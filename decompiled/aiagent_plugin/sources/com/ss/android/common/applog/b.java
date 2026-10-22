package com.ss.android.common.applog;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLogCache.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f37155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<a> f37156b;

    /* JADX INFO: compiled from: AppLogCache.java */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f37157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f37158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f37159c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f37160d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f37161e;
        boolean f;
        JSONObject g;
        final /* synthetic */ b h;

        a(b r1, String r2, String r3, String r4, long r5, long r7, boolean r9, JSONObject r10) {
            this.h = r1;
            this.f37157a = r2;
            this.f37158b = r3;
            this.f37159c = r4;
            this.f37160d = r5;
            this.f37161e = r7;
            this.f = r9;
            this.g = r10;
        }
    }

    public b() {
        this.f37156b = new LinkedList();
    }

    static b a() {
        if (f37155a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f37155a != null) goto L9;
        f37155a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f37155a;
    }

    void a(String r16, String r17, String r18, long r19, long r21, boolean r23, JSONObject r24) {
        LinkedList<a> r12 = this.f37156b;
        monitor-enter(r12);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f37156b.size() <= 200) goto L9;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f37156b.poll(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        LogTrace.a(1, 1, null);     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.m);     // Catch: Throwable -> L12
    L9:
        this.f37156b.add(new a(this, r16, r17, r18, r19, r21, r23, r24));     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
    }
}
