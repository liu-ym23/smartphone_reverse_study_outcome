package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class EmojiSpan extends ReplacementSpan {
    private short mHeight;
    private final e mMetadata;
    private float mRatio;
    private final Paint.FontMetricsInt mTmpFontMetrics;
    private short mWidth;

    EmojiSpan(e r2) {
        this.mTmpFontMetrics = new Paint.FontMetricsInt();
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRatio = 1.0f;
        androidx.core.util.g.a(r2, "metadata cannot be null");
        this.mMetadata = r2;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        r1.getFontMetricsInt(this.mTmpFontMetrics);
        this.mRatio = (Math.abs(this.mTmpFontMetrics.descent - this.mTmpFontMetrics.ascent) * 1.0f) / this.mMetadata.c();
        this.mHeight = (short) (this.mMetadata.c() * this.mRatio);
        this.mWidth = (short) (this.mMetadata.b() * this.mRatio);
        if (r5 == null) goto L6;
        r5.ascent = this.mTmpFontMetrics.ascent;
        r5.descent = this.mTmpFontMetrics.descent;
        r5.top = this.mTmpFontMetrics.top;
        r5.bottom = this.mTmpFontMetrics.bottom;
    L6:
        return this.mWidth;
    }

    public final e getMetadata() {
        return this.mMetadata;
    }

    final int getWidth() {
        return this.mWidth;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    final float getRatio() {
        return this.mRatio;
    }

    public final int getId() {
        return getMetadata().a();
    }
}
