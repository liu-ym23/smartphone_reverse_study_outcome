package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

/* loaded from: classes.dex */
public interface IStreetViewPanoramaDelegate extends IInterface {
    void animateTo(@NonNull StreetViewPanoramaCamera streetViewPanoramaCamera, long j4) throws RemoteException;

    void enablePanning(boolean z4) throws RemoteException;

    void enableStreetNames(boolean z4) throws RemoteException;

    void enableUserNavigation(boolean z4) throws RemoteException;

    void enableZoom(boolean z4) throws RemoteException;

    @NonNull
    StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException;

    @NonNull
    StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException;

    boolean isPanningGesturesEnabled() throws RemoteException;

    boolean isStreetNamesEnabled() throws RemoteException;

    boolean isUserNavigationEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    @Nullable
    IObjectWrapper orientationToPoint(@NonNull StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;

    @NonNull
    StreetViewPanoramaOrientation pointToOrientation(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    void setOnStreetViewPanoramaCameraChangeListener(@javax.annotation.Nullable zzbk zzbkVar) throws RemoteException;

    void setOnStreetViewPanoramaChangeListener(@javax.annotation.Nullable zzbm zzbmVar) throws RemoteException;

    void setOnStreetViewPanoramaClickListener(@javax.annotation.Nullable zzbo zzboVar) throws RemoteException;

    void setOnStreetViewPanoramaLongClickListener(@javax.annotation.Nullable zzbq zzbqVar) throws RemoteException;

    void setPosition(@NonNull LatLng latLng) throws RemoteException;

    void setPositionWithID(@NonNull String str) throws RemoteException;

    void setPositionWithRadius(@NonNull LatLng latLng, int i4) throws RemoteException;

    void setPositionWithRadiusAndSource(@NonNull LatLng latLng, int i4, @javax.annotation.Nullable StreetViewSource streetViewSource) throws RemoteException;

    void setPositionWithSource(@NonNull LatLng latLng, @javax.annotation.Nullable StreetViewSource streetViewSource) throws RemoteException;
}
