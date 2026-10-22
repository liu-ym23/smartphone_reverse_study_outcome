package androidx.compose.foundation.text.input.internal;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0005H\u0002J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J2\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0005J\u0012\u0010\u001c\u001a\u00020\u00122\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fJ\u0006\u0010 \u001a\u00020\u0005J\b\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/foundation/text/input/internal/GapBuffer;", "", "initBuffer", "", "initGapStart", "", "initGapEnd", "<init>", "([CII)V", "capacity", "buffer", "gapStart", "gapEnd", "gapLength", MonitorConstants.CONNECT_TYPE_GET, "", "index", "makeSureAvailableSpace", "", "requestSize", "delete", "start", "end", "replace", "text", "", "textStart", "textEnd", "append", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "length", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class GapBuffer {
    private char[] buffer;
    private int capacity;
    private int gapEnd;
    private int gapStart;

    private final int gapLength() {
        return this.gapEnd - this.gapStart;
    }

    public final int length() {
        return this.capacity - gapLength();
    }

    public String toString() {
        return "";
    }

    private final void makeSureAvailableSpace(int r100) {
        if (r100 > gapLength()) goto L5;
        return;
    L5:
        int r101 = r100 - gapLength();
        int r102 = this.capacity;
    L6:
        r102 = r102 * 2;
        if ((r102 - this.capacity) < r101) goto L6;
        char[] r103 = new char[r102];
        ArraysKt.copyInto(this.buffer, r103, 0, 0, this.gapStart);
        int r104 = this.capacity;
        int r105 = this.gapEnd;
        int r106 = r104 - r105;
        int r107 = r102 - r106;
        ArraysKt.copyInto(this.buffer, r103, r107, r105, r106 + r105);
        this.buffer = r103;
        this.capacity = r102;
        this.gapEnd = r107;
    }

    public final void append(StringBuilder r100) {
        r100.append(this.buffer, 0, this.gapStart - 0);
        char[] r101 = this.buffer;
        int r102 = this.gapEnd;
        r100.append(r101, r102, this.capacity - r102);
    }

    public final char get(int r100) {
        int r101 = this.gapStart;
        if (r100 >= r101) goto L7;
        return this.buffer[r100];
    L7:
        return this.buffer[(r100 - r101) + this.gapEnd];
    }

    private final void delete(int r100, int r101) {
        int r102 = this.gapStart;
        if (r100 >= r102) goto L6;
        if (r101 > r102) goto L6;
        int r103 = r102 - r101;
        char[] r104 = this.buffer;
        ArraysKt.copyInto(r104, r104, this.gapEnd - r103, r101, r102);
        this.gapStart = r100;
        this.gapEnd -= r103;
        return;
    L6:
        if (r100 >= r102) goto L9;
        if (r101 < r102) goto L9;
        this.gapEnd = r101 + gapLength();
        this.gapStart = r100;
        return;
    L9:
        int r105 = r100 + gapLength();
        int r106 = r101 + gapLength();
        int r107 = this.gapEnd;
        char[] r108 = this.buffer;
        ArraysKt.copyInto(r108, r108, this.gapStart, r107, r105);
        this.gapStart += r105 - r107;
        this.gapEnd = r106;
    }

    public GapBuffer(char[] r100, int r101, int r102) {
        this.capacity = r100.length;
        this.buffer = r100;
        this.gapStart = r101;
        this.gapEnd = r102;
    }

    public final void replace(int r100, int r101, CharSequence r102, int r103, int r104) {
        int r105 = r104 - r103;
        makeSureAvailableSpace(r105 - (r101 - r100));
        delete(r100, r101);
        ToCharArray_androidKt.toCharArray(r102, this.buffer, this.gapStart, r103, r104);
        this.gapStart += r105;
    }

    public static /* synthetic */ void replace$default(GapBuffer r100, int r101, int r102, CharSequence r103, int r110, int r111, int r112, Object r113) {
        if ((r112 & 8) == 0) goto L5;
        int r104 = 0;
    L7:
        if ((r112 & 16) == 0) goto L9;
        r111 = r103.length();
    L9:
        r100.replace(r101, r102, r103, r104, r111);
        return;
    L5:
        r104 = r110;
        goto L7
    }
}
