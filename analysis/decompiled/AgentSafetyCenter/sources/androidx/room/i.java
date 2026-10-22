package androidx.room;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public static final i f1544c;

    /* renamed from: f, reason: collision with root package name */
    public static final i f1545f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f1546g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ i[] f1547h;

    static {
        i iVar = new i("NO_OP", 0);
        f1544c = iVar;
        i iVar2 = new i("ADD", 1);
        f1545f = iVar2;
        i iVar3 = new i("REMOVE", 2);
        f1546g = iVar3;
        i[] iVarArr = {iVar, iVar2, iVar3};
        f1547h = iVarArr;
        a.a.p(iVarArr);
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f1547h.clone();
    }
}
