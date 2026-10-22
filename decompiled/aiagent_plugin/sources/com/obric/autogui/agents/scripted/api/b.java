package com.obric.autogui.agents.scripted.api;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: IJSScriptWorker.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: IJSScriptWorker.kt */
    public static final class a {
        public static Object a(b r2, Context r3, d<? super x> r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return x.f38692a;
        }
    }

    Object onFoundationReady(Context r1, d<? super x> r2);
}
