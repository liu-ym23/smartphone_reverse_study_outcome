package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f129484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f129485b = null;

    static {
        int[] r100 = new int[DataSource.ScaleType.values().length];
        f129484a = r100;
        DataSource.ScaleType r101 = DataSource.ScaleType.ScaleAspectFitCenter;
        r100[r101.ordinal()] = 1;
        DataSource.ScaleType r102 = DataSource.ScaleType.TopFit;
        r100[r102.ordinal()] = 2;
        DataSource.ScaleType r103 = DataSource.ScaleType.BottomFit;
        r100[r103.ordinal()] = 3;
        DataSource.ScaleType r104 = DataSource.ScaleType.LeftFit;
        r100[r104.ordinal()] = 4;
        DataSource.ScaleType r105 = DataSource.ScaleType.RightFit;
        r100[r105.ordinal()] = 5;
        int[] r106 = new int[DataSource.ScaleType.values().length];
        f129485b = r106;
        r106[DataSource.ScaleType.ScaleToFill.ordinal()] = 1;
        r106[DataSource.ScaleType.ScaleAspectFill.ordinal()] = 2;
        r106[DataSource.ScaleType.TopFill.ordinal()] = 3;
        r106[DataSource.ScaleType.BottomFill.ordinal()] = 4;
        r106[DataSource.ScaleType.LeftFill.ordinal()] = 5;
        r106[DataSource.ScaleType.RightFill.ordinal()] = 6;
        r106[r101.ordinal()] = 7;
        r106[r102.ordinal()] = 8;
        r106[r103.ordinal()] = 9;
        r106[r104.ordinal()] = 10;
        r106[r105.ordinal()] = 11;
    }
}
