package com.obric.autogui.common.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConfigTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends l<Boolean> {
    public /* synthetic */ a(String r1, int r2, boolean r3, int r4, d.h.b.h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    public a(String r2, int r3, boolean r4) {
        o.e(r2, "prefKey");
        super(r2, r3, Boolean.valueOf(r4));
    }

    @Override // com.obric.autogui.common.a.f
    public void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        a(Boolean.valueOf(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getBoolean(c())));
    }

    @Override // com.obric.autogui.common.a.f
    public void a() {
        a(Boolean.valueOf(e().getBoolean(b(), ((Boolean) ZeusTransformUtils.preCheckCast(d(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue())));
    }

    public void a(boolean r2) {
        e().edit().putBoolean(b(), r2).apply();
    }
}
