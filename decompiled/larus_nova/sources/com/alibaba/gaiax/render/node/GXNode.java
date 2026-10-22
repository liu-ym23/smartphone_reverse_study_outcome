package com.alibaba.gaiax.render.node;

import android.animation.AnimatorSet;
import android.view.KeyEvent;
import android.view.View;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.view.GXIRelease;
import com.alibaba.gaiax.template.GXLayer;
import com.alibaba.gaiax.template.GXTemplateItem;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alibaba.gaiax.template.animation.GXAnimationBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bv\u0010wJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\fJ\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\fJ\u0006\u0010\u0019\u001a\u00020\fJ\u0006\u0010\u001a\u001a\u00020\fJ\u0018\u0010\u001e\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\tH\u0016J\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b3\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00109\u001a\u0004\b?\u0010;\"\u0004\b\u001e\u0010=R\"\u0010@\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u00104\u001a\u0004\b@\u00105\"\u0004\bA\u00107R\"\u0010B\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00104\u001a\u0004\bB\u00105\"\u0004\bC\u00107R$\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010K\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010F\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR$\u0010N\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010F\u001a\u0004\bO\u0010H\"\u0004\bP\u0010JR\"\u0010Q\u001a\u00020\u00048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010^\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR*\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010l\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR6\u0010s\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040r\u0018\u00010d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010f\u001a\u0004\bt\u0010h\"\u0004\bu\u0010j¨\u0006x"}, d2 = {"Lcom/alibaba/gaiax/render/node/GXNode;", "", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "templateItem", "Lcom/alibaba/gaiax/render/node/GXTemplateNode;", "visualTemplateNode", "", "addChildTemplateItems", "release", "", "getType", "getCustomViewClass", "", "isTextType", "isRichTextType", "isGaiaTemplateType", "isViewType", "isIconFontType", "isImageType", "isContainerType", "isCustomViewType", "isGridType", "isScrollType", "isSliderType", "isProgressType", "isNeedShadow", "isNeedLottie", "parent", "Lcom/alibaba/gaiax/template/GXLayer;", GXTemplateKey.GAIAX_LAYER, "setIdPath", "toString", "initEventByRegisterCenter", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "gxTemplateContext", "resetTree", "", "Lu/b;", "multiTypeItemComputeCache", "Ljava/util/Map;", "getMultiTypeItemComputeCache", "()Ljava/util/Map;", "setMultiTypeItemComputeCache", "(Ljava/util/Map;)V", "Landroid/animation/AnimatorSet;", "propAnimatorSet", "Landroid/animation/AnimatorSet;", "getPropAnimatorSet", "()Landroid/animation/AnimatorSet;", "setPropAnimatorSet", "(Landroid/animation/AnimatorSet;)V", "isAnimating", "Z", "()Z", "setAnimating", "(Z)V", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "idPath", "getIdPath", "isRoot", "setRoot", "isNestRoot", "setNestRoot", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "boxLayoutView", "getBoxLayoutView", "setBoxLayoutView", "lottieView", "getLottieView", "setLottieView", "templateNode", "Lcom/alibaba/gaiax/render/node/GXTemplateNode;", "getTemplateNode", "()Lcom/alibaba/gaiax/render/node/GXTemplateNode;", "setTemplateNode", "(Lcom/alibaba/gaiax/render/node/GXTemplateNode;)V", "Lcom/alibaba/gaiax/render/node/GXStretchNode;", "stretchNode", "Lcom/alibaba/gaiax/render/node/GXStretchNode;", "getStretchNode", "()Lcom/alibaba/gaiax/render/node/GXStretchNode;", "setStretchNode", "(Lcom/alibaba/gaiax/render/node/GXStretchNode;)V", "parentNode", "Lcom/alibaba/gaiax/render/node/GXNode;", "getParentNode", "()Lcom/alibaba/gaiax/render/node/GXNode;", "setParentNode", "(Lcom/alibaba/gaiax/render/node/GXNode;)V", "", "children", "Ljava/util/List;", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "Lcom/alibaba/gaiax/render/node/GXINodeEvent;", "event", "Lcom/alibaba/gaiax/render/node/GXINodeEvent;", "getEvent", "()Lcom/alibaba/gaiax/render/node/GXINodeEvent;", "setEvent", "(Lcom/alibaba/gaiax/render/node/GXINodeEvent;)V", "Lkotlin/Pair;", "childTemplateItems", "getChildTemplateItems", "setChildTemplateItems", "<init>", "()V", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final class GXNode {
    private View boxLayoutView;
    private List<Pair<GXTemplateItem, GXTemplateNode>> childTemplateItems;
    private List<GXNode> children;
    private GXINodeEvent event;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f24954id;
    private String idPath;
    private boolean isAnimating;
    private boolean isNestRoot;
    private boolean isRoot;
    private View lottieView;
    private Map<GXTemplateItem, u.b> multiTypeItemComputeCache;
    private GXNode parentNode;
    private AnimatorSet propAnimatorSet;
    public GXStretchNode stretchNode;
    public GXTemplateNode templateNode;
    private View view;

    public final void release() {
        this.isAnimating = false;
        this.idPath = "";
        KeyEvent.Callback r100 = this.view;
        if ((r100 instanceof GXIRelease) == false) goto L5;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.alibaba.gaiax.render.view.GXIRelease");
        ((GXIRelease) r100).release();
    L5:
        this.view = null;
        this.boxLayoutView = null;
        getStretchNode().free();
        List<GXNode> r101 = this.children;
        if (r101 == null) goto L11;
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        ((GXNode) r102.next()).release();
    L11:
        List<GXNode> r103 = this.children;
        if (r103 == null) goto L14;
        r103.clear();
    L14:
        this.parentNode = null;
    }

    public final GXStretchNode getStretchNode() {
        GXStretchNode r100 = this.stretchNode;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("stretchNode");
        return null;
    }

    public final GXTemplateNode getTemplateNode() {
        GXTemplateNode r100 = this.templateNode;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("templateNode");
        return null;
    }

    public final void initEventByRegisterCenter() {
        if (this.event != null) goto L10;
        GXRegisterCenter.GXIExtensionNodeEvent r100 = GXRegisterCenter.Companion.getInstance().getExtensionNodeEvent$GaiaX();
        if (r100 == null) goto L7;
        GXINodeEvent r101 = r100.create();
    L8:
        this.event = r101;
        return;
    L7:
        r101 = null;
        goto L8
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("GXNode(id='");
        r100.append(this.f24954id);
        r100.append("', idPath='");
        r100.append(this.idPath);
        r100.append("', isRoot=");
        r100.append(this.isRoot);
        r100.append(", isNestRoot=");
        r100.append(this.isNestRoot);
        r100.append(", templateNode=");
        r100.append(getTemplateNode());
        r100.append(", stretchNode=");
        r100.append(getStretchNode());
        r100.append(", children=");
        List<GXNode> r101 = this.children;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public GXNode() {
        this.f24954id = "";
        this.idPath = "";
    }

    public final String getCustomViewClass() {
        return getTemplateNode().getCustomViewClass();
    }

    public final String getType() {
        return getTemplateNode().getNodeType();
    }

    public final boolean isContainerType() {
        return getTemplateNode().isContainerType();
    }

    public final boolean isCustomViewType() {
        return getTemplateNode().isCustomType();
    }

    public final boolean isGaiaTemplateType() {
        return getTemplateNode().isGaiaTemplateType();
    }

    public final boolean isGridType() {
        return getTemplateNode().isGridType();
    }

    public final boolean isIconFontType() {
        return getTemplateNode().isIconFontType();
    }

    public final boolean isImageType() {
        return getTemplateNode().isImageType();
    }

    public final boolean isNeedLottie() {
        GXAnimationBinding r100 = getTemplateNode().getAnimationBinding();
        if (r100 == null) goto L10;
        String r101 = r100.getType();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (StringsKt.equals(r101, GXTemplateKey.GAIAX_ANIMATION_TYPE_LOTTIE, true) != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean isNeedShadow() {
        if (isViewType() == true) goto L7;
        if (isImageType() == true) goto L7;
    L9:
        return false;
    L7:
        if (getTemplateNode().getCss().getStyle().getBoxShadow() == null) goto L9;
        return true;
    }

    public final boolean isProgressType() {
        return getTemplateNode().isProgressType();
    }

    public final boolean isRichTextType() {
        return getTemplateNode().isRichTextType();
    }

    public final boolean isScrollType() {
        return getTemplateNode().isScrollType();
    }

    public final boolean isSliderType() {
        return getTemplateNode().isSliderType();
    }

    public final boolean isTextType() {
        return getTemplateNode().isTextType();
    }

    public final boolean isViewType() {
        return getTemplateNode().isViewType();
    }

    public final View getBoxLayoutView() {
        return this.boxLayoutView;
    }

    public final List<Pair<GXTemplateItem, GXTemplateNode>> getChildTemplateItems() {
        return this.childTemplateItems;
    }

    public final List<GXNode> getChildren() {
        return this.children;
    }

    public final GXINodeEvent getEvent() {
        return this.event;
    }

    public final String getId() {
        return this.f24954id;
    }

    public final String getIdPath() {
        return this.idPath;
    }

    public final View getLottieView() {
        return this.lottieView;
    }

    public final Map<GXTemplateItem, u.b> getMultiTypeItemComputeCache() {
        return this.multiTypeItemComputeCache;
    }

    public final GXNode getParentNode() {
        return this.parentNode;
    }

    public final AnimatorSet getPropAnimatorSet() {
        return this.propAnimatorSet;
    }

    public final View getView() {
        return this.view;
    }

    public final boolean isAnimating() {
        return this.isAnimating;
    }

    public final boolean isNestRoot() {
        return this.isNestRoot;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    public final void resetTree(GXTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, "gxTemplateContext");
        getTemplateNode().reset();
        getStretchNode().reset(r100, getTemplateNode());
        List<GXNode> r101 = this.children;
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((GXNode) r102.next()).resetTree(r100);
        goto L6
    L10:
        return;
    }

    public final void setAnimating(boolean r100) {
        this.isAnimating = r100;
    }

    public final void setBoxLayoutView(View r100) {
        this.boxLayoutView = r100;
    }

    public final void setChildTemplateItems(List<Pair<GXTemplateItem, GXTemplateNode>> r100) {
        this.childTemplateItems = r100;
    }

    public final void setChildren(List<GXNode> r100) {
        this.children = r100;
    }

    public final void setEvent(GXINodeEvent r100) {
        this.event = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f24954id = r100;
    }

    public final void setIdPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.idPath = r100;
    }

    public final void setLottieView(View r100) {
        this.lottieView = r100;
    }

    public final void setMultiTypeItemComputeCache(Map<GXTemplateItem, u.b> r100) {
        this.multiTypeItemComputeCache = r100;
    }

    public final void setNestRoot(boolean r100) {
        this.isNestRoot = r100;
    }

    public final void setParentNode(GXNode r100) {
        this.parentNode = r100;
    }

    public final void setPropAnimatorSet(AnimatorSet r100) {
        this.propAnimatorSet = r100;
    }

    public final void setRoot(boolean r100) {
        this.isRoot = r100;
    }

    public final void setStretchNode(GXStretchNode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stretchNode = r100;
    }

    public final void setTemplateNode(GXTemplateNode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templateNode = r100;
    }

    public final void setView(View r100) {
        this.view = r100;
    }

    public final void addChildTemplateItems(GXTemplateItem r100, GXTemplateNode r101) {
        Intrinsics.checkNotNullParameter(r100, "templateItem");
        Intrinsics.checkNotNullParameter(r101, "visualTemplateNode");
        if (this.childTemplateItems != null) goto L5;
        this.childTemplateItems = new ArrayList();
    L5:
        List<Pair<GXTemplateItem, GXTemplateNode>> r102 = this.childTemplateItems;
        if (r102 == null) goto L9;
        r102.add(new Pair(r100, r101));
        return;
    }

    public final void setIdPath(GXNode r100, GXLayer r101) {
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_LAYER);
        this.f24954id = r101.getId();
        boolean r102 = true;
        if (r100 == null) goto L12;
        if (this.idPath.length() > 0) goto L8;
        r102 = false;
    L8:
        if (r102 == false) goto L10;
        String r103 = r100.idPath + '@' + this.idPath + '@' + r101.getId();
    L18:
        this.idPath = r103;
        return;
    L10:
        r103 = r100.idPath + '@' + r101.getId();
        goto L18
    L12:
        if (this.idPath.length() > 0) goto L15;
        r102 = false;
    L15:
        if (r102 == false) goto L17;
        r103 = this.idPath + '@' + r101.getId();
        goto L18
    L17:
        r103 = r101.getId();
        goto L18
    }
}
