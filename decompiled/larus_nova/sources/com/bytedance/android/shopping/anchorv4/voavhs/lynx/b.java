package com.bytedance.android.shopping.anchorv4.voavhs.lynx;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.lynx.tasm.LynxView;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f170012a;

    @Override // ti.k
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public b(a r100) {
        this.f170012a = r100;
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
        ComponentDTO r101 = this.f170012a.f169995f;
        if (r101 == null) goto L35;
        VO r102 = r101.getVo();
        if (r102 == null) goto L36;
        ConfigModel r103 = r102.getConfig();
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.getFontScale() != true) goto L38;
        ComponentDTO r104 = this.f170012a.f169995f;
        if (r104 == null) goto L17;
        VO r105 = r104.getVo();
        if (r105 == null) goto L17;
        ConfigModel r106 = r105.getConfig();
        if (r106 == null) goto L17;
        Float r107 = r106.getFontScaleMaxRatio();
    L18:
        if (r107 == null) goto L27;
        ComponentDTO r108 = this.f170012a.f169995f;
        if (r108 == null) goto L26;
        VO r109 = r108.getVo();
        if (r109 == null) goto L26;
        ConfigModel r110 = r109.getConfig();
        if (r110 == null) goto L26;
        Float r111 = r110.getFontScaleMaxRatio();
    L28:
        Lazy r112 = LargeFontModeUtil.f187028a;
        if ((r100 instanceof LynxView) == true) goto L31;
        r100 = null;
    L31:
        LynxView r113 = (LynxView) r100;
        if (r111 == null) goto L39;
        r111.floatValue();
        return;
    L39:
        return;
    L26:
        r111 = null;
        goto L28
    L27:
        r111 = Float.valueOf(LargeFontModeUtil.a());
    L17:
        r107 = null;
        goto L18
    L38:
        return;
    L36:
        return;
    }

    @Override // ti.k
    public final void onRuntimeReady(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
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
