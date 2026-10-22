package com.bytedanceos.appstore.buss.beta.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.obric.capabilitykit.common.UiType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010!\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0095\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0016J\t\u00109\u001a\u00020\u0004HÆ\u0003J\t\u0010:\u001a\u00020\u0004HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010A\u001a\u00020\u0004HÆ\u0003J\t\u0010B\u001a\u00020\u0004HÆ\u0003J\t\u0010C\u001a\u00020\bHÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003J\t\u0010E\u001a\u00020\bHÆ\u0003J\t\u0010F\u001a\u00020\fHÆ\u0003J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\t\u0010H\u001a\u00020\fHÆ\u0003Jº\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010JJ\t\u0010K\u001a\u00020\u0004HÖ\u0001J\u0013\u0010L\u001a\u00020\f2\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020\u0004HÖ\u0001J\t\u0010P\u001a\u00020\bHÖ\u0001J\u0019\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010!\"\u0004\b*\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010.R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b/\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u000e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b6\u0010\u001eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0018R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0018¨\u0006V"}, d2 = {"Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "Landroid/os/Parcelable;", ServerElements.GROUP_ID, "", "id", "jsonType", "apiType", "", "title", "iconId", "selected", "", "navPosition", "showCount", "countNum", "pageIdentity", "pageSource", "source", "cid", "type", "page_id", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getApiType", "()Ljava/lang/String;", "childNode", "", "getChildNode", "()Ljava/util/List;", "getCid", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCountNum", "()I", "setCountNum", "(I)V", "getGroup_id", "setGroup_id", "getIconId", "getId", "getJsonType", "getNavPosition", "setNavPosition", "getPageIdentity", "getPageSource", "setPageSource", "(Ljava/lang/String;)V", "getPage_id", "getSelected", "()Z", "setSelected", "(Z)V", "getShowCount", "setShowCount", "getSource", "getTitle", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;", "describeContents", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BetaNavTitleEntity extends BaseNode implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BetaNavTitleEntity> CREATOR = null;

    @NotNull
    private final String apiType;

    @Nullable
    private final Integer cid;
    private int countNum;
    private int group_id;

    @NotNull
    private final String iconId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f8405id;
    private final int jsonType;
    private int navPosition;

    @Nullable
    private final String pageIdentity;

    @Nullable
    private String pageSource;

    @Nullable
    private final Integer page_id;
    private boolean selected;
    private boolean showCount;

    @Nullable
    private final Integer source;

    @NotNull
    private final String title;

    @Nullable
    private final String type;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BetaNavTitleEntity> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BetaNavTitleEntity createFromParcel(@NotNull Parcel r21) {
            q.g(r21, "parcel");
            int r10 = r21.readInt();
            int r11 = r21.readInt();
            int r12 = r21.readInt();
            String r13 = r21.readString();
            String r14 = r21.readString();
            String r15 = r21.readString();
            boolean r16 = true;
            if (r21.readInt() == 0) goto L5;
            boolean r17 = true;
        L6:
            int r18 = r21.readInt();
            if (r21.readInt() != 0) goto L10;
            r16 = false;
        L10:
            int r19 = r21.readInt();
            String r110 = r21.readString();
            String r111 = r21.readString();
            if (r21.readInt() != 0) goto L13;
            Integer r112 = null;
        L15:
            if (r21.readInt() != 0) goto L17;
            Integer r113 = null;
        L18:
            String r114 = r21.readString();
            if (r21.readInt() != 0) goto L21;
            Integer r115 = null;
        L23:
            return new BetaNavTitleEntity(r10, r11, r12, r13, r14, r15, r17, r18, r16, r19, r110, r111, r112, r113, r114, r115);
        L21:
            r115 = Integer.valueOf(r21.readInt());
            goto L23
        L17:
            r113 = Integer.valueOf(r21.readInt());
            goto L18
        L13:
            r112 = Integer.valueOf(r21.readInt());
            goto L15
        L5:
            r17 = false;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BetaNavTitleEntity[] newArray(int r10) {
            return new BetaNavTitleEntity[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BetaNavTitleEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BetaNavTitleEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public /* synthetic */ BetaNavTitleEntity(int r21, int r22, int r23, String r24, String r25, String r26, boolean r27, int r28, boolean r29, int r30, String r31, String r32, Integer r33, Integer r34, String r35, Integer r36, int r37, DefaultConstructorMarker r38) {
        if ((r37 & 256) == 0) goto L5;
        boolean r12 = false;
    L7:
        if ((r37 & 512) == 0) goto L9;
        int r13 = 0;
    L10:
        this(r21, r22, r23, r24, r25, r26, r27, r28, r12, r13, r31, r32, r33, r34, r35, r36);
        return;
    L9:
        r13 = r30;
        goto L10
    L5:
        r12 = r29;
        goto L7
    }

    public static /* synthetic */ BetaNavTitleEntity copy$default(BetaNavTitleEntity r17, int r18, int r19, int r20, String r21, String r22, String r23, boolean r24, int r25, boolean r26, int r27, String r28, String r29, Integer r30, Integer r31, String r32, Integer r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        int r10 = r17.group_id;
    L7:
        if ((r34 & 2) == 0) goto L9;
        int r11 = r17.f8405id;
    L11:
        if ((r34 & 4) == 0) goto L13;
        int r12 = r17.jsonType;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r13 = r17.apiType;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r14 = r17.title;
    L23:
        if ((r34 & 32) == 0) goto L25;
        String r15 = r17.iconId;
    L27:
        if ((r34 & 64) == 0) goto L29;
        boolean r16 = r17.selected;
    L31:
        if ((r34 & 128) == 0) goto L33;
        int r36 = r17.navPosition;
    L35:
        if ((r34 & 256) == 0) goto L37;
        boolean r110 = r17.showCount;
    L39:
        if ((r34 & 512) == 0) goto L41;
        int r111 = r17.countNum;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r112 = r17.pageIdentity;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r113 = r17.pageSource;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        Integer r114 = r17.source;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        Integer r115 = r17.cid;
    L58:
        Integer r37 = r115;
        if ((r34 & 16384) == 0) goto L61;
        String r116 = r17.type;
    L63:
        if ((r34 & UiType.FLAG_SETTINGS_CARD) == 0) goto L65;
        Integer r38 = r17.page_id;
    L67:
        return r17.copy(r10, r11, r12, r13, r14, r15, r16, r36, r110, r111, r112, r113, r114, r37, r116, r38);
    L65:
        r38 = r33;
        goto L67
    L61:
        r116 = r32;
        goto L63
    L57:
        r115 = r31;
        goto L58
    L53:
        r114 = r30;
        goto L55
    L49:
        r113 = r29;
        goto L51
    L45:
        r112 = r28;
        goto L47
    L41:
        r111 = r27;
        goto L43
    L37:
        r110 = r26;
        goto L39
    L33:
        r36 = r25;
        goto L35
    L29:
        r16 = r24;
        goto L31
    L25:
        r15 = r23;
        goto L27
    L21:
        r14 = r22;
        goto L23
    L17:
        r13 = r21;
        goto L19
    L13:
        r12 = r20;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }

    public final int component1() {
        return this.group_id;
    }

    public final int component10() {
        return this.countNum;
    }

    @Nullable
    public final String component11() {
        return this.pageIdentity;
    }

    @Nullable
    public final String component12() {
        return this.pageSource;
    }

    @Nullable
    public final Integer component13() {
        return this.source;
    }

    @Nullable
    public final Integer component14() {
        return this.cid;
    }

    @Nullable
    public final String component15() {
        return this.type;
    }

    @Nullable
    public final Integer component16() {
        return this.page_id;
    }

    public final int component2() {
        return this.f8405id;
    }

    public final int component3() {
        return this.jsonType;
    }

    @NotNull
    public final String component4() {
        return this.apiType;
    }

    @NotNull
    public final String component5() {
        return this.title;
    }

    @NotNull
    public final String component6() {
        return this.iconId;
    }

    public final boolean component7() {
        return this.selected;
    }

    public final int component8() {
        return this.navPosition;
    }

    public final boolean component9() {
        return this.showCount;
    }

    @NotNull
    public final BetaNavTitleEntity copy(int r19, int r20, int r21, @NotNull String r22, @NotNull String r23, @NotNull String r24, boolean r25, int r26, boolean r27, int r28, @Nullable String r29, @Nullable String r30, @Nullable Integer r31, @Nullable Integer r32, @Nullable String r33, @Nullable Integer r34) {
        q.g(r22, "apiType");
        q.g(r23, "title");
        q.g(r24, "iconId");
        return new BetaNavTitleEntity(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof BetaNavTitleEntity) == true) goto L8;
        return false;
    L8:
        BetaNavTitleEntity r11 = (BetaNavTitleEntity) r10;
        if (this.group_id == r11.group_id) goto L12;
        return false;
    L12:
        if (this.f8405id == r11.f8405id) goto L15;
        return false;
    L15:
        if (this.jsonType == r11.jsonType) goto L18;
        return false;
    L18:
        if (q.b(this.apiType, r11.apiType) == true) goto L21;
        return false;
    L21:
        if (q.b(this.title, r11.title) == true) goto L24;
        return false;
    L24:
        if (q.b(this.iconId, r11.iconId) == true) goto L27;
        return false;
    L27:
        if (this.selected == r11.selected) goto L30;
        return false;
    L30:
        if (this.navPosition == r11.navPosition) goto L33;
        return false;
    L33:
        if (this.showCount == r11.showCount) goto L36;
        return false;
    L36:
        if (this.countNum == r11.countNum) goto L39;
        return false;
    L39:
        if (q.b(this.pageIdentity, r11.pageIdentity) == true) goto L42;
        return false;
    L42:
        if (q.b(this.pageSource, r11.pageSource) == true) goto L45;
        return false;
    L45:
        if (q.b(this.source, r11.source) == true) goto L48;
        return false;
    L48:
        if (q.b(this.cid, r11.cid) == true) goto L51;
        return false;
    L51:
        if (q.b(this.type, r11.type) == true) goto L54;
        return false;
    L54:
        if (q.b(this.page_id, r11.page_id) == true) goto L56;
        return false;
    L56:
        return true;
    }

    @NotNull
    public final String getApiType() {
        return this.apiType;
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        return null;
    }

    @Nullable
    public final Integer getCid() {
        return this.cid;
    }

    public final int getCountNum() {
        return this.countNum;
    }

    public final int getGroup_id() {
        return this.group_id;
    }

    @NotNull
    public final String getIconId() {
        return this.iconId;
    }

    public final int getId() {
        return this.f8405id;
    }

    public final int getJsonType() {
        return this.jsonType;
    }

    public final int getNavPosition() {
        return this.navPosition;
    }

    @Nullable
    public final String getPageIdentity() {
        return this.pageIdentity;
    }

    @Nullable
    public final String getPageSource() {
        return this.pageSource;
    }

    @Nullable
    public final Integer getPage_id() {
        return this.page_id;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final boolean getShowCount() {
        return this.showCount;
    }

    @Nullable
    public final Integer getSource() {
        return this.source;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r10 = ((((((((((((((((((Integer.hashCode(this.group_id) * 31) + Integer.hashCode(this.f8405id)) * 31) + Integer.hashCode(this.jsonType)) * 31) + this.apiType.hashCode()) * 31) + this.title.hashCode()) * 31) + this.iconId.hashCode()) * 31) + Boolean.hashCode(this.selected)) * 31) + Integer.hashCode(this.navPosition)) * 31) + Boolean.hashCode(this.showCount)) * 31) + Integer.hashCode(this.countNum)) * 31;
        String r11 = this.pageIdentity;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.pageSource;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        Integer r18 = this.source;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (r17 + r19) * 31;
        Integer r21 = this.cid;
        if (r21 != null) goto L17;
        int r22 = 0;
    L18:
        int r23 = (r20 + r22) * 31;
        String r24 = this.type;
        if (r24 != null) goto L21;
        int r25 = 0;
    L22:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.page_id;
        if (r27 == null) goto L27;
        r12 = r27.hashCode();
    L27:
        return r26 + r12;
    L21:
        r25 = r24.hashCode();
        goto L22
    L17:
        r22 = r21.hashCode();
        goto L18
    L13:
        r19 = r18.hashCode();
        goto L14
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final void setCountNum(int r10) {
        this.countNum = r10;
    }

    public final void setGroup_id(int r10) {
        this.group_id = r10;
    }

    public final void setNavPosition(int r10) {
        this.navPosition = r10;
    }

    public final void setPageSource(@Nullable String r10) {
        this.pageSource = r10;
    }

    public final void setSelected(boolean r10) {
        this.selected = r10;
    }

    public final void setShowCount(boolean r10) {
        this.showCount = r10;
    }

    @NotNull
    public String toString() {
        return "BetaNavTitleEntity(group_id=" + this.group_id + ", id=" + this.f8405id + ", jsonType=" + this.jsonType + ", apiType=" + this.apiType + ", title=" + this.title + ", iconId=" + this.iconId + ", selected=" + this.selected + ", navPosition=" + this.navPosition + ", showCount=" + this.showCount + ", countNum=" + this.countNum + ", pageIdentity=" + this.pageIdentity + ", pageSource=" + this.pageSource + ", source=" + this.source + ", cid=" + this.cid + ", type=" + this.type + ", page_id=" + this.page_id + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "out");
        r10.writeInt(this.group_id);
        r10.writeInt(this.f8405id);
        r10.writeInt(this.jsonType);
        r10.writeString(this.apiType);
        r10.writeString(this.title);
        r10.writeString(this.iconId);
        r10.writeInt(this.selected ? 1 : 0);
        r10.writeInt(this.navPosition);
        r10.writeInt(this.showCount ? 1 : 0);
        r10.writeInt(this.countNum);
        r10.writeString(this.pageIdentity);
        r10.writeString(this.pageSource);
        Integer r12 = this.source;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        Integer r13 = this.cid;
        if (r13 != null) goto L9;
        r10.writeInt(0);
    L10:
        r10.writeString(this.type);
        Integer r14 = this.page_id;
        if (r14 != null) goto L13;
        r10.writeInt(0);
        return;
    L13:
        r10.writeInt(1);
        r10.writeInt(r14.intValue());
        return;
    L9:
        r10.writeInt(1);
        r10.writeInt(r13.intValue());
        goto L10
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.intValue());
        goto L6
    }

    public BetaNavTitleEntity(int r10, int r11, int r12, @NotNull String r13, @NotNull String r14, @NotNull String r15, boolean r16, int r17, boolean r18, int r19, @Nullable String r110, @Nullable String r111, @Nullable Integer r112, @Nullable Integer r113, @Nullable String r20, @Nullable Integer r21) {
        q.g(r13, "apiType");
        q.g(r14, "title");
        q.g(r15, "iconId");
        this.group_id = r10;
        this.f8405id = r11;
        this.jsonType = r12;
        this.apiType = r13;
        this.title = r14;
        this.iconId = r15;
        this.selected = r16;
        this.navPosition = r17;
        this.showCount = r18;
        this.countNum = r19;
        this.pageIdentity = r110;
        this.pageSource = r111;
        this.source = r112;
        this.cid = r113;
        this.type = r20;
        this.page_id = r21;
    }
}
