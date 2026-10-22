package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class RoutingRuleCondition {

    @JsonProperty("HttpErrorCodeReturnedEquals")
    private int httpErrorCodeReturnedEquals;

    @JsonProperty("KeyPrefixEquals")
    private String keyPrefixEquals;

    public static final class RoutingRuleConditionBuilder {
        private int httpErrorCodeReturnedEquals;
        private String keyPrefixEquals;

        public RoutingRuleCondition build() {
            RoutingRuleCondition routingRuleCondition = new RoutingRuleCondition();
            routingRuleCondition.setKeyPrefixEquals(this.keyPrefixEquals);
            routingRuleCondition.setHttpErrorCodeReturnedEquals(this.httpErrorCodeReturnedEquals);
            return routingRuleCondition;
        }

        public RoutingRuleConditionBuilder httpErrorCodeReturnedEquals(int i) {
            this.httpErrorCodeReturnedEquals = i;
            return this;
        }

        public RoutingRuleConditionBuilder keyPrefixEquals(String str) {
            this.keyPrefixEquals = str;
            return this;
        }

        private RoutingRuleConditionBuilder() {
        }
    }

    public static RoutingRuleConditionBuilder builder() {
        return new RoutingRuleConditionBuilder();
    }

    public int getHttpErrorCodeReturnedEquals() {
        return this.httpErrorCodeReturnedEquals;
    }

    public String getKeyPrefixEquals() {
        return this.keyPrefixEquals;
    }

    public RoutingRuleCondition setHttpErrorCodeReturnedEquals(int i) {
        this.httpErrorCodeReturnedEquals = i;
        return this;
    }

    public RoutingRuleCondition setKeyPrefixEquals(String str) {
        this.keyPrefixEquals = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RoutingRuleCondition{keyPrefixEquals='");
        sb.append(this.keyPrefixEquals);
        sb.append("', httpErrorCodeReturnedEquals=");
        return a.o(sb, this.httpErrorCodeReturnedEquals, '}');
    }
}
