package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.text.TextUtils;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;

/* JADX INFO: loaded from: classes9.dex */
public final class m1 implements z62.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1.a f135932a;

    @Override // z62.i
    public final void onUpdate() {
        o1.a r100 = this.f135932a;
        BaseCommentGiftGuideView r101 = r100.f135944e.f135941c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.f135513b.m0() == true) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r102 = this.f135932a.f135513b.V();
        if (r102 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r103 = r102.f135419g;
        if (r103 == null) goto L13;
        boolean r104 = true;
        if ((!TextUtils.isEmpty(r103.f135370f)) == true) goto L13;
    L14:
        r101.setGuideEnable(r104);
        return;
    L13:
        r104 = false;
        goto L14
    }

    public m1(o1.a r100) {
        this.f135932a = r100;
    }
}
