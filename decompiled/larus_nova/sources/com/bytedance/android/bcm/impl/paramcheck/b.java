package com.bytedance.android.bcm.impl.paramcheck;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f41867a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f41868b = null;

    static {
        int[] r100 = new int[EnumTypeAdapterFactory.BasicType.values().length];
        f41867a = r100;
        EnumTypeAdapterFactory.BasicType r101 = EnumTypeAdapterFactory.BasicType.INT;
        r100[r101.ordinal()] = 1;
        EnumTypeAdapterFactory.BasicType r102 = EnumTypeAdapterFactory.BasicType.STRING;
        r100[r102.ordinal()] = 2;
        EnumTypeAdapterFactory.BasicType r103 = EnumTypeAdapterFactory.BasicType.LONG;
        r100[r103.ordinal()] = 3;
        EnumTypeAdapterFactory.BasicType r104 = EnumTypeAdapterFactory.BasicType.DOUBLE;
        r100[r104.ordinal()] = 4;
        EnumTypeAdapterFactory.BasicType r105 = EnumTypeAdapterFactory.BasicType.BOOLEAN;
        r100[r105.ordinal()] = 5;
        int[] r106 = new int[EnumTypeAdapterFactory.BasicType.values().length];
        f41868b = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r104.ordinal()] = 4;
        r106[r105.ordinal()] = 5;
    }
}
