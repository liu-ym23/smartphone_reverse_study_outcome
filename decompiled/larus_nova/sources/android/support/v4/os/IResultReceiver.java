package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
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
public interface IResultReceiver extends IInterface {
    public static final String DESCRIPTOR = null;

    public static class Default implements IResultReceiver {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int r100, Bundle r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IResultReceiver {
        static final int TRANSACTION_send = 1;

        public static class Proxy implements IResultReceiver {
            private IBinder mRemote;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IResultReceiver.DESCRIPTOR;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.support.v4.os.IResultReceiver
            public void send(int r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(IResultReceiver.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeInt(r100);     // Catch: Throwable -> L6
                _Parcel.access$100(r102, r101, 0);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_os_IResultReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1);     // Catch: Throwable -> L6
                r102.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_android_support_v4_os_IResultReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IResultReceiver.DESCRIPTOR);
        }

        public static IResultReceiver asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IResultReceiver.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IResultReceiver) == false) goto L12;
            return (IResultReceiver) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            String r104 = IResultReceiver.DESCRIPTOR;
            if (r100 < 1) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(r104);
        L8:
            if (r100 != 1598968902) goto L11;
            r102.writeString(r104);
            return true;
        L11:
            if (r100 != 1) goto L13;
            send(r101.readInt(), (Bundle) _Parcel.access$000(r101, Bundle.CREATOR));
            return true;
        L13:
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

    void send(int r100, Bundle r101) throws RemoteException;

    static {
        DESCRIPTOR = "android$support$v4$os$IResultReceiver".replace(Typography.dollar, '.');
    }
}
