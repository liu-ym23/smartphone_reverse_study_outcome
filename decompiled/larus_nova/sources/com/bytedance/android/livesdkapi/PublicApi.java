package com.bytedance.android.livesdkapi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes12.dex */
@Target({ElementType.METHOD})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B$\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\tR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\nR\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000bR\u000f\u0010\b\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\b\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/PublicApi;", "", "owner", "Lcom/bytedance/android/livesdkapi/Owner;", "scope", "Lcom/bytedance/android/livesdkapi/Scope;", "since", "", "until", "()Lcom/bytedance/android/livesdkapi/Owner;", "()Lcom/bytedance/android/livesdkapi/Scope;", "()Ljava/lang/String;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface PublicApi {
    Owner owner();

    Scope scope();

    String since() default "";

    String until() default "";
}
