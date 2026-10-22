package com.bytedance.android.ec.window.base.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b*\u0010+J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003JR\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0017\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0007R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\nR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/WindowSearchResultV2;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lcom/bytedance/android/ec/window/base/repository/dto/m;", "component1", "", "component2", "()Ljava/lang/Boolean;", "", "component3", "()Ljava/lang/Long;", "Lcom/bytedance/android/ec/window/base/repository/dto/h;", "component4", "Lcom/bytedance/android/ec/window/base/repository/dto/e;", "component5", "items", "hasMore", EffectConfiguration.KEY_CURSOR, "config", "extra", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/bytedance/android/ec/window/base/repository/dto/h;Lcom/bytedance/android/ec/window/base/repository/dto/e;)Lcom/bytedance/android/ec/window/base/repository/dto/WindowSearchResultV2;", "", "toString", "", "hashCode", "", "other", "equals", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Ljava/lang/Boolean;", "getHasMore", "Ljava/lang/Long;", "getCursor", "Lcom/bytedance/android/ec/window/base/repository/dto/h;", "getConfig", "()Lcom/bytedance/android/ec/window/base/repository/dto/h;", "Lcom/bytedance/android/ec/window/base/repository/dto/e;", "getExtra", "()Lcom/bytedance/android/ec/window/base/repository/dto/e;", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/bytedance/android/ec/window/base/repository/dto/h;Lcom/bytedance/android/ec/window/base/repository/dto/e;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchResultV2 extends CommerceBaseResponse {

    @SerializedName("global_doodle_config")
    private final h config;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final Long cursor;

    @SerializedName("extra")
    private final e extra;

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("items")
    private final List<m> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WindowSearchResultV2 copy$default(WindowSearchResultV2 r100, List r101, Boolean r102, Long r103, h r104, e r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.items;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.hasMore;
    L8:
        Boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.cursor;
    L11:
        Long r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.config;
    L14:
        h r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.extra;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<m> component1() {
        return this.items;
    }

    public final Boolean component2() {
        return this.hasMore;
    }

    public final Long component3() {
        return this.cursor;
    }

    public final h component4() {
        return this.config;
    }

    public final e component5() {
        return this.extra;
    }

    public final WindowSearchResultV2 copy(List<m> r100, Boolean r101, Long r110, h r111, e r112) {
        return new WindowSearchResultV2(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WindowSearchResultV2) == false) goto L16;
        WindowSearchResultV2 r101 = (WindowSearchResultV2) r100;
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cursor, r101.cursor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        List<m> r100 = this.items;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.hasMore;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.cursor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.config;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        e r113 = this.extra;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "WindowSearchResultV2(items=" + this.items + ", hasMore=" + this.hasMore + ", cursor=" + this.cursor + ", config=" + this.config + ", extra=" + this.extra + ")";
    }

    public final h getConfig() {
        return this.config;
    }

    public final Long getCursor() {
        return this.cursor;
    }

    public final e getExtra() {
        return this.extra;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final List<m> getItems() {
        return this.items;
    }

    public WindowSearchResultV2(List<m> r100, Boolean r101, Long r102, h r103, e r104) {
        this.items = r100;
        this.hasMore = r101;
        this.cursor = r102;
        this.config = r103;
        this.extra = r104;
    }
}
