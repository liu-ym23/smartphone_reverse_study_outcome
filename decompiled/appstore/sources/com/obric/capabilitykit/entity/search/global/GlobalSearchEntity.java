package com.obric.capabilitykit.entity.search.global;

import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/capabilitykit/entity/search/global/GlobalSearchEntity;", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "params", "", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Ljava/util/List;)V", "getAppEntity", "()Lcom/obric/capabilitykit/entity/app/AppEntity;", "getParams", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalSearchEntity {

    @NotNull
    private final AppEntity appEntity;

    @NotNull
    private final List<InAppSearchEntityParam> params;

    public GlobalSearchEntity(@NotNull AppEntity r10, @NotNull List<InAppSearchEntityParam> r11) {
        q.g(r10, "appEntity");
        q.g(r11, "params");
        this.appEntity = r10;
        this.params = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalSearchEntity copy$default(GlobalSearchEntity r10, AppEntity r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.appEntity;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.params;
    L9:
        return r10.copy(r11, r12);
    }

    @NotNull
    public final AppEntity component1() {
        return this.appEntity;
    }

    @NotNull
    public final List<InAppSearchEntityParam> component2() {
        return this.params;
    }

    @NotNull
    public final GlobalSearchEntity copy(@NotNull AppEntity r10, @NotNull List<InAppSearchEntityParam> r11) {
        q.g(r10, "appEntity");
        q.g(r11, "params");
        return new GlobalSearchEntity(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GlobalSearchEntity) == true) goto L8;
        return false;
    L8:
        GlobalSearchEntity r11 = (GlobalSearchEntity) r10;
        if (q.b(this.appEntity, r11.appEntity) == true) goto L12;
        return false;
    L12:
        if (q.b(this.params, r11.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @NotNull
    public final AppEntity getAppEntity() {
        return this.appEntity;
    }

    @NotNull
    public final List<InAppSearchEntityParam> getParams() {
        return this.params;
    }

    public int hashCode() {
        return (this.appEntity.hashCode() * 31) + this.params.hashCode();
    }

    @NotNull
    public String toString() {
        return "GlobalSearchEntity(appEntity=" + this.appEntity + ", params=" + this.params + ')';
    }
}
