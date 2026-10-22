package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f116309a = 0;

    static {
    }

    public static void a(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = UtilityKotlinExtentionsKt.i(38);
        UIUtils.setLayoutParams(r100, r101, r101);
    }

    public static boolean b(Boolean r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100.booleanValue();
    L13:
        return !r101;
    L4:
        IRoomContextService r102 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.o r103 = IRoomContextService.a.a(r102, null, 0, 3);
        if (r103 == null) goto L11;
        Boolean r104 = r103.isAnchor();
        if (r104 == null) goto L11;
        r101 = r104.booleanValue();
    L11:
        r101 = false;
        goto L13
    }
}
