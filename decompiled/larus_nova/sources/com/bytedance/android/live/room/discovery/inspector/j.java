package com.bytedance.android.live.room.discovery.inspector;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficialInspectorWidget f99556a;

    public j(OfficialInspectorWidget r100) {
        this.f99556a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        TextView r101 = this.f99556a.f99533c;
        if (r101 == null) goto L13;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L13;
        Object r103 = r100.getAnimatedValue();
        if ((r103 instanceof Integer) == true) goto L9;
        r103 = null;
    L9:
        Integer r104 = (Integer) r103;
        if (r104 == null) goto L12;
        r102.width = r104.intValue();
        goto L13
    L12:
        return;
    L13:
        TextView r105 = this.f99556a.f99533c;
        if (r105 == null) goto L17;
        r105.requestLayout();
        return;
    }
}
