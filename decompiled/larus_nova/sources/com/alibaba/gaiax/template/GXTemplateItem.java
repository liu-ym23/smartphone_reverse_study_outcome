package com.alibaba.gaiax.template;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000b¨\u0006#"}, d2 = {"Lcom/alibaba/gaiax/template/GXTemplateItem;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bizId", "", GXTemplateKey.GAIAX_TEMPLATE_ID, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "getBizId", "()Ljava/lang/String;", "setBizId", "(Ljava/lang/String;)V", "bundle", "getBundle", "setBundle", "getContext", "()Landroid/content/Context;", "isLocal", "", "()Z", "setLocal", "(Z)V", "getTemplateId", GXTemplateKey.GAIAX_TEMPLATE_VERSION, "getTemplateVersion", "setTemplateVersion", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXTemplateItem {
    private String bizId;
    private String bundle;
    private final Context context;
    private boolean isLocal;
    private final String templateId;
    private String templateVersion;

    public static /* synthetic */ GXTemplateItem copy$default(GXTemplateItem r100, Context r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.context;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.bizId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.templateId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Context component1() {
        return this.context;
    }

    public final String component2() {
        return this.bizId;
    }

    public final String component3() {
        return this.templateId;
    }

    public final GXTemplateItem copy(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bizId");
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_TEMPLATE_ID);
        return new GXTemplateItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXTemplateItem) == true) goto L8;
        return false;
    L8:
        GXTemplateItem r101 = (GXTemplateItem) r100;
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizId, r101.bizId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templateId, r101.templateId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.context.hashCode() * 31) + this.bizId.hashCode()) * 31) + this.templateId.hashCode();
    }

    public String toString() {
        return "GXTemplateItem(context=" + this.context + ", bizId='" + this.bizId + "', templateId='" + this.templateId + "', templateVersion='" + this.templateVersion + '\'';
    }

    public final String getBizId() {
        return this.bizId;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final String getTemplateVersion() {
        return this.templateVersion;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public final void setBizId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bizId = r100;
    }

    public final void setBundle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bundle = r100;
    }

    public final void setLocal(boolean r100) {
        this.isLocal = r100;
    }

    public final void setTemplateVersion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templateVersion = r100;
    }

    public GXTemplateItem(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bizId");
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_TEMPLATE_ID);
        this.context = r100;
        this.bizId = r101;
        this.templateId = r102;
        this.bundle = "";
        this.templateVersion = "";
    }
}
