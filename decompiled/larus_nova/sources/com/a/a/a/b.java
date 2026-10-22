package com.a.a.a;

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
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.a.a.a.b$a$a, reason: collision with other inner class name */
        public static class C0474a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static b f24673a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f24674b;

            @Override // com.a.a.a.b
            public final boolean a() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.coloros.gamespace.gamesdk.IHyperBoostService");     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_a_a_a_b$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24674b, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (a.d() == null) goto L10;
                boolean r103 = a.d().a();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.a.a.a.b
            public final String b() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.coloros.gamespace.gamesdk.IHyperBoostService");     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_a_a_a_b$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24674b, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (a.d() == null) goto L10;
                String r103 = a.d().b();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.a.a.a.b
            public final void c() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.coloros.gamespace.gamesdk.IHyperBoostService");     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_a_a_a_b$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24674b, 5, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L12
            L8:
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (a.d() == null) goto L10;
                a.d().c();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f24674b;
            }

            public C0474a(IBinder r100) {
                this.f24674b = r100;
            }

            @Override // com.a.a.a.b
            public final boolean a(IBinder r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.coloros.gamespace.gamesdk.IHyperBoostService");     // Catch: Throwable -> L15
                r101.writeStrongBinder(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_a_a_a_b$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24674b, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (a.d() == null) goto L10;
                boolean r104 = a.d().a(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.a.a.a.b
            public final void a(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.coloros.gamespace.gamesdk.IHyperBoostService");     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_a_a_a_b$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24674b, 6, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (a.d() == null) goto L10;
                a.d().a(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.a.a.a.b
            public final void a(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.coloros.gamespace.gamesdk.IHyperBoostService");     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_a_a_a_b$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f24674b, 4, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (a.d() == null) goto L10;
                a.d().a(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_a_a_a_b$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static b d() {
            return C0474a.f24673a;
        }

        public static b b(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.coloros.gamespace.gamesdk.IHyperBoostService");
            if (r101 == null) goto L12;
            if ((r101 instanceof b) == false) goto L12;
            return (b) r101;
        L12:
            return new C0474a(r100);
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
            r101.enforceInterface("com.coloros.gamespace.gamesdk.IHyperBoostService");
            a(r101.readInt());
            r102.writeNoException();
            return true;
        L9:
            r101.enforceInterface("com.coloros.gamespace.gamesdk.IHyperBoostService");
            c();
            r102.writeNoException();
            return true;
        L11:
            r101.enforceInterface("com.coloros.gamespace.gamesdk.IHyperBoostService");
            a(r101.readString());
            r102.writeNoException();
            return true;
        L13:
            r101.enforceInterface("com.coloros.gamespace.gamesdk.IHyperBoostService");
            String r104 = b();
            r102.writeNoException();
            r102.writeString(r104);
            return true;
        L15:
            r101.enforceInterface("com.coloros.gamespace.gamesdk.IHyperBoostService");
            boolean r105 = a(r101.readStrongBinder());
            r102.writeNoException();
            r102.writeInt(r105 ? 1 : 0);
            return true;
        L17:
            r101.enforceInterface("com.coloros.gamespace.gamesdk.IHyperBoostService");
            boolean r106 = a();
            r102.writeNoException();
            r102.writeInt(r106 ? 1 : 0);
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L19:
            r102.writeString("com.coloros.gamespace.gamesdk.IHyperBoostService");
            return true;
        }
    }

    void a(int r100) throws RemoteException;

    void a(String r100) throws RemoteException;

    boolean a() throws RemoteException;

    boolean a(IBinder r100) throws RemoteException;

    String b() throws RemoteException;

    void c() throws RemoteException;
}
