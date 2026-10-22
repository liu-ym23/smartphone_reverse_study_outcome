package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/OpenPkPanelSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "guideType", "", "watchUv", "", "toUserGroup", "page", "tabType", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getGuideType", "()Ljava/lang/String;", "getPage", "getTabType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getToUserGroup", "getWatchUv", "()I", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPkPanelSchemaModel extends BaseSchemaModel {

    @SerializedName("guide_type")
    private final String guideType;

    @SerializedName("page")
    private final String page;

    @SerializedName("tab_type")
    private final Integer tabType;

    @SerializedName("to_user_group")
    private final String toUserGroup;

    @SerializedName("watch_uv")
    private final int watchUv;

    public OpenPkPanelSchemaModel() {
        this(null, 0, null, null, null, 31, null);
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.OPEN_PK_PANEL;
    }

    public final String getGuideType() {
        return this.guideType;
    }

    public final String getPage() {
        return this.page;
    }

    public final Integer getTabType() {
        return this.tabType;
    }

    public final String getToUserGroup() {
        return this.toUserGroup;
    }

    public final int getWatchUv() {
        return this.watchUv;
    }

    public OpenPkPanelSchemaModel(String r100, int r101, String r102, String r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "guideType");
        Intrinsics.checkNotNullParameter(r102, "toUserGroup");
        Intrinsics.checkNotNullParameter(r103, "page");
        this.guideType = r100;
        this.watchUv = r101;
        this.toUserGroup = r102;
        this.page = r103;
        this.tabType = r104;
    }

    public /* synthetic */ OpenPkPanelSchemaModel(String r100, int r101, String r102, String r103, Integer r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) == 0) goto L9;
        int r107 = 0;
    L11:
        if ((r105 & 4) == 0) goto L13;
        String r108 = "";
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        r104 = null;
    L21:
        Integer r109 = r104;
        this(r111, r107, r108, r106, r109);
        return;
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
