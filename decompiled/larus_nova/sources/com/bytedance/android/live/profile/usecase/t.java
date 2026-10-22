package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.profile.p004enum.DressClickArea;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f87055a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f87056b = null;

    static {
        int[] r100 = new int[NewProfileTrackUseCase.LogProfileType.values().length];
        f87055a = r100;
        r100[NewProfileTrackUseCase.LogProfileType.POI_VIEW_CLK.ordinal()] = 1;
        int[] r101 = new int[DressClickArea.values().length];
        f87056b = r101;
        r101[DressClickArea.BorderRight.ordinal()] = 1;
        r101[DressClickArea.BorderLeft.ordinal()] = 2;
        r101[DressClickArea.Panel.ordinal()] = 3;
    }
}
