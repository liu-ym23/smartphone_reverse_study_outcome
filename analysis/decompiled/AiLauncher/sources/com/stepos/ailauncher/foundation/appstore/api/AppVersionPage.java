package com.stepos.ailauncher.foundation.appstore.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionPage;", "", DidiCardProvider.KEY_ITEMS, "", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;", "page", "", "total", "", "more", "", "<init>", "(Ljava/util/List;IJZ)V", "getItems", "()Ljava/util/List;", "getPage", "()I", "getTotal", "()J", "getMore", "()Z", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppVersionPage {
    private final List<AppVersionItem> items;
    private final boolean more;
    private final int page;
    private final long total;

    public AppVersionPage(List<AppVersionItem> items, int i10, long j10, boolean z10) {
        p.i(items, "items");
        this.items = items;
        this.page = i10;
        this.total = j10;
        this.more = z10;
    }

    public static /* synthetic */ AppVersionPage copy$default(AppVersionPage appVersionPage, List list, int i10, long j10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = appVersionPage.items;
        }
        if ((i11 & 2) != 0) {
            i10 = appVersionPage.page;
        }
        if ((i11 & 4) != 0) {
            j10 = appVersionPage.total;
        }
        if ((i11 & 8) != 0) {
            z10 = appVersionPage.more;
        }
        boolean z11 = z10;
        return appVersionPage.copy(list, i10, j10, z11);
    }

    public final List<AppVersionItem> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTotal() {
        return this.total;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getMore() {
        return this.more;
    }

    public final AppVersionPage copy(List<AppVersionItem> items, int page, long total, boolean more) {
        p.i(items, "items");
        return new AppVersionPage(items, page, total, more);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppVersionPage)) {
            return false;
        }
        AppVersionPage appVersionPage = (AppVersionPage) other;
        return p.d(this.items, appVersionPage.items) && this.page == appVersionPage.page && this.total == appVersionPage.total && this.more == appVersionPage.more;
    }

    public final List<AppVersionItem> getItems() {
        return this.items;
    }

    public final boolean getMore() {
        return this.more;
    }

    public final int getPage() {
        return this.page;
    }

    public final long getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((((this.items.hashCode() * 31) + Integer.hashCode(this.page)) * 31) + Long.hashCode(this.total)) * 31) + Boolean.hashCode(this.more);
    }

    public String toString() {
        return "AppVersionPage(items=" + this.items + ", page=" + this.page + ", total=" + this.total + ", more=" + this.more + ")";
    }
}
