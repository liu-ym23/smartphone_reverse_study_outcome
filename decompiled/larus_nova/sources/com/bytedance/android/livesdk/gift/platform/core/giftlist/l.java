package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Triple<String, String, IntRange>> f130621a;

    public static final class a {
    }

    static {
    }

    public l() {
        this.f130621a = CollectionsKt.listOf(new Triple[]{new Triple("webcast/fansclub_new_advanced_badge_", "_xmp.png", new IntRange(1, 20)), new Triple("webcast/ranklist_fansclub_pop_advanced_badge_", "_xmp.png", new IntRange(1, 20)), new Triple("webcast/ranklist_fansclub_pop_super_badge_", "_xmp.png", new IntRange(1, 20)), new Triple("webcast/fansclub_effect_badge_", RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, new IntRange(10, 20))});
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
    public final boolean b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        if (((q) RevenueImageUrlServiceKt.f130579c.getValue()).a() == true) goto L5;
        return false;
    L5:
        Iterator<T> r100 = this.f130621a.iterator();
    L6:
        Object r101 = null;
        if (r100.hasNext() == false) goto L11;
        Object r102 = r100.next();
        if (StringsKt.startsWith$default(r110, (String) ((Triple) r102).getFirst(), false, 2, null) == false) goto L6;
        r101 = r102;
    L11:
        Triple r103 = (Triple) r101;
        if (r103 == null) goto L23;
        String r104 = (String) r103.component1();
        String r105 = (String) r103.component2();
        IntRange r106 = (IntRange) r103.component3();
        int r107 = StringsKt.indexOf$default(r110, r105, 0, false, 6, null);
        if (r107 <= r104.length()) goto L23;
        Integer r111 = StringsKt.toIntOrNull(r110.substring(r104.length(), r107));
        if (r111 != null) goto L18;
    L20:
        boolean r112 = false;
    L21:
        if (r112 == false) goto L23;
        return true;
    L18:
        if (r106.contains(r111.intValue()) == false) goto L20;
        r112 = true;
    L23:
        return false;
    }
}
