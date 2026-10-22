package x5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: b, reason: collision with root package name */
    public static final m f6302b;

    /* renamed from: c, reason: collision with root package name */
    public static final m f6303c;
    public static final m d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ m[] f6304e;

    /* renamed from: a, reason: collision with root package name */
    public final int f6305a;

    static {
        m mVar = new m("IGNORE_CASE", 0, 2);
        f6302b = mVar;
        m mVar2 = new m("MULTILINE", 1, 8);
        f6303c = mVar2;
        m mVar3 = new m("LITERAL", 2, 16);
        m mVar4 = new m("UNIX_LINES", 3, 1);
        m mVar5 = new m("COMMENTS", 4, 4);
        m mVar6 = new m("DOT_MATCHES_ALL", 5, 32);
        d = mVar6;
        m[] mVarArr = {mVar, mVar2, mVar3, mVar4, mVar5, mVar6, new m("CANON_EQ", 6, 128)};
        f6304e = mVarArr;
        a.a.F(mVarArr);
    }

    public m(String str, int i8, int i9) {
        this.f6305a = i9;
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f6304e.clone();
    }
}
