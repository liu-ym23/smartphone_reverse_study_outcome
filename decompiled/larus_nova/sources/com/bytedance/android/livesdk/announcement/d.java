package com.bytedance.android.livesdk.announcement;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f103357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f103358b;

    public d(int r100, long r101) {
        this.f103357a = r100;
        this.f103358b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f103357a != 0) goto L5;
        String[] r101 = com.bytedance.android.livesdk.announce.c.f103134a;
        f2.c(s1.C(R.string.ttlive_annocement_setting_banned_text_for_not_on_time, new Object[]{com.bytedance.android.livesdk.announce.c.a(this.f103358b * ((long) 1000))}), 0);
        return;
    L5:
        String[] r102 = com.bytedance.android.livesdk.announce.c.f103134a;
        f2.c(s1.C(R.string.ttlive_annocement_setting_banned_text_for_audit, new Object[]{com.bytedance.android.livesdk.announce.c.a(this.f103358b * ((long) 1000))}), 0);
    }
}
