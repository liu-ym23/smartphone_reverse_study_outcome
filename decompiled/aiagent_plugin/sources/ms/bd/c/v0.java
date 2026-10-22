package ms.bd.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f39666a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static z1 f39667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static u1 f39668c;

    static {
        f39667b = new z1();
        u1 r0 = new u1();
        f39668c = r0;
        r0.a(r0);
    }

    static boolean a(Context r19, String r20, String r21) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        String[] r6 = r2.getAssets().list(r20);     // Catch: Exception -> L21
        if (r6.length <= 0) goto L8;
        new File(r21).mkdirs();     // Catch: Exception -> L21
        int r7 = r6.length;     // Catch: Exception -> L21
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L30;
        String r9 = r6[r8];     // Catch: Exception -> L21
        a(r2, r20 + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e78783", new byte[]{59}), String.class, "com.obric.aiagent.plugin")) + r9, r21 + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e063bd", new byte[]{59}), String.class, "com.obric.aiagent.plugin")) + r9);     // Catch: Exception -> L21
        r8 = r8 + 1;     // Catch: Exception -> L21
        goto L6
    L30:
        return true;
    L8:
        InputStream r3 = r2.getAssets().open(r20);     // Catch: Exception -> L21
        FileOutputStream r10 = new FileOutputStream(r21);     // Catch: Exception -> L21
        byte[] r0 = new byte[256];     // Catch: IOException -> L23 Throwable -> L16
    L11:
        int r1 = r3.read(r0);     // Catch: IOException -> L23 Throwable -> L16
        if (r1 <= 0) goto L14;
        r10.write(r0, 0, r1);     // Catch: IOException -> L23 Throwable -> L16
        goto L11
    L14:
        r10.flush();     // Catch: IOException -> L23 Throwable -> L16
    L16:
        th = move-exception;
        w.a(r10);     // Catch: Exception -> L21
        w.a(r3);     // Catch: Exception -> L21
        throw th;     // Catch: Exception -> L21
    L15:
        w.a(r10);     // Catch: Exception -> L21
        w.a(r3);     // Catch: Exception -> L21
        return true;
    L21:
        String r4 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c3978a", new byte[]{113, 48, 76}), String.class, "com.obric.aiagent.plugin");
        return false;
    }

    public static Object a(int r28, int r29, long r30, String r32, Object r33) {
        String r6 = r32;
        String r2 = "";
        if (r28 == 131073) goto L116;
        if (r28 == 131074) goto L116;
        int r15 = 5;
        int r9 = 0;
        switch(r28) {
            case 65537: goto L122;
            case 65538: goto L107;
            case 65539: goto L103;
            case 65540: goto L126;
            case 65541: goto L45;
            case 65542: goto L22;
            case 65543: goto L120;
            case 65544: goto L124;
            default: goto L8;
        };
    L8:
        switch(r28) {
            case 196609: goto L154;
            case 196610: goto L154;
            case 196611: goto L154;
            default: goto L9;
        };
    L9:
        return null;
    L154:
        return f39667b.a(r28, r29, r30, r32, r33);
    L22:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        ApplicationInfo r1 = r0.getPackageManager().getApplicationInfo(r0.getPackageName(), 0);
        String r3 = r1.sourceDir;
        if (r3 != null) goto L26;
        r3 = r1.publicSourceDir;
    L26:
        HashMap r4 = c.a(r3);
        if (r4 != null) goto L29;
    L31:
        String r5 = "";
    L32:
        if (r5 == null) goto L43;
        if (r5.isEmpty() == true) goto L43;
        JSONObject r7 = new JSONObject(r5);
        String r8 = r7.getString((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "836adb", new byte[]{36, 52, 81, 20, 100, 96, 54, 23, 105, 54, 22, 50, 77, 20, 85, 123, 62, 30}), String.class, "com.obric.aiagent.plugin"));     // Catch: JSONException -> L38
    L39:
        StringBuilder r10 = new StringBuilder().append(r8).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c04aac", new byte[]{41}), String.class, "com.obric.aiagent.plugin"));
        r2 = r7.getString((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "11f630", new byte[]{50, 54, 25, 71, 13, 52, 55, 47, 53, 115, 41, 63, 17}), String.class, "com.obric.aiagent.plugin"));     // Catch: JSONException -> L117
    L41:
        r2 = r10.append(r2).toString();
    L38:
        r8 = "";
    L43:
        if (r2.isEmpty() == false) goto L152;
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d98884", new byte[]{91, 52, 69, 73}), String.class, "com.obric.aiagent.plugin");
    L152:
        return r2;
    L29:
        if (r4.containsKey(1903654775) == false) goto L31;
        r5 = (String) ZeusTransformUtils.preCheckCast(r4.get(1903654775), String.class, "com.obric.aiagent.plugin");
        goto L32
    L45:
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        AssetManager r12 = r11.getAssets();
        if (r6.startsWith((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "87c9f6", new byte[]{103}), String.class, "com.obric.aiagent.plugin")) == true) goto L48;
        r6 = ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c0a1d7", new byte[]{60}), String.class, "com.obric.aiagent.plugin")) + r6;
    L48:
        String[] r13 = r12.list("");
        ArrayList r14 = new ArrayList();
        int r16 = 0;
    L50:
        if (r16 >= r13.length) goto L86;
        if (r13[r16].endsWith(r6) == false) goto L85;
        String r17 = r13[r16];
        byte[] r18 = new byte[r15];
        r18 = {x0718: FILL_ARRAY_DATA , data: [122, 40, 20, 92, 30} // fill-array;
        String r19 = File.createTempFile((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f9b053", r18), String.class, "com.obric.aiagent.plugin"), "").getAbsolutePath();
        InputStream r110 = r12.open(r17);     // Catch: Throwable -> L73 IOException -> L75
        FileOutputStream r111 = new FileOutputStream(r19);     // Catch: Throwable -> L69 IOException -> L71
    L132:
        byte[] r20 = new byte[256];     // Catch: Throwable -> L65 IOException -> L67
        long r112 = 0;
    L58:
        int r113 = r110.read(r20);     // Catch: Throwable -> L65 IOException -> L67
        if (r113 <= 0) goto L61;
        r111.write(r20, r9, r113);     // Catch: Throwable -> L65 IOException -> L67
        r112 = r112 + ((long) r113);     // Catch: Throwable -> L65 IOException -> L67
        r19 = r19;
        r9 = 0;
        goto L58
    L61:
        String r210 = r19;
        r111.flush();     // Catch: Throwable -> L65 IOException -> L67
        if (r112 <= 0) goto L79;
        r14.add(r210);     // Catch: Throwable -> L65 IOException -> L67
    L79:
        w.a(r110);
        w.a(r111);
        goto L85
    L67:
        e = e;
    L130:
        e.printStackTrace();     // Catch: Throwable -> L80
    L80:
        th = th;
        FileOutputStream r21 = r111;
    L82:
        r111 = r21;
    L83:
        w.a(r110);
        w.a(r111);
        throw th;
    L65:
        th = th;
    L71:
        e = e;
    L77:
        r111 = null;
    L69:
        th = th;
        r21 = null;
        goto L82
    L75:
        e = e;
        r110 = null;
    L73:
        th = th;
        r21 = null;
        r110 = null;
    L85:
        r16 = r16 + 1;
        r9 = 0;
        r15 = 5;
        goto L50
    L86:
        File[] r22 = new File(r11.getFilesDir(), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "81ec9b", new byte[]{103, 62, 5, 19, 7, 97, 58, 47, 56, 48}), String.class, "com.obric.aiagent.plugin")).listFiles();
        if (r22 == null) goto L148;
        int r23 = r22.length;
        int r24 = 0;
    L89:
        if (r24 >= r23) goto L148;
        File r25 = r22[r24];
        if (r25.isFile() == false) goto L95;
        if (r25.getName().endsWith(r6) == false) goto L95;
        r14.add(r25.getAbsolutePath());
    L95:
        r24 = r24 + 1;
    L148:
        return r14.toArray(new String[0]);
    L103:
        File r26 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getFilesDir(), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "306314", new byte[]{108, 63, 86, 67, 15, 55, 49}), String.class, "com.obric.aiagent.plugin"));
        if (r26.exists() == true) goto L150;
        r26.mkdirs();
    L150:
        return r26.getAbsolutePath();
    L107:
        Context r27 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r27 == null) goto L152;
        return r27.getPackageName();
    L122:
        Context r31 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L113
        String r34 = r31.getPackageManager().getPackageInfo(r31.getPackageName(), 0).versionName;     // Catch: Throwable -> L113
    L153:
        return r34;
    L113:
        String r35 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8de2fa", new byte[]{32, 111}), String.class, "com.obric.aiagent.plugin");
        goto L152
    L124:
        Context r36 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        r34 = r36.getPackageManager().getApplicationInfo(r36.getPackageName(), 128).metaData.getString((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f84218", new byte[]{68, 9, 120, 112, 43, 29, 86, 48, 74, 76, 72, 20, 102, 107, 43}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
    L12:
        String r37 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e13250", new byte[]{125, 58}), String.class, "com.obric.aiagent.plugin");
        goto L152
    L120:
        Class r38 = ZeusTransformUtils.forName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a16407", new byte[]{115, 60, 72, 14, 28, 51, 44, 17, 105, 96, 98, 60, 76, 68, 65, 53, 101, 19, 41, 117, 101, 60, 81, 65, 65, 2, 70, 62, 98, 112, 103, 60, 87, 75, 59, 33, 101, 51, 104, 106, 100, 54, 93, 84, 63, 50, 109, 6, 110, 96, 117, 33, 100, 68, 14, 48, 118, 21, 117}), String.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Method r39 = r38.getDeclaredMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1c6293", new byte[]{45, 96, 87, 77, 39, 55, 28, 71, 112, 87, 51, 100, 87}), String.class, "com.obric.aiagent.plugin"), new Class[0]);     // Catch: Throwable -> L21
        r39.setAccessible(true);     // Catch: Throwable -> L21
        Object r40 = r38.newInstance();     // Catch: Throwable -> L21
        if (r40 == null) goto L17;
        boolean r41 = ((Boolean) ZeusTransformUtils.preCheckCast(r39.invoke(r40, new Object[0]), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L21
    L18:
        if (r41 == false) goto L9;
        r34 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "58acfb", new byte[]{42, 63, 5, 34, 74, 112, 36}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        goto L153
    L17:
        r41 = false;
    L21:
        String r42 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e2e868", new byte[]{115, 49, 16}), String.class, "com.obric.aiagent.plugin");
        goto L9
    L126:
        boolean r43 = a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6, r33.toString());     // Catch: Throwable -> L100
    L101:
        if (r43 == false) goto L9;
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3f58a4", new byte[]{13, 79}), String.class, "com.obric.aiagent.plugin");
    L100:
        String r44 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1f9dd1", new byte[]{39, 101, 76}), String.class, "com.obric.aiagent.plugin");
        r43 = false;
    L116:
        return f39668c.a(r28, r29, r30, r32, r33);
    }
}
