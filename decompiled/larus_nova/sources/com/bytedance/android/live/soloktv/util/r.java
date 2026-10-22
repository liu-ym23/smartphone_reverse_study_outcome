package com.bytedance.android.live.soloktv.util;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.larus.nova.R;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes7.dex */
public final class r implements njc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f101641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f101642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f101643c;

    @Override // njc.a
    public final void onCompleted() {
        ALogger.i(bb0.b.b(), "VideoPublishUtil :export onCompleted, invoke class :".concat(r.class.getSimpleName()));
    }

    public r(Function3 r100, Context r101, Function1 r102) {
        this.f101641a = r100;
        this.f101642b = r101;
        this.f101643c = r102;
    }

    @Override // njc.a
    public final void a(int r100, String r101, Throwable r102) {
        String r103 = "export onFailed: code=" + r100 + ", msg=" + r101 + ", throwable=" + Log.getStackTraceString(r102);
        ALogger.i(bb0.b.b(), "VideoPublishUtil :" + r103 + ", invoke class :" + r.class.getSimpleName());
        this.f101641a.invoke(Boolean.FALSE, r101, VSConstants.EXTRA_SHOW_MSG_BOARD_FROM_PASSIVE_ACTION);
        l.b r104 = l.f101621d;
        if ((r104 instanceof l.b.a) == false) goto L6;
        String r105 = rm3.c.f538539a;
        rm3.c.f(this.f101642b, R.string.ttlive_solo_ktv_publish_failed, false, 28);
        return;
    L6:
        if ((r104 instanceof l.b.C1546b) == false) goto L10;
        String r106 = rm3.c.f538539a;
        rm3.c.f(this.f101642b, R.string.ttlive_solo_ktv_save_draft_failed, false, 28);
        return;
    }
}
