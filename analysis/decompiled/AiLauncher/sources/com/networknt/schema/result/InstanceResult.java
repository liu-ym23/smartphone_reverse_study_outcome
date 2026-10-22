package com.networknt.schema.result;

import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.Objects;

/* loaded from: classes2.dex */
public class InstanceResult {
    private final NodePath evaluationPath;
    private final NodePath instanceLocation;
    private final SchemaLocation schemaLocation;
    private final boolean valid;

    public InstanceResult(NodePath nodePath, SchemaLocation schemaLocation, NodePath nodePath2, boolean z10) {
        this.instanceLocation = nodePath;
        this.schemaLocation = schemaLocation;
        this.evaluationPath = nodePath2;
        this.valid = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InstanceResult instanceResult = (InstanceResult) obj;
        return Objects.equals(this.evaluationPath, instanceResult.evaluationPath) && Objects.equals(this.instanceLocation, instanceResult.instanceLocation) && Objects.equals(this.schemaLocation, instanceResult.schemaLocation) && this.valid == instanceResult.valid;
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
        return Objects.hash(this.evaluationPath, this.instanceLocation, this.schemaLocation, Boolean.valueOf(this.valid));
    }

    public boolean isValid() {
        return this.valid;
    }

    public String toString() {
        return "JsonNodeResult [instanceLocation=" + this.instanceLocation + ", schemaLocation=" + this.schemaLocation + ", evaluationPath=" + this.evaluationPath + ", valid=" + this.valid + "]";
    }
}
