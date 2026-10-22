package ce8;

import android.view.ViewTreeObserver;
import com.larus.bmhome.chat.component.util.PaneAwareFrameLayout;

/* JADX INFO: loaded from: classes25.dex */
public final class n implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaneAwareFrameLayout f23482a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        PaneAwareFrameLayout r100 = this.f23482a;
        int r101 = PaneAwareFrameLayout.f301864j;
        r100.c();
        this.f23482a.a();
        return true;
    }

    public n(PaneAwareFrameLayout r100) {
        this.f23482a = r100;
    }
}
