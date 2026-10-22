package com.bytedance.android.live.util;

import com.bytedance.android.livehostapi.platform.UserSelection;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f102526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f102527b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f102528c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f102529d = null;

    static {
        int[] r100 = new int[UserSelection.values().length];
        f102526a = r100;
        UserSelection r101 = UserSelection.CONFIRM;
        r100[r101.ordinal()] = 1;
        UserSelection r102 = UserSelection.USE_DOUYIN;
        r100[r102.ordinal()] = 2;
        UserSelection r103 = UserSelection.CANCEL;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[UserSelection.values().length];
        f102527b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
        int[] r105 = new int[UserSelection.values().length];
        f102528c = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        int[] r106 = new int[UserSelection.values().length];
        f102529d = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
    }
}
