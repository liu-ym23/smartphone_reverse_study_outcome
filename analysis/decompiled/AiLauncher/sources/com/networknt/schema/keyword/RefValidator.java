package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.InvalidSchemaRefException;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SchemaRef;
import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.ThreadSafeCachingSupplier;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public class RefValidator extends BaseKeywordValidator {
    private static final String REF_CURRENT = "#";
    protected final SchemaRef schema;

    public RefValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.REF, jsonNode, schemaLocation, schema, schemaContext);
        this.schema = getRefSchema(schema, schemaContext, jsonNode.asText());
    }

    public static /* synthetic */ Schema c(SchemaContext schemaContext, String str, SchemaLocation schemaLocation, int i10, String str2, String str3) throws UnsupportedEncodingException {
        Schema schemaLoadSchema = schemaContext.getSchemaResources().get(str);
        if (schemaLoadSchema == null && (schemaLoadSchema = schemaContext.getSchemaRegistry().loadSchema(schemaLocation)) != null) {
            copySchemaResources(schemaContext, schemaLoadSchema);
        }
        if (i10 < 0) {
            if (schemaLoadSchema == null) {
                return null;
            }
            return schemaLoadSchema;
        }
        String strSubstring = str2.substring(i10);
        String str4 = schemaLocation.getAbsoluteIri() + strSubstring;
        Schema schema = schemaContext.getSchemaResources().get(str4);
        if (schema == null) {
            schema = schemaContext.getDynamicAnchors().get(str4);
        }
        if (schema == null) {
            schema = getSchema(schemaLoadSchema, schemaContext, strSubstring, str3);
        }
        if (schema == null) {
            return null;
        }
        return schema;
    }

    private static void copySchemaResources(SchemaContext schemaContext, Schema schema) {
        if (!schema.getSchemaContext().getSchemaResources().isEmpty()) {
            schemaContext.getSchemaResources().putAll(schema.getSchemaContext().getSchemaResources());
        }
        if (!schema.getSchemaContext().getSchemaReferences().isEmpty()) {
            schemaContext.getSchemaReferences().putAll(schema.getSchemaContext().getSchemaReferences());
        }
        if (schema.getSchemaContext().getDynamicAnchors().isEmpty()) {
            return;
        }
        schemaContext.getDynamicAnchors().putAll(schema.getSchemaContext().getDynamicAnchors());
    }

    public static /* synthetic */ Schema d(SchemaContext schemaContext, String str, Schema schema, String str2, String str3) throws UnsupportedEncodingException {
        Schema schema2 = schemaContext.getSchemaResources().get(str);
        if (schema2 == null) {
            schema2 = schemaContext.getDynamicAnchors().get(str);
        }
        if (schema2 == null) {
            schema2 = getSchema(schema, schemaContext, str2, str3);
        }
        if (schema2 == null) {
            return null;
        }
        return schema2;
    }

    public static SchemaRef getRefSchema(final Schema schema, final SchemaContext schemaContext, final String str) throws UnsupportedEncodingException {
        if (str.startsWith("#")) {
            if (!SchemaLocation.Fragment.isAnchorFragment(str)) {
                return str.equals("#") ? new SchemaRef(getSupplier(new Supplier() { // from class: com.networknt.schema.keyword.p0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return schema.findSchemaResourceRoot();
                    }
                }, schemaContext.getSchemaRegistryConfig().isCacheRefs())) : new SchemaRef(getSupplier(new Supplier() { // from class: com.networknt.schema.keyword.q0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return RefValidator.getSchema(schema, schemaContext, str, str);
                    }
                }, schemaContext.getSchemaRegistryConfig().isCacheRefs()));
            }
            final String strResolve = resolve(schema, str);
            return new SchemaRef(getSupplier(new Supplier() { // from class: com.networknt.schema.keyword.o0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return RefValidator.d(schemaContext, strResolve, schema, str, str);
                }
            }, schemaContext.getSchemaRegistryConfig().isCacheRefs()));
        }
        final int iIndexOf = str.indexOf("#");
        final String strResolve2 = resolve(schema, iIndexOf > 0 ? str.substring(0, iIndexOf) : str);
        final SchemaLocation schemaLocationOf = SchemaLocation.of(strResolve2);
        return new SchemaRef(getSupplier(new Supplier() { // from class: com.networknt.schema.keyword.n0
            @Override // java.util.function.Supplier
            public final Object get() {
                return RefValidator.c(schemaContext, strResolve2, schemaLocationOf, iIndexOf, str, str);
            }
        }, schemaContext.getSchemaRegistryConfig().isCacheRefs()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Schema getSchema(Schema schema, SchemaContext schemaContext, String str, String str2) throws UnsupportedEncodingException {
        Schema subSchema;
        String strResolve = resolve(schema, str2);
        Schema schema2 = schemaContext.getSchemaReferences().get(strResolve);
        if (schema2 != null) {
            return schema2;
        }
        NodePath nodePathOf = SchemaLocation.Fragment.of(str);
        synchronized (schemaContext.getSchemaRegistry()) {
            try {
                subSchema = schemaContext.getSchemaReferences().get(strResolve);
                if (subSchema == null && (subSchema = schema.getSubSchema(nodePathOf)) != null) {
                    schemaContext.getSchemaReferences().put(strResolve, subSchema);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return subSchema;
    }

    public static <T> Supplier<T> getSupplier(Supplier<T> supplier, boolean z10) {
        return z10 ? new ThreadSafeCachingSupplier(supplier) : supplier;
    }

    private static String resolve(Schema schema, String str) {
        if (schema.getId() != null && schema.getParentSchema() != null && schema.getSchemaContext().getDialect().getSpecificationVersion().getOrder() <= SpecificationVersion.DRAFT_7.getOrder()) {
            schema = schema.getParentSchema();
        }
        return SchemaLocation.resolve(schema.getSchemaLocation(), str);
    }

    public SchemaRef getSchemaRef() {
        return this.schema;
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        try {
            this.schema.getSchema().initializeValidators();
        } catch (SchemaException e10) {
            throw e10;
        } catch (RuntimeException e11) {
            throw new SchemaException(e11);
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        Schema schema = this.schema.getSchema();
        if (schema == null) {
            throw new InvalidSchemaRefException(error().keyword(KeywordType.REF.getValue()).messageKey("internal.unresolvedRef").message("Reference {0} cannot be resolved").instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).arguments(this.schemaNode.asText()).build());
        }
        schema.validate(executionContext, jsonNode, jsonNode2, nodePath);
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        Schema schema = this.schema.getSchema();
        if (schema == null) {
            throw new InvalidSchemaRefException(error().keyword(KeywordType.REF.getValue()).messageKey("internal.unresolvedRef").message("Reference {0} cannot be resolved").instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).arguments(this.schemaNode.asText()).build());
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
