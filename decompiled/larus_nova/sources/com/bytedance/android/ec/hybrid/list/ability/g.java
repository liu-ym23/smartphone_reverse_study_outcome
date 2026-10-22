package com.bytedance.android.ec.hybrid.list.ability;

import com.bytedance.android.ec.hybrid.list.entity.ECItemOperationType;
import com.bytedance.android.ec.hybrid.list.entity.ECSectionOperationType;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f46971a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f46972b = null;

    static {
        int[] r100 = new int[ECSectionOperationType.values().length];
        f46971a = r100;
        r100[ECSectionOperationType.DELETE_SECTION.ordinal()] = 1;
        r100[ECSectionOperationType.INSERT_SECTION.ordinal()] = 2;
        r100[ECSectionOperationType.APPEND_ITEM.ordinal()] = 3;
        int[] r101 = new int[ECItemOperationType.values().length];
        f46972b = r101;
        r101[ECItemOperationType.UPDATE.ordinal()] = 1;
        r101[ECItemOperationType.DELETE.ordinal()] = 2;
        r101[ECItemOperationType.INSERT.ordinal()] = 3;
        r101[ECItemOperationType.PATH_UPDATE.ordinal()] = 4;
    }
}
