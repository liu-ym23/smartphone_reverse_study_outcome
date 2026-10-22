package com.bytedance.android.gamecp.host_api.model.toolbar;

import am3.g;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.SimpleGameInfo")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/toolbar/a;", "", "", "gameId", "Ljava/lang/String;", "", "stage", "I", "bizType", "bizId", "bizMode", "bizExtra", "gameAttr", "componentExtra", "", "isIntroducing", "Z", "gameName", "androidPackageSize", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "androidPackageName", "", "gameUnionType", "J", "gameCategoryId", "gameTagId", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("android_package_name")
    public String androidPackageName;

    @SerializedName("android_package_size")
    public String androidPackageSize;

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

    @SerializedName("game_category_id")
    public long gameCategoryId;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName("game_tag_id")
    public long gameTagId;

    @SerializedName("game_union_type")
    public long gameUnionType;

    @SerializedName("is_introduce")
    public boolean isIntroducing;

    @SerializedName("stage")
    public int stage;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    public List<String> tags;

    public a() {
        this.bizId = "";
        this.bizMode = "";
        this.bizExtra = "";
        this.gameAttr = "";
        this.componentExtra = "";
        this.gameName = "";
        this.androidPackageSize = "";
        this.tags = new ArrayList();
        this.androidPackageName = "";
        this.gameUnionType = GameUnionType.UNION_GAME.getType();
    }

    public a(g r100) {
        this.tags = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L23;
        switch(r103) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L6;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L6;
            case 14: goto L11;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L8;
            case 18: goto L7;
            default: goto L6;
        };
    L7:
        this.gameUnionType = r100.j();
        r102 = r102 | true;
        goto L3
    L8:
        this.gameTagId = r100.j();
        goto L3
    L9:
        this.gameCategoryId = r100.j();
        goto L3
    L10:
        this.androidPackageName = am3.h.c(r100);
        goto L3
    L11:
        this.androidPackageSize = am3.h.c(r100);
        goto L3
    L12:
        this.tags.add(am3.h.c(r100));
        goto L3
    L13:
        this.gameName = am3.h.c(r100);
        goto L3
    L14:
        this.isIntroducing = am3.h.a(r100);
        goto L3
    L15:
        this.componentExtra = am3.h.c(r100);
        goto L3
    L16:
        this.gameAttr = am3.h.c(r100);
        goto L3
    L17:
        this.bizExtra = am3.h.c(r100);
        goto L3
    L18:
        this.bizMode = am3.h.c(r100);
        goto L3
    L19:
        this.bizId = am3.h.c(r100);
        goto L3
    L20:
        this.bizType = r100.i();
        goto L3
    L21:
        this.stage = r100.i();
        goto L3
    L22:
        this.gameId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L23:
        r100.d(r101);
        if (this.bizId != null) goto L27;
        this.bizId = "";
    L27:
        if (this.bizMode != null) goto L30;
        this.bizMode = "";
    L30:
        if (this.bizExtra != null) goto L33;
        this.bizExtra = "";
    L33:
        if (this.gameAttr != null) goto L36;
        this.gameAttr = "";
    L36:
        if (this.componentExtra != null) goto L39;
        this.componentExtra = "";
    L39:
        if (this.gameName != null) goto L42;
        this.gameName = "";
    L42:
        if (this.androidPackageSize != null) goto L45;
        this.androidPackageSize = "";
    L45:
        if (this.tags.isEmpty() == false) goto L48;
        this.tags = new ArrayList();
    L48:
        if (this.androidPackageName != null) goto L51;
        this.androidPackageName = "";
    L51:
        if ((r102 & true) == true) goto L90;
        this.gameUnionType = GameUnionType.UNION_GAME.getType();
        return;
    }
}
