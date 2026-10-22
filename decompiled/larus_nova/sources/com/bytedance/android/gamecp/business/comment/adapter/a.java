package com.bytedance.android.gamecp.business.comment.adapter;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentEditorLabelAdapter f51970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f51971b;

    public a(CommentEditorLabelAdapter r100, int r101) {
        this.f51970a = r100;
        this.f51971b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CommentEditorLabelAdapter r101 = this.f51970a;
        Function1<? super com.bytedance.android.gamecp.business.comment.data.n, Unit> r102 = r101.f51888b;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(ListProtector.get(r101.f51887a, this.f51971b));
        return;
    }
}
