package com.networknt.schema.output;

import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.SchemaContext;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class ListOutputUnitFormatter {
    public static OutputUnit format(OutputUnit outputUnit, OutputUnitData outputUnitData) {
        Map<OutputUnitKey, Boolean> valid = outputUnitData.getValid();
        Map<OutputUnitKey, Map<String, Object>> errors = outputUnitData.getErrors();
        Map<OutputUnitKey, Map<String, Object>> annotations = outputUnitData.getAnnotations();
        Map<OutputUnitKey, Map<String, Object>> droppedAnnotations = outputUnitData.getDroppedAnnotations();
        for (Map.Entry<OutputUnitKey, Boolean> entry : valid.entrySet()) {
            OutputUnit outputUnit2 = new OutputUnit();
            OutputUnitKey key = entry.getKey();
            outputUnit2.setValid(entry.getValue().booleanValue());
            outputUnit2.setEvaluationPath(key.getEvaluationPath().toString());
            outputUnit2.setSchemaLocation(key.getSchemaLocation().toString());
            outputUnit2.setInstanceLocation(key.getInstanceLocation().toString());
            Map<String, Object> map = errors.get(key);
            if (map != null && !map.isEmpty()) {
                if (outputUnit2.getErrors() == null) {
                    outputUnit2.setErrors(new LinkedHashMap());
                }
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    outputUnit2.getErrors().put(entry2.getKey(), entry2.getValue());
                }
            }
            Map<String, Object> map2 = annotations.get(key);
            if (map2 != null && !map2.isEmpty()) {
                if (outputUnit2.getAnnotations() == null) {
                    outputUnit2.setAnnotations(new LinkedHashMap());
                }
                for (Map.Entry<String, Object> entry3 : map2.entrySet()) {
                    outputUnit2.getAnnotations().put(entry3.getKey(), entry3.getValue());
                }
            }
            Map<String, Object> map3 = droppedAnnotations.get(key);
            if (map3 != null && !map3.isEmpty()) {
                if (outputUnit2.getDroppedAnnotations() == null) {
                    outputUnit2.setDroppedAnnotations(new LinkedHashMap());
                }
                for (Map.Entry<String, Object> entry4 : map3.entrySet()) {
                    outputUnit2.getDroppedAnnotations().put(entry4.getKey(), entry4.getValue());
                }
            }
            List<OutputUnit> details = outputUnit.getDetails();
            if (details == null) {
                details = new ArrayList<>();
                outputUnit.setDetails(details);
            }
            details.add(outputUnit2);
        }
        return outputUnit;
    }

    public static OutputUnit format(List<Error> list, ExecutionContext executionContext, SchemaContext schemaContext, Function<Error, Object> function) {
        OutputUnit outputUnit = new OutputUnit();
        outputUnit.setValid(list.isEmpty());
        return format(outputUnit, OutputUnitData.from(list, executionContext, function));
    }
}
