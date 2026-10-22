package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
abstract class PickerFragment<S> extends Fragment {
    protected final LinkedHashSet<f<S>> onSelectionChangedListeners;

    abstract DateSelector<S> getDateSelector();

    PickerFragment() {
        this.onSelectionChangedListeners = new LinkedHashSet();
    }

    boolean addOnSelectionChangedListener(f<S> r1) {
        return this.onSelectionChangedListeners.add(r1);
    }

    boolean removeOnSelectionChangedListener(f<S> r1) {
        return this.onSelectionChangedListeners.remove(r1);
    }

    void clearOnSelectionChangedListeners() {
        this.onSelectionChangedListeners.clear();
    }
}
