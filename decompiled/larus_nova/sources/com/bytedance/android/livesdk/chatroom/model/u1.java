package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/u1;", "Lvh7/c;", "", "getAddFollowerCount", "()J", "setAddFollowerCount", "(J)V", "getAddFollowerCount$annotations", "()V", "addFollowerCount", "", "getFanTicket", "()Ljava/lang/String;", "setFanTicket", "(Ljava/lang/String;)V", "getFanTicket$annotations", "fanTicket", "getScoreBeyond", "setScoreBeyond", "getScoreBeyond$annotations", "scoreBeyond", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u1 extends vh7.c<u1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "add_followers_count")
    long getAddFollowerCount();

    @FieldName(name = "add_fan_ticket_str")
    String getFanTicket();

    @FieldName(name = "score_more_than")
    long getScoreBeyond();

    @FieldName(name = "add_followers_count#setter")
    void setAddFollowerCount(long r100);

    @FieldName(name = "add_fan_ticket_str#setter")
    void setFanTicket(String r100);

    @FieldName(name = "score_more_than#setter")
    void setScoreBeyond(long r100);
}
