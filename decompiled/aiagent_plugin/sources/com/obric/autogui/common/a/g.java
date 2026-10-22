package com.obric.autogui.common.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConfigTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends l<Integer> {
    public /* synthetic */ g(String r1, int r2, int r3, int r4, d.h.b.h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = -1;
    L5:
        this(r1, r2, r3);
    }

    public g(String r2, int r3, int r4) {
        o.e(r2, "prefKey");
        super(r2, r3, Integer.valueOf(r4));
    }

    @Override // com.obric.autogui.common.a.f
    public void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        a(Integer.valueOf(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getInteger(c())));
    }

    @Override // com.obric.autogui.common.a.f
    public void a() {
        a(Integer.valueOf(e().getInt(b(), ((Number) ZeusTransformUtils.preCheckCast(d(), Number.class, "com.obric.aiagent.plugin")).intValue())));
    }

    public void a(int r2) {
        e().edit().putInt(b(), r2).apply();
    }
}
