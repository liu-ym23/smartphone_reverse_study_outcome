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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/ai/AiStrategyStatus;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AiStrategyStatus {
    public static final a Companion = null;
    public static final String NO_EFFECT_SCENE = "no_effect_scene";
    public static final String NO_STRATEGY = "no_strategy";
    public static final String STRATEGY_AND_INSERT = "strategy_and_insert";
    public static final String STRATEGY_NOT_INSERT = "strategy_not_insert";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f127103a = null;

        public a() {
        }

        static {
            f127103a = new a();
        }
    }

    static {
        Companion = a.f127103a;
    }
}
