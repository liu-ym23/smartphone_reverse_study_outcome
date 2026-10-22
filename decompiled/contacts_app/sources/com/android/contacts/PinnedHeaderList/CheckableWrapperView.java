package com.android.contacts.PinnedHeaderList;

import android.content.Context;
import android.widget.Checkable;

/* JADX INFO: loaded from: classes.dex */
class CheckableWrapperView extends WrapperView implements Checkable {
    public CheckableWrapperView(Context r1) {
        super(r1);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return ((Checkable) this.item).isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        ((Checkable) this.item).setChecked(r1);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
