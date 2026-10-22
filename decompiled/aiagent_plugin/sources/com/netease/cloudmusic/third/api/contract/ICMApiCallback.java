package com.netease.cloudmusic.third.api.contract;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface ICMApiCallback extends IInterface {

    public static class Default implements ICMApiCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.netease.cloudmusic.third.api.contract.ICMApiCallback
        public void onReturn(Bundle r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ICMApiCallback {
        private static final String DESCRIPTOR = "com.netease.cloudmusic.third.api.contract.ICMApiCallback";
        static final int TRANSACTION_onReturn = 1;

        private static class Proxy implements ICMApiCallback {
            public static ICMApiCallback sDefaultImpl;
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

            @Override // com.netease.cloudmusic.third.api.contract.ICMApiCallback
            public void onReturn(Bundle r4) {
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
                Stub.getDefaultImpl().onReturn(r4);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
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

        public static ICMApiCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICMApiCallback.class) == false) goto L13;
            return (ICMApiCallback) ZeusTransformUtils.preCheckCast(r0, ICMApiCallback.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L13;
            Bundle r8 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r5), Bundle.class, "com.obric.aiagent.plugin");
        L14:
            onReturn(r8);
            return true;
        L13:
            r8 = null;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(ICMApiCallback r2) {
            ICMApiCallback r3 = (ICMApiCallback) ZeusTransformUtils.wrapperContextForParams(r2, ICMApiCallback.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static ICMApiCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onReturn(Bundle r1);
}
