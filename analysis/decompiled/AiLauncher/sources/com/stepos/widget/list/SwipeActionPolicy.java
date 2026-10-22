package com.stepos.widget.list;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J&\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e¨\u0006\u0012"}, d2 = {"Lcom/stepos/widget/list/SwipeActionPolicy;", "", "<init>", "()V", "width", "", "count", "iconSize", "gap", "isVisible", "", "actionId", "shouldOpen", "progress", "", "openingVelocity", "verticalVelocity", "minFlingVelocity", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SwipeActionPolicy {
    public static final SwipeActionPolicy INSTANCE = new SwipeActionPolicy();

    private SwipeActionPolicy() {
    }

    public final boolean isVisible(int actionId, int count) {
        return actionId != 0 ? actionId != 1 ? actionId == 2 && count >= 1 : count == 3 : count >= 2;
    }

    public final boolean shouldOpen(float progress, float openingVelocity, float verticalVelocity, float minFlingVelocity) {
        return (Math.abs(openingVelocity) < minFlingVelocity || Math.abs(openingVelocity) <= Math.abs(verticalVelocity)) ? progress >= 0.5f : openingVelocity > 0.0f;
    }

    public final int width(int count, int iconSize, int gap) {
        if (count < 0 || count >= 4) {
            throw new IllegalArgumentException("count must be in 0..3");
        }
        if (iconSize < 0 || gap < 0) {
            throw new IllegalArgumentException("iconSize and gap must be non-negative");
        }
        if (count == 0) {
            return 0;
        }
        return (iconSize * count) + (gap * (count + 1));
    }
}
