package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f96578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f96579b;

    public static final class a extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p f96580c;

        public a(p r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("LINK", 3);
            this.f96580c = r100;
        }
    }

    public static final class b extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final s f96581c;

        public b(s r100) {
            Intrinsics.checkNotNullParameter(r100, "penalInfo");
            super("PENAL", 2);
            this.f96581c = r100;
        }
    }

    public static final class c extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final v f96582c;

        public c(v r100) {
            Intrinsics.checkNotNullParameter(r100, "pkInfo");
            super("PK", 1);
            this.f96582c = r100;
        }
    }

    public static final class d extends l {
        public d() {
            super("UNKNOWN", 0);
        }
    }

    public l(String r100, int r101) {
        this.f96578a = r100;
        this.f96579b = r101;
    }
}
