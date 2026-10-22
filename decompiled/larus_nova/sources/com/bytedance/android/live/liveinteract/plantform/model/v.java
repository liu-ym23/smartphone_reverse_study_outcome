package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface v extends vh7.c<v> {
    public static final int TAG_ECOM_FANS_CLUB = 5;
    public static final int TAG_ECOM_VIEW = 4;
    public static final int TAG_FANS = 3;
    public static final int TAG_FANS_CLUB = 0;
    public static final int TAG_FRIEND = 2;
    public static final int TAG_HONOR_LEVEL = 1;

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "ecom_fans_club_tag")
    w getEcomFansClubTag();

    @FieldName(name = "ecom_view_tag")
    x getEcomViewTag();

    @FieldName(name = "fans_club_tag")
    y getListTagFansClubContent();

    @FieldName(name = "fans_tag")
    z getListTagFansContent();

    @FieldName(name = "friend_tag")
    a0 getListTagFriendContent();

    @FieldName(name = "honor_level_tag")
    b0 getListTagHonorLevelContent();

    @FieldName(name = "list_tag_type")
    int getType();
}
