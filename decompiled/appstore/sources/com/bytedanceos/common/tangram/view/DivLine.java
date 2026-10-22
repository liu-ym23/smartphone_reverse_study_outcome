package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.obric.oui.divider.ODivider;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class DivLine extends FrameLayout implements ITangramViewLifeCycle {
    public DivLine(Context r10) {
        this(r10, null);
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void cellInited(BaseCell r10) {
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postBindView(BaseCell r10) {
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postUnBindView(BaseCell r10) {
    }

    public DivLine(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public DivLine(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        int r13 = f.i(20);
        int r14 = (int) f.g(15.5f);
        setPadding(r13, r14, r13, r14);
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-1, (f.i(1) * 2) / 3);
        r15.gravity = 17;
        addView(new ODivider(getContext()), r15);
    }
}
