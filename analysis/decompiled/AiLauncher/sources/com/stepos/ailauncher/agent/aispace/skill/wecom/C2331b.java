package com.stepos.ailauncher.agent.aispace.skill.wecom;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u0004H\u0082\u0010¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Z", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "initialStatus", "LY8/t;", "c", "(Landroid/content/Context;Lcom/stepos/ailauncher/agent/skill/SkillStatus;)V", "Landroid/app/Activity;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Landroid/app/Activity;", "", "TAG", "Ljava/lang/String;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.wecom.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2331b {
    public static final C2331b INSTANCE = new C2331b();
    private static final String TAG = "AILauncher-WecomRouter";

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
            if (!C2330a.INSTANCE.b(context)) {
                Activity activity = null;
                C4148a.d(TAG, "intercepted: wecom app not installed", false, 4, null);
                Activity activityA = a(context);
                if (activityA != null && !activityA.isFinishing() && !activityA.isDestroyed()) {
                    activity = activityA;
                }
                if (activity != null) {
                    try {
                        new V(activity).show();
                        objB2 = Result.b(Y8.t.f7040a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB2 = Result.b(C4849c.a(th));
                    }
                    Throwable thE = Result.e(objB2);
                    if (thE != null) {
                        C4148a.t(TAG, "show WecomNeedInstallDialog on host failed, fallback activity", thE, false, 8, null);
                        WecomNeedInstallActivity.INSTANCE.a(context);
                    }
                    Result.a(objB2);
                } else {
                    WecomNeedInstallActivity.INSTANCE.a(context);
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
            C4148a.t(TAG, "wecom install check failed, fall through", thE2, false, 8, null);
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void c(Context context, SkillStatus initialStatus) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        if (b(context)) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("onCardClick -> start WecomConnectActivity initialStatus=%s", Arrays.copyOf(new Object[]{initialStatus}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
            WecomConnectActivity.INSTANCE.a(context, initialStatus);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "start WecomConnectActivity failed", thE, false, 8, null);
        }
    }
}
