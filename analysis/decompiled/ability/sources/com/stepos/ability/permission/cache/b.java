package com.stepos.ability.permission.cache;

import C7.r;
import D7.N;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.stepos.taskrobot.llmapi.stepfun.g;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import n5.C1741a;
import r4.AbstractC1878a;
import s4.f;
import s9.C1923c;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final o4.c f3213a;
    public final InterfaceC1733z b;
    public final S7.a c;
    public volatile p4.b d;
    public volatile long e;
    public final AtomicBoolean f;
    public volatile F5.a g;

    public b(o4.c cVar, C1923c scope, C1741a clock) {
        k.f(scope, "scope");
        k.f(clock, "clock");
        this.f3213a = cVar;
        this.b = scope;
        this.c = clock;
        this.f = new AtomicBoolean(false);
    }

    public static final List a(b bVar, f fVar, f fVar2) {
        Map map = fVar2.f5985a;
        if (fVar == null) {
            return EmptyList.f4893a;
        }
        Map map2 = fVar.f5985a;
        LinkedHashSet<String> linkedHashSetL = N.L(map2.keySet(), map.keySet());
        ArrayList arrayList = new ArrayList();
        for (String str : linkedHashSetL) {
            String str2 = (String) map2.get(str);
            String str3 = (String) map.get(str);
            String str4 = k.b(str2, str3) ? null : str + ": " + str2 + "->" + str3;
            if (str4 != null) {
                arrayList.add(str4);
            }
        }
        return arrayList;
    }

    public final Long b() {
        p4.b bVar = this.d;
        if (bVar != null) {
            return Long.valueOf(((Number) this.c.invoke()).longValue() - bVar.b);
        }
        return null;
    }

    public final void c(String str, boolean z10, boolean z11) {
        if (!this.f.compareAndSet(false, true)) {
            P3.c.b("SlaPermMode", "refresh skip: fetch in-flight (reason=" + str + ")");
            return;
        }
        Long lB = b();
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("refresh start reason=", str, " force=", " age=", z10);
        sbL.append(lB);
        P3.c.b("SlaPermMode", sbL.toString());
        AbstractC1683A.n(this.b, null, new ModeCache$refresh$1(this, z10, z11, str, null), 3).w(new g(this, 7));
    }

    public final synchronized void d(Context context) {
        Object objA;
        if (this.g != null) {
            P3.c.f1086a.invoke(3, "Ability_".concat("SlaPermMode"), "startObserving: already registered", null);
            return;
        }
        F5.a aVar = new F5.a(this, new Handler(Looper.getMainLooper()), 2);
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = AbstractC1878a.c;
            contentResolver.registerContentObserver(uri, true, aVar);
            this.g = aVar;
            P3.c.b("SlaPermMode", "observer registered on " + uri);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            String msg = "observer register FAILED: " + thA.getMessage() + " -> 降级为安全网轮询";
            k.f(msg, "msg");
            P3.c.f1086a.invoke(5, "Ability_".concat("SlaPermMode"), msg, thA);
        }
    }
}
