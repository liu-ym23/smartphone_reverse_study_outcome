package com.bytedance.android.livesdk.interactivity.comment.mention;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.platform.depend.user.IHostUserActiveChangeCallback;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements IHostUserActiveChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MentionAvatarViewHolder f135299a;

    public a(MentionAvatarViewHolder r100) {
        this.f135299a = r100;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.user.IHostUserActiveChangeCallback
    public final void onActiveChanged(boolean r100) {
        MentionAvatarViewHolder r101 = this.f135299a;
        r101.f135257g = r100;
        if (r100 == false) goto L5;
        r101.f135251a.setCircleRadius(UtilityKotlinExtentionsKt.h(12));
        return;
    L5:
        l r102 = r101.f135255e;
        if (r102 != null) goto L8;
    L9:
        r101.f135251a.setCircleRadius(0.0f);
        return;
    L8:
        if (r102.f135311b != true) goto L9;
    }
}
