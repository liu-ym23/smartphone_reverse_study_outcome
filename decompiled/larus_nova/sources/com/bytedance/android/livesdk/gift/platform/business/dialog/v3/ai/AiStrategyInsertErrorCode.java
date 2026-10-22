package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.ai;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes9.dex */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/ai/AiStrategyInsertErrorCode;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AiStrategyInsertErrorCode {
    public static final a Companion = null;
    public static final int NOT_FIND_GIFT = 302;
    public static final int RECEIVER_IS_NOT_ANCHOR = 301;
    public static final int SCENE_IS_EMPTY = 305;
    public static final int SCENE_MISMATCH = 303;
    public static final int SCENE_NOT_SUPPORT_INSERT = 304;
    public static final int SUCCESS = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f127102a = null;

        public a() {
        }

        static {
            f127102a = new a();
        }
    }

    static {
        Companion = a.f127102a;
    }
}
