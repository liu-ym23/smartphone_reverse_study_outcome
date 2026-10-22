package com.bytedance.android.livesdk.message.linker;

import com.bytedance.android.livesdk.chatroom.model.t;
import com.bytedance.android.livesdk.chatroom.model.v;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&R\u001a\u0010\n\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00168VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0018R*\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001bj\b\u0012\u0004\u0012\u00020\u0005`\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\t\u001a\u0004\b!\u0010\u0007R\u001c\u0010(\u001a\u0004\u0018\u00010$8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\t\u001a\u0004\b%\u0010&R\u001c\u0010-\u001a\u0004\u0018\u00010)8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\t\u001a\u0004\b*\u0010+R\u001c\u00100\u001a\u0004\u0018\u00010\u00168&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\t\u001a\u0004\b.\u0010\u0018R\u001c\u00103\u001a\u0004\u0018\u00010\u00168&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\t\u001a\u0004\b1\u0010\u0018R\u001c\u00108\u001a\u0004\u0018\u0001048&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010\t\u001a\u0004\b5\u00106R\u001c\u0010=\u001a\u0004\u0018\u0001098&X§\u0004¢\u0006\f\u0012\u0004\b<\u0010\t\u001a\u0004\b:\u0010;R\u001c\u0010B\u001a\u0004\u0018\u00010>8&X§\u0004¢\u0006\f\u0012\u0004\bA\u0010\t\u001a\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/bytedance/android/livesdk/message/linker/h;", "Lvh7/c;", "", "", "checkIsLegal", "", "getScene", "()I", "getScene$annotations", "()V", "scene", "Lcom/bytedance/android/livesdk/message/linker/b;", "getMainAnchorLinkmicInfo", "()Lcom/bytedance/android/livesdk/message/linker/b;", "getMainAnchorLinkmicInfo$annotations", "mainAnchorLinkmicInfo", "getVendor", "getVendor$annotations", Constants.OperatorKey.KEY_VENDOR, "isSupportUpdateLinkType", "()Z", "isSupportUpdateLinkType$annotations", "", "getLiveCoreExtInfo", "()Ljava/lang/String;", "getLiveCoreExtInfo$annotations", "liveCoreExtInfo", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPlayModes", "()Ljava/util/List;", "getPlayModes$annotations", "playModes", "getUiLayout", "getUiLayout$annotations", "uiLayout", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo$annotations", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "getMultiLiveCoreInfo$annotations", "multiLiveCoreInfo", "getFunctionType", "getFunctionType$annotations", "functionType", "getSubRtcExtInfo", "getSubRtcExtInfo$annotations", "subRtcExtInfo", "Lcom/bytedance/android/livesdk/chatroom/model/v;", "getChorusCDNInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/v;", "getChorusCDNInfo$annotations", "chorusCDNInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUIInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUIInfo$annotations", "clientUIInfo", "Lcom/bytedance/android/livesdk/chatroom/model/t;", "getChorusAccompanimentInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/t;", "getChorusAccompanimentInfo$annotations", "chorusAccompanimentInfo", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h extends vh7.c<h> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    boolean checkIsLegal();

    @FieldName(name = "chorus_accompaniment_info")
    t getChorusAccompanimentInfo();

    @FieldName(name = "chorus_cdn_info")
    v getChorusCDNInfo();

    @FieldName(name = "client_ui_info")
    ClientUIInfo getClientUIInfo();

    @FieldName(name = "function_type")
    String getFunctionType();

    @FieldName(name = "live_core_ext_info")
    String getLiveCoreExtInfo();

    @FieldName(name = "main_anchor_linkmic_info")
    b getMainAnchorLinkmicInfo();

    @FieldName(name = "multi_live_core_info")
    u1 getMultiLiveCoreInfo();

    @FieldName(name = "multi_rtc_info")
    v1 getMultiRtcInfo();

    @FieldName(name = "play_modes")
    List<Integer> getPlayModes();

    @FieldName(name = "scene")
    int getScene();

    @FieldName(name = "sub_rtc_ext_info")
    String getSubRtcExtInfo();

    @FieldName(name = "ui_layout")
    int getUiLayout();

    @FieldName(name = Constants.OperatorKey.KEY_VENDOR)
    int getVendor();

    @FieldName(name = "support_update_link_type")
    boolean isSupportUpdateLinkType();
}
