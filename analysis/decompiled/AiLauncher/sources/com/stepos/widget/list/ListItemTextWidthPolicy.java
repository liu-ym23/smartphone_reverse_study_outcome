package com.stepos.widget.list;

import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\tJ%\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\rJ(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002JM\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/widget/list/ListItemTextWidthPolicy;", "", "<init>", "()V", "endWidth", "", "available", "startDesired", "endDesired", "endWidth$StepOSWidget_release", "auxiliaryWidth", "titleDesired", "auxiliaryDesired", "auxiliaryWidth$StepOSWidget_release", "allocateEndWidth", "endPercent", "shouldStack", "", x5.d.EXTRA_ENABLED, "hasValue", "titleAvailable", "startAvailable", "endAvailable", "shouldStack$StepOSWidget_release", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ListItemTextWidthPolicy {
    public static final ListItemTextWidthPolicy INSTANCE = new ListItemTextWidthPolicy();

    private ListItemTextWidthPolicy() {
    }

    private final int allocateEndWidth(int available, int startDesired, int endDesired, int endPercent) {
        int iF = C5685n.f(available, 0);
        int i10 = (int) ((iF * endPercent) / 100);
        int i11 = iF - i10;
        if (startDesired > iF - endDesired) {
            if (startDesired <= i11) {
                endDesired = iF - startDesired;
            } else if (endDesired > i10) {
                endDesired = i10;
            }
        }
        return C5685n.n(endDesired, 0, iF);
    }

    public final int auxiliaryWidth$StepOSWidget_release(int available, int titleDesired, int auxiliaryDesired) {
        return allocateEndWidth(available, titleDesired, auxiliaryDesired, 50);
    }

    public final int endWidth$StepOSWidget_release(int available, int startDesired, int endDesired) {
        return allocateEndWidth(available, startDesired, endDesired, 30);
    }

    public final boolean shouldStack$StepOSWidget_release(boolean enabled, boolean hasValue, int titleDesired, int titleAvailable, int startDesired, int startAvailable, int endDesired, int endAvailable) {
        if (!enabled || !hasValue) {
            return false;
        }
        if (titleDesired <= titleAvailable) {
            return startDesired > startAvailable && endDesired > endAvailable;
        }
        return true;
    }
}
