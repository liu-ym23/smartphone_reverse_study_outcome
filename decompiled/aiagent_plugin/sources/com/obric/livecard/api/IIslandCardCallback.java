package com.obric.livecard.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IIslandCardCallback extends IInterface {

    public static class Default implements IIslandCardCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.livecard.api.IIslandCardCallback
        public Bundle hasViewClickId(String r1) {
            return null;
        }

        @Override // com.obric.livecard.api.IIslandCardCallback
        public Bundle onCardEvent(String r1, Bundle r2) {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IIslandCardCallback {
        private static final String DESCRIPTOR = "com.obric.livecard.api.IIslandCardCallback";
        static final int TRANSACTION_hasViewClickId = 2;
        static final int TRANSACTION_onCardEvent = 1;

        private static class Proxy implements IIslandCardCallback {
            public static IIslandCardCallback sDefaultImpl;
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

            @Override // com.obric.livecard.api.IIslandCardCallback
            public Bundle onCardEvent(String r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r0.writeString(r5);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
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
                Bundle r7 = Stub.getDefaultImpl().onCardEvent(r5, r6);     // Catch: Throwable -> L21
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

            @Override // com.obric.livecard.api.IIslandCardCallback
            public Bundle hasViewClickId(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r1), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Bundle r6 = Stub.getDefaultImpl().hasViewClickId(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
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

        public static IIslandCardCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IIslandCardCallback.class) == false) goto L13;
            return (IIslandCardCallback) ZeusTransformUtils.preCheckCast(r0, IIslandCardCallback.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            String r9 = r6.readString();
            if (r6.readInt() == 0) goto L20;
            Bundle r10 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r6), Bundle.class, "com.obric.aiagent.plugin");
        L21:
            Bundle r4 = onCardEvent(r9, r10);
            r7.writeNoException();
            if (r4 == null) goto L24;
            r7.writeInt(1);
            r4.writeToParcel(r7, 1);
        L25:
            return true;
        L24:
            r7.writeInt(0);
            goto L25
        L20:
            r10 = null;
            goto L21
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            Bundle r11 = hasViewClickId(r6.readString());
            r7.writeNoException();
            if (r11 == null) goto L15;
            r7.writeInt(1);
            r11.writeToParcel(r7, 1);
        L16:
            return true;
        L15:
            r7.writeInt(0);
            goto L16
        L7:
            if (r5 != 1598968902) goto L9;
            r7.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r5, r6, r7, r8);
        }

        public static boolean setDefaultImpl(IIslandCardCallback r2) {
            IIslandCardCallback r3 = (IIslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r2, IIslandCardCallback.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IIslandCardCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    Bundle hasViewClickId(String r1);

    Bundle onCardEvent(String r1, Bundle r2);
}
