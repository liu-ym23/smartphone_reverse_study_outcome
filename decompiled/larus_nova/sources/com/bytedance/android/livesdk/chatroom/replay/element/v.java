package com.bytedance.android.livesdk.chatroom.replay.element;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class v {
    public static final void a(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$refreshViewPosition");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r101.next()).a();
        goto L4
    }
}
