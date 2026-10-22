package vf;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends uf.a {

    /* JADX INFO: renamed from: vf.a$a, reason: collision with other inner class name */
    public static final class C0397a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0397a f25231a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f25232b = null;

        static {
            f25231a = new C0397a();
            Integer r10 = null;
            Object r11 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);     // Catch: Throwable -> L14
            if ((r11 instanceof Integer) == false) goto L7;
            Integer r12 = (Integer) r11;     // Catch: Throwable -> L14
        L8:
            if (r12 != null) goto L10;
        L12:
            f25232b = r10;
            return;
        L10:
            if (r12.intValue() <= 0) goto L12;
            r10 = r12;
        L7:
            r12 = null;
            goto L8
        }

        public C0397a() {
        }
    }

    public a() {
    }

    private final boolean d(int r10) {
        Integer r11 = C0397a.f25232b;
        if (r11 != null) goto L5;
    L8:
        return true;
    L5:
        if (r11.intValue() >= r10) goto L8;
        return false;
    }

    @Override // uf.a
    public void a(Throwable r10, Throwable r11) {
        q.g(r10, "cause");
        q.g(r11, "exception");
        if (d(19) == false) goto L5;
        r10.addSuppressed(r11);
        return;
    L5:
        super.a(r10, r11);
    }
}
