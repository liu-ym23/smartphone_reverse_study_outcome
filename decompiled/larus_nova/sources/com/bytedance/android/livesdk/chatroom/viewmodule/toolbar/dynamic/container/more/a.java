package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.more;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ListActionEnum;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import zo1.i;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends zo1.a {
    public a() {
        i r100 = new i(new ArrayList(), new ArrayList());
        Intrinsics.checkNotNullParameter("showing", "key");
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f573098a.put("showing", r100);
    }

    @Override // zo1.f
    public final boolean f(s r100) {
        s r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        i r102 = n();
        if (r102 != null) goto L5;
        return false;
    L5:
        r102.b(r101, ListActionEnum.ADD);
        o("add " + r101);
        return true;
    }

    @Override // zo1.f
    public final boolean i(s r100) {
        s r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        i r102 = n();
        if (r102 != null) goto L5;
        return false;
    L5:
        o("remove " + r101);
        return r102.b(r101, ListActionEnum.REMOVE);
    }

    @Override // zo1.f
    public final boolean m(s r100) {
        s r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        i r102 = n();
        if (r102 != null) goto L5;
        return false;
    L5:
        o("update " + r101);
        return r102.b(r101, ListActionEnum.UPDATE);
    }

    public final void o(String r100) {
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.a.f116165b.a(), "data " + r100);
    }
}
