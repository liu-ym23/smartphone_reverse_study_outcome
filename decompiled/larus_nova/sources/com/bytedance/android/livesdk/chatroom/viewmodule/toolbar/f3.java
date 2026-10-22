package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.live.base.model.message.l5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f3 {
    public static final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s a(l5 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convert2Model");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r101 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s();
        r101.f116191a = r100.getComponentType();
        String r102 = "";
        if (TextUtils.isEmpty(r100.getText()) == true) goto L9;
        String r103 = r100.getText();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f116192b = r103;
    L9:
        if (TextUtils.isEmpty(r100.getSchema()) == true) goto L14;
        String r104 = r100.getSchema();
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r101.f116195e = r104;
    L14:
        r101.f116193c = r100.getIcon();
        String r105 = r100.getExtraData();
        if (r105 == null) goto L18;
        r102 = r105;
    L18:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f116194d = r102;
        r101.f116196f = r100.getGroupId();
        r101.f116202l.f116104b = true;
        r101.f116197g = (int) r100.getShowType();
        return r101;
    }

    public static final ToolbarButton b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLocalData");
        SparseArray<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w> r103 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0.f115962e;
        return com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0.a.a(r100.f116191a, r101, r102);
    }
}
