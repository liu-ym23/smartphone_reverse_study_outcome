package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.bytedance.commerce.uikit.roundedlayout.RoundedFrameLayout;
import com.google.gson.JsonObject;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class FrameGroupViewElement<LP extends ViewGroup.LayoutParams> extends UIViewGroup<RoundedFrameLayout, LP, FrameLayout.LayoutParams, Object> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final vo.b<RoundedFrameLayout> f49274n = null;

    public static final class a {
    }

    static {
        f49274n = new vo.b(FrameGroupViewElement$Companion$groupMaker$1.INSTANCE);
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.k
    public final void e(View r100) {
        RoundedFrameLayout r101 = (RoundedFrameLayout) r100;
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        super.e(r101);
        float r102 = this.f49319c.f49309c;
        if (r102 <= 0) goto L5;
        r101.setRadius((int) r102);
    L5:
        Iterator r103 = this.f49287m.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        k r104 = (k) r103.next();
        View r105 = r104.d(r101.getContext(), false);
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r104.b(r104.f49319c);
        r104.a(null, r106, this.f49287m);
        r101.addView(r105, r106);
        goto L7
    }

    public FrameGroupViewElement(String r110, j r111, JsonObject r112, int r113, g<LP, Object> r114, List<? extends k<? extends View, FrameLayout.LayoutParams>> r115) {
        Intrinsics.checkNotNullParameter(r110, "uniqueId");
        Intrinsics.checkNotNullParameter(r111, "uiParam");
        Intrinsics.checkNotNullParameter(r114, "filler");
        Intrinsics.checkNotNullParameter(r115, "uiViewElements");
        super(r110, r113, r111, f49274n, r112, "frame_group", r114, r115);
    }
}
