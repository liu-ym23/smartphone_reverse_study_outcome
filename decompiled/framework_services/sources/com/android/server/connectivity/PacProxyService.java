package com.android.server.connectivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.IPacProxyInstalledListener;
import android.net.IPacProxyManager;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Log;
import android.webkit.URLUtil;
import com.android.net.IProxyService;
import com.android.net.module.util.PermissionUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes.dex */
public class PacProxyService extends IPacProxyManager.Stub {
    private static final String ACTION_PAC_REFRESH = "android.net.proxy.PAC_REFRESH";
    private static final String DEFAULT_DELAYS = "8 32 120 14400 43200";
    private static final int DELAY_1 = 0;
    private static final int DELAY_4 = 3;
    private static final int DELAY_LONG = 4;
    private static final long MAX_PAC_SIZE = 20000000;
    private static final String PAC_PACKAGE = "com.android.pacprocessor";
    private static final String PAC_SERVICE = "com.android.pacprocessor.PacService";
    private static final String PAC_SERVICE_NAME = "com.android.net.IProxyService";
    private static final String PROXY_PACKAGE = "com.android.proxyhandler";
    private static final String PROXY_SERVICE = "com.android.proxyhandler.ProxyService";
    private static final String TAG = "PacProxyService";
    private AlarmManager mAlarmManager;
    private final Object mBroadcastStateLock;
    private final RemoteCallbackList<IPacProxyInstalledListener> mCallbacks;
    private ServiceConnection mConnection;
    private Context mContext;
    private int mCurrentDelay;
    private String mCurrentPac;
    private volatile boolean mHasDownloaded;
    private volatile boolean mHasSentBroadcast;
    private int mLastPort;
    private final Handler mNetThreadHandler;
    private Runnable mPacDownloader;
    private PendingIntent mPacRefreshIntent;
    private volatile Uri mPacUrl;
    private ServiceConnection mProxyConnection;
    private final Object mProxyLock;
    private IProxyService mProxyService;

    class PacRefreshIntentReceiver extends BroadcastReceiver {
        final /* synthetic */ PacProxyService this$0;

