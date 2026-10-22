package ga;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: g, reason: collision with root package name */
    public static final j f4027g;

    /* renamed from: h, reason: collision with root package name */
    public static final j f4028h;

    /* renamed from: i, reason: collision with root package name */
    public static final j f4029i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ j[] f4030j;

    /* renamed from: f, reason: collision with root package name */
    public final int f4031f;

    static {
        j jVar = new j("IGNORE_CASE", 0, 2);
        f4027g = jVar;
        j jVar2 = new j("MULTILINE", 1, 8);
        f4028h = jVar2;
        j jVar3 = new j("LITERAL", 2, 16);
        j jVar4 = new j("UNIX_LINES", 3, 1);
        j jVar5 = new j("COMMENTS", 4, 4);
        j jVar6 = new j("DOT_MATCHES_ALL", 5, 32);
        f4029i = jVar6;
        j[] jVarArr = {jVar, jVar2, jVar3, jVar4, jVar5, jVar6, new j("CANON_EQ", 6, 128)};
        f4030j = jVarArr;
        e0.s(jVarArr);
    }

    public j(String str, int i2, int i10) {
        this.f4031f = i10;
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f4030j.clone();
    }
}
