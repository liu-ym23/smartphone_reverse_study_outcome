package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.SimpleGameInfo")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/hl;", "", "", "gameId", "Ljava/lang/String;", "", "stage", "I", "bizType", "bizId", "bizMode", "bizExtra", "gameAttr", "gameName", "componentExtra", "", "isIntroducing", "Z", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hl implements vh7.h {

    @SerializedName("biz_extra")
    public String bizExtra;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    public String bizId;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_MODE)
    public String bizMode;

    @SerializedName("biz_type")
    public int bizType;

    @SerializedName("component_extra")
    public String componentExtra;

    @SerializedName("game_attr")
    public String gameAttr;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName("is_introduce")
    public boolean isIntroducing;

    @SerializedName("stage")
    public int stage;

    public hl() {
        this.bizType = -1;
        this.bizId = "";
        this.bizMode = "";
        this.bizExtra = "";
        this.gameAttr = "";
        this.gameName = "";
        this.componentExtra = "";
    }

    public hl(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        switch(r103) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L6;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        this.gameName = am3.h.c(r100);
        goto L3
    L8:
        this.isIntroducing = am3.h.a(r100);
        goto L3
    L9:
        this.componentExtra = am3.h.c(r100);
        goto L3
    L10:
        this.gameAttr = am3.h.c(r100);
        goto L3
    L11:
        this.bizExtra = am3.h.c(r100);
        goto L3
    L12:
        this.bizMode = am3.h.c(r100);
        goto L3
    L13:
        this.bizId = am3.h.c(r100);
        goto L3
    L14:
        this.bizType = r100.i();
        r102 = r102 | true;
        goto L3
    L15:
        this.stage = r100.i();
        goto L3
    L16:
        this.gameId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if ((r102 & true) == true) goto L21;
        this.bizType = -1;
    L21:
        if (this.bizId != null) goto L24;
        this.bizId = "";
    L24:
        if (this.bizMode != null) goto L27;
        this.bizMode = "";
    L27:
        if (this.bizExtra != null) goto L30;
        this.bizExtra = "";
    L30:
        if (this.gameAttr != null) goto L33;
        this.gameAttr = "";
    L33:
        if (this.gameName != null) goto L36;
        this.gameName = "";
    L36:
        if (this.componentExtra != null) goto L63;
        this.componentExtra = "";
        return;
    }
}
