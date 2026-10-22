package androidx.compose.runtime.saveable;

import android.view.serialization.SavedStateConfiguration;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.serialization.SerializableSaverKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aN\u0010\b\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00000\u0002\"\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0087\b¢\u0006\u0004\b\b\u0010\t\u001aW\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00000\u0002\"\u0004\u0018\u00010\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0007¢\u0006\u0004\b\b\u0010\f\u001aZ\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00000\u0002\"\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u0006H\u0087\b¢\u0006\u0004\b\b\u0010\u000e\u001ac\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00000\u0002\"\u0004\u0018\u00010\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u0006H\u0007¢\u0006\u0004\b\b\u0010\u0010¨\u0006\u0011"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "inputs", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "configuration", "Lkotlin/Function0;", "init", "rememberSerializable", "([Ljava/lang/Object;Landroidx/savedstate/serialization/SavedStateConfiguration;LS7/a;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "Lx9/b;", "serializer", "([Ljava/lang/Object;Lx9/b;Landroidx/savedstate/serialization/SavedStateConfiguration;LS7/a;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "Landroidx/compose/runtime/MutableState;", "([Ljava/lang/Object;Landroidx/savedstate/serialization/SavedStateConfiguration;LS7/a;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "stateSerializer", "([Ljava/lang/Object;Lx9/b;Landroidx/savedstate/serialization/SavedStateConfiguration;LS7/a;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "runtime-saveable"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RememberSerializableKt {
    @Composable
    /* renamed from: rememberSerializable, reason: collision with other method in class */
    public static final <T> T m3592rememberSerializable(Object[] objArr, SavedStateConfiguration savedStateConfiguration, S7.a aVar, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        Arrays.copyOf(objArr, objArr.length);
        savedStateConfiguration.getSerializersModule();
        k.m();
        throw null;
    }

    @Composable
    /* renamed from: rememberSerializable, reason: collision with other method in class */
    public static final <T> T m3593rememberSerializable(Object[] objArr, x9.b bVar, SavedStateConfiguration savedStateConfiguration, S7.a aVar, Composer composer, int i, int i6) {
        if ((i6 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1261607160, i, -1, "androidx.compose.runtime.saveable.rememberSerializable (RememberSerializable.kt:93)");
        }
        T t9 = (T) RememberSaveableKt.m3591rememberSaveable(Arrays.copyOf(objArr, objArr.length), SerializableSaverKt.serializableSaver(bVar, savedStateConfiguration), (String) null, aVar, composer, (i & 7168) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return t9;
    }

    @Composable
    public static final <T> MutableState<T> rememberSerializable(Object[] objArr, SavedStateConfiguration savedStateConfiguration, S7.a aVar, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        Arrays.copyOf(objArr, objArr.length);
        savedStateConfiguration.getSerializersModule();
        k.m();
        throw null;
    }

    @Composable
    public static final <T> MutableState<T> rememberSerializable(Object[] objArr, x9.b bVar, SavedStateConfiguration savedStateConfiguration, S7.a aVar, Composer composer, int i, int i6) {
        if ((i6 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1248826527, i, -1, "androidx.compose.runtime.saveable.rememberSerializable (RememberSerializable.kt:163)");
        }
        MutableState<T> mutableState = (MutableState) RememberSaveableKt.m3591rememberSaveable(Arrays.copyOf(objArr, objArr.length), RememberSaveableKt.mutableStateSaver(SerializableSaverKt.serializableSaver(bVar, savedStateConfiguration)), (String) null, aVar, composer, (i & 7168) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return mutableState;
    }
}
