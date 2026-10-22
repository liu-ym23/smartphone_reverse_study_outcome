package com.bytedance.android.btm.impl.setting;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/c;", "", "", "btmPageShowSwitch", "I", "c", "()I", "", "", "allowlistPages", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "blocklistPages", "b", "defaultSend", "e", "eventDefaultAllowlist", ce.f26391f, "eventDefaultBlocklist", "h", "chainLength", "d", "loggerType", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/btm/impl/setting/b;", "eventConfig", "f", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class c {

    @SerializedName("btm_page_show_allowlist")
    private final List<String> allowlistPages;

    @SerializedName("btm_page_show_blocklist")
    private final List<String> blocklistPages;

    @SerializedName("btm_page_show_switch")
    private final int btmPageShowSwitch;

    @SerializedName("chain_length")
    private final int chainLength;

    @SerializedName("btm_page_show_default_send")
    private final int defaultSend;

    @SerializedName("event_config")
    private final List<b> eventConfig;

    @SerializedName("event_default_allowlist")
    private final List<String> eventDefaultAllowlist;

    @SerializedName("event_default_blocklist")
    private final List<String> eventDefaultBlocklist;

    @SerializedName("logger_type")
    private final int loggerType;

    public c() {
        this.allowlistPages = CollectionsKt.emptyList();
        this.blocklistPages = CollectionsKt.emptyList();
        this.eventDefaultAllowlist = CollectionsKt.emptyList();
        this.eventDefaultBlocklist = CollectionsKt.emptyList();
        this.chainLength = 20;
        this.eventConfig = CollectionsKt.emptyList();
    }

    public final List<String> a() {
        return this.allowlistPages;
    }

    public final List<String> b() {
        return this.blocklistPages;
    }

    public final int c() {
        return this.btmPageShowSwitch;
    }

    public final int d() {
        return this.chainLength;
    }

    public final int e() {
        return this.defaultSend;
    }

    public final List<b> f() {
        return this.eventConfig;
    }

    public final List<String> g() {
        return this.eventDefaultAllowlist;
    }

    public final List<String> h() {
        return this.eventDefaultBlocklist;
    }

    public final int i() {
        return this.loggerType;
    }
}
