package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\fJ\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\fJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f¨\u0006'"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesImpl;", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM$annotations", "()V", "getStart-D9Ej5fM", "()F", FaceService.girlLabel, "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "getEnd-D9Ej5fM$annotations", "getEnd-D9Ej5fM", "getBottom-D9Ej5fM$annotations", "getBottom-D9Ej5fM", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PaddingValuesImpl implements PaddingValues {
    public static final int $stable = 0;
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingValuesImpl(float r100, float r101, float r102, float r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m748getBottomD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m749getEndD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m750getStartD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m751getTopD9Ej5fM$annotations() {
    }

    public int hashCode() {
        return (((((Dp.m7550hashCodeimpl(this.start) * 31) + Dp.m7550hashCodeimpl(this.top)) * 31) + Dp.m7550hashCodeimpl(this.end)) * 31) + Dp.m7550hashCodeimpl(this.bottom);
    }

    public String toString() {
        return "PaddingValues(start=" + Dp.m7555toStringimpl(this.start) + ", top=" + Dp.m7555toStringimpl(this.top) + ", end=" + Dp.m7555toStringimpl(this.end) + ", bottom=" + Dp.m7555toStringimpl(this.bottom) + ')';
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    public float mo680calculateBottomPaddingD9Ej5fM() {
        return this.bottom;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    public float mo683calculateTopPaddingD9Ej5fM() {
        return this.top;
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m752getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m753getEndD9Ej5fM() {
        return this.end;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m754getStartD9Ej5fM() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m755getTopD9Ej5fM() {
        return this.top;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    public float mo681calculateLeftPaddingu2uoSUM(LayoutDirection r100) {
        if (r100 != LayoutDirection.Ltr) goto L6;
        return this.start;
    L6:
        return this.end;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    public float mo682calculateRightPaddingu2uoSUM(LayoutDirection r100) {
        if (r100 != LayoutDirection.Ltr) goto L6;
        return this.end;
    L6:
        return this.start;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof PaddingValuesImpl) == true) goto L5;
        return false;
    L5:
        PaddingValuesImpl r101 = (PaddingValuesImpl) r100;
        if (Dp.m7549equalsimpl0(this.start, r101.start) == true) goto L8;
        return false;
    L8:
        if (Dp.m7549equalsimpl0(this.top, r101.top) == true) goto L10;
        return false;
    L10:
        if (Dp.m7549equalsimpl0(this.end, r101.end) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.bottom, r101.bottom) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private PaddingValuesImpl(float r100, float r101, float r102, float r103) {
        this.start = r100;
        this.top = r101;
        this.end = r102;
        this.bottom = r103;
        boolean r104 = true;
        if (r100 < 0.0f) goto L5;
        boolean r105 = true;
    L7:
        if (r101 < 0.0f) goto L9;
        boolean r106 = true;
    L10:
        boolean r107 = r105 & r106;
        if (r102 < 0.0f) goto L13;
        boolean r108 = true;
    L14:
        boolean r109 = r107 & r108;
        if (r103 >= 0.0f) goto L19;
        r104 = false;
    L19:
        if ((r109 & r104) == true) goto L22;
        InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        return;
    L22:
        return;
    L13:
        r108 = false;
        goto L14
    L9:
        r106 = false;
        goto L10
    L5:
        r105 = false;
        goto L7
    }

    public /* synthetic */ PaddingValuesImpl(float r100, float r101, float r110, float r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        r100 = Dp.m7544constructorimpl(0);
    L5:
        float r102 = r100;
        if ((r112 & 2) == 0) goto L8;
        r101 = Dp.m7544constructorimpl(0);
    L8:
        float r103 = r101;
        if ((r112 & 4) == 0) goto L11;
        r110 = Dp.m7544constructorimpl(0);
    L11:
        float r104 = r110;
        if ((r112 & 8) == 0) goto L14;
        r111 = Dp.m7544constructorimpl(0);
    L14:
        this(r102, r103, r104, r111, null);
    }
}
