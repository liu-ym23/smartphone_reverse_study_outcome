package com.bytedance.android.livesdkapi.commerce.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/commerce/event/ModifiedPromotionEvent;", "", "num", "", "(I)V", "getNum", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ModifiedPromotionEvent {
    private final int num;

    public ModifiedPromotionEvent() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public static /* synthetic */ ModifiedPromotionEvent copy$default(ModifiedPromotionEvent r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.num;
    L6:
        return r100.copy(r101);
    }

    public final int component1() {
        return this.num;
    }

    public final ModifiedPromotionEvent copy(int r100) {
        return new ModifiedPromotionEvent(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ModifiedPromotionEvent) == true) goto L6;
        return false;
    L6:
        if (this.num == ((ModifiedPromotionEvent) r100).num) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        return this.num;
    }

    public String toString() {
        return "ModifiedPromotionEvent(num=" + this.num + ")";
    }

    public final int getNum() {
        return this.num;
    }

    public ModifiedPromotionEvent(int r100) {
        this.num = r100;
    }

    public /* synthetic */ ModifiedPromotionEvent(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
