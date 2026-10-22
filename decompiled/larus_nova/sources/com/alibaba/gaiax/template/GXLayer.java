package com.alibaba.gaiax.template;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.alibaba.gaiax.utils.GXExtJsonKt;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 D2\u00020\u0001:\u0001DBu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u007f\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u00101\u001a\u00020\u0003J\t\u00102\u001a\u000203HÖ\u0001J\u0006\u00104\u001a\u00020/J\u0006\u00105\u001a\u00020/J\u0006\u00106\u001a\u00020/J\u0006\u00107\u001a\u00020/J\u0006\u00108\u001a\u00020/J\u0006\u00109\u001a\u00020/J\u0006\u0010:\u001a\u00020/J\u0006\u0010;\u001a\u00020/J\u0006\u0010<\u001a\u00020/J\u0006\u0010=\u001a\u00020/J\u0006\u0010>\u001a\u00020/J\u0006\u0010?\u001a\u00020/J\u0006\u0010@\u001a\u00020/J\u0006\u0010A\u001a\u00020/J\u0006\u0010B\u001a\u00020/J\b\u0010C\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u0006E"}, d2 = {"Lcom/alibaba/gaiax/template/GXLayer;", "", "id", "", GXTemplateKey.GAIAX_CSS, "type", "subType", "customNodeClass", "scrollConfig", "Lcom/alibaba/gaiax/template/GXScrollConfig;", "gridConfig", "Lcom/alibaba/gaiax/template/GXGridConfig;", "sliderConfig", "Lcom/alibaba/gaiax/template/GXSliderConfig;", "progressConfig", "Lcom/alibaba/gaiax/template/GXProgressConfig;", GXTemplateKey.GAIAX_LAYERS, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/gaiax/template/GXScrollConfig;Lcom/alibaba/gaiax/template/GXGridConfig;Lcom/alibaba/gaiax/template/GXSliderConfig;Lcom/alibaba/gaiax/template/GXProgressConfig;Ljava/util/List;)V", "getCss", "()Ljava/lang/String;", "getCustomNodeClass", "getGridConfig", "()Lcom/alibaba/gaiax/template/GXGridConfig;", "getId", "getLayers", "()Ljava/util/List;", "getProgressConfig", "()Lcom/alibaba/gaiax/template/GXProgressConfig;", "getScrollConfig", "()Lcom/alibaba/gaiax/template/GXScrollConfig;", "getSliderConfig", "()Lcom/alibaba/gaiax/template/GXSliderConfig;", "getSubType", "getType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getNodeType", "hashCode", "", "isCanMergeType", "isContainerType", "isCustomType", "isGaiaTemplate", "isGridType", "isIconFontType", "isImageType", "isLottieType", "isNestChildTemplateType", "isProgressType", "isRichTextType", "isScrollType", "isSliderType", "isTextType", "isViewType", "toString", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXLayer {
    public static final Companion Companion = null;
    private final String css;
    private final String customNodeClass;
    private final GXGridConfig gridConfig;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f24979id;
    private final List<GXLayer> layers;
    private final GXProgressConfig progressConfig;
    private final GXScrollConfig scrollConfig;
    private final GXSliderConfig sliderConfig;
    private final String subType;
    private final String type;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J>\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u0017"}, d2 = {"Lcom/alibaba/gaiax/template/GXLayer$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/GXLayer;", "data", "Lorg/json/JSONObject;", "createLayer", "initChildrenLayer", "", GXTemplateKey.GAIAX_LAYER, "initLayer", "id", "", GXTemplateKey.GAIAX_CSS, "type", "subType", "viewClass", "isGridType", "", "isProgressType", "isScrollType", "isSliderType", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final GXLayer createLayer(JSONObject r110) {
            String r100 = null;
            String r101 = r110.optString("id", null);
            if (r101 == null) goto L16;
            String r102 = r110.optString("type", null);
            if (r102 == null) goto L14;
            String r103 = r110.optString("class", null);
            String r104 = r110.optString(GXTemplateKey.GAIAX_LAYER_SUB_TYPE, null);
            String r105 = r110.optString(GXTemplateKey.GAIAX_LAYER_CUSTOM_VIEW_CLASS, null);
            if (r105 == null) goto L11;
            GXRegisterCenterApi.GXIExtensionViewClass r106 = GXRegisterCenter.Companion.getInstance().getExtensionViewClass$GaiaX();
            if (r106 == null) goto L11;
            r100 = r106.convert(r105);
        L11:
            GXLayer r107 = initLayer(r101, r103, r102, r104, r100, r110);
            initChildrenLayer(r110, r107);
            return r107;
        L14:
            throw new IllegalArgumentException("Layer must have type property");
        L16:
            throw new IllegalArgumentException("Layer must have id property");
        }

        private final boolean isProgressType(String r100) {
            return Intrinsics.areEqual(r100, "progress");
        }

        public final GXLayer create(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            return createLayer(r100);
        }

        public static final /* synthetic */ GXLayer access$createLayer(Companion r100, JSONObject r101) {
            return r100.createLayer(r101);
        }

        private final void initChildrenLayer(JSONObject r100, final GXLayer r101) {
            JSONArray r102 = r100.optJSONArray(GXTemplateKey.GAIAX_LAYERS);
            if (r102 == null) goto L6;
            GXExtJsonKt.forEach(r102, new GXLayer$Companion$initChildrenLayer$1(r101));
            return;
        }

        private final boolean isGridType(String r100, String r101) {
            if (Intrinsics.areEqual(r100, GXViewKey.VIEW_TYPE_GAIA_TEMPLATE) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r101, GXViewKey.VIEW_TYPE_CONTAINER_GRID) == false) goto L7;
            return true;
        }

        private final boolean isScrollType(String r100, String r101) {
            if (Intrinsics.areEqual(r100, GXViewKey.VIEW_TYPE_GAIA_TEMPLATE) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r101, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL) == false) goto L7;
            return true;
        }

        private final boolean isSliderType(String r100, String r101) {
            if (Intrinsics.areEqual(r100, GXViewKey.VIEW_TYPE_GAIA_TEMPLATE) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r101, GXViewKey.VIEW_TYPE_CONTAINER_SLIDER) == false) goto L7;
            return true;
        }

        private final GXLayer initLayer(String r110, String r111, String r112, String r210, String r211, JSONObject r212) {
            String r100 = r212.optString("direction", null);
            String r101 = r212.optString(GXTemplateKey.GAIAX_LAYER_EDGE_INSETS, null);
            String r102 = r212.optString(GXTemplateKey.GAIAX_LAYER_ITEM_SPACING, null);
            if (r102 != null) goto L5;
            r102 = r212.optString(GXTemplateKey.GAIAX_LAYER_LINE_SPACING, null);
        L5:
            String r113 = r102;
            String r103 = r212.optString(GXTemplateKey.GAIAX_LAYER_ROW_SPACING, null);
            if (r103 != null) goto L8;
            r103 = r212.optString(GXTemplateKey.GAIAX_LAYER_INTERITEM_SPACING, null);
        L8:
            String r114 = r103;
            int r115 = r212.optInt("column");     // Catch: Exception -> L11
        L12:
            boolean r116 = r212.optBoolean(GXTemplateKey.GAIAX_LAYER_SCROLL_ENABLE);
            String r104 = r212.optString(GXTemplateKey.GAIAX_LAYER_GRAVITY, null);
            if (r104 == null) goto L33;
            int r105 = r104.hashCode();
            if (r105 == (-1383228885)) goto L30;
            if (r105 == (-1364013995)) goto L26;
            if (r105 != 115029) goto L33;
            if (r104.equals("top") == false) goto L33;
            Integer r106 = 48;
        L35:
            if (isScrollType(r112, r210) == false) goto L42;
            if (r111 != null) goto L39;
            String r107 = r110;
        L40:
            GXLayer r117 = new GXLayer(r110, r107, r112, r210, r211, GXScrollConfig.Companion.create(r212, r100, r101, r113, r106), null, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT, null);
        L67:
            return r117;
        L39:
            r107 = r111;
            goto L40
        L42:
            if (isGridType(r112, r210) == false) goto L49;
            if (r111 != null) goto L46;
            String r108 = r110;
        L47:
            r117 = new GXLayer(r110, r108, r112, r210, r211, null, GXGridConfig.Companion.create(r212, r100, r101, r113, r114, r115, r116), null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT, null);
            goto L67
        L46:
            r108 = r111;
            goto L47
        L49:
            if (isSliderType(r112, r210) == false) goto L56;
            if (r111 != null) goto L53;
            String r109 = r110;
        L54:
            r117 = new GXLayer(r110, r109, r112, r210, r211, null, null, GXSliderConfig.Companion.create(r212), null, null, 864, null);
            goto L67
        L53:
            r109 = r111;
            goto L54
        L56:
            if (isProgressType(r112) == false) goto L63;
            if (r111 != null) goto L60;
            String r118 = r110;
        L61:
            r117 = new GXLayer(r110, r118, r112, r210, r211, null, null, null, GXProgressConfig.Companion.create(r212), null, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, null);
            goto L67
        L60:
            r118 = r111;
            goto L61
        L63:
            if (r111 != null) goto L65;
            String r119 = r110;
        L66:
            r117 = new GXLayer(r110, r119, r112, r210, r211, null, null, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT, null);
            goto L67
        L65:
            r119 = r111;
            goto L66
        L26:
            if (r104.equals("center") == false) goto L33;
            r106 = 17;
            goto L35
        L30:
            if (r104.equals("bottom") == false) goto L33;
            r106 = 80;
        L33:
            r106 = null;
        L11:
            r115 = 1;
            goto L12
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GXLayer copy$default(GXLayer r110, String r111, String r112, String r113, String r114, String r115, GXScrollConfig r116, GXGridConfig r117, GXSliderConfig r118, GXProgressConfig r210, List r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.f24979id;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.css;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.type;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.subType;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.customNodeClass;
    L23:
        if ((r212 & 32) == 0) goto L25;
        GXScrollConfig r105 = r110.scrollConfig;
    L27:
        if ((r212 & 64) == 0) goto L29;
        GXGridConfig r106 = r110.gridConfig;
    L31:
        if ((r212 & 128) == 0) goto L33;
        GXSliderConfig r107 = r110.sliderConfig;
    L35:
        if ((r212 & 256) == 0) goto L37;
        GXProgressConfig r119 = r110.progressConfig;
    L39:
        if ((r212 & 512) == 0) goto L41;
        List r108 = r110.layers;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.f24979id;
    }

    public final List<GXLayer> component10() {
        return this.layers;
    }

    public final String component2() {
        return this.css;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.subType;
    }

    public final String component5() {
        return this.customNodeClass;
    }

    public final GXScrollConfig component6() {
        return this.scrollConfig;
    }

    public final GXGridConfig component7() {
        return this.gridConfig;
    }

    public final GXSliderConfig component8() {
        return this.sliderConfig;
    }

    public final GXProgressConfig component9() {
        return this.progressConfig;
    }

    public final GXLayer copy(String r110, String r111, String r112, String r113, String r114, GXScrollConfig r115, GXGridConfig r116, GXSliderConfig r210, GXProgressConfig r211, List<GXLayer> r212) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, GXTemplateKey.GAIAX_CSS);
        Intrinsics.checkNotNullParameter(r112, "type");
        Intrinsics.checkNotNullParameter(r212, GXTemplateKey.GAIAX_LAYERS);
        return new GXLayer(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXLayer) == true) goto L8;
        return false;
    L8:
        GXLayer r101 = (GXLayer) r100;
        if (Intrinsics.areEqual(this.f24979id, r101.f24979id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.css, r101.css) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subType, r101.subType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.customNodeClass, r101.customNodeClass) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.scrollConfig, r101.scrollConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.gridConfig, r101.gridConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.sliderConfig, r101.sliderConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.progressConfig, r101.progressConfig) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.layers, r101.layers) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.f24979id.hashCode() * 31) + this.css.hashCode()) * 31) + this.type.hashCode()) * 31;
        String r101 = this.subType;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.customNodeClass;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        GXScrollConfig r108 = this.scrollConfig;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        GXGridConfig r111 = this.gridConfig;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        GXSliderConfig r114 = this.sliderConfig;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        GXProgressConfig r117 = this.progressConfig;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return ((r116 + r102) * 31) + this.layers.hashCode();
    L21:
        r115 = r114.hashCode();
        goto L22
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

    public final String getNodeType() {
        String r100 = this.subType;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.type;
    }

    public final boolean isCustomType() {
        if (Intrinsics.areEqual(this.type, "custom") == true) goto L5;
    L7:
        return false;
    L5:
        if (this.customNodeClass == null) goto L7;
        return true;
    }

    public final boolean isGaiaTemplate() {
        return Intrinsics.areEqual(GXViewKey.VIEW_TYPE_GAIA_TEMPLATE, this.type);
    }

    public final boolean isGridType() {
        if (Intrinsics.areEqual(this.type, GXViewKey.VIEW_TYPE_GAIA_TEMPLATE) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.subType, GXViewKey.VIEW_TYPE_CONTAINER_GRID) == false) goto L7;
        return true;
    }

    public final boolean isIconFontType() {
        return Intrinsics.areEqual("iconfont", this.type);
    }

    public final boolean isImageType() {
        return Intrinsics.areEqual("image", this.type);
    }

    public final boolean isLottieType() {
        return Intrinsics.areEqual("lottie", this.type);
    }

    public final boolean isNestChildTemplateType() {
        GXRegisterCenter.GXIExtensionCompatibility r100 = GXRegisterCenter.Companion.getInstance().getExtensionCompatibility$GaiaX();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L26;
        if (Intrinsics.areEqual(this.type, GXViewKey.VIEW_TYPE_GAIA_TEMPLATE) == false) goto L17;
        if (Intrinsics.areEqual(this.subType, "custom") == false) goto L17;
        if (this.customNodeClass != null) goto L17;
        return true;
    L17:
        if (Intrinsics.areEqual(this.type, GXViewKey.VIEW_TYPE_GAIA_TEMPLATE) == true) goto L19;
    L23:
        return false;
    L19:
        if (this.subType != null) goto L23;
        if (this.customNodeClass != null) goto L23;
        return true;
    L26:
        if (Intrinsics.areEqual(this.type, GXViewKey.VIEW_TYPE_GAIA_TEMPLATE) == true) goto L28;
    L32:
        return false;
    L28:
        if (Intrinsics.areEqual(this.subType, "custom") == false) goto L32;
        if (this.customNodeClass != null) goto L32;
        return true;
    L5:
        if (r100.isCompatibilityContainerNestTemplateJudgementCondition() != true) goto L7;
        r101 = true;
        goto L9
    }

    public final boolean isProgressType() {
        return Intrinsics.areEqual("progress", this.type);
    }

    public final boolean isRichTextType() {
        return Intrinsics.areEqual(GXViewKey.VIEW_TYPE_RICH_TEXT, this.type);
    }

    public final boolean isScrollType() {
        if (Intrinsics.areEqual(this.type, GXViewKey.VIEW_TYPE_GAIA_TEMPLATE) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.subType, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL) == false) goto L7;
        return true;
    }

    public final boolean isSliderType() {
        if (Intrinsics.areEqual(this.type, GXViewKey.VIEW_TYPE_GAIA_TEMPLATE) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.subType, GXViewKey.VIEW_TYPE_CONTAINER_SLIDER) == false) goto L7;
        return true;
    }

    public String toString() {
        return "GXLayer(id='" + this.f24979id + "', css='" + this.css + "', type='" + this.type + "', subType=" + this.subType + ", customNodeClass=" + this.customNodeClass + ", scrollConfig=" + this.scrollConfig + ", gridConfig=" + this.gridConfig + ", sliderConfig=" + this.sliderConfig + ", layers=" + this.layers + ')';
    }

    public final boolean isCanMergeType() {
        if (isContainerType() == false) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual("view", this.type) == false) goto L7;
    L8:
        return true;
    L7:
        if (Intrinsics.areEqual(this.type, GXViewKey.VIEW_TYPE_GAIA_TEMPLATE) == false) goto L9;
        goto L8
    }

    public final boolean isContainerType() {
        if (isScrollType() == false) goto L5;
    L10:
        return true;
    L5:
        if (isGridType() == true) goto L10;
        if (isSliderType() == true) goto L10;
        return false;
    }

    public final boolean isTextType() {
        return Intrinsics.areEqual("text", this.type);
    }

    public final boolean isViewType() {
        if (Intrinsics.areEqual("view", this.type) == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(GXViewKey.VIEW_TYPE_GAIA_TEMPLATE, this.type) == true) goto L7;
    L9:
        return false;
    L7:
        if (this.subType != null) goto L9;
        goto L9
    }

    public final String getCss() {
        return this.css;
    }

    public final String getCustomNodeClass() {
        return this.customNodeClass;
    }

    public final GXGridConfig getGridConfig() {
        return this.gridConfig;
    }

    public final String getId() {
        return this.f24979id;
    }

    public final List<GXLayer> getLayers() {
        return this.layers;
    }

    public final GXProgressConfig getProgressConfig() {
        return this.progressConfig;
    }

    public final GXScrollConfig getScrollConfig() {
        return this.scrollConfig;
    }

    public final GXSliderConfig getSliderConfig() {
        return this.sliderConfig;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final String getType() {
        return this.type;
    }

    public GXLayer(String r100, String r101, String r102, String r103, String r104, GXScrollConfig r105, GXGridConfig r106, GXSliderConfig r107, GXProgressConfig r110, List<GXLayer> r111) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_CSS);
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r111, GXTemplateKey.GAIAX_LAYERS);
        this.f24979id = r100;
        this.css = r101;
        this.type = r102;
        this.subType = r103;
        this.customNodeClass = r104;
        this.scrollConfig = r105;
        this.gridConfig = r106;
        this.sliderConfig = r107;
        this.progressConfig = r110;
        this.layers = r111;
    }

    public /* synthetic */ GXLayer(String r110, String r111, String r112, String r113, String r114, GXScrollConfig r210, GXGridConfig r211, GXSliderConfig r212, GXProgressConfig r213, List r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 32) == 0) goto L13;
        GXScrollConfig r102 = null;
    L15:
        if ((r215 & 64) == 0) goto L17;
        GXGridConfig r115 = null;
    L19:
        if ((r215 & 128) == 0) goto L21;
        GXSliderConfig r116 = null;
    L23:
        if ((r215 & 256) == 0) goto L25;
        GXProgressConfig r117 = null;
    L27:
        if ((r215 & 512) == 0) goto L29;
        List r118 = new ArrayList();
    L30:
        this(r110, r111, r112, r100, r101, r102, r115, r116, r117, r118);
        return;
    L29:
        r118 = r214;
        goto L30
    L25:
        r117 = r213;
        goto L27
    L21:
        r116 = r212;
        goto L23
    L17:
        r115 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
