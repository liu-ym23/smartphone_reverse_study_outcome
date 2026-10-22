package com.alibaba.gaiax.render.view.basic.richtext;

import androidx.camera.video.AudioStats;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b1\b\u0086\b\u0018\u0000 @2\u00020\u0001:\u0001@B¯\u0001\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0015J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00106\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00109\u001a\u0004\u0018\u00010\u000bHÆ\u0003J¶\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0003HÖ\u0001J\t\u0010?\u001a\u00020\u000bHÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b \u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b&\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010#\u001a\u0004\b'\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010#\u001a\u0004\b+\u0010\"¨\u0006A"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/richtext/RangeInfo;", "", "start", "", "end", SegmentStyle.UNDERLINE, "", "letter_spacing", "font_size", "", FontsContractCompat.Columns.WEIGHT, "", "font_family", "strike", "text_color", "tagInfo", "Lcom/alibaba/gaiax/render/view/basic/richtext/TagInfo;", "schema", "opt_symbol", "left_space_symbols", "right_space_symbols", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/alibaba/gaiax/render/view/basic/richtext/TagInfo;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getEnd", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFont_family", "()Ljava/lang/String;", "getFont_size", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFont_weight", "getLeft_space_symbols", "getLetter_spacing", "getOpt_symbol", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRight_space_symbols", "getSchema", "getStart", "getStrike", "getTagInfo", "()Lcom/alibaba/gaiax/render/view/basic/richtext/TagInfo;", "getText_color", "getUnderline", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/alibaba/gaiax/render/view/basic/richtext/TagInfo;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/alibaba/gaiax/render/view/basic/richtext/RangeInfo;", "equals", "other", "hashCode", "toString", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RangeInfo {
    public static final Companion Companion = null;
    private final Integer end;
    private final String font_family;
    private final Float font_size;
    private final String font_weight;
    private final String left_space_symbols;
    private final Integer letter_spacing;
    private final Boolean opt_symbol;
    private final String right_space_symbols;
    private final String schema;
    private final Integer start;
    private final Boolean strike;
    private final TagInfo tagInfo;
    private final String text_color;
    private final Boolean underline;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/richtext/RangeInfo$Companion;", "", "()V", "createByExtend", "Lcom/alibaba/gaiax/render/view/basic/richtext/RangeInfo;", "textModel", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final RangeInfo createByExtend(JSONObject r210) {
            Intrinsics.checkNotNullParameter(r210, "textModel");
            int r100 = r210.optInt("start", 0);
            int r101 = r210.optInt("end", 0);
            float r102 = (float) r210.optDouble("font_size", AudioStats.AUDIO_AMPLITUDE_NONE);
            String r110 = r210.optString(FontsContractCompat.Columns.WEIGHT, null);
            String r111 = r210.optString("font_family", null);
            String r112 = r210.optString("text_color", null);
            boolean r103 = r210.optBoolean(SegmentStyle.UNDERLINE, false);
            boolean r104 = r210.optBoolean("strike", false);
            int r105 = r210.optInt("letter_spacing", 0);
            TagInfo r113 = TagInfo.Companion.createByExtend(r210.optJSONObject("tag"));
            String r114 = r210.optString("schema", null);
            boolean r106 = r210.optBoolean("opt_symbol", false);
            String r211 = r210.optString("left_space_symbols", null);
            String r212 = r210.optString("right_space_symbols", null);
            return new RangeInfo(Integer.valueOf(r100), Integer.valueOf(r101), Boolean.valueOf(r103), Integer.valueOf(r105), Float.valueOf(r102), r110, r111, Boolean.valueOf(r104), r112, r113, r114, Boolean.valueOf(r106), r211, r212);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RangeInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public RangeInfo(Integer r110) {
        this(r110, null, null, null, null, null, null, null, null, null, null, null, null, null, 16382, null);
    }

    public RangeInfo(Integer r110, Integer r111) {
        this(r110, r111, null, null, null, null, null, null, null, null, null, null, null, null, 16380, null);
    }

    public RangeInfo(Integer r110, Integer r111, Boolean r210) {
        this(r110, r111, r210, null, null, null, null, null, null, null, null, null, null, null, 16376, null);
    }

    public RangeInfo(Integer r110, Integer r111, Boolean r210, Integer r211) {
        this(r110, r111, r210, r211, null, null, null, null, null, null, null, null, null, null, 16368, null);
    }

    public RangeInfo(Integer r110, Integer r111, Boolean r210, Integer r211, Float r212) {
        this(r110, r111, r210, r211, r212, null, null, null, null, null, null, null, null, null, 16352, null);
    }

    public RangeInfo(Integer r110, Integer r111, Boolean r210, Integer r211, Float r212, String r213) {
        this(r110, r111, r210, r211, r212, r213, null, null, null, null, null, null, null, null, 16320, null);
    }

    public RangeInfo(Integer r110, Integer r111, Boolean r210, Integer r211, Float r212, String r213, String r214) {
        this(r110, r111, r210, r211, r212, r213, r214, null, null, null, null, null, null, null, 16256, null);
    }

    public RangeInfo(Integer r110, Integer r111, Boolean r210, Integer r211, Float r212, String r213, String r214, Boolean r215) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, null, null, null, null, null, null, 16128, null);
    }

    public RangeInfo(Integer r110, Integer r111, Boolean r210, Integer r211, Float r212, String r213, String r214, Boolean r215, String r216) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, null, null, null, null, null, 15872, null);
    }

    public RangeInfo(Integer r110, Integer r111, Boolean r210, Integer r211, Float r212, String r213, String r214, Boolean r215, String r216, TagInfo r217) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, null, null, null, null, 15360, null);
    }

    public RangeInfo(Integer r110, Integer r111, Boolean r210, Integer r211, Float r212, String r213, String r214, Boolean r215, String r216, TagInfo r217, String r218) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, null, null, null, 14336, null);
    }

    public RangeInfo(Integer r110, Integer r111, Boolean r210, Integer r211, Float r212, String r213, String r214, Boolean r215, String r216, TagInfo r217, String r218, Boolean r219) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, null, null, 12288, null);
    }

    public RangeInfo(Integer r110, Integer r111, Boolean r210, Integer r211, Float r212, String r213, String r214, Boolean r215, String r216, TagInfo r217, String r218, Boolean r219, String r310) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, null, 8192, null);
    }

    public static /* synthetic */ RangeInfo copy$default(RangeInfo r110, Integer r111, Integer r112, Boolean r113, Integer r114, Float r210, String r211, String r212, Boolean r213, String r214, TagInfo r215, String r216, Boolean r217, String r218, String r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        Integer r100 = r110.start;
    L7:
        if ((r310 & 2) == 0) goto L9;
        Integer r101 = r110.end;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Boolean r102 = r110.underline;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Integer r103 = r110.letter_spacing;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Float r104 = r110.font_size;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = r110.font_weight;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r106 = r110.font_family;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Boolean r107 = r110.strike;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r115 = r110.text_color;
    L39:
        if ((r310 & 512) == 0) goto L41;
        TagInfo r116 = r110.tagInfo;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r117 = r110.schema;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Boolean r118 = r110.opt_symbol;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r119 = r110.left_space_symbols;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        String r108 = r110.right_space_symbols;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    public final Integer component1() {
        return this.start;
    }

    public final TagInfo component10() {
        return this.tagInfo;
    }

    public final String component11() {
        return this.schema;
    }

    public final Boolean component12() {
        return this.opt_symbol;
    }

    public final String component13() {
        return this.left_space_symbols;
    }

    public final String component14() {
        return this.right_space_symbols;
    }

    public final Integer component2() {
        return this.end;
    }

    public final Boolean component3() {
        return this.underline;
    }

    public final Integer component4() {
        return this.letter_spacing;
    }

    public final Float component5() {
        return this.font_size;
    }

    public final String component6() {
        return this.font_weight;
    }

    public final String component7() {
        return this.font_family;
    }

    public final Boolean component8() {
        return this.strike;
    }

    public final String component9() {
        return this.text_color;
    }

    public final RangeInfo copy(Integer r110, Integer r111, Boolean r112, Integer r210, Float r211, String r212, String r213, Boolean r214, String r215, TagInfo r216, String r217, Boolean r218, String r219, String r310) {
        return new RangeInfo(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RangeInfo) == true) goto L8;
        return false;
    L8:
        RangeInfo r101 = (RangeInfo) r100;
        if (Intrinsics.areEqual(this.start, r101.start) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.end, r101.end) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.underline, r101.underline) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.letter_spacing, r101.letter_spacing) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.font_size, r101.font_size) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.font_weight, r101.font_weight) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.font_family, r101.font_family) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.strike, r101.strike) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.text_color, r101.text_color) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagInfo, r101.tagInfo) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.opt_symbol, r101.opt_symbol) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.left_space_symbols, r101.left_space_symbols) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.right_space_symbols, r101.right_space_symbols) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.start;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.end;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.underline;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.letter_spacing;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.font_size;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.font_weight;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.font_family;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.strike;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.text_color;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        TagInfo r128 = this.tagInfo;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.schema;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.opt_symbol;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.left_space_symbols;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.right_space_symbols;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
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
        return "RangeInfo(start=" + this.start + ", end=" + this.end + ", underline=" + this.underline + ", letter_spacing=" + this.letter_spacing + ", font_size=" + this.font_size + ", font_weight=" + this.font_weight + ", font_family=" + this.font_family + ", strike=" + this.strike + ", text_color=" + this.text_color + ", tagInfo=" + this.tagInfo + ", schema=" + this.schema + ", opt_symbol=" + this.opt_symbol + ", left_space_symbols=" + this.left_space_symbols + ", right_space_symbols=" + this.right_space_symbols + ')';
    }

    public final Integer getEnd() {
        return this.end;
    }

    public final String getFont_family() {
        return this.font_family;
    }

    public final Float getFont_size() {
        return this.font_size;
    }

    public final String getFont_weight() {
        return this.font_weight;
    }

    public final String getLeft_space_symbols() {
        return this.left_space_symbols;
    }

    public final Integer getLetter_spacing() {
        return this.letter_spacing;
    }

    public final Boolean getOpt_symbol() {
        return this.opt_symbol;
    }

    public final String getRight_space_symbols() {
        return this.right_space_symbols;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Integer getStart() {
        return this.start;
    }

    public final Boolean getStrike() {
        return this.strike;
    }

    public final TagInfo getTagInfo() {
        return this.tagInfo;
    }

    public final String getText_color() {
        return this.text_color;
    }

    public final Boolean getUnderline() {
        return this.underline;
    }

    public RangeInfo(Integer r100, Integer r101, Boolean r102, Integer r103, Float r104, String r105, String r106, Boolean r107, String r108, TagInfo r110, String r111, Boolean r112, String r113, String r114) {
        this.start = r100;
        this.end = r101;
        this.underline = r102;
        this.letter_spacing = r103;
        this.font_size = r104;
        this.font_weight = r105;
        this.font_family = r106;
        this.strike = r107;
        this.text_color = r108;
        this.tagInfo = r110;
        this.schema = r111;
        this.opt_symbol = r112;
        this.left_space_symbols = r113;
        this.right_space_symbols = r114;
    }

    public /* synthetic */ RangeInfo(Integer r110, Integer r111, Boolean r112, Integer r113, Float r210, String r211, String r212, Boolean r213, String r214, TagInfo r215, String r216, Boolean r217, String r218, String r219, int r310, DefaultConstructorMarker r311) {
        Integer r100 = -1;
        if ((r310 & 1) == 0) goto L5;
        Integer r101 = r100;
    L7:
        if ((r310 & 2) != 0) goto L11;
        r100 = r111;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Boolean r102 = Boolean.FALSE;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Integer r103 = 0;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Float r104 = Float.valueOf(0.0f);
    L22:
        String r105 = "";
        if ((r310 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r310 & 128) == 0) goto L33;
        Boolean r108 = Boolean.FALSE;
    L34:
        String r114 = null;
        if ((r310 & 256) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        TagInfo r116 = null;
    L43:
        if ((r310 & 1024) != 0) goto L47;
        r105 = r216;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Boolean r117 = Boolean.FALSE;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r114 = r219;
    L58:
        this(r101, r100, r102, r103, r104, r106, r107, r108, r115, r116, r105, r117, r118, r114);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L34
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
