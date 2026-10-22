package aa;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static void a(File r10, HashMap r11, List r12) {
        if (c(r10.getName()) == false) goto L5;
        return;
    L5:
        int r13 = 0;
        if (ListUtils.b(r12) == true) goto L13;
        Iterator r14 = r12.iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        if (r10.getAbsolutePath().startsWith((String) r14.next()) == false) goto L9;
        boolean r15 = true;
    L14:
        if (r15 == false) goto L20;
        StringBuilder r16 = new StringBuilder();
        int r17 = 0;
    L17:
        if (r17 >= r10.getName().length()) goto L19;
        r16.append("*");
        r17 = r17 + 1;
        goto L17
    L19:
        String r18 = r16.toString();
    L22:
        if (r10.isFile() == false) goto L25;
        r11.put(r18, Long.valueOf(r10.length()));
    L25:
        if (r10.isDirectory() == false) goto L29;
        HashMap r19 = new HashMap();
        r11.put(r18, r19);
        String[] r20 = r10.list();
        int r21 = r20.length;
    L27:
        if (r13 >= r21) goto L35;
        a(new File(r10, r20[r13]), r19, r12);
        r13 = r13 + 1;
        goto L27
    L35:
        return;
    L29:
        return;
    L20:
        r18 = r10.getName();
    L13:
        r15 = false;
        goto L14
    }

    public static void b(File r10, BufferedWriter r11, List r12) {
        HashMap r13 = new HashMap();
        r11.write("{");
        r11.newLine();
        File[] r14 = r10.listFiles();
        int r15 = 0;
    L4:
        if (r15 >= r14.length) goto L12;
        r13.clear();
        a(r14[r15], r13, r12);
        if (r13.keySet().isEmpty() == true) goto L11;
        e(r13, 1, r11);
        if ((r15 + 1) >= r14.length) goto L11;
        r11.write(",");
    L11:
        r15 = r15 + 1;
        goto L4
    L12:
        r11.write("}");
        r11.flush();
    }

    public static boolean c(String r10) {
        return r10.startsWith(LibrarianImpl.Constants.DOT);
    }

    public static boolean d(File r10, File r11, List r12) {
        BufferedWriter r13 = null;
        FileWriter r14 = new FileWriter(r11);     // Catch: Throwable -> L20 IOException -> L22
        BufferedWriter r15 = new BufferedWriter(r14);     // Catch: Throwable -> L16 IOException -> L18
        b(r10, r15, r12);     // Catch: Throwable -> L12 IOException -> L14
        r15.close();     // Catch: IOException -> L8
        r14.close();     // Catch: IOException -> L8
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        return true;
    L14:
        e = e;
        r13 = r15;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L16
        if (r13 != null) goto L50;
    L29:
        if (r14 == null) goto L58;
        r14.close();     // Catch: IOException -> L27
        return false;
    L27:
        e = move-exception;
        e.printStackTrace();
        return false;
    L58:
        return false;
    L50:
        r13.close();     // Catch: IOException -> L27
    L12:
        th = th;
        r13 = r15;
    L35:
        if (r13 != null) goto L48;
    L39:
        if (r14 == null) goto L43;
        r14.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L43:
        throw th;
    L48:
        r13.close();     // Catch: IOException -> L37
    L18:
        e = e;
        goto L24
    L16:
        th = th;
    L22:
        e = e;
        r14 = null;
    L20:
        th = th;
        r14 = null;
        goto L35
    }

    public static void e(HashMap r12, int r13, BufferedWriter r14) {
        int r10 = r12.keySet().size();
        Iterator r11 = r12.keySet().iterator();
        int r15 = 0;
    L4:
        if (r11.hasNext() == false) goto L25;
        String r16 = (String) r11.next();
        Object r17 = r12.get(r16);
        r15 = r15 + 1;
        if ((r17 instanceof Long) == true) goto L7;
        int r18 = 0;
    L16:
        if (r18 >= r13) goto L18;
        r14.write("\t");
        r18 = r18 + 1;
        goto L16
    L18:
        r14.write(String.format("\"%s\": {", new Object[]{r16.replaceAll("\n", "")}));
        r14.newLine();
        int r19 = r13 + 1;
        e((HashMap) r17, r19, r14);
        int r20 = 0;
    L19:
        if (r20 >= r19) goto L21;
        r14.write("\t");
        r20 = r20 + 1;
        goto L19
    L21:
        r14.write("}");
        if (r15 >= r10) goto L24;
        r14.write(",");
    L24:
        r14.newLine();
        goto L4
    L7:
        int r21 = 0;
    L9:
        if (r21 >= (r13 + 1)) goto L11;
        r14.write("\t");
        r21 = r21 + 1;
        goto L9
    L11:
        String r22 = r16.replaceAll("\n", "");
        Long r23 = (Long) r17;
        r23.longValue();
        r14.write(String.format("\"%s\": %d", new Object[]{r22, r23}));
        if (r15 >= r10) goto L14;
        r14.write(",");
    L14:
        r14.newLine();
        goto L4
    }
}
