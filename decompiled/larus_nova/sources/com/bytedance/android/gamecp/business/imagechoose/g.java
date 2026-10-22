package com.bytedance.android.gamecp.business.imagechoose;

import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements zj6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageChooseDialog f56083a;

    @Override // zj6.c
    public final void onTransitionBegin(int r100) {
    }

    public g(ImageChooseDialog r100) {
        this.f56083a = r100;
    }

    @Override // zj6.c
    public final void onTransitionEnd(int r100) {
        if (r100 != 2) goto L8;
        ConstraintLayout r101 = this.f56083a.f56028m;
        if (r101 == null) goto L9;
        UtilityKotlinExtentionsKt.h(r101);
        return;
    L9:
        return;
    }

    @Override // zj6.c
    public final void onTransitionChanged(int r100, float r101) {
        ConstraintLayout r102 = this.f56083a.f56028m;
        if (r102 == null) goto L8;
        Drawable r103 = r102.getBackground();
        if (r103 == null) goto L9;
        r103.setAlpha((int) (r101 * 255));
        return;
    L9:
        return;
    }
}
