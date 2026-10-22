package androidx.compose.ui.text.android.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 )2\u00020\u0001:\u0001)B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0017JR\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/ui/text/android/style/PlaceholderSpan;", "Landroid/text/style/ReplacementSpan;", "width", "", "widthUnit", "", "height", "heightUnit", "pxPerSp", "verticalAlign", "<init>", "(FIFIFI)V", "getVerticalAlign", "()I", "value", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetrics", "getFontMetrics", "()Landroid/graphics/Paint$FontMetricsInt;", "widthPx", "getWidthPx", "heightPx", "getHeightPx", "isLaidOut", "", "getSize", "paint", "Landroid/graphics/Paint;", "text", "", "start", "end", "fm", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "top", "y", "bottom", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlaceholderSpan extends ReplacementSpan {
    public static final int $stable = 0;
    public static final int ALIGN_ABOVE_BASELINE = 0;
    public static final int ALIGN_BOTTOM = 2;
    public static final int ALIGN_CENTER = 3;
    public static final int ALIGN_TEXT_BOTTOM = 5;
    public static final int ALIGN_TEXT_CENTER = 6;
    public static final int ALIGN_TEXT_TOP = 4;
    public static final int ALIGN_TOP = 1;
    public static final Companion Companion = null;
    public static final int UNIT_EM = 1;
    public static final int UNIT_SP = 0;
    public static final int UNIT_UNSPECIFIED = 2;
    private Paint.FontMetricsInt fontMetrics;
    private final float height;
    private int heightPx;
    private final int heightUnit;
    private boolean isLaidOut;
    private final float pxPerSp;
    private final int verticalAlign;
    private final float width;
    private int widthPx;
    private final int widthUnit;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/android/style/PlaceholderSpan$Companion;", "", "<init>", "()V", "ALIGN_ABOVE_BASELINE", "", "ALIGN_TOP", "ALIGN_BOTTOM", "ALIGN_CENTER", "ALIGN_TEXT_TOP", "ALIGN_TEXT_BOTTOM", "ALIGN_TEXT_CENTER", "UNIT_SP", "UNIT_EM", "UNIT_UNSPECIFIED", "VerticalAlign", "Unit", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/text/android/style/PlaceholderSpan$Companion$Unit;", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface Unit {
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/text/android/style/PlaceholderSpan$Companion$VerticalAlign;", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface VerticalAlign {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
    }

    public final Paint.FontMetricsInt getFontMetrics() {
        Paint.FontMetricsInt r100 = this.fontMetrics;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
        return null;
    }

    public final int getHeightPx() {
        if (this.isLaidOut == true) goto L6;
        InlineClassHelperKt.throwIllegalStateException("PlaceholderSpan is not laid out yet.");
    L6:
        return this.heightPx;
    }

    public final int getWidthPx() {
        if (this.isLaidOut == true) goto L6;
        InlineClassHelperKt.throwIllegalStateException("PlaceholderSpan is not laid out yet.");
    L6:
        return this.widthPx;
    }

    public final int getVerticalAlign() {
        return this.verticalAlign;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        this.isLaidOut = true;
        float r105 = r100.getTextSize();
        this.fontMetrics = r100.getFontMetricsInt();
        if (getFontMetrics().descent <= getFontMetrics().ascent) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Invalid fontMetrics: line height can not be negative.");
    L8:
        int r107 = this.widthUnit;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L12;
        float r108 = this.width * r105;
    L15:
        this.widthPx = PlaceholderSpan_androidKt.ceilToInt(r108);
        int r109 = this.heightUnit;
        if (r109 == 0) goto L21;
        if (r109 != 1) goto L19;
        int r110 = PlaceholderSpan_androidKt.ceilToInt(this.height * r105);
    L22:
        this.heightPx = r110;
        if (r104 == null) goto L41;
        r104.ascent = getFontMetrics().ascent;
        r104.descent = getFontMetrics().descent;
        r104.leading = getFontMetrics().leading;
        switch(this.verticalAlign) {
            case 0: goto L37;
            case 1: goto L34;
            case 2: goto L31;
            case 3: goto L28;
            case 4: goto L34;
            case 5: goto L31;
            case 6: goto L28;
            default: goto L26;
        };
    L26:
        InlineClassHelperKt.throwIllegalArgumentException("Unknown verticalAlign.");
    L39:
        r104.top = Math.min(getFontMetrics().top, r104.ascent);
        r104.bottom = Math.max(getFontMetrics().bottom, r104.descent);
        goto L41
    L28:
        if ((r104.descent - r104.ascent) >= getHeightPx()) goto L39;
        int r111 = r104.ascent - ((getHeightPx() - (r104.descent - r104.ascent)) / 2);
        r104.ascent = r111;
        r104.descent = r111 + getHeightPx();
        goto L39
    L31:
        if (r104.ascent <= (r104.descent - getHeightPx())) goto L39;
        r104.ascent = r104.descent - getHeightPx();
        goto L39
    L34:
        if ((r104.ascent + getHeightPx()) <= r104.descent) goto L39;
        r104.descent = r104.ascent + getHeightPx();
        goto L39
    L37:
        if (r104.ascent <= (-getHeightPx())) goto L39;
        r104.ascent = -getHeightPx();
    L41:
        return getWidthPx();
    L19:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Unsupported unit.");
        throw new KotlinNothingValueException();
    L21:
        r110 = PlaceholderSpan_androidKt.ceilToInt(this.height * this.pxPerSp);
        goto L22
    L12:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Unsupported unit.");
        throw new KotlinNothingValueException();
    L14:
        r108 = this.width * this.pxPerSp;
        goto L15
    L5:
        r106 = false;
        goto L6
    }

    public PlaceholderSpan(float r100, int r101, float r102, int r103, float r104, int r105) {
        this.width = r100;
        this.widthUnit = r101;
        this.height = r102;
        this.heightUnit = r103;
        this.pxPerSp = r104;
        this.verticalAlign = r105;
    }
}
