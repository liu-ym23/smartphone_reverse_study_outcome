package android.view;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IFloatingTransitionCallback extends IInterface {

    public static class Default implements IFloatingTransitionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.view.IFloatingTransitionCallback
        public boolean onHideTitleBar(SurfaceControl r1, Bundle r2) {
            return false;
        }

        @Override // android.view.IFloatingTransitionCallback
        public void onTransitionCancelled() {
        }

        @Override // android.view.IFloatingTransitionCallback
        public void onTransitionFinished() {
        }

        @Override // android.view.IFloatingTransitionCallback
        public boolean onTransitionStart(SurfaceControl r1, SurfaceControl r2, Bundle r3) {
            return false;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IFloatingTransitionCallback {
        private static final String DESCRIPTOR = "android.view.IFloatingTransitionCallback";
        static final int TRANSACTION_onHideTitleBar = 2;
        static final int TRANSACTION_onTransitionCancelled = 3;
        static final int TRANSACTION_onTransitionFinished = 4;
        static final int TRANSACTION_onTransitionStart = 1;

        private static class Proxy implements IFloatingTransitionCallback {
            public static IFloatingTransitionCallback sDefaultImpl;
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

            @Override // android.view.IFloatingTransitionCallback
            public boolean onTransitionStart(SurfaceControl r5, SurfaceControl r6, Bundle r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L26
                boolean r2 = true;
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L26
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L26
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L26
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L26
            L10:
                if (r7 == null) goto L12;
                r0.writeInt(1);     // Catch: Throwable -> L26
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L26
            L14:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L16;
            L20:
                r1.readException();     // Catch: Throwable -> L26
                if (r1.readInt() != 0) goto L24;
                r2 = false;
            L24:
                r1.recycle();
                r0.recycle();
                return r2;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                boolean r4 = Stub.getDefaultImpl().onTransitionStart(r5, r6, r7);     // Catch: Throwable -> L26
                r1.recycle();
                r0.recycle();
                return r4;
            L12:
                r0.writeInt(0);     // Catch: Throwable -> L26
                goto L14
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L26
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L26
            L26:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionCallback
            public boolean onHideTitleBar(SurfaceControl r6, Bundle r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L7:
                if (r7 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L11:
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L23
                if (r1.readInt() != 0) goto L21;
                r2 = false;
            L21:
                r1.recycle();
                r0.recycle();
                return r2;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                boolean r5 = Stub.getDefaultImpl().onHideTitleBar(r6, r7);     // Catch: Throwable -> L23
                r1.recycle();
                r0.recycle();
                return r5;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L23
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionCallback
            public void onTransitionCancelled() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onTransitionCancelled();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionCallback
            public void onTransitionFinished() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onTransitionFinished();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
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

        public static IFloatingTransitionCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IFloatingTransitionCallback.class) == false) goto L13;
            return (IFloatingTransitionCallback) ZeusTransformUtils.preCheckCast(r0, IFloatingTransitionCallback.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            Bundle r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L32;
            SurfaceControl r10 = (SurfaceControl) ZeusTransformUtils.preCheckCast(SurfaceControl.CREATOR.createFromParcel(r7), SurfaceControl.class, "com.obric.aiagent.plugin");
        L34:
            if (r7.readInt() == 0) goto L36;
            SurfaceControl r11 = (SurfaceControl) ZeusTransformUtils.preCheckCast(SurfaceControl.CREATOR.createFromParcel(r7), SurfaceControl.class, "com.obric.aiagent.plugin");
        L38:
            if (r7.readInt() == 0) goto L40;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L40:
            boolean r5 = onTransitionStart(r10, r11, r1);
            r8.writeNoException();
            r8.writeInt(r5 ? 1 : 0);
            return true;
        L36:
            r11 = null;
            goto L38
        L32:
            r10 = null;
            goto L34
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L23;
            SurfaceControl r12 = (SurfaceControl) ZeusTransformUtils.preCheckCast(SurfaceControl.CREATOR.createFromParcel(r7), SurfaceControl.class, "com.obric.aiagent.plugin");
        L25:
            if (r7.readInt() == 0) goto L27;
            r1 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.aiagent.plugin");
        L27:
            boolean r13 = onHideTitleBar(r12, r1);
            r8.writeNoException();
            r8.writeInt(r13 ? 1 : 0);
            return true;
        L23:
            r12 = null;
            goto L25
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface(DESCRIPTOR);
            onTransitionCancelled();
            r8.writeNoException();
            return true;
        L9:
            if (r6 != 4) goto L11;
            r7.enforceInterface(DESCRIPTOR);
            onTransitionFinished();
            r8.writeNoException();
            return true;
        L11:
            if (r6 != 1598968902) goto L13;
            r8.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r6, r7, r8, r9);
        }

        public static boolean setDefaultImpl(IFloatingTransitionCallback r2) {
            IFloatingTransitionCallback r3 = (IFloatingTransitionCallback) ZeusTransformUtils.wrapperContextForParams(r2, IFloatingTransitionCallback.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IFloatingTransitionCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    boolean onHideTitleBar(SurfaceControl r1, Bundle r2);

    void onTransitionCancelled();

    void onTransitionFinished();

    boolean onTransitionStart(SurfaceControl r1, SurfaceControl r2, Bundle r3);
}
