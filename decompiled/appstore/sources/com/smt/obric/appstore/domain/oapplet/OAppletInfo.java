package com.smt.obric.appstore.domain.oapplet;

import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/smt/obric/appstore/domain/oapplet/OAppletInfo;", "", "action", "", ServerElements.ICON, "installed", "", "label_cn", "label_en", "packageName", "versionCode", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAction", "()Ljava/lang/String;", "getIcon", "getInstalled", "()Z", "getLabel_cn", "getLabel_en", "getPackageName", "getVersionCode", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OAppletInfo {

    @NotNull
    private final String action;

    @NotNull
    private final String icon;
    private final boolean installed;

    @NotNull
    private final String label_cn;

    @NotNull
    private final String label_en;

    @NotNull
    private final String packageName;
    private final long versionCode;

    public OAppletInfo() {
        String r10 = null;
        String r11 = null;
        boolean r12 = false;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        long r16 = 0;
        this(r10, r11, r12, r13, r14, r15, r16, 127, null);
    }

    public static /* synthetic */ OAppletInfo copy$default(OAppletInfo r10, String r11, String r12, boolean r13, String r14, String r15, String r16, long r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r20 = r10.action;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r21 = r10.icon;
    L11:
        if ((r18 & 4) == 0) goto L13;
        boolean r22 = r10.installed;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r23 = r10.label_cn;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r24 = r10.label_en;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r25 = r10.packageName;
    L27:
        if ((r18 & 64) == 0) goto L29;
        long r26 = r10.versionCode;
    L31:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26);
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
        return this.action;
    }

    @NotNull
    public final String component2() {
        return this.icon;
    }

    public final boolean component3() {
        return this.installed;
    }

    @NotNull
    public final String component4() {
        return this.label_cn;
    }

    @NotNull
    public final String component5() {
        return this.label_en;
    }

    @NotNull
    public final String component6() {
        return this.packageName;
    }

    public final long component7() {
        return this.versionCode;
    }

    @NotNull
    public final OAppletInfo copy(@NotNull String r11, @NotNull String r12, boolean r13, @NotNull String r14, @NotNull String r15, @NotNull String r16, long r17) {
        q.g(r11, "action");
        q.g(r12, ServerElements.ICON);
        q.g(r14, "label_cn");
        q.g(r15, "label_en");
        q.g(r16, "packageName");
        return new OAppletInfo(r11, r12, r13, r14, r15, r16, r17);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OAppletInfo) == true) goto L8;
        return false;
    L8:
        OAppletInfo r11 = (OAppletInfo) r10;
        if (q.b(this.action, r11.action) == true) goto L12;
        return false;
    L12:
        if (q.b(this.icon, r11.icon) == true) goto L15;
        return false;
    L15:
        if (this.installed == r11.installed) goto L18;
        return false;
    L18:
        if (q.b(this.label_cn, r11.label_cn) == true) goto L21;
        return false;
    L21:
        if (q.b(this.label_en, r11.label_en) == true) goto L24;
        return false;
    L24:
        if (q.b(this.packageName, r11.packageName) == true) goto L27;
        return false;
    L27:
        if (this.versionCode == r11.versionCode) goto L29;
        return false;
    L29:
        return true;
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    public final boolean getInstalled() {
        return this.installed;
    }

    @NotNull
    public final String getLabel_cn() {
        return this.label_cn;
    }

    @NotNull
    public final String getLabel_en() {
        return this.label_en;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return (((((((((((this.action.hashCode() * 31) + this.icon.hashCode()) * 31) + Boolean.hashCode(this.installed)) * 31) + this.label_cn.hashCode()) * 31) + this.label_en.hashCode()) * 31) + this.packageName.hashCode()) * 31) + Long.hashCode(this.versionCode);
    }

    @NotNull
    public String toString() {
        return "OAppletInfo(action=" + this.action + ", icon=" + this.icon + ", installed=" + this.installed + ", label_cn=" + this.label_cn + ", label_en=" + this.label_en + ", packageName=" + this.packageName + ", versionCode=" + this.versionCode + ')';
    }

    public OAppletInfo(@NotNull String r10, @NotNull String r11, boolean r12, @NotNull String r13, @NotNull String r14, @NotNull String r15, long r16) {
        q.g(r10, "action");
        q.g(r11, ServerElements.ICON);
        q.g(r13, "label_cn");
        q.g(r14, "label_en");
        q.g(r15, "packageName");
        this.action = r10;
        this.icon = r11;
        this.installed = r12;
        this.label_cn = r13;
        this.label_en = r14;
        this.packageName = r15;
        this.versionCode = r16;
    }

    public /* synthetic */ OAppletInfo(String r10, String r11, boolean r12, String r13, String r14, String r15, long r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r17 & 2) == 0) goto L9;
        r11 = "";
    L9:
        if ((r17 & 4) == 0) goto L12;
        r12 = false;
    L12:
        if ((r17 & 8) == 0) goto L15;
        r13 = "";
    L15:
        if ((r17 & 16) == 0) goto L18;
        r14 = "";
    L18:
        if ((r17 & 32) == 0) goto L21;
        r15 = "";
    L21:
        if ((r17 & 64) == 0) goto L23;
        r16 = 0;
    L23:
        this(r10, r11, r12, r13, r14, r15, r16);
    }
}
