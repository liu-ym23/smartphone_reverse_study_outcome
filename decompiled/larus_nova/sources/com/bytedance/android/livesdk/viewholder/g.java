package com.bytedance.android.livesdk.viewholder;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GuideChatConfViewHolder f159292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.base.model.message.h f159293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f159294c;

    public g(GuideChatConfViewHolder r100, com.bytedance.android.live.base.model.message.h r101, String r102) {
        this.f159292a = r100;
        this.f159293b = r101;
        this.f159294c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f159293b.getType() != 1) goto L5;
        String r101 = s1.B(R.string.ttlive_emoji_guide_chat_say_hi_input_box);
    L6:
        jf2.b r102 = this.f159292a.f159267c;
        if (r102 == null) goto L10;
        r102.t1(this.f159293b, r101);
        return;
    L10:
        return;
    L5:
        r101 = s1.B(R.string.ttlive_emoji_guide_chat_location) + this.f159294c;
        goto L6
    }
}
