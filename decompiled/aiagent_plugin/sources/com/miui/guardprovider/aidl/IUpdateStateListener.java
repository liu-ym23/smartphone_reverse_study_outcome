package com.miui.guardprovider.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IUpdateStateListener extends IInterface {
    public static final String DESCRIPTOR = "com.miui.guardprovider.aidl.IUpdateStateListener";

    public static class Default implements IUpdateStateListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.guardprovider.aidl.IUpdateStateListener
        public void onUpdateFinished(int r1) {
        }

        @Override // com.miui.guardprovider.aidl.IUpdateStateListener
        public void onUpdateProgress(int r1, int r2) {
        }

        @Override // com.miui.guardprovider.aidl.IUpdateStateListener
        public void onUpdateStart() {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IUpdateStateListener {
        static final int TRANSACTION_onUpdateFinished = 3;
        static final int TRANSACTION_onUpdateProgress = 2;
        static final int TRANSACTION_onUpdateStart = 1;

        private static class Proxy implements IUpdateStateListener {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IUpdateStateListener.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.miui.guardprovider.aidl.IUpdateStateListener
            public void onUpdateStart() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IUpdateStateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.miui.guardprovider.aidl.IUpdateStateListener
            public void onUpdateProgress(int r3, int r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IUpdateStateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.miui.guardprovider.aidl.IUpdateStateListener
            public void onUpdateFinished(int r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IUpdateStateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
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
            attachInterface(this, IUpdateStateListener.DESCRIPTOR);
        }

        public static IUpdateStateListener asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(IUpdateStateListener.DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IUpdateStateListener.class) == false) goto L13;
            return (IUpdateStateListener) ZeusTransformUtils.preCheckCast(r0, IUpdateStateListener.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IUpdateStateListener.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IUpdateStateListener.DESCRIPTOR);
            return true;
        L11:
            if (r4 != 1) goto L13;
            onUpdateStart();
        L21:
            return true;
        L13:
            if (r4 != 2) goto L15;
            onUpdateProgress(r5.readInt(), r5.readInt());
            goto L21
        L15:
            if (r4 != 3) goto L17;
            onUpdateFinished(r5.readInt());
            goto L21
        L17:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onUpdateFinished(int r1);

    void onUpdateProgress(int r1, int r2);

    void onUpdateStart();
}
