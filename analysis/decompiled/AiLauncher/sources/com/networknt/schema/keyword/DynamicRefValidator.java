package com.networknt.schema.keyword;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.InvalidSchemaRefException;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SchemaRef;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.ThreadSafeCachingSupplier;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public class DynamicRefValidator extends BaseKeywordValidator {
    public DynamicRefValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.DYNAMIC_REF, jsonNode, schemaLocation, schema, schemaContext);
    }

    public static /* synthetic */ Schema a(Schema schema, String str, String str2, ExecutionContext executionContext) throws UnsupportedEncodingException {
        SchemaContext schemaContext = schema.getSchemaContext();
        Schema schema2 = schema.getSchemaContext().getDynamicAnchors().get(str);
        if (schema2 == null) {
            SchemaRef refSchema = RefValidator.getRefSchema(schema, schemaContext, str2);
            return refSchema != null ? refSchema.getSchema() : schema2;
        }
        int iIndexOf = str.indexOf(Const.STR_MART_WELL);
        String strSubstring = str.substring(iIndexOf);
        String strSubstring2 = str.substring(0, iIndexOf);
        Iterator<Schema> itDescendingIterator = executionContext.getEvaluationSchema().descendingIterator();
        while (itDescendingIterator.hasNext()) {
            Schema next = itDescendingIterator.next();
            String string = next.getSchemaLocation().getAbsoluteIri() != null ? next.getSchemaLocation().getAbsoluteIri().toString() : "";
            if (!string.equals(strSubstring2)) {
                Schema schema3 = next.getSchemaContext().getDynamicAnchors().get(SchemaLocation.resolve(next.getSchemaLocation(), strSubstring));
                if (schema3 != null) {
                    schema2 = schema3;
                }
                strSubstring2 = string;
            }
        }
        return schema2;
    }

    public static SchemaRef getRefSchema(final Schema schema, final String str, final ExecutionContext executionContext) {
        final String strResolve = resolve(schema, str);
        return new SchemaRef(getSupplier(new Supplier() { // from class: com.networknt.schema.keyword.g
            @Override // java.util.function.Supplier
            public final Object get() {
                return DynamicRefValidator.a(schema, strResolve, str, executionContext);
            }
        }, false));
    }

    public static <T> Supplier<T> getSupplier(Supplier<T> supplier, boolean z10) {
        return z10 ? new ThreadSafeCachingSupplier(supplier) : supplier;
    }

    private static String resolve(Schema schema, String str) {
        if (schema.getId() != null && schema.getParentSchema() != null) {
            schema = schema.getParentSchema();
        }
        return SchemaLocation.resolve(schema.getSchemaLocation(), str);
    }

    public SchemaRef getSchemaRef(ExecutionContext executionContext) {
        return getRefSchema(getParentSchema(), this.schemaNode.asText(), executionContext);
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        Schema schema = getSchemaRef(executionContext).getSchema();
        if (schema == null) {
            throw new InvalidSchemaRefException(error().keyword(KeywordType.DYNAMIC_REF.getValue()).messageKey("internal.unresolvedRef").message("Reference {0} cannot be resolved").instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).arguments(this.schemaNode.asText()).build());
        }
        schema.validate(executionContext, jsonNode, jsonNode2, nodePath);
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        Schema schema = getSchemaRef(executionContext).getSchema();
        if (schema == null) {
            throw new InvalidSchemaRefException(error().keyword(KeywordType.DYNAMIC_REF.getValue()).messageKey("internal.unresolvedRef").message("Reference {0} cannot be resolved").instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).arguments(this.schemaNode.asText()).build());
        }
        if (jsonNode == null) {
            SchemaLocation schemaLocation = schema.getSchemaLocation();
            Iterator<Schema> itDescendingIterator = executionContext.getEvaluationSchema().descendingIterator();
            while (itDescendingIterator.hasNext()) {
                if (itDescendingIterator.next().getSchemaLocation().equals(schemaLocation)) {
                    return;
                }
            }
        }
        schema.walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
    }
}
