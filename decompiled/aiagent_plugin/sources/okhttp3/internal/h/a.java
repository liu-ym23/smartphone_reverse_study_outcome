package okhttp3.internal.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import e.aa;
import e.y;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: FileSystem.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1081a f40088a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f40089b = null;

    /* JADX INFO: renamed from: okhttp3.internal.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FileSystem.kt */
    public static final class C1081a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C1081a f40090a = null;

        /* JADX INFO: renamed from: okhttp3.internal.h.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FileSystem.kt */
        private static final class C1082a implements a {
            public String toString() {
                return "FileSystem.SYSTEM";
            }

            public C1082a() {
            }

            @Override // okhttp3.internal.h.a
            public aa a(File r1) {
                o.e(r1, "file");
                return e.o.b(r1);
            }

            @Override // okhttp3.internal.h.a
            public y b(File r4) {
                o.e(r4, "file");
                return e.o.a(r4, false, 1, null);
            L5:
                r4.getParentFile().mkdirs();
                return e.o.a(r4, false, 1, null);
            }

            @Override // okhttp3.internal.h.a
            public y c(File r1) {
                o.e(r1, "file");
                return e.o.a(r1);
            L5:
                r1.getParentFile().mkdirs();
                return e.o.a(r1);
            }

            @Override // okhttp3.internal.h.a
            public void delete(File r3) {
                o.e(r3, "file");
                if (r3.delete() == false) goto L5;
                return;
            L5:
                if (r3.exists() == true) goto L8;
                return;
            L8:
                throw new IOException("failed to delete " + r3);
            }

            @Override // okhttp3.internal.h.a
            public boolean d(File r1) {
                o.e(r1, "file");
                return r1.exists();
            }

            @Override // okhttp3.internal.h.a
            public long e(File r1) {
                o.e(r1, "file");
                return r1.length();
            }

            @Override // okhttp3.internal.h.a
            public void a(File r3, File r4) {
                o.e(r3, "from");
                o.e(r4, "to");
                delete(r4);
                if (r3.renameTo(r4) == false) goto L6;
                return;
            L6:
                throw new IOException("failed to rename " + r3 + " to " + r4);
            }

            @Override // okhttp3.internal.h.a
            public void f(File r5) {
                o.e(r5, "directory");
                File[] r0 = r5.listFiles();
                if (r0 == null) goto L16;
                int r6 = 0;
                int r1 = r0.length;
            L5:
                if (r6 >= r1) goto L14;
                File r2 = r0[r6];
                if (r2.isDirectory() == false) goto L10;
                o.c(r2, "file");
                f(r2);
            L10:
                if (r2.delete() == false) goto L13;
                r6 = r6 + 1;
                goto L5
            L13:
                throw new IOException("failed to delete " + r2);
            L14:
                return;
            L16:
                throw new IOException("not a readable directory: " + r5);
            }
        }

        static {
            f40090a = new C1081a();
        }

        private C1081a() {
        }
    }

    aa a(File r1);

    void a(File r1, File r2);

    y b(File r1);

    y c(File r1);

    boolean d(File r1);

    void delete(File r1);

    long e(File r1);

    void f(File r1);

    static {
        f40088a = C1081a.f40090a;
        f40089b = (a) ZeusTransformUtils.preCheckCast(new C1081a.C1082a(), a.class, "com.obric.aiagent.plugin");
    }
}
