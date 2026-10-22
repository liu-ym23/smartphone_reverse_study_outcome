package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0002\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010%\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "", "text", AppAgent.CONSTRUCT, "(Ljava/lang/CharSequence;)V", "", "start", "end", "textStart", "textEnd", "LC7/r;", "replace", "(IILjava/lang/CharSequence;II)V", "index", "", "get", "(I)C", "startIndex", "endIndex", "subSequence", "(II)Ljava/lang/CharSequence;", "", "toString", "()Ljava/lang/String;", "other", "", "contentEquals", "(Ljava/lang/CharSequence;)Z", "Ljava/lang/CharSequence;", "Landroidx/compose/foundation/text/input/internal/GapBuffer;", "buffer", "Landroidx/compose/foundation/text/input/internal/GapBuffer;", "bufStart", "I", "bufEnd", "getLength", "()I", "length", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PartialGapBuffer implements CharSequence {
    public static final int BUF_SIZE = 255;
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private GapBuffer buffer;
    private CharSequence text;
    public static final int $stable = 8;
    private int bufStart = -1;
    private int bufEnd = -1;

    public PartialGapBuffer(CharSequence charSequence) {
        this.text = charSequence;
    }

    public static /* synthetic */ void replace$default(PartialGapBuffer partialGapBuffer, int i, int i6, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 16) != 0) {
            i11 = charSequence.length();
        }
        partialGapBuffer.replace(i, i6, charSequence, i13, i11);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public final boolean contentEquals(CharSequence other) {
        return k.b(toString(), other.toString());
    }

    public char get(int index) {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer != null && index >= this.bufStart) {
            int length = gapBuffer.length();
            int i = this.bufStart;
            return index < length + i ? gapBuffer.get(index - i) : this.text.charAt(index - ((length - this.bufEnd) + i));
        }
        return this.text.charAt(index);
    }

    public int getLength() {
        GapBuffer gapBuffer = this.buffer;
        return gapBuffer == null ? this.text.length() : (this.text.length() - (this.bufEnd - this.bufStart)) + gapBuffer.length();
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public final void replace(int start, int end, CharSequence text, int textStart, int textEnd) {
        if (start > end) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(start, end, "start=", " > end=").toString());
        }
        if (textStart > textEnd) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(textStart, textEnd, "textStart=", " > textEnd=").toString());
        }
        if (start < 0) {
            throw new IllegalArgumentException(B7.a.h(start, "start must be non-negative, but was ").toString());
        }
        if (textStart < 0) {
            throw new IllegalArgumentException(B7.a.h(textStart, "textStart must be non-negative, but was ").toString());
        }
        GapBuffer gapBuffer = this.buffer;
        int i = textEnd - textStart;
        if (gapBuffer != null) {
            int i6 = this.bufStart;
            int i10 = start - i6;
            int i11 = end - i6;
            if (i10 >= 0 && i11 <= gapBuffer.length()) {
                gapBuffer.replace(i10, i11, text, textStart, textEnd);
                return;
            }
            this.text = toString();
            this.buffer = null;
            this.bufStart = -1;
            this.bufEnd = -1;
            replace(start, end, text, textStart, textEnd);
            return;
        }
        int iMax = Math.max(255, i + 128);
        char[] cArr = new char[iMax];
        int iMin = Math.min(start, 64);
        int iMin2 = Math.min(this.text.length() - end, 64);
        int i12 = start - iMin;
        ToCharArray_androidKt.toCharArray(this.text, cArr, 0, i12, start);
        int i13 = iMax - iMin2;
        int i14 = iMin2 + end;
        ToCharArray_androidKt.toCharArray(this.text, cArr, i13, end, i14);
        ToCharArray_androidKt.toCharArray(text, cArr, iMin, textStart, textEnd);
        this.buffer = new GapBuffer(cArr, iMin + i, i13);
        this.bufStart = i12;
        this.bufEnd = i14;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int startIndex, int endIndex) {
        return toString().subSequence(startIndex, endIndex);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.text, 0, this.bufStart);
        gapBuffer.append(sb);
        CharSequence charSequence = this.text;
        sb.append(charSequence, this.bufEnd, charSequence.length());
        return sb.toString();
    }
}
