package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ICapabilityFeedbackReceiver extends IInterface {

    public static class Default implements ICapabilityFeedbackReceiver {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public boolean isCardViewVisible(long r10) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public boolean isKeyguardReallyLocked() throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onActionResultRecv(String r10, String r11, boolean r12) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onFinishFloatingActivity(long r10) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onHideIntentResultCard(long r10) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onJobResultRecv(String r10, String r11, boolean r12, JobResult r13) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onUpdateIntentResult(long r10, IntentResult r11, boolean r12, Map r13) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onUpdateIntentResultWithRequest(String r10, IntentResult r11, boolean r12, Map r13) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityFeedbackReceiver {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityFeedbackReceiver";
        public static final int TRANSACTION_isCardViewVisible = 6;
        public static final int TRANSACTION_isKeyguardReallyLocked = 7;
        public static final int TRANSACTION_onActionResultRecv = 1;
        public static final int TRANSACTION_onFinishFloatingActivity = 5;
        public static final int TRANSACTION_onHideIntentResultCard = 3;
        public static final int TRANSACTION_onJobResultRecv = 4;
        public static final int TRANSACTION_onUpdateIntentResult = 2;
        public static final int TRANSACTION_onUpdateIntentResultWithRequest = 8;

        public static class Proxy implements ICapabilityFeedbackReceiver {
            public static ICapabilityFeedbackReceiver sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public boolean isCardViewVisible(long r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeLong(r10);     // Catch: Throwable -> L10
                boolean r13 = false;
                if (this.mRemote.transact(6, r11, r12, 0) == false) goto L6;
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

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public boolean isKeyguardReallyLocked() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                boolean r12 = false;
                if (this.mRemote.transact(7, r10, r11, 0) == false) goto L6;
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

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onActionResultRecv(String r10, String r11, boolean r12) throws RemoteException {
                Parcel r13 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r13.writeString(r10);     // Catch: Throwable -> L10
                r13.writeString(r11);     // Catch: Throwable -> L10
                r13.writeInt(r12 ? 1 : 0);     // Catch: Throwable -> L10
                if (this.mRemote.transact(1, r13, null, 1) == false) goto L6;
            L12:
                r13.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().onActionResultRecv(r10, r11, r12);     // Catch: Throwable -> L10
                r13.recycle();
                return;
            L10:
                th = move-exception;
                r13.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onFinishFloatingActivity(long r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeLong(r10);     // Catch: Throwable -> L10
                if (this.mRemote.transact(5, r11, null, 1) == false) goto L6;
            L12:
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().onFinishFloatingActivity(r10);     // Catch: Throwable -> L10
                r11.recycle();
                return;
            L10:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onHideIntentResultCard(long r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeLong(r10);     // Catch: Throwable -> L10
                if (this.mRemote.transact(3, r11, null, 1) == false) goto L6;
            L12:
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().onHideIntentResultCard(r10);     // Catch: Throwable -> L10
                r11.recycle();
                return;
            L10:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onJobResultRecv(String r10, String r11, boolean r12, JobResult r13) throws RemoteException {
                Parcel r14 = Parcel.obtain();
                r14.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r14.writeString(r10);     // Catch: Throwable -> L6
                r14.writeString(r11);     // Catch: Throwable -> L6
                r14.writeInt(r12 ? 1 : 0);     // Catch: Throwable -> L6
                if (r13 == null) goto L8;
                r14.writeInt(1);     // Catch: Throwable -> L6
                r13.writeToParcel(r14, 0);     // Catch: Throwable -> L6
            L10:
                if (this.mRemote.transact(4, r14, null, 1) == false) goto L12;
            L16:
                r14.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().onJobResultRecv(r10, r11, r12, r13);     // Catch: Throwable -> L6
                r14.recycle();
                return;
            L8:
                r14.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r14.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onUpdateIntentResult(long r10, IntentResult r11, boolean r12, Map r13) throws RemoteException {
                Parcel r14 = Parcel.obtain();
                r14.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r14.writeLong(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r14.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r14, 0);     // Catch: Throwable -> L6
            L9:
                r14.writeInt(r12 ? 1 : 0);     // Catch: Throwable -> L6
                r14.writeMap(r13);     // Catch: Throwable -> L6
                if (this.mRemote.transact(2, r14, null, 1) == false) goto L12;
            L16:
                r14.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().onUpdateIntentResult(r10, r11, r12, r13);     // Catch: Throwable -> L6
                r14.recycle();
                return;
            L8:
                r14.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r14.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onUpdateIntentResultWithRequest(String r10, IntentResult r11, boolean r12, Map r13) throws RemoteException {
                Parcel r14 = Parcel.obtain();
                r14.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r14.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                r14.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r14, 0);     // Catch: Throwable -> L6
            L9:
                r14.writeInt(r12 ? 1 : 0);     // Catch: Throwable -> L6
                r14.writeMap(r13);     // Catch: Throwable -> L6
                if (this.mRemote.transact(8, r14, null, 1) == false) goto L12;
            L16:
                r14.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().onUpdateIntentResultWithRequest(r10, r11, r12, r13);     // Catch: Throwable -> L6
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

        public static ICapabilityFeedbackReceiver asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof ICapabilityFeedbackReceiver) == false) goto L12;
            return (ICapabilityFeedbackReceiver) r11;
        L12:
            return new Proxy(r10);
        }

        public static ICapabilityFeedbackReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityFeedbackReceiver r10) {
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
            if (r10 == 1598968902) goto L46;
            IntentResult<?> r14 = null;
            IntentResult<?> r15 = null;
            JobResult r16 = null;
            boolean r17 = false;
            switch(r10) {
                case 1: goto L41;
                case 2: goto L32;
                case 3: goto L30;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface(DESCRIPTOR);
            String r18 = r11.readString();
            if (r11.readInt() == 0) goto L12;
            r15 = IntentResult.CREATOR.a(r11);
        L12:
            if (r11.readInt() == 0) goto L14;
            r17 = true;
        L14:
            onUpdateIntentResultWithRequest(r18, r15, r17, r11.readHashMap(getClass().getClassLoader()));
            return true;
        L16:
            r11.enforceInterface(DESCRIPTOR);
            boolean r19 = isKeyguardReallyLocked();
            r12.writeNoException();
            r12.writeInt(r19 ? 1 : 0);
            return true;
        L18:
            r11.enforceInterface(DESCRIPTOR);
            boolean r20 = isCardViewVisible(r11.readLong());
            r12.writeNoException();
            r12.writeInt(r20 ? 1 : 0);
            return true;
        L20:
            r11.enforceInterface(DESCRIPTOR);
            onFinishFloatingActivity(r11.readLong());
            return true;
        L22:
            r11.enforceInterface(DESCRIPTOR);
            String r21 = r11.readString();
            String r110 = r11.readString();
            if (r11.readInt() == 0) goto L26;
            r17 = true;
        L26:
            if (r11.readInt() == 0) goto L28;
            r16 = JobResult.CREATOR.createFromParcel(r11);
        L28:
            onJobResultRecv(r21, r110, r17, r16);
            return true;
        L30:
            r11.enforceInterface(DESCRIPTOR);
            onHideIntentResultCard(r11.readLong());
            return true;
        L32:
            r11.enforceInterface(DESCRIPTOR);
            long r111 = r11.readLong();
            if (r11.readInt() == 0) goto L35;
            r14 = IntentResult.CREATOR.a(r11);
        L35:
            IntentResult<?> r22 = r14;
            if (r11.readInt() == 0) goto L38;
            boolean r23 = true;
        L39:
            onUpdateIntentResult(r111, r22, r23, r11.readHashMap(getClass().getClassLoader()));
            return true;
        L38:
            r23 = false;
            goto L39
        L41:
            r11.enforceInterface(DESCRIPTOR);
            String r24 = r11.readString();
            String r112 = r11.readString();
            if (r11.readInt() == 0) goto L44;
            r17 = true;
        L44:
            onActionResultRecv(r24, r112, r17);
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L46:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean isCardViewVisible(long r10) throws RemoteException;

    boolean isKeyguardReallyLocked() throws RemoteException;

    void onActionResultRecv(String r10, String r11, boolean r12) throws RemoteException;

    void onFinishFloatingActivity(long r10) throws RemoteException;

    void onHideIntentResultCard(long r10) throws RemoteException;

    void onJobResultRecv(String r10, String r11, boolean r12, JobResult r13) throws RemoteException;

    void onUpdateIntentResult(long r10, IntentResult r11, boolean r12, Map r13) throws RemoteException;

    void onUpdateIntentResultWithRequest(String r10, IntentResult r11, boolean r12, Map r13) throws RemoteException;
}
