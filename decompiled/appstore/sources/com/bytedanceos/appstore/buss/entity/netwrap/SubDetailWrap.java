package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.entity.AppSubVideoEntity;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\t\u0010,\u001a\u00020\u0013HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u0006\u00105\u001a\u000206J\u009b\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0013HÖ\u0001J\u0006\u0010<\u001a\u000209J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006>"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/SubDetailWrap;", "", "id", "", "name", ServerElements.LOGO, ServerElements.BANNER, "onlineTime", "parentCid", "category", "childCid", ServerElements.GAME_GIFT_PACK, "", "Lcom/bytedanceos/appstore/buss/entity/netwrap/SubDetailGiftEntity;", ServerElements.VIDEO, "Lcom/bytedanceos/appstore/buss/entity/AppSubVideoEntity;", ServerElements.BRIEF, "screen", "status", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedanceos/appstore/buss/entity/AppSubVideoEntity;Ljava/lang/String;Ljava/util/List;I)V", "getBanner", "()Ljava/lang/String;", "getBrief", "getCategory", "getChildCid", "getGifts", "()Ljava/util/List;", "getId", "getLogo", "getName", "getOnlineTime", "getParentCid", "getScreen", "getStatus", "()I", "setStatus", "(I)V", "getVideo", "()Lcom/bytedanceos/appstore/buss/entity/AppSubVideoEntity;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "convertAppSubEntity", "Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "isSubscribed", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SubDetailWrap {

    @NotNull
    private final String banner;

    @NotNull
    private final String brief;

    @NotNull
    private final String category;

    @SerializedName(ServerElements.SECOND_CATEGORY_ID)
    @NotNull
    private final String childCid;

    @Nullable
    private final List<SubDetailGiftEntity> gifts;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f8435id;

    @NotNull
    private final String logo;

    @NotNull
    private final String name;

    @SerializedName("online_time")
    @NotNull
    private final String onlineTime;

    @SerializedName("parent_cid")
    @NotNull
    private final String parentCid;

    @NotNull
    private final List<String> screen;
    private int status;

    @Nullable
    private final AppSubVideoEntity video;

    public SubDetailWrap(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull String r13, @NotNull String r14, @NotNull String r15, @NotNull String r16, @NotNull String r17, @Nullable List<SubDetailGiftEntity> r18, @Nullable AppSubVideoEntity r19, @NotNull String r110, @NotNull List<String> r111, int r112) {
        q.g(r10, "id");
        q.g(r11, "name");
        q.g(r12, ServerElements.LOGO);
        q.g(r13, ServerElements.BANNER);
        q.g(r14, "onlineTime");
        q.g(r15, "parentCid");
        q.g(r16, "category");
        q.g(r17, "childCid");
        q.g(r110, ServerElements.BRIEF);
        q.g(r111, "screen");
        this.f8435id = r10;
        this.name = r11;
        this.logo = r12;
        this.banner = r13;
        this.onlineTime = r14;
        this.parentCid = r15;
        this.category = r16;
        this.childCid = r17;
        this.gifts = r18;
        this.video = r19;
        this.brief = r110;
        this.screen = r111;
        this.status = r112;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubDetailWrap copy$default(SubDetailWrap r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, List r23, AppSubVideoEntity r24, String r25, List r26, int r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        String r10 = r14.f8435id;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r11 = r14.name;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r12 = r14.logo;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r13 = r14.banner;
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r30 = r14.onlineTime;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r31 = r14.parentCid;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r32 = r14.category;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r33 = r14.childCid;
    L35:
        if ((r28 & 256) == 0) goto L37;
        List r110 = r14.gifts;
    L39:
        if ((r28 & 512) == 0) goto L41;
        AppSubVideoEntity r111 = r14.video;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        String r112 = r14.brief;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        List r113 = r14.screen;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        int r34 = r14.status;
    L55:
        return r14.copy(r10, r11, r12, r13, r30, r31, r32, r33, r110, r111, r112, r113, r34);
    L53:
        r34 = r27;
        goto L55
    L49:
        r113 = r26;
        goto L51
    L45:
        r112 = r25;
        goto L47
    L41:
        r111 = r24;
        goto L43
    L37:
        r110 = r23;
        goto L39
    L33:
        r33 = r22;
        goto L35
    L29:
        r32 = r21;
        goto L31
    L25:
        r31 = r20;
        goto L27
    L21:
        r30 = r19;
        goto L23
    L17:
        r13 = r18;
        goto L19
    L13:
        r12 = r17;
        goto L15
    L9:
        r11 = r16;
        goto L11
    L5:
        r10 = r15;
        goto L7
    }

    @NotNull
    public final String component1() {
        return this.f8435id;
    }

    @Nullable
    public final AppSubVideoEntity component10() {
        return this.video;
    }

    @NotNull
    public final String component11() {
        return this.brief;
    }

    @NotNull
    public final List<String> component12() {
        return this.screen;
    }

    public final int component13() {
        return this.status;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.logo;
    }

    @NotNull
    public final String component4() {
        return this.banner;
    }

    @NotNull
    public final String component5() {
        return this.onlineTime;
    }

    @NotNull
    public final String component6() {
        return this.parentCid;
    }

    @NotNull
    public final String component7() {
        return this.category;
    }

    @NotNull
    public final String component8() {
        return this.childCid;
    }

    @Nullable
    public final List<SubDetailGiftEntity> component9() {
        return this.gifts;
    }

    @NotNull
    public final AppSubEntity convertAppSubEntity() {
        return new AppSubEntity(this.f8435id, this.name, this.banner, this.logo, this.onlineTime, this.category, this.video, this.status, null);
    }

    @NotNull
    public final SubDetailWrap copy(@NotNull String r16, @NotNull String r17, @NotNull String r18, @NotNull String r19, @NotNull String r20, @NotNull String r21, @NotNull String r22, @NotNull String r23, @Nullable List<SubDetailGiftEntity> r24, @Nullable AppSubVideoEntity r25, @NotNull String r26, @NotNull List<String> r27, int r28) {
        q.g(r16, "id");
        q.g(r17, "name");
        q.g(r18, ServerElements.LOGO);
        q.g(r19, ServerElements.BANNER);
        q.g(r20, "onlineTime");
        q.g(r21, "parentCid");
        q.g(r22, "category");
        q.g(r23, "childCid");
        q.g(r26, ServerElements.BRIEF);
        q.g(r27, "screen");
        return new SubDetailWrap(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SubDetailWrap) == true) goto L8;
        return false;
    L8:
        SubDetailWrap r11 = (SubDetailWrap) r10;
        if (q.b(this.f8435id, r11.f8435id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.name, r11.name) == true) goto L15;
        return false;
    L15:
        if (q.b(this.logo, r11.logo) == true) goto L18;
        return false;
    L18:
        if (q.b(this.banner, r11.banner) == true) goto L21;
        return false;
    L21:
        if (q.b(this.onlineTime, r11.onlineTime) == true) goto L24;
        return false;
    L24:
        if (q.b(this.parentCid, r11.parentCid) == true) goto L27;
        return false;
    L27:
        if (q.b(this.category, r11.category) == true) goto L30;
        return false;
    L30:
        if (q.b(this.childCid, r11.childCid) == true) goto L33;
        return false;
    L33:
        if (q.b(this.gifts, r11.gifts) == true) goto L36;
        return false;
    L36:
        if (q.b(this.video, r11.video) == true) goto L39;
        return false;
    L39:
        if (q.b(this.brief, r11.brief) == true) goto L42;
        return false;
    L42:
        if (q.b(this.screen, r11.screen) == true) goto L45;
        return false;
    L45:
        if (this.status == r11.status) goto L47;
        return false;
    L47:
        return true;
    }

    @NotNull
    public final String getBanner() {
        return this.banner;
    }

    @NotNull
    public final String getBrief() {
        return this.brief;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getChildCid() {
        return this.childCid;
    }

    @Nullable
    public final List<SubDetailGiftEntity> getGifts() {
        return this.gifts;
    }

    @NotNull
    public final String getId() {
        return this.f8435id;
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
    public final String getOnlineTime() {
        return this.onlineTime;
    }

    @NotNull
    public final String getParentCid() {
        return this.parentCid;
    }

    @NotNull
    public final List<String> getScreen() {
        return this.screen;
    }

    public final int getStatus() {
        return this.status;
    }

    @Nullable
    public final AppSubVideoEntity getVideo() {
        return this.video;
    }

    public int hashCode() {
        int r10 = ((((((((((((((this.f8435id.hashCode() * 31) + this.name.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.banner.hashCode()) * 31) + this.onlineTime.hashCode()) * 31) + this.parentCid.hashCode()) * 31) + this.category.hashCode()) * 31) + this.childCid.hashCode()) * 31;
        List<SubDetailGiftEntity> r11 = this.gifts;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        AppSubVideoEntity r15 = this.video;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return ((((((r14 + r12) * 31) + this.brief.hashCode()) * 31) + this.screen.hashCode()) * 31) + Integer.hashCode(this.status);
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

    public final void setStatus(int r10) {
        this.status = r10;
    }

    @NotNull
    public String toString() {
        return "SubDetailWrap(id=" + this.f8435id + ", name=" + this.name + ", logo=" + this.logo + ", banner=" + this.banner + ", onlineTime=" + this.onlineTime + ", parentCid=" + this.parentCid + ", category=" + this.category + ", childCid=" + this.childCid + ", gifts=" + this.gifts + ", video=" + this.video + ", brief=" + this.brief + ", screen=" + this.screen + ", status=" + this.status + ')';
    }
}
