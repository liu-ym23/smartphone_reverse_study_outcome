package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.view.View;
import com.bytedance.android.live.profile.customview.ProfileNestedScrollView;
import com.bytedance.android.live.profile.ui.base.n;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements ProfileNestedScrollView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f86622a;

    public c(a r100) {
        this.f86622a = r100;
    }

    @Override // com.bytedance.android.live.profile.customview.ProfileNestedScrollView.b
    public final void a(int r100, int r110, int r111) {
        a r101 = this.f86622a;
        n r102 = (n) r101.f86614e.getValue();
        if (r102 == null) goto L5;
        int r103 = r102.getBottom();
    L6:
        int r104 = a.f86610i;
        if (r100 < (r103 + r104)) goto L15;
        View r105 = r101.f86611b;
        if (r105 != null) goto L11;
    L12:
        View r106 = r101.f86611b;
        if (r106 == null) goto L30;
        r106.setAlpha(1.0f);
    L30:
        a r107 = this.f86622a;
        if (r110 < r111) goto L39;
        if (r107.f86616g == true) goto L45;
        View r112 = r107.f86611b;
        if (r112 == null) goto L37;
        r112.setOnClickListener(b.f86621a);
    L37:
        r107.f86616g = true;
        return;
    L45:
        return;
    L39:
        if (r107.f86616g == false) goto L47;
        View r113 = r107.f86611b;
        if (r113 == null) goto L43;
        r113.setOnClickListener(null);
    L43:
        r107.f86616g = false;
        return;
    L47:
        return;
    L11:
        if (r105.getAlpha() == 1.0f) goto L30;
    L15:
        if (r100 >= r103) goto L23;
        View r108 = r101.f86611b;
        if (r108 != null) goto L19;
    L20:
        View r109 = r101.f86611b;
        if (r109 == null) goto L30;
        r109.setAlpha(0.0f);
        goto L30
    L19:
        if (r108.getAlpha() == 0.0f) goto L30;
    L23:
        float r114 = (float) (((double) (r100 - r103)) / ((double) r104));
        View r115 = r101.f86611b;
        if (r115 != null) goto L26;
    L27:
        View r116 = r101.f86611b;
        if (r116 == null) goto L30;
        r116.setAlpha(r114);
        goto L30
    L26:
        if (r115.getAlpha() == r114) goto L30;
    L5:
        r103 = 0;
        goto L6
    }
}
