package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class v {
    public static final int a(com.bytedance.android.scope.j r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        return ((Number) r101.get("data_link_state", 0)).intValue();
    }

    public static final List<ILinkPlayerInfoBridge> b(com.bytedance.android.scope.j r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        return (List) r101.get("data_online_changed_list", new ArrayList());
    }
}
