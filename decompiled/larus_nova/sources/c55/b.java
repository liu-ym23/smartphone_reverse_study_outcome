package c55;

import android.os.Binder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes16.dex */
public abstract class b extends Binder {

    public static final class a {
    }

    /* JADX INFO: renamed from: c55.b$b, reason: collision with other inner class name */
    public static final class C0405b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f22482b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f22483a;

        /* JADX INFO: renamed from: c55.b$b$a */
        public static final class a {
        }

        static {
        }

        public C0405b() {
        }

        public final String toString() {
            return "Result {handled=" + this.f22483a + '}';
        }
    }

    static {
    }

    public abstract void b(C0405b r100);

    public b() {
    }

    public final void c(boolean r100) {
        tt5.a.k("drive_in_doc_attachment_ITouchEventCallback", "ITouchEventCallbackProxy.sendTouchEventHandled: handled= " + r100);
        if (isBinderAlive() == false) goto L13;
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken("android.os.IBinder");
        int r103 = C0405b.f22482b;
        r101.writeInt(r100 ? 1 : 0);
        tt5.a.k("drive_in_doc_attachment_ITouchEventCallback", "ITouchEventCallbackProxy.sendTouchEventHandled: send success ");     // Catch: RemoteException -> L7
        a(this, r101, r102);     // Catch: RemoteException -> L7
    L9:
        r102.readException();
        r101.recycle();
        r102.recycle();
        return;
    L7:
        e = move-exception;
        tt5.a.d("drive_in_doc_attachment_ITouchEventCallback", "sendTouchEventHandled: send fail: " + e);
        goto L9
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void a(b r110, Parcel r111, Parcel r112) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r110.transact(2, r111, r112, 0);
        return;
    L6:
        long r100 = SystemClock.uptimeMillis();
        r110.transact(2, r111, r112, 0);     // Catch: Throwable -> L12
        long r101 = SystemClock.uptimeMillis() - r100;
        if (r101 < 100) goto L22;
        BinderPerformanceReporter.report(r101, r110.getClass().getName(), 2, 0, new Throwable("Slow main-thread Binder transaction"));
        return;
    L22:
        return;
    L12:
        th = move-exception;
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L19;
        if (r110 != null) goto L17;
        String r113 = "";
    L18:
        BinderPerformanceReporter.report(r102, r113, 2, 0, new Throwable("Slow main-thread Binder transaction"));
        goto L19
    L17:
        r113 = r110.getClass().getName();
    L19:
        throw th;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r100 != 2) goto L13;
        r101.enforceInterface("android.os.IBinder");     // Catch: Exception -> L10
        C0405b r104 = new C0405b();     // Catch: Exception -> L10
        int r105 = C0405b.f22482b;     // Catch: Exception -> L10
        if (r101.readInt() != 1) goto L7;
        boolean r106 = true;
    L8:
        r104.f22483a = r106;     // Catch: Exception -> L10
        b(r104);     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L10
        r102.writeNoException();     // Catch: Exception -> L10
        return true;
    L7:
        r106 = false;
    L10:
        e = move-exception;
        tt5.a.k("drive_in_doc_attachment_ITouchEventCallback", "Callback ERROR! " + e);
    L13:
        return super.onTransact(r100, r101, r102, r103);
    }
}
