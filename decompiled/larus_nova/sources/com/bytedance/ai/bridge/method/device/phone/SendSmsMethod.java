package com.bytedance.ai.bridge.method.device.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.phone.AbsSendSmsMethodIDL;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/phone/SendSmsMethod;", "Lcom/bytedance/ai/bridge/device/phone/AbsSendSmsMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/phone/AbsSendSmsMethodIDL$SendSmsParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/phone/AbsSendSmsMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendSmsMethod extends AbsSendSmsMethodIDL {

    public static final class a {
    }

    static {
    }

    public SendSmsMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r110, ParamModel r111, h r112) {
        AbsSendSmsMethodIDL.b r113 = (AbsSendSmsMethodIDL.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        g r100 = g.f37637a;
        StringBuilder r101 = new StringBuilder("call start, hasPhoneNumber=");
        String r102 = r113.getPhoneNumber();
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        r101.append(!r104);
        r101.append(", hasMessage=");
        String r105 = r113.getMessage();
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        r101.append(!r106);
        r101.append(", appletId=");
        a0 r107 = r110.getContainerContext();
        if (r107 == null) goto L19;
        String r108 = r107.getAppletId();
    L20:
        r101.append(r108);
        r100.i("AISDK_JSB_SendSmsMethod", r101.toString());
        Activity r114 = r110.getOwnerActivity();
        if (r114 != null) goto L25;
        r114 = k.b();
        if (r114 != null) goto L25;
        StringBuilder r115 = new StringBuilder("call failed, errNo=");
        f3.a r116 = f3.a.f475265f;
        r115.append(r116.f475285a);
        r115.append(", msg=context is null");
        r100.e("AISDK_JSB_SendSmsMethod", r115.toString());
        h.a.a(r112, "context is null", r116, null, 10);
        return;
    L25:
        String r109 = r113.getPhoneNumber();
        if (r109 == null) goto L28;
        String r117 = StringsKt.trim(r109).toString();
    L30:
        if (r117 != null) goto L32;
        r117 = "";
    L32:
        Intent r118 = new Intent("android.intent.action.SENDTO", UriProtector.parse("smsto:" + Uri.encode(r117)));
        String r119 = r113.getMessage();
        if (r119 != null) goto L35;
    L36:
        r103 = true;
    L37:
        if (r103 == true) goto L44;
        r118.putExtra("sms_body", r113.getMessage());
    L44:
        r114.startActivity(r118);     // Catch: Exception -> L41
        r100.i("AISDK_JSB_SendSmsMethod", "call success");     // Catch: Exception -> L41
        Intrinsics.checkNotNullParameter(AbsSendSmsMethodIDL.a.class, "<this>");     // Catch: Exception -> L41
        r112.b((ResultModel) c.a(AbsSendSmsMethodIDL.a.class), "");     // Catch: Exception -> L41
        return;
    L41:
        e = move-exception;
        g r120 = g.f37637a;
        StringBuilder r121 = new StringBuilder("call failed, errNo=");
        f3.a r122 = f3.a.f475265f;
        r121.append(r122.f475285a);
        r121.append(", msg=sendSms failed: ");
        r121.append(e.getMessage());
        r120.e("AISDK_JSB_SendSmsMethod", r121.toString());
        h.a.a(r112, "sendSms failed: " + e.getMessage(), r122, null, 10);
        return;
    L35:
        if (r119.length() != 0) goto L37;
    L28:
        r117 = null;
        goto L30
    L19:
        r108 = null;
        goto L20
    L12:
        if (r105.length() == 0) goto L15;
        r106 = false;
        goto L16
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
