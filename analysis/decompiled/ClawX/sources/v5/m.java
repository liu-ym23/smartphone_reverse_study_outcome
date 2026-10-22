package v5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ m[] f5991a;

    static {
        m[] mVarArr = {new m("PUBLIC", 0), new m("PROTECTED", 1), new m("INTERNAL", 2), new m("PRIVATE", 3)};
        f5991a = mVarArr;
        a.a.F(mVarArr);
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f5991a.clone();
    }
}
