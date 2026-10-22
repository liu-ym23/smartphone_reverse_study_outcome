package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public class a extends f {
        public a() {
        }

        @Override // androidx.work.f
        public e a(String r10) {
            return null;
        }
    }

    public f() {
    }

    public static f c() {
        return new a();
    }

    public abstract e a(String r10);

    public final e b(String r10) {
        e r11 = a(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return e.a(r10);
    }
}
