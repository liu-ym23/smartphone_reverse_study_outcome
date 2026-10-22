package com.bytedance.keva;

import android.content.Context;
import android.util.Log;
import com.obric.aiagent.apm.impl.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class KevaBuilder {
    private static KevaBuilder mInstance;
    Context mContext;
    Executor mExecutor;
    KevaMonitor mMonitor;
    String mPortedRepoName;
    File mWorkDir;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public KevaBuilder() {
    }

    static {
        mInstance = new KevaBuilder();
    }

    public static KevaBuilder getInstance() {
        KevaBuilder r0 = mInstance;
        if (r0 == null) goto L5;
        return r0;
    L5:
        INVOKESTATIC_com_bytedance_keva_KevaBuilder_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(KevaConstants.TAG, "have already did init, builder is invalid now!");
        return new KevaBuilder();
    }

    static void clearInstance() {
        mInstance = null;
    }

    public KevaBuilder setContext(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        return this;
    }

    public KevaBuilder setMonitor(KevaMonitor r1) {
        this.mMonitor = r1;
        return this;
    }

    public KevaBuilder setExecutor(Executor r3) {
        this.mExecutor = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
        return this;
    }

    public KevaBuilder setWorkDir(File r3) {
        if (r3.exists() == true) goto L8;
        INVOKESTATIC_com_bytedance_keva_KevaBuilder_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(KevaConstants.TAG, "work dir does not exist! try to create " + r3.getPath());
        if (r3.mkdirs() == true) goto L8;
        INVOKESTATIC_com_bytedance_keva_KevaBuilder_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(KevaConstants.TAG, "work dir fail to create!");
        return this;
    L8:
        this.mWorkDir = r3;
        return this;
    }

    public KevaBuilder setPortedRepoName(String r1) {
        this.mPortedRepoName = r1;
        return this;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_keva_KevaBuilder_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_keva_KevaBuilder_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
