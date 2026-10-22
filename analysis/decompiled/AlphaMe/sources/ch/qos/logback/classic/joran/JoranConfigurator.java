package ch.qos.logback.classic.joran;

import ch.qos.logback.classic.joran.action.ConfigurationAction;
import ch.qos.logback.classic.joran.action.ConsolePluginAction;
import ch.qos.logback.classic.joran.action.ContextNameAction;
import ch.qos.logback.classic.joran.action.EvaluatorAction;
import ch.qos.logback.classic.joran.action.InsertFromJNDIAction;
import ch.qos.logback.classic.joran.action.JMXConfiguratorAction;
import ch.qos.logback.classic.joran.action.LevelAction;
import ch.qos.logback.classic.joran.action.LoggerAction;
import ch.qos.logback.classic.joran.action.LoggerContextListenerAction;
import ch.qos.logback.classic.joran.action.ReceiverAction;
import ch.qos.logback.classic.joran.action.RootLoggerAction;
import ch.qos.logback.classic.sift.SiftAction;
import ch.qos.logback.classic.spi.PlatformInfo;
import ch.qos.logback.classic.util.DefaultNestedComponentRules;
import ch.qos.logback.core.joran.JoranConfiguratorBase;
import ch.qos.logback.core.joran.action.AppenderRefAction;
import ch.qos.logback.core.joran.action.IncludeAction;
import ch.qos.logback.core.joran.action.NOPAction;
import ch.qos.logback.core.joran.conditional.ElseAction;
import ch.qos.logback.core.joran.conditional.IfAction;
import ch.qos.logback.core.joran.conditional.ThenAction;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.joran.spi.ElementSelector;
import ch.qos.logback.core.joran.spi.RuleStore;

/* loaded from: classes.dex */
public class JoranConfigurator extends JoranConfiguratorBase {
    @Override // ch.qos.logback.core.joran.GenericConfigurator
    public void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        DefaultNestedComponentRules.addDefaultNestedComponentRegistryRules(defaultNestedComponentRegistry);
    }

    @Override // ch.qos.logback.core.joran.JoranConfiguratorBase, ch.qos.logback.core.joran.GenericConfigurator
    public void addInstanceRules(RuleStore ruleStore) {
        super.addInstanceRules(ruleStore);
        ruleStore.addRule(new ElementSelector("configuration"), new ConfigurationAction());
        ruleStore.addRule(new ElementSelector("configuration/contextName"), new ContextNameAction());
        ruleStore.addRule(new ElementSelector("configuration/contextListener"), new LoggerContextListenerAction());
        ruleStore.addRule(new ElementSelector("configuration/insertFromJNDI"), new InsertFromJNDIAction());
        ruleStore.addRule(new ElementSelector("configuration/evaluator"), new EvaluatorAction());
        ruleStore.addRule(new ElementSelector("configuration/appender/sift"), new SiftAction());
        ruleStore.addRule(new ElementSelector("configuration/appender/sift/*"), new NOPAction());
        ruleStore.addRule(new ElementSelector("configuration/logger"), new LoggerAction());
        ruleStore.addRule(new ElementSelector("configuration/logger/level"), new LevelAction());
        ruleStore.addRule(new ElementSelector("configuration/root"), new RootLoggerAction());
        ruleStore.addRule(new ElementSelector("configuration/root/level"), new LevelAction());
        ruleStore.addRule(new ElementSelector("configuration/logger/appender-ref"), new AppenderRefAction());
        ruleStore.addRule(new ElementSelector("configuration/root/appender-ref"), new AppenderRefAction());
        ruleStore.addRule(new ElementSelector("*/if"), new IfAction());
        ruleStore.addRule(new ElementSelector("*/if/then"), new ThenAction());
        ruleStore.addRule(new ElementSelector("*/if/then/*"), new NOPAction());
        ruleStore.addRule(new ElementSelector("*/if/else"), new ElseAction());
        ruleStore.addRule(new ElementSelector("*/if/else/*"), new NOPAction());
        if (PlatformInfo.hasJMXObjectName()) {
            ruleStore.addRule(new ElementSelector("configuration/jmxConfigurator"), new JMXConfiguratorAction());
        }
        ruleStore.addRule(new ElementSelector("configuration/include"), new IncludeAction());
        ruleStore.addRule(new ElementSelector("configuration/consolePlugin"), new ConsolePluginAction());
        ruleStore.addRule(new ElementSelector("configuration/receiver"), new ReceiverAction());
    }
}
