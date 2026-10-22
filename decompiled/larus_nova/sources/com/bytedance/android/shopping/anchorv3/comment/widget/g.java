package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.shopping.gallery2.newgallery.NewGalleryViewer;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class g implements OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewGalleryViewer f164705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommentMediaView f164706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f164707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f164708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List f164709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ View f164710f;

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener
    public final void onDismiss(int r100) {
        com.bytedance.android.shopping.utils.f.f187079b = false;
        long r101 = System.currentTimeMillis();
        CommentMediaView r102 = this.f164706b;
        if ((r101 - r102.f164652g) <= 2000) goto L26;
        Iterator<Integer> r103 = r102.f164651f.iterator();
        int r104 = 1;
    L6:
        if (r103.hasNext() == false) goto L10;
        int r105 = Math.abs(r103.next().intValue() - this.f164708d) + 1;
        if (r105 <= r104) goto L6;
        r104 = r105;
        goto L6
    L10:
        CommentNodeVO r106 = this.f164706b.f164648c;
        if (r106 == null) goto L19;
        t53.b r107 = t53.b.f544622a;
        int r108 = ((zb3.e) ListProtector.get(this.f164709e, this.f164708d)).getType();
        CommentMediaView r109 = this.f164706b;
        int r110 = r109.f164649d + 1;
        com.bytedance.android.shopping.anchorv3.commentv2.model.c r111 = r109.f164647b;
        if (r111 != null) goto L15;
    L17:
        String r112 = "list";
    L18:
        Context r113 = this.f164705a.getContext();
        r107.getClass();
        t53.b.e(r108, r110, r104, r106, r112, r113);
        goto L19
    L15:
        if (r111.c() != true) goto L17;
        r112 = "pic";
    L19:
        this.f164706b.f164652g = System.currentTimeMillis();
        return;
    }

    public g(NewGalleryViewer r100, CommentMediaView r101, List r102, int r103, List r104, View r105) {
        this.f164705a = r100;
        this.f164706b = r101;
        this.f164707c = r102;
        this.f164708d = r103;
        this.f164709e = r104;
        this.f164710f = r105;
    }
}
