package com.bytedance.android.livesdk.dslservice.util.jsb;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import yt1.h;
import yt1.j;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f122992a;

    @Override // yt1.h
    public final String a() {
        return null;
    }

    public final Context getContext() {
        return this.f122992a;
    }

    @Override // yt1.h
    public final DSLActionEnum getName() {
        return DSLActionEnum.SubscribeAnchorPlay;
    }

    public g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f122992a = r100;
    }

    @Override // yt1.h
    public final void b(Map r100, j r110) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("appointment_id");
    L6:
        String r103 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r102);
        if (TextUtils.isEmpty(r103) == false) goto L9;
        return;
    L9:
        if (r100 == null) goto L11;
        Object r104 = r100.get("is_subscribe");
    L12:
        if (r104 == null) goto L28;
        boolean r105 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r100.get("is_subscribe"));
        String r106 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.get("send_event"));
        Object r107 = r100.get("live_dsl_success_callback");
        if ((r107 instanceof String) == true) goto L17;
        r107 = null;
    L17:
        String r108 = (String) r107;
        Object r109 = r100.get("live_dsl_error_callback");
        if ((r109 instanceof String) == false) goto L21;
        r101 = r109;
    L21:
        String r111 = (String) r101;
        if (r105 == false) goto L24;
        Uri r112 = UriProtector.parse("sslocal://webcast_dispatch/SubscribeAnchor/subscribePlay/");
    L25:
        ((IBaseLiveActionHandler) k.n(IBaseLiveActionHandler.class)).handle(this.f122992a, r112.buildUpon().appendQueryParameter("appointment_id", r103).appendQueryParameter("send_event", r106).build(), new f(r108, r110, r111));
        return;
    L24:
        r112 = UriProtector.parse("sslocal://webcast_dispatch/SubscribeAnchor/unsubscribePlay/");
        goto L25
    L28:
        return;
    L11:
        r104 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
