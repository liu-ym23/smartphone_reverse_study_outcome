package com.bytedance.android.livesdk.gift.platform.core.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes9.dex */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/GiftInsertStatus;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GiftInsertStatus {
    public static final a Companion = null;
    public static final String NOT_STRATEGY = "not_strategy";
    public static final String STRATEGY_INSERT = "strategy_insert";
    public static final String STRATEGY_NOT_INSERT = "strategy_not_insert";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f130824a = null;

        public a() {
        }

        static {
            f130824a = new a();
        }
    }

    static {
        Companion = a.f130824a;
    }
}
