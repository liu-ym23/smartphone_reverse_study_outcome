package com.ttnet.org.chromium.net;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("net::android")
public class AndroidCellularSignalStrength {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AndroidCellularSignalStrength f18354b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f18355a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidCellularSignalStrength f18356a;

        public a(AndroidCellularSignalStrength r10) {
            this.f18356a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            new b(this.f18356a);
        }
    }

    public class b extends PhoneStateListener implements ApplicationStatus.ApplicationStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TelephonyManager f18357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AndroidCellularSignalStrength f18358b;

        static {
        }

        public b(AndroidCellularSignalStrength r10) {
            this.f18358b = r10;
            ThreadUtils.a();
            TelephonyManager r11 = (TelephonyManager) com.ttnet.org.chromium.base.e.d().getSystemService("phone");
            this.f18357a = r11;
            if (r11.getSimState() == 5) goto L5;
            return;
        L5:
            ApplicationStatus.d(this);
            onApplicationStateChange(ApplicationStatus.getStateForApplication());
        }

        private void a() {
            this.f18357a.listen(this, 256);
        }

        private void b() {
            AndroidCellularSignalStrength.a(this.f18358b, Integer.MIN_VALUE);
            this.f18357a.listen(this, 0);
        }

        @Override // com.ttnet.org.chromium.base.ApplicationStatus.ApplicationStateListener
        public void onApplicationStateChange(int r10) {
            if (r10 != 1) goto L6;
            a();
            return;
        L6:
            if (r10 != 2) goto L10;
            b();
            return;
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength r10) {
            if (ApplicationStatus.getStateForApplication() == 1) goto L9;
            return;
        L9:
            AndroidCellularSignalStrength.a(this.f18358b, r10.getLevel());     // Catch: SecurityException -> L7
            return;
        L7:
            AndroidCellularSignalStrength.a(this.f18358b, Integer.MIN_VALUE);
        }
    }

    static {
        f18354b = new AndroidCellularSignalStrength();
    }

    public AndroidCellularSignalStrength() {
        this.f18355a = Integer.MIN_VALUE;
        HandlerThread r10 = new HandlerThread("AndroidCellularSignalStrength");
        r10.start();
        new Handler(r10.getLooper()).post(new a(this));
    }

    public static /* synthetic */ int a(AndroidCellularSignalStrength r10, int r11) {
        r10.f18355a = r11;
        return r11;
    }

    @CalledByNative
    @TargetApi(23)
    private static int getSignalStrengthLevel() {
        return f18354b.f18355a;
    }
}
