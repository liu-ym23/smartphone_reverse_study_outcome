package org.slf4j.event;

import ba.C0866a;
import ca.C0894c;
import java.util.Queue;
import org.slf4j.helpers.LegacyAbstractLogger;

/* loaded from: classes4.dex */
public class EventRecordingLogger extends LegacyAbstractLogger {

    /* renamed from: a, reason: collision with root package name */
    public String f5512a;
    public C0894c b;
    public Queue c;

    @Override // aa.InterfaceC0315b
    public final String getName() {
        return this.f5512a;
    }

    @Override // aa.InterfaceC0315b
    public final boolean isDebugEnabled() {
        return true;
    }

    @Override // aa.InterfaceC0315b
    public final boolean isErrorEnabled() {
        return true;
    }

    @Override // aa.InterfaceC0315b
    public final boolean isInfoEnabled() {
        return true;
    }

    @Override // aa.InterfaceC0315b
    public final boolean isTraceEnabled() {
        return true;
    }

    @Override // aa.InterfaceC0315b
    public final boolean isWarnEnabled() {
        return true;
    }

    @Override // org.slf4j.helpers.AbstractLogger
    public final void m(Level level, Object[] objArr) {
        C0866a c0866a = new C0866a();
        System.currentTimeMillis();
        c0866a.f2066a = level;
        c0866a.b = this.b;
        Thread.currentThread().getName();
        c0866a.c = objArr;
        this.c.add(c0866a);
    }
}
