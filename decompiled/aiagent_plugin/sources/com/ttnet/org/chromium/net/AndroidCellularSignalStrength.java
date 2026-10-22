package com.ttnet.org.chromium.net;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class AndroidCellularSignalStrength {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AndroidCellularSignalStrength f37778b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f37779a;

    private class CellStateListener extends PhoneStateListener implements ApplicationStatus.c {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final TelephonyManager mTelephonyManager;
        final /* synthetic */ AndroidCellularSignalStrength this$0;

        static {
        }

        CellStateListener(AndroidCellularSignalStrength r3) {
            this.this$0 = r3;
            ThreadUtils.c();
            TelephonyManager r4 = (TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin");
            this.mTelephonyManager = r4;
            if (r4.getSimState() == 5) goto L5;
            return;
        L5:
            ApplicationStatus.a(this);
            onApplicationStateChange(ApplicationStatus.getStateForApplication());
        }

        private void register() {
            this.mTelephonyManager.listen(this, 256);
        }

        private void unregister() {
            AndroidCellularSignalStrength.a(this.this$0, Integer.MIN_VALUE);
            this.mTelephonyManager.listen(this, 0);
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength r3) {
            if (ApplicationStatus.getStateForApplication() == 1) goto L9;
            return;
        L9:
            AndroidCellularSignalStrength.a(this.this$0, r3.getLevel());     // Catch: SecurityException -> L7
            return;
        L7:
            AndroidCellularSignalStrength.a(this.this$0, Integer.MIN_VALUE);
        }

        @Override // com.ttnet.org.chromium.base.ApplicationStatus.c
        public void onApplicationStateChange(int r2) {
            if (r2 != 1) goto L6;
            register();
            return;
        L6:
            if (r2 != 2) goto L10;
            unregister();
            return;
        }
    }

    static /* synthetic */ int a(AndroidCellularSignalStrength r0, int r1) {
        r0.f37779a = r1;
        return r1;
    }

    static {
        f37778b = new AndroidCellularSignalStrength();
    }

    private AndroidCellularSignalStrength() {
        this.f37779a = Integer.MIN_VALUE;
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return;
    L6:
        if (x.a().b() == false) goto L8;
        return;
    L8:
        HandlerThread r0 = new HandlerThread("AndroidCellularSignalStrength");
        r0.start();
        new Handler(r0.getLooper()).post(new AnonymousClass1(this));
    }

    private static int getSignalStrengthLevel() {
        return f37778b.f37779a;
    }
}
