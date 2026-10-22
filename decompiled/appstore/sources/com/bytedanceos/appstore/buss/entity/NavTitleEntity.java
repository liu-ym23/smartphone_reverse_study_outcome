package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010!\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u000fHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\u009f\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u0010@\u001a\u00020\u000f2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\u0006\u0010C\u001a\u00020\u0003J\u0006\u0010D\u001a\u00020\u0003J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u0012\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0016¨\u0006G"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/NavTitleEntity;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "jsonType", "", "apiType", "", "title", "source", "page", "page_id", "size", ServerElements.LAST_APP_ID, "type", "cid", "selected", "", "iconNormalId", "iconPressId", "showCount", "appCount", "(ILjava/lang/String;Ljava/lang/String;IIIIILjava/lang/String;IZLjava/lang/String;Ljava/lang/String;ZI)V", "getApiType", "()Ljava/lang/String;", "getAppCount", "()I", "setAppCount", "(I)V", "childNode", "", "getChildNode", "()Ljava/util/List;", "getCid", "getIconNormalId", "getIconPressId", "getJsonType", "getLastId", "getPage", "getPage_id", "getSelected", "()Z", "setSelected", "(Z)V", "getShowCount", "setShowCount", "getSize", "getSource", "getTitle", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getNormalId", "getPressId", "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NavTitleEntity extends BaseNode {

    @NotNull
    private final String apiType;
    private int appCount;
    private final int cid;

    @NotNull
    private final String iconNormalId;

    @NotNull
    private final String iconPressId;
    private final int jsonType;
    private final int lastId;
    private final int page;
    private final int page_id;
    private boolean selected;
    private boolean showCount;
    private final int size;
    private final int source;

    @NotNull
    private final String title;

    @NotNull
    private final String type;

    public NavTitleEntity(int r10, @NotNull String r11, @NotNull String r12, int r13, int r14, int r15, int r16, int r17, @NotNull String r18, int r19, boolean r110, @NotNull String r111, @NotNull String r20, boolean r21, int r22) {
        q.g(r11, "apiType");
        q.g(r12, "title");
        q.g(r18, "type");
        q.g(r111, "iconNormalId");
        q.g(r20, "iconPressId");
        this.jsonType = r10;
        this.apiType = r11;
        this.title = r12;
        this.source = r13;
        this.page = r14;
        this.page_id = r15;
        this.size = r16;
        this.lastId = r17;
        this.type = r18;
        this.cid = r19;
        this.selected = r110;
        this.iconNormalId = r111;
        this.iconPressId = r20;
        this.showCount = r21;
        this.appCount = r22;
    }

    public static /* synthetic */ NavTitleEntity copy$default(NavTitleEntity r16, int r17, String r18, String r19, int r20, int r21, int r22, int r23, int r24, String r25, int r26, boolean r27, String r28, String r29, boolean r30, int r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        int r10 = r16.jsonType;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r11 = r16.apiType;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r12 = r16.title;
    L15:
        if ((r32 & 8) == 0) goto L17;
        int r13 = r16.source;
    L19:
        if ((r32 & 16) == 0) goto L21;
        int r14 = r16.page;
    L23:
        if ((r32 & 32) == 0) goto L25;
        int r15 = r16.page_id;
    L27:
        if ((r32 & 64) == 0) goto L29;
        int r34 = r16.size;
    L31:
        if ((r32 & 128) == 0) goto L33;
        int r35 = r16.lastId;
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r110 = r16.type;
    L39:
        if ((r32 & 512) == 0) goto L41;
        int r111 = r16.cid;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        boolean r112 = r16.selected;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        String r113 = r16.iconNormalId;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        String r114 = r16.iconPressId;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        boolean r115 = r16.showCount;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        int r36 = r16.appCount;
    L63:
        return r16.copy(r10, r11, r12, r13, r14, r15, r34, r35, r110, r111, r112, r113, r114, r115, r36);
    L61:
        r36 = r31;
        goto L63
    L57:
        r115 = r30;
        goto L59
    L53:
        r114 = r29;
        goto L55
    L49:
        r113 = r28;
        goto L51
    L45:
        r112 = r27;
        goto L47
    L41:
        r111 = r26;
        goto L43
    L37:
        r110 = r25;
        goto L39
    L33:
        r35 = r24;
        goto L35
    L29:
        r34 = r23;
        goto L31
    L25:
        r15 = r22;
        goto L27
    L21:
        r14 = r21;
        goto L23
    L17:
        r13 = r20;
        goto L19
    L13:
        r12 = r19;
        goto L15
    L9:
        r11 = r18;
        goto L11
    L5:
        r10 = r17;
        goto L7
    }

    public final int component1() {
        return this.jsonType;
    }

    public final int component10() {
        return this.cid;
    }

    public final boolean component11() {
        return this.selected;
    }

    @NotNull
    public final String component12() {
        return this.iconNormalId;
    }

    @NotNull
    public final String component13() {
        return this.iconPressId;
    }

    public final boolean component14() {
        return this.showCount;
    }

    public final int component15() {
        return this.appCount;
    }

    @NotNull
    public final String component2() {
        return this.apiType;
    }

    @NotNull
    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.source;
    }

    public final int component5() {
        return this.page;
    }

    public final int component6() {
        return this.page_id;
    }

    public final int component7() {
        return this.size;
    }

    public final int component8() {
        return this.lastId;
    }

    @NotNull
    public final String component9() {
        return this.type;
    }

    @NotNull
    public final NavTitleEntity copy(int r18, @NotNull String r19, @NotNull String r20, int r21, int r22, int r23, int r24, int r25, @NotNull String r26, int r27, boolean r28, @NotNull String r29, @NotNull String r30, boolean r31, int r32) {
        q.g(r19, "apiType");
        q.g(r20, "title");
        q.g(r26, "type");
        q.g(r29, "iconNormalId");
        q.g(r30, "iconPressId");
        return new NavTitleEntity(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof NavTitleEntity) == true) goto L8;
        return false;
    L8:
        NavTitleEntity r11 = (NavTitleEntity) r10;
        if (this.jsonType == r11.jsonType) goto L12;
        return false;
    L12:
        if (q.b(this.apiType, r11.apiType) == true) goto L15;
        return false;
    L15:
        if (q.b(this.title, r11.title) == true) goto L18;
        return false;
    L18:
        if (this.source == r11.source) goto L21;
        return false;
    L21:
        if (this.page == r11.page) goto L24;
        return false;
    L24:
        if (this.page_id == r11.page_id) goto L27;
        return false;
    L27:
        if (this.size == r11.size) goto L30;
        return false;
    L30:
        if (this.lastId == r11.lastId) goto L33;
        return false;
    L33:
        if (q.b(this.type, r11.type) == true) goto L36;
        return false;
    L36:
        if (this.cid == r11.cid) goto L39;
        return false;
    L39:
        if (this.selected == r11.selected) goto L42;
        return false;
    L42:
        if (q.b(this.iconNormalId, r11.iconNormalId) == true) goto L45;
        return false;
    L45:
        if (q.b(this.iconPressId, r11.iconPressId) == true) goto L48;
        return false;
    L48:
        if (this.showCount == r11.showCount) goto L51;
        return false;
    L51:
        if (this.appCount == r11.appCount) goto L53;
        return false;
    L53:
        return true;
    }

    @NotNull
    public final String getApiType() {
        return this.apiType;
    }

    public final int getAppCount() {
        return this.appCount;
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        return null;
    }

    public final int getCid() {
        return this.cid;
    }

    @NotNull
    public final String getIconNormalId() {
        return this.iconNormalId;
    }

    @NotNull
    public final String getIconPressId() {
        return this.iconPressId;
    }

    public final int getJsonType() {
        return this.jsonType;
    }

    public final int getLastId() {
        return this.lastId;
    }

    public final int getNormalId() {
        return BaseApplication.c().getResources().getIdentifier(this.iconNormalId, "drawable", "com.obric.appstore");
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPage_id() {
        return this.page_id;
    }

    public final int getPressId() {
        return BaseApplication.c().getResources().getIdentifier(this.iconPressId, "drawable", "com.obric.appstore");
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final boolean getShowCount() {
        return this.showCount;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getSource() {
        return this.source;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((Integer.hashCode(this.jsonType) * 31) + this.apiType.hashCode()) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.source)) * 31) + Integer.hashCode(this.page)) * 31) + Integer.hashCode(this.page_id)) * 31) + Integer.hashCode(this.size)) * 31) + Integer.hashCode(this.lastId)) * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.cid)) * 31) + Boolean.hashCode(this.selected)) * 31) + this.iconNormalId.hashCode()) * 31) + this.iconPressId.hashCode()) * 31) + Boolean.hashCode(this.showCount)) * 31) + Integer.hashCode(this.appCount);
    }

    public final void setAppCount(int r10) {
        this.appCount = r10;
    }

    public final void setSelected(boolean r10) {
        this.selected = r10;
    }

    public final void setShowCount(boolean r10) {
        this.showCount = r10;
    }

    @NotNull
    public String toString() {
        return "NavTitleEntity(jsonType=" + this.jsonType + ", apiType=" + this.apiType + ", title=" + this.title + ", source=" + this.source + ", page=" + this.page + ", page_id=" + this.page_id + ", size=" + this.size + ", lastId=" + this.lastId + ", type=" + this.type + ", cid=" + this.cid + ", selected=" + this.selected + ", iconNormalId=" + this.iconNormalId + ", iconPressId=" + this.iconPressId + ", showCount=" + this.showCount + ", appCount=" + this.appCount + ')';
    }
}
