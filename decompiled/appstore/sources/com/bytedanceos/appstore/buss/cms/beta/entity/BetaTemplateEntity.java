package com.bytedanceos.appstore.buss.cms.beta.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaTemplateEntity;", "", "templateName", "", "betaElementList", "", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaElementEntity;", "(Ljava/lang/String;Ljava/util/List;)V", "getBetaElementList", "()Ljava/util/List;", "getTemplateName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BetaTemplateEntity {

    @SerializedName("data")
    @NotNull
    private final List<BetaElementEntity<?>> betaElementList;

    @SerializedName(ServerElements.TEMPLATE)
    @NotNull
    private final String templateName;

    /* JADX WARN: Multi-variable type inference failed */
    public BetaTemplateEntity(@NotNull String r10, @NotNull List<? extends BetaElementEntity<?>> r11) {
        q.g(r10, "templateName");
        q.g(r11, "betaElementList");
        this.templateName = r10;
        this.betaElementList = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BetaTemplateEntity copy$default(BetaTemplateEntity r10, String r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.templateName;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.betaElementList;
    L9:
        return r10.copy(r11, r12);
    }

    @NotNull
    public final String component1() {
        return this.templateName;
    }

    @NotNull
    public final List<BetaElementEntity<?>> component2() {
        return this.betaElementList;
    }

    @NotNull
    public final BetaTemplateEntity copy(@NotNull String r10, @NotNull List<? extends BetaElementEntity<?>> r11) {
        q.g(r10, "templateName");
        q.g(r11, "betaElementList");
        return new BetaTemplateEntity(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof BetaTemplateEntity) == true) goto L8;
        return false;
    L8:
        BetaTemplateEntity r11 = (BetaTemplateEntity) r10;
        if (q.b(this.templateName, r11.templateName) == true) goto L12;
        return false;
    L12:
        if (q.b(this.betaElementList, r11.betaElementList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @NotNull
    public final List<BetaElementEntity<?>> getBetaElementList() {
        return this.betaElementList;
    }

    @NotNull
    public final String getTemplateName() {
        return this.templateName;
    }

    public int hashCode() {
        return (this.templateName.hashCode() * 31) + this.betaElementList.hashCode();
    }

    @NotNull
    public String toString() {
        return "BetaTemplateEntity(templateName=" + this.templateName + ", betaElementList=" + this.betaElementList + ')';
    }
}
