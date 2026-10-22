package com.obric.olog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class ConfigService extends PluginService {
    private static final String TAG = "olog ConfigService";
    private Messenger mMessenger;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public ConfigService() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        INVOKESTATIC_com_obric_olog_ConfigService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "onCreate");
        this.mMessenger = new Messenger(new ConfigHandler((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
    }

    public IBinder onBind(Intent r3) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        INVOKESTATIC_com_obric_olog_ConfigService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ConfigService", "onBind");
        return this.mMessenger.getBinder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onUnbind(Intent r3) {
        INVOKESTATIC_com_obric_olog_ConfigService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "onUnbind");
        return super/*android.app.Service*/.onUnbind(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        INVOKESTATIC_com_obric_olog_ConfigService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "onDestroy");
        super/*android.app.Service*/.onDestroy();
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_ConfigService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
