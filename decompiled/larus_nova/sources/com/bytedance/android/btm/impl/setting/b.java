package com.bytedance.android.btm.impl.setting;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006\""}, d2 = {"Lcom/bytedance/android/btm/impl/setting/b;", "", "", "event", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "", "chainLength", "I", "c", "()I", ce.f26391f, "(I)V", "defaultSend", "d", "setDefaultSend", "ignoreBcmWhitelist", "f", "setIgnoreBcmWhitelist", "", "btmAllowlist", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setBtmAllowlist", "(Ljava/util/List;)V", "btmBlocklist", "b", "setBtmBlocklist", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class b {

    @SerializedName("btm_allowlist")
    private List<String> btmAllowlist;

    @SerializedName("btm_blocklist")
    private List<String> btmBlocklist;

    @SerializedName("chain_length")
    private int chainLength;

    @SerializedName("default_send")
    private int defaultSend;

    @SerializedName("event")
    private String event;

    @SerializedName("ignore_bcm_filter")
    private int ignoreBcmWhitelist;

    public b() {
        this.event = "";
        this.chainLength = -1;
        this.defaultSend = 1;
    }

    public final List<String> a() {
        return this.btmAllowlist;
    }

    public final List<String> b() {
        return this.btmBlocklist;
    }

    public final int c() {
        return this.chainLength;
    }

    public final int d() {
        return this.defaultSend;
    }

    public final String e() {
        return this.event;
    }

    public final int f() {
        return this.ignoreBcmWhitelist;
    }

    public final void g(int r100) {
        this.chainLength = r100;
    }
}
