package eg;

import android.view.View;
import me.everything.android.ui.overscroll.adapters.IOverScrollDecoratorAdapter;

/* JADX INFO: loaded from: classes4.dex */
public class a implements IOverScrollDecoratorAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f19428a;

    public a(View r10) {
        this.f19428a = r10;
    }

    @Override // me.everything.android.ui.overscroll.adapters.IOverScrollDecoratorAdapter
    public View getView() {
        return this.f19428a;
    }

    @Override // me.everything.android.ui.overscroll.adapters.IOverScrollDecoratorAdapter
    public boolean isInAbsoluteEnd() {
        return true;
    }

    @Override // me.everything.android.ui.overscroll.adapters.IOverScrollDecoratorAdapter
    public boolean isInAbsoluteStart() {
        return true;
    }
}
