package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IAssistantTtsStateListener extends IInterface {

    public static class Default implements IAssistantTtsStateListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener
        public void onAssistantTtsStateChanged(int r1) {
        }
    }

    public static abstract class Stub extends Binder implements IAssistantTtsStateListener {
        private static final String DESCRIPTOR = "com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener";
        public static final int TRANSACTION_onAssistantTtsStateChanged = 1;

        public static class Proxy implements IAssistantTtsStateListener {
            public static IAssistantTtsStateListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener
            public void onAssistantTtsStateChanged(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAssistantTtsStateChanged(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAssistantTtsStateListener asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IAssistantTtsStateListener.class) == false) goto L13;
            return (IAssistantTtsStateListener) ZeusTransformUtils.preCheckCast(r0, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static IAssistantTtsStateListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAssistantTtsStateListener r2) {
            IAssistantTtsStateListener r3 = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onAssistantTtsStateChanged(r5.readInt());
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onAssistantTtsStateChanged(int r1);
}
