package com.bytedance.android.shopping.commentv3.uitree.title;

import android.view.View;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.commentv3.data.interfaces.SubTitle;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentTitleUI f172914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SubTitle f172915b;

    public e(CommentTitleUI r100, SubTitle r101) {
        this.f172914a = r100;
        this.f172915b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        p r101 = p.f48130a;
        CommentTitleUI r102 = this.f172914a;
        int r103 = CommentTitleUI.f172883v;
        r101.openSchema(r102.getContext(), this.f172915b.getSchema());
    }
}
