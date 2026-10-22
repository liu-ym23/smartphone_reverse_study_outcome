package aec;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes38.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f3132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView.ViewHolder f3133b;

    public abstract void g(View r100);

    public e() {
    }

    public final void f(View r100) {
        this.f3132a = r100;
        g(r100);
    }
}
