package p1;

import android.view.ViewGroup;
import androidx.transition.R$id;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f38136a;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f38137b;

    public static i b(ViewGroup viewGroup) {
        return (i) viewGroup.getTag(R$id.transition_current_scene);
    }

    public static void c(ViewGroup viewGroup, i iVar) {
        viewGroup.setTag(R$id.transition_current_scene, iVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f38136a) != this || (runnable = this.f38137b) == null) {
            return;
        }
        runnable.run();
    }
}
