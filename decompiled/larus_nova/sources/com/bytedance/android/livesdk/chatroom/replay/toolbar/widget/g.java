package com.bytedance.android.livesdk.chatroom.replay.toolbar.widget;

import android.content.DialogInterface;
import com.bytedance.android.live.core.log.ALogger;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f110230a = null;

    static {
        f110230a = new g();
    }

    public g() {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        ALogger.d("VSScheduleCloseWidget", "dismiss shadow dialog, start to PlayNext or goNextFeed");
        List<com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.InterfaceC1745a> r101 = com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118159a;
        Function0<Unit> r102 = com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118164f;
        if (r102 == null) goto L5;
        Unit r103 = r102.invoke();
    L5:
        com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118164f = null;
    }
}
