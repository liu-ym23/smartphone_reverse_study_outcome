package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f96554a;

    public static final class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.live.revlink.impl.pk.feedview.machine.c f96555b;

        public a(com.bytedance.android.live.revlink.impl.pk.feedview.machine.c r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("BattleOpen");
            this.f96555b = r100;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f96556b;

        public b(p r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("PenalTimeUpToLink");
            this.f96556b = r100;
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f96557b;

        public c(p r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("PkStandardEndToLink");
            this.f96557b = r100;
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.live.revlink.impl.pk.feedview.machine.b f96558b;

        public d(com.bytedance.android.live.revlink.impl.pk.feedview.machine.b r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("PkStandardEndToPenal");
            this.f96558b = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.feedview.machine.e$e, reason: collision with other inner class name */
    public static final class C1483e extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f96559b;

        public C1483e(p r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("PkTimeOutToLink");
            this.f96559b = r100;
        }
    }

    public static final class f extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x f96560b;

        public f(x r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("PkTimeOutToPenal");
            this.f96560b = r100;
        }
    }

    public static final class g extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f96561b;

        public g(p r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("QueryFailedBackToLink");
            this.f96561b = r100;
        }
    }

    public static final class h extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f96562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o f96563c;

        public h(p r100, o r101) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            Intrinsics.checkNotNullParameter(r101, "data");
            super("QueryReturnLink");
            this.f96562b = r100;
            this.f96563c = r101;
        }
    }

    public static final class i extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f96564b;

        public i(r r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("QueryReturnPenal");
            this.f96564b = r100;
        }
    }

    public static final class j extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u f96565b;

        public j(u r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("QueryReturnPk");
            this.f96565b = r100;
        }
    }

    public static final class k extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f96566b;

        public k(p r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("ResetToLinkPrepareReBattle");
            this.f96566b = r100;
        }
    }

    public static final class l extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f96567b;

        public l(p r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("SecKillToLink");
            this.f96567b = r100;
        }
    }

    public static final class m extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z f96568b;

        public m(z r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("SecKillToPenal");
            this.f96568b = r100;
        }
    }

    public e(String r100) {
        this.f96554a = r100;
    }
}
