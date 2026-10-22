package com.stepos.common.widget;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f11967a;

    /* renamed from: b, reason: collision with root package name */
    public static final t f11968b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ t[] f11969c;

    static {
        t tVar = new t("PRAISED", 0);
        f11967a = tVar;
        t tVar2 = new t("CANCEL", 1);
        f11968b = tVar2;
        f11969c = new t[]{tVar, tVar2};
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f11969c.clone();
    }
}
