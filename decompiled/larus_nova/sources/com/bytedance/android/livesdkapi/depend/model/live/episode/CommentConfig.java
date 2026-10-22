package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class CommentConfig implements Serializable {
    private static final long serialVersionUID = -5346852879900605232L;

    @SerializedName("comment_colors")
    public List<CommentColor> mCommentColors;

    @SerializedName("comment_medals")
    public List<CommentMedal> mCommentMedals;

    @SerializedName("comment_roles")
    public List<CommentRole> mCommentRoles;

    @SerializedName("medal_title")
    public String mMedalTitle;

    @SerializedName("role_suffix")
    public String mRoleSuffix;

    @SerializedName("role_title")
    public String mRoleTitle;

    @SerializedName("unlock_role_tip")
    public String mUnlockRoleTip;

    public CommentConfig() {
    }
}
