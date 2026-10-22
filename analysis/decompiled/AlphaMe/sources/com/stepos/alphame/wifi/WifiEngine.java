package com.stepos.alphame.wifi;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.LocalConsts;
import com.stepos.alphame.utils.NetworkHelper;
import com.stepos.alphame.utils.ReceiverUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class WifiEngine extends EngineBase {
    private static final long MIN_DRUATION = 20000;
    protected static final String TAG = "WifiEngine";
    private static final long WIFI_CONNECTED_DELAY = 3000;

    @SuppressLint({"StaticFieldLeak"})
    private static WifiEngine sInstance;
    private Context mContext;
    private Handler mHandler;
    private OnWifiConnected mOnWifConnected;
    private OnWifiDisconnected mOnWifiDisconnected;
    private WifiManager mWifiManager;
    private String mCurrSSID = null;
    private String mCurrBSSID = null;
    private boolean mIsWifiOn = false;
    private List<Runnable> mWifiConnectedListeners = new ArrayList();
    private NetworkConnectChangedReceiver mNetworkConnectChangedReceiver = new NetworkConnectChangedReceiver();

    public class NetworkConnectChangedReceiver extends BroadcastReceiver {
        public NetworkConnectChangedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Parcelable parcelableExtra;
            AlphaMeLogger.debugLog(WifiEngine.TAG, "NetworkConnectChangedReceiver onReceive " + intent.getAction() + ", " + intent.getIntExtra("wifi_state", -1) + ", " + intent.getParcelableExtra("networkInfo"));
            String action = intent.getAction();
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("wifi_state", -1);
                if (intExtra == 1) {
                    WifiEngine.this.mIsWifiOn = false;
                } else if (intExtra == 3) {
                    WifiEngine.this.mIsWifiOn = true;
                }
            }
            if (!"android.net.wifi.STATE_CHANGE".equals(action) || (parcelableExtra = intent.getParcelableExtra("networkInfo")) == null || ((NetworkInfo) parcelableExtra).getState() == NetworkInfo.State.CONNECTING) {
                return;
            }
            Bundle wifiConnectionInfo = PerfBinderHelper.getWifiConnectionInfo();
            String string = wifiConnectionInfo.getString("WIFI_SSID");
            String string2 = wifiConnectionInfo.getString("WIFI_BSSID");
            AlphaMeLogger.debugLog(WifiEngine.TAG, "mCurrSSID = " + WifiEngine.this.mCurrSSID + ", ssid = " + string + ", bssid = " + string2);
            if ((string2 != null || WifiEngine.this.mCurrBSSID == null) && (string2 == null || string == null || string.equals(WifiEngine.this.mCurrSSID))) {
                return;
            }
            if (string2 == null) {
                WifiEngine.this.mOnWifiDisconnected.ssid = WifiEngine.this.mCurrSSID;
                WifiEngine.this.getHandler().removeCallbacks(WifiEngine.this.mOnWifConnected);
                WifiEngine.this.getHandler().postDelayed(WifiEngine.this.mOnWifiDisconnected, WifiEngine.MIN_DRUATION);
            } else if (string.equals(WifiEngine.this.mOnWifiDisconnected.ssid)) {
                WifiEngine.this.getHandler().removeCallbacks(WifiEngine.this.mOnWifiDisconnected);
            } else {
                ActionManager.getInstance().broadcast(LocalConsts.ACTION_WIFI_STATE_CHANGED, new String[]{String.valueOf(1), string, string2});
                WifiEngine.this.getHandler().postDelayed(WifiEngine.this.mOnWifConnected, 3000L);
            }
            WifiEngine.this.mCurrSSID = string;
            WifiEngine.this.mCurrBSSID = string2;
        }
    }

    public class OnWifiConnected implements Runnable {
        public /* synthetic */ OnWifiConnected(WifiEngine wifiEngine, int i4) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            AlphaMeLogger.dLog("onWifiConnected " + NetworkHelper.isConnectionAvailable(ApplicationImpl.getApplication()));
            Iterator it = WifiEngine.this.mWifiConnectedListeners.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        private OnWifiConnected() {
        }
    }

    public class OnWifiDisconnected implements Runnable {
        public String ssid;

        public /* synthetic */ OnWifiDisconnected(WifiEngine wifiEngine, int i4) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.ssid = null;
            ActionManager actionManager = ActionManager.getInstance();
            WifiEngine.this.isWifiOn();
            actionManager.broadcast(LocalConsts.ACTION_WIFI_STATE_CHANGED, new String[]{String.valueOf(0), null, null});
        }

        private OnWifiDisconnected() {
        }
    }

    private WifiEngine(Context context) {
        int i4 = 0;
        this.mOnWifiDisconnected = new OnWifiDisconnected(this, i4);
        this.mOnWifConnected = new OnWifiConnected(this, i4);
        this.mContext = context;
        this.mWifiManager = (WifiManager) this.mContext.getSystemService(AppSuggestStorable.COLUMN_WIFI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        return this.mHandler;
    }

    public static WifiEngine getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new WifiEngine(context);
        }
        return sInstance;
    }

    private static boolean isDataMigrationConfiguration(int i4, String str) {
        String wifiConfigCreatorName = PerfBinderHelper.getWifiConfigCreatorName(i4, str);
        AlphaMeLogger.dLog("isDataMigrationConfiguration creatorName" + wifiConfigCreatorName);
        return "com.stepos.datamigration".equals(wifiConfigCreatorName);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean wifiChannelInUsed(Context context) {
        boolean z4;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Network activeNetwork = connectivityManager.getActiveNetwork();
        AlphaMeLogger.dLog(" activeNetwork " + activeNetwork);
        if (activeNetwork != null) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(activeNetwork);
            String wifiSsid = PerfBinderHelper.getWifiSsid();
            AlphaMeLogger.dLog(" wifi ssid(ipc) " + wifiSsid);
            if (networkInfo != null && networkInfo.getType() == 1 && networkInfo.isConnectedOrConnecting() && wifiSsid != null && wifiSsid.contains("SOFTAP")) {
                Iterator<Bundle> it = PerfBinderHelper.getConfiguredWifiNetworks().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z4 = false;
                        break;
                    }
                    Bundle next = it.next();
                    String string = next.getString("ssid");
                    int i4 = next.getInt("networkId", -1);
                    if (TextUtils.equals(string, wifiSsid) && isDataMigrationConfiguration(i4, string)) {
                        AlphaMeLogger.dLog(" connectedconfig networkId=" + i4 + " ssid=" + string);
                        z4 = true;
                        break;
                    }
                }
                LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
                AlphaMeLogger.dLog(" linkProps " + linkProperties);
                if (linkProperties != null && z4 && linkProperties.getDnsServers() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addWifiConnectedListener(Runnable runnable) {
        if (this.mWifiConnectedListeners.contains(runnable)) {
            return;
        }
        this.mWifiConnectedListeners.add(runnable);
    }

    public boolean isWifiOn() {
        return this.mIsWifiOn;
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        ReceiverUtils.registerReceiverExported(this.mContext, this.mNetworkConnectChangedReceiver, intentFilter);
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        super.onStop();
        this.mContext.unregisterReceiver(this.mNetworkConnectChangedReceiver);
    }

    public void removeWifiConnectedListener(Runnable runnable) {
        if (this.mWifiConnectedListeners.contains(runnable)) {
            this.mWifiConnectedListeners.remove(runnable);
        }
    }

    public void scan() {
        List<ScanResult> scanResults;
        if (!this.mIsWifiOn || this.mCurrSSID != null || (scanResults = this.mWifiManager.getScanResults()) == null || scanResults.size() <= 0) {
            return;
        }
        ScanResult scanResult = scanResults.get(0);
        for (ScanResult scanResult2 : scanResults) {
            if (scanResult2.level > scanResult.level) {
                scanResult = scanResult2;
            }
        }
        this.mCurrSSID = scanResult.BSSID;
        ActionManager.getInstance().broadcast(LocalConsts.ACTION_WIFI_STATE_CHANGED, new String[]{String.valueOf(0), scanResult.SSID, this.mCurrSSID});
    }
}
