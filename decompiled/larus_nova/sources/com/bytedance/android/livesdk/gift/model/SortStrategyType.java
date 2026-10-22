package com.bytedance.android.livesdk.gift.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/SortStrategyType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public @interface SortStrategyType {
    public static final a Companion = null;
    public static final int SORT_STRATEGY_TYPE_DEFAULT = 0;
    public static final int SORT_STRATEGY_TYPE_NONE = 2;
    public static final int SORT_STRATEGY_TYPE_PREVIEW = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f126374a = null;

        public a() {
        }

        static {
            f126374a = new a();
        }
    }

    static {
        Companion = a.f126374a;
    }
}
