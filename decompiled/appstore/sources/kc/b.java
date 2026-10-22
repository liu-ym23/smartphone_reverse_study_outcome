package kc;

import android.content.Context;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f21042a = null;

    static {
        f21042a = Logger.getLogger(b.class.getName());
    }

    public static boolean a(File r10, String r11, ZipOutputStream r12, File r13, String r14, boolean r15) {
        File[] r16 = r10.listFiles();
        if (r16 == null) goto L54;
        int r17 = r16.length;
        int r18 = 0;
        boolean r19 = false;
    L5:
        if (r18 >= r17) goto L39;
        File r20 = r16[r18];
        if (r20.equals(r13) == true) goto L37;
        if (r15 == true) goto L15;
        if (r20.getName().contains("SensitiveContent") == false) goto L15;
        Log.i("zhoupeng.725", "Skipping sensitive file: " + r20.getAbsolutePath());
    L15:
        if (r20.isDirectory() == false) goto L17;
        r19 = r19 | a(r20, r11 + LibrarianImpl.Constants.SEPARATOR + r20.getName(), r12, r13, r14, r15);
        goto L37
    L17:
        String r21 = r14 + LibrarianImpl.Constants.SEPARATOR + r11 + LibrarianImpl.Constants.SEPARATOR + r20.getName();
        Log.i("zhoupeng.725", "entryName:" + r21);
        FileInputStream r22 = new FileInputStream(r20);     // Catch: Exception -> L29
        r12.putNextEntry(new ZipEntry(r21));     // Catch: Throwable -> L23
        byte[] r23 = new byte[8192];     // Catch: Throwable -> L23
    L20:
        int r24 = r22.read(r23);     // Catch: Throwable -> L23
        if (r24 < 0) goto L25;
        r12.write(r23, 0, r24);     // Catch: Throwable -> L23
        goto L20
    L25:
        r12.closeEntry();     // Catch: Throwable -> L23
        r19 = true;
        r22.close();     // Catch: Exception -> L29
        goto L37
    L23:
        th = move-exception;
        r22.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: Exception -> L29
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Log.e("zhoupeng.725", "压缩文件失败，将跳过该文件: " + r20.getAbsolutePath(), e);
    L37:
        r18 = r18 + 1;
        goto L5
    L39:
        return r19;
    L54:
        return false;
    }

    public static void b(Context r17, String[] r18, String r19) {
        String[] r10 = r18;
        String r11 = r10[r10.length - 1].trim().toLowerCase();
        if (r11.equals("true") == false) goto L5;
    L8:
        r10 = (String[]) Arrays.copyOfRange(r10, 0, r10.length - 1);
        boolean r12 = r11.equals("true");
        Log.i("zhoupeng.725", "解析控制参数：isIncludeSensitive=" + r12);
    L9:
        File r13 = new File(r17.getFilesDir(), r19);
        if (r13.exists() == false) goto L58;
        r13.delete();
    L58:
        FileOutputStream r14 = new FileOutputStream(r13);     // Catch: Exception -> L36
        ZipOutputStream r15 = new ZipOutputStream(r14);     // Catch: Throwable -> L38
        int r16 = r10.length;     // Catch: Throwable -> L27
        int r110 = 0;
        boolean r111 = false;
    L15:
        if (r110 >= r16) goto L31;
        String r20 = r10[r110];     // Catch: Throwable -> L27
        File r21 = new File(r20);     // Catch: Throwable -> L27
        if (r21.exists() == true) goto L19;
    L29:
        f21042a.log(Level.SEVERE, "Source directory {0} does not exist or is not a directory.", r20);     // Catch: Throwable -> L27
    L30:
        r110 = r110 + 1;     // Catch: Throwable -> L27
        goto L15
    L19:
        if (r21.isDirectory() == false) goto L29;
        if (a(r21, r21.getName(), r15, r13, r21.getAbsolutePath().replaceAll(LibrarianImpl.Constants.SEPARATOR, "_"), r12) == true) goto L26;
        if (r111 == true) goto L26;
        r111 = false;
    L26:
        r111 = true;
        goto L30
    L31:
        if (r111 == true) goto L33;
        Log.i("zhoupeng.725", "atLeastOneFileAdded为false，空目录。添加一个empty_logs保证zip文件正常");     // Catch: Throwable -> L27
        r15.putNextEntry(new ZipEntry("empty_logs/"));     // Catch: Throwable -> L27
        r15.closeEntry();     // Catch: Throwable -> L27
    L33:
        r15.close();     // Catch: Throwable -> L38
        r14.close();     // Catch: Exception -> L36
        return;
    L27:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L42
    L66:
        throw th;     // Catch: Throwable -> L38
    L42:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L48
    L67:
        throw th;     // Catch: Exception -> L36
    L48:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L36
        throw th;     // Catch: Exception -> L36
    L36:
        e = move-exception;
        f21042a.log(Level.SEVERE, "Error compressing files to {0}: {1}", new Object[]{r13.getAbsolutePath(), e.getMessage()});
        throw e;
    L5:
        if (r11.equals("false") == true) goto L8;
        r12 = false;
        goto L9
    }
}
