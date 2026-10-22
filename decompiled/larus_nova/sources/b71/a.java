package b71;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17899b;

    /* JADX INFO: renamed from: b71.a$a, reason: collision with other inner class name */
    public static final class C0274a extends a {
        public C0274a() {
            super(3);
        }
    }

    public static final class b extends a {
        public b() {
            super(1);
        }
    }

    public static final class c extends a {
        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "winnerId");
            super(2, r100);
        }
    }

    public /* synthetic */ a(int r100) {
        this(r100, "");
    }

    public a(int r100, String r101) {
        this.f17898a = r100;
        this.f17899b = r101;
    }
}
