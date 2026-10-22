package androidx.activity;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    public static final void a(View r10, OnBackPressedDispatcherOwner r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "onBackPressedDispatcherOwner");
        r10.setTag(R$id.view_tree_on_back_pressed_dispatcher_owner, r11);
    }
}
