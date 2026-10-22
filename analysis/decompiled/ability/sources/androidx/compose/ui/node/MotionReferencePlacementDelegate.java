package androidx.compose.ui.node;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "", "", "newMFR", "LC7/r;", "updatePlacedUnderMotionFrameOfReference", "(Z)V", "isPlacedUnderMotionFrameOfReference", "()Z", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MotionReferencePlacementDelegate {
    boolean isPlacedUnderMotionFrameOfReference();

    void updatePlacedUnderMotionFrameOfReference(boolean newMFR);
}
