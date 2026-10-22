package com.bytedance.android.gamecp.host_api.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.gamecp.host_api.model.toolbar.GameUnionType;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.SimpleGameInfo")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b!\u0010\"R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0016\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u0007¨\u0006$"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/j;", "", "", "gameId", "Ljava/lang/String;", "", "gameStage", "I", "mStage", "bizType", "bizId", "bizMode", "bizExtra", "gameAttr", "componentExtra", "", "isIntroducing", "Z", "name", "mGameName", "androidPackageSize", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "promoteInstanceId", "androidPackageName", "", "gameUnionType", "J", "gameCategoryId", "gameTagId", "userGameStats", "omniCooperationType", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class j implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f57396a;

    @SerializedName("android_package_name")
    public String androidPackageName;

    @SerializedName("android_package_size")
    public String androidPackageSize;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f57397b;

    @IgnoreProtoFieldCheck
    @SerializedName("biz_extra")
    public String bizExtra;

    @IgnoreProtoFieldCheck
    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    public String bizId;

    @IgnoreProtoFieldCheck
    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_MODE)
    public String bizMode;

    @IgnoreProtoFieldCheck
    @SerializedName("biz_type")
    public int bizType;

    @IgnoreProtoFieldCheck
    @SerializedName("component_extra")
    public String componentExtra;

    @IgnoreProtoFieldCheck
    @SerializedName("game_attr")
    public String gameAttr;

    @SerializedName("game_category_id")
    public long gameCategoryId;

    @SerializedName("game_id")
    public String gameId;

    @IgnoreProtoFieldCheck
    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_GAME_STAGE)
    protected int gameStage;

    @SerializedName("game_tag_id")
    public long gameTagId;

    @SerializedName("game_union_type")
    public long gameUnionType;

    @IgnoreProtoFieldCheck
    @SerializedName("is_introduce")
    public boolean isIntroducing;

    @IgnoreProtoFieldCheck
    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    protected String mGameName;

    @IgnoreProtoFieldCheck
    @SerializedName("stage")
    protected int mStage;

    @IgnoreProtoFieldCheck
    @SerializedName("name")
    protected String name;

    @IgnoreProtoFieldCheck
    @SerializedName("omni_cooperation_type")
    public int omniCooperationType;

    @IgnoreProtoFieldCheck
    @SerializedName(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID)
    public String promoteInstanceId;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    public List<String> tags;

    @SerializedName("user_game_stats")
    public String userGameStats;

    public static final class a {
    }

    static {
    }

    public final String a() {
        String r100 = this.mGameName;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L12;
        return this.mGameName;
    L12:
        return this.name;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final int b() {
        if (this.mStage < GameStageType.NONE.getType()) goto L6;
        return this.mStage;
    L6:
        return this.gameStage;
    }

    public j() {
        this.f57396a = "";
        this.f57397b = "";
        GameStageType r100 = GameStageType.NONE;
        this.gameStage = r100.getType();
        this.name = "";
        this.mStage = r100.getType();
        this.bizId = "";
        this.bizMode = "";
        this.bizExtra = "";
        this.gameAttr = "";
        this.componentExtra = "";
        this.mGameName = "";
        this.androidPackageSize = "";
        this.tags = new ArrayList();
        this.promoteInstanceId = "";
        this.androidPackageName = "";
        this.gameUnionType = GameUnionType.UNION_GAME.getType();
    }

    public j(am3.g r100) {
        this.tags = new ArrayList();
        this.f57396a = "";
        this.f57397b = "";
        this.gameStage = GameStageType.NONE.getType();
        this.name = "";
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L26;
        switch(r103) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L6;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L9;
            case 19: goto L6;
            case 20: goto L8;
            case 21: goto L7;
            default: goto L6;
        };
    L7:
        this.omniCooperationType = r100.i();
        goto L3
    L8:
        this.userGameStats = am3.h.c(r100);
        goto L3
    L9:
        this.gameUnionType = r100.j();
        r102 = r102 | 2;
        goto L3
    L10:
        this.gameTagId = r100.j();
        goto L3
    L11:
        this.gameCategoryId = r100.j();
        goto L3
    L12:
        this.androidPackageName = am3.h.c(r100);
        goto L3
    L13:
        this.androidPackageSize = am3.h.c(r100);
        goto L3
    L14:
        this.tags.add(am3.h.c(r100));
        goto L3
    L15:
        this.mGameName = am3.h.c(r100);
        goto L3
    L16:
        this.promoteInstanceId = am3.h.c(r100);
        goto L3
    L17:
        this.isIntroducing = am3.h.a(r100);
        goto L3
    L18:
        this.componentExtra = am3.h.c(r100);
        goto L3
    L19:
        this.gameAttr = am3.h.c(r100);
        goto L3
    L20:
        this.bizExtra = am3.h.c(r100);
        goto L3
    L21:
        this.bizMode = am3.h.c(r100);
        goto L3
    L22:
        this.bizId = am3.h.c(r100);
        goto L3
    L23:
        this.bizType = r100.i();
        goto L3
    L24:
        this.mStage = r100.i();
        r102 = r102 | 1;
        goto L3
    L25:
        this.gameId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L26:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L30;
        this.mStage = GameStageType.NONE.getType();
    L30:
        if (this.bizId != null) goto L33;
        this.bizId = "";
    L33:
        if (this.bizMode != null) goto L36;
        this.bizMode = "";
    L36:
        if (this.bizExtra != null) goto L39;
        this.bizExtra = "";
    L39:
        if (this.gameAttr != null) goto L42;
        this.gameAttr = "";
    L42:
        if (this.componentExtra != null) goto L45;
        this.componentExtra = "";
    L45:
        if (this.mGameName != null) goto L48;
        this.mGameName = "";
    L48:
        if (this.androidPackageSize != null) goto L51;
        this.androidPackageSize = "";
    L51:
        if (this.tags.isEmpty() == false) goto L54;
        this.tags = new ArrayList();
    L54:
        if (this.promoteInstanceId != null) goto L57;
        this.promoteInstanceId = "";
    L57:
        if (this.androidPackageName != null) goto L60;
        this.androidPackageName = "";
    L60:
        if ((r102 & 2) != 0) goto L105;
        this.gameUnionType = GameUnionType.UNION_GAME.getType();
        return;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.mGameName = r100;
        this.name = r100;
    }

    public final void d(int r100) {
        this.mStage = r100;
        this.gameStage = r100;
    }
}
