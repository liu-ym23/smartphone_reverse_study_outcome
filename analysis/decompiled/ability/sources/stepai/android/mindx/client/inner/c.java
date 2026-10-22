package stepai.android.mindx.client.inner;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.stepos.taskrobot.llmapi.stepfun.g;
import java.util.ArrayList;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.log.ILLMLogger;
import stepai.android.mindx.base.LLMInterface;
import stepai.android.mindx.client.config.ConfigsKt;

/* loaded from: classes4.dex */
public final class c implements ILLMLogger {

    /* renamed from: a, reason: collision with root package name */
    public final g f6209a;
    public final StepInnerClient$iCallback$1 b;
    public Application c;
    public LLMInterface d;
    public final ArrayList e = new ArrayList();
    public final a f = new a(this);
    public final b g = new b(this);
    public final String h = "ServiceBindManager";

    public c(g gVar, StepInnerClient$iCallback$1 stepInnerClient$iCallback$1) {
        this.f6209a = gVar;
        this.b = stepInnerClient$iCallback$1;
    }

    public final boolean a(Context context) {
        IBinder iBinderAsBinder;
        k.f(context, "context");
        LLMInterface lLMInterface = this.d;
        if (lLMInterface != null && lLMInterface != null && (iBinderAsBinder = lLMInterface.asBinder()) != null && iBinderAsBinder.isBinderAlive()) {
            ILLMLogger.DefaultImpls.printI(this, "is alive", ConfigsKt.TAG);
            return true;
        }
        Context applicationContext = context.getApplicationContext();
        k.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        this.c = (Application) applicationContext;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(ConfigsKt.TARGET_PACKAGE, ConfigsKt.TARGET_SERVICE_CLASS));
        Application application = this.c;
        boolean zBindService = application != null ? application.bindService(intent, this.f, 1) : false;
        ILLMLogger.DefaultImpls.printI(this, "bind service, res: ".concat(zBindService ? "✅" : "❌"), ConfigsKt.TAG);
        return zBindService;
    }

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final String getChildTag() {
        return this.h;
    }

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final void printE(String str, String str2) {
        ILLMLogger.DefaultImpls.printE(this, str, str2);
    }

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final void printI(String str, String str2) {
        ILLMLogger.DefaultImpls.printI(this, str, str2);
    }

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final void printV(String str, String str2) {
        ILLMLogger.DefaultImpls.printV(this, str, str2);
    }
}
