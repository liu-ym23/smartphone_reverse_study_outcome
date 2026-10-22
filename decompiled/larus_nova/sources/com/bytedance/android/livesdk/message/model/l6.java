package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/l6;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getAssetId", "()J", "getAssetId$annotations", "()V", "assetId", "getPriority", "getPriority$annotations", "priority", "", "getScene", "()Ljava/lang/String;", "getScene$annotations", "scene", "", "getAction", "()I", "getAction$annotations", "action", "getEndTime", "getEndTime$annotations", "endTime", "getActivityInformation", "getActivityInformation$annotations", "activityInformation", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l6 extends vh7.c<l6>, yh6.c {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "action")
    int getAction();

    @FieldName(name = "actvity_information")
    String getActivityInformation();

    @FieldName(name = "asset_id")
    long getAssetId();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "end_time")
    long getEndTime();

    @FieldName(name = "priority")
    long getPriority();

    @FieldName(name = "scene")
    String getScene();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
