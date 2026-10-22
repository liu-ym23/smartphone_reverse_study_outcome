package com.bytedance.frameworks.baselib.network.http;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RotationHostRetryHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c.C0184c> f8393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<a> f8395c;

    /* JADX INFO: compiled from: RotationHostRetryHandler.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8399d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8400e;
        public boolean f;

        public a(String r1, String r2, int r3, long r4, long r6, boolean r8) {
            this.f8396a = r1;
            this.f8397b = r2;
            this.f8398c = r3;
            this.f8399d = r4;
            this.f8400e = r6;
            this.f = r8;
        }
    }

    public j(List<c.C0184c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        this.f8393a = r0;
        this.f8394b = 0;
        this.f8395c = new CopyOnWriteArrayList();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L10;
        r0.addAll(r4);
        return;
    }

    public boolean a() {
        if (this.f8393a.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f8394b >= this.f8393a.size()) goto L8;
        return false;
    }

    public c.C0184c b() {
        if (this.f8394b < this.f8393a.size()) goto L6;
        return null;
    L6:
        List<c.C0184c> r0 = this.f8393a;
        int r1 = this.f8394b;
        this.f8394b = r1 + 1;
        return (c.C0184c) ZeusTransformUtils.preCheckCast(r0.get(r1), c.C0184c.class, "com.obric.aiagent.plugin");
    }

    public void a(String r12, String r13, int r14, long r15, i r17, b r18) {
        if (r17 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean r10 = r1;
        if (r18.aa <= 0) goto L11;
        long r2 = r18.aa;
    L12:
        a r3 = new a(r12, r13, r14, r15, System.currentTimeMillis() - r2, r10);
        this.f8395c.add(r3);
        if (r18.f8138d == null) goto L16;
        r18.f8138d.b(c());
        return;
    L16:
        return;
    L11:
        r2 = r18.g;
        goto L12
    L5:
        if (r17.a() == false) goto L7;
        r1 = true;
        goto L8
    }

    public JSONObject c() {
        if (this.f8395c.isEmpty() == false) goto L6;
        return null;
    L6:
        JSONObject r0 = new JSONObject();
        Iterator<a> r6 = this.f8395c.iterator();     // Catch: JSONException -> L13
    L9:
        if (r6.hasNext() == false) goto L12;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L13
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L13
        r2.put("callback_duration", r1.f8399d);     // Catch: JSONException -> L13
        r2.put("request_duration", r1.f8400e);     // Catch: JSONException -> L13
        r2.put(MonitorConstants.CODE, r1.f8398c);     // Catch: JSONException -> L13
        r0.put(r1.f8396a + r1.f8397b, r2);     // Catch: JSONException -> L13
    L12:
        return r0;
    }

    public j d() {
        ArrayList r0 = new ArrayList();
        Iterator<c.C0184c> r1 = this.f8393a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(((c.C0184c) ZeusTransformUtils.preCheckCast(r1.next(), c.C0184c.class, "com.obric.aiagent.plugin")).a());
        goto L4
    L6:
        j r2 = new j(r0);
        r2.f8394b = this.f8394b;
        Iterator<a> r14 = this.f8395c.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.aiagent.plugin");
        r2.f8395c.add(new a(r3.f8396a, r3.f8397b, r3.f8398c, r3.f8399d, r3.f8400e, r3.f));
        goto L8
    L10:
        return r2;
    }
}
