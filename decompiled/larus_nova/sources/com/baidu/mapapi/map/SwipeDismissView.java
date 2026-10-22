package com.baidu.mapapi.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes39.dex */
public class SwipeDismissView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WearMapView.OnDismissCallback f31355a;

    public class a implements SwipeDismissTouchListener.DismissCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SwipeDismissView f31356a;

        @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
        public boolean canDismiss(Object r100) {
            return true;
        }

        @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
        public void onNotify() {
            WearMapView.OnDismissCallback r100 = this.f31356a.f31355a;
            if (r100 != null) goto L5;
            return;
        L5:
            r100.onNotify();
        }

        public a(SwipeDismissView r100) {
            this.f31356a = r100;
        }

        @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
        public void onDismiss(View r100, Object r101) {
            WearMapView.OnDismissCallback r102 = this.f31356a.f31355a;
            if (r102 != null) goto L5;
            return;
        L5:
            r102.onDismiss();
        }
    }

    public void setCallback(WearMapView.OnDismissCallback r100) {
        this.f31355a = r100;
    }

    public SwipeDismissView(Context r100, View r101) {
        super(r100);
        this.f31355a = null;
        a(r100, r101);
    }

    public void a(Context r100, View r101) {
        setOnTouchListener(new SwipeDismissTouchListener(r101, new Object(), new a(this)));
    }

    public SwipeDismissView(Context r100, AttributeSet r101, View r102) {
        super(r100, r101);
        this.f31355a = null;
        a(r100, r102);
    }

    public SwipeDismissView(Context r100, AttributeSet r101, int r102, View r103) {
        super(r100, r101, r102);
        this.f31355a = null;
        a(r100, r103);
    }
}
