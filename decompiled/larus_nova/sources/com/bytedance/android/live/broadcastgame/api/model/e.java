package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.game.api.EntranceResponse.EntranceItem")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR$\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\"\u0010$\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/e;", "", "", "interactId", "J", "b", "()J", "setInteractId", "(J)V", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "iconUrls", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setIconUrls", "(Ljava/util/List;)V", "", "rank", "I", "getRank", "()I", "setRank", "(I)V", "groupType", "getGroupType", "setGroupType", "extra", "getExtra", "setExtra", "supportPlayers", "getSupportPlayers", "setSupportPlayers", "supportLiveModeList", "getSupportLiveModeList", "setSupportLiveModeList", "supportLiveEntranceList", "getSupportLiveEntranceList", "setSupportLiveEntranceList", "<init>", "()V", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e implements vh7.h {

    @SerializedName("extra")
    protected String extra;

    @SerializedName("group_type")
    protected long groupType;

    @SerializedName("icon_url")
    protected List<String> iconUrls;

    @SerializedName("interact_id")
    protected long interactId;

    @SerializedName("name")
    protected String name;

    @SerializedName("rank")
    protected int rank;

    @SerializedName("support_live_entrance_list")
    protected List<Long> supportLiveEntranceList;

    @SerializedName("support_live_mode_list")
    protected List<Long> supportLiveModeList;

    @SerializedName("support_players")
    protected int supportPlayers;

    public e() {
        this.iconUrls = new ArrayList();
        this.supportLiveModeList = new ArrayList();
        this.supportLiveEntranceList = new ArrayList();
    }

    public final List<String> a() {
        return this.iconUrls;
    }

    public final long b() {
        return this.interactId;
    }

    public final String c() {
        return this.name;
    }

    public e(am3.g r100) {
        this.iconUrls = new ArrayList();
        this.supportLiveModeList = new ArrayList();
        this.supportLiveEntranceList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        List r103 = this.supportLiveEntranceList;
    L9:
        Comparable r104 = Long.valueOf(r100.j());
    L15:
        r103.add(r104);
        goto L3
    L8:
        r103 = this.supportLiveModeList;
        goto L9
    L10:
        this.supportPlayers = (int) r100.j();
        goto L3
    L11:
        this.extra = am3.h.c(r100);
        goto L3
    L12:
        this.groupType = r100.j();
        goto L3
    L13:
        this.rank = (int) r100.j();
        goto L3
    L14:
        r103 = this.iconUrls;
        r104 = am3.h.c(r100);
        goto L15
    L16:
        this.name = am3.h.c(r100);
        goto L3
    L17:
        this.interactId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.iconUrls.isEmpty() == false) goto L22;
        this.iconUrls = new ArrayList();
    L22:
        if (this.supportLiveModeList.isEmpty() == false) goto L25;
        this.supportLiveModeList = new ArrayList();
    L25:
        if (this.supportLiveEntranceList.isEmpty() == false) goto L48;
        this.supportLiveEntranceList = new ArrayList();
        return;
    }
}
