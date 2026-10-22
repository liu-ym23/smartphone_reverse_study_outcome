package com.networknt.schema.walk;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.keyword.KeywordValidator;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.walk.ApplyDefaultsStrategy;
import java.util.List;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class WalkConfig {
    private final ApplyDefaultsStrategy applyDefaultsStrategy;
    private final WalkHandler itemWalkHandler;
    private final WalkHandler keywordWalkHandler;
    private final WalkHandler propertyWalkHandler;

    public static class Builder {
        private ApplyDefaultsStrategy applyDefaultsStrategy = null;
        private WalkHandler itemWalkHandler = null;
        private WalkHandler keywordWalkHandler = null;
        private WalkHandler propertyWalkHandler = null;

        public Builder applyDefaultsStrategy(ApplyDefaultsStrategy applyDefaultsStrategy) {
            this.applyDefaultsStrategy = applyDefaultsStrategy;
            return this;
        }

        public WalkConfig build() {
            ApplyDefaultsStrategy applyDefaultsStrategy = this.applyDefaultsStrategy;
            if (applyDefaultsStrategy == null) {
                applyDefaultsStrategy = ApplyDefaultsStrategy.EMPTY_APPLY_DEFAULTS_STRATEGY;
            }
            WalkHandler noOpWalkHandler = this.itemWalkHandler;
            if (noOpWalkHandler == null) {
                noOpWalkHandler = NoOpWalkHandler.getInstance();
            }
            WalkHandler noOpWalkHandler2 = this.keywordWalkHandler;
            if (noOpWalkHandler2 == null) {
                noOpWalkHandler2 = NoOpWalkHandler.getInstance();
            }
            WalkHandler noOpWalkHandler3 = this.propertyWalkHandler;
            if (noOpWalkHandler3 == null) {
                noOpWalkHandler3 = NoOpWalkHandler.getInstance();
            }
            return new WalkConfig(applyDefaultsStrategy, noOpWalkHandler, noOpWalkHandler2, noOpWalkHandler3);
        }

        public Builder itemWalkHandler(WalkHandler walkHandler) {
            this.itemWalkHandler = walkHandler;
            return this;
        }

        public Builder keywordWalkHandler(WalkHandler walkHandler) {
            this.keywordWalkHandler = walkHandler;
            return this;
        }

        public Builder propertyWalkHandler(WalkHandler walkHandler) {
            this.propertyWalkHandler = walkHandler;
            return this;
        }

        public Builder applyDefaultsStrategy(Consumer<ApplyDefaultsStrategy.Builder> consumer) {
            ApplyDefaultsStrategy.Builder builder = ApplyDefaultsStrategy.builder(this.applyDefaultsStrategy);
            consumer.accept(builder);
            return applyDefaultsStrategy(builder.build());
        }
    }

    public static class Holder {
        private static final WalkConfig INSTANCE = WalkConfig.builder().build();

        private Holder() {
        }
    }

    public static class NoOpWalkHandler implements WalkHandler {

        public static class Holder {
            private static final NoOpWalkHandler INSTANCE = new NoOpWalkHandler();

            private Holder() {
            }
        }

        public static NoOpWalkHandler getInstance() {
            return Holder.INSTANCE;
        }

        @Override // com.networknt.schema.walk.WalkHandler
        public void postWalk(ExecutionContext executionContext, String str, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, Schema schema, KeywordValidator keywordValidator, List<Error> list) {
        }

        @Override // com.networknt.schema.walk.WalkHandler
        public boolean preWalk(ExecutionContext executionContext, String str, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, Schema schema, KeywordValidator keywordValidator) {
            return true;
        }
    }

    public WalkConfig(ApplyDefaultsStrategy applyDefaultsStrategy, WalkHandler walkHandler, WalkHandler walkHandler2, WalkHandler walkHandler3) {
        this.applyDefaultsStrategy = applyDefaultsStrategy;
        this.itemWalkHandler = walkHandler;
        this.keywordWalkHandler = walkHandler2;
        this.propertyWalkHandler = walkHandler3;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static WalkConfig getInstance() {
        return Holder.INSTANCE;
    }

    public ApplyDefaultsStrategy getApplyDefaultsStrategy() {
        return this.applyDefaultsStrategy;
    }

    public WalkHandler getItemWalkHandler() {
        return this.itemWalkHandler;
    }

    public WalkHandler getKeywordWalkHandler() {
        return this.keywordWalkHandler;
    }

    public WalkHandler getPropertyWalkHandler() {
        return this.propertyWalkHandler;
    }

    public static Builder builder(WalkConfig walkConfig) {
        Builder builder = new Builder();
        builder.applyDefaultsStrategy = walkConfig.applyDefaultsStrategy;
        builder.itemWalkHandler = walkConfig.itemWalkHandler;
        builder.keywordWalkHandler = walkConfig.keywordWalkHandler;
        builder.propertyWalkHandler = walkConfig.propertyWalkHandler;
        return builder;
    }
}
