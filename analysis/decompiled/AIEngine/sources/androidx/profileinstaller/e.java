package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final d0.a<b> f2457a = new d0.a<>();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f2458b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static b f2459c = null;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f2460a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2461b;

        /* renamed from: c, reason: collision with root package name */
        public final long f2462c;

        /* renamed from: d, reason: collision with root package name */
        public final long f2463d;

        public a(long j10, int i10, int i11, long j11) {
            this.f2460a = i10;
            this.f2461b = i11;
            this.f2462c = j10;
            this.f2463d = j11;
        }

        public static a a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                a aVar = new a(dataInputStream.readLong(), dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong());
                dataInputStream.close();
                return aVar;
            } finally {
            }
        }

        public final void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f2460a);
                dataOutputStream.writeInt(this.f2461b);
                dataOutputStream.writeLong(this.f2462c);
                dataOutputStream.writeLong(this.f2463d);
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

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                if (this.f2461b == aVar.f2461b && this.f2462c == aVar.f2462c && this.f2460a == aVar.f2460a && this.f2463d == aVar.f2463d) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.f2461b), Long.valueOf(this.f2462c), Integer.valueOf(this.f2460a), Long.valueOf(this.f2463d));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {
    }

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L)).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static b b() {
        b bVar = new b();
        f2459c = bVar;
        f2457a.j(bVar);
        return f2459c;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0047 A[Catch: all -> 0x0013, TryCatch #2 {, blocks: (B:9:0x000d, B:11:0x0011, B:16:0x001a, B:22:0x002f, B:33:0x0041, B:35:0x0047, B:36:0x004a, B:38:0x004d, B:44:0x0070, B:50:0x0093, B:51:0x0097, B:53:0x00a8, B:61:0x00b6, B:63:0x00bc, B:78:0x00d8, B:81:0x00de, B:84:0x00e5, B:86:0x00ef, B:89:0x00f8, B:90:0x00fb, B:88:0x00f5, B:55:0x00ad, B:56:0x00b0, B:92:0x00fd, B:93:0x0100, B:31:0x003f, B:30:0x003c), top: B:102:0x000d, inners: #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x004d A[Catch: all -> 0x0013, TryCatch #2 {, blocks: (B:9:0x000d, B:11:0x0011, B:16:0x001a, B:22:0x002f, B:33:0x0041, B:35:0x0047, B:36:0x004a, B:38:0x004d, B:44:0x0070, B:50:0x0093, B:51:0x0097, B:53:0x00a8, B:61:0x00b6, B:63:0x00bc, B:78:0x00d8, B:81:0x00de, B:84:0x00e5, B:86:0x00ef, B:89:0x00f8, B:90:0x00fb, B:88:0x00f5, B:55:0x00ad, B:56:0x00b0, B:92:0x00fd, B:93:0x0100, B:31:0x003f, B:30:0x003c), top: B:102:0x000d, inners: #5, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(android.content.Context r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.e.c(android.content.Context, boolean):void");
    }
}
