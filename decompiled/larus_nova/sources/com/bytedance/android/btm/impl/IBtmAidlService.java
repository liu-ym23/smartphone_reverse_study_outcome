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
public interface IBtmAidlService extends IInterface {

    public static class Default implements IBtmAidlService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.android.btm.impl.IBtmAidlService
        public String getPreBtm(String r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.android.btm.impl.IBtmAidlService
        public void setPreBtm(String r100, String r101, boolean r102) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IBtmAidlService {
        private static final String DESCRIPTOR = "com.bytedance.android.btm.impl.IBtmAidlService";
        static final int TRANSACTION_getPreBtm = 2;
        static final int TRANSACTION_setPreBtm = 1;

        public static class Proxy implements IBtmAidlService {
            public static IBtmAidlService sDefaultImpl;
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

            @Override // com.bytedance.android.btm.impl.IBtmAidlService
            public String getPreBtm(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_android_btm_impl_IBtmAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                String r103 = r102.readString();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r104 = Stub.getDefaultImpl().getPreBtm(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.android.btm.impl.IBtmAidlService
            public void setPreBtm(String r100, String r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r103.writeString(r100);     // Catch: Throwable -> L17
                r103.writeString(r101);     // Catch: Throwable -> L17
                if (r102 == false) goto L6;
                int r105 = 1;
            L7:
                r103.writeInt(r105);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_android_btm_impl_IBtmAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setPreBtm(r100, r101, r102);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L6:
                r105 = 0;
            L17:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_android_btm_impl_IBtmAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IBtmAidlService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IBtmAidlService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IBtmAidlService) == false) goto L12;
            return (IBtmAidlService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IBtmAidlService r100) {
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
            String r104 = r101.readString();
            String r105 = r101.readString();
            if (r101.readInt() == 0) goto L17;
            boolean r106 = true;
        L18:
            setPreBtm(r104, r105, r106);
            r102.writeNoException();
            return true;
        L17:
            r106 = false;
            goto L18
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            String r107 = getPreBtm(r101.readString());
            r102.writeNoException();
            r102.writeString(r107);
            return true;
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    String getPreBtm(String r100) throws RemoteException;

    void setPreBtm(String r100, String r101, boolean r102) throws RemoteException;
}
