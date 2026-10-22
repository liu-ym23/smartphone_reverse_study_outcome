package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f7823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f7824e;
    private Map<String, List<String>> f;

    public l(int r1) {
        this.f7820a = r1;
    }

    public l(int r1, byte[] r2) {
        this.f7820a = r1;
        this.f7824e = r2;
    }

    public l(int r1, Throwable r2) {
        this.f7820a = r1;
        if (r2 == null) goto L6;
        this.f7822c = r2.getMessage();
        return;
    }

    public l(int r1, String r2) {
        this.f7820a = r1;
        this.f7822c = r2;
    }

    public boolean a() {
        int r1 = this.f7820a;
        if (r1 != 207) goto L5;
    L7:
        return false;
    L5:
        if (r1 == 214) goto L7;
        return true;
    }

    public byte[] b() {
        return this.f7824e;
    }

    public void a(byte[] r1) {
        this.f7824e = r1;
    }

    public void a(int r1) {
        this.f7820a = r1;
    }

    public JSONObject c() {
        return this.f7823d;
    }

    public void a(JSONObject r7) {
        this.f7823d = r7;
        String r8 = "";
        if (this.f == null) goto L14;
        new ArrayList();     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, List<String>>> r1 = this.f.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r1.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if ("Alog_quota".equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin")) == false) goto L8;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3.getValue(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r4.size() <= 0) goto L8;
        r8 = (String) ZeusTransformUtils.preCheckCast(r4.get(0), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
    L14:
        this.f7823d.putOpt("Alog_quota", r8);     // Catch: Throwable -> L22
        String r9 = this.f7823d.optString("message");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r9) == false) goto L17;
        return;
    L17:
        if (r9.equals("drop all data") == false) goto L19;
    L20:
        a(213);     // Catch: Throwable -> L22
        return;
    L19:
        if (r9.equals("drop data") == true) goto L20;
        return;
    }

    public void b(int r1) {
        this.f7821b = r1;
    }

    public int d() {
        return this.f7820a;
    }

    public int e() {
        return this.f7821b;
    }

    public void a(String r1) {
        this.f7822c = r1;
    }

    public void a(Map<String, List<String>> r3) {
        this.f = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public String toString() {
        String r0 = "Response:mErrorCode=" + this.f7820a + ", mServerErrorCode=" + this.f7821b;
        if (this.f7823d != null) goto L5;
        return r0;
    L5:
        return r0 + ", mServerJson=" + this.f7823d.toString();
    }
}
