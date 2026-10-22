package com.obric.capabilitykit.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ICapabilityManager extends IInterface {

    public static class Default implements ICapabilityManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void finishFloatingActivity(long r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public PendingIntent getFloatingPendingIntent(long r1, Intent r3, FloatingIntentParams r4) throws RemoteException {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public int getVersion() throws RemoteException {
            return 0;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void hideIntentResultCard(long r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean isCardViewVisible(long r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean isKeyguardReallyLocked() throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerFunction(String r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerIntent(String r1, String r2, String r3) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerResultCallback(IErrorCodeCallback r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void requestCloseFile(String r1, Uri r2) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean requestOpenFile(IUriFileReceiver r1, Uri r2, String r3) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void requestStateChanged(String r1, TaskStateInfo r2, ITaskStateChangeCallback r3, long r4) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void sendActionExecuteResult(String r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void sendIntentExecutionResult(IntentResult r1, String r2) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterFunction(String r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterIntent(String r1, String r2) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterResultCallback(IErrorCodeCallback r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void updateIntentResult(IntentResult r1, long r2, boolean r4, Map r5) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityManager {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityManager";
        public static final int TRANSACTION_finishFloatingActivity = 14;
        public static final int TRANSACTION_getFloatingPendingIntent = 16;
        public static final int TRANSACTION_getVersion = 1;
        public static final int TRANSACTION_hideIntentResultCard = 9;
        public static final int TRANSACTION_isCardViewVisible = 15;
        public static final int TRANSACTION_isKeyguardReallyLocked = 17;
        public static final int TRANSACTION_registerFunction = 2;
        public static final int TRANSACTION_registerIntent = 4;
        public static final int TRANSACTION_registerResultCallback = 10;
        public static final int TRANSACTION_requestCloseFile = 13;
        public static final int TRANSACTION_requestOpenFile = 12;
        public static final int TRANSACTION_requestStateChanged = 18;
        public static final int TRANSACTION_sendActionExecuteResult = 7;
        public static final int TRANSACTION_sendIntentExecutionResult = 6;
        public static final int TRANSACTION_unregisterFunction = 3;
        public static final int TRANSACTION_unregisterIntent = 5;
        public static final int TRANSACTION_unregisterResultCallback = 11;
        public static final int TRANSACTION_updateIntentResult = 8;

        public static class Proxy implements ICapabilityManager {
            public static ICapabilityManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void finishFloatingActivity(long r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(14, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().finishFloatingActivity(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public PendingIntent getFloatingPendingIntent(long r5, Intent r7, FloatingIntentParams r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L22
                r0.writeLong(r5);     // Catch: Throwable -> L22
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L22
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L22
            L7:
                if (r8 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L22
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L22
            L11:
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L22
                if (r1.readInt() == 0) goto L21;
                PendingIntent r4 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L22
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L21:
                r4 = null;
                goto L15
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                r4 = Stub.getDefaultImpl().getFloatingPendingIntent(r5, r7, r8);     // Catch: Throwable -> L22
                goto L15
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L22
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L22
            L22:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public int getVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void hideIntentResultCard(long r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(9, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().hideIntentResultCard(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean isCardViewVisible(long r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeLong(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isCardViewVisible(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean isKeyguardReallyLocked() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isKeyguardReallyLocked();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerFunction(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().registerFunction(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerIntent(String r5, String r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().registerIntent(r5, r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerResultCallback(IErrorCodeCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(10, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerResultCallback(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void requestCloseFile(String r5, Uri r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeString(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(13, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestCloseFile(r5, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean requestOpenFile(IUriFileReceiver r6, Uri r7, String r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L24
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L24
                boolean r3 = true;
                if (r7 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L24
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L24
            L11:
                r0.writeString(r8);     // Catch: Throwable -> L24
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L24
                if (r1.readInt() != 0) goto L22;
                r3 = false;
            L22:
                r1.recycle();
                r0.recycle();
                return r3;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                boolean r5 = Stub.getDefaultImpl().requestOpenFile(r6, r7, r8);     // Catch: Throwable -> L24
                r1.recycle();
                r0.recycle();
                return r5;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L24
                goto L11
            L6:
                r2 = null;
            L24:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void requestStateChanged(String r8, TaskStateInfo r9, ITaskStateChangeCallback r10, long r11) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeString(r8);     // Catch: Throwable -> L20
                if (r9 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r9.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (r10 == null) goto L10;
                IBinder r3 = r10.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                r0.writeLong(r11);     // Catch: Throwable -> L20
                if (this.mRemote.transact(18, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().requestStateChanged(r8, r9, r10, r11);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void sendActionExecuteResult(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().sendActionExecuteResult(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void sendIntentExecutionResult(IntentResult r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeString(r6);     // Catch: Throwable -> L16
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().sendIntentExecutionResult(r5, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterFunction(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterFunction(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterIntent(String r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterIntent(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterResultCallback(IErrorCodeCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(11, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterResultCallback(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void updateIntentResult(IntentResult r8, long r9, boolean r11, Map r12) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeLong(r9);     // Catch: Throwable -> L16
                r0.writeInt(r11 ? 1 : 0);     // Catch: Throwable -> L16
                r0.writeMap(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateIntentResult(r8, r9, r11, r12);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilityManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICapabilityManager) == false) goto L12;
            return (ICapabilityManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICapabilityManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityManager r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
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
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) throws RemoteException {
            if (r11 == 1598968902) goto L73;
            IntentResult<?> r3 = null;
            TaskStateInfo r4 = null;
            FloatingIntentParams r5 = null;
            Uri r6 = null;
            Uri r7 = null;
            IntentResult<?> r8 = null;
            switch(r11) {
                case 1: goto L71;
                case 2: goto L69;
                case 3: goto L67;
                case 4: goto L65;
                case 5: goto L63;
                case 6: goto L58;
                case 7: goto L56;
                case 8: goto L47;
                case 9: goto L45;
                case 10: goto L43;
                case 11: goto L41;
                case 12: goto L36;
                case 13: goto L31;
                case 14: goto L29;
                case 15: goto L27;
                case 16: goto L15;
                case 17: goto L13;
                case 18: goto L8;
                default: goto L7;
            };
        L8:
            r12.enforceInterface(DESCRIPTOR);
            String r9 = r12.readString();
            if (r12.readInt() == 0) goto L11;
            r4 = TaskStateInfo.CREATOR.createFromParcel(r12);
        L11:
            requestStateChanged(r9, r4, ITaskStateChangeCallback.Stub.asInterface(r12.readStrongBinder()), r12.readLong());
            return true;
        L13:
            r12.enforceInterface(DESCRIPTOR);
            boolean r10 = isKeyguardReallyLocked();
            r13.writeNoException();
            r13.writeInt(r10 ? 1 : 0);
            return true;
        L15:
            r12.enforceInterface(DESCRIPTOR);
            long r15 = r12.readLong();
            if (r12.readInt() == 0) goto L18;
            Intent r16 = (Intent) Intent.CREATOR.createFromParcel(r12);
        L20:
            if (r12.readInt() == 0) goto L22;
            r5 = FloatingIntentParams.CREATOR.a(r12);
        L22:
            PendingIntent r17 = getFloatingPendingIntent(r15, r16, r5);
            r13.writeNoException();
            if (r17 == null) goto L25;
            r13.writeInt(1);
            r17.writeToParcel(r13, 1);
        L26:
            return true;
        L25:
            r13.writeInt(0);
            goto L26
        L18:
            r16 = null;
            goto L20
        L27:
            r12.enforceInterface(DESCRIPTOR);
            boolean r18 = isCardViewVisible(r12.readLong());
            r13.writeNoException();
            r13.writeInt(r18 ? 1 : 0);
            return true;
        L29:
            r12.enforceInterface(DESCRIPTOR);
            finishFloatingActivity(r12.readLong());
            return true;
        L31:
            r12.enforceInterface(DESCRIPTOR);
            String r19 = r12.readString();
            if (r12.readInt() == 0) goto L34;
            r6 = (Uri) Uri.CREATOR.createFromParcel(r12);
        L34:
            requestCloseFile(r19, r6);
            return true;
        L36:
            r12.enforceInterface(DESCRIPTOR);
            IUriFileReceiver r110 = IUriFileReceiver.Stub.asInterface(r12.readStrongBinder());
            if (r12.readInt() == 0) goto L39;
            r7 = (Uri) Uri.CREATOR.createFromParcel(r12);
        L39:
            boolean r111 = requestOpenFile(r110, r7, r12.readString());
            r13.writeNoException();
            r13.writeInt(r111 ? 1 : 0);
            return true;
        L41:
            r12.enforceInterface(DESCRIPTOR);
            unregisterResultCallback(IErrorCodeCallback.Stub.asInterface(r12.readStrongBinder()));
            return true;
        L43:
            r12.enforceInterface(DESCRIPTOR);
            registerResultCallback(IErrorCodeCallback.Stub.asInterface(r12.readStrongBinder()));
            return true;
        L45:
            r12.enforceInterface(DESCRIPTOR);
            hideIntentResultCard(r12.readLong());
            return true;
        L47:
            r12.enforceInterface(DESCRIPTOR);
            if (r12.readInt() == 0) goto L50;
            r8 = IntentResult.CREATOR.a(r12);
        L50:
            IntentResult<?> r20 = r8;
            long r21 = r12.readLong();
            if (r12.readInt() == 0) goto L53;
            boolean r22 = true;
        L54:
            updateIntentResult(r20, r21, r22, r12.readHashMap(getClass().getClassLoader()));
            return true;
        L53:
            r22 = false;
            goto L54
        L56:
            r12.enforceInterface(DESCRIPTOR);
            sendActionExecuteResult(r12.readString());
            return true;
        L58:
            r12.enforceInterface(DESCRIPTOR);
            if (r12.readInt() == 0) goto L61;
            r3 = IntentResult.CREATOR.a(r12);
        L61:
            sendIntentExecutionResult(r3, r12.readString());
            return true;
        L63:
            r12.enforceInterface(DESCRIPTOR);
            unregisterIntent(r12.readString(), r12.readString());
            r13.writeNoException();
            return true;
        L65:
            r12.enforceInterface(DESCRIPTOR);
            registerIntent(r12.readString(), r12.readString(), r12.readString());
            r13.writeNoException();
            return true;
        L67:
            r12.enforceInterface(DESCRIPTOR);
            unregisterFunction(r12.readString());
            r13.writeNoException();
            return true;
        L69:
            r12.enforceInterface(DESCRIPTOR);
            registerFunction(r12.readString());
            r13.writeNoException();
            return true;
        L71:
            r12.enforceInterface(DESCRIPTOR);
            int r112 = getVersion();
            r13.writeNoException();
            r13.writeInt(r112);
            return true;
        L7:
            return super.onTransact(r11, r12, r13, r14);
        L73:
            r13.writeString(DESCRIPTOR);
            return true;
        }
    }

    void finishFloatingActivity(long r1) throws RemoteException;

    PendingIntent getFloatingPendingIntent(long r1, Intent r3, FloatingIntentParams r4) throws RemoteException;

    int getVersion() throws RemoteException;

    void hideIntentResultCard(long r1) throws RemoteException;

    boolean isCardViewVisible(long r1) throws RemoteException;

    boolean isKeyguardReallyLocked() throws RemoteException;

    void registerFunction(String r1) throws RemoteException;

    void registerIntent(String r1, String r2, String r3) throws RemoteException;

    void registerResultCallback(IErrorCodeCallback r1) throws RemoteException;

    void requestCloseFile(String r1, Uri r2) throws RemoteException;

    boolean requestOpenFile(IUriFileReceiver r1, Uri r2, String r3) throws RemoteException;

    void requestStateChanged(String r1, TaskStateInfo r2, ITaskStateChangeCallback r3, long r4) throws RemoteException;

    void sendActionExecuteResult(String r1) throws RemoteException;

    void sendIntentExecutionResult(IntentResult r1, String r2) throws RemoteException;

    void unregisterFunction(String r1) throws RemoteException;

    void unregisterIntent(String r1, String r2) throws RemoteException;

    void unregisterResultCallback(IErrorCodeCallback r1) throws RemoteException;

    void updateIntentResult(IntentResult r1, long r2, boolean r4, Map r5) throws RemoteException;
}
