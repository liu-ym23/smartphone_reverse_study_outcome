package com.bytedance.android.livesdk.event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e0 extends d0 {

    public static final class a {
    }

    static {
    }

    public e0() {
        throw null;
    }

    public e0(String r100, ISendCommentEvent.Sender r110, Map r111) {
        Intrinsics.checkNotNullParameter(r100, "vsContent");
        Intrinsics.checkNotNullParameter(r110, "vsSender");
        Intrinsics.checkNotNullParameter(r111, "vsArgs");
        super(r100, r110, r111, null, null, false, 32);
    }
}
