package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class ExpandableWidgetHelper {
    private boolean expanded;

    @IdRes
    private int expandedComponentIdHint;

    @NonNull
    private final View widget;

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandableWidgetHelper(ExpandableWidget r10) {
        this.expanded = false;
        this.expandedComponentIdHint = 0;
        this.widget = (View) r10;
    }

    private void dispatchExpandedStateChanged() {
        ViewParent r10 = this.widget.getParent();
        if ((r10 instanceof CoordinatorLayout) == false) goto L6;
        ((CoordinatorLayout) r10).dispatchDependentViewsChanged(this.widget);
        return;
    }

    @IdRes
    public int getExpandedComponentIdHint() {
        return this.expandedComponentIdHint;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void onRestoreInstanceState(@NonNull Bundle r10) {
        this.expanded = r10.getBoolean("expanded", false);
        this.expandedComponentIdHint = r10.getInt("expandedComponentIdHint", 0);
        if (this.expanded == false) goto L6;
        dispatchExpandedStateChanged();
        return;
    }

    @NonNull
    public Bundle onSaveInstanceState() {
        Bundle r10 = new Bundle();
        r10.putBoolean("expanded", this.expanded);
        r10.putInt("expandedComponentIdHint", this.expandedComponentIdHint);
        return r10;
    }

    public boolean setExpanded(boolean r10) {
        if (this.expanded == r10) goto L6;
        this.expanded = r10;
        dispatchExpandedStateChanged();
        return true;
    L6:
        return false;
    }

    public void setExpandedComponentIdHint(@IdRes int r10) {
        this.expandedComponentIdHint = r10;
    }
}
