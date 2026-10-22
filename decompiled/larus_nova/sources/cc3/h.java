package cc3;

import com.bytedance.android.shopping.commentgallery.view.CommentPhotoVH;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentPhotoVH f23235a;

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionBegin(int r100) {
    }

    public h(CommentPhotoVH r100) {
        this.f23235a = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
        if (r100 != 3) goto L6;
        CommentPhotoVH r101 = this.f23235a;
        r101.f172550f = r101.f172551g;
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionChanged(int r100, float r101) {
        CommentPhotoVH r102 = this.f23235a;
        if (r100 != 0) goto L5;
    L14:
        r102.f172551g = r101;
        CommentPhotoVH r103 = this.f23235a;
        if (r103.f172551g <= 1.0f) goto L18;
        r103.f172551g = 1.0f;
    L18:
        if (r103.f172551g >= 0.0f) goto L20;
        r103.f172551g = 0.0f;
    L20:
        r103.f172549e.getBackground().setAlpha((int) (this.f23235a.f172551g * 255));
        return;
    L5:
        if (r100 != 1) goto L7;
        float r104 = r102.f172550f;
        r101 = r104 + ((1 - r104) * r101);
        goto L14
    L7:
        if (r100 != 2) goto L9;
        r101 = r102.f172550f * (1 - r101);
        goto L14
    L9:
        if (r100 == 3) goto L11;
        r101 = 1.0f;
        goto L14
    L11:
        r101 = 1 - RangesKt.coerceAtLeast(r101, 0.0f);
        goto L14
    }
}
