package com.bytedance.android.live.base.model.user;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R\"\u0010\u0012\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\"\u0010\u0019\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001d\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R:\u0010&\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001ej\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u0001` 8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\t\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010*\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\t\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007R$\u00101\u001a\u0004\u0018\u00010+8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\t\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00105\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b4\u0010\t\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R$\u00109\u001a\u0004\u0018\u00010+8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b8\u0010\t\u001a\u0004\b6\u0010-\"\u0004\b7\u0010/R$\u0010=\u001a\u0004\u0018\u00010+8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b<\u0010\t\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/base/model/user/c0;", "Lvh7/c;", "", "", "getFollowingCount", "()J", "setFollowingCount", "(J)V", "getFollowingCount$annotations", "()V", "followingCount", "getFollowerCount", "setFollowerCount", "getFollowerCount$annotations", "followerCount", "getFollowStatus", "setFollowStatus", "getFollowStatus$annotations", "followStatus", "", "getFollowerCountEnable", "()Z", "setFollowerCountEnable", "(Z)V", "getFollowerCountEnable$annotations", "followerCountEnable", "getJumpFollowerListEnable", "setJumpFollowerListEnable", "getJumpFollowerListEnable$annotations", "jumpFollowerListEnable", "", "Lcom/bytedance/android/live/base/model/user/IMutualFollowUser;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getAccounts", "()Ljava/util/List;", "setAccounts", "(Ljava/util/List;)V", "getAccounts$annotations", "accounts", "getMutualFollowCount", "setMutualFollowCount", "getMutualFollowCount$annotations", "mutualFollowCount", "", "getRemarkName", "()Ljava/lang/String;", "setRemarkName", "(Ljava/lang/String;)V", "getRemarkName$annotations", "remarkName", "getInvalidFollowStatus", "setInvalidFollowStatus", "getInvalidFollowStatus$annotations", "invalidFollowStatus", "getFollowerCountStr", "setFollowerCountStr", "getFollowerCountStr$annotations", "followerCountStr", "getFollowingCountStr", "setFollowingCountStr", "getFollowingCountStr$annotations", "followingCountStr", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c0 extends vh7.c<c0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "accounts")
    List<IMutualFollowUser> getAccounts();

    @FieldName(name = "follow_status")
    long getFollowStatus();

    @FieldName(name = "follower_count")
    long getFollowerCount();

    @FieldName(name = "follower_count_enable")
    boolean getFollowerCountEnable();

    @FieldName(name = "follower_count_str")
    String getFollowerCountStr();

    @FieldName(name = "following_count")
    long getFollowingCount();

    @FieldName(name = "following_count_str")
    String getFollowingCountStr();

    @FieldName(name = "invalid_follow_status")
    boolean getInvalidFollowStatus();

    @FieldName(name = "follower_list_enable")
    boolean getJumpFollowerListEnable();

    @FieldName(name = "mutual_follow_count")
    long getMutualFollowCount();

    /* synthetic */ long getPushStatus();

    @FieldName(name = "remark_name")
    String getRemarkName();

    @FieldName(name = "accounts#setter")
    void setAccounts(List<? extends IMutualFollowUser> r100);

    @FieldName(name = "follow_status#setter")
    void setFollowStatus(long r100);

    @FieldName(name = "follower_count#setter")
    void setFollowerCount(long r100);

    @FieldName(name = "follower_count_enable#setter")
    void setFollowerCountEnable(boolean r100);

    @FieldName(name = "follower_count_str#setter")
    void setFollowerCountStr(String r100);

    @FieldName(name = "following_count#setter")
    void setFollowingCount(long r100);

    @FieldName(name = "following_count_str#setter")
    void setFollowingCountStr(String r100);

    @FieldName(name = "invalid_follow_status#setter")
    void setInvalidFollowStatus(boolean r100);

    @FieldName(name = "follower_list_enable#setter")
    void setJumpFollowerListEnable(boolean r100);

    @FieldName(name = "mutual_follow_count#setter")
    void setMutualFollowCount(long r100);

    @FieldName(name = "remark_name#setter")
    void setRemarkName(String r100);
}
