package com.bytedance.android.shopping.store.home.view;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.a2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FollowGiftBubbleView f184743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f184744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f184745c;

    public s(FollowGiftBubbleView r100, View r101, ViewGroup r102) {
        this.f184743a = r100;
        this.f184744b = r101;
        this.f184745c = r102;
    }

    public final void a() {
        int[] r100 = new int[2];
        int[] r101 = new int[2];
        this.f184744b.getLocationInWindow(r100);
        this.f184745c.getLocationInWindow(r101);
        dm.a.a("FollowGiftBubbleView").a("anchorView location: (" + r100[0] + ',' + r100[1] + "), containerLocation: (" + r101[0] + ", " + r101[1] + ')');
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, FollowGiftBubbleView.f184621e);
        r102.rightMargin = (r101[0] + this.f184745c.getWidth()) - (r100[0] + this.f184744b.getWidth());
        r102.topMargin = (r100[1] - r101[1]) - FollowGiftBubbleView.f184620d;
        r102.gravity = 8388661;
        FollowGiftBubbleView r103 = this.f184743a;
        r103.setText(r103.f184622a);
        String r104 = this.f184743a.f184623b;
        String r105 = null;
        if (r104 != null) goto L5;
    L10:
        String r106 = this.f184743a.f184624c;
        if (r106 != null) goto L13;
    L19:
        this.f184743a.y();
        this.f184745c.addView(this.f184743a, r102);
        return;
    L13:
        if (a2.b(r106) == false) goto L15;
        r105 = r106;
    L15:
        if (r105 == null) goto L19;
        Drawable r107 = this.f184743a.getBackground();
        if (r107 == null) goto L19;
        r107.setColorFilter(com.bytedance.android.ec.core.utils.s.a(r105, 16711760), PorterDuff.Mode.SRC_ATOP);
        goto L19
    L5:
        if (a2.b(r104) == true) goto L8;
        r104 = null;
    L8:
        if (r104 == null) goto L10;
        this.f184743a.setTextColor(com.bytedance.android.ec.core.utils.s.a(r104, 16777215));
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
