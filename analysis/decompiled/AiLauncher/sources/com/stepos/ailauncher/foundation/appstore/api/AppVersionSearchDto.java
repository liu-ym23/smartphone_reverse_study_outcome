package com.stepos.ailauncher.foundation.appstore.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionSearchDto;", "", "data", "", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDto;", "more", "", "pageSize", "", "<init>", "(Ljava/util/List;ZI)V", "getData", "()Ljava/util/List;", "getMore", "()Z", "getPageSize", "()I", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppVersionSearchDto {

    @SerializedName("data")
    private final List<AppVersionDto> data;

    @SerializedName("more")
    private final boolean more;

    @SerializedName("pageSize")
    private final int pageSize;

    public AppVersionSearchDto() {
        this(null, false, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppVersionSearchDto copy$default(AppVersionSearchDto appVersionSearchDto, List list, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = appVersionSearchDto.data;
        }
        if ((i11 & 2) != 0) {
            z10 = appVersionSearchDto.more;
        }
        if ((i11 & 4) != 0) {
            i10 = appVersionSearchDto.pageSize;
        }
        return appVersionSearchDto.copy(list, z10, i10);
    }

    public final List<AppVersionDto> component1() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getMore() {
        return this.more;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    public final AppVersionSearchDto copy(List<AppVersionDto> data, boolean more, int pageSize) {
        return new AppVersionSearchDto(data, more, pageSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppVersionSearchDto)) {
            return false;
        }
        AppVersionSearchDto appVersionSearchDto = (AppVersionSearchDto) other;
        return p.d(this.data, appVersionSearchDto.data) && this.more == appVersionSearchDto.more && this.pageSize == appVersionSearchDto.pageSize;
    }

    public final List<AppVersionDto> getData() {
        return this.data;
    }

    public final boolean getMore() {
        return this.more;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public int hashCode() {
        List<AppVersionDto> list = this.data;
        return ((((list == null ? 0 : list.hashCode()) * 31) + Boolean.hashCode(this.more)) * 31) + Integer.hashCode(this.pageSize);
    }

    public String toString() {
        return "AppVersionSearchDto(data=" + this.data + ", more=" + this.more + ", pageSize=" + this.pageSize + ")";
    }

    public AppVersionSearchDto(List<AppVersionDto> list, boolean z10, int i10) {
        this.data = list;
        this.more = z10;
        this.pageSize = i10;
    }

    public /* synthetic */ AppVersionSearchDto(List list, boolean z10, int i10, int i11, i iVar) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? 0 : i10);
    }
}
