package com.stepos.statsrpk;

import android.content.Context;
import android.text.TextUtils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.Map;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public Context f31038a;

    /* renamed from: b, reason: collision with root package name */
    public RpkInfo f31039b;

    /* renamed from: c, reason: collision with root package name */
    public b f31040c;

    /* renamed from: d, reason: collision with root package name */
    public f f31041d;

    /* renamed from: e, reason: collision with root package name */
    public e f31042e;

    /* renamed from: f, reason: collision with root package name */
    public a f31043f;

    public d(Context context, RpkInfo rpkInfo) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (context == null) {
            throw new IllegalArgumentException("The applicationContext is null!");
        }
        Context applicationContext = context.getApplicationContext();
        this.f31038a = applicationContext;
        this.f31039b = rpkInfo;
        this.f31043f = new a(applicationContext, rpkInfo);
        Logger.d("RpkInstanceImpl", "##### RpkInstanceImpl 1, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        Logger.d("RpkInstanceImpl", "##### RpkInstanceImpl 2, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        Logger.d("RpkInstanceImpl", "##### RpkInstanceImpl 3, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        Context context2 = this.f31038a;
        this.f31041d = c(context2, a(context2, rpkInfo));
        Logger.d("RpkInstanceImpl", "##### RpkInstanceImpl 4, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        this.f31042e = new e(this.f31038a);
        Logger.d("RpkInstanceImpl", "##### RpkInstanceImpl 5, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        h();
        Logger.d("RpkInstanceImpl", "##### RpkInstanceImpl 6, " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public final b a(Context context, RpkInfo rpkInfo) {
        b bVar = new b(context, rpkInfo);
        this.f31040c = bVar;
        return bVar;
    }

    public e b() {
        return this.f31042e;
    }

    public final f c(Context context, b bVar) {
        return new f(context, bVar, this.f31039b);
    }

    public void d(String str) throws Throwable {
        Logger.d("RpkInstanceImpl", "onPageStart pageName: " + str);
        e eVar = this.f31042e;
        if (eVar == null) {
            return;
        }
        eVar.e(str);
    }

    public void e(String str, String str2, Map<String, String> map) {
        Logger.d("RpkInstanceImpl", "onEvent eventName: " + str + ", pageName: " + str2 + ", properties: " + map);
        if (this.f31041d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f31041d.d(str, str2, map);
    }

    public f f() {
        return this.f31041d;
    }

    public void g(String str) {
        Logger.d("RpkInstanceImpl", "onPageStop pageName: " + str);
        e eVar = this.f31042e;
        if (eVar == null) {
            return;
        }
        eVar.g(str);
    }

    public final void h() {
        this.f31043f.f(this);
        this.f31042e.d(this);
        this.f31041d.b(this);
    }
}
