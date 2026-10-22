package com.bytedance.android.livesdk.livecommerce.promotion.card;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements QModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.ec.common.api.jump.model.e f150059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UpdateType f150060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f150061c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L12;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f150059a, r101.f150059a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f150060b, r101.f150060b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f150061c, r101.f150061c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.ec.common.api.jump.model.e r100 = this.f150059a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UpdateType r104 = this.f150060b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.f150061c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 88;
    }

    public final String toString() {
        return "PromotionCardItem(promotionParams=" + this.f150059a + ", bindType=" + this.f150060b + ", style=" + this.f150061c + ")";
    }

    public i(com.bytedance.android.ec.common.api.jump.model.e r100, UpdateType r101, k r102) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        Intrinsics.checkNotNullParameter(r101, "bindType");
        Intrinsics.checkNotNullParameter(r102, "style");
        this.f150059a = r100;
        this.f150060b = r101;
        this.f150061c = r102;
    }
}
