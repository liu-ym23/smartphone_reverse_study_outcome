package com.android.server.emergency;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.SystemService;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EmergencyAffordanceService extends SystemService {
    private static final boolean DBG = false;
    private static final String EMERGENCY_AFFORDANCE_OVERRIDE_ISO = "emergency_affordance_override_iso";
    private static final int INITIALIZE_STATE = 1;
    private static final int NETWORK_COUNTRY_CHANGED = 2;
    private static final String SERVICE_NAME = "emergency_affordance";
    private static final int SUBSCRIPTION_CHANGED = 3;
    private static final String TAG = "EmergencyAffordanceService";
    private static final int UPDATE_AIRPLANE_MODE_STATUS = 4;
    private boolean mAirplaneModeEnabled;
    private boolean mAnyNetworkNeedsEmergencyAffordance;
    private boolean mAnySimNeedsEmergencyAffordance;
    private BroadcastReceiver mBroadcastReceiver;
    private final Context mContext;
    private boolean mEmergencyAffordanceNeeded;
    private final ArrayList<String> mEmergencyCallCountryIsos;
    private MyHandler mHandler;
    private SubscriptionManager.OnSubscriptionsChangedListener mSubscriptionChangedListener;
    private SubscriptionManager mSubscriptionManager;
    private TelephonyManager mTelephonyManager;
    private boolean mVoiceCapable;

    private final class BinderService extends Binder {
        final /* synthetic */ EmergencyAffordanceService this$0;

        /* synthetic */ BinderService(EmergencyAffordanceService r1, EmergencyAffordanceServiceIA r2) {
            this(r1);
        }

        private BinderService(EmergencyAffordanceService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.Binder
        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(EmergencyAffordanceService.m4218$$Nest$fgetmContext(this.this$0), EmergencyAffordanceService.TAG, pw) == true) goto L5;
            return;
        L5:
            EmergencyAffordanceService.m4220$$Nest$mdumpInternal(this.this$0, new IndentingPrintWriter(pw, "  "));
        }
    }

    private class MyHandler extends Handler {
        final /* synthetic */ EmergencyAffordanceService this$0;

        public MyHandler(EmergencyAffordanceService r1, Looper l) {
            this.this$0 = r1;
            super(l);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L8;
                case 2: goto L7;
                case 3: goto L6;
                case 4: goto L5;
                default: goto L4;
            };
        L4:
            Slog.e(EmergencyAffordanceService.TAG, "Unexpected message received: " + msg.what);
            return;
        L5:
            EmergencyAffordanceService.m4223$$Nest$mhandleUpdateAirplaneModeStatus(this.this$0);
            return;
        L6:
            EmergencyAffordanceService.m4224$$Nest$mhandleUpdateSimSubscriptionInfo(this.this$0);
            return;
        L7:
            String countryIso = (String) msg.obj;
            int slotId = msg.arg1;
            EmergencyAffordanceService.m4222$$Nest$mhandleNetworkCountryChanged(this.this$0, countryIso, slotId);
            return;
        L8:
            EmergencyAffordanceService.m4221$$Nest$mhandleInitializeState(this.this$0);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m4218$$Nest$fgetmContext(EmergencyAffordanceService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ MyHandler m4219$$Nest$fgetmHandler(EmergencyAffordanceService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4220$$Nest$mdumpInternal(EmergencyAffordanceService r0, IndentingPrintWriter r1) {
        r0.dumpInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleInitializeState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4221$$Nest$mhandleInitializeState(EmergencyAffordanceService r0) {
        r0.handleInitializeState();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNetworkCountryChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4222$$Nest$mhandleNetworkCountryChanged(EmergencyAffordanceService r0, String r1, int r2) {
        r0.handleNetworkCountryChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUpdateAirplaneModeStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4223$$Nest$mhandleUpdateAirplaneModeStatus(EmergencyAffordanceService r0) {
        r0.handleUpdateAirplaneModeStatus();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUpdateSimSubscriptionInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4224$$Nest$mhandleUpdateSimSubscriptionInfo(EmergencyAffordanceService r0) {
        r0.handleUpdateSimSubscriptionInfo();
    }

    public EmergencyAffordanceService(Context context) {
        super(context);
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mSubscriptionChangedListener = new AnonymousClass2(this);
        this.mContext = context;
        String[] isos = context.getResources().getStringArray(R.array.config_halfFoldedDeviceStates);
        this.mEmergencyCallCountryIsos = new ArrayList(isos.length);
        int r1 = isos.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        String iso = isos[r2];
        this.mEmergencyCallCountryIsos.add(iso);
        r2 = r2 + 1;
        goto L3
    L6:
        if (Build.IS_DEBUGGABLE == false) goto L12;
        String overrideIso = Settings.Global.getString(this.mContext.getContentResolver(), EMERGENCY_AFFORDANCE_OVERRIDE_ISO);
        if (TextUtils.isEmpty(overrideIso) == true) goto L13;
        this.mEmergencyCallCountryIsos.clear();
        this.mEmergencyCallCountryIsos.add(overrideIso);
        return;
    L13:
        return;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService(SERVICE_NAME, new BinderService(this, null));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 600) goto L6;
        handleThirdPartyBootPhase();
        return;
    }

    private void handleInitializeState() {
        handleUpdateAirplaneModeStatus();
        handleUpdateSimSubscriptionInfo();
        updateNetworkCountry();
        updateEmergencyAffordanceNeeded();
    }

    private void handleThirdPartyBootPhase() {
        this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        this.mVoiceCapable = this.mTelephonyManager.isVoiceCapable();
        if (this.mVoiceCapable == true) goto L6;
        updateEmergencyAffordanceNeeded();
        return;
    L6:
        HandlerThread thread = new HandlerThread(TAG);
        thread.start();
        this.mHandler = new MyHandler(this, thread.getLooper());
        this.mSubscriptionManager = SubscriptionManager.from(this.mContext);
        this.mSubscriptionManager.addOnSubscriptionsChangedListener(this.mSubscriptionChangedListener);
        IntentFilter filter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        filter.addAction("android.telephony.action.NETWORK_COUNTRY_CHANGED");
        this.mContext.registerReceiver(this.mBroadcastReceiver, filter);
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    private void handleUpdateAirplaneModeStatus() {
        boolean r2 = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) != 1) goto L5;
        r2 = true;
    L5:
        this.mAirplaneModeEnabled = r2;
    }

    private void handleUpdateSimSubscriptionInfo() {
        List<SubscriptionInfo> activeSubscriptionInfoList = this.mSubscriptionManager.getActiveSubscriptionInfoList();
        if (activeSubscriptionInfoList != null) goto L5;
        return;
    L5:
        boolean needsAffordance = false;
        Iterator<SubscriptionInfo> r2 = activeSubscriptionInfoList.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        SubscriptionInfo info = r2.next();
        if (isoRequiresEmergencyAffordance(info.getCountryIso()) == false) goto L7;
        needsAffordance = true;
    L12:
        this.mAnySimNeedsEmergencyAffordance = needsAffordance;
        updateEmergencyAffordanceNeeded();
    }

    private void handleNetworkCountryChanged(String countryIso, int slotId) {
        if (TextUtils.isEmpty(countryIso) == true) goto L5;
    L8:
        updateNetworkCountry();
        updateEmergencyAffordanceNeeded();
        return;
    L5:
        if (this.mAirplaneModeEnabled == false) goto L8;
        Slog.w(TAG, "Ignore empty countryIso report when APM is on.");
    }

    private void updateNetworkCountry() {
        boolean needsAffordance = false;
        int activeModems = this.mTelephonyManager.getActiveModemCount();
        int i = 0;
    L3:
        if (i >= activeModems) goto L8;
        String countryIso = this.mTelephonyManager.getNetworkCountryIso(i);
        if (isoRequiresEmergencyAffordance(countryIso) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        needsAffordance = true;
    L8:
        this.mAnyNetworkNeedsEmergencyAffordance = needsAffordance;
        updateEmergencyAffordanceNeeded();
    }

    private boolean isoRequiresEmergencyAffordance(String iso) {
        return this.mEmergencyCallCountryIsos.contains(iso);
    }

    private void updateEmergencyAffordanceNeeded() {
        boolean r0 = this.mEmergencyAffordanceNeeded;
        if (this.mVoiceCapable == true) goto L5;
    L9:
        boolean r1 = false;
    L10:
        this.mEmergencyAffordanceNeeded = r1;
        if (r0 == this.mEmergencyAffordanceNeeded) goto L14;
        Settings.Global.putInt(this.mContext.getContentResolver(), "emergency_affordance_needed", this.mEmergencyAffordanceNeeded ? 1 : 0);
        return;
    L14:
        return;
    L5:
        if (this.mAnySimNeedsEmergencyAffordance == false) goto L7;
    L8:
        r1 = true;
        goto L10
    L7:
        if (this.mAnyNetworkNeedsEmergencyAffordance == false) goto L9;
        goto L8
    }

    private void dumpInternal(IndentingPrintWriter ipw) {
        ipw.println("EmergencyAffordanceService (dumpsys emergency_affordance) state:\n");
        ipw.println("mEmergencyAffordanceNeeded=" + this.mEmergencyAffordanceNeeded);
        ipw.println("mVoiceCapable=" + this.mVoiceCapable);
        ipw.println("mAnySimNeedsEmergencyAffordance=" + this.mAnySimNeedsEmergencyAffordance);
        ipw.println("mAnyNetworkNeedsEmergencyAffordance=" + this.mAnyNetworkNeedsEmergencyAffordance);
        ipw.println("mEmergencyCallCountryIsos=" + String.join(",", this.mEmergencyCallCountryIsos));
    }
}
