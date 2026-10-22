package com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.platform.depend.user.IContactActiveViewHolderWrapper;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements IContactActiveViewHolderWrapper.IContactActiveCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InviteeUserItemViewBinder.ItemViewHolder f134687a;

    public a(InviteeUserItemViewBinder.ItemViewHolder r100) {
        this.f134687a = r100;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.user.IContactActiveViewHolderWrapper.IContactActiveCallback
    public final void onActiveChanged(boolean r100) {
        if (r100 == false) goto L4;
        this.f134687a.f134662c.setVisibility(0);
        this.f134687a.f134662c.setImageResource(R.drawable.ttlive_chat_channel_invite_contact_active);
        this.f134687a.f134660a.setCircleRadius(UtilityKotlinExtentionsKt.i(10));
        this.f134687a.f134661b.setCircleRadius(UtilityKotlinExtentionsKt.i(10));
        return;
    L4:
        this.f134687a.f134662c.setVisibility(8);
        this.f134687a.f134660a.setCircleRadius(0.0f);
        this.f134687a.f134661b.setCircleRadius(0.0f);
    }
}
