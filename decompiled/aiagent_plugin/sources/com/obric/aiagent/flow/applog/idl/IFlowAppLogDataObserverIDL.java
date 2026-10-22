package com.obric.aiagent.flow.applog.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowAppLogDataObserverIDL extends IInterface {

    public static class Default implements IFlowAppLogDataObserverIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
        public void onIdLoaded(String r1, String r2, String r3) {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
        public void onRemoteIdGet(boolean r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowAppLogDataObserverIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL";
        static final int TRANSACTION_onIdLoaded = 1;
        static final int TRANSACTION_onRemoteIdGet = 2;

        private static class Proxy implements IFlowAppLogDataObserverIDL {
            public static IFlowAppLogDataObserverIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
            public void onIdLoaded(String r4, String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r4);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onIdLoaded(r4, r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
            public void onRemoteIdGet(boolean r12, String r13, String r14, String r15, String r16, String r17, String r18) {
                Parcel r1 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r12 == false) goto L6;
                int r2 = 1;
            L7:
                r1.writeInt(r2);     // Catch: Throwable -> L16
                r1.writeString(r13);     // Catch: Throwable -> L16
                r1.writeString(r14);     // Catch: Throwable -> L16
                r1.writeString(r15);     // Catch: Throwable -> L16
                r1.writeString(r16);     // Catch: Throwable -> L16
                r1.writeString(r17);     // Catch: Throwable -> L16
                r1.writeString(r18);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r1, null, 1) == false) goto L10;
            L14:
                r1.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onRemoteIdGet(r12, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L16
                r1.recycle();
                return;
            L6:
                r2 = 0;
            L16:
                th = move-exception;
                r1.recycle();
                throw th;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowAppLogDataObserverIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowAppLogDataObserverIDL.class) == false) goto L13;
            return (IFlowAppLogDataObserverIDL) ZeusTransformUtils.preCheckCast(r0, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface(DESCRIPTOR);
            onIdLoaded(r11.readString(), r11.readString(), r11.readString());
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L15;
            boolean r2 = true;
        L16:
            onRemoteIdGet(r2, r11.readString(), r11.readString(), r11.readString(), r11.readString(), r11.readString(), r11.readString());
            return true;
        L15:
            r2 = false;
            goto L16
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }

        public static boolean setDefaultImpl(IFlowAppLogDataObserverIDL r2) {
            IFlowAppLogDataObserverIDL r3 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowAppLogDataObserverIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onIdLoaded(String r1, String r2, String r3);

    void onRemoteIdGet(boolean r1, String r2, String r3, String r4, String r5, String r6, String r7);
}
