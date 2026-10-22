package com.bytedance.android.gamecp.base.core.service.depend;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/gamecp/base/core/service/depend/PackageType;", "", "", "value", "I", "getValue", "()I", "UnKnown", "OfficialPackage", "UnionPackage", "MutiChannelPackage", "SuperPackage", "OfficialBetaPackage", "MicroPackage", "BetaPackage", "OmniPackage", "OuterPackage", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PackageType extends Enum<PackageType> {
    public static final PackageType BetaPackage = null;
    public static final PackageType MicroPackage = null;
    public static final PackageType MutiChannelPackage = null;
    public static final PackageType OfficialBetaPackage = null;
    public static final PackageType OfficialPackage = null;
    public static final PackageType OmniPackage = null;
    public static final PackageType OuterPackage = null;
    public static final PackageType SuperPackage = null;
    public static final PackageType UnKnown = null;
    public static final PackageType UnionPackage = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PackageType[] f51405a = null;
    private final int value;

    public static PackageType valueOf(String r100) {
        return (PackageType) r27.a.a(PackageType.class, r100);
    }

    public static PackageType[] values() {
        return (PackageType[]) f51405a.clone();
    }

    static {
        PackageType r100 = new PackageType("UnKnown", 0, 0);
        UnKnown = r100;
        PackageType r101 = new PackageType("OfficialPackage", 1, 1);
        OfficialPackage = r101;
        PackageType r102 = new PackageType("UnionPackage", 2, 2);
        UnionPackage = r102;
        PackageType r103 = new PackageType("MutiChannelPackage", 3, 3);
        MutiChannelPackage = r103;
        PackageType r104 = new PackageType("SuperPackage", 4, 4);
        SuperPackage = r104;
        PackageType r105 = new PackageType("OfficialBetaPackage", 5, 5);
        OfficialBetaPackage = r105;
        PackageType r106 = new PackageType("MicroPackage", 6, 6);
        MicroPackage = r106;
        PackageType r107 = new PackageType("BetaPackage", 7, 7);
        BetaPackage = r107;
        PackageType r108 = new PackageType("OmniPackage", 8, 8);
        OmniPackage = r108;
        PackageType r109 = new PackageType("OuterPackage", 9, 9);
        OuterPackage = r109;
        f51405a = new PackageType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final int getValue() {
        return this.value;
    }

    public PackageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
