package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.text.SpannableString;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f79602a;

    public c(Function2 r100) {
        this.f79602a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void a(py.k r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f79602a.invoke(Boolean.FALSE, null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void b(SpannableString r100, q.a r101) {
        Intrinsics.checkNotNullParameter(r100, "spannable");
        Intrinsics.checkNotNullParameter(r101, "info");
        this.f79602a.invoke(Boolean.TRUE, r100);
    }
}
