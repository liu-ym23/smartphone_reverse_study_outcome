package com.obric.aiagent.executionengine.utils;

import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f18568a = null;

    /* JADX INFO: renamed from: lambda$8yQ3hDGRQH0BL-UPLJmXVmBqJXQ, reason: not valid java name */
    public static /* synthetic */ Gson m192lambda$8yQ3hDGRQH0BLUPLJmXVmBqJXQ() {
        return b();
    }

    static {
        f18568a = g.a($$Lambda$e$8yQ3hDGRQH0BLUPLJmXVmBqJXQ.INSTANCE);
    }

    public static final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f18568a.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson b() {
        return new Gson();
    }
}
