package com.bytedance.android.btm.impl.setting;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b'\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bX\u0010YR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR*\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR(\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010F\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR\"\u0010N\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010\u0004\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR\"\u0010R\u001a\u00020Q8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006Z"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/o;", "", "", "enableBtmPageShowOpt", "I", "f", "()I", "setEnableBtmPageShowOpt", "(I)V", "chainMapSize", "d", "setChainMapSize", "eventMapSize", ce.f26396k, "setEventMapSize", "bcmMapSize", "c", "setBcmMapSize", "durationMapSize", "e", "setDurationMapSize", "lowMemory", OfficeSDKRequestTag.KEY_NEW_USER, "setLowMemory", "alogVersion", "b", "setAlogVersion", "", "alogSleepTimeMillis", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setAlogSleepTimeMillis", "(J)V", "eventCheckSleepTimeMillis", ce.f26395j, "setEventCheckSleepTimeMillis", "eventQueueCapacity", "l", "setEventQueueCapacity", "enableRecoveryALog", "getEnableRecoveryALog", "setEnableRecoveryALog", "weakFragmentViewMap", BaseSwitches.V, "setWeakFragmentViewMap", "unitBufferBtm", "u", "setUnitBufferBtm", "enableEventBtmMap", ce.f26391f, "setEnableEventBtmMap", "pageTreeV2", "q", "setPageTreeV2", "optTab", "p", "setOptTab", "showIdUpdateDelay", "s", "setShowIdUpdateDelay", "optCreateNode", "o", "setOptCreateNode", "sameUnitParams", "r", "setSameUnitParams", "", "", "generateShowIdByEmptyHost", "Ljava/util/List;", "m", "()Ljava/util/List;", "setGenerateShowIdByEmptyHost", "(Ljava/util/List;)V", "errCloseList", "h", "setErrCloseList", "storeUsedTokenMap", "t", "setStoreUsedTokenMap", "Lcom/bytedance/android/btm/impl/setting/j;", "errorCodeConfig", "Lcom/bytedance/android/btm/impl/setting/j;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/btm/impl/setting/j;", "setErrorCodeConfig", "(Lcom/bytedance/android/btm/impl/setting/j;)V", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class o {

    @SerializedName("alog_sleep_timemillis")
    private long alogSleepTimeMillis;

    @SerializedName("alog_thread_version")
    private int alogVersion;

    @SerializedName("bcm_map_size")
    private int bcmMapSize;

    @SerializedName("chain_map_size")
    private int chainMapSize;

    @SerializedName("duration_map_size")
    private int durationMapSize;

    @SerializedName("enable_btm_page_show_opt")
    private int enableBtmPageShowOpt;

    @SerializedName("enable_event_btm_map")
    private int enableEventBtmMap;

    @SerializedName("enable_recovery_alog")
    private int enableRecoveryALog;

    @SerializedName("err_close_list")
    private List<Integer> errCloseList;

    @SerializedName("error_code_config")
    private j errorCodeConfig;

    @SerializedName("event_check_sleep_alog_sleep_timemillis")
    private long eventCheckSleepTimeMillis;

    @SerializedName("event_map_size")
    private int eventMapSize;

    @SerializedName("event_queue_capacity")
    private int eventQueueCapacity;

    @SerializedName("generate_show_id_by_empty_host")
    private List<String> generateShowIdByEmptyHost;

    @SerializedName("low_memory")
    private int lowMemory;

    @SerializedName("optimize_create_node")
    private int optCreateNode;

    @SerializedName("opt_tab")
    private int optTab;

    @SerializedName("page_tree_v2")
    private int pageTreeV2;

    @SerializedName("same_unit_params")
    private int sameUnitParams;

    @SerializedName("show_id_update_delay")
    private int showIdUpdateDelay;

    @SerializedName("store_used_token_map")
    private int storeUsedTokenMap;

    @SerializedName("unit_buffer_btm")
    private int unitBufferBtm;

    @SerializedName("weak_fragment_view_map")
    private int weakFragmentViewMap;

    public o() {
        this.enableBtmPageShowOpt = 1;
        this.chainMapSize = 20000;
        this.eventMapSize = 20000;
        this.bcmMapSize = 10000;
        this.durationMapSize = 10000;
        this.lowMemory = 1;
        this.alogVersion = 2;
        this.alogSleepTimeMillis = 5000;
        this.eventCheckSleepTimeMillis = 10000;
        this.eventQueueCapacity = 3000;
        this.enableRecoveryALog = 1;
        this.weakFragmentViewMap = 1;
        this.unitBufferBtm = 1;
        this.pageTreeV2 = 1;
        this.optTab = 1;
        this.showIdUpdateDelay = 1;
        this.generateShowIdByEmptyHost = CollectionsKt.emptyList();
        this.errCloseList = CollectionsKt.emptyList();
        this.storeUsedTokenMap = 1;
        this.errorCodeConfig = new j();
    }

    public final long a() {
        return this.alogSleepTimeMillis;
    }

    public final int b() {
        return this.alogVersion;
    }

    public final int c() {
        return this.bcmMapSize;
    }

    public final int d() {
        return this.chainMapSize;
    }

    public final int e() {
        return this.durationMapSize;
    }

    public final int f() {
        return this.enableBtmPageShowOpt;
    }

    public final int g() {
        return this.enableEventBtmMap;
    }

    public final List<Integer> h() {
        return this.errCloseList;
    }

    public final j i() {
        return this.errorCodeConfig;
    }

    public final long j() {
        return this.eventCheckSleepTimeMillis;
    }

    public final int k() {
        return this.eventMapSize;
    }

    public final int l() {
        return this.eventQueueCapacity;
    }

    public final List<String> m() {
        return this.generateShowIdByEmptyHost;
    }

    public final int n() {
        return this.lowMemory;
    }

    public final int o() {
        return this.optCreateNode;
    }

    public final int p() {
        return this.optTab;
    }

    public final int q() {
        return this.pageTreeV2;
    }

    public final int r() {
        return this.sameUnitParams;
    }

    public final int s() {
        return this.showIdUpdateDelay;
    }

    public final int t() {
        return this.storeUsedTokenMap;
    }

    public final int u() {
        return this.unitBufferBtm;
    }

    public final int v() {
        return this.weakFragmentViewMap;
    }
}
