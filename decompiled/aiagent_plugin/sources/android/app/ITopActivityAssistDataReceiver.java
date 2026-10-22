package android.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface ITopActivityAssistDataReceiver extends IInterface {

    public static class Default implements ITopActivityAssistDataReceiver {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.ITopActivityAssistDataReceiver
        public void onResultData(int r1, Bundle r2) {
        }

        @Override // android.app.ITopActivityAssistDataReceiver
        public void onScreenshotData(int r1, Bundle r2) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ITopActivityAssistDataReceiver {
        private static final String DESCRIPTOR = "android.app.ITopActivityAssistDataReceiver";
        static final int TRANSACTION_onResultData = 1;
        static final int TRANSACTION_onScreenshotData = 2;

        private static class Proxy implements ITopActivityAssistDataReceiver {
            public static ITopActivityAssistDataReceiver sDefaultImpl;
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

            @Override // android.app.ITopActivityAssistDataReceiver
            public void onResultData(int r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r4);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onResultData(r4, r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.app.ITopActivityAssistDataReceiver
            public void onScreenshotData(int r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r5);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onScreenshotData(r5, r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
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

        public static ITopActivityAssistDataReceiver asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ITopActivityAssistDataReceiver.class) == false) goto L13;
            return (ITopActivityAssistDataReceiver) ZeusTransformUtils.preCheckCast(r0, ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            Bundle r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            int r10 = r7.readInt();
            if (r7.readInt() == 0) goto L20;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L20:
            onResultData(r10, r1);
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            int r11 = r7.readInt();
            if (r7.readInt() == 0) goto L15;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L15:
            onScreenshotData(r11, r1);
            return true;
        L7:
            if (r6 != 1598968902) goto L9;
            r8.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r6, r7, r8, r9);
        }

        public static boolean setDefaultImpl(ITopActivityAssistDataReceiver r2) {
            ITopActivityAssistDataReceiver r3 = (ITopActivityAssistDataReceiver) ZeusTransformUtils.wrapperContextForParams(r2, ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static ITopActivityAssistDataReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onResultData(int r1, Bundle r2);

    void onScreenshotData(int r1, Bundle r2);
}
