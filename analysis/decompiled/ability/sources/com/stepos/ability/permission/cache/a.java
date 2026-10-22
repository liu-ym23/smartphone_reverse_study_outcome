package com.stepos.ability.permission.cache;

import com.stepos.taskrobot.llmapi.stepfun.g;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import n5.C1741a;
import p4.C1791a;
import s9.C1923c;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final o4.c f3212a;
    public final InterfaceC1733z b;
    public final S7.a c;
    public volatile C1791a d;
    public final AtomicBoolean e;

    public a(o4.c cVar, C1923c scope, C1741a clock) {
        k.f(scope, "scope");
        k.f(clock, "clock");
        this.f3212a = cVar;
        this.b = scope;
        this.c = clock;
        this.e = new AtomicBoolean(false);
    }

    public final Long a() {
        C1791a c1791a = this.d;
        if (c1791a != null) {
            return Long.valueOf(((Number) this.c.invoke()).longValue() - c1791a.b);
        }
        return null;
    }

    public final void b(String str) {
        if (!this.e.compareAndSet(false, true)) {
            P3.c.b("SlaPermMapping", "refresh skip: fetch in-flight (reason=" + str + ")");
            return;
        }
        P3.c.b("SlaPermMapping", "refresh start reason=" + str + " force=true age=" + a());
        AbstractC1683A.n(this.b, null, new MappingCache$refresh$1(this, str, null), 3).w(new g(this, 6));
    }
}
