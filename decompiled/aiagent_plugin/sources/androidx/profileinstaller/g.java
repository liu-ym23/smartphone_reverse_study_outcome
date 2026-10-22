package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ProfileVerifier.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    private static final String TAG = "ProfileVerifier";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final androidx.c.a.b<c> f2259a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f2260b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f2261c;

    /* JADX INFO: compiled from: ProfileVerifier.java */
    private static class a {
        static PackageInfo a(PackageManager r2, Context r3) {
            return r2.getPackageInfo(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    /* JADX INFO: compiled from: ProfileVerifier.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f2262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f2263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f2264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f2265d;

        b(int r1, int r2, long r3, long r5) {
            this.f2262a = r1;
            this.f2263b = r2;
            this.f2264c = r3;
            this.f2265d = r5;
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 != null) goto L8;
        L21:
            return false;
        L8:
            if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L21;
            b r9 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin");
            if (this.f2263b != r9.f2263b) goto L20;
            if (this.f2264c != r9.f2264c) goto L20;
            if (this.f2262a != r9.f2262a) goto L20;
            if (this.f2265d != r9.f2265d) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.f2263b), Long.valueOf(this.f2264c), Integer.valueOf(this.f2262a), Long.valueOf(this.f2265d)});
        }

        void a(File r4) {
            r4.delete();
            DataOutputStream r0 = new DataOutputStream(new FileOutputStream(r4));
            r0.writeInt(this.f2262a);     // Catch: Throwable -> L6
            r0.writeInt(this.f2263b);     // Catch: Throwable -> L6
            r0.writeLong(this.f2264c);     // Catch: Throwable -> L6
            r0.writeLong(this.f2265d);     // Catch: Throwable -> L6
            r0.close();
            return;
        L6:
            th = move-exception;
            r0.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }

        static b b(File r9) {
            DataInputStream r0 = new DataInputStream(new FileInputStream(r9));
            b r10 = new b(r0.readInt(), r0.readInt(), r0.readLong(), r0.readLong());     // Catch: Throwable -> L6
            r0.close();
            return r10;
        L6:
            th = move-exception;
            r0.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }
    }

    /* JADX INFO: compiled from: ProfileVerifier.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f2266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f2267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f2268c;

        c(int r1, boolean r2, boolean r3) {
            this.f2266a = r1;
            this.f2268c = r3;
            this.f2267b = r2;
        }
    }

    static {
        f2259a = androidx.c.a.b.d();
        f2260b = new Object();
        f2261c = null;
    }

    static c a(Context r19, boolean r20) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        if (r20 == true) goto L7;
        c r1 = f2261c;
        if (r1 == null) goto L7;
        return r1;
    L7:
        Object r2 = f2260b;
        monitor-enter(r2);
        if (r20 == false) goto L82;
    L14:
        int r4 = 0;
        if (Build.VERSION.SDK_INT >= 28) goto L17;
    L76:
        c r3 = a(262144, false, false);     // Catch: Throwable -> L79
        monitor-exit(r2);     // Catch: Throwable -> L79
        return r3;
    L17:
        if (Build.VERSION.SDK_INT == 30) goto L76;
        File r5 = new File(new File("/data/misc/profiles/ref/", r0.getPackageName()), "primary.prof");     // Catch: Throwable -> L79
        long r6 = r5.length();     // Catch: Throwable -> L79
        if (r5.exists() == true) goto L22;
    L24:
        boolean r7 = false;
    L25:
        File r9 = new File(new File("/data/misc/profiles/cur/0/", r0.getPackageName()), "primary.prof");     // Catch: Throwable -> L79
        long r17 = r9.length();     // Catch: Throwable -> L79
        if (r9.exists() == true) goto L28;
    L30:
        boolean r8 = false;
    L83:
        long r15 = a(r0);     // Catch: PackageManager.NameNotFoundException -> L73 Throwable -> L79
        File r10 = new File(r0.getFilesDir(), "profileInstalled");     // Catch: Throwable -> L79
        b r11 = null;
        if (r10.exists() == false) goto L41;
        r11 = b.b(r10);     // Catch: IOException -> L36 Throwable -> L79
    L39:
        return a(UiType.FLAG_PHONE_CARD, r7, r8);
    L41:
        if (r11 != null) goto L43;
    L48:
        if (r7 == false) goto L50;
        r4 = 1;
    L52:
        if (r20 == false) goto L56;
        if (r8 == false) goto L56;
        if (r4 == 1) goto L56;
        r4 = 2;
    L56:
        if (r11 != null) goto L58;
    L63:
        b r12 = new b(1, r4, r15, r17);     // Catch: Throwable -> L79
        if (r11 != null) goto L66;
    L87:
        r12.a(r10);     // Catch: IOException -> L69 Throwable -> L79
    L70:
        c r13 = a(r4, r7, r8);     // Catch: Throwable -> L79
        monitor-exit(r2);     // Catch: Throwable -> L79
        return r13;
    L69:
        r4 = 196608;
        goto L70
    L66:
        if (r11.equals(r12) == true) goto L70;
    L58:
        if (r11.f2263b != 2) goto L63;
        if (r4 != 1) goto L63;
        if (r6 >= r11.f2265d) goto L63;
        r4 = 3;
        goto L63
    L50:
        if (r8 == false) goto L52;
        r4 = 2;
        goto L52
    L43:
        if (r11.f2264c != r15) goto L48;
        if (r11.f2263b == 2) goto L48;
        r4 = r11.f2263b;     // Catch: Throwable -> L79
        goto L52
    L79:
        th = move-exception;
        throw th;
    L75:
        return a(65536, r7, r8);
    L28:
        if (r17 <= 0) goto L30;
        r8 = true;
        goto L83
    L22:
        if (r6 <= 0) goto L24;
        r7 = true;
        goto L25
    L82:
        c r14 = f2261c;     // Catch: Throwable -> L79
        if (r14 == null) goto L14;
        monitor-exit(r2);     // Catch: Throwable -> L79
        return r14;
    }

    private static c a(int r1, boolean r2, boolean r3) {
        c r0 = new c(r1, r2, r3);
        f2261c = r0;
        f2259a.a(r0);
        return f2261c;
    }

    private static long a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        PackageManager r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager();
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return a.a(r0, r4).lastUpdateTime;
    L7:
        return r0.getPackageInfo(r4.getPackageName(), 0).lastUpdateTime;
    }
}
