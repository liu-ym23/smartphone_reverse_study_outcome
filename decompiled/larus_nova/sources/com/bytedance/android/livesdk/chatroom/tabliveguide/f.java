package com.bytedance.android.livesdk.chatroom.tabliveguide;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InnerCardTabliveGuideView f111675a;

    public f(InnerCardTabliveGuideView r100) {
        this.f111675a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        LiveInnerTabGuideManager r102 = InnerCardTabliveGuideView.j(this.f111675a);
        if (r102 == null) goto L6;
        r102.removeInnerCardItem();
        return;
    }
}
