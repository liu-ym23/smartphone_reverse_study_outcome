package com.amap.api.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes28.dex */
public class SwipeDismissView extends RelativeLayout {
    protected WearMapView.OnDismissCallback onDismissCallback;

    public void setCallback(WearMapView.OnDismissCallback r100) {
        this.onDismissCallback = r100;
    }

    public void setOnTouchListener(View r100) {
        setOnTouchListener(new SwipeDismissTouchListener(r100, new Object(), new SwipeDismissCallBack(this)));
    }

    public SwipeDismissView(Context r100, View r101) {
        super(r100);
        this.onDismissCallback = null;
        setOnTouchListener(r101);
    }

    public SwipeDismissView(Context r100, AttributeSet r101, View r102) {
        super(r100, r101);
        this.onDismissCallback = null;
        setOnTouchListener(r102);
    }

    public SwipeDismissView(Context r100, AttributeSet r101, int r102, View r103) {
        super(r100, r101, r102);
        this.onDismissCallback = null;
        setOnTouchListener(r103);
    }
}
