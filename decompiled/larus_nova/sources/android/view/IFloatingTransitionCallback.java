package android.view;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public interface IFloatingTransitionCallback extends IInterface {

    public static class Default implements IFloatingTransitionCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.view.IFloatingTransitionCallback
        public boolean onHideTitleBar(SurfaceControl r100, Bundle r101) throws RemoteException {
            return false;
        }

        @Override // android.view.IFloatingTransitionCallback
        public void onTransitionCancelled() throws RemoteException {
        }

        @Override // android.view.IFloatingTransitionCallback
        public void onTransitionFinished() throws RemoteException {
        }

        @Override // android.view.IFloatingTransitionCallback
        public boolean onTransitionStart(SurfaceControl r100, SurfaceControl r101, Bundle r102) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IFloatingTransitionCallback {
        private static final String DESCRIPTOR = "android.view.IFloatingTransitionCallback";
        static final int TRANSACTION_onHideTitleBar = 2;
        static final int TRANSACTION_onTransitionCancelled = 3;
        static final int TRANSACTION_onTransitionFinished = 4;
        static final int TRANSACTION_onTransitionStart = 1;

        public static class Proxy implements IFloatingTransitionCallback {
            public static IFloatingTransitionCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.view.IFloatingTransitionCallback
            public void onTransitionCancelled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_android_view_IFloatingTransitionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onTransitionCancelled();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionCallback
            public void onTransitionFinished() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_android_view_IFloatingTransitionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onTransitionFinished();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.view.IFloatingTransitionCallback
            public boolean onHideTitleBar(SurfaceControl r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                boolean r104 = true;
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L23
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L23
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L23
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L23
            L11:
                if (INVOKEINTERFACE_android_view_IFloatingTransitionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L23
                if (r103.readInt() != 0) goto L21;
                r104 = false;
            L21:
                r103.recycle();
                r102.recycle();
                return r104;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                boolean r105 = Stub.getDefaultImpl().onHideTitleBar(r100, r101);     // Catch: Throwable -> L23
                r103.recycle();
                r102.recycle();
                return r105;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L23
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionCallback
            public boolean onTransitionStart(SurfaceControl r100, SurfaceControl r101, Bundle r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L26
                boolean r105 = true;
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L26
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L26
            L7:
                if (r101 == null) goto L9;
                r103.writeInt(1);     // Catch: Throwable -> L26
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L26
            L10:
                if (r102 == null) goto L12;
                r103.writeInt(1);     // Catch: Throwable -> L26
                r102.writeToParcel(r103, 0);     // Catch: Throwable -> L26
            L14:
                if (INVOKEINTERFACE_android_view_IFloatingTransitionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L16;
            L20:
                r104.readException();     // Catch: Throwable -> L26
                if (r104.readInt() != 0) goto L24;
                r105 = false;
            L24:
                r104.recycle();
                r103.recycle();
                return r105;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                boolean r106 = Stub.getDefaultImpl().onTransitionStart(r100, r101, r102);     // Catch: Throwable -> L26
                r104.recycle();
                r103.recycle();
                return r106;
            L12:
                r103.writeInt(0);     // Catch: Throwable -> L26
                goto L14
            L9:
                r103.writeInt(0);     // Catch: Throwable -> L26
                goto L10
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L26
            L26:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_android_view_IFloatingTransitionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r100 = SystemClock.uptimeMillis();
                boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
                long r102 = SystemClock.uptimeMillis() - r100;
                if (r102 < 100) goto L11;
                BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r101;
            L12:
                th = move-exception;
                long r103 = SystemClock.uptimeMillis() - r100;
                if (r103 < 100) goto L22;
                if (r110 != null) goto L17;
                String r104 = "";
            L18:
                BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r104 = r110.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r110.transact(r111, r112, r113, r114);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFloatingTransitionCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFloatingTransitionCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFloatingTransitionCallback) == false) goto L12;
            return (IFloatingTransitionCallback) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFloatingTransitionCallback r100) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r100 == null) goto L7;
            Proxy.sDefaultImpl = r100;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            Bundle r104 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L32;
            SurfaceControl r105 = (SurfaceControl) SurfaceControl.CREATOR.createFromParcel(r101);
        L34:
            if (r101.readInt() == 0) goto L36;
            SurfaceControl r106 = (SurfaceControl) SurfaceControl.CREATOR.createFromParcel(r101);
        L38:
            if (r101.readInt() == 0) goto L40;
            r104 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L40:
            boolean r107 = onTransitionStart(r105, r106, r104);
            r102.writeNoException();
            r102.writeInt(r107 ? 1 : 0);
            return true;
        L36:
            r106 = null;
            goto L38
        L32:
            r105 = null;
            goto L34
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L23;
            SurfaceControl r108 = (SurfaceControl) SurfaceControl.CREATOR.createFromParcel(r101);
        L25:
            if (r101.readInt() == 0) goto L27;
            r104 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L27:
            boolean r109 = onHideTitleBar(r108, r104);
            r102.writeNoException();
            r102.writeInt(r109 ? 1 : 0);
            return true;
        L23:
            r108 = null;
            goto L25
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            onTransitionCancelled();
            r102.writeNoException();
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            onTransitionFinished();
            r102.writeNoException();
            return true;
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    boolean onHideTitleBar(SurfaceControl r100, Bundle r101) throws RemoteException;

    void onTransitionCancelled() throws RemoteException;

    void onTransitionFinished() throws RemoteException;

    boolean onTransitionStart(SurfaceControl r100, SurfaceControl r101, Bundle r102) throws RemoteException;
}
