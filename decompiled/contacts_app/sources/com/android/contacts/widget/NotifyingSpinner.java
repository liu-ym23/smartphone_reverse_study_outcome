package com.android.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

/* JADX INFO: loaded from: classes2.dex */
public class NotifyingSpinner extends Spinner {
    private SelectionListener mListener;

    public interface SelectionListener {
        void onSetSelection(NotifyingSpinner r1, int r2);
    }

    public NotifyingSpinner(Context r1) {
        super(r1);
    }

    public NotifyingSpinner(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public void setSetSelectionListener(SelectionListener r1) {
        this.mListener = r1;
    }

    @Override // android.widget.AbsSpinner, android.widget.AdapterView
    public void setSelection(int r2) {
        super.setSelection(r2);
        SelectionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onSetSelection(this, r2);
        return;
    }
}
