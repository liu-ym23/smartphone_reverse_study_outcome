package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/PushDevAppsEntity;", "", ServerElements.DEVELOPER, "", "size", "page", "developerId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeveloper", "()Ljava/lang/String;", "getDeveloperId", "getPage", "getSize", "component1", "component2", "component3", "component4", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PushDevAppsEntity {

    @NotNull
    private final String developer;

    @SerializedName(ServerElements.DEVER_ID)
    @NotNull
    private final String developerId;

    @NotNull
    private final String page;

    @NotNull
    private final String size;

    public PushDevAppsEntity(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull String r13) {
        q.g(r10, ServerElements.DEVELOPER);
        q.g(r11, "size");
        q.g(r12, "page");
        q.g(r13, "developerId");
        this.developer = r10;
        this.size = r11;
        this.page = r12;
        this.developerId = r13;
    }

    public static /* synthetic */ PushDevAppsEntity copy$default(PushDevAppsEntity r10, String r11, String r12, String r13, String r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.developer;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.size;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.page;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.developerId;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @NotNull
    public final String component1() {
        return this.developer;
    }

    @NotNull
    public final String component2() {
        return this.size;
    }

    @NotNull
    public final String component3() {
        return this.page;
    }

    @NotNull
    public final String component4() {
        return this.developerId;
    }

    @NotNull
    public final PushDevAppsEntity copy(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull String r13) {
        q.g(r10, ServerElements.DEVELOPER);
        q.g(r11, "size");
        q.g(r12, "page");
        q.g(r13, "developerId");
        return new PushDevAppsEntity(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PushDevAppsEntity) == true) goto L8;
        return false;
    L8:
        PushDevAppsEntity r11 = (PushDevAppsEntity) r10;
        if (q.b(this.developer, r11.developer) == true) goto L12;
        return false;
    L12:
        if (q.b(this.size, r11.size) == true) goto L15;
        return false;
    L15:
        if (q.b(this.page, r11.page) == true) goto L18;
        return false;
    L18:
        if (q.b(this.developerId, r11.developerId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @NotNull
    public final String getDeveloper() {
        return this.developer;
    }

    @NotNull
    public final String getDeveloperId() {
        return this.developerId;
    }

    @NotNull
    public final String getPage() {
        return this.page;
    }

    @NotNull
    public final String getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((((this.developer.hashCode() * 31) + this.size.hashCode()) * 31) + this.page.hashCode()) * 31) + this.developerId.hashCode();
    }

    @NotNull
    public String toString() {
        return "PushDevAppsEntity(developer=" + this.developer + ", size=" + this.size + ", page=" + this.page + ", developerId=" + this.developerId + ')';
    }
}
