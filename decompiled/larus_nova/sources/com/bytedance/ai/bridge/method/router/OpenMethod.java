package com.bytedance.ai.bridge.method.router;

import android.app.Activity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/OpenMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenMethod extends AbsOpenMethodIDL {
    public OpenMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, f3.h r112) {
        AbsOpenMethodIDL.b r100 = (AbsOpenMethodIDL.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r101 = r110.getOwnerActivity();
        if (r101 != null) goto L7;
        r101 = f2.k.b();
        if (r101 != null) goto L7;
        f3.h.a.a(r112, "context not provided in host", null, null, 14);
        return;
    L7:
        String r102 = r100.getSchema();
        boolean r103 = r100.getReplace();
        boolean r104 = r100.getUseSysBrowser();
        String r105 = r100.getReplaceType();
        boolean r113 = true;
        boolean r114 = false;
        if (r102.length() != 0) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L13;
        f3.h.a.a(r112, "schema should not be empty", null, null, 14);
        return;
    L13:
        Map<String, ? extends Object> r107 = MapsKt.mapOf(TuplesKt.to("useSysBrowser", Boolean.valueOf(r104)));
        r4.j r108 = r4.a.f535983j;
        if (r103 == true) goto L20;
        if (r108 == null) goto L17;
        r114 = r108.openSchema(r110, r102, r107, r101);
    L17:
        if (r114 == false) goto L19;
        Intrinsics.checkNotNullParameter(AbsOpenMethodIDL.c.class, "<this>");
        r112.b((ResultModel) k3.c.a(AbsOpenMethodIDL.c.class), "");
        return;
    L19:
        f3.h.a.a(r112, "Failed to open schema: ".concat(r102), null, null, 14);
        return;
    L20:
        int r109 = r105.hashCode();
        if (r109 == (-1465864472)) goto L43;
        if (r109 == 169053298) goto L36;
        if (r109 == 2116215581) goto L28;
    L52:
        r113 = false;
    L53:
        if (r113 == false) goto L55;
        Intrinsics.checkNotNullParameter(AbsOpenMethodIDL.c.class, "<this>");
        r112.b((ResultModel) k3.c.a(AbsOpenMethodIDL.c.class), "");
        return;
    L55:
        f3.h.a.a(r112, "Failed to open schema: ".concat(r102), null, null, 14);
        return;
    L28:
        if (r105.equals("alwaysCloseAfterOpen") == false) goto L52;
        if (r108 == null) goto L32;
        r113 = r108.openSchema(r110, r102, r107, r101);
    L33:
        if (r108 == null) goto L53;
        r108.closeView(r110, null, false);
        goto L53
    L32:
        r113 = false;
        goto L33
    L36:
        if (r105.equals("alwaysCloseBeforeOpen") == false) goto L52;
        if (r108 == null) goto L40;
        r108.closeView(r110, null, false);
    L40:
        if (r108 == null) goto L52;
        r113 = r108.openSchema(r110, r102, r107, r101);
        goto L53
    L43:
        if (r105.equals("onlyCloseAfterOpenSucceed") == false) goto L52;
        if (r108 != null) goto L47;
    L49:
        boolean r115 = false;
    L50:
        if (r115 == false) goto L52;
        r4.j.a.a(r108, r110);
        goto L53
    L47:
        if (r108.openSchema(r110, r102, r107, r101) != true) goto L49;
        r115 = true;
        goto L50
    L10:
        r106 = false;
        goto L11
    }
}
