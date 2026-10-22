package com.obric.capabilitykit.entity;

import androidx.annotation.Keep;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/capabilitykit/entity/IndexProgress;", "", "left", "", PerfConsts.PERF_DISK_TOTAL, "(II)V", "getLeft", "()I", "getTotal", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IndexProgress {
    private final int left;
    private final int total;

    public IndexProgress(int r10, int r11) {
        this.left = r10;
        this.total = r11;
    }

    public static /* synthetic */ IndexProgress copy$default(IndexProgress r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.left;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.total;
    L9:
        return r10.copy(r11, r12);
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.total;
    }

    @NotNull
    public final IndexProgress copy(int r10, int r11) {
        return new IndexProgress(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof IndexProgress) == true) goto L8;
        return false;
    L8:
        IndexProgress r11 = (IndexProgress) r10;
        if (this.left == r11.left) goto L12;
        return false;
    L12:
        if (this.total == r11.total) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (Integer.hashCode(this.left) * 31) + Integer.hashCode(this.total);
    }

    @NotNull
    public String toString() {
        return "IndexProgress(left=" + this.left + ", total=" + this.total + ')';
    }
}
