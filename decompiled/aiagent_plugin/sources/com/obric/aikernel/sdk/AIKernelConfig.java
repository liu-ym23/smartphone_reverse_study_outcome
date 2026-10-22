package com.obric.aikernel.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.data.ExtraAppInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AIKernelConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AIKernelConfig {
    public static final Companion Companion = null;
    private static final String TAG = "AIKernelConfig";
    private boolean authBySign;
    private boolean bindRemoteOnInit;
    private boolean childProcessImportantBindEnabled;
    private ExtraAppInfo extraBindInfo;
    private a<Integer> llmUsageMode;
    private Long mAppId;
    private Context mContext;
    private String mPackageName;
    private int staticLlmMode;

    /* JADX INFO: compiled from: AIKernelConfig.kt */
    public static final class Builder {
        private Long appId;
        private boolean authBySign;
        private boolean bindRemoteOnInit;
        private boolean childProcessImportantBindEnabled;
        private ExtraAppInfo extraBindInfo;
        private Integer llmUsageMode;
        private a<Integer> llmUsageModeGetter;
        private final Context mContext;
        private String packageName;

        public Builder(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r5, "context");
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r0, "context.applicationContext");
            this.mContext = ZeusTransformUtils.wrapperContext(r0, "com.obric.aiagent.plugin");
            this.bindRemoteOnInit = true;
            this.packageName = r5.getPackageName();
        }

        public final Context getMContext$sdk_release() {
            return this.mContext;
        }

        public final Long getAppId$sdk_release() {
            return this.appId;
        }

        public final void setAppId$sdk_release(Long r1) {
            this.appId = r1;
        }

        public final String getPackageName$sdk_release() {
            return this.packageName;
        }

        public final void setPackageName$sdk_release(String r1) {
            this.packageName = r1;
        }

        public final ExtraAppInfo getExtraBindInfo$sdk_release() {
            return this.extraBindInfo;
        }

        public final void setExtraBindInfo$sdk_release(ExtraAppInfo r1) {
            this.extraBindInfo = r1;
        }

        public final boolean getAuthBySign$sdk_release() {
            return this.authBySign;
        }

        public final void setAuthBySign$sdk_release(boolean r1) {
            this.authBySign = r1;
        }

        public final boolean getBindRemoteOnInit$sdk_release() {
            return this.bindRemoteOnInit;
        }

        public final void setBindRemoteOnInit$sdk_release(boolean r1) {
            this.bindRemoteOnInit = r1;
        }

        public final boolean getChildProcessImportantBindEnabled$sdk_release() {
            return this.childProcessImportantBindEnabled;
        }

        public final void setChildProcessImportantBindEnabled$sdk_release(boolean r1) {
            this.childProcessImportantBindEnabled = r1;
        }

        public final Integer getLlmUsageMode$sdk_release() {
            return this.llmUsageMode;
        }

        public final void setLlmUsageMode$sdk_release(Integer r1) {
            this.llmUsageMode = r1;
        }

        public final a<Integer> getLlmUsageModeGetter$sdk_release() {
            return this.llmUsageModeGetter;
        }

        public final void setLlmUsageModeGetter$sdk_release(a<Integer> r3) {
            this.llmUsageModeGetter = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        }

        public final Builder appId(long r1) {
            this.appId = Long.valueOf(r1);
            return this;
        }

        public final Builder packageName(String r2) {
            o.e(r2, "packageName");
            this.packageName = r2;
            return this;
        }

        public final Builder extraBindInfo(ExtraAppInfo r1) {
            this.extraBindInfo = r1;
            return this;
        }

        public final Builder authBySign() {
            this.authBySign = true;
            return this;
        }

        public static /* synthetic */ Builder bindRemoteOnInit$default(Builder r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = true;
        L6:
            return r0.bindRemoteOnInit(r1);
        }

        public final Builder bindRemoteOnInit(boolean r1) {
            this.bindRemoteOnInit = r1;
            return this;
        }

        public static /* synthetic */ Builder enableChildProcessImportantBind$default(Builder r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = false;
        L6:
            return r0.enableChildProcessImportantBind(r1);
        }

        public final Builder enableChildProcessImportantBind(boolean r1) {
            this.childProcessImportantBindEnabled = r1;
            return this;
        }

        public final Builder useLlmInBackgroundOnDemand() {
            this.llmUsageMode = 1;
            return this;
        }

        public final Builder setLlmUsageMode(a<Integer> r3) {
            a<Integer> r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            o.e(r4, "getter");
            this.llmUsageModeGetter = r4;
            return this;
        }

        public final AIKernelConfig build() {
            return new AIKernelConfig(this);
        }
    }

    /* JADX INFO: compiled from: AIKernelConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AIKernelConfig(Builder r4) {
        o.e(r4, "builder");
        this.bindRemoteOnInit = true;
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getMContext$sdk_release(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.mContext = r0;
        if (r0 == null) goto L24;
        Long r1 = r4.getAppId$sdk_release();
        this.mAppId = r1;
        if (r1 == null) goto L22;
        String r2 = r4.getPackageName$sdk_release();
        this.mPackageName = r2;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L13;
        Context r3 = this.mContext;
        if (r3 == null) goto L11;
        String r5 = r3.getPackageName();
    L12:
        this.mPackageName = r5;
        goto L13
    L11:
        r5 = null;
    L13:
        this.extraBindInfo = r4.getExtraBindInfo$sdk_release();
        this.authBySign = r4.getAuthBySign$sdk_release();
        this.bindRemoteOnInit = r4.getBindRemoteOnInit$sdk_release();
        this.childProcessImportantBindEnabled = r4.getChildProcessImportantBindEnabled$sdk_release();
        if (r4.getLlmUsageModeGetter$sdk_release() != null) goto L18;
        Integer r6 = r4.getLlmUsageMode$sdk_release();
        if (r6 == null) goto L19;
        this.staticLlmMode = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue();
        this.llmUsageMode = (a) ZeusTransformUtils.preCheckCast(new AIKernelConfig$3$1(this), a.class, "com.obric.aiagent.plugin");
    L19:
        AIKLog.INSTANCE.i(TAG, "AIKernel init config success");
        return;
    L18:
        this.llmUsageMode = r4.getLlmUsageModeGetter$sdk_release();
        goto L19
    L22:
        throw new IllegalArgumentException("appId is required".toString());
    L24:
        throw new IllegalArgumentException("app context is required".toString());
    }

    public static final /* synthetic */ int access$getStaticLlmMode$p(AIKernelConfig r0) {
        return r0.staticLlmMode;
    }

    public final boolean getAuthBySign() {
        return this.authBySign;
    }

    public final boolean getBindRemoteOnInit() {
        return this.bindRemoteOnInit;
    }

    public final boolean getChildProcessImportantBindEnabled() {
        return this.childProcessImportantBindEnabled;
    }

    public final a<Integer> getLlmUsageMode() {
        return this.llmUsageMode;
    }

    public final Context getContext() {
        Context r0 = this.mContext;
        o.a(r0);
        return r0;
    }

    public final long getAppId() {
        Long r2 = this.mAppId;
        o.a(r2);
        return r2.longValue();
    }

    public final String getPackageName() {
        String r0 = this.mPackageName;
        o.a(r0);
        return r0;
    }

    public final ExtraAppInfo getExtraBindInfo() {
        return this.extraBindInfo;
    }
}
