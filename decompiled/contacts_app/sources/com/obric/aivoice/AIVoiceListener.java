package com.obric.aivoice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface AIVoiceListener extends IInterface {

    public static class Default implements AIVoiceListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aivoice.AIVoiceListener
        public int getVersion() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aivoice.AIVoiceListener
        public int onAsrResponse(String r1, String r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.aivoice.AIVoiceListener
        public void onResult(Bundle r1) throws RemoteException {
        }

        @Override // com.obric.aivoice.AIVoiceListener
        public int onTtsResponse(String r1, byte[] r2, String r3) throws RemoteException {
            return 0;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements AIVoiceListener {
        private static final String DESCRIPTOR = "com.obric.aivoice.AIVoiceListener";
        static final int TRANSACTION_getVersion = 1;
        static final int TRANSACTION_onAsrResponse = 3;
        static final int TRANSACTION_onResult = 2;
        static final int TRANSACTION_onTtsResponse = 4;

        private static class Proxy implements AIVoiceListener {
            public static AIVoiceListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.aivoice.AIVoiceListener
            public int getVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getVersion();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aivoice.AIVoiceListener
            public void onResult(Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onResult(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aivoice.AIVoiceListener
            public int onAsrResponse(String r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().onAsrResponse(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aivoice.AIVoiceListener
            public int onTtsResponse(String r5, byte[] r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeByteArray(r6);     // Catch: Throwable -> L13
                r0.writeString(r7);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().onTtsResponse(r5, r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static AIVoiceListener asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof AIVoiceListener) == false) goto L12;
            return (AIVoiceListener) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            int r3 = getVersion();
            r6.writeNoException();
            r6.writeInt(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L23;
            Bundle r8 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L24:
            onResult(r8);
            r6.writeNoException();
            return true;
        L23:
            r8 = null;
            goto L24
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            int r9 = onAsrResponse(r5.readString(), r5.readString());
            r6.writeNoException();
            r6.writeInt(r9);
            return true;
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface(DESCRIPTOR);
            int r10 = onTtsResponse(r5.readString(), r5.createByteArray(), r5.readString());
            r6.writeNoException();
            r6.writeInt(r10);
            return true;
        L11:
            if (r4 != 1598968902) goto L13;
            r6.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(AIVoiceListener r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static AIVoiceListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    int getVersion() throws RemoteException;

    int onAsrResponse(String r1, String r2) throws RemoteException;

    void onResult(Bundle r1) throws RemoteException;

    int onTtsResponse(String r1, byte[] r2, String r3) throws RemoteException;
}
