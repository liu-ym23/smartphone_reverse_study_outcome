package h1;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import n1.C0873a;

/* renamed from: h1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0748c {

    /* renamed from: h1.c$b */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f17585b = new b();

        /* renamed from: a, reason: collision with root package name */
        private final e f17586a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f5, e eVar, e eVar2) {
            this.f17586a.a(C0873a.d(eVar.f17589a, eVar2.f17589a, f5), C0873a.d(eVar.f17590b, eVar2.f17590b, f5), C0873a.d(eVar.f17591c, eVar2.f17591c, f5));
            return this.f17586a;
        }
    }

    /* renamed from: h1.c$c, reason: collision with other inner class name */
    public static class C0217c extends Property<InterfaceC0748c, e> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<InterfaceC0748c, e> f17587a = new C0217c("circularReveal");

        private C0217c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(InterfaceC0748c interfaceC0748c) {
            return interfaceC0748c.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(InterfaceC0748c interfaceC0748c, e eVar) {
            interfaceC0748c.setRevealInfo(eVar);
        }
    }

    /* renamed from: h1.c$d */
    public static class d extends Property<InterfaceC0748c, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<InterfaceC0748c, Integer> f17588a = new d("circularRevealScrimColor");

        private d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(InterfaceC0748c interfaceC0748c) {
            return Integer.valueOf(interfaceC0748c.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(InterfaceC0748c interfaceC0748c, Integer num) {
            interfaceC0748c.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* renamed from: h1.c$e */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public float f17589a;

        /* renamed from: b, reason: collision with root package name */
        public float f17590b;

        /* renamed from: c, reason: collision with root package name */
        public float f17591c;

        public void a(float f5, float f6, float f7) {
            this.f17589a = f5;
            this.f17590b = f6;
            this.f17591c = f7;
        }

        private e() {
        }

        public e(float f5, float f6, float f7) {
            this.f17589a = f5;
            this.f17590b = f6;
            this.f17591c = f7;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i5);

    void setRevealInfo(e eVar);
}
