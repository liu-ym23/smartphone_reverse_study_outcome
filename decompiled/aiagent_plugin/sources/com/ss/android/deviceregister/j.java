package com.ss.android.deviceregister;

import android.content.Context;
import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GaidGetter.java */
/* JADX INFO: loaded from: classes4.dex */
public class j {
    public static Pair<String, Boolean> a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return null;
    }

    public static void b(Context r2) {
        com.ss.android.deviceregister.base.b.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).edit().remove("google_aid").remove("gaid_limited").apply();
    }
}
