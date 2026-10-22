package com.bytedance.android.scope;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.scope.j;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Repeatable;

/* JADX INFO: loaded from: classes12.dex */
@Target({ElementType.TYPE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\"\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\tR\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u00048\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\t8\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/scope/RunInScope;", "Lcom/bytedance/android/scope/j;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "Lkotlin/reflect/KClass;", "", "exportedTypes", "()[Ljava/lang/Class;", "", "lazy", "()Z", "runtime"}, k = 1, mv = {1, 4, 3})
@Repeatable
@Documented
public @interface RunInScope<T extends j> {
    Class<? extends Object>[] exportedTypes() default {};

    boolean lazy() default false;
}
