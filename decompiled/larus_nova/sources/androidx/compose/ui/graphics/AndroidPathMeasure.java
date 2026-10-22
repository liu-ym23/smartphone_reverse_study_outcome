package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0017\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPathMeasure;", "Landroidx/compose/ui/graphics/PathMeasure;", "internalPathMeasure", "Landroid/graphics/PathMeasure;", "<init>", "(Landroid/graphics/PathMeasure;)V", "length", "", "getLength", "()F", "positionArray", "", "tangentArray", "getSegment", "", "startDistance", "stopDistance", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "Landroidx/compose/ui/graphics/Path;", "startWithMoveTo", "setPath", "", "path", "forceClosed", "getPosition", "Landroidx/compose/ui/geometry/Offset;", "distance", "getPosition-tuRUvjQ", "(F)J", "getTangent", "getTangent-tuRUvjQ", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidPathMeasure implements PathMeasure {
    private final android.graphics.PathMeasure internalPathMeasure;
    private float[] positionArray;
    private float[] tangentArray;

    @Override // androidx.compose.ui.graphics.PathMeasure
    public float getLength() {
        return this.internalPathMeasure.getLength();
    }

    public AndroidPathMeasure(android.graphics.PathMeasure r100) {
        this.internalPathMeasure = r100;
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    /* JADX INFO: renamed from: getPosition-tuRUvjQ, reason: not valid java name */
    public long mo4723getPositiontuRUvjQ(float r100) {
        if (this.positionArray != null) goto L6;
        this.positionArray = new float[2];
    L6:
        if (this.tangentArray != null) goto L9;
        this.tangentArray = new float[2];
    L9:
        if (this.internalPathMeasure.getPosTan(r100, this.positionArray, this.tangentArray) == false) goto L12;
        float[] r101 = this.positionArray;
        Intrinsics.checkNotNull(r101);
        float r102 = r101[0];
        float[] r103 = this.positionArray;
        Intrinsics.checkNotNull(r103);
        float r104 = r103[1];
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r104) & BodyPartID.bodyIdMax));
    L12:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    /* JADX INFO: renamed from: getTangent-tuRUvjQ, reason: not valid java name */
    public long mo4724getTangenttuRUvjQ(float r100) {
        if (this.positionArray != null) goto L6;
        this.positionArray = new float[2];
    L6:
        if (this.tangentArray != null) goto L9;
        this.tangentArray = new float[2];
    L9:
        if (this.internalPathMeasure.getPosTan(r100, this.positionArray, this.tangentArray) == false) goto L12;
        float[] r101 = this.tangentArray;
        Intrinsics.checkNotNull(r101);
        float r102 = r101[0];
        float[] r103 = this.tangentArray;
        Intrinsics.checkNotNull(r103);
        float r104 = r103[1];
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r104) & BodyPartID.bodyIdMax));
    L12:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public void setPath(Path r100, boolean r101) {
        android.graphics.PathMeasure r102 = this.internalPathMeasure;
        if (r100 != null) goto L5;
        android.graphics.Path r103 = null;
    L10:
        r102.setPath(r103, r101);
        return;
    L5:
        if ((r100 instanceof AndroidPath) == false) goto L8;
        r103 = ((AndroidPath) r100).getInternalPath();
        goto L10
    L8:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public boolean getSegment(float r100, float r101, Path r102, boolean r103) {
        android.graphics.PathMeasure r104 = this.internalPathMeasure;
        if ((r102 instanceof AndroidPath) == false) goto L7;
        return r104.getSegment(r100, r101, ((AndroidPath) r102).getInternalPath(), r103);
    L7:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }
}
