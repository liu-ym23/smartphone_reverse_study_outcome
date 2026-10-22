package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.ProductShelfExperimentConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class r extends SSettingKey<ProductShelfExperimentConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f121095a = null;

    static {
        f121095a = new r();
    }

    public r() {
        super("audience_live_product_info", "观众端商品货架实验", new ProductShelfExperimentConfig(false, false, false, false, false, false, false, 127, null), new ProductShelfExperimentConfig(false, false, false, false, false, false, false, 127, null));
    }
}
