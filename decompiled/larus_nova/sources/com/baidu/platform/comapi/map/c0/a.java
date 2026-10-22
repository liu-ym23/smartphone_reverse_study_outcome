package com.baidu.platform.comapi.map.c0;

import android.view.MotionEvent;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0664a f33159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0664a f33160b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0664a f33161c = null;

    /* JADX INFO: renamed from: com.baidu.platform.comapi.map.c0.a$a, reason: collision with other inner class name */
    public static class C0664a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f33162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f33163b;

        public b a() {
            b r100 = this.f33162a;
            double r101 = r100.f33164a;
            b r102 = this.f33163b;
            return new b((r101 + r102.f33164a) / 2.0d, (r100.f33165b + r102.f33165b) / 2.0d);
        }

        public double b() {
            b r100 = this.f33162a;
            double r101 = r100.f33164a;
            b r102 = this.f33163b;
            double r103 = r101 - r102.f33164a;
            double r104 = r100.f33165b - r102.f33165b;
            return Math.sqrt((r103 * r103) + (r104 * r104));
        }

        public d c() {
            b r100 = this.f33163b;
            double r101 = r100.f33164a;
            b r102 = this.f33162a;
            return new d(r101 - r102.f33164a, r100.f33165b - r102.f33165b);
        }

        public String toString() {
            return C0664a.class.getSimpleName() + "  a : " + this.f33162a.toString() + " b : " + this.f33163b.toString();
        }

        public static C0664a a(MotionEvent r100) {
            return new C0664a(new b(r100.getX(0), r100.getY(0)), new b(r100.getX(1), r100.getY(1)));
        }

        public C0664a(b r100, b r101) {
            this.f33162a = r100;
            this.f33163b = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f33164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f33165b;

        public String toString() {
            return b.class.getSimpleName() + " x : " + this.f33164a + " y : " + this.f33165b;
        }

        public b(double r100, double r101) {
            this.f33164a = r100;
            this.f33165b = r101;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f33166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f33167b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f33168c;

        public String toString() {
            return c.class.getSimpleName() + " rotate : " + this.f33166a + " scale : " + (this.f33167b * 100.0d) + " move : " + this.f33168c.toString();
        }

        public c(C0664a r100, C0664a r101) {
            this.f33168c = new d(r100.a(), r101.a());
            this.f33167b = r101.b() / r100.b();
            this.f33166a = d.a(r100.c(), r101.c());
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f33169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f33170b;

        public String toString() {
            return d.class.getSimpleName() + " x : " + this.f33169a + " y : " + this.f33170b;
        }

        public d(b r100, b r101) {
            this.f33169a = r101.f33164a - r100.f33164a;
            this.f33170b = r101.f33165b - r100.f33165b;
        }

        public static double a(d r100, d r101) {
            double r102 = Math.atan2(r100.f33170b, r100.f33169a) - Math.atan2(r101.f33170b, r101.f33169a);
            if (r102 <= 3.141592653589793d) goto L6;
            r102 = r102 - 6.283185307179586d;
        L9:
            return (r102 * 180.0d) / 3.141592653589793d;
        L6:
            if (r102 >= (-3.141592653589793d)) goto L9;
            r102 = r102 + 6.283185307179586d;
            goto L9
        }

        public d(double r100, double r101) {
            this.f33169a = r100;
            this.f33170b = r101;
        }
    }

    static {
        f33159a = new C0664a(new b(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), new b(1.0d, AudioStats.AUDIO_AMPLITUDE_NONE));
        f33160b = new C0664a(new b(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), new b(AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d));
        f33161c = new C0664a(new b(AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d), new b(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE));
    }
}
