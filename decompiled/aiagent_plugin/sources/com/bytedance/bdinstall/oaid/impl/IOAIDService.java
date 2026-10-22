package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IOAIDService extends IInterface {

    public static abstract class Stub extends Binder implements IOAIDService {
        private static final String DESCRIPTOR = "com.hihonor.cloudservice.oaid.IOAIDService";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_isOAIDTrackingLimited = 3;

        private static class Proxy implements IOAIDService {
            public static IOAIDService sDefaultImpl;
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

            @Override // com.bytedance.bdinstall.oaid.impl.IOAIDService
            public void basicTypes(int r13, long r14, boolean r16, float r17, double r18, String r20) {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r1.writeInt(r13);     // Catch: Throwable -> L17
                r1.writeLong(r14);     // Catch: Throwable -> L17
                if (r16 == false) goto L6;
                int r7 = 1;
            L7:
                r1.writeInt(r7);     // Catch: Throwable -> L17
                r1.writeFloat(r17);     // Catch: Throwable -> L17
                r1.writeDouble(r18);     // Catch: Throwable -> L17
                r1.writeString(r20);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r1, r2, 0) == false) goto L10;
            L14:
                r2.readException();     // Catch: Throwable -> L17
                r2.recycle();
                r1.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().basicTypes(r13, r14, r16, r17, r18, r20);     // Catch: Throwable -> L17
                r2.recycle();
                r1.recycle();
                return;
            L6:
                r7 = 0;
            L17:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IOAIDService
            public void getOAID(IOAIDCallBack r5) {
                IOAIDCallBack r6 = (IOAIDCallBack) ZeusTransformUtils.wrapperContextForParams(r5, IOAIDCallBack.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getOAID(r6);     // Catch: Throwable -> L17
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

            @Override // com.bytedance.bdinstall.oaid.impl.IOAIDService
            public void isOAIDTrackingLimited(IOAIDCallBack r5) {
                IOAIDCallBack r6 = (IOAIDCallBack) ZeusTransformUtils.wrapperContextForParams(r5, IOAIDCallBack.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().isOAIDTrackingLimited(r6);     // Catch: Throwable -> L17
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

        public static IOAIDService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IOAIDService.class) == false) goto L13;
            return (IOAIDService) ZeusTransformUtils.preCheckCast(r0, IOAIDService.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r11, Parcel r12, Parcel r13, int r14) {
            if (r11 != 1) goto L5;
            r12.enforceInterface(DESCRIPTOR);
            int r2 = r12.readInt();
            long r3 = r12.readLong();
            if (r12.readInt() == 0) goto L21;
            boolean r5 = true;
        L22:
            basicTypes(r2, r3, r5, r12.readFloat(), r12.readDouble(), r12.readString());
            r13.writeNoException();
            return true;
        L21:
            r5 = false;
            goto L22
        L5:
            if (r11 != 2) goto L7;
            r12.enforceInterface(DESCRIPTOR);
            getOAID(IOAIDCallBack.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            return true;
        L7:
            if (r11 != 3) goto L9;
            r12.enforceInterface(DESCRIPTOR);
            isOAIDTrackingLimited(IOAIDCallBack.Stub.asInterface(r12.readStrongBinder()));
            r13.writeNoException();
            return true;
        L9:
            if (r11 != 1598968902) goto L11;
            r13.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r11, r12, r13, r14);
        }

        public static boolean setDefaultImpl(IOAIDService r2) {
            IOAIDService r3 = (IOAIDService) ZeusTransformUtils.wrapperContextForParams(r2, IOAIDService.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IOAIDService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void basicTypes(int r1, long r2, boolean r4, float r5, double r6, String r8);

    void getOAID(IOAIDCallBack r1);

    void isOAIDTrackingLimited(IOAIDCallBack r1);
}
