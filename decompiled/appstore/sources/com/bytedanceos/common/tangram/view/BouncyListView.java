package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.toolbox.DeviceType;

/* JADX INFO: loaded from: classes2.dex */
public class BouncyListView extends RecyclerView {
    public BouncyListView(Context r10) {
        this(r10, null);
    }

    private void L() {
        if (DeviceType.is(DeviceType.M1) == false) goto L5;
    L7:
        LinearLayoutManager r10 = new FullyLinearLayoutManager(getContext());
    L8:
        r10.setOrientation(0);
        setLayoutManager(r10);
        return;
    L5:
        if (DeviceType.is(DeviceType.M1L) == true) goto L7;
        r10 = new LinearLayoutManager(getContext());
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE), r11);
    }

    public BouncyListView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public BouncyListView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        L();
    }
}
