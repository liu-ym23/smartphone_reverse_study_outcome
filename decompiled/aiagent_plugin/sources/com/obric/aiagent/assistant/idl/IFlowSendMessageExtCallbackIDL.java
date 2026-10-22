package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowSendMessageExtCallbackIDL extends IInterface {

    public static class Default implements IFlowSendMessageExtCallbackIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
        public Map getExt(Map r1, String r2) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
        public String getScene() {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowSendMessageExtCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL";
        static final int TRANSACTION_getExt = 2;
        static final int TRANSACTION_getScene = 1;

        private static class Proxy implements IFlowSendMessageExtCallbackIDL {
            public static IFlowSendMessageExtCallbackIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
            public String getScene() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getScene();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
            public Map getExt(Map r6, String r7) {
                Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeMap(r8);     // Catch: Throwable -> L13
                r0.writeString(r7);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                HashMap r5 = r1.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map r9 = Stub.getDefaultImpl().getExt(r8, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
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

        public static IFlowSendMessageExtCallbackIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowSendMessageExtCallbackIDL.class) == false) goto L13;
            return (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            String r3 = getScene();
            r6.writeNoException();
            r6.writeString(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            Map r8 = getExt(r5.readHashMap(getClass().getClassLoader()), r5.readString());
            r6.writeNoException();
            r6.writeMap(r8);
            return true;
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IFlowSendMessageExtCallbackIDL r2) {
            IFlowSendMessageExtCallbackIDL r3 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowSendMessageExtCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    Map getExt(Map r1, String r2);

    String getScene();
}
