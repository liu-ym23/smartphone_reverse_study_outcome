package com.stepos.ailauncher.foundation.appstore.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionListDto;", "", "data", "", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDto;", "page", "", "pageSize", "total", "", "more", "", "<init>", "(Ljava/util/List;IIJZ)V", "getData", "()Ljava/util/List;", "getPage", "()I", "getPageSize", "getTotal", "()J", "getMore", "()Z", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppVersionListDto {

    @SerializedName("data")
    private final List<AppVersionDto> data;

    @SerializedName("more")
    private final boolean more;

    @SerializedName("page")
    private final int page;

    @SerializedName("pageSize")
    private final int pageSize;

    @SerializedName("total")
    private final long total;

    public AppVersionListDto() {
        this(null, 0, 0, 0L, false, 31, null);
    }

    public static /* synthetic */ AppVersionListDto copy$default(AppVersionListDto appVersionListDto, List list, int i10, int i11, long j10, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = appVersionListDto.data;
        }
        if ((i12 & 2) != 0) {
            i10 = appVersionListDto.page;
        }
        if ((i12 & 4) != 0) {
            i11 = appVersionListDto.pageSize;
        }
        if ((i12 & 8) != 0) {
            j10 = appVersionListDto.total;
        }
        if ((i12 & 16) != 0) {
            z10 = appVersionListDto.more;
        }
        boolean z11 = z10;
        int i13 = i11;
        return appVersionListDto.copy(list, i10, i13, j10, z11);
    }

    public final List<AppVersionDto> component1() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTotal() {
        return this.total;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getMore() {
        return this.more;
    }

    public final AppVersionListDto copy(List<AppVersionDto> data, int page, int pageSize, long total, boolean more) {
        return new AppVersionListDto(data, page, pageSize, total, more);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppVersionListDto)) {
            return false;
        }
        AppVersionListDto appVersionListDto = (AppVersionListDto) other;
        return p.d(this.data, appVersionListDto.data) && this.page == appVersionListDto.page && this.pageSize == appVersionListDto.pageSize && this.total == appVersionListDto.total && this.more == appVersionListDto.more;
    }

    public final List<AppVersionDto> getData() {
        return this.data;
    }

    public final boolean getMore() {
        return this.more;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final long getTotal() {
        return this.total;
    }

    public int hashCode() {
        List<AppVersionDto> list = this.data;
        return ((((((((list == null ? 0 : list.hashCode()) * 31) + Integer.hashCode(this.page)) * 31) + Integer.hashCode(this.pageSize)) * 31) + Long.hashCode(this.total)) * 31) + Boolean.hashCode(this.more);
    }

    public String toString() {
        return "AppVersionListDto(data=" + this.data + ", page=" + this.page + ", pageSize=" + this.pageSize + ", total=" + this.total + ", more=" + this.more + ")";
    }

    public AppVersionListDto(List<AppVersionDto> list, int i10, int i11, long j10, boolean z10) {
        this.data = list;
        this.page = i10;
        this.pageSize = i11;
        this.total = j10;
        this.more = z10;
    }

    public /* synthetic */ AppVersionListDto(List list, int i10, int i11, long j10, boolean z10, int i12, i iVar) {
        this((i12 & 1) != 0 ? null : list, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? 0L : j10, (i12 & 16) != 0 ? false : z10);
    }
}
