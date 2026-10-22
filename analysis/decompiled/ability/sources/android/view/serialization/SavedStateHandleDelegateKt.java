package android.view.serialization;

import S7.a;
import V7.c;
import android.view.SavedStateHandle;
import android.view.serialization.SavedStateConfiguration;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import x9.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00028\u00000\t\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\b\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a[\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00028\u00000\t\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\n\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/SavedStateHandle;", "", "key", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "configuration", "Lkotlin/Function0;", "init", "LV7/c;", "saved", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Landroidx/savedstate/serialization/SavedStateConfiguration;LS7/a;)LV7/c;", "Lx9/b;", "serializer", "(Landroidx/lifecycle/SavedStateHandle;Lx9/b;Ljava/lang/String;Landroidx/savedstate/serialization/SavedStateConfiguration;LS7/a;)LV7/c;", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateHandleDelegateKt {
    public static final <T> c saved(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration configuration, a init) {
        k.f(savedStateHandle, "<this>");
        k.f(configuration, "configuration");
        k.f(init, "init");
        configuration.getSerializersModule();
        k.m();
        throw null;
    }

    public static c saved$default(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration configuration, a init, int i, Object obj) {
        if ((i & 2) != 0) {
            configuration = SavedStateConfiguration.DEFAULT;
        }
        k.f(savedStateHandle, "<this>");
        k.f(configuration, "configuration");
        k.f(init, "init");
        configuration.getSerializersModule();
        k.m();
        throw null;
    }

    public static final <T> c saved(SavedStateHandle savedStateHandle, b serializer, String str, SavedStateConfiguration configuration, a init) {
        k.f(savedStateHandle, "<this>");
        k.f(serializer, "serializer");
        k.f(configuration, "configuration");
        k.f(init, "init");
        return new SavedStateHandleDelegate(savedStateHandle, serializer, str, configuration, init);
    }

    public static /* synthetic */ c saved$default(SavedStateHandle savedStateHandle, b bVar, String str, SavedStateConfiguration savedStateConfiguration, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return saved(savedStateHandle, bVar, str, savedStateConfiguration, aVar);
    }
}
