package com.bytedance.android.live.wallet.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes7.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/wallet/model/OrderParamsKey;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface OrderParamsKey {
    public static final a Companion = null;
    public static final String KEY_CJ_APP_ID = "app_id";
    public static final String KEY_CJ_MERCHANT_ID = "merchant_id";
    public static final String KEY_PRODUCT_ID = "product_id";
    public static final String KEY_SDK_PARAM = "sdk_params";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f102676a = null;

        public a() {
        }

        static {
            f102676a = new a();
        }
    }

    static {
        Companion = a.f102676a;
    }
}
