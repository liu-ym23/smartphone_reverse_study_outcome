package com.bytedance.bdinstall.j;

import android.content.Context;
import android.util.Pair;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GaidGetter.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Pair<String, Boolean> f6314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f6315b;

    /* JADX INFO: compiled from: GaidGetter.java */
    public static class a {
    }

    static {
    }

    public static void a(Context r2, an r3) {
        j.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3).edit().remove("google_aid").remove("gaid_limited").apply();
    }
}
