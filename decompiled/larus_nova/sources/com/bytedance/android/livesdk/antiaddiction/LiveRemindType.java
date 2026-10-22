package com.bytedance.android.livesdk.antiaddiction;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/antiaddiction/LiveRemindType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public @interface LiveRemindType {
    public static final int BLOCK_PAGE = 3;
    public static final int CANCELLABLE_PAGE = 2;
    public static final a Companion = null;
    public static final int I_SHOULD_REST_PAGE = 4;
    public static final int I_SHOULD_SLEEP_PAGE = 5;
    public static final int I_SHOULD_SLEEP_PAGE_REMIND_LATER = 16;
    public static final int NONE = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f103689a = null;

        public a() {
        }

        static {
            f103689a = new a();
        }
    }

    static {
        Companion = a.f103689a;
    }
}
