package androidx.activity;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class SystemBarStyle {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f158e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1 f162d;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ SystemBarStyle b(Companion r10, int r11, int r12, Function1 r13, int r14, Object r15) {
            if ((r14 & 4) == 0) goto L6;
            r13 = SystemBarStyle$Companion$auto$1.INSTANCE;
        L6:
            return r10.a(r11, r12, r13);
        }

        public final SystemBarStyle a(int r10, int r11, Function1 r12) {
            kotlin.jvm.internal.q.g(r12, "detectDarkMode");
            return new SystemBarStyle(r10, r11, 0, r12, null);
        }

        public Companion() {
        }
    }

    static {
        f158e = new Companion(null);
    }

    public /* synthetic */ SystemBarStyle(int r10, int r11, int r12, Function1 r13, DefaultConstructorMarker r14) {
        this(r10, r11, r12, r13);
    }

    public final Function1 a() {
        return this.f162d;
    }

    public final int b() {
        return this.f161c;
    }

    public final int c(boolean r10) {
        if (this.f161c != 0) goto L5;
        return 0;
    L5:
        if (r10 == false) goto L8;
        return this.f160b;
    L8:
        return this.f159a;
    }

    public SystemBarStyle(int r10, int r11, int r12, Function1 r13) {
        this.f159a = r10;
        this.f160b = r11;
        this.f161c = r12;
        this.f162d = r13;
    }
}
