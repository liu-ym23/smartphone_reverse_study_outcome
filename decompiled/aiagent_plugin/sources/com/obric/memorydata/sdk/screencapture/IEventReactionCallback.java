package com.obric.memorydata.sdk.screencapture;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IEventReactionCallback extends IInterface {

    public static class Default implements IEventReactionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
        public void onError(int r1, String r2) {
        }

        @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
        public void onEvent(ScreenEvent r1, ScreenData r2) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IEventReactionCallback {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.screencapture.IEventReactionCallback";
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onEvent = 1;

        private static class Proxy implements IEventReactionCallback {
            public static IEventReactionCallback sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
            public void onEvent(ScreenEvent r5, ScreenData r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L11:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onEvent(r5, r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.screencapture.IEventReactionCallback
            public void onError(int r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onError(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
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

        public static IEventReactionCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IEventReactionCallback.class) == false) goto L13;
            return (IEventReactionCallback) ZeusTransformUtils.preCheckCast(r0, IEventReactionCallback.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            ScreenData r8 = null;
            if (r5.readInt() == 0) goto L17;
            ScreenEvent r9 = ScreenEvent.CREATOR.createFromParcel(r5);
        L19:
            if (r5.readInt() == 0) goto L21;
            r8 = (ScreenData) ZeusTransformUtils.preCheckCast(ScreenData.CREATOR.createFromParcel(r5), ScreenData.class, "com.obric.aiagent.plugin");
        L21:
            onEvent(r9, r8);
            r6.writeNoException();
            return true;
        L17:
            r9 = null;
            goto L19
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onError(r5.readInt(), r5.readString());
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IEventReactionCallback r2) {
            IEventReactionCallback r3 = (IEventReactionCallback) ZeusTransformUtils.wrapperContextForParams(r2, IEventReactionCallback.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IEventReactionCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onError(int r1, String r2);

    void onEvent(ScreenEvent r1, ScreenData r2);
}
