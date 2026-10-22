package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    final String mPropertyName;

    /* JADX INFO: renamed from: androidx.dynamicanimation.animation.a$a, reason: collision with other inner class name */
    public static class C0026a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatProperty f2999a;

        public C0026a(String r10, FloatProperty r11) {
            this.f2999a = r11;
            super(r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public float getValue(Object r10) {
            return ((Float) this.f2999a.get(r10)).floatValue();
        }

        @Override // androidx.dynamicanimation.animation.a
        public void setValue(Object r10, float r11) {
            this.f2999a.setValue(r10, r11);
        }
    }

    public a(String r10) {
        this.mPropertyName = r10;
    }

    @RequiresApi(24)
    public static <T> a createFloatPropertyCompat(FloatProperty<T> r10) {
        return new C0026a(r10.getName(), r10);
    }

    public abstract float getValue(Object r10);

    public abstract void setValue(Object r10, float r11);
}
