package com.alipay.sdk.m.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.alipay.sdk.m.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0478a extends Binder implements a {

        /* JADX INFO: renamed from: com.alipay.sdk.m.a.a$a$a, reason: collision with other inner class name */
        public static class C0479a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f25211a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25211a;
            }

            public C0479a(IBinder r100) {
                this.f25211a = r100;
            }

            public String a(String r100, String r101, String r102) {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken("com.heytap.openid.IOpenID");     // Catch: Throwable -> L6
                r103.writeString(r100);     // Catch: Throwable -> L6
                r103.writeString(r101);     // Catch: Throwable -> L6
                r103.writeString(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_alipay_sdk_m_a_a$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f25211a, 1, r103, r104, 0);     // Catch: Throwable -> L6
                r104.readException();     // Catch: Throwable -> L6
                String r105 = r104.readString();     // Catch: Throwable -> L6
                r104.recycle();
                r103.recycle();
                return r105;
            L6:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_alipay_sdk_m_a_a$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static a a(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.heytap.openid.IOpenID");
            if (r101 == null) goto L12;
            if ((r101 instanceof a) == false) goto L12;
            return (a) r101;
        L12:
            return new C0479a(r100);
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f25212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f25213b;
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f25214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f25215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f25216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f25217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ServiceConnection f25218e;

        /* JADX INFO: renamed from: com.alipay.sdk.m.a.a$c$a, reason: collision with other inner class name */
        public class ServiceConnectionC0480a implements ServiceConnection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f25219a;

            public ServiceConnectionC0480a(c r100) {
                this.f25219a = r100;
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName r100) {
                this.f25219a.f25214a = null;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName r100, IBinder r101) {
                c r102 = this.f25219a;
                r102.f25214a = AbstractBinderC0478a.a(r101);
                Object r103 = this.f25219a.f25217d;
                monitor-enter(r103);
                this.f25219a.f25217d.notify();     // Catch: Throwable -> L7
                monitor-exit(r103);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f25220a = null;

            static {
                f25220a = new c(null);
            }
        }

        public /* synthetic */ c(ServiceConnectionC0480a r100) {
            this.f25214a = null;
            this.f25215b = null;
            this.f25216c = null;
            this.f25217d = new Object();
            this.f25218e = new ServiceConnectionC0480a(this);
        }

        public boolean a(Context r100) {
        L17:
            e = move-exception;
            e.printStackTrace();
            return false;
        L5:
            PackageInfo r101 = r100.getPackageManager().getPackageInfo("com.heytap.openid", 0);     // Catch: PackageManager.NameNotFoundException -> L17
            if (Build.VERSION.SDK_INT < 28) goto L12;
            if (r101 != null) goto L9;
            return false;
        L9:
            if (r101.getLongVersionCode() < 1) goto L22;
            return true;
        L22:
            return false;
        L12:
            if (r101 != null) goto L14;
            return false;
        L14:
            if (r101.versionCode < 1) goto L24;
            return true;
        L24:
            return false;
        }

        public synchronized String a(Context r100, String r101) {
            monitor-enter(this);
        L42:
            th = move-exception;
            throw th;
        L4:
            if (Looper.myLooper() == Looper.getMainLooper()) goto L41;
            if (this.f25214a != null) goto L47;
            Intent r102 = new Intent();     // Catch: Throwable -> L42
            r102.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));     // Catch: Throwable -> L42
            r102.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");     // Catch: Throwable -> L42
            if (r100.bindService(r102, this.f25218e, 1) == false) goto L22;
            Object r103 = this.f25217d;     // Catch: Throwable -> L42
            monitor-enter(r103);     // Catch: Throwable -> L42
            this.f25217d.wait(3000);     // Catch: Throwable -> L13 InterruptedException -> L15
        L17:
            monitor-exit(r103);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L42
        L15:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L13
        L22:
            if (this.f25214a == null) goto L24;
            String r104 = b(r100, r101);     // Catch: RemoteException -> L29 Throwable -> L42
            monitor-exit(this);
            return r104;
        L29:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L42
            return "";
        L24:
            monitor-exit(this);
            return "";
        L47:
            String r105 = b(r100, r101);     // Catch: RemoteException -> L36 Throwable -> L42
            monitor-exit(this);
            return r105;
        L36:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L42
            return "";
        L41:
            throw new IllegalStateException("Cannot run on MainThread");     // Catch: Throwable -> L42
        }

        public final String b(Context r100, String r101) {
            if (TextUtils.isEmpty(this.f25215b) == false) goto L6;
            this.f25215b = r100.getPackageName();
        L6:
            if (TextUtils.isEmpty(this.f25216c) == false) goto L26;
            String r102 = null;
            Signature[] r103 = r100.getPackageManager().getPackageInfo(this.f25215b, 64).signatures;     // Catch: PackageManager.NameNotFoundException -> L10
        L12:
            if (r103 != null) goto L14;
        L25:
            this.f25216c = r102;
            goto L26
        L14:
            if (r103.length <= 0) goto L25;
            int r104 = 0;
            byte[] r105 = r103[0].toByteArray();
            MessageDigest r106 = MessageDigest.getInstance("SHA1");     // Catch: NoSuchAlgorithmException -> L23
            if (r106 == null) goto L25;
            byte[] r107 = r106.digest(r105);     // Catch: NoSuchAlgorithmException -> L23
            StringBuilder r108 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L23
            int r109 = r107.length;     // Catch: NoSuchAlgorithmException -> L23
        L19:
            if (r104 >= r109) goto L21;
            r108.append(Integer.toHexString((r107[r104] & UByte.MAX_VALUE) | 256).substring(1, 3));     // Catch: NoSuchAlgorithmException -> L23
            r104 = r104 + 1;     // Catch: NoSuchAlgorithmException -> L23
            goto L19
        L21:
            r102 = r108.toString();     // Catch: NoSuchAlgorithmException -> L23
        L23:
            e = move-exception;
            e.printStackTrace();
        L10:
            e = move-exception;
            e.printStackTrace();
            r103 = null;
        L26:
            String r110 = ((AbstractBinderC0478a.C0479a) this.f25214a).a(this.f25215b, this.f25216c, r101);
            if (TextUtils.isEmpty(r110) == false) goto L35;
            return "";
        L35:
            return r110;
        }
    }
}
