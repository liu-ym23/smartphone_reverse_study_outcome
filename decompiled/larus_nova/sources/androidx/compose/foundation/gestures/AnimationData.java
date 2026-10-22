package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/gestures/AnimationData;", "", GestureAction.zoom, "", "offset", "Landroidx/compose/ui/geometry/Offset;", "degrees", "<init>", "(FJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getZoom", "()F", "getOffset-F1C5BW0", "()J", "J", "getDegrees", "component1", "component2", "component2-F1C5BW0", "component3", "copy", "copy-d-4ec7I", "(FJF)Landroidx/compose/foundation/gestures/AnimationData;", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AnimationData {
    private final float degrees;
    private final long offset;
    private final float zoom;

    public /* synthetic */ AnimationData(float r100, long r101, float r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    /* JADX INFO: renamed from: copy-d-4ec7I$default, reason: not valid java name */
    public static /* synthetic */ AnimationData m393copyd4ec7I$default(AnimationData r100, float r101, long r102, float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.zoom;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.offset;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.degrees;
    L12:
        return r100.m395copyd4ec7I(r101, r102, r103);
    }

    public final float component1() {
        return this.zoom;
    }

    /* JADX INFO: renamed from: component2-F1C5BW0, reason: not valid java name */
    public final long m394component2F1C5BW0() {
        return this.offset;
    }

    public final float component3() {
        return this.degrees;
    }

    /* JADX INFO: renamed from: copy-d-4ec7I, reason: not valid java name */
    public final AnimationData m395copyd4ec7I(float r100, long r101, float r110) {
        return new AnimationData(r100, r101, r110, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AnimationData) == true) goto L8;
        return false;
    L8:
        AnimationData r101 = (AnimationData) r100;
        if (Float.compare(this.zoom, r101.zoom) == 0) goto L12;
        return false;
    L12:
        if (Offset.m4579equalsimpl0(this.offset, r101.offset) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.degrees, r101.degrees) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.zoom) * 31) + Offset.m4584hashCodeimpl(this.offset)) * 31) + Float.floatToIntBits(this.degrees);
    }

    public String toString() {
        return "AnimationData(zoom=" + this.zoom + ", offset=" + Offset.m4590toStringimpl(this.offset) + ", degrees=" + this.degrees + ')';
    }

    public final float getDegrees() {
        return this.degrees;
    }

    /* JADX INFO: renamed from: getOffset-F1C5BW0, reason: not valid java name */
    public final long m396getOffsetF1C5BW0() {
        return this.offset;
    }

    public final float getZoom() {
        return this.zoom;
    }

    private AnimationData(float r100, long r101, float r102) {
        this.zoom = r100;
        this.offset = r101;
        this.degrees = r102;
    }
}
