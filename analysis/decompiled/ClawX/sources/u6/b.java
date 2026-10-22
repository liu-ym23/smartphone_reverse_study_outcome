package u6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final y f5670b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f5671c;
    public static final b d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f5672e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f5673f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f5674g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f5675h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ b[] f5676j;

    /* renamed from: a, reason: collision with root package name */
    public final int f5677a;

    static {
        b bVar = new b("NO_ERROR", 0, 0);
        f5671c = bVar;
        b bVar2 = new b("PROTOCOL_ERROR", 1, 1);
        d = bVar2;
        b bVar3 = new b("INTERNAL_ERROR", 2, 2);
        f5672e = bVar3;
        b bVar4 = new b("FLOW_CONTROL_ERROR", 3, 3);
        f5673f = bVar4;
        b bVar5 = new b("SETTINGS_TIMEOUT", 4, 4);
        b bVar6 = new b("STREAM_CLOSED", 5, 5);
        b bVar7 = new b("FRAME_SIZE_ERROR", 6, 6);
        b bVar8 = new b("REFUSED_STREAM", 7, 7);
        f5674g = bVar8;
        b bVar9 = new b("CANCEL", 8, 8);
        f5675h = bVar9;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9, new b("COMPRESSION_ERROR", 9, 9), new b("CONNECT_ERROR", 10, 10), new b("ENHANCE_YOUR_CALM", 11, 11), new b("INADEQUATE_SECURITY", 12, 12), new b("HTTP_1_1_REQUIRED", 13, 13)};
        f5676j = bVarArr;
        a.a.F(bVarArr);
        f5670b = new y();
    }

    public b(String str, int i8, int i9) {
        this.f5677a = i9;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f5676j.clone();
    }
}
