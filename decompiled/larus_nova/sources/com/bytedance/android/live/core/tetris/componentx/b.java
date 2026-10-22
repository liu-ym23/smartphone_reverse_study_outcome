package com.bytedance.android.live.core.tetris.componentx;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f65516a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f65517b = null;

    static {
        int[] r100 = new int[LayerIndex.values().length];
        f65516a = r100;
        LayerIndex r101 = LayerIndex.INDEX_SERVICE;
        r100[r101.ordinal()] = 1;
        LayerIndex r102 = LayerIndex.INDEX_XML;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[LayerIndex.values().length];
        f65517b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
