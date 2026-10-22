package com.bytedance.android.livesdk.chatroom.utils;

import android.view.View;
import com.bytedance.android.livehostapi.business.IBcmSearchTrack;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class r3 {
    static {
    }

    @JvmStatic
    public static final void a(View r100, String r101, String r102, String r103) {
        IBcmSearchTrack r104 = (IBcmSearchTrack) jc1.k.f(IBcmSearchTrack.class);
        if (r104 == null) goto L6;
        r104.appendSearchParams(r100, r101, r102, r103);
        return;
    }
}
