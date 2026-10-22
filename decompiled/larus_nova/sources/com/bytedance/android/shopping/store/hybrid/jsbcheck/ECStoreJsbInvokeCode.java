package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes14.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/ECStoreJsbInvokeCode;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ECStoreJsbInvokeCode {
    public static final a Companion = null;
    public static final int IN_JSB_PARAM_EXCLUDES_LIST = -2;
    public static final int NOT_IN_JSB_ALLOW_LIST = -1;
    public static final int NOT_IN_JSB_PARAM_INCLUDE_LIST = -3;
    public static final int PASS = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f184854a = null;

        public a() {
        }

        static {
            f184854a = new a();
        }
    }

    static {
        Companion = a.f184854a;
    }
}
