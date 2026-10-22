package com.bytedance.android.livesdk.message.linker;

import com.bytedance.android.live.base.model.user.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l {
    public static final String a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$fromUid");
        o0.a r101 = o0.f58946a;
        Long r102 = Long.valueOf(r100.get_fromUid());
        String r103 = r100.get_fromOpenId();
        r101.getClass();
        return o0.a.g(r102, r103);
    }
}
