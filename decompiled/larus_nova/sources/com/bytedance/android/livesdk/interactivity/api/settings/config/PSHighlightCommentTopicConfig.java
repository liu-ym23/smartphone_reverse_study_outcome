package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/PSHighlightCommentTopicConfig;", "", "", "enableAudience", "Z", "b", "()Z", "setEnableAudience", "(Z)V", "enableAnchor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEnableAnchor", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSHighlightCommentTopicConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f133756a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f133757b = null;

    @SerializedName("enable_anchor")
    private boolean enableAnchor;

    @SerializedName("enable_audience")
    private boolean enableAudience;

    public static final class a {
        public a() {
        }
    }

    public PSHighlightCommentTopicConfig() {
    }

    static {
        f133757b = new a();
        f133756a = LazyKt.lazy(PSHighlightCommentTopicConfig$Companion$setting$2.INSTANCE);
    }

    public final boolean a() {
        return this.enableAnchor;
    }

    public final boolean b() {
        return this.enableAudience;
    }
}
