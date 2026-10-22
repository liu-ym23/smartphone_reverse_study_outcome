package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import kotlin.text.Typography;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public interface INotificationSideChannel extends IInterface {
    public static final String DESCRIPTOR = null;

    public static class Default implements INotificationSideChannel {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String r100, int r101, String r102) throws RemoteException {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String r100) throws RemoteException {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String r100, int r101, String r102, Notification r103) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements INotificationSideChannel {
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        public static class Proxy implements INotificationSideChannel {
            private IBinder mRemote;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return INotificationSideChannel.DESCRIPTOR;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancelAll(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(INotificationSideChannel.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeString(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_app_INotificationSideChannel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1);     // Catch: Throwable -> L6
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancel(String r100, int r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(INotificationSideChannel.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeString(r100);     // Catch: Throwable -> L6
                r103.writeInt(r101);     // Catch: Throwable -> L6
                r103.writeString(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_app_INotificationSideChannel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r103, null, 1);     // Catch: Throwable -> L6
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void notify(String r100, int r101, String r102, Notification r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                r104.writeInterfaceToken(INotificationSideChannel.DESCRIPTOR);     // Catch: Throwable -> L6
                r104.writeString(r100);     // Catch: Throwable -> L6
                r104.writeInt(r101);     // Catch: Throwable -> L6
                r104.writeString(r102);     // Catch: Throwable -> L6
                _Parcel.access$100(r104, r103, 0);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_app_INotificationSideChannel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r104, null, 1);     // Catch: Throwable -> L6
                r104.recycle();
                return;
            L6:
                th = move-exception;
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_android_support_v4_app_INotificationSideChannel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, INotificationSideChannel.DESCRIPTOR);
        }

        public static INotificationSideChannel asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(INotificationSideChannel.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof INotificationSideChannel) == false) goto L12;
            return (INotificationSideChannel) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            String r104 = INotificationSideChannel.DESCRIPTOR;
            if (r100 < 1) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(r104);
        L8:
            if (r100 != 1598968902) goto L11;
            r102.writeString(r104);
            return true;
        L11:
            if (r100 != 1) goto L13;
            notify(r101.readString(), r101.readInt(), r101.readString(), (Notification) _Parcel.access$000(r101, Notification.CREATOR));
        L21:
            return true;
        L13:
            if (r100 != 2) goto L15;
            cancel(r101.readString(), r101.readInt(), r101.readString());
            goto L21
        L15:
            if (r100 != 3) goto L17;
            cancelAll(r101.readString());
            goto L21
        L17:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static /* synthetic */ Object access$000(Parcel r100, Parcelable.Creator r101) {
            return readTypedObject(r100, r101);
        }

        private static <T> T readTypedObject(Parcel r100, Parcelable.Creator<T> r101) {
            if (r100.readInt() != 0) goto L5;
            return null;
        L5:
            return r101.createFromParcel(r100);
        }

        public static /* synthetic */ void access$100(Parcel r100, Parcelable r101, int r102) {
            writeTypedObject(r100, r101, r102);
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel r100, T r101, int r102) {
            if (r101 == null) goto L4;
            r100.writeInt(1);
            r101.writeToParcel(r100, r102);
            return;
        L4:
            r100.writeInt(0);
        }
    }

    void cancel(String r100, int r101, String r102) throws RemoteException;

    void cancelAll(String r100) throws RemoteException;

    void notify(String r100, int r101, String r102, Notification r103) throws RemoteException;

    static {
        DESCRIPTOR = "android$support$v4$app$INotificationSideChannel".replace(Typography.dollar, '.');
    }
}
