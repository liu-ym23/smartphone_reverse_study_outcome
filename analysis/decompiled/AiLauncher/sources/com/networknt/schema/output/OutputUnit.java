package com.networknt.schema.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.networknt.schema.serialization.JsonMapperFactory;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({M5.c.CARD_STATE_VALID, "evaluationPath", "schemaLocation", "instanceLocation", "errors", "annotations", "droppedAnnotations", "details"})
/* loaded from: classes2.dex */
public class OutputUnit {
    private boolean valid;
    private String evaluationPath = null;
    private String schemaLocation = null;
    private String instanceLocation = null;
    private Map<String, Object> errors = null;
    private Map<String, Object> annotations = null;
    private Map<String, Object> droppedAnnotations = null;
    private List<OutputUnit> details = null;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OutputUnit outputUnit = (OutputUnit) obj;
        return Objects.equals(this.annotations, outputUnit.annotations) && Objects.equals(this.details, outputUnit.details) && Objects.equals(this.droppedAnnotations, outputUnit.droppedAnnotations) && Objects.equals(this.errors, outputUnit.errors) && Objects.equals(this.evaluationPath, outputUnit.evaluationPath) && Objects.equals(this.instanceLocation, outputUnit.instanceLocation) && Objects.equals(this.schemaLocation, outputUnit.schemaLocation) && this.valid == outputUnit.valid;
    }

    public Map<String, Object> getAnnotations() {
        return this.annotations;
    }

    public List<OutputUnit> getDetails() {
        return this.details;
    }

    public Map<String, Object> getDroppedAnnotations() {
        return this.droppedAnnotations;
    }

    public Map<String, Object> getErrors() {
        return this.errors;
    }

    public String getEvaluationPath() {
        return this.evaluationPath;
    }

    public String getInstanceLocation() {
        return this.instanceLocation;
    }

    public String getSchemaLocation() {
        return this.schemaLocation;
    }

    public int hashCode() {
        return Objects.hash(this.annotations, this.details, this.droppedAnnotations, this.errors, this.evaluationPath, this.instanceLocation, this.schemaLocation, Boolean.valueOf(this.valid));
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setAnnotations(Map<String, Object> map) {
        this.annotations = map;
    }

    public void setDetails(List<OutputUnit> list) {
        this.details = list;
    }

    public void setDroppedAnnotations(Map<String, Object> map) {
        this.droppedAnnotations = map;
    }

    public void setErrors(Map<String, Object> map) {
        this.errors = map;
    }

    public void setEvaluationPath(String str) {
        this.evaluationPath = str;
    }

    public void setInstanceLocation(String str) {
        this.instanceLocation = str;
    }

    public void setSchemaLocation(String str) {
        this.schemaLocation = str;
    }

    public void setValid(boolean z10) {
        this.valid = z10;
    }

    public String toString() {
        try {
            return JsonMapperFactory.getInstance().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException unused) {
            return "OutputUnit [valid=" + this.valid + ", evaluationPath=" + this.evaluationPath + ", schemaLocation=" + this.schemaLocation + ", instanceLocation=" + this.instanceLocation + ", errors=" + this.errors + ", annotations=" + this.annotations + ", droppedAnnotations=" + this.droppedAnnotations + ", details=" + this.details + "]";
        }
    }
}
