package com.bytedance.apm;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.IHttpService;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements ff7.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f190620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f190621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f190622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f190623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f190624e;

    public m() {
    }

    @Override // ff7.k
    public final Pair<byte[], String> a() {
        PolarisFileOutputStreamWrapper r100 = null;
        if (this.f190621b == true) goto L6;
        this.f190622c = xu3.b.b(new PolarisFileWrapper(xu3.a.getContext().getFilesDir(), "monitor_dict"));
        SharedPreferences r101 = xu3.a.getContext().getSharedPreferences("dict_interval", 0);
        this.f190623d = r101.getLong("dict_interval", 0);
        this.f190624e = r101.getString("dict_version", null);
        this.f190621b = true;
    L6:
        byte[] r102 = this.f190622c;
        if (r102 != null) goto L9;
    L10:
        HashMap r103 = new HashMap(du3.a.m());
        r103.put("slardar_zstd_dict_type", "monitor");
        r103.put("zstd_client_code_version", "dynamic");
        r103.put("Content-Type", "application/json; charset=utf-8");
        byte[] r104 = new JSONObject(r103).toString().getBytes();     // Catch: Exception -> L42
        String r105 = xu3.h.a(this.f190620a, r103);     // Catch: Exception -> L42
        ff7.b r106 = ((IHttpService) qu3.c.a(IHttpService.class)).doPost(r105, r104, r103);     // Catch: Exception -> L42
        if (r106 != null) goto L14;
    L44:
        r102 = this.f190622c;
    L46:
        return new Pair(r102, this.f190624e);
    L14:
        if (r106.f476669c == null) goto L44;
        JSONObject r107 = new JSONObject(new String(r106.f476669c));     // Catch: Exception -> L42
        String r108 = JSONObjectProtectorUtils.getString(r107, "dict_version");     // Catch: Exception -> L42
        String r109 = JSONObjectProtectorUtils.getString(r107, "dict");     // Catch: Exception -> L42
        if (JSONObjectProtectorUtils.getInt(r107, "code") != 200) goto L44;
        byte[] r110 = Base64.decode(r109, 0);     // Catch: Exception -> L42
        PolarisFileWrapper r111 = new PolarisFileWrapper(xu3.a.getContext().getFilesDir(), "monitor_dict");     // Catch: Exception -> L42
        if (r110 != null) goto L21;
    L40:
        this.f190624e = r108;     // Catch: Exception -> L42
        this.f190622c = r110;     // Catch: Exception -> L42
        this.f190623d = System.currentTimeMillis();
        xu3.a.getContext().getSharedPreferences("dict_interval", 0).edit().putLong("dict_interval", this.f190623d).putString("dict_version", r108).commit();
        goto L44
    L21:
        if (r110.length == 0) goto L40;
        r111.getParentFile().mkdirs();     // Catch: Exception -> L42
    L34:
        th = th;
    L35:
        if (r100 != null) goto L50;
    L37:
        throw th;     // Catch: Exception -> L42
    L50:
        r100.close();     // Catch: Throwable -> L47
        goto L37
    L25:
        if (r111.exists() == false) goto L27;
        r111.delete();     // Catch: Throwable -> L34 Exception -> L48
    L27:
        r111.exists();     // Catch: Throwable -> L34 Exception -> L48
        PolarisFileOutputStreamWrapper r112 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L34 Exception -> L48
        r112.write(r110);     // Catch: Throwable -> L31 Exception -> L33
        r112.flush();     // Catch: Throwable -> L31 Exception -> L33
        r112.close();     // Catch: Throwable -> L49
    L52:
        goto L40
    L33:
        r100 = r112;
    L31:
        th = th;
        r100 = r112;
        goto L35
    L38:
        if (r100 == null) goto L40;
        r100.close();     // Catch: Throwable -> L49
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L9:
        if ((System.currentTimeMillis() - this.f190623d) <= 604800000) goto L46;
        goto L10
    }

    @Override // ff7.k
    public final void setDomain(String r100) {
        this.f190620a = "https://" + r100 + "/monitor/collect/zstd_dict/";
    }
}
