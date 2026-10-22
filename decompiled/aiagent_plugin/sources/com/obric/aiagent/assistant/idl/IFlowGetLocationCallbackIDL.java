package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.aiagent.assistant.idl.bean.OLocationInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IFlowGetLocationCallbackIDL extends IInterface {

    public static class Default implements IFlowGetLocationCallbackIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowGetLocationCallbackIDL
        public void onLocationResult(boolean r1, OLocationInfo r2) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFlowGetLocationCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowGetLocationCallbackIDL";
        static final int TRANSACTION_onLocationResult = 1;

        private static class Proxy implements IFlowGetLocationCallbackIDL {
            public static IFlowGetLocationCallbackIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowGetLocationCallbackIDL
            public void onLocationResult(boolean r6, OLocationInfo r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L21
                if (r7 == null) goto L10;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L12:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().onLocationResult(r6, r7);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r0.writeInt(0);     // Catch: Throwable -> L21
                goto L12
            L6:
                r4 = 0;
            L21:
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

        public static IFlowGetLocationCallbackIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFlowGetLocationCallbackIDL.class) == false) goto L13;
            return (IFlowGetLocationCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IFlowGetLocationCallbackIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L13;
            boolean r8 = true;
        L15:
            if (r5.readInt() == 0) goto L17;
            OLocationInfo r9 = (OLocationInfo) ZeusTransformUtils.preCheckCast(OLocationInfo.CREATOR.createFromParcel(r5), OLocationInfo.class, "com.obric.aiagent.plugin");
        L18:
            onLocationResult(r8, r9);
            r6.writeNoException();
            return true;
        L17:
            r9 = null;
            goto L18
        L13:
            r8 = false;
            goto L15
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IFlowGetLocationCallbackIDL r2) {
            IFlowGetLocationCallbackIDL r3 = (IFlowGetLocationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowGetLocationCallbackIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IFlowGetLocationCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onLocationResult(boolean r1, OLocationInfo r2);
}
