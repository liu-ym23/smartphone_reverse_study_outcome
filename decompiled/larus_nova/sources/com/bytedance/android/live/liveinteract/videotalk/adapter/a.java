package com.bytedance.android.live.liveinteract.videotalk.adapter;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.multilink.base.model.c0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdjustGuestPositionListAdapter f79062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f79063b;

    public a(AdjustGuestPositionListAdapter r100, int r101) {
        this.f79062a = r100;
        this.f79063b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (((c0) ListProtector.get(this.f79062a.f79043c, this.f79063b)).getEnable() == false) goto L8;
        b r101 = this.f79062a.f79045e;
        if (r101 == null) goto L7;
        r101.onItemClick(this.f79063b);
    L7:
        AdjustGuestPositionListAdapter r102 = this.f79062a;
        int r103 = this.f79063b;
        r102.f79044d = r103;
        r102.f79046f = (c0) ListProtector.get(r102.f79043c, r103);
        this.f79062a.notifyDataSetChanged();
        return;
    L8:
        f2.b(R.string.ttlive_link_position_prohibited_toast, 0);
    }
}
