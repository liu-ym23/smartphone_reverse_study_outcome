package com.baidu.platform.comapi.map.c0;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0046a f9054a = new C0046a(new b(0.0d, 0.0d), new b(1.0d, 0.0d));

    /* renamed from: b, reason: collision with root package name */
    public static final C0046a f9055b = new C0046a(new b(0.0d, 0.0d), new b(0.0d, 1.0d));

    /* renamed from: c, reason: collision with root package name */
    public static final C0046a f9056c = new C0046a(new b(0.0d, 1.0d), new b(0.0d, 0.0d));

    /* renamed from: com.baidu.platform.comapi.map.c0.a$a, reason: collision with other inner class name */
    public static class C0046a {

        /* renamed from: a, reason: collision with root package name */
        public b f9057a;

        /* renamed from: b, reason: collision with root package name */
        public b f9058b;

        public C0046a(b bVar, b bVar2) {
            this.f9057a = bVar;
            this.f9058b = bVar2;
        }

        public b a() {
            b bVar = this.f9057a;
            double d4 = bVar.f9059a;
            b bVar2 = this.f9058b;
            return new b((d4 + bVar2.f9059a) / 2.0d, (bVar.f9060b + bVar2.f9060b) / 2.0d);
        }

        public double b() {
            b bVar = this.f9057a;
            double d4 = bVar.f9059a;
            b bVar2 = this.f9058b;
            double d5 = d4 - bVar2.f9059a;
            double d6 = bVar.f9060b - bVar2.f9060b;
            return Math.sqrt((d6 * d6) + (d5 * d5));
        }

        public d c() {
            b bVar = this.f9058b;
            double d4 = bVar.f9059a;
            b bVar2 = this.f9057a;
            return new d(d4 - bVar2.f9059a, bVar.f9060b - bVar2.f9060b);
        }

        public String toString() {
            return C0046a.class.getSimpleName() + "  a : " + this.f9057a.toString() + " b : " + this.f9058b.toString();
        }

        public static C0046a a(MotionEvent motionEvent) {
            return new C0046a(new b(motionEvent.getX(0), motionEvent.getY(0)), new b(motionEvent.getX(1), motionEvent.getY(1)));
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public double f9059a;

        /* renamed from: b, reason: collision with root package name */
        public double f9060b;

        public b(double d4, double d5) {
            this.f9059a = d4;
            this.f9060b = d5;
        }

        public String toString() {
            return b.class.getSimpleName() + " x : " + this.f9059a + " y : " + this.f9060b;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final double f9061a;

        /* renamed from: b, reason: collision with root package name */
        public final double f9062b;

        /* renamed from: c, reason: collision with root package name */
        public final d f9063c;

        public c(C0046a c0046a, C0046a c0046a2) {
            this.f9063c = new d(c0046a.a(), c0046a2.a());
            this.f9062b = c0046a2.b() / c0046a.b();
            this.f9061a = d.a(c0046a.c(), c0046a2.c());
        }

        public String toString() {
            return c.class.getSimpleName() + " rotate : " + this.f9061a + " scale : " + (this.f9062b * 100.0d) + " move : " + this.f9063c.toString();
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public double f9064a;

        /* renamed from: b, reason: collision with root package name */
        public double f9065b;

        public d(double d4, double d5) {
            this.f9064a = d4;
            this.f9065b = d5;
        }

        public static double a(d dVar, d dVar2) {
            double dAtan2 = Math.atan2(dVar.f9065b, dVar.f9064a) - Math.atan2(dVar2.f9065b, dVar2.f9064a);
            if (dAtan2 > 3.141592653589793d) {
                dAtan2 -= 6.283185307179586d;
            } else if (dAtan2 < -3.141592653589793d) {
                dAtan2 += 6.283185307179586d;
            }
            return (dAtan2 * 180.0d) / 3.141592653589793d;
        }

        public String toString() {
            return d.class.getSimpleName() + " x : " + this.f9064a + " y : " + this.f9065b;
        }

        public d(b bVar, b bVar2) {
            this.f9064a = bVar2.f9059a - bVar.f9059a;
            this.f9065b = bVar2.f9060b - bVar.f9060b;
        }
    }
}
