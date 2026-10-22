package com.networknt.schema;

import java.util.List;

/* loaded from: classes2.dex */
public class Result {
    private final ExecutionContext executionContext;

    public Result(ExecutionContext executionContext) {
        this.executionContext = executionContext;
    }

    public CollectorContext getCollectorContext() {
        return getExecutionContext().getCollectorContext();
    }

    public List<Error> getErrors() {
        return getExecutionContext().getErrors();
    }

    public ExecutionContext getExecutionContext() {
        return this.executionContext;
    }
}
