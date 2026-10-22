package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AllRecommendWrap;", "", "type", "", "location", Card.KEY_ITEMS, "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "show_count", "(IILjava/util/List;I)V", "getItems", "()Ljava/util/List;", "getLocation", "()I", "getShow_count", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AllRecommendWrap {

    @NotNull
    private final List<CommonAppEntity> items;
    private final int location;
    private final int show_count;
    private final int type;

    public AllRecommendWrap(int r10, int r11, @NotNull List<CommonAppEntity> r12, int r13) {
        q.g(r12, Card.KEY_ITEMS);
        this.type = r10;
        this.location = r11;
        this.items = r12;
        this.show_count = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AllRecommendWrap copy$default(AllRecommendWrap r10, int r11, int r12, List r13, int r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.type;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.location;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.items;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.show_count;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    public final int component1() {
        return this.type;
    }

    public final int component2() {
        return this.location;
    }

    @NotNull
    public final List<CommonAppEntity> component3() {
        return this.items;
    }

    public final int component4() {
        return this.show_count;
    }

    @NotNull
    public final AllRecommendWrap copy(int r10, int r11, @NotNull List<CommonAppEntity> r12, int r13) {
        q.g(r12, Card.KEY_ITEMS);
        return new AllRecommendWrap(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AllRecommendWrap) == true) goto L8;
        return false;
    L8:
        AllRecommendWrap r11 = (AllRecommendWrap) r10;
        if (this.type == r11.type) goto L12;
        return false;
    L12:
        if (this.location == r11.location) goto L15;
        return false;
    L15:
        if (q.b(this.items, r11.items) == true) goto L18;
        return false;
    L18:
        if (this.show_count == r11.show_count) goto L20;
        return false;
    L20:
        return true;
    }

    @NotNull
    public final List<CommonAppEntity> getItems() {
        return this.items;
    }

    public final int getLocation() {
        return this.location;
    }

    public final int getShow_count() {
        return this.show_count;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.location)) * 31) + this.items.hashCode()) * 31) + Integer.hashCode(this.show_count);
    }

    @NotNull
    public String toString() {
        return "AllRecommendWrap(type=" + this.type + ", location=" + this.location + ", items=" + this.items + ", show_count=" + this.show_count + ')';
    }
}
