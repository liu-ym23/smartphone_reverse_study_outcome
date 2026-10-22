package com.jakewharton.rxbinding.widget;

import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterViewNothingSelectionEvent extends AdapterViewSelectionEvent {
    private AdapterViewNothingSelectionEvent(@NonNull AdapterView<?> r10) {
        super(r10);
    }

    @NonNull
    @CheckResult
    public static AdapterViewSelectionEvent create(@NonNull AdapterView<?> r10) {
        return new AdapterViewNothingSelectionEvent(r10);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof AdapterViewNothingSelectionEvent) == true) goto L9;
        return false;
    L9:
        if (((AdapterViewNothingSelectionEvent) r10).view() != view()) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return view().hashCode();
    }

    public String toString() {
        return "AdapterViewNothingSelectionEvent{view=" + view() + '}';
    }
}
