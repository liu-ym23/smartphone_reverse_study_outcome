package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.shopping.api.mall.common.tools.NativeMallGeckoHelper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PreInitCreateLynxViewTask4AnnieX$lynxSchema$2 extends Lambda implements Function0<String> {
    public static final PreInitCreateLynxViewTask4AnnieX$lynxSchema$2 INSTANCE = null;

    static {
        INSTANCE = new PreInitCreateLynxViewTask4AnnieX$lynxSchema$2();
    }

    public PreInitCreateLynxViewTask4AnnieX$lynxSchema$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return "hybrid://lynxview?biz_tag=ec_shop&enable_code_cache=1&enable_js_runtime=true&enable_memory_cache=1&scene_tag=ec_shop_follow_tab_follow_tab_boundary&surl=https%3A%2F%2Flf-ecom-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fecom%2Flynx%2F" + NativeMallGeckoHelper.b() + "%2Fcards%2Ftest_card%2Ffollow_tab_boundary%2Ftemplate.js&use_ecom_image=1";
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
