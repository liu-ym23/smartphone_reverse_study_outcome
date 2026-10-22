package com.bytedance.android.livesdk.chatroom.broadcast.v2.service;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.bytedance.android.live.pushstream.report.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f105470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f105471b;

    public a(Function0 r100, Function1 r101) {
        this.f105470a = r100;
        this.f105471b = r101;
    }

    @Override // com.bytedance.android.live.pushstream.report.c
    public final void a(int r100, boolean r101, int r102, Throwable r103) {
        if (r101 == false) goto L10;
        if (r102 != 0) goto L6;
    L9:
        ALogger.i("ttlive_anchor_swallow_back", "ping anchor end success");
        this.f105470a.invoke();
        return;
    L6:
        if (r102 == 30001) goto L9;
        if (r102 == 30003) goto L9;
    L10:
        ALogger.i("ttlive_anchor_swallow_back", "ping anchor end error: " + r100 + ' ' + r101 + ' ' + r102 + ", " + r103);
        this.f105471b.invoke(Integer.valueOf(r102));
    }
}
