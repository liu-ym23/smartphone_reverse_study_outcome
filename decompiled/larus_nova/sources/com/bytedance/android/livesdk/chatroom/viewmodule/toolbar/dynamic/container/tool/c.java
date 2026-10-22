package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ContainerContextEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ListActionEnum;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.ComponentConfigManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements zo1.g<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContainerContextEnv f116071a;

    public c(ContainerContextEnv r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f116071a = r100;
    }

    public final void a(s r100, boolean r101) {
        if (g.f116077a.contains(Integer.valueOf(r100.f116191a)) == true) goto L5;
        return;
    L5:
        ComponentConfigManager r102 = this.f116071a.f116031a;
        if (r102 == null) goto L11;
        a0 r103 = r102.getToolbarConfig(r100.f116191a);
        if (r103 == null) goto L12;
        r103.n(r101);
        return;
    L12:
        return;
    }

    @Override // zo1.g
    public final void e(s r100, ListActionEnum r101) {
        s r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "action");
        int r103 = b.f116070a[r101.ordinal()];
        if (r103 != 1) goto L5;
        a(r102, true);
        return;
    L5:
        if (r103 != 2) goto L11;
        a(r102, false);
        return;
    }
}
