package com.bytedance.android.live.xplay.basic;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class r {

    public static final class a {
    }

    public static final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f102861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f102862b;

        public final Long a() {
            return Long.valueOf(Long.valueOf(this.f102862b).longValue() - Long.valueOf(this.f102861a).longValue());
        }

        public b(e r100) {
            Intrinsics.checkNotNullParameter(r100, "prevState");
            long r101 = Long.valueOf(r100.f102867a).longValue();
            long r102 = System.currentTimeMillis();
            this.f102861a = r101;
            this.f102862b = r102;
        }
    }

    public static final class c extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f102863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f102864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f102865c;

        public c(e r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "prevState");
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            long r102 = Long.valueOf(r100.f102867a).longValue();
            long r103 = System.currentTimeMillis();
            this.f102863a = r102;
            this.f102864b = r103;
            this.f102865c = r101;
        }
    }

    public static final class d extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f102866a = null;

        static {
            f102866a = new d();
        }

        public d() {
        }
    }

    public static final class e extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f102867a;

        public e() {
            this.f102867a = System.currentTimeMillis();
        }
    }

    public static final class f extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f102868a = null;

        static {
            f102868a = new f();
        }

        public f() {
        }
    }

    static {
    }

    public r() {
    }
}
