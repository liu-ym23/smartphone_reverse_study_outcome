package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.View;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTalkGuestSearchViewHolder f74946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f74947b;

    public e(BaseTalkGuestSearchViewHolder r100, HashMap r101) {
        this.f74946a = r100;
        this.f74947b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        j0.l().sendLog("livesdk_invitation_search_click", this.f74947b, new Object[]{IRoom.class});
        v r101 = this.f74946a.f74854a;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
