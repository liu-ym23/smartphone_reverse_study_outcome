package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/ParagraphIntrinsicInfo;", "", "intrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "startIndex", "", "endIndex", "<init>", "(Landroidx/compose/ui/text/ParagraphIntrinsics;II)V", "getIntrinsics", "()Landroidx/compose/ui/text/ParagraphIntrinsics;", "getStartIndex", "()I", "getEndIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ParagraphIntrinsicInfo {
    public static final int $stable = 8;
    private final int endIndex;
    private final ParagraphIntrinsics intrinsics;
    private final int startIndex;

    public static /* synthetic */ ParagraphIntrinsicInfo copy$default(ParagraphIntrinsicInfo r100, ParagraphIntrinsics r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.intrinsics;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.startIndex;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.endIndex;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final ParagraphIntrinsics component1() {
        return this.intrinsics;
    }

    public final int component2() {
        return this.startIndex;
    }

    public final int component3() {
        return this.endIndex;
    }

    public final ParagraphIntrinsicInfo copy(ParagraphIntrinsics r100, int r101, int r102) {
        return new ParagraphIntrinsicInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ParagraphIntrinsicInfo) == true) goto L8;
        return false;
    L8:
        ParagraphIntrinsicInfo r101 = (ParagraphIntrinsicInfo) r100;
        if (Intrinsics.areEqual(this.intrinsics, r101.intrinsics) == true) goto L12;
        return false;
    L12:
        if (this.startIndex == r101.startIndex) goto L15;
        return false;
    L15:
        if (this.endIndex == r101.endIndex) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.intrinsics.hashCode() * 31) + this.startIndex) * 31) + this.endIndex;
    }

    public String toString() {
        return "ParagraphIntrinsicInfo(intrinsics=" + this.intrinsics + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ')';
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final ParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public ParagraphIntrinsicInfo(ParagraphIntrinsics r100, int r101, int r102) {
        this.intrinsics = r100;
        this.startIndex = r101;
        this.endIndex = r102;
    }
}
