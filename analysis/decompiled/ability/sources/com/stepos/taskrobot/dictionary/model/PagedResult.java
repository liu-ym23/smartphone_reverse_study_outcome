package com.stepos.taskrobot.dictionary.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/stepos/taskrobot/dictionary/model/PagedResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "total", "", "rows", "", AppAgent.CONSTRUCT, "(ILjava/util/List;)V", "getTotal", "()I", "getRows", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PagedResult<T> {

    @SerializedName("rows")
    private final List<T> rows;

    @SerializedName("total")
    private final int total;

    public PagedResult() {
        this(0, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PagedResult copy$default(PagedResult pagedResult, int i, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = pagedResult.total;
        }
        if ((i6 & 2) != 0) {
            list = pagedResult.rows;
        }
        return pagedResult.copy(i, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final List<T> component2() {
        return this.rows;
    }

    public final PagedResult<T> copy(int total, List<? extends T> rows) {
        k.f(rows, "rows");
        return new PagedResult<>(total, rows);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagedResult)) {
            return false;
        }
        PagedResult pagedResult = (PagedResult) other;
        return this.total == pagedResult.total && k.b(this.rows, pagedResult.rows);
    }

    public final List<T> getRows() {
        return this.rows;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return this.rows.hashCode() + (Integer.hashCode(this.total) * 31);
    }

    public String toString() {
        return "PagedResult(total=" + this.total + ", rows=" + this.rows + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PagedResult(int i, List<? extends T> rows) {
        k.f(rows, "rows");
        this.total = i;
        this.rows = rows;
    }

    public PagedResult(int i, List list, int i6, e eVar) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? EmptyList.f4893a : list);
    }
}
