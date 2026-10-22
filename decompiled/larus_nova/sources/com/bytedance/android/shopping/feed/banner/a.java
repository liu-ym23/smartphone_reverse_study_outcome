package com.bytedance.android.shopping.feed.banner;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.android.ec.core.widget.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ImageSlideListProgressBar f174421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f174422h;

    @Override // com.bytedance.android.ec.core.widget.d
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        ImageSlideListProgressBar r101 = this.f174421g;
        if (r101.f174383b != this.f174422h) goto L5;
        return;
    L5:
        Function1<Boolean, Unit> r102 = r101.getOnProgressBarSelected();
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f174422h <= this.f174421g.f174383b) goto L10;
        boolean r103 = true;
    L11:
        Unit r104 = r102.invoke(Boolean.valueOf(r103));
        return;
    L10:
        r103 = false;
        goto L11
    }

    public a(ImageSlideListProgressBar r100, int r101) {
        this.f174421g = r100;
        this.f174422h = r101;
        super(null, null, 3);
    }
}
