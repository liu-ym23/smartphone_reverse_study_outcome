package com.bytedance.android.live.uikit.switchview;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes7.dex */
public class SwitchButton extends SwitchBase {

    public interface a {
    }

    public void setOnCheckStateChangeListener(a r100) {
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setCheckedWithListener(!isChecked());
    }

    public SwitchButton(Context r100) {
        super(r100);
    }

    @Override // com.bytedance.android.live.uikit.switchview.SwitchBase
    public final void a(boolean r100) {
        setCheckedWithListener(r100);
    }

    public void setCheckedWithListener(boolean r100) {
        if (r100 != isChecked()) goto L5;
        return;
    L5:
        setChecked(r100);
    }

    public SwitchButton(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public SwitchButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
