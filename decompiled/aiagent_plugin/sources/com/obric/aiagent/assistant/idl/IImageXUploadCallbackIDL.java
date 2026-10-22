package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IImageXUploadCallbackIDL extends IInterface {

    public static class Default implements IImageXUploadCallbackIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
        public void onResult(boolean r1, String r2, String r3, String r4, String r5) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IImageXUploadCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL";
        static final int TRANSACTION_onResult = 1;

        private static class Proxy implements IImageXUploadCallbackIDL {
            public static IImageXUploadCallbackIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
            public void onResult(boolean r8, String r9, String r10, String r11, String r12) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == false) goto L6;
                int r2 = 1;
            L7:
                r0.writeInt(r2);     // Catch: Throwable -> L16
                r0.writeString(r9);     // Catch: Throwable -> L16
                r0.writeString(r10);     // Catch: Throwable -> L16
                r0.writeString(r11);     // Catch: Throwable -> L16
                r0.writeString(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onResult(r8, r9, r10, r11, r12);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = 0;
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

        public static IImageXUploadCallbackIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IImageXUploadCallbackIDL.class) == false) goto L13;
            return (IImageXUploadCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r9, Parcel r10, int r11) {
            if (r8 != 1) goto L5;
            r9.enforceInterface(DESCRIPTOR);
            if (r9.readInt() == 0) goto L13;
            boolean r2 = true;
        L14:
            onResult(r2, r9.readString(), r9.readString(), r9.readString(), r9.readString());
            return true;
        L13:
            r2 = false;
            goto L14
        L5:
            if (r8 != 1598968902) goto L7;
            r10.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r8, r9, r10, r11);
        }

        public static boolean setDefaultImpl(IImageXUploadCallbackIDL r2) {
            IImageXUploadCallbackIDL r3 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IImageXUploadCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onResult(boolean r1, String r2, String r3, String r4, String r5);
}
