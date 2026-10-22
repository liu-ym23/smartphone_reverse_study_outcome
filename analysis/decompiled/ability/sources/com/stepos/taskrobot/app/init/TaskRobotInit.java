package com.stepos.taskrobot.app.init;

import B7.a;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.HandlerThread;
import android.util.Log;
import androidx.compose.foundation.b;
import c6.C0880b;
import c6.ServiceConnectionC0879a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.TaskManager;
import com.stepos.ability.api.init.IInit;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.taskrobot.appwhitelist.api.AppWhitelistService;
import com.stepos.taskrobot.dictionary.DictionaryManager;
import com.stepos.taskrobot.llmapi.stepfun.ExperienceManager;
import com.stepos.taskrobot.llmapi.stepfun.GuiAgentInitializer;
import com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2;
import com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager;
import com.tencent.mmkv.MMKV;
import f6.C1438c;
import g7.C1464a;
import h7.C1491a;
import j7.C1599a;
import j7.C1601c;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import l6.C1662a;
import l6.c;
import stepai.aios.guiagent.llm.config.PromptOverrideManager;
import stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager;
import u1.d;

@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/taskrobot/app/init/TaskRobotInit;", "Lcom/stepos/ability/api/init/IInit;", "Lf6/c;", "taskRobotAccountUtil", AppAgent.CONSTRUCT, "(Lf6/c;)V", "Landroid/app/Application;", "app", "LC7/r;", "initLogger", "(Landroid/app/Application;)V", "bindKeyboardIme", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "Lf6/c;", "", "tag", "Ljava/lang/String;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskRobotInit implements IInit {
    private final String tag;
    private final C1438c taskRobotAccountUtil;

    @Inject
    public TaskRobotInit(C1438c taskRobotAccountUtil) {
        k.f(taskRobotAccountUtil, "taskRobotAccountUtil");
        this.taskRobotAccountUtil = taskRobotAccountUtil;
        this.tag = "TaskRobotInit";
    }

    private final void bindKeyboardIme(Application app) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(app.getPackageName(), "com.stepos.taskrobot.llmapi.stepfun.ime.KeyboardIME"));
        app.bindService(intent, new ServiceConnectionC0879a(this, 0), 1);
    }

    private final void initLogger(Application app) {
        c.b = app;
        String str = C1662a.e;
        d dVar = new d(18, false);
        dVar.e = "TaskRobot_AI";
        if (((Date) dVar.b) == null) {
            dVar.b = new Date();
        }
        if (((SimpleDateFormat) dVar.c) == null) {
            dVar.c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        }
        if (((h2.d) dVar.d) == null) {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            String packageName = c.b.getPackageName();
            StringBuilder sbV = b.v(absolutePath);
            char c = File.separatorChar;
            sbV.append(c);
            sbV.append("logger");
            sbV.append(c);
            sbV.append(packageName);
            String string = sbV.toString();
            HandlerThread handlerThread = new HandlerThread(a.k("AndroidFileLogger.", string));
            handlerThread.start();
            dVar.d = new h2.d(new l6.b(handlerThread.getLooper(), string));
        }
        ((ArrayList) c.f5288a.c).add(new C0880b(new C1662a(dVar)));
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        k.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        k.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application application = (Application) applicationContext;
        initLogger(application);
        MMKV.initialize(application);
        DictionaryManager.INSTANCE.init(application, false);
        com.zyql.ability.sdk.client.a aVar = com.zyql.ability.sdk.client.a.f4237a;
        synchronized (aVar) {
            if (com.zyql.ability.sdk.client.a.b) {
                C1491a.a("AbilityClient", "Init ignore. Cause already init.");
            } else {
                Context applicationContext2 = application.getApplicationContext();
                k.c(applicationContext2);
                U7.a.H(applicationContext2);
                C1599a c1599aB = C1601c.b(application);
                if (c1599aB != null) {
                    com.zyql.ability.sdk.client.a.d = new C1464a(c1599aB.f4775a, c1599aB.b, c1599aB.c, c1599aB.d);
                    C1491a.a("AbilityClient", "Create service connector");
                    R5.d dVar = new R5.d();
                    dVar.f1155a = applicationContext2;
                    dVar.d = new Object();
                    dVar.f = new com.zyql.ability.sdk.client.c(dVar);
                    com.zyql.ability.sdk.client.a.c = dVar;
                    C1464a c1464a = com.zyql.ability.sdk.client.a.d;
                    if (c1464a == null) {
                        k.n("caller");
                        throw null;
                    }
                    com.zyql.ability.sdk.client.a.e = new com.zyql.ability.sdk.client.b(applicationContext2, dVar, c1464a);
                    C1491a.a("AbilityClient", "Pre-binding AbilityService...");
                    R5.d dVar2 = com.zyql.ability.sdk.client.a.c;
                    if (dVar2 == null) {
                        k.n("connector");
                        throw null;
                    }
                    R5.d.b(dVar2, new com.uxsense.parse.b(7));
                    com.zyql.ability.sdk.client.a.b = true;
                    C1491a.a("AbilityClient", "Init success. self:" + aVar);
                }
            }
        }
        ExperienceManager.INSTANCE.syncFromSp(application);
        ApiManager apiManager = ApiManager.INSTANCE;
        if (!com.zyql.ability.sdk.client.a.b) {
            Log.e("AbilityClient", "AbilityClient not initialized. Call AbilityClient.init(context) first.", null);
            throw new IllegalStateException("AbilityClient not initialized. Call AbilityClient.init(context) first.");
        }
        String str = U7.a.b;
        k.c(str);
        ApiManager.init$default(apiManager, application, str, 0L, null, null, 28, null);
        S0.b.p = application;
        bindKeyboardIme(application);
        TaskManager.initialize$default(application, false, 2, null);
        GuiAgentInitializer.INSTANCE.initGuiAgent(application, this.taskRobotAccountUtil);
        PromptOverrideManager.INSTANCE.init(application);
        AgentCacheSdk.init$default(AgentCacheSdk.INSTANCE, application, null, null, 6, null);
        GuiAgentTraceManager guiAgentTraceManager = GuiAgentTraceManager.INSTANCE;
        UploadManager uploadManager = UploadManager.INSTANCE;
        guiAgentTraceManager.registerUploader(uploadManager);
        GuiAgentTraceManagerV2.INSTANCE.registerUploader(uploadManager);
        AppWhitelistService.INSTANCE.warmUp(application);
    }
}
