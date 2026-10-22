package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
import com.huawei.hms.framework.common.ContainerUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes28.dex */
public class b0 implements IMapFragmentDelegate {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile Context f27047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f27048g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAMap f27049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f27050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f27051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AMapOptions f27052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f27053e;

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onCreate(Bundle r100) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onDestroyView() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onLowMemory() throws RemoteException {
    }

    private void a() {
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L8
        int r101 = 0;
    L4:
        if (r101 >= 80) goto L6;
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L8
        r101 = r101 + 1;     // Catch: Throwable -> L8
        goto L4
    L6:
        f27048g = r100.toString();     // Catch: Throwable -> L8
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public IAMap getMap() throws RemoteException {
        if (this.f27049a != null) goto L35;
        if (f27047f != null) goto L8;
        p0.a(2131034398);
        return null;
    L8:
        int r100 = INVOKEVIRTUAL_com_amap_api_mapcore_util_b0_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(f27047f.getResources()).densityDpi;
        if (r100 > 120) goto L12;
        w.f28255b = 0.5f;
    L27:
        int r101 = this.f27051c;
        if (r101 != 0) goto L31;
        this.f27049a = new k(f27047f, null, this.f27053e).a();
        goto L35
    L31:
        if (r101 != 1) goto L33;
        this.f27049a = new l(f27047f, this.f27053e).f();
        goto L35
    L33:
        this.f27049a = new j(f27047f, null).a();
        goto L35
    L12:
        if (r100 > 160) goto L15;
        w.f28255b = 0.8f;
        goto L27
    L15:
        if (r100 > 240) goto L18;
        w.f28255b = 0.87f;
        goto L27
    L18:
        if (r100 > 320) goto L21;
        w.f28255b = 1.0f;
        goto L27
    L21:
        if (r100 > 480) goto L24;
        w.f28255b = 1.5f;
        goto L27
    L24:
        if (r100 > 640) goto L26;
        w.f28255b = 1.8f;
        goto L27
    L26:
        w.f28255b = 0.9f;
    L35:
        return this.f27049a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onPause() throws RemoteException {
        IAMap r100 = this.f27049a;
        if (r100 == null) goto L6;
        r100.onActivityPause();
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onResume() throws RemoteException {
        IAMap r100 = this.f27049a;
        if (r100 == null) goto L6;
        r100.onActivityResume();
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onDestroy() throws RemoteException {
        StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();     // Catch: Throwable -> L20
        int r101 = 0;
    L3:
        if (r101 >= r100.length) goto L21;
        if (r100[r101].getClassName() == null) goto L11;
        if (r100[r101].getClassName().endsWith("TextureMapView") == true) goto L11;
    L11:
        if (r100[r101].getClassName() == null) goto L17;
        if (r100[r101].getClassName().endsWith("Fragment") == true) goto L17;
    L17:
        if ("OnDestroyView".equalsIgnoreCase(r100[r101].getMethodName()) == true) goto L19;
    L19:
        r101 = r101 + 1;
    L21:
        IAMap r102 = this.f27049a;
        if (r102 == null) goto L30;
        r102.destroy();
        this.f27049a = null;
        return;
    }

    public b0(int r100) {
        this.f27050b = 0;
        this.f27051c = 0;
        this.f27053e = true;
        this.f27051c = r100 % 3;
        a();
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_amap_api_mapcore_util_b0_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public void a(AMapOptions r100) throws RemoteException {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f27049a == null) goto L11;
        CameraPosition r101 = r100.getCamera();
        if (r101 == null) goto L8;
        this.f27049a.moveCamera(CameraUpdateFactory.newCameraPosition(r101));
    L8:
        UiSettings r102 = this.f27049a.getAMapUiSettings();
        r102.setRotateGesturesEnabled(r100.getRotateGesturesEnabled());
        r102.setScrollGesturesEnabled(r100.getScrollGesturesEnabled());
        r102.setTiltGesturesEnabled(r100.getTiltGesturesEnabled());
        r102.setZoomControlsEnabled(r100.getZoomControlsEnabled());
        r102.setZoomGesturesEnabled(r100.getZoomGesturesEnabled());
        r102.setCompassEnabled(r100.getCompassEnabled());
        r102.setScaleControlsEnabled(r100.getScaleControlsEnabled());
        r102.setLogoPosition(r100.getLogoPosition());
        this.f27049a.setMapType(r100.getMapType());
        this.f27049a.setZOrderOnTop(r100.getZOrderOnTop());
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void loadWorldVectorMap(boolean r100) {
        this.f27053e = r100;
        IAMap r101 = this.f27049a;
        if (r101 == null) goto L6;
        r101.loadWorldVectorMap(r100);
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onSaveInstanceState(Bundle r100) throws RemoteException {
        if (this.f27049a != null) goto L5;
        return;
    L5:
        if (this.f27052d != null) goto L12;
        this.f27052d = new AMapOptions();
    L12:
        Parcel r101 = Parcel.obtain();     // Catch: Throwable -> L11
        AMapOptions r102 = this.f27052d.camera(getMap().getCameraPosition());     // Catch: Throwable -> L11
        this.f27052d = r102;     // Catch: Throwable -> L11
        r102.writeToParcel(r101, 0);     // Catch: Throwable -> L11
        r100.putByteArray("MAP_OPTIONS", r101.marshall());     // Catch: Throwable -> L11
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setContext(Context r100) {
        if (r100 == null) goto L5;
        f27047f = r100.getApplicationContext();
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setOptions(AMapOptions r100) {
        this.f27052d = r100;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setUseForNavi(boolean r100) {
        IAMap r101 = this.f27049a;
        if (r101 == null) goto L6;
        r101.setUseForNavi(r100);
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setVisibility(int r100) {
        this.f27050b = r100;
        IAMap r101 = this.f27049a;
        if (r101 == null) goto L6;
        r101.setVisibilityEx(r100);
        return;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) throws RemoteException {
        if (f27047f != null) goto L18;
        if (r100 == null) goto L18;
        setContext(r100.getContext().getApplicationContext());
    L18:
        IAMap r103 = getMap();     // Catch: Throwable -> L14
        this.f27049a = r103;     // Catch: Throwable -> L14
        r103.setVisibilityEx(this.f27050b);     // Catch: Throwable -> L14
        if (this.f27052d != null) goto L12;
        if (r102 == null) goto L12;
        byte[] r104 = r102.getByteArray("MAP_OPTIONS");     // Catch: Throwable -> L14
        if (r104 == null) goto L12;
        Parcel r105 = Parcel.obtain();     // Catch: Throwable -> L14
        r105.unmarshall(r104, 0, r104.length);     // Catch: Throwable -> L14
        r105.setDataPosition(0);     // Catch: Throwable -> L14
        this.f27052d = AMapOptions.CREATOR.createFromParcel(r105);     // Catch: Throwable -> L14
    L12:
        a(this.f27052d);     // Catch: Throwable -> L14
    L17:
        return this.f27049a.getView();
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onInflate(Activity r100, AMapOptions r101, Bundle r102) throws RemoteException {
        setContext(r100.getApplicationContext());
        this.f27052d = r101;
    }
}
