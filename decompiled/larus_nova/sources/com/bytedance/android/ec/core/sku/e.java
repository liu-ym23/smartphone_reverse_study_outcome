package com.bytedance.android.ec.core.sku;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/core/sku/e;", "", "", "clickDebounceDuration", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "serverTimeOffsetDuration", "c", "textPoolSize", "d", "imagePoolSize", "b", "viewPoolSize", "e", "", "enableRefactorText", "Z", "getEnableRefactorText", "()Z", "enableLayoutTwiceOpt", "getEnableLayoutTwiceOpt", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("click_debounce_duration")
    private final int clickDebounceDuration;

    @SerializedName("enable_layout_twice_opt")
    private final boolean enableLayoutTwiceOpt;

    @SerializedName("enable_refactor_text")
    private final boolean enableRefactorText;

    @SerializedName("image_pool_size")
    private final int imagePoolSize;

    @SerializedName("server_time_offset_duration")
    private final int serverTimeOffsetDuration;

    @SerializedName("text_pool_size")
    private final int textPoolSize;

    @SerializedName("view_pool_size")
    private final int viewPoolSize;

    public e() {
        this(0);
    }

    public final int a() {
        return this.clickDebounceDuration;
    }

    public final int b() {
        return this.imagePoolSize;
    }

    public final int c() {
        return this.serverTimeOffsetDuration;
    }

    public final int d() {
        return this.textPoolSize;
    }

    public final int e() {
        return this.viewPoolSize;
    }

    public e(int r100) {
        this.clickDebounceDuration = 1000;
        this.serverTimeOffsetDuration = 5;
        this.textPoolSize = 200;
        this.imagePoolSize = 200;
        this.viewPoolSize = 200;
        this.enableRefactorText = true;
        this.enableLayoutTwiceOpt = true;
    }
}
