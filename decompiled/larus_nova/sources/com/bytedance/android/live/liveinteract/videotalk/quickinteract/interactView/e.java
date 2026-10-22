package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f79603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkMicQuickInteractView f79604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f79605c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int r100 = this.f79603a.getWidth();
        View r101 = this.f79604b.findViewById(R.id.main_container_view);
        View r102 = this.f79604b.findViewById(R.id.extra_container_view);
        if (r101 == null) goto L5;
        r101.measure(0, 0);
    L5:
        if (r102 == null) goto L7;
        r102.measure(0, 0);
    L7:
        if (r101 == null) goto L9;
        int r103 = r101.getMeasuredWidth();
    L10:
        if (r102 != null) goto L12;
    L16:
        int r104 = 0;
    L17:
        int r105 = r103 + r104;
        ConstraintSet r106 = new ConstraintSet();
        r106.clone(this.f79603a);
        if (r105 <= r100) goto L22;
        r106.clear(this.f79604b.getId(), 6);
        r106.connect(this.f79604b.getId(), 7, 0, 7);
        r106.applyTo(this.f79603a);
        ViewGroup.LayoutParams r107 = this.f79604b.getLayoutParams();
        if (r107 == null) goto L24;
        r107.width = r105;
        this.f79604b.setLayoutParams(r107);
    L24:
        this.f79604b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L22:
        if (r105 >= r100) goto L24;
        this.f79604b.f(this.f79603a);
        goto L24
    L12:
        if (r102.getVisibility() != 0) goto L16;
        if (this.f79605c == true) goto L16;
        r104 = r102.getMeasuredWidth();
        goto L17
    L9:
        r103 = 0;
        goto L10
    }

    public e(ConstraintLayout r100, LinkMicQuickInteractView r101, boolean r102) {
        this.f79603a = r100;
        this.f79604b = r101;
        this.f79605c = r102;
    }
}
