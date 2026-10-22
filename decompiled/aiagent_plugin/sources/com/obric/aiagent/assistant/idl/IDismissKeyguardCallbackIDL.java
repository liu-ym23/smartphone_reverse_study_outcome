package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IDismissKeyguardCallbackIDL extends IInterface {

    public static class Default implements IDismissKeyguardCallbackIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IDismissKeyguardCallbackIDL
        public void onResult(boolean r1, boolean r2) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IDismissKeyguardCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IDismissKeyguardCallbackIDL";
        static final int TRANSACTION_onResult = 1;

        private static class Proxy implements IDismissKeyguardCallbackIDL {
            public static IDismissKeyguardCallbackIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IDismissKeyguardCallbackIDL
            public void onResult(boolean r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                int r1 = 0;
                if (r5 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L19
                if (r6 == false) goto L10;
                r1 = 1;
            L10:
                r0.writeInt(r1);     // Catch: Throwable -> L19
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L13;
            L17:
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onResult(r5, r6);     // Catch: Throwable -> L19
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L19:
                th = move-exception;
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

        public static IDismissKeyguardCallbackIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IDismissKeyguardCallbackIDL.class) == false) goto L13;
            return (IDismissKeyguardCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IDismissKeyguardCallbackIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = false;
            if (r5.readInt() == 0) goto L13;
            boolean r9 = true;
        L15:
            if (r5.readInt() == 0) goto L17;
            r8 = true;
        L17:
            onResult(r9, r8);
            return true;
        L13:
            r9 = false;
            goto L15
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IDismissKeyguardCallbackIDL r2) {
            IDismissKeyguardCallbackIDL r3 = (IDismissKeyguardCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IDismissKeyguardCallbackIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IDismissKeyguardCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onResult(boolean r1, boolean r2);
}
