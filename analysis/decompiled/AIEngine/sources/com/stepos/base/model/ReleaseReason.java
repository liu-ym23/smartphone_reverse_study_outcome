package com.stepos.base.model;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ReleaseReason {

    /* renamed from: b, reason: collision with root package name */
    public static final ReleaseReason f6338b;

    /* renamed from: c, reason: collision with root package name */
    public static final ReleaseReason f6339c;

    /* renamed from: d, reason: collision with root package name */
    public static final ReleaseReason f6340d;

    /* renamed from: e, reason: collision with root package name */
    public static final ReleaseReason f6341e;
    public static final /* synthetic */ ReleaseReason[] h;

    /* renamed from: a, reason: collision with root package name */
    public final int f6342a;

    static {
        ReleaseReason releaseReason = new ReleaseReason("CLIENT_RELEASE", 0, 0);
        f6338b = releaseReason;
        ReleaseReason releaseReason2 = new ReleaseReason("PRESSURE_NORMAL", 1, 1);
        f6339c = releaseReason2;
        ReleaseReason releaseReason3 = new ReleaseReason("PRESSURE_LOW", 2, 2);
        f6340d = releaseReason3;
        ReleaseReason releaseReason4 = new ReleaseReason("PRESSURE_ULTRA_LOW", 3, 3);
        f6341e = releaseReason4;
        ReleaseReason[] releaseReasonArr = {releaseReason, releaseReason2, releaseReason3, releaseReason4};
        h = releaseReasonArr;
        kotlin.enums.a.a(releaseReasonArr);
    }

    public ReleaseReason(String str, int i10, int i11) {
        this.f6342a = i11;
    }

    public static ReleaseReason valueOf(String str) {
        return (ReleaseReason) Enum.valueOf(ReleaseReason.class, str);
    }

    public static ReleaseReason[] values() {
        return (ReleaseReason[]) h.clone();
    }
}
