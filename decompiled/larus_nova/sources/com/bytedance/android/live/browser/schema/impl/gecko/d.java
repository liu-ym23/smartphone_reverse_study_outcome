package com.bytedance.android.live.browser.schema.impl.gecko;

import android.net.Uri;
import com.bytedance.android.live.core.setting.e4;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livesdk.config.tm0;
import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import com.bytedance.mt.protector.impl.UriProtector;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f64237b;

    public static final class a {
    }

    static {
    }

    public d() {
        this.f64236a = tm0.f121311a.getValue();
        this.f64237b = !e4.f65289a.getValue().booleanValue();
    }

    public static final String a(d r100) {
        r100.getClass();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        Uri.Builder r102 = UriProtector.parse(r100.f64236a).buildUpon().appendQueryParameter(com.heytap.mcssdk.constant.b.C, "1");     // Catch: Throwable -> L18
        if (v.a() == false) goto L16;
        IMiddleWareHostContext r103 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);     // Catch: Throwable -> L18
        if (r103 == null) goto L16;
        HostBoeParams r104 = r103.getHostBoeParams();     // Catch: Throwable -> L18
        if (r104 == null) goto L16;
        if (r104.getBoeEnable() == false) goto L14;
        r102.appendQueryParameter(ByteNetEnvHeaderName.BOE, "1");     // Catch: Throwable -> L18
        r102.appendQueryParameter("x-tt-env", r104.getBoeLane());     // Catch: Throwable -> L18
    L14:
        if (r104.getPpeEnable() == false) goto L16;
        r102.appendQueryParameter(ByteNetEnvHeaderName.PPE, "1");     // Catch: Throwable -> L18
        r102.appendQueryParameter("x-tt-env", r104.getPpeLane());     // Catch: Throwable -> L18
    L16:
        Object r105 = Result.m9449constructorimpl(r102.build().toString());     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r105) == false) goto L24;
        r105 = "";
    L24:
        return (String) r105;
    L18:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
