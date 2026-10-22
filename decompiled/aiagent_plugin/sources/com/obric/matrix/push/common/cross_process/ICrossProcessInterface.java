package com.obric.matrix.push.common.cross_process;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ICrossProcessInterface extends IInterface {

    public static class Default implements ICrossProcessInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.push.common.cross_process.ICrossProcessInterface
        public void invoke(String r1, String r2, List r3, ICrossProcessCallbackInterface r4) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            ICrossProcessCallbackInterface r5 = (ICrossProcessCallbackInterface) ZeusTransformUtils.wrapperContextForParams(r4, ICrossProcessCallbackInterface.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ICrossProcessInterface {
        private static final String DESCRIPTOR = "com.obric.matrix.push.common.cross_process.ICrossProcessInterface";
        static final int TRANSACTION_invoke = 1;

        private static class Proxy implements ICrossProcessInterface {
            public static ICrossProcessInterface sDefaultImpl;
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

            @Override // com.obric.matrix.push.common.cross_process.ICrossProcessInterface
            public void invoke(String r5, String r6, List r7, ICrossProcessCallbackInterface r8) {
                List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
                ICrossProcessCallbackInterface r10 = (ICrossProcessCallbackInterface) ZeusTransformUtils.wrapperContextForParams(r8, ICrossProcessCallbackInterface.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeList(r9);     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                IBinder r2 = r10.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().invoke(r5, r6, r9, r10);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
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

        public static ICrossProcessInterface asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICrossProcessInterface.class) == false) goto L13;
            return (ICrossProcessInterface) ZeusTransformUtils.preCheckCast(r0, ICrossProcessInterface.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            invoke(r5.readString(), r5.readString(), r5.readArrayList(getClass().getClassLoader()), ICrossProcessCallbackInterface.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(ICrossProcessInterface r2) {
            ICrossProcessInterface r3 = (ICrossProcessInterface) ZeusTransformUtils.wrapperContextForParams(r2, ICrossProcessInterface.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static ICrossProcessInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void invoke(String r1, String r2, List r3, ICrossProcessCallbackInterface r4);
}
