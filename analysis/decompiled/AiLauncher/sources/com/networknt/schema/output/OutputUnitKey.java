package com.networknt.schema.output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.serialization.JsonMapperFactory;
import java.util.Objects;

/* loaded from: classes2.dex */
public class OutputUnitKey {

    @JsonSerialize(using = ToStringSerializer.class)
    final NodePath evaluationPath;

    @JsonSerialize(using = ToStringSerializer.class)
    final NodePath instanceLocation;

    @JsonSerialize(using = ToStringSerializer.class)
    final SchemaLocation schemaLocation;

    public OutputUnitKey(NodePath nodePath, SchemaLocation schemaLocation, NodePath nodePath2) {
        this.evaluationPath = nodePath;
        this.schemaLocation = schemaLocation;
        this.instanceLocation = nodePath2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OutputUnitKey outputUnitKey = (OutputUnitKey) obj;
        return Objects.equals(this.evaluationPath, outputUnitKey.evaluationPath) && Objects.equals(this.instanceLocation, outputUnitKey.instanceLocation) && Objects.equals(this.schemaLocation, outputUnitKey.schemaLocation);
    }

    public NodePath getEvaluationPath() {
        return this.evaluationPath;
    }

    public NodePath getInstanceLocation() {
        return this.instanceLocation;
    }

    public SchemaLocation getSchemaLocation() {
        return this.schemaLocation;
    }

    public int hashCode() {
        return Objects.hash(this.evaluationPath, this.instanceLocation, this.schemaLocation);
    }

    public String toString() {
        try {
            return JsonMapperFactory.getInstance().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException unused) {
            return "OutputUnitKey [evaluationPath=" + this.evaluationPath + ", schemaLocation=" + this.schemaLocation + ", instanceLocation=" + this.instanceLocation + "]";
        }
    }
}
