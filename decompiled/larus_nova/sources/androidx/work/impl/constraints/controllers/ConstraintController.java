package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConstraintController<T> implements ConstraintListener<T> {
    private OnConstraintUpdatedCallback mCallback;
    private T mCurrentValue;
    private final List<String> mMatchingWorkSpecIds;
    private ConstraintTracker<T> mTracker;

    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(List<String> r100);

        void onConstraintNotMet(List<String> r100);
    }

    public abstract boolean hasConstraint(WorkSpec r100);

    public abstract boolean isConstrained(T r100);

    public void reset() {
        if (this.mMatchingWorkSpecIds.isEmpty() == true) goto L6;
        this.mMatchingWorkSpecIds.clear();
        this.mTracker.removeListener(this);
        return;
    }

    public ConstraintController(ConstraintTracker<T> r100) {
        this.mMatchingWorkSpecIds = new ArrayList();
        this.mTracker = r100;
    }

    public boolean isWorkSpecConstrained(String r100) {
        T r101 = this.mCurrentValue;
        if (r101 != null) goto L5;
    L9:
        return false;
    L5:
        if (isConstrained(r101) == false) goto L9;
        if (this.mMatchingWorkSpecIds.contains(r100) == false) goto L9;
        return true;
    }

    @Override // androidx.work.impl.constraints.ConstraintListener
    public void onConstraintChanged(T r100) {
        this.mCurrentValue = r100;
        updateCallback(this.mCallback, r100);
    }

    public void replace(Iterable<WorkSpec> r100) {
        this.mMatchingWorkSpecIds.clear();
        Iterator<WorkSpec> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        WorkSpec r102 = r101.next();
        if (hasConstraint(r102) == false) goto L4;
        this.mMatchingWorkSpecIds.add(r102.f15686id);
        goto L4
    L9:
        if (this.mMatchingWorkSpecIds.isEmpty() == false) goto L11;
        this.mTracker.removeListener(this);
    L12:
        updateCallback(this.mCallback, this.mCurrentValue);
        return;
    L11:
        this.mTracker.addListener(this);
        goto L12
    }

    public void setCallback(OnConstraintUpdatedCallback r100) {
        if (this.mCallback == r100) goto L6;
        this.mCallback = r100;
        updateCallback(r100, this.mCurrentValue);
        return;
    }

    private void updateCallback(OnConstraintUpdatedCallback r100, T r101) {
        if (this.mMatchingWorkSpecIds.isEmpty() == true) goto L13;
        if (r100 == null) goto L15;
        if (r101 != null) goto L8;
    L11:
        r100.onConstraintNotMet(this.mMatchingWorkSpecIds);
        return;
    L8:
        if (isConstrained(r101) == true) goto L11;
        r100.onConstraintMet(this.mMatchingWorkSpecIds);
        return;
    L15:
        return;
    }
}
