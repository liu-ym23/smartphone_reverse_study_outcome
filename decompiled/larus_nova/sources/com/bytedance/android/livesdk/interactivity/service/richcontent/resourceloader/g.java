package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements hk6.c<ob2.d> {
    public g() {
    }

    @Override // hk6.c
    public final Drawable b(ek6.b r100, ak6.f r101, ek6.d r102) {
        ob2.d r103 = (ob2.d) r100;
        Intrinsics.checkNotNullParameter(r103, "resourceInfo");
        Intrinsics.checkNotNullParameter(r101, "loadConfig");
        Intrinsics.checkNotNullParameter(r102, "content");
        return s1.m(r103.f522598a);
    }
}
