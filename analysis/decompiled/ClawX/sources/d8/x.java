package d8;

import java.util.HashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static final l1 f2205a;

    static {
        l1 l1Var = new l1("DNSSEC Digest Algorithm", 2);
        f2205a = l1Var;
        HashMap map = new HashMap(4);
        l1Var.f2066f = 255;
        l1Var.a(1, "SHA-1");
        map.put(1, 20);
        l1Var.a(2, "SHA-256");
        map.put(2, 32);
        l1Var.a(3, "GOST R 34.11-94");
        map.put(3, 32);
        l1Var.a(4, "SHA-384");
        map.put(4, 48);
        l1Var.a(5, "GOST12");
        map.put(5, 64);
        l1Var.a(6, "SM3");
        map.put(6, 32);
    }
}
