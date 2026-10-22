package com.bytedanceos.appstore.buss.entity;

import androidx.core.internal.view.SupportMenu;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.UiType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b?\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÎ\u0001\u0010N\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u0011HÖ\u0001J\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019¨\u0006U"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/HotKeywordEntity;", "", "keyword", "", "pkgName", ServerElements.SSTJ, ServerElements.LOGO, "soft_type", "version", "version_code", ServerElements.IFGMS, ServerElements.FILESIZE, "score", "", "category", ServerElements.RECMD_BRIEF, ServerElements.SORT, "", ServerElements.ADS_IMPRESSION, ServerElements.ADS_CLICK, ServerElements.DOWNLOAD_URL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getClick", "setClick", "getDownload_url", "setDownload_url", "getFilesize", "setFilesize", "getIfgms", "setIfgms", "getImpression", "setImpression", "getKeyword", "setKeyword", "getLogo", "setLogo", "getPkgName", "setPkgName", "getRecmd_brief", "setRecmd_brief", "getScore", "()Ljava/lang/Float;", "setScore", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getSoft_type", "setSoft_type", "getSort", "()Ljava/lang/Integer;", "setSort", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSstj", "setSstj", "getVersion", "setVersion", "getVersion_code", "setVersion_code", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedanceos/appstore/buss/entity/HotKeywordEntity;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HotKeywordEntity {

    @Nullable
    private String category;

    @Nullable
    private String click;

    @Nullable
    private String download_url;

    @Nullable
    private String filesize;

    @Nullable
    private String ifgms;

    @Nullable
    private String impression;

    @Nullable
    private String keyword;

    @Nullable
    private String logo;

    @SerializedName("package")
    @Nullable
    private String pkgName;

    @Nullable
    private String recmd_brief;

    @Nullable
    private Float score;

    @Nullable
    private String soft_type;

    @Nullable
    private Integer sort;

    @Nullable
    private String sstj;

    @Nullable
    private String version;

    @Nullable
    private String version_code;

    public HotKeywordEntity() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        String r16 = null;
        String r17 = null;
        String r18 = null;
        Float r19 = null;
        String r110 = null;
        String r111 = null;
        Integer r112 = null;
        String r113 = null;
        String r114 = null;
        String r115 = null;
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, SupportMenu.USER_MASK, null);
    }

    public static /* synthetic */ HotKeywordEntity copy$default(HotKeywordEntity r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, Float r27, String r28, String r29, Integer r30, String r31, String r32, String r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        String r10 = r17.keyword;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r11 = r17.pkgName;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r12 = r17.sstj;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r13 = r17.logo;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r14 = r17.soft_type;
    L23:
        if ((r34 & 32) == 0) goto L25;
        String r15 = r17.version;
    L27:
        if ((r34 & 64) == 0) goto L29;
        String r16 = r17.version_code;
    L31:
        if ((r34 & 128) == 0) goto L33;
        String r36 = r17.ifgms;
    L35:
        if ((r34 & 256) == 0) goto L37;
        String r110 = r17.filesize;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Float r111 = r17.score;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r112 = r17.category;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r113 = r17.recmd_brief;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        Integer r114 = r17.sort;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        String r115 = r17.impression;
    L58:
        String r37 = r115;
        if ((r34 & 16384) == 0) goto L61;
        String r116 = r17.click;
    L63:
        if ((r34 & UiType.FLAG_SETTINGS_CARD) == 0) goto L65;
        String r38 = r17.download_url;
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

    @Nullable
    public final String component1() {
        return this.keyword;
    }

    @Nullable
    public final Float component10() {
        return this.score;
    }

    @Nullable
    public final String component11() {
        return this.category;
    }

    @Nullable
    public final String component12() {
        return this.recmd_brief;
    }

    @Nullable
    public final Integer component13() {
        return this.sort;
    }

    @Nullable
    public final String component14() {
        return this.impression;
    }

    @Nullable
    public final String component15() {
        return this.click;
    }

    @Nullable
    public final String component16() {
        return this.download_url;
    }

    @Nullable
    public final String component2() {
        return this.pkgName;
    }

    @Nullable
    public final String component3() {
        return this.sstj;
    }

    @Nullable
    public final String component4() {
        return this.logo;
    }

    @Nullable
    public final String component5() {
        return this.soft_type;
    }

    @Nullable
    public final String component6() {
        return this.version;
    }

    @Nullable
    public final String component7() {
        return this.version_code;
    }

    @Nullable
    public final String component8() {
        return this.ifgms;
    }

    @Nullable
    public final String component9() {
        return this.filesize;
    }

    @NotNull
    public final HotKeywordEntity copy(@Nullable String r19, @Nullable String r20, @Nullable String r21, @Nullable String r22, @Nullable String r23, @Nullable String r24, @Nullable String r25, @Nullable String r26, @Nullable String r27, @Nullable Float r28, @Nullable String r29, @Nullable String r30, @Nullable Integer r31, @Nullable String r32, @Nullable String r33, @Nullable String r34) {
        return new HotKeywordEntity(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof HotKeywordEntity) == true) goto L8;
        return false;
    L8:
        HotKeywordEntity r11 = (HotKeywordEntity) r10;
        if (q.b(this.keyword, r11.keyword) == true) goto L12;
        return false;
    L12:
        if (q.b(this.pkgName, r11.pkgName) == true) goto L15;
        return false;
    L15:
        if (q.b(this.sstj, r11.sstj) == true) goto L18;
        return false;
    L18:
        if (q.b(this.logo, r11.logo) == true) goto L21;
        return false;
    L21:
        if (q.b(this.soft_type, r11.soft_type) == true) goto L24;
        return false;
    L24:
        if (q.b(this.version, r11.version) == true) goto L27;
        return false;
    L27:
        if (q.b(this.version_code, r11.version_code) == true) goto L30;
        return false;
    L30:
        if (q.b(this.ifgms, r11.ifgms) == true) goto L33;
        return false;
    L33:
        if (q.b(this.filesize, r11.filesize) == true) goto L36;
        return false;
    L36:
        if (q.b(this.score, r11.score) == true) goto L39;
        return false;
    L39:
        if (q.b(this.category, r11.category) == true) goto L42;
        return false;
    L42:
        if (q.b(this.recmd_brief, r11.recmd_brief) == true) goto L45;
        return false;
    L45:
        if (q.b(this.sort, r11.sort) == true) goto L48;
        return false;
    L48:
        if (q.b(this.impression, r11.impression) == true) goto L51;
        return false;
    L51:
        if (q.b(this.click, r11.click) == true) goto L54;
        return false;
    L54:
        if (q.b(this.download_url, r11.download_url) == true) goto L56;
        return false;
    L56:
        return true;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getClick() {
        return this.click;
    }

    @Nullable
    public final String getDownload_url() {
        return this.download_url;
    }

    @Nullable
    public final String getFilesize() {
        return this.filesize;
    }

    @Nullable
    public final String getIfgms() {
        return this.ifgms;
    }

    @Nullable
    public final String getImpression() {
        return this.impression;
    }

    @Nullable
    public final String getKeyword() {
        return this.keyword;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    public final String getPkgName() {
        return this.pkgName;
    }

    @Nullable
    public final String getRecmd_brief() {
        return this.recmd_brief;
    }

    @Nullable
    public final Float getScore() {
        return this.score;
    }

    @Nullable
    public final String getSoft_type() {
        return this.soft_type;
    }

    @Nullable
    public final Integer getSort() {
        return this.sort;
    }

    @Nullable
    public final String getSstj() {
        return this.sstj;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    @Nullable
    public final String getVersion_code() {
        return this.version_code;
    }

    public int hashCode() {
        String r10 = this.keyword;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.pkgName;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.sstj;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.logo;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.soft_type;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.version;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.version_code;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        String r32 = this.ifgms;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (r31 + r33) * 31;
        String r35 = this.filesize;
        if (r35 != null) goto L37;
        int r36 = 0;
    L38:
        int r37 = (r34 + r36) * 31;
        Float r38 = this.score;
        if (r38 != null) goto L41;
        int r39 = 0;
    L42:
        int r40 = (r37 + r39) * 31;
        String r41 = this.category;
        if (r41 != null) goto L45;
        int r42 = 0;
    L46:
        int r43 = (r40 + r42) * 31;
        String r44 = this.recmd_brief;
        if (r44 != null) goto L49;
        int r45 = 0;
    L50:
        int r46 = (r43 + r45) * 31;
        Integer r47 = this.sort;
        if (r47 != null) goto L53;
        int r48 = 0;
    L54:
        int r49 = (r46 + r48) * 31;
        String r50 = this.impression;
        if (r50 != null) goto L57;
        int r51 = 0;
    L58:
        int r52 = (r49 + r51) * 31;
        String r53 = this.click;
        if (r53 != null) goto L61;
        int r54 = 0;
    L62:
        int r55 = (r52 + r54) * 31;
        String r56 = this.download_url;
        if (r56 == null) goto L67;
        r11 = r56.hashCode();
    L67:
        return r55 + r11;
    L61:
        r54 = r53.hashCode();
        goto L62
    L57:
        r51 = r50.hashCode();
        goto L58
    L53:
        r48 = r47.hashCode();
        goto L54
    L49:
        r45 = r44.hashCode();
        goto L50
    L45:
        r42 = r41.hashCode();
        goto L46
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

    public final void setCategory(@Nullable String r10) {
        this.category = r10;
    }

    public final void setClick(@Nullable String r10) {
        this.click = r10;
    }

    public final void setDownload_url(@Nullable String r10) {
        this.download_url = r10;
    }

    public final void setFilesize(@Nullable String r10) {
        this.filesize = r10;
    }

    public final void setIfgms(@Nullable String r10) {
        this.ifgms = r10;
    }

    public final void setImpression(@Nullable String r10) {
        this.impression = r10;
    }

    public final void setKeyword(@Nullable String r10) {
        this.keyword = r10;
    }

    public final void setLogo(@Nullable String r10) {
        this.logo = r10;
    }

    public final void setPkgName(@Nullable String r10) {
        this.pkgName = r10;
    }

    public final void setRecmd_brief(@Nullable String r10) {
        this.recmd_brief = r10;
    }

    public final void setScore(@Nullable Float r10) {
        this.score = r10;
    }

    public final void setSoft_type(@Nullable String r10) {
        this.soft_type = r10;
    }

    public final void setSort(@Nullable Integer r10) {
        this.sort = r10;
    }

    public final void setSstj(@Nullable String r10) {
        this.sstj = r10;
    }

    public final void setVersion(@Nullable String r10) {
        this.version = r10;
    }

    public final void setVersion_code(@Nullable String r10) {
        this.version_code = r10;
    }

    @NotNull
    public String toString() {
        return "HotKeywordEntity(keyword=" + this.keyword + ", pkgName=" + this.pkgName + ", sstj=" + this.sstj + ", logo=" + this.logo + ", soft_type=" + this.soft_type + ", version=" + this.version + ", version_code=" + this.version_code + ", ifgms=" + this.ifgms + ", filesize=" + this.filesize + ", score=" + this.score + ", category=" + this.category + ", recmd_brief=" + this.recmd_brief + ", sort=" + this.sort + ", impression=" + this.impression + ", click=" + this.click + ", download_url=" + this.download_url + ')';
    }

    public HotKeywordEntity(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable String r16, @Nullable String r17, @Nullable String r18, @Nullable Float r19, @Nullable String r110, @Nullable String r111, @Nullable Integer r112, @Nullable String r113, @Nullable String r114, @Nullable String r115) {
        this.keyword = r10;
        this.pkgName = r11;
        this.sstj = r12;
        this.logo = r13;
        this.soft_type = r14;
        this.version = r15;
        this.version_code = r16;
        this.ifgms = r17;
        this.filesize = r18;
        this.score = r19;
        this.category = r110;
        this.recmd_brief = r111;
        this.sort = r112;
        this.impression = r113;
        this.click = r114;
        this.download_url = r115;
    }

    public /* synthetic */ HotKeywordEntity(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, Float r27, String r28, String r29, Integer r30, String r31, String r32, String r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r13 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r14 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        String r15 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        String r16 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        String r17 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Float r111 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        Integer r114 = null;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        String r36 = null;
    L63:
        if ((r34 & UiType.FLAG_SETTINGS_CARD) == 0) goto L65;
        String r37 = null;
    L66:
        this(r10, r11, r12, r13, r14, r15, r16, r17, r110, r111, r112, r113, r114, r115, r36, r37);
        return;
    L65:
        r37 = r33;
        goto L66
    L61:
        r36 = r32;
        goto L63
    L57:
        r115 = r31;
        goto L59
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
        r17 = r25;
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
}
