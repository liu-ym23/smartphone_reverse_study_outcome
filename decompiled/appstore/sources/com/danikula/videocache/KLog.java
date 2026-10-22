package com.danikula.videocache;

import android.text.TextUtils;
import android.util.Log;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.http.protocol.HttpRequestExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class KLog {
    private static final int A = 6;
    private static final int D = 2;
    private static final int E = 5;
    private static final int I = 3;
    private static boolean IS_SHOW_LOG = false;
    private static final int JSON = 7;
    private static final int JSON_INDENT = 4;
    private static final String LINE_SEPARATOR = null;
    private static final String NULL = "null";
    private static final String NULL_TIPS = "Log with null object";
    private static final String PARAM = "Param";
    private static final int STACK_TRACE_INDEX = 5;
    private static final String SUFFIX = ".java";
    private static String TAG_DEFAULT = null;
    private static final int V = 1;
    private static final int W = 4;
    private static final int XML = 8;

    static {
        LINE_SEPARATOR = System.getProperty("line.separator");
        TAG_DEFAULT = "YWLog ";
        IS_SHOW_LOG = false;
    }

    public KLog() {
    }

    public static void a(Object r10) {
        printLog(6, null, new Object[]{r10});
    }

    public static void d(Object r10) {
        printLog(2, null, new Object[]{r10});
    }

    public static void e(Object r10) {
        printLog(5, null, new Object[]{r10});
    }

    public static String formatXML(String r10) {
        StreamSource r11 = new StreamSource(new StringReader(r10));     // Catch: Exception -> L4
        StreamResult r12 = new StreamResult(new StringWriter());     // Catch: Exception -> L4
        Transformer r13 = TransformerFactory.newInstance().newTransformer();     // Catch: Exception -> L4
        r13.setOutputProperty("indent", "yes");     // Catch: Exception -> L4
        r13.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");     // Catch: Exception -> L4
        r13.transform(r11, r12);     // Catch: Exception -> L4
        return r12.getWriter().toString().replaceFirst(">", ">\n");
    L4:
        e = move-exception;
        e.printStackTrace();
        return r10;
    }

    private static String getObjectsString(Object... r10) {
        int r11 = 0;
        if (r10.length <= 1) goto L14;
        StringBuilder r12 = new StringBuilder();
        r12.append("\n");
    L6:
        if (r11 >= r10.length) goto L13;
        Object r13 = r10[r11];
        if (r13 != null) goto L10;
        r12.append(PARAM);
        r12.append("[");
        r12.append(r11);
        r12.append("]");
        r12.append(" = ");
        r12.append(NULL);
        r12.append("\n");
    L11:
        r11 = r11 + 1;
        goto L6
    L10:
        r12.append(PARAM);
        r12.append("[");
        r12.append(r11);
        r12.append("]");
        r12.append(" = ");
        r12.append(r13.toString());
        r12.append("\n");
        goto L11
    L13:
        return r12.toString();
    L14:
        Object r14 = r10[0];
        if (r14 != null) goto L18;
        return NULL;
    L18:
        return r14.toString();
    }

    public static void i(Object r10) {
        printLog(3, null, new Object[]{r10});
    }

    public static void init(boolean r10, String r11) {
        IS_SHOW_LOG = r10;
        TAG_DEFAULT = r11;
    }

    public static boolean isEmpty(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L12:
        return true;
    L5:
        if (r10.equals("\n") == true) goto L12;
        if (r10.equals("\t") == true) goto L12;
        if (TextUtils.isEmpty(r10.trim()) == true) goto L12;
        return false;
    }

    public static void json(String r10) {
        printLog(7, null, new Object[]{r10});
    }

    public static void printDefault(int r10, String r11, String r12) {
        int r13 = r12.length() / HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
        if (r13 <= 0) goto L8;
        int r14 = 0;
        int r15 = 0;
    L5:
        if (r14 >= r13) goto L7;
        int r16 = r15 + HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
        printSub(r10, r11, r12.substring(r15, r16));
        r14 = r14 + 1;
        r15 = r16;
        goto L5
    L7:
        printSub(r10, r11, r12.substring(r15, r12.length()));
        return;
    L8:
        printSub(r10, r11, r12);
    }

    public static void printJson(String r10, String r11, String r12) {
        if (r11.startsWith("{") == false) goto L6;
        r11 = new JSONObject(r11).toString(4);     // Catch: JSONException -> L13
    L14:
        goto L8
    L6:
        if (r11.startsWith("[") == false) goto L14;
        r11 = new JSONArray(r11).toString(4);     // Catch: JSONException -> L13
    L8:
        printLine(r10, true);
        StringBuilder r13 = new StringBuilder();
        r13.append(r12);
        String r14 = LINE_SEPARATOR;
        r13.append(r14);
        r13.append(r11);
        String[] r15 = r13.toString().split(r14);
        int r16 = r15.length;
        int r17 = 0;
    L9:
        if (r17 >= r16) goto L11;
        Log.d(r10, "║ " + r15[r17]);
        r17 = r17 + 1;
        goto L9
    L11:
        printLine(r10, false);
    }

    public static void printLine(String r10, boolean r11) {
        if (r11 == false) goto L4;
        Log.d(r10, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        return;
    L4:
        Log.d(r10, "╚═══════════════════════════════════════════════════════════════════════════════════════");
    }

    private static void printLog(int r10, String r11, Object... r12) {
        if (IS_SHOW_LOG == true) goto L5;
        return;
    L5:
        String[] r13 = wrapperContent(r11, r12);
        String r14 = r13[0];
        String r15 = r13[1];
        String r16 = r13[2];
        switch(r10) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L14;
        };
    L8:
        printXml(r14, r15, r16);
        return;
    L9:
        printJson(r14, r15, r16);
        return;
    L10:
        printDefault(r10, r14, r16 + r15);
        return;
    }

    private static void printSub(int r10, String r11, String r12) {
        switch(r10) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L4;
            default: goto L16;
        };
    L4:
        Log.wtf(r11, r12);
        return;
    L5:
        Log.e(r11, r12);
        return;
    L6:
        Log.w(r11, r12);
        return;
    L7:
        Log.i(r11, r12);
        return;
    L8:
        Log.d(r11, r12);
        return;
    L9:
        Log.v(r11, r12);
        return;
    }

    public static void printXml(String r10, String r11, String r12) {
        if (r11 == null) goto L4;
        String r13 = r12 + "\n" + formatXML(r11);
    L5:
        printLine(r10, true);
        String[] r14 = r13.split(LINE_SEPARATOR);
        int r15 = r14.length;
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L11;
        String r17 = r14[r16];
        if (isEmpty(r17) == true) goto L10;
        Log.d(r10, "║ " + r17);
    L10:
        r16 = r16 + 1;
        goto L6
    L11:
        printLine(r10, false);
        return;
    L4:
        r13 = r12 + NULL_TIPS;
        goto L5
    }

    public static void v(Object r10) {
        printLog(1, null, new Object[]{r10});
    }

    public static void w(Object r10) {
        printLog(4, null, new Object[]{r10});
    }

    private static String[] wrapperContent(String r10, Object... r11) {
        StackTraceElement r12 = Thread.currentThread().getStackTrace()[5];
        String r13 = r12.getClassName();
        String[] r14 = r13.split("\\.");
        if (r14.length <= 0) goto L5;
        r13 = r14[r14.length - 1] + SUFFIX;
    L5:
        String r15 = r12.getMethodName();
        int r16 = r12.getLineNumber();
        if (r16 >= 0) goto L8;
        r16 = 0;
    L8:
        String r17 = r15.substring(0, 1).toUpperCase() + r15.substring(1);
        if (r10 != null) goto L11;
        r10 = r13;
    L11:
        if (r11 != null) goto L13;
        String r18 = NULL_TIPS;
    L14:
        String r19 = "[ (" + r13 + ":" + r16 + ")#" + r17 + " ] ";
        if (TextUtils.isEmpty(r10) == false) goto L17;
        String r20 = TAG_DEFAULT;
    L19:
        return new String[]{r20, r18, r19};
    L17:
        r20 = TAG_DEFAULT + "_" + r10;
        goto L19
    L13:
        r18 = getObjectsString(r11);
        goto L14
    }

    public static void xml(String r10) {
        printLog(8, null, new Object[]{r10});
    }

    public static void a(String r10, Object... r11) {
        printLog(6, r10, r11);
    }

    public static void d(String r10, Object... r11) {
        printLog(2, r10, r11);
    }

    public static void e(String r10, Object... r11) {
        printLog(5, r10, r11);
    }

    public static void i(String r10, Object... r11) {
        printLog(3, r10, r11);
    }

    public static void json(String r10, String r11) {
        printLog(7, r10, new Object[]{r11});
    }

    public static void v(String r10, Object... r11) {
        printLog(1, r10, r11);
    }

    public static void w(String r10, Object... r11) {
        printLog(4, r10, r11);
    }

    public static void xml(String r10, String r11) {
        printLog(8, r10, new Object[]{r11});
    }
}
