package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.view.View;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f167871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f167872b;

    @Override // ti.k
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    @Override // ti.k
    public final void onFirstScreen(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onLoadSuccess(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        if (this.f167872b == false) goto L9;
        Lazy r101 = LargeFontModeUtil.f187028a;
        if ((r100 instanceof LynxView) == true) goto L7;
        r100 = null;
    L7:
        LynxView r102 = (LynxView) r100;
        return;
    }

    @Override // ti.k
    public final void onRuntimeReady(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    public b(Map r100, boolean r101) {
        this.f167871a = r100;
        this.f167872b = r101;
    }

    @Override // ti.k
    public final void g(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // ti.k
    public final void onLoadFailed(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onPageStart(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void s(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }
}
