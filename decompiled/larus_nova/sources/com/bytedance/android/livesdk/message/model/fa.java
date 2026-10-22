package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H&R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/fa;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/n1;", "getChangeUserScore", "Lcom/bytedance/android/livesdk/chatroom/model/interact/a2;", "getInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/a2;", "getInfo$annotations", "()V", "info", "", "getScoreChangeUserIdStr", "()Ljava/lang/String;", "getScoreChangeUserIdStr$annotations", "scoreChangeUserIdStr", "Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "getQuickInteract", "()Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "getQuickInteract$annotations", "quickInteract", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface fa extends vh7.c<fa> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    com.bytedance.android.livesdk.chatroom.model.interact.n1 getChangeUserScore();

    @FieldName(name = "info")
    com.bytedance.android.livesdk.chatroom.model.interact.a2 getInfo();

    @FieldName(name = "quick_interact")
    com.bytedance.android.live.liveinteract.plantform.model.l getQuickInteract();

    @FieldName(name = "score_change_user_id")
    String getScoreChangeUserIdStr();
}
