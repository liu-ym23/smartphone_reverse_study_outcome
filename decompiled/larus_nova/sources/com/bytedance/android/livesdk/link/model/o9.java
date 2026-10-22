package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001d\u0010\u001aR\u001a\u0010$\u001a\u00020 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0007\u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\u00020 8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0007\u001a\u0004\b%\u0010\"R\u001c\u0010,\u001a\u0004\u0018\u00010(8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0007\u001a\u0004\b)\u0010*R.\u00103\u001a\u0016\u0012\u0004\u0012\u00020.\u0018\u00010-j\n\u0012\u0004\u0012\u00020.\u0018\u0001`/8&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0007\u001a\u0004\b0\u00101R\u001a\u00108\u001a\u0002048&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0007\u001a\u0004\b5\u00106R\u001c\u0010;\u001a\u0004\u0018\u00010 8&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0007\u001a\u0004\b9\u0010\"R\u001c\u0010>\u001a\u0004\u0018\u00010 8&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0007\u001a\u0004\b<\u0010\"¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/o9;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/j2;", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo$annotations", "()V", "multiChannelInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo$annotations", "preRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo$annotations", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo$annotations", "multiRtcInfo", "", "getDefaultUILayout", "()I", "getDefaultUILayout$annotations", "defaultUILayout", "getToScene", "getToScene$annotations", "toScene", "", "getLiveCoreExtInfo", "()Ljava/lang/String;", "getLiveCoreExtInfo$annotations", "liveCoreExtInfo", "getRtcExtInfo", "getRtcExtInfo$annotations", "rtcExtInfo", "Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo", "()Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo$annotations", "layoutInfo", "", "Lcom/bytedance/android/livesdk/link/model/p;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkedUsers", "()Ljava/util/List;", "getLinkedUsers$annotations", "linkedUsers", "", "getVersion", "()J", "getVersion$annotations", "version", "getBattleAttachedInfoStr", "getBattleAttachedInfoStr$annotations", "battleAttachedInfoStr", "getEventTrackingInfo", "getEventTrackingInfo$annotations", "eventTrackingInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o9 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.j2>, com.bytedance.android.livesdk.link.model.bridge.j2 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.j2, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.j2, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfoStr();

    @FieldName(name = "anchor_ui_layout")
    int getDefaultUILayout();

    @FieldName(name = "event_tracking_info")
    String getEventTrackingInfo();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "inviter_from_scene")
    /* synthetic */ int getInviterFromScene();

    @FieldName(name = "layout_info")
    m getLayoutInfo();

    @FieldName(name = "linked_users")
    List<p> getLinkedUsers();

    @FieldName(name = "live_core_ext_info")
    String getLiveCoreExtInfo();

    @FieldName(name = "multi_anchor_extra")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.n1 getMultiAnchorExtra();

    @FieldName(name = "multi_channel_info")
    b7 getMultiChannelInfo();

    @FieldName(name = "multi_live_core_info")
    d7 getMultiLiveCoreInfo();

    @FieldName(name = "multi_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo();

    @FieldName(name = "pre_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();

    @FieldName(name = "to_linker_id")
    /* synthetic */ long getToLinkerId();

    @FieldName(name = "scene")
    int getToScene();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "multi_anchor_extra#setter")
    /* synthetic */ void setMultiAnchorExtra(com.bytedance.android.livesdk.link.model.bridge.n1 r100);
}
