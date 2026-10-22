package ms.bd.c;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39528a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f39529b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f39530c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f39531d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f39532e = null;
    private static final String f = null;
    private static final String g = null;
    private static final String h = null;
    private static final String i = null;
    private static final FileFilter j = null;

    final class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r7) {
            return Pattern.matches((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5608b6", new byte[]{39, 36, 86, 119, 13, 108, 111, 42}), String.class, "com.obric.aiagent.plugin"), r7.getName());
        }
    }

    static {
        f39528a = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "0375dc", new byte[]{17, 35, 75, 66, 94, 103, 32, 29, 116}), String.class, "com.obric.aiagent.plugin");
        f39529b = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e3a25c", new byte[]{92, 48, 0, 66, 29, 117, 116, 23}), String.class, "com.obric.aiagent.plugin");
        f39530c = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "397c94", new byte[]{4, 62, 69, 3, 19, 49, 53, 11}), String.class, "com.obric.aiagent.plugin");
        f39531d = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "eafcb3", new byte[]{100, 96}), String.class, "com.obric.aiagent.plugin");
        f39532e = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "82ea3c", new byte[]{33, 39}), String.class, "com.obric.aiagent.plugin");
        f = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "12cd0f", new byte[]{38, 36}), String.class, "com.obric.aiagent.plugin");
        g = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "afae6c", new byte[]{125, 101, 10}), String.class, "com.obric.aiagent.plugin");
        h = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8383ee", new byte[]{36, 56, 69}), String.class, "com.obric.aiagent.plugin");
        i = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ab7b5f", new byte[]{115, 111, 86, 19}), String.class, "com.obric.aiagent.plugin");
        j = new a();
    }

    public static String a() {
        JSONObject r1 = new JSONObject();
        HashMap<String, String> r3 = b();     // Catch: Throwable -> L32
        r1.put(i, c());     // Catch: Throwable -> L32
        String r5 = null;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get(f39528a), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
    L8:
        String r6 = "";
        if (r4 != null) goto L11;
        String r7 = "";
    L12:
        r1.put(f39531d, r7);     // Catch: Throwable -> L32
        String r8 = (String) ZeusTransformUtils.preCheckCast(r3.get(f39529b), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
    L16:
        if (r8 != null) goto L18;
        String r9 = "";
    L19:
        r1.put(f39532e, r9);     // Catch: Throwable -> L32
        r1.put(g, a((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2ceebb", new byte[]{108, 114, 15, 2, 18, 113, 52, 84, 61, 54, 38, 114, 89, 2, 68, 102, 37, 71, 57, 122, 32, 113, 3, 94, 94, 101, 36, 18, 123, 54, 51, 116, 16, 3, 88, 100, 126, 65, 36, 32, 42, 111, 16, 30, 98, 120, 48, 90, 11, 51, 49, 100, 7}), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L32
        r1.put(h, a((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "51b524", new byte[]{107, 32, 8, 82, 66, 39, 51, 6, 58, 102, 33, 32, 94, 82, 20, 48, 34, 21, 62, 42, 39, 35, 4, 14, 14, 51, 35, 64, 124, 102, 52, 38, 23, 83, 8, 50, 121, 19, 35, 112, 45, 61, 23, 78, 50, 46, 63, 30, 12, 99, 54, 54, 0}), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L32
        r5 = (String) ZeusTransformUtils.preCheckCast(r3.get(f39530c), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
    L22:
        if (r5 == null) goto L25;
        r6 = r5.trim();     // Catch: Throwable -> L32
    L25:
        r1.put(f, r6);     // Catch: Throwable -> L32
        goto L26
    L18:
        r9 = r8.trim();     // Catch: Throwable -> L32
    L15:
        r8 = null;
        goto L16
    L11:
        r7 = r4.trim();     // Catch: Throwable -> L32
    L7:
        r4 = null;
    L26:
        String r2 = r1.toString();
        if (TextUtils.isEmpty(r2) == false) goto L30;
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bb7e03", new byte[]{104, 125}), String.class, "com.obric.aiagent.plugin");
    L30:
        return r2.trim();
    }

    private static String a(String r11) {
        String r3 = null;
        File r4 = new File(r11);     // Catch: Throwable -> L14
        if (r4.exists() == false) goto L6;
        FileReader r12 = new FileReader(r4);     // Catch: Throwable -> L14
        BufferedReader r5 = new BufferedReader(r12);     // Catch: Throwable -> L13
        r3 = r5.readLine();     // Catch: Throwable -> L25
        r5.close();     // Catch: Throwable -> L23
    L34:
        r12.close();     // Catch: Throwable -> L24
    L19:
        if (r3 != null) goto L22;
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8a5241", new byte[]{121}), String.class, "com.obric.aiagent.plugin");
    L22:
        return r3.trim();
    L15:
        if (r5 != null) goto L32;
    L17:
        if (r12 == null) goto L19;
    L32:
        r5.close();     // Catch: Throwable -> L26
    L13:
        r5 = null;
        goto L15
    L6:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fdeaf4", new byte[]{39}), String.class, "com.obric.aiagent.plugin");
    L14:
        r12 = null;
        r5 = null;
        goto L15
    }

    private static HashMap<String, String> b() {
        HashMap<String, String> r1 = new HashMap();
        BufferedReader r2 = null;
        FileReader r3 = new FileReader((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "62fc00", new byte[]{104, 32, 7, 24, 12, 104, 54, 3, 34, 58, 41, 54, 26}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L20
        BufferedReader r4 = new BufferedReader(r3);     // Catch: Throwable -> L28
    L38:
        String r5 = r4.readLine();     // Catch: Throwable -> L19
        if (r5 != null) goto L11;
        r4.close();     // Catch: Throwable -> L26
    L36:
        r3.close();     // Catch: Throwable -> L27
    L25:
        return r1;
    L11:
        String[] r6 = r5.split((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a2d09a", new byte[]{42}), String.class, "com.obric.aiagent.plugin"), 2);     // Catch: Throwable -> L19
        if (r6.length < 2) goto L38;
        String r7 = r6[0].trim();     // Catch: Throwable -> L19
        String r8 = r6[1].trim();     // Catch: Throwable -> L19
        if (r1.get(r7) != null) goto L38;
        r1.put(r7, r8);     // Catch: Throwable -> L19
    L19:
        r2 = r4;
    L21:
        if (r2 != null) goto L34;
    L23:
        if (r3 == null) goto L25;
    L34:
        r2.close();     // Catch: Throwable -> L29
    L20:
        r3 = null;
        goto L21
    }

    private static int c() {
        return new File((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4a5735", new byte[]{106, 112, 95, 80, 67, 38, 50, 86, 109, 100, 32, 112, 9, 80, 21, 49, 35, 69, 105, 40, 38, 115, 83, 12}), String.class, "com.obric.aiagent.plugin")).listFiles(j).length;
    L4:
        return -1;
    }
}
