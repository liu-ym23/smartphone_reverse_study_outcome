package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;", "Ljava/io/Serializable;", "enableMediaAsyncScroll", "", "enableSliceAsyncScroll", "(ZZ)V", "getEnableMediaAsyncScroll", "()Z", "getEnableSliceAsyncScroll", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Config implements Serializable {

    @SerializedName("enable_media_async_scroll")
    private final boolean enableMediaAsyncScroll;

    @SerializedName("enable_slice_async_scroll")
    private final boolean enableSliceAsyncScroll;

    public Config() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ Config copy$default(Config r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enableMediaAsyncScroll;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.enableSliceAsyncScroll;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enableMediaAsyncScroll;
    }

    public final boolean component2() {
        return this.enableSliceAsyncScroll;
    }

    public final Config copy(boolean r100, boolean r101) {
        return new Config(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Config) == false) goto L10;
        Config r101 = (Config) r100;
        if (this.enableMediaAsyncScroll == r101.enableMediaAsyncScroll) goto L8;
        return false;
    L8:
        if (this.enableSliceAsyncScroll == r101.enableSliceAsyncScroll) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r100 = this.enableMediaAsyncScroll;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.enableSliceAsyncScroll;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public String toString() {
        return "Config(enableMediaAsyncScroll=" + this.enableMediaAsyncScroll + ", enableSliceAsyncScroll=" + this.enableSliceAsyncScroll + ")";
    }

    public final boolean getEnableMediaAsyncScroll() {
        return this.enableMediaAsyncScroll;
    }

    public final boolean getEnableSliceAsyncScroll() {
        return this.enableSliceAsyncScroll;
    }

    public Config(boolean r100, boolean r101) {
        this.enableMediaAsyncScroll = r100;
        this.enableSliceAsyncScroll = r101;
    }

    public /* synthetic */ Config(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
