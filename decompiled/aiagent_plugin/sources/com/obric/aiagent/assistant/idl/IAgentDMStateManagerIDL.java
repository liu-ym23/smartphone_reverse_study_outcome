package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentDMStateManagerIDL extends IInterface {

    public static class Default implements IAgentDMStateManagerIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
        public DMStateInfo getCurrentDMSteate() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
        public void registerDMStateListener(IAgentDMStateListenerIDL r2) {
            IAgentDMStateListenerIDL r1 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
        public void unRegisterDMStateListener(IAgentDMStateListenerIDL r2) {
            IAgentDMStateListenerIDL r1 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentDMStateManagerIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL";
        static final int TRANSACTION_getCurrentDMSteate = 3;
        static final int TRANSACTION_registerDMStateListener = 1;
        static final int TRANSACTION_unRegisterDMStateListener = 2;

        private static class Proxy implements IAgentDMStateManagerIDL {
            public static IAgentDMStateManagerIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
            public void registerDMStateListener(IAgentDMStateListenerIDL r4) {
                IAgentDMStateListenerIDL r5 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r4, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerDMStateListener(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
            public void unRegisterDMStateListener(IAgentDMStateListenerIDL r5) {
                IAgentDMStateListenerIDL r6 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r5, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unRegisterDMStateListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
            public DMStateInfo getCurrentDMSteate() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                DMStateInfo r4 = (DMStateInfo) ZeusTransformUtils.preCheckCast(DMStateInfo.CREATOR.createFromParcel(r1), DMStateInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                DMStateInfo r5 = Stub.getDefaultImpl().getCurrentDMSteate();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
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

        public static IAgentDMStateManagerIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentDMStateManagerIDL.class) == false) goto L13;
            return (IAgentDMStateManagerIDL) ZeusTransformUtils.preCheckCast(r0, IAgentDMStateManagerIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            registerDMStateListener(IAgentDMStateListenerIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            unRegisterDMStateListener(IAgentDMStateListenerIDL.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            DMStateInfo r3 = getCurrentDMSteate();
            r6.writeNoException();
            if (r3 == null) goto L17;
            r6.writeInt(1);
            r3.writeToParcel(r6, 1);
        L18:
            return true;
        L17:
            r6.writeInt(0);
            goto L18
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IAgentDMStateManagerIDL r2) {
            IAgentDMStateManagerIDL r3 = (IAgentDMStateManagerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentDMStateManagerIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentDMStateManagerIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    DMStateInfo getCurrentDMSteate();

    void registerDMStateListener(IAgentDMStateListenerIDL r1);

    void unRegisterDMStateListener(IAgentDMStateListenerIDL r1);
}
