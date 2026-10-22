package com.amap.api.maps;

import android.R;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amap.api.col.jmsl.C1585n2;
import com.amap.api.col.jmsl.InterfaceC1552f1;
import com.amap.api.col.jmsl.InterfaceC1588o1;
import com.amap.api.maps.AMap;

/* loaded from: classes.dex */
public class MapView extends FrameLayout {
    private AMap aMap;
    private InterfaceC1588o1 mapFragmentDelegate;
    private int visibility;

    public class a implements AMap.OnMapReadyListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1588o1 f17217a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AMap.OnMapReadyListener f17218b;

        public a(InterfaceC1588o1 interfaceC1588o1, AMap.OnMapReadyListener onMapReadyListener) {
            this.f17217a = interfaceC1588o1;
            this.f17218b = onMapReadyListener;
        }

        @Override // com.amap.api.maps.AMap.OnMapReadyListener
        public void onMapReady(AMap aMap) {
            ((C1585n2) this.f17217a).h();
            AMap.OnMapReadyListener onMapReadyListener = this.f17218b;
            if (onMapReadyListener != null) {
                onMapReadyListener.onMapReady(MapView.this.aMap);
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.visibility = 0;
        ((C1585n2) getMapFragmentDelegate()).e(context);
    }

    public void getMapAsyn(AMap.OnMapReadyListener onMapReadyListener) {
        InterfaceC1588o1 mapFragmentDelegate = getMapFragmentDelegate();
        try {
            InterfaceC1552f1 interfaceC1552f1B = ((C1585n2) mapFragmentDelegate).b(null);
            this.aMap = new AMap(interfaceC1552f1B);
            interfaceC1552f1B.A(new a(mapFragmentDelegate, onMapReadyListener));
        } catch (Throwable unused) {
        }
    }

    public InterfaceC1588o1 getMapFragmentDelegate() {
        InterfaceC1588o1 interfaceC1588o1 = this.mapFragmentDelegate;
        if (interfaceC1588o1 == null && interfaceC1588o1 == null) {
            this.mapFragmentDelegate = new C1585n2(3);
        }
        return this.mapFragmentDelegate;
    }

    public final void onCreate(Bundle bundle) {
        try {
            addView(((C1585n2) getMapFragmentDelegate()).a(null, null, bundle), new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            ((C1585n2) getMapFragmentDelegate()).k();
            this.aMap = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onLowMemory() {
        try {
            ((C1585n2) getMapFragmentDelegate()).getClass();
            Log.d("onLowMemory", "onLowMemory run");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onPause() {
        try {
            ((C1585n2) getMapFragmentDelegate()).l();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            ((C1585n2) getMapFragmentDelegate()).m();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            ((C1585n2) getMapFragmentDelegate()).i(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setLayerType(int i10, Paint paint) {
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        ((C1585n2) getMapFragmentDelegate()).d(i10);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.visibility = 0;
        try {
            this.visibility = attributeSet.getAttributeIntValue(R.attr.visibility, 0);
        } catch (Throwable unused) {
        }
        ((C1585n2) getMapFragmentDelegate()).e(context);
        ((C1585n2) getMapFragmentDelegate()).d(this.visibility);
    }

    public MapView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.visibility = 0;
        try {
            this.visibility = attributeSet.getAttributeIntValue(R.attr.visibility, 0);
        } catch (Throwable unused) {
        }
        ((C1585n2) getMapFragmentDelegate()).e(context);
        ((C1585n2) getMapFragmentDelegate()).d(this.visibility);
    }

    public MapView(Context context, AMapOptions aMapOptions) {
        super(context);
        this.visibility = 0;
        ((C1585n2) getMapFragmentDelegate()).e(context);
        ((C1585n2) getMapFragmentDelegate()).j(aMapOptions);
    }
}
