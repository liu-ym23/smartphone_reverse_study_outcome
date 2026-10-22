package com.bytedance.ai.bridge.method.info;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.info.AbsGetUserInfoMethodIDL;
import com.bytedance.ai.bridge.service.IHostUserDepend;
import com.bytedance.ai.utils.f;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r4.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/GetUserInfoMethod;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/info/AbsGetUserInfoMethodIDL$GetUserInfoResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetUserInfoMethod extends AbsGetUserInfoMethodIDL {
    public GetUserInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r110, ParamModel r111, h r210) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetUserInfoMethodIDL.a) r111, "params");
        Intrinsics.checkNotNullParameter(r210, "callback");
        IHostUserDepend r100 = a.f535982i;
        if (r100 == null) goto L28;
        Intrinsics.checkNotNullParameter(AbsGetUserInfoMethodIDL.b.class, "<this>");
        BaseModel r101 = c.a(AbsGetUserInfoMethodIDL.b.class);
        AbsGetUserInfoMethodIDL.b r102 = (AbsGetUserInfoMethodIDL.b) r101;
        boolean r103 = r100.hasLogin();
        r102.setHasLoggedIn(r103);
        r102.setLogin(r103);
        if (r103 == false) goto L27;
        String r104 = r100.getUserId();
        if (r104 != null) goto L9;
        String r105 = "";
    L10:
        r100.getUserModelExt();
        String r106 = r100.getSecUid();
        if (r106 != null) goto L13;
        String r107 = "";
    L14:
        String r108 = r100.getUniqueID();
        if (r108 != null) goto L17;
        String r112 = "";
    L18:
        String r109 = r100.getNickname();
        if (r109 != null) goto L21;
        String r113 = "";
    L22:
        String r114 = r100.getAvatarURL();
        if (r114 != null) goto L25;
        String r115 = "";
    L26:
        r100.getBoundPhone();
        r102.setUserInfo(new AbsGetUserInfoMethodIDL.UserInfo(r105, "", r107, r112, r113, r115, Boolean.valueOf(f.g(null)), null, 128, null));
        goto L27
    L25:
        r115 = r114;
        goto L26
    L21:
        r113 = r109;
        goto L22
    L17:
        r112 = r108;
        goto L18
    L13:
        r107 = r106;
        goto L14
    L9:
        r105 = r104;
    L27:
        r210.b((ResultModel) r101, "");
        return;
    L28:
        h.a.a(r210, "hostUserDepend is null", null, null, 14);
    }
}
