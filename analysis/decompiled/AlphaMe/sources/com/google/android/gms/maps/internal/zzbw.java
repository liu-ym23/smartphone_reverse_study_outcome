package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.AbstractC0351g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public final class zzbw extends zza implements IStreetViewPanoramaDelegate {
    public zzbw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j4) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, streetViewPanoramaCamera);
        parcelZza.writeLong(j4);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void enablePanning(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void enableStreetNames(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void enableUserNavigation(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void enableZoom(boolean z4) throws RemoteException {
        Parcel parcelZza = zza();
        ClassLoader classLoader = AbstractC0619a.f13018a;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException {
        Parcel parcelZzH = zzH(10, zza());
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) AbstractC0619a.a(parcelZzH, StreetViewPanoramaCamera.CREATOR);
        parcelZzH.recycle();
        return streetViewPanoramaCamera;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException {
        Parcel parcelZzH = zzH(14, zza());
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) AbstractC0619a.a(parcelZzH, StreetViewPanoramaLocation.CREATOR);
        parcelZzH.recycle();
        return streetViewPanoramaLocation;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final boolean isPanningGesturesEnabled() throws RemoteException {
        Parcel parcelZzH = zzH(6, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final boolean isStreetNamesEnabled() throws RemoteException {
        Parcel parcelZzH = zzH(8, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final boolean isUserNavigationEnabled() throws RemoteException {
        Parcel parcelZzH = zzH(7, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final boolean isZoomGesturesEnabled() throws RemoteException {
        Parcel parcelZzH = zzH(5, zza());
        boolean zE = AbstractC0619a.e(parcelZzH);
        parcelZzH.recycle();
        return zE;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final IObjectWrapper orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, streetViewPanoramaOrientation);
        return AbstractC0351g.g(zzH(19, parcelZza));
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final StreetViewPanoramaOrientation pointToOrientation(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, iObjectWrapper);
        Parcel parcelZzH = zzH(18, parcelZza);
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) AbstractC0619a.a(parcelZzH, StreetViewPanoramaOrientation.CREATOR);
        parcelZzH.recycle();
        return streetViewPanoramaOrientation;
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setOnStreetViewPanoramaCameraChangeListener(zzbk zzbkVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzbkVar);
        zzc(16, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setOnStreetViewPanoramaChangeListener(zzbm zzbmVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzbmVar);
        zzc(15, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setOnStreetViewPanoramaClickListener(zzbo zzboVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzboVar);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setOnStreetViewPanoramaLongClickListener(zzbq zzbqVar) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, zzbqVar);
        zzc(20, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setPosition(LatLng latLng) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, latLng);
        zzc(12, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setPositionWithID(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setPositionWithRadius(LatLng latLng, int i4) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, latLng);
        parcelZza.writeInt(i4);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setPositionWithRadiusAndSource(LatLng latLng, int i4, StreetViewSource streetViewSource) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, latLng);
        parcelZza.writeInt(i4);
        AbstractC0619a.c(parcelZza, streetViewSource);
        zzc(22, parcelZza);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
    public final void setPositionWithSource(LatLng latLng, StreetViewSource streetViewSource) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, latLng);
        AbstractC0619a.c(parcelZza, streetViewSource);
        zzc(21, parcelZza);
    }
}
