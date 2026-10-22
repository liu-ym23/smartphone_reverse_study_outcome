package com.bytedance.android.shopping.service;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.g;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f182608a;

    public b(Ref.ObjectRef r100) {
        this.f182608a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        Exception r100 = (Exception) this.f182608a.element;     // Catch: Exception -> L12
        if (r100 == null) goto L6;
        String r101 = r100.getMessage();     // Catch: Exception -> L12
    L7:
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L12
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);     // Catch: Exception -> L12
        r102.put("error_msg", r101);     // Catch: Exception -> L12
        g.f48122a.logV3("slice_sdk_init_error", r102);     // Catch: Exception -> L12
        T r103 = this.f182608a.element;     // Catch: Exception -> L12
        if (((Exception) r103) != null) goto L10;
        ECExceptionMonitor.c("slice_sdk_exception:tryGetSliceInitServiceByReflect result is null");     // Catch: Exception -> L12
        return;
    L10:
        ECExceptionMonitor.f((Exception) r103, "slice_sdk_exception:tryGetSliceInitServiceByReflect result is null. e: " + r101);     // Catch: Exception -> L12
        return;
    L6:
        r101 = null;
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
