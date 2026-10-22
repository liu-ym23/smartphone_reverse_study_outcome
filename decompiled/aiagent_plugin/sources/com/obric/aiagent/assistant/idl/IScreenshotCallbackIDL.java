package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IScreenshotCallbackIDL extends IInterface {

    public static class Default implements IScreenshotCallbackIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
        public void onError(String r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
        public void onReceivedScreenshot(Bitmap r1) {
        }

        @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
        public void onReceivedScreenshotUri(Uri r1) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IScreenshotCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL";
        static final int TRANSACTION_onError = 3;
        static final int TRANSACTION_onReceivedScreenshot = 1;
        static final int TRANSACTION_onReceivedScreenshotUri = 2;

        private static class Proxy implements IScreenshotCallbackIDL {
            public static IScreenshotCallbackIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
            public void onReceivedScreenshot(Bitmap r4) {
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
                Stub.getDefaultImpl().onReceivedScreenshot(r4);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
            public void onReceivedScreenshotUri(Uri r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onReceivedScreenshotUri(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
            public void onError(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onError(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
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

        public static IScreenshotCallbackIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IScreenshotCallbackIDL.class) == false) goto L13;
            return (IScreenshotCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            Bitmap r1 = null;
            Uri r2 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L24;
            r1 = (Bitmap) ZeusTransformUtils.preCheckCast(Bitmap.CREATOR.createFromParcel(r7), Bitmap.class, "com.obric.aiagent.plugin");
        L24:
            onReceivedScreenshot(r1);
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L19;
            r2 = (Uri) ZeusTransformUtils.preCheckCast(Uri.CREATOR.createFromParcel(r7), Uri.class, "com.obric.aiagent.plugin");
        L19:
            onReceivedScreenshotUri(r2);
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface(DESCRIPTOR);
            onError(r7.readString());
            return true;
        L9:
            if (r6 != 1598968902) goto L11;
            r8.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r6, r7, r8, r9);
        }

        public static boolean setDefaultImpl(IScreenshotCallbackIDL r2) {
            IScreenshotCallbackIDL r3 = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IScreenshotCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onError(String r1);

    void onReceivedScreenshot(Bitmap r1);

    void onReceivedScreenshotUri(Uri r1);
}
