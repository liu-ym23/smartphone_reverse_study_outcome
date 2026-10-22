package com.amap.api.maps;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amap.api.mapcore.util.b0;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes28.dex */
public class WearMapView extends ViewGroup implements BaseMapView {
    private static int pointX;
    private static int pointY;
    private final String TAG;
    private AMap aMap;
    private View mMapView;
    private SwipeDismissView mSwipeDismissView;
    private IMapFragmentDelegate mapFragmentDelegate;
    private int visibility;

    public interface OnDismissCallback {
        void onDismiss();

        void onNotifySwipe();
    }

    @Override // android.view.View
    public void setLayerType(int r100, Paint r101) {
    }

    public IMapFragmentDelegate getMapFragmentDelegate() {
        IMapFragmentDelegate r100 = this.mapFragmentDelegate;
        if (r100 != null) goto L7;
        if (r100 != null) goto L7;
        this.mapFragmentDelegate = new b0(1);
    L7:
        return this.mapFragmentDelegate;
    }

    public AMap getMap() {
        IAMap r100 = getMapFragmentDelegate().getMap();     // Catch: Throwable -> L11
        if (r100 != null) goto L7;
        return null;
    L7:
        if (this.aMap != null) goto L10;
        this.aMap = new AMap(r100);
    L10:
        return this.aMap;
    L11:
        return null;
    }

    public final void onDestroy() {
        getMapFragmentDelegate().onDestroy();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void onLowMemory() {
        getMapFragmentDelegate().onLowMemory();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void onPause() {
        getMapFragmentDelegate().onPause();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void onResume() {
        getMapFragmentDelegate().onResume();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void onDismiss() {
        removeAllViews();
    }

    public void onExitAmbient() {
        onPause();
    }

    public WearMapView(Context r100) {
        super(r100);
        this.TAG = "WearMapView";
        this.visibility = 0;
        getMapFragmentDelegate().setContext(r100);
        a(r100);
        b(r100);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_amap_api_maps_WearMapView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void a(Context r100) {
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r101 == null) goto L9;
        Display r102 = r101.getDefaultDisplay();
        Point r103 = new Point();
        if (r102 == null) goto L7;
        r102.getSize(r103);
    L7:
        pointX = r103.x;
        pointY = r103.y;
        return;
    }

    private void b(Context r100) {
        this.mSwipeDismissView = new SwipeDismissView(r100, this);
        ViewGroup.LayoutParams r101 = new ViewGroup.LayoutParams((int) ((INVOKEVIRTUAL_com_amap_api_maps_WearMapView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density * 30.0f) + 0.5f), pointY);
        this.mSwipeDismissView.setBackgroundColor(Color.argb(0, 0, 0, 0));
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        addView(this.mSwipeDismissView, r101);
    }

    @Override // com.amap.api.maps.BaseMapView
    public void loadWorldVectorMap(boolean r100) {
        getMapFragmentDelegate().loadWorldVectorMap(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void onCreate(Bundle r100) {
        this.mMapView = getMapFragmentDelegate().onCreateView(null, null, r100);     // Catch: Throwable -> L4
        ViewGroup.LayoutParams r101 = new ViewGroup.LayoutParams(-1, -1);     // Catch: Throwable -> L4
        addView(this.mMapView, 0, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void onEnterAmbient(Bundle r100) {
        onResume();
    }

    public final void onSaveInstanceState(Bundle r100) {
        getMapFragmentDelegate().onSaveInstanceState(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void setOnDismissCallbackListener(OnDismissCallback r100) {
        SwipeDismissView r101 = this.mSwipeDismissView;
        if (r101 == null) goto L6;
        r101.setCallback(r100);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        getMapFragmentDelegate().setVisibility(r100);
    }

    public WearMapView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.TAG = "WearMapView";
        this.visibility = 0;
        this.visibility = r101.getAttributeIntValue(R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(r100);
        getMapFragmentDelegate().setVisibility(this.visibility);
        a(r100);
        b(r100);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        View r104 = getChildAt(r103);
        if ((r104 instanceof SwipeDismissView) == false) goto L7;
        SwipeDismissView r105 = (SwipeDismissView) r104;
        r104.measure(r105.getLayoutParams().width, r105.getLayoutParams().height);
    L8:
        r103 = r103 + 1;
        goto L3
    L7:
        r104.measure(r100, r101);
        goto L8
    L9:
        super.onMeasure(r100, r101);
    }

    public WearMapView(Context r100, AMapOptions r101) {
        super(r100);
        this.TAG = "WearMapView";
        this.visibility = 0;
        getMapFragmentDelegate().setContext(r100);
        getMapFragmentDelegate().setOptions(r101);
        a(r100);
        b(r100);
    }

    public WearMapView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.TAG = "WearMapView";
        this.visibility = 0;
        this.visibility = r101.getAttributeIntValue(R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(r100);
        getMapFragmentDelegate().setVisibility(this.visibility);
        a(r100);
        b(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L22;
        View r107 = getChildAt(r106);
        if (r107 != this.mMapView) goto L7;
        r107.layout(0, 0, getWidth(), getHeight());
    L21:
        r106 = r106 + 1;
        goto L3
    L7:
        SwipeDismissView r108 = this.mSwipeDismissView;
        if (r107 != r108) goto L21;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 != null) goto L12;
        r109 = new ViewGroup.LayoutParams(-2, -2);
    L12:
        int r110 = r109.width;
        if (r110 <= 0) goto L15;
        int r111 = View.MeasureSpec.makeMeasureSpec(r110, 1073741824);
    L16:
        int r112 = r109.height;
        if (r112 <= 0) goto L19;
        int r113 = View.MeasureSpec.makeMeasureSpec(r112, 1073741824);
    L20:
        r108.measure(r111, r113);
        int r114 = this.mSwipeDismissView.getMeasuredWidth();
        this.mSwipeDismissView.layout(0, 0, r114, r103);
        goto L21
    L19:
        r113 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L20
    L15:
        r111 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L16
    }
}
