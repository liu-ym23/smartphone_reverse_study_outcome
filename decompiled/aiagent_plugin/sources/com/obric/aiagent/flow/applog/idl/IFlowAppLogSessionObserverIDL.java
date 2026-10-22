package com.obric.aiagent.flow.applog.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowAppLogSessionObserverIDL extends IInterface {

    public static class Default implements IFlowAppLogSessionObserverIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
        public void onSessionBatchEvent(long r1, String r3) {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
        public void onSessionStart(long r1, String r3) {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
        public void onSessionTerminate(long r1, String r3) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowAppLogSessionObserverIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL";
        static final int TRANSACTION_onSessionBatchEvent = 3;
        static final int TRANSACTION_onSessionStart = 1;
        static final int TRANSACTION_onSessionTerminate = 2;

        private static class Proxy implements IFlowAppLogSessionObserverIDL {
            public static IFlowAppLogSessionObserverIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
            public void onSessionStart(long r4, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r4);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSessionStart(r4, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
            public void onSessionTerminate(long r5, String r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSessionTerminate(r5, r7);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
            public void onSessionBatchEvent(long r5, String r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSessionBatchEvent(r5, r7);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowAppLogSessionObserverIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowAppLogSessionObserverIDL.class) == false) goto L13;
            return (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onSessionStart(r5.readLong(), r5.readString());
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onSessionTerminate(r5.readLong(), r5.readString());
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            onSessionBatchEvent(r5.readLong(), r5.readString());
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IFlowAppLogSessionObserverIDL r2) {
            IFlowAppLogSessionObserverIDL r3 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowAppLogSessionObserverIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onSessionBatchEvent(long r1, String r3);

    void onSessionStart(long r1, String r3);

    void onSessionTerminate(long r1, String r3);
}
