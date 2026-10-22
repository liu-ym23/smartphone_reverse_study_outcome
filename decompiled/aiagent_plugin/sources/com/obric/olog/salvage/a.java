package com.obric.olog.salvage;

import android.content.Context;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LogFileCompressor.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f33925a = null;

    public a() {
    }

    static {
        f33925a = Logger.getLogger(a.class.getName());
    }

    public static void a(Context r17, String[] r18, String r19) {
        String[] r0 = r18;
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        String r3 = r0[r0.length - 1].trim().toLowerCase();
        if (r3.equals("true") == false) goto L5;
    L8:
        r0 = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r0, 0, r0.length - 1), String[].class, "com.obric.aiagent.plugin");
        boolean r2 = r3.equals("true");
        a("zhoupeng.725", "解析控制参数：isIncludeSensitive=" + r2);
    L9:
        File r4 = new File(r1.getFilesDir(), r19);
        if (r4.exists() == false) goto L58;
        r4.delete();
    L58:
        FileOutputStream r5 = new FileOutputStream(r4);     // Catch: Exception -> L50
        ZipOutputStream r6 = new ZipOutputStream(r5);     // Catch: Throwable -> L42
        int r7 = r0.length;     // Catch: Throwable -> L34
        int r15 = 0;
        boolean r16 = false;
    L15:
        if (r15 >= r7) goto L29;
        String r9 = r0[r15];     // Catch: Throwable -> L34
        File r10 = new File(r9);     // Catch: Throwable -> L34
        if (r10.exists() == true) goto L19;
    L27:
        f33925a.log(Level.SEVERE, "Source directory {0} does not exist or is not a directory.", r9);     // Catch: Throwable -> L34
    L28:
        r15 = r15 + 1;     // Catch: Throwable -> L34
        goto L15
    L19:
        if (r10.isDirectory() == false) goto L27;
        if (a(r10, r10.getName(), r6, r4, r10.getAbsolutePath().replaceAll("/", "_"), r2) == true) goto L26;
        if (r16 == true) goto L26;
        r16 = false;
    L26:
        r16 = true;
        goto L28
    L29:
        if (r16 == true) goto L31;
        a("zhoupeng.725", "atLeastOneFileAdded为false，空目录。添加一个empty_logs保证zip文件正常");     // Catch: Throwable -> L34
        r6.putNextEntry(new ZipEntry("empty_logs/"));     // Catch: Throwable -> L34
        r6.closeEntry();     // Catch: Throwable -> L34
    L31:
        r6.close();     // Catch: Throwable -> L42
        r5.close();     // Catch: Exception -> L50
        return;
    L34:
        th = move-exception;
        r6.close();     // Catch: Throwable -> L38
    L65:
        throw th;     // Catch: Throwable -> L42
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L46
    L66:
        throw th;     // Catch: Exception -> L50
    L46:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L50
        throw th;     // Catch: Exception -> L50
    L50:
        e = move-exception;
        f33925a.log(Level.SEVERE, "Error compressing files to {0}: {1}", new Object[]{r4.getAbsolutePath(), e.getMessage()});
        throw e;
    L5:
        if (r3.equals("false") == true) goto L8;
        r2 = false;
        goto L9
    }

    private static boolean a(File r15, String r16, ZipOutputStream r17, File r18, String r19, boolean r20) {
        File[] r9 = r15.listFiles();
        if (r9 == null) goto L57;
        int r11 = r9.length;
        int r12 = 0;
        boolean r13 = false;
    L5:
        if (r12 >= r11) goto L41;
        File r2 = r9[r12];
        if (r2.equals(r18) == true) goto L39;
        if (r20 == true) goto L16;
        if (r2.getName().contains("SensitiveContent") == false) goto L16;
        a("zhoupeng.725", "Skipping sensitive file: " + r2.getAbsolutePath());
    L16:
        if (r2.isDirectory() == false) goto L18;
        r13 = r13 | a(r2, r16 + "/" + r2.getName(), r17, r18, r19, r20);
        goto L39
    L18:
        String r0 = r19 + "/" + r16 + "/" + r2.getName();
        a("zhoupeng.725", "entryName:" + r0);
        FileInputStream r5 = new FileInputStream(r2);     // Catch: Exception -> L37
        r17.putNextEntry(new ZipEntry(r0));     // Catch: Throwable -> L29
        byte[] r1 = new byte[8192];     // Catch: Throwable -> L29
    L21:
        int r7 = r5.read(r1);     // Catch: Throwable -> L29
        if (r7 < 0) goto L24;
        r17.write(r1, 0, r7);     // Catch: Throwable -> L29
        goto L21
    L24:
        r17.closeEntry();     // Catch: Throwable -> L29
        r5.close();     // Catch: Exception -> L27
        r13 = true;
    L27:
        e = e;
        r13 = true;
    L38:
        a("zhoupeng.725", "压缩文件失败，将跳过该文件: " + r2.getAbsolutePath(), e);
        goto L39
    L29:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L33
    L36:
        throw th;     // Catch: Exception -> L37
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L37
    L37:
        e = e;
    L39:
        r12 = r12 + 1;
        goto L5
    L41:
        return r13;
    L57:
        return false;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
