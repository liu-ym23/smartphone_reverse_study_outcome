package com.amap.api.maps;

import android.view.View;

/* JADX INFO: loaded from: classes28.dex */
public class SwipeDismissCallBack implements SwipeDismissTouchListener.DismissCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SwipeDismissView f28624a;

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object r100) {
        return true;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onNotifySwipe() {
        WearMapView.OnDismissCallback r100 = this.f28624a.onDismissCallback;
        if (r100 == null) goto L6;
        r100.onNotifySwipe();
        return;
    }

    public SwipeDismissCallBack(SwipeDismissView r100) {
        this.f28624a = r100;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View r100, Object r101) {
        WearMapView.OnDismissCallback r102 = this.f28624a.onDismissCallback;
        if (r102 == null) goto L6;
        r102.onDismiss();
        return;
    }
}
