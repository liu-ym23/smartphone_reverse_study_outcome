package com.stepos.ability.screenops.init;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.init.IInit;
import com.stepos.ability.screenops.service.c;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import s9.C1923c;
import w4.a;

@Singleton
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stepos/ability/screenops/init/ScreenOpsInit;", "Lcom/stepos/ability/api/init/IInit;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "Companion", "w4/a", "screenops_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenOpsInit implements IInit {
    public static final a Companion = new a();
    private static final String TAG = "ScreenOpsInit";

    @Inject
    public ScreenOpsInit() {
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        String processName;
        k.f(context, "context");
        try {
            processName = Application.getProcessName();
        } catch (Throwable unused) {
            processName = null;
        }
        if (processName != null && !processName.equals(context.getPackageName())) {
            Log.d(TAG, "init: skip non-main process (" + processName + ")");
            return;
        }
        C1923c c1923c = c.f3241a;
        Context applicationContext = context.getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        c.b(applicationContext);
        Log.i(TAG, "init: RuleTriggerManager kicked off on process cold start");
    }
}
