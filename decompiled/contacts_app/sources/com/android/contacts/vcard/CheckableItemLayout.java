package com.android.contacts.vcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import com.android.contacts.R;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public class CheckableItemLayout extends RelativeLayout implements Checkable {
    private boolean mChecked;

    public CheckableItemLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mChecked = false;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r5) {
        if (this.mChecked == r5) goto L10;
        this.mChecked = r5;
        refreshDrawableState();
        int r0 = getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        KeyEvent.Callback r2 = getChildAt(r1);
        if ((r2 instanceof Checkable) == false) goto L9;
        ((Checkable) r2).setChecked(r5);
    L9:
        r1 = r1 + 1;
        goto L5
    L14:
        return;
    }

    public void setBackgroundStyle(int r2) {
        ((ListContentItemCustom) findViewById(R.id.list_item)).setBackgroundStyle(r2);
    }
}
