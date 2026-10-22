package com.obric.cae.libs.network.AppQoEReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IAppQoEReport extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.network.AppQoEReport.IAppQoEReport";

    public static class Default implements IAppQoEReport {
        public Default() {
        }

        @Override // com.obric.cae.libs.network.AppQoEReport.IAppQoEReport
        public void AppQoeReport(QoeReportParams r1) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAppQoEReport {
        static final int TRANSACTION_AppQoeReport = 1;

        public static class Proxy implements IAppQoEReport {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.cae.libs.network.AppQoEReport.IAppQoEReport
            public void AppQoeReport(QoeReportParams r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IAppQoEReport.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAppQoEReport.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IAppQoEReport.DESCRIPTOR);
        }

        public static IAppQoEReport asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IAppQoEReport.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAppQoEReport) == false) goto L12;
            return (IAppQoEReport) r0;
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
            r5.enforceInterface(IAppQoEReport.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            AppQoeReport((QoeReportParams) _Parcel.a(r5, QoeReportParams.CREATOR));
            r6.writeNoException();
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString(IAppQoEReport.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static Object a(Parcel r1, Parcelable.Creator r2) {
            if (r1.readInt() != 0) goto L7;
            return null;
        L7:
            return r2.createFromParcel(r1);
        }
    }

    void AppQoeReport(QoeReportParams r1) throws RemoteException;
}
