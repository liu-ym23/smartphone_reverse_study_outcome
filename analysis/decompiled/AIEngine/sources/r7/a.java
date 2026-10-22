package r7;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f11756a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /* renamed from: b, reason: collision with root package name */
    public static final C0132a f11757b = new C0132a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: r7.a$a, reason: collision with other inner class name */
    public class C0132a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        public final Object initialValue() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("no md5 algorythm found");
            }
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 : bArr) {
            if (i10 < 0) {
                i10 += 256;
            }
            StringBuilder sb2 = new StringBuilder();
            String[] strArr = f11756a;
            sb2.append(strArr[i10 / 16]);
            sb2.append(strArr[i10 % 16]);
            stringBuffer.append(sb2.toString());
        }
        return stringBuffer.toString();
    }
}
