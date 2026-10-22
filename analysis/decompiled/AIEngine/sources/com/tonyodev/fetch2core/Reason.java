package com.tonyodev.fetch2core;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Reason {

    /* renamed from: a, reason: collision with root package name */
    public static final Reason f8218a;

    /* renamed from: b, reason: collision with root package name */
    public static final Reason f8219b;

    /* renamed from: c, reason: collision with root package name */
    public static final Reason f8220c;

    /* renamed from: d, reason: collision with root package name */
    public static final Reason f8221d;

    /* renamed from: e, reason: collision with root package name */
    public static final Reason f8222e;
    public static final Reason h;

    /* renamed from: j, reason: collision with root package name */
    public static final Reason f8223j;

    /* renamed from: k, reason: collision with root package name */
    public static final Reason f8224k;

    /* renamed from: l, reason: collision with root package name */
    public static final Reason f8225l;

    /* renamed from: m, reason: collision with root package name */
    public static final Reason f8226m;

    /* renamed from: n, reason: collision with root package name */
    public static final Reason f8227n;

    /* renamed from: o, reason: collision with root package name */
    public static final Reason f8228o;

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ Reason[] f8229p;

    static {
        Reason reason = new Reason("NOT_SPECIFIED", 0);
        Reason reason2 = new Reason("DOWNLOAD_ADDED", 1);
        f8218a = reason2;
        Reason reason3 = new Reason("DOWNLOAD_QUEUED", 2);
        f8219b = reason3;
        Reason reason4 = new Reason("DOWNLOAD_STARTED", 3);
        f8220c = reason4;
        Reason reason5 = new Reason("DOWNLOAD_WAITING_ON_NETWORK", 4);
        f8221d = reason5;
        Reason reason6 = new Reason("DOWNLOAD_PROGRESS_CHANGED", 5);
        f8222e = reason6;
        Reason reason7 = new Reason("DOWNLOAD_COMPLETED", 6);
        h = reason7;
        Reason reason8 = new Reason("DOWNLOAD_ERROR", 7);
        f8223j = reason8;
        Reason reason9 = new Reason("DOWNLOAD_PAUSED", 8);
        f8224k = reason9;
        Reason reason10 = new Reason("DOWNLOAD_RESUMED", 9);
        f8225l = reason10;
        Reason reason11 = new Reason("DOWNLOAD_CANCELLED", 10);
        f8226m = reason11;
        Reason reason12 = new Reason("DOWNLOAD_REMOVED", 11);
        Reason reason13 = new Reason("DOWNLOAD_DELETED", 12);
        f8227n = reason13;
        Reason reason14 = new Reason("DOWNLOAD_BLOCK_UPDATED", 13);
        f8228o = reason14;
        Reason[] reasonArr = {reason, reason2, reason3, reason4, reason5, reason6, reason7, reason8, reason9, reason10, reason11, reason12, reason13, reason14, new Reason("OBSERVER_ATTACHED", 14), new Reason("REPORTING", 15)};
        f8229p = reasonArr;
        kotlin.enums.a.a(reasonArr);
    }

    public Reason() {
        throw null;
    }

    public static Reason valueOf(String str) {
        return (Reason) Enum.valueOf(Reason.class, str);
    }

    public static Reason[] values() {
        return (Reason[]) f8229p.clone();
    }
}
