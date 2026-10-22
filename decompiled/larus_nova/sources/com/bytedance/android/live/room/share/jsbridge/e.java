package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.live.browser.jsbridge.base.ShareLiveResultModel;
import com.bytedance.android.livehostapi.business.depend.share.IUgShareCallback;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements IUgShareCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareLiveMethod f100293a;

    public e(ShareLiveMethod r100) {
        this.f100293a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IUgShareCallback
    public final void onSuccess(JSONObject r100) {
        ShareLiveMethod r101 = this.f100293a;
        ShareLiveResultModel r102 = new ShareLiveResultModel();
        r102.a(ShareLiveResultModel.Code.Success);
        JsonObject r103 = new JsonObject();
        if (r100 == null) goto L9;
        Iterator<String> r104 = r100.keys();
        if (r104 == null) goto L9;
    L7:
        if (r104.hasNext() == false) goto L9;
        String r105 = r104.next();
        r103.addProperty(r105, r100.optString(r105));
    L9:
        Unit r106 = Unit.INSTANCE;
        r102.b(r103);
        r101.finishWithResult(r102);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.IUgShareCallback
    public final void onFailed(int r100, String r101, Object r102) {
        ShareLiveMethod r103 = this.f100293a;
        ShareLiveResultModel r104 = new ShareLiveResultModel();
        r104.a(ShareLiveResultModel.Code.Failed);
        JsonObject r105 = new JsonObject();
        r105.addProperty("code", Integer.valueOf(r100));
        r105.addProperty("msg", r101);
        r105.addProperty("data", String.valueOf(r102));
        Unit r106 = Unit.INSTANCE;
        r104.b(r105);
        r103.finishWithResult(r104);
    }
}
