package ba6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class h {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18417a;

        public a() {
            Intrinsics.checkNotNullParameter("main tree is null", "reason");
            this.f18417a = "main tree is null";
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f18418a = null;

        static {
            f18418a = new b();
        }

        public b() {
        }
    }

    public h() {
    }
}
