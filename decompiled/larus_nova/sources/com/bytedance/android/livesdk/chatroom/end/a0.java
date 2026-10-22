package com.bytedance.android.livesdk.chatroom.end;

import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class a0<T> implements sy.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IMiddlewareHostBusiness f106030a;

    public a0(IMiddlewareHostBusiness r100) {
        this.f106030a = r100;
    }

    @Override // sy.a
    public final void invoke(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101.booleanValue() == false) goto L7;
        IMiddlewareHostBusiness r102 = this.f106030a;
        if (r102 == null) goto L7;
        r102.updateLivePushOpen(r101.booleanValue());
    L7:
        f2.c(LiveResUtil.getString(R.string.ttlive_notificaton_live_setting_push_is_open), 0);
    }
}
