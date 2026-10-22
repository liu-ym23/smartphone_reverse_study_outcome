package com.obric.memorydata.sdk.realtime;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IRealTimeContextCallback extends IInterface {

    public static class Default implements IRealTimeContextCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextCallback
        public void updateActionContext(ActionContext r1) {
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextCallback
        public void updateRealTimeContext(RealTimeContext r1, boolean r2) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IRealTimeContextCallback {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.realtime.IRealTimeContextCallback";
        static final int TRANSACTION_updateActionContext = 2;
        static final int TRANSACTION_updateRealTimeContext = 1;

        private static class Proxy implements IRealTimeContextCallback {
            public static IRealTimeContextCallback sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextCallback
            public void updateRealTimeContext(RealTimeContext r6, boolean r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == false) goto L9;
                int r4 = 1;
            L10:
                r0.writeInt(r4);     // Catch: Throwable -> L20
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().updateRealTimeContext(r6, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r4 = 0;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextCallback
            public void updateActionContext(ActionContext r5) {
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
                Stub.getDefaultImpl().updateActionContext(r5);     // Catch: Throwable -> L17
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRealTimeContextCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IRealTimeContextCallback.class) == false) goto L13;
            return (IRealTimeContextCallback) ZeusTransformUtils.preCheckCast(r0, IRealTimeContextCallback.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            RealTimeContext r0 = null;
            ActionContext r1 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L21;
            r0 = (RealTimeContext) ZeusTransformUtils.preCheckCast(RealTimeContext.CREATOR.createFromParcel(r6), RealTimeContext.class, "com.obric.aiagent.plugin");
        L21:
            if (r6.readInt() == 0) goto L23;
            boolean r9 = true;
        L24:
            updateRealTimeContext(r0, r9);
            r7.writeNoException();
            return true;
        L23:
            r9 = false;
            goto L24
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L15;
            r1 = ActionContext.CREATOR.createFromParcel(r6);
        L15:
            updateActionContext(r1);
            r7.writeNoException();
            return true;
        L7:
            if (r5 != 1598968902) goto L9;
            r7.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r5, r6, r7, r8);
        }

        public static boolean setDefaultImpl(IRealTimeContextCallback r2) {
            IRealTimeContextCallback r3 = (IRealTimeContextCallback) ZeusTransformUtils.wrapperContextForParams(r2, IRealTimeContextCallback.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IRealTimeContextCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void updateActionContext(ActionContext r1);

    void updateRealTimeContext(RealTimeContext r1, boolean r2);
}
