package com.bytedance.android.livesdk.chatroom.tabliveguide;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveInnerTabliveGuideFragment f111686a;

    public l(LiveInnerTabliveGuideFragment r100) {
        this.f111686a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        if (r101 == null) goto L27;
        int r102 = ((Number) r101.component1()).intValue();
        int r103 = ((Number) r101.component2()).intValue();
        FrameLayout r104 = this.f111686a.f111656h;
        ViewGroup.MarginLayoutParams r105 = null;
        if (r104 == null) goto L8;
        ViewGroup.LayoutParams r106 = r104.getLayoutParams();
    L10:
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == true) goto L12;
        r106 = null;
    L12:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r107 == null) goto L28;
        r107.width = (int) (r107.height * (r102 / r103));
        if ((r107 instanceof FrameLayout.LayoutParams) == false) goto L19;
        r105 = r107;
    L19:
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r105;
        if (r108 == null) goto L22;
        r108.gravity = 1;
    L22:
        FrameLayout r109 = this.f111686a.f111656h;
        if (r109 == null) goto L26;
        r109.setLayoutParams(r107);
        return;
    L26:
        return;
    L28:
        return;
    L8:
        r106 = null;
        goto L10
    }
}
