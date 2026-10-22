package com.bytedance.android.gamecp.business.download.ai;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.gamecp.common.model.GameStageType;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.SimpleGameInfo")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/business/download/ai/y;", "", "", "id", "Ljava/lang/String;", "name", "androidPackageSize", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "androidPackageName", "", "gameStage", "I", "", "gameUnionType", "J", "gameCategoryId", "gameTagId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y implements vh7.h {

    @SerializedName("android_package_name")
    public String androidPackageName;

    @SerializedName("android_package_size")
    public String androidPackageSize;

    @SerializedName("game_category_id")
    public long gameCategoryId;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_GAME_STAGE)
    public int gameStage;

    @SerializedName("game_tag_id")
    public long gameTagId;

    @SerializedName("game_union_type")
    public long gameUnionType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("game_id")
    public String f52530id;

    @SerializedName("name")
    public String name;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    public List<String> tags;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L28;
        y r101 = (y) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f52530id, r101.f52530id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.androidPackageSize, r101.androidPackageSize) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.androidPackageName, r101.androidPackageName) == true) goto L20;
        return false;
    L20:
        if (this.gameStage == r101.gameStage) goto L22;
        return false;
    L22:
        if (this.gameUnionType == r101.gameUnionType) goto L24;
        return false;
    L24:
        if (this.gameCategoryId == r101.gameCategoryId) goto L26;
        return false;
    L26:
        if (this.gameTagId == r101.gameTagId) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f52530id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = (r102 + 0) * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.androidPackageSize;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.tags;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.androidPackageName;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (((r112 + r101) * 31) + this.gameStage) * 31;
        long r115 = this.gameUnionType;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.gameCategoryId;
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        long r119 = this.gameTagId;
        return r118 + ((int) (r119 ^ (r119 >>> 32)));
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SimpleGameInfo(from=null, downloadStatus=null, id=" + this.f52530id + ", name=" + this.name + ", androidPackageSize=" + this.androidPackageSize + ", tags=" + this.tags + ", androidPackageName=" + this.androidPackageName + ", gameStage=" + this.gameStage + ", gameUnionType=" + this.gameUnionType + ", gameCategoryId=" + this.gameCategoryId + ", gameTagId=" + this.gameTagId + ")";
    }

    public y() {
        this.f52530id = "";
        this.name = "";
        this.androidPackageSize = "";
        this.tags = new ArrayList();
        this.androidPackageName = "";
        this.gameStage = GameStageType.NONE.getType();
        this.gameUnionType = GameUnionType.UNION_GAME.getType();
        this.gameCategoryId = 0;
        this.gameTagId = 0;
    }

    public y(am3.g r100) {
        this.tags = new ArrayList();
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L16;
        switch(r103) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L6;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.gameTagId = r100.j();
        r102 = r102 | 8;
        goto L3
    L8:
        this.gameCategoryId = r100.j();
        r102 = r102 | 4;
        goto L3
    L9:
        this.gameUnionType = r100.j();
        r102 = r102 | 2;
        goto L3
    L10:
        this.gameStage = r100.i();
        r102 = r102 | 1;
        goto L3
    L11:
        this.androidPackageName = am3.h.c(r100);
        goto L3
    L12:
        this.androidPackageSize = am3.h.c(r100);
        goto L3
    L13:
        this.tags.add(am3.h.c(r100));
        goto L3
    L14:
        this.name = am3.h.c(r100);
        goto L3
    L15:
        this.f52530id = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
        if (this.f52530id != null) goto L20;
        this.f52530id = "";
    L20:
        if (this.name != null) goto L23;
        this.name = "";
    L23:
        if (this.androidPackageSize != null) goto L26;
        this.androidPackageSize = "";
    L26:
        if (this.tags.isEmpty() == false) goto L29;
        this.tags = new ArrayList();
    L29:
        if (this.androidPackageName != null) goto L32;
        this.androidPackageName = "";
    L32:
        if ((r102 & 1) != 0) goto L35;
        this.gameStage = GameStageType.NONE.getType();
    L35:
        if ((r102 & 2) != 0) goto L38;
        this.gameUnionType = GameUnionType.UNION_GAME.getType();
    L38:
        if ((r102 & 4) != 0) goto L41;
        this.gameCategoryId = 0;
    L41:
        if ((r102 & 8) != 0) goto L66;
        this.gameTagId = 0;
        return;
    }
}
