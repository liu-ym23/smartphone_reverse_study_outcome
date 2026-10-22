package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class ChannelInviteMessageItem {
    public static final int TYPE_GROUP = 2;
    public static final int TYPE_USER = 1;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public long f132927id;

    @SerializedName("name")
    public String name;

    @SerializedName("type")
    public int type;

    public ChannelInviteMessageItem() {
    }
}
