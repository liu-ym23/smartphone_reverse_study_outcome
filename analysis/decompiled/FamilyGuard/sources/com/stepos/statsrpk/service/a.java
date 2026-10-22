package com.stepos.statsrpk.service;

import X2.a;
import android.content.Context;
import android.net.Uri;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import d3.C0667c;
import d3.C0668d;
import d3.C0672h;
import g3.C0742e;
import i3.C0759a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class a extends T2.c implements a.c {

    /* renamed from: d, reason: collision with root package name */
    private static final String f15984d = "a";

    /* renamed from: b, reason: collision with root package name */
    private C0759a f15985b;

    /* renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f15986c;

    /* renamed from: com.stepos.statsrpk.service.a$a, reason: collision with other inner class name */
    class RunnableC0198a implements Runnable {
        RunnableC0198a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a.this.c();
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15988a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15989b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TrackerPayload f15990c;

        b(String str, String str2, TrackerPayload trackerPayload) {
            this.f15988a = str;
            this.f15989b = str2;
            this.f15990c = trackerPayload;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a.this.k(this.f15988a, this.f15989b, this.f15990c);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15992a;

        c(String str) {
            this.f15992a = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a.this.j(this.f15992a);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a.this.c();
        }
    }

    public a(Context context, int i5) {
        super(context);
        this.f15986c = Executors.newScheduledThreadPool(i5);
        this.f15985b = new C0759a(context);
        X2.a.e(context).d(this);
        this.f15986c.schedule(new RunnableC0198a(), 1800000L, TimeUnit.MILLISECONDS);
    }

    private String b(String str, byte[] bArr) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        HashMap map = new HashMap();
        String strC = C0672h.c(bArr);
        builderBuildUpon.appendQueryParameter("md5", strC);
        map.put("md5", strC);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        String strValueOf = String.valueOf(jCurrentTimeMillis);
        builderBuildUpon.appendQueryParameter("ts", strValueOf);
        String strValueOf2 = String.valueOf(jCurrentTimeMillis + new Random().nextInt());
        builderBuildUpon.appendQueryParameter("nonce", strValueOf2);
        map.put("ts", strValueOf);
        map.put("nonce", strValueOf2);
        builderBuildUpon.appendQueryParameter("sign", C0668d.a("POST", str, map, null));
        return builderBuildUpon.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() throws Throwable {
        C0742e.c(f15984d, "flushQueueInternalByTimer");
        for (String str : this.f15985b.i()) {
            this.f15985b.f();
            h(str, this.f15985b.c(str));
        }
        this.f15986c.schedule(new d(), 1800000L, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void h(java.lang.String r10, java.util.ArrayList<T2.a> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.service.a.h(java.lang.String, java.util.ArrayList):void");
    }

    private boolean i(String str) {
        long jH = this.f15985b.h(str);
        boolean zC = C0667c.c(this.f5408a);
        C0742e.c(f15984d, "cacheCheck appKey:" + str + " ------------------ eventSize:" + jH + ", flushCacheLimit:5, networkAvailable:" + zC);
        return jH >= ((long) 5) && zC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) throws Throwable {
        C0742e.c(f15984d, "environmentChanged. changeName: " + str);
        List<String> listI = this.f15985b.i();
        if ("CHANGE_NAME_NETWORKCONNECT".equals(str)) {
            Iterator<String> it = listI.iterator();
            while (it.hasNext()) {
                l(it.next());
            }
        } else if ("CHANGE_NAME_POWER".equals(str)) {
            Iterator<String> it2 = listI.iterator();
            while (it2.hasNext()) {
                l(it2.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, String str2, TrackerPayload trackerPayload) throws Throwable {
        if (str == null || trackerPayload == null) {
            return;
        }
        C0742e.c(f15984d, "Queuing event for sending later, appKey:" + str + ", payload:" + trackerPayload);
        this.f15985b.f();
        if (this.f15985b.b(str, str2, trackerPayload) <= 0 || !i(str)) {
            return;
        }
        h(str, this.f15985b.c(str));
    }

    private void l(String str) throws Throwable {
        C0742e.c(f15984d, "flushQueueInternalWhenEnvChanged, appKey: " + str);
        this.f15985b.f();
        h(str, this.f15985b.c(str));
    }

    @Override // X2.a.c
    public void a(String str) {
        this.f15986c.execute(new c(str));
    }

    public void g(String str, String str2, TrackerPayload trackerPayload) {
        this.f15986c.execute(new b(str, str2, trackerPayload));
    }
}
