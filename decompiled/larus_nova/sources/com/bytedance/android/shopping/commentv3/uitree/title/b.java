package com.bytedance.android.shopping.commentv3.uitree.title;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements BackComponent.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentTitleUI f172908a;

    public b(CommentTitleUI r100) {
        this.f172908a = r100;
    }

    @Override // com.bytedance.android.ec.base.api.ai.framework.component.BackComponent.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        CommentTitleUI.o(this.f172908a);
    }
}
