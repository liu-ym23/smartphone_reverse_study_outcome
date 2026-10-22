package com.obric.autogui.common.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConfigTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends l<String> {
    public /* synthetic */ j(String r1, int r2, String r3, int r4, d.h.b.h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        this(r1, r2, r3);
    }

    public j(String r2, int r3, String r4) {
        o.e(r2, "prefKey");
        o.e(r4, "value");
        super(r2, r3, r4);
    }

    @Override // com.obric.autogui.common.a.f
    public void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        String r5 = ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getString(c());
        o.c(r5, "getString(...)");
        a(r5);
    }

    @Override // com.obric.autogui.common.a.f
    public void a() {
        String r0 = e().getString(b(), (String) ZeusTransformUtils.preCheckCast(d(), String.class, "com.obric.aiagent.plugin"));
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        a(r0);
    }

    public void a(String r2) {
        o.e(r2, "value");
        e().edit().putString(b(), r2).apply();
    }
}
