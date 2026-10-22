package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICapabilitySchedule extends IInterface {

    public static class Default implements ICapabilitySchedule {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void dispatchServerActions(String r10, boolean r11) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void queryAppIntents(String r10, IQueryAppIntentsCallback r11) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void registerActionsResultReceiver(ICapabilityFeedbackReceiver r10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICapabilitySchedule {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilitySchedule";
        public static final int TRANSACTION_dispatchServerActions = 1;
        public static final int TRANSACTION_queryAppIntents = 3;
        public static final int TRANSACTION_registerActionsResultReceiver = 2;

        public static class Proxy implements ICapabilitySchedule {
            public static ICapabilitySchedule sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.capabilitykit.common.ICapabilitySchedule
            public void dispatchServerActions(String r10, boolean r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r12.writeString(r10);     // Catch: Throwable -> L10
                r12.writeInt(r11 ? 1 : 0);     // Catch: Throwable -> L10
                if (this.mRemote.transact(1, r12, r13, 0) == false) goto L6;
            L12:
                r13.readException();     // Catch: Throwable -> L10
            L8:
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().dispatchServerActions(r10, r11);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilitySchedule
            public void queryAppIntents(String r10, IQueryAppIntentsCallback r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L6
            L9:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L6
                if (this.mRemote.transact(3, r12, r13, 0) == false) goto L12;
            L16:
                r13.readException();     // Catch: Throwable -> L6
            L14:
                r13.recycle();
                r12.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().queryAppIntents(r10, r11);     // Catch: Throwable -> L6
                goto L14
            L8:
                r14 = null;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilitySchedule
            public void registerActionsResultReceiver(ICapabilityFeedbackReceiver r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L6
            L9:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L6
                if (this.mRemote.transact(2, r11, r12, 0) == false) goto L12;
            L16:
                r12.readException();     // Catch: Throwable -> L6
            L14:
                r12.recycle();
                r11.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().registerActionsResultReceiver(r10);     // Catch: Throwable -> L6
                goto L14
            L8:
                r13 = null;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilitySchedule asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof ICapabilitySchedule) == false) goto L12;
            return (ICapabilitySchedule) r11;
        L12:
            return new Proxy(r10);
        }

        public static ICapabilitySchedule getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilitySchedule r10) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r10 == null) goto L9;
            Proxy.sDefaultImpl = r10;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 != 1) goto L5;
            r11.enforceInterface(DESCRIPTOR);
            String r14 = r11.readString();
            if (r11.readInt() == 0) goto L21;
            boolean r15 = true;
        L22:
            dispatchServerActions(r14, r15);
        L15:
            r12.writeNoException();
            return true;
        L21:
            r15 = false;
            goto L22
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface(DESCRIPTOR);
            registerActionsResultReceiver(ICapabilityFeedbackReceiver.Stub.asInterface(r11.readStrongBinder()));
            goto L15
        L7:
            if (r10 != 3) goto L9;
            r11.enforceInterface(DESCRIPTOR);
            queryAppIntents(r11.readString(), IQueryAppIntentsCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L15
        L9:
            if (r10 != 1598968902) goto L11;
            r12.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void dispatchServerActions(String r10, boolean r11) throws RemoteException;

    void queryAppIntents(String r10, IQueryAppIntentsCallback r11) throws RemoteException;

    void registerActionsResultReceiver(ICapabilityFeedbackReceiver r10) throws RemoteException;
}
