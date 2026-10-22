package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import kotlin.text.Typography;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
public interface IUnusedAppRestrictionsBackportCallback extends IInterface {
    public static final String DESCRIPTOR = null;

    public static class Default implements IUnusedAppRestrictionsBackportCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
        public void onIsPermissionRevocationEnabledForAppResult(boolean r100, boolean r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {
        static final int TRANSACTION_onIsPermissionRevocationEnabledForAppResult = 1;

        public static class Proxy implements IUnusedAppRestrictionsBackportCallback {
            private IBinder mRemote;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUnusedAppRestrictionsBackportCallback.DESCRIPTOR;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void onIsPermissionRevocationEnabledForAppResult(boolean r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);     // Catch: Throwable -> L13
                int r103 = 0;
                if (r100 == false) goto L6;
                int r104 = 1;
            L7:
                r102.writeInt(r104);     // Catch: Throwable -> L13
                if (r101 == false) goto L10;
                r103 = 1;
            L10:
                r102.writeInt(r103);     // Catch: Throwable -> L13
                INVOKEINTERFACE_androidx_core_app_unusedapprestrictions_IUnusedAppRestrictionsBackportCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1);     // Catch: Throwable -> L13
                r102.recycle();
                return;
            L6:
                r104 = 0;
            L13:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_androidx_core_app_unusedapprestrictions_IUnusedAppRestrictionsBackportCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
        }

        public static IUnusedAppRestrictionsBackportCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IUnusedAppRestrictionsBackportCallback) == false) goto L12;
            return (IUnusedAppRestrictionsBackportCallback) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            String r104 = IUnusedAppRestrictionsBackportCallback.DESCRIPTOR;
            if (r100 < 1) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(r104);
        L8:
            if (r100 != 1598968902) goto L11;
            r102.writeString(r104);
            return true;
        L11:
            if (r100 != 1) goto L13;
            boolean r105 = false;
            if (r101.readInt() == 0) goto L17;
            boolean r106 = true;
        L19:
            if (r101.readInt() == 0) goto L21;
            r105 = true;
        L21:
            onIsPermissionRevocationEnabledForAppResult(r106, r105);
            return true;
        L17:
            r106 = false;
            goto L19
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onIsPermissionRevocationEnabledForAppResult(boolean r100, boolean r101) throws RemoteException;

    static {
        DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace(Typography.dollar, '.');
    }
}
