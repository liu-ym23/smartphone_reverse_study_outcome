package com.bytedance.android.gamecp.live_impl.message;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.OnLivePromoteMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/message/k;", "", "", "promoteText", "Ljava/lang/String;", "introduceText", "gameIcon", "gameName", "", "bizMode", "J", "gameId", "<init>", "()V", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k implements vh7.h {

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_MODE)
    public long bizMode;

    @SerializedName("game_icon")
    public String gameIcon;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName("introduce_text")
    public String introduceText;

    @SerializedName("promote_text")
    public String promoteText;

    public k() {
        this.promoteText = "";
        this.introduceText = "";
        this.gameIcon = "";
        this.gameName = "";
        this.gameId = "";
    }

    public k(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 2) goto L8;
        this.promoteText = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.introduceText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 5) goto L12;
        this.gameIcon = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 6) goto L14;
        this.gameName = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 7) goto L16;
        this.bizMode = r100.j();
        goto L3
    L16:
        if (r102 != 8) goto L17;
        this.gameId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this.promoteText != null) goto L28;
        this.promoteText = "";
    L28:
        if (this.introduceText != null) goto L31;
        this.introduceText = "";
    L31:
        if (this.gameIcon != null) goto L34;
        this.gameIcon = "";
    L34:
        if (this.gameName != null) goto L37;
        this.gameName = "";
    L37:
        if (this.gameId != null) goto L61;
        this.gameId = "";
        return;
    }
}
