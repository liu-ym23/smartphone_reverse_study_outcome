package com.bytedance.apm;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: ZstdDictManager.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements com.bytedance.services.apm.api.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f4726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f4727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4729e;

    public l() {
    }

    @Override // com.bytedance.services.apm.api.l
    public Pair<byte[], String> a() {
        b();
        byte[] r0 = this.f4727c;
        if (r0 != null) goto L5;
    L6:
        c();
        r0 = this.f4727c;
    L8:
        return new Pair(r0, this.f4729e);
    L5:
        if ((System.currentTimeMillis() - this.f4728d) <= 604800000) goto L8;
        goto L6
    }

    private void b() {
        if (this.f4726b == false) goto L5;
        return;
    L5:
        this.f4727c = com.bytedance.apm6.util.c.a(new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir(), "monitor_dict"));
        SharedPreferences r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSharedPreferences("dict_interval", 0);
        this.f4728d = r0.getLong("dict_interval", 0);
        this.f4729e = r0.getString("dict_version", null);
        this.f4726b = true;
    }

    private void c() {
        HashMap r2 = new HashMap(com.bytedance.apm6.foundation.context.a.t());
        r2.put("slardar_zstd_dict_type", "monitor");
        r2.put("zstd_client_code_version", "dynamic");
        r2.put(DownloadHelper.CONTENT_TYPE, "application/json; charset=utf-8");
        byte[] r3 = new JSONObject(r2).toString().getBytes();     // Catch: Exception -> L13
        com.bytedance.services.apm.api.c r4 = com.bytedance.apm6.foundation.context.a.a(com.bytedance.apm6.util.k.a(this.f4725a, r2), r2, r3);     // Catch: Exception -> L13
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.b() == null) goto L19;
        JSONObject r5 = new JSONObject(new String(r4.b()));     // Catch: Exception -> L13
        String r6 = r5.getString("dict_version");     // Catch: Exception -> L13
        String r7 = r5.getString("dict");     // Catch: Exception -> L13
        if (r5.getInt(MonitorConstants.CODE) == 200) goto L10;
        return;
    L10:
        byte[] r8 = Base64.decode(r7, 0);     // Catch: Exception -> L13
        a(new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir(), "monitor_dict"), r8);     // Catch: Exception -> L13
        this.f4729e = r6;     // Catch: Exception -> L13
        this.f4727c = r8;     // Catch: Exception -> L13
        this.f4728d = System.currentTimeMillis();
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSharedPreferences("dict_interval", 0).edit().putLong("dict_interval", this.f4728d).putString("dict_version", r6).commit();
        return;
    L19:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.services.apm.api.l
    public void a(String r3) {
        this.f4725a = "https://" + r3 + "/monitor/collect/zstd_dict/";
    }

    private static void a(File r2, byte[] r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.length == 0) goto L30;
        r2.getParentFile().mkdirs();
        FileOutputStream r0 = null;
    L18:
        th = th;
    L19:
        com.bytedance.apm6.util.d.b(r0);
        throw th;
    L10:
        if (r2.exists() == false) goto L12;
        r2.delete();     // Catch: Throwable -> L18 Exception -> L23
    L12:
        r2.exists();     // Catch: Throwable -> L18 Exception -> L23
        FileOutputStream r1 = new FileOutputStream(r2);     // Catch: Throwable -> L18 Exception -> L23
        r1.write(r3);     // Catch: Throwable -> L15 Exception -> L17
        r1.flush();     // Catch: Throwable -> L15 Exception -> L17
        com.bytedance.apm6.util.d.b(r1);
        return;
    L17:
        r0 = r1;
    L15:
        th = th;
        r0 = r1;
        goto L19
    L21:
        com.bytedance.apm6.util.d.b(r0);
        return;
    }
}
