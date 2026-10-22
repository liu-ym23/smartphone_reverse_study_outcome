package androidx.appfunctions.internal;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"findImpl", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/Class;", "prefix", "", "suffix", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClassUtilsKt {
    @RequiresApi(31)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> T findImpl(Class<T> cls, String prefix, String suffix) throws ClassNotFoundException {
        k.f(cls, "<this>");
        k.f(prefix, "prefix");
        k.f(suffix, "suffix");
        String packageName = cls.getPackageName();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        String strSubstring = canonicalName.substring(packageName.length() + 1);
        k.e(strSubstring, "substring(...)");
        String strB = B7.a.B(prefix, strSubstring, suffix);
        try {
            Class<?> cls2 = Class.forName(packageName + '.' + strB, true, cls.getClassLoader());
            k.d(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.appfunctions.internal.ClassUtilsKt.findImpl>");
            T t9 = (T) cls2.getDeclaredConstructor(null).newInstance(null);
            k.c(t9);
            return t9;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + strB + " does not exist. Is AppFunction annotation processor correctly configured?", e);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName(), e6);
        } catch (InstantiationException e9) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName(), e9);
        }
    }
}
