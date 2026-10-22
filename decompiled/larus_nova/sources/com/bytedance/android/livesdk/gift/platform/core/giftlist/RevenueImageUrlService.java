package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class RevenueImageUrlService implements dy0.c, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f130574c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f130575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f130576b;

    public static final class a {
        public a() {
        }

        public static final String a(String r110) {
            int r100 = RevenueImageUrlService.f130574c;
            if (StringsKt.startsWith$default(r110, "https://p", false, 2, null) == true) goto L5;
            return null;
        L5:
            if (StringsKt.endsWith$default(r110, "~tplv-obj.image", false, 2, null) == false) goto L15;
            int r101 = (StringsKt.indexOf$default(r110, "-webcast.douyinpic.com/img/webcast/", 0, false, 6, null) + 35) - 8;
            int r102 = r110.length() - 15;
            if (r101 < 0) goto L14;
            if (r101 < r102) goto L12;
            return null;
        L12:
            return r110.substring(r101, r102);
        L14:
            return null;
        L15:
            return null;
        }

        public static String b(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "imageSuffix");
            if (r100 != null) goto L5;
            return r100;
        L5:
            if (StringsKt.endsWith$default(r100, r101, false, 2, null) == true) goto L7;
            return r100;
        L7:
            if (((q) RevenueImageUrlServiceKt.f130579c.getValue()).e() == false) goto L13;
            if (r102 == false) goto L12;
            return r100.substring(0, r100.length() - r101.length()) + "~tplv-dy-vqe2-live-gift-v1:156:q80.heic?&biz_tag=aweme_webcast&sc=gift_icon&s=gift_wall";
        L12:
            return r100.substring(0, r100.length() - r101.length()) + "~tplv-obj.webp?&biz_tag=aweme_webcast&sc=gift_icon&s=gift_rich";
        L13:
            if (r102 == false) goto L17;
            return r100.substring(0, r100.length() - r101.length()) + "~tplv-obj.webp?&biz_tag=aweme_webcast&sc=gift_icon&s=gift_wall";
        L17:
            return r100.substring(0, r100.length() - r101.length()) + "~tplv-obj.webp?&biz_tag=aweme_webcast&sc=gift_icon&s=gift_rich";
        }

        public static /* synthetic */ String c(String r100, String r101, int r102) {
            if ((r102 & 2) == 0) goto L6;
            r101 = "~tplv-obj.image";
        L6:
            return b(r100, r101, false);
        }
    }

    static {
        new a();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public RevenueImageUrlService() {
        this.f130575a = new LinkedHashSet();
        this.f130576b = LazyKt.lazy(new RevenueImageUrlService$urlConverters$2(this));
    }
}
