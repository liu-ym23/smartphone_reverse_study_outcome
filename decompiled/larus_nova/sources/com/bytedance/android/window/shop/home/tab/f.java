package com.bytedance.android.window.shop.home.tab;

import com.bytedance.android.ec.window.base.SyncType;
import com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f188741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f188742b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f188743c = null;

    static {
        int[] r100 = new int[WindowTabEventReporter.EventType.values().length];
        f188741a = r100;
        r100[WindowTabEventReporter.EventType.SHOW.ordinal()] = 1;
        r100[WindowTabEventReporter.EventType.CLICK.ordinal()] = 2;
        int[] r101 = new int[ClickSeparatedTabSelectListener.ActionType.values().length];
        f188742b = r101;
        r101[ClickSeparatedTabSelectListener.ActionType.SCROLL.ordinal()] = 1;
        r101[ClickSeparatedTabSelectListener.ActionType.CLICK.ordinal()] = 2;
        int[] r102 = new int[SyncType.values().length];
        f188743c = r102;
        r102[SyncType.HISTORY_PRODUCT.ordinal()] = 1;
        r102[SyncType.STORE_PRODUCT.ordinal()] = 2;
    }
}
