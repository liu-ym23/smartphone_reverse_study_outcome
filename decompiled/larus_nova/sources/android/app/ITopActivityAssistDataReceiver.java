package android.app;

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

/* JADX INFO: loaded from: classes6.dex */
public interface ITopActivityAssistDataReceiver extends IInterface {

    /* JADX INFO: loaded from: classes2.dex */
    public static class Default implements ITopActivityAssistDataReceiver {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.ITopActivityAssistDataReceiver
        public void onResultData(int r100, Bundle r101) throws RemoteException {
        }

        @Override // android.app.ITopActivityAssistDataReceiver
        public void onScreenshotData(int r100, Bundle r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITopActivityAssistDataReceiver {
        private static final String DESCRIPTOR = "android.app.ITopActivityAssistDataReceiver";
        static final int TRANSACTION_onResultData = 1;
        static final int TRANSACTION_onScreenshotData = 2;

        /* JADX INFO: loaded from: classes2.dex */
        public static class Proxy implements ITopActivityAssistDataReceiver {
            public static ITopActivityAssistDataReceiver sDefaultImpl;
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

            @Override // android.app.ITopActivityAssistDataReceiver
            public void onResultData(int r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeInt(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L16
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_android_app_ITopActivityAssistDataReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onResultData(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // android.app.ITopActivityAssistDataReceiver
            public void onScreenshotData(int r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeInt(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L16
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_android_app_ITopActivityAssistDataReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onScreenshotData(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_android_app_ITopActivityAssistDataReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ITopActivityAssistDataReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ITopActivityAssistDataReceiver asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ITopActivityAssistDataReceiver) == false) goto L12;
            return (ITopActivityAssistDataReceiver) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ITopActivityAssistDataReceiver r100) {
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
            Bundle r104 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            int r105 = r101.readInt();
            if (r101.readInt() == 0) goto L20;
            r104 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L20:
            onResultData(r105, r104);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            int r106 = r101.readInt();
            if (r101.readInt() == 0) goto L15;
            r104 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L15:
            onScreenshotData(r106, r104);
            return true;
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onResultData(int r100, Bundle r101) throws RemoteException;

    void onScreenshotData(int r100, Bundle r101) throws RemoteException;
}
