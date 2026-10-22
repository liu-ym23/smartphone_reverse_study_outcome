package com.bytedance.android.live.soloktv.util;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.larus.nova.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes7.dex */
public final class m implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f101632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f101633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f101634c;

    public m(Function0 r100, Function3 r101, Context r102) {
        this.f101632a = r100;
        this.f101633b = r101;
        this.f101634c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        l.b r102 = l.f101621d;
        if ((r102 instanceof l.b.a) == false) goto L6;
        this.f101632a.invoke();
    L8:
        r100.dismiss();
        return;
    L6:
        if ((r102 instanceof l.b.c) == false) goto L8;
        l.f101621d = l.b.C1546b.f101629a;
        ((IMiddlewareHostBusiness) jc1.k.n(IMiddlewareHostBusiness.class)).cancelVideoPublish(l.f101623f);
        this.f101633b.invoke(Boolean.FALSE, "cancel publish", VSConstants.EXTRA_SHOW_MSG_BOARD_FROM_PASSIVE_ACTION);
        String r103 = rm3.c.f538539a;
        rm3.c.f(this.f101634c, R.string.ttlive_solo_ktv_publish_failed, false, 28);
        goto L8
    }
}
