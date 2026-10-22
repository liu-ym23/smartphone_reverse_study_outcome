package A2;

import android.content.Context;
import android.view.View;

/* renamed from: A2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0268g<Data> {

    /* renamed from: a, reason: collision with root package name */
    protected View f123a;

    public abstract void a(Data data);

    public View b(Context context) {
        View viewD = d(context);
        this.f123a = viewD;
        return viewD;
    }

    public void c() {
        View view = this.f123a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    protected abstract View d(Context context);

    public void e() {
        View view = this.f123a;
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
