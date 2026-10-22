package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class Game {

    @SerializedName("game_id")
    public long gameId;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("name")
    public String name;

    public Game() {
    }

    public String toJsonString() {
        return GsonProtectorUtils.toJson(GsonHelper.get(), this);
    }

    public static Game fromJson(String r100) {
        return (Game) GsonProtectorUtils.fromJson(GsonHelper.get(), r100, Game.class);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
