package com.stepos.widget.recipient;

import I6.a;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.style.ReplacementSpan;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.Px;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001<B\u0013\b\u0016\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\bBC\b\u0016\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0005\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u001bJ\r\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010\u001bJ;\u0010(\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b(\u0010)JY\u00101\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020*2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b1\u00102R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0004\u00103R\u001a\u0010\u0007\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0007\u00103\u0012\u0004\b4\u00105R\u0014\u0010\t\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u00103R\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u00103R\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u00103R\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/stepos/widget/recipient/StepOSParcelableImageSpan;", "Landroid/text/style/ReplacementSpan;", "Landroid/text/ParcelableSpan;", "", "systemResId", AppAgent.CONSTRUCT, "(I)V", "verticalAlignment", "(II)V", "insetLeft", "insetTop", "insetRight", "insetBottom", "(IIIIII)V", "Landroid/os/Parcel;", "src", "(Landroid/os/Parcel;)V", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint$FontMetricsInt;", "getPaintFontMetricsInt", "(Landroid/graphics/Paint;)Landroid/graphics/Paint$FontMetricsInt;", "Landroid/graphics/drawable/Drawable;", "getCachedDrawable", "()Landroid/graphics/drawable/Drawable;", "getDrawable", "describeContents", "()I", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "getSpanTypeId", "getVerticalAlignment", "", "text", "start", "end", "fm", "getSize", "(Landroid/graphics/Paint;Ljava/lang/CharSequence;IILandroid/graphics/Paint$FontMetricsInt;)I", "Landroid/graphics/Canvas;", "canvas", "", "x", "top", "y", "bottom", "draw", "(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IIFIIILandroid/graphics/Paint;)V", "I", "getVerticalAlignment$annotations", "()V", "fontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "Ljava/lang/ref/WeakReference;", "drawableRef", "Ljava/lang/ref/WeakReference;", "Companion", "I6/a", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StepOSParcelableImageSpan extends ReplacementSpan implements ParcelableSpan {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    public static final a Companion = new a();
    public static final int PARCELABLE_IMAGE_SPAN = 25;
    private static final String TAG = "ParcelableImageSpan";
    public static final int TTS_SPAN = 24;
    private WeakReference<Drawable> drawableRef;
    private Paint.FontMetricsInt fontMetrics;

    @Px
    private final int insetBottom;

    @Px
    private final int insetLeft;

    @Px
    private final int insetRight;

    @Px
    private final int insetTop;

    @DrawableRes
    private final int systemResId;
    private final int verticalAlignment;

    public StepOSParcelableImageSpan(@DrawableRes int i) {
        this(i, 2);
    }

    private final Drawable getCachedDrawable() throws Resources.NotFoundException {
        WeakReference<Drawable> weakReference = this.drawableRef;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = getDrawable();
        this.drawableRef = new WeakReference<>(drawable2);
        return drawable2;
    }

    private final Paint.FontMetricsInt getPaintFontMetricsInt(Paint paint) {
        Paint.FontMetricsInt fontMetricsInt = this.fontMetrics;
        if (fontMetricsInt != null) {
            paint.getFontMetricsInt(fontMetricsInt);
            return fontMetricsInt;
        }
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        k.e(fontMetricsInt2, "getFontMetricsInt(...)");
        this.fontMetrics = fontMetricsInt2;
        return fontMetricsInt2;
    }

    private static /* synthetic */ void getVerticalAlignment$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x10, int top, int y, int bottom, Paint paint) throws Resources.NotFoundException {
        int i;
        k.f(canvas, "canvas");
        k.f(paint, "paint");
        Drawable cachedDrawable = getCachedDrawable();
        canvas.save();
        int i6 = bottom - cachedDrawable.getBounds().bottom;
        int i10 = this.verticalAlignment;
        if (i10 != 2) {
            if (i10 == 1) {
                i = getPaintFontMetricsInt(paint).descent;
            }
            canvas.translate(x10, i6);
            cachedDrawable.draw(canvas);
            canvas.restore();
        }
        Paint.FontMetricsInt paintFontMetricsInt = getPaintFontMetricsInt(paint);
        i = ((paintFontMetricsInt.descent - paintFontMetricsInt.ascent) - cachedDrawable.getBounds().bottom) >> 1;
        i6 -= i;
        canvas.translate(x10, i6);
        cachedDrawable.draw(canvas);
        canvas.restore();
    }

    public final Drawable getDrawable() throws Resources.NotFoundException {
        try {
            Drawable drawable = Resources.getSystem().getDrawable(this.systemResId, null);
            k.e(drawable, "getDrawable(...)");
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.insetLeft;
            if (i != 0 || this.insetTop != 0 || this.insetRight != 0 || this.insetBottom != 0) {
                intrinsicWidth += i + this.insetRight;
                intrinsicHeight += this.insetTop + this.insetBottom;
                drawable = new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
            }
            if (intrinsicWidth < 0) {
                intrinsicWidth = 0;
            }
            if (intrinsicHeight < 0) {
                intrinsicHeight = 0;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            return drawable;
        } catch (Exception e) {
            Log.e(TAG, "Unable to find resource: " + this.systemResId, e);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            colorDrawable.setBounds(0, 0, 0, 0);
            return colorDrawable;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        k.f(paint, "paint");
        return getCachedDrawable().getBounds().right;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 25;
    }

    public final int getVerticalAlignment() {
        return this.verticalAlignment;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeInt(getVerticalAlignment());
        dest.writeInt(this.systemResId);
        dest.writeInt(this.insetLeft);
        dest.writeInt(this.insetTop);
        dest.writeInt(this.insetRight);
        dest.writeInt(this.insetBottom);
    }

    public StepOSParcelableImageSpan(@DrawableRes int i, int i6) {
        this(i, i6, 0, 0, 0, 0);
    }

    public StepOSParcelableImageSpan(@DrawableRes int i, int i6, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        this.verticalAlignment = i6;
        this.systemResId = i;
        this.insetLeft = i10;
        this.insetTop = i11;
        this.insetRight = i12;
        this.insetBottom = i13;
    }

    public StepOSParcelableImageSpan(Parcel src) {
        k.f(src, "src");
        this.verticalAlignment = src.readInt();
        this.systemResId = src.readInt();
        this.insetLeft = src.readInt();
        this.insetTop = src.readInt();
        this.insetRight = src.readInt();
        this.insetBottom = src.readInt();
    }
}
