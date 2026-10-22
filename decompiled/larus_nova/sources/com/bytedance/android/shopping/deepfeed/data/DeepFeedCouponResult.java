package com.bytedance.android.shopping.deepfeed.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes13.dex */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/DeepFeedCouponResult;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface DeepFeedCouponResult {
    public static final a Companion = null;
    public static final String FAIL = "fail";
    public static final String SUCCESS = "success";
    public static final String UN_REQUEST = "un_request";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f173078a = null;

        public a() {
        }

        static {
            f173078a = new a();
        }
    }

    static {
        Companion = a.f173078a;
    }
}
