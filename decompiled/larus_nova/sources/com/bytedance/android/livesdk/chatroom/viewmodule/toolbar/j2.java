package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.DialogInterface;
import com.bytedance.android.live.core.log.ALogger;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class j2 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j2 f116361a = null;

    static {
        f116361a = new j2();
    }

    public j2() {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        ALogger.d("VSScheduleCloseWidget", "dismiss shadow dialog, start to PlayNext or goNextFeed");
        List<i2.a> r101 = i2.f116348a;
    }
}
