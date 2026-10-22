package com.bytedance.android.livesdk.chatroom.tabliveguide;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InnerCardTabliveGuideView f111674a;

    public e(InnerCardTabliveGuideView r100) {
        this.f111674a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        LiveInnerTabGuideManager r102 = InnerCardTabliveGuideView.j(this.f111674a);
        if (r102 == null) goto L6;
        r102.removeInnerCardItem();
        return;
    }
}
