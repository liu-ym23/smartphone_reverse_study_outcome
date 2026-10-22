package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RestrictTo;
import com.obric.capabilitykit.common.UiType;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProfileVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.concurrent.futures.c f3930a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f3931b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static CompilationStatus f3932c;

    public static class CompilationStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f3935c;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface ResultCode {
        }

        public CompilationStatus(int r10, boolean r11, boolean r12) {
            this.f3933a = r10;
            this.f3935c = r12;
            this.f3934b = r11;
        }
    }

    public static class a {
        @DoNotInline
        public static PackageInfo a(PackageManager r10, Context r11) throws PackageManager.NameNotFoundException {
            return r10.getPackageInfo(r11.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f3938c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f3939d;

        public b(int r10, int r11, long r12, long r13) {
            this.f3936a = r10;
            this.f3937b = r11;
            this.f3938c = r12;
            this.f3939d = r13;
        }

        public static b a(File r10) {
            DataInputStream r11 = new DataInputStream(new FileInputStream(r10));
            b r12 = new b(r11.readInt(), r11.readInt(), r11.readLong(), r11.readLong());     // Catch: Throwable -> L6
            r11.close();
            return r12;
        L6:
            th = move-exception;
            r11.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }

        public void b(File r10) {
            r10.delete();
            DataOutputStream r11 = new DataOutputStream(new FileOutputStream(r10));
            r11.writeInt(this.f3936a);     // Catch: Throwable -> L6
            r11.writeInt(this.f3937b);     // Catch: Throwable -> L6
            r11.writeLong(this.f3938c);     // Catch: Throwable -> L6
            r11.writeLong(this.f3939d);     // Catch: Throwable -> L6
            r11.close();
            return;
        L6:
            th = move-exception;
            r11.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 != null) goto L8;
        L21:
            return false;
        L8:
            if ((r10 instanceof b) == false) goto L21;
            b r11 = (b) r10;
            if (this.f3937b != r11.f3937b) goto L20;
            if (this.f3938c != r11.f3938c) goto L20;
            if (this.f3936a != r11.f3936a) goto L20;
            if (this.f3939d != r11.f3939d) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.f3937b), Long.valueOf(this.f3938c), Integer.valueOf(this.f3936a), Long.valueOf(this.f3939d)});
        }
    }

    static {
        f3930a = androidx.concurrent.futures.c.q();
        f3931b = new Object();
        f3932c = null;
    }

    public static long a(Context r10) {
        PackageManager r11 = r10.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return a.a(r11, r10).lastUpdateTime;
    L7:
        return r11.getPackageInfo(r10.getPackageName(), 0).lastUpdateTime;
    }

    public static CompilationStatus b(int r10, boolean r11, boolean r12) {
        CompilationStatus r13 = new CompilationStatus(r10, r11, r12);
        f3932c = r13;
        f3930a.o(r13);
        return f3932c;
    }

    public static CompilationStatus c(Context r18, boolean r19) {
        if (r19 == true) goto L6;
        CompilationStatus r10 = f3932c;
        if (r10 == null) goto L6;
        return r10;
    L6:
        Object r11 = f3931b;
        monitor-enter(r11);
        if (r19 == false) goto L84;
    L15:
        int r12 = 0;
        if (Build.VERSION.SDK_INT != 30) goto L20;
        CompilationStatus r13 = b(UiType.FLAG_TIMER_CARD, false, false);     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        return r13;
    L20:
        File r14 = new File(new File("/data/misc/profiles/ref/", r18.getPackageName()), "primary.prof");     // Catch: Throwable -> L13
        long r15 = r14.length();     // Catch: Throwable -> L13
        if (r14.exists() == true) goto L23;
    L25:
        boolean r16 = false;
    L26:
        File r17 = new File(new File("/data/misc/profiles/cur/0/", r18.getPackageName()), "primary.prof");     // Catch: Throwable -> L13
        long r110 = r17.length();     // Catch: Throwable -> L13
        if (r17.exists() == true) goto L29;
    L31:
        boolean r20 = false;
    L80:
        long r111 = a(r18);     // Catch: Throwable -> L13 PackageManager.NameNotFoundException -> L75
        File r21 = new File(r18.getFilesDir(), "profileInstalled");     // Catch: Throwable -> L13
        if (r21.exists() == true) goto L82;
        b r22 = null;
    L43:
        if (r22 != null) goto L45;
    L50:
        if (r16 == false) goto L52;
        r12 = 1;
    L54:
        if (r19 == false) goto L58;
        if (r20 == false) goto L58;
        if (r12 == 1) goto L58;
        r12 = 2;
    L58:
        if (r22 != null) goto L60;
    L65:
        b r23 = new b(1, r12, r111, r110);     // Catch: Throwable -> L13
        if (r22 != null) goto L68;
    L85:
        r23.b(r21);     // Catch: Throwable -> L13 IOException -> L71
    L72:
        CompilationStatus r24 = b(r12, r16, r20);     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        return r24;
    L71:
        r12 = 196608;
        goto L72
    L68:
        if (r22.equals(r23) == true) goto L72;
    L60:
        if (r22.f3937b != 2) goto L65;
        if (r12 != 1) goto L65;
        if (r15 >= r22.f3939d) goto L65;
        r12 = 3;
        goto L65
    L52:
        if (r20 == false) goto L54;
        r12 = 2;
        goto L54
    L45:
        if (r22.f3938c != r111) goto L50;
        int r112 = r22.f3937b;     // Catch: Throwable -> L13
        if (r112 == 2) goto L50;
        r12 = r112;
        goto L54
    L82:
        r22 = b.a(r21);     // Catch: Throwable -> L13 IOException -> L37
    L40:
        return b(UiType.FLAG_PHONE_CARD, r16, r20);
    L13:
        th = move-exception;
        throw th;
    L77:
        return b(65536, r16, r20);
    L29:
        if (r110 <= 0) goto L31;
        r20 = true;
        goto L80
    L23:
        if (r15 <= 0) goto L25;
        r16 = true;
        goto L26
    L84:
        CompilationStatus r25 = f3932c;     // Catch: Throwable -> L13
        if (r25 == null) goto L15;
        monitor-exit(r11);     // Catch: Throwable -> L13
        return r25;
    }
}
