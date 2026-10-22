package androidx.compose.foundation.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ2\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R(\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/FlowLineInfo;", "", "", "lineIndex", "positionInLine", "Landroidx/compose/ui/unit/Dp;", "maxMainAxisSize", "maxCrossAxisSize", AppAgent.CONSTRUCT, "(IIFFLkotlin/jvm/internal/e;)V", "LC7/r;", "update-4j6BHR0$foundation_layout_release", "(IIFF)V", "update", "I", "getLineIndex$foundation_layout_release", "()I", "setLineIndex$foundation_layout_release", "(I)V", "getPositionInLine$foundation_layout_release", "setPositionInLine$foundation_layout_release", "F", "getMaxMainAxisSize-D9Ej5fM$foundation_layout_release", "()F", "setMaxMainAxisSize-0680j_4$foundation_layout_release", "(F)V", "getMaxCrossAxisSize-D9Ej5fM$foundation_layout_release", "setMaxCrossAxisSize-0680j_4$foundation_layout_release", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowLineInfo {
    public static final int $stable = 8;
    private int lineIndex;
    private float maxCrossAxisSize;
    private float maxMainAxisSize;
    private int positionInLine;

    public /* synthetic */ FlowLineInfo(int i, int i6, float f, float f7, e eVar) {
        this(i, i6, f, f7);
    }

    /* renamed from: getLineIndex$foundation_layout_release, reason: from getter */
    public final int getLineIndex() {
        return this.lineIndex;
    }

    /* renamed from: getMaxCrossAxisSize-D9Ej5fM$foundation_layout_release, reason: not valid java name and from getter */
    public final float getMaxCrossAxisSize() {
        return this.maxCrossAxisSize;
    }

    /* renamed from: getMaxMainAxisSize-D9Ej5fM$foundation_layout_release, reason: not valid java name and from getter */
    public final float getMaxMainAxisSize() {
        return this.maxMainAxisSize;
    }

    /* renamed from: getPositionInLine$foundation_layout_release, reason: from getter */
    public final int getPositionInLine() {
        return this.positionInLine;
    }

    public final void setLineIndex$foundation_layout_release(int i) {
        this.lineIndex = i;
    }

    /* renamed from: setMaxCrossAxisSize-0680j_4$foundation_layout_release, reason: not valid java name */
    public final void m634setMaxCrossAxisSize0680j_4$foundation_layout_release(float f) {
        this.maxCrossAxisSize = f;
    }

    /* renamed from: setMaxMainAxisSize-0680j_4$foundation_layout_release, reason: not valid java name */
    public final void m635setMaxMainAxisSize0680j_4$foundation_layout_release(float f) {
        this.maxMainAxisSize = f;
    }

    public final void setPositionInLine$foundation_layout_release(int i) {
        this.positionInLine = i;
    }

    /* renamed from: update-4j6BHR0$foundation_layout_release, reason: not valid java name */
    public final void m636update4j6BHR0$foundation_layout_release(int lineIndex, int positionInLine, float maxMainAxisSize, float maxCrossAxisSize) {
        this.lineIndex = lineIndex;
        this.positionInLine = positionInLine;
        this.maxMainAxisSize = maxMainAxisSize;
        this.maxCrossAxisSize = maxCrossAxisSize;
    }

    private FlowLineInfo(int i, int i6, float f, float f7) {
        this.lineIndex = i;
        this.positionInLine = i6;
        this.maxMainAxisSize = f;
        this.maxCrossAxisSize = f7;
    }

    public /* synthetic */ FlowLineInfo(int i, int i6, float f, float f7, int i10, e eVar) {
        this((i10 & 1) != 0 ? 0 : i, (i10 & 2) != 0 ? 0 : i6, (i10 & 4) != 0 ? Dp.m6844constructorimpl(0) : f, (i10 & 8) != 0 ? Dp.m6844constructorimpl(0) : f7, null);
    }
}
