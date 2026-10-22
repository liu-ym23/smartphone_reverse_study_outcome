package com.bytedance.android.live.effect.beauty;

import com.bytedance.android.live.effect.template.BeautifyTemplate;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f67213a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f67214b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f67215c = null;

    static {
        int[] r100 = new int[BeautifyTemplate.BeautifyContentType.values().length];
        f67213a = r100;
        BeautifyTemplate.BeautifyContentType r101 = BeautifyTemplate.BeautifyContentType.BEAUTY;
        r100[r101.ordinal()] = 1;
        BeautifyTemplate.BeautifyContentType r102 = BeautifyTemplate.BeautifyContentType.MAKEUPS;
        r100[r102.ordinal()] = 2;
        BeautifyTemplate.BeautifyContentType r103 = BeautifyTemplate.BeautifyContentType.FILTER;
        r100[r103.ordinal()] = 3;
        BeautifyTemplate.BeautifyContentType r104 = BeautifyTemplate.BeautifyContentType.AV_ADJUST;
        r100[r104.ordinal()] = 4;
        BeautifyTemplate.BeautifyContentType r105 = BeautifyTemplate.BeautifyContentType.BODY_BEAUTY;
        r100[r105.ordinal()] = 5;
        int[] r106 = new int[BeautifyTemplate.BeautifyContentType.values().length];
        f67214b = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r104.ordinal()] = 4;
        r106[r105.ordinal()] = 5;
        r106[BeautifyTemplate.BeautifyContentType.PRESETS.ordinal()] = 6;
        int[] r107 = new int[BeautifyTemplate.BeautifyContentType.values().length];
        f67215c = r107;
        r107[r104.ordinal()] = 1;
    }
}
