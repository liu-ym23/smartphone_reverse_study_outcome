package com.bytedance.android.gamecp.business.comment.edit;

import android.content.Context;
import android.view.View;
import com.bytedance.live.photoviewer.photoviewer.PVMediaModel;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes44.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentEditorImageAdapter f52169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommentEditorImageAdapter.ViewHolder f52170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f52171c;

    public s(CommentEditorImageAdapter r100, CommentEditorImageAdapter.ViewHolder r101, int r102) {
        this.f52169a = r100;
        this.f52170b = r101;
        this.f52171c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = xj6.a.f564102a;
        Context r102 = this.f52170b.itemView.getContext();
        CommentEditorImageAdapter r103 = this.f52169a;
        r103.getClass();
        ArrayList r104 = new ArrayList();
        Iterator<com.bytedance.android.gamecp.base.core.service.depend.w> r105 = r103.f52100c.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        com.bytedance.android.gamecp.base.core.service.depend.w r106 = r105.next();
        if (r106.f51415e == null) goto L4;
        r104.add(new PVMediaModel(MSkiaImageRegionDecoder.FILE_PREFIX + r106.f51415e, 1));
        goto L4
    L8:
        xj6.a.a(r102, r104, this.f52171c, this.f52170b.itemView, null, null, 208);
    }
}
