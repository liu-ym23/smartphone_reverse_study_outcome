package com.android.server.adb;

import android.R;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.debug.AdbNotifications;
import android.debug.PairDevice;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.net.Uri;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.InputConstants;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.SystemService;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AtomicFile;
import android.util.Base64;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.util.dump.DumpUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.FgThread;
import com.android.server.autofill.HintsHelper;
import com.android.server.usage.UnixCalendar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AdbDebuggingManager {
    private static final String ADBD_SOCKET = "adbd";
    private static final long ADBD_STATE_CHANGE_TIMEOUT = 0;
    private static final String ADB_DIRECTORY = "misc/adb";
    private static final String ADB_KEYS_FILE = "adb_keys";
    private static final String ADB_TEMP_KEYS_FILE = "adb_temp_keys.xml";
    private static final int BUFFER_SIZE = 65536;
    private static final String MAINTENACE_ID = "persist.sys.maintid";
    private static final int PAIRING_CODE_LENGTH = 6;
    private static final Ticker SYSTEM_TICKER = null;
    private static final String TAG = null;
    private static final String WIFI_PERSISTENT_GUID = "persist.adb.wifi.guid";
    private AdbConnectionInfo mAdbConnectionInfo;
    private boolean mAdbUsbEnabled;
    private boolean mAdbWifiEnabled;
    private final String mConfirmComponent;
    private final Map<String, Integer> mConnectedKeys;
    private AdbConnectionPortPoller mConnectionPortPoller;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private String mFingerprints;
    final AdbDebuggingHandler mHandler;
    private PairingThread mPairingThread;
    private final File mTempKeysFile;
    private AdbDebuggingThread mThread;
    private final Ticker mTicker;
    private final File mUserKeyFile;
    private final Set<String> mWifiConnectedKeys;

    private static class AdbConnectionInfo {
        private String mBssid;
        private int mPort;
        private String mSsid;

        AdbConnectionInfo() {
            this.mBssid = "";
            this.mSsid = "";
            this.mPort = -1;
        }

        AdbConnectionInfo(String bssid, String ssid) {
            this.mBssid = bssid;
            this.mSsid = ssid;
        }

        AdbConnectionInfo(AdbConnectionInfo other) {
            this.mBssid = other.mBssid;
            this.mSsid = other.mSsid;
            this.mPort = other.mPort;
        }

        public String getBSSID() {
            return this.mBssid;
        }

        public String getSSID() {
            return this.mSsid;
        }

        public int getPort() {
            return this.mPort;
        }

        public void setPort(int port) {
            this.mPort = port;
        }

        public void clear() {
            this.mBssid = "";
            this.mSsid = "";
            this.mPort = -1;
        }
    }

    private class AdbConnectionPortPoller extends Thread {
        private final String mAdbPortProp;
        private AtomicBoolean mCanceled;
        private final int mDurationSecs;
        final /* synthetic */ AdbDebuggingManager this$0;

        /* synthetic */ AdbConnectionPortPoller(AdbDebuggingManager r1, AdbDebuggingManagerIA r2) {
            this(r1);
        }

        private AdbConnectionPortPoller(AdbDebuggingManager r2) {
            this.this$0 = r2;
            this.mAdbPortProp = "service.adb.tls.port";
            this.mDurationSecs = 10;
            this.mCanceled = new AtomicBoolean(false);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Starting adb port property poller");
            int i = 0;
        L4:
            if (i >= 10) goto L17;
            if (this.mCanceled.get() == true) goto L7;
            int port = SystemProperties.getInt("service.adb.tls.port", Integer.MAX_VALUE);
            if (port == (-1)) goto L15;
            if (port <= 0) goto L14;
            if (port <= 65535) goto L15;
        L14:
            SystemClock.sleep(1000);
            i = i + 1;
        L15:
            onPortReceived(port);
            return;
        L7:
            return;
        L17:
            Slog.w(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Failed to receive adb connection port");
            onPortReceived(-1);
        }

        private void onPortReceived(int port) {
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Received tls port=" + port);
            AdbDebuggingHandler r0 = this.this$0.mHandler;
            if (port <= 0) goto L5;
            int r1 = 24;
        L6:
            Message msg = r0.obtainMessage(r1);
            msg.obj = Integer.valueOf(port);
            this.this$0.mHandler.sendMessage(msg);
            return;
        L5:
            r1 = 25;
            goto L6
        }

        public void cancelAndWait() {
            this.mCanceled.set(true);
            if (isAlive() == false) goto L10;
            join();     // Catch: InterruptedException -> L6
            return;
        L7:
            return;
        }
    }

    class AdbDebuggingHandler extends Handler {
        private static final String ADB_NOTIFICATION_CHANNEL_ID_TV = "usbdevicemanager.adb.tv";
        static final int MESSAGE_ADB_ALLOW = 3;
        static final int MESSAGE_ADB_CLEAR = 6;
        static final int MESSAGE_ADB_CONFIRM = 5;
        static final int MESSAGE_ADB_CONNECTED_KEY = 10;
        static final int MESSAGE_ADB_DENY = 4;
        static final int MESSAGE_ADB_DISABLED = 2;
        static final int MESSAGE_ADB_DISCONNECT = 7;
        static final int MESSAGE_ADB_ENABLED = 1;
        static final int MESSAGE_ADB_PERSIST_KEYSTORE = 8;
        static final int MESSAGE_ADB_UPDATE_KEYSTORE = 9;
        private static final int MESSAGE_KEY_FILES_UPDATED = 28;
        static final int MSG_ADBDWIFI_DISABLE = 12;
        static final int MSG_ADBDWIFI_ENABLE = 11;
        static final int MSG_ADBD_SOCKET_CONNECTED = 26;
        static final int MSG_ADBD_SOCKET_DISCONNECTED = 27;
        static final int MSG_ADBWIFI_ALLOW = 18;
        static final int MSG_ADBWIFI_DENY = 19;
        static final String MSG_DISCONNECT_DEVICE = "DD";
        static final int MSG_PAIRING_CANCEL = 14;
        static final int MSG_PAIR_PAIRING_CODE = 15;
        static final int MSG_PAIR_QR_CODE = 16;
        static final int MSG_REQ_UNPAIR = 17;
        static final int MSG_RESPONSE_PAIRING_PORT = 21;
        static final int MSG_RESPONSE_PAIRING_RESULT = 20;
        static final int MSG_SERVER_CONNECTED = 24;
        static final int MSG_SERVER_DISCONNECTED = 25;
        static final int MSG_WIFI_DEVICE_CONNECTED = 22;
        static final int MSG_WIFI_DEVICE_DISCONNECTED = 23;
        static final long UPDATE_KEYSTORE_JOB_INTERVAL = 86400000;
        static final long UPDATE_KEYSTORE_MIN_JOB_INTERVAL = 60000;
        private int mAdbEnabledRefCount;
        AdbKeyStore mAdbKeyStore;
        private boolean mAdbNotificationShown;
        private ContentObserver mAuthTimeObserver;
        private final BroadcastReceiver mBroadcastReceiver;
        private NotificationManager mNotificationManager;
        final /* synthetic */ AdbDebuggingManager this$0;

        private boolean isTv() {
            return AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0).getPackageManager().hasSystemFeature("android.software.leanback");
        }

        private void setupNotifications() {
            if (this.mNotificationManager == null) goto L5;
            return;
        L5:
            this.mNotificationManager = (NotificationManager) AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0).getSystemService("notification");
            if (this.mNotificationManager != null) goto L10;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Unable to setup notifications for wireless debugging");
            return;
        L10:
            if (isTv() == false) goto L13;
            this.mNotificationManager.createNotificationChannel(new NotificationChannel(ADB_NOTIFICATION_CHANNEL_ID_TV, AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0).getString(R.string.aerr_process), 4));
            return;
        }

        AdbDebuggingHandler(AdbDebuggingManager this$0, Looper looper, AdbDebuggingThread thread) {
            this.this$0 = this$0;
            super(looper);
            this.mBroadcastReceiver = new AnonymousClass1(this);
            this.mAdbEnabledRefCount = 0;
            this.mAuthTimeObserver = new AnonymousClass2(this, this);
            AdbDebuggingManager.m965$$Nest$fputmThread(this$0, thread);
        }

        void initKeyStore() {
            if (this.mAdbKeyStore != null) goto L6;
            this.mAdbKeyStore = new AdbKeyStore(this.this$0);
            return;
        }

        public void showAdbConnectedNotification(boolean show) {
            if (show != this.mAdbNotificationShown) goto L5;
            return;
        L5:
            setupNotifications();
            if (this.mAdbNotificationShown == true) goto L8;
            Notification notification = AdbNotifications.createNotification(AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0), (byte) 1);
            this.mAdbNotificationShown = true;
            this.mNotificationManager.notifyAsUser(null, 62, notification, UserHandle.ALL);
            return;
        L8:
            this.mAdbNotificationShown = false;
            this.mNotificationManager.cancelAsUser(null, 62, UserHandle.ALL);
        }

        private void startAdbDebuggingThread() {
            this.mAdbEnabledRefCount++;
            Slog.i(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "startAdbDebuggingThread ref=" + this.mAdbEnabledRefCount);
            if (this.mAdbEnabledRefCount <= 1) goto L5;
            return;
        L5:
            registerForAuthTimeChanges();
            AdbDebuggingManager.m965$$Nest$fputmThread(this.this$0, new AdbDebuggingThread());
            AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0).setHandler(this.this$0.mHandler);
            AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0).start();
            this.mAdbKeyStore.updateKeyStore();
            scheduleJobToUpdateAdbKeyStore();
        }

        private void stopAdbDebuggingThread() {
            this.mAdbEnabledRefCount--;
            Slog.i(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "stopAdbDebuggingThread ref=" + this.mAdbEnabledRefCount);
            if (this.mAdbEnabledRefCount <= 0) goto L6;
            return;
        L6:
            if (AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0) == null) goto L9;
            AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0).stopListening();
            AdbDebuggingManager.m965$$Nest$fputmThread(this.this$0, null);
        L9:
            if (AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).isEmpty() == true) goto L15;
            Iterator r0 = AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).entrySet().iterator();
        L12:
            if (r0.hasNext() == false) goto L14;
            Map.Entry<String, Integer> entry = (Map.Entry) r0.next();
            this.mAdbKeyStore.setLastConnectionTime(entry.getKey(), AdbDebuggingManager.m957$$Nest$fgetmTicker(this.this$0).currentTimeMillis());
            goto L12
        L14:
            AdbDebuggingManager.m967$$Nest$msendPersistKeyStoreMessage(this.this$0);
            AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).clear();
            AdbDebuggingManager.m959$$Nest$fgetmWifiConnectedKeys(this.this$0).clear();
        L15:
            scheduleJobToUpdateAdbKeyStore();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            initKeyStore();
            AdbDebuggingManagerIA r2 = null;
            boolean alwaysAllow = false;
            switch(msg.what) {
                case 1: goto L162;
                case 2: goto L158;
                case 3: goto L142;
                case 4: goto L140;
                case 5: goto L133;
                case 6: goto L125;
                case 7: goto L112;
                case 8: goto L110;
                case 9: goto L100;
                case 10: goto L88;
                case 11: goto L79;
                case 12: goto L75;
                case 13: goto L220;
                case 14: goto L67;
                case 15: goto L65;
                case 16: goto L64;
                case 17: goto L54;
                case 18: goto L41;
                case 19: goto L39;
                case 20: goto L38;
                case 21: goto L37;
                case 22: goto L35;
                case 23: goto L30;
                case 24: goto L21;
                case 25: goto L16;
                case 26: goto L12;
                case 27: goto L6;
                case 28: goto L5;
                default: goto L220;
            };
        L5:
            this.mAdbKeyStore.reloadKeyMap();
            return;
        L6:
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "adbd socket disconnected");
            if (AdbDebuggingManager.m950$$Nest$fgetmConnectionPortPoller(this.this$0) == null) goto L10;
            AdbDebuggingManager.m950$$Nest$fgetmConnectionPortPoller(this.this$0).cancelAndWait();
            AdbDebuggingManager.m962$$Nest$fputmConnectionPortPoller(this.this$0, null);
        L10:
            if (AdbDebuggingManager.m948$$Nest$fgetmAdbWifiEnabled(this.this$0) == false) goto L174;
            onAdbdWifiServerDisconnected(-1);
            return;
        L174:
            return;
        L12:
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "adbd socket connected");
            if (AdbDebuggingManager.m948$$Nest$fgetmAdbWifiEnabled(this.this$0) == false) goto L176;
            AdbDebuggingManager.m962$$Nest$fputmConnectionPortPoller(this.this$0, new AdbConnectionPortPoller(this.this$0, r2));
            AdbDebuggingManager.m950$$Nest$fgetmConnectionPortPoller(this.this$0).start();
            return;
        L176:
            return;
        L21:
            int port = ((Integer) msg.obj).intValue();
            onAdbdWifiServerConnected(port);
            AdbConnectionInfo r1 = AdbDebuggingManager.m946$$Nest$fgetmAdbConnectionInfo(this.this$0);
            monitor-enter(r1);
            AdbDebuggingManager.m946$$Nest$fgetmAdbConnectionInfo(this.this$0).setPort(port);     // Catch: Throwable -> L26
            monitor-exit(r1);     // Catch: Throwable -> L26
            Settings.Global.putInt(AdbDebuggingManager.m951$$Nest$fgetmContentResolver(this.this$0), "adb_wifi_enabled", 1);
            return;
        L26:
            th = move-exception;
            throw th;
        L37:
            sendPairingPortToUI(((Integer) msg.obj).intValue());
            return;
        L38:
            onPairingResult(((Bundle) msg.obj).getString("publicKey"));
            sendPairedDevicesToUI(this.mAdbKeyStore.getPairedDevices());
            return;
        L39:
            Settings.Global.putInt(AdbDebuggingManager.m951$$Nest$fgetmContentResolver(this.this$0), "adb_wifi_enabled", 0);
            sendServerConnectionState(false, -1);
            return;
        L54:
            String fingerprint = (String) msg.obj;
            String publicKey = this.mAdbKeyStore.findKeyFromFingerprint(fingerprint);
            if (publicKey != null) goto L57;
        L63:
            String cmdStr = AdbDebuggingManager.m973$$Nest$sfgetTAG();
            Slog.e(cmdStr, "Not a known fingerprint [" + fingerprint + "]");
            return;
        L57:
            if (publicKey.isEmpty() == true) goto L63;
            String cmdStr2 = MSG_DISCONNECT_DEVICE + publicKey;
            if (AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0) == null) goto L62;
            AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0).sendResponse(cmdStr2);
        L62:
            this.mAdbKeyStore.removeKey(publicKey);
            sendPairedDevicesToUI(this.mAdbKeyStore.getPairedDevices());
            return;
        L64:
            Bundle bundle = (Bundle) msg.obj;
            String serviceName = bundle.getString("serviceName");
            String password = bundle.getString(HintsHelper.AUTOFILL_HINT_PASSWORD);
            AdbDebuggingManager.m964$$Nest$fputmPairingThread(this.this$0, new PairingThread(this.this$0, password, serviceName));
            AdbDebuggingManager.m954$$Nest$fgetmPairingThread(this.this$0).start();
            return;
        L65:
            String pairingCode = createPairingCode(6);
            updateUIPairCode(pairingCode);
            AdbDebuggingManager.m964$$Nest$fputmPairingThread(this.this$0, new PairingThread(this.this$0, pairingCode, null));
            AdbDebuggingManager.m954$$Nest$fgetmPairingThread(this.this$0).start();
            return;
        L88:
            String key = (String) msg.obj;
            if (key != null) goto L91;
        L98:
            Slog.w(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Received a connected key message with an empty key");
            return;
        L91:
            if (key.length() == 0) goto L98;
            if (AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).containsKey(key) == true) goto L96;
            AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).put(key, 1);
        L97:
            this.mAdbKeyStore.setLastConnectionTime(key, AdbDebuggingManager.m957$$Nest$fgetmTicker(this.this$0).currentTimeMillis());
            AdbDebuggingManager.m967$$Nest$msendPersistKeyStoreMessage(this.this$0);
            scheduleJobToUpdateAdbKeyStore();
            logAdbConnectionChanged(key, 4, true);
            return;
        L96:
            AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).put(key, Integer.valueOf(((Integer) AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).get(key)).intValue() + 1));
            goto L97
        L112:
            String key2 = (String) msg.obj;
            boolean alwaysAllow2 = false;
            if (key2 != null) goto L115;
        L123:
            Slog.w(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Received a disconnected key message with an empty key");
        L124:
            logAdbConnectionChanged(key2, 7, alwaysAllow2);
            return;
        L115:
            if (key2.length() <= 0) goto L123;
            if (AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).containsKey(key2) == false) goto L124;
            alwaysAllow2 = true;
            int refcount = ((Integer) AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).get(key2)).intValue() - 1;
            if (refcount != 0) goto L121;
            this.mAdbKeyStore.setLastConnectionTime(key2, AdbDebuggingManager.m957$$Nest$fgetmTicker(this.this$0).currentTimeMillis());
            AdbDebuggingManager.m967$$Nest$msendPersistKeyStoreMessage(this.this$0);
            scheduleJobToUpdateAdbKeyStore();
            AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).remove(key2);
            goto L124
        L121:
            AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).put(key2, Integer.valueOf(refcount));
            goto L124
        L125:
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Received a request to clear the adb authorizations");
            AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).clear();
            initKeyStore();
            AdbDebuggingManager.m959$$Nest$fgetmWifiConnectedKeys(this.this$0).clear();
            this.mAdbKeyStore.deleteKeyStore();
            cancelJobToUpdateAdbKeyStore();
            if (Settings.Global.getInt(AdbDebuggingManager.m951$$Nest$fgetmContentResolver(this.this$0), "adb_disconnect_sessions_on_revoke", 1) == 1) goto L128;
            return;
        L128:
            if (AdbDebuggingManager.m947$$Nest$fgetmAdbUsbEnabled(this.this$0) == false) goto L210;
            SystemService.stop(AdbDebuggingManager.ADBD_SOCKET);     // Catch: TimeoutException -> L131
            SystemService.waitForState(AdbDebuggingManager.ADBD_SOCKET, SystemService.State.STOPPED, AdbDebuggingManager.m972$$Nest$sfgetADBD_STATE_CHANGE_TIMEOUT());     // Catch: TimeoutException -> L131
            SystemService.start(AdbDebuggingManager.ADBD_SOCKET);     // Catch: TimeoutException -> L131
            SystemService.waitForState(AdbDebuggingManager.ADBD_SOCKET, SystemService.State.RUNNING, AdbDebuggingManager.m972$$Nest$sfgetADBD_STATE_CHANGE_TIMEOUT());     // Catch: TimeoutException -> L131
            return;
        L131:
            e = move-exception;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Timeout occurred waiting for adbd to cycle: ", e);
            Settings.Global.putInt(AdbDebuggingManager.m951$$Nest$fgetmContentResolver(this.this$0), "adb_enabled", 0);
            return;
        L210:
            return;
        L133:
            String key3 = (String) msg.obj;
            String fingerprints = AdbDebuggingManager.m966$$Nest$mgetFingerprints(this.this$0, key3);
            if ("".equals(fingerprints) == true) goto L136;
            logAdbConnectionChanged(key3, 1, false);
            AdbDebuggingManager.m963$$Nest$fputmFingerprints(this.this$0, fingerprints);
            AdbDebuggingManager.m969$$Nest$mstartConfirmationForKey(this.this$0, key3, AdbDebuggingManager.m953$$Nest$fgetmFingerprints(this.this$0));
            return;
        L136:
            if (AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0) == null) goto L211;
            AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0).sendResponse("NO");
            logAdbConnectionChanged(key3, 5, false);
            return;
        L211:
            return;
        L142:
            String key4 = (String) msg.obj;
            String fingerprints2 = AdbDebuggingManager.m966$$Nest$mgetFingerprints(this.this$0, key4);
            if (fingerprints2.equals(AdbDebuggingManager.m953$$Nest$fgetmFingerprints(this.this$0)) == true) goto L146;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Fingerprints do not match. Got " + fingerprints2 + ", expected " + AdbDebuggingManager.m953$$Nest$fgetmFingerprints(this.this$0));
            return;
        L146:
            if (msg.arg1 != 1) goto L149;
            alwaysAllow = true;
        L149:
            if (AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0) == null) goto L217;
            AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0).sendResponse("OK");
            if (alwaysAllow == true) goto L153;
        L156:
            logAdbConnectionChanged(key4, 2, alwaysAllow);
            return;
        L153:
            if (AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).containsKey(key4) == true) goto L155;
            AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).put(key4, 1);
        L155:
            this.mAdbKeyStore.setLastConnectionTime(key4, AdbDebuggingManager.m957$$Nest$fgetmTicker(this.this$0).currentTimeMillis());
            AdbDebuggingManager.m967$$Nest$msendPersistKeyStoreMessage(this.this$0);
            scheduleJobToUpdateAdbKeyStore();
            goto L156
        L217:
            return;
        L220:
            return;
        L16:
            if (AdbDebuggingManager.m948$$Nest$fgetmAdbWifiEnabled(this.this$0) == false) goto L221;
            onAdbdWifiServerDisconnected(((Integer) msg.obj).intValue());
            Settings.Global.putInt(AdbDebuggingManager.m951$$Nest$fgetmContentResolver(this.this$0), "adb_wifi_enabled", 0);
            stopAdbDebuggingThread();
            if (AdbDebuggingManager.m950$$Nest$fgetmConnectionPortPoller(this.this$0) == null) goto L178;
            AdbDebuggingManager.m950$$Nest$fgetmConnectionPortPoller(this.this$0).cancelAndWait();
            AdbDebuggingManager.m962$$Nest$fputmConnectionPortPoller(this.this$0, null);
            return;
        L178:
            return;
        L221:
            return;
        L30:
            if (AdbDebuggingManager.m959$$Nest$fgetmWifiConnectedKeys(this.this$0).remove((String) msg.obj) == false) goto L181;
            sendPairedDevicesToUI(this.mAdbKeyStore.getPairedDevices());
            if (AdbDebuggingManager.m959$$Nest$fgetmWifiConnectedKeys(this.this$0).isEmpty() == false) goto L182;
            showAdbConnectedNotification(false);
            return;
        L182:
            return;
        L181:
            return;
        L35:
            if (AdbDebuggingManager.m959$$Nest$fgetmWifiConnectedKeys(this.this$0).add((String) msg.obj) == false) goto L184;
            sendPairedDevicesToUI(this.mAdbKeyStore.getPairedDevices());
            showAdbConnectedNotification(true);
            return;
        L184:
            return;
        L41:
            if (AdbDebuggingManager.m948$$Nest$fgetmAdbWifiEnabled(this.this$0) == true) goto L222;
            String bssid = (String) msg.obj;
            if (msg.arg1 != 1) goto L46;
            alwaysAllow = true;
        L46:
            if (alwaysAllow == false) goto L48;
            this.mAdbKeyStore.addTrustedNetwork(bssid);
        L48:
            AdbConnectionInfo newInfo = getCurrentWifiApInfo();
            if (newInfo != null) goto L51;
            return;
        L51:
            if (bssid.equals(newInfo.getBSSID()) == false) goto L223;
            AdbDebuggingManager.m968$$Nest$msetAdbConnectionInfo(this.this$0, newInfo);
            Settings.Global.putInt(AdbDebuggingManager.m951$$Nest$fgetmContentResolver(this.this$0), "adb_wifi_enabled", 1);
            IntentFilter intentFilter = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0).registerReceiver(this.mBroadcastReceiver, intentFilter);
            SystemProperties.set("persist.adb.tls_server.enable", "1");
            AdbDebuggingManager.m962$$Nest$fputmConnectionPortPoller(this.this$0, new AdbConnectionPortPoller(this.this$0, r2));
            AdbDebuggingManager.m950$$Nest$fgetmConnectionPortPoller(this.this$0).start();
            startAdbDebuggingThread();
            AdbDebuggingManager.m961$$Nest$fputmAdbWifiEnabled(this.this$0, true);
            Slog.i(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "adb start wireless adb");
            return;
        L223:
            return;
        L222:
            return;
        L67:
            if (AdbDebuggingManager.m954$$Nest$fgetmPairingThread(this.this$0) == null) goto L195;
            AdbDebuggingManager.m954$$Nest$fgetmPairingThread(this.this$0).cancelPairing();
            AdbDebuggingManager.m954$$Nest$fgetmPairingThread(this.this$0).join();     // Catch: InterruptedException -> L71
        L73:
            AdbDebuggingManager.m964$$Nest$fputmPairingThread(this.this$0, null);
            return;
        L71:
            e = move-exception;
            Slog.w(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Error while waiting for pairing thread to quit.");
            e.printStackTrace();
            goto L73
        L195:
            return;
        L75:
            if (AdbDebuggingManager.m948$$Nest$fgetmAdbWifiEnabled(this.this$0) == false) goto L224;
            AdbDebuggingManager.m961$$Nest$fputmAdbWifiEnabled(this.this$0, false);
            AdbDebuggingManager.m968$$Nest$msetAdbConnectionInfo(this.this$0, null);
            AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0).unregisterReceiver(this.mBroadcastReceiver);
            onAdbdWifiServerDisconnected(-1);
            stopAdbDebuggingThread();
            return;
        L224:
            return;
        L79:
            if (AdbDebuggingManager.m948$$Nest$fgetmAdbWifiEnabled(this.this$0) == true) goto L225;
            AdbConnectionInfo currentInfo = getCurrentWifiApInfo();
            if (currentInfo != null) goto L85;
            Settings.Global.putInt(AdbDebuggingManager.m951$$Nest$fgetmContentResolver(this.this$0), "adb_wifi_enabled", 0);
            return;
        L85:
            if (verifyWifiNetwork(currentInfo.getBSSID(), currentInfo.getSSID()) == true) goto L87;
            Settings.Global.putInt(AdbDebuggingManager.m951$$Nest$fgetmContentResolver(this.this$0), "adb_wifi_enabled", 0);
            return;
        L87:
            AdbDebuggingManager.m968$$Nest$msetAdbConnectionInfo(this.this$0, currentInfo);
            IntentFilter intentFilter2 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter2.addAction("android.net.wifi.STATE_CHANGE");
            AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0).registerReceiver(this.mBroadcastReceiver, intentFilter2);
            SystemProperties.set("persist.adb.tls_server.enable", "1");
            AdbDebuggingManager.m962$$Nest$fputmConnectionPortPoller(this.this$0, new AdbConnectionPortPoller(this.this$0, r2));
            AdbDebuggingManager.m950$$Nest$fgetmConnectionPortPoller(this.this$0).start();
            startAdbDebuggingThread();
            AdbDebuggingManager.m961$$Nest$fputmAdbWifiEnabled(this.this$0, true);
            Slog.i(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "adb start wireless adb");
            return;
        L225:
            return;
        L100:
            if (AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).isEmpty() == true) goto L107;
            Iterator r0 = AdbDebuggingManager.m949$$Nest$fgetmConnectedKeys(this.this$0).entrySet().iterator();
        L103:
            if (r0.hasNext() == false) goto L105;
            Map.Entry<String, Integer> entry = (Map.Entry) r0.next();
            this.mAdbKeyStore.setLastConnectionTime(entry.getKey(), AdbDebuggingManager.m957$$Nest$fgetmTicker(this.this$0).currentTimeMillis());
            goto L103
        L105:
            AdbDebuggingManager.m967$$Nest$msendPersistKeyStoreMessage(this.this$0);
            scheduleJobToUpdateAdbKeyStore();
            return;
        L107:
            if (this.mAdbKeyStore.isEmpty() == true) goto L204;
            this.mAdbKeyStore.updateKeyStore();
            scheduleJobToUpdateAdbKeyStore();
            return;
        L204:
            return;
        L110:
            if (this.mAdbKeyStore == null) goto L206;
            this.mAdbKeyStore.persistKeyStore();
            return;
        L206:
            return;
        L140:
            if (AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0) == null) goto L214;
            Slog.w(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Denying adb confirmation");
            AdbDebuggingManager.m956$$Nest$fgetmThread(this.this$0).sendResponse("NO");
            logAdbConnectionChanged(null, 3, false);
            return;
        L214:
            return;
        L158:
            if (AdbDebuggingManager.m947$$Nest$fgetmAdbUsbEnabled(this.this$0) == false) goto L228;
            stopAdbDebuggingThread();
            AdbDebuggingManager.m960$$Nest$fputmAdbUsbEnabled(this.this$0, false);
            return;
        L228:
            return;
        L162:
            if (AdbDebuggingManager.m947$$Nest$fgetmAdbUsbEnabled(this.this$0) == true) goto L229;
            startAdbDebuggingThread();
            AdbDebuggingManager.m960$$Nest$fputmAdbUsbEnabled(this.this$0, true);
            return;
        }

        void registerForAuthTimeChanges() {
            Uri uri = Settings.Global.getUriFor("adb_allowed_connection_time");
            AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0).getContentResolver().registerContentObserver(uri, false, this.mAuthTimeObserver);
        }

        private void logAdbConnectionChanged(String key, int state, boolean alwaysAllow) {
            long lastConnectionTime = this.mAdbKeyStore.getLastConnectionTime(key);
            long authWindow = this.mAdbKeyStore.getAllowedConnectionTime();
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Logging key " + key + ", state = " + state + ", alwaysAllow = " + alwaysAllow + ", lastConnectionTime = " + lastConnectionTime + ", authWindow = " + authWindow);
            FrameworkStatsLog.write(144, lastConnectionTime, authWindow, state, alwaysAllow);
        }

        long scheduleJobToUpdateAdbKeyStore() {
            cancelJobToUpdateAdbKeyStore();
            long keyExpiration = this.mAdbKeyStore.getNextExpirationTime();
            if (keyExpiration != (-1)) goto L6;
            return -1;
        L6:
            if (keyExpiration != 0) goto L8;
            long delay = 0;
        L9:
            Message message = obtainMessage(9);
            sendMessageDelayed(message, delay);
            return delay;
        L8:
            delay = Math.max(Math.min(86400000, keyExpiration), 60000);
            goto L9
        }

        private void cancelJobToUpdateAdbKeyStore() {
            removeMessages(9);
        }

        private String createPairingCode(int size) {
            String res = "";
            SecureRandom rand = new SecureRandom();
            int i = 0;
        L3:
            if (i >= size) goto L6;
            res = res + rand.nextInt(10);
            i = i + 1;
            goto L3
        L6:
            return res;
        }

        private void sendServerConnectionState(boolean connected, int port) {
            Intent intent = new Intent("com.android.server.adb.WIRELESS_DEBUG_STATUS");
            if (connected == false) goto L5;
            int r1 = 4;
        L6:
            intent.putExtra("status", r1);
            intent.putExtra("adb_port", port);
            AdbDebuggingManager.sendBroadcastWithDebugPermission(AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0), intent, UserHandle.ALL);
            return;
        L5:
            r1 = 5;
            goto L6
        }

        private void onAdbdWifiServerConnected(int port) {
            sendPairedDevicesToUI(this.mAdbKeyStore.getPairedDevices());
            sendServerConnectionState(true, port);
        }

        private void onAdbdWifiServerDisconnected(int port) {
            AdbDebuggingManager.m959$$Nest$fgetmWifiConnectedKeys(this.this$0).clear();
            showAdbConnectedNotification(false);
            sendServerConnectionState(false, port);
        }

        private AdbConnectionInfo getCurrentWifiApInfo() {
            WifiManager wifiManager = (WifiManager) AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0).getSystemService("wifi");
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            if (wifiInfo != null) goto L5;
        L33:
            String ssid = AdbDebuggingManager.m973$$Nest$sfgetTAG();
            Slog.i(ssid, "Not connected to any wireless network. Not enabling adbwifi.");
            return null;
        L5:
            if (wifiInfo.getNetworkId() == (-1)) goto L33;
            if (wifiInfo.isPasspointAp() == false) goto L10;
        L26:
            String ssid2 = wifiInfo.getPasspointProviderFriendlyName();
        L27:
            String bssid = wifiInfo.getBSSID();
            if (TextUtils.isEmpty(bssid) == false) goto L32;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Unable to get the wifi ap's BSSID.");
            return null;
        L32:
            return new AdbConnectionInfo(bssid, ssid2);
        L10:
            if (wifiInfo.isOsuAp() == true) goto L26;
            ssid2 = wifiInfo.getSSID();
            if (ssid2 != null) goto L15;
        L16:
            List<WifiConfiguration> networks = wifiManager.getConfiguredNetworks();
            int length = networks.size();
            int i = 0;
        L17:
            if (i >= length) goto L23;
            if (networks.get(i).networkId != wifiInfo.getNetworkId()) goto L21;
            ssid2 = networks.get(i).SSID;
        L21:
            i = i + 1;
            goto L17
        L23:
            if (ssid2 != null) goto L27;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Unable to get ssid of the wifi AP.");
            return null;
        L15:
            if ("<unknown ssid>".equals(ssid2) == false) goto L27;
            goto L16
        }

        private boolean verifyWifiNetwork(String bssid, String ssid) {
            if (this.mAdbKeyStore.isTrustedNetwork(bssid) == false) goto L6;
            return true;
        L6:
            AdbDebuggingManager.m970$$Nest$mstartConfirmationForNetwork(this.this$0, ssid, bssid);
            return false;
        }

        private void onPairingResult(String publicKey) {
            if (publicKey != null) goto L5;
            Intent intent = new Intent("com.android.server.adb.WIRELESS_DEBUG_PAIRING_RESULT");
            intent.putExtra("status", 0);
            AdbDebuggingManager.sendBroadcastWithDebugPermission(AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0), intent, UserHandle.ALL);
            return;
        L5:
            Intent intent2 = new Intent("com.android.server.adb.WIRELESS_DEBUG_PAIRING_RESULT");
            intent2.putExtra("status", 1);
            String fingerprints = AdbDebuggingManager.m966$$Nest$mgetFingerprints(this.this$0, publicKey);
            String hostname = "nouser@nohostname";
            String[] args = publicKey.split("\\s+");
            if (args.length <= 1) goto L8;
            hostname = args[1];
        L8:
            PairDevice device = new PairDevice();
            device.name = fingerprints;
            device.guid = hostname;
            device.connected = false;
            intent2.putExtra("pair_device", device);
            AdbDebuggingManager.sendBroadcastWithDebugPermission(AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0), intent2, UserHandle.ALL);
            this.mAdbKeyStore.setLastConnectionTime(publicKey, AdbDebuggingManager.m957$$Nest$fgetmTicker(this.this$0).currentTimeMillis());
            AdbDebuggingManager.m967$$Nest$msendPersistKeyStoreMessage(this.this$0);
            scheduleJobToUpdateAdbKeyStore();
        }

        private void sendPairingPortToUI(int port) {
            Intent intent = new Intent("com.android.server.adb.WIRELESS_DEBUG_PAIRING_RESULT");
            intent.putExtra("status", 4);
            intent.putExtra("adb_port", port);
            AdbDebuggingManager.sendBroadcastWithDebugPermission(AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0), intent, UserHandle.ALL);
        }

        private void sendPairedDevicesToUI(Map<String, PairDevice> devices) {
            Intent intent = new Intent("com.android.server.adb.WIRELESS_DEBUG_PAIRED_DEVICES");
            intent.putExtra("devices_map", (HashMap) devices);
            AdbDebuggingManager.sendBroadcastWithDebugPermission(AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0), intent, UserHandle.ALL);
        }

        private void updateUIPairCode(String code) {
            Slog.i(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "updateUIPairCode: " + code);
            Intent intent = new Intent("com.android.server.adb.WIRELESS_DEBUG_PAIRING_RESULT");
            intent.putExtra("pairing_code", code);
            intent.putExtra("status", 3);
            AdbDebuggingManager.sendBroadcastWithDebugPermission(AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0), intent, UserHandle.ALL);
        }
    }

    static class AdbDebuggingThread extends Thread {
        private Handler mHandler;
        private InputStream mInputStream;
        private OutputStream mOutputStream;
        private LocalSocket mSocket;
        private boolean mStopped;

        AdbDebuggingThread() {
            super(AdbDebuggingManager.m973$$Nest$sfgetTAG());
        }

        void setHandler(Handler handler) {
            this.mHandler = handler;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Entering thread");
        L3:
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mStopped == true) goto L6;
            openSocketLocked();     // Catch: Throwable -> L9 Exception -> L14
        L16:
            monitor-exit(this);     // Catch: Throwable -> L9
            listenToSocket();     // Catch: Exception -> L19
        L20:
            SystemClock.sleep(1000);
            goto L3
        L15:
            SystemClock.sleep(1000);     // Catch: Throwable -> L9
            goto L16
        L6:
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Exiting thread");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
        }

        private void openSocketLocked() throws IOException {
            LocalSocketAddress address = new LocalSocketAddress(AdbDebuggingManager.ADBD_SOCKET, LocalSocketAddress.Namespace.RESERVED);     // Catch: IOException -> L4
            this.mInputStream = null;     // Catch: IOException -> L4
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Creating socket");     // Catch: IOException -> L4
            this.mSocket = new LocalSocket(3);     // Catch: IOException -> L4
            this.mSocket.connect(address);     // Catch: IOException -> L4
            this.mOutputStream = this.mSocket.getOutputStream();     // Catch: IOException -> L4
            this.mInputStream = this.mSocket.getInputStream();     // Catch: IOException -> L4
            this.mHandler.sendEmptyMessage(26);     // Catch: IOException -> L4
            return;
        L4:
            ioe = move-exception;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Caught an exception opening the socket: " + ioe);
            closeSocketLocked();
            throw ioe;
        }

        private void listenToSocket() throws IOException {
            byte[] buffer = new byte[65536];     // Catch: Throwable -> L7
        L4:
            int count = this.mInputStream.read(buffer);     // Catch: Throwable -> L7
            if (count < 2) goto L6;
            if (buffer[0] != 80) goto L15;
            if (buffer[1] != 75) goto L15;
            String key = new String(Arrays.copyOfRange(buffer, 2, count));     // Catch: Throwable -> L7
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Received public key: " + key);     // Catch: Throwable -> L7
            Message msg = this.mHandler.obtainMessage(5);     // Catch: Throwable -> L7
            msg.obj = key;     // Catch: Throwable -> L7
            this.mHandler.sendMessage(msg);     // Catch: Throwable -> L7
        L15:
            if (buffer[0] != 68) goto L20;
            if (buffer[1] != 67) goto L20;
            String key2 = new String(Arrays.copyOfRange(buffer, 2, count));     // Catch: Throwable -> L7
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Received disconnected message: " + key2);     // Catch: Throwable -> L7
            Message msg2 = this.mHandler.obtainMessage(7);     // Catch: Throwable -> L7
            msg2.obj = key2;     // Catch: Throwable -> L7
            this.mHandler.sendMessage(msg2);     // Catch: Throwable -> L7
        L20:
            if (buffer[0] != 67) goto L25;
            if (buffer[1] != 75) goto L25;
            String key3 = new String(Arrays.copyOfRange(buffer, 2, count));     // Catch: Throwable -> L7
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Received connected key message: " + key3);     // Catch: Throwable -> L7
            Message msg3 = this.mHandler.obtainMessage(10);     // Catch: Throwable -> L7
            msg3.obj = key3;     // Catch: Throwable -> L7
            this.mHandler.sendMessage(msg3);     // Catch: Throwable -> L7
        L25:
            if (buffer[0] != 87) goto L36;
            if (buffer[1] != 69) goto L36;
            byte transportType = buffer[2];     // Catch: Throwable -> L7
            String key4 = new String(Arrays.copyOfRange(buffer, 3, count));     // Catch: Throwable -> L7
            if (transportType != 0) goto L31;
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Received USB TLS connected key message: " + key4);     // Catch: Throwable -> L7
            Message msg4 = this.mHandler.obtainMessage(10);     // Catch: Throwable -> L7
            msg4.obj = key4;     // Catch: Throwable -> L7
            this.mHandler.sendMessage(msg4);     // Catch: Throwable -> L7
            goto L4
        L31:
            if (transportType != 1) goto L33;
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Received WIFI TLS connected key message: " + key4);     // Catch: Throwable -> L7
            Message msg5 = this.mHandler.obtainMessage(22);     // Catch: Throwable -> L7
            msg5.obj = key4;     // Catch: Throwable -> L7
            this.mHandler.sendMessage(msg5);     // Catch: Throwable -> L7
            goto L4
        L33:
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Got unknown transport type from adbd (" + transportType + ")");     // Catch: Throwable -> L7
        L36:
            if (buffer[0] != 87) goto L47;
            if (buffer[1] != 70) goto L47;
            byte transportType2 = buffer[2];     // Catch: Throwable -> L7
            String key5 = new String(Arrays.copyOfRange(buffer, 3, count));     // Catch: Throwable -> L7
            if (transportType2 != 0) goto L42;
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Received USB TLS disconnect message: " + key5);     // Catch: Throwable -> L7
            Message msg6 = this.mHandler.obtainMessage(7);     // Catch: Throwable -> L7
            msg6.obj = key5;     // Catch: Throwable -> L7
            this.mHandler.sendMessage(msg6);     // Catch: Throwable -> L7
            goto L4
        L42:
            if (transportType2 != 1) goto L44;
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Received WIFI TLS disconnect key message: " + key5);     // Catch: Throwable -> L7
            Message msg7 = this.mHandler.obtainMessage(23);     // Catch: Throwable -> L7
            msg7.obj = key5;     // Catch: Throwable -> L7
            this.mHandler.sendMessage(msg7);     // Catch: Throwable -> L7
            goto L4
        L44:
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Got unknown transport type from adbd (" + transportType2 + ")");     // Catch: Throwable -> L7
        L47:
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Wrong message: " + new String(Arrays.copyOfRange(buffer, 0, 2)));     // Catch: Throwable -> L7
        L48:
            monitor-enter(this);
            closeSocketLocked();     // Catch: Throwable -> L52
            monitor-exit(this);     // Catch: Throwable -> L52
            return;
        L52:
            th = move-exception;
            throw th;
        L6:
            Slog.w(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Read failed with count " + count);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            monitor-enter(this);
            closeSocketLocked();     // Catch: Throwable -> L59
            throw th;
        L59:
            th = move-exception;
            throw th;
        }

        private void closeSocketLocked() {
            Slog.d(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Closing socket");
        L7:
            e = move-exception;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Failed closing output stream: " + e);
        L23:
        L15:
            ex = move-exception;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Failed closing socket: " + ex);
        L19:
            this.mHandler.sendEmptyMessage(27);
            return;
        L12:
            if (this.mSocket == null) goto L19;
            this.mSocket.close();     // Catch: IOException -> L15
            this.mSocket = null;     // Catch: IOException -> L15
            goto L19
        L4:
            if (this.mOutputStream == null) goto L23;
            this.mOutputStream.close();     // Catch: IOException -> L7
            this.mOutputStream = null;     // Catch: IOException -> L7
            goto L23
        }

        void stopListening() {
            monitor-enter(this);
            this.mStopped = true;     // Catch: Throwable -> L7
            closeSocketLocked();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void sendResponse(String msg) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.mStopped == false) goto L6;
        L13:
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L6:
            if (this.mOutputStream == null) goto L13;
            this.mOutputStream.write(msg.getBytes());     // Catch: Throwable -> L9 IOException -> L11
        L11:
            ex = move-exception;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Failed to write response:", ex);     // Catch: Throwable -> L9
            goto L13
        }
    }

    class AdbKeyStore {
        private static final int KEYSTORE_VERSION = 1;
        private static final int MAX_SUPPORTED_KEYSTORE_VERSION = 1;
        public static final long NO_PREVIOUS_CONNECTION = 0;
        private static final String SYSTEM_KEY_FILE = "/adb_keys";
        private static final String XML_ATTRIBUTE_KEY = "key";
        private static final String XML_ATTRIBUTE_LAST_CONNECTION = "lastConnection";
        private static final String XML_ATTRIBUTE_VERSION = "version";
        private static final String XML_ATTRIBUTE_WIFI_BSSID = "bssid";
        private static final String XML_KEYSTORE_START_TAG = "keyStore";
        private static final String XML_TAG_ADB_KEY = "adbKey";
        private static final String XML_TAG_WIFI_ACCESS_POINT = "wifiAP";
        private AtomicFile mAtomicKeyFile;
        private final Map<String, Long> mKeyMap;
        private final Set<String> mSystemKeys;
        private final List<String> mTrustedNetworks;
        final /* synthetic */ AdbDebuggingManager this$0;

        AdbKeyStore(AdbDebuggingManager this$0) {
            this.this$0 = this$0;
            this.mKeyMap = new HashMap();
            this.mTrustedNetworks = new ArrayList();
            initKeyFile();
            readTempKeysFile();
            this.mSystemKeys = getSystemKeysFromFile(SYSTEM_KEY_FILE);
            addExistingUserKeysToKeyStore();
        }

        public void reloadKeyMap() {
            readTempKeysFile();
        }

        public void addTrustedNetwork(String bssid) {
            this.mTrustedNetworks.add(bssid);
            AdbDebuggingManager.m967$$Nest$msendPersistKeyStoreMessage(this.this$0);
        }

        public Map<String, PairDevice> getPairedDevices() {
            Map<String, PairDevice> pairedDevices = new HashMap();
            Iterator<Map.Entry<String, Long>> r1 = this.mKeyMap.entrySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            Map.Entry<String, Long> keyEntry = r1.next();
            String fingerprints = AdbDebuggingManager.m966$$Nest$mgetFingerprints(this.this$0, keyEntry.getKey());
            String hostname = "nouser@nohostname";
            String[] args = keyEntry.getKey().split("\\s+");
            if (args.length <= 1) goto L8;
            hostname = args[1];
        L8:
            PairDevice pairDevice = new PairDevice();
            pairDevice.name = hostname;
            pairDevice.guid = fingerprints;
            pairDevice.connected = AdbDebuggingManager.m959$$Nest$fgetmWifiConnectedKeys(this.this$0).contains(keyEntry.getKey());
            pairedDevices.put(keyEntry.getKey(), pairDevice);
            goto L4
        L9:
            return pairedDevices;
        }

        public String findKeyFromFingerprint(String fingerprint) {
            Iterator<Map.Entry<String, Long>> r0 = this.mKeyMap.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            Map.Entry<String, Long> entry = r0.next();
            String f = AdbDebuggingManager.m966$$Nest$mgetFingerprints(this.this$0, entry.getKey());
            if (fingerprint.equals(f) == false) goto L4;
            return entry.getKey();
        L10:
            return null;
        }

        public void removeKey(String key) {
            if (this.mKeyMap.containsKey(key) == false) goto L6;
            this.mKeyMap.remove(key);
            AdbDebuggingManager.m967$$Nest$msendPersistKeyStoreMessage(this.this$0);
            return;
        }

        private void initKeyFile() {
            if (AdbDebuggingManager.m955$$Nest$fgetmTempKeysFile(this.this$0) == null) goto L6;
            this.mAtomicKeyFile = new AtomicFile(AdbDebuggingManager.m955$$Nest$fgetmTempKeysFile(this.this$0));
            return;
        }

        private Set<String> getSystemKeysFromFile(String fileName) {
            Set<String> systemKeys = new HashSet();
            File systemKeyFile = new File(fileName);
            if (systemKeyFile.exists() == true) goto L25;
        L24:
            return systemKeys;
        L25:
            BufferedReader in = new BufferedReader(new FileReader(systemKeyFile));     // Catch: IOException -> L16
        L28:
            String key = in.readLine();     // Catch: Throwable -> L11
            if (key == null) goto L14;
            String key2 = key.trim();     // Catch: Throwable -> L11
            if (key2.length() <= 0) goto L28;
            systemKeys.add(key2);     // Catch: Throwable -> L11
        L14:
            in.close();     // Catch: IOException -> L16
        L11:
            th = move-exception;
            in.close();     // Catch: Throwable -> L20
        L22:
            throw th;     // Catch: IOException -> L16
        L20:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L16
        L16:
            e = move-exception;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Caught an exception reading " + fileName + ": " + e);
            goto L24
        }

        public boolean isEmpty() {
            return this.mKeyMap.isEmpty();
        }

        public void updateKeyStore() {
            if (filterOutOldKeys() == false) goto L6;
            AdbDebuggingManager.m967$$Nest$msendPersistKeyStoreMessage(this.this$0);
            return;
        }

        private void readTempKeysFile() {
            this.mKeyMap.clear();
            this.mTrustedNetworks.clear();
            if (this.mAtomicKeyFile != null) goto L9;
            initKeyFile();
            if (this.mAtomicKeyFile != null) goto L9;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Unable to obtain the key file, " + AdbDebuggingManager.m955$$Nest$fgetmTempKeysFile(this.this$0) + ", for reading");
            return;
        L9:
            if (this.mAtomicKeyFile.exists() == true) goto L49;
            return;
        L49:
            FileInputStream keyStream = this.mAtomicKeyFile.openRead();     // Catch: XmlPullParserException -> L18 IOException -> L20
            TypedXmlPullParser parser = Xml.resolvePullParser(keyStream);     // Catch: Throwable -> L23 XmlPullParserException -> L25
            XmlUtils.beginDocument(parser, XML_KEYSTORE_START_TAG);     // Catch: Throwable -> L23 XmlPullParserException -> L25
            int keystoreVersion = parser.getAttributeInt(null, XML_ATTRIBUTE_VERSION);     // Catch: Throwable -> L23 XmlPullParserException -> L25
            if (keystoreVersion <= 1) goto L30;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Keystore version=" + keystoreVersion + " not supported (max_supported=1)");     // Catch: Throwable -> L23 XmlPullParserException -> L25
            if (keyStream == null) goto L22;
            keyStream.close();     // Catch: XmlPullParserException -> L18 IOException -> L20
            return;
        L22:
            return;
        L30:
            readKeyStoreContents(parser);     // Catch: Throwable -> L23
            if (keyStream == null) goto L52;
            keyStream.close();     // Catch: XmlPullParserException -> L18 IOException -> L20
            return;
        L52:
            return;
        L23:
            th = move-exception;
            if (keyStream != null) goto L46;
        L40:
            throw th;     // Catch: XmlPullParserException -> L18 IOException -> L20
        L46:
            keyStream.close();     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            th.addSuppressed(th);     // Catch: XmlPullParserException -> L18 IOException -> L20
        L29:
            parser = Xml.resolvePullParser(keyStream);     // Catch: Throwable -> L23
        L20:
            e = move-exception;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Caught an IOException parsing the XML key file: ", e);
            return;
        L18:
            e = move-exception;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Caught XmlPullParserException parsing the XML key file: ", e);
        }

        private void readKeyStoreContents(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        L3:
            if (parser.next() == 1) goto L12;
            String tagName = parser.getName();
            if (XML_TAG_ADB_KEY.equals(tagName) == false) goto L8;
            addAdbKeyToKeyMap(parser);
        L11:
            XmlUtils.skipCurrentTag(parser);
            goto L3
        L8:
            if (XML_TAG_WIFI_ACCESS_POINT.equals(tagName) == false) goto L10;
            addTrustedNetworkToTrustedNetworks(parser);
            goto L11
        L10:
            Slog.w(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Ignoring tag '" + tagName + "'. Not recognized.");
            goto L11
        }

        private void addAdbKeyToKeyMap(TypedXmlPullParser parser) {
            String key = parser.getAttributeValue(null, XML_ATTRIBUTE_KEY);
            long connectionTime = parser.getAttributeLong(null, XML_ATTRIBUTE_LAST_CONNECTION);     // Catch: XmlPullParserException -> L5
            this.mKeyMap.put(key, Long.valueOf(connectionTime));     // Catch: XmlPullParserException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Error reading adbKey attributes", e);
        }

        private void addTrustedNetworkToTrustedNetworks(TypedXmlPullParser parser) {
            String bssid = parser.getAttributeValue(null, XML_ATTRIBUTE_WIFI_BSSID);
            this.mTrustedNetworks.add(bssid);
        }

        private void addExistingUserKeysToKeyStore() {
            if (AdbDebuggingManager.m958$$Nest$fgetmUserKeyFile(this.this$0) != null) goto L5;
            return;
        L5:
            if (AdbDebuggingManager.m958$$Nest$fgetmUserKeyFile(this.this$0).exists() == false) goto L43;
            boolean mapUpdated = false;
            BufferedReader in = new BufferedReader(new FileReader(AdbDebuggingManager.m958$$Nest$fgetmUserKeyFile(this.this$0)));     // Catch: IOException -> L20
        L35:
            String key = in.readLine();     // Catch: Throwable -> L15
            if (key == null) goto L18;
            if (this.mKeyMap.containsKey(key) == true) goto L35;
            this.mKeyMap.put(key, Long.valueOf(AdbDebuggingManager.m957$$Nest$fgetmTicker(this.this$0).currentTimeMillis()));     // Catch: Throwable -> L15
            mapUpdated = true;
            goto L35
        L18:
            in.close();     // Catch: IOException -> L20
        L28:
            if (mapUpdated == false) goto L42;
            AdbDebuggingManager.m967$$Nest$msendPersistKeyStoreMessage(this.this$0);
            return;
        L42:
            return;
        L15:
            th = move-exception;
            in.close();     // Catch: Throwable -> L24
        L26:
            throw th;     // Catch: IOException -> L20
        L24:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L20
        L20:
            e = move-exception;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Caught an exception reading " + AdbDebuggingManager.m958$$Nest$fgetmUserKeyFile(this.this$0) + ": " + e);
            goto L28
        }

        public void persistKeyStore() {
            filterOutOldKeys();
            if (this.mKeyMap.isEmpty() == false) goto L9;
            if (this.mTrustedNetworks.isEmpty() == false) goto L9;
            deleteKeyStore();
            return;
        L9:
            if (this.mAtomicKeyFile != null) goto L14;
            initKeyFile();
            if (this.mAtomicKeyFile != null) goto L14;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Unable to obtain the key file, " + AdbDebuggingManager.m955$$Nest$fgetmTempKeysFile(this.this$0) + ", for writing");
            return;
        L14:
            FileOutputStream keyStream = null;
            keyStream = this.mAtomicKeyFile.startWrite();     // Catch: IOException -> L19
            TypedXmlSerializer serializer = Xml.resolveSerializer(keyStream);     // Catch: IOException -> L19
            serializer.startDocument(null, true);     // Catch: IOException -> L19
            serializer.startTag(null, XML_KEYSTORE_START_TAG);     // Catch: IOException -> L19
            serializer.attributeInt(null, XML_ATTRIBUTE_VERSION, 1);     // Catch: IOException -> L19
            Iterator<Map.Entry<String, Long>> r5 = this.mKeyMap.entrySet().iterator();     // Catch: IOException -> L19
        L17:
            if (r5.hasNext() == false) goto L21;
            Map.Entry<String, Long> keyEntry = r5.next();     // Catch: IOException -> L19
            serializer.startTag(null, XML_TAG_ADB_KEY);     // Catch: IOException -> L19
            serializer.attribute(null, XML_ATTRIBUTE_KEY, keyEntry.getKey());     // Catch: IOException -> L19
            serializer.attributeLong(null, XML_ATTRIBUTE_LAST_CONNECTION, keyEntry.getValue().longValue());     // Catch: IOException -> L19
            serializer.endTag(null, XML_TAG_ADB_KEY);     // Catch: IOException -> L19
            goto L17
        L21:
            Iterator<String> r1 = this.mTrustedNetworks.iterator();     // Catch: IOException -> L19
        L23:
            if (r1.hasNext() == false) goto L25;
            String bssid = r1.next();     // Catch: IOException -> L19
            serializer.startTag(null, XML_TAG_WIFI_ACCESS_POINT);     // Catch: IOException -> L19
            serializer.attribute(null, XML_ATTRIBUTE_WIFI_BSSID, bssid);     // Catch: IOException -> L19
            serializer.endTag(null, XML_TAG_WIFI_ACCESS_POINT);     // Catch: IOException -> L19
            goto L23
        L25:
            serializer.endTag(null, XML_KEYSTORE_START_TAG);     // Catch: IOException -> L19
            serializer.endDocument();     // Catch: IOException -> L19
            this.mAtomicKeyFile.finishWrite(keyStream);     // Catch: IOException -> L19
        L28:
            AdbDebuggingManager.m971$$Nest$mwriteKeys(this.this$0, this.mKeyMap.keySet());
            return;
        L19:
            e = move-exception;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Caught an exception writing the key map: ", e);
            this.mAtomicKeyFile.failWrite(keyStream);
            goto L28
        }

        private boolean filterOutOldKeys() {
            long allowedTime = getAllowedConnectionTime();
            if (allowedTime != 0) goto L6;
            return false;
        L6:
            boolean keysDeleted = false;
            long systemTime = AdbDebuggingManager.m957$$Nest$fgetmTicker(this.this$0).currentTimeMillis();
            Iterator<Map.Entry<String, Long>> keyMapIterator = this.mKeyMap.entrySet().iterator();
        L8:
            if (keyMapIterator.hasNext() == false) goto L13;
            Map.Entry<String, Long> keyEntry = keyMapIterator.next();
            long connectionTime = keyEntry.getValue().longValue();
            if (systemTime <= (connectionTime + allowedTime)) goto L8;
            keyMapIterator.remove();
            keysDeleted = true;
            goto L8
        L13:
            if (keysDeleted == false) goto L15;
            AdbDebuggingManager.m971$$Nest$mwriteKeys(this.this$0, this.mKeyMap.keySet());
        L15:
            return keysDeleted;
        }

        public long getNextExpirationTime() {
            long minExpiration = -1;
            long allowedTime = getAllowedConnectionTime();
            if (allowedTime != 0) goto L5;
            return -1;
        L5:
            long systemTime = AdbDebuggingManager.m957$$Nest$fgetmTicker(this.this$0).currentTimeMillis();
            Iterator<Map.Entry<String, Long>> keyMapIterator = this.mKeyMap.entrySet().iterator();
        L7:
            if (keyMapIterator.hasNext() == false) goto L14;
            Map.Entry<String, Long> keyEntry = keyMapIterator.next();
            long connectionTime = keyEntry.getValue().longValue();
            long keyExpiration = Math.max(0, (connectionTime + allowedTime) - systemTime);
            if (minExpiration == (-1)) goto L12;
            if (keyExpiration >= minExpiration) goto L7;
        L12:
            minExpiration = keyExpiration;
            goto L7
        L14:
            return minExpiration;
        }

        public void deleteKeyStore() {
            this.mKeyMap.clear();
            this.mTrustedNetworks.clear();
            if (AdbDebuggingManager.m958$$Nest$fgetmUserKeyFile(this.this$0) == null) goto L6;
            AdbDebuggingManager.m958$$Nest$fgetmUserKeyFile(this.this$0).delete();
        L6:
            if (this.mAtomicKeyFile != null) goto L8;
            return;
        L8:
            this.mAtomicKeyFile.delete();
        }

        public long getLastConnectionTime(String key) {
            return this.mKeyMap.getOrDefault(key, 0L).longValue();
        }

        public void setLastConnectionTime(String key, long connectionTime) {
            setLastConnectionTime(key, connectionTime, false);
        }

        void setLastConnectionTime(String key, long connectionTime, boolean force) {
            if (this.mKeyMap.containsKey(key) == false) goto L9;
            if (this.mKeyMap.get(key).longValue() < connectionTime) goto L9;
            if (force == true) goto L9;
            return;
        L9:
            if (this.mSystemKeys.contains(key) == false) goto L11;
            return;
        L11:
            this.mKeyMap.put(key, Long.valueOf(connectionTime));
        }

        public long getAllowedConnectionTime() {
            return Settings.Global.getLong(AdbDebuggingManager.m952$$Nest$fgetmContext(this.this$0).getContentResolver(), "adb_allowed_connection_time", UnixCalendar.WEEK_IN_MILLIS);
        }

        public boolean isKeyAuthorized(String key) {
            if (this.mSystemKeys.contains(key) == false) goto L5;
            return true;
        L5:
            long lastConnectionTime = getLastConnectionTime(key);
            if (lastConnectionTime != 0) goto L8;
            return false;
        L8:
            long allowedConnectionTime = getAllowedConnectionTime();
            if (allowedConnectionTime != 0) goto L11;
            return true;
        L11:
            if (AdbDebuggingManager.m957$$Nest$fgetmTicker(this.this$0).currentTimeMillis() >= (lastConnectionTime + allowedConnectionTime)) goto L15;
            return true;
        L15:
            return false;
        }

        public boolean isTrustedNetwork(String bssid) {
            return this.mTrustedNetworks.contains(bssid);
        }
    }

    class PairingThread extends Thread implements NsdManager.RegistrationListener {
        static final String SERVICE_PROTOCOL = "adb-tls-pairing";
        private String mGuid;
        private NsdManager mNsdManager;
        private String mPairingCode;
        private int mPort;
        private String mPublicKey;
        private String mServiceName;
        private final String mServiceType;
        final /* synthetic */ AdbDebuggingManager this$0;

        private native void native_pairing_cancel();

        private native int native_pairing_start(String r1, String r2);

        private native boolean native_pairing_wait();

        PairingThread(AdbDebuggingManager this$0, String pairingCode, String serviceName) {
            this.this$0 = this$0;
            super(AdbDebuggingManager.m973$$Nest$sfgetTAG());
            this.mServiceType = String.format("_%s._tcp.", new Object[]{SERVICE_PROTOCOL});
            this.mPairingCode = pairingCode;
            this.mGuid = SystemProperties.get(AdbDebuggingManager.WIFI_PERSISTENT_GUID);
            this.mServiceName = serviceName;
            if (serviceName != null) goto L5;
        L6:
            this.mServiceName = this.mGuid;
        L7:
            this.mPort = -1;
            this.mNsdManager = (NsdManager) AdbDebuggingManager.m952$$Nest$fgetmContext(this$0).getSystemService("servicediscovery");
            return;
        L5:
            if (serviceName.isEmpty() == false) goto L7;
            goto L6
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            NsdServiceInfo serviceInfo = new NsdServiceInfo();
            serviceInfo.setServiceName(this.mServiceName);
            serviceInfo.setServiceType(this.mServiceType);
            serviceInfo.setPort(this.mPort);
            this.mNsdManager.registerService(serviceInfo, 1, this);
            Message msg = this.this$0.mHandler.obtainMessage(21);
            msg.obj = Integer.valueOf(this.mPort);
            this.this$0.mHandler.sendMessage(msg);
            boolean paired = native_pairing_wait();
            if (this.mPublicKey == null) goto L5;
            Slog.i(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Pairing succeeded key=" + this.mPublicKey);
        L6:
            this.mNsdManager.unregisterService(this);
            Bundle bundle = new Bundle();
            if (paired == false) goto L9;
            String r4 = this.mPublicKey;
        L10:
            bundle.putString("publicKey", r4);
            Message message = Message.obtain(this.this$0.mHandler, 20, bundle);
            this.this$0.mHandler.sendMessage(message);
            return;
        L9:
            r4 = null;
            goto L10
        L5:
            Slog.i(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Pairing failed");
            goto L6
        }

        @Override // java.lang.Thread
        public void start() {
            if (this.mGuid.isEmpty() == false) goto L6;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "adbwifi guid was not set");
            return;
        L6:
            this.mPort = native_pairing_start(this.mGuid, this.mPairingCode);
            if (this.mPort > 0) goto L10;
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Unable to start pairing server");
            return;
        L10:
            super.start();
        }

        public void cancelPairing() {
            native_pairing_cancel();
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onServiceRegistered(NsdServiceInfo serviceInfo) {
            Slog.i(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Registered pairing service: " + serviceInfo);
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onRegistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
            Slog.e(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Failed to register pairing service(err=" + errorCode + "): " + serviceInfo);
            cancelPairing();
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onServiceUnregistered(NsdServiceInfo serviceInfo) {
            Slog.i(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Unregistered pairing service: " + serviceInfo);
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
            Slog.w(AdbDebuggingManager.m973$$Nest$sfgetTAG(), "Failed to unregister pairing service(err=" + errorCode + "): " + serviceInfo);
        }
    }

    interface Ticker {
        long currentTimeMillis();
    }

    /* JADX INFO: renamed from: $r8$lambda$I3NlJTMol-2JFN3dPyCB7gKkrsk, reason: not valid java name */
    public static /* synthetic */ long m945$r8$lambda$I3NlJTMol2JFN3dPyCB7gKkrsk() {
        return lambda$static$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdbConnectionInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ AdbConnectionInfo m946$$Nest$fgetmAdbConnectionInfo(AdbDebuggingManager r0) {
        return r0.mAdbConnectionInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdbUsbEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m947$$Nest$fgetmAdbUsbEnabled(AdbDebuggingManager r0) {
        return r0.mAdbUsbEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdbWifiEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m948$$Nest$fgetmAdbWifiEnabled(AdbDebuggingManager r0) {
        return r0.mAdbWifiEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectedKeys, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m949$$Nest$fgetmConnectedKeys(AdbDebuggingManager r0) {
        return r0.mConnectedKeys;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectionPortPoller, reason: not valid java name */
    static /* bridge */ /* synthetic */ AdbConnectionPortPoller m950$$Nest$fgetmConnectionPortPoller(AdbDebuggingManager r0) {
        return r0.mConnectionPortPoller;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContentResolver, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentResolver m951$$Nest$fgetmContentResolver(AdbDebuggingManager r0) {
        return r0.mContentResolver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m952$$Nest$fgetmContext(AdbDebuggingManager r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFingerprints, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m953$$Nest$fgetmFingerprints(AdbDebuggingManager r0) {
        return r0.mFingerprints;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPairingThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ PairingThread m954$$Nest$fgetmPairingThread(AdbDebuggingManager r0) {
        return r0.mPairingThread;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTempKeysFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m955$$Nest$fgetmTempKeysFile(AdbDebuggingManager r0) {
        return r0.mTempKeysFile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ AdbDebuggingThread m956$$Nest$fgetmThread(AdbDebuggingManager r0) {
        return r0.mThread;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTicker, reason: not valid java name */
    static /* bridge */ /* synthetic */ Ticker m957$$Nest$fgetmTicker(AdbDebuggingManager r0) {
        return r0.mTicker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserKeyFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m958$$Nest$fgetmUserKeyFile(AdbDebuggingManager r0) {
        return r0.mUserKeyFile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWifiConnectedKeys, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m959$$Nest$fgetmWifiConnectedKeys(AdbDebuggingManager r0) {
        return r0.mWifiConnectedKeys;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAdbUsbEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m960$$Nest$fputmAdbUsbEnabled(AdbDebuggingManager r0, boolean r1) {
        r0.mAdbUsbEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAdbWifiEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m961$$Nest$fputmAdbWifiEnabled(AdbDebuggingManager r0, boolean r1) {
        r0.mAdbWifiEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmConnectionPortPoller, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m962$$Nest$fputmConnectionPortPoller(AdbDebuggingManager r0, AdbConnectionPortPoller r1) {
        r0.mConnectionPortPoller = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFingerprints, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m963$$Nest$fputmFingerprints(AdbDebuggingManager r0, String r1) {
        r0.mFingerprints = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPairingThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m964$$Nest$fputmPairingThread(AdbDebuggingManager r0, PairingThread r1) {
        r0.mPairingThread = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m965$$Nest$fputmThread(AdbDebuggingManager r0, AdbDebuggingThread r1) {
        r0.mThread = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetFingerprints, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m966$$Nest$mgetFingerprints(AdbDebuggingManager r0, String r1) {
        return r0.getFingerprints(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendPersistKeyStoreMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m967$$Nest$msendPersistKeyStoreMessage(AdbDebuggingManager r0) {
        r0.sendPersistKeyStoreMessage();
    }

    /* JADX INFO: renamed from: -$$Nest$msetAdbConnectionInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m968$$Nest$msetAdbConnectionInfo(AdbDebuggingManager r0, AdbConnectionInfo r1) {
        r0.setAdbConnectionInfo(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartConfirmationForKey, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m969$$Nest$mstartConfirmationForKey(AdbDebuggingManager r0, String r1, String r2) {
        r0.startConfirmationForKey(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartConfirmationForNetwork, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m970$$Nest$mstartConfirmationForNetwork(AdbDebuggingManager r0, String r1, String r2) {
        r0.startConfirmationForNetwork(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteKeys, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m971$$Nest$mwriteKeys(AdbDebuggingManager r0, Iterable r1) {
        r0.writeKeys(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetADBD_STATE_CHANGE_TIMEOUT, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m972$$Nest$sfgetADBD_STATE_CHANGE_TIMEOUT() {
        return ADBD_STATE_CHANGE_TIMEOUT;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m973$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = AdbDebuggingManager.class.getSimpleName();
        SYSTEM_TICKER = new AdbDebuggingManager$$ExternalSyntheticLambda0();
        ADBD_STATE_CHANGE_TIMEOUT = InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
    }

    private static /* synthetic */ long lambda$static$0() {
        return System.currentTimeMillis();
    }

    public AdbDebuggingManager(Context context) {
        this(context, null, getAdbFile(ADB_KEYS_FILE), getAdbFile(ADB_TEMP_KEYS_FILE), null, SYSTEM_TICKER);
    }

    AdbDebuggingManager(Context context, String confirmComponent, File testUserKeyFile, File tempKeysFile, AdbDebuggingThread adbDebuggingThread, Ticker ticker) {
        this.mAdbUsbEnabled = false;
        this.mAdbWifiEnabled = false;
        this.mConnectedKeys = new HashMap();
        this.mPairingThread = null;
        this.mWifiConnectedKeys = new HashSet();
        this.mAdbConnectionInfo = new AdbConnectionInfo();
        this.mContext = context;
        this.mContentResolver = this.mContext.getContentResolver();
        this.mConfirmComponent = confirmComponent;
        this.mUserKeyFile = testUserKeyFile;
        this.mTempKeysFile = tempKeysFile;
        this.mThread = adbDebuggingThread;
        this.mTicker = ticker;
        this.mHandler = new AdbDebuggingHandler(this, FgThread.get().getLooper(), this.mThread);
    }

    static void sendBroadcastWithDebugPermission(Context context, Intent intent, UserHandle userHandle) {
        context.sendBroadcastAsUser(intent, userHandle, "android.permission.MANAGE_DEBUGGING");
    }

    private void setAdbConnectionInfo(AdbConnectionInfo info) {
        AdbConnectionInfo r0 = this.mAdbConnectionInfo;
        monitor-enter(r0);
        if (info != null) goto L10;
        this.mAdbConnectionInfo.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mAdbConnectionInfo = info;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private AdbConnectionInfo getAdbConnectionInfo() {
        AdbConnectionInfo r0 = this.mAdbConnectionInfo;
        monitor-enter(r0);
        AdbConnectionInfo r1 = new AdbConnectionInfo(this.mAdbConnectionInfo);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private String getFingerprints(String key) {
        StringBuilder sb = new StringBuilder();
        if (key != null) goto L25;
        return "";
    L25:
        MessageDigest digester = MessageDigest.getInstance("MD5");     // Catch: Exception -> L20
        byte[] base64_data = key.split("\\s+")[0].getBytes();
        byte[] digest = digester.digest(Base64.decode(base64_data, 0));     // Catch: IllegalArgumentException -> L17
        int i = 0;
    L10:
        if (i >= digest.length) goto L16;
        sb.append("0123456789ABCDEF".charAt((digest[i] >> 4) & 15));
        sb.append("0123456789ABCDEF".charAt(digest[i] & 15));
        if (i >= (digest.length - 1)) goto L14;
        sb.append(":");
    L14:
        i = i + 1;
        goto L10
    L16:
        return sb.toString();
    L17:
        e = move-exception;
        Slog.e(TAG, "error doing base64 decoding", e);
        return "";
    L20:
        ex = move-exception;
        Slog.e(TAG, "Error getting digester", ex);
        return "";
    }

    private void startConfirmationForNetwork(String ssid, String bssid) {
        List<Map.Entry<String, String>> extras = new ArrayList();
        extras.add(new AbstractMap.SimpleEntry("ssid", ssid));
        extras.add(new AbstractMap.SimpleEntry("bssid", bssid));
        int currentUserId = ActivityManager.getCurrentUser();
        String componentString = Resources.getSystem().getString(R.string.config_defaultSmartspaceService);
        ComponentName componentName = ComponentName.unflattenFromString(componentString);
        UserInfo userInfo = UserManager.get(this.mContext).getUserInfo(currentUserId);
        if (startConfirmationActivity(componentName, userInfo.getUserHandle(), extras) == false) goto L5;
        return;
    L5:
        if (startConfirmationService(componentName, userInfo.getUserHandle(), extras) == true) goto L10;
        Slog.e(TAG, "Unable to start customAdbWifiNetworkConfirmation[SecondaryUser]Component " + componentString + " as an Activity or a Service");
        return;
    }

    private boolean isMaintenaceMode() {
        int currentUserId = ActivityManager.getCurrentUser();
        int mUid = Integer.parseInt(SystemProperties.get(MAINTENACE_ID, "0"));
        Slog.d(TAG, "isMaintenaceMode currentUserId = " + currentUserId);
        Slog.d(TAG, "isMaintenaceMode mUid = " + mUid);
        if (mUid == 0) goto L7;
        if (mUid != currentUserId) goto L9;
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    private void startConfirmationForKey(String key, String fingerprints) {
        List<Map.Entry<String, String>> extras = new ArrayList();
        extras.add(new AbstractMap.SimpleEntry("key", key));
        extras.add(new AbstractMap.SimpleEntry("fingerprints", fingerprints));
        int currentUserId = ActivityManager.getCurrentUser();
        UserInfo userInfo = UserManager.get(this.mContext).getUserInfo(currentUserId);
        if (userInfo.isAdmin() == false) goto L5;
    L8:
        String componentString = this.mConfirmComponent;
        if (componentString == null) goto L11;
        String componentString2 = this.mConfirmComponent;
    L12:
        ComponentName componentName = ComponentName.unflattenFromString(componentString2);
        if (startConfirmationActivity(componentName, userInfo.getUserHandle(), extras) == false) goto L15;
        return;
    L15:
        if (startConfirmationService(componentName, userInfo.getUserHandle(), extras) == true) goto L20;
        Slog.e(TAG, "unable to start customAdbPublicKeyConfirmation[SecondaryUser]Component " + componentString2 + " as an Activity or a Service");
        return;
    L20:
        return;
    L11:
        componentString2 = Resources.getSystem().getString(R.string.config_defaultSelectToSpeakService);
        goto L12
    L5:
        if (isMaintenaceMode() == true) goto L8;
        componentString2 = Resources.getSystem().getString(R.string.config_defaultShutdownVibrationFile);
        goto L12
    }

    private boolean startConfirmationActivity(ComponentName componentName, UserHandle userHandle, List<Map.Entry<String, String>> extras) {
        PackageManager packageManager = this.mContext.getPackageManager();
        Intent intent = createConfirmationIntent(componentName, extras);
        intent.addFlags(268435456);
        if (packageManager.resolveActivity(intent, 65536) == null) goto L13;
        this.mContext.startActivityAsUser(intent, userHandle);     // Catch: ActivityNotFoundException -> L7
        return true;
    L7:
        e = move-exception;
        Slog.e(TAG, "unable to start adb whitelist activity: " + componentName, e);
        return false;
    L13:
        return false;
    }

    private boolean startConfirmationService(ComponentName componentName, UserHandle userHandle, List<Map.Entry<String, String>> extras) {
        Intent intent = createConfirmationIntent(componentName, extras);
        if (this.mContext.startServiceAsUser(intent, userHandle) == null) goto L14;
        return true;
    L14:
        return false;
    L8:
        e = move-exception;
        Slog.e(TAG, "unable to start adb whitelist service: " + componentName, e);
        return false;
    }

    private Intent createConfirmationIntent(ComponentName componentName, List<Map.Entry<String, String>> extras) {
        Intent intent = new Intent();
        intent.setClassName(componentName.getPackageName(), componentName.getClassName());
        Iterator<Map.Entry<String, String>> r1 = extras.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, String> entry = r1.next();
        intent.putExtra(entry.getKey(), entry.getValue());
        goto L4
    L6:
        return intent;
    }

    private static File getAdbFile(String fileName) {
        File dataDir = Environment.getDataDirectory();
        File adbDir = new File(dataDir, ADB_DIRECTORY);
        if (adbDir.exists() == true) goto L7;
        Slog.e(TAG, "ADB data directory does not exist");
        return null;
    L7:
        return new File(adbDir, fileName);
    }

    File getAdbTempKeysFile() {
        return this.mTempKeysFile;
    }

    File getUserKeyFile() {
        return this.mUserKeyFile;
    }

    private void writeKeys(Iterable<String> keys) {
        if (this.mUserKeyFile != null) goto L5;
        return;
    L5:
        AtomicFile atomicKeyFile = new AtomicFile(this.mUserKeyFile);
        FileOutputStream fo = null;
        fo = atomicKeyFile.startWrite();     // Catch: IOException -> L10
        Iterator<String> r2 = keys.iterator();     // Catch: IOException -> L10
    L8:
        if (r2.hasNext() == false) goto L12;
        String key = r2.next();     // Catch: IOException -> L10
        fo.write(key.getBytes());     // Catch: IOException -> L10
        fo.write(10);     // Catch: IOException -> L10
        goto L8
    L12:
        atomicKeyFile.finishWrite(fo);     // Catch: IOException -> L10
        FileUtils.setPermissions(this.mUserKeyFile.toString(), FrameworkStatsLog.DISPLAY_HBM_STATE_CHANGED, -1, -1);
        return;
    L10:
        ex = move-exception;
        Slog.e(TAG, "Error writing keys: " + ex);
        atomicKeyFile.failWrite(fo);
    }

    public void setAdbEnabled(boolean enabled, byte transportType) {
        int r0 = 1;
        if (transportType != 0) goto L9;
        AdbDebuggingHandler r1 = this.mHandler;
        if (enabled == true) goto L8;
        r0 = 2;
    L8:
        r1.sendEmptyMessage(r0);
        return;
    L9:
        if (transportType != 1) goto L17;
        AdbDebuggingHandler r2 = this.mHandler;
        if (enabled == false) goto L13;
        int r3 = 11;
    L14:
        r2.sendEmptyMessage(r3);
        return;
    L13:
        r3 = 12;
        goto L14
    L17:
        throw new IllegalArgumentException("setAdbEnabled called with unimplemented transport type=" + transportType);
    }

    public void allowDebugging(boolean r3, String r4) {
        Message r0 = this.mHandler.obtainMessage(3);
        r0.arg1 = r3 ? 1 : 0;
        r0.obj = r4;
        this.mHandler.sendMessage(r0);
    }

    public void denyDebugging() {
        this.mHandler.sendEmptyMessage(4);
    }

    public void clearDebuggingKeys() {
        this.mHandler.sendEmptyMessage(6);
    }

    public void allowWirelessDebugging(boolean r3, String r4) {
        Message r0 = this.mHandler.obtainMessage(18);
        r0.arg1 = r3 ? 1 : 0;
        r0.obj = r4;
        this.mHandler.sendMessage(r0);
    }

    public void denyWirelessDebugging() {
        this.mHandler.sendEmptyMessage(19);
    }

    public int getAdbWirelessPort() {
        AdbConnectionInfo info = getAdbConnectionInfo();
        if (info != null) goto L7;
        return 0;
    L7:
        return info.getPort();
    }

    public Map<String, PairDevice> getPairedDevices() {
        AdbKeyStore keystore = new AdbKeyStore(this);
        return keystore.getPairedDevices();
    }

    public void unpairDevice(String fingerprint) {
        Message message = Message.obtain(this.mHandler, 17, fingerprint);
        this.mHandler.sendMessage(message);
    }

    public void enablePairingByPairingCode() {
        this.mHandler.sendEmptyMessage(15);
    }

    public void enablePairingByQrCode(String serviceName, String password) {
        Bundle bundle = new Bundle();
        bundle.putString("serviceName", serviceName);
        bundle.putString(HintsHelper.AUTOFILL_HINT_PASSWORD, password);
        Message message = Message.obtain(this.mHandler, 16, bundle);
        this.mHandler.sendMessage(message);
    }

    public void disablePairing() {
        this.mHandler.sendEmptyMessage(14);
    }

    public boolean isAdbWifiEnabled() {
        return this.mAdbWifiEnabled;
    }

    public void notifyKeyFilesUpdated() {
        this.mHandler.sendEmptyMessage(28);
    }

    private void sendPersistKeyStoreMessage() {
        Message msg = this.mHandler.obtainMessage(8);
        this.mHandler.sendMessage(msg);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004b -> B:25:0x0053). Please report as a decompilation issue!!! */
    public void dump(DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        if (this.mThread == null) goto L5;
        boolean r2 = true;
    L6:
        dump.write("connected_to_adb", 1133871366145L, r2);
        DumpUtils.writeStringIfNotNull(dump, "last_key_received", 1138166333442L, this.mFingerprints);
        File userKeys = new File("/data/misc/adb/adb_keys");     // Catch: IOException -> L10
        if (userKeys.exists() == false) goto L12;
        dump.write("user_keys", 1138166333443L, FileUtils.readTextFile(userKeys, 0, null));     // Catch: IOException -> L10
    L25:
        dump.write("system_keys", 1138166333444L, FileUtils.readTextFile(new File("/adb_keys"), 0, null));     // Catch: IOException -> L17
    L27:
        dump.write("keystore", 1138166333445L, FileUtils.readTextFile(this.mTempKeysFile, 0, null));     // Catch: IOException -> L21
    L23:
        dump.end(token);
        return;
    L21:
        e = move-exception;
        Slog.i(TAG, "Cannot read keystore: ", e);
    L17:
        e = move-exception;
        Slog.i(TAG, "Cannot read system keys", e);
        goto L27
    L12:
        Slog.i(TAG, "No user keys on this device");     // Catch: IOException -> L10
    L10:
        e = move-exception;
        Slog.i(TAG, "Cannot read user keys", e);
        goto L25
    L5:
        r2 = false;
        goto L6
    }
}
