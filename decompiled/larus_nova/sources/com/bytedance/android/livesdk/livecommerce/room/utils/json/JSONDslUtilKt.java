package com.bytedance.android.livesdk.livecommerce.room.utils.json;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class JSONDslUtilKt {
    public static final JSONObject a(a... r100) {
        Intrinsics.checkNotNullParameter(r100, "envPair");
        JSONObject r101 = new JSONObject();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        a r104 = r100[r103];
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        r104.f151944a.invoke(r101);
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final a b(final String r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$objto");
        return new a(new JSONDslUtilKt$objto$1(r100, r101));
    }

    public static final a c(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$objto");
        Intrinsics.checkNotNullParameter(r101, "value");
        return new a(new JSONDslUtilKt$objto$3(r100, r101));
    }

    public static final a d(final String r100, final JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$objto");
        Intrinsics.checkNotNullParameter(r101, "value");
        return new a(new JSONDslUtilKt$objto$6(r100, r101));
    }

    public static final a e(final String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$objto");
        return new a(new JSONDslUtilKt$objto$5(r100, r101));
    }
}
