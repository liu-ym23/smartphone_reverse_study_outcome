package com.bytedance.android.annie.bridge.method;

import androidx.activity.result.ActivityResultCaller;
import com.bytedance.android.annie.api.container.HybridFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s0 implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridFragment f38816a;

    public s0(HybridFragment r100) {
        this.f38816a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f a() {
        ActivityResultCaller r100 = this.f38816a;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.android.annie.container.fragment.IInnerHybridFragment");
        return new com.bytedance.android.annie.bridge.method.calendar.r((com.bytedance.android.annie.container.fragment.q) r100);
    }
}
