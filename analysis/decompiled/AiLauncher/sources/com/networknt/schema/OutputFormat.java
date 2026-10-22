package com.networknt.schema;

import com.networknt.schema.ExecutionConfig;
import com.networknt.schema.output.HierarchicalOutputUnitFormatter;
import com.networknt.schema.output.ListOutputUnitFormatter;
import com.networknt.schema.output.OutputFlag;
import com.networknt.schema.output.OutputUnit;
import java.util.function.Consumer;
import java.util.function.Function;

/* loaded from: classes2.dex */
public interface OutputFormat<T> {
    public static final Default DEFAULT = new Default();
    public static final Boolean BOOLEAN = new Boolean();
    public static final Flag FLAG = new Flag();
    public static final List LIST = new List();
    public static final Hierarchical HIERARCHICAL = new Hierarchical();
    public static final Result RESULT = new Result();

    public static class Boolean implements OutputFormat<java.lang.Boolean> {
        @Override // com.networknt.schema.OutputFormat
        public void customize(ExecutionContext executionContext, SchemaContext schemaContext) {
            executionContext.executionConfig(new Consumer() { // from class: com.networknt.schema.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((ExecutionConfig.Builder) obj).annotationCollectionEnabled(false).failFast(true);
                }
            });
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.networknt.schema.OutputFormat
        public java.lang.Boolean format(Schema schema, ExecutionContext executionContext, SchemaContext schemaContext) {
            return java.lang.Boolean.valueOf(executionContext.getErrors().isEmpty());
        }
    }

    public static class Default implements OutputFormat<java.util.List<Error>> {
        @Override // com.networknt.schema.OutputFormat
        public void customize(ExecutionContext executionContext, SchemaContext schemaContext) {
            executionContext.executionConfig(new Consumer() { // from class: com.networknt.schema.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((ExecutionConfig.Builder) obj).annotationCollectionEnabled(false);
                }
            });
        }

        @Override // com.networknt.schema.OutputFormat
        public java.util.List<Error> format(Schema schema, ExecutionContext executionContext, SchemaContext schemaContext) {
            return executionContext.getErrors();
        }
    }

    public static class Flag implements OutputFormat<OutputFlag> {
        @Override // com.networknt.schema.OutputFormat
        public void customize(ExecutionContext executionContext, SchemaContext schemaContext) {
            executionContext.executionConfig(new Consumer() { // from class: com.networknt.schema.j
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((ExecutionConfig.Builder) obj).annotationCollectionEnabled(false).failFast(true);
                }
            });
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.networknt.schema.OutputFormat
        public OutputFlag format(Schema schema, ExecutionContext executionContext, SchemaContext schemaContext) {
            return new OutputFlag(executionContext.getErrors().isEmpty());
        }
    }

    public static class Hierarchical implements OutputFormat<OutputUnit> {
        private final Function<Error, Object> errorMapper;

        public Hierarchical() {
            this(new k());
        }

        @Override // com.networknt.schema.OutputFormat
        public void customize(ExecutionContext executionContext, SchemaContext schemaContext) {
        }

        public Hierarchical(Function<Error, Object> function) {
            this.errorMapper = function;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.networknt.schema.OutputFormat
        public OutputUnit format(Schema schema, ExecutionContext executionContext, SchemaContext schemaContext) {
            return HierarchicalOutputUnitFormatter.format(schema, executionContext.getErrors(), executionContext, schemaContext, this.errorMapper);
        }
    }

    public static class List implements OutputFormat<OutputUnit> {
        private final Function<Error, Object> errorMapper;

        public List() {
            this(new k());
        }

        @Override // com.networknt.schema.OutputFormat
        public void customize(ExecutionContext executionContext, SchemaContext schemaContext) {
        }

        public List(Function<Error, Object> function) {
            this.errorMapper = function;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.networknt.schema.OutputFormat
        public OutputUnit format(Schema schema, ExecutionContext executionContext, SchemaContext schemaContext) {
            return ListOutputUnitFormatter.format(executionContext.getErrors(), executionContext, schemaContext, this.errorMapper);
        }
    }

    public static class Result implements OutputFormat<com.networknt.schema.Result> {
        @Override // com.networknt.schema.OutputFormat
        public void customize(ExecutionContext executionContext, SchemaContext schemaContext) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.networknt.schema.OutputFormat
        public com.networknt.schema.Result format(Schema schema, ExecutionContext executionContext, SchemaContext schemaContext) {
            return new com.networknt.schema.Result(executionContext);
        }
    }

    default void customize(ExecutionContext executionContext, SchemaContext schemaContext) {
    }

    T format(Schema schema, ExecutionContext executionContext, SchemaContext schemaContext);
}
