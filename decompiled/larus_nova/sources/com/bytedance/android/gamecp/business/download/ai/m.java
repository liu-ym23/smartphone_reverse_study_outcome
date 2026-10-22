package com.bytedance.android.gamecp.business.download.ai;

import com.bytedance.android.gamecp.base.network.exception.CustomApiServerException;
import com.bytedance.android.gamecp.host_api.model.Room;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f52495a;

    public m(c r100) {
        this.f52495a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        JSONObject r102 = new JSONObject();
        Room r103 = this.f52495a.f();
        Integer r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getOwnerUserId();
    L6:
        r102.put("anchor_id", String.valueOf(r105));
        if ((r101 instanceof CustomApiServerException) == true) goto L9;
        Throwable r106 = null;
    L10:
        CustomApiServerException r107 = (CustomApiServerException) r106;
        if (r107 == null) goto L13;
        r104 = Integer.valueOf(r107.getErrorCode());
    L13:
        r102.put("error_code", String.valueOf(r104));
        Unit r108 = Unit.INSTANCE;
        yr.c.e("explain_card_get_promote_list_response", r102.toString());
        yr.b.a("AiDownloadPredictor", r101);
        return;
    L9:
        r106 = r101;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
