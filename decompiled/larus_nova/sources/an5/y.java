package an5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class y extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetEditorLayout f4542a;

    public y(SheetEditorLayout r100) {
        this.f4542a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        SheetEditorLayout r101 = this.f4542a;
        if (r101.M == false) goto L6;
        rcb.c.h(r101.f237954j, null);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        SheetEditorLayout r101 = this.f4542a;
        r101.f237945a.getLayoutParams().height = -1;
        r101.f237945a.requestLayout();
        this.f4542a.f237953i.setVisibility(0);
        this.f4542a.f237955k.setVisibility(8);
        SheetEditorLayout r102 = this.f4542a;
        r102.E = true;
        r102.f();
        this.f4542a.f237954j.getPresenter().d().c();
        this.f4542a.f237958m.getSegments().subscribe(new w(this), new x());
        wm5.b r103 = this.f4542a.f237970x;
        if (r103 == null) goto L6;
        r103.b();
        return;
    }
}
