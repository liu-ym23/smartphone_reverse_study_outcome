package com.bytedance.android.livesdk.livecommerce.promotion.card;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements QModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.ec.common.api.jump.model.g f150056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UpdateType f150057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f150058c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f150056a, r101.f150056a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f150057b, r101.f150057b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f150058c, r101.f150058c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.ec.common.api.jump.model.g r100 = this.f150056a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UpdateType r104 = this.f150057b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.f150058c;
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
        return 89;
    }

    public final String toString() {
        return "NewPromotionCardItem(promotionParams=" + this.f150056a + ", bindType=" + this.f150057b + ", style=" + this.f150058c + ")";
    }

    public h(com.bytedance.android.ec.common.api.jump.model.g r100, UpdateType r101, k r102) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        Intrinsics.checkNotNullParameter(r101, "bindType");
        Intrinsics.checkNotNullParameter(r102, "style");
        this.f150056a = r100;
        this.f150057b = r101;
        this.f150058c = r102;
    }
}
