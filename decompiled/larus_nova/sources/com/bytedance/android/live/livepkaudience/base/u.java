package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f81567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f81568b;

    public u(long r100, String r101) {
        this.f81567a = r100;
        this.f81568b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Throwable r111 = (Throwable) r110;
        Intrinsics.checkNotNullParameter(r111, LynxError.LYNX_THROWABLE);
        long r100 = this.f81567a;
        long r101 = System.currentTimeMillis() - r100;
        String r102 = this.f81568b;
        dl0.m r103 = dl0.m.f469074a;
        Intrinsics.checkNotNullParameter(r102, "token");
        JSONObject r104 = new JSONObject();
        BaseMonitor.add(r104, "token", r102);
        if (r111 != null) goto L5;
        return;
    L5:
        if ((r111 instanceof ApiServerException) == false) goto L10;
        dl0.m r105 = dl0.m.f469074a;
        ApiServerException r112 = (ApiServerException) r111;
        int r106 = r112.getErrorCode();
        String r113 = r112.getErrorMsg();
        if (r113 != null) goto L9;
        r113 = "";
    L9:
        r105.getClass();
        dl0.m.z("audience_notify_join_rtc", r106, r113, r101, r104);
        return;
    L10:
        dl0.m r107 = dl0.m.f469074a;
        String r108 = r111.toString();
        r107.getClass();
        dl0.m.z("audience_notify_join_rtc", 1, r108, r101, r104);
    }
}
