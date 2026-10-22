package K2;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* loaded from: classes2.dex */
public interface c {

    public static class b implements TypeEvaluator<e> {

        /* renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f4095b = new b();

        /* renamed from: a, reason: collision with root package name */
        public final e f4096a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f10, e eVar, e eVar2) {
            this.f4096a.a(S2.a.d(eVar.f4099a, eVar2.f4099a, f10), S2.a.d(eVar.f4100b, eVar2.f4100b, f10), S2.a.d(eVar.f4101c, eVar2.f4101c, f10));
            return this.f4096a;
        }
    }

    /* renamed from: K2.c$c, reason: collision with other inner class name */
    public static class C0063c extends Property<c, e> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<c, e> f4097a = new C0063c("circularReveal");

        public C0063c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    public static class d extends Property<c, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<c, Integer> f4098a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public float f4099a;

        /* renamed from: b, reason: collision with root package name */
        public float f4100b;

        /* renamed from: c, reason: collision with root package name */
        public float f4101c;

        public void a(float f10, float f11, float f12) {
            this.f4099a = f10;
            this.f4100b = f11;
            this.f4101c = f12;
        }

        public e() {
        }

        public e(float f10, float f11, float f12) {
            this.f4099a = f10;
            this.f4100b = f11;
            this.f4101c = f12;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i10);

    void setRevealInfo(e eVar);
}
