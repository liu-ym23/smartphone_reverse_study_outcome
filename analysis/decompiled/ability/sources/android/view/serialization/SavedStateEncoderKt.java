package android.view.serialization;

import android.os.Bundle;
import android.view.SavedStateWriter;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.k;
import x9.f;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a2\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0086\b¢\u0006\u0004\b\u0007\u0010\b\u001a=\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0002\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "value", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "configuration", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "encodeToSavedState", "(Ljava/lang/Object;Landroidx/savedstate/serialization/SavedStateConfiguration;)Landroid/os/Bundle;", "Lx9/f;", "serializer", "(Lx9/f;Ljava/lang/Object;Landroidx/savedstate/serialization/SavedStateConfiguration;)Landroid/os/Bundle;", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateEncoderKt {
    public static final <T> Bundle encodeToSavedState(f serializer, T value) {
        k.f(serializer, "serializer");
        k.f(value, "value");
        return encodeToSavedState$default(serializer, value, null, 4, null);
    }

    public static Bundle encodeToSavedState$default(Object value, SavedStateConfiguration configuration, int i, Object obj) {
        if ((i & 2) != 0) {
            configuration = SavedStateConfiguration.DEFAULT;
        }
        k.f(value, "value");
        k.f(configuration, "configuration");
        configuration.getSerializersModule();
        k.m();
        throw null;
    }

    public static final <T> Bundle encodeToSavedState(T value, SavedStateConfiguration configuration) {
        k.f(value, "value");
        k.f(configuration, "configuration");
        configuration.getSerializersModule();
        k.m();
        throw null;
    }

    public static final <T> Bundle encodeToSavedState(f serializer, T value, SavedStateConfiguration configuration) {
        k.f(serializer, "serializer");
        k.f(value, "value");
        k.f(configuration, "configuration");
        a.M();
        Pair[] pairArr = new Pair[0];
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m7263constructorimpl(bundleBundleOf);
        new SavedStateEncoder(bundleBundleOf, configuration).encodeSerializableValue(serializer, value);
        return bundleBundleOf;
    }

    public static /* synthetic */ Bundle encodeToSavedState$default(f fVar, Object obj, SavedStateConfiguration savedStateConfiguration, int i, Object obj2) {
        if ((i & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return encodeToSavedState(fVar, obj, savedStateConfiguration);
    }
}
