package com.alipay.android.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public interface IRemoteServiceCallback extends IInterface {

    public static abstract class Stub extends Binder implements IRemoteServiceCallback {
        public static final String DESCRIPTOR = "com.alipay.android.app.IRemoteServiceCallback";
        public static final int TRANSACTION_getVersion = 4;
        public static final int TRANSACTION_isHideLoadingScreen = 3;
        public static final int TRANSACTION_payEnd = 2;
        public static final int TRANSACTION_r03 = 5;
        public static final int TRANSACTION_startActivity = 1;

        public static class a implements IRemoteServiceCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f24988a;

            public String d() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.alipay.android.app.IRemoteServiceCallback
            public int getVersion() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_android_app_IRemoteServiceCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24988a, 4, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                int r102 = r101.readInt();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.alipay.android.app.IRemoteServiceCallback
            public boolean isHideLoadingScreen() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r102 = false;
                INVOKEINTERFACE_com_alipay_android_app_IRemoteServiceCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24988a, 3, r100, r101, 0);     // Catch: Throwable -> L8
                r101.readException();     // Catch: Throwable -> L8
                if (r101.readInt() == 0) goto L6;
                r102 = true;
            L6:
                r101.recycle();
                r100.recycle();
                return r102;
            L8:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24988a;
            }

            public a(IBinder r100) {
                this.f24988a = r100;
            }

            @Override // com.alipay.android.app.IRemoteServiceCallback
            public void payEnd(boolean r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L6
                r102.writeString(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_android_app_IRemoteServiceCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24988a, 2, r102, r103, 0);     // Catch: Throwable -> L6
                r103.readException();     // Catch: Throwable -> L6
                r103.recycle();
                r102.recycle();
                return;
            L6:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.alipay.android.app.IRemoteServiceCallback
            public void r03(String r100, String r101, Map r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeString(r100);     // Catch: Throwable -> L6
                r103.writeString(r101);     // Catch: Throwable -> L6
                r103.writeMap(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_android_app_IRemoteServiceCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24988a, 5, r103, null, 1);     // Catch: Throwable -> L6
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.alipay.android.app.IRemoteServiceCallback
            public void startActivity(String r100, String r101, int r102, Bundle r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                Parcel r105 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r104.writeString(r100);     // Catch: Throwable -> L10
                r104.writeString(r101);     // Catch: Throwable -> L10
                r104.writeInt(r102);     // Catch: Throwable -> L10
                if (r103 == null) goto L6;
                r104.writeInt(1);     // Catch: Throwable -> L10
                r103.writeToParcel(r104, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_com_alipay_android_app_IRemoteServiceCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24988a, 1, r104, r105, 0);     // Catch: Throwable -> L10
                r105.readException();     // Catch: Throwable -> L10
                r105.recycle();
                r104.recycle();
                return;
            L6:
                r104.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r105.recycle();
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_alipay_android_app_IRemoteServiceCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IRemoteServiceCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IRemoteServiceCallback) == false) goto L12;
            return (IRemoteServiceCallback) r101;
        L12:
            return new a(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 == 1598968902) goto L33;
            if (r100 != 1) goto L6;
            r101.enforceInterface(DESCRIPTOR);
            String r104 = r101.readString();
            String r105 = r101.readString();
            int r106 = r101.readInt();
            if (r101.readInt() == 0) goto L30;
            Bundle r107 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L31:
            startActivity(r104, r105, r106, r107);
            r102.writeNoException();
            return true;
        L30:
            r107 = null;
            goto L31
        L6:
            if (r100 != 2) goto L8;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L24;
            boolean r108 = true;
        L25:
            payEnd(r108, r101.readString());
            r102.writeNoException();
            return true;
        L24:
            r108 = false;
            goto L25
        L8:
            if (r100 != 3) goto L10;
            r101.enforceInterface(DESCRIPTOR);
            boolean r109 = isHideLoadingScreen();
            r102.writeNoException();
            r102.writeInt(r109 ? 1 : 0);
            return true;
        L10:
            if (r100 != 4) goto L12;
            r101.enforceInterface(DESCRIPTOR);
            int r110 = getVersion();
            r102.writeNoException();
            r102.writeInt(r110);
            return true;
        L12:
            if (r100 != 5) goto L14;
            r101.enforceInterface(DESCRIPTOR);
            r03(r101.readString(), r101.readString(), r101.readHashMap(getClass().getClassLoader()));
            return true;
        L14:
            return super.onTransact(r100, r101, r102, r103);
        L33:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getVersion() throws RemoteException;

    boolean isHideLoadingScreen() throws RemoteException;

    void payEnd(boolean r100, String r101) throws RemoteException;

    void r03(String r100, String r101, Map r102) throws RemoteException;

    void startActivity(String r100, String r101, int r102, Bundle r103) throws RemoteException;
}
