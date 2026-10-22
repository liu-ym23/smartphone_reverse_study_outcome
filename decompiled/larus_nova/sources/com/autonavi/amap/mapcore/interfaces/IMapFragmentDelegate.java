package com.autonavi.amap.mapcore.interfaces;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;

/* JADX INFO: loaded from: classes39.dex */
public interface IMapFragmentDelegate {
    IAMap getMap() throws RemoteException;

    boolean isReady() throws RemoteException;

    void loadWorldVectorMap(boolean r100);

    void onCreate(Bundle r100) throws RemoteException;

    View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onDestroyView() throws RemoteException;

    void onInflate(Activity r100, AMapOptions r101, Bundle r102) throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle r100) throws RemoteException;

    void setContext(Context r100);

    void setOptions(AMapOptions r100);

    void setUseForNavi(boolean r100);

    void setVisibility(int r100);
}
