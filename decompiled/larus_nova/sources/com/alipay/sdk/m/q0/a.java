package com.alipay.sdk.m.q0;

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
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.alipay.sdk.m.q0.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0490a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f25723a = "com.zui.deviceidservice.IDeviceidInterface";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f25724b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f25725c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f25726d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f25727e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f25728f = 5;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f25729g = 6;

        /* JADX INFO: renamed from: com.alipay.sdk.m.q0.a$a$a, reason: collision with other inner class name */
        public static class C0491a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f25730a;

            public String d() {
                return AbstractBinderC0490a.f25723a;
            }

            @Override // com.alipay.sdk.m.q0.a
            public String a() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(AbstractBinderC0490a.f25723a);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_sdk_m_q0_a$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f25730a, 1, r100, r101, 0);     // Catch: Throwable -> L6
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

            @Override // com.alipay.sdk.m.q0.a
            public String b() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(AbstractBinderC0490a.f25723a);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_sdk_m_q0_a$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f25730a, 2, r100, r101, 0);     // Catch: Throwable -> L6
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

            @Override // com.alipay.sdk.m.q0.a
            public boolean c() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(AbstractBinderC0490a.f25723a);     // Catch: Throwable -> L8
                boolean r102 = false;
                INVOKEINTERFACE_com_alipay_sdk_m_q0_a$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f25730a, 3, r100, r101, 0);     // Catch: Throwable -> L8
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
                return this.f25730a;
            }

            public C0491a(IBinder r100) {
                this.f25730a = r100;
            }

            @Override // com.alipay.sdk.m.q0.a
            public String a(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(AbstractBinderC0490a.f25723a);     // Catch: Throwable -> L6
                r101.writeString(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_sdk_m_q0_a$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f25730a, 5, r101, r102, 0);     // Catch: Throwable -> L6
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

            @Override // com.alipay.sdk.m.q0.a
            public String b(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(AbstractBinderC0490a.f25723a);     // Catch: Throwable -> L6
                r101.writeString(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_sdk_m_q0_a$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f25730a, 4, r101, r102, 0);     // Catch: Throwable -> L6
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

            @Override // com.alipay.sdk.m.q0.a
            public boolean c(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(AbstractBinderC0490a.f25723a);     // Catch: Throwable -> L8
                r101.writeString(r100);     // Catch: Throwable -> L8
                boolean r103 = false;
                INVOKEINTERFACE_com_alipay_sdk_m_q0_a$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f25730a, 6, r101, r102, 0);     // Catch: Throwable -> L8
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_alipay_sdk_m_q0_a$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public AbstractBinderC0490a() {
            attachInterface(this, f25723a);
        }

        public static a a(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(f25723a);
            if (r101 == null) goto L12;
            if ((r101 instanceof a) == false) goto L12;
            return (a) r101;
        L12:
            return new C0491a(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 == 1598968902) goto L19;
            switch(r100) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(f25723a);
            boolean r104 = c(r101.readString());
            r102.writeNoException();
            r102.writeInt(r104 ? 1 : 0);
            return true;
        L9:
            r101.enforceInterface(f25723a);
            String r105 = a(r101.readString());
            r102.writeNoException();
            r102.writeString(r105);
            return true;
        L11:
            r101.enforceInterface(f25723a);
            String r106 = b(r101.readString());
            r102.writeNoException();
            r102.writeString(r106);
            return true;
        L13:
            r101.enforceInterface(f25723a);
            boolean r107 = c();
            r102.writeNoException();
            r102.writeInt(r107 ? 1 : 0);
            return true;
        L15:
            r101.enforceInterface(f25723a);
            String r108 = b();
            r102.writeNoException();
            r102.writeString(r108);
            return true;
        L17:
            r101.enforceInterface(f25723a);
            String r109 = a();
            r102.writeNoException();
            r102.writeString(r109);
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L19:
            r102.writeString(f25723a);
            return true;
        }
    }

    String a() throws RemoteException;

    String a(String r100) throws RemoteException;

    String b() throws RemoteException;

    String b(String r100) throws RemoteException;

    boolean c() throws RemoteException;

    boolean c(String r100) throws RemoteException;
}
