package com.bytedance.android.shopping.store.hybridproduct;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f184934a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f184935b = null;

    static {
        int[] r100 = new int[LoadStatus.values().length];
        f184934a = r100;
        r100[LoadStatus.Initialize.ordinal()] = 1;
        r100[LoadStatus.InitializeSuccess.ordinal()] = 2;
        r100[LoadStatus.InitializeError.ordinal()] = 3;
        r100[LoadStatus.InitializeEmpty.ordinal()] = 4;
        int[] r101 = new int[Lifecycle.Event.values().length];
        f184935b = r101;
        r101[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
        r101[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
        r101[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
    }
}
