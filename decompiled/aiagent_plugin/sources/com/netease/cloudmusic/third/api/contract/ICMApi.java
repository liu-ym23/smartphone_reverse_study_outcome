package com.netease.cloudmusic.third.api.contract;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface ICMApi extends IInterface {

    public static class Default implements ICMApi {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.netease.cloudmusic.third.api.contract.ICMApi
        public Bundle execute(String r1, Bundle r2) {
            return null;
        }

        @Override // com.netease.cloudmusic.third.api.contract.ICMApi
        public void executeAsync(String r1, String r2, Bundle r3, ICMApiCallback r4) {
            ICMApiCallback r0 = (ICMApiCallback) ZeusTransformUtils.wrapperContextForParams(r4, ICMApiCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.netease.cloudmusic.third.api.contract.ICMApi
        public Bundle registerEventListener(ICMApiEventListener r2) {
            ICMApiEventListener r1 = (ICMApiEventListener) ZeusTransformUtils.wrapperContextForParams(r2, ICMApiEventListener.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.netease.cloudmusic.third.api.contract.ICMApi
        public Bundle unregisterEventListener(ICMApiEventListener r2) {
            ICMApiEventListener r1 = (ICMApiEventListener) ZeusTransformUtils.wrapperContextForParams(r2, ICMApiEventListener.class, "com.obric.aiagent.plugin");
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ICMApi {
        private static final String DESCRIPTOR = "com.netease.cloudmusic.third.api.contract.ICMApi";
        static final int TRANSACTION_execute = 2;
        static final int TRANSACTION_executeAsync = 1;
        static final int TRANSACTION_registerEventListener = 3;
        static final int TRANSACTION_unregisterEventListener = 4;

        private static class Proxy implements ICMApi {
            public static ICMApi sDefaultImpl;
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

            @Override // com.netease.cloudmusic.third.api.contract.ICMApi
            public void executeAsync(String r5, String r6, Bundle r7, ICMApiCallback r8) {
                ICMApiCallback r9 = (ICMApiCallback) ZeusTransformUtils.wrapperContextForParams(r8, ICMApiCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeString(r5);     // Catch: Throwable -> L20
                r0.writeString(r6);     // Catch: Throwable -> L20
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (r9 == null) goto L10;
                IBinder r3 = r9.asBinder();     // Catch: Throwable -> L20
            L11:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L14;
            L18:
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().executeAsync(r5, r6, r7, r9);     // Catch: Throwable -> L20
                r0.recycle();
                return;
            L10:
                r3 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.netease.cloudmusic.third.api.contract.ICMApi
            public Bundle execute(String r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r0.writeString(r5);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L8:
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
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
                Bundle r7 = Stub.getDefaultImpl().execute(r5, r6);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.netease.cloudmusic.third.api.contract.ICMApi
            public Bundle registerEventListener(ICMApiEventListener r7) {
                ICMApiEventListener r8 = (ICMApiEventListener) ZeusTransformUtils.wrapperContextForParams(r7, ICMApiEventListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                Bundle r3 = null;
                if (r8 == null) goto L6;
                IBinder r4 = r8.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L19
                if (this.mRemote.transact(3, r0, r2, 0) == false) goto L10;
            L14:
                r2.readException();     // Catch: Throwable -> L19
                if (r2.readInt() == 0) goto L17;
                r3 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r2), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            L17:
                r2.recycle();
                r0.recycle();
                return r3;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bundle r6 = Stub.getDefaultImpl().registerEventListener(r8);     // Catch: Throwable -> L19
                r2.recycle();
                r0.recycle();
                return r6;
            L6:
                r4 = null;
            L19:
                th = move-exception;
                r2.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.netease.cloudmusic.third.api.contract.ICMApi
            public Bundle unregisterEventListener(ICMApiEventListener r7) {
                ICMApiEventListener r8 = (ICMApiEventListener) ZeusTransformUtils.wrapperContextForParams(r7, ICMApiEventListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                Bundle r3 = null;
                if (r8 == null) goto L6;
                IBinder r4 = r8.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L19
                if (this.mRemote.transact(4, r0, r2, 0) == false) goto L10;
            L14:
                r2.readException();     // Catch: Throwable -> L19
                if (r2.readInt() == 0) goto L17;
                r3 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r2), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            L17:
                r2.recycle();
                r0.recycle();
                return r3;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bundle r6 = Stub.getDefaultImpl().unregisterEventListener(r8);     // Catch: Throwable -> L19
                r2.recycle();
                r0.recycle();
                return r6;
            L6:
                r4 = null;
            L19:
                th = move-exception;
                r2.recycle();
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

        public static ICMApi asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICMApi.class) == false) goto L13;
            return (ICMApi) ZeusTransformUtils.preCheckCast(r0, ICMApi.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r7, Parcel r8, Parcel r9, int r10) {
            Bundle r1 = null;
            if (r7 != 1) goto L5;
            r8.enforceInterface(DESCRIPTOR);
            String r11 = r8.readString();
            String r12 = r8.readString();
            if (r8.readInt() == 0) goto L37;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r8), Bundle.class, "com.obric.aiagent.plugin");
        L37:
            executeAsync(r11, r12, r1, ICMApiCallback.Stub.asInterface(r8.readStrongBinder()));
            return true;
        L5:
            if (r7 != 2) goto L7;
            r8.enforceInterface(DESCRIPTOR);
            String r13 = r8.readString();
            if (r8.readInt() == 0) goto L29;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r8), Bundle.class, "com.obric.aiagent.plugin");
        L29:
            Bundle r6 = execute(r13, r1);
            r9.writeNoException();
            if (r6 == null) goto L32;
            r9.writeInt(1);
            r6.writeToParcel(r9, 1);
        L33:
            return true;
        L32:
            r9.writeInt(0);
            goto L33
        L7:
            if (r7 != 3) goto L9;
            r8.enforceInterface(DESCRIPTOR);
            Bundle r14 = registerEventListener(ICMApiEventListener.Stub.asInterface(r8.readStrongBinder()));
            r9.writeNoException();
            if (r14 == null) goto L24;
            r9.writeInt(1);
            r14.writeToParcel(r9, 1);
        L25:
            return true;
        L24:
            r9.writeInt(0);
            goto L25
        L9:
            if (r7 != 4) goto L11;
            r8.enforceInterface(DESCRIPTOR);
            Bundle r15 = unregisterEventListener(ICMApiEventListener.Stub.asInterface(r8.readStrongBinder()));
            r9.writeNoException();
            if (r15 == null) goto L19;
            r9.writeInt(1);
            r15.writeToParcel(r9, 1);
        L20:
            return true;
        L19:
            r9.writeInt(0);
            goto L20
        L11:
            if (r7 != 1598968902) goto L13;
            r9.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r7, r8, r9, r10);
        }

        public static boolean setDefaultImpl(ICMApi r2) {
            ICMApi r3 = (ICMApi) ZeusTransformUtils.wrapperContextForParams(r2, ICMApi.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static ICMApi getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    Bundle execute(String r1, Bundle r2);

    void executeAsync(String r1, String r2, Bundle r3, ICMApiCallback r4);

    Bundle registerEventListener(ICMApiEventListener r1);

    Bundle unregisterEventListener(ICMApiEventListener r1);
}
