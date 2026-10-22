package com.bytedance.android.livesdk.message.linker;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiRtcInfo;
import com.bytedance.android.livesdk.chatroom.model.t;
import com.bytedance.android.livesdk.chatroom.model.v;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class LinkmicInfoWithRtcInfoData extends FlexModelBase<h> implements h {

    @SerializedName("chorus_accompaniment_info")
    public t chorusAccompanimentInfo;

    @SerializedName("chorus_cdn_info")
    public v chorusCDNInfo;

    @SerializedName("client_ui_info")
    public ClientUIInfo clientUIInfo;

    @SerializedName("function_type")
    public String functionType;

    @SerializedName("live_core_ext_info")
    public String liveCoreExtInfo;

    @SerializedName("main_anchor_linkmic_info")
    public AnchorLinkmicInfo mainAnchorLinkmicInfo;

    @SerializedName("multi_live_core_info")
    public MultiLiveCoreInfo multiLiveCoreInfo;

    @SerializedName("multi_rtc_info")
    public MultiRtcInfo multiRtcInfo;

    @SerializedName("play_modes")
    public List<Integer> playModes;

    @SerializedName("scene")
    public int scene;

    @SerializedName("sub_rtc_ext_info")
    public String subRtcExtInfo;

    @SerializedName("support_update_link_type")
    public boolean supportUpdateLinkType;

    @SerializedName("ui_layout")
    public int uiLayout;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    @SerializedName(Constants.OperatorKey.KEY_VENDOR)
    public int f153548vendor;

    public LinkmicInfoWithRtcInfoData() {
        super(h.class);
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public boolean checkIsLegal() {
        AnchorLinkmicInfo r100 = this.mainAnchorLinkmicInfo;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.linkmicIdStr) == true) goto L9;
        if (TextUtils.isEmpty(this.mainAnchorLinkmicInfo.rtcExtInfo) == true) goto L9;
        return true;
    }

    public String toString() {
        return "LinkmicInfoWithRtcInfoData{scene=" + this.scene + ", playModes=" + this.playModes + ", uiLayout=" + this.uiLayout + '}';
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public /* bridge */ /* synthetic */ b getMainAnchorLinkmicInfo() {
        return getMainAnchorLinkmicInfo();
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public t getChorusAccompanimentInfo() {
        return this.chorusAccompanimentInfo;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public v getChorusCDNInfo() {
        return this.chorusCDNInfo;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public ClientUIInfo getClientUIInfo() {
        return this.clientUIInfo;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public String getFunctionType() {
        return this.functionType;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public String getLiveCoreExtInfo() {
        return this.liveCoreExtInfo;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public u1 getMultiLiveCoreInfo() {
        return this.multiLiveCoreInfo;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public v1 getMultiRtcInfo() {
        return this.multiRtcInfo;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public List<Integer> getPlayModes() {
        return this.playModes;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public int getScene() {
        return this.scene;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public String getSubRtcExtInfo() {
        return this.subRtcExtInfo;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public int getUiLayout() {
        return this.uiLayout;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public int getVendor() {
        return this.f153548vendor;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public boolean isSupportUpdateLinkType() {
        return this.supportUpdateLinkType;
    }

    @Override // com.bytedance.android.livesdk.message.linker.h
    public AnchorLinkmicInfo getMainAnchorLinkmicInfo() {
        return this.mainAnchorLinkmicInfo;
    }
}
