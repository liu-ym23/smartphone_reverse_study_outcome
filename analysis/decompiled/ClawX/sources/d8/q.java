package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final p f2118a;

    static {
        p pVar = new p("DClass", 2);
        pVar.f("CLASS");
        f2118a = pVar;
        pVar.a(1, "IN");
        pVar.a(3, "CH");
        pVar.b(3, "CHAOS");
        pVar.a(4, "HS");
        pVar.b(4, "HESIOD");
        pVar.a(254, "NONE");
        pVar.a(255, "ANY");
    }

    public static void a(int i8) {
        if (i8 < 0 || i8 > 65535) {
            throw new x0(a8.b.j(i8, "Invalid DNS class: "));
        }
    }
}
