package com.bytedance.android.livesdk.interactivity.api.emoji;

import am3.g;
import am3.h;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.api.interaction.FusionEmojiResponse.ResponseData")
public final class c extends a {
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public c(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.emoji = vh7.f.a(r100, k.class);
        goto L3
    L7:
        h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }
}
