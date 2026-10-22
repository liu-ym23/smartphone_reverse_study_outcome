package androidx.compose.runtime.saveable;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b\u001a\f\u0010\u000e\u001a\u00020\t*\u00020\u000fH\u0002\u001a0\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u0011\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0013*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u0003H\u0002\"\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"SaveableStateRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "restoredValues", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "LocalSaveableStateRegistry", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalSaveableStateRegistry", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "fastIsBlank", "", "toMutableScatterMap", "Landroidx/collection/MutableScatterMap;", "K", "V", "runtime-saveable"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SaveableStateRegistryKt {
    private static final ProvidableCompositionLocal<SaveableStateRegistry> LocalSaveableStateRegistry = null;

    private static final SaveableStateRegistry LocalSaveableStateRegistry$lambda$0() {
        return null;
    }

    public static /* synthetic */ SaveableStateRegistry a() {
        return LocalSaveableStateRegistry$lambda$0();
    }

    static {
        LocalSaveableStateRegistry = CompositionLocalKt.staticCompositionLocalOf(new m());
    }

    public static final ProvidableCompositionLocal<SaveableStateRegistry> getLocalSaveableStateRegistry() {
        return LocalSaveableStateRegistry;
    }

    public static final /* synthetic */ boolean access$fastIsBlank(CharSequence r100) {
        return fastIsBlank(r100);
    }

    public static final /* synthetic */ MutableScatterMap access$toMutableScatterMap(Map r100) {
        return toMutableScatterMap(r100);
    }

    private static final boolean fastIsBlank(CharSequence r100) {
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (CharsKt.isWhitespace(r100.charAt(r102)) == false) goto L12;
        r102 = r102 + 1;
        goto L3
    L12:
        return false;
    L8:
        return true;
    }

    private static final <K, V> MutableScatterMap<K, V> toMutableScatterMap(Map<K, ? extends V> r100) {
        MutableScatterMap<K, V> r101 = new MutableScatterMap(r100.size());
        r101.putAll(r100);
        return r101;
    }

    public static final SaveableStateRegistry SaveableStateRegistry(Map<String, ? extends List<? extends Object>> r100, Function1<Object, Boolean> r101) {
        return new SaveableStateRegistryImpl(r100, r101);
    }
}
