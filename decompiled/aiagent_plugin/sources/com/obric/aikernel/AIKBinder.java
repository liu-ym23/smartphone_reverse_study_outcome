package com.obric.aikernel;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface AIKBinder extends IInterface {

    public static class Default implements AIKBinder {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aikernel.AIKBinder
        public void autoTest(Bundle r1, AIKListener r2) {
            AIKListener r0 = (AIKListener) ZeusTransformUtils.wrapperContextForParams(r2, AIKListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aikernel.AIKBinder
        public void callModel(Bundle r1, AIKListener r2) {
            AIKListener r0 = (AIKListener) ZeusTransformUtils.wrapperContextForParams(r2, AIKListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aikernel.AIKBinder
        public Bundle callModelSync(Bundle r1) {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements AIKBinder {
        private static final String DESCRIPTOR = "com.obric.aikernel.AIKBinder";
        static final int TRANSACTION_autoTest = 3;
        static final int TRANSACTION_callModel = 2;
        static final int TRANSACTION_callModelSync = 1;

        private static class Proxy implements AIKBinder {
            public static AIKBinder sDefaultImpl;
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

            @Override // com.obric.aikernel.AIKBinder
            public Bundle callModelSync(Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L8:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r1), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bundle r6 = Stub.getDefaultImpl().callModelSync(r5);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aikernel.AIKBinder
            public void callModel(Bundle r5, AIKListener r6) {
                AIKListener r7 = (AIKListener) ZeusTransformUtils.wrapperContextForParams(r6, AIKListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == null) goto L9;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L20
            L10:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().callModel(r5, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r3 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aikernel.AIKBinder
            public void autoTest(Bundle r5, AIKListener r6) {
                AIKListener r7 = (AIKListener) ZeusTransformUtils.wrapperContextForParams(r6, AIKListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == null) goto L9;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L20
            L10:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().autoTest(r5, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r3 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
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

        public static AIKBinder asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, AIKBinder.class) == false) goto L13;
            return (AIKBinder) ZeusTransformUtils.preCheckCast(r0, AIKBinder.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            Bundle r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L27;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L27:
            Bundle r5 = callModelSync(r1);
            r8.writeNoException();
            if (r5 == null) goto L30;
            r8.writeInt(1);
            r5.writeToParcel(r8, 1);
        L31:
            return true;
        L30:
            r8.writeInt(0);
            goto L31
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L22;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L22:
            callModel(r1, AIKListener.Stub.asInterface(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L17;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L17:
            autoTest(r1, AIKListener.Stub.asInterface(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L9:
            if (r6 != 1598968902) goto L11;
            r8.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r6, r7, r8, r9);
        }

        public static boolean setDefaultImpl(AIKBinder r2) {
            AIKBinder r3 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r2, AIKBinder.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static AIKBinder getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void autoTest(Bundle r1, AIKListener r2);

    void callModel(Bundle r1, AIKListener r2);

    Bundle callModelSync(Bundle r1);
}
