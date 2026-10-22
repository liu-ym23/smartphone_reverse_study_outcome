package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jm\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\fHÖ\u0001J\u0006\u00101\u001a\u00020.J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00063"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;", "", "id", "", "name", ServerElements.BANNER, ServerElements.LOGO, "online_time", "category", ServerElements.VIDEO, "Lcom/bytedanceos/appstore/buss/entity/AppSubVideoEntity;", "status", "", "gift_id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedanceos/appstore/buss/entity/AppSubVideoEntity;ILjava/lang/String;)V", "getBanner", "()Ljava/lang/String;", "setBanner", "(Ljava/lang/String;)V", "getCategory", "getGift_id", "setGift_id", "getId", "itemPosition", "getItemPosition", "setItemPosition", "getLogo", "getName", "getOnline_time", "getStatus", "()I", "setStatus", "(I)V", "getVideo", "()Lcom/bytedanceos/appstore/buss/entity/AppSubVideoEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "isSubscribed", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppSubEntity {

    @Nullable
    private String banner;

    @Nullable
    private final String category;

    @Nullable
    private String gift_id;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f8428id;

    @NotNull
    private String itemPosition;

    @Nullable
    private final String logo;

    @NotNull
    private final String name;

    @NotNull
    private final String online_time;
    private int status;

    @Nullable
    private final AppSubVideoEntity video;

    public AppSubEntity(@NotNull String r10, @NotNull String r11, @Nullable String r12, @Nullable String r13, @NotNull String r14, @Nullable String r15, @Nullable AppSubVideoEntity r16, int r17, @Nullable String r18) {
        q.g(r10, "id");
        q.g(r11, "name");
        q.g(r14, "online_time");
        this.f8428id = r10;
        this.name = r11;
        this.banner = r12;
        this.logo = r13;
        this.online_time = r14;
        this.category = r15;
        this.video = r16;
        this.status = r17;
        this.gift_id = r18;
        this.itemPosition = "";
    }

    public static /* synthetic */ AppSubEntity copy$default(AppSubEntity r10, String r11, String r12, String r13, String r14, String r15, String r16, AppSubVideoEntity r17, int r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r22 = r10.f8428id;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r23 = r10.name;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r24 = r10.banner;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r25 = r10.logo;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r26 = r10.online_time;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r27 = r10.category;
    L27:
        if ((r20 & 64) == 0) goto L29;
        AppSubVideoEntity r28 = r10.video;
    L31:
        if ((r20 & 128) == 0) goto L33;
        int r29 = r10.status;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r30 = r10.gift_id;
    L39:
        return r10.copy(r22, r23, r24, r25, r26, r27, r28, r29, r30);
    L37:
        r30 = r19;
        goto L39
    L33:
        r29 = r18;
        goto L35
    L29:
        r28 = r17;
        goto L31
    L25:
        r27 = r16;
        goto L27
    L21:
        r26 = r15;
        goto L23
    L17:
        r25 = r14;
        goto L19
    L13:
        r24 = r13;
        goto L15
    L9:
        r23 = r12;
        goto L11
    L5:
        r22 = r11;
        goto L7
    }

    @NotNull
    public final String component1() {
        return this.f8428id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final String component3() {
        return this.banner;
    }

    @Nullable
    public final String component4() {
        return this.logo;
    }

    @NotNull
    public final String component5() {
        return this.online_time;
    }

    @Nullable
    public final String component6() {
        return this.category;
    }

    @Nullable
    public final AppSubVideoEntity component7() {
        return this.video;
    }

    public final int component8() {
        return this.status;
    }

    @Nullable
    public final String component9() {
        return this.gift_id;
    }

    @NotNull
    public final AppSubEntity copy(@NotNull String r12, @NotNull String r13, @Nullable String r14, @Nullable String r15, @NotNull String r16, @Nullable String r17, @Nullable AppSubVideoEntity r18, int r19, @Nullable String r20) {
        q.g(r12, "id");
        q.g(r13, "name");
        q.g(r16, "online_time");
        return new AppSubEntity(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppSubEntity) == true) goto L8;
        return false;
    L8:
        AppSubEntity r11 = (AppSubEntity) r10;
        if (q.b(this.f8428id, r11.f8428id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.name, r11.name) == true) goto L15;
        return false;
    L15:
        if (q.b(this.banner, r11.banner) == true) goto L18;
        return false;
    L18:
        if (q.b(this.logo, r11.logo) == true) goto L21;
        return false;
    L21:
        if (q.b(this.online_time, r11.online_time) == true) goto L24;
        return false;
    L24:
        if (q.b(this.category, r11.category) == true) goto L27;
        return false;
    L27:
        if (q.b(this.video, r11.video) == true) goto L30;
        return false;
    L30:
        if (this.status == r11.status) goto L33;
        return false;
    L33:
        if (q.b(this.gift_id, r11.gift_id) == true) goto L35;
        return false;
    L35:
        return true;
    }

    @Nullable
    public final String getBanner() {
        return this.banner;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getGift_id() {
        return this.gift_id;
    }

    @NotNull
    public final String getId() {
        return this.f8428id;
    }

    @NotNull
    public final String getItemPosition() {
        return this.itemPosition;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getOnline_time() {
        return this.online_time;
    }

    public final int getStatus() {
        return this.status;
    }

    @Nullable
    public final AppSubVideoEntity getVideo() {
        return this.video;
    }

    public int hashCode() {
        int r10 = ((this.f8428id.hashCode() * 31) + this.name.hashCode()) * 31;
        String r11 = this.banner;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.logo;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (((r14 + r16) * 31) + this.online_time.hashCode()) * 31;
        String r18 = this.category;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (r17 + r19) * 31;
        AppSubVideoEntity r21 = this.video;
        if (r21 != null) goto L17;
        int r22 = 0;
    L18:
        int r23 = (((r20 + r22) * 31) + Integer.hashCode(this.status)) * 31;
        String r24 = this.gift_id;
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

    public final boolean isSubscribed() {
        if (this.status == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void setBanner(@Nullable String r10) {
        this.banner = r10;
    }

    public final void setGift_id(@Nullable String r10) {
        this.gift_id = r10;
    }

    public final void setItemPosition(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.itemPosition = r10;
    }

    public final void setStatus(int r10) {
        this.status = r10;
    }

    @NotNull
    public String toString() {
        return "AppSubEntity(id=" + this.f8428id + ", name=" + this.name + ", banner=" + this.banner + ", logo=" + this.logo + ", online_time=" + this.online_time + ", category=" + this.category + ", video=" + this.video + ", status=" + this.status + ", gift_id=" + this.gift_id + ')';
    }
}
