package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzbm extends zzb implements zzbn {
    public zzbm() {
        super("com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            zzd();
            parcel2.writeNoException();
        } else if (i10 == 2) {
            zzf();
            parcel2.writeNoException();
        } else if (i10 == 3) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzcc zzccVar = (zzcc) C.a(parcel, zzcc.CREATOR);
            C.b(parcel);
            List listZzb = zzb(iObjectWrapperAsInterface, zzccVar);
            parcel2.writeNoException();
            parcel2.writeTypedList(listZzb);
        } else if (i10 == 4) {
            IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzcc zzccVar2 = (zzcc) C.a(parcel, zzcc.CREATOR);
            zzbc zzbcVar = (zzbc) C.a(parcel, zzbc.CREATOR);
            C.b(parcel);
            List listZzc = zzc(iObjectWrapperAsInterface2, zzccVar2, zzbcVar);
            parcel2.writeNoException();
            parcel2.writeTypedList(listZzc);
        } else {
            if (i10 != 5) {
                return false;
            }
            zzbe zzbeVar = (zzbe) C.a(parcel, zzbe.CREATOR);
            C.b(parcel);
            zze(zzbeVar);
            parcel2.writeNoException();
        }
        return true;
    }
}
