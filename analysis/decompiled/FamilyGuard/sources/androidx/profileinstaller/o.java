package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.concurrent.futures.b<c> f11316a = androidx.concurrent.futures.b.q();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f11317b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static c f11318c = null;

    private static class a {
        static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int f11319a;

        /* renamed from: b, reason: collision with root package name */
        final int f11320b;

        /* renamed from: c, reason: collision with root package name */
        final long f11321c;

        /* renamed from: d, reason: collision with root package name */
        final long f11322d;

        b(int i5, int i6, long j5, long j6) {
            this.f11319a = i5;
            this.f11320b = i6;
            this.f11321c = j5;
            this.f11322d = j6;
        }

        static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } finally {
            }
        }

        void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f11319a);
                dataOutputStream.writeInt(this.f11320b);
                dataOutputStream.writeLong(this.f11321c);
                dataOutputStream.writeLong(this.f11322d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                if (this.f11320b == bVar.f11320b && this.f11321c == bVar.f11321c && this.f11319a == bVar.f11319a && this.f11322d == bVar.f11322d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f11320b), Long.valueOf(this.f11321c), Integer.valueOf(this.f11319a), Long.valueOf(this.f11322d));
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final int f11323a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f11324b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f11325c;

        c(int i5, boolean z5, boolean z6) {
            this.f11323a = i5;
            this.f11325c = z6;
            this.f11324b = z5;
        }
    }

    private static long a(Context context) {
        return a.a(context.getApplicationContext().getPackageManager(), context).lastUpdateTime;
    }

    private static c b(int i5, boolean z5, boolean z6) {
        c cVar = new c(i5, z5, z6);
        f11318c = cVar;
        f11316a.o(cVar);
        return f11318c;
    }

    static c c(Context context, boolean z5) {
        b bVarA;
        int i5;
        c cVar;
        if (!z5 && (cVar = f11318c) != null) {
            return cVar;
        }
        synchronized (f11317b) {
            if (!z5) {
                try {
                    c cVar2 = f11318c;
                    if (cVar2 != null) {
                        return cVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
            long length = file.length();
            int i6 = 0;
            boolean z6 = file.exists() && length > 0;
            File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
            long length2 = file2.length();
            boolean z7 = file2.exists() && length2 > 0;
            try {
                long jA = a(context);
                File file3 = new File(context.getFilesDir(), "profileInstalled");
                if (file3.exists()) {
                    try {
                        bVarA = b.a(file3);
                    } catch (IOException unused) {
                        return b(131072, z6, z7);
                    }
                } else {
                    bVarA = null;
                }
                if (bVarA != null && bVarA.f11321c == jA && (i5 = bVarA.f11320b) != 2) {
                    i6 = i5;
                } else if (z6) {
                    i6 = 1;
                } else if (z7) {
                    i6 = 2;
                }
                if (z5 && z7 && i6 != 1) {
                    i6 = 2;
                }
                if (bVarA != null && bVarA.f11320b == 2 && i6 == 1 && length < bVarA.f11322d) {
                    i6 = 3;
                }
                int i7 = i6;
                b bVar = new b(1, i7, jA, length2);
                if (bVarA == null || !bVarA.equals(bVar)) {
                    try {
                        bVar.b(file3);
                    } catch (IOException unused2) {
                        i7 = 196608;
                    }
                }
                return b(i7, z6, z7);
            } catch (PackageManager.NameNotFoundException unused3) {
                return b(65536, z6, z7);
            }
        }
    }
}
