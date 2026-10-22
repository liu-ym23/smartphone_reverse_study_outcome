package com.obric.aiagent.assistant_card.provider_core;

import android.content.Context;
import android.net.Uri;
import com.obric.aiagent.assistant_card.provider_core.bean.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseCardProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16330a;

    public c a(Context r1, Uri r2, JSONObject r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r2, "cardUri");
        return null;
    }

    public Object a(Context r9, Uri r10, String r11, JSONObject r12, d<? super x> r13) {
        return a(this, (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), r10, r11, r12, (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.aiagent.plugin"));
    }

    public a(String r2) {
        o.e(r2, "cardType");
        this.f16330a = r2;
    }

    public final String a() {
        return this.f16330a;
    }

    public c a(Context r2, Uri r3, JSONObject r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r3, "cardUri");
        return a(r6, r3, r4);
    }

    static /* synthetic */ Object a(a r0, Context r1, Uri r2, String r3, JSONObject r4, d<? super x> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return x.f38692a;
    }
}
