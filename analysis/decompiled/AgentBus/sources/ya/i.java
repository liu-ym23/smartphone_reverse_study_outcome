package ya;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: h, reason: collision with root package name */
    public static final i f11740h;

    /* renamed from: i, reason: collision with root package name */
    public static final i f11741i;

    /* renamed from: j, reason: collision with root package name */
    public static final i f11742j;

    /* renamed from: k, reason: collision with root package name */
    public static final i f11743k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ i[] f11744l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ j7.b f11745m;

    /* renamed from: f, reason: collision with root package name */
    public final char f11746f;

    /* renamed from: g, reason: collision with root package name */
    public final char f11747g;

    static {
        i iVar = new i("OBJ", 0, '{', '}');
        f11740h = iVar;
        i iVar2 = new i("LIST", 1, '[', ']');
        f11741i = iVar2;
        i iVar3 = new i("MAP", 2, '{', '}');
        f11742j = iVar3;
        i iVar4 = new i("POLY_OBJ", 3, '[', ']');
        f11743k = iVar4;
        i[] iVarArr = {iVar, iVar2, iVar3, iVar4};
        f11744l = iVarArr;
        f11745m = e0.s(iVarArr);
    }

    public i(String str, int i2, char c10, char c11) {
        this.f11746f = c10;
        this.f11747g = c11;
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f11744l.clone();
    }
}
