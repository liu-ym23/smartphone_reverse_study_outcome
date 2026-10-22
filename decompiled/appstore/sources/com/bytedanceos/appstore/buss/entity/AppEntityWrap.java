package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.n;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b6\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJ¬\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\u0006\u0010H\u001a\u00020\u000eJ\r\u0010I\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u001dJ\b\u0010J\u001a\u0004\u0018\u00010\u0003J\t\u0010K\u001a\u00020\u000eHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0015\"\u0004\b4\u0010\u0017¨\u0006M"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "Lcom/bytedanceos/appstore/buss/entity/BaseWrap;", "name", "", ServerElements.GROUP_ID, ServerElements.TEMPLATE, "info_type", "apps", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "rows", ServerElements.AD_COUNT, "cid", "bannerSpanCount", "", "show_count", "pos", ServerElements.VIDEO_IMG, ServerElements.VIDEO_PATH, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IILjava/lang/String;Ljava/lang/String;)V", "getAd_count", "()Ljava/lang/String;", "setAd_count", "(Ljava/lang/String;)V", "getApps", "()Ljava/util/List;", "setApps", "(Ljava/util/List;)V", "getBannerSpanCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCid", "setCid", "getGroup_id", "setGroup_id", "getInfo_type", "setInfo_type", "getName", "setName", "getPos", "()I", "setPos", "(I)V", "getRows", "setRows", "getShow_count", "setShow_count", "getTemplate", "setTemplate", "getVideo_img", "setVideo_img", "getVideo_url", "setVideo_url", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IILjava/lang/String;Ljava/lang/String;)Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getBannerSpan", "getCategoryId", "getCategoryName", "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppEntityWrap extends BaseWrap {

    @Nullable
    private String ad_count;

    @Nullable
    private List<CommonAppEntity> apps;

    @Nullable
    private final Integer bannerSpanCount;

    @Nullable
    private String cid;

    @Nullable
    private String group_id;

    @Nullable
    private String info_type;

    @Nullable
    private String name;
    private int pos;

    @Nullable
    private String rows;
    private int show_count;

    @Nullable
    private String template;

    @Nullable
    private String video_img;

    @Nullable
    private String video_url;

    public AppEntityWrap() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        List r14 = null;
        String r15 = null;
        String r16 = null;
        String r17 = null;
        Integer r18 = null;
        int r19 = 0;
        int r110 = 0;
        String r111 = null;
        String r112 = null;
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppEntityWrap copy$default(AppEntityWrap r14, String r15, String r16, String r17, String r18, List r19, String r20, String r21, String r22, Integer r23, int r24, int r25, String r26, String r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        String r10 = r14.name;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r11 = r14.group_id;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r12 = r14.template;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r13 = r14.info_type;
    L19:
        if ((r28 & 16) == 0) goto L21;
        List r30 = r14.apps;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r31 = r14.rows;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r32 = r14.ad_count;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r33 = r14.cid;
    L35:
        if ((r28 & 256) == 0) goto L37;
        Integer r110 = r14.bannerSpanCount;
    L39:
        if ((r28 & 512) == 0) goto L41;
        int r111 = r14.show_count;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        int r112 = r14.pos;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r113 = r14.video_img;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        String r34 = r14.video_url;
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

    @Nullable
    public final String component1() {
        return this.name;
    }

    public final int component10() {
        return this.show_count;
    }

    public final int component11() {
        return this.pos;
    }

    @Nullable
    public final String component12() {
        return this.video_img;
    }

    @Nullable
    public final String component13() {
        return this.video_url;
    }

    @Nullable
    public final String component2() {
        return this.group_id;
    }

    @Nullable
    public final String component3() {
        return this.template;
    }

    @Nullable
    public final String component4() {
        return this.info_type;
    }

    @Nullable
    public final List<CommonAppEntity> component5() {
        return this.apps;
    }

    @Nullable
    public final String component6() {
        return this.rows;
    }

    @Nullable
    public final String component7() {
        return this.ad_count;
    }

    @Nullable
    public final String component8() {
        return this.cid;
    }

    @Nullable
    public final Integer component9() {
        return this.bannerSpanCount;
    }

    @NotNull
    public final AppEntityWrap copy(@Nullable String r16, @Nullable String r17, @Nullable String r18, @Nullable String r19, @Nullable List<CommonAppEntity> r20, @Nullable String r21, @Nullable String r22, @Nullable String r23, @Nullable Integer r24, int r25, int r26, @Nullable String r27, @Nullable String r28) {
        return new AppEntityWrap(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppEntityWrap) == true) goto L8;
        return false;
    L8:
        AppEntityWrap r11 = (AppEntityWrap) r10;
        if (q.b(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (q.b(this.group_id, r11.group_id) == true) goto L15;
        return false;
    L15:
        if (q.b(this.template, r11.template) == true) goto L18;
        return false;
    L18:
        if (q.b(this.info_type, r11.info_type) == true) goto L21;
        return false;
    L21:
        if (q.b(this.apps, r11.apps) == true) goto L24;
        return false;
    L24:
        if (q.b(this.rows, r11.rows) == true) goto L27;
        return false;
    L27:
        if (q.b(this.ad_count, r11.ad_count) == true) goto L30;
        return false;
    L30:
        if (q.b(this.cid, r11.cid) == true) goto L33;
        return false;
    L33:
        if (q.b(this.bannerSpanCount, r11.bannerSpanCount) == true) goto L36;
        return false;
    L36:
        if (this.show_count == r11.show_count) goto L39;
        return false;
    L39:
        if (this.pos == r11.pos) goto L42;
        return false;
    L42:
        if (q.b(this.video_img, r11.video_img) == true) goto L45;
        return false;
    L45:
        if (q.b(this.video_url, r11.video_url) == true) goto L47;
        return false;
    L47:
        return true;
    }

    @Nullable
    public final String getAd_count() {
        return this.ad_count;
    }

    @Nullable
    public final List<CommonAppEntity> getApps() {
        return this.apps;
    }

    public final int getBannerSpan() {
        Integer r10 = this.bannerSpanCount;
        if (r10 != null) goto L7;
        return 2;
    L7:
        return r10.intValue();
    }

    @Nullable
    public final Integer getBannerSpanCount() {
        return this.bannerSpanCount;
    }

    @Nullable
    public final Integer getCategoryId() {
        String r10 = this.cid;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (o.r(r10) == true) goto L13;
        String r11 = this.cid;
        if (r11 != null) goto L10;
        return null;
    L10:
        return n.g(r11);
    L13:
        return null;
    }

    @Nullable
    public final String getCategoryName() {
        return this.name;
    }

    @Nullable
    public final String getCid() {
        return this.cid;
    }

    @Nullable
    public final String getGroup_id() {
        return this.group_id;
    }

    @Nullable
    public final String getInfo_type() {
        return this.info_type;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final int getPos() {
        return this.pos;
    }

    @Nullable
    public final String getRows() {
        return this.rows;
    }

    public final int getShow_count() {
        return this.show_count;
    }

    @Nullable
    public final String getTemplate() {
        return this.template;
    }

    @Nullable
    public final String getVideo_img() {
        return this.video_img;
    }

    @Nullable
    public final String getVideo_url() {
        return this.video_url;
    }

    public int hashCode() {
        String r10 = this.name;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.group_id;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.template;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.info_type;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        List<CommonAppEntity> r23 = this.apps;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.rows;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.ad_count;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        String r32 = this.cid;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (r31 + r33) * 31;
        Integer r35 = this.bannerSpanCount;
        if (r35 != null) goto L37;
        int r36 = 0;
    L38:
        int r37 = (((((r34 + r36) * 31) + Integer.hashCode(this.show_count)) * 31) + Integer.hashCode(this.pos)) * 31;
        String r38 = this.video_img;
        if (r38 != null) goto L41;
        int r39 = 0;
    L42:
        int r40 = (r37 + r39) * 31;
        String r41 = this.video_url;
        if (r41 == null) goto L47;
        r11 = r41.hashCode();
    L47:
        return r40 + r11;
    L41:
        r39 = r38.hashCode();
        goto L42
    L37:
        r36 = r35.hashCode();
        goto L38
    L33:
        r33 = r32.hashCode();
        goto L34
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
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

    public final void setAd_count(@Nullable String r10) {
        this.ad_count = r10;
    }

    public final void setApps(@Nullable List<CommonAppEntity> r10) {
        this.apps = r10;
    }

    public final void setCid(@Nullable String r10) {
        this.cid = r10;
    }

    public final void setGroup_id(@Nullable String r10) {
        this.group_id = r10;
    }

    public final void setInfo_type(@Nullable String r10) {
        this.info_type = r10;
    }

    public final void setName(@Nullable String r10) {
        this.name = r10;
    }

    public final void setPos(int r10) {
        this.pos = r10;
    }

    public final void setRows(@Nullable String r10) {
        this.rows = r10;
    }

    public final void setShow_count(int r10) {
        this.show_count = r10;
    }

    public final void setTemplate(@Nullable String r10) {
        this.template = r10;
    }

    public final void setVideo_img(@Nullable String r10) {
        this.video_img = r10;
    }

    public final void setVideo_url(@Nullable String r10) {
        this.video_url = r10;
    }

    @NotNull
    public String toString() {
        return "AppEntityWrap(name=" + this.name + ", group_id=" + this.group_id + ", template=" + this.template + ", info_type=" + this.info_type + ", apps=" + this.apps + ", rows=" + this.rows + ", ad_count=" + this.ad_count + ", cid=" + this.cid + ", bannerSpanCount=" + this.bannerSpanCount + ", show_count=" + this.show_count + ", pos=" + this.pos + ", video_img=" + this.video_img + ", video_url=" + this.video_url + ')';
    }

    public /* synthetic */ AppEntityWrap(String r15, String r16, String r17, String r18, List r19, String r20, String r21, String r22, Integer r23, int r24, int r25, String r26, String r27, int r28, DefaultConstructorMarker r29) {
        String r10 = null;
        if ((r28 & 1) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r28 & 16) == 0) goto L21;
        List r30 = null;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r31 = null;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r32 = null;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r33 = null;
    L35:
        if ((r28 & 256) == 0) goto L37;
        Integer r110 = 2;
    L38:
        int r111 = 0;
        if ((r28 & 512) == 0) goto L41;
        int r112 = 0;
    L43:
        if ((r28 & 1024) != 0) goto L47;
        r111 = r25;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r28 & 4096) != 0) goto L54;
        r10 = r27;
    L54:
        this(r11, r12, r13, r14, r30, r31, r32, r33, r110, r112, r111, r113, r10);
        return;
    L49:
        r113 = r26;
        goto L51
    L41:
        r112 = r24;
        goto L43
    L37:
        r110 = r23;
        goto L38
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
        r14 = r18;
        goto L19
    L13:
        r13 = r17;
        goto L15
    L9:
        r12 = r16;
        goto L11
    L5:
        r11 = r15;
        goto L7
    }

    public AppEntityWrap(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable List<CommonAppEntity> r14, @Nullable String r15, @Nullable String r16, @Nullable String r17, @Nullable Integer r18, int r19, int r110, @Nullable String r111, @Nullable String r112) {
        this.name = r10;
        this.group_id = r11;
        this.template = r12;
        this.info_type = r13;
        this.apps = r14;
        this.rows = r15;
        this.ad_count = r16;
        this.cid = r17;
        this.bannerSpanCount = r18;
        this.show_count = r19;
        this.pos = r110;
        this.video_img = r111;
        this.video_url = r112;
    }
}
