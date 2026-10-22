package com.tonyodev.fetch2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Priority {

    /* renamed from: b, reason: collision with root package name */
    public static final a f8179b;

    /* renamed from: c, reason: collision with root package name */
    public static final Priority f8180c;

    /* renamed from: d, reason: collision with root package name */
    public static final Priority f8181d;

    /* renamed from: e, reason: collision with root package name */
    public static final Priority f8182e;
    public static final /* synthetic */ Priority[] h;

    /* renamed from: a, reason: collision with root package name */
    public final int f8183a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static Priority a(int i10) {
            return i10 != -1 ? i10 != 0 ? i10 != 1 ? Priority.f8181d : Priority.f8180c : Priority.f8181d : Priority.f8182e;
        }
    }

    static {
        Priority priority = new Priority("HIGH", 0, 1);
        f8180c = priority;
        Priority priority2 = new Priority("NORMAL", 1, 0);
        f8181d = priority2;
        Priority priority3 = new Priority("LOW", 2, -1);
        f8182e = priority3;
        Priority[] priorityArr = {priority, priority2, priority3};
        h = priorityArr;
        kotlin.enums.a.a(priorityArr);
        f8179b = new a();
    }

    public Priority(String str, int i10, int i11) {
        this.f8183a = i11;
    }

    public static Priority valueOf(String str) {
        return (Priority) Enum.valueOf(Priority.class, str);
    }

    public static Priority[] values() {
        return (Priority[]) h.clone();
    }
}
