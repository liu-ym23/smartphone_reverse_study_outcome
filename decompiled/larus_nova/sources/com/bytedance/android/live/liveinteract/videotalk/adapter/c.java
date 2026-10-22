package com.bytedance.android.live.liveinteract.videotalk.adapter;

import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.plantform.model.c0;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.live.liveinteract.plantform.model.d0;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c1 f79064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f79065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VideoRoomAudiencePreApplyViewHolder f79066c;

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void a(k r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void b(SpannableString r100, q.a r101) {
        Intrinsics.checkNotNullParameter(r100, "spannable");
        Intrinsics.checkNotNullParameter(r101, "info");
        TextView r102 = this.f79066c.f79053c;
        c0 r103 = this.f79064a.c();
        if (r103 == null) goto L5;
        Spannable r104 = d0.a(r103, r100, this.f79065b);
    L6:
        r102.setText(r104);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public c(c1 r100, String r101, VideoRoomAudiencePreApplyViewHolder r102) {
        this.f79064a = r100;
        this.f79065b = r101;
        this.f79066c = r102;
    }
}
