package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import android.text.SpannableString;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import com.bytedance.android.livesdk.message.model.eb;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ eb f72185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataCenter f72186b;

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void a(k r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }

    public h(eb r100, DataCenter r101) {
        this.f72185a = r100;
        this.f72186b = r101;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void b(SpannableString r110, q.a r111) {
        Intrinsics.checkNotNullParameter(r110, "spannable");
        Intrinsics.checkNotNullParameter(r111, "info");
        pp1.c r112 = new pp1.c(null, this.f72185a.getRichText(), this.f72185a.getSchema(), 5, null, null, 1, 0, this.f72185a.getExtra(), 0, 7856);
        r112.f530167a = r110;
        DataCenter r113 = this.f72186b;
        if (r113 == null) goto L6;
        r113.put("cmd_show_self_bubble_on_openplatform_behavior", r112);
        return;
    }
}
