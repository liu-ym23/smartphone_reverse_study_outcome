package com.bytedance.android.livesdk.interactivity.comment.audio;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class a {

    @SerializedName("results")
    public List<C2124a> result;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.audio.a$a, reason: collision with other inner class name */
    public static class C2124a {

        @SerializedName("end_time")
        public float endTime;

        @SerializedName("index")
        public int index;

        @SerializedName("is_interim")
        public boolean isInterim;

        @SerializedName(ILoadStallMonitor.START_TIME)
        public float startTime;

        @SerializedName("text")
        public String text;

        public C2124a() {
        }
    }

    public a() {
    }
}
