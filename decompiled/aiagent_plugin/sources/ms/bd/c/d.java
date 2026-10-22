package ms.bd.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements g1.a {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ZipFile f39470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ZipEntry f39471b;

        public a(ZipFile r1, ZipEntry r2) {
            this.f39470a = r1;
            this.f39471b = r2;
        }
    }

    public d() {
    }

    private static a a(Context r16, String[] r17, String r18, i1 r19) {
        ApplicationInfo r1 = ((Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin")).getApplicationInfo();
        int r3 = 0;
        if (Build.VERSION.SDK_INT < 21) goto L9;
        String[] r2 = r1.splitSourceDirs;
        if (r2 == null) goto L9;
        if (r2.length == 0) goto L9;
        String[] r5 = new String[r2.length + 1];
        r5[0] = r1.sourceDir;
        System.arraycopy(r2, 0, r5, 1, r2.length);
    L10:
        int r4 = r5.length;
        int r6 = 0;
    L11:
        ZipFile r7 = null;
        if (r6 >= r4) goto L35;
        String r8 = r5[r6];
        int r9 = r3;
    L14:
        int r10 = r9 + 1;
        if (r9 >= 5) goto L19;
        r7 = new ZipFile(new File(r8), 1);     // Catch: IOException -> L18
    L18:
        r9 = r10;
    L19:
        if (r7 == null) goto L34;
        int r11 = r3;
    L22:
        int r12 = r11 + 1;
        if (r11 >= 5) goto L37;
        int r13 = r17.length;
        int r14 = r3;
    L25:
        if (r14 >= r13) goto L31;
        String r15 = "lib" + File.separatorChar + r17[r14] + File.separatorChar + r18;
        Object[] r110 = new Object[2];
        r110[r3] = r15;
        r110[1] = r8;
        r19.getClass();
        String.format(Locale.US, "Looking for %s in APK %s...", r110);
        ZipEntry r20 = r7.getEntry(r15);
        if (r20 != null) goto L29;
        r14 = r14 + 1;
        r3 = 0;
        goto L25
    L29:
        return new a(r7, r20);
    L31:
        r11 = r12;
        goto L22
    L37:
        r7.close();     // Catch: IOException -> L36
    L34:
        r6 = r6 + 1;
        r3 = 0;
        goto L11
    L35:
        return null;
    L9:
        r5 = new String[]{r1.sourceDir};
        goto L10
    }

    private static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    private static String[] a(Context r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        Pattern r12 = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + r10);
        HashSet r0 = new HashSet();
        ApplicationInfo r13 = r11.getApplicationInfo();
        int r3 = 0;
        if (Build.VERSION.SDK_INT < 21) goto L9;
        String[] r2 = r13.splitSourceDirs;
        if (r2 == null) goto L9;
        if (r2.length == 0) goto L9;
        String[] r5 = new String[r2.length + 1];
        r5[0] = r13.sourceDir;
        System.arraycopy(r2, 0, r5, 1, r2.length);
    L10:
        int r14 = r5.length;
        ZipFile r4 = null;
    L11:
        if (r3 >= r14) goto L22;
        ZipFile r7 = new ZipFile(new File(r5[r3]), 1);     // Catch: IOException -> L26
        Enumeration<? extends ZipEntry> r6 = r7.entries();
    L16:
        if (r6.hasMoreElements() == false) goto L20;
        Matcher r8 = r12.matcher(((ZipEntry) ZeusTransformUtils.preCheckCast(r6.nextElement(), ZipEntry.class, "com.obric.aiagent.plugin")).getName());
        if (r8.matches() == false) goto L16;
        r0.add(r8.group(1));
        goto L16
    L20:
        r4 = r7;
    L21:
        r3 = r3 + 1;
        goto L11
    L22:
        if (r4 == null) goto L25;
        r4.close();     // Catch: IOException -> L27
    L25:
        return (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[r0.size()]), String[].class, "com.obric.aiagent.plugin");
    L9:
        r5 = new String[]{r13.sourceDir};
        goto L10
    }

    public final void a(Context r10, String[] r11, String r12, File r13, i1 r14) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        a r15 = null;
        a r0 = a(r9, r11, r12, r14);     // Catch: Throwable -> L58
        if (r0 == null) goto L76;
        int r16 = 0;
    L7:
        int r17 = r16 + 1;
        if (r16 >= 5) goto L45;
        r14.getClass();     // Catch: Throwable -> L52
        String.format(Locale.US, "Found %s! Extracting...", new Object[]{r12});     // Catch: Throwable -> L52
        if (r13.exists() == true) goto L87;
        if (r13.createNewFile() == false) goto L44;
    L87:
        InputStream r18 = r0.f39470a.getInputStream(r0.f39471b);     // Catch: Throwable -> L36 Throwable -> L41
        FileOutputStream r3 = new FileOutputStream(r13);     // Catch: Throwable -> L34 Throwable -> L66
        long r4 = 0;
        byte[] r6 = new byte[4096];     // Catch: Throwable -> L32 Throwable -> L65
    L19:
        int r7 = r18.read(r6);     // Catch: Throwable -> L32 Throwable -> L65
        if (r7 == (-1)) goto L21;
        r3.write(r6, 0, r7);     // Catch: Throwable -> L32 Throwable -> L65 Throwable -> L65
        r4 = r4 + ((long) r7);
        goto L19
    L21:
        r3.flush();     // Catch: Throwable -> L32 Throwable -> L65
        r3.getFD().sync();     // Catch: Throwable -> L32 Throwable -> L65
        if (r4 == r13.length()) goto L25;
        a(r18);     // Catch: Throwable -> L52
        a(r3);     // Catch: Throwable -> L52
        goto L44
    L25:
        a(r18);     // Catch: Throwable -> L52
        a(r3);     // Catch: Throwable -> L52
        r13.setReadable(true, false);     // Catch: Throwable -> L52
        r13.setExecutable(true, false);     // Catch: Throwable -> L52
        r13.setWritable(true);     // Catch: Throwable -> L52
        ZipFile r19 = r0.f39470a;     // Catch: IOException -> L64
        if (r19 == null) goto L95;
        r19.close();     // Catch: IOException -> L64
        return;
    L95:
        return;
    L96:
        return;
    L32:
        Throwable th = th;
    L39:
        a(r18);     // Catch: Throwable -> L52
        a(r3);     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L43:
        a(r18);     // Catch: Throwable -> L52
        a(r3);     // Catch: Throwable -> L52
        goto L44
    L34:
        Throwable th2 = th;
    L38:
        r3 = null;
        th = th2;
    L42:
        r3 = null;
        goto L43
    L41:
        r18 = null;
    L36:
        th = move-exception;
        th2 = th;
        r18 = null;
    L44:
        r16 = r17;
        goto L7
    L45:
        r14.getClass();     // Catch: Throwable -> L52
        ZipFile r20 = r0.f39470a;     // Catch: IOException -> L68
        if (r20 == null) goto L97;
        r20.close();     // Catch: IOException -> L68
        return;
    L97:
        return;
    L98:
        return;
    L76:
        String[] r21 = a(r9, r12);     // Catch: Throwable -> L52 Exception -> L54
    L57:
        throw new x0(r12, r11, r21);     // Catch: Throwable -> L52
    L54:
        e = move-exception;
        r21 = new String[]{e.toString()};     // Catch: Throwable -> L52
    L52:
        th = th;
        r15 = r0;
    L59:
        if (r15 != null) goto L74;
    L63:
        throw th;
    L74:
        ZipFile r110 = r15.f39470a;     // Catch: IOException -> L69
        if (r110 == null) goto L63;
        r110.close();     // Catch: IOException -> L69
    L58:
        th = th;
        goto L59
    }
}
