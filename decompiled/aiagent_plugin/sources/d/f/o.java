package d.f;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
class o extends n {

    /* JADX INFO: compiled from: Utils.kt */
    static final class a extends d.h.b.p implements d.h.a.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38466a = null;

        static {
            f38466a = new a();
        }

        a() {
            super(2);
        }

        public final Void a(File r1, IOException r2) {
            d.h.b.o.e(r1, "<anonymous parameter 0>");
            d.h.b.o.e(r2, "exception");
            throw r2;
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Object r3, Object r4) {
            return a((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin"), (IOException) ZeusTransformUtils.preCheckCast(r4, IOException.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Utils.kt */
    static final class b extends d.h.b.p implements d.h.a.m<File, IOException, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.m<File, IOException, r> f38467a;

        b(d.h.a.m<? super File, ? super IOException, ? extends r> r3) {
            this.f38467a = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
            super(2);
        }

        public final void a(File r2, IOException r3) {
            d.h.b.o.e(r2, com.bytedance.apm.util.f.f4978a);
            d.h.b.o.e(r3, "e");
            if (this.f38467a.invoke(r2, r3) == r.f38473b) goto L6;
            return;
        L6:
            throw new s(r2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(File r3, IOException r4) {
            a((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.aiagent.plugin"), (IOException) ZeusTransformUtils.preCheckCast(r4, IOException.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final String f(File r2) {
        d.h.b.o.e(r2, "<this>");
        String r3 = r2.getName();
        d.h.b.o.c(r3, "getName(...)");
        return d.o.o.d(r3, '.', "");
    }

    public static final String g(File r9) {
        d.h.b.o.e(r9, "<this>");
        if (File.separatorChar == '/') goto L5;
        String r3 = r9.getPath();
        d.h.b.o.c(r3, "getPath(...)");
        return d.o.o.a(r3, File.separatorChar, '/', false, 4, null);
    L5:
        String r10 = r9.getPath();
        d.h.b.o.c(r10, "getPath(...)");
        return r10;
    }

    public static final String a(File r3, File r4) {
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r4, "base");
        String r0 = d(r3, r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("this and base files have different roots: " + r3 + " and " + r4 + '.');
    }

    public static final File b(File r1, File r2) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "base");
        return new File(k.a(r1, r2));
    }

    private static final String d(File r19, File r20) {
        g r0 = a(k.b(r19));
        g r1 = a(k.b(r20));
        if (d.h.b.o.a(r0.a(), r1.a()) == true) goto L5;
        return null;
    L5:
        int r2 = r1.c();
        int r4 = r0.c();
        int r5 = 0;
        int r6 = Math.min(r4, r2);
    L6:
        if (r5 >= r6) goto L10;
        if (d.h.b.o.a(r0.b().get(r5), r1.b().get(r5)) == false) goto L10;
        r5 = r5 + 1;
    L10:
        StringBuilder r7 = new StringBuilder();
        int r8 = r2 - 1;
        if (r5 <= r8) goto L13;
    L20:
        if (r5 >= r4) goto L25;
        if (r5 >= r2) goto L23;
        r7.append(File.separatorChar);
    L23:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast(r0.b(), Iterable.class, "com.obric.aiagent.plugin"), r5), Iterable.class, "com.obric.aiagent.plugin");
        Appendable r10 = (Appendable) ZeusTransformUtils.preCheckCast(r7, Appendable.class, "com.obric.aiagent.plugin");
        String r3 = File.separator;
        d.h.b.o.c(r3, "separator");
        d.a.p.a(r9, r10, (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, BDImageUploader.MessageIsPreHeatResultUsed, null);
    L25:
        return r7.toString();
    L13:
        if (d.h.b.o.a(((File) ZeusTransformUtils.preCheckCast(r1.b().get(r8), File.class, "com.obric.aiagent.plugin")).getName(), DownloadConstants.VULNERABILITY_PATH) == true) goto L14;
        r7.append(DownloadConstants.VULNERABILITY_PATH);
        if (r8 == r5) goto L18;
        r7.append(File.separatorChar);
    L18:
        if (r8 == r5) goto L20;
        r8 = r8 - 1;
        goto L13
    L14:
        return null;
    }

    public static /* synthetic */ File a(File r0, File r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = 8192;
    L9:
        return k.a(r0, r1, r2, r3);
    }

    public static final File a(File r6, File r7, boolean r8, int r9) {
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r7, "target");
        if (r6.exists() == false) goto L42;
        if (r7.exists() == false) goto L15;
        if (r8 == false) goto L13;
        if (r7.delete() == true) goto L15;
        throw new f(r6, r7, "Tried to overwrite the destination, but failed to delete it.");
    L13:
        throw new f(r6, r7, "The destination file already exists.");
    L15:
        if (r6.isDirectory() == true) goto L17;
        File r10 = r7.getParentFile();
        if (r10 == null) goto L24;
        r10.mkdirs();
    L24:
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r6), Closeable.class, "com.obric.aiagent.plugin");
        FileInputStream r12 = (FileInputStream) ZeusTransformUtils.preCheckCast(r11, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r7), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        FileOutputStream r2 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r1, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        d.f.b.a((InputStream) ZeusTransformUtils.preCheckCast(r12, InputStream.class, "com.obric.aiagent.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r2, OutputStream.class, "com.obric.aiagent.plugin"), r9);     // Catch: Throwable -> L31
    L28:
        c.a(r1, null);     // Catch: Throwable -> L36
        c.a(r11, null);
    L30:
        return r7;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        c.a(r1, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        c.a(r11, th);
        throw th;
    L17:
        if (r7.mkdirs() == true) goto L30;
        throw new h(r6, r7, "Failed to create target directory.");
    L42:
        throw new q(r6, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ boolean a(File r1, File r2, boolean r3, d.h.a.m r4, int r5, Object r6) {
        d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = (d.h.a.m) ZeusTransformUtils.preCheckCast(a.f38466a, d.h.a.m.class, "com.obric.aiagent.plugin");
    L9:
        return k.a(r1, r2, r3, r7);
    }

    public static final boolean a(File r12, File r13, boolean r14, d.h.a.m<? super File, ? super IOException, ? extends r> r15) {
        d.h.a.m r16 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "<this>");
        d.h.b.o.e(r13, "target");
        d.h.b.o.e(r16, "onError");
        if (r12.exists() == false) goto L5;
        Iterator<File> r0 = k.d(r12).a((d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r16), d.h.a.m.class, "com.obric.aiagent.plugin")).a();     // Catch: s -> L47
    L10:
        if (r0.hasNext() == false) goto L46;
        File r4 = (File) ZeusTransformUtils.preCheckCast(r0.next(), File.class, "com.obric.aiagent.plugin");     // Catch: s -> L47
        if (r4.exists() == false) goto L15;
        File r6 = new File(r13, k.a(r4, r12));     // Catch: s -> L47
        if (r6.exists() == false) goto L39;
        if (r4.isDirectory() == true) goto L22;
    L23:
        if (r14 == true) goto L26;
    L24:
        boolean r5 = true;
    L34:
        if (r5 == false) goto L39;
        if (r16.invoke(r6, new f(r4, r6, "The destination file already exists.")) != r.f38473b) goto L10;
        return false;
    L26:
        if (r6.isDirectory() == false) goto L31;
        if (k.h(r6) == false) goto L24;
    L33:
        r5 = false;
        goto L34
    L31:
        if (r6.delete() == true) goto L33;
    L22:
        if (r6.isDirectory() == false) goto L23;
    L39:
        if (r4.isDirectory() == true) goto L40;
        if (k.a(r4, r6, r14, 0, 4, null).length() == r4.length()) goto L10;
        if (r16.invoke(r4, new IOException("Source file wasn't copied completely, length of destination file differs.")) != r.f38473b) goto L10;
        return false;
    L40:
        r6.mkdirs();     // Catch: s -> L47
        goto L10
    L15:
        if (r16.invoke(r4, new q(r4, null, "The source file doesn't exist.", 2, null)) != r.f38473b) goto L10;
        return false;
    L46:
        return true;
    L47:
        return false;
    L5:
        if (r16.invoke(r12, new q(r12, null, "The source file doesn't exist.", 2, null)) == r.f38473b) goto L8;
        return true;
    L8:
        return false;
    }

    public static final boolean h(File r5) {
        d.h.b.o.e(r5, "<this>");
        Iterator r6 = ((d.n.j) ZeusTransformUtils.preCheckCast(k.e(r5), d.n.j.class, "com.obric.aiagent.plugin")).a();
    L3:
        boolean r2 = true;
    L5:
        if (r6.hasNext() == false) goto L13;
        File r3 = (File) ZeusTransformUtils.preCheckCast(r6.next(), File.class, "com.obric.aiagent.plugin");
        if (r3.delete() == true) goto L10;
        if (r3.exists() == false) goto L10;
    L12:
        r2 = false;
    L10:
        if (r2 == false) goto L12;
    L13:
        return r2;
    }

    private static final g a(g r2) {
        return new g(r2.a(), a(r2.b()));
    }

    private static final List<File> a(List<? extends File> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List<File> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(r7.size()), List.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L16;
        File r2 = (File) ZeusTransformUtils.preCheckCast(r8.next(), File.class, "com.obric.aiagent.plugin");
        String r3 = r2.getName();
        if (d.h.b.o.a(r3, ".") == true) goto L4;
        if (d.h.b.o.a(r3, DownloadConstants.VULNERABILITY_PATH) == true) goto L10;
        r0.add(r2);
        goto L4
    L10:
        if (r0.isEmpty() == true) goto L14;
        if (d.h.b.o.a(((File) ZeusTransformUtils.preCheckCast(d.a.p.m(r0), File.class, "com.obric.aiagent.plugin")).getName(), DownloadConstants.VULNERABILITY_PATH) == true) goto L14;
        r0.remove(r0.size() - 1);
    L14:
        r0.add(r2);
        goto L4
    L16:
        return r0;
    }

    public static final File c(File r5, File r6) {
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "relative");
        if (k.a(r6) == false) goto L5;
        return r6;
    L5:
        String r7 = r5.toString();
        d.h.b.o.c(r7, "toString(...)");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L15;
        if (d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), File.separatorChar, false, 2, null) == true) goto L15;
        return new File(r7 + File.separatorChar + r6);
    L15:
        return new File(r7 + r6);
    L8:
        r0 = false;
        goto L9
    }

    public static final File a(File r1, String r2) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "relative");
        return k.c(r1, new File(r2));
    }
}
