package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/s6;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "", "getRtcExtInfo", "()Ljava/lang/String;", "getRtcExtInfo$annotations", "()V", "rtcExtInfo", "getLinkMicIdStr", "getLinkMicIdStr$annotations", "linkMicIdStr", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo$annotations", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo$annotations", "multiLiveCoreInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s6 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.j1>, com.bytedance.android.livesdk.link.model.bridge.j1 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.j1, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.j1, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ String getBizTag();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "linkmic_id_str")
    String getLinkMicIdStr();

    /* synthetic */ String getLiveCoreExtInfo();

    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.u1 getMultiLiveCoreInfo();

    @FieldName(name = "multi_live_core_info")
    d7 getMultiLiveCoreInfo();

    @FieldName(name = "multi_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();
}
