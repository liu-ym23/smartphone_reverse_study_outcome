package android.view;

import S7.k;
import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"androidx/savedstate/SavedStateKt__SavedStateKt", "androidx/savedstate/SavedStateKt__SavedState_androidKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateKt {
    public static final <T> T read(Bundle bundle, k kVar) {
        return (T) SavedStateKt__SavedStateKt.read(bundle, kVar);
    }

    public static final Bundle savedState(Bundle bundle, k kVar) {
        return SavedStateKt__SavedState_androidKt.savedState(bundle, kVar);
    }

    public static final <T> T write(Bundle bundle, k kVar) {
        return (T) SavedStateKt__SavedStateKt.write(bundle, kVar);
    }

    public static final Bundle savedState(Map<String, ? extends Object> map, k kVar) {
        return SavedStateKt__SavedState_androidKt.savedState(map, kVar);
    }
}
