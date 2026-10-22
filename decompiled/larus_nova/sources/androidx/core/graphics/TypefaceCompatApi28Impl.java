package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
public class TypefaceCompatApi28Impl extends TypefaceCompatApi26Impl {
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String DEFAULT_FAMILY = "sans-serif";
    private static final int RESOLVE_BY_FONT_TABLE = -1;

    public TypefaceCompatApi28Impl() {
    }

    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    public Typeface createFromFamiliesWithDefault(Object r100) {
        Object r101 = Array.newInstance(this.mFontFamily, 1);     // Catch: InvocationTargetException -> L4 Throwable -> L6
        Array.set(r101, 0, r100);     // Catch: InvocationTargetException -> L4 Throwable -> L6
        return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{r101, "sans-serif", -1, -1});
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> r100) throws NoSuchMethodException {
        Class r101 = Integer.TYPE;
        Method r102 = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r100, 1).getClass(), String.class, r101, r101});
        r102.setAccessible(true);
        return r102;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi26Impl, androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createWeightStyle(Context r100, Typeface r101, int r102, boolean r103) {
        return Typeface.create(r101, r102, r103);
    }
}
