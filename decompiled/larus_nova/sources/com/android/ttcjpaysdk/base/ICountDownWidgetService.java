package com.android.ttcjpaysdk.base;

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
public interface ICountDownWidgetService extends IInterface {

    public static class Default implements ICountDownWidgetService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.android.ttcjpaysdk.base.ICountDownWidgetService
        public void clearCacheData() throws RemoteException {
        }

        @Override // com.android.ttcjpaysdk.base.ICountDownWidgetService
        public String getCacheData() throws RemoteException {
            return null;
        }

        @Override // com.android.ttcjpaysdk.base.ICountDownWidgetService
        public boolean hasRelease() throws RemoteException {
            return false;
        }

        @Override // com.android.ttcjpaysdk.base.ICountDownWidgetService
        public void setCacheData(String r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICountDownWidgetService {
        private static final String DESCRIPTOR = "com.android.ttcjpaysdk.base.ICountDownWidgetService";
        static final int TRANSACTION_clearCacheData = 3;
        static final int TRANSACTION_getCacheData = 2;
        static final int TRANSACTION_hasRelease = 4;
        static final int TRANSACTION_setCacheData = 1;

        public static class Proxy implements ICountDownWidgetService {
            public static ICountDownWidgetService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.android.ttcjpaysdk.base.ICountDownWidgetService
            public void clearCacheData() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_android_ttcjpaysdk_base_ICountDownWidgetService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearCacheData();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.android.ttcjpaysdk.base.ICountDownWidgetService
            public String getCacheData() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_android_ttcjpaysdk_base_ICountDownWidgetService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getCacheData();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.android.ttcjpaysdk.base.ICountDownWidgetService
            public boolean hasRelease() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_android_ttcjpaysdk_base_ICountDownWidgetService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().hasRelease();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
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

            @Override // com.android.ttcjpaysdk.base.ICountDownWidgetService
            public void setCacheData(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_android_ttcjpaysdk_base_ICountDownWidgetService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setCacheData(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_android_ttcjpaysdk_base_ICountDownWidgetService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICountDownWidgetService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICountDownWidgetService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICountDownWidgetService) == false) goto L12;
            return (ICountDownWidgetService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICountDownWidgetService r100) {
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
            setCacheData(r101.readString());
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            String r104 = getCacheData();
            r102.writeNoException();
            r102.writeString(r104);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            clearCacheData();
            r102.writeNoException();
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            boolean r105 = hasRelease();
            r102.writeNoException();
            r102.writeInt(r105 ? 1 : 0);
            return true;
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void clearCacheData() throws RemoteException;

    String getCacheData() throws RemoteException;

    boolean hasRelease() throws RemoteException;

    void setCacheData(String r100) throws RemoteException;
}
