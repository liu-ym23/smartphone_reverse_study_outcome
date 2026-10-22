package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface zzl extends IInterface {
    boolean zzA() throws RemoteException;

    double zzd() throws RemoteException;

    float zze() throws RemoteException;

    float zzf() throws RemoteException;

    int zzg() throws RemoteException;

    int zzh() throws RemoteException;

    int zzi() throws RemoteException;

    IObjectWrapper zzj() throws RemoteException;

    LatLng zzk() throws RemoteException;

    String zzl() throws RemoteException;

    List zzm() throws RemoteException;

    void zzn() throws RemoteException;

    void zzo(LatLng latLng) throws RemoteException;

    void zzp(boolean z4) throws RemoteException;

    void zzq(int i4) throws RemoteException;

    void zzr(double d4) throws RemoteException;

    void zzs(int i4) throws RemoteException;

    void zzt(@Nullable List list) throws RemoteException;

    void zzu(float f4) throws RemoteException;

    void zzv(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzw(boolean z4) throws RemoteException;

    void zzx(float f4) throws RemoteException;

    boolean zzy(@Nullable zzl zzlVar) throws RemoteException;

    boolean zzz() throws RemoteException;
}
