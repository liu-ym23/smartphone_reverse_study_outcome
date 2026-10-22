package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R$id;

/* JADX INFO: loaded from: classes.dex */
public abstract class o0 {
    public static final void a(View r10, LifecycleOwner r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        r10.setTag(R$id.view_tree_lifecycle_owner, r11);
    }
}
