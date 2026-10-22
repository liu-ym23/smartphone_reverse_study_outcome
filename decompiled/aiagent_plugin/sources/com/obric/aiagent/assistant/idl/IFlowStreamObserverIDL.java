package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowStreamObserverIDL extends IInterface {

    public static class Default implements IFlowStreamObserverIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
        public void onStreamBegin(IMMessage r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
        public void onStreamEnd(IMMessage r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowStreamObserverIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL";
        static final int TRANSACTION_onStreamBegin = 1;
        static final int TRANSACTION_onStreamEnd = 2;

        private static class Proxy implements IFlowStreamObserverIDL {
            public static IFlowStreamObserverIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
            public void onStreamBegin(IMMessage r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onStreamBegin(r4);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
            public void onStreamEnd(IMMessage r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onStreamEnd(r5);     // Catch: Throwable -> L16
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

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowStreamObserverIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowStreamObserverIDL.class) == false) goto L13;
            return (IFlowStreamObserverIDL) ZeusTransformUtils.preCheckCast(r0, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            IMMessage r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L20;
            r1 = (IMMessage) ZeusTransformUtils.preCheckCast(IMMessage.CREATOR.createFromParcel(r7), IMMessage.class, "com.obric.aiagent.plugin");
        L20:
            onStreamBegin(r1);
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L15;
            r1 = (IMMessage) ZeusTransformUtils.preCheckCast(IMMessage.CREATOR.createFromParcel(r7), IMMessage.class, "com.obric.aiagent.plugin");
        L15:
            onStreamEnd(r1);
            return true;
        L7:
            if (r6 != 1598968902) goto L9;
            r8.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r6, r7, r8, r9);
        }

        public static boolean setDefaultImpl(IFlowStreamObserverIDL r2) {
            IFlowStreamObserverIDL r3 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowStreamObserverIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onStreamBegin(IMMessage r1);

    void onStreamEnd(IMMessage r1);
}
