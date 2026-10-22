package com.hihonor.cloudservice.oaid;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IOAIDCallBack extends IInterface {

    public static class Default implements IOAIDCallBack {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
        public void basicTypes(int r1, long r2, boolean r4, float r5, double r6, String r8) {
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
        public void handleResult(int r1, Bundle r2) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IOAIDCallBack {
        private static final String DESCRIPTOR = "com.hihonor.cloudservice.oaid.IOAIDCallBack";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_handleResult = 2;

        private static class Proxy implements IOAIDCallBack {
            public static IOAIDCallBack sDefaultImpl;
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

            @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
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

            @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
            public void handleResult(int r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().handleResult(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
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

        public static IOAIDCallBack asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IOAIDCallBack.class) == false) goto L13;
            return (IOAIDCallBack) ZeusTransformUtils.preCheckCast(r0, IOAIDCallBack.class, "com.obric.aiagent.plugin");
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
            int r15 = r12.readInt();
            if (r12.readInt() == 0) goto L15;
            Bundle r16 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r12), Bundle.class, "com.obric.aiagent.plugin");
        L16:
            handleResult(r15, r16);
            r13.writeNoException();
            return true;
        L15:
            r16 = null;
            goto L16
        L7:
            if (r11 != 1598968902) goto L9;
            r13.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r11, r12, r13, r14);
        }

        public static boolean setDefaultImpl(IOAIDCallBack r2) {
            IOAIDCallBack r3 = (IOAIDCallBack) ZeusTransformUtils.wrapperContextForParams(r2, IOAIDCallBack.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IOAIDCallBack getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void basicTypes(int r1, long r2, boolean r4, float r5, double r6, String r8);

    void handleResult(int r1, Bundle r2);
}
