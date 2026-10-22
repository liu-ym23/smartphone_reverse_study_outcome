package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class HonorWallUi {
    public static final int dressup = 5;
    public static final int fansClub = 2;
    public static final int giftExhibition = 3;
    public static final int ktv = 8;
    public static final int level = 1;
    public static final int shopFansClub = 6;
    public static final int subscribeVIP = 4;

    @SerializedName("bgs")
    public Map<Integer, HonorWallBg> bgs;

    public static class HonorWallBg {

        @SerializedName("gradient_end")
        public String gradientEnd;

        @SerializedName("gradient_start")
        public String gradientStart;

        @SerializedName("icon")
        public py.k icon;

        public HonorWallBg() {
        }
    }

    public HonorWallUi() {
    }
}
