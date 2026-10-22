package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/c0;", "", "", "highPriorityChatBufferSize", "I", "c", "()I", "normalPriorityChatBufferSize", RXScreenCaptureService.KEY_INDEX, "lowPriorityChatBufferSize", "f", "highPriorityBusinessBufferSize", "b", "normalPriorityBusinessBufferSize", "h", "lowPriorityBusinessBufferSize", "e", "highPriorityBasicBufferSize", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "normalPriorityBasicBufferSize", ce.f26391f, "lowPriorityBasicBufferSize", "d", "systemActionBufferSize", ce.f26395j, "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("high_priority_basic_action_size")
    private final int highPriorityBasicBufferSize;

    @SerializedName("high_priority_business_action_size")
    private final int highPriorityBusinessBufferSize;

    @SerializedName("high_priority_chat_action_size")
    private final int highPriorityChatBufferSize;

    @SerializedName("low_priority_basic_action_size")
    private final int lowPriorityBasicBufferSize;

    @SerializedName("low_priority_business_action_size")
    private final int lowPriorityBusinessBufferSize;

    @SerializedName("low_priority_chat_action_size")
    private final int lowPriorityChatBufferSize;

    @SerializedName("normal_priority_basic_action_size")
    private final int normalPriorityBasicBufferSize;

    @SerializedName("normal_priority_business_action_size")
    private final int normalPriorityBusinessBufferSize;

    @SerializedName("normal_priority_chat_action_size")
    private final int normalPriorityChatBufferSize;

    @SerializedName("system_action_size")
    private final int systemActionBufferSize;

    public c0() {
        this.highPriorityChatBufferSize = 36;
        this.normalPriorityChatBufferSize = 36;
        this.lowPriorityChatBufferSize = 12;
        this.highPriorityBusinessBufferSize = 12;
        this.normalPriorityBusinessBufferSize = 8;
        this.lowPriorityBusinessBufferSize = 12;
        this.highPriorityBasicBufferSize = 24;
        this.normalPriorityBasicBufferSize = 24;
        this.lowPriorityBasicBufferSize = 12;
        this.systemActionBufferSize = 96;
    }

    public final int a() {
        return this.highPriorityBasicBufferSize;
    }

    public final int b() {
        return this.highPriorityBusinessBufferSize;
    }

    public final int c() {
        return this.highPriorityChatBufferSize;
    }

    public final int d() {
        return this.lowPriorityBasicBufferSize;
    }

    public final int e() {
        return this.lowPriorityBusinessBufferSize;
    }

    public final int f() {
        return this.lowPriorityChatBufferSize;
    }

    public final int g() {
        return this.normalPriorityBasicBufferSize;
    }

    public final int h() {
        return this.normalPriorityBusinessBufferSize;
    }

    public final int i() {
        return this.normalPriorityChatBufferSize;
    }

    public final int j() {
        return this.systemActionBufferSize;
    }
}
