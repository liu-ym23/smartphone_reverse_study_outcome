package com.bytedance.android.live.broadcastgame.xplay;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class m1 {

    public static final class a {
    }

    public static final class b extends m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f62276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f62277b;

        public final Long a() {
            return Long.valueOf(Long.valueOf(this.f62277b).longValue() - Long.valueOf(this.f62276a).longValue());
        }

        public b(e r100) {
            Intrinsics.checkNotNullParameter(r100, "prevState");
            long r101 = Long.valueOf(r100.f62282a).longValue();
            long r102 = System.currentTimeMillis();
            this.f62276a = r101;
            this.f62277b = r102;
        }
    }

    public static final class c extends m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f62278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f62279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f62280c;

        public c(e r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "prevState");
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            long r102 = Long.valueOf(r100.f62282a).longValue();
            long r103 = System.currentTimeMillis();
            this.f62278a = r102;
            this.f62279b = r103;
            this.f62280c = r101;
        }
    }

    public static final class d extends m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f62281a = null;

        static {
            f62281a = new d();
        }

        public d() {
        }
    }

    public static final class e extends m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f62282a;

        public e() {
            this.f62282a = System.currentTimeMillis();
        }
    }

    public static final class f extends m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f62283a = null;

        static {
            f62283a = new f();
        }

        public f() {
        }
    }

    static {
    }

    public m1() {
    }
}
