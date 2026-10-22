package com.bytedance.android.gamecp.business.imagechoose;

import android.view.View;
import com.bytedance.android.gamecp.base.core.service.depend.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageChooseSummaryAdapter f56084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f56085b;

    public h(ImageChooseSummaryAdapter r100, w r101) {
        this.f56084a = r100;
        this.f56085b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<? super w, Unit> r101 = this.f56084a.f56055c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mImageSummaryCancelListener");
    L5:
        r101.invoke(this.f56085b);
    }
}
