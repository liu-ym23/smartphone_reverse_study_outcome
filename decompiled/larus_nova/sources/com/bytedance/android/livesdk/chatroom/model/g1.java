package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0018\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001c\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR$\u0010#\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/g1;", "Lvh7/c;", "", "getControlType", "()I", "setControlType", "(I)V", "getControlType$annotations", "()V", "controlType", "", "getTotalApplyNum", "()J", "setTotalApplyNum", "(J)V", "getTotalApplyNum$annotations", "totalApplyNum", "getTotalLinkedNum", "setTotalLinkedNum", "getTotalLinkedNum$annotations", "totalLinkedNum", "getPaid_count", "setPaid_count", "getPaid_count$annotations", "paid_count", "getLink_duration", "setLink_duration", "getLink_duration$annotations", "link_duration", "Lcom/bytedance/android/livesdk/chatroom/model/u1;", "getUserInfoDuringLinkmic", "()Lcom/bytedance/android/livesdk/chatroom/model/u1;", "setUserInfoDuringLinkmic", "(Lcom/bytedance/android/livesdk/chatroom/model/u1;)V", "getUserInfoDuringLinkmic$annotations", "userInfoDuringLinkmic", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g1 extends vh7.c<g1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "control_type")
    int getControlType();

    @FieldName(name = "link_duration")
    long getLink_duration();

    @FieldName(name = "paid_count")
    long getPaid_count();

    @FieldName(name = "total_apply")
    long getTotalApplyNum();

    @FieldName(name = "total_linked")
    long getTotalLinkedNum();

    @FieldName(name = "userinfo_during_linkmic")
    u1 getUserInfoDuringLinkmic();

    @FieldName(name = "control_type#setter")
    void setControlType(int r100);

    @FieldName(name = "link_duration#setter")
    void setLink_duration(long r100);

    @FieldName(name = "paid_count#setter")
    void setPaid_count(long r100);

    @FieldName(name = "total_apply#setter")
    void setTotalApplyNum(long r100);

    @FieldName(name = "total_linked#setter")
    void setTotalLinkedNum(long r100);

    @FieldName(name = "userinfo_during_linkmic#setter")
    void setUserInfoDuringLinkmic(u1 r100);
}
