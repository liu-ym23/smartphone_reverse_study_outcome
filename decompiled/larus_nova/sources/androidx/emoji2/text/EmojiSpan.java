package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes17.dex */
public abstract class EmojiSpan extends ReplacementSpan {
    private short mHeight;
    private final TypefaceEmojiRasterizer mRasterizer;
    private float mRatio;
    private final Paint.FontMetricsInt mTmpFontMetrics;
    private short mWidth;

    public final int getId() {
        return getTypefaceRasterizer().getId();
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final float getRatio() {
        return this.mRatio;
    }

    public final TypefaceEmojiRasterizer getTypefaceRasterizer() {
        return this.mRasterizer;
    }

    public final int getWidth() {
        return this.mWidth;
    }

    public EmojiSpan(TypefaceEmojiRasterizer r100) {
        this.mTmpFontMetrics = new Paint.FontMetricsInt();
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRatio = 1.0f;
        Preconditions.checkNotNull(r100, "rasterizer cannot be null");
        this.mRasterizer = r100;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        r100.getFontMetricsInt(this.mTmpFontMetrics);
        Paint.FontMetricsInt r105 = this.mTmpFontMetrics;
        this.mRatio = (Math.abs(r105.descent - r105.ascent) * 1.0f) / this.mRasterizer.getHeight();
        this.mHeight = (short) (this.mRasterizer.getHeight() * this.mRatio);
        short r106 = (short) (this.mRasterizer.getWidth() * this.mRatio);
        this.mWidth = r106;
        if (r104 == null) goto L5;
        Paint.FontMetricsInt r107 = this.mTmpFontMetrics;
        r104.ascent = r107.ascent;
        r104.descent = r107.descent;
        r104.top = r107.top;
        r104.bottom = r107.bottom;
    L5:
        return r106;
    }
}
