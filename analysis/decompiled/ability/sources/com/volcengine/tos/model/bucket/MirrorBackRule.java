package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class MirrorBackRule {

    @JsonProperty("Condition")
    private Condition condition;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Redirect")
    private Redirect redirect;

    public static final class MirrorBackRuleBuilder {
        private Condition condition;
        private String id;
        private Redirect redirect;

        public MirrorBackRule build() {
            MirrorBackRule mirrorBackRule = new MirrorBackRule();
            mirrorBackRule.setId(this.id);
            mirrorBackRule.setCondition(this.condition);
            mirrorBackRule.setRedirect(this.redirect);
            return mirrorBackRule;
        }

        public MirrorBackRuleBuilder condition(Condition condition) {
            this.condition = condition;
            return this;
        }

        public MirrorBackRuleBuilder id(String str) {
            this.id = str;
            return this;
        }

        public MirrorBackRuleBuilder redirect(Redirect redirect) {
            this.redirect = redirect;
            return this;
        }

        private MirrorBackRuleBuilder() {
        }
    }

    public static MirrorBackRuleBuilder builder() {
        return new MirrorBackRuleBuilder();
    }

    public Condition getCondition() {
        return this.condition;
    }

    public String getId() {
        return this.id;
    }

    public Redirect getRedirect() {
        return this.redirect;
    }

    public MirrorBackRule setCondition(Condition condition) {
        this.condition = condition;
        return this;
    }

    public MirrorBackRule setId(String str) {
        this.id = str;
        return this;
    }

    public MirrorBackRule setRedirect(Redirect redirect) {
        this.redirect = redirect;
        return this;
    }

    public String toString() {
        return "MirrorBackRule{id='" + this.id + "', condition=" + this.condition + ", redirect=" + this.redirect + '}';
    }
}
