package com.bytedance.android.live.soloktv.view;

import android.widget.FrameLayout;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdjustControlTabWrapper f101826a;

    public c(AdjustControlTabWrapper r100) {
        this.f101826a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L10;
        FrameLayout r101 = this.f101826a.f101655l;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        LiveDoubleColorBallAnimationView r102 = this.f101826a.f101656m;
        if (r102 == null) goto L17;
        r102.b();
        return;
    L17:
        return;
    L10:
        FrameLayout r103 = this.f101826a.f101655l;
        if (r103 == null) goto L13;
        r103.setVisibility(4);
    L13:
        LiveDoubleColorBallAnimationView r104 = this.f101826a.f101656m;
        if (r104 == null) goto L19;
        r104.c();
        return;
    }
}
