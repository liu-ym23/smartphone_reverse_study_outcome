package com.bytedance.monitor.collector;

import android.text.TextUtils;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtils {
    private FileUtils() {
    }

    public static void writeFile(File r2, String r3, boolean r4) throws IOException {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        r2.getParentFile().mkdirs();
        FileOutputStream r0 = null;
        FileOutputStream r1 = new FileOutputStream(r2, r4);     // Catch: Throwable -> L12
        r1.write(r3.getBytes());     // Catch: Throwable -> L10
        r1.flush();     // Catch: Throwable -> L10
        IoUtil.safeClose(r1);
        return;
    L10:
        th = th;
        r0 = r1;
    L13:
        IoUtil.safeClose(r0);
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static boolean deleteFile(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return deleteFile(new File(r1));
    }

    public static boolean deleteFile(File r5) {
        boolean r1 = true;
        if (r5.exists() == true) goto L6;
        return true;
    L6:
        if (r5.canWrite() == true) goto L9;
        return false;
    L9:
        if (r5.isFile() == false) goto L13;
        return r5.delete();
    L13:
        if (r5.isDirectory() == false) goto L33;
        File[] r0 = r5.listFiles();
        int r3 = 0;
    L15:
        if (r0 == null) goto L28;
        if (r3 >= r0.length) goto L28;
        if (r0[r3].isFile() == true) goto L21;
        boolean r4 = deleteFile(r0[r3]);
    L25:
        r1 = r1 & r4;
    L26:
        r3 = r3 + 1;
        goto L15
    L21:
        if (r0[r3].canWrite() == false) goto L23;
        r4 = r0[r3].delete();
        goto L25
    L23:
        r1 = false;
    L28:
        return r1 & r5.delete();
    L33:
        return true;
    }

    public static String readFile(String r4, String r5) throws IOException {
        BufferedReader r1 = null;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        File r0 = new File(r4);
        StringBuilder r6 = new StringBuilder();
        BufferedReader r2 = new BufferedReader(new FileReader(r0));     // Catch: Throwable -> L17
    L20:
        String r3 = r2.readLine();     // Catch: Throwable -> L15
        if (r3 == null) goto L13;
        r6.append(r3);     // Catch: Throwable -> L15
        if (r5 == null) goto L20;
        r6.append(r5);     // Catch: Throwable -> L15
        goto L20
    L13:
        IoUtil.safeClose(r2);
        return r6.toString();
    L15:
        th = th;
        r1 = r2;
    L18:
        IoUtil.safeClose(r1);
        throw th;
    L17:
        th = th;
        goto L18
    }

    public static JSONArray readFileArray(String r4) throws IOException {
        BufferedReader r1 = null;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        File r0 = new File(r4);
        JSONArray r5 = new JSONArray();
        BufferedReader r2 = new BufferedReader(new FileReader(r0));     // Catch: Throwable -> L15
    L18:
        String r3 = r2.readLine();     // Catch: Throwable -> L13
        if (r3 == null) goto L11;
        r5.put(r3);     // Catch: Throwable -> L13
        goto L18
    L11:
        IoUtil.safeClose(r2);
        return r5;
    L13:
        th = th;
        r1 = r2;
    L16:
        IoUtil.safeClose(r1);
        throw th;
    L15:
        th = th;
        goto L16
    }

    public static boolean isEmpty(File r0) {
        String[] r1 = r0.list();
        if (r1 != null) goto L5;
    L8:
        return true;
    L5:
        if (r1.length == 0) goto L8;
        return false;
    }

    public static boolean isEmpty(JSONArray r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static String readFile(String r1) throws IOException {
        return readFile(r1, null);
    }

    public static JSONArray toJsonArray(String r3, String r4) {
        JSONArray r0 = new JSONArray();
        if (r3 == null) goto L8;
        if (r4 == null) goto L8;
        String[] r5 = r3.split(r4);
        int r6 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r6) goto L8;
        r0.put(r5[r1]);
        r1 = r1 + 1;
    L8:
        return r0;
    }

    public static Map<String, String> readPropertiesFile(File r6) {
        FileInputStream r0 = null;
        Properties r1 = new Properties();     // Catch: Throwable -> L13 IOException -> L16
        FileInputStream r2 = new FileInputStream(r6);     // Catch: Throwable -> L13 IOException -> L16
        r1.load(r2);     // Catch: Throwable -> L11 IOException -> L19
        Set<String> r7 = r1.stringPropertyNames();     // Catch: Throwable -> L11 IOException -> L19
        HashMap r3 = new HashMap();     // Catch: Throwable -> L11 IOException -> L19
        Iterator<String> r8 = r7.iterator();     // Catch: Throwable -> L11 IOException -> L19
    L6:
        if (r8.hasNext() == false) goto L9;
        String r4 = r8.next();     // Catch: Throwable -> L11 IOException -> L19
        r3.put(r4, r1.getProperty(r4));     // Catch: Throwable -> L11 IOException -> L19
        goto L17
    L9:
        IoUtil.safeClose(r2);
        return r3;
    L11:
        th = th;
        r0 = r2;
    L14:
        IoUtil.safeClose(r0);
        throw th;
    L17:
        IoUtil.safeClose(r2);
        return null;
    L16:
        r2 = null;
    L13:
        th = th;
        goto L14
    }

    public static String[] readProcFile(String r4) {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream(r4)), 1000);     // Catch: Throwable -> L12
        String r5 = r1.readLine();     // Catch: Throwable -> L10
        int r2 = r5.indexOf(")");     // Catch: Throwable -> L10
        if (r2 <= 0) goto L7;
        r5 = r5.substring(r2 + 2);     // Catch: Throwable -> L10
    L7:
        String[] r6 = r5.split(HanziToPinyin.Token.SEPARATOR);     // Catch: Throwable -> L10
        IoUtil.safeClose(r1);
        return r6;
    L10:
        th = th;
    L22:
        th.printStackTrace();     // Catch: Throwable -> L17
        IoUtil.safeClose(r1);
        return null;
    L17:
        th = move-exception;
        IoUtil.safeClose(r1);
        throw th;
    L12:
        th = th;
        r1 = null;
        goto L22
    }

    public static boolean isEmpty(File[] r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length == 0) goto L7;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static void writeListMap(File r6, ArrayList<HashMap<String, String>> r7, String r8, String r9) {
        if (r6 == null) goto L39;
        if (r7 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r9) == true) goto L53;
        ?? r0 = 0;
        FileOutputStream r1 = null;
        FileOutputStream r2 = new FileOutputStream(r6);     // Catch: Throwable -> L31 IOException -> L33
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L27 IOException -> L29
        int r3 = 0;
    L13:
        if (r3 >= r7.size()) goto L25;
        HashMap<String, String> r4 = r7.get(r3);     // Catch: Throwable -> L27 IOException -> L29
        if (r4 == null) goto L24;
        if (r4.size() == 0) goto L24;
        Iterator<String> r5 = r4.keySet().iterator();     // Catch: Throwable -> L27 IOException -> L29
    L21:
        if (r5.hasNext() == false) goto L23;
        String r11 = r5.next();     // Catch: Throwable -> L27 IOException -> L29
        r10.append(r11).append(r9).append(r4.get(r11)).append(r8);     // Catch: Throwable -> L27 IOException -> L29
        goto L21
    L23:
        r10.append("\n");     // Catch: Throwable -> L27 IOException -> L29
    L24:
        r3 = r3 + 1;     // Catch: Throwable -> L27 IOException -> L29
        goto L13
    L25:
        r2.write(r10.toString().getBytes());     // Catch: Throwable -> L27 IOException -> L29
        IoUtil.safeClose(r2);
        r0 = r3;
    L40:
        return;
    L29:
        e = e;
        r1 = r2;
    L34:
        e.printStackTrace();     // Catch: Throwable -> L31
        IoUtil.safeClose(r1);
        r0 = r1;
    L27:
        th = th;
        r0 = r2;
    L37:
        IoUtil.safeClose(r0);
        throw th;
    L31:
        th = th;
    L33:
        e = e;
        goto L34
    L53:
        return;
    }

    public static ArrayList<HashMap<String, String>> readListMap(File r8, String r9, String r10) {
        BufferedReader r0 = null;
        ArrayList<HashMap<String, String>> r1 = null;
        BufferedReader r2 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r8.exists() == true) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r9) == false) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r10) == true) goto L66;
        BufferedReader r3 = new BufferedReader(new FileReader(r8));     // Catch: Throwable -> L38 Throwable -> L41
    L46:
        String r11 = r3.readLine();     // Catch: Throwable -> L35 Throwable -> L37
        if (r11 == null) goto L34;
        if ("\n".equals(r11) == true) goto L46;
        String[] r12 = r11.split(r9);     // Catch: Throwable -> L35 Throwable -> L37
        if (r12 == null) goto L46;
        HashMap<String, String> r4 = new HashMap();     // Catch: Throwable -> L35 Throwable -> L37
        int r5 = 0;
    L21:
        if (r5 >= r12.length) goto L29;
        String[] r6 = r12[r5].split(r10);     // Catch: Throwable -> L35 Throwable -> L37
        if (r6 == null) goto L27;
        if (r6.length != 2) goto L27;
        r4.put(r6[0], r6[1]);     // Catch: Throwable -> L35 Throwable -> L37
    L27:
        r5 = r5 + 1;     // Catch: Throwable -> L35 Throwable -> L37
        goto L21
    L29:
        if (r4.size() <= 0) goto L46;
        if (r1 != null) goto L32;
        r1 = new ArrayList();     // Catch: Throwable -> L35 Throwable -> L37
    L32:
        r1.add(r4);     // Catch: Throwable -> L35 Throwable -> L37
        goto L46
    L34:
        IoUtil.safeClose(r3);
        return r1;
    L37:
        ArrayList<HashMap<String, String>> r13 = r1;
        r2 = r3;
    L42:
        IoUtil.safeClose(r2);
        return r13;
    L35:
        th = th;
        r0 = r3;
    L39:
        IoUtil.safeClose(r0);
        throw th;
    L41:
        r13 = null;
    L38:
        th = th;
        goto L39
    L66:
        return null;
    }

    public static void copy(File r3, File r4) {
        if (r3 == null) goto L36;
        if (r4 == null) goto L47;
        FileInputStream r0 = null;
        r4.getParentFile().mkdirs();     // Catch: Throwable -> L25 Exception -> L27
        FileInputStream r1 = new FileInputStream(r3);     // Catch: Throwable -> L25 Exception -> L27
    L43:
        FileOutputStream r5 = new FileOutputStream(r4);     // Catch: Throwable -> L19 Exception -> L22
    L39:
        byte[] r6 = new byte[8192];     // Catch: Throwable -> L15 Exception -> L17
    L10:
        int r2 = r1.read(r6);     // Catch: Throwable -> L15 Exception -> L17
        if (r2 <= 0) goto L14;
        r5.write(r6, 0, r2);     // Catch: Throwable -> L15 Exception -> L17
    L14:
        IoUtil.safeClose(r1);
    L31:
        IoUtil.safeClose(r5);
        return;
    L17:
        e = e;
    L24:
        r0 = r1;
    L37:
        e.printStackTrace();     // Catch: Throwable -> L33
        IoUtil.safeClose(r0);
    L33:
        th = th;
    L34:
        IoUtil.safeClose(r0);
        IoUtil.safeClose(r5);
        throw th;
    L15:
        th = th;
    L21:
        r0 = r1;
    L22:
        e = e;
        r5 = null;
    L19:
        th = th;
        r5 = null;
    L27:
        e = e;
        r5 = null;
    L25:
        th = th;
        r5 = null;
        goto L34
    L47:
        return;
    }

    public static void zip(String r1, String r2) throws Exception {
        zip(r2, new File(r1));
    }

    public static void zip(List<String> r3, String r4) throws Exception {
        ZipOutputStream r0 = null;
        ZipOutputStream r1 = new ZipOutputStream(new FileOutputStream(r4));     // Catch: Throwable -> L13
        Iterator<String> r5 = r3.iterator();     // Catch: Throwable -> L11
    L6:
        if (r5.hasNext() == false) goto L9;
        File r2 = new File(r5.next());     // Catch: Throwable -> L11
        zip(r1, r2, r2.getName());     // Catch: Throwable -> L11
        goto L6
    L9:
        IoUtil.safeClose(r1);
        return;
    L11:
        th = th;
        r0 = r1;
    L14:
        IoUtil.safeClose(r0);
        throw th;
    L13:
        th = th;
        goto L14
    }

    private static void zip(String r3, File r4) throws Exception {
        ZipOutputStream r0 = null;
        new File(r3).getParentFile().mkdirs();     // Catch: Throwable -> L9
        ZipOutputStream r1 = new ZipOutputStream(new FileOutputStream(r3));     // Catch: Throwable -> L9
        zip(r1, r4, "");     // Catch: Throwable -> L7
        IoUtil.safeClose(r1);
        return;
    L7:
        th = th;
        r0 = r1;
    L10:
        IoUtil.safeClose(r0);
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static void zip(OutputStream r3, File... r4) throws IOException {
        ZipOutputStream r0 = null;
        ZipOutputStream r1 = new ZipOutputStream(r3);     // Catch: Throwable -> L12
        r1.putNextEntry(new ZipEntry(LibrarianImpl.Constants.SEPARATOR));     // Catch: Throwable -> L10
        int r5 = r4.length;     // Catch: Throwable -> L10
        int r2 = 0;
    L5:
        if (r2 >= r5) goto L8;
        zip(r1, r4[r2]);     // Catch: Throwable -> L10
        r2 = r2 + 1;
        goto L5
    L8:
        IoUtil.safeClose(r1);
        return;
    L10:
        th = th;
        r0 = r1;
    L13:
        IoUtil.safeClose(r0);
        throw th;
    L12:
        th = th;
        goto L13
    }

    private static void zip(ZipOutputStream r4, File r5) throws IOException {
        if (r5.exists() == true) goto L5;
        return;
    L5:
        int r1 = 0;
        if (r5.isDirectory() == false) goto L11;
        File[] r6 = r5.listFiles();
    L9:
        if (r1 >= r6.length) goto L33;
        File r0 = r6[r1];
        zip(r4, r0, r0.getName());
        r1 = r1 + 1;
        goto L9
    L33:
        return;
    L11:
        FileInputStream r2 = null;
        FileInputStream r3 = new FileInputStream(r5);     // Catch: Throwable -> L23
        byte[] r7 = new byte[4096];     // Catch: Throwable -> L21
    L15:
        int r8 = r3.read(r7);     // Catch: Throwable -> L21
        if ((-1) == r8) goto L19;
        r4.write(r7, 0, r8);     // Catch: Throwable -> L21
        goto L15
    L19:
        IoUtil.safeClose(r3);
        return;
    L21:
        th = th;
        r2 = r3;
    L24:
        IoUtil.safeClose(r2);
        throw th;
    L23:
        th = th;
        goto L24
    }

    private static void zip(ZipOutputStream r4, File r5, String r6) throws IOException {
        if (r5.exists() == true) goto L5;
        return;
    L5:
        int r1 = 0;
        if (r5.isDirectory() == false) goto L14;
        File[] r7 = r5.listFiles();
        r4.putNextEntry(new ZipEntry(r6 + LibrarianImpl.Constants.SEPARATOR));
        if (r6.length() != 0) goto L10;
        String r8 = "";
    L12:
        if (r1 >= r7.length) goto L37;
        zip(r4, r7[r1], r8 + r7[r1].getName());
        r1 = r1 + 1;
        goto L12
    L37:
        return;
    L10:
        r8 = r6 + LibrarianImpl.Constants.SEPARATOR;
        goto L12
    L14:
        r4.putNextEntry(new ZipEntry(r6));
        FileInputStream r9 = null;
        FileInputStream r0 = new FileInputStream(r5);     // Catch: Throwable -> L26
        byte[] r10 = new byte[4096];     // Catch: Throwable -> L24
    L18:
        int r11 = r0.read(r10);     // Catch: Throwable -> L24
        if ((-1) == r11) goto L22;
        r4.write(r10, 0, r11);     // Catch: Throwable -> L24
        goto L18
    L22:
        IoUtil.safeClose(r0);
        return;
    L24:
        th = th;
        r9 = r0;
    L27:
        IoUtil.safeClose(r9);
        throw th;
    L26:
        th = th;
        goto L27
    }
}
