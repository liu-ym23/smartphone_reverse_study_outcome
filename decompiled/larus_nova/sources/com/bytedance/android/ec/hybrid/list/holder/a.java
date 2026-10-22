package com.bytedance.android.ec.hybrid.list.holder;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxLoadType;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f47194a = null;

    static {
        int[] r100 = new int[ECLynxLoadType.values().length];
        f47194a = r100;
        r100[ECLynxLoadType.DEFAULT.ordinal()] = 1;
        r100[ECLynxLoadType.PRE_CREATE_VIEW.ordinal()] = 2;
        r100[ECLynxLoadType.PRE_LOAD.ordinal()] = 3;
    }
}
