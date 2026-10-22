package org.slf4j.helpers;

import org.slf4j.Marker;

/* loaded from: classes5.dex */
public class NOPLogger extends NamedLoggerBase implements vc.c {

    /* renamed from: b, reason: collision with root package name */
    public static final NOPLogger f37933b = new NOPLogger();

    @Override // vc.c
    public final void a(String str, Object obj, Object obj2) {
    }

    @Override // vc.c
    public final void b(String str, Object obj, Object obj2) {
    }

    @Override // vc.c
    public final void c(String str, Object obj, Object obj2) {
    }

    @Override // vc.c
    public final void debug(String str) {
    }

    @Override // vc.c
    public final void error(String str) {
    }

    @Override // vc.c
    public final boolean g(Marker marker) {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, vc.c
    public String getName() {
        return "NOP";
    }

    @Override // vc.c
    public final boolean h(Marker marker) {
        return false;
    }

    @Override // vc.c
    public final void i(String str, Object obj) {
    }

    @Override // vc.c
    public final void info(String str) {
    }

    @Override // vc.c
    public final boolean isDebugEnabled() {
        return false;
    }

    @Override // vc.c
    public final boolean isErrorEnabled() {
        return false;
    }

    @Override // vc.c
    public final boolean isInfoEnabled() {
        return false;
    }

    @Override // vc.c
    public final boolean isTraceEnabled() {
        return false;
    }

    @Override // vc.c
    public final boolean isWarnEnabled() {
        return false;
    }

    @Override // vc.c
    public final void j(String str, Object obj) {
    }

    @Override // vc.c
    public final void k(Marker marker, String str, Throwable th) {
    }

    @Override // vc.c
    public final void l(Marker marker, String str, Throwable th) {
    }

    @Override // vc.c
    public final void m(String str, Object obj) {
    }

    @Override // vc.c
    public final void n(Marker marker, String str, Throwable th) {
    }

    @Override // vc.c
    public final void q(String str, Object obj, Object obj2) {
    }

    @Override // vc.c
    public final void t(String str, Object obj) {
    }

    @Override // vc.c
    public final void trace(String str) {
    }

    @Override // vc.c
    public final void u(String str, Object obj) {
    }

    @Override // vc.c
    public final boolean v(Marker marker) {
        return false;
    }

    @Override // vc.c
    public final boolean w(Marker marker) {
        return false;
    }

    @Override // vc.c
    public final void warn(String str) {
    }

    @Override // vc.c
    public final void x(Marker marker, String str, Throwable th) {
    }

    @Override // vc.c
    public final void y(Marker marker, String str, Throwable th) {
    }

    @Override // vc.c
    public boolean z(Marker marker) {
        return false;
    }

    @Override // vc.c
    public final void debug(String str, Throwable th) {
    }

    @Override // vc.c
    public final void error(String str, Throwable th) {
    }

    @Override // vc.c
    public final void info(String str, Throwable th) {
    }

    @Override // vc.c
    public final void trace(String str, Throwable th) {
    }

    @Override // vc.c
    public final void warn(String str, Throwable th) {
    }

    @Override // vc.c
    public final void debug(String str, Object... objArr) {
    }

    @Override // vc.c
    public final void error(String str, Object... objArr) {
    }

    @Override // vc.c
    public final void info(String str, Object... objArr) {
    }

    @Override // vc.c
    public final void trace(String str, Object... objArr) {
    }

    @Override // vc.c
    public final void warn(String str, Object... objArr) {
    }
}
