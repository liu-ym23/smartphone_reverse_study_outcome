package com.bytedance.android.livesdk.interactivity.square.common;

import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f141145a = null;

    static {
        int[] r100 = new int[IModelListDataManager.ModelChangeType.values().length];
        f141145a = r100;
        r100[IModelListDataManager.ModelChangeType.INIT_LIST.ordinal()] = 1;
        r100[IModelListDataManager.ModelChangeType.INSERT_BOTTOM.ordinal()] = 2;
        r100[IModelListDataManager.ModelChangeType.INSERT_ITEM.ordinal()] = 3;
        r100[IModelListDataManager.ModelChangeType.RELOAD_ALL.ordinal()] = 4;
        r100[IModelListDataManager.ModelChangeType.REMOVE_RANGE.ordinal()] = 5;
    }
}
