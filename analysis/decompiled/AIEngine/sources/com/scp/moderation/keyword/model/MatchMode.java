package com.scp.moderation.keyword.model;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MatchMode {

    /* renamed from: a, reason: collision with root package name */
    public static final MatchMode f5549a;

    /* renamed from: b, reason: collision with root package name */
    public static final MatchMode f5550b;

    /* renamed from: c, reason: collision with root package name */
    public static final MatchMode f5551c;

    /* renamed from: d, reason: collision with root package name */
    public static final MatchMode f5552d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ MatchMode[] f5553e;

    static {
        MatchMode matchMode = new MatchMode("CONTAINS", 0);
        f5549a = matchMode;
        MatchMode matchMode2 = new MatchMode("EXACT", 1);
        f5550b = matchMode2;
        MatchMode matchMode3 = new MatchMode("REGEX", 2);
        f5551c = matchMode3;
        MatchMode matchMode4 = new MatchMode("COMBINE", 3);
        f5552d = matchMode4;
        f5553e = new MatchMode[]{matchMode, matchMode2, matchMode3, matchMode4};
    }

    public MatchMode() {
        throw null;
    }

    public static MatchMode valueOf(String str) {
        return (MatchMode) Enum.valueOf(MatchMode.class, str);
    }

    public static MatchMode[] values() {
        return (MatchMode[]) f5553e.clone();
    }
}
