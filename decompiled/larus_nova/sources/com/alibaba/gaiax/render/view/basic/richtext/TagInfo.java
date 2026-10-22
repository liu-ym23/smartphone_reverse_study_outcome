package com.alibaba.gaiax.render.view.basic.richtext;

import androidx.camera.video.AudioStats;
import com.facebook.keyframes.model.KFFeature;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.ttvideoengine.DataLoaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00011B\u008b\u0001\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0092\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014¨\u00062"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/richtext/TagInfo;", "", "height", "", "align", "", "offset", "left_offset", "right_offset", "left_padding", "right_padding", "background_color", KFFeature.STROKE_WIDTH_JSON_FIELD, KFFeature.STROKE_COLOR_JSON_FIELD, "corner_radius", "(Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;)V", "getAlign", "()Ljava/lang/String;", "getBackground_color", "getCorner_radius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHeight", "getLeft_offset", "getLeft_padding", "getOffset", "getRight_offset", "getRight_padding", "getStroke_color", "getStroke_width", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;)Lcom/alibaba/gaiax/render/view/basic/richtext/TagInfo;", "equals", "", "other", "hashCode", "", "toString", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TagInfo {
    public static final Companion Companion = null;
    private final String align;
    private final String background_color;
    private final Float corner_radius;
    private final Float height;
    private final Float left_offset;
    private final Float left_padding;
    private final Float offset;
    private final Float right_offset;
    private final Float right_padding;
    private final String stroke_color;
    private final Float stroke_width;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/richtext/TagInfo$Companion;", "", "()V", "createByExtend", "Lcom/alibaba/gaiax/render/view/basic/richtext/TagInfo;", "tagModel", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final TagInfo createByExtend(JSONObject r110) {
            if (r110 != null) goto L6;
            return null;
        L6:
            return new TagInfo(Float.valueOf((float) r110.optDouble("height", AudioStats.AUDIO_AMPLITUDE_NONE)), r110.optString("align", "center"), Float.valueOf((float) r110.optDouble("offset", AudioStats.AUDIO_AMPLITUDE_NONE)), Float.valueOf((float) r110.optDouble("left_offset", AudioStats.AUDIO_AMPLITUDE_NONE)), Float.valueOf((float) r110.optDouble("right_offset", AudioStats.AUDIO_AMPLITUDE_NONE)), Float.valueOf((float) r110.optDouble("left_padding", AudioStats.AUDIO_AMPLITUDE_NONE)), Float.valueOf((float) r110.optDouble("right_padding", AudioStats.AUDIO_AMPLITUDE_NONE)), r110.optString("background_color", null), Float.valueOf((float) r110.optDouble(KFFeature.STROKE_WIDTH_JSON_FIELD, AudioStats.AUDIO_AMPLITUDE_NONE)), r110.optString(KFFeature.STROKE_COLOR_JSON_FIELD, null), Float.valueOf((float) r110.optDouble("corner_radius", AudioStats.AUDIO_AMPLITUDE_NONE)));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TagInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public TagInfo(Float r110) {
        this(r110, null, null, null, null, null, null, null, null, null, null, 2046, null);
    }

    public TagInfo(Float r110, String r111) {
        this(r110, r111, null, null, null, null, null, null, null, null, null, 2044, null);
    }

    public TagInfo(Float r110, String r111, Float r112) {
        this(r110, r111, r112, null, null, null, null, null, null, null, null, 2040, null);
    }

    public TagInfo(Float r110, String r111, Float r112, Float r113) {
        this(r110, r111, r112, r113, null, null, null, null, null, null, null, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT, null);
    }

    public TagInfo(Float r110, String r111, Float r112, Float r113, Float r114) {
        this(r110, r111, r112, r113, r114, null, null, null, null, null, null, 2016, null);
    }

    public TagInfo(Float r110, String r111, Float r112, Float r113, Float r114, Float r210) {
        this(r110, r111, r112, r113, r114, r210, null, null, null, null, null, 1984, null);
    }

    public TagInfo(Float r110, String r111, Float r112, Float r113, Float r114, Float r210, Float r211) {
        this(r110, r111, r112, r113, r114, r210, r211, null, null, null, null, TECameraUtils.CAPTURE_NORMAL, null);
    }

    public TagInfo(Float r110, String r111, Float r112, Float r113, Float r114, Float r210, Float r211, String r212) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, null, null, null, ISmModel.VERSION_0700, null);
    }

    public TagInfo(Float r110, String r111, Float r112, Float r113, Float r114, Float r210, Float r211, String r212, Float r213) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, null, null, ISmModel.VERSION_0600, null);
    }

    public TagInfo(Float r110, String r111, Float r112, Float r113, Float r114, Float r210, Float r211, String r212, Float r213, String r214) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, null, 1024, null);
    }

    public static /* synthetic */ TagInfo copy$default(TagInfo r110, Float r111, String r112, Float r113, Float r114, Float r115, Float r116, Float r117, String r210, Float r211, String r212, Float r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        Float r100 = r110.height;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.align;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Float r102 = r110.offset;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Float r103 = r110.left_offset;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Float r104 = r110.right_offset;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Float r105 = r110.left_padding;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Float r106 = r110.right_padding;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.background_color;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Float r118 = r110.stroke_width;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.stroke_color;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Float r108 = r110.corner_radius;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final Float component1() {
        return this.height;
    }

    public final String component10() {
        return this.stroke_color;
    }

    public final Float component11() {
        return this.corner_radius;
    }

    public final String component2() {
        return this.align;
    }

    public final Float component3() {
        return this.offset;
    }

    public final Float component4() {
        return this.left_offset;
    }

    public final Float component5() {
        return this.right_offset;
    }

    public final Float component6() {
        return this.left_padding;
    }

    public final Float component7() {
        return this.right_padding;
    }

    public final String component8() {
        return this.background_color;
    }

    public final Float component9() {
        return this.stroke_width;
    }

    public final TagInfo copy(Float r110, String r111, Float r112, Float r113, Float r114, Float r115, Float r210, String r211, Float r212, String r213, Float r214) {
        return new TagInfo(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TagInfo) == true) goto L8;
        return false;
    L8:
        TagInfo r101 = (TagInfo) r100;
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.align, r101.align) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.offset, r101.offset) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.left_offset, r101.left_offset) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.right_offset, r101.right_offset) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.left_padding, r101.left_padding) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.right_padding, r101.right_padding) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.background_color, r101.background_color) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.stroke_width, r101.stroke_width) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.stroke_color, r101.stroke_color) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.corner_radius, r101.corner_radius) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        Float r100 = this.height;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.align;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.offset;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.left_offset;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.right_offset;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.left_padding;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Float r119 = this.right_padding;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.background_color;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Float r125 = this.stroke_width;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.stroke_color;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Float r131 = this.corner_radius;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TagInfo(height=" + this.height + ", align=" + this.align + ", offset=" + this.offset + ", left_offset=" + this.left_offset + ", right_offset=" + this.right_offset + ", left_padding=" + this.left_padding + ", right_padding=" + this.right_padding + ", background_color=" + this.background_color + ", stroke_width=" + this.stroke_width + ", stroke_color=" + this.stroke_color + ", corner_radius=" + this.corner_radius + ')';
    }

    public final String getAlign() {
        return this.align;
    }

    public final String getBackground_color() {
        return this.background_color;
    }

    public final Float getCorner_radius() {
        return this.corner_radius;
    }

    public final Float getHeight() {
        return this.height;
    }

    public final Float getLeft_offset() {
        return this.left_offset;
    }

    public final Float getLeft_padding() {
        return this.left_padding;
    }

    public final Float getOffset() {
        return this.offset;
    }

    public final Float getRight_offset() {
        return this.right_offset;
    }

    public final Float getRight_padding() {
        return this.right_padding;
    }

    public final String getStroke_color() {
        return this.stroke_color;
    }

    public final Float getStroke_width() {
        return this.stroke_width;
    }

    public TagInfo(Float r100, String r101, Float r102, Float r103, Float r104, Float r105, Float r106, String r107, Float r108, String r110, Float r111) {
        this.height = r100;
        this.align = r101;
        this.offset = r102;
        this.left_offset = r103;
        this.right_offset = r104;
        this.left_padding = r105;
        this.right_padding = r106;
        this.background_color = r107;
        this.stroke_width = r108;
        this.stroke_color = r110;
        this.corner_radius = r111;
    }

    public /* synthetic */ TagInfo(Float r110, String r111, Float r112, Float r113, Float r114, Float r115, Float r210, String r211, Float r212, String r213, Float r214, int r215, DefaultConstructorMarker r216) {
        int r100 = r215 & 1;
        Float r101 = Float.valueOf(0.0f);
        if (r100 == 0) goto L5;
        Float r102 = r101;
    L7:
        if ((r215 & 2) == 0) goto L9;
        String r103 = "center";
    L11:
        if ((r215 & 4) == 0) goto L13;
        Float r104 = r101;
    L15:
        if ((r215 & 8) == 0) goto L17;
        Float r105 = r101;
    L19:
        if ((r215 & 16) == 0) goto L21;
        Float r106 = r101;
    L23:
        if ((r215 & 32) == 0) goto L25;
        Float r107 = r101;
    L27:
        if ((r215 & 64) == 0) goto L29;
        Float r108 = r101;
    L30:
        String r116 = null;
        if ((r215 & 128) == 0) goto L33;
        String r109 = null;
    L35:
        if ((r215 & 256) == 0) goto L37;
        Float r117 = r101;
    L39:
        if ((r215 & 512) != 0) goto L43;
        r116 = r213;
    L43:
        if ((r215 & 1024) != 0) goto L46;
        r101 = r214;
    L46:
        this(r102, r103, r104, r105, r106, r107, r108, r109, r117, r116, r101);
        return;
    L37:
        r117 = r212;
        goto L39
    L33:
        r109 = r211;
        goto L35
    L29:
        r108 = r210;
        goto L30
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
