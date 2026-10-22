package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoViewDialogFragment f168669a;

    public k(PhotoViewDialogFragment r100) {
        this.f168669a = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionBegin(int r100) {
        Iterator<T> r101 = this.f168669a.f168625j.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IIndicatorView) r101.next()).onTransitionBegin(r100);
        goto L4
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
        if (r100 != 2) goto L5;
        this.f168669a.Y90();
    L9:
        Iterator<T> r101 = this.f168669a.f168625j.iterator();
    L11:
        if (r101.hasNext() == false) goto L13;
        ((IIndicatorView) r101.next()).onTransitionEnd(r100);
        goto L11
    L13:
        return;
    L5:
        if (r100 != 3) goto L9;
        PhotoViewDialogFragment r102 = this.f168669a;
        r102.f168627l = r102.f168626k;
        goto L9
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionChanged(int r100, float r101) {
        PhotoViewDialogFragment r102 = this.f168669a;
        if (r100 != 0) goto L5;
        float r103 = r101;
    L15:
        r102.f168626k = r103;
        this.f168669a.W90().getBackground().setAlpha((int) (this.f168669a.f168626k * 255));
        Iterator<T> r104 = this.f168669a.f168625j.iterator();
    L17:
        if (r104.hasNext() == false) goto L19;
        ((IIndicatorView) r104.next()).onTransitionChanged(r100, r101);
        goto L17
    L19:
        return;
    L5:
        if (r100 != 1) goto L7;
        float r105 = r102.f168627l;
        r103 = ((1 - r105) * r101) + r105;
        goto L15
    L7:
        if (r100 != 2) goto L9;
        r103 = (1 - r101) * r102.f168627l;
        goto L15
    L9:
        if (r100 == 3) goto L11;
        r103 = 1.0f;
        goto L15
    L11:
        r103 = 1 - Math.max(r101, 0.0f);
        goto L15
    }
}
