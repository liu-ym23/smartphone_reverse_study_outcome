package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.JsonType;
import com.networknt.schema.utils.TypeFactory;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class EnumValidator extends BaseKeywordValidator implements KeywordValidator {
    private final String error;
    private final Set<JsonNode> nodes;

    public EnumValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        JsonNode jsonNode2;
        super(KeywordType.ENUM, jsonNode, schemaLocation, schema, schemaContext);
        if (jsonNode == null || !jsonNode.isArray()) {
            this.nodes = Collections.EMPTY_SET;
            this.error = "[none]";
            return;
        }
        this.nodes = new HashSet();
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Iterator<JsonNode> it = jsonNode.iterator();
        String str = "";
        while (it.hasNext()) {
            JsonNode next = it.next();
            if (next.isNumber()) {
                this.nodes.add(processNumberNode(next));
            } else if (next.isArray()) {
                this.nodes.add(processArrayNode((ArrayNode) next));
            } else {
                this.nodes.add(next);
            }
            sb2.append(str);
            sb2.append(asText(next));
            str = ", ";
        }
        if (schemaContext.isNullableKeywordEnabled() && (jsonNode2 = schema.getSchemaNode().get("nullable")) != null && jsonNode2.asBoolean()) {
            this.nodes.add(NullNode.getInstance());
            sb2.append(", ");
            sb2.append("null");
        }
        sb2.append(']');
        this.error = sb2.toString();
    }

    public static String asText(JsonNode jsonNode) {
        return (jsonNode.isObject() || jsonNode.isArray() || jsonNode.isTextual()) ? jsonNode.toString() : jsonNode.asText();
    }

    private boolean isTypeLooseContainsInEnum(JsonNode jsonNode) {
        if (TypeFactory.getValueNodeType(jsonNode, this.schemaContext.getSchemaRegistryConfig()) != JsonType.STRING) {
            return false;
        }
        String strTextValue = jsonNode.textValue();
        Iterator<JsonNode> it = this.nodes.iterator();
        while (it.hasNext()) {
            String strAsText = it.next().asText();
            if (strAsText != null && strAsText.equals(strTextValue)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasNumber(ArrayNode arrayNode) {
        for (int i10 = 0; i10 < arrayNode.size(); i10++) {
            if (arrayNode.get(i10).isNumber()) {
                return true;
            }
        }
        return false;
    }

    public ArrayNode processArrayNode(ArrayNode arrayNode) {
        if (!hasNumber(arrayNode)) {
            return arrayNode;
        }
        ArrayNode arrayNodeDeepCopy = arrayNode.deepCopy();
        for (int i10 = 0; i10 < arrayNodeDeepCopy.size(); i10++) {
            JsonNode jsonNode = arrayNodeDeepCopy.get(i10);
            if (jsonNode.isNumber()) {
                arrayNodeDeepCopy.set(i10, processNumberNode(jsonNode));
            }
        }
        return arrayNodeDeepCopy;
    }

    public JsonNode processNumberNode(JsonNode jsonNode) {
        return DecimalNode.valueOf(new BigDecimal(jsonNode.decimalValue().toPlainString()));
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (jsonNode.isNumber()) {
            jsonNode = processNumberNode(jsonNode);
        } else if (jsonNode.isArray()) {
            jsonNode = processArrayNode((ArrayNode) jsonNode);
        }
        if (this.nodes.contains(jsonNode)) {
            return;
        }
        if (this.schemaContext.getSchemaRegistryConfig().isTypeLoose() && isTypeLooseContainsInEnum(jsonNode)) {
            return;
        }
        executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(this.error).build());
    }
}
