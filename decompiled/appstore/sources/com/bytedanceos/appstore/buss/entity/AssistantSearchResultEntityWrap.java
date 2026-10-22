package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J%\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AssistantSearchResultEntityWrap;", "", "apps", "", "Lcom/bytedanceos/appstore/buss/entity/AssistantSearchResultEntity;", ServerElements.HAS_MORE, "", "(Ljava/util/List;Z)V", "getApps", "()Ljava/util/List;", "setApps", "(Ljava/util/List;)V", "getHas_more", "()Z", "component1", "component2", "copy", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AssistantSearchResultEntityWrap {

    @Nullable
    private List<AssistantSearchResultEntity> apps;
    private final boolean has_more;

    public AssistantSearchResultEntityWrap(@Nullable List<AssistantSearchResultEntity> r10, boolean r11) {
        this.apps = r10;
        this.has_more = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AssistantSearchResultEntityWrap copy$default(AssistantSearchResultEntityWrap r10, List r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.apps;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.has_more;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final List<AssistantSearchResultEntity> component1() {
        return this.apps;
    }

    public final boolean component2() {
        return this.has_more;
    }

    @NotNull
    public final AssistantSearchResultEntityWrap copy(@Nullable List<AssistantSearchResultEntity> r10, boolean r11) {
        return new AssistantSearchResultEntityWrap(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AssistantSearchResultEntityWrap) == true) goto L8;
        return false;
    L8:
        AssistantSearchResultEntityWrap r11 = (AssistantSearchResultEntityWrap) r10;
        if (q.b(this.apps, r11.apps) == true) goto L12;
        return false;
    L12:
        if (this.has_more == r11.has_more) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final List<AssistantSearchResultEntity> getApps() {
        return this.apps;
    }

    public final boolean getHas_more() {
        return this.has_more;
    }

    public int hashCode() {
        List<AssistantSearchResultEntity> r10 = this.apps;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return (r11 * 31) + Boolean.hashCode(this.has_more);
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final void setApps(@Nullable List<AssistantSearchResultEntity> r10) {
        this.apps = r10;
    }

    @NotNull
    public String toString() {
        return "AssistantSearchResultEntityWrap(apps=" + this.apps + ", has_more=" + this.has_more + ')';
    }
}
