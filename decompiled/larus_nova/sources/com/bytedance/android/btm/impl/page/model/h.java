package com.bytedance.android.btm.impl.page.model;

import android.app.Activity;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class h implements xc.a<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f42354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, f> f42355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f42356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f42357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f42358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f42359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActivityResumeOrigin f42360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f42361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<com.bytedance.android.btm.impl.util.f<Object>> f42362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<com.bytedance.android.btm.impl.util.f<Object>> f42363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<com.bytedance.android.btm.impl.util.f<Object>, ResumeFuncOrigin> f42364k;

    public final Collection<? extends d> n() {
        if (BtmSetting.f42469d.c().d().q() == 1) goto L5;
        d r100 = this.f42356c;
        if (r100 == null) goto L11;
        return ((e) r100).k();
    L11:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.btm.impl.page.model.Node");
    L5:
        return this.f42355b.values();
    }

    @Override // xc.a
    public final String save() {
        JSONObject r100 = new JSONObject();
        r100.put("tree_id", this.f42354a);     // Catch: Throwable -> L6
        r100.put("top_node_id", this.f42358e);     // Catch: Throwable -> L6
        r100.put("root_node", this.f42356c.save());     // Catch: Throwable -> L6
    L5:
        return r100.toString();
    }

    public final String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("tree_id", this.f42354a);     // Catch: Throwable -> L10
        r100.put("root_node_id", this.f42356c.h());     // Catch: Throwable -> L10
        r100.put("top_node_id", this.f42358e);     // Catch: Throwable -> L10
        r100.put("mResumed", this.f42357d);     // Catch: Throwable -> L10
        r100.put("activityResumeOrigin", this.f42360g);     // Catch: Throwable -> L10
        r100.put("activityResumeOriginV2", this.f42361h);     // Catch: Throwable -> L10
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L10
        Iterator<Map.Entry<String, f>> r102 = this.f42355b.entrySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L7;
        Map.Entry<String, f> r103 = r102.next();     // Catch: Throwable -> L10
        r101.put(r103.getKey(), r103.getValue().toString());     // Catch: Throwable -> L10
        goto L5
    L7:
        r100.put("nodes", r101);     // Catch: Throwable -> L10
    L9:
        return r100.toString();
    }

    public h(Activity r100) {
        AtomicLong r101 = com.bytedance.android.btm.impl.util.e.f42500a;
        AtomicLong r102 = com.bytedance.android.btm.impl.util.e.f42501b;
        long r103 = r102.incrementAndGet();
        if (r103 <= 10000) goto L5;
        r102.set(0);
    L5:
        this.f42354a = "" + System.currentTimeMillis() + "_" + r103;
        ConcurrentHashMap<String, f> r104 = new ConcurrentHashMap();
        this.f42355b = r104;
        if (BtmSetting.f42469d.c().d().q() != 1) goto L8;
        f r105 = new f(r100);
        r105.f42348b = this.f42354a;
        r104.put(r105.f42347a, r105);
        d r106 = r105;
    L9:
        this.f42356c = r106;
        this.f42357d = true;
        this.f42361h = new a();
        this.f42362i = new ArrayList();
        this.f42363j = new ArrayList();
        this.f42364k = new LinkedHashMap();
        return;
    L8:
        e r107 = new e(r100);
        r107.f42339b = this;
        r106 = r107;
        goto L9
    }

    public final d l(Object r100) {
        Iterator<T> r101 = n().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        d r102 = (d) r101.next();
        if (Intrinsics.areEqual(r102.a(), r100) == false) goto L4;
        return r102;
    L8:
        return null;
    }

    public final d m(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        return null;
    L13:
        if (BtmSetting.f42469d.c().d().q() == 1) goto L15;
        Iterator<T> r102 = n().iterator();
    L18:
        if (r102.hasNext() == false) goto L22;
        d r103 = (d) r102.next();
        if (Intrinsics.areEqual(r103.h(), r100) == false) goto L18;
        return r103;
    L22:
        return null;
    L15:
        return this.f42355b.get(r100);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final void k(d r100, d r101) {
        r100.c(r101);
        if (BtmSetting.f42469d.c().d().q() == 1) goto L5;
        return;
    L5:
        if ((r100 instanceof f) == true) goto L7;
        r100 = null;
    L7:
        f r102 = (f) r100;
        if (r102 == null) goto L12;
        this.f42355b.put(r102.f42347a, r102);
        return;
    }
}
