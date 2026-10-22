package com.stepos.aiengine.model;

import Ua.L0;
import Ua.M;
import Ua.Y;
import android.app.Activity;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.client.AbilityServiceClient;
import com.stepos.aiengine.model.SdkConfirmHost;
import com.stepos.core.ota.confirmui.ConfirmUiHost;
import com.stepos.core.ota.confirmui.EnhancedServiceGuide;
import com.stepos.core.ota.confirmui.FallbackConfirmHost;
import com.stepos.core.ota.confirmui.InProcessConfirmHost;
import com.stepos.core.ota.confirmui.TrampolineConfirmHost;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.d;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/aiengine/model/SdkConfirmHost;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/core/ota/confirmui/ConfirmUiHost;", "hostFor", "(Landroid/content/Context;)Lcom/stepos/core/ota/confirmui/ConfirmUiHost;", "LUa/M;", Const.INTENT_KEY_APIKEY, "LUa/M;", "getScope", "()LUa/M;", "scope", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SdkConfirmHost {
    public static final SdkConfirmHost INSTANCE = new SdkConfirmHost();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final M scope = d.a(L0.b(null, 1, null).plus(Y.a()));

    public static final int c(Context ctx) {
        Object objB;
        Object objB2;
        p.i(ctx, "ctx");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(AbilityServiceClient.INSTANCE.get(ctx).openEnhancedServiceSettings()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) != null) {
            AbilityServiceClient abilityServiceClient = AbilityServiceClient.INSTANCE;
            abilityServiceClient.invalidate();
            try {
                objB2 = Result.b(Integer.valueOf(abilityServiceClient.get(ctx).openEnhancedServiceSettings()));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            if (Result.g(objB2)) {
                objB2 = 1;
            }
            objB = Integer.valueOf(((Number) objB2).intValue());
        }
        return ((Number) objB).intValue();
    }

    public static final Activity d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public final M getScope() {
        return scope;
    }

    public final ConfirmUiHost hostFor(final Context context) {
        p.i(context, "context");
        EnhancedServiceGuide.setLauncher(new InterfaceC5074l() { // from class: Q4.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(SdkConfirmHost.c((Context) obj));
            }
        });
        InProcessConfirmHost inProcessConfirmHost = new InProcessConfirmHost(new InterfaceC5063a() { // from class: Q4.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SdkConfirmHost.d(context);
            }
        });
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "getApplicationContext(...)");
        return new FallbackConfirmHost(inProcessConfirmHost, new TrampolineConfirmHost(applicationContext));
    }
}
