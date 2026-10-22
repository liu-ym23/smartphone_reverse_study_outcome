package cc3;

import android.view.View;
import com.bytedance.android.shopping.commentgallery.view.CommentGalleryVideoVHNew;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentGalleryVideoVHNew f23232a;

    public e(CommentGalleryVideoVHNew r100) {
        this.f23232a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f23232a.f172535c.h() == false) goto L5;
        this.f23232a.T3();
        return;
    L5:
        this.f23232a.play();
    }
}
