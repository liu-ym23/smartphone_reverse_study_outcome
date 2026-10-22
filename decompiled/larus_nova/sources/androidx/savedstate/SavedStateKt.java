package androidx.savedstate;

import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"androidx/savedstate/SavedStateKt__SavedStateKt", "androidx/savedstate/SavedStateKt__SavedState_androidKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class SavedStateKt {
    public static final <T> T read(Bundle r100, Function1<? super SavedStateReader, ? extends T> r101) {
        return (T) SavedStateKt__SavedStateKt.read(r100, r101);
    }

    public static final Bundle savedState(Bundle r100, Function1<? super SavedStateWriter, Unit> r101) {
        return SavedStateKt__SavedState_androidKt.savedState(r100, r101);
    }

    public static final <T> T write(Bundle r100, Function1<? super SavedStateWriter, ? extends T> r101) {
        return (T) SavedStateKt__SavedStateKt.write(r100, r101);
    }

    public static final Bundle savedState(Map<String, ? extends Object> r100, Function1<? super SavedStateWriter, Unit> r101) {
        return SavedStateKt__SavedState_androidKt.savedState(r100, r101);
    }

    public static /* synthetic */ Bundle savedState$default(Bundle r100, Function1 r101, int r102, Object r103) {
        return SavedStateKt__SavedState_androidKt.savedState$default(r100, r101, r102, r103);
    }

    public static /* synthetic */ Bundle savedState$default(Map r100, Function1 r101, int r102, Object r103) {
        return SavedStateKt__SavedState_androidKt.savedState$default(r100, r101, r102, r103);
    }
}
