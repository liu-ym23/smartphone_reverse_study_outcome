package com.bytedance.android.ecom.arch.slice.expr;

import android.util.LruCache;
import com.bytedance.android.ecom.arch.expr.parser.SlcExprParser;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcExprContext {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f50053g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Object, Object> f50054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, zp.b> f50055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f50056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SlcExprParser f50057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zp.d f50058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f50059f;

    public static final class a {
    }

    static {
    }

    public SlcExprContext() {
        this(0);
    }

    public SlcExprContext(b r100) {
        this.f50059f = r100;
        ConcurrentHashMap<Object, Object> r101 = new ConcurrentHashMap();
        this.f50054a = r101;
        HashMap<String, zp.b> r102 = new HashMap();
        this.f50055b = r102;
        this.f50056c = new d(r102, r101);
        this.f50057d = new SlcExprParser();
        this.f50058e = new zp.d(r102);
    }

    public /* synthetic */ SlcExprContext(int r100) {
        this(new b(1000));
    }

    public final void b(String r100, zp.b r101) {
        this.f50055b.put(r100, r101);
    }

    public final Object a(final String r100, Map<String, ? extends Object> r101, Function1<? super c, Unit> r102) {
        LruCache<String, dq.a> r103 = this.f50059f.f50061a.f50060a;     // Catch: Throwable -> L11
        if (r100 == null) goto L10;
        dq.a r104 = r103.get(r100.trim());     // Catch: Throwable -> L11
        if (r104 != null) goto L7;
        SlcExprParser r105 = this.f50057d;     // Catch: Throwable -> L11
        zp.d r106 = this.f50058e;     // Catch: Throwable -> L11
        r105.getClass();     // Catch: Throwable -> L11
        r104 = SlcExprParser.a(r100, r106);     // Catch: Throwable -> L11
        this.f50059f.f50061a.f50060a.put(r100.trim(), r104);     // Catch: Throwable -> L11
    L7:
        int r107 = zp.c.f573173a;     // Catch: Throwable -> L11
        return new dq.b(r104, r101, this.f50056c).d();
    L10:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r102 == null) goto L14;
        Unit r108 = r102.invoke(new c(r100, th, 4));
    L14:
        int r109 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.b(new SlcExprContext$evaluate$1(r100, th));
        return null;
    }
}
