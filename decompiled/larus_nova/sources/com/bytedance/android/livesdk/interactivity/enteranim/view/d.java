package com.bytedance.android.livesdk.interactivity.enteranim.view;

import ak6.g;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.UserDslBadgeUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements UserDslBadgeUtils.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseEnterView f136875a;

    public d(BaseEnterView r100) {
        this.f136875a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.utils.UserDslBadgeUtils.a
    public final void a(g r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        NoMoreSpaceTextView r102 = this.f136875a.f136806b;
        if (r102 == null) goto L5;
        r102.setText(r100.f4074a);
    L5:
        NoMoreSpaceTextView r103 = this.f136875a.f136806b;
        if (r103 == null) goto L8;
        r103.setAlwaysInvalidate(r101);
    L8:
        this.f136875a.invalidate();
        BaseEnterView r104 = this.f136875a;
        e r105 = r104.f136811g;
        if (r105 == null) goto L12;
        ((UserEnterLevelView) r105).e(r104);
        return;
    }
}
