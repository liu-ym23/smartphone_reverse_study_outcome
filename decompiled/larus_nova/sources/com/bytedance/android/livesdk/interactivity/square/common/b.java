package com.bytedance.android.livesdk.interactivity.square.common;

import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f141129a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f141130b = null;

    static {
        int[] r100 = new int[BaseModelListScrollManager.ScrollState.values().length];
        f141129a = r100;
        r100[BaseModelListScrollManager.ScrollState.AutoScroll.ordinal()] = 1;
        r100[BaseModelListScrollManager.ScrollState.Focus.ordinal()] = 2;
        int[] r101 = new int[IModelListDataManager.ModelChangeType.values().length];
        f141130b = r101;
        r101[IModelListDataManager.ModelChangeType.INSERT_ITEM.ordinal()] = 1;
        r101[IModelListDataManager.ModelChangeType.REMOVE_RANGE.ordinal()] = 2;
    }
}
