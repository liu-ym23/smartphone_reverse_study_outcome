package com.bytedance.ai.bridge.method.device.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.phone.AbsMakePhoneCallMethodIDL;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/phone/MakePhoneCallMethod;", "Lcom/bytedance/ai/bridge/device/phone/AbsMakePhoneCallMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/phone/AbsMakePhoneCallMethodIDL$MakePhoneCallParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/phone/AbsMakePhoneCallMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MakePhoneCallMethod extends AbsMakePhoneCallMethodIDL {

    public static final class a {
    }

    static {
    }

    public MakePhoneCallMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r110) {
        AbsMakePhoneCallMethodIDL.b r102 = (AbsMakePhoneCallMethodIDL.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        g r103 = g.f37637a;
        StringBuilder r104 = new StringBuilder("call start, hasPhoneNumber=");
        boolean r105 = true;
        if (r102.getPhoneNumber().length() <= 0) goto L5;
        boolean r106 = true;
    L6:
        r104.append(r106);
        r104.append(", appletId=");
        a0 r107 = r100.getContainerContext();
        if (r107 == null) goto L9;
        String r108 = r107.getAppletId();
    L10:
        r104.append(r108);
        r103.i("AISDK_JSB_MakePhoneCallMethod", r104.toString());
        String r109 = r102.getPhoneNumber();
        if (r109.length() == 0) goto L15;
        r105 = false;
    L15:
        if (r105 == false) goto L17;
        StringBuilder r111 = new StringBuilder("call failed, errNo=");
        f3.a r112 = f3.a.f475267h;
        r111.append(r112.f475285a);
        r111.append(", msg=phoneNumber is empty");
        r103.e("AISDK_JSB_MakePhoneCallMethod", r111.toString());
        h.a.a(r110, "The phoneNumber parameter should not be empty.", r112, null, 10);
        return;
    L17:
        Activity r113 = r100.getOwnerActivity();
        if (r113 != null) goto L27;
        r113 = k.b();
        if (r113 != null) goto L27;
        StringBuilder r114 = new StringBuilder("call failed, errNo=");
        f3.a r115 = f3.a.f475265f;
        r114.append(r115.f475285a);
        r114.append(", msg=context is null");
        r103.e("AISDK_JSB_MakePhoneCallMethod", r114.toString());
        h.a.a(r110, "context is null", r115, null, 10);
        return;
    L27:
        r113.startActivity(new Intent("android.intent.action.DIAL", UriProtector.parse("tel:" + Uri.encode(r109))));     // Catch: Exception -> L24
        r103.i("AISDK_JSB_MakePhoneCallMethod", "call success");     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(AbsMakePhoneCallMethodIDL.a.class, "<this>");     // Catch: Exception -> L24
        r110.b((ResultModel) c.a(AbsMakePhoneCallMethodIDL.a.class), "");     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        g r116 = g.f37637a;
        StringBuilder r117 = new StringBuilder("call failed, errNo=");
        f3.a r118 = f3.a.f475265f;
        r117.append(r118.f475285a);
        r117.append(", msg=makePhoneCall failed: ");
        r117.append(e.getMessage());
        r116.e("AISDK_JSB_MakePhoneCallMethod", r117.toString());
        h.a.a(r110, "makePhoneCall failed: " + e.getMessage(), r118, null, 10);
        return;
    L9:
        r108 = null;
        goto L10
    L5:
        r106 = false;
        goto L6
    }
}
