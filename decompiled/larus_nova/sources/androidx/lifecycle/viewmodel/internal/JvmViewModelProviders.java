package androidx.lifecycle.viewmodel.internal;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Landroidx/lifecycle/viewmodel/internal/JvmViewModelProviders;", "", "<init>", "()V", "createViewModel", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JvmViewModelProviders {
    public static final JvmViewModelProviders INSTANCE = null;

    static {
        INSTANCE = new JvmViewModelProviders();
    }

    private JvmViewModelProviders() {
    }

    public final <T extends ViewModel> T createViewModel(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        Constructor<T> r101 = r100.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L16
        if (Modifier.isPublic(r101.getModifiers()) == false) goto L15;
        T r102 = r101.newInstance(new Object[0]);     // Catch: IllegalAccessException -> L8 InstantiationException -> L11
        Intrinsics.checkNotNull(r102);     // Catch: IllegalAccessException -> L8 InstantiationException -> L11
        return r102;
    L8:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r100, e);
    L11:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r100, e);
    L15:
        throw new RuntimeException("Cannot create an instance of " + r100);
    L16:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r100, e);
    }
}
