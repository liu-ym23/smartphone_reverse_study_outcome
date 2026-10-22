package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final void a(DataCenter r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        if (r100 == null) goto L5;
        LayerEventDispatcher r102 = o70.c.a(Integer.valueOf(r100.hashCode()));
    L6:
        if (r102 == null) goto L8;
        r102.b(new o42.c(false, true, r101));
        return;
    L8:
        boolean r103 = TextMessageTracer.f133629a;
        TextMessageTracer.A("try, adjust wh, but dispatcher is null");
        return;
    L5:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final void b(DataCenter r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        if (r100 == null) goto L5;
        LayerEventDispatcher r102 = o70.c.a(Integer.valueOf(r100.hashCode()));
    L6:
        if (r102 == null) goto L8;
        r102.b(new o42.c(true, true, r101));
        return;
    L8:
        boolean r103 = TextMessageTracer.f133629a;
        TextMessageTracer.A("try, adjust wh, but dispatcher is null");
        return;
    L5:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final void c(DataCenter r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        if (r100 == null) goto L5;
        LayerEventDispatcher r102 = o70.c.a(Integer.valueOf(r100.hashCode()));
    L6:
        if (r102 == null) goto L8;
        r102.b(new o42.c(true, false, r101));
        return;
    L8:
        boolean r103 = TextMessageTracer.f133629a;
        TextMessageTracer.A("try, adjust wh, but dispatcher is null");
        return;
    L5:
        r102 = null;
        goto L6
    }
}
