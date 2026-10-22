package com.stepos.base.model;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ReleasePriority {

    /* renamed from: a, reason: collision with root package name */
    public static final ReleasePriority f6335a;

    /* renamed from: b, reason: collision with root package name */
    public static final ReleasePriority f6336b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ReleasePriority[] f6337c;

    static {
        ReleasePriority releasePriority = new ReleasePriority("PINNED", 0);
        f6335a = releasePriority;
        ReleasePriority releasePriority2 = new ReleasePriority("NORMAL", 1);
        f6336b = releasePriority2;
        ReleasePriority[] releasePriorityArr = {releasePriority, releasePriority2, new ReleasePriority("LOW", 2)};
        f6337c = releasePriorityArr;
        kotlin.enums.a.a(releasePriorityArr);
    }

    public ReleasePriority() {
        throw null;
    }

    public static ReleasePriority valueOf(String str) {
        return (ReleasePriority) Enum.valueOf(ReleasePriority.class, str);
    }

    public static ReleasePriority[] values() {
        return (ReleasePriority[]) f6337c.clone();
    }
}
