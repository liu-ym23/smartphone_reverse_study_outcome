package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/GiftAllEntity;", "", "id", "", "name", "packageName", "category", "softType", "count", "", ServerElements.LOGO, ServerElements.SCORES, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getCount", "()I", "getId", "getLogo", "getName", "getPackageName", "getScores", "getSoftType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GiftAllEntity {

    @NotNull
    private final String category;
    private final int count;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f8431id;

    @NotNull
    private final String logo;

    @NotNull
    private final String name;

    @SerializedName("package")
    @NotNull
    private final String packageName;

    @NotNull
    private final String scores;

    @SerializedName("soft_type")
    @NotNull
    private final String softType;

    public GiftAllEntity(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull String r13, @NotNull String r14, int r15, @NotNull String r16, @NotNull String r17) {
        q.g(r10, "id");
        q.g(r11, "name");
        q.g(r12, "packageName");
        q.g(r13, "category");
        q.g(r14, "softType");
        q.g(r16, ServerElements.LOGO);
        q.g(r17, ServerElements.SCORES);
        this.f8431id = r10;
        this.name = r11;
        this.packageName = r12;
        this.category = r13;
        this.softType = r14;
        this.count = r15;
        this.logo = r16;
        this.scores = r17;
    }

    public static /* synthetic */ GiftAllEntity copy$default(GiftAllEntity r10, String r11, String r12, String r13, String r14, String r15, int r16, String r17, String r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r20 = r10.f8431id;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r21 = r10.name;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r22 = r10.packageName;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r23 = r10.category;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r24 = r10.softType;
    L23:
        if ((r19 & 32) == 0) goto L25;
        int r25 = r10.count;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r26 = r10.logo;
    L31:
        if ((r19 & 128) == 0) goto L33;
        String r27 = r10.scores;
    L35:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26, r27);
    L33:
        r27 = r18;
        goto L35
    L29:
        r26 = r17;
        goto L31
    L25:
        r25 = r16;
        goto L27
    L21:
        r24 = r15;
        goto L23
    L17:
        r23 = r14;
        goto L19
    L13:
        r22 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L11
    L5:
        r20 = r11;
        goto L7
    }

    @NotNull
    public final String component1() {
        return this.f8431id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.packageName;
    }

    @NotNull
    public final String component4() {
        return this.category;
    }

    @NotNull
    public final String component5() {
        return this.softType;
    }

    public final int component6() {
        return this.count;
    }

    @NotNull
    public final String component7() {
        return this.logo;
    }

    @NotNull
    public final String component8() {
        return this.scores;
    }

    @NotNull
    public final GiftAllEntity copy(@NotNull String r11, @NotNull String r12, @NotNull String r13, @NotNull String r14, @NotNull String r15, int r16, @NotNull String r17, @NotNull String r18) {
        q.g(r11, "id");
        q.g(r12, "name");
        q.g(r13, "packageName");
        q.g(r14, "category");
        q.g(r15, "softType");
        q.g(r17, ServerElements.LOGO);
        q.g(r18, ServerElements.SCORES);
        return new GiftAllEntity(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GiftAllEntity) == true) goto L8;
        return false;
    L8:
        GiftAllEntity r11 = (GiftAllEntity) r10;
        if (q.b(this.f8431id, r11.f8431id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.name, r11.name) == true) goto L15;
        return false;
    L15:
        if (q.b(this.packageName, r11.packageName) == true) goto L18;
        return false;
    L18:
        if (q.b(this.category, r11.category) == true) goto L21;
        return false;
    L21:
        if (q.b(this.softType, r11.softType) == true) goto L24;
        return false;
    L24:
        if (this.count == r11.count) goto L27;
        return false;
    L27:
        if (q.b(this.logo, r11.logo) == true) goto L30;
        return false;
    L30:
        if (q.b(this.scores, r11.scores) == true) goto L32;
        return false;
    L32:
        return true;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final String getId() {
        return this.f8431id;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getScores() {
        return this.scores;
    }

    @NotNull
    public final String getSoftType() {
        return this.softType;
    }

    public int hashCode() {
        return (((((((((((((this.f8431id.hashCode() * 31) + this.name.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.category.hashCode()) * 31) + this.softType.hashCode()) * 31) + Integer.hashCode(this.count)) * 31) + this.logo.hashCode()) * 31) + this.scores.hashCode();
    }

    @NotNull
    public String toString() {
        return "GiftAllEntity(id=" + this.f8431id + ", name=" + this.name + ", packageName=" + this.packageName + ", category=" + this.category + ", softType=" + this.softType + ", count=" + this.count + ", logo=" + this.logo + ", scores=" + this.scores + ')';
    }
}
