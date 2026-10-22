package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class n implements r {

    public static final class a {
    }

    static {
    }

    public n() {
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
        if (((q) RevenueImageUrlServiceKt.f130579c.getValue()).c() == true) goto L6;
        return false;
    L6:
        if (StringsKt.startsWith$default(r100, "webcast/paygrade_badge_level_", false, 2, null) == true) goto L8;
    L25:
        return false;
    L8:
        if (StringsKt.indexOf$default(r100, RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, 0, false, 6, null) != 33) goto L25;
        char r101 = r100.charAt(29);
        if ('4' > r101) goto L25;
        if ('7' < r101) goto L25;
        if (Character.isDigit(r100.charAt(30)) == false) goto L25;
        if (r100.charAt(31) != '_') goto L25;
        char r102 = r100.charAt(32);
        if ('1' > r102) goto L25;
        if ('3' < r102) goto L25;
        return true;
    }
}
