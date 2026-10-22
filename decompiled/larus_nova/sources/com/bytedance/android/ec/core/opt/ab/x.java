package com.bytedance.android.ec.core.opt.ab;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/core/opt/ab/x;", "", "", "jitOnPromotionsLaunch", "Z", "c", "()Z", "setJitOnPromotionsLaunch", "(Z)V", "jitOnPromotionsSwipe", "d", "setJitOnPromotionsSwipe", "jitOnDetailLaunch", "getJitOnDetailLaunch", "setJitOnDetailLaunch", "jitOnDetailSwipe", "b", "setJitOnDetailSwipe", "", "jitDurationOnPromotions", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setJitDurationOnPromotions", "(J)V", "jitDurationOnDetail", "getJitDurationOnDetail", "setJitDurationOnDetail", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x {

    @SerializedName("jit_duration_on_detail")
    private long jitDurationOnDetail;

    @SerializedName("jit_duration_on_promotions")
    private long jitDurationOnPromotions;

    @SerializedName("jit_on_detail_launch")
    private boolean jitOnDetailLaunch;

    @SerializedName("jit_on_detail_swipe")
    private boolean jitOnDetailSwipe;

    @SerializedName("jit_on_promotions_launch")
    private boolean jitOnPromotionsLaunch;

    @SerializedName("jit_on_promotions_swipe")
    private boolean jitOnPromotionsSwipe;

    public x() {
        this.jitDurationOnPromotions = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
        this.jitDurationOnDetail = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
    }

    public final long a() {
        return this.jitDurationOnPromotions;
    }

    public final boolean b() {
        return this.jitOnDetailSwipe;
    }

    public final boolean c() {
        return this.jitOnPromotionsLaunch;
    }

    public final boolean d() {
        return this.jitOnPromotionsSwipe;
    }
}
