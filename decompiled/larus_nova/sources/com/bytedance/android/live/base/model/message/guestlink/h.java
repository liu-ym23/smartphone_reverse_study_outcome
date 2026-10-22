package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R>\u0010\f\u001a\u001e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u0002j\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u0001`\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0013\u001a\u00020\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001e\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/h;", "Lvh7/c;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getMatchmakingUsers", "()Ljava/util/List;", "setMatchmakingUsers", "(Ljava/util/List;)V", "getMatchmakingUsers$annotations", "()V", "matchmakingUsers", "", "getUserRole", "()I", "setUserRole", "(I)V", "getUserRole$annotations", "userRole", "", "getCallDuration", "()J", "setCallDuration", "(J)V", "getCallDuration$annotations", "callDuration", "getLinkThreshold", "setLinkThreshold", "getLinkThreshold$annotations", "linkThreshold", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h extends vh7.c<h> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "call_duration")
    long getCallDuration();

    @FieldName(name = "link_threshold")
    long getLinkThreshold();

    @FieldName(name = "matchmaking_users")
    List<IBaseUser> getMatchmakingUsers();

    @FieldName(name = "user_role")
    int getUserRole();

    @FieldName(name = "call_duration#setter")
    void setCallDuration(long r100);

    @FieldName(name = "link_threshold#setter")
    void setLinkThreshold(long r100);

    @FieldName(name = "matchmaking_users#setter")
    void setMatchmakingUsers(List<? extends IBaseUser> r100);

    @FieldName(name = "user_role#setter")
    void setUserRole(int r100);
}
