package com.bytedance.android.live.soloktv.util;

import android.content.DialogInterface;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.config.jh1;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f101635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f101636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f101637c;

    public n(Function3 r100, Function2 r101, String r102) {
        this.f101635a = r100;
        this.f101636b = r101;
        this.f101637c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        List<jh1> r102 = l.f101618a;
        l.b r103 = l.f101621d;
        if ((r103 instanceof l.b.a) == false) goto L6;
        l.f101621d = l.b.C1546b.f101629a;
    L8:
        r100.dismiss();
        return;
    L6:
        if ((r103 instanceof l.b.c) == false) goto L8;
        l.f101621d = l.b.C1546b.f101629a;
        ((IMiddlewareHostBusiness) jc1.k.n(IMiddlewareHostBusiness.class)).cancelVideoPublish(l.f101623f);
        this.f101635a.invoke(Boolean.FALSE, "cancel publish", VSConstants.EXTRA_SHOW_MSG_BOARD_FROM_PASSIVE_ACTION);
        this.f101636b.invoke(this.f101637c, 0L);
        goto L8
    }
}
