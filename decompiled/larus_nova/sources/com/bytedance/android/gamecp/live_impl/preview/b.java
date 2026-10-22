package com.bytedance.android.gamecp.live_impl.preview;

import com.bytedance.android.gamecp.live_impl.animation.CardAnimationEvent;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    public static final void a(LinkedList<CardAnimationEvent> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$clearQueue");
    L4:
        if (r100.size() <= 0) goto L9;
        CardAnimationEvent r101 = r100.pollFirst();
        if (r101 == null) goto L4;
        r101.f57780s = true;
        r101.c(CardAnimationEvent.State.EVENT_END);
        goto L4
    }
}
