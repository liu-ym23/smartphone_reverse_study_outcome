package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes28.dex */
public class DownLoadExpandListView extends ExpandableListView {
    public DownLoadExpandListView(Context r100) {
        super(r100);
    }

    public DownLoadExpandListView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
