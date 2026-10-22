package com.android.ttcjpaysdk.base.utils;

import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J*\u0010\u0011\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayLargeScreenDecorObserver;", "", "()V", "hasObservedDecorLayoutChange", "", "lastDecorWidth", "", LynxViewpagerItem.BIND_ON_ATTACH, "", LiveEndPageData.TAG_WINDOW, "Landroid/view/Window;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "contentView", "Landroid/view/View;", "tag", "", "refresh", "reason", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLargeScreenDecorObserver {
    private boolean hasObservedDecorLayoutChange;
    private int lastDecorWidth;

    public CJPayLargeScreenDecorObserver() {
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayLargeScreenDecorObserver_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ int access$getLastDecorWidth$p(CJPayLargeScreenDecorObserver r100) {
        return r100.lastDecorWidth;
    }

    public static final /* synthetic */ void access$setLastDecorWidth$p(CJPayLargeScreenDecorObserver r100, int r101) {
        r100.lastDecorWidth = r101;
    }

    public final void attach(Window r100, final Context r101, final View r102, final String r103) {
        Intrinsics.checkNotNullParameter(r103, "tag");
        if (this.hasObservedDecorLayoutChange == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L21;
        View r104 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayLargeScreenDecorObserver_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100);
        if (r104 == null) goto L22;
        boolean r105 = true;
        this.hasObservedDecorLayoutChange = true;
        Integer r106 = Integer.valueOf(r104.getWidth());
        if (r106.intValue() > 0) goto L13;
        r105 = false;
    L13:
        if (r105 == true) goto L16;
        r106 = null;
    L16:
        if (r106 == null) goto L18;
        int r107 = r106.intValue();
    L19:
        this.lastDecorWidth = r107;
        r104.addOnLayoutChangeListener(new AnonymousClass2(this, r101, r102, r103));
        return;
    L18:
        r107 = this.lastDecorWidth;
        goto L19
    L22:
        return;
    }

    public final void refresh(Context r100, View r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "tag");
        Intrinsics.checkNotNullParameter(r103, "reason");
        CJPayLargeScreenUtils.applyCashierContentLayout(r100, r101, r102, r103);
    }
}
