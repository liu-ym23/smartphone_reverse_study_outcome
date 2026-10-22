package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import h1.AbstractC0588a;

/* loaded from: classes.dex */
public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        @NonNull
        public static IFragmentWrapper asInterface(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return iInterfaceQueryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) iInterfaceQueryLocalInterface : new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zzb
        public final boolean zza(int i4, @NonNull Parcel parcel, @NonNull Parcel parcel2, int i5) throws RemoteException {
            switch (i4) {
                case 2:
                    IObjectWrapper iObjectWrapperZzg = zzg();
                    parcel2.writeNoException();
                    AbstractC0588a.d(parcel2, iObjectWrapperZzg);
                    return true;
                case 3:
                    Bundle bundleZzd = zzd();
                    parcel2.writeNoException();
                    int i6 = AbstractC0588a.f12690a;
                    if (bundleZzd == null) {
                        parcel2.writeInt(0);
                    } else {
                        parcel2.writeInt(1);
                        bundleZzd.writeToParcel(parcel2, 1);
                    }
                    return true;
                case 4:
                    int iZzb = zzb();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzb);
                    return true;
                case 5:
                    IFragmentWrapper iFragmentWrapperZze = zze();
                    parcel2.writeNoException();
                    AbstractC0588a.d(parcel2, iFragmentWrapperZze);
                    return true;
                case 6:
                    IObjectWrapper iObjectWrapperZzh = zzh();
                    parcel2.writeNoException();
                    AbstractC0588a.d(parcel2, iObjectWrapperZzh);
                    return true;
                case 7:
                    boolean zZzs = zzs();
                    parcel2.writeNoException();
                    int i7 = AbstractC0588a.f12690a;
                    parcel2.writeInt(zZzs ? 1 : 0);
                    return true;
                case 8:
                    String strZzj = zzj();
                    parcel2.writeNoException();
                    parcel2.writeString(strZzj);
                    return true;
                case 9:
                    IFragmentWrapper iFragmentWrapperZzf = zzf();
                    parcel2.writeNoException();
                    AbstractC0588a.d(parcel2, iFragmentWrapperZzf);
                    return true;
                case 10:
                    int iZzc = zzc();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzc);
                    return true;
                case 11:
                    boolean zZzt = zzt();
                    parcel2.writeNoException();
                    int i8 = AbstractC0588a.f12690a;
                    parcel2.writeInt(zZzt ? 1 : 0);
                    return true;
                case 12:
                    IObjectWrapper iObjectWrapperZzi = zzi();
                    parcel2.writeNoException();
                    AbstractC0588a.d(parcel2, iObjectWrapperZzi);
                    return true;
                case 13:
                    boolean zZzu = zzu();
                    parcel2.writeNoException();
                    int i9 = AbstractC0588a.f12690a;
                    parcel2.writeInt(zZzu ? 1 : 0);
                    return true;
                case 14:
                    boolean zZzv = zzv();
                    parcel2.writeNoException();
                    int i10 = AbstractC0588a.f12690a;
                    parcel2.writeInt(zZzv ? 1 : 0);
                    return true;
                case 15:
                    boolean zZzw = zzw();
                    parcel2.writeNoException();
                    int i11 = AbstractC0588a.f12690a;
                    parcel2.writeInt(zZzw ? 1 : 0);
                    return true;
                case 16:
                    boolean zZzx = zzx();
                    parcel2.writeNoException();
                    int i12 = AbstractC0588a.f12690a;
                    parcel2.writeInt(zZzx ? 1 : 0);
                    return true;
                case 17:
                    boolean zZzy = zzy();
                    parcel2.writeNoException();
                    int i13 = AbstractC0588a.f12690a;
                    parcel2.writeInt(zZzy ? 1 : 0);
                    return true;
                case 18:
                    boolean zZzz = zzz();
                    parcel2.writeNoException();
                    int i14 = AbstractC0588a.f12690a;
                    parcel2.writeInt(zZzz ? 1 : 0);
                    return true;
                case 19:
                    boolean zZzA = zzA();
                    parcel2.writeNoException();
                    int i15 = AbstractC0588a.f12690a;
                    parcel2.writeInt(zZzA ? 1 : 0);
                    return true;
                case 20:
                    IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    AbstractC0588a.b(parcel);
                    zzk(iObjectWrapperAsInterface);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    boolean zE = AbstractC0588a.e(parcel);
                    AbstractC0588a.b(parcel);
                    zzl(zE);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    boolean zE2 = AbstractC0588a.e(parcel);
                    AbstractC0588a.b(parcel);
                    zzm(zE2);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    boolean zE3 = AbstractC0588a.e(parcel);
                    AbstractC0588a.b(parcel);
                    zzn(zE3);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    boolean zE4 = AbstractC0588a.e(parcel);
                    AbstractC0588a.b(parcel);
                    zzo(zE4);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    Intent intent = (Intent) AbstractC0588a.a(parcel, Intent.CREATOR);
                    AbstractC0588a.b(parcel);
                    zzp(intent);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    Intent intent2 = (Intent) AbstractC0588a.a(parcel, Intent.CREATOR);
                    int i16 = parcel.readInt();
                    AbstractC0588a.b(parcel);
                    zzq(intent2, i16);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    AbstractC0588a.b(parcel);
                    zzr(iObjectWrapperAsInterface2);
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    boolean zzA() throws RemoteException;

    int zzb() throws RemoteException;

    int zzc() throws RemoteException;

    @Nullable
    Bundle zzd() throws RemoteException;

    @Nullable
    IFragmentWrapper zze() throws RemoteException;

    @Nullable
    IFragmentWrapper zzf() throws RemoteException;

    @NonNull
    IObjectWrapper zzg() throws RemoteException;

    @NonNull
    IObjectWrapper zzh() throws RemoteException;

    @NonNull
    IObjectWrapper zzi() throws RemoteException;

    @Nullable
    String zzj() throws RemoteException;

    void zzk(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzl(boolean z4) throws RemoteException;

    void zzm(boolean z4) throws RemoteException;

    void zzn(boolean z4) throws RemoteException;

    void zzo(boolean z4) throws RemoteException;

    void zzp(@NonNull Intent intent) throws RemoteException;

    void zzq(@NonNull Intent intent, int i4) throws RemoteException;

    void zzr(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzs() throws RemoteException;

    boolean zzt() throws RemoteException;

    boolean zzu() throws RemoteException;

    boolean zzv() throws RemoteException;

    boolean zzw() throws RemoteException;

    boolean zzx() throws RemoteException;

    boolean zzy() throws RemoteException;

    boolean zzz() throws RemoteException;
}
