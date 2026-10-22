package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IAgentDMStateListenerIDL extends IInterface {

    public static class Default implements IAgentDMStateListenerIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
        public void onDMStateChanged(DMStateInfo r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
        public void onTaskAdded(DMTaskInfo r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
        public void onTaskEnd(DMTaskInfo r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
        public void onTaskStateChanged(DMTaskInfo r1, DMTaskState r2, DMTaskState r3) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAgentDMStateListenerIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL";
        static final int TRANSACTION_onDMStateChanged = 1;
        static final int TRANSACTION_onTaskAdded = 2;
        static final int TRANSACTION_onTaskEnd = 3;
        static final int TRANSACTION_onTaskStateChanged = 4;

        private static class Proxy implements IAgentDMStateListenerIDL {
            public static IAgentDMStateListenerIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
            public void onDMStateChanged(DMStateInfo r4) {
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
                Stub.getDefaultImpl().onDMStateChanged(r4);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
            public void onTaskAdded(DMTaskInfo r5) {
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
                Stub.getDefaultImpl().onTaskAdded(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
            public void onTaskEnd(DMTaskInfo r5) {
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
                Stub.getDefaultImpl().onTaskEnd(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
            public void onTaskStateChanged(DMTaskInfo r5, DMTaskState r6, DMTaskState r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L22
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L22
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L22
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L22
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L22
            L10:
                if (r7 == null) goto L12;
                r0.writeInt(1);     // Catch: Throwable -> L22
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L22
            L14:
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L16;
            L20:
                r0.recycle();
                return;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                Stub.getDefaultImpl().onTaskStateChanged(r5, r6, r7);     // Catch: Throwable -> L22
                r0.recycle();
                return;
            L12:
                r0.writeInt(0);     // Catch: Throwable -> L22
                goto L14
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L22
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L22
            L22:
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

        public static IAgentDMStateListenerIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAgentDMStateListenerIDL.class) == false) goto L13;
            return (IAgentDMStateListenerIDL) ZeusTransformUtils.preCheckCast(r0, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            DMStateInfo r1 = null;
            DMTaskState r2 = null;
            DMTaskInfo r3 = null;
            DMTaskInfo r4 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L42;
            r1 = (DMStateInfo) ZeusTransformUtils.preCheckCast(DMStateInfo.CREATOR.createFromParcel(r7), DMStateInfo.class, "com.obric.aiagent.plugin");
        L42:
            onDMStateChanged(r1);
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L37;
            r4 = (DMTaskInfo) ZeusTransformUtils.preCheckCast(DMTaskInfo.CREATOR.createFromParcel(r7), DMTaskInfo.class, "com.obric.aiagent.plugin");
        L37:
            onTaskAdded(r4);
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L32;
            r3 = (DMTaskInfo) ZeusTransformUtils.preCheckCast(DMTaskInfo.CREATOR.createFromParcel(r7), DMTaskInfo.class, "com.obric.aiagent.plugin");
        L32:
            onTaskEnd(r3);
            return true;
        L9:
            if (r6 != 4) goto L11;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L19;
            DMTaskInfo r10 = (DMTaskInfo) ZeusTransformUtils.preCheckCast(DMTaskInfo.CREATOR.createFromParcel(r7), DMTaskInfo.class, "com.obric.aiagent.plugin");
        L21:
            if (r7.readInt() == 0) goto L23;
            DMTaskState r11 = (DMTaskState) ZeusTransformUtils.preCheckCast(DMTaskState.CREATOR.createFromParcel(r7), DMTaskState.class, "com.obric.aiagent.plugin");
        L25:
            if (r7.readInt() == 0) goto L27;
            r2 = (DMTaskState) ZeusTransformUtils.preCheckCast(DMTaskState.CREATOR.createFromParcel(r7), DMTaskState.class, "com.obric.aiagent.plugin");
        L27:
            onTaskStateChanged(r10, r11, r2);
            return true;
        L23:
            r11 = null;
            goto L25
        L19:
            r10 = null;
            goto L21
        L11:
            if (r6 != 1598968902) goto L13;
            r8.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r6, r7, r8, r9);
        }

        public static boolean setDefaultImpl(IAgentDMStateListenerIDL r2) {
            IAgentDMStateListenerIDL r3 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAgentDMStateListenerIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onDMStateChanged(DMStateInfo r1);

    void onTaskAdded(DMTaskInfo r1);

    void onTaskEnd(DMTaskInfo r1);

    void onTaskStateChanged(DMTaskInfo r1, DMTaskState r2, DMTaskState r3);
}
