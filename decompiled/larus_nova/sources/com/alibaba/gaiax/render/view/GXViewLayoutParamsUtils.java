package com.alibaba.gaiax.render.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.alibaba.gaiax.render.node.GXNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u.b;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006J*\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/alibaba/gaiax/render/view/GXViewLayoutParamsUtils;", "", "Lcom/alibaba/gaiax/render/node/GXNode;", "data", "Lu/b;", "layout", "", "mergeX", "mergeY", "Landroid/widget/AbsoluteLayout$LayoutParams;", "createLayoutParams", "Landroid/view/View;", "view", "", "updateLayoutParams", "<init>", "()V", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final class GXViewLayoutParamsUtils {
    public static final GXViewLayoutParamsUtils INSTANCE = null;

    static {
        INSTANCE = new GXViewLayoutParamsUtils();
    }

    private GXViewLayoutParamsUtils() {
    }

    public final AbsoluteLayout.LayoutParams createLayoutParams(GXNode r100, b r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r101 == null) goto L6;
        return new AbsoluteLayout.LayoutParams((int) r101.f548085c, (int) r101.f548086d, ((int) r101.f548083a) + ((int) r102), ((int) r101.f548084b) + ((int) r103));
    L6:
        return new AbsoluteLayout.LayoutParams(-2, -2, 0, 0);
    }

    public final void updateLayoutParams(View r100, b r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "layout");
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        int r105 = (int) r101.f548085c;
        int r106 = (int) r101.f548086d;
        r104.width = r105;
        r104.height = r106;
        if ((r104 instanceof AbsoluteLayout.LayoutParams) == false) goto L5;
        AbsoluteLayout.LayoutParams r107 = (AbsoluteLayout.LayoutParams) r104;
        r107.x = ((int) r101.f548083a) + ((int) r102);
        r107.y = ((int) r101.f548084b) + ((int) r103);
    L5:
        r100.setLayoutParams(r104);
    }

    public static /* synthetic */ AbsoluteLayout.LayoutParams createLayoutParams$default(GXViewLayoutParamsUtils r100, GXNode r101, b r102, float r103, float r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = 0.0f;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r104 = 0.0f;
    L9:
        return r100.createLayoutParams(r101, r102, r103, r104);
    }

    public static /* synthetic */ void updateLayoutParams$default(GXViewLayoutParamsUtils r100, View r101, b r102, float r103, float r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = 0.0f;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = 0.0f;
    L8:
        r100.updateLayoutParams(r101, r102, r103, r104);
    }
}
