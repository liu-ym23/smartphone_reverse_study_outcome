package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ye0.a f145803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f145804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f145805c;

    public h1(ye0.a r100, long r101) {
        this.f145803a = r100;
        this.f145804b = 1;
        this.f145805c = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f145803a.onFailure();
        TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
        int r103 = this.f145804b;
        long r104 = this.f145805c;
        r102.getClass();
        TalkRoomBusinessFullLinkMonitor.b(r103, r104, r101);
        if ((r101 instanceof CustomApiServerException) == false) goto L10;
        String r105 = ((CustomApiServerException) r101).getPrompt();
        if (r105 != null) goto L7;
        return;
    L7:
        if ((!Intrinsics.areEqual("", r105)) == false) goto L14;
        f2.c(r105, 0);
        return;
    L14:
        return;
    L10:
        if (this.f145804b != 0) goto L16;
        f2.c(com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_interact_linkmic_apply_float_window_open_error), 0);
        return;
    }
}
