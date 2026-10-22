package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f21583a = null;

    static {
        f21583a = new b0("CLOSED");
    }

    public static final /* synthetic */ b0 a() {
        return f21583a;
    }

    public static final e b(e r10) {
    L2:
        Object r11 = e.a(r10);
        if (r11 == a()) goto L4;
        e r12 = (e) r11;
        if (r12 == null) goto L8;
        r10 = r12;
        goto L2
    L8:
        if (r10.j() == false) goto L2;
        return r10;
    L4:
        return r10;
    }

    public static final Object c(y r10, long r11, Function2 r12) {
    L3:
        if (r10.f21630c >= r11) goto L5;
    L9:
        Object r13 = e.a(r10);
        if (r13 == a()) goto L12;
        y r14 = (y) ((e) r13);
        if (r14 != null) goto L15;
        r14 = (y) r12.mo0invoke(Long.valueOf(r10.f21630c + 1), r10);
        if (r10.l(r14) == false) goto L3;
        if (r10.h() == false) goto L15;
        r10.k();
    L15:
        r10 = r14;
        goto L3
    L12:
        return z.a(f21583a);
    L5:
        if (r10.h() == true) goto L9;
        return z.a(r10);
    }
}
