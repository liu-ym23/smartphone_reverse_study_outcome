package com.stepos.ailauncher.foundation.appstore.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionSearchPage;", "", DidiCardProvider.KEY_ITEMS, "", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;", "more", "", "pageSize", "", "<init>", "(Ljava/util/List;ZI)V", "getItems", "()Ljava/util/List;", "getMore", "()Z", "getPageSize", "()I", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppVersionSearchPage {
    private final List<AppVersionItem> items;
    private final boolean more;
    private final int pageSize;

    public AppVersionSearchPage(List<AppVersionItem> items, boolean z10, int i10) {
        p.i(items, "items");
        this.items = items;
        this.more = z10;
        this.pageSize = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppVersionSearchPage copy$default(AppVersionSearchPage appVersionSearchPage, List list, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = appVersionSearchPage.items;
        }
        if ((i11 & 2) != 0) {
            z10 = appVersionSearchPage.more;
        }
        if ((i11 & 4) != 0) {
            i10 = appVersionSearchPage.pageSize;
        }
        return appVersionSearchPage.copy(list, z10, i10);
    }

    public final List<AppVersionItem> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getMore() {
        return this.more;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    public final AppVersionSearchPage copy(List<AppVersionItem> items, boolean more, int pageSize) {
        p.i(items, "items");
        return new AppVersionSearchPage(items, more, pageSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppVersionSearchPage)) {
            return false;
        }
        AppVersionSearchPage appVersionSearchPage = (AppVersionSearchPage) other;
        return p.d(this.items, appVersionSearchPage.items) && this.more == appVersionSearchPage.more && this.pageSize == appVersionSearchPage.pageSize;
    }

    public final List<AppVersionItem> getItems() {
        return this.items;
    }

    public final boolean getMore() {
        return this.more;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public int hashCode() {
        return (((this.items.hashCode() * 31) + Boolean.hashCode(this.more)) * 31) + Integer.hashCode(this.pageSize);
    }

    public String toString() {
        return "AppVersionSearchPage(items=" + this.items + ", more=" + this.more + ", pageSize=" + this.pageSize + ")";
    }
}
