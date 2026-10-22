package com.bytedance.android.livesdk.log;

import com.bytedance.android.live.core.log.ALogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class BroadcastLogInterceptor implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f153269a;

    public BroadcastLogInterceptor() {
        this.f153269a = LazyKt.lazy(BroadcastLogInterceptor$blockTagList$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.log.d0
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter("loadStickerByEffectId", "message");
        if (com.bytedance.android.live.core.utils.v.b() == false) goto L9;
        if (StringsKt.startsWith$default(r100, "ttlive_anchor", false, 2, null) == true) goto L9;
        ALogger.w(r100, "TAG not start with ttlive_anchor");
        return false;
    L9:
        if ((!((List) this.f153269a.getValue()).isEmpty()) == true) goto L11;
    L13:
        return true;
    L11:
        if (((List) this.f153269a.getValue()).contains(r100) == false) goto L13;
        return false;
    }
}