        PacRefreshIntentReceiver(PacProxyService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PacProxyService.m3072$$Nest$fgetmNetThreadHandler(this.this$0).post(PacProxyService.m3073$$Nest$fgetmPacDownloader(this.this$0));
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentPac, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3070$$Nest$fgetmCurrentPac(PacProxyService r0) {
        return r0.mCurrentPac;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastPort, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3071$$Nest$fgetmLastPort(PacProxyService r0) {
        return r0.mLastPort;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetThreadHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3072$$Nest$fgetmNetThreadHandler(PacProxyService r0) {
        return r0.mNetThreadHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPacDownloader, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m3073$$Nest$fgetmPacDownloader(PacProxyService r0) {
        return r0.mPacDownloader;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPacUrl, reason: not valid java name */
    static /* bridge */ /* synthetic */ Uri m3074$$Nest$fgetmPacUrl(PacProxyService r0) {
        return r0.mPacUrl;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProxyLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m3075$$Nest$fgetmProxyLock(PacProxyService r0) {
        return r0.mProxyLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProxyService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IProxyService m3076$$Nest$fgetmProxyService(PacProxyService r0) {
        return r0.mProxyService;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHasDownloaded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3077$$Nest$fputmHasDownloaded(PacProxyService r0, boolean r1) {
        r0.mHasDownloaded = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHasSentBroadcast, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3078$$Nest$fputmHasSentBroadcast(PacProxyService r0, boolean r1) {
        r0.mHasSentBroadcast = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastPort, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3079$$Nest$fputmLastPort(PacProxyService r0, int r1) {
        r0.mLastPort = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmProxyService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3080$$Nest$fputmProxyService(PacProxyService r0, IProxyService r1) {
        r0.mProxyService = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mlongSchedule, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3081$$Nest$mlongSchedule(PacProxyService r0) {
        r0.longSchedule();
    }

    /* JADX INFO: renamed from: -$$Nest$mreschedule, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3082$$Nest$mreschedule(PacProxyService r0) {
        r0.reschedule();
    }

    /* JADX INFO: renamed from: -$$Nest$msendProxyIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3083$$Nest$msendProxyIfNeeded(PacProxyService r0) {
        r0.sendProxyIfNeeded();
    }

    /* JADX INFO: renamed from: -$$Nest$msetCurrentProxyScript, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3084$$Nest$msetCurrentProxyScript(PacProxyService r0, String r1) {
        r0.setCurrentProxyScript(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smget, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3085$$Nest$smget(Uri r0) {
        return get(r0);
    }

    public PacProxyService(Context context) {
        this.mPacUrl = Uri.EMPTY;
        this.mCallbacks = new RemoteCallbackList();
        this.mProxyLock = new Object();
        this.mBroadcastStateLock = new Object();
        this.mPacDownloader = new AnonymousClass1(this);
        this.mContext = context;
        this.mLastPort = -1;
        HandlerThread netThread = new HandlerThread("android.pacproxyservice", 0);
        netThread.start();
        this.mNetThreadHandler = new Handler(netThread.getLooper());
        this.mPacRefreshIntent = PendingIntent.getBroadcast(context, 0, new Intent(ACTION_PAC_REFRESH), 67108864);
        context.registerReceiver(new PacRefreshIntentReceiver(this), new IntentFilter(ACTION_PAC_REFRESH));
    }

    private AlarmManager getAlarmManager() {
        if (this.mAlarmManager != null) goto L6;
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
    L6:
        return this.mAlarmManager;
    }

    public void addListener(IPacProxyInstalledListener listener) {
        PermissionUtils.enforceNetworkStackPermissionOr(this.mContext, new String[]{"android.permission.NETWORK_SETTINGS"});
        this.mCallbacks.register(listener);
    }

    public void removeListener(IPacProxyInstalledListener listener) {
        PermissionUtils.enforceNetworkStackPermissionOr(this.mContext, new String[]{"android.permission.NETWORK_SETTINGS"});
        this.mCallbacks.unregister(listener);
    }

    public void setCurrentProxyScriptUrl(ProxyInfo proxy) {
        PermissionUtils.enforceNetworkStackPermissionOr(this.mContext, new String[]{"android.permission.NETWORK_SETTINGS"});
        Object r0 = this.mBroadcastStateLock;
        monitor-enter(r0);
        if (proxy != null) goto L30;
    L16:
        getAlarmManager().cancel(this.mPacRefreshIntent);     // Catch: Throwable -> L13
        Object r1 = this.mProxyLock;     // Catch: Throwable -> L13
        monitor-enter(r1);     // Catch: Throwable -> L13
        this.mPacUrl = Uri.EMPTY;     // Catch: Throwable -> L21
        this.mCurrentPac = null;     // Catch: Throwable -> L21
        if (this.mProxyService == null) goto L23;
        unbind();     // Catch: Throwable -> L21
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L21
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L30:
        if (Uri.EMPTY.equals(proxy.getPacFileUrl()) == true) goto L16;
        if (proxy.getPacFileUrl().equals(this.mPacUrl) == true) goto L10;
    L15:
        this.mPacUrl = proxy.getPacFileUrl();     // Catch: Throwable -> L13
        this.mCurrentDelay = 0;     // Catch: Throwable -> L13
        this.mHasSentBroadcast = false;     // Catch: Throwable -> L13
        this.mHasDownloaded = false;     // Catch: Throwable -> L13
        getAlarmManager().cancel(this.mPacRefreshIntent);     // Catch: Throwable -> L13
        bind();     // Catch: Throwable -> L13
        goto L24
    L10:
        if (proxy.getPort() <= 0) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    private static String get(Uri pacUri) throws IOException {
        if (URLUtil.isValidUrl(pacUri.toString()) == false) goto L33;
        URL url = new URL(pacUri.toString());
        URLConnection urlConnection = url.openConnection(Proxy.NO_PROXY);     // Catch: UnsupportedOperationException -> L24 IllegalArgumentException -> L26
        long contentLength = -1;
        contentLength = Long.parseLong(urlConnection.getHeaderField("Content-Length"));     // Catch: NumberFormatException -> L9
    L11:
        if (contentLength > MAX_PAC_SIZE) goto L23;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
    L13:
        int count = urlConnection.getInputStream().read(buffer);
        if (count == (-1)) goto L21;
        bytes.write(buffer, 0, count);
        if (bytes.size() <= MAX_PAC_SIZE) goto L13;
        throw new IOException("PAC too big");
    L21:
        return bytes.toString();
    L23:
        throw new IOException("PAC too big: " + contentLength + " bytes");
    L31:
        throw new IOException("Incorrect proxy type for " + pacUri);
    L29:
        throw new IOException("Unsupported URL connection type for " + pacUri);
    L33:
        throw new IOException("Malformed URL:" + pacUri);
    }

    private int getNextDelay(int currentDelay) {
        int currentDelay2 = currentDelay + 1;
        if (currentDelay2 <= 3) goto L5;
        return 3;
    L5:
        return currentDelay2;
    }

    private void longSchedule() {
        this.mCurrentDelay = 0;
        setDownloadIn(4);
    }

    private void reschedule() {
        this.mCurrentDelay = getNextDelay(this.mCurrentDelay);
        setDownloadIn(this.mCurrentDelay);
    }

    private String getPacChangeDelay() {
        ContentResolver cr = this.mContext.getContentResolver();
        String defaultDelay = SystemProperties.get("conn.pac_change_delay", DEFAULT_DELAYS);
        String val = Settings.Global.getString(cr, "pac_change_delay");
        if (val != null) goto L6;
        return defaultDelay;
    L6:
        return val;
    }

    private long getDownloadDelay(int delayIndex) {
        String[] list = getPacChangeDelay().split(" ");
        if (delayIndex < list.length) goto L5;
        return 0;
    L5:
        return Long.parseLong(list[delayIndex]);
    }

    private void setDownloadIn(int delayIndex) {
        long delay = getDownloadDelay(delayIndex);
        long timeTillTrigger = (1000 * delay) + SystemClock.elapsedRealtime();
        getAlarmManager().set(3, timeTillTrigger, this.mPacRefreshIntent);
    }

    private void setCurrentProxyScript(String script) {
        if (this.mProxyService != null) goto L11;
        Log.e(TAG, "setCurrentProxyScript: no proxy service");
        return;
    L11:
        this.mProxyService.setPacFile(script);     // Catch: RemoteException -> L8
        this.mCurrentPac = script;     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "Unable to set PAC file", e);
    }

    private void bind() {
        if (this.mContext != null) goto L6;
        Log.e(TAG, "No context for binding");
        return;
    L6:
        Intent intent = new Intent();
        intent.setClassName(PAC_PACKAGE, PAC_SERVICE);
        if (this.mProxyConnection != null) goto L9;
    L12:
        this.mConnection = new AnonymousClass2(this);
        this.mContext.bindServiceAsUser(intent, this.mConnection, 1073741829, UserHandle.SYSTEM);
        Intent intent2 = new Intent();
        intent2.setClassName(PROXY_PACKAGE, PROXY_SERVICE);
        this.mProxyConnection = new AnonymousClass3(this);
        this.mContext.bindServiceAsUser(intent2, this.mProxyConnection, 1073741829, this.mNetThreadHandler, UserHandle.SYSTEM);
        return;
    L9:
        if (this.mConnection == null) goto L12;
        this.mNetThreadHandler.post(this.mPacDownloader);
    }

    private void unbind() {
        if (this.mConnection == null) goto L6;
        this.mContext.unbindService(this.mConnection);
        this.mConnection = null;
    L6:
        if (this.mProxyConnection == null) goto L8;
        this.mContext.unbindService(this.mProxyConnection);
        this.mProxyConnection = null;
    L8:
        this.mProxyService = null;
        this.mLastPort = -1;
    }

    private void sendPacBroadcast(ProxyInfo proxy) {
        int length = this.mCallbacks.beginBroadcast();
        int i = 0;
    L3:
        if (i >= length) goto L12;
        IPacProxyInstalledListener listener = this.mCallbacks.getBroadcastItem(i);
        if (listener == null) goto L11;
        listener.onPacProxyInstalled(null, proxy);     // Catch: RemoteException -> L9
    L11:
        i = i + 1;
        goto L3
    L12:
        this.mCallbacks.finishBroadcast();
    }

    private void sendProxyIfNeeded() {
        Object r0 = this.mBroadcastStateLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasDownloaded == false) goto L16;
        if (this.mLastPort == (-1)) goto L16;
        if (this.mHasSentBroadcast == true) goto L14;
        sendPacBroadcast(ProxyInfo.buildPacProxy(this.mPacUrl, this.mLastPort));     // Catch: Throwable -> L12
        this.mHasSentBroadcast = true;     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }
}
