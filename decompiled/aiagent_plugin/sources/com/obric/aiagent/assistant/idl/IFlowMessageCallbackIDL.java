package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowMessageCallbackIDL extends IInterface {

    public static class Default implements IFlowMessageCallbackIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
        public void onInsertMessageList(List<IMMessage> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
        public void onReceiveMessage(IMMessage r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
        public void onRegenMessage(IMMessage r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
        public void onSendMessage(IMMessage r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
        public void onUpdateMessage(IMMessage r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowMessageCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL";
        static final int TRANSACTION_onInsertMessageList = 5;
        static final int TRANSACTION_onReceiveMessage = 2;
        static final int TRANSACTION_onRegenMessage = 4;
        static final int TRANSACTION_onSendMessage = 1;
        static final int TRANSACTION_onUpdateMessage = 3;

        private static class Proxy implements IFlowMessageCallbackIDL {
            public static IFlowMessageCallbackIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
            public void onSendMessage(IMMessage r4) {
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
                Stub.getDefaultImpl().onSendMessage(r4);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
            public void onReceiveMessage(IMMessage r5) {
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
                Stub.getDefaultImpl().onReceiveMessage(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
            public void onUpdateMessage(IMMessage r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onUpdateMessage(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
            public void onRegenMessage(IMMessage r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onRegenMessage(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
            public void onInsertMessageList(List<IMMessage> r5) {
                List<IMMessage> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onInsertMessageList(r6);     // Catch: Throwable -> L12
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

        public static IFlowMessageCallbackIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowMessageCallbackIDL.class) == false) goto L13;
            return (IFlowMessageCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            IMMessage r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L38;
            r1 = (IMMessage) ZeusTransformUtils.preCheckCast(IMMessage.CREATOR.createFromParcel(r7), IMMessage.class, "com.obric.aiagent.plugin");
        L38:
            onSendMessage(r1);
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L33;
            r1 = (IMMessage) ZeusTransformUtils.preCheckCast(IMMessage.CREATOR.createFromParcel(r7), IMMessage.class, "com.obric.aiagent.plugin");
        L33:
            onReceiveMessage(r1);
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L28;
            r1 = (IMMessage) ZeusTransformUtils.preCheckCast(IMMessage.CREATOR.createFromParcel(r7), IMMessage.class, "com.obric.aiagent.plugin");
        L28:
            onUpdateMessage(r1);
            return true;
        L9:
            if (r6 != 4) goto L11;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L23;
            r1 = (IMMessage) ZeusTransformUtils.preCheckCast(IMMessage.CREATOR.createFromParcel(r7), IMMessage.class, "com.obric.aiagent.plugin");
        L23:
            onRegenMessage(r1);
            return true;
        L11:
            if (r6 != 5) goto L13;
            r7.enforceInterface(DESCRIPTOR);
            onInsertMessageList(r7.createTypedArrayList(IMMessage.CREATOR));
            return true;
        L13:
            if (r6 != 1598968902) goto L15;
            r8.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r6, r7, r8, r9);
        }

        public static boolean setDefaultImpl(IFlowMessageCallbackIDL r2) {
            IFlowMessageCallbackIDL r3 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowMessageCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onInsertMessageList(List<IMMessage> r1);

    void onReceiveMessage(IMMessage r1);

    void onRegenMessage(IMMessage r1);

    void onSendMessage(IMMessage r1);

    void onUpdateMessage(IMMessage r1);
}
