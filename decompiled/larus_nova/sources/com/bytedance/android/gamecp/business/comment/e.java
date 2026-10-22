package com.bytedance.android.gamecp.business.comment;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentImageSummaryAdapter f52057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f52058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CommentImageSummaryAdapter.ViewHolder f52059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f52060d;

    public static final class a implements y.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f52061a;

        @Override // com.bytedance.android.gamecp.common.utils.y.a
        public final void a() {
        }

        @Override // com.bytedance.android.gamecp.common.utils.y.a
        public final void onLoadFailed() {
            ImageView r100 = this.f52061a.f52059c.f51826b;
            if (r100 == null) goto L6;
            UtilityKotlinExtentionsKt.j(r100);
            return;
        }

        @Override // com.bytedance.android.gamecp.common.utils.y.a
        public final void onLoadSuccess() {
            ImageView r100 = this.f52061a.f52059c.f51826b;
            if (r100 == null) goto L6;
            UtilityKotlinExtentionsKt.h(r100);
            return;
        }

        public a(e r100) {
            this.f52061a = r100;
        }
    }

    public e(CommentImageSummaryAdapter r100, int r101, CommentImageSummaryAdapter.ViewHolder r102, Function1 r103) {
        this.f52057a = r100;
        this.f52058b = r101;
        this.f52059c = r102;
        this.f52060d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<? super Integer, ? extends com.bytedance.android.gamecp.business.gallery.transfer.h> r101 = this.f52057a.f51821d;
        if (r101 == null) goto L5;
        com.bytedance.android.gamecp.business.gallery.transfer.h r102 = r101.invoke(Integer.valueOf(this.f52058b));
    L5:
        ImageView r103 = this.f52059c.f51826b;
        if (r103 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L14;
        this.f52060d.invoke(new a(this));
        return;
    L14:
        return;
    L8:
        if (r103.getVisibility() != 0) goto L10;
        r104 = true;
        goto L11
    }
}
