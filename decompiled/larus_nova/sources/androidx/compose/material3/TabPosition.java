package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\t¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/TabPosition;", "", "left", "Landroidx/compose/ui/unit/Dp;", "width", "contentWidth", "<init>", "(FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM", "()F", FaceService.girlLabel, "getWidth-D9Ej5fM", "getContentWidth-D9Ej5fM", "right", "getRight-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TabPosition {
    public static final int $stable = 0;
    private final float contentWidth;
    private final float left;
    private final float width;

    public /* synthetic */ TabPosition(float r100, float r101, float r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m2746getRightD9Ej5fM() {
        return Dp.m7544constructorimpl(this.left + this.width);
    }

    public int hashCode() {
        return (((Dp.m7550hashCodeimpl(this.left) * 31) + Dp.m7550hashCodeimpl(this.width)) * 31) + Dp.m7550hashCodeimpl(this.contentWidth);
    }

    public String toString() {
        return "TabPosition(left=" + Dp.m7555toStringimpl(this.left) + ", right=" + Dp.m7555toStringimpl(m2746getRightD9Ej5fM()) + ", width=" + Dp.m7555toStringimpl(this.width) + ", contentWidth=" + Dp.m7555toStringimpl(this.contentWidth) + ')';
    }

    /* JADX INFO: renamed from: getContentWidth-D9Ej5fM, reason: not valid java name */
    public final float m2744getContentWidthD9Ej5fM() {
        return this.contentWidth;
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m2745getLeftD9Ej5fM() {
        return this.left;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final float m2747getWidthD9Ej5fM() {
        return this.width;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TabPosition) == true) goto L8;
        return false;
    L8:
        TabPosition r101 = (TabPosition) r100;
        if (Dp.m7549equalsimpl0(this.left, r101.left) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.width, r101.width) == true) goto L15;
        return false;
    L15:
        if (Dp.m7549equalsimpl0(this.contentWidth, r101.contentWidth) == true) goto L17;
        return false;
    L17:
        return true;
    }

    private TabPosition(float r100, float r101, float r102) {
        this.left = r100;
        this.width = r101;
        this.contentWidth = r102;
    }
}
