package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/p9;", "Lvh7/c;", "", "getScore", "()J", "setScore", "(J)V", "getScore$annotations", "()V", com.bytedance.android.ec.core.event.a.KEY_SCORE, "", "getEggId", "()Ljava/lang/String;", "setEggId", "(Ljava/lang/String;)V", "getEggId$annotations", "eggId", "getTeamId", "setTeamId", "getTeamId$annotations", "teamId", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p9 extends vh7.c<p9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "egg_id")
    String getEggId();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_SCORE)
    long getScore();

    @FieldName(name = "team_id")
    String getTeamId();

    @FieldName(name = "egg_id#setter")
    void setEggId(String r100);

    @FieldName(name = "score#setter")
    void setScore(long r100);

    @FieldName(name = "team_id#setter")
    void setTeamId(String r100);
}
