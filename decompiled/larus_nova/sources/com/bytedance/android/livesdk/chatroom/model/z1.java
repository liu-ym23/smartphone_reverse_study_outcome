package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/z1;", "", "", "replayStatus", "I", "d", "()I", "", "itemId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "replayHit", "c", "episodeId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "replayGid", "getReplayGid", "replaySchema", "getReplaySchema", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z1 {

    @SerializedName("episode_id")
    private final String episodeId;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("replay_gid")
    private final String replayGid;

    @SerializedName("replay_hint")
    private final String replayHit;

    @SerializedName("replay_schema")
    private final String replaySchema;

    @SerializedName("replay_status")
    private final int replayStatus;

    public static final class a {
    }

    static {
    }

    public final String a() {
        return this.episodeId;
    }

    public final String b() {
        return this.itemId;
    }

    public final String c() {
        return this.replayHit;
    }

    public final int d() {
        return this.replayStatus;
    }
}
