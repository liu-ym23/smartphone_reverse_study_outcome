package com.stepos.statsrpk;

import android.content.Context;
import android.text.TextUtils;
import g3.C0742e;
import java.util.Map;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private Context f15955a;

    /* renamed from: b, reason: collision with root package name */
    private b f15956b;

    /* renamed from: c, reason: collision with root package name */
    private d f15957c;

    /* renamed from: d, reason: collision with root package name */
    private h f15958d;

    /* renamed from: e, reason: collision with root package name */
    private g f15959e;

    /* renamed from: f, reason: collision with root package name */
    private c f15960f;

    public f(Context context, b bVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (context == null) {
            throw new IllegalArgumentException("The applicationContext is null!");
        }
        Context applicationContext = context.getApplicationContext();
        this.f15955a = applicationContext;
        this.f15956b = bVar;
        this.f15960f = new c(applicationContext, bVar);
        C0742e.c("RpkInstanceImpl", "##### RpkInstanceImpl 1, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        C0742e.c("RpkInstanceImpl", "##### RpkInstanceImpl 2, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        C0742e.c("RpkInstanceImpl", "##### RpkInstanceImpl 3, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        Context context2 = this.f15955a;
        this.f15958d = c(context2, a(context2, bVar));
        C0742e.c("RpkInstanceImpl", "##### RpkInstanceImpl 4, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        this.f15959e = new g(this.f15955a);
        C0742e.c("RpkInstanceImpl", "##### RpkInstanceImpl 5, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        h();
        C0742e.c("RpkInstanceImpl", "##### RpkInstanceImpl 6, " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private d a(Context context, b bVar) {
        d dVar = new d(context, bVar);
        this.f15957c = dVar;
        return dVar;
    }

    private h c(Context context, d dVar) {
        return new h(context, dVar, this.f15956b);
    }

    private void h() {
        this.f15960f.f(this);
        this.f15959e.d(this);
        this.f15958d.b(this);
    }

    g b() {
        return this.f15959e;
    }

    public void d(String str) throws Throwable {
        C0742e.c("RpkInstanceImpl", "onPageStart pageName: " + str);
        g gVar = this.f15959e;
        if (gVar == null) {
            return;
        }
        gVar.e(str);
    }

    public void e(String str, String str2, Map<String, String> map) {
        C0742e.c("RpkInstanceImpl", "onEvent eventName: " + str + ", pageName: " + str2 + ", properties: " + map);
        if (this.f15958d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f15958d.d(str, str2, map);
    }

    h f() {
        return this.f15958d;
    }

    public void g(String str) {
        C0742e.c("RpkInstanceImpl", "onPageStop pageName: " + str);
        g gVar = this.f15959e;
        if (gVar == null) {
            return;
        }
        gVar.g(str);
    }
}
