package com.bytedance.android.livesdk.message.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ToolbarButtonAction;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ToolbarButtonAction {
    public static final a Companion = null;
    public static final int DOWN = 2;
    public static final int HasPermission = 3;
    public static final int NoOp = 0;
    public static final int NoPermission = 4;
    public static final int UP = 1;
    public static final int UPDATE = 5;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153619a = null;

        public a() {
        }

        static {
            f153619a = new a();
        }
    }

    static {
        Companion = a.f153619a;
    }
}
