package d8;

import java.util.HashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class n4 {

    /* renamed from: a, reason: collision with root package name */
    public static final l1 f2096a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f2097b;

    static {
        l1 l1Var = new l1("ZONEMD Hash Algorithms", 2);
        f2096a = l1Var;
        HashMap map = new HashMap(2);
        f2097b = map;
        l1Var.f2066f = 255;
        l1Var.a(0, "RESERVED");
        l1Var.a(1, "SHA384");
        map.put(1, 48);
        l1Var.a(2, "SHA512");
        map.put(2, 64);
    }
}
