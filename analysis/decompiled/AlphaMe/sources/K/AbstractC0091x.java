package K;

import android.R;
import android.view.View;

/* renamed from: K.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0091x extends y1.f {

    /* renamed from: c, reason: collision with root package name */
    public final View f1014c;

    public AbstractC0091x(View view) {
        super(7);
        this.f1014c = view;
    }

    @Override // y1.f
    public void p() {
        View viewFindViewById;
        View view = this.f1014c;
        if (view == null) {
            return;
        }
        if (view.isInEditMode() || view.onCheckIsTextEditor()) {
            view.requestFocus();
            viewFindViewById = view;
        } else {
            viewFindViewById = view.getRootView().findFocus();
        }
        if (viewFindViewById == null) {
            viewFindViewById = view.getRootView().findViewById(R.id.content);
        }
        if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
            return;
        }
        viewFindViewById.post(new RunnableC0090w(0, viewFindViewById));
    }
}
