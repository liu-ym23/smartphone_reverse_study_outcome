package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements k<ItemListData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<ItemListData> f128253a;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k
    public final void clear() {
        this.f128253a.clear();
    }

    public m() {
        this.f128253a = new LinkedList();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k
    public final GiftPreloadResType a() {
        return GiftPreloadResType.ITEM_LIST_DATA;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k
    public final void b(h r100) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
        int r101 = this.f128253a.size();
    L4:
        if (r101 >= 500) goto L6;
        this.f128253a.add(new ItemListData());
        r101 = r101 + 1;
        goto L4
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k
    public final boolean c(h r100) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
        if (this.f128253a.size() <= 500) goto L6;
        return false;
    L6:
        if ((r100 instanceof h.i) == false) goto L8;
    L9:
        return true;
    L8:
        if ((r100 instanceof h.g) == true) goto L9;
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k
    public final ItemListData d(f r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        return this.f128253a.poll();
    }
}
