package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import android.view.View;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends b {
    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final int c() {
        return R.layout.ttlive_audience_panel_profile;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final boolean canShow() {
        return true;
    }

    public g() {
        super(AudiencePanelItemSymbol.PROFILE);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void onClick(View r100) {
        super.onClick(r100);
        t r101 = this.f138971c;
        if ((r101 instanceof u3) == true) goto L5;
        r101 = null;
    L5:
        u3 r102 = (u3) r101;
        if (r102 == null) goto L17;
        IBaseUser r103 = r102.getUserInMessage();
        if (r103 == null) goto L19;
        t r104 = this.f138971c;
        if (r104 == null) goto L13;
        UserProfileEvent r105 = com.bytedance.android.livesdk.interactivity.textmessage.utils.e.a(r104, r103, true);
        xs2.b.a().post(r105);
    L13:
        v r106 = this.f138972d;
        if (r106 == null) goto L18;
        r106.l20(false);
        return;
    L18:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void b(t r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "bridge");
        super.b(r100, r101);
    }
}
