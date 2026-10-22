package com.bytedance.applet.aibridge.auth;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.platform.api.c5;
import com.larus.utils.logger.FLogger;
import f3.h;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements c5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f190913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h<AbsStartDouyinOpenAuthMethodIDL.b> f190914b;

    public e(JSONObject r100, h<AbsStartDouyinOpenAuthMethodIDL.b> r101) {
        this.f190913a = r100;
        this.f190914b = r101;
    }

    @Override // com.larus.platform.api.c5
    public final void a(boolean r110, Integer r111, String r112, String r113) {
        FLogger.f375446a.i("StartDouyinOpenAuthMethod", "onResult, isAuthorized:" + r110 + ", errorCode:" + r111 + ", errorMsg: " + r112 + '.');
        w0.d(null, null, null, r110 ? 1 : 0, r113, null, null, null, null, null, this.f190913a, 3047);
        h<AbsStartDouyinOpenAuthMethodIDL.b> r100 = this.f190914b;
        Intrinsics.checkNotNullParameter(AbsStartDouyinOpenAuthMethodIDL.b.class, "<this>");
        BaseModel r101 = k3.c.a(AbsStartDouyinOpenAuthMethodIDL.b.class);
        ((AbsStartDouyinOpenAuthMethodIDL.b) r101).setAuthorized(r110);
        h.a.b(r100, (ResultModel) r101);
    }
}
