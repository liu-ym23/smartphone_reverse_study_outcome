package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\b\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/a2;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/b2;", "getSetting", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/b2;", "setSetting", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/b2;)V", "getSetting$annotations", "()V", "setting", "", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/n1;", "getUserIdStrToScore", "()Ljava/util/Map;", "getUserIdStrToScore$annotations", "userIdStrToScore", "", "getStatus", "()I", "getStatus$annotations", "status", "", "getCompetitionId", "()J", "getCompetitionId$annotations", "competitionId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a2 extends vh7.c<a2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "competition_id")
    long getCompetitionId();

    @FieldName(name = "setting")
    b2 getSetting();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = "user_id_to_score")
    Map<String, n1> getUserIdStrToScore();

    @FieldName(name = "setting#setter")
    void setSetting(b2 r100);
}
