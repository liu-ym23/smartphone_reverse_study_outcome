package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

/* JADX INFO: loaded from: classes17.dex */
public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public abstract float getValue(T r100);

    public abstract void setValue(T r100, float r101);

    public FloatPropertyCompat(String r100) {
        this.mPropertyName = r100;
    }

    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> r100) {
        final String r101 = r100.getName();
        return new AnonymousClass1(r101, r100);
    }
}
