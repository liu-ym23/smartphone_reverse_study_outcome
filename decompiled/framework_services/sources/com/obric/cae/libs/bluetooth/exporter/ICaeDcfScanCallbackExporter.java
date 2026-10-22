package com.obric.cae.libs.bluetooth.exporter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.CaeDcfScanResult;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeDcfScanCallbackExporter extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanCallbackExporter";

    public static class Default implements ICaeDcfScanCallbackExporter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanCallbackExporter
        public void onDevicesChanged(List<CaeDcfScanResult> r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeDcfScanCallbackExporter {
        static final int TRANSACTION_onDevicesChanged = 1;

        public static class Proxy implements ICaeDcfScanCallbackExporter {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICaeDcfScanCallbackExporter.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanCallbackExporter
            public void onDevicesChanged(List<CaeDcfScanResult> r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeDcfScanCallbackExporter.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeTypedList(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICaeDcfScanCallbackExporter.DESCRIPTOR);
        }

        public static ICaeDcfScanCallbackExporter asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeDcfScanCallbackExporter.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeDcfScanCallbackExporter) == false) goto L12;
            return (ICaeDcfScanCallbackExporter) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(ICaeDcfScanCallbackExporter.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            onDevicesChanged(r5.createTypedArrayList(CaeDcfScanResult.CREATOR));
            r6.writeNoException();
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString(ICaeDcfScanCallbackExporter.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }
    }

    void onDevicesChanged(List<CaeDcfScanResult> r1) throws RemoteException;
}
