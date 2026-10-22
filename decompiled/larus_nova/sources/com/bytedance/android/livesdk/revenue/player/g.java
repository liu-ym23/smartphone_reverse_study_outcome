package com.bytedance.android.livesdk.revenue.player;

import android.text.SpannableString;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import py.k;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f157267a;

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void a(k r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }

    public g(Ref.ObjectRef r100) {
        this.f157267a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void b(SpannableString r100, q.a r101) {
        Intrinsics.checkNotNullParameter(r100, "spannable");
        Intrinsics.checkNotNullParameter(r101, "info");
        this.f157267a.element = r100;
    }
}
