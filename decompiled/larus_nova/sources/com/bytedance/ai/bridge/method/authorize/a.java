package com.bytedance.ai.bridge.method.authorize;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35350a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, UUID> f35351b = null;

    public a() {
    }

    static {
        f35350a = new a();
        f35351b = new LinkedHashMap();
    }

    public final synchronized boolean a(String r100, UUID r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r101, "token");     // Catch: Throwable -> L12
        Map<String, UUID> r102 = f35351b;     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(((LinkedHashMap) r102).get(r100), r101) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        r102.remove(r100);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L12:
        th = move-exception;
        throw th;
    }
}
