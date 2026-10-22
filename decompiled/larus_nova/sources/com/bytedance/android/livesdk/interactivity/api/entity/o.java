package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.android.live.base.model.message.x3;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o {
    public static final void a(com.bytedance.android.livesdk.event.k r100, x3 r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$createAndSetSelfSendInfo");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "content");
        com.bytedance.android.livesdk.event.m r103 = r100.b();
        if (r103 == null) goto L6;
        List r104 = r103.f123350a;
        if (r104 == null) goto L6;
    L7:
        com.bytedance.android.livesdk.event.q r105 = r100.c();
        if (r105 == null) goto L11;
        List r106 = r105.f123363a;
        if (r106 == null) goto L11;
    L13:
        if ((!r104.isEmpty()) == false) goto L15;
    L16:
        r101.setSelfFakeRichContent(new p(r102, r104, r106));
        return;
    L15:
        if ((!r106.isEmpty()) == true) goto L16;
        return;
    L11:
        r106 = new ArrayList();
    L6:
        r104 = new ArrayList();
        goto L7
    }
}
