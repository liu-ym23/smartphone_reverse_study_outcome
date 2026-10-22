package com.android.contacts.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.widget.AdapterView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ActionsViewContainer extends LinearLayout {
    private ContextMenu.ContextMenuInfo mContextMenuInfo;

    public ActionsViewContainer(Context r1) {
        super(r1);
    }

    public ActionsViewContainer(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ActionsViewContainer(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public void setPosition(int r4) {
        this.mContextMenuInfo = new AdapterView.AdapterContextMenuInfo(this, r4, -1);
    }

    @Override // android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }
}
