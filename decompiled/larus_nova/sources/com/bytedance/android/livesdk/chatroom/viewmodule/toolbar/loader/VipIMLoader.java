package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.vipim.VipIMManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/VipIMLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VipIMLoader extends AbsDynamicLoader {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ExtendedToolbarButton.a r100 = ExtendedToolbarButton.f115618h;
        ToolbarButton r101 = ToolbarButton.VIP_IM;
        r100.getClass();
        ExtendedToolbarButton.b r102 = ExtendedToolbarButton.a.a(r101);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r103 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e(r102);
        r103.f115910b = r102.f115626i.getDrawableFolded();
        r103.f(r102.g());
        Lazy r104 = VipIMManager.f159346f;
        String r105 = VipIMManager.a.a().f159348b;
        if (TextUtils.isEmpty(r105) == true) goto L6;
        r103.f(r105);
    L6:
        return CollectionsKt.arrayListOf(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e[]{r103});
    }

    public VipIMLoader(e r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        super(r100);
    }
}
