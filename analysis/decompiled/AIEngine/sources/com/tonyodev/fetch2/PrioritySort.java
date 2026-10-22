package com.tonyodev.fetch2;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PrioritySort {

    /* renamed from: a, reason: collision with root package name */
    public static final PrioritySort f8184a;

    /* renamed from: b, reason: collision with root package name */
    public static final PrioritySort f8185b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ PrioritySort[] f8186c;

    static {
        PrioritySort prioritySort = new PrioritySort("ASC", 0);
        f8184a = prioritySort;
        PrioritySort prioritySort2 = new PrioritySort("DESC", 1);
        f8185b = prioritySort2;
        PrioritySort[] prioritySortArr = {prioritySort, prioritySort2};
        f8186c = prioritySortArr;
        a.a(prioritySortArr);
    }

    public PrioritySort() {
        throw null;
    }

    public static PrioritySort valueOf(String str) {
        return (PrioritySort) Enum.valueOf(PrioritySort.class, str);
    }

    public static PrioritySort[] values() {
        return (PrioritySort[]) f8186c.clone();
    }
}
