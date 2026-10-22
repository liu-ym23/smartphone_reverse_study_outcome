package com.networknt.schema;

import com.networknt.schema.ExecutionConfig;
import com.networknt.schema.annotation.Annotations;
import com.networknt.schema.keyword.DiscriminatorState;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.walk.WalkConfig;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class ExecutionContext {
    private Annotations annotations;
    private CollectorContext collectorContext;
    private final Map<NodePath, DiscriminatorState> discriminatorMapping;
    private List<Error> errors;
    NodePath evaluationPath;
    final ArrayDeque<Schema> evaluationSchema;
    final ArrayDeque<Object> evaluationSchemaPath;
    private ExecutionConfig executionConfig;
    private Boolean failFast;
    boolean unevaluatedItemsPresent;
    boolean unevaluatedPropertiesPresent;
    private WalkConfig walkConfig;

    public ExecutionContext() {
        this(ExecutionConfig.getInstance(), null);
    }

    public void addError(Error error) {
        this.errors.add(error);
        if (isFailFast()) {
            throw new FailFastAssertionException(error);
        }
    }

    public void evaluationPathAddLast(String str) {
        this.evaluationPath = this.evaluationPath.append(str);
    }

    public void evaluationPathRemoveLast() {
        this.evaluationPath = this.evaluationPath.getParent();
    }

    public void executionConfig(Consumer<ExecutionConfig.Builder> consumer) {
        ExecutionConfig.Builder builder = ExecutionConfig.builder(getExecutionConfig());
        consumer.accept(builder);
        this.executionConfig = builder.build();
    }

    public Annotations getAnnotations() {
        if (this.annotations == null) {
            this.annotations = new Annotations();
        }
        return this.annotations;
    }

    public CollectorContext getCollectorContext() {
        if (this.collectorContext == null) {
            this.collectorContext = new CollectorContext();
        }
        return this.collectorContext;
    }

    public Map<NodePath, DiscriminatorState> getDiscriminatorMapping() {
        return this.discriminatorMapping;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public NodePath getEvaluationPath() {
        return this.evaluationPath;
    }

    public ArrayDeque<Schema> getEvaluationSchema() {
        return this.evaluationSchema;
    }

    public ArrayDeque<Object> getEvaluationSchemaPath() {
        return this.evaluationSchemaPath;
    }

    public ExecutionConfig getExecutionConfig() {
        return this.executionConfig;
    }

    public WalkConfig getWalkConfig() {
        if (this.walkConfig == null) {
            this.walkConfig = WalkConfig.getInstance();
        }
        return this.walkConfig;
    }

    public boolean isFailFast() {
        if (this.failFast == null) {
            this.failFast = Boolean.valueOf(getExecutionConfig().isFailFast());
        }
        return this.failFast.booleanValue();
    }

    public boolean isUnevaluatedItemsPresent() {
        return this.unevaluatedItemsPresent;
    }

    public boolean isUnevaluatedPropertiesPresent() {
        return this.unevaluatedPropertiesPresent;
    }

    public void setCollectorContext(CollectorContext collectorContext) {
        this.collectorContext = collectorContext;
    }

    public void setErrors(List<Error> list) {
        this.errors = list;
    }

    public void setExecutionConfig(ExecutionConfig executionConfig) {
        this.executionConfig = executionConfig;
    }

    public void setFailFast(boolean z10) {
        this.failFast = Boolean.valueOf(z10);
    }

    public void setUnevaluatedItemsPresent(boolean z10) {
        this.unevaluatedItemsPresent = z10;
    }

    public void setUnevaluatedPropertiesPresent(boolean z10) {
        this.unevaluatedPropertiesPresent = z10;
    }

    public void setWalkConfig(WalkConfig walkConfig) {
        this.walkConfig = walkConfig;
    }

    public void walkConfig(Consumer<WalkConfig.Builder> consumer) {
        WalkConfig.Builder builder = WalkConfig.builder(getWalkConfig());
        consumer.accept(builder);
        this.walkConfig = builder.build();
    }

    public ExecutionContext(CollectorContext collectorContext) {
        this(ExecutionConfig.getInstance(), collectorContext);
    }

    public void evaluationPathAddLast(int i10) {
        this.evaluationPath = this.evaluationPath.append(i10);
    }

    public ExecutionContext(ExecutionConfig executionConfig) {
        this(executionConfig, null);
    }

    public ExecutionContext(ExecutionConfig executionConfig, CollectorContext collectorContext) {
        this.walkConfig = null;
        this.collectorContext = null;
        this.annotations = null;
        this.errors = new ArrayList();
        this.discriminatorMapping = new HashMap();
        this.evaluationSchema = new ArrayDeque<>(64);
        this.evaluationSchemaPath = new ArrayDeque<>(64);
        this.failFast = null;
        this.unevaluatedPropertiesPresent = false;
        this.unevaluatedItemsPresent = false;
        this.collectorContext = collectorContext;
        this.executionConfig = executionConfig;
    }
}
