package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/rc;", "", "", "themeId", "J", "getThemeId", "()J", "", "themeName", "Ljava/lang/String;", "getThemeName", "()Ljava/lang/String;", "", "Lcom/bytedance/android/livesdk/message/model/qc;", "roleList", "Ljava/util/List;", "getRoleList", "()Ljava/util/List;", "auditReason", "getAuditReason", "extra", "getExtra", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class rc implements vh7.h {

    @SerializedName("audit_reason")
    protected String auditReason;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("role_list")
    protected List<qc> roleList;

    @SerializedName("theme_id")
    protected long themeId;

    @SerializedName("theme_name")
    protected String themeName;

    public rc() {
        this.themeName = "";
        this.roleList = CollectionsKt.emptyList();
        this.auditReason = "";
        this.extra = "";
    }

    public rc(am3.g r100) {
        this.roleList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.themeId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.themeName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.roleList.add(new qc(r100));
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.auditReason = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 100) goto L15;
        this.extra = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.themeName != null) goto L25;
        this.themeName = "";
    L25:
        if (this.roleList.isEmpty() == false) goto L28;
        this.roleList = CollectionsKt.emptyList();
    L28:
        if (this.auditReason != null) goto L31;
        this.auditReason = "";
    L31:
        if (this.extra != null) goto L52;
        this.extra = "";
        return;
    }
}
