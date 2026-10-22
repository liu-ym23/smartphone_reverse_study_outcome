package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface zzaa extends IInterface {
    void zzA(float f4) throws RemoteException;

    void zzB() throws RemoteException;

    boolean zzC(zzaa zzaaVar) throws RemoteException;

    boolean zzD() throws RemoteException;

    boolean zzE() throws RemoteException;

    boolean zzF() throws RemoteException;

    boolean zzG() throws RemoteException;

    float zzd() throws RemoteException;

    float zze() throws RemoteException;

    float zzf() throws RemoteException;

    int zzg() throws RemoteException;

    IObjectWrapper zzh() throws RemoteException;

    LatLng zzi() throws RemoteException;

    String zzj() throws RemoteException;

    String zzk() throws RemoteException;

    String zzl() throws RemoteException;

    void zzm() throws RemoteException;

    void zzn() throws RemoteException;

    void zzo(float f4) throws RemoteException;

    void zzp(float f4, float f5) throws RemoteException;

    void zzq(boolean z4) throws RemoteException;

    void zzr(boolean z4) throws RemoteException;

    void zzs(@Nullable IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzt(float f4, float f5) throws RemoteException;

    void zzu(LatLng latLng) throws RemoteException;

    void zzv(float f4) throws RemoteException;

    void zzw(@Nullable String str) throws RemoteException;

    void zzx(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzy(@Nullable String str) throws RemoteException;

    void zzz(boolean z4) throws RemoteException;
}
