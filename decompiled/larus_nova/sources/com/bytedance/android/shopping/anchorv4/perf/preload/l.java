package com.bytedance.android.shopping.anchorv4.perf.preload;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/perf/preload/l;", "", "", "isActive", "Z", "d", "()Z", "", "triggerAfterDuration", "I", "b", "()I", "triggerAfterPicLoad", "c", "disableScroll", "getDisableScroll", "", "", "activeModule", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("active_module")
    private final List<String> activeModule;

    @SerializedName("disable_scroll")
    private final boolean disableScroll;

    @SerializedName("is_active")
    private final boolean isActive;

    @SerializedName("trigger_after_duration")
    private final int triggerAfterDuration;

    @SerializedName("trigger_after_pic_load")
    private final boolean triggerAfterPicLoad;

    public l() {
        this.isActive = false;
        this.triggerAfterDuration = 0;
        this.triggerAfterPicLoad = false;
        this.disableScroll = false;
        this.activeModule = null;
    }

    public final List<String> a() {
        return this.activeModule;
    }

    public final int b() {
        return this.triggerAfterDuration;
    }

    public final boolean c() {
        return this.triggerAfterPicLoad;
    }

    public final boolean d() {
        return this.isActive;
    }
}
