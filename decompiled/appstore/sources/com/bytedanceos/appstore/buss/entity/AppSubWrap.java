package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JU\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AppSubWrap;", "", "name", "", ServerElements.GROUP_ID, ServerElements.TEMPLATE, "info_type", "apps", "", "Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;", "rows", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getApps", "()Ljava/util/List;", "getGroup_id", "()Ljava/lang/String;", "getInfo_type", "getName", "getRows", "()I", "getTemplate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppSubWrap {

    @Nullable
    private final List<AppSubEntity> apps;

    @Nullable
    private final String group_id;

    @Nullable
    private final String info_type;

    @Nullable
    private final String name;
    private final int rows;

    @Nullable
    private final String template;

    public AppSubWrap(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable List<AppSubEntity> r14, int r15) {
        this.name = r10;
        this.group_id = r11;
        this.template = r12;
        this.info_type = r13;
        this.apps = r14;
        this.rows = r15;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppSubWrap copy$default(AppSubWrap r10, String r11, String r12, String r13, String r14, List r15, int r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.name;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.group_id;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.template;
    L11:
        String r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.info_type;
    L14:
        String r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.apps;
    L17:
        List r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.rows;
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
    public final List<AppSubEntity> component5() {
        return this.apps;
    }

    public final int component6() {
        return this.rows;
    }

    @NotNull
    public final AppSubWrap copy(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable List<AppSubEntity> r14, int r15) {
        return new AppSubWrap(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppSubWrap) == true) goto L8;
        return false;
    L8:
        AppSubWrap r11 = (AppSubWrap) r10;
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
        if (this.rows == r11.rows) goto L26;
        return false;
    L26:
        return true;
    }

    @Nullable
    public final List<AppSubEntity> getApps() {
        return this.apps;
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

    public final int getRows() {
        return this.rows;
    }

    @Nullable
    public final String getTemplate() {
        return this.template;
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
        List<AppSubEntity> r23 = this.apps;
        if (r23 == null) goto L23;
        r11 = r23.hashCode();
    L23:
        return ((r22 + r11) * 31) + Integer.hashCode(this.rows);
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

    @NotNull
    public String toString() {
        return "AppSubWrap(name=" + this.name + ", group_id=" + this.group_id + ", template=" + this.template + ", info_type=" + this.info_type + ", apps=" + this.apps + ", rows=" + this.rows + ')';
    }
}
