package androidx.savedstate;

import android.view.View;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static final void a(View r10, SavedStateRegistryOwner r11) {
        q.g(r10, "<this>");
        r10.setTag(R$id.view_tree_saved_state_registry_owner, r11);
    }
}
