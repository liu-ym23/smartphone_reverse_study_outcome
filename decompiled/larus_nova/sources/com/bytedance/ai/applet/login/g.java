package com.bytedance.ai.applet.login;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g extends BottomSheetBehavior.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f34752a;

    @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior.b
    public final void a(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
    }

    public g(f r100) {
        this.f34752a = r100;
    }

    @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior.b
    public final void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        this.f34752a.getClass();
        com.bytedance.ai.utils.g.f37637a.d("DrawerWidgetContainer", "onStateChanged: newState=" + r101);
        if (r101 != 3) goto L5;
        this.f34752a.getClass();
        ViewGroup r102 = this.f34752a.f34746b;
        if (r102 == null) goto L18;
        r102.setVisibility(0);
        return;
    L18:
        return;
    L5:
        if (r101 != 4) goto L7;
    L9:
        this.f34752a.getClass();
        ViewGroup r103 = this.f34752a.f34746b;
        if (r103 == null) goto L16;
        r103.setVisibility(8);
        return;
    L16:
        return;
    L7:
        if (r101 == 5) goto L9;
    }
}
