package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f99951a;

    public b(a r100) {
        this.f99951a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void a(py.k r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void b(SpannableString r100, q.a r101) {
        Intrinsics.checkNotNullParameter(r100, "spannable");
        Intrinsics.checkNotNullParameter(r101, "info");
        TextView r102 = this.f99951a.f99950h;
        if (r102 == null) goto L6;
        r102.setText(r100);
        return;
    }
}
