package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoFilterInterface;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\n\u0010&\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/SearchResultPromoteEntity;", "Lcom/bytedanceos/common/model/AppInfoFilterInterface;", "name", "", "pck", ServerElements.ADS_IMPRESSION, "type", "", ServerElements.ADS_CLICK, ServerElements.SSTJ, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getClick", "()Ljava/lang/String;", "setClick", "(Ljava/lang/String;)V", "getImpression", "setImpression", "getName", "setName", "getPck", "setPck", "getSstj", "setSstj", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getPackageNameForFilter", "hashCode", "toString", "Companion", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchResultPromoteEntity implements AppInfoFilterInterface {

    @NotNull
    public static final Companion Companion = null;
    public static final int TYPE_CATEGORY = 2;

    @Nullable
    private String click;

    @Nullable
    private String impression;

    @Nullable
    private String name;

    @SerializedName("package")
    @Nullable
    private String pck;

    @Nullable
    private String sstj;
    private int type;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/SearchResultPromoteEntity$Companion;", "", "()V", "TYPE_CATEGORY", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SearchResultPromoteEntity() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        int r13 = 0;
        String r14 = null;
        String r15 = null;
        this(r10, r11, r12, r13, r14, r15, 63, null);
    }

    public static /* synthetic */ SearchResultPromoteEntity copy$default(SearchResultPromoteEntity r10, String r11, String r12, String r13, int r14, String r15, String r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.name;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.pck;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.impression;
    L11:
        String r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.type;
    L14:
        int r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.click;
    L17:
        String r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.sstj;
    L20:
        String r23 = r11;
        return r10.copy(r23, r19, r20, r21, r22, r16);
    }

    @Nullable
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component2() {
        return this.pck;
    }

    @Nullable
    public final String component3() {
        return this.impression;
    }

    public final int component4() {
        return this.type;
    }

    @Nullable
    public final String component5() {
        return this.click;
    }

    @Nullable
    public final String component6() {
        return this.sstj;
    }

    @NotNull
    public final SearchResultPromoteEntity copy(@Nullable String r10, @Nullable String r11, @Nullable String r12, int r13, @Nullable String r14, @Nullable String r15) {
        return new SearchResultPromoteEntity(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SearchResultPromoteEntity) == true) goto L8;
        return false;
    L8:
        SearchResultPromoteEntity r11 = (SearchResultPromoteEntity) r10;
        if (q.b(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (q.b(this.pck, r11.pck) == true) goto L15;
        return false;
    L15:
        if (q.b(this.impression, r11.impression) == true) goto L18;
        return false;
    L18:
        if (this.type == r11.type) goto L21;
        return false;
    L21:
        if (q.b(this.click, r11.click) == true) goto L24;
        return false;
    L24:
        if (q.b(this.sstj, r11.sstj) == true) goto L26;
        return false;
    L26:
        return true;
    }

    @Nullable
    public final String getClick() {
        return this.click;
    }

    @Nullable
    public final String getImpression() {
        return this.impression;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Override // com.bytedanceos.common.model.AppInfoFilterInterface
    @Nullable
    public String getPackageNameForFilter() {
        String r10 = this.pck;
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10;
    }

    @Nullable
    public final String getPck() {
        return this.pck;
    }

    @Nullable
    public final String getSstj() {
        return this.sstj;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        String r10 = this.name;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.pck;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.impression;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (((r16 + r18) * 31) + Integer.hashCode(this.type)) * 31;
        String r20 = this.click;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.sstj;
        if (r23 == null) goto L23;
        r11 = r23.hashCode();
    L23:
        return r22 + r11;
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setClick(@Nullable String r10) {
        this.click = r10;
    }

    public final void setImpression(@Nullable String r10) {
        this.impression = r10;
    }

    public final void setName(@Nullable String r10) {
        this.name = r10;
    }

    public final void setPck(@Nullable String r10) {
        this.pck = r10;
    }

    public final void setSstj(@Nullable String r10) {
        this.sstj = r10;
    }

    public final void setType(int r10) {
        this.type = r10;
    }

    @NotNull
    public String toString() {
        return "SearchResultPromoteEntity(name=" + this.name + ", pck=" + this.pck + ", impression=" + this.impression + ", type=" + this.type + ", click=" + this.click + ", sstj=" + this.sstj + ')';
    }

    public SearchResultPromoteEntity(@Nullable String r10, @Nullable String r11, @Nullable String r12, int r13, @Nullable String r14, @Nullable String r15) {
        this.name = r10;
        this.pck = r11;
        this.impression = r12;
        this.type = r13;
        this.click = r14;
        this.sstj = r15;
    }

    public /* synthetic */ SearchResultPromoteEntity(String r10, String r11, String r12, int r13, String r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r16 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r16 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r16 & 8) == 0) goto L15;
        r13 = -1;
    L15:
        if ((r16 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r16 & 32) == 0) goto L20;
        r15 = null;
    L20:
        this(r10, r11, r12, r13, r14, r15);
    }
}
