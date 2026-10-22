package com.obric.aivoice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface AIVoiceBinder extends IInterface {

    public static class Default implements AIVoiceBinder {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aivoice.AIVoiceBinder
        public void callVoice(Bundle r1, AIVoiceListener r2) throws RemoteException {
        }

        @Override // com.obric.aivoice.AIVoiceBinder
        public Bundle callVoiceSync(Bundle r1) throws RemoteException {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements AIVoiceBinder {
        private static final String DESCRIPTOR = "com.obric.aivoice.AIVoiceBinder";
        static final int TRANSACTION_callVoice = 2;
        static final int TRANSACTION_callVoiceSync = 1;

        private static class Proxy implements AIVoiceBinder {
            public static AIVoiceBinder sDefaultImpl;
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

            @Override // com.obric.aivoice.AIVoiceBinder
            public Bundle callVoiceSync(Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L8:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                Bundle r4 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bundle r6 = Stub.getDefaultImpl().callVoiceSync(r5);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aivoice.AIVoiceBinder
            public void callVoice(Bundle r5, AIVoiceListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                IBinder r3 = r6.asBinder();     // Catch: Throwable -> L20
            L10:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().callVoice(r5, r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r3 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
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

        public static AIVoiceBinder asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof AIVoiceBinder) == false) goto L12;
            return (AIVoiceBinder) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            Bundle r0 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L20;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L20:
            Bundle r4 = callVoiceSync(r0);
            r7.writeNoException();
            if (r4 == null) goto L23;
            r7.writeInt(1);
            r4.writeToParcel(r7, 1);
        L24:
            return true;
        L23:
            r7.writeInt(0);
            goto L24
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L15;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L15:
            callVoice(r0, AIVoiceListener.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L7:
            if (r5 != 1598968902) goto L9;
            r7.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r5, r6, r7, r8);
        }

        public static boolean setDefaultImpl(AIVoiceBinder r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static AIVoiceBinder getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void callVoice(Bundle r1, AIVoiceListener r2) throws RemoteException;

    Bundle callVoiceSync(Bundle r1) throws RemoteException;
}
