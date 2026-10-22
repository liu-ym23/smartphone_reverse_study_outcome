package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveAppLoggerConfig;", "", "()V", "enablePreDrop", "", "getEnablePreDrop", "()Z", "setEnablePreDrop", "(Z)V", "preDropEventsWhiteSet", "", "", "getPreDropEventsWhiteSet", "()Ljava/util/Set;", "setPreDropEventsWhiteSet", "(Ljava/util/Set;)V", "Companion", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAppLoggerConfig {
    public static final Companion Companion = null;
    private static final Lazy config$delegate = null;

    @SerializedName("enable_pre_drop")
    private boolean enablePreDrop;

    @SerializedName("pre_drop_events_whitelist")
    private Set<String> preDropEventsWhiteSet;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveAppLoggerConfig$Companion;", "", "()V", "config", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveAppLoggerConfig;", "getConfig", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveAppLoggerConfig;", "config$delegate", "Lkotlin/Lazy;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final LiveAppLoggerConfig getConfig() {
            return (LiveAppLoggerConfig) LiveAppLoggerConfig.access$getConfig$cp().getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        config$delegate = LazyKt.lazy(LiveAppLoggerConfig$Companion$config$2.INSTANCE);
    }

    public LiveAppLoggerConfig() {
        this.preDropEventsWhiteSet = SetsKt.emptySet();
    }

    public static final /* synthetic */ Lazy access$getConfig$cp() {
        return config$delegate;
    }

    public final boolean getEnablePreDrop() {
        return this.enablePreDrop;
    }

    public final Set<String> getPreDropEventsWhiteSet() {
        return this.preDropEventsWhiteSet;
    }

    public final void setEnablePreDrop(boolean r100) {
        this.enablePreDrop = r100;
    }

    public final void setPreDropEventsWhiteSet(Set<String> r100) {
        this.preDropEventsWhiteSet = r100;
    }
}
