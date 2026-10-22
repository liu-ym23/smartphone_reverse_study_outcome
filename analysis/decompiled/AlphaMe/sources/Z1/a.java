package Z1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class a extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2159a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f2159a) {
            case 0:
                try {
                    return MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                    throw new IllegalStateException("no md5 algorythm found");
                }
            default:
                return new char[8192];
        }
    }
}
