package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements r {

    public static final class a {
    }

    static {
    }

    public o() {
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
        boolean r101 = false;
        if (((q) RevenueImageUrlServiceKt.f130579c.getValue()).d() == true) goto L6;
        return false;
    L6:
        if (StringsKt.startsWith$default(r100, "webcast/new_user_grade_level_v1_", false, 2, null) == false) goto L17;
        int r102 = StringsKt.indexOf$default(r100, RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, 0, false, 6, null);
        if (r102 <= 32) goto L17;
        Integer r103 = StringsKt.toIntOrNull(r100.substring(32, r102));
        IntRange r104 = new IntRange(1, 75);
        if (r103 != null) goto L12;
    L14:
        if (r101 == false) goto L17;
        return true;
    L12:
        if (r104.contains(r103.intValue()) == false) goto L14;
        r101 = true;
    L17:
        return Intrinsics.areEqual(r100, "webcast/hide_paygrade_badge_v2.png");
    }
}
