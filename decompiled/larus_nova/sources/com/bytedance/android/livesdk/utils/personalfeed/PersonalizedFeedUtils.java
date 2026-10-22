package com.bytedance.android.livesdk.utils.personalfeed;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.ee1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class PersonalizedFeedUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f159121a = null;

    public static ee1 b() {
        return (ee1) f159121a.getValue();
    }

    static {
        f159121a = LazyKt.lazy(PersonalizedFeedUtils$config$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean c() {
        return b().b();
    }

    @JvmStatic
    public static final boolean a(Bundle r110) {
        Intrinsics.checkNotNullParameter("single_request", "from");
        boolean r100 = false;
        if (c() == true) goto L6;
        return false;
    L6:
        if (b().g() != 1) goto L8;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L12;
    L46:
        e("PersonalizedFeedUtils", "canRequest:" + r100 + ", from:single_request");
        return r100;
    L12:
        if (Intrinsics.areEqual("single_request", "single_request") == false) goto L46;
        if (r110 == null) goto L46;
        String r102 = r110.getString("enter_from_merge", "");
        String r103 = r110.getString("enter_method", "");
        boolean r104 = r110.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_PREVIEW_LANDE_SCAPE_ENTER, false);
        int r105 = r110.getInt(ILiveRoomPlayFragmentConstant.EXTRA_PERSONALIZED_FEED_BACKEND_COUNT, -1);
        boolean r111 = r110.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_PREVIEW_LIVE_MIX, false);
        if (r105 == 0) goto L18;
    L45:
        e("PersonalizedFeedUtils", "canRequest:" + r100 + ", from:single_request, enterFromMerge:" + r102 + ", enterMethod:" + r103 + ", personalizedIndex " + r105 + "，isPreviewLandscapeEnter：" + r104 + ", isEnterFromPreviewLiveMix:" + r111);
        goto L46
    L18:
        if (c() == false) goto L40;
        if (r103 == null) goto L40;
        if (r102 == null) goto L40;
        String r106 = r102 + '-' + r103;
        List<String> r107 = b().d();
        if (r107 == null) goto L40;
        List<String> r108 = r107;
        if ((r108 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r109 = r108.iterator();
    L33:
        if (r109.hasNext() == false) goto L37;
        if (StringsKt.startsWith$default(r106, (String) r109.next(), false, 2, null) == false) goto L33;
        boolean r112 = true;
    L38:
        if (r112 != true) goto L40;
        boolean r113 = true;
    L41:
        if (r113 == false) goto L45;
        if (r104 == true) goto L45;
        if (r111 == true) goto L45;
        r100 = true;
    L37:
        r112 = false;
        goto L38
    L29:
        if (r108.isEmpty() == false) goto L31;
    L40:
        r113 = false;
        goto L41
    L8:
        r101 = false;
        goto L10
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ALogger.e("PersonalizedFeedUtils", "subTag:" + r100 + ", msg:" + r101);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ALogger.i("PersonalizedFeedUtils", "subTag:" + r100 + ", msg:" + r101);
    }
}
