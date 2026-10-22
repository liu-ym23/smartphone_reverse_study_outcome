package org.slf4j.helpers;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.event.EventRecordingLogger;
import org.slf4j.event.Level;

/* loaded from: classes4.dex */
public abstract class AbstractLogger implements InterfaceC0315b, Serializable {
    @Override // aa.InterfaceC0315b
    public final void a(String str, Object obj, Object obj2) {
        k(Level.DEBUG, str, obj, obj2);
    }

    @Override // aa.InterfaceC0315b
    public final void b(Integer num, String str, Object obj) {
        k(Level.TRACE, str, num, obj);
    }

    @Override // aa.InterfaceC0315b
    public final void c(String str, Object obj, Object obj2) {
        k(Level.WARN, str, obj, obj2);
    }

    @Override // aa.InterfaceC0315b
    public final void debug(String str) {
        m(Level.DEBUG, null);
    }

    @Override // aa.InterfaceC0315b
    public final void e(Object obj, String str) {
        m(Level.ERROR, new Object[]{obj});
    }

    @Override // aa.InterfaceC0315b
    public final void error(String str) {
        m(Level.ERROR, null);
    }

    @Override // aa.InterfaceC0315b
    public final void f(Object obj, String str) {
        m(Level.INFO, new Object[]{obj});
    }

    @Override // aa.InterfaceC0315b
    public final void g(Object obj, String str) {
        m(Level.TRACE, new Object[]{obj});
    }

    @Override // aa.InterfaceC0315b
    public final void h(Object obj, String str) {
        m(Level.WARN, new Object[]{obj});
    }

    @Override // aa.InterfaceC0315b
    public final void i(String str, Object obj, Object obj2) {
        k(Level.ERROR, str, obj, obj2);
    }

    @Override // aa.InterfaceC0315b
    public final void info(String str) {
        m(Level.INFO, null);
    }

    @Override // aa.InterfaceC0315b
    public final void j(Object obj, String str) {
        m(Level.DEBUG, new Object[]{obj});
    }

    public final void k(Level level, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            m(level, new Object[]{obj});
        } else {
            m(level, new Object[]{obj, obj2});
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(org.slf4j.event.Level r3, java.lang.String r4, java.lang.Object[] r5) {
        /*
            r2 = this;
            if (r5 == 0) goto L12
            int r4 = r5.length
            if (r4 != 0) goto L6
            goto L12
        L6:
            int r4 = r5.length
            int r4 = r4 + (-1)
            r4 = r5[r4]
            boolean r0 = r4 instanceof java.lang.Throwable
            if (r0 == 0) goto L12
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            goto L13
        L12:
            r4 = 0
        L13:
            if (r4 == 0) goto L31
            if (r5 == 0) goto L29
            int r4 = r5.length
            if (r4 == 0) goto L29
            int r4 = r5.length
            int r4 = r4 + (-1)
            java.lang.Object[] r0 = new java.lang.Object[r4]
            if (r4 <= 0) goto L25
            r1 = 0
            java.lang.System.arraycopy(r5, r1, r0, r1, r4)
        L25:
            r2.m(r3, r0)
            return
        L29:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "non-sensical empty or null argument array"
            r2.<init>(r3)
            throw r2
        L31:
            r2.m(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.slf4j.helpers.AbstractLogger.l(org.slf4j.event.Level, java.lang.String, java.lang.Object[]):void");
    }

    public abstract void m(Level level, Object[] objArr);

    public Object readResolve() throws ObjectStreamException {
        return AbstractC0317d.c(((EventRecordingLogger) this).f5512a);
    }

    @Override // aa.InterfaceC0315b
    public final void trace(String str) {
        m(Level.TRACE, null);
    }

    @Override // aa.InterfaceC0315b
    public final void warn(String str) {
        m(Level.WARN, null);
    }

    @Override // aa.InterfaceC0315b
    public final void debug(String str, Object... objArr) {
        l(Level.DEBUG, str, objArr);
    }

    @Override // aa.InterfaceC0315b
    public final void error(String str, Object... objArr) {
        l(Level.ERROR, str, objArr);
    }

    @Override // aa.InterfaceC0315b
    public final void info(String str, Object... objArr) {
        l(Level.INFO, str, objArr);
    }

    @Override // aa.InterfaceC0315b
    public final void trace(String str, Object... objArr) {
        l(Level.TRACE, str, objArr);
    }

    @Override // aa.InterfaceC0315b
    public final void warn(String str, Object... objArr) {
        l(Level.WARN, str, objArr);
    }

    @Override // aa.InterfaceC0315b
    public final void debug(String str, Throwable th) {
        m(Level.DEBUG, null);
    }

    @Override // aa.InterfaceC0315b
    public final void error(String str, Throwable th) {
        m(Level.ERROR, null);
    }

    @Override // aa.InterfaceC0315b
    public final void info(String str, Throwable th) {
        m(Level.INFO, null);
    }

    @Override // aa.InterfaceC0315b
    public final void trace(String str, Throwable th) {
        m(Level.TRACE, null);
    }

    @Override // aa.InterfaceC0315b
    public final void warn(String str, Throwable th) {
        m(Level.WARN, null);
    }
}
