package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f113331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 f113332b;

    public e(Object r100, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r101) {
        this.f113331a = r100;
        this.f113332b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        mk1.a r101 = (mk1.a) r100;
        Intrinsics.checkNotNullParameter(r101, "castScreen");
        if (r101.b() == true) goto L5;
        return;
    L5:
        if ((this.f113331a instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == false) goto L9;
        ALogger.e("liveRefinedDegrade", "auth castScreen update to hide castscreentoolbar");
        this.f113332b.d(ToolbarButton.GAME_CAST_SCREEN, (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) this.f113331a);
        return;
    }
}
