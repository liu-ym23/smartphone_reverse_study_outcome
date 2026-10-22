package com.alipay.android.app;

import android.os.Binder;
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
public interface IAlixPay extends IInterface {

    public static abstract class Stub extends Binder implements IAlixPay {
        public static final String DESCRIPTOR = "com.alipay.android.app.IAlixPay";
        public static final int TRANSACTION_Pay = 1;
        public static final int TRANSACTION_deployFastConnect = 6;
        public static final int TRANSACTION_getVersion = 8;
        public static final int TRANSACTION_manager = 7;
        public static final int TRANSACTION_pay02 = 9;
        public static final int TRANSACTION_prePay = 5;
        public static final int TRANSACTION_r03 = 10;
        public static final int TRANSACTION_registerCallback = 3;
        public static final int TRANSACTION_registerCallback03 = 11;
        public static final int TRANSACTION_test = 2;
        public static final int TRANSACTION_unregisterCallback = 4;

        public static class a implements IAlixPay {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f24987a;

            public String d() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.alipay.android.app.IAlixPay
            public void deployFastConnect() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24987a, 6, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.alipay.android.app.IAlixPay
            public int getVersion() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24987a, 8, r100, r101, 0);     // Catch: Throwable -> L6
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

            @Override // com.alipay.android.app.IAlixPay
            public String test() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24987a, 2, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                String r102 = r101.readString();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24987a;
            }

            public a(IBinder r100) {
                this.f24987a = r100;
            }

            @Override // com.alipay.android.app.IAlixPay
            public String Pay(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeString(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24987a, 1, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                String r103 = r102.readString();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.alipay.android.app.IAlixPay
            public boolean manager(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                r101.writeString(r100);     // Catch: Throwable -> L8
                boolean r103 = false;
                INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24987a, 7, r101, r102, 0);     // Catch: Throwable -> L8
                r102.readException();     // Catch: Throwable -> L8
                if (r102.readInt() == 0) goto L6;
                r103 = true;
            L6:
                r102.recycle();
                r101.recycle();
                return r103;
            L8:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.alipay.android.app.IAlixPay
            public String prePay(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeString(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24987a, 5, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                String r103 = r102.readString();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.alipay.android.app.IAlixPay
            public void registerCallback(IRemoteServiceCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L10
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L10
                INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24987a, 3, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.alipay.android.app.IAlixPay
            public void unregisterCallback(IRemoteServiceCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L10
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L10
                INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24987a, 4, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.alipay.android.app.IAlixPay
            public String pay02(String r100, Map r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeString(r100);     // Catch: Throwable -> L6
                r102.writeMap(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24987a, 9, r102, r103, 0);     // Catch: Throwable -> L6
                r103.readException();     // Catch: Throwable -> L6
                String r104 = r103.readString();     // Catch: Throwable -> L6
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.alipay.android.app.IAlixPay
            public void r03(String r100, String r101, Map r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeString(r100);     // Catch: Throwable -> L6
                r103.writeString(r101);     // Catch: Throwable -> L6
                r103.writeMap(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24987a, 10, r103, null, 1);     // Catch: Throwable -> L6
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.alipay.android.app.IAlixPay
            public void registerCallback03(IRemoteServiceCallback r100, String r101, Map r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                IBinder r105 = r100.asBinder();     // Catch: Throwable -> L10
            L7:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L10
                r103.writeString(r101);     // Catch: Throwable -> L10
                r103.writeMap(r102);     // Catch: Throwable -> L10
                INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24987a, 11, r103, r104, 0);     // Catch: Throwable -> L10
                r104.readException();     // Catch: Throwable -> L10
                r104.recycle();
                r103.recycle();
                return;
            L6:
                r105 = null;
            L10:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_alipay_android_app_IAlixPay$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IAlixPay asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAlixPay) == false) goto L12;
            return (IAlixPay) r101;
        L12:
            return new a(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 == 1598968902) goto L29;
            switch(r100) {
                case 1: goto L27;
                case 2: goto L25;
                case 3: goto L23;
                case 4: goto L21;
                case 5: goto L19;
                case 6: goto L17;
                case 7: goto L15;
                case 8: goto L13;
                case 9: goto L11;
                case 10: goto L9;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            registerCallback03(IRemoteServiceCallback.Stub.asInterface(r101.readStrongBinder()), r101.readString(), r101.readHashMap(Stub.class.getClassLoader()));
            r102.writeNoException();
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            r03(r101.readString(), r101.readString(), r101.readHashMap(Stub.class.getClassLoader()));
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            String r104 = pay02(r101.readString(), r101.readHashMap(Stub.class.getClassLoader()));
            r102.writeNoException();
            r102.writeString(r104);
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            int r105 = getVersion();
            r102.writeNoException();
            r102.writeInt(r105);
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            boolean r106 = manager(r101.readString());
            r102.writeNoException();
            r102.writeInt(r106 ? 1 : 0);
            return true;
        L17:
            r101.enforceInterface(DESCRIPTOR);
            deployFastConnect();
            r102.writeNoException();
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            String r107 = prePay(r101.readString());
            r102.writeNoException();
            r102.writeString(r107);
            return true;
        L21:
            r101.enforceInterface(DESCRIPTOR);
            unregisterCallback(IRemoteServiceCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L23:
            r101.enforceInterface(DESCRIPTOR);
            registerCallback(IRemoteServiceCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L25:
            r101.enforceInterface(DESCRIPTOR);
            String r108 = test();
            r102.writeNoException();
            r102.writeString(r108);
            return true;
        L27:
            r101.enforceInterface(DESCRIPTOR);
            String r109 = Pay(r101.readString());
            r102.writeNoException();
            r102.writeString(r109);
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L29:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    String Pay(String r100) throws RemoteException;

    void deployFastConnect() throws RemoteException;

    int getVersion() throws RemoteException;

    boolean manager(String r100) throws RemoteException;

    String pay02(String r100, Map r101) throws RemoteException;

    String prePay(String r100) throws RemoteException;

    void r03(String r100, String r101, Map r102) throws RemoteException;

    void registerCallback(IRemoteServiceCallback r100) throws RemoteException;

    void registerCallback03(IRemoteServiceCallback r100, String r101, Map r102) throws RemoteException;

    String test() throws RemoteException;

    void unregisterCallback(IRemoteServiceCallback r100) throws RemoteException;
}
