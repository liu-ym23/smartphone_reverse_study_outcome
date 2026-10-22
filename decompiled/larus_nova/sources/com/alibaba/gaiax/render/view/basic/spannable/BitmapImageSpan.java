package com.alibaba.gaiax.render.view.basic.spannable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.alibaba.gaiax.template.GXSize;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0002*+Bk\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012JP\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%H\u0016J2\u0010&\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J \u0010)\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/BitmapImageSpan;", "Landroid/text/style/ReplacementSpan;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "width", "", "height", "offset", "", "leftOffset", "rightOffset", "corners", "isSquare", "", "anchorPoint", "Lcom/alibaba/gaiax/render/view/basic/spannable/BitmapImageSpan$AnchorPoint;", "(Landroid/content/Context;Landroid/graphics/Bitmap;IILjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;ZLcom/alibaba/gaiax/render/view/basic/spannable/BitmapImageSpan$AnchorPoint;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "leftOffsetPX", "mCorners", "rightOffsetPX", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "scaleDrawableWithAspectRatio", "AnchorPoint", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BitmapImageSpan extends ReplacementSpan {
    public static final Companion Companion = null;
    private final AnchorPoint anchorPoint;
    private final Drawable drawable;
    private final int leftOffsetPX;
    private final float mCorners;
    private final int offset;
    private final int rightOffsetPX;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/BitmapImageSpan$AnchorPoint;", "", "(Ljava/lang/String;I)V", "CENTER", "LINE_BOTTOM", "TOP", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum AnchorPoint extends Enum<AnchorPoint> {
        private static final /* synthetic */ AnchorPoint[] $VALUES = null;
        public static final AnchorPoint CENTER = null;
        public static final AnchorPoint LINE_BOTTOM = null;
        public static final AnchorPoint TOP = null;

        private static final /* synthetic */ AnchorPoint[] $values() {
            return new AnchorPoint[]{CENTER, LINE_BOTTOM, TOP};
        }

        public static AnchorPoint valueOf(String r100) {
            return (AnchorPoint) a.a(AnchorPoint.class, r100);
        }

        public static AnchorPoint[] values() {
            return (AnchorPoint[]) $VALUES.clone();
        }

        static {
            CENTER = new AnchorPoint("CENTER", 0);
            LINE_BOTTOM = new AnchorPoint("LINE_BOTTOM", 1);
            TOP = new AnchorPoint("TOP", 2);
            $VALUES = $values();
        }

        private AnchorPoint(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/BitmapImageSpan$Companion;", "", "()V", "getAnchorPoint", "Lcom/alibaba/gaiax/render/view/basic/spannable/BitmapImageSpan$AnchorPoint;", "str", "", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final AnchorPoint getAnchorPoint(String r100) {
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
            return AnchorPoint.LINE_BOTTOM;
        L23:
            return AnchorPoint.CENTER;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[AnchorPoint.values().length];
            r100[AnchorPoint.LINE_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AnchorPoint.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AnchorPoint.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BitmapImageSpan(Context r110, Bitmap r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, SimplayerImageStrategy.RESULT_BITMAP);
        this(r110, r111, r112, r113, null, null, null, null, false, null, 1008, null);
    }

    public BitmapImageSpan(Context r110, Bitmap r111, int r112, int r113, Float r114) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, SimplayerImageStrategy.RESULT_BITMAP);
        this(r110, r111, r112, r113, r114, null, null, null, false, null, 992, null);
    }

    public BitmapImageSpan(Context r110, Bitmap r111, int r112, int r113, Float r114, Float r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, SimplayerImageStrategy.RESULT_BITMAP);
        this(r110, r111, r112, r113, r114, r210, null, null, false, null, 960, null);
    }

    public BitmapImageSpan(Context r110, Bitmap r111, int r112, int r113, Float r114, Float r210, Float r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, SimplayerImageStrategy.RESULT_BITMAP);
        this(r110, r111, r112, r113, r114, r210, r211, null, false, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT, null);
    }

    public BitmapImageSpan(Context r110, Bitmap r111, int r112, int r113, Float r114, Float r210, Float r211, Float r212) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, SimplayerImageStrategy.RESULT_BITMAP);
        this(r110, r111, r112, r113, r114, r210, r211, r212, false, null, ISmModel.VERSION_0300, null);
    }

    public BitmapImageSpan(Context r110, Bitmap r111, int r112, int r113, Float r114, Float r210, Float r211, Float r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, SimplayerImageStrategy.RESULT_BITMAP);
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, null, 512, null);
    }

    private final void scaleDrawableWithAspectRatio(Bitmap r100, int r101, int r102) {
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        float r105 = 1.0f;
        if (r101 <= 0) goto L5;
        float r106 = r103 / r101;
    L6:
        if (r102 <= 0) goto L8;
        r105 = r104 / r102;
    L8:
        float r107 = Math.max(r106, r105);
        Drawable r108 = this.drawable;
        boolean r109 = true;
        if (r103 > 0) goto L11;
    L16:
        int r110 = 0;
    L17:
        if (r104 > 0) goto L19;
    L24:
        int r111 = 0;
    L25:
        r108.setBounds(0, 0, r110, r111);
        return;
    L19:
        if (r107 == 0.0f) goto L22;
        r109 = false;
    L22:
        if (r109 == true) goto L24;
        r111 = (int) (r104 / r107);
        goto L25
    L11:
        if (r107 != 0.0f) goto L13;
        boolean r112 = true;
    L14:
        if (r112 == true) goto L16;
        r110 = (int) (r103 / r107);
        goto L17
    L13:
        r112 = false;
        goto L14
    L5:
        r106 = 1.0f;
        goto L6
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        return (this.drawable.getBounds().right + this.rightOffsetPX) + this.leftOffsetPX;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        r100.save();
        int r109 = WhenMappings.$EnumSwitchMapping$0[this.anchorPoint.ordinal()];
        if (r109 != 1) goto L5;
    L12:
        r100.translate(r104 + this.leftOffsetPX, ((r107 - this.drawable.getBounds().bottom) + this.offset) * 1.0f);
        this.drawable.draw(r100);
        r100.restore();
        return;
    L5:
        if (r109 != 2) goto L7;
        r107 = ((r107 - r105) + this.drawable.getBounds().bottom) / 2;
        goto L12
    L7:
        if (r109 != 3) goto L10;
        r107 = this.drawable.getBounds().bottom;
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public BitmapImageSpan(Context r100, Bitmap r101, int r102, int r103, Float r104, Float r105, Float r106, Float r107, boolean r110, AnchorPoint r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r111, "anchorPoint");
        this.anchorPoint = r111;
        if (r104 == null) goto L5;
        int r108 = GXSize.Companion.dpToIntPx(r104.floatValue());
    L6:
        this.offset = r108;
        if (r106 == null) goto L9;
        int r109 = GXSize.Companion.dpToIntPx(r106.floatValue());
    L10:
        this.rightOffsetPX = r109;
        if (r105 == null) goto L13;
        int r112 = GXSize.Companion.dpToIntPx(r105.floatValue());
    L14:
        this.leftOffsetPX = r112;
        if (r107 == null) goto L17;
        float r113 = GXSize.Companion.dpToPx(r107.floatValue());
    L18:
        this.mCorners = r113;
        RoundedBitmapDrawable r114 = RoundedBitmapDrawableFactory.create(r100.getResources(), r101);
        r114.setCornerRadius(r113);
        this.drawable = r114;
        if (r102 > 0) goto L21;
        r102 = r101.getWidth();
    L21:
        if (r103 > 0) goto L23;
        r103 = r101.getHeight();
    L23:
        if (r110 == false) goto L25;
        scaleDrawableWithAspectRatio(r101, r102, r103);
        return;
    L25:
        r114.setBounds(0, 0, r102, r103);
        return;
    L17:
        r113 = 0.0f;
        goto L18
    L13:
        r112 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r108 = 0;
        goto L6
    }

    public /* synthetic */ BitmapImageSpan(Context r110, Bitmap r111, int r112, int r113, Float r114, Float r210, Float r211, Float r212, boolean r213, AnchorPoint r214, int r215, DefaultConstructorMarker r216) {
        int r100 = r215 & 16;
        Float r101 = Float.valueOf(0.0f);
        if (r100 == 0) goto L5;
        Float r102 = r101;
    L7:
        if ((r215 & 32) == 0) goto L9;
        Float r103 = r101;
    L11:
        if ((r215 & 64) == 0) goto L13;
        Float r115 = r101;
    L15:
        if ((r215 & 128) == 0) goto L17;
        Float r116 = r101;
    L19:
        if ((r215 & 256) == 0) goto L21;
        boolean r117 = true;
    L23:
        if ((r215 & 512) == 0) goto L25;
        AnchorPoint r118 = AnchorPoint.LINE_BOTTOM;
    L26:
        this(r110, r111, r112, r113, r102, r103, r115, r116, r117, r118);
        return;
    L25:
        r118 = r214;
        goto L26
    L21:
        r117 = r213;
        goto L23
    L17:
        r116 = r212;
        goto L19
    L13:
        r115 = r211;
        goto L15
    L9:
        r103 = r210;
        goto L11
    L5:
        r102 = r114;
        goto L7
    }
}
