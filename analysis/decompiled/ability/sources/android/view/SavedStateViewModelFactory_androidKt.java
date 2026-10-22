package android.view;

import B7.a;
import C7.i;
import D7.q;
import H4.o;
import android.app.Application;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u001aI\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0000¢\u0006\u0002\u0010\n\u001a6\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\fH\u0000\"\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"newInstance", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "constructor", "Ljava/lang/reflect/Constructor;", "params", "", "", "(Ljava/lang/Class;Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Landroidx/lifecycle/ViewModel;", "ANDROID_VIEWMODEL_SIGNATURE", "", "VIEWMODEL_SIGNATURE", "findMatchingConstructor", "signature", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public final class SavedStateViewModelFactory_androidKt {
    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE = o.N(Application.class, SavedStateHandle.class);
    private static final List<Class<?>> VIEWMODEL_SIGNATURE = o.M(SavedStateHandle.class);

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> modelClass, List<? extends Class<?>> signature) {
        k.f(modelClass, "modelClass");
        k.f(signature, "signature");
        i iVarJ = k.j(modelClass.getConstructors());
        while (iVarJ.hasNext()) {
            Constructor<T> constructor = (Constructor) iVarJ.next();
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            k.e(parameterTypes, "getParameterTypes(...)");
            List listI0 = q.I0(parameterTypes);
            if (signature.equals(listI0)) {
                return constructor;
            }
            if (signature.size() == listI0.size() && listI0.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> modelClass, Constructor<T> constructor, Object... params) {
        k.f(modelClass, "modelClass");
        k.f(constructor, "constructor");
        k.f(params, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(a.i(modelClass, "Failed to access "), e);
        } catch (InstantiationException e6) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e6);
        } catch (InvocationTargetException e9) {
            throw new RuntimeException(a.i(modelClass, "An exception happened in constructor of "), e9.getCause());
        }
    }
}
