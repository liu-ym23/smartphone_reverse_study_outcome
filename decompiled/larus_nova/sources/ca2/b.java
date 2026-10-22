package ca2;

import com.bytedance.android.livesdk.interactivity.publicscreen.preview.transition.TransitionPhotoDraweeView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransitionPhotoDraweeView f22923a;

    public b(TransitionPhotoDraweeView r100) {
        this.f22923a = r100;
    }

    @Override // ca2.a
    public final void onTransitionBegin(int r100) {
        Iterator<T> r101 = this.f22923a.f139353n.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).onTransitionBegin(r100);
        goto L4
    }

    @Override // ca2.a
    public final void onTransitionEnd(int r100) {
        Iterator<T> r101 = this.f22923a.f139353n.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).onTransitionEnd(r100);
        goto L4
    }

    @Override // ca2.a
    public final void onTransitionChanged(int r100, float r101) {
        Iterator<T> r102 = this.f22923a.f139353n.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((a) r102.next()).onTransitionChanged(r100, r101);
        goto L4
    }
}
