package com.bytedance.android.live.profit.fansclub;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.f7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f7.b f87281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f87282b;

        public a(f7.b r100, int r101) {
            this.f87281a = r100;
            this.f87282b = r101;
        }
    }

    public static class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IBaseUser f87283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f87284b;

        public /* synthetic */ b() {
            throw null;
        }

        public b(IBaseUser r100, Long r101) {
            Intrinsics.checkNotNullParameter(r100, "user");
            this.f87283a = r100;
            this.f87284b = r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.fansclub.c$c, reason: collision with other inner class name */
    public static final class C1333c extends b {
        public C1333c(IBaseUser r100, Long r101) {
            Intrinsics.checkNotNullParameter(r100, "user");
            super(r100, r101);
        }
    }

    public static final class d extends b {
        public d(IBaseUser r100, Long r101) {
            Intrinsics.checkNotNullParameter(r100, "user");
            super(r100, r101);
        }
    }

    public static final class e extends b {
        public e(IBaseUser r100) {
            Intrinsics.checkNotNullParameter(r100, "user");
            super(r100, null);
        }
    }

    public static final class f extends b {
        public f(IBaseUser r100) {
            Intrinsics.checkNotNullParameter(r100, "user");
            super(r100, null);
        }
    }

    public static final class g extends b {
        public g(IBaseUser r100) {
            Intrinsics.checkNotNullParameter(r100, "user");
            super(r100, null);
        }
    }

    public static final class h extends b {
        public h(IBaseUser r100) {
            Intrinsics.checkNotNullParameter(r100, "user");
            super(r100, null);
        }
    }

    public c() {
    }
}
