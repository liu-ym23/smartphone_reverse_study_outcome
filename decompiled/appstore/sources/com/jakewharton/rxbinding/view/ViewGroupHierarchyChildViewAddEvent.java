package com.jakewharton.rxbinding.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewGroupHierarchyChildViewAddEvent extends ViewGroupHierarchyChangeEvent {
    private ViewGroupHierarchyChildViewAddEvent(@NonNull ViewGroup r10, View r11) {
        super(r10, r11);
    }

    @NonNull
    @CheckResult
    public static ViewGroupHierarchyChildViewAddEvent create(@NonNull ViewGroup r10, View r11) {
        return new ViewGroupHierarchyChildViewAddEvent(r10, r11);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ViewGroupHierarchyChildViewAddEvent) == true) goto L8;
        return false;
    L8:
        ViewGroupHierarchyChildViewAddEvent r11 = (ViewGroupHierarchyChildViewAddEvent) r10;
        if (r11.view() != view()) goto L14;
        if (r11.child() != child()) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return ((629 + view().hashCode()) * 37) + child().hashCode();
    }

    public String toString() {
        return "ViewGroupHierarchyChildViewAddEvent{view=" + view() + ", child=" + child() + '}';
    }
}
