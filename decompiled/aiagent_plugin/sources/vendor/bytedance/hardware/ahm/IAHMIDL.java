package vendor.bytedance.hardware.ahm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public interface IAHMIDL extends IInterface {

    public static class Default implements IAHMIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // vendor.bytedance.hardware.ahm.IAHMIDL
        public long ipc_ahm_close() {
            return 0;
        }

        @Override // vendor.bytedance.hardware.ahm.IAHMIDL
        public long ipc_ahm_open(IAHMCallbackIDL r2) {
            IAHMCallbackIDL r1 = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
            return 0;
        }

        @Override // vendor.bytedance.hardware.ahm.IAHMIDL
        public long ipc_ahm_open_v2(IAHMCallbackIDL r1, int r2) {
            IAHMCallbackIDL r0 = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r1, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
            return 0;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAHMIDL {
        private static final String DESCRIPTOR = "vendor.bytedance.hardware.ahm.IAHMIDL";
        static final int TRANSACTION_ipc_ahm_close = 2;
        static final int TRANSACTION_ipc_ahm_open = 1;
        static final int TRANSACTION_ipc_ahm_open_v2 = 3;

        private static class Proxy implements IAHMIDL {
            public static IAHMIDL sDefaultImpl;
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

            @Override // vendor.bytedance.hardware.ahm.IAHMIDL
            public long ipc_ahm_open(IAHMCallbackIDL r5) {
                IAHMCallbackIDL r6 = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                long r4 = r1.readLong();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                long r7 = Stub.getDefaultImpl().ipc_ahm_open(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.ahm.IAHMIDL
            public long ipc_ahm_close() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                long r2 = r1.readLong();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r3 = Stub.getDefaultImpl().ipc_ahm_close();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.ahm.IAHMIDL
            public long ipc_ahm_open_v2(IAHMCallbackIDL r5, int r6) {
                IAHMCallbackIDL r7 = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                long r4 = r1.readLong();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                long r8 = Stub.getDefaultImpl().ipc_ahm_open_v2(r7, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r2 = null;
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

        public static IAHMIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAHMIDL.class) == false) goto L13;
            return (IAHMIDL) ZeusTransformUtils.preCheckCast(r0, IAHMIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            long r3 = ipc_ahm_open(IAHMCallbackIDL.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeLong(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            long r8 = ipc_ahm_close();
            r6.writeNoException();
            r6.writeLong(r8);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            long r9 = ipc_ahm_open_v2(IAHMCallbackIDL.Stub.asInterface(r5.readStrongBinder()), r5.readInt());
            r6.writeNoException();
            r6.writeLong(r9);
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IAHMIDL r2) {
            IAHMIDL r3 = (IAHMIDL) ZeusTransformUtils.wrapperContextForParams(r2, IAHMIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IAHMIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    long ipc_ahm_close();

    long ipc_ahm_open(IAHMCallbackIDL r1);

    long ipc_ahm_open_v2(IAHMCallbackIDL r1, int r2);
}
