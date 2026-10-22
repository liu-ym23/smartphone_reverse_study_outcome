package com.bytedance.android.livesdk.chatroom.tabliveguide;

import androidx.lifecycle.LifecycleOwner;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InnerCardTabliveGuideView f111676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f111677b;

    public g(InnerCardTabliveGuideView r100, LifecycleOwner r101) {
        this.f111676a = r100;
        this.f111677b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L8;
        LiveInnerTabGuideManager r101 = InnerCardTabliveGuideView.j(this.f111676a);
        if (r101 == null) goto L9;
        r101.onFirstFrame(this.f111677b);
        return;
    L9:
        return;
    }
}
