package com.bytedance.android.ec.local.api.atomic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes44.dex */
@Target({ElementType.TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B&\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004R\u000f\u0010\u0005\u001a\u00020\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u000f\u0010\u0006\u001a\u00020\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/local/api/atomic/LiveAtomicAbilityDescriptor;", "", "service", "", "", "action", "description", "()Ljava/lang/String;", "()[Ljava/lang/String;", "ec-local-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface LiveAtomicAbilityDescriptor {
    String action();

    String description() default "";

    String[] service();
}
