package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.View;
import com.bytedance.android.shopping.feed.resourcecard.frequency.ResourceCardFreqController;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yd3.p f175395a;

    public k(yd3.p r100) {
        this.f175395a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f175395a.getType() == 7) goto L10;
        Lazy r101 = ResourceCardFreqController.f175190a;
        yd3.d r102 = this.f175395a.c();
        if (r102 == null) goto L7;
        Integer r103 = r102.b();
    L8:
        ResourceCardFreqController.d(r103);
        return;
    L7:
        r103 = null;
        goto L8
    }
}
