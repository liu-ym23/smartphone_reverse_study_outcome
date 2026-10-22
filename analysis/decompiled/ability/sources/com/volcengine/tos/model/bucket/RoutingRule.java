package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class RoutingRule {

    @JsonProperty("Condition")
    private RoutingRuleCondition condition;

    @JsonProperty("Redirect")
    private RoutingRuleRedirect redirect;

    public static final class RoutingRuleBuilder {
        private RoutingRuleCondition condition;
        private RoutingRuleRedirect redirect;

        public RoutingRule build() {
            RoutingRule routingRule = new RoutingRule();
            routingRule.setCondition(this.condition);
            routingRule.setRedirect(this.redirect);
            return routingRule;
        }

        public RoutingRuleBuilder condition(RoutingRuleCondition routingRuleCondition) {
            this.condition = routingRuleCondition;
            return this;
        }

        public RoutingRuleBuilder redirect(RoutingRuleRedirect routingRuleRedirect) {
            this.redirect = routingRuleRedirect;
            return this;
        }

        private RoutingRuleBuilder() {
        }
    }

    public static RoutingRuleBuilder builder() {
        return new RoutingRuleBuilder();
    }

    public RoutingRuleCondition getCondition() {
        return this.condition;
    }

    public RoutingRuleRedirect getRedirect() {
        return this.redirect;
    }

    public RoutingRule setCondition(RoutingRuleCondition routingRuleCondition) {
        this.condition = routingRuleCondition;
        return this;
    }

    public RoutingRule setRedirect(RoutingRuleRedirect routingRuleRedirect) {
        this.redirect = routingRuleRedirect;
        return this;
    }

    public String toString() {
        return "RoutingRule{condition=" + this.condition + ", redirect=" + this.redirect + '}';
    }
}
