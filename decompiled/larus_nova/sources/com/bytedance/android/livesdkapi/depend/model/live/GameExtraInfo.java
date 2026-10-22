package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.GameExtra")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001e\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001e\u0010%\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GameExtraInfo;", "", "()V", "data", "", "", "getData", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "gameId", "", "getGameId", "()J", "setGameId", "(J)V", "gameKind", "", "getGameKind", "()I", "setGameKind", "(I)V", "gift_limit", "getGift_limit", "setGift_limit", "kind", "getKind", "setKind", "loader", "getLoader", "setLoader", "reload", "getReload", "setReload", "roundId", "getRoundId", "setRoundId", "status", "getStatus", "setStatus", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameExtraInfo implements h {
    public static final int AIRDROP_KIND = 2002;
    public static final int CROWD_FUNDING_KIND = 2003;
    public static final Companion Companion = null;
    public static final int OPEN_PLATFORM_GAME_KIND = 6;

    @SerializedName("data")
    protected Map<String, String> data;

    @SerializedName("game_id")
    protected long gameId;

    @SerializedName("game_kind")
    protected int gameKind;

    @SerializedName("gift_limit")
    protected int gift_limit;

    @SerializedName("kind")
    protected int kind;

    @SerializedName("loader")
    protected long loader;

    @SerializedName("reload")
    protected long reload;

    @SerializedName("round_id")
    protected long roundId;

    @SerializedName("status")
    protected int status;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GameExtraInfo$Companion;", "", "()V", "AIRDROP_KIND", "", "CROWD_FUNDING_KIND", "OPEN_PLATFORM_GAME_KIND", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GameExtraInfo() {
    }

    public final Map<String, String> getData() {
        return this.data;
    }

    public final long getGameId() {
        return this.gameId;
    }

    public final int getGameKind() {
        return this.gameKind;
    }

    public final int getGift_limit() {
        return this.gift_limit;
    }

    public final int getKind() {
        return this.kind;
    }

    public final long getLoader() {
        return this.loader;
    }

    public final long getReload() {
        return this.reload;
    }

    public final long getRoundId() {
        return this.roundId;
    }

    public final int getStatus() {
        return this.status;
    }

    public GameExtraInfo(g r110) {
        this.data = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        switch(r101) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L6;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L8:
        int r105 = r110.f();
        if (r105 == (-1)) goto L17;
        if (r105 != 1) goto L13;
        r103 = am3.h.c(r110);
        goto L8
    L13:
        if (r105 != 2) goto L14;
        r104 = am3.h.c(r110);
        goto L8
    L14:
        am3.h.e(r110);
        goto L8
    L17:
        r110.d(r102);
        Map<String, String> r106 = this.data;
        if (r103 == null) goto L24;
        if (r104 == null) goto L22;
        r106.put(r103, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.reload = r110.j();
        goto L3
    L26:
        this.loader = r110.j();
        goto L3
    L27:
        this.gameKind = r110.i();
        goto L3
    L28:
        this.roundId = r110.j();
        goto L3
    L29:
        this.gift_limit = r110.i();
        goto L3
    L30:
        this.gameId = r110.j();
        goto L3
    L31:
        this.status = r110.i();
        goto L3
    L32:
        this.kind = r110.i();
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L33:
        r110.d(r100);
    }

    public final void setData(Map<String, String> r100) {
        this.data = r100;
    }

    public final void setGameId(long r100) {
        this.gameId = r100;
    }

    public final void setGameKind(int r100) {
        this.gameKind = r100;
    }

    public final void setGift_limit(int r100) {
        this.gift_limit = r100;
    }

    public final void setKind(int r100) {
        this.kind = r100;
    }

    public final void setLoader(long r100) {
        this.loader = r100;
    }

    public final void setReload(long r100) {
        this.reload = r100;
    }

    public final void setRoundId(long r100) {
        this.roundId = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }
}
