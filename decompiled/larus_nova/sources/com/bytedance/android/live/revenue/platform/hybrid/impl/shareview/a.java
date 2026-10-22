package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxView;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public class a implements com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f91443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zy0.b f91444b;

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public final void b() {
        if (this.f91444b.c().getParent() == null) goto L5;
        return;
    L5:
        Context r100 = getContext();
        if ((r100 instanceof Activity) == false) goto L18;
        jy0.b.d("HybridCardSharer", "attach sharer to decorView");
        View r101 = ((Activity) r100).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L12;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L12;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L12:
        if (r101 == null) goto L16;
        ((ViewGroup) r101).addView(this.f91444b.c(), new ViewGroup.LayoutParams(0, 0));
        this.f91444b.c().setAlpha(0.0f);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L18:
        throw new Error("context is not Activity");
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public final LynxView getLynxView() {
        xy0.a<?> r100 = this.f91444b.g();
        Intrinsics.checkNotNull(r100);
        View r101 = r100.getHybridView();
        if (r101 == null) goto L7;
        return (LynxView) r101;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public final boolean isValid() {
        return !this.f91444b.isDisposed();
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public void release() {
        UtilityKotlinExtentionsKt.q(this.f91444b.c());
        this.f91444b.dispose();
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public Context getContext() {
        return this.f91443a;
    }

    public a(zy0.b r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        this.f91444b = r100;
        this.f91443a = r100.c().getContext();
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f91444b.w().sendJsEvent(r100, r101);
    }
}
