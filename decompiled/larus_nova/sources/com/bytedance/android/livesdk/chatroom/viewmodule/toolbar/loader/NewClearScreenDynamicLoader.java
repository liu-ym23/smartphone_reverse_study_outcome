package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/NewClearScreenDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewClearScreenDynamicLoader extends AbsDynamicLoader {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        HashSet r100 = new HashSet();
        Boolean r101 = (Boolean) this.f116377a.get("data_hide_screen", Boolean.FALSE);
        if (r101 == null) goto L5;
        boolean r102 = r101.booleanValue();
    L6:
        if (r102 == false) goto L8;
        ToolbarButton r103 = ToolbarButton.CLEAR_SCREEN_OPTIMIZE_ON;
    L9:
        r100.add(r103);
        return CollectionsKt.toList(r100);
    L8:
        r103 = ToolbarButton.CLEAR_SCREEN_OPTIMIZE_OFF;
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    public NewClearScreenDynamicLoader(e r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        super(r100);
    }
}
