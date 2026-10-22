package android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IScreenShotTickCallback extends IInterface {

    public static class Default implements IScreenShotTickCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.IScreenShotTickCallback
        public void onScreenShotReady(int r1, String r2, int r3, String r4) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IScreenShotTickCallback {
        private static final String DESCRIPTOR = "android.app.IScreenShotTickCallback";
        static final int TRANSACTION_onScreenShotReady = 1;

        private static class Proxy implements IScreenShotTickCallback {
            public static IScreenShotTickCallback sDefaultImpl;
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

            @Override // android.app.IScreenShotTickCallback
            public void onScreenShotReady(int r4, String r5, int r6, String r7) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r4);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeString(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onScreenShotReady(r4, r5, r6, r7);     // Catch: Throwable -> L12
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

        public static IScreenShotTickCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IScreenShotTickCallback.class) == false) goto L13;
            return (IScreenShotTickCallback) ZeusTransformUtils.preCheckCast(r0, IScreenShotTickCallback.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onScreenShotReady(r5.readInt(), r5.readString(), r5.readInt(), r5.readString());
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IScreenShotTickCallback r2) {
            IScreenShotTickCallback r3 = (IScreenShotTickCallback) ZeusTransformUtils.wrapperContextForParams(r2, IScreenShotTickCallback.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IScreenShotTickCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onScreenShotReady(int r1, String r2, int r3, String r4);
}
