package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f86940a = 0;

    static {
    }

    public static AbstractDraweeController a(py.k r100) {
        if (UtilityKotlinExtentionsKt.n(r100) == false) goto L7;
        return null;
    L7:
        return Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r100, -1)).setAutoPlayAnimations(true).build();
    }
}
