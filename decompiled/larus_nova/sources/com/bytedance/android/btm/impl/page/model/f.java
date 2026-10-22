package com.bytedance.android.btm.impl.page.model;

import android.app.Activity;
import com.bytedance.android.btm.impl.page.PageWoods;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f42347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f42348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f42349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f42350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.btm.impl.util.f<Object> f42351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f42352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f42353g;

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final Object a() {
        return this.f42351e.get();
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final h b() {
        ConcurrentHashMap<com.bytedance.android.btm.impl.util.f<Activity>, h> r100 = PageWoods.f42253a;
        String r101 = this.f42348b;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L22;
        Iterator<Map.Entry<com.bytedance.android.btm.impl.util.f<Activity>, h>> r103 = PageWoods.f42253a.entrySet().iterator();
    L14:
        if (r103.hasNext() == false) goto L23;
        Map.Entry<com.bytedance.android.btm.impl.util.f<Activity>, h> r104 = r103.next();
        if (Intrinsics.areEqual(r104.getValue().f42354a, r101) == false) goto L14;
        return r104.getValue();
    L23:
        return null;
    L22:
        return null;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final d getParentNode() {
        String r100 = this.f42349c;
        if (r100 == null) goto L9;
        h r101 = b();
        if (r101 == null) goto L9;
        ConcurrentHashMap<String, f> r102 = r101.f42355b;
        if (r102 == null) goto L9;
        return r102.get(r100);
    L9:
        return null;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final d j() {
        String r100 = this.f42350d;
        if (r100 == null) goto L9;
        h r101 = b();
        if (r101 == null) goto L9;
        ConcurrentHashMap<String, f> r102 = r101.f42355b;
        if (r102 == null) goto L9;
        return r102.get(r100);
    L9:
        return null;
    }

    public final String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("is_page", this.f42352f);     // Catch: Throwable -> L6
        r100.put("is_container", this.f42353g);     // Catch: Throwable -> L6
        r100.put("node_id", this.f42347a);     // Catch: Throwable -> L6
        r100.put("tree_id", this.f42348b);     // Catch: Throwable -> L6
        r100.put("parent_node_id", this.f42349c);     // Catch: Throwable -> L6
        r100.put("pre_node_id", this.f42350d);     // Catch: Throwable -> L6
    L5:
        return r100.toString();
    }

    @Override // xc.a
    public final String save() {
        return toString();
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final String d() {
        return this.f42348b;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final String h() {
        return this.f42347a;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final boolean i() {
        return this.f42352f;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final boolean isContainer() {
        return this.f42353g;
    }

    public f(Object r100) {
        this.f42347a = com.bytedance.android.btm.impl.util.e.b();
        this.f42351e = new com.bytedance.android.btm.impl.util.f(r100);
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void c(d r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.h();
    L6:
        this.f42349c = r102;
        if (r100 == null) goto L9;
        r101 = r100.d();
    L9:
        this.f42348b = r101;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void f(String r100) {
        this.f42347a = r100;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void g(d r100) {
        if (r100 == null) goto L4;
        String r101 = r100.h();
    L5:
        this.f42350d = r101;
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // xc.a
    public final Object parse(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L4
        this.f42352f = r101.optBoolean("is_page");     // Catch: Exception -> L4
        this.f42353g = r101.optBoolean("is_container");     // Catch: Exception -> L4
        this.f42347a = r101.optString("node_id");     // Catch: Exception -> L4
        this.f42348b = r101.optString("tree_id");     // Catch: Exception -> L4
        this.f42349c = r101.optString("parent_node_id");     // Catch: Exception -> L4
        this.f42350d = r101.optString("pre_node_id");     // Catch: Exception -> L4
    L6:
        return this;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void e(boolean r100, boolean r101) {
        this.f42352f = r100;
        this.f42353g = r101;
    }
}
