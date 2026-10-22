package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import android.text.SpannableString;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f113500a;

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void a(py.k r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }

    public b(Function1 r100) {
        this.f113500a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
    public final void b(SpannableString r100, q.a r101) {
        Intrinsics.checkNotNullParameter(r100, "spannable");
        Intrinsics.checkNotNullParameter(r101, "info");
        this.f113500a.invoke(r100.toString());
    }
}
