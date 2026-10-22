package com.bytedance.android.shopping.api.mall.feed;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes13.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/feed/InitGYLComponentBehavior;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface InitGYLComponentBehavior {
    public static final a Companion = null;
    public static final String PRODUCT_DETAIL_CLICK_RECOMMEND = "product_detail_click_recommend";
    public static final String PRODUCT_DETAIL_SCROLL_TO_GYL = "product_detail_scroll_to_gyl";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f170505a = null;

        public a() {
        }

        static {
            f170505a = new a();
        }
    }

    static {
        Companion = a.f170505a;
    }
}
