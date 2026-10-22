package com.bytedance.android.btm.impl.page.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Deprecated(message = "use NodeV2 instead.")
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f42338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f42339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.btm.impl.util.f<Object> f42340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f42341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f42342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f42343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f42344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<e> f42345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f42346i;

    @Override // xc.a
    public final Object parse(String r100) {
        return this;
    }

    @Override // xc.a
    public final String save() {
        return "";
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final Object a() {
        return this.f42340c.get();
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final String d() {
        h r100 = this.f42339b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f42354a;
    }

    public final List<e> k() {
        ArrayList r100 = new ArrayList();
        r100.add(this);
        Iterator<T> r101 = this.f42345h.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.addAll(((e) r101.next()).k());
        goto L4
    L6:
        return r100;
    }

    public final String toString() {
        JSONObject r100 = new JSONObject();
        Object r101 = this.f42340c.get();     // Catch: Throwable -> L21
        String r102 = null;
        if (r101 == null) goto L6;
        String r103 = r101.getClass().getName();     // Catch: Throwable -> L21
    L7:
        r100.put("class_name", r103);     // Catch: Throwable -> L21
        r100.put("is_page", this.f42342e);     // Catch: Throwable -> L21
        r100.put("is_container", this.f42343f);     // Catch: Throwable -> L21
        r100.put(GXTemplateKey.GAIAX_LAYER, this.f42341d);     // Catch: Throwable -> L21
        r100.put("node_id", this.f42338a);     // Catch: Throwable -> L21
        e r104 = this.f42344g;     // Catch: Throwable -> L21
        if (r104 == null) goto L10;
        String r105 = r104.f42338a;     // Catch: Throwable -> L21
    L11:
        r100.put("parent_node_id", r105);     // Catch: Throwable -> L21
        e r106 = this.f42346i;     // Catch: Throwable -> L21
        if (r106 == null) goto L14;
        r102 = r106.f42338a;     // Catch: Throwable -> L21
    L14:
        r100.put("pre_node_id", r102);     // Catch: Throwable -> L21
        JSONArray r107 = new JSONArray();     // Catch: Throwable -> L21
        Iterator r108 = ((ArrayList) this.f42345h).iterator();     // Catch: Throwable -> L21
    L16:
        if (r108.hasNext() == false) goto L18;
        r107.put(((e) r108.next()).toString());     // Catch: Throwable -> L21
        goto L16
    L18:
        r100.put("children", r107);     // Catch: Throwable -> L21
        goto L20
    L10:
        r105 = null;
        goto L11
    L6:
        r103 = null;
    L20:
        return r100.toString();
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final h b() {
        return this.f42339b;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final d getParentNode() {
        return this.f42344g;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final String h() {
        return this.f42338a;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final boolean i() {
        return this.f42342e;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final boolean isContainer() {
        return this.f42343f;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final d j() {
        return this.f42346i;
    }

    public e(Object r100) {
        this.f42338a = com.bytedance.android.btm.impl.util.e.b();
        this.f42340c = new com.bytedance.android.btm.impl.util.f(r100);
        this.f42345h = new ArrayList();
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void c(d r100) {
        if ((r100 instanceof e) == true) goto L5;
        r100 = null;
    L5:
        e r101 = (e) r100;
        if (r101 == null) goto L9;
        ((ArrayList) r101.f42345h).add(this);
        this.f42344g = r101;
        this.f42341d = r101.f42341d + 1;
        this.f42339b = r101.f42339b;
        return;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void f(String r100) {
        this.f42338a = r100;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void g(d r100) {
        if ((r100 instanceof e) == true) goto L5;
        r100 = null;
    L5:
        this.f42346i = (e) r100;
    }

    @Override // com.bytedance.android.btm.impl.page.model.d
    public final void e(boolean r100, boolean r101) {
        this.f42342e = r100;
        this.f42343f = r101;
    }
}
