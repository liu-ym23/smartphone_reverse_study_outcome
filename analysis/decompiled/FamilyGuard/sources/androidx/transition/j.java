package androidx.transition;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f11422a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f11423b;

    public static j b(ViewGroup viewGroup) {
        return (j) viewGroup.getTag(h.f11419c);
    }

    static void c(ViewGroup viewGroup, j jVar) {
        viewGroup.setTag(h.f11419c, jVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f11422a) != this || (runnable = this.f11423b) == null) {
            return;
        }
        runnable.run();
    }
}
