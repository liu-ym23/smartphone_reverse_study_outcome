package com.alibaba.gaiax.render.view;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.node.GXNode;
import com.alibaba.gaiax.render.node.GXTemplateNode;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u.b;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0005¢\u0006\u0004\b)\u0010*J5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u000f\u001a\u00020\u000eJ)\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\tH ¢\u0006\u0004\b\u0012\u0010\u0013JS\u0010 \u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH ¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010!\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/alibaba/gaiax/render/view/GXViewTreeMerger;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/alibaba/gaiax/context/GXTemplateContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/alibaba/gaiax/render/node/GXNode;", "parentNode", "parentView", "", "Lu/b;", "parentMerges", "", "createMergedViewTree", "(Lcom/alibaba/gaiax/context/GXTemplateContext;Lcom/alibaba/gaiax/render/node/GXNode;Ljava/lang/Object;Ljava/util/List;)V", "Landroid/view/View;", "build", "node", "layout", "withRootView$GaiaX", "(Lcom/alibaba/gaiax/context/GXTemplateContext;Lcom/alibaba/gaiax/render/node/GXNode;Lu/b;)Ljava/lang/Object;", "withRootView", "parentMergeView", "", "childType", "childViewType", "childNode", "childLayout", "", "mergeX", "mergeY", "withChildView$GaiaX", "(Lcom/alibaba/gaiax/context/GXTemplateContext;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/gaiax/render/node/GXNode;Lu/b;FF)Ljava/lang/Object;", "withChildView", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "getGxTemplateContext", "()Lcom/alibaba/gaiax/context/GXTemplateContext;", "rootNode", "Lcom/alibaba/gaiax/render/node/GXNode;", "getRootNode", "()Lcom/alibaba/gaiax/render/node/GXNode;", "<init>", "(Lcom/alibaba/gaiax/context/GXTemplateContext;Lcom/alibaba/gaiax/render/node/GXNode;)V", "GaiaX"}, k = 1, mv = {1, 7, 1})
public abstract class GXViewTreeMerger<T> {
    private final GXTemplateContext gxTemplateContext;
    private final GXNode rootNode;

    public abstract T withChildView$GaiaX(GXTemplateContext r100, T r101, String r102, String r103, GXNode r104, b r105, float r106, float r107);

    public abstract T withRootView$GaiaX(GXTemplateContext r100, GXNode r101, b r102);

    public final View build() {
        b r100 = this.rootNode.getStretchNode().getLayoutByBind();
        if (r100 != null) goto L9;
        r100 = this.rootNode.getStretchNode().getLayoutByCreate();
        if (r100 != null) goto L9;
        throw new IllegalArgumentException("Stretch layout info is null gxTemplateContext = " + this.gxTemplateContext);
    L9:
        T r101 = withRootView$GaiaX(this.gxTemplateContext, this.rootNode, r100);
        if (r101 == null) goto L17;
        ArrayList r102 = new ArrayList();
        r102.add(r100);
        createMergedViewTree(this.gxTemplateContext, this.rootNode, r101, r102);
        View r103 = this.rootNode.getView();
        if (r103 == null) goto L15;
        return r103;
    L15:
        throw new IllegalArgumentException("Create root view error, not found root view gxTemplateContext = " + this.gxTemplateContext);
    L17:
        throw new IllegalArgumentException("Create root view error gxTemplateContext = " + this.gxTemplateContext);
    }

    public final GXTemplateContext getGxTemplateContext() {
        return this.gxTemplateContext;
    }

    public final GXNode getRootNode() {
        return this.rootNode;
    }

    public GXViewTreeMerger(GXTemplateContext r100, GXNode r101) {
        Intrinsics.checkNotNullParameter(r100, "gxTemplateContext");
        Intrinsics.checkNotNullParameter(r101, "rootNode");
        this.gxTemplateContext = r100;
        this.rootNode = r101;
    }

    private final void createMergedViewTree(GXTemplateContext r210, GXNode r211, T r212, List<b> r310) {
        List<GXNode> r100 = r211.getChildren();
        if (r100 == null) goto L52;
        Iterator<T> r110 = r100.iterator();
    L6:
        if (r110.hasNext() == false) goto L61;
        GXNode r111 = (GXNode) r110.next();
        GXTemplateNode r101 = r111.getTemplateNode();
        b r102 = r111.getStretchNode().getLayoutByBind();
        if (r102 != null) goto L14;
        r102 = r111.getStretchNode().getLayoutByCreate();
        if (r102 != null) goto L14;
        throw new IllegalArgumentException("Stretch layout info is null");
    L14:
        b r112 = r102;
        String r103 = r101.getLayer().getNodeType();
        String r104 = r101.getLayer().getCustomNodeClass();
        boolean r113 = r101.isCanBeMergedType();
        boolean r114 = false;
        if (r113 == true) goto L17;
    L31:
        boolean r105 = false;
    L32:
        if (r105 == false) goto L34;
        List<b> r106 = new ArrayList();
        r106.addAll(r310);
        r106.add(r112);
        createMergedViewTree(r210, r111, r212, r106);
        Iterator<T> r213 = r110;
    L49:
        r110 = r213;
        goto L6
    L34:
        Iterator<T> r107 = r310.iterator();
        float r115 = 0.0f;
        float r116 = 0.0f;
    L36:
        if (r107.hasNext() == false) goto L38;
        b r108 = (b) r107.next();
        r115 = r115 + r108.f548083a;
        r116 = r116 + r108.f548084b;
        goto L36
    L38:
        r213 = r110;
        T r109 = withChildView$GaiaX(r210, r212, r103, r104, r111, r112, r115, r116);
        if (r109 == null) goto L51;
        List<GXNode> r117 = r111.getChildren();
        if (r117 != null) goto L43;
    L45:
        if (r114 == false) goto L49;
        if (r113 == false) goto L48;
        List<b> r118 = new ArrayList();
        float r119 = r112.f548083a;
        float r120 = r112.f548084b;
        float r121 = r112.f548085c;
        float r122 = r112.f548086d;
        List<b> r123 = r112.f548087e;
        String r124 = r112.f548088f;
        String r125 = r112.f548089g;
        Intrinsics.checkNotNullParameter(r123, "children");
        Intrinsics.checkNotNullParameter(r124, "id");
        Intrinsics.checkNotNullParameter(r125, "idPath");
        b r126 = new b(r119, r120, r121, r122, r123, r124, r125);
        r126.f548083a = 0.0f;
        r126.f548084b = 0.0f;
        r118.add(r126);
        createMergedViewTree(r210, r111, r109, r118);
        goto L49
    L48:
        List<b> r127 = new ArrayList();
        r127.addAll(r310);
        createMergedViewTree(r210, r111, r212, r127);
        goto L49
    L43:
        if ((!r117.isEmpty()) != true) goto L45;
        r114 = true;
        goto L45
    L51:
        throw new IllegalArgumentException("Create child view error");
    L17:
        if (r101.getCss().getStyle().isEmptyStyle() == false) goto L31;
        if (r101.getVisualTemplateNode() == null) goto L23;
        if (r101.getVisualTemplateNode().getCss().getStyle().isEmptyStyle() == false) goto L31;
    L23:
        if (r101.getAnimationBinding() != null) goto L31;
        if (r101.getEventBinding() != null) goto L31;
        if (r101.getDataBinding() != null) goto L31;
        if (r101.getTrackBinding() != null) goto L31;
        r105 = true;
        goto L32
    L61:
        return;
    }
}
