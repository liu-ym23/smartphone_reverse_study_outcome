package androidx.compose.ui.platform;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.larus.nova.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a \u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00130\u0012*\u00020\u0014H\u0002\u001a \u0010\u0015\u001a\u00020\u0014*\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00130\u0012H\u0002\"\u001e\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000f0\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0016"}, d2 = {"DisposableSaveableStateRegistry", "Landroidx/compose/ui/platform/DisposableSaveableStateRegistry;", "view", "Landroid/view/View;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "id", "", "savedStateRegistryOwner", "canBeSavedToBundle", "", "value", "", "AcceptableClasses", "", "Ljava/lang/Class;", "[Ljava/lang/Class;", "toMap", "", "", "Landroid/os/Bundle;", "toBundle", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DisposableSaveableStateRegistry_androidKt {
    private static final Class<? extends Object>[] AcceptableClasses = null;

    static {
        AcceptableClasses = new Class[]{Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};
    }

    public static /* synthetic */ Bundle a(SaveableStateRegistry r100) {
        return DisposableSaveableStateRegistry$lambda$0(r100);
    }

    private static final Bundle DisposableSaveableStateRegistry$lambda$0(SaveableStateRegistry r100) {
        return toBundle(r100.performSave());
    }

    public static final /* synthetic */ boolean access$canBeSavedToBundle(Object r100) {
        return canBeSavedToBundle(r100);
    }

    private static final boolean canBeSavedToBundle(Object r100) {
        if ((r100 instanceof SnapshotMutableState) == false) goto L18;
        SnapshotMutableState r101 = (SnapshotMutableState) r100;
        if (r101.getPolicy() != SnapshotStateKt.neverEqualPolicy()) goto L7;
    L12:
        T r102 = r101.getValue();
        if (r102 != 0) goto L16;
        return true;
    L16:
        return canBeSavedToBundle(r102);
    L7:
        if (r101.getPolicy() == SnapshotStateKt.structuralEqualityPolicy()) goto L12;
        if (r101.getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) goto L12;
        return false;
    L18:
        if ((r100 instanceof Function) == true) goto L20;
    L22:
        Class<? extends Object>[] r103 = AcceptableClasses;
        int r104 = r103.length;
        int r105 = 0;
    L23:
        if (r105 >= r104) goto L28;
        if (r103[r105].isInstance(r100) == true) goto L26;
        r105 = r105 + 1;
        goto L23
    L26:
        return true;
    L28:
        return false;
    L20:
        if ((r100 instanceof Serializable) == false) goto L22;
        return false;
    }

    private static final Bundle toBundle(Map<String, ? extends List<? extends Object>> r100) {
        Bundle r101 = new Bundle();
        Iterator<Map.Entry<String, ? extends List<? extends Object>>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, ? extends List<? extends Object>> r103 = r102.next();
        String r104 = r103.getKey();
        List<? extends Object> r105 = r103.getValue();
        if ((r105 instanceof ArrayList) == false) goto L8;
        ArrayList<? extends Parcelable> r106 = (ArrayList) r105;
    L9:
        r101.putParcelableArrayList(r104, r106);
        goto L4
    L8:
        r106 = new ArrayList(r105);
        goto L9
    L10:
        return r101;
    }

    private static final Map<String, List<Object>> toMap(Bundle r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = (String) r102.next();
        ArrayList r104 = r100.getParcelableArrayList(r103);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>");
        r101.put(r103, r104);
        goto L4
    L6:
        return r101;
    }

    public static final DisposableSaveableStateRegistry DisposableSaveableStateRegistry(String r100, SavedStateRegistryOwner r101) {
        final String r102 = "SaveableStateRegistry:" + r100;
        final SavedStateRegistry r103 = r101.getSavedStateRegistry();
        Bundle r104 = r103.consumeRestoredStateForKey(r102);
        if (r104 == null) goto L5;
        Map<String, List<Object>> r105 = toMap(r104);
    L6:
        final SaveableStateRegistry r106 = SaveableStateRegistryKt.SaveableStateRegistry(r105, DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1.INSTANCE);
        r103.registerSavedStateProvider(r102, new m(r106));     // Catch: IllegalArgumentException -> L9
        final boolean r107 = true;
    L11:
        return new DisposableSaveableStateRegistry(r106, new AnonymousClass1(r107, r103, r102));
    L9:
        r107 = false;
        goto L11
    L5:
        r105 = null;
        goto L6
    }

    public static final DisposableSaveableStateRegistry DisposableSaveableStateRegistry(View r100, SavedStateRegistryOwner r101) {
        Object r102 = r100.getParent();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.View");
        View r103 = (View) r102;
        Object r104 = r103.getTag(R.id.compose_view_saveable_id_tag);
        if ((r104 instanceof String) == false) goto L5;
        String r105 = (String) r104;
    L6:
        if (r105 != null) goto L9;
        r105 = String.valueOf(r103.getId());
    L9:
        return DisposableSaveableStateRegistry(r105, r101);
    L5:
        r105 = null;
        goto L6
    }
}
