package an5;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class o0 extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SheetEditorLayout f4528c;

    public o0(SheetEditorLayout r100) {
        this.f4528c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        this.f4528c.f237971y.b("enter_cell_expand");
        this.f4528c.j();
        this.f4528c.k();
        final SheetEditorLayout r101 = this.f4528c;
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{r101.getRootView().getHeight() - r101.f237955k.getHeight(), 0});
        r102.setDuration(350);
        r102.setInterpolator(new DecelerateInterpolator());
        r102.addUpdateListener(new t(r101));
        r102.addListener(new y(r101));
        r102.start();
    }
}
