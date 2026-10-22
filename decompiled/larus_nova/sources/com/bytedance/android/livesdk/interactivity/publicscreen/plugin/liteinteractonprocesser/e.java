package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends a {
    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final String a() {
        return "ToastProcessor";
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final boolean b(long r100) {
        if (r100 != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final void c(t42.a r100, com.bytedance.android.live.base.model.liteinteraction.a r101, CompositeDisposable r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r102, "cd");
        String r103 = r101.e();
        if (r103 != null) goto L5;
        return;
    L5:
        f2.c(r103, 0);
    }
}
