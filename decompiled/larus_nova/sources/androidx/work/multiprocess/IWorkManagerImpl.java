package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public interface IWorkManagerImpl extends IInterface {

    public static class Default implements IWorkManagerImpl {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelAllWork(IWorkManagerImplCallback r100) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelAllWorkByTag(String r100, IWorkManagerImplCallback r101) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelUniqueWork(String r100, IWorkManagerImplCallback r101) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelWorkById(String r100, IWorkManagerImplCallback r101) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void enqueueContinuation(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void enqueueWorkRequests(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void queryWorkInfo(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void setProgress(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImpl {
        private static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImpl";
        static final int TRANSACTION_cancelAllWork = 6;
        static final int TRANSACTION_cancelAllWorkByTag = 4;
        static final int TRANSACTION_cancelUniqueWork = 5;
        static final int TRANSACTION_cancelWorkById = 3;
        static final int TRANSACTION_enqueueContinuation = 2;
        static final int TRANSACTION_enqueueWorkRequests = 1;
        static final int TRANSACTION_queryWorkInfo = 7;
        static final int TRANSACTION_setProgress = 8;

        public static class Proxy implements IWorkManagerImpl {
            public static IWorkManagerImpl sDefaultImpl;
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

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelAllWork(IWorkManagerImplCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_androidx_work_multiprocess_IWorkManagerImpl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().cancelAllWork(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelAllWorkByTag(String r100, IWorkManagerImplCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_androidx_work_multiprocess_IWorkManagerImpl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().cancelAllWorkByTag(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelUniqueWork(String r100, IWorkManagerImplCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_androidx_work_multiprocess_IWorkManagerImpl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().cancelUniqueWork(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelWorkById(String r100, IWorkManagerImplCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_androidx_work_multiprocess_IWorkManagerImpl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().cancelWorkById(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void enqueueContinuation(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeByteArray(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_androidx_work_multiprocess_IWorkManagerImpl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().enqueueContinuation(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void enqueueWorkRequests(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeByteArray(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_androidx_work_multiprocess_IWorkManagerImpl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().enqueueWorkRequests(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void queryWorkInfo(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeByteArray(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_androidx_work_multiprocess_IWorkManagerImpl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().queryWorkInfo(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void setProgress(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeByteArray(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_androidx_work_multiprocess_IWorkManagerImpl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setProgress(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_androidx_work_multiprocess_IWorkManagerImpl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IWorkManagerImpl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IWorkManagerImpl asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IWorkManagerImpl) == false) goto L12;
            return (IWorkManagerImpl) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IWorkManagerImpl r100) {
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
            if (r100 == 1598968902) goto L23;
            switch(r100) {
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L13;
                case 6: goto L11;
                case 7: goto L9;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            setProgress(r101.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            queryWorkInfo(r101.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            cancelAllWork(IWorkManagerImplCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            cancelUniqueWork(r101.readString(), IWorkManagerImplCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            cancelAllWorkByTag(r101.readString(), IWorkManagerImplCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L17:
            r101.enforceInterface(DESCRIPTOR);
            cancelWorkById(r101.readString(), IWorkManagerImplCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            enqueueContinuation(r101.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L21:
            r101.enforceInterface(DESCRIPTOR);
            enqueueWorkRequests(r101.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L23:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void cancelAllWork(IWorkManagerImplCallback r100) throws RemoteException;

    void cancelAllWorkByTag(String r100, IWorkManagerImplCallback r101) throws RemoteException;

    void cancelUniqueWork(String r100, IWorkManagerImplCallback r101) throws RemoteException;

    void cancelWorkById(String r100, IWorkManagerImplCallback r101) throws RemoteException;

    void enqueueContinuation(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException;

    void enqueueWorkRequests(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException;

    void queryWorkInfo(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException;

    void setProgress(byte[] r100, IWorkManagerImplCallback r101) throws RemoteException;
}
