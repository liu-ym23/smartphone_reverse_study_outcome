package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.AbstractC0351g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;
import i1.AbstractC0619a;

/* loaded from: classes.dex */
public final class zzbt extends zza implements IProjectionDelegate {
    public zzbt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IProjectionDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IProjectionDelegate
    public final LatLng fromScreenLocation(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.d(parcelZza, iObjectWrapper);
        Parcel parcelZzH = zzH(1, parcelZza);
        LatLng latLng = (LatLng) AbstractC0619a.a(parcelZzH, LatLng.CREATOR);
        parcelZzH.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.maps.internal.IProjectionDelegate
    public final VisibleRegion getVisibleRegion() throws RemoteException {
        Parcel parcelZzH = zzH(3, zza());
        VisibleRegion visibleRegion = (VisibleRegion) AbstractC0619a.a(parcelZzH, VisibleRegion.CREATOR);
        parcelZzH.recycle();
        return visibleRegion;
    }

    @Override // com.google.android.gms.maps.internal.IProjectionDelegate
    public final IObjectWrapper toScreenLocation(LatLng latLng) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0619a.c(parcelZza, latLng);
        return AbstractC0351g.g(zzH(2, parcelZza));
    }
}
