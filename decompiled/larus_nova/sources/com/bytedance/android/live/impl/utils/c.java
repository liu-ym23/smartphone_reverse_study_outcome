package com.bytedance.android.live.impl.utils;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f69321a = null;

    static {
        int[] r100 = new int[SharedPrefHelper.Type.values().length];
        f69321a = r100;
        r100[SharedPrefHelper.Type.STRING.ordinal()] = 1;
        r100[SharedPrefHelper.Type.INTEGER.ordinal()] = 2;
        r100[SharedPrefHelper.Type.BOOLEAN.ordinal()] = 3;
        r100[SharedPrefHelper.Type.FLOAT.ordinal()] = 4;
        r100[SharedPrefHelper.Type.LONG.ordinal()] = 5;
        r100[SharedPrefHelper.Type.STRING_SET.ordinal()] = 6;
        r100[SharedPrefHelper.Type.ALL.ordinal()] = 7;
    }
}
