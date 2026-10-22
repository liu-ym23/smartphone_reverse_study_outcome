package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class u8 implements com.bytedance.android.live.effect.api.k.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenLiveEffectPanelMethod.AnonymousClass1 f63683a;

    @Override // com.bytedance.android.live.effect.api.k.e
    public final void onFetchFailed() {
        this.f63683a.invoke(true);
    }

    public u8(OpenLiveEffectPanelMethod.AnonymousClass1 r100) {
        this.f63683a = r100;
    }

    @Override // com.bytedance.android.live.effect.api.k.e
    public final void onFetchSuccess(List<Effect> r100) {
        Intrinsics.checkNotNullParameter(r100, "effectList");
        this.f63683a.invoke(true);
    }
}
