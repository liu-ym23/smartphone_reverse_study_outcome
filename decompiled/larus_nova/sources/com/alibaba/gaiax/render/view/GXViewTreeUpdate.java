package com.alibaba.gaiax.render.view;

import android.view.View;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.node.GXNode;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u.b;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0010¢\u0006\u0004\b\t\u0010\nJS\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0010¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/alibaba/gaiax/render/view/GXViewTreeUpdate;", "Lcom/alibaba/gaiax/render/view/GXViewTreeMerger;", "Landroid/view/View;", "Lcom/alibaba/gaiax/context/GXTemplateContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/alibaba/gaiax/render/node/GXNode;", "node", "Lu/b;", "layout", "withRootView$GaiaX", "(Lcom/alibaba/gaiax/context/GXTemplateContext;Lcom/alibaba/gaiax/render/node/GXNode;Lu/b;)Landroid/view/View;", "withRootView", "parentMergeView", "", "childType", "childViewType", "childNode", "childLayout", "", "mergeX", "mergeY", "withChildView$GaiaX", "(Lcom/alibaba/gaiax/context/GXTemplateContext;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/gaiax/render/node/GXNode;Lu/b;FF)Landroid/view/View;", "withChildView", "rootNode", "<init>", "(Lcom/alibaba/gaiax/context/GXTemplateContext;Lcom/alibaba/gaiax/render/node/GXNode;)V", "GaiaX"}, k = 1, mv = {1, 7, 1})
public class GXViewTreeUpdate extends GXViewTreeMerger<View> {
    public GXViewTreeUpdate(GXTemplateContext r100, GXNode r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootNode");
        super(r100, r101);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.gaiax.render.view.GXViewTreeMerger
    public View withRootView$GaiaX(GXTemplateContext r100, GXNode r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "node");
        Intrinsics.checkNotNullParameter(r102, "layout");
        View r103 = r101.getView();
        if (r103 == null) goto L5;
        GXViewLayoutParamsUtils.INSTANCE.updateLayoutParams(r103, r102, 0.0f, 0.0f);
        return r103;
    L5:
        return null;
    }

    @Override // com.alibaba.gaiax.render.view.GXViewTreeMerger
    public /* bridge */ /* synthetic */ View withRootView$GaiaX(GXTemplateContext r100, GXNode r101, b r102) {
        return withRootView$GaiaX(r100, r101, r102);
    }

    /* JADX INFO: renamed from: withChildView$GaiaX, reason: avoid collision after fix types in other method */
    public View withChildView$GaiaX2(GXTemplateContext r100, View r101, String r102, String r103, GXNode r104, b r105, float r106, float r107) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parentMergeView");
        Intrinsics.checkNotNullParameter(r102, "childType");
        Intrinsics.checkNotNullParameter(r104, "childNode");
        Intrinsics.checkNotNullParameter(r105, "childLayout");
        View r108 = r104.getView();
        if (r108 != null) goto L5;
        return null;
    L5:
        if (r104.isNeedShadow() == false) goto L10;
        View r109 = r104.getBoxLayoutView();
        if (r109 == null) goto L10;
        GXViewLayoutParamsUtils.INSTANCE.updateLayoutParams(r109, r105, r106, r107);
    L10:
        if (r104.isNeedLottie() == false) goto L14;
        View r110 = r104.getLottieView();
        if (r110 == null) goto L14;
        GXViewLayoutParamsUtils.INSTANCE.updateLayoutParams(r110, r105, r106, r107);
    L14:
        GXViewLayoutParamsUtils.INSTANCE.updateLayoutParams(r108, r105, r106, r107);
        return r108;
    }

    @Override // com.alibaba.gaiax.render.view.GXViewTreeMerger
    public /* bridge */ /* synthetic */ View withChildView$GaiaX(GXTemplateContext r100, View r101, String r102, String r103, GXNode r104, b r105, float r106, float r107) {
        return withChildView$GaiaX2(r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
