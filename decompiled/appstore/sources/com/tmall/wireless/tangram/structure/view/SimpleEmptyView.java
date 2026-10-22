package com.tmall.wireless.tangram.structure.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.CellRender;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleEmptyView extends FrameLayout {
    public SimpleEmptyView(Context r10) {
        super(r10);
    }

    @CellRender
    public void cellInited(BaseCell r10) {
    }

    public SimpleEmptyView(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public SimpleEmptyView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
