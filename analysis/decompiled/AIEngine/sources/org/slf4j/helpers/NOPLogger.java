package org.slf4j.helpers;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NOPLogger extends MarkerIgnoringBase {

    /* renamed from: a, reason: collision with root package name */
    public static final NOPLogger f11340a = new NOPLogger();

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase, ud.a
    public final String getName() {
        return "NOP";
    }

    @Override // ud.a
    public final void a(String str) {
    }

    @Override // ud.a
    public final void d(String str) {
    }

    @Override // ud.a
    public final void c(Integer num, Long l10) {
    }

    @Override // ud.a
    public final void e(Integer num, Integer num2) {
    }

    @Override // ud.a
    public final void b(String str, String str2, Object obj) {
    }
}
