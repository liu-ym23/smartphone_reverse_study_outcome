package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J2\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\bJ\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0096\u0002J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "", "text", "<init>", "(Ljava/lang/CharSequence;)V", "buffer", "Landroidx/compose/foundation/text/input/internal/GapBuffer;", "bufStart", "", "bufEnd", "length", "getLength", "()I", "replace", "", "start", "end", "textStart", "textEnd", MonitorConstants.CONNECT_TYPE_GET, "", "index", "subSequence", "startIndex", "endIndex", "toString", "", "contentEquals", "", "other", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PartialGapBuffer implements CharSequence {
    public static final int $stable = 0;
    public static final int BUF_SIZE = 255;
    public static final Companion Companion = null;
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd;
    private int bufStart;
    private GapBuffer buffer;
    private CharSequence text;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/PartialGapBuffer$Companion;", "", "<init>", "()V", "BUF_SIZE", "", "SURROUNDING_SIZE", "NOWHERE", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
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

    public int getLength() {
        GapBuffer r100 = this.buffer;
        if (r100 != null) goto L7;
        return this.text.length();
    L7:
        return (this.text.length() - (this.bufEnd - this.bufStart)) + r100.length();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        GapBuffer r100 = this.buffer;
        if (r100 == null) goto L5;
        StringBuilder r101 = new StringBuilder();
        r101.append(this.text, 0, this.bufStart);
        r100.append(r101);
        CharSequence r102 = this.text;
        r101.append(r102, this.bufEnd, r102.length());
        return r101.toString();
    L5:
        return this.text.toString();
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public PartialGapBuffer(CharSequence r100) {
        this.text = r100;
        this.bufStart = -1;
        this.bufEnd = -1;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int r100) {
        return get(r100);
    }

    public final boolean contentEquals(CharSequence r100) {
        return Intrinsics.areEqual(toString(), r100.toString());
    }

    public char get(int r100) {
        GapBuffer r101 = this.buffer;
        if (r101 != null) goto L7;
        return this.text.charAt(r100);
    L7:
        if (r100 < this.bufStart) goto L9;
        int r102 = r101.length();
        int r103 = this.bufStart;
        if (r100 >= (r102 + r103)) goto L15;
        return r101.get(r100 - r103);
    L15:
        return this.text.charAt(r100 - ((r102 - this.bufEnd) + r103));
    L9:
        return this.text.charAt(r100);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r100, int r101) {
        return toString().subSequence(r100, r101);
    }

    public final void replace(int r100, int r110, CharSequence r111, int r112, int r113) {
        boolean r101 = true;
        if (r100 > r110) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("start=" + r100 + " > end=" + r110);
    L8:
        if (r112 > r113) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
        InlineClassHelperKt.throwIllegalArgumentException("textStart=" + r112 + " > textEnd=" + r113);
    L13:
        if (r100 < 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L18;
        InlineClassHelperKt.throwIllegalArgumentException("start must be non-negative, but was " + r100);
    L18:
        if (r112 >= 0) goto L21;
        r101 = false;
    L21:
        if (r101 == true) goto L23;
        InlineClassHelperKt.throwIllegalArgumentException("textStart must be non-negative, but was " + r112);
    L23:
        GapBuffer r105 = this.buffer;
        int r106 = r113 - r112;
        if (r105 != null) goto L27;
        int r107 = Math.max(255, r106 + 128);
        char[] r108 = new char[r107];
        int r109 = Math.min(r100, 64);
        int r114 = Math.min(this.text.length() - r110, 64);
        int r115 = r100 - r109;
        ToCharArray_androidKt.toCharArray(this.text, r108, 0, r115, r100);
        int r116 = r107 - r114;
        int r117 = r114 + r110;
        ToCharArray_androidKt.toCharArray(this.text, r108, r116, r110, r117);
        ToCharArray_androidKt.toCharArray(r111, r108, r109, r112, r113);
        this.buffer = new GapBuffer(r108, r109 + r106, r116);
        this.bufStart = r115;
        this.bufEnd = r117;
        return;
    L27:
        int r118 = this.bufStart;
        int r119 = r100 - r118;
        int r120 = r110 - r118;
        if (r119 >= 0) goto L30;
    L34:
        this.text = toString();
        this.buffer = null;
        this.bufStart = -1;
        this.bufEnd = -1;
        replace(r100, r110, r111, r112, r113);
        return;
    L30:
        if (r120 > r105.length()) goto L34;
        r105.replace(r119, r120, r111, r112, r113);
        return;
    L15:
        r104 = false;
        goto L16
    L10:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L6
    }

    public static /* synthetic */ void replace$default(PartialGapBuffer r100, int r101, int r102, CharSequence r103, int r110, int r111, int r112, Object r113) {
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
