package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: classes8.dex */
public final class t extends mx.l {
    public t() {
        if (com.bytedance.android.livesdk.sharedpref.b.f158122b.getValue().booleanValue() == true) goto L10;
        Integer r100 = com.bytedance.android.livesdk.sharedpref.b.f158117a.a();
        if (r100 == null) goto L10;
        if (r100.intValue() != 1) goto L10;
        boolean r101 = true;
    L11:
        Integer r102 = com.bytedance.android.livesdk.sharedpref.b.f158117a.a();
        if (r102 != null) goto L15;
    L17:
        boolean r103 = false;
    L18:
        super("画面镜像", null, r101, false, r103, null, 106);
        return;
    L15:
        if (r102.intValue() != 1) goto L17;
        r103 = true;
    L10:
        r101 = false;
        goto L11
    }

    @Override // mx.l
    public final void c(SwitchSettingViewHolder r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f516148l = r101;
        xs2.b.a().post(new h1(22));
    }
}
