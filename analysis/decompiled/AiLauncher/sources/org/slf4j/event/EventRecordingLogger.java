package org.slf4j.event;

import java.util.Queue;
import org.slf4j.Marker;
import org.slf4j.helpers.LegacyAbstractLogger;
import org.slf4j.helpers.h;
import wc.d;

/* loaded from: classes5.dex */
public class EventRecordingLogger extends LegacyAbstractLogger {

    /* renamed from: b, reason: collision with root package name */
    public String f37927b;

    /* renamed from: c, reason: collision with root package name */
    public h f37928c;

    /* renamed from: d, reason: collision with root package name */
    public Queue<d> f37929d;

    public EventRecordingLogger(h hVar, Queue<d> queue) {
        this.f37928c = hVar;
        this.f37927b = hVar.getName();
        this.f37929d = queue;
    }

    @Override // org.slf4j.helpers.AbstractLogger
    public void D(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        d dVar = new d();
        dVar.n(System.currentTimeMillis());
        dVar.h(level);
        dVar.i(this.f37928c);
        dVar.j(this.f37927b);
        if (marker != null) {
            dVar.e(marker);
        }
        dVar.k(str);
        dVar.l(Thread.currentThread().getName());
        dVar.g(objArr);
        dVar.m(th);
        this.f37929d.add(dVar);
    }

    @Override // org.slf4j.helpers.AbstractLogger, vc.c
    public String getName() {
        return this.f37927b;
    }

    @Override // vc.c
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // vc.c
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // vc.c
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // vc.c
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // vc.c
    public boolean isWarnEnabled() {
        return true;
    }
}
