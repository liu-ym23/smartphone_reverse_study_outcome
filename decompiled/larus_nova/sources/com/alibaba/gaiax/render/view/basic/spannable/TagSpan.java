package com.alibaba.gaiax.render.view.basic.spannable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.alibaba.gaiax.render.view.basic.richtext.TagInfo;
import com.alibaba.gaiax.template.GXSize;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0002&'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JP\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0016J4\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006("}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/TagSpan;", "Landroid/text/style/ReplacementSpan;", "tagInfo", "Lcom/alibaba/gaiax/render/view/basic/richtext/TagInfo;", "(Lcom/alibaba/gaiax/render/view/basic/richtext/TagInfo;)V", "align", "Lcom/alibaba/gaiax/render/view/basic/spannable/TagSpan$AnchorPoint;", "backgroundColor", "", "Ljava/lang/Integer;", "cornerRadiusPX", "", "height", "leftOffsetPX", "leftPaddingPX", "offset", "rightOffsetPX", "rightPaddingPX", "strokeColor", "strokeWidthPX", "Ljava/lang/Float;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "AnchorPoint", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TagSpan extends ReplacementSpan {
    public static final Companion Companion = null;
    private final AnchorPoint align;
    private final Integer backgroundColor;
    private final float cornerRadiusPX;
    private final int height;
    private final int leftOffsetPX;
    private final int leftPaddingPX;
    private final int offset;
    private final int rightOffsetPX;
    private final int rightPaddingPX;
    private final Integer strokeColor;
    private final Float strokeWidthPX;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/TagSpan$AnchorPoint;", "", "(Ljava/lang/String;I)V", "CENTER", "BOTTOM", "TOP", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum AnchorPoint extends Enum<AnchorPoint> {
        private static final /* synthetic */ AnchorPoint[] $VALUES = null;
        public static final AnchorPoint BOTTOM = null;
        public static final AnchorPoint CENTER = null;
        public static final AnchorPoint TOP = null;

        private static final /* synthetic */ AnchorPoint[] $values() {
            return new AnchorPoint[]{CENTER, BOTTOM, TOP};
        }

        public static AnchorPoint valueOf(String r100) {
            return (AnchorPoint) a.a(AnchorPoint.class, r100);
        }

        public static AnchorPoint[] values() {
            return (AnchorPoint[]) $VALUES.clone();
        }

        static {
            CENTER = new AnchorPoint("CENTER", 0);
            BOTTOM = new AnchorPoint("BOTTOM", 1);
            TOP = new AnchorPoint("TOP", 2);
            $VALUES = $values();
        }

        private AnchorPoint(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/TagSpan$Companion;", "", "()V", "getAnchorPoint", "Lcom/alibaba/gaiax/render/view/basic/spannable/TagSpan$AnchorPoint;", "str", "", "needBuildTagSpan", "", "rangeInfo", "Lcom/alibaba/gaiax/render/view/basic/richtext/TagInfo;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final AnchorPoint getAnchorPoint(String r100) {
            if (r100 == null) goto L23;
            int r101 = r100.hashCode();
            if (r101 == (-1383228885)) goto L19;
            if (r101 == (-1364013995)) goto L15;
            if (r101 != 115029) goto L23;
            if (r100.equals("top") == false) goto L23;
            return AnchorPoint.TOP;
        L15:
            if (r100.equals("center") == false) goto L23;
            return AnchorPoint.CENTER;
        L19:
            if (r100.equals("bottom") == false) goto L23;
            return AnchorPoint.BOTTOM;
        L23:
            return AnchorPoint.CENTER;
        }

        public final boolean needBuildTagSpan(TagInfo r100) {
            if (r100 == null) goto L52;
            Float r101 = r100.getLeft_offset();
            if (r101 == null) goto L7;
            float r102 = r101.floatValue();
        L9:
            if (r102 > 0.0f) goto L50;
            Float r103 = r100.getRight_offset();
            if (r103 == null) goto L13;
            float r104 = r103.floatValue();
        L15:
            if (r104 > 0.0f) goto L50;
            Float r105 = r100.getRight_padding();
            if (r105 == null) goto L19;
            float r106 = r105.floatValue();
        L21:
            if (r106 > 0.0f) goto L50;
            Float r107 = r100.getLeft_padding();
            if (r107 == null) goto L25;
            float r108 = r107.floatValue();
        L27:
            if (r108 > 0.0f) goto L50;
            String r109 = r100.getBackground_color();
            if (r109 != null) goto L31;
        L34:
            boolean r110 = true;
        L35:
            if (r110 == false) goto L50;
            String r111 = r100.getStroke_color();
            if (r111 != null) goto L39;
        L42:
            boolean r112 = true;
        L43:
            if (r112 == false) goto L50;
            Float r113 = r100.getStroke_width();
            if (r113 == null) goto L47;
            float r114 = r113.floatValue();
        L49:
            if (r114 > 0.0f) goto L50;
            return false;
        L47:
            r114 = 0.0f;
            goto L49
        L39:
            if (r111.length() == 0) goto L42;
            r112 = false;
            goto L43
        L31:
            if (r109.length() == 0) goto L34;
            r110 = false;
            goto L35
        L25:
            r108 = 0.0f;
            goto L27
        L19:
            r106 = 0.0f;
            goto L21
        L13:
            r104 = 0.0f;
        L50:
            return true;
        L7:
            r102 = 0.0f;
            goto L9
        L52:
            return false;
        }

        public static final /* synthetic */ AnchorPoint access$getAnchorPoint(Companion r100, String r101) {
            return r100.getAnchorPoint(r101);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[AnchorPoint.values().length];
            r100[AnchorPoint.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AnchorPoint.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AnchorPoint.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TagSpan(TagInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "tagInfo");
        Float r101 = r100.getHeight();
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = GXSize.Companion.dpToIntPx(r101.floatValue());
    L6:
        this.height = r103;
        this.align = Companion.access$getAnchorPoint(Companion, r100.getAlign());
        Float r104 = r100.getOffset();
        if (r104 == null) goto L9;
        int r105 = GXSize.Companion.dpToIntPx(r104.floatValue());
    L10:
        this.offset = r105;
        Float r106 = r100.getLeft_offset();
        if (r106 == null) goto L13;
        int r107 = GXSize.Companion.dpToIntPx(r106.floatValue());
    L14:
        this.leftOffsetPX = r107;
        Float r108 = r100.getRight_offset();
        if (r108 == null) goto L17;
        int r109 = GXSize.Companion.dpToIntPx(r108.floatValue());
    L18:
        this.rightOffsetPX = r109;
        Float r110 = r100.getLeft_padding();
        if (r110 == null) goto L21;
        int r111 = GXSize.Companion.dpToIntPx(r110.floatValue());
    L22:
        this.leftPaddingPX = r111;
        Float r112 = r100.getRight_padding();
        if (r112 == null) goto L25;
        r102 = GXSize.Companion.dpToIntPx(r112.floatValue());
    L25:
        this.rightPaddingPX = r102;
        Float r113 = r100.getStroke_width();
        Integer r114 = null;
        if (r113 == null) goto L28;
        Float r115 = Float.valueOf(GXSize.Companion.dpToPx(r113.floatValue()));
    L29:
        this.strokeWidthPX = r115;
        Float r116 = r100.getCorner_radius();
        if (r116 == null) goto L32;
        float r117 = GXSize.Companion.dpToPx(r116.floatValue());
    L33:
        this.cornerRadiusPX = r117;
        String r118 = r100.getBackground_color();
        if (r118 == null) goto L36;
        Integer r119 = Integer.valueOf(ColorProtector.parseColor(r118));
    L37:
        this.backgroundColor = r119;
        String r120 = r100.getStroke_color();
        if (r120 == null) goto L40;
        r114 = Integer.valueOf(ColorProtector.parseColor(r120));
    L40:
        this.strokeColor = r114;
        return;
    L36:
        r119 = null;
        goto L37
    L32:
        r117 = 0.0f;
        goto L33
    L28:
        r115 = null;
        goto L29
    L21:
        r111 = 0;
        goto L22
    L17:
        r109 = 0;
        goto L18
    L13:
        r107 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return (((((int) r100.measureText(r101, r102, r103)) + this.leftOffsetPX) + this.rightOffsetPX) + this.leftPaddingPX) + this.rightPaddingPX;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r210, CharSequence r211, int r212, int r213, float r214, int r215, int r216, int r217, Paint r218) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        Intrinsics.checkNotNullParameter(r211, "text");
        Intrinsics.checkNotNullParameter(r218, "paint");
        float r100 = r218.getStrokeWidth();
        int r101 = r218.getColor();
        float r110 = r215;
        float r111 = r217;
        int r112 = this.height;
        if (r112 > 0) goto L5;
        r112 = r217 - r215;
    L5:
        Float r113 = this.strokeWidthPX;
        if (r113 == null) goto L8;
        float r114 = r113.floatValue();
    L9:
        r218.setStrokeWidth(r114);
        AnchorPoint r115 = this.align;
        int[] r116 = WhenMappings.$EnumSwitchMapping$0;
        int r117 = r116[r115.ordinal()];
        if (r117 == 1) goto L17;
        if (r117 != 2) goto L13;
        float r118 = (r218.getStrokeWidth() * 0.5f) + r110;
        float r119 = r110 + r112;
        float r120 = r218.getStrokeWidth();
    L18:
        float r121 = r118;
        r111 = r119 - (r120 * 1.5f);
        r110 = r121;
    L20:
        if (this.backgroundColor == null) goto L24;
        r218.setStyle(Paint.Style.FILL);
        r218.setColor(this.backgroundColor.intValue());
        RectF r122 = new RectF((r214 + (r218.getStrokeWidth() / 2)) + this.leftOffsetPX, r110, (((r214 + r218.measureText(r211, r212, r213)) + this.leftPaddingPX) + this.rightPaddingPX) + this.leftOffsetPX, r111);
        float r123 = this.cornerRadiusPX;
        r210.drawRoundRect(r122, r123, r123, r218);
    L24:
        if (this.strokeColor == null) goto L26;
        r218.setStyle(Paint.Style.STROKE);
        r218.setColor(this.strokeColor.intValue());
        RectF r124 = new RectF((r214 + (r218.getStrokeWidth() / 2)) + this.leftOffsetPX, r110, (((r214 + r218.measureText(r211, r212, r213)) + this.leftPaddingPX) + this.rightPaddingPX) + this.leftOffsetPX, r111);
        float r125 = this.cornerRadiusPX;
        r210.drawRoundRect(r124, r125, r125, r218);
    L26:
        r218.setColor(r101);
        r218.setStrokeWidth(r100);
        r218.setStyle(Paint.Style.FILL);
        float r102 = (r217 - r215) / 2;
        float r103 = 2;
        float r104 = (r102 - (r218.getFontMetrics().top / r103)) - (r218.getFontMetrics().bottom / r103);
        int r105 = r116[this.align.ordinal()];
        if (r105 != 1) goto L29;
    L36:
        r210.drawText(r211, r212, r213, (r214 + this.leftOffsetPX) + this.leftPaddingPX, r104 + this.offset, r218);
        return;
    L29:
        if (r105 != 2) goto L31;
        r104 = (r104 - r102) + (r112 / 2);
        goto L36
    L31:
        if (r105 != 3) goto L34;
        r104 = (r104 + r102) - (r112 / 2);
        goto L36
    L34:
        throw new NoWhenBranchMatchedException();
    L13:
        if (r117 != 3) goto L20;
        r110 = (r111 - r112) + (r218.getStrokeWidth() * 0.5f);
        r111 = r111 - (r218.getStrokeWidth() * 1.5f);
        goto L20
    L17:
        int r126 = ((r217 - r215) - r112) / 2;
        r118 = (r215 + r126) + (r218.getStrokeWidth() * 0.5f);
        r119 = r217 - r126;
        r120 = r218.getStrokeWidth();
        goto L18
    L8:
        r114 = r100;
        goto L9
    }
}
