package androidx.compose.runtime.saveable.serialization;

import H4.l;
import android.os.Bundle;
import android.view.serialization.SavedStateConfiguration;
import android.view.serialization.SavedStateDecoderKt;
import android.view.serialization.SavedStateEncoderKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import x9.b;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00028\u0000\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00028\u0000\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, d2 = {"", "Serializable", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "configuration", "Landroidx/compose/runtime/saveable/Saver;", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "serializableSaver", "(Landroidx/savedstate/serialization/SavedStateConfiguration;)Landroidx/compose/runtime/saveable/Saver;", "Lx9/b;", "serializer", "(Lx9/b;Landroidx/savedstate/serialization/SavedStateConfiguration;)Landroidx/compose/runtime/saveable/Saver;", "runtime-saveable"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerializableSaverKt {
    public static final <Serializable> Saver<Serializable, Bundle> serializableSaver(SavedStateConfiguration savedStateConfiguration) {
        savedStateConfiguration.getSerializersModule();
        k.m();
        throw null;
    }

    public static Saver serializableSaver$default(SavedStateConfiguration savedStateConfiguration, int i, Object obj) {
        if ((i & 1) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        savedStateConfiguration.getSerializersModule();
        k.m();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle serializableSaver$lambda$0(b bVar, SavedStateConfiguration savedStateConfiguration, SaverScope saverScope, Object obj) {
        return SavedStateEncoderKt.encodeToSavedState(bVar, obj, savedStateConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object serializableSaver$lambda$1(b bVar, SavedStateConfiguration savedStateConfiguration, Bundle bundle) {
        return SavedStateDecoderKt.decodeFromSavedState(bVar, bundle, savedStateConfiguration);
    }

    public static final <Serializable> Saver<Serializable, Bundle> serializableSaver(b bVar, SavedStateConfiguration savedStateConfiguration) {
        return SaverKt.Saver(new l(3, bVar, savedStateConfiguration), new R3.b(25, bVar, savedStateConfiguration));
    }

    public static /* synthetic */ Saver serializableSaver$default(b bVar, SavedStateConfiguration savedStateConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return serializableSaver(bVar, savedStateConfiguration);
    }
}
