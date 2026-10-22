package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.event.a1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IronPromotionListTopCategoryWidget f149230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IronPromotionListTopCategoryWidget$createExpandView$view$1 f149231b;

    public g(IronPromotionListTopCategoryWidget r100, IronPromotionListTopCategoryWidget$createExpandView$view$1 r101) {
        this.f149230a = r100;
        this.f149231b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        View r101 = this.f149231b.getTagView();
        if (r101 != null) goto L5;
    L10:
        IronPromotionListTopCategoryWidget r102 = this.f149230a;
        if (r102.f149145k == false) goto L13;
        r102.b();
    L14:
        new a1(false, this.f149230a.f149147m).k();
        return;
    L13:
        r102.a();
        goto L14
    L5:
        if (r101.isEnabled() == true) goto L10;
        Function1<? super View, Unit> r103 = this.f149230a.f149148n;
        if (r103 == null) goto L16;
        Unit r104 = r103.invoke(this.f149231b);
        return;
    }
}
