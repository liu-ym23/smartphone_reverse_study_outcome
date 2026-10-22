package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f130622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f130623b;

    public m(Set<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "giftImageUriSet");
        this.f130623b = r110;
        this.f130622a = SetsKt.setOf(new String[]{"webcast/7ef47758a435313180e6b78b056dda4e.png", "webcast/722e56b42551d6490e5ebd9521287c67", "webcast/e9b7db267d0501b8963d8000c091e123.png", "webcast/5ddfcd51beaa7cad1294a4e517bc80fb.png", "webcast/4960c39f645d524beda5d50dc372510e.png", "webcast/11bcb8bdc16b66fb330346cb478c1c98", "webcast/d4006cb190c47aed60be5381e59a3696.png", "webcast/71801c53df3977b1470ac2afb8250ac1.png", "webcast/96e9bc9717d926732e37351fae827813.png", "webcast/2756f07818a73a8c79f024e959665110.png", "webcast/53f9109a6b72c2fa36392a8bfb57e0ea.png", "webcast/webcast_admin_badge.png", "webcast/subscribe_new_v3.png", "webcast/subscribe_new_yearly_v3.png"});
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.r
    public final List<String> a(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        List<String> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = (String) r103.next();
        int r105 = RevenueImageUrlService.f130574c;
        r102.add(RevenueImageUrlService.a.c(r104, null, 6));
        goto L4
    L6:
        return r102;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.r
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (((q) RevenueImageUrlServiceKt.f130579c.getValue()).b() == true) goto L7;
        return false;
    L7:
        if (this.f130622a.contains(r100) == false) goto L11;
        return true;
    L11:
        return this.f130623b.contains(r100);
    }
}
