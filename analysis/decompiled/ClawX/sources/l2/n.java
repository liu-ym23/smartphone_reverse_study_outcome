package l2;

import java.security.SecureRandom;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final a2.b f3794a = new a2.b(5);

    public static byte[] a(int i8) {
        byte[] bArr = new byte[i8];
        ((SecureRandom) f3794a.get()).nextBytes(bArr);
        return bArr;
    }
}
