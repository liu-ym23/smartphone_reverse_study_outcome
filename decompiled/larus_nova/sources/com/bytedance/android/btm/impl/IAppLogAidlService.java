package com.bytedance.android.btm.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public interface IAppLogAidlService extends IInterface {

    public static class Default implements IAppLogAidlService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.android.btm.impl.IAppLogAidlService
        public void onEventV1(String r100, String r101, String r102, long r103, long r104, boolean r105, String r106) throws RemoteException {
        }

        @Override // com.bytedance.android.btm.impl.IAppLogAidlService
        public void onEventV3(String r100, String r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAppLogAidlService {
        private static final String DESCRIPTOR = "com.bytedance.android.btm.impl.IAppLogAidlService";
        static final int TRANSACTION_onEventV1 = 1;
        static final int TRANSACTION_onEventV3 = 2;

        public static class Proxy implements IAppLogAidlService {
            public static IAppLogAidlService sDefaultImpl;
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

            @Override // com.bytedance.android.btm.impl.IAppLogAidlService
            public void onEventV3(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeString(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_android_btm_impl_IAppLogAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onEventV3(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_android_btm_impl_IAppLogAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.bytedance.android.btm.impl.IAppLogAidlService
            public void onEventV1(String r110, String r111, String r112, long r113, long r210, boolean r211, String r212) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                r100.writeString(r111);     // Catch: Throwable -> L21
                r100.writeString(r112);     // Catch: Throwable -> L21
                r100.writeLong(r113);     // Catch: Throwable -> L21
                r100.writeLong(r210);     // Catch: Throwable -> L21
                if (r211 == false) goto L6;
                int r114 = 1;
            L7:
                r100.writeInt(r114);     // Catch: Throwable -> L21
                r100.writeString(r212);     // Catch: Throwable -> L21
            L19:
                th = th;
            L23:
                r101.recycle();
                r100.recycle();
                throw th;
            L10:
                if (INVOKEINTERFACE_com_bytedance_android_btm_impl_IAppLogAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L12;
            L16:
                r101.readException();     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().onEventV1(r110, r111, r112, r113, r210, r211, r212);     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r114 = 0;
            L21:
                th = th;
                goto L23
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAppLogAidlService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAppLogAidlService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAppLogAidlService) == false) goto L12;
            return (IAppLogAidlService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IAppLogAidlService r100) {
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
        public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
            if (r110 != 1) goto L5;
            r111.enforceInterface(DESCRIPTOR);
            String r100 = r111.readString();
            String r101 = r111.readString();
            String r102 = r111.readString();
            long r103 = r111.readLong();
            long r104 = r111.readLong();
            if (r111.readInt() == 0) goto L17;
            boolean r105 = true;
        L18:
            onEventV1(r100, r101, r102, r103, r104, r105, r111.readString());
            r112.writeNoException();
            return true;
        L17:
            r105 = false;
            goto L18
        L5:
            if (r110 != 2) goto L7;
            r111.enforceInterface(DESCRIPTOR);
            onEventV3(r111.readString(), r111.readString());
            r112.writeNoException();
            return true;
        L7:
            if (r110 != 1598968902) goto L9;
            r112.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r110, r111, r112, r113);
        }
    }

    void onEventV1(String r100, String r101, String r102, long r103, long r104, boolean r105, String r106) throws RemoteException;

    void onEventV3(String r100, String r101) throws RemoteException;
}
