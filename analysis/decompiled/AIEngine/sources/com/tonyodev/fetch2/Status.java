package com.tonyodev.fetch2;

import com.stepos.core.download.ModelFlowMeta;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Status {

    /* renamed from: b, reason: collision with root package name */
    public static final a f8188b;

    /* renamed from: c, reason: collision with root package name */
    public static final Status f8189c;

    /* renamed from: d, reason: collision with root package name */
    public static final Status f8190d;

    /* renamed from: e, reason: collision with root package name */
    public static final Status f8191e;
    public static final Status h;

    /* renamed from: j, reason: collision with root package name */
    public static final Status f8192j;

    /* renamed from: k, reason: collision with root package name */
    public static final Status f8193k;

    /* renamed from: l, reason: collision with root package name */
    public static final Status f8194l;

    /* renamed from: m, reason: collision with root package name */
    public static final Status f8195m;

    /* renamed from: n, reason: collision with root package name */
    public static final Status f8196n;

    /* renamed from: o, reason: collision with root package name */
    public static final Status f8197o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ Status[] f8198p;

    /* renamed from: a, reason: collision with root package name */
    public final int f8199a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static Status a(int i10) {
            switch (i10) {
                case 0:
                    return Status.f8189c;
                case 1:
                    return Status.f8190d;
                case 2:
                    return Status.f8191e;
                case 3:
                    return Status.h;
                case 4:
                    return Status.f8192j;
                case 5:
                    return Status.f8193k;
                case 6:
                    return Status.f8194l;
                case 7:
                    return Status.f8195m;
                case 8:
                    return Status.f8196n;
                case 9:
                    return Status.f8197o;
                default:
                    return Status.f8189c;
            }
        }
    }

    static {
        Status status = new Status(ModelFlowMeta.PLAN_NONE, 0, 0);
        f8189c = status;
        Status status2 = new Status("QUEUED", 1, 1);
        f8190d = status2;
        Status status3 = new Status("DOWNLOADING", 2, 2);
        f8191e = status3;
        Status status4 = new Status("PAUSED", 3, 3);
        h = status4;
        Status status5 = new Status("COMPLETED", 4, 4);
        f8192j = status5;
        Status status6 = new Status("CANCELLED", 5, 5);
        f8193k = status6;
        Status status7 = new Status("FAILED", 6, 6);
        f8194l = status7;
        Status status8 = new Status("REMOVED", 7, 7);
        f8195m = status8;
        Status status9 = new Status("DELETED", 8, 8);
        f8196n = status9;
        Status status10 = new Status("ADDED", 9, 9);
        f8197o = status10;
        Status[] statusArr = {status, status2, status3, status4, status5, status6, status7, status8, status9, status10};
        f8198p = statusArr;
        kotlin.enums.a.a(statusArr);
        f8188b = new a();
    }

    public Status(String str, int i10, int i11) {
        this.f8199a = i11;
    }

    public static Status valueOf(String str) {
        return (Status) Enum.valueOf(Status.class, str);
    }

    public static Status[] values() {
        return (Status[]) f8198p.clone();
    }
}
