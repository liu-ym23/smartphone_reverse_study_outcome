package com.bytedance.android.livesdk.vscore_api.paidlive;

import com.bytedance.android.livesdkapi.roomplayer.PaidLivePingV2Response;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f159445a;

    public static final class a extends j {
        public a() {
            super("Active");
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PaidLivePingV2Response f159446b;

        public b(String r100, PaidLivePingV2Response r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            super("AuthCheckOtherPurchase");
            this.f159446b = r101;
        }
    }

    public static final class c extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f159447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PaidLivePingV2Response f159448c;

        public c(String r100, String r101, PaidLivePingV2Response r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            super("AuthCheckPaidDelivery");
            this.f159447b = r101;
            this.f159448c = r102;
        }

        public /* synthetic */ c(String r100, String r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101, null);
        }
    }

    public static final class d extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f159449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PaidLivePingV2Response f159450c;

        public /* synthetic */ d(String r100) {
            this(r100, 0, null);
        }

        public d(String r100, int r101, PaidLivePingV2Response r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            super("AuthCheckPaidNoDelivery");
            this.f159449b = r101;
            this.f159450c = r102;
        }
    }

    public static final class e extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f159451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f159452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f159453d;

        public e(String r100, long r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            super("AuthCheckTempWatch");
            this.f159451b = r101;
            this.f159452c = r102;
            this.f159453d = true;
        }
    }

    public static final class f extends j {
        public f() {
            super("HideRefreshStreamMask");
        }
    }

    public static final class g extends j {
        public g() {
            super("InActive");
        }
    }

    public static final class h extends j {
        public h() {
            super("PaidLiveTypeChangeMsg");
        }
    }

    public static final class i extends j {
        public i() {
            super("PauseRoomPaidMachine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.vscore_api.paidlive.j$j, reason: collision with other inner class name */
    public static final class C2442j extends j {
        public C2442j() {
            super("RefreshStreamMaskFail");
        }
    }

    public static final class k extends j {
        public k() {
            super("StartDelivery");
        }
    }

    public static final class l extends j {
        public l() {
            super("StartTempWatch");
        }
    }

    public static final class m extends j {
        public m() {
            super("TempWatchOver");
        }
    }

    public static final class n extends j {
        public n() {
            super("TempWatchTimeUpdate");
        }
    }

    public final String toString() {
        return this.f159445a;
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f159445a = r100;
    }
}
