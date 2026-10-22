package com.bytedance.android.livesdk.rank.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class d {

    @SerializedName("cards")
    private List<a> cards;

    @SerializedName("total")
    private long total;

    @SerializedName("total_enter_number")
    private long totalEnterNumber;

    public class a {

        @SerializedName("amount")
        private int amount;

        @SerializedName("card_id")
        private long cardId;

        @SerializedName("end_time")
        private long endTime;

        @SerializedName("enter_number")
        private int enterNumber;

        @SerializedName("room_id")
        private long roomId;

        @SerializedName(ILoadStallMonitor.START_TIME)
        private long startTime;

        @SerializedName("status")
        private int status;

        @SerializedName("user_id")
        private long userId;

        public final long a() {
            return this.endTime;
        }

        public final int b() {
            return this.status;
        }
    }

    public d() {
    }

    public final List<a> a() {
        return this.cards;
    }
}
