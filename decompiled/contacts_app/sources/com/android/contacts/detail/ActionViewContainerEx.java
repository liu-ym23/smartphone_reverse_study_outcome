package com.android.contacts.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.widget.AdapterView;
import com.obric.oui.lisitem.OListItemGeneral;

/* JADX INFO: loaded from: classes.dex */
public class ActionViewContainerEx extends OListItemGeneral {
    private ContextMenu.ContextMenuInfo mContextMenuInfo;

    public ActionViewContainerEx(Context r1) {
        super(r1);
    }

    public ActionViewContainerEx(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public void setPosition(int r4) {
        this.mContextMenuInfo = new AdapterView.AdapterContextMenuInfo(this, r4, -1);
    }

    @Override // android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }
}
