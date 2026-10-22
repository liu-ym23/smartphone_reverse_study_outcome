package com.bytedance.android.live.broadcast.api.monitor.game;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/monitor/game/LiveRetryState;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public @interface LiveRetryState {
    public static final a Companion = null;
    public static final int NONE = 0;
    public static final int RETRY_DUE_TO_201 = 1;
    public static final int RETRY_DUE_TO_202 = 2;
    public static final int RETRY_DUE_TO_NET = 3;
    public static final int RETRY_DUE_TO_PAUSE = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f59067a = null;

        public a() {
        }

        static {
            f59067a = new a();
        }
    }

    static {
        Companion = a.f59067a;
    }
}
