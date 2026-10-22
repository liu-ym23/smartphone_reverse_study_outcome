package android.view;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IFloatingTransitionStateProvider extends IInterface {

    public static class Default implements IFloatingTransitionStateProvider {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.view.IFloatingTransitionStateProvider
        public Bundle captureFloatingTransitionState() {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFloatingTransitionStateProvider {
        private static final String DESCRIPTOR = "android.view.IFloatingTransitionStateProvider";
        static final int TRANSACTION_captureFloatingTransitionState = 1;

        private static class Proxy implements IFloatingTransitionStateProvider {
            public static IFloatingTransitionStateProvider sDefaultImpl;
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

            @Override // android.view.IFloatingTransitionStateProvider
            public Bundle captureFloatingTransitionState() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
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
                Bundle r5 = Stub.getDefaultImpl().captureFloatingTransitionState();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
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

        public static IFloatingTransitionStateProvider asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFloatingTransitionStateProvider.class) == false) goto L13;
            return (IFloatingTransitionStateProvider) ZeusTransformUtils.preCheckCast(r0, IFloatingTransitionStateProvider.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            Bundle r3 = captureFloatingTransitionState();
            r6.writeNoException();
            if (r3 == null) goto L13;
            r6.writeInt(1);
            r3.writeToParcel(r6, 1);
        L14:
            return true;
        L13:
            r6.writeInt(0);
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IFloatingTransitionStateProvider r2) {
            IFloatingTransitionStateProvider r3 = (IFloatingTransitionStateProvider) ZeusTransformUtils.wrapperContextForParams(r2, IFloatingTransitionStateProvider.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IFloatingTransitionStateProvider getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    Bundle captureFloatingTransitionState();
}
