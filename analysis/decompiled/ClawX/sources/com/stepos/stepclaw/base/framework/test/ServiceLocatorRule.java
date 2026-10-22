package com.stepos.stepclaw.base.framework.test;

import com.stepos.stepclaw.base.framework.ServiceLocator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/stepos/stepclaw/base/framework/test/ServiceLocatorRule;", "Lorg/junit/rules/TestRule;", "<init>", "()V", "apply", "Lorg/junit/runners/model/Statement;", "base", "description", "Lorg/junit/runner/Description;", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ServiceLocatorRule implements TestRule {
    public Statement apply(final Statement base, Description description) {
        p.e(base, "base");
        p.e(description, "description");
        return new Statement() { // from class: com.stepos.stepclaw.base.framework.test.ServiceLocatorRule.apply.1
            public void evaluate() {
                ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
                serviceLocator.reset();
                try {
                    base.evaluate();
                    serviceLocator.reset();
                } catch (Throwable th) {
                    ServiceLocator.INSTANCE.reset();
                    throw th;
                }
            }
        };
    }
}
