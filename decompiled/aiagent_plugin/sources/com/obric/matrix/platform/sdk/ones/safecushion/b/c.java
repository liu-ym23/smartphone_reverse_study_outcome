package com.obric.matrix.platform.sdk.ones.safecushion.b;

import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f.k;
import d.h.b.o;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SafeCushionFileUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "SafeCushionFileUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f33722a = null;

    static {
        f33722a = new c();
    }

    private c() {
    }

    public final File a() {
        File r0 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.safecushion.c.f33723a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getFilesDir(), "safeCushionCrashInfo");
        if (r0.isDirectory() == true) goto L6;
        a(r0);
    L6:
        if (r0.exists() == true) goto L8;
        r0.mkdir();
    L8:
        return r0;
    }

    public final File a(String r10) {
        o.e(r10, "fileNamePrefix");
        File r2 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.safecushion.c.f33723a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getFilesDir(), "safeCushionCrashInfo");     // Catch: Exception -> L24
        if (r2.exists() == true) goto L6;
    L26:
        return null;
    L6:
        if (r2.isDirectory() == false) goto L26;
        File[] r3 = r2.listFiles();     // Catch: Exception -> L24
        boolean r4 = true;
        if (r3 != null) goto L10;
    L16:
        if (r4 == true) goto L26;
        o.c(r3, "crashFiles");     // Catch: Exception -> L24
        int r5 = r3.length;     // Catch: Exception -> L24
        int r6 = 0;
    L18:
        if (r6 >= r5) goto L26;
        File r7 = r3[r6];     // Catch: Exception -> L24
        String r8 = r7.getName();     // Catch: Exception -> L24
        o.c(r8, "it.name");     // Catch: Exception -> L24
        if (d.o.o.b(r8, r10, false, 2, null) == true) goto L21;
        r6 = r6 + 1;
        goto L18
    L21:
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "getSafeModeFile: " + r7.getName(), null, 4, null);     // Catch: Exception -> L24
        return r7;
    L10:
        if (r3.length != 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == true) goto L16;
        r4 = false;
        goto L16
    L12:
        r9 = false;
    L24:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "getSafeCushion: error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L26
    }

    public final void a(String r5, String r6) {
        o.e(r5, "fileNamePrefix");
        o.e(r6, "updateFileName");
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "createOrUpdateSafeCushionFile fileNamePrefix:" + r5 + ",updateFileName:" + r6, null, 4, null);     // Catch: Exception -> L8
        File r7 = a(r5);     // Catch: Exception -> L8
        File r1 = new File(a(), r6);     // Catch: Exception -> L8
        if (r7 == null) goto L6;
        a(r7, r1);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        r1.createNewFile();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "createOrUpdateSafeCushionFile: error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final void a(File r2, File r3) {
        o.e(r2, "currentFile");
        o.e(r3, "updateFile");
        if (r2.renameTo(r3) == true) goto L6;
        a(r2);
        r3.createNewFile();
        return;
    }

    public final String a(String r2, int r3, int r4) {
        o.e(r2, "fileNamePrefix");
        return a(a(r2), r3, r4);
    L5:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.e(TAG, "getSafeCushionSpiltFileName: " + e, null, 4, null);
        return null;
    }

    public final String a(File r9, int r10, int r11) {
        if (r9 != null) goto L5;
    L10:
        return null;
    L5:
        if (r9.exists() == false) goto L10;
        String r12 = r9.getName();
        o.c(r12, "file.name");
        List r13 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);
        if (r13.size() != r10) goto L10;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.get(r11), String.class, "com.obric.aiagent.plugin");
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "getSpiltFileName: " + r14, null, 4, null);
        return r14;
    }

    public final void a(String r3, String r4, String r5, int r6) {
        o.e(r3, "crashType");
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
        r0.put("crash_type", r3);     // Catch: Exception -> L7
        r0.put("crash_msg", r4);     // Catch: Exception -> L7
        r0.put("crash_count", r6);     // Catch: Exception -> L7
        r0.put("thread", r5);     // Catch: Exception -> L7
        r0.put(DBHelper.COL_TIME, String.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L7
        File r2 = a("crashInfo");     // Catch: Exception -> L7
        if (r2 == null) goto L12;
        String r7 = r0.toString();     // Catch: Exception -> L7
        o.c(r7, "jsonObject.toString()");     // Catch: Exception -> L7
        k.a(r2, r7, null, 2, null);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "saveCrashInfo:error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final boolean a(File r7) {
        o.e(r7, "dir");
        if (r7.isDirectory() == false) goto L15;
        String[] r0 = r7.list();
        if (r0 == null) goto L7;
        int r1 = r0.length;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L15;
        if (a(new File(r7, r0[r3])) == false) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return false;
    L7:
        return r7.delete();
    L15:
        return r7.delete();
    }
}
