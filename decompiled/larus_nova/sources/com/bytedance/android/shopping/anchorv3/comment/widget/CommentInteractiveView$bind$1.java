package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.shopping.anchorv3.comment.CommentViewModel;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;

/* JADX INFO: loaded from: classes12.dex */
public final class CommentInteractiveView$bind$1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentInteractiveView f164627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommentNodeVO f164628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.anchorv3.commentv2.model.c f164629c;

    public CommentInteractiveView$bind$1(CommentInteractiveView r100, CommentNodeVO r101, CommentViewModel r102) {
        this.f164627a = r100;
        this.f164628b = r101;
        this.f164629c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        long r100 = System.currentTimeMillis();
        CommentInteractiveView r111 = this.f164627a;
        if ((r100 - r111.f164626g) >= 500) goto L5;
        boolean r101 = true;
    L6:
        r111.f164626g = System.currentTimeMillis();
        if (r101 == false) goto L9;
        return;
    L9:
        final CommentNodeVO r112 = this.f164628b;
        if (r112.getLiked() == false) goto L12;
        long r113 = 2;
    L13:
        boolean r102 = r112.getLiked();
        long r103 = r112.getLikes();
        if (r102 == false) goto L16;
        final long r104 = r103 - 1;
    L17:
        ViewPropertyAnimator r105 = this.f164627a.f164622c.animate().scaleX(0.8f).scaleY(0.8f).setDuration(80);
        com.bytedance.android.ec.core.utils.f.b(r105, new CommentInteractiveView$bind$1$$special$$inlined$let$lambda$1(this));
        r105.start();
        this.f164627a.a(!r112.getLiked(), r104);
        this.f164629c.d(r112.getId(), r113, new CommentInteractiveView$bind$1$$special$$inlined$let$lambda$2(r112, r104, this));
        return;
    L16:
        r104 = r103 + 1;
        goto L17
    L12:
        r113 = 1;
        goto L13
    L5:
        r101 = false;
        goto L6
    }
}
