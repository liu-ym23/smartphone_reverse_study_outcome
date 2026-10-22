package com.bytedance.crash.resource.b;

import android.content.Context;
import android.os.Build;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.r;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: GwpAsanAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.crash.resource.b {
    private static final String TAG = "NPTH_XASAN: ";
    private static a i;
    private b h;

    /* JADX INFO: renamed from: com.bytedance.crash.resource.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GwpAsanAdapter.java */
    static class C0173a extends com.bytedance.crash.resource.b.a {
        public C0173a(com.bytedance.crash.monitor.a r1, File r2) {
            super(r1, r2);
        }

        @Override // com.bytedance.crash.resource.b.a
        public boolean a(File r20, com.bytedance.crash.resource.b.C0172b r21) {
            String r1 = "Use After Free";
            String r5 = a.TAG;
            File r6 = new File(r20, "tombstone.txt");
            if (r6.exists() == true) goto L160;
            return false;
        L160:
            JSONArray r7 = j.b(r6.getAbsolutePath());     // Catch: Throwable -> L154
            if (r7 != null) goto L9;
            r.c(a.TAG, "parseReport  native stack is null");     // Catch: Throwable -> L154
            return false;
        L9:
            int r8 = a(r7, 0, "pid:");     // Catch: Throwable -> L154
            if (r8 >= 0) goto L13;
            r.c(a.TAG, "parseReport  pid index err");     // Catch: Throwable -> L154
            return false;
        L13:
            String[] r10 = r7.optString(r8, null).trim().split("\\s");     // Catch: Throwable -> L154
            int r11 = 0;
        L15:
            if (r11 >= r10.length) goto L26;
            String r12 = r10[r11];     // Catch: Throwable -> L154
            if ("pid:".equals(r12) == false) goto L20;
            int r13 = r11 + 1;     // Catch: Throwable -> L154
            r21.f = Long.decode(r10[r13].substring(0, r10[r13].length() - 1)).intValue();     // Catch: Throwable -> L154
        L25:
            r11 = r11 + 1;     // Catch: Throwable -> L154
            goto L15
        L20:
            if ("tid:".equals(r12) == false) goto L23;
            int r14 = r11 + 1;     // Catch: Throwable -> L154
            r21.g = Long.decode(r10[r14].substring(0, r10[r14].length() - 1)).intValue();     // Catch: Throwable -> L154
            goto L25
        L23:
            if ("name:".equals(r12) == false) goto L25;
            int r15 = r11 + 1;     // Catch: Throwable -> L154
            r21.f7707c = r10[r15].substring(0, r10[r15].length() - 1);     // Catch: Throwable -> L154
            goto L25
        L26:
            r21.f7709e = r10[r10.length - 2];     // Catch: Throwable -> L154
            StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L154
            int r9 = a(r7, r8 + 1, "Signal ");     // Catch: Throwable -> L154
            if (r9 >= 0) goto L30;
            r.c(a.TAG, "parseReport  signal index err");     // Catch: Throwable -> L154
            return false;
        L30:
            r4.append(r7.optString(r9, null)).append('\n');     // Catch: Throwable -> L154
            int r16 = a(r7, r9 + 1, "GWP-ASan message:");     // Catch: Throwable -> L154
            if (r16 >= 0) goto L34;
            r.c(a.TAG, "parseReport abort msg index err");     // Catch: Throwable -> L154
            return false;
        L34:
            String r2 = r7.optString(r16, null).replace("GWP-ASan message:", "abort message:");     // Catch: Throwable -> L154
            r4.append(r2).append('\n');     // Catch: Throwable -> L154
            if (r2.contains("Use After Free") == false) goto L39;
        L51:
            int r3 = a(r7, r16 + 1, "backtrace:");     // Catch: Throwable -> L154 Throwable -> L154
            if (r3 >= 0) goto L55;
            r.c(a.TAG, "parseReport backtrace index err");     // Catch: Throwable -> L154 Throwable -> L154
            return false;
        L55:
            String r17 = "    #00";
            int r18 = r3 + 1;
            String r19 = "None";
            String r110 = "None";
        L58:
            String r111 = r17;
            String r22 = "==/lib/";
            String r112 = r19;
            if (r18 >= r7.length()) goto L88;
            String r113 = r7.optString(r18, null);     // Catch: Throwable -> L154 Throwable -> L154
            if (r113.startsWith("    #") == false) goto L88;
            String r114 = r5;
            r4.append(r113.trim()).append('\n');     // Catch: Throwable -> L152
            if ("Double Free".equals(r1) == false) goto L68;
            String r115 = "    #03";
        L70:
            if (r113.endsWith("libc.so") == true) goto L81;
            if (r113.endsWith("libc++_shared.so") == true) goto L81;
            if (r113.startsWith(r115) == false) goto L87;
            String[] r23 = a(r113, "==/lib/", ".so").trim().split("/");     // Catch: Throwable -> L152
            if (r23 == null) goto L87;
            if (r23.length <= 1) goto L87;
            r110 = r23[1].substring(r23[1].lastIndexOf(47) + 1);     // Catch: Throwable -> L152
        L87:
            r18 = r18 + 1;     // Catch: Throwable -> L152
            r17 = r115;
            r19 = r112;
            r5 = r114;
        L81:
            if (r113.startsWith("    #01") == false) goto L87;
            String[] r24 = a(r113, "==/lib/", ".so").trim().split("/");     // Catch: Throwable -> L152
            if (r24 == null) goto L87;
            if (r24.length <= 1) goto L87;
            r110 = r24[1].substring(r24[1].lastIndexOf(47) + 1);     // Catch: Throwable -> L152
            goto L87
        L68:
            r115 = r111;
        L152:
            e = e;
        L156:
            r.c(r114, "parseReport :" + e);
            return false;
        L88:
            r114 = r5;
            r21.f7706b = r4.toString();     // Catch: Throwable -> L152
            int r25 = a(r7, r18, "deallocated by thread") + 1;     // Catch: Throwable -> L152
            String r26 = r112;
        L91:
            if (r25 >= r7.length()) goto L115;
            String r116 = r7.optString(r25, null);     // Catch: Throwable -> L152 Throwable -> L152
            if (r116.startsWith("    #01") == true) goto L98;
            if (r116.startsWith("    #02") == true) goto L98;
        L112:
            r26 = r26;
        L113:
            r25 = r25 + 1;     // Catch: Throwable -> L152 Throwable -> L152
        L98:
            if (r116.endsWith("libnpth_xasan.so") == true) goto L112;
            if (r116.endsWith("libc++_shared.so") == true) goto L112;
            String[] r27 = a(r116, "==/lib/", ".so").trim().split("/");     // Catch: Throwable -> L152 Throwable -> L152
            if (r27 == null) goto L112;
            if (r27.length <= 1) goto L112;
            String r28 = r27[1].substring(r27[1].lastIndexOf(47) + 1);     // Catch: Throwable -> L152 Throwable -> L152
            if (r28.length() >= 1) goto L108;
        L110:
            r26 = r28;
            goto L113
        L108:
            if (r28.isEmpty() == true) goto L110;
            r26 = r28;
        L115:
            int r29 = a(r7, r25, "allocated by thread") + 1;     // Catch: Throwable -> L152 Throwable -> L152
        L117:
            if (r29 >= r7.length()) goto L137;
            String r117 = r7.optString(r29, null);     // Catch: Throwable -> L152 Throwable -> L152
            if (r117.startsWith("    #01") == true) goto L123;
            if (r117.startsWith("    #02") == true) goto L123;
        L135:
            String r118 = r22;
        L136:
            r29 = r29 + 1;     // Catch: Throwable -> L152 Throwable -> L152
            r22 = r118;
        L123:
            if (r117.endsWith("libnpth_xasan.so") == true) goto L135;
            if (r117.endsWith("libc++_shared.so") == true) goto L135;
            String[] r30 = a(r117, r22, ".so").trim().split("/");     // Catch: Throwable -> L152 Throwable -> L152
            if (r30 == null) goto L135;
            r118 = r22;
            if (r30.length <= 1) goto L136;
            r112 = r30[1].substring(r30[1].lastIndexOf(47) + 1);     // Catch: Throwable -> L152 Throwable -> L152
            if (r112.length() < 1) goto L136;
            if (r112.isEmpty() == true) goto L136;
        L137:
            String r31 = r112;
            int r32 = a(r7, r29, "build id:");     // Catch: Throwable -> L152 Throwable -> L152
            if (r32 <= 0) goto L149;
            int r33 = r32 + 1;     // Catch: Throwable -> L152 Throwable -> L152
        L141:
            if (r33 >= r7.length()) goto L149;
            String r34 = r7.optString(r33, null);     // Catch: Throwable -> L152 Throwable -> L152
            if (r34.startsWith("    /") == false) goto L148;
            String[] r35 = r34.trim().split("\\s");     // Catch: Throwable -> L152 Throwable -> L152
            if (r35.length < 3) goto L148;
            r21.h.put(new JSONObject().put("lib_name", r35[0].substring(r35[0].lastIndexOf(47) + 1)).put("lib_uuid", a(r35[r35.length - 1].substring(0, r35[r35.length - 1].length() - 1))));     // Catch: Throwable -> L152 Throwable -> L152
        L148:
            r33 = r33 + 1;     // Catch: Throwable -> L152 Throwable -> L152
        L149:
            r21.i.put("gwp_asan_type", r1);     // Catch: Throwable -> L152 Throwable -> L152
            r21.i.put("gwp_asan_fatal_lib", r110);     // Catch: Throwable -> L152 Throwable -> L152
            r21.i.put("gwp_asan_deallocated_lib", r26);     // Catch: Throwable -> L152 Throwable -> L152
            r21.i.put("gwp_asan_allocated_lib", r31);     // Catch: Throwable -> L152 Throwable -> L152
            return true;
        L39:
            if (r2.contains("Double Free") == false) goto L42;
            r1 = "Double Free";
            goto L51
        L42:
            if (r2.contains("Buffer Overflow") == false) goto L45;
            r1 = "Buffer Overflow";
            goto L51
        L45:
            if (r2.contains("Buffer Underflow") == false) goto L48;
            r1 = "Buffer Underflow";
            goto L51
        L48:
            if (r2.contains("Invalid Free") == false) goto L50;
            r1 = "Invalid Free";
            goto L51
        L50:
            r1 = "Unknown";
        L154:
            e = e;
            r114 = a.TAG;
            goto L156
        }

        @Override // com.bytedance.crash.resource.b.a
        public void a(Map<String, String> r3, com.bytedance.crash.resource.b.C0172b r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            super.a(r5, r4);
            if (r4.f7706b.isEmpty() == true) goto L5;
            String r2 = "true";
        L6:
            r5.put("has_gwp_asan", r2);
            r5.put("gwp_asan_app", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName());
            return;
        L5:
            r2 = "false";
            goto L6
        }

        private static String a(String r2, String r3, String r4) {
            int r0 = r2.indexOf(r3);
            int r5 = r2.indexOf(r4);
            if (r0 >= 0) goto L5;
            return "null";
        L5:
            if (r5 >= 0) goto L8;
            return "null";
        L8:
            return r2.substring(r0, r5).substring(r3.length());
        }
    }

    static {
    }

    @Override // com.bytedance.crash.resource.b
    public void b() {
    }

    public a() {
    }

    public static a f() {
        if (i != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (i != null) goto L9;
        i = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return i;
    }

    public static void g() {
    L22:
        e = move-exception;
        r.c(TAG, "GwpAsanStart err:" + e);
        return;
    L3:
        if (NativeBridge.g() == true) goto L6;
        r.a("xasan 32bit app Not supported");     // Catch: IOException -> L22
        return;
    L6:
        a r0 = f();     // Catch: IOException -> L22
        if (r0.g == false) goto L11;
        r.a("xasan has init");     // Catch: IOException -> L22
        return;
    L11:
        if (Build.VERSION.SDK_INT >= 21) goto L13;
        return;
    L13:
        if (Build.VERSION.SDK_INT > 34) goto L27;
        String r1 = com.bytedance.crash.resource.f.b.c().getAbsolutePath() + "/" + com.bytedance.crash.crash.b.b();     // Catch: IOException -> L22
        if (com.bytedance.crash.resource.f.b.c().exists() == true) goto L17;
        com.bytedance.crash.resource.f.b.c().mkdirs();     // Catch: IOException -> L22
    L17:
        String r2 = i.e();     // Catch: IOException -> L22
        File r3 = new File(r2, "xasan.config");     // Catch: IOException -> L22
        if (r3.exists() == true) goto L20;
        r3.createNewFile();     // Catch: IOException -> L22
    L20:
        j.a(r3, new b(com.bytedance.crash.monitor.b.f()).toString(), false);     // Catch: IOException -> L22
        NativeResourceMonitor.a(Build.VERSION.SDK_INT, r1, r2);     // Catch: IOException -> L22
        r0.g = true;     // Catch: IOException -> L22
        return;
    }

    @Override // com.bytedance.crash.resource.b
    public boolean d() {
        return NativeBridge.g();
    }

    public static void a(b r1) {
        a r0 = f();
        r0.h = r1;
        r0.a(r1);
    }

    public static void a(com.bytedance.crash.monitor.a r2) {
        new C0173a(r2, com.bytedance.crash.resource.f.b.c()).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        r.c(TAG, "upload exception:" + th);
    }
}
