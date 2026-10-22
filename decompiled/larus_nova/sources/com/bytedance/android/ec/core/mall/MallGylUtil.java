package com.bytedance.android.ec.core.mall;

import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class MallGylUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f45107a = null;

    static {
        f45107a = LazyKt.lazy(MallGylUtil$config$2.INSTANCE);
    }

    public static String a() {
        String r100 = ((a) f45107a.getValue()).b();
        if (r100 != null) goto L6;
        return "hybrid://lynxview?enable_code_cache=1&enable_js_runtime=true&surl=https%3A%2F%2Flf-ecom-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fecom%2Flynx%2Fecom_mall_cards_saas%2Fcards%2Fpage_card%2Ftemplate.js";
    L6:
        return r100;
    }

    public static String b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "pageName");
        boolean r100 = true;
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        return null;
    L9:
        String r102 = ((a) f45107a.getValue()).a();
        if (r102 != null) goto L12;
    L15:
        if (r100 == false) goto L17;
        r102 = "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/ecom/lynx/ecom_mall_cards_saas/config.json";
    L17:
        String r103 = r102;
        if (StringsKt.contains$default(r103, ComposerHelper.CONFIG_FILE_NAME, false, 2, null) == true) goto L20;
        return null;
    L20:
        return StringsKt.replace$default(r103, ComposerHelper.CONFIG_FILE_NAME, r110.concat("_config.json"), false, 4, null);
    L12:
        if (r102.length() == 0) goto L15;
        r100 = false;
        goto L15
    L5:
        r101 = false;
        goto L7
    }
}
