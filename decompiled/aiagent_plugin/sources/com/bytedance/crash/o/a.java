package com.bytedance.crash.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: compiled from: ActivityUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Callable<JSONArray> f7656a;

    static {
    }

    public static void a(Callable<JSONArray> r2) {
        f7656a = (Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.aiagent.plugin");
    }
}
