package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b0 extends dmc.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LiveScheduleMessageWidget f113301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Set f113302e;

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f113301d.wq();
    }

    public b0(LiveScheduleMessageWidget r100, Set r101, Set r102, Set r103, dmc.d r104) {
        this.f113301d = r100;
        this.f113302e = r101;
        super(r102, r103, r104);
    }
}
