package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/Placeholder;", "", "width", "Landroidx/compose/ui/unit/TextUnit;", "height", "placeholderVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "<init>", "(JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWidth-XSAIIZE", "()J", "J", "getHeight-XSAIIZE", "getPlaceholderVerticalAlign-J6kI3mc", "()I", "I", "copy", "copy-K8Q-__8", "(JJI)Landroidx/compose/ui/text/Placeholder;", "equals", "", "other", "hashCode", "", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Placeholder {
    public static final int $stable = 0;
    private final long height;
    private final int placeholderVerticalAlign;
    private final long width;

    public /* synthetic */ Placeholder(long r100, long r101, int r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public int hashCode() {
        return (((TextUnit.m7743hashCodeimpl(this.width) * 31) + TextUnit.m7743hashCodeimpl(this.height)) * 31) + PlaceholderVerticalAlign.m6916hashCodeimpl(this.placeholderVerticalAlign);
    }

    public String toString() {
        return "Placeholder(width=" + TextUnit.m7749toStringimpl(this.width) + ", height=" + TextUnit.m7749toStringimpl(this.height) + ", placeholderVerticalAlign=" + PlaceholderVerticalAlign.m6917toStringimpl(this.placeholderVerticalAlign) + ')';
    }

    /* JADX INFO: renamed from: getHeight-XSAIIZE, reason: not valid java name */
    public final long m6909getHeightXSAIIZE() {
        return this.height;
    }

    /* JADX INFO: renamed from: getPlaceholderVerticalAlign-J6kI3mc, reason: not valid java name */
    public final int m6910getPlaceholderVerticalAlignJ6kI3mc() {
        return this.placeholderVerticalAlign;
    }

    /* JADX INFO: renamed from: getWidth-XSAIIZE, reason: not valid java name */
    public final long m6911getWidthXSAIIZE() {
        return this.width;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Placeholder) == true) goto L8;
        return false;
    L8:
        Placeholder r101 = (Placeholder) r100;
        if (TextUnit.m7739equalsimpl0(this.width, r101.width) == true) goto L12;
        return false;
    L12:
        if (TextUnit.m7739equalsimpl0(this.height, r101.height) == true) goto L15;
        return false;
    L15:
        if (PlaceholderVerticalAlign.m6915equalsimpl0(this.placeholderVerticalAlign, r101.placeholderVerticalAlign) == true) goto L17;
        return false;
    L17:
        return true;
    }

    private Placeholder(long r100, long r101, int r102) {
        this.width = r100;
        this.height = r101;
        this.placeholderVerticalAlign = r102;
        boolean r103 = false;
        if (TextUnit.m7740getRawTypeimpl(r100) != 0) goto L5;
        boolean r104 = true;
    L7:
        if ((!r104) == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("width cannot be TextUnit.Unspecified");
    L10:
        if (TextUnit.m7740getRawTypeimpl(r101) != 0) goto L13;
        r103 = true;
    L13:
        if ((!r103) == true) goto L16;
        InlineClassHelperKt.throwIllegalArgumentException("height cannot be TextUnit.Unspecified");
        return;
    L16:
        return;
    L5:
        r104 = false;
        goto L7
    }

    /* JADX INFO: renamed from: copy-K8Q-__8, reason: not valid java name */
    public final Placeholder m6908copyK8Q__8(long r100, long r110, int r111) {
        return new Placeholder(r100, r110, r111, null);
    }

    /* JADX INFO: renamed from: copy-K8Q-__8$default, reason: not valid java name */
    public static /* synthetic */ Placeholder m6907copyK8Q__8$default(Placeholder r100, long r101, long r102, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.width;
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.height;
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L12;
        r110 = r100.placeholderVerticalAlign;
    L12:
        return r100.m6908copyK8Q__8(r103, r104, r110);
    }
}
