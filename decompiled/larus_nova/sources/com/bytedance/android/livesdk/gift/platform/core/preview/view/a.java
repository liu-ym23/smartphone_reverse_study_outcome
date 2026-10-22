package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseUgcGiftDialog f131081a;

    public a(BaseUgcGiftDialog r100) {
        this.f131081a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BaseUgcGiftDialog r101 = this.f131081a;
        int r102 = BaseUgcGiftDialog.f131003o;
        r101.getClass();
        RotateAnimation r103 = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        r103.setFillAfter(true);
        r103.setDuration(300);
        r103.setInterpolator(new AccelerateDecelerateInterpolator());
        View r104 = r101.f131012l;
        if (r104 == null) goto L5;
        r104.startAnimation(r103);
    L5:
        Function0<Unit> r105 = this.f131081a.f131006f;
        if (r105 == null) goto L9;
        Unit r106 = r105.invoke();
        return;
    }
}
