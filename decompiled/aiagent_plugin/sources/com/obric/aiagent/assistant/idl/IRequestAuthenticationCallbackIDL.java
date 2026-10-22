package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IRequestAuthenticationCallbackIDL extends IInterface {

    public static class Default implements IRequestAuthenticationCallbackIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
        public void onAuthenticationCancelled() {
        }

        @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
        public void onAuthenticationFailed() {
        }

        @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
        public void onAuthenticationNotAvailable() {
        }

        @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
        public void onAuthenticationPass() {
        }

        @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
        public void onAuthenticationTimeout() {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IRequestAuthenticationCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL";
        static final int TRANSACTION_onAuthenticationCancelled = 5;
        static final int TRANSACTION_onAuthenticationFailed = 3;
        static final int TRANSACTION_onAuthenticationNotAvailable = 4;
        static final int TRANSACTION_onAuthenticationPass = 1;
        static final int TRANSACTION_onAuthenticationTimeout = 2;

        private static class Proxy implements IRequestAuthenticationCallbackIDL {
            public static IRequestAuthenticationCallbackIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
            public void onAuthenticationPass() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAuthenticationPass();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
            public void onAuthenticationTimeout() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAuthenticationTimeout();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
            public void onAuthenticationFailed() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAuthenticationFailed();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
            public void onAuthenticationNotAvailable() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAuthenticationNotAvailable();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
            public void onAuthenticationCancelled() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAuthenticationCancelled();     // Catch: Throwable -> L12
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

        public static IRequestAuthenticationCallbackIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IRequestAuthenticationCallbackIDL.class) == false) goto L13;
            return (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onAuthenticationPass();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onAuthenticationTimeout();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            onAuthenticationFailed();
            return true;
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface(DESCRIPTOR);
            onAuthenticationNotAvailable();
            return true;
        L11:
            if (r4 != 5) goto L13;
            r5.enforceInterface(DESCRIPTOR);
            onAuthenticationCancelled();
            return true;
        L13:
            if (r4 != 1598968902) goto L15;
            r6.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IRequestAuthenticationCallbackIDL r2) {
            IRequestAuthenticationCallbackIDL r3 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IRequestAuthenticationCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onAuthenticationCancelled();

    void onAuthenticationFailed();

    void onAuthenticationNotAvailable();

    void onAuthenticationPass();

    void onAuthenticationTimeout();
}
