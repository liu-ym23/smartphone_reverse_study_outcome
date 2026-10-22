package com.bytedance.android.livesdk.widget;

import android.content.Context;
import com.bytedance.android.livesdk.w8;
import com.bytedance.android.livesdk.z8;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes11.dex */
public final class c0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GuidePageController f161481a;

    public c0(GuidePageController r100) {
        this.f161481a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.intValue() != 3) goto L18;
        h70.b r102 = this.f161481a.f160901b;
        if (r102 == null) goto L10;
        Context r103 = r102.getContext();
    L12:
        if (SharedPrefHelper.b(r103).h("live.pref.PREF_SINGLE_TAP_CLEARSCREEN_ENTRANCE_GUIDE", -10086) == 1) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L19;
        z8 r105 = new z8();
        r105.f162566b = true;
        r105.f162565a = "tap_check_mode.zip";
        w8 r106 = new w8(q.f161940a, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_single_tap_enter_clear_screen));
        r106.f160661e = 10L;
        r106.f160659c = r105;
        r106.f160657a = "live.pref.PREF_SINGLE_TAP_CLEARSCREEN_ENTRANCE_GUIDE";
        r106.f160658b = 1;
        this.f161481a.a(r106);
        return;
    L19:
        return;
    L14:
        r104 = false;
        goto L15
    L10:
        r103 = null;
        goto L12
    }
}
