package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\fR\u001a\u0010\u001e\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R(\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\n\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006R\u001a\u0010*\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006R \u0010,\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b-\u0010\f¨\u00060"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/e;", "", "", "switch", "I", "l", "()I", "", "", "liveInterruptBtmList", "Ljava/util/List;", "c", "()Ljava/util/List;", "videoInterruptBtmList", "m", "liveOrVideoInterruptBtmList", "d", "productDetailBtmList", ce.f26391f, "skuBtmList", ce.f26396k, "orderSubmitBtmList", "e", "productExplainRecordPageBtmList", RXScreenCaptureService.KEY_INDEX, "schemaJumpBtmList", ce.f26395j, "otherEnableBackPages", "f", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/a;", "alogUpload", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/a;", "getAlogUpload", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/a;", "eventMonitorSwitch", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "eventMustHaveBtm", "b", "setEventMustHaveBtm", "(Ljava/util/List;)V", "productDetailDuration", "h", "underTakeSwitch", "getUnderTakeSwitch", "disableUnderTakeList", "getDisableUnderTakeList", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class e {

    @SerializedName("alog_upload")
    private final a alogUpload;

    @SerializedName("disable_under_take_list")
    private final List<String> disableUnderTakeList;

    @SerializedName("event_monitor_switch")
    private final int eventMonitorSwitch;

    @SerializedName("event_must_have_btm")
    private List<String> eventMustHaveBtm;

    @SerializedName("live_interrupt_btm_list")
    private final List<String> liveInterruptBtmList;

    @SerializedName("live_or_video_interrupt_btm_list")
    private final List<String> liveOrVideoInterruptBtmList;

    @SerializedName("order_submit_btm_list")
    private final List<String> orderSubmitBtmList;

    @SerializedName("other_enable_back_pages")
    private final List<String> otherEnableBackPages;

    @SerializedName("product_detail_btm_list")
    private final List<String> productDetailBtmList;

    @SerializedName("product_detail_duration")
    private final int productDetailDuration;

    @SerializedName("product_explain_record_btm_list")
    private final List<String> productExplainRecordPageBtmList;

    @SerializedName("schema_jump_btm_list")
    private final List<String> schemaJumpBtmList;

    @SerializedName("sku_btm_list")
    private final List<String> skuBtmList;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f67switch;

    @SerializedName("under_take_switch")
    private final int underTakeSwitch;

    @SerializedName("video_interrupt_btm_list")
    private final List<String> videoInterruptBtmList;

    public e() {
        this.f67switch = 1;
        this.liveInterruptBtmList = CollectionsKt.listOf(new String[]{"a1.b0715.c0.d0", "a1128.b3295.c0.d0"});
        this.videoInterruptBtmList = CollectionsKt.emptyList();
        this.liveOrVideoInterruptBtmList = CollectionsKt.listOf("a1128.b7947.c0.d0");
        this.productDetailBtmList = CollectionsKt.listOf(new String[]{"a1.b8094.c0.d0", "a1.b84216.c0.d0"});
        this.skuBtmList = CollectionsKt.listOf("a1.b5267.c0.d0");
        this.orderSubmitBtmList = CollectionsKt.listOf("a1.b7411.c0.d0");
        this.productExplainRecordPageBtmList = CollectionsKt.listOf("a1.b3390.c0.d0");
        this.schemaJumpBtmList = CollectionsKt.listOf("a1.b9795.c0.d0");
        this.otherEnableBackPages = CollectionsKt.listOf("a1.b60327.c0.d0");
        this.alogUpload = new a();
        this.eventMonitorSwitch = 1;
        this.eventMustHaveBtm = CollectionsKt.emptyList();
        this.productDetailDuration = 3000;
        this.underTakeSwitch = 1;
        this.disableUnderTakeList = CollectionsKt.emptyList();
    }

    public final int a() {
        return this.eventMonitorSwitch;
    }

    public final List<String> b() {
        return this.eventMustHaveBtm;
    }

    public final List<String> c() {
        return this.liveInterruptBtmList;
    }

    public final List<String> d() {
        return this.liveOrVideoInterruptBtmList;
    }

    public final List<String> e() {
        return this.orderSubmitBtmList;
    }

    public final List<String> f() {
        return this.otherEnableBackPages;
    }

    public final List<String> g() {
        return this.productDetailBtmList;
    }

    public final int h() {
        return this.productDetailDuration;
    }

    public final List<String> i() {
        return this.productExplainRecordPageBtmList;
    }

    public final List<String> j() {
        return this.schemaJumpBtmList;
    }

    public final List<String> k() {
        return this.skuBtmList;
    }

    public final int l() {
        return this.f67switch;
    }

    public final List<String> m() {
        return this.videoInterruptBtmList;
    }
}
