package com.bytedance.android.live.browser.service;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class y implements w9.c {
    public y() {
    }

    @Override // w9.c
    public final boolean handleHttpSchema(Context r100, Uri r101, View r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return ((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).actionHandler().handleHttpSchema(r100, r101, r102, r103);
    }

    @Override // w9.c
    public final boolean j0(Context r100, Uri r101, View r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        IBaseLiveActionHandler r104 = ((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).actionHandler();
        int r105 = r30.a.f535858a;
        Intrinsics.checkNotNullParameter(r101, "uri");
        IMiddlewareHostBusiness r106 = (IMiddlewareHostBusiness) jc1.k.f(IMiddlewareHostBusiness.class);
        if (r106 == null) goto L14;
        String r107 = r106.getSourceBtmToken2Schema(r102, r103);
        if (r107 != null) goto L7;
    L10:
        boolean r108 = true;
    L11:
        if (r108 == true) goto L14;
        r101 = r101.buildUpon().appendQueryParameter(PhotoEnterModel.SOURCE_BTM_TOKEN, r107).build();
        goto L14
    L7:
        if (r107.length() == 0) goto L10;
        r108 = false;
    L14:
        return r104.handle(r100, r101);
    }

    @Override // w9.c
    public final void v1(Context r100, String r101, View r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).actionHandler().pageFinished(r100, r101, r102, r103);
    }
}
