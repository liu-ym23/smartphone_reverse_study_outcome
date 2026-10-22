package com.alibaba.gaiax.render.node;

import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.template.GXCss;
import com.alibaba.gaiax.template.GXDataBinding;
import com.alibaba.gaiax.template.GXEventBinding;
import com.alibaba.gaiax.template.GXGridConfig;
import com.alibaba.gaiax.template.GXLayer;
import com.alibaba.gaiax.template.GXProgressConfig;
import com.alibaba.gaiax.template.GXScrollConfig;
import com.alibaba.gaiax.template.GXSliderConfig;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alibaba.gaiax.template.GXTrackBinding;
import com.alibaba.gaiax.template.animation.GXAnimationBinding;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u0000 x2\u00020\u0001:\u0001xBQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u000fJ\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0000HÆ\u0003JY\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0000HÆ\u0001J\u0013\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010U\u001a\u0004\u0018\u00010VJ\u0010\u0010W\u001a\u0004\u0018\u00010\u00192\u0006\u0010X\u001a\u00020\u0019J\u0010\u0010Y\u001a\u0004\u0018\u00010\u00012\u0006\u0010X\u001a\u00020\u0019J\u0012\u0010Z\u001a\u0004\u0018\u00010\u00192\b\u0010X\u001a\u0004\u0018\u00010\u0001J\u0006\u0010[\u001a\u00020VJ\u0006\u0010\\\u001a\u00020VJ\t\u0010]\u001a\u00020^HÖ\u0001J\"\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010\u00192\b\u0010d\u001a\u0004\u0018\u00010\u0019J\u0006\u0010e\u001a\u00020SJ\u0006\u0010f\u001a\u00020SJ\u0006\u0010g\u001a\u00020SJ\u0006\u0010h\u001a\u00020SJ\u0006\u0010i\u001a\u00020SJ\u0006\u0010j\u001a\u00020SJ\u0006\u0010k\u001a\u00020SJ\u0006\u0010l\u001a\u00020SJ\u0006\u0010m\u001a\u00020SJ\u0006\u0010n\u001a\u00020SJ\u0006\u0010o\u001a\u00020SJ\u0006\u0010p\u001a\u00020SJ\u0006\u0010q\u001a\u00020SJ\u0006\u0010r\u001a\u00020SJ\u0006\u0010s\u001a\u00020SJ\u0006\u0010t\u001a\u00020`J\b\u0010u\u001a\u00020`H\u0002J\u0006\u0010v\u001a\u00020`J\b\u0010w\u001a\u00020VH\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\bH\u0010I¨\u0006y"}, d2 = {"Lcom/alibaba/gaiax/render/node/GXTemplateNode;", "", GXTemplateKey.GAIAX_LAYER, "Lcom/alibaba/gaiax/template/GXLayer;", GXTemplateKey.GAIAX_CSS, "Lcom/alibaba/gaiax/template/GXCss;", "dataBinding", "Lcom/alibaba/gaiax/template/GXDataBinding;", "eventBinding", "Lcom/alibaba/gaiax/template/GXEventBinding;", "trackBinding", "Lcom/alibaba/gaiax/template/GXTrackBinding;", "animationBinding", "Lcom/alibaba/gaiax/template/animation/GXAnimationBinding;", "visualTemplateNode", "(Lcom/alibaba/gaiax/template/GXLayer;Lcom/alibaba/gaiax/template/GXCss;Lcom/alibaba/gaiax/template/GXDataBinding;Lcom/alibaba/gaiax/template/GXEventBinding;Lcom/alibaba/gaiax/template/GXTrackBinding;Lcom/alibaba/gaiax/template/animation/GXAnimationBinding;Lcom/alibaba/gaiax/render/node/GXTemplateNode;)V", "getAnimationBinding", "()Lcom/alibaba/gaiax/template/animation/GXAnimationBinding;", "getCss", "()Lcom/alibaba/gaiax/template/GXCss;", "getDataBinding", "()Lcom/alibaba/gaiax/template/GXDataBinding;", "setDataBinding", "(Lcom/alibaba/gaiax/template/GXDataBinding;)V", "dataCache", "Lorg/json/JSONObject;", "getDataCache", "()Lorg/json/JSONObject;", "setDataCache", "(Lorg/json/JSONObject;)V", "dataExtendCache", "getDataExtendCache", "setDataExtendCache", "dataValueCache", "getDataValueCache", "()Ljava/lang/Object;", "setDataValueCache", "(Ljava/lang/Object;)V", "getEventBinding", "()Lcom/alibaba/gaiax/template/GXEventBinding;", "finalCss", "getFinalCss", "setFinalCss", "(Lcom/alibaba/gaiax/template/GXCss;)V", "finalGridConfig", "Lcom/alibaba/gaiax/template/GXGridConfig;", "getFinalGridConfig", "()Lcom/alibaba/gaiax/template/GXGridConfig;", "setFinalGridConfig", "(Lcom/alibaba/gaiax/template/GXGridConfig;)V", "finalProgressConfig", "Lcom/alibaba/gaiax/template/GXProgressConfig;", "getFinalProgressConfig", "()Lcom/alibaba/gaiax/template/GXProgressConfig;", "setFinalProgressConfig", "(Lcom/alibaba/gaiax/template/GXProgressConfig;)V", "finalScrollConfig", "Lcom/alibaba/gaiax/template/GXScrollConfig;", "getFinalScrollConfig", "()Lcom/alibaba/gaiax/template/GXScrollConfig;", "setFinalScrollConfig", "(Lcom/alibaba/gaiax/template/GXScrollConfig;)V", "finalSliderConfig", "Lcom/alibaba/gaiax/template/GXSliderConfig;", "getFinalSliderConfig", "()Lcom/alibaba/gaiax/template/GXSliderConfig;", "setFinalSliderConfig", "(Lcom/alibaba/gaiax/template/GXSliderConfig;)V", "getLayer", "()Lcom/alibaba/gaiax/template/GXLayer;", "getTrackBinding", "()Lcom/alibaba/gaiax/template/GXTrackBinding;", "getVisualTemplateNode", "()Lcom/alibaba/gaiax/render/node/GXTemplateNode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "getCustomViewClass", "", "getData", "templateData", "getDataValue", "getExtend", "getNodeId", "getNodeType", "hashCode", "", "initFinal", "", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "visualTemplateData", "nodeTemplateData", "isCanBeMergedType", "isContainerType", "isCustomType", "isGaiaTemplateType", "isGridType", "isIconFontType", "isImageType", "isLottieType", "isNestChildTemplateType", "isProgressType", "isRichTextType", "isScrollType", "isSliderType", "isTextType", "isViewType", BasicTestActionHandler.TEST_ACTION_RESET, "resetBasic", "resetData", "toString", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXTemplateNode {
    public static final Companion Companion = null;
    private final GXAnimationBinding animationBinding;
    private final GXCss css;
    private GXDataBinding dataBinding;
    private JSONObject dataCache;
    private JSONObject dataExtendCache;
    private Object dataValueCache;
    private final GXEventBinding eventBinding;
    private GXCss finalCss;
    private GXGridConfig finalGridConfig;
    private GXProgressConfig finalProgressConfig;
    private GXScrollConfig finalScrollConfig;
    private GXSliderConfig finalSliderConfig;
    private final GXLayer layer;
    private final GXTrackBinding trackBinding;
    private final GXTemplateNode visualTemplateNode;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/render/node/GXTemplateNode$Companion;", "", "()V", "createNode", "Lcom/alibaba/gaiax/render/node/GXTemplateNode;", "viewId", "", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "visualTemplateNode", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXTemplateNode createNode(String r110, GXTemplateInfo r111, GXTemplateNode r112) {
            Intrinsics.checkNotNullParameter(r110, "viewId");
            Intrinsics.checkNotNullParameter(r111, ThumbGlideUrl.SOURCE_TEMPLATE);
            GXLayer r100 = r111.findLayer(r110);
            if (r100 == null) goto L10;
            GXCss r101 = r111.findCss(r110);
            if (r101 != null) goto L8;
            r101 = GXCss.Companion.create$default(GXCss.Companion, null, 1, null);
        L8:
            return new GXTemplateNode(r100, r101, r111.findData(r110), r111.findEvent(r110), r111.findTrack(r110), r111.findAnimation(r110), r112);
        L10:
            throw new IllegalArgumentException("Not found layer by view id, viewId = " + r110);
        }

        public static /* synthetic */ GXTemplateNode createNode$default(Companion r100, String r101, GXTemplateInfo r102, GXTemplateNode r103, int r104, Object r105) {
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            return r100.createNode(r101, r102, r103);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ GXTemplateNode copy$default(GXTemplateNode r100, GXLayer r101, GXCss r102, GXDataBinding r103, GXEventBinding r104, GXTrackBinding r110, GXAnimationBinding r111, GXTemplateNode r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.layer;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.css;
    L8:
        GXCss r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.dataBinding;
    L11:
        GXDataBinding r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.eventBinding;
    L14:
        GXEventBinding r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.trackBinding;
    L17:
        GXTrackBinding r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.animationBinding;
    L20:
        GXAnimationBinding r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.visualTemplateNode;
    L23:
        GXLayer r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    private final void resetBasic() {
        this.finalCss = null;
        this.finalGridConfig = null;
        this.finalScrollConfig = null;
        this.finalSliderConfig = null;
    }

    public final GXLayer component1() {
        return this.layer;
    }

    public final GXCss component2() {
        return this.css;
    }

    public final GXDataBinding component3() {
        return this.dataBinding;
    }

    public final GXEventBinding component4() {
        return this.eventBinding;
    }

    public final GXTrackBinding component5() {
        return this.trackBinding;
    }

    public final GXAnimationBinding component6() {
        return this.animationBinding;
    }

    public final GXTemplateNode component7() {
        return this.visualTemplateNode;
    }

    public final GXTemplateNode copy(GXLayer r110, GXCss r111, GXDataBinding r112, GXEventBinding r113, GXTrackBinding r114, GXAnimationBinding r115, GXTemplateNode r116) {
        Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_LAYER);
        Intrinsics.checkNotNullParameter(r111, GXTemplateKey.GAIAX_CSS);
        return new GXTemplateNode(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXTemplateNode) == true) goto L8;
        return false;
    L8:
        GXTemplateNode r101 = (GXTemplateNode) r100;
        if (Intrinsics.areEqual(this.layer, r101.layer) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.css, r101.css) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.dataBinding, r101.dataBinding) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventBinding, r101.eventBinding) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.trackBinding, r101.trackBinding) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.animationBinding, r101.animationBinding) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.visualTemplateNode, r101.visualTemplateNode) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.layer.hashCode() * 31) + this.css.hashCode()) * 31;
        GXDataBinding r101 = this.dataBinding;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        GXEventBinding r105 = this.eventBinding;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        GXTrackBinding r108 = this.trackBinding;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        GXAnimationBinding r111 = this.animationBinding;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        GXTemplateNode r114 = this.visualTemplateNode;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final void resetData() {
        this.dataExtendCache = null;
        this.dataValueCache = null;
        this.dataCache = null;
    }

    public final String getCustomViewClass() {
        return this.layer.getCustomNodeClass();
    }

    public final String getNodeId() {
        return this.layer.getId();
    }

    public final String getNodeType() {
        return this.layer.getNodeType();
    }

    public final boolean isCanBeMergedType() {
        return this.layer.isCanMergeType();
    }

    public final boolean isContainerType() {
        return this.layer.isContainerType();
    }

    public final boolean isCustomType() {
        return this.layer.isCustomType();
    }

    public final boolean isGaiaTemplateType() {
        return this.layer.isGaiaTemplate();
    }

    public final boolean isGridType() {
        return this.layer.isGridType();
    }

    public final boolean isIconFontType() {
        return this.layer.isIconFontType();
    }

    public final boolean isImageType() {
        return this.layer.isImageType();
    }

    public final boolean isLottieType() {
        return this.layer.isLottieType();
    }

    public final boolean isNestChildTemplateType() {
        return this.layer.isNestChildTemplateType();
    }

    public final boolean isProgressType() {
        return this.layer.isProgressType();
    }

    public final boolean isRichTextType() {
        return this.layer.isRichTextType();
    }

    public final boolean isScrollType() {
        return this.layer.isScrollType();
    }

    public final boolean isSliderType() {
        return this.layer.isSliderType();
    }

    public final boolean isTextType() {
        return this.layer.isTextType();
    }

    public final boolean isViewType() {
        return this.layer.isViewType();
    }

    public String toString() {
        return "GXTemplateNode(layer=" + this.layer + ", css=" + this.css + ", dataBinding=" + this.dataBinding + ", eventBinding=" + this.eventBinding + ", animationBinding=" + this.animationBinding + ", visualTemplateNode=" + this.visualTemplateNode + ", finalCss=" + this.finalCss + ')';
    }

    public final void reset() {
        resetData();
        GXTemplateNode r100 = this.visualTemplateNode;
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    public final GXAnimationBinding getAnimationBinding() {
        return this.animationBinding;
    }

    public final GXCss getCss() {
        return this.css;
    }

    public final GXDataBinding getDataBinding() {
        return this.dataBinding;
    }

    public final JSONObject getDataCache() {
        return this.dataCache;
    }

    public final JSONObject getDataExtendCache() {
        return this.dataExtendCache;
    }

    public final Object getDataValueCache() {
        return this.dataValueCache;
    }

    public final GXEventBinding getEventBinding() {
        return this.eventBinding;
    }

    public final GXCss getFinalCss() {
        return this.finalCss;
    }

    public final GXGridConfig getFinalGridConfig() {
        return this.finalGridConfig;
    }

    public final GXProgressConfig getFinalProgressConfig() {
        return this.finalProgressConfig;
    }

    public final GXScrollConfig getFinalScrollConfig() {
        return this.finalScrollConfig;
    }

    public final GXSliderConfig getFinalSliderConfig() {
        return this.finalSliderConfig;
    }

    public final GXLayer getLayer() {
        return this.layer;
    }

    public final GXTrackBinding getTrackBinding() {
        return this.trackBinding;
    }

    public final GXTemplateNode getVisualTemplateNode() {
        return this.visualTemplateNode;
    }

    public final JSONObject getData(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "templateData");
        if (this.dataCache != null) goto L10;
        GXDataBinding r101 = this.dataBinding;
        if (r101 == null) goto L7;
        JSONObject r102 = r101.getData(r100);
    L8:
        this.dataCache = r102;
        goto L10
    L7:
        r102 = null;
    L10:
        return this.dataCache;
    }

    public final Object getDataValue(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "templateData");
        if (this.dataValueCache != null) goto L12;
        GXDataBinding r101 = this.dataBinding;
        if (r101 == null) goto L9;
        JSONObject r102 = r101.getData(r100);
        if (r102 == null) goto L9;
        Object r103 = r102.opt("value");
    L10:
        this.dataValueCache = r103;
    L9:
        r103 = null;
    L12:
        return this.dataValueCache;
    }

    public final JSONObject getExtend(Object r100) {
        if (this.dataExtendCache != null) goto L10;
        GXDataBinding r101 = this.dataBinding;
        if (r101 == null) goto L7;
        JSONObject r102 = r101.getExtend(r100);
    L8:
        this.dataExtendCache = r102;
        goto L10
    L7:
        r102 = null;
    L10:
        return this.dataExtendCache;
    }

    public final void setDataBinding(GXDataBinding r100) {
        this.dataBinding = r100;
    }

    public final void setDataCache(JSONObject r100) {
        this.dataCache = r100;
    }

    public final void setDataExtendCache(JSONObject r100) {
        this.dataExtendCache = r100;
    }

    public final void setDataValueCache(Object r100) {
        this.dataValueCache = r100;
    }

    public final void setFinalCss(GXCss r100) {
        this.finalCss = r100;
    }

    public final void setFinalGridConfig(GXGridConfig r100) {
        this.finalGridConfig = r100;
    }

    public final void setFinalProgressConfig(GXProgressConfig r100) {
        this.finalProgressConfig = r100;
    }

    public final void setFinalScrollConfig(GXScrollConfig r100) {
        this.finalScrollConfig = r100;
    }

    public final void setFinalSliderConfig(GXSliderConfig r100) {
        this.finalSliderConfig = r100;
    }

    public final void initFinal(GXTemplateContext r100, JSONObject r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "gxTemplateContext");
        GXDataBinding r103 = this.dataBinding;
        GXCss r104 = null;
        if (r103 == null) goto L5;
        JSONObject r105 = r103.getExtend(r102);
    L6:
        if (r105 == null) goto L20;
        GXCss.Companion r106 = GXCss.Companion;
        GXCss r107 = r106.createByExtend(r105);
        GXGridConfig r108 = this.layer.getGridConfig();
        if (r108 == null) goto L10;
        this.finalGridConfig = GXGridConfig.Companion.create(r108, r105);
    L10:
        GXScrollConfig r109 = this.layer.getScrollConfig();
        if (r109 == null) goto L13;
        this.finalScrollConfig = GXScrollConfig.Companion.create(r109, r105);
    L13:
        GXSliderConfig r110 = this.layer.getSliderConfig();
        if (r110 == null) goto L16;
        this.finalSliderConfig = GXSliderConfig.Companion.create(r110, r105);
    L16:
        GXProgressConfig r111 = this.layer.getProgressConfig();
        if (r111 == null) goto L19;
        this.finalProgressConfig = GXProgressConfig.Companion.create(r111, r105);
    L19:
        GXCss r112 = r106.create(this.css, r107);
    L33:
        GXTemplateNode r113 = this.visualTemplateNode;
        if (r113 == null) goto L36;
        r113.initFinal(r100, null, r101);
    L36:
        GXCss.Companion r114 = GXCss.Companion;
        GXTemplateNode r115 = this.visualTemplateNode;
        if (r115 == null) goto L39;
        r104 = r115.finalCss;
    L39:
        this.finalCss = r114.create(r112, r104);
        return;
    L20:
        GXGridConfig r116 = this.layer.getGridConfig();
        if (r116 == null) goto L23;
        this.finalGridConfig = r116;
    L23:
        GXScrollConfig r117 = this.layer.getScrollConfig();
        if (r117 == null) goto L26;
        this.finalScrollConfig = r117;
    L26:
        GXSliderConfig r118 = this.layer.getSliderConfig();
        if (r118 == null) goto L29;
        this.finalSliderConfig = r118;
    L29:
        GXProgressConfig r119 = this.layer.getProgressConfig();
        if (r119 == null) goto L32;
        this.finalProgressConfig = r119;
    L32:
        r112 = this.css;
        goto L33
    L5:
        r105 = null;
        goto L6
    }

    public GXTemplateNode(GXLayer r100, GXCss r101, GXDataBinding r102, GXEventBinding r103, GXTrackBinding r104, GXAnimationBinding r105, GXTemplateNode r106) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_CSS);
        this.layer = r100;
        this.css = r101;
        this.dataBinding = r102;
        this.eventBinding = r103;
        this.trackBinding = r104;
        this.animationBinding = r105;
        this.visualTemplateNode = r106;
    }

    public /* synthetic */ GXTemplateNode(GXLayer r110, GXCss r111, GXDataBinding r112, GXEventBinding r113, GXTrackBinding r114, GXAnimationBinding r115, GXTemplateNode r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 4) == 0) goto L5;
        GXDataBinding r100 = null;
    L7:
        if ((r117 & 8) == 0) goto L9;
        GXEventBinding r101 = null;
    L11:
        if ((r117 & 16) == 0) goto L13;
        GXTrackBinding r102 = null;
    L15:
        if ((r117 & 32) == 0) goto L17;
        GXAnimationBinding r103 = null;
    L19:
        if ((r117 & 64) == 0) goto L21;
        GXTemplateNode r104 = null;
    L22:
        this(r110, r111, r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r116;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
