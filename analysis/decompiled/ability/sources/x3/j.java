package x3;

/* loaded from: classes3.dex */
public final class j implements d {
    @Override // x3.d
    public final String a() {
        return "format.regex";
    }

    @Override // x3.d
    public final boolean b(u3.f fVar, G6.c cVar, String str) {
        if (str == null) {
            return true;
        }
        try {
            B3.c.a(str, cVar);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    @Override // x3.d
    public final String getName() {
        return "regex";
    }
}
