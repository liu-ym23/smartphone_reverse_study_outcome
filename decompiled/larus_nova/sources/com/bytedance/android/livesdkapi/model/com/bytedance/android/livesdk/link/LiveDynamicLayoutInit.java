package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.link;

import com.bytedance.live.dynamicresource.b;
import com.bytedance.live.dynamicresource.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/link/LiveDynamicLayoutInit;", "", "()V", "initLiveDynamicLayout", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDynamicLayoutInit {
    public static final LiveDynamicLayoutInit INSTANCE = null;

    private LiveDynamicLayoutInit() {
    }

    static {
        INSTANCE = new LiveDynamicLayoutInit();
    }

    public final void initLiveDynamicLayout() {
        d r100 = d.f255131a;
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "builderScopeInitFunc");
        b.a r102 = new b.a();
        r101.invoke(r102);
        d.f255132b = new b(r102);
    }
}
