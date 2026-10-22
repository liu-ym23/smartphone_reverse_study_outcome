package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.livesdk.message.model.el;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ShelfCardInfo> f84574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final el f84575b;

    public b(List<ShelfCardInfo> r100, el r101) {
        Intrinsics.checkNotNullParameter(r100, "cardInfoList");
        this.f84574a = r100;
        this.f84575b = r101;
    }
}
