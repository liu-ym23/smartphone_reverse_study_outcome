package com.stepos.aiengine.update;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.deepbinder.client.DeepBinderClient;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/aiengine/update/OtaServiceClient;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "get", "(Landroid/content/Context;)Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "service", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes2.dex */
public final class OtaServiceClient {
    public static final OtaServiceClient INSTANCE = new OtaServiceClient();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static volatile IOtaDeepBinderService service;

    public final IOtaDeepBinderService get(Context context) {
        IOtaDeepBinderService iOtaDeepBinderService;
        Object objB;
        p.i(context, "context");
        IOtaDeepBinderService iOtaDeepBinderService2 = service;
        if (iOtaDeepBinderService2 != null) {
            return iOtaDeepBinderService2;
        }
        synchronized (this) {
            try {
                iOtaDeepBinderService = service;
                if (iOtaDeepBinderService == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Object objCreate = DeepBinderClient.INSTANCE.create(new ComponentName("com.stepos.aiengine", "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider"), "com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl", IOtaDeepBinderService.class, new Pair[0]);
                        service = (IOtaDeepBinderService) objCreate;
                        objB = Result.b((IOtaDeepBinderService) objCreate);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB = Result.b(C4849c.a(th));
                    }
                    Throwable thE = Result.e(objB);
                    if (thE != null) {
                        Log.e("OtaServiceClient", "OtaServiceClient connect failed", thE);
                    }
                    if (Result.g(objB)) {
                        objB = null;
                    }
                    iOtaDeepBinderService = (IOtaDeepBinderService) objB;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iOtaDeepBinderService;
    }
}
