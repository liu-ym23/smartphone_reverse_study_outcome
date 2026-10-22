package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

/* loaded from: classes.dex */
public abstract class f<T> {
    final String mPropertyName;

    public class a extends f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatProperty f13720a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, FloatProperty floatProperty) {
            super(str);
            this.f13720a = floatProperty;
        }

        @Override // androidx.dynamicanimation.animation.f
        public float getValue(T t10) {
            return ((Float) this.f13720a.get(t10)).floatValue();
        }

        @Override // androidx.dynamicanimation.animation.f
        public void setValue(T t10, float f10) {
            this.f13720a.setValue(t10, f10);
        }
    }

    public f(String str) {
        this.mPropertyName = str;
    }

    public static <T> f<T> createFloatPropertyCompat(FloatProperty<T> floatProperty) {
        return new a(floatProperty.getName(), floatProperty);
    }

    public abstract float getValue(T t10);

    public abstract void setValue(T t10, float f10);
}
