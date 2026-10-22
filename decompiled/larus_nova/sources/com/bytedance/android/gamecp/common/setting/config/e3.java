package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/e3;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "switchOne", "e", "setSwitchOne", "switchTwo", ce.f26391f, "setSwitchTwo", "switchThree", "f", "setSwitchThree", "debug", "b", "setDebug", "forceTransform", "d", "setForceTransform", "closeRequest", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCloseRequest", "", "", "zhaoXiGameIds", "Ljava/util/List;", "h", "()Ljava/util/List;", "setZhaoXiGameIds", "(Ljava/util/List;)V", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e3 {

    @SerializedName("game_center_data_switch")
    private boolean closeRequest;

    @SerializedName("debug_mode")
    private boolean debug;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("force_transform")
    private boolean forceTransform;

    @SerializedName("switch_zhao_xi_game")
    private boolean switchOne;

    @SerializedName("switch_enter_from")
    private boolean switchThree;

    @SerializedName("switch_from_source")
    private boolean switchTwo;

    @SerializedName("zhao_xi_game_ids")
    private List<String> zhaoXiGameIds;

    public e3() {
        this.switchOne = true;
        this.switchTwo = true;
        this.switchThree = true;
        this.closeRequest = true;
        this.zhaoXiGameIds = CollectionsKt.listOf(new String[]{"cgmocn000000001000004355", "cgmocn000000000014170286", "cgmocn000000001000006297", "cgmocn000000000014137295", "cgmocn000000001000008259", "cgm-f3be5eb3e726d5ca", "cgm-f7e0392754fc9fd5", "cg43503459d29d0611", "cgm-955ecde5be6ba2fa", "cg419d0618d84a1b07", "cgmocn000000001000006467", "cgmocn000000000015336281", "cgm-01b9f28101174399", "cgmocn000000000003003369"});
    }

    public final boolean a() {
        return this.closeRequest;
    }

    public final boolean b() {
        return this.debug;
    }

    public final boolean c() {
        return this.enable;
    }

    public final boolean d() {
        return this.forceTransform;
    }

    public final boolean e() {
        return this.switchOne;
    }

    public final boolean f() {
        return this.switchThree;
    }

    public final boolean g() {
        return this.switchTwo;
    }

    public final List<String> h() {
        return this.zhaoXiGameIds;
    }
}
