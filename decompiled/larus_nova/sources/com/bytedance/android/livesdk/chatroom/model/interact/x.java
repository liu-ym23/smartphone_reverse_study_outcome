package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u0004R\"\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/x;", "Lvh7/c;", "", "getRank", "()J", "getRank$annotations", "()V", "rank", "", "getPrompt", "()Ljava/lang/String;", "getPrompt$annotations", EventConstant.Key.RETAIN_PROMPT, "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText$annotations", "displayText", "getTotalCount", "getTotalCount$annotations", "totalCount", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getWaitingUsers", "()Ljava/util/List;", "getWaitingUsers$annotations", "waitingUsers", "Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "getJoinTeamInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "getJoinTeamInfo$annotations", "joinTeamInfo", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface x extends vh7.c<x> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "display_text")
    a5 getDisplayText();

    @FieldName(name = "join_teamfight_info")
    com.bytedance.android.live.liveinteract.plantform.model.j0 getJoinTeamInfo();

    @FieldName(name = EventConstant.Key.RETAIN_PROMPT)
    String getPrompt();

    @FieldName(name = "offset")
    long getRank();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    long getTotalCount();

    @FieldName(name = "waiting_users")
    List<? extends com.bytedance.android.livesdk.link.model.bridge.k> getWaitingUsers();
}
