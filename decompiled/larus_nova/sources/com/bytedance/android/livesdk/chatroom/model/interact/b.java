package com.bytedance.android.livesdk.chatroom.model.interact;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final List<String> a(EnlargeGuestInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$enlargedUserIdList");
        com.bytedance.android.live.base.model.user.o0.a r101 = com.bytedance.android.live.base.model.user.o0.f58946a;
        r100.get_enlargedUserIdList();
        List<String> r102 = r100.get_enlargedOpenIdList();
        r101.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.h(r102);
    }
}
