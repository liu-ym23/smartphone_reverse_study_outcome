package com.bytedance.android.shopping.mall.homepage.preload;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/preload/TopBarPreloadState;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public @interface TopBarPreloadState {
    public static final a Companion = null;
    public static final int PRELOAD_FAIL = 3;
    public static final int PRELOAD_ING = 1;
    public static final int PRELOAD_SUCCESS = 2;
    public static final int UN_START = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f178385a = null;

        public a() {
        }

        static {
            f178385a = new a();
        }
    }

    static {
        Companion = a.f178385a;
    }
}
