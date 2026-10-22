package com.bytedance.android.livesdk.chatroom.permission.rule;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes7.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/permission/rule/ComponentStatus;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ComponentStatus {
    public static final a Companion = null;
    public static final int DEFAULT = 0;
    public static final int DISABLE = 2;
    public static final int ENABLE = 1;
    public static final int GRAY = 3;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f107577a = null;

        public a() {
        }

        static {
            f107577a = new a();
        }
    }

    static {
        Companion = a.f107577a;
    }
}
