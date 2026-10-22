package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/y9;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;", "getNormalPaidLinkmicInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;", "getNormalPaidLinkmicInfo$annotations", "()V", "normalPaidLinkmicInfo", "", "getWaitingUserNeedLeave", "()Ljava/lang/Boolean;", "getWaitingUserNeedLeave$annotations", "waitingUserNeedLeave", "", "getWaitingUserToast", "()Ljava/lang/String;", "getWaitingUserToast$annotations", "waitingUserToast", "", "getOpenSource", "()I", "getOpenSource$annotations", "openSource", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y9 extends vh7.c<y9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "normal_paid_linkmic_info")
    com.bytedance.android.livesdk.chatroom.model.interact.c1 getNormalPaidLinkmicInfo();

    @FieldName(name = "source")
    int getOpenSource();

    @FieldName(name = "waiting_user_need_leave")
    Boolean getWaitingUserNeedLeave();

    @FieldName(name = "waiting_user_toast")
    String getWaitingUserToast();
}
