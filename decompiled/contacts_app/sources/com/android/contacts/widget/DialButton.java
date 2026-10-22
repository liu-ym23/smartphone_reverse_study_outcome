package com.android.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.oui.button.OButton;
import com.obric.oui.common.style.OUIStyleProvider;

/* JADX INFO: loaded from: classes2.dex */
public class DialButton extends OButton {
    private boolean inEnableChanging;

    public DialButton(Context r1, AttributeSet r2, int r3, int r4, OUIStyleProvider r5) {
        super(r1, r2, r3, r4, r5);
        this.inEnableChanging = false;
    }

    public DialButton(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.inEnableChanging = false;
    }

    public DialButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.inEnableChanging = false;
    }

    public DialButton(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.inEnableChanging = false;
    }

    @Override // com.obric.oui.button.OButton, android.widget.TextView, android.view.View
    public void setEnabled(boolean r2) {
        this.inEnableChanging = true;
        super.setEnabled(r2);
        this.inEnableChanging = false;
    }

    @Override // android.view.View
    public void setAlpha(float r2) {
        if (this.inEnableChanging == true) goto L5;
        super.setAlpha(r2);
        return;
    L5:
        if (getMIcon() == null) goto L10;
        getMIcon().setAlpha((int) (r2 * 255.0f));
        return;
    }
}
