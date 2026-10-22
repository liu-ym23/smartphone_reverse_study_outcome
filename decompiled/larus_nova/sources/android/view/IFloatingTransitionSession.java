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
public interface IFloatingTransitionSession extends IInterface {

    public static class Default implements IFloatingTransitionSession {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.view.IFloatingTransitionSession
        public void notifyFloatingTransitionFinished(IBinder r100) throws RemoteException {
        }

        @Override // android.view.IFloatingTransitionSession
        public void notifyFloatingTransitionLaunch(IBinder r100) throws RemoteException {
        }

        @Override // android.view.IFloatingTransitionSession
        public boolean registerTitleBar(IBinder r100, IFloatingTransitionCallback r101, IFloatingTransitionStateProvider r102) throws RemoteException {
            return false;
        }

        @Override // android.view.IFloatingTransitionSession
        public void unregisterTitleBar(IBinder r100) throws RemoteException {
        }

        @Override // android.view.IFloatingTransitionSession
        public void updateState(IBinder r100, Bundle r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFloatingTransitionSession {
        private static final String DESCRIPTOR = "android.view.IFloatingTransitionSession";
        static final int TRANSACTION_notifyFloatingTransitionFinished = 5;
        static final int TRANSACTION_notifyFloatingTransitionLaunch = 4;
        static final int TRANSACTION_registerTitleBar = 1;
        static final int TRANSACTION_unregisterTitleBar = 2;
        static final int TRANSACTION_updateState = 3;

        public static class Proxy implements IFloatingTransitionSession {
            public static IFloatingTransitionSession sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.view.IFloatingTransitionSession
            public void notifyFloatingTransitionFinished(IBinder r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStrongBinder(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyFloatingTransitionFinished(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public void notifyFloatingTransitionLaunch(IBinder r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStrongBinder(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyFloatingTransitionLaunch(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public void unregisterTitleBar(IBinder r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStrongBinder(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterTitleBar(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public void updateState(IBinder r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeStrongBinder(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateState(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public boolean registerTitleBar(IBinder r100, IFloatingTransitionCallback r101, IFloatingTransitionStateProvider r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L22
                r103.writeStrongBinder(r100);     // Catch: Throwable -> L22
                IBinder r105 = null;
                if (r101 == null) goto L6;
                IBinder r106 = r101.asBinder();     // Catch: Throwable -> L22
            L7:
                r103.writeStrongBinder(r106);     // Catch: Throwable -> L22
                if (r102 == null) goto L10;
                r105 = r102.asBinder();     // Catch: Throwable -> L22
            L10:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L22
                boolean r107 = false;
                if (INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L13;
            L17:
                r104.readException();     // Catch: Throwable -> L22
                if (r104.readInt() == 0) goto L20;
                r107 = true;
            L20:
                r104.recycle();
                r103.recycle();
                return r107;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                boolean r108 = Stub.getDefaultImpl().registerTitleBar(r100, r101, r102);     // Catch: Throwable -> L22
                r104.recycle();
                r103.recycle();
                return r108;
            L6:
                r106 = null;
            L22:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFloatingTransitionSession getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFloatingTransitionSession asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFloatingTransitionSession) == false) goto L12;
            return (IFloatingTransitionSession) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFloatingTransitionSession r100) {
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
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            boolean r104 = registerTitleBar(r101.readStrongBinder(), IFloatingTransitionCallback.Stub.asInterface(r101.readStrongBinder()), IFloatingTransitionStateProvider.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            r102.writeInt(r104 ? 1 : 0);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            unregisterTitleBar(r101.readStrongBinder());
            r102.writeNoException();
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            IBinder r105 = r101.readStrongBinder();
            if (r101.readInt() == 0) goto L25;
            Bundle r106 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L26:
            updateState(r105, r106);
            r102.writeNoException();
            return true;
        L25:
            r106 = null;
            goto L26
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            notifyFloatingTransitionLaunch(r101.readStrongBinder());
            r102.writeNoException();
            return true;
        L11:
            if (r100 != 5) goto L13;
            r101.enforceInterface(DESCRIPTOR);
            notifyFloatingTransitionFinished(r101.readStrongBinder());
            r102.writeNoException();
            return true;
        L13:
            if (r100 != 1598968902) goto L15;
            r102.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void notifyFloatingTransitionFinished(IBinder r100) throws RemoteException;

    void notifyFloatingTransitionLaunch(IBinder r100) throws RemoteException;

    boolean registerTitleBar(IBinder r100, IFloatingTransitionCallback r101, IFloatingTransitionStateProvider r102) throws RemoteException;

    void unregisterTitleBar(IBinder r100) throws RemoteException;

    void updateState(IBinder r100, Bundle r101) throws RemoteException;
}
