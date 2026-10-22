package com.stepos.common.widget;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f2685c;

    /* renamed from: f, reason: collision with root package name */
    public static final f f2686f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f2687g;

    /* renamed from: h, reason: collision with root package name */
    public static final f f2688h;
    public static final /* synthetic */ f[] i;

    static {
        f fVar = new f("PROGRESS", 0);
        f2685c = fVar;
        f fVar2 = new f("IDLE", 1);
        f2686f = fVar2;
        f fVar3 = new f("COMPLETE", 2);
        f2687g = fVar3;
        f fVar4 = new f("ERROR", 3);
        f2688h = fVar4;
        i = new f[]{fVar, fVar2, fVar3, fVar4};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) i.clone();
    }
}
