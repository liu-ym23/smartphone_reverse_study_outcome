package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import com.bytedance.android.live.commonui.LiveSettingKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i extends ir1.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class<? extends zq1.a> f118179c;

    public final boolean o() {
        mq1.g r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.q.b();
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (b() == false) goto L13;
        if (LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue().getEnable() == true) goto L10;
    L11:
        r101 = true;
        goto L13
    L10:
        if (a() == false) goto L11;
    L13:
        return !Intrinsics.areEqual(this.f118179c, r100.f(r101));
    }

    public i() {
    }
}
