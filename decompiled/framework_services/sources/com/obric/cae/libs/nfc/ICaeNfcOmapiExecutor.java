package com.obric.cae.libs.nfc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeNfcOmapiExecutor extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.nfc.ICaeNfcOmapiExecutor";

    public static class Default implements ICaeNfcOmapiExecutor {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcOmapiExecutor
        public String getEseId() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcOmapiExecutor
        public CaeNfcCardQueryResult queryInstalledCards(List<String> r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcOmapiExecutor
        public CaeNfcCardSwitchResult switchActiveCard(String r1, List<String> r2) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICaeNfcOmapiExecutor {
        static final int TRANSACTION_getEseId = 1;
        static final int TRANSACTION_queryInstalledCards = 2;
        static final int TRANSACTION_switchActiveCard = 3;

        public static class Proxy implements ICaeNfcOmapiExecutor {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcOmapiExecutor
            public String getEseId() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcOmapiExecutor.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r2 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return ICaeNfcOmapiExecutor.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcOmapiExecutor
            public CaeNfcCardQueryResult queryInstalledCards(List<String> r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcOmapiExecutor.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStringList(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator<CaeNfcCardQueryResult> r6 = CaeNfcCardQueryResult.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                CaeNfcCardQueryResult r7 = r6.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                CaeNfcCardQueryResult r8 = r7;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r8;
            L8:
                r7 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcOmapiExecutor
            public CaeNfcCardSwitchResult switchActiveCard(String r4, List<String> r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcOmapiExecutor.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStringList(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator<CaeNfcCardSwitchResult> r6 = CaeNfcCardSwitchResult.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                CaeNfcCardSwitchResult r7 = r6.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                CaeNfcCardSwitchResult r8 = r7;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r8;
            L8:
                r7 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICaeNfcOmapiExecutor.DESCRIPTOR);
        }

        public static ICaeNfcOmapiExecutor asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeNfcOmapiExecutor.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeNfcOmapiExecutor) == false) goto L12;
            return (ICaeNfcOmapiExecutor) r0;
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
            r5.enforceInterface(ICaeNfcOmapiExecutor.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L20;
            if (r4 != 1) goto L11;
            String r8 = getEseId();
            r6.writeNoException();
            r6.writeString(r8);
        L19:
            return true;
        L11:
            if (r4 != 2) goto L13;
            CaeNfcCardQueryResult r9 = queryInstalledCards(r5.createStringArrayList());
            r6.writeNoException();
            _Parcel.a(r6, r9);
            goto L19
        L13:
            if (r4 != 3) goto L15;
            CaeNfcCardSwitchResult r10 = switchActiveCard(r5.readString(), r5.createStringArrayList());
            r6.writeNoException();
            _Parcel.a(r6, r10);
            goto L19
        L15:
            return super.onTransact(r4, r5, r6, r7);
        L20:
            r6.writeString(ICaeNfcOmapiExecutor.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static void a(Parcel r1, Parcelable r2) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, 1);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    String getEseId() throws RemoteException;

    CaeNfcCardQueryResult queryInstalledCards(List<String> r1) throws RemoteException;

    CaeNfcCardSwitchResult switchActiveCard(String r1, List<String> r2) throws RemoteException;
}
