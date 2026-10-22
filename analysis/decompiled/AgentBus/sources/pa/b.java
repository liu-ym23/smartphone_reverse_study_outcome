package pa;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final b f8539f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f8540g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f8541h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f8542i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f8543j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ b[] f8544k;

    static {
        b bVar = new b("CPU_ACQUIRED", 0);
        f8539f = bVar;
        b bVar2 = new b("BLOCKING", 1);
        f8540g = bVar2;
        b bVar3 = new b("PARKING", 2);
        f8541h = bVar3;
        b bVar4 = new b("DORMANT", 3);
        f8542i = bVar4;
        b bVar5 = new b("TERMINATED", 4);
        f8543j = bVar5;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5};
        f8544k = bVarArr;
        e0.s(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f8544k.clone();
    }
}
