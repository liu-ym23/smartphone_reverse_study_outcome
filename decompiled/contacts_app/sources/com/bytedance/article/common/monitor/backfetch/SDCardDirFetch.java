package com.bytedance.article.common.monitor.backfetch;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.PermissionUtils;
import com.bytedance.article.common.monitor.file.FileUploadManager;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class SDCardDirFetch {
    public static final String SD_CARD_DIR_BACK_TYPE = "sd_card_dir_back";
    private static long lastFetchTime;

    static {
    }

    public SDCardDirFetch() {
    }

    public static boolean writeSDCardInfo(Context r5) {
        if (PermissionUtils.isGrantSDCardWritePermission(r5) == true) goto L5;
        return false;
    L5:
        String r0 = FileUtils.getExternalRootDir(ApmContext.getContext()).getAbsolutePath() + File.separator + "backfetch" + File.separator + "sdcardinfo" + File.separator + "tmp";
        BufferedWriter r2 = null;
        File r3 = new File(r0);     // Catch: Throwable -> L24 IOException -> L26
        if (r3.exists() == true) goto L9;
        r3.mkdirs();     // Catch: Throwable -> L24 IOException -> L26
    L9:
        FileWriter r4 = new FileWriter(r0 + File.separator + "sdcardinfo.txt");     // Catch: Throwable -> L24 IOException -> L26
        BufferedWriter r1 = new BufferedWriter(r4);     // Catch: IOException -> L22 Throwable -> L38
        getDeptXml(FileUtils.getExternalRootDir(r5), 0, r1);     // Catch: Throwable -> L18 IOException -> L20
        r1.close();     // Catch: IOException -> L14
        r4.close();     // Catch: IOException -> L14
        return true;
    L14:
        e = move-exception;
        e.printStackTrace();
        return true;
    L20:
        e = e;
        r2 = r1;
    L28:
        e.printStackTrace();     // Catch: Throwable -> L38
        if (r2 != null) goto L52;
    L33:
        if (r4 == null) goto L37;
        r4.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L37:
        return false;
    L52:
        r2.close();     // Catch: IOException -> L31
    L18:
        th = th;
        r2 = r1;
    L39:
        if (r2 != null) goto L48;
    L43:
        if (r4 == null) goto L47;
        r4.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
    L47:
        throw th;
    L48:
        r2.close();     // Catch: IOException -> L41
    L22:
        e = e;
    L38:
        th = th;
        goto L39
    L26:
        e = e;
        r4 = null;
    L24:
        th = th;
        r4 = null;
        goto L39
    }

    public static boolean writeAppDataInfo(Context r5) {
        if (PermissionUtils.isGrantSDCardWritePermission(r5) == true) goto L5;
        return false;
    L5:
        String r0 = FileUtils.getExternalRootDir(r5).getAbsolutePath() + File.separator + "backfetch" + File.separator + "sdcardinfo" + File.separator + "tmp";
        BufferedWriter r2 = null;
        File r3 = new File(r0);     // Catch: Throwable -> L24 IOException -> L26
        if (r3.exists() == true) goto L9;
        r3.mkdirs();     // Catch: Throwable -> L24 IOException -> L26
    L9:
        FileWriter r4 = new FileWriter(r0 + File.separator + "appDataInfo.txt");     // Catch: Throwable -> L24 IOException -> L26
        BufferedWriter r1 = new BufferedWriter(r4);     // Catch: IOException -> L22 Throwable -> L38
        getDeptXml(r5.getCacheDir().getParentFile(), 0, r1);     // Catch: Throwable -> L18 IOException -> L20
        r1.close();     // Catch: IOException -> L14
        r4.close();     // Catch: IOException -> L14
        return true;
    L14:
        e = move-exception;
        e.printStackTrace();
        return true;
    L20:
        e = e;
        r2 = r1;
    L28:
        e.printStackTrace();     // Catch: Throwable -> L38
        if (r2 != null) goto L52;
    L33:
        if (r4 == null) goto L37;
        r4.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L37:
        return false;
    L52:
        r2.close();     // Catch: IOException -> L31
    L18:
        th = th;
        r2 = r1;
    L39:
        if (r2 != null) goto L48;
    L43:
        if (r4 == null) goto L47;
        r4.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
    L47:
        throw th;
    L48:
        r2.close();     // Catch: IOException -> L41
    L22:
        e = e;
    L38:
        th = th;
        goto L39
    L26:
        e = e;
        r4 = null;
    L24:
        th = th;
        r4 = null;
        goto L39
    }

    private static boolean copyFiles(Context r5) {
        boolean r0 = writeSDCardInfo(r5);
        if (r0 == true) goto L5;
        return r0;
    L5:
        boolean r1 = writeAppDataInfo(r5);
        if (r1 == true) goto L8;
        return r1;
    L8:
        File r2 = new File(FileUtils.getExternalRootDir(r5).getAbsolutePath() + File.separator + "backfetch" + File.separator + "sdcardinfo" + File.separator + "tmp");
        FileUtils.compress(r2.getParentFile().getAbsolutePath() + File.separator + generateUploadFileName(), new String[]{r2.getAbsolutePath()});     // Catch: Exception -> L12
        FileUtils.removeDir(r2.getAbsolutePath());
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static String generateUploadFileName() {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String r1 = FetchUtils.getVersionName(ApmContext.getHeaderInner());
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return String.format("%s_sdcardinfo.zip", new Object[]{r0.format(new Date(System.currentTimeMillis()))});
    L7:
        return String.format("%s_sdcardinfo_%s.zip", new Object[]{r0.format(new Date(System.currentTimeMillis())), r1});
    }

    @Deprecated
    public static void walkdir(File r5, BufferedWriter r6) throws IOException {
        File[] r7 = r5.listFiles();
        if (r7 == null) goto L18;
        int r1 = 0;
    L6:
        if (r1 >= r7.length) goto L24;
        if (r7[r1].isDirectory() == false) goto L13;
        if (r7[r1].getPath().indexOf("/.") != (-1)) goto L13;
        walkdir(r7[r1], r6);
    L17:
        r1 = r1 + 1;
    L13:
        if (r7[r1].getName().startsWith(LibrarianImpl.Constants.DOT) == true) goto L17;
        if (r7[r1].canRead() == false) goto L17;
        r6.write(String.format("file Name: %s, file size: %s\n", new Object[]{r7[r1].getAbsolutePath(), FileUtils.getFormatSize(r7[r1].length())}));
        goto L17
    L24:
        return;
    }

    public static void uplaodSDCardDirFile(Context r4) {
        if (FetchUtils.checkFetchInterval(lastFetchTime, System.currentTimeMillis()) == true) goto L6;
        return;
    L6:
        if (copyFiles(r4) == false) goto L9;
        lastFetchTime = System.currentTimeMillis();
        FileUploadManager.registerFileCallBack(SD_CARD_DIR_BACK_TYPE, new AnonymousClass1());
        return;
    }

    @Deprecated
    protected static void getDeptTree(File r9, String r10, int r11, BufferedWriter r12) throws IOException {
        if (r9.isDirectory() == false) goto L5;
        File[] r13 = r9.listFiles();
        int r0 = 0;
    L11:
        if (r0 >= r13.length) goto L40;
        if (r11 > 0) goto L14;
        String r5 = "";
        String r6 = "";
    L20:
        if (r13[r0].getName().startsWith(LibrarianImpl.Constants.DOT) == true) goto L28;
        if (r13[r0].canRead() == false) goto L28;
        r12.write(r6 + r13[r0].getName());
        if (r13[r0].isDirectory() == true) goto L26;
        r12.write(String.format("(size: %s)", new Object[]{FileUtils.getFormatSize(r13[r0].length())}));
    L26:
        r12.newLine();
    L28:
        if (r13[r0].isDirectory() == false) goto L32;
        if (r13[r0].getPath().indexOf("/.") != (-1)) goto L32;
        getDeptTree(r13[r0], r5, r11 + 1, r12);
    L32:
        r0 = r0 + 1;
        goto L11
    L14:
        if ((r13.length - r0) <= 1) goto L16;
        r5 = r10 + "  |";
    L17:
        r6 = r10 + "  |__";
        goto L20
    L16:
        r5 = r10 + "   ";
        goto L17
    L40:
        return;
    L5:
        if (r9.getName().startsWith(LibrarianImpl.Constants.DOT) == false) goto L7;
        return;
    L7:
        if (r9.canRead() == false) goto L38;
        r12.write(r9.getName());
        r12.write(String.format("(size: %s)", new Object[]{FileUtils.getFormatSize(r9.length())}));
        r12.newLine();
        return;
    }

    protected static void getDeptXml(File r10, int r11, BufferedWriter r12) throws IOException {
        int r4 = 0;
        if (r10.isDirectory() == false) goto L5;
        File[] r0 = r10.listFiles();
        if (r0 != null) goto L15;
        return;
    L15:
        int r7 = 0;
    L16:
        if (r7 >= r11) goto L18;
        r12.write("\t");
        r7 = r7 + 1;
        goto L16
    L18:
        r12.write(String.format("<dir name=\"%s\">", new Object[]{r10.getName()}));
        r12.newLine();
        int r13 = 0;
    L20:
        if (r13 >= r0.length) goto L36;
        if (r0[r13].getName().startsWith(LibrarianImpl.Constants.DOT) == true) goto L35;
        if (r0[r13].canRead() == false) goto L35;
        if (r0[r13].isDirectory() == true) goto L33;
        int r8 = 0;
    L29:
        if (r8 >= (r11 + 1)) goto L31;
        r12.write("\t");
        r8 = r8 + 1;
        goto L29
    L31:
        r12.write(String.format("<file name=\"%s\" size=\"%s\"></file>", new Object[]{r0[r13].getName(), FileUtils.getFormatSize(r0[r13].length())}));
        r12.newLine();
        goto L35
    L33:
        if (r0[r13].getPath().indexOf("/.") != (-1)) goto L35;
        getDeptXml(r0[r13], r11 + 1, r12);
    L35:
        r13 = r13 + 1;
    L36:
        if (r4 >= r11) goto L38;
        r12.write("\t");
        r4 = r4 + 1;
        goto L36
    L38:
        r12.write("</dir>");
        r12.newLine();
        return;
    L5:
        if (r10.getName().startsWith(LibrarianImpl.Constants.DOT) == false) goto L7;
        return;
    L7:
        if (r10.canRead() == false) goto L51;
        int r1 = 0;
    L9:
        if (r1 >= r11) goto L11;
        r12.write("\t");
        r1 = r1 + 1;
        goto L9
    L11:
        r12.write(String.format("<file name=\"%s\" size=\"%s\"></file>", new Object[]{r10.getName(), FileUtils.getFormatSize(r10.length())}));
        r12.newLine();
        return;
    }
}
