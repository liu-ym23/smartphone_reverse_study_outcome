package android.view.viewmodel.compose;

import G6.e;
import S7.a;
import V7.b;
import V7.c;
import Z7.t;
import android.os.Bundle;
import android.view.SavedStateHandle;
import android.view.SavedStateRegistry;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aK\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00000\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001aQ\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00000\u00052\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0007H\u0007¢\u0006\u0004\b\t\u0010\r\u001a_\u0010\t\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00028\u00000\u000f0\u000e\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00000\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0007¢\u0006\u0004\b\t\u0010\u0010\u001ak\u0010\t\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00028\u00000\u00120\u000e\"\u0004\b\u0000\u0010\u0001\"\u000e\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u00028\u00000\f*\u00020\u00022\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00000\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u0010\u001aE\u0010\u0015\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\f0\u0005\"\u0004\b\u0000\u0010\u00012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00000\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/SavedStateHandle;", "", "key", "Landroidx/compose/runtime/saveable/Saver;", "saver", "Lkotlin/Function0;", "init", "saveable", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Landroidx/compose/runtime/saveable/Saver;LS7/a;)Ljava/lang/Object;", "stateSaver", "Landroidx/compose/runtime/MutableState;", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Landroidx/compose/runtime/saveable/Saver;LS7/a;)Landroidx/compose/runtime/MutableState;", "LV7/a;", "LV7/b;", "(Landroidx/lifecycle/SavedStateHandle;Landroidx/compose/runtime/saveable/Saver;LS7/a;)LV7/a;", "M", "LV7/c;", "saveableMutableState", "inner", "mutableStateSaver", "(Landroidx/compose/runtime/saveable/Saver;)Landroidx/compose/runtime/saveable/Saver;", "lifecycle-viewmodel-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateHandleSaverKt {
    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(final Saver<T, ? extends Object> saver) {
        k.d(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.mutableStateSaver, kotlin.Any>");
        return SaverKt.Saver(new e(saver, 4), new S7.k() { // from class: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt$mutableStateSaver$1$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // S7.k
            public final MutableState<T> invoke(MutableState<Object> mutableState) {
                Object objRestore;
                if (!(mutableState instanceof SnapshotMutableState)) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                SnapshotMutableState snapshotMutableState = (SnapshotMutableState) mutableState;
                if (snapshotMutableState.getValue() != 0) {
                    Saver<T, Object> saver2 = saver;
                    Object value = snapshotMutableState.getValue();
                    k.c(value);
                    objRestore = saver2.restore(value);
                } else {
                    objRestore = null;
                }
                SnapshotMutationPolicy policy = snapshotMutableState.getPolicy();
                k.d(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.mutableStateSaver?>");
                MutableState<T> mutableStateMutableStateOf = SnapshotStateKt.mutableStateOf(objRestore, policy);
                k.d(mutableStateMutableStateOf, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<T of androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.mutableStateSaver>");
                return mutableStateMutableStateOf;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState mutableStateSaver$lambda$7$lambda$6(Saver saver, SaverScope saverScope, MutableState mutableState) {
        if (!(mutableState instanceof SnapshotMutableState)) {
            throw new IllegalArgumentException("If you use a custom MutableState implementation you have to write a custom Saver and pass it as a saver param to rememberSaveable()");
        }
        SnapshotMutableState snapshotMutableState = (SnapshotMutableState) mutableState;
        Object objSave = saver.save(saverScope, snapshotMutableState.getValue());
        SnapshotMutationPolicy policy = snapshotMutableState.getPolicy();
        k.d(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<kotlin.Any?>");
        return SnapshotStateKt.mutableStateOf(objSave, policy);
    }

    @SavedStateHandleSaveableApi
    /* renamed from: saveable, reason: collision with other method in class */
    public static final <T> T m7159saveable(SavedStateHandle savedStateHandle, String str, final Saver<T, ? extends Object> saver, a aVar) {
        T tRestore;
        Object obj;
        k.d(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.saveable, kotlin.Any>");
        Bundle bundle = (Bundle) savedStateHandle.get(str);
        if (bundle == null || (obj = bundle.get("value")) == null || (tRestore = saver.restore(obj)) == null) {
            tRestore = (T) aVar.invoke();
        }
        final T t9 = tRestore;
        savedStateHandle.setSavedStateProvider(str, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.viewmodel.compose.a
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                return SavedStateHandleSaverKt.saveable$lambda$1(saver, t9);
            }
        });
        return tRestore;
    }

    public static /* synthetic */ Object saveable$default(SavedStateHandle savedStateHandle, String str, Saver saver, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            saver = SaverKt.autoSaver();
        }
        return m7159saveable(savedStateHandle, str, saver, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle saveable$lambda$1(Saver saver, Object obj) {
        return BundleKt.bundleOf(new Pair("value", saver.save(new SavedStateHandleSaverKt$saveable$1$1$1(SavedStateHandle.INSTANCE), obj)));
    }

    private static final b saveable$lambda$3(SavedStateHandle savedStateHandle, Saver saver, a aVar, Object obj, t tVar) {
        String str;
        if (obj != null) {
            str = m.f4928a.b(obj.getClass()).l() + '.';
        } else {
            str = "";
        }
        StringBuilder sbV = androidx.compose.foundation.b.v(str);
        sbV.append(tVar.getName());
        return new B5.a(m7159saveable(savedStateHandle, sbV.toString(), saver, aVar), 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object saveable$lambda$3$lambda$2(Object obj, Object obj2, t tVar) {
        return obj;
    }

    private static final c saveable$lambda$4(SavedStateHandle savedStateHandle, Saver saver, a aVar, Object obj, t tVar) {
        String str;
        if (obj != null) {
            str = m.f4928a.b(obj.getClass()).l() + '.';
        } else {
            str = "";
        }
        StringBuilder sbV = androidx.compose.foundation.b.v(str);
        sbV.append(tVar.getName());
        final MutableState mutableStateSaveable = saveable(savedStateHandle, sbV.toString(), saver, aVar);
        return new c() { // from class: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt$saveable$3$1
            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
            @Override // V7.b
            public T getValue(Object thisRef, t property) {
                return mutableStateSaveable.getValue();
            }

            public void setValue(Object thisRef, t property, T value) {
                mutableStateSaveable.setValue(value);
            }
        };
    }

    @SavedStateHandleSaveableApi
    public static final <T, M extends MutableState<T>> V7.a saveableMutableState(SavedStateHandle savedStateHandle, Saver<T, ? extends Object> saver, a aVar) {
        return new B5.a(saver, 12);
    }

    public static /* synthetic */ V7.a saveableMutableState$default(SavedStateHandle savedStateHandle, Saver saver, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            saver = SaverKt.autoSaver();
        }
        return saveableMutableState(savedStateHandle, saver, aVar);
    }

    public static /* synthetic */ V7.a saveable$default(SavedStateHandle savedStateHandle, Saver saver, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            saver = SaverKt.autoSaver();
        }
        return saveable(savedStateHandle, saver, aVar);
    }

    @SavedStateHandleSaveableApi
    public static final <T> MutableState<T> saveable(SavedStateHandle savedStateHandle, String str, Saver<T, ? extends Object> saver, a aVar) {
        return (MutableState) m7159saveable(savedStateHandle, str, mutableStateSaver(saver), aVar);
    }

    @SavedStateHandleSaveableApi
    public static final <T> V7.a saveable(SavedStateHandle savedStateHandle, Saver<T, ? extends Object> saver, a aVar) {
        return new B5.a(saver, 12);
    }
}
