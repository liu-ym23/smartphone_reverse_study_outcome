package com.amap.api.maps;

import android.R;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amap.api.mapcore.util.b0;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* JADX INFO: loaded from: classes28.dex */
public class MapView extends FrameLayout implements BaseMapView {
    private AMap aMap;
    private IMapFragmentDelegate mapFragmentDelegate;
    private int visibility;

    @Override // android.view.View
    public void setLayerType(int r100, Paint r101) {
    }

    public IMapFragmentDelegate getMapFragmentDelegate() {
        IMapFragmentDelegate r100 = this.mapFragmentDelegate;
        if (r100 != null) goto L7;
        if (r100 != null) goto L7;
        this.mapFragmentDelegate = new b0(0);
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
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final void onDestroy() {
        getMapFragmentDelegate().onDestroy();     // Catch: Throwable -> L4
        this.aMap = null;     // Catch: Throwable -> L4
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

    public MapView(Context r100) {
        super(r100);
        this.visibility = 0;
        getMapFragmentDelegate().setContext(r100);
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
        addView(getMapFragmentDelegate().onCreateView(null, null, r100), new ViewGroup.LayoutParams(-1, -1));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final void onSaveInstanceState(Bundle r100) {
        getMapFragmentDelegate().onSaveInstanceState(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        getMapFragmentDelegate().setVisibility(r100);
    }

    public MapView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.visibility = 0;
        this.visibility = r101.getAttributeIntValue(R.attr.visibility, 0);     // Catch: Throwable -> L6
    L4:
        getMapFragmentDelegate().setContext(r100);
        getMapFragmentDelegate().setVisibility(this.visibility);
    }

    public MapView(Context r100, AMapOptions r101) {
        super(r100);
        this.visibility = 0;
        getMapFragmentDelegate().setContext(r100);
        getMapFragmentDelegate().setOptions(r101);
    }

    public MapView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.visibility = 0;
        this.visibility = r101.getAttributeIntValue(R.attr.visibility, 0);     // Catch: Throwable -> L6
    L4:
        getMapFragmentDelegate().setContext(r100);
        getMapFragmentDelegate().setVisibility(this.visibility);
    }
}
