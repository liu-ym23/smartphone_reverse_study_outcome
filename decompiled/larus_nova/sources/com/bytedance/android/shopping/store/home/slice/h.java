package com.bytedance.android.shopping.store.home.slice;

import com.bytedance.android.shopping.store.home.a0;
import com.bytedance.android.shopping.store.home.b0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class h {
    public static final void a(Map<String, Object> r100, a0 r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sliceItemStates");
        Intrinsics.checkNotNullParameter(r101, "followConfig");
        Intrinsics.checkNotNullParameter(r102, "logTag");
        int r103 = b0.f183607a;
        Intrinsics.checkNotNullParameter(r101, "followConfig");
        Integer r104 = null;
        if (r101.f183587b == false) goto L9;
        if (r101.f183590e == false) goto L7;
        String r105 = "follow";
    L15:
        String r106 = r101.f183593h;
        if (r106 == null) goto L18;
        r104 = StringsKt.toIntOrNull(r106);
    L18:
        Intrinsics.checkNotNullParameter(r100, "sliceItemStates");
        if (r105 == null) goto L21;
        r100.put("shop_follow_state", r105);
    L21:
        if (r104 == null) goto L23;
        r100.put("shop_fans_level", Integer.valueOf(r104.intValue()));
    L23:
        dm.a.a(r102).a("updateFollowStateFromFollowConfig, sliceItemStates: " + r100);
        return;
    L7:
        r105 = "unfollow";
        goto L15
    L9:
        if (r101.f183588c == true) goto L11;
        r105 = null;
        goto L15
    L11:
        if (r101.f183594i == false) goto L13;
        r105 = "fans_level";
        goto L15
    L13:
        r105 = "join_fans";
        goto L15
    }
}
