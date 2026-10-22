package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r11.c;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/InteractVoteConfigSerializableObjectImpl;", "Lr11/c;", "", "inviteTimer", "J", "b6", "()J", "", "voteStartAnimUrl", "Ljava/lang/String;", "getVoteStartAnimUrl", "()Ljava/lang/String;", "voteEndWinAnimUrl", "getVoteEndWinAnimUrl", "voteEndLoseAnimUrl", "getVoteEndLoseAnimUrl", "voteEndEvenAnimUrl", "getVoteEndEvenAnimUrl", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractVoteConfigSerializableObjectImpl implements c {

    @SerializedName("invite_timer")
    private final long inviteTimer;

    @SerializedName("vote_end_even_anim_url")
    private final String voteEndEvenAnimUrl;

    @SerializedName("vote_end_lose_anim_url")
    private final String voteEndLoseAnimUrl;

    @SerializedName("vote_end_win_anim_url")
    private final String voteEndWinAnimUrl;

    @SerializedName("vote_start_anim_url")
    private final String voteStartAnimUrl;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/InteractVoteConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(InteractVoteConfigSerializableObjectImpl.class);
        }
    }

    public InteractVoteConfigSerializableObjectImpl() {
        this.inviteTimer = 30;
        int r100 = r41.c.f536017a;
        this.voteStartAnimUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_interact_vote_anim_start.webp";
        this.voteEndWinAnimUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_interact_vote_end_win_anim.webp";
        this.voteEndLoseAnimUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_interact_vote_end_lose_anim.webp";
        this.voteEndEvenAnimUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_interact_vote_end_even_anim.webp";
    }

    @Override // r11.c
    public final long b6() {
        return this.inviteTimer;
    }
}
