package com.stepos.aiengine.update;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.deepbinder.client.DeepBinderClient;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/aiengine/update/OtaServiceClient;", "", "Landroid/content/Context;", "context", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "get", "(Landroid/content/Context;)Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class OtaServiceClient {
    public static final OtaServiceClient INSTANCE = new OtaServiceClient();

    /* renamed from: a, reason: collision with root package name */
    public static volatile IOtaDeepBinderService f3536a;

    public final IOtaDeepBinderService get(Context context) {
        IOtaDeepBinderService iOtaDeepBinderService;
        Object objA;
        k.f(context, "context");
        IOtaDeepBinderService iOtaDeepBinderService2 = f3536a;
        if (iOtaDeepBinderService2 != null) {
            return iOtaDeepBinderService2;
        }
        synchronized (this) {
            try {
                iOtaDeepBinderService = f3536a;
                if (iOtaDeepBinderService == null) {
                    try {
                        Object objCreate = DeepBinderClient.INSTANCE.create(new ComponentName("com.stepos.aiengine", "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider"), "com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl", IOtaDeepBinderService.class, new Pair[0]);
                        f3536a = (IOtaDeepBinderService) objCreate;
                        objA = (IOtaDeepBinderService) objCreate;
                    } catch (Throwable th) {
                        objA = b.a(th);
                    }
                    Throwable thA = Result.a(objA);
                    if (thA != null) {
                        Log.e("OtaServiceClient", "OtaServiceClient connect failed", thA);
                    }
                    if (objA instanceof Result.Failure) {
                        objA = null;
                    }
                    iOtaDeepBinderService = (IOtaDeepBinderService) objA;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iOtaDeepBinderService;
    }
}
