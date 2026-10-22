package com.stepos.ailauncher.agent.aispace.skill.feishu;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u0004H\u0082\u0010¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/g;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Z", "LY8/t;", "c", "(Landroid/content/Context;)V", "Landroid/app/Activity;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Landroid/app/Activity;", "", "TAG", "Ljava/lang/String;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2311g {
    public static final C2311g INSTANCE = new C2311g();
    private static final String TAG = "AILauncher-FeishuRouter";

    public final Activity a(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
            kotlin.jvm.internal.p.h(context, "getBaseContext(...)");
        }
        return (Activity) context;
    }

    public final boolean b(Context context) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            boolean z10 = false;
            if (!C2309e.INSTANCE.a(context)) {
                Activity activity = null;
                C4148a.d(TAG, "intercepted: feishu app not installed", false, 4, null);
                Activity activityA = a(context);
                if (activityA != null && !activityA.isFinishing() && !activityA.isDestroyed()) {
                    activity = activityA;
                }
                if (activity != null) {
                    try {
                        new m0(activity).show();
                        objB2 = Result.b(Y8.t.f7040a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB2 = Result.b(C4849c.a(th));
                    }
                    Throwable thE = Result.e(objB2);
                    if (thE != null) {
                        C4148a.t(TAG, "show FeishuNeedInstallDialog on host failed, fallback activity", thE, false, 8, null);
                        FeishuNeedInstallActivity.INSTANCE.a(context);
                    }
                    Result.a(objB2);
                } else {
                    FeishuNeedInstallActivity.INSTANCE.a(context);
                }
                z10 = true;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB);
        if (thE2 != null) {
            C4148a.t(TAG, "feishu install check failed, fall through", thE2, false, 8, null);
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void c(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        if (b(context)) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            C4148a.d(TAG, "onCardClick -> start FeishuConnectActivity", false, 4, null);
            FeishuConnectActivity.INSTANCE.a(context);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "start FeishuConnectActivity failed", thE, false, 8, null);
        }
    }
}
