package ch.qos.logback.classic.util;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.boolex.JaninoEventEvaluator;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.filter.EvaluatorFilter;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.net.ssl.SSLNestedComponentRegistryRules;

/* loaded from: classes.dex */
public class DefaultNestedComponentRules {
    public static void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        defaultNestedComponentRegistry.add(AppenderBase.class, "layout", PatternLayout.class);
        defaultNestedComponentRegistry.add(UnsynchronizedAppenderBase.class, "layout", PatternLayout.class);
        defaultNestedComponentRegistry.add(AppenderBase.class, "encoder", PatternLayoutEncoder.class);
        defaultNestedComponentRegistry.add(UnsynchronizedAppenderBase.class, "encoder", PatternLayoutEncoder.class);
        defaultNestedComponentRegistry.add(EvaluatorFilter.class, "evaluator", JaninoEventEvaluator.class);
        SSLNestedComponentRegistryRules.addDefaultNestedComponentRegistryRules(defaultNestedComponentRegistry);
    }
}
