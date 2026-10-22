package com.stepos.stepclaw.base.framework;

import com.stepos.stepclaw.SecurePrefs;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B,\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\u00020\u0005B\u0006\b\n0\u00058\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\u00020\bB\u0006\b\n0\b8\tR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\nR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u000bR\u000f\u0010\u0007\u001a\u00020\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/stepclaw/base/framework/ImplementedBy;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "implClass", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "lifecycle", "Lcom/stepos/stepclaw/base/framework/Lifecycle;", "SINGLETON", "factory", "Lcom/stepos/stepclaw/base/framework/Factory;", "AUTO", "()Ljava/lang/String;", "()Lcom/stepos/stepclaw/base/framework/Lifecycle;", "()Lcom/stepos/stepclaw/base/framework/Factory;", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface ImplementedBy {
    Factory factory() default Factory.AUTO;

    String implClass();

    Lifecycle lifecycle() default Lifecycle.SINGLETON;
}
