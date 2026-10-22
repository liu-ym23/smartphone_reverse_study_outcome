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
        public void finishFloatingActivity(long r10) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public PendingIntent getFloatingPendingIntent(long r10, Intent r11, FloatingIntentParams r12) throws RemoteException {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public int getVersion() throws RemoteException {
            return 0;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void hideIntentResultCard(long r10) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean isCardViewVisible(long r10) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean isKeyguardReallyLocked() throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerFunction(String r10) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerIntent(String r10, String r11, String r12) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerResultCallback(IErrorCodeCallback r10) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void requestCloseFile(String r10, Uri r11) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean requestOpenFile(IUriFileReceiver r10, Uri r11, String r12) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void requestStateChanged(String r10, TaskStateInfo r11, ITaskStateChangeCallback r12, long r13) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void sendActionExecuteResult(String r10) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void sendIntentExecutionResult(IntentResult r10, String r11) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterFunction(String r10) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterIntent(String r10, String r11) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterResultCallback(IErrorCodeCallback r10) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void updateIntentResult(IntentResult r10, long r11, boolean r12, Map r13) throws RemoteException {
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

            public Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void finishFloatingActivity(long r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeLong(r10);     // Catch: Throwable -> L10
                if (this.mRemote.transact(14, r11, null, 1) == false) goto L6;
            L12:
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().finishFloatingActivity(r10);     // Catch: Throwable -> L10
                r11.recycle();
                return;
            L10:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public PendingIntent getFloatingPendingIntent(long r10, Intent r11, FloatingIntentParams r12) throws RemoteException {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeLong(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r13.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r13, 0);     // Catch: Throwable -> L6
            L9:
                if (r12 == null) goto L11;
                r13.writeInt(1);     // Catch: Throwable -> L6
                r12.writeToParcel(r13, 0);     // Catch: Throwable -> L6
            L13:
                if (this.mRemote.transact(16, r13, r14, 0) == false) goto L15;
            L19:
                r14.readException();     // Catch: Throwable -> L6
                if (r14.readInt() == 0) goto L23;
                PendingIntent r15 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(r14);     // Catch: Throwable -> L6
            L17:
                r14.recycle();
                r13.recycle();
                return r15;
            L23:
                r15 = null;
                goto L17
            L15:
                if (Stub.getDefaultImpl() == null) goto L19;
                r15 = Stub.getDefaultImpl().getFloatingPendingIntent(r10, r11, r12);     // Catch: Throwable -> L6
                goto L17
            L11:
                r13.writeInt(0);     // Catch: Throwable -> L6
                goto L13
            L8:
                r13.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public int getVersion() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L6;
            L12:
                r11.readException();     // Catch: Throwable -> L10
                int r12 = r11.readInt();     // Catch: Throwable -> L10
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                r12 = Stub.getDefaultImpl().getVersion();     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void hideIntentResultCard(long r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeLong(r10);     // Catch: Throwable -> L10
                if (this.mRemote.transact(9, r11, null, 1) == false) goto L6;
            L12:
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().hideIntentResultCard(r10);     // Catch: Throwable -> L10
                r11.recycle();
                return;
            L10:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean isCardViewVisible(long r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeLong(r10);     // Catch: Throwable -> L10
                boolean r13 = false;
                if (this.mRemote.transact(15, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                if (r12.readInt() == 0) goto L15;
                r13 = true;
            L15:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                boolean r14 = Stub.getDefaultImpl().isCardViewVisible(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean isKeyguardReallyLocked() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                boolean r12 = false;
                if (this.mRemote.transact(17, r10, r11, 0) == false) goto L6;
            L12:
                r11.readException();     // Catch: Throwable -> L10
                if (r11.readInt() == 0) goto L15;
                r12 = true;
            L15:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                boolean r13 = Stub.getDefaultImpl().isKeyguardReallyLocked();     // Catch: Throwable -> L10
                r11.recycle();
                r10.recycle();
                return r13;
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerFunction(String r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeString(r10);     // Catch: Throwable -> L10
                if (this.mRemote.transact(2, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
            L8:
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().registerFunction(r10);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerIntent(String r10, String r11, String r12) throws RemoteException {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r13.writeString(r10);     // Catch: Throwable -> L10
                r13.writeString(r11);     // Catch: Throwable -> L10
                r13.writeString(r12);     // Catch: Throwable -> L10
                if (this.mRemote.transact(4, r13, r14, 0) == false) goto L6;
            L12:
                r14.readException();     // Catch: Throwable -> L10
            L8:
                r14.recycle();
                r13.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().registerIntent(r10, r11, r12);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerResultCallback(IErrorCodeCallback r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                IBinder r12 = r10.asBinder();     // Catch: Throwable -> L6
            L9:
                r11.writeStrongBinder(r12);     // Catch: Throwable -> L6
                if (this.mRemote.transact(10, r11, null, 1) == false) goto L12;
            L16:
                r11.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().registerResultCallback(r10);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L8:
                r12 = null;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void requestCloseFile(String r10, Uri r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L10:
                if (this.mRemote.transact(13, r12, null, 1) == false) goto L12;
            L16:
                r12.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().requestCloseFile(r10, r11);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean requestOpenFile(IUriFileReceiver r10, Uri r11, String r12) throws RemoteException {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                IBinder r15 = r10.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                boolean r16 = true;
                if (r11 == null) goto L12;
                r13.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r13, 0);     // Catch: Throwable -> L6
            L13:
                r13.writeString(r12);     // Catch: Throwable -> L6
                if (this.mRemote.transact(12, r13, r14, 0) == false) goto L16;
            L20:
                r14.readException();     // Catch: Throwable -> L6
                if (r14.readInt() != 0) goto L24;
                r16 = false;
            L24:
                r14.recycle();
                r13.recycle();
                return r16;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                boolean r17 = Stub.getDefaultImpl().requestOpenFile(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return r17;
            L12:
                r13.writeInt(0);     // Catch: Throwable -> L6
                goto L13
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void requestStateChanged(String r10, TaskStateInfo r11, ITaskStateChangeCallback r12, long r13) throws RemoteException {
                Parcel r14 = Parcel.obtain();
                r14.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r14.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r14.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r14, 0);     // Catch: Throwable -> L6
            L10:
                if (r12 == null) goto L12;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L13:
                r14.writeStrongBinder(r15);     // Catch: Throwable -> L6
                r14.writeLong(r13);     // Catch: Throwable -> L6
                if (this.mRemote.transact(18, r14, null, 1) == false) goto L16;
            L20:
                r14.recycle();
                return;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                Stub.getDefaultImpl().requestStateChanged(r10, r11, r12, r13);     // Catch: Throwable -> L6
                r14.recycle();
                return;
            L12:
                r15 = null;
                goto L13
            L8:
                r14.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r14.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void sendActionExecuteResult(String r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeString(r10);     // Catch: Throwable -> L10
                if (this.mRemote.transact(7, r11, null, 1) == false) goto L6;
            L12:
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().sendActionExecuteResult(r10);     // Catch: Throwable -> L10
                r11.recycle();
                return;
            L10:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void sendIntentExecutionResult(IntentResult r10, String r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r12.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L6
            L9:
                r12.writeString(r11);     // Catch: Throwable -> L6
                if (this.mRemote.transact(6, r12, null, 1) == false) goto L12;
            L16:
                r12.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().sendIntentExecutionResult(r10, r11);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L8:
                r12.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterFunction(String r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeString(r10);     // Catch: Throwable -> L10
                if (this.mRemote.transact(3, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
            L8:
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().unregisterFunction(r10);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterIntent(String r10, String r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r12.writeString(r10);     // Catch: Throwable -> L10
                r12.writeString(r11);     // Catch: Throwable -> L10
                if (this.mRemote.transact(5, r12, r13, 0) == false) goto L6;
            L12:
                r13.readException();     // Catch: Throwable -> L10
            L8:
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().unregisterIntent(r10, r11);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterResultCallback(IErrorCodeCallback r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                IBinder r12 = r10.asBinder();     // Catch: Throwable -> L6
            L9:
                r11.writeStrongBinder(r12);     // Catch: Throwable -> L6
                if (this.mRemote.transact(11, r11, null, 1) == false) goto L12;
            L16:
                r11.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().unregisterResultCallback(r10);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L8:
                r12 = null;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void updateIntentResult(IntentResult r10, long r11, boolean r12, Map r13) throws RemoteException {
                Parcel r14 = Parcel.obtain();
                r14.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r14.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r14, 0);     // Catch: Throwable -> L6
            L9:
                r14.writeLong(r11);     // Catch: Throwable -> L6
                r14.writeInt(r12 ? 1 : 0);     // Catch: Throwable -> L6
                r14.writeMap(r13);     // Catch: Throwable -> L6
                if (this.mRemote.transact(8, r14, null, 1) == false) goto L12;
            L16:
                r14.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().updateIntentResult(r10, r11, r12, r13);     // Catch: Throwable -> L6
                r14.recycle();
                return;
            L8:
                r14.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r14.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilityManager asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof ICapabilityManager) == false) goto L12;
            return (ICapabilityManager) r11;
        L12:
            return new Proxy(r10);
        }

        public static ICapabilityManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityManager r10) {
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
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) throws RemoteException {
            if (r11 == 1598968902) goto L73;
            IntentResult<?> r10 = null;
            TaskStateInfo r15 = null;
            FloatingIntentParams r16 = null;
            Uri r17 = null;
            Uri r18 = null;
            IntentResult<?> r19 = null;
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
            String r110 = r12.readString();
            if (r12.readInt() == 0) goto L11;
            r15 = TaskStateInfo.CREATOR.createFromParcel(r12);
        L11:
            requestStateChanged(r110, r15, ITaskStateChangeCallback.Stub.asInterface(r12.readStrongBinder()), r12.readLong());
            return true;
        L13:
            r12.enforceInterface(DESCRIPTOR);
            boolean r111 = isKeyguardReallyLocked();
            r13.writeNoException();
            r13.writeInt(r111 ? 1 : 0);
            return true;
        L15:
            r12.enforceInterface(DESCRIPTOR);
            long r20 = r12.readLong();
            if (r12.readInt() == 0) goto L18;
            Intent r112 = (Intent) Intent.CREATOR.createFromParcel(r12);
        L20:
            if (r12.readInt() == 0) goto L22;
            r16 = FloatingIntentParams.CREATOR.a(r12);
        L22:
            PendingIntent r113 = getFloatingPendingIntent(r20, r112, r16);
            r13.writeNoException();
            if (r113 == null) goto L25;
            r13.writeInt(1);
            r113.writeToParcel(r13, 1);
        L26:
            return true;
        L25:
            r13.writeInt(0);
            goto L26
        L18:
            r112 = null;
            goto L20
        L27:
            r12.enforceInterface(DESCRIPTOR);
            boolean r114 = isCardViewVisible(r12.readLong());
            r13.writeNoException();
            r13.writeInt(r114 ? 1 : 0);
            return true;
        L29:
            r12.enforceInterface(DESCRIPTOR);
            finishFloatingActivity(r12.readLong());
            return true;
        L31:
            r12.enforceInterface(DESCRIPTOR);
            String r115 = r12.readString();
            if (r12.readInt() == 0) goto L34;
            r17 = (Uri) Uri.CREATOR.createFromParcel(r12);
        L34:
            requestCloseFile(r115, r17);
            return true;
        L36:
            r12.enforceInterface(DESCRIPTOR);
            IUriFileReceiver r116 = IUriFileReceiver.Stub.asInterface(r12.readStrongBinder());
            if (r12.readInt() == 0) goto L39;
            r18 = (Uri) Uri.CREATOR.createFromParcel(r12);
        L39:
            boolean r117 = requestOpenFile(r116, r18, r12.readString());
            r13.writeNoException();
            r13.writeInt(r117 ? 1 : 0);
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
            r19 = IntentResult.CREATOR.a(r12);
        L50:
            IntentResult<?> r21 = r19;
            long r22 = r12.readLong();
            if (r12.readInt() == 0) goto L53;
            boolean r23 = true;
        L54:
            updateIntentResult(r21, r22, r23, r12.readHashMap(getClass().getClassLoader()));
            return true;
        L53:
            r23 = false;
            goto L54
        L56:
            r12.enforceInterface(DESCRIPTOR);
            sendActionExecuteResult(r12.readString());
            return true;
        L58:
            r12.enforceInterface(DESCRIPTOR);
            if (r12.readInt() == 0) goto L61;
            r10 = IntentResult.CREATOR.a(r12);
        L61:
            sendIntentExecutionResult(r10, r12.readString());
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
            int r118 = getVersion();
            r13.writeNoException();
            r13.writeInt(r118);
            return true;
        L7:
            return super.onTransact(r11, r12, r13, r14);
        L73:
            r13.writeString(DESCRIPTOR);
            return true;
        }
    }

    void finishFloatingActivity(long r10) throws RemoteException;

    PendingIntent getFloatingPendingIntent(long r10, Intent r11, FloatingIntentParams r12) throws RemoteException;

    int getVersion() throws RemoteException;

    void hideIntentResultCard(long r10) throws RemoteException;

    boolean isCardViewVisible(long r10) throws RemoteException;

    boolean isKeyguardReallyLocked() throws RemoteException;

    void registerFunction(String r10) throws RemoteException;

    void registerIntent(String r10, String r11, String r12) throws RemoteException;

    void registerResultCallback(IErrorCodeCallback r10) throws RemoteException;

    void requestCloseFile(String r10, Uri r11) throws RemoteException;

    boolean requestOpenFile(IUriFileReceiver r10, Uri r11, String r12) throws RemoteException;

    void requestStateChanged(String r10, TaskStateInfo r11, ITaskStateChangeCallback r12, long r13) throws RemoteException;

    void sendActionExecuteResult(String r10) throws RemoteException;

    void sendIntentExecutionResult(IntentResult r10, String r11) throws RemoteException;

    void unregisterFunction(String r10) throws RemoteException;

    void unregisterIntent(String r10, String r11) throws RemoteException;

    void unregisterResultCallback(IErrorCodeCallback r10) throws RemoteException;

    void updateIntentResult(IntentResult r10, long r11, boolean r12, Map r13) throws RemoteException;
}
