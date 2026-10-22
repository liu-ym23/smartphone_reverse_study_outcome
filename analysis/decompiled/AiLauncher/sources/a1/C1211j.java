package a1;

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
import k0.C4797a;

/* renamed from: a1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1211j {

    /* renamed from: a, reason: collision with root package name */
    public static final C4797a<c> f7850a = C4797a.s();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f7851b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static c f7852c = null;

    /* renamed from: a1.j$a */
    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* renamed from: a1.j$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f7853a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7854b;

        /* renamed from: c, reason: collision with root package name */
        public final long f7855c;

        /* renamed from: d, reason: collision with root package name */
        public final long f7856d;

        public b(int i10, int i11, long j10, long j11) {
            this.f7853a = i10;
            this.f7854b = i11;
            this.f7855c = j10;
            this.f7856d = j11;
        }

        public static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } finally {
            }
        }

        public void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f7853a);
                dataOutputStream.writeInt(this.f7854b);
                dataOutputStream.writeLong(this.f7855c);
                dataOutputStream.writeLong(this.f7856d);
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
                if (this.f7854b == bVar.f7854b && this.f7855c == bVar.f7855c && this.f7853a == bVar.f7853a && this.f7856d == bVar.f7856d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f7854b), Long.valueOf(this.f7855c), Integer.valueOf(this.f7853a), Long.valueOf(this.f7856d));
        }
    }

    /* renamed from: a1.j$c */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f7857a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f7858b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f7859c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f7860d;

        public c(int i10, boolean z10, boolean z11, boolean z12) {
            this.f7857a = i10;
            this.f7859c = z11;
            this.f7858b = z10;
            this.f7860d = z12;
        }
    }

    public static long a(Context context) throws PackageManager.NameNotFoundException {
        return a.a(context.getApplicationContext().getPackageManager(), context).lastUpdateTime;
    }

    public static c b(int i10, boolean z10, boolean z11, boolean z12) {
        c cVar = new c(i10, z10, z11, z12);
        f7852c = cVar;
        f7850a.p(cVar);
        return f7852c;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a1.C1211j.c c(android.content.Context r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.C1211j.c(android.content.Context, boolean):a1.j$c");
    }
}
