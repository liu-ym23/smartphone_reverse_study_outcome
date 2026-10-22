package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IDowngradeAuthForDoraCallbackIDL extends IInterface {

    public static class Default implements IDowngradeAuthForDoraCallbackIDL {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
        public void onDowngradeToNoneAuth() {
        }

        @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
        public void onDowngradeToVoicePrint() {
        }

        @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
        public void onNotDowngrade() {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IDowngradeAuthForDoraCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL";
        static final int TRANSACTION_onDowngradeToNoneAuth = 2;
        static final int TRANSACTION_onDowngradeToVoicePrint = 3;
        static final int TRANSACTION_onNotDowngrade = 1;

        private static class Proxy implements IDowngradeAuthForDoraCallbackIDL {
            public static IDowngradeAuthForDoraCallbackIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
            public void onNotDowngrade() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onNotDowngrade();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
            public void onDowngradeToNoneAuth() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onDowngradeToNoneAuth();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
            public void onDowngradeToVoicePrint() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onDowngradeToVoicePrint();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
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

        public static IDowngradeAuthForDoraCallbackIDL asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IDowngradeAuthForDoraCallbackIDL.class) == false) goto L13;
            return (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onNotDowngrade();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onDowngradeToNoneAuth();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            onDowngradeToVoicePrint();
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IDowngradeAuthForDoraCallbackIDL r2) {
            IDowngradeAuthForDoraCallbackIDL r3 = (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IDowngradeAuthForDoraCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onDowngradeToNoneAuth();

    void onDowngradeToVoicePrint();

    void onNotDowngrade();
}
