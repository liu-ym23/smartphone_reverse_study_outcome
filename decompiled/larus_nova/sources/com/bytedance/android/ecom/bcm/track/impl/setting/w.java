package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bg\u0010hR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\u00020 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001a\u0010'\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001a\u0010*\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010/\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00104\u001a\u0002038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u00109\u001a\u0002088\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020=8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010C\u001a\u00020B8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001a\u0010H\u001a\u00020G8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001a\u0010M\u001a\u00020L8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\"\u0010R\u001a\u00020Q8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010X\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0004\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010[R \u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001a\u0010c\u001a\u00020b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010f¨\u0006i"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/w;", "", "", "sdkSwitch", "I", "o", "()I", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/s;", "orderBcmChain", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/s;", "l", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/s;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/t;", "search", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/t;", "p", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/t;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/q;", "liveGuideMall", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/q;", ce.f26396k, "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/q;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/z;", "videoGuideMall", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/z;", "r", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/z;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/m;", "ecomSec", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/m;", "e", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/m;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/e;", "bstGroupType", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/e;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/e;", "errCrashSwitch", "getErrCrashSwitch", "popUpDialogSwitch", "getPopUpDialogSwitch", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/g;", "bstRequestMonitor", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/g;", "b", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/g;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/u;", "sendLogV3", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/u;", "q", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/u;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/p;", "globalProps", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/p;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/p;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/l;", "ecmConfig", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/l;", "d", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/l;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/r;", "orderIdConfig", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/r;", "m", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/r;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/k;", "liveConfig", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/k;", ce.f26395j, "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/k;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/o;", "generalTracker", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/o;", "h", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/o;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/i;", "compressedBcmChainConfig", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/i;", "c", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/i;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/a0;", "virtualNode", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/a0;", "s", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/a0;", "setVirtualNode", "(Lcom/bytedance/android/ecom/bcm/track/impl/setting/a0;)V", "fixBcmChainInOrder", ce.f26391f, "setFixBcmChainInOrder", "(I)V", "", "", "removeKeysFromEntranceInfo", "Ljava/util/List;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/util/List;", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/n;", "entranceInfoConfig", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/n;", "f", "()Lcom/bytedance/android/ecom/bcm/track/impl/setting/n;", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class w {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE)
    private final e bstGroupType;

    @SerializedName("bst_request_monitor")
    private final g bstRequestMonitor;

    @SerializedName("compressed_bcm_chain_to_header")
    private final i compressedBcmChainConfig;

    @SerializedName("ecom_marketing_config")
    private final l ecmConfig;

    @SerializedName("ecom_sec")
    private final m ecomSec;

    @SerializedName("entrance_info_emergency_config")
    private final n entranceInfoConfig;

    @SerializedName("err_crash_switch")
    private final int errCrashSwitch;

    @SerializedName("fix_bcm_chain_in_order")
    private int fixBcmChainInOrder;

    @SerializedName("general_tracker")
    private final o generalTracker;

    @SerializedName("global_props_config")
    private final p globalProps;

    @SerializedName("ecom_live_config")
    private final k liveConfig;

    @SerializedName("live_guide_mall")
    private final q liveGuideMall;

    @SerializedName("order_bcm_chain")
    private final s orderBcmChain;

    @SerializedName("mall_purchase_order_id_config")
    private final r orderIdConfig;

    @SerializedName("popup_dialog_switch")
    private final int popUpDialogSwitch;

    @SerializedName("remove_keys_from_entrance_info")
    private final List<String> removeKeysFromEntranceInfo;

    @SerializedName("sdk_switch")
    private final int sdkSwitch;

    @SerializedName("search")
    private final t search;

    @SerializedName("sendLogV3")
    private final u sendLogV3;

    @SerializedName("video_guide_mall")
    private final z videoGuideMall;

    @SerializedName("virtual_node")
    private a0 virtualNode;

    public w() {
        this.sdkSwitch = 1;
        this.orderBcmChain = new s();
        this.search = new t();
        this.liveGuideMall = new q();
        this.videoGuideMall = new z();
        this.ecomSec = new m();
        this.bstGroupType = new e();
        this.bstRequestMonitor = new g();
        this.sendLogV3 = new u();
        this.globalProps = new p();
        this.ecmConfig = new l();
        this.orderIdConfig = new r();
        this.liveConfig = new k();
        this.generalTracker = new o();
        this.compressedBcmChainConfig = new i();
        this.virtualNode = new a0();
        this.fixBcmChainInOrder = 1;
        this.removeKeysFromEntranceInfo = CollectionsKt.emptyList();
        this.entranceInfoConfig = new n();
    }

    public final e a() {
        return this.bstGroupType;
    }

    public final g b() {
        return this.bstRequestMonitor;
    }

    public final i c() {
        return this.compressedBcmChainConfig;
    }

    public final l d() {
        return this.ecmConfig;
    }

    public final m e() {
        return this.ecomSec;
    }

    public final n f() {
        return this.entranceInfoConfig;
    }

    public final int g() {
        return this.fixBcmChainInOrder;
    }

    public final o h() {
        return this.generalTracker;
    }

    public final p i() {
        return this.globalProps;
    }

    public final k j() {
        return this.liveConfig;
    }

    public final q k() {
        return this.liveGuideMall;
    }

    public final s l() {
        return this.orderBcmChain;
    }

    public final r m() {
        return this.orderIdConfig;
    }

    public final List<String> n() {
        return this.removeKeysFromEntranceInfo;
    }

    public final int o() {
        return this.sdkSwitch;
    }

    public final t p() {
        return this.search;
    }

    public final u q() {
        return this.sendLogV3;
    }

    public final z r() {
        return this.videoGuideMall;
    }

    public final a0 s() {
        return this.virtualNode;
    }
}
