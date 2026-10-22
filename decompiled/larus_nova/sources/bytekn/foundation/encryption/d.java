package bytekn.foundation.encryption;

/* JADX INFO: loaded from: classes28.dex */
public final class d {
    public static final byte[] a(byte[] r100) {
        c r101 = MD5.f21751k.f21748a.invoke();
        r101.update(r100, 0, r100.length);
        return r101.e();
    }
}
