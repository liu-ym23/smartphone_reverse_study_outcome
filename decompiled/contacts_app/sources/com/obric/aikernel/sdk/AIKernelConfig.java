package com.obric.aikernel.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.data.ExtraAppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIKernelConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\rJ\u0006\u0010\u0014\u001a\u00020\u0010J\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0016\u001a\u00020\u0012R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/aikernel/sdk/AIKernelConfig;", "", "builder", "Lcom/obric/aikernel/sdk/AIKernelConfig$Builder;", "(Lcom/obric/aikernel/sdk/AIKernelConfig$Builder;)V", "<set-?>", "", "authBySign", "getAuthBySign", "()Z", "extraBindInfo", "Lcom/obric/aikernel/sdk/data/ExtraAppInfo;", "mAppId", "", "Ljava/lang/Long;", "mContext", "Landroid/content/Context;", "mPackageName", "", "getAppId", "getContext", "getExtraBindInfo", "getPackageName", "Builder", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIKernelConfig {
    public static final Companion Companion = null;
    private static final String TAG = "AIKernelConfig";
    private boolean authBySign;
    private ExtraAppInfo extraBindInfo;
    private Long mAppId;
    private Context mContext;
    private String mPackageName;

    /* JADX INFO: compiled from: AIKernelConfig.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0000J\u0006\u0010!\u001a\u00020\"J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/obric/aikernel/sdk/AIKernelConfig$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appId", "", "getAppId$sdk_release", "()Ljava/lang/Long;", "setAppId$sdk_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "authBySign", "", "getAuthBySign$sdk_release", "()Z", "setAuthBySign$sdk_release", "(Z)V", "extraBindInfo", "Lcom/obric/aikernel/sdk/data/ExtraAppInfo;", "getExtraBindInfo$sdk_release", "()Lcom/obric/aikernel/sdk/data/ExtraAppInfo;", "setExtraBindInfo$sdk_release", "(Lcom/obric/aikernel/sdk/data/ExtraAppInfo;)V", "mContext", "getMContext$sdk_release", "()Landroid/content/Context;", "packageName", "", "getPackageName$sdk_release", "()Ljava/lang/String;", "setPackageName$sdk_release", "(Ljava/lang/String;)V", "build", "Lcom/obric/aikernel/sdk/AIKernelConfig;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        private Long appId;
        private boolean authBySign;
        private ExtraAppInfo extraBindInfo;
        private final Context mContext;
        private String packageName;

        public Builder(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Context r0 = r3.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(r0, "context.applicationContext");
            this.mContext = r0;
            this.packageName = r3.getPackageName();
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

        public final Builder appId(long r1) {
            this.appId = Long.valueOf(r1);
            return this;
        }

        public final Builder packageName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "packageName");
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

        public final AIKernelConfig build() {
            return new AIKernelConfig(this);
        }
    }

    /* JADX INFO: compiled from: AIKernelConfig.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/sdk/AIKernelConfig$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AIKernelConfig(Builder r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Context r0 = r2.getMContext$sdk_release();
        this.mContext = r0;
        if (r0 == null) goto L18;
        Long r1 = r2.getAppId$sdk_release();
        this.mAppId = r1;
        if (r1 == null) goto L16;
        String r3 = r2.getPackageName$sdk_release();
        this.mPackageName = r3;
        if (TextUtils.isEmpty(r3) == false) goto L13;
        Context r4 = this.mContext;
        if (r4 == null) goto L11;
        String r5 = r4.getPackageName();
    L12:
        this.mPackageName = r5;
        goto L13
    L11:
        r5 = null;
    L13:
        this.extraBindInfo = r2.getExtraBindInfo$sdk_release();
        this.authBySign = r2.getAuthBySign$sdk_release();
        AIKLog.INSTANCE.i(TAG, "AIKernel init config success");
        return;
    L16:
        throw new IllegalArgumentException("appId is required".toString());
    L18:
        throw new IllegalArgumentException("app context is required".toString());
    }

    public final boolean getAuthBySign() {
        return this.authBySign;
    }

    public final Context getContext() {
        Context r0 = this.mContext;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final long getAppId() {
        Long r2 = this.mAppId;
        Intrinsics.checkNotNull(r2);
        return r2.longValue();
    }

    public final String getPackageName() {
        String r0 = this.mPackageName;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final ExtraAppInfo getExtraBindInfo() {
        return this.extraBindInfo;
    }
}
