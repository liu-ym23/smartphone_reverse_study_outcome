package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
public class CommentRole implements Serializable {
    private static final long serialVersionUID = -6815496811374478842L;

    @SerializedName("avatar")
    public k mRoleCharactor;

    @SerializedName("role_id")
    public long mRoleId;

    @SerializedName("name")
    public String mRoleName;

    public CommentRole() {
    }
}
