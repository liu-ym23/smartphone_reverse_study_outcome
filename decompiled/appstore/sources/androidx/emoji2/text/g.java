package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f3081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EmojiMetadata f3082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short f3083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short f3084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3085e;

    public g(EmojiMetadata r10) {
        this.f3081a = new Paint.FontMetricsInt();
        this.f3083c = -1;
        this.f3084d = -1;
        this.f3085e = 1.0f;
        androidx.core.util.e.h(r10, "metadata cannot be null");
        this.f3082b = r10;
    }

    public final EmojiMetadata a() {
        return this.f3082b;
    }

    public final int b() {
        return this.f3083c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r10, CharSequence r11, int r12, int r13, Paint.FontMetricsInt r14) {
        r10.getFontMetricsInt(this.f3081a);
        Paint.FontMetricsInt r15 = this.f3081a;
        this.f3085e = (Math.abs(r15.descent - r15.ascent) * 1.0f) / this.f3082b.e();
        this.f3084d = (short) (this.f3082b.e() * this.f3085e);
        short r16 = (short) (this.f3082b.i() * this.f3085e);
        this.f3083c = r16;
        if (r14 == null) goto L5;
        Paint.FontMetricsInt r17 = this.f3081a;
        r14.ascent = r17.ascent;
        r14.descent = r17.descent;
        r14.top = r17.top;
        r14.bottom = r17.bottom;
    L5:
        return r16;
    }
}
