package com.bytedance.android.live.liveinteract.floatwindow.dialog;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f73341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f73342b;

    public h(Function1 r100, long r101) {
        this.f73341a = r100;
        this.f73342b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f73341a.invoke(r101);
        TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
        long r103 = this.f73342b;
        r102.getClass();
        TalkRoomBusinessFullLinkMonitor.b(0, r103, r101);
        if ((r101 instanceof ApiServerException) == false) goto L12;
        String r104 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r101);
        if (r104 != null) goto L7;
        return;
    L7:
        if (r104.length() <= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L15;
        f2.c(r104, 0);
        return;
    L15:
        return;
    L9:
        r105 = false;
        goto L10
    L12:
        f2.c(s1.B(R.string.ttlive_interact_linkmic_apply_float_window_open_error), 0);
    }
}
