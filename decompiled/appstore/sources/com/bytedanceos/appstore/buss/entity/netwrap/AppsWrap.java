package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.appstore.buss.entity.BaseWrap;
import com.bytedanceos.common.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/AppsWrap;", "T", "Lcom/bytedanceos/appstore/buss/entity/BaseWrap;", "apps", "", "(Ljava/util/List;)V", "getApps", "()Ljava/util/List;", "component1", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppsWrap<T> extends BaseWrap {

    @NotNull
    private final List<T> apps;

    /* JADX WARN: Multi-variable type inference failed */
    public AppsWrap(@NotNull List<? extends T> r10) {
        q.g(r10, "apps");
        this.apps = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppsWrap copy$default(AppsWrap r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.apps;
    L6:
        return r10.copy(r11);
    }

    @NotNull
    public final List<T> component1() {
        return this.apps;
    }

    @NotNull
    public final AppsWrap<T> copy(@NotNull List<? extends T> r10) {
        q.g(r10, "apps");
        return new AppsWrap(r10);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppsWrap) == true) goto L9;
        return false;
    L9:
        if (q.b(this.apps, ((AppsWrap) r10).apps) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @NotNull
    public final List<T> getApps() {
        return this.apps;
    }

    public int hashCode() {
        return this.apps.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppsWrap(apps=" + this.apps + ')';
    }
}
