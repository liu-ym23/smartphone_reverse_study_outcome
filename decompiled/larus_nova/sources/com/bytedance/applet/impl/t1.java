package com.bytedance.applet.impl;

import com.larus.bmhome.ability.ContainerExceptionType;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class t1 implements com.bytedance.ai.widget.l {
    public t1() {
    }

    @Override // com.bytedance.ai.widget.l
    public final void a(com.bytedance.ai.widget.m r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        com.larus.bmhome.chat.api.t r101 = ILegacyChatUiServiceDelegate.f297164b.V8();
        if (r101 == null) goto L6;
        r101.g(r100.f38052a, r100.f38055d, r100.f38056e, r100.f38053b);
        return;
    }

    @Override // com.bytedance.ai.widget.l
    public final void c(com.bytedance.ai.widget.m r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        com.larus.bmhome.chat.api.t r101 = ILegacyChatUiServiceDelegate.f297164b.V8();
        if (r101 == null) goto L6;
        r101.h(r100.f38052a, r100.f38055d, r100.f38056e, r100.f38053b);
        return;
    }

    @Override // com.bytedance.ai.widget.l
    public final void b(com.bytedance.ai.widget.m r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        com.larus.bmhome.chat.api.t r102 = ILegacyChatUiServiceDelegate.f297164b.V8();
        if (r102 == null) goto L6;
        String r103 = r100.f38052a;
        ContainerExceptionType r104 = ContainerExceptionType.FAILED_LYNX;
        String r105 = r100.f38053b;
        JSONObject r106 = new JSONObject();
        r106.put("applet_id", r100.f38055d);
        r106.put("widget_id", r100.f38056e);
        r106.put("error_msg", r101);
        Unit r107 = Unit.INSTANCE;
        com.larus.bmhome.chat.api.t.a.a(r102, r103, r104, r105, r106);
        return;
    }
}
