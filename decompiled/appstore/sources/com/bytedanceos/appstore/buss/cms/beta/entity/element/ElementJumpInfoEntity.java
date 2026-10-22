package com.bytedanceos.appstore.buss.cms.beta.entity.element;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003JT\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0006\u0010!\u001a\u00020\u001eJ\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/ElementJumpInfoEntity;", "", "redirectType", "", "packageName", "", "topicId", "url", "urlType", "pageId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getPageId", "getRedirectType", "()I", "getTopicId", "getUrl", "getUrlType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/ElementJumpInfoEntity;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "isAvailable", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementJumpInfoEntity {

    @SerializedName("package")
    @Nullable
    private final String packageName;

    @SerializedName("page")
    @Nullable
    private final String pageId;

    @SerializedName("redirect_type")
    private final int redirectType;

    @SerializedName(ServerElements.TOPIC_ID)
    @Nullable
    private final String topicId;

    @Nullable
    private final String url;

    @SerializedName("url_type")
    @Nullable
    private final Integer urlType;

    public ElementJumpInfoEntity(int r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable Integer r14, @Nullable String r15) {
        this.redirectType = r10;
        this.packageName = r11;
        this.topicId = r12;
        this.url = r13;
        this.urlType = r14;
        this.pageId = r15;
    }

    public static /* synthetic */ ElementJumpInfoEntity copy$default(ElementJumpInfoEntity r10, int r11, String r12, String r13, String r14, Integer r15, String r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.redirectType;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.packageName;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.topicId;
    L11:
        String r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.url;
    L14:
        String r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.urlType;
    L17:
        Integer r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.pageId;
    L20:
        int r23 = r11;
        return r10.copy(r23, r19, r20, r21, r22, r16);
    }

    public final int component1() {
        return this.redirectType;
    }

    @Nullable
    public final String component2() {
        return this.packageName;
    }

    @Nullable
    public final String component3() {
        return this.topicId;
    }

    @Nullable
    public final String component4() {
        return this.url;
    }

    @Nullable
    public final Integer component5() {
        return this.urlType;
    }

    @Nullable
    public final String component6() {
        return this.pageId;
    }

    @NotNull
    public final ElementJumpInfoEntity copy(int r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable Integer r14, @Nullable String r15) {
        return new ElementJumpInfoEntity(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ElementJumpInfoEntity) == true) goto L8;
        return false;
    L8:
        ElementJumpInfoEntity r11 = (ElementJumpInfoEntity) r10;
        if (this.redirectType == r11.redirectType) goto L12;
        return false;
    L12:
        if (q.b(this.packageName, r11.packageName) == true) goto L15;
        return false;
    L15:
        if (q.b(this.topicId, r11.topicId) == true) goto L18;
        return false;
    L18:
        if (q.b(this.url, r11.url) == true) goto L21;
        return false;
    L21:
        if (q.b(this.urlType, r11.urlType) == true) goto L24;
        return false;
    L24:
        if (q.b(this.pageId, r11.pageId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    @Nullable
    public final String getPackageName() {
        return this.packageName;
    }

    @Nullable
    public final String getPageId() {
        return this.pageId;
    }

    public final int getRedirectType() {
        return this.redirectType;
    }

    @Nullable
    public final String getTopicId() {
        return this.topicId;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final Integer getUrlType() {
        return this.urlType;
    }

    public int hashCode() {
        int r10 = Integer.hashCode(this.redirectType) * 31;
        String r11 = this.packageName;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.topicId;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        String r18 = this.url;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (r17 + r19) * 31;
        Integer r21 = this.urlType;
        if (r21 != null) goto L17;
        int r22 = 0;
    L18:
        int r23 = (r20 + r22) * 31;
        String r24 = this.pageId;
        if (r24 == null) goto L23;
        r12 = r24.hashCode();
    L23:
        return r23 + r12;
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

    public final boolean isAvailable() {
        if (this.redirectType == 5) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public String toString() {
        return "ElementJumpInfoEntity(redirectType=" + this.redirectType + ", packageName=" + this.packageName + ", topicId=" + this.topicId + ", url=" + this.url + ", urlType=" + this.urlType + ", pageId=" + this.pageId + ')';
    }
}
