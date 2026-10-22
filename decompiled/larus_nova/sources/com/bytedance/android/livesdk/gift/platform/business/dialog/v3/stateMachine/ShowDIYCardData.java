package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowDIYCardData;", "", "canShow", "", "renderParams", "", "", "(ZLjava/util/Map;)V", "getCanShow", "()Z", "getRenderParams", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowDIYCardData {
    private final boolean canShow;
    private final Map<String, Object> renderParams;

    /* JADX WARN: Multi-variable type inference failed */
    public ShowDIYCardData() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowDIYCardData copy$default(ShowDIYCardData r100, boolean r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.canShow;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.renderParams;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.canShow;
    }

    public final Map<String, Object> component2() {
        return this.renderParams;
    }

    public final ShowDIYCardData copy(boolean r100, Map<String, ? extends Object> r101) {
        return new ShowDIYCardData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShowDIYCardData) == false) goto L10;
        ShowDIYCardData r101 = (ShowDIYCardData) r100;
        if (this.canShow == r101.canShow) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.renderParams, r101.renderParams) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r100 = this.canShow;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Map<String, Object> r103 = this.renderParams;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public String toString() {
        return "ShowDIYCardData(canShow=" + this.canShow + ", renderParams=" + this.renderParams + ")";
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public final Map<String, Object> getRenderParams() {
        return this.renderParams;
    }

    public ShowDIYCardData(boolean r100, Map<String, ? extends Object> r101) {
        this.canShow = r100;
        this.renderParams = r101;
    }

    public /* synthetic */ ShowDIYCardData(boolean r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
