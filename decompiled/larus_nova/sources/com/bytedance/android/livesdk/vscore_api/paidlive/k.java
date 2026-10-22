package com.bytedance.android.livesdk.vscore_api.paidlive;

import com.bytedance.android.livesdkapi.roomplayer.PaidLivePingV2Response;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f159454a;

    public static final class a extends k {
        public a() {
            super("ChangeToPrivilegeClarity");
        }
    }

    public static final class b extends k {
        public b() {
            super("DoDelivery");
        }
    }

    public static final class c extends k {
        public c() {
            super("DoPauseRoomWatching");
        }
    }

    public static final class d extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f159455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f159456c;

        public d(long r100, int r101) {
            super("DoServiceTimeCountDownUpdate");
            this.f159455b = r100;
            this.f159456c = r101;
        }
    }

    public static final class e extends k {
        public e() {
            super("DoStartTempWatch");
        }
    }

    public static final class f extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f159457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PaidLivePingV2Response f159458c;

        public f() {
            this(null, null);
        }

        public f(String r100, PaidLivePingV2Response r101) {
            super("DoStopTempWatch");
            this.f159457b = r100;
            this.f159458c = r101;
        }
    }

    public static final class g extends k {
        public g() {
            super("DoTimeCountDownUpdate");
        }
    }

    public static final class h extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PaidLivePingV2Response f159459b;

        public h() {
            this(null);
        }

        public h(PaidLivePingV2Response r100) {
            super("HideTempWatchEndView");
            this.f159459b = r100;
        }
    }

    public static final class i extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final i f159460b = null;

        static {
            f159460b = new i();
        }

        public i() {
            super("None");
        }
    }

    public static final class j extends k {
        public j() {
            super("RefreshPaidLiveType");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.vscore_api.paidlive.k$k, reason: collision with other inner class name */
    public static final class C2443k extends k {
        public C2443k() {
            super("Reset");
        }
    }

    public static final class l extends k {
        public l() {
            super("ReturnToOriginClarity");
        }
    }

    public static final class m extends k {
        public m() {
            super("ShowTempWatchEndView");
        }
    }

    public final String toString() {
        return this.f159454a;
    }

    public k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f159454a = r100;
    }
}
