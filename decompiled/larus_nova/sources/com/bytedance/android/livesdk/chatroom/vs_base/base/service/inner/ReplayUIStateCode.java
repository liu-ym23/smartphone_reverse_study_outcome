package com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/service/inner/ReplayUIStateCode;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public @interface ReplayUIStateCode {
    public static final a Companion = null;
    public static final int IS_FOLD_OPEN = 16;
    public static final int IS_FULL_UI = 4;
    public static final int IS_LAND_SCREEN = 8;
    public static final int IS_LAND_STREAM = 1;
    public static final int IS_PAD = 2;
    public static final int NOT = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f117911a = null;

        public a() {
        }

        static {
            f117911a = new a();
        }
    }

    static {
        Companion = a.f117911a;
    }
}
