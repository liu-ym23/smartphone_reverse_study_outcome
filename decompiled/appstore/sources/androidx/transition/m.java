package androidx.transition;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static m a(ViewGroup r10) {
        androidx.appcompat.widget.p.a(r10.getTag(R$id.transition_current_scene));
        return null;
    }

    public static void b(ViewGroup r10, m r11) {
        r10.setTag(R$id.transition_current_scene, r11);
    }
}
