package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j {
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter("PlayModeService", "tag");
        Intrinsics.checkNotNullParameter(r100, "content");
        ALogger.d("PlayModeIncompatible_PlayModeService", r100);
    }
}
