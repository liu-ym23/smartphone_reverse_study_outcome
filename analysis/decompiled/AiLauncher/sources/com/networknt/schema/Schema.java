package com.networknt.schema;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.i18n.MessageFormatter;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.keyword.KeywordValidator;
import com.networknt.schema.keyword.PatternPropertiesValidator;
import com.networknt.schema.keyword.PropertiesValidator;
import com.networknt.schema.keyword.TypeValidator;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.path.PathType;
import com.networknt.schema.resource.ClasspathResourceLoader;
import com.networknt.schema.resource.InputStreamSource;
import com.networknt.schema.resource.ResourceLoader;
import com.networknt.schema.utils.JsonNodes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class Schema implements Validator {
    private static final long DRAFT_2019_09_VALUE = SpecificationVersion.DRAFT_2019_09.getOrder();
    private static final Comparator<KeywordValidator> VALIDATOR_SORT = new Comparator() { // from class: com.networknt.schema.r
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Schema.f((KeywordValidator) obj, (KeywordValidator) obj2);
        }
    };
    private final String id;
    protected final Schema parentSchema;
    private boolean recursiveAnchor;
    protected final SchemaContext schemaContext;
    protected final SchemaLocation schemaLocation;
    protected final JsonNode schemaNode;
    protected final boolean suppressSubSchemaRetrieval;
    private boolean unevaluatedItemsPresent;
    private boolean unevaluatedPropertiesPresent;
    private List<KeywordValidator> validators;
    private boolean validatorsLoaded;

    public static class JsonNodePathJsonPath {
        private static final NodePath INSTANCE = new NodePath(PathType.JSON_PATH);

        public static NodePath getInstance() {
            return INSTANCE;
        }
    }

    public static class JsonNodePathJsonPointer {
        private static final NodePath INSTANCE = new NodePath(PathType.JSON_POINTER);

        public static NodePath getInstance() {
            return INSTANCE;
        }
    }

    public static class JsonNodePathLegacy {
        private static final NodePath INSTANCE = new NodePath(PathType.LEGACY);

        public static NodePath getInstance() {
            return INSTANCE;
        }
    }

    private Schema(SchemaContext schemaContext, SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, boolean z10) {
        this.validators = null;
        this.unevaluatedPropertiesPresent = false;
        this.unevaluatedItemsPresent = false;
        this.validatorsLoaded = false;
        this.recursiveAnchor = false;
        this.schemaContext = schemaContext;
        SchemaLocation schemaLocationResolve = resolve(schemaLocation, jsonNode, schema == null, schemaContext);
        this.schemaLocation = schemaLocationResolve;
        this.schemaNode = jsonNode;
        this.parentSchema = schema;
        this.suppressSubSchemaRetrieval = z10;
        String strResolveSchemaId = schemaContext.resolveSchemaId(jsonNode);
        if (strResolveSchemaId != null) {
            SchemaLocation schemaLocationResolve2 = strResolveSchemaId.indexOf(35) != -1 ? schemaLocation.resolve(strResolveSchemaId) : schemaLocationResolve;
            if (hasNoFragment(schemaLocationResolve2)) {
                this.id = strResolveSchemaId;
            } else {
                this.id = null;
            }
            schemaContext.getSchemaResources().putIfAbsent(schemaLocationResolve2 != null ? schemaLocationResolve2.toString() : strResolveSchemaId, this);
        } else if (hasNoFragment(schemaLocation)) {
            this.id = schemaLocation.getAbsoluteIri() != null ? schemaLocation.getAbsoluteIri().toString() : "";
            schemaContext.getSchemaResources().putIfAbsent(schemaLocation.toString(), this);
        } else {
            this.id = null;
        }
        String anchor = schemaContext.getDialect().readAnchor(jsonNode);
        if (anchor != null) {
            String string = schemaLocationResolve.getAbsoluteIri() != null ? schemaLocationResolve.getAbsoluteIri().toString() : "";
            schemaContext.getSchemaResources().putIfAbsent(string + Const.STR_MART_WELL + anchor, this);
        }
        String dynamicAnchor = schemaContext.getDialect().readDynamicAnchor(jsonNode);
        if (dynamicAnchor != null) {
            String string2 = schemaLocationResolve.getAbsoluteIri() != null ? schemaLocationResolve.getAbsoluteIri().toString() : "";
            schemaContext.getDynamicAnchors().putIfAbsent(string2 + Const.STR_MART_WELL + dynamicAnchor, this);
        }
        getValidators();
    }

    private JsonNode deserialize(String str, InputFormat inputFormat) {
        try {
            return getSchemaContext().getSchemaRegistry().readTree(str, inputFormat);
        } catch (IOException e10) {
            throw new UncheckedIOException("Invalid input", e10);
        }
    }

    public static /* synthetic */ int f(KeywordValidator keywordValidator, KeywordValidator keywordValidator2) {
        String keyword = keywordValidator.getKeyword();
        String keyword2 = keywordValidator2.getKeyword();
        if (keyword.equals(keyword2)) {
            return 0;
        }
        if (keyword.equals("discriminator")) {
            return -1;
        }
        if (keyword2.equals("discriminator")) {
            return 1;
        }
        if (keyword.equals("type")) {
            return -1;
        }
        if (keyword2.equals("type")) {
            return 1;
        }
        if (keyword.equals(PropertiesValidator.PROPERTY)) {
            return -1;
        }
        if (keyword2.equals(PropertiesValidator.PROPERTY)) {
            return 1;
        }
        if (keyword.equals(PatternPropertiesValidator.PROPERTY)) {
            return -1;
        }
        if (keyword2.equals(PatternPropertiesValidator.PROPERTY) || keyword.equals("unevaluatedItems")) {
            return 1;
        }
        if (keyword2.equals("unevaluatedItems")) {
            return -1;
        }
        if (keyword.equals("unevaluatedProperties")) {
            return 1;
        }
        return keyword2.equals("unevaluatedProperties") ? -1 : 0;
    }

    public static Schema from(SchemaContext schemaContext, SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, boolean z10) {
        return new Schema(schemaContext, schemaLocation, jsonNode, schema, z10);
    }

    private InputStreamSource getInputResource(AbsoluteIri absoluteIri) {
        Iterator<ResourceLoader> it = getSchemaContext().getSchemaRegistry().getSchemaLoader().getResourceLoaders().iterator();
        while (it.hasNext()) {
            InputStreamSource resource = it.next().getResource(absoluteIri);
            if (resource != null) {
                return resource;
            }
        }
        return ClasspathResourceLoader.getInstance().getResource(absoluteIri);
    }

    private JsonNode handleNullNode(String str, Schema schema) {
        Schema schemaFetchSubSchemaNode = schema.fetchSubSchemaNode(this.schemaContext);
        if (schemaFetchSubSchemaNode != null) {
            return schemaFetchSubSchemaNode.getRefSchemaNode(str);
        }
        return null;
    }

    private boolean hasNoFragment(SchemaLocation schemaLocation) {
        NodePath fragment = this.schemaLocation.getFragment();
        if (fragment != null) {
            return fragment.getParent() == null && fragment.getNameCount() == 0;
        }
        return true;
    }

    private static Schema obtainSubSchemaNode(JsonNode jsonNode, SchemaContext schemaContext) throws UnsupportedEncodingException {
        JsonNode jsonNode2 = jsonNode.get("id");
        if (jsonNode2 == null || jsonNode2.equals(jsonNode.get("$schema")) || jsonNode2.textValue() == null) {
            return null;
        }
        return schemaContext.getSchemaRegistry().getSchema(SchemaLocation.of(jsonNode2.textValue()));
    }

    private List<KeywordValidator> read(JsonNode jsonNode) {
        ArrayList arrayList;
        if (jsonNode.isBoolean()) {
            arrayList = new ArrayList(1);
            if (jsonNode.booleanValue()) {
                arrayList.add(this.schemaContext.newValidator(getSchemaLocation().append("true"), "true", jsonNode, this));
            } else {
                arrayList.add(this.schemaContext.newValidator(getSchemaLocation().append("false"), "false", jsonNode, this));
            }
        } else {
            Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
            ArrayList arrayList2 = new ArrayList(jsonNode.size());
            KeywordValidator keywordValidator = null;
            while (itFields.hasNext()) {
                Map.Entry<String, JsonNode> next = itFields.next();
                String key = next.getKey();
                JsonNode value = next.getValue();
                SchemaLocation schemaLocationAppend = getSchemaLocation().append(key);
                if ("$recursiveAnchor".equals(key)) {
                    if (!value.isBoolean()) {
                        throw new SchemaException(Error.builder().keyword("$recursiveAnchor").messageKey("internal.invalidRecursiveAnchor").message("The value of a $recursiveAnchor must be a Boolean literal but is {0}").instanceLocation(null).evaluationPath(null).schemaLocation(schemaLocationAppend).arguments(value.getNodeType().toString()).build());
                    }
                    this.recursiveAnchor = value.booleanValue();
                }
                KeywordValidator keywordValidatorNewValidator = this.schemaContext.newValidator(schemaLocationAppend, key, value, this);
                if (keywordValidatorNewValidator != null) {
                    arrayList2.add(keywordValidatorNewValidator);
                    if ("unevaluatedProperties".equals(key)) {
                        this.unevaluatedPropertiesPresent = true;
                    } else if ("unevaluatedItems".equals(key)) {
                        this.unevaluatedItemsPresent = true;
                    }
                    if ("$ref".equals(key)) {
                        keywordValidator = keywordValidatorNewValidator;
                    }
                }
            }
            if (keywordValidator != null && getSchemaContext().getDialect().getSpecificationVersion().getOrder() < DRAFT_2019_09_VALUE) {
                arrayList2.clear();
                arrayList2.add(keywordValidator);
            }
            arrayList = arrayList2;
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, VALIDATOR_SORT);
        }
        return arrayList;
    }

    private static SchemaLocation resolve(SchemaLocation schemaLocation, JsonNode jsonNode, boolean z10, final SchemaContext schemaContext) {
        String strResolveSchemaId = schemaContext.resolveSchemaId(jsonNode);
        if (strResolveSchemaId == null) {
            return schemaLocation;
        }
        int iIndexOf = strResolveSchemaId.indexOf(35);
        String strSubstring = (iIndexOf == -1 || iIndexOf + 1 >= strResolveSchemaId.length()) ? strResolveSchemaId : strResolveSchemaId.substring(0, iIndexOf);
        SchemaLocation schemaLocationResolve = !"".equals(strSubstring) ? schemaLocation.resolve(strSubstring) : schemaLocation;
        SchemaIdValidator schemaIdValidator = schemaContext.getSchemaRegistryConfig().getSchemaIdValidator();
        if (schemaIdValidator == null || schemaIdValidator.validate(strResolveSchemaId, z10, schemaLocation, schemaLocationResolve, schemaContext)) {
            return schemaLocationResolve;
        }
        SchemaLocation schemaLocationAppend = schemaLocation.append(schemaContext.getDialect().getIdKeyword());
        Error.Builder builder = Error.builder();
        KeywordType keywordType = KeywordType.ID;
        throw new InvalidSchemaException(builder.messageKey(keywordType.getValue()).keyword(keywordType.getValue()).instanceLocation(schemaLocationAppend.getFragment()).arguments(strResolveSchemaId, schemaContext.getDialect().getIdKeyword(), schemaLocationAppend).schemaLocation(schemaLocationAppend).schemaNode(jsonNode).messageFormatter(new MessageFormatter() { // from class: com.networknt.schema.q
            @Override // com.networknt.schema.i18n.MessageFormatter
            public final String format(Object[] objArr) {
                SchemaContext schemaContext2 = schemaContext;
                return schemaContext2.getSchemaRegistryConfig().getMessageSource().getMessage(KeywordType.ID.getValue(), schemaContext2.getSchemaRegistryConfig().getLocale(), objArr);
            }
        }).build());
    }

    private <T> T walkAtNodeInternal(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10, OutputFormat<T> outputFormat, final Consumer<ExecutionContext> consumer) {
        return (T) walkAtNodeInternal(executionContext, jsonNode, jsonNode2, nodePath, z10, outputFormat, new ExecutionContextCustomizer() { // from class: com.networknt.schema.p
            @Override // com.networknt.schema.ExecutionContextCustomizer
            public final void customize(ExecutionContext executionContext2, SchemaContext schemaContext) {
                consumer.accept(executionContext2);
            }
        });
    }

    public NodePath atRoot() {
        return this.schemaContext.getSchemaRegistryConfig().getPathType().equals(PathType.JSON_POINTER) ? JsonNodePathJsonPointer.getInstance() : this.schemaContext.getSchemaRegistryConfig().getPathType().equals(PathType.LEGACY) ? JsonNodePathLegacy.getInstance() : this.schemaContext.getSchemaRegistryConfig().getPathType().equals(PathType.JSON_PATH) ? JsonNodePathJsonPath.getInstance() : new NodePath(this.schemaContext.getSchemaRegistryConfig().getPathType());
    }

    public ExecutionContext createExecutionContext() {
        SchemaRegistryConfig schemaRegistryConfig = this.schemaContext.getSchemaRegistryConfig();
        ExecutionContext executionContext = new ExecutionContext(ExecutionConfig.builder().locale(schemaRegistryConfig.getLocale()).formatAssertionsEnabled(schemaRegistryConfig.getFormatAssertionsEnabled()).failFast(schemaRegistryConfig.isFailFast()).build());
        if (schemaRegistryConfig.getExecutionContextCustomizer() != null) {
            schemaRegistryConfig.getExecutionContextCustomizer().customize(executionContext, this.schemaContext);
        }
        return executionContext;
    }

    public Schema fetchSubSchemaNode(SchemaContext schemaContext) {
        if (this.suppressSubSchemaRetrieval) {
            return null;
        }
        return obtainSubSchemaNode(this.schemaNode, schemaContext);
    }

    public Schema findAncestor() {
        return getParentSchema() != null ? getParentSchema().findAncestor() : this;
    }

    public Schema findLexicalRoot() {
        while (this.getId() == null && this.getParentSchema() != null) {
            this = this.getParentSchema();
        }
        return this;
    }

    public Schema findSchemaResourceRoot() {
        while (!this.isSchemaResourceRoot()) {
            this = this.getParentSchema();
        }
        return this;
    }

    public String getId() {
        return this.id;
    }

    public JsonNode getNode(Object obj) {
        return getNode(this.schemaNode, obj);
    }

    public Schema getParentSchema() {
        return this.parentSchema;
    }

    public Schema getRefSchema(NodePath nodePath) {
        if (PathType.JSON_POINTER.equals(nodePath.getPathType())) {
            return getSubSchema(nodePath);
        }
        String str = (getSchemaLocation().getAbsoluteIri() != null ? this.schemaLocation.getAbsoluteIri().toString() : "") + Const.STR_MART_WELL + nodePath;
        Schema schema = this.schemaContext.getSchemaResources().get(str);
        if (schema == null) {
            schema = this.schemaContext.getDynamicAnchors().get(str);
        }
        if (schema != null) {
            return schema;
        }
        throw new SchemaException("Unable to find anchor " + str);
    }

    public JsonNode getRefSchemaNode(String str) throws UnsupportedEncodingException {
        Schema schemaFindSchemaResourceRoot = findSchemaResourceRoot();
        JsonNode schemaNode = schemaFindSchemaResourceRoot.getSchemaNode();
        String strSubstring = (schemaFindSchemaResourceRoot.getId() == null || !str.startsWith(schemaFindSchemaResourceRoot.getId())) ? str : str.substring(schemaFindSchemaResourceRoot.getId().length());
        if (strSubstring.startsWith("#/")) {
            strSubstring = strSubstring.substring(1);
        }
        if (!strSubstring.startsWith("/")) {
            return schemaNode;
        }
        try {
            strSubstring = URLDecoder.decode(strSubstring, "utf-8");
        } catch (UnsupportedEncodingException unused) {
        }
        JsonNode jsonNodeAt = schemaNode.at(strSubstring);
        return jsonNodeAt.isMissingNode() ? handleNullNode(str, schemaFindSchemaResourceRoot) : jsonNodeAt;
    }

    public SchemaContext getSchemaContext() {
        return this.schemaContext;
    }

    @Override // com.networknt.schema.Validator
    public SchemaLocation getSchemaLocation() {
        return this.schemaLocation;
    }

    public JsonNode getSchemaNode() {
        return this.schemaNode;
    }

    public Schema getSubSchema(NodePath nodePath) {
        Schema schemaFindSchemaResourceRoot = findSchemaResourceRoot();
        JsonNode schemaNode = schemaFindSchemaResourceRoot.getSchemaNode();
        SchemaLocation schemaLocation = schemaFindSchemaResourceRoot.getSchemaLocation();
        int nameCount = nodePath.getNameCount();
        int i10 = 0;
        Schema schema = schemaFindSchemaResourceRoot;
        Schema schemaNewSchema = null;
        while (i10 < nameCount) {
            Object element = nodePath.getElement(i10);
            JsonNode node = getNode(schemaNode, element);
            if (node == null) {
                Schema schemaFetchSubSchemaNode = schemaFindSchemaResourceRoot.findSchemaResourceRoot().fetchSubSchemaNode(this.schemaContext);
                if (schemaFetchSubSchemaNode != null) {
                    schemaFetchSubSchemaNode = schemaFetchSubSchemaNode.getSubSchema(nodePath);
                }
                if (schemaFetchSubSchemaNode != null) {
                    return schemaFetchSubSchemaNode;
                }
                throw new InvalidSchemaRefException(Error.builder().keyword(KeywordType.REF.getValue()).messageKey("internal.unresolvedRef").message("Reference {0} cannot be resolved").instanceLocation(schemaLocation.getFragment()).schemaLocation(schemaLocation).evaluationPath(null).arguments(nodePath).build());
            }
            SchemaLocation schemaLocationAppend = ((element instanceof Number) && schemaNode.isArray()) ? schemaLocation.append(((Number) element).intValue()) : schemaLocation.append(element.toString());
            if (schema.getSchemaContext().resolveSchemaId(node) != null || i10 == nameCount - 1) {
                schemaNewSchema = schema.getSchemaContext().newSchema(schemaLocationAppend, node, schema);
                schemaLocationAppend = schemaNewSchema.getSchemaLocation();
                schema = schemaNewSchema;
            }
            schemaLocation = schemaLocationAppend;
            i10++;
            schemaNode = node;
        }
        return schemaNewSchema;
    }

    public List<KeywordValidator> getValidators() {
        if (this.validators == null) {
            this.validators = Collections.unmodifiableList(read(getSchemaNode()));
        }
        return this.validators;
    }

    public boolean hasKeyword(String str) {
        return this.schemaNode.has(str);
    }

    public void initializeValidators() {
        if (this.validatorsLoaded) {
            return;
        }
        this.validatorsLoaded = true;
        try {
            Iterator<KeywordValidator> it = getValidators().iterator();
            while (it.hasNext()) {
                it.next().preloadSchema();
            }
        } catch (RuntimeException e10) {
            this.validatorsLoaded = false;
            throw e10;
        }
    }

    public boolean isRecursiveAnchor() {
        return this.recursiveAnchor;
    }

    public boolean isSchemaResourceRoot() {
        if (getId() == null && getParentSchema() != null) {
            return !Objects.equals(getSchemaLocation().getAbsoluteIri(), getParentSchema().getSchemaLocation().getAbsoluteIri());
        }
        return true;
    }

    public boolean isSuppressSubSchemaRetrieval() {
        return this.suppressSubSchemaRetrieval;
    }

    public String toString() {
        return getSchemaNode().toString();
    }

    public void validate(ExecutionContext executionContext, JsonNode jsonNode) {
        executionContext.evaluationPath = atRoot();
        validate(executionContext, jsonNode, jsonNode, atRoot());
    }

    public Result walk(ExecutionContext executionContext, JsonNode jsonNode, boolean z10, ExecutionContextCustomizer executionContextCustomizer) {
        return (Result) walkAtNodeInternal(executionContext, jsonNode, jsonNode, atRoot(), z10, OutputFormat.RESULT, executionContextCustomizer);
    }

    public Result walkAtNode(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        return (Result) walkAtNodeInternal(executionContext, jsonNode, jsonNode2, nodePath, z10, OutputFormat.RESULT, (ExecutionContextCustomizer) null);
    }

    private <T> T walkAtNodeInternal(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10, OutputFormat<T> outputFormat, ExecutionContextCustomizer executionContextCustomizer) {
        if (executionContextCustomizer != null) {
            executionContextCustomizer.customize(executionContext, this.schemaContext);
        }
        executionContext.evaluationPath = atRoot();
        walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
        return outputFormat.format(this, executionContext, this.schemaContext);
    }

    public JsonNode getNode(JsonNode jsonNode, Object obj) {
        return JsonNodes.get(jsonNode, obj);
    }

    public <T> T walk(ExecutionContext executionContext, JsonNode jsonNode, OutputFormat<T> outputFormat, boolean z10, ExecutionContextCustomizer executionContextCustomizer) {
        return (T) walkAtNodeInternal(executionContext, jsonNode, jsonNode, atRoot(), z10, outputFormat, executionContextCustomizer);
    }

    private JsonNode deserialize(AbsoluteIri absoluteIri, InputFormat inputFormat) throws IOException {
        try {
            InputStreamSource inputResource = getInputResource(absoluteIri);
            if (inputResource != null) {
                InputStream inputStream = inputResource.getInputStream();
                try {
                    JsonNode tree = getSchemaContext().getSchemaRegistry().readTree(inputStream, inputFormat);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return tree;
                } finally {
                }
            }
            throw new UncheckedIOException(new FileNotFoundException(absoluteIri.toString() + " not found"));
        } catch (IOException e10) {
            throw new UncheckedIOException("Invalid input", e10);
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        List<Annotation> list;
        List<KeywordValidator> validators = getValidators();
        executionContext.evaluationSchema.addLast(this);
        boolean z10 = executionContext.unevaluatedPropertiesPresent;
        boolean z11 = executionContext.unevaluatedItemsPresent;
        boolean z12 = this.unevaluatedPropertiesPresent;
        if (z12) {
            executionContext.unevaluatedPropertiesPresent = z12;
        }
        boolean z13 = this.unevaluatedItemsPresent;
        if (z13) {
            executionContext.unevaluatedItemsPresent = z13;
        }
        try {
            int size = executionContext.getErrors().size();
            for (KeywordValidator keywordValidator : validators) {
                executionContext.evaluationPathAddLast(keywordValidator.getKeyword());
                executionContext.evaluationSchemaPath.addLast(keywordValidator.getKeyword());
                try {
                    keywordValidator.validate(executionContext, jsonNode, jsonNode2, nodePath);
                    executionContext.evaluationPathRemoveLast();
                    executionContext.evaluationSchemaPath.removeLast();
                } catch (Throwable th) {
                    executionContext.evaluationPathRemoveLast();
                    executionContext.evaluationSchemaPath.removeLast();
                    throw th;
                }
            }
            if (executionContext.getErrors().size() > size && (list = executionContext.getAnnotations().asMap().get(nodePath)) != null) {
                for (Annotation annotation : list) {
                    if (annotation.getEvaluationPath().startsWith(executionContext.getEvaluationPath())) {
                        annotation.setValid(false);
                    }
                }
            }
            executionContext.evaluationSchema.removeLast();
            executionContext.unevaluatedPropertiesPresent = z10;
            executionContext.unevaluatedItemsPresent = z11;
        } catch (Throwable th2) {
            executionContext.evaluationSchema.removeLast();
            executionContext.unevaluatedPropertiesPresent = z10;
            executionContext.unevaluatedItemsPresent = z11;
            throw th2;
        }
    }

    public Result walk(ExecutionContext executionContext, JsonNode jsonNode, boolean z10, Consumer<ExecutionContext> consumer) {
        return (Result) walkAtNodeInternal(executionContext, jsonNode, jsonNode, atRoot(), z10, OutputFormat.RESULT, consumer);
    }

    public <T> T walk(ExecutionContext executionContext, JsonNode jsonNode, OutputFormat<T> outputFormat, boolean z10, Consumer<ExecutionContext> consumer) {
        return (T) walkAtNodeInternal(executionContext, jsonNode, jsonNode, atRoot(), z10, outputFormat, consumer);
    }

    public Result walk(ExecutionContext executionContext, JsonNode jsonNode, boolean z10) {
        return (Result) walkAtNodeInternal(executionContext, jsonNode, jsonNode, atRoot(), z10, OutputFormat.RESULT, (ExecutionContextCustomizer) null);
    }

    public Result walk(ExecutionContext executionContext, String str, InputFormat inputFormat, boolean z10) {
        JsonNode jsonNodeDeserialize = deserialize(str, inputFormat);
        return (Result) walkAtNodeInternal(executionContext, jsonNodeDeserialize, jsonNodeDeserialize, atRoot(), z10, OutputFormat.RESULT, (ExecutionContextCustomizer) null);
    }

    public <T> T walk(ExecutionContext executionContext, String str, InputFormat inputFormat, OutputFormat<T> outputFormat, boolean z10) {
        JsonNode jsonNodeDeserialize = deserialize(str, inputFormat);
        return (T) walkAtNodeInternal(executionContext, jsonNodeDeserialize, jsonNodeDeserialize, atRoot(), z10, outputFormat, (ExecutionContextCustomizer) null);
    }

    public Result walk(ExecutionContext executionContext, String str, InputFormat inputFormat, boolean z10, ExecutionContextCustomizer executionContextCustomizer) {
        JsonNode jsonNodeDeserialize = deserialize(str, inputFormat);
        return (Result) walkAtNodeInternal(executionContext, jsonNodeDeserialize, jsonNodeDeserialize, atRoot(), z10, OutputFormat.RESULT, executionContextCustomizer);
    }

    public <T> T walk(ExecutionContext executionContext, String str, InputFormat inputFormat, OutputFormat<T> outputFormat, boolean z10, ExecutionContextCustomizer executionContextCustomizer) {
        JsonNode jsonNodeDeserialize = deserialize(str, inputFormat);
        return (T) walkAtNodeInternal(executionContext, jsonNodeDeserialize, jsonNodeDeserialize, atRoot(), z10, outputFormat, executionContextCustomizer);
    }

    public Result walk(JsonNode jsonNode, boolean z10) {
        return walk(createExecutionContext(), jsonNode, z10);
    }

    public Result walk(JsonNode jsonNode, boolean z10, ExecutionContextCustomizer executionContextCustomizer) {
        return walk(createExecutionContext(), jsonNode, z10, executionContextCustomizer);
    }

    public Result walk(JsonNode jsonNode, boolean z10, Consumer<ExecutionContext> consumer) {
        return walk(createExecutionContext(), jsonNode, z10, consumer);
    }

    public <T> T walk(JsonNode jsonNode, OutputFormat<T> outputFormat, boolean z10) {
        return (T) walk(createExecutionContext(), jsonNode, outputFormat, z10, (ExecutionContextCustomizer) null);
    }

    public Result walk(String str, InputFormat inputFormat, boolean z10) {
        return walk(createExecutionContext(), deserialize(str, inputFormat), z10);
    }

    public Result walk(String str, InputFormat inputFormat, boolean z10, ExecutionContextCustomizer executionContextCustomizer) {
        return walk(createExecutionContext(), deserialize(str, inputFormat), z10, executionContextCustomizer);
    }

    public Result walk(String str, InputFormat inputFormat, boolean z10, Consumer<ExecutionContext> consumer) {
        return walk(createExecutionContext(), deserialize(str, inputFormat), z10, consumer);
    }

    public Result walk(AbsoluteIri absoluteIri, InputFormat inputFormat, boolean z10) {
        return walk(createExecutionContext(), deserialize(absoluteIri, inputFormat), z10);
    }

    public Result walk(AbsoluteIri absoluteIri, InputFormat inputFormat, boolean z10, ExecutionContextCustomizer executionContextCustomizer) {
        return walk(createExecutionContext(), deserialize(absoluteIri, inputFormat), z10, executionContextCustomizer);
    }

    public Result walk(AbsoluteIri absoluteIri, InputFormat inputFormat, boolean z10, Consumer<ExecutionContext> consumer) {
        return walk(createExecutionContext(), deserialize(absoluteIri, inputFormat), z10, consumer);
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        List<KeywordValidator> validators = getValidators();
        executionContext.evaluationSchema.addLast(this);
        boolean z11 = executionContext.unevaluatedPropertiesPresent;
        boolean z12 = executionContext.unevaluatedItemsPresent;
        boolean z13 = this.unevaluatedPropertiesPresent;
        if (z13) {
            executionContext.unevaluatedPropertiesPresent = z13;
        }
        boolean z14 = this.unevaluatedItemsPresent;
        if (z14) {
            executionContext.unevaluatedItemsPresent = z14;
        }
        try {
            int size = executionContext.getErrors().size();
            Iterator<KeywordValidator> it = validators.iterator();
            while (it.hasNext()) {
                KeywordValidator next = it.next();
                try {
                    if (executionContext.getWalkConfig().getKeywordWalkHandler().preWalk(executionContext, next.getKeyword(), jsonNode, jsonNode2, nodePath, this, next)) {
                        executionContext.evaluationPathAddLast(next.getKeyword());
                        executionContext.evaluationSchemaPath.addLast(next.getKeyword());
                        try {
                            next.walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
                            next = next;
                            executionContext.evaluationPathRemoveLast();
                            executionContext.evaluationSchemaPath.removeLast();
                        } finally {
                        }
                    }
                    executionContext.getWalkConfig().getKeywordWalkHandler().postWalk(executionContext, next.getKeyword(), jsonNode, jsonNode2, nodePath, this, next, executionContext.getErrors().subList(size, executionContext.getErrors().size()));
                } catch (Throwable th) {
                    executionContext.getWalkConfig().getKeywordWalkHandler().postWalk(executionContext, next.getKeyword(), jsonNode, jsonNode2, nodePath, this, next, executionContext.getErrors().subList(size, executionContext.getErrors().size()));
                    throw th;
                }
            }
            executionContext.evaluationSchema.removeLast();
            executionContext.unevaluatedPropertiesPresent = z11;
            executionContext.unevaluatedItemsPresent = z12;
        } catch (Throwable th2) {
            executionContext.evaluationSchema.removeLast();
            executionContext.unevaluatedPropertiesPresent = z11;
            executionContext.unevaluatedItemsPresent = z12;
            throw th2;
        }
    }

    public List<Error> validate(JsonNode jsonNode) {
        return (List) validate(jsonNode, OutputFormat.DEFAULT);
    }

    public List<Error> validate(JsonNode jsonNode, ExecutionContextCustomizer executionContextCustomizer) {
        return (List) validate(jsonNode, OutputFormat.DEFAULT, executionContextCustomizer);
    }

    public List<Error> validate(JsonNode jsonNode, Consumer<ExecutionContext> consumer) {
        return (List) validate(jsonNode, OutputFormat.DEFAULT, consumer);
    }

    public Schema(List<KeywordValidator> list, boolean z10, boolean z11, TypeValidator typeValidator, String str, boolean z12, JsonNode jsonNode, SchemaContext schemaContext, Schema schema, SchemaLocation schemaLocation, Map<String, String> map) {
        this.unevaluatedPropertiesPresent = false;
        this.unevaluatedItemsPresent = false;
        this.validators = list;
        this.validatorsLoaded = z10;
        this.recursiveAnchor = z11;
        this.id = str;
        this.schemaContext = schemaContext;
        this.schemaLocation = schemaLocation;
        this.schemaNode = jsonNode;
        this.parentSchema = schema;
        this.suppressSubSchemaRetrieval = z12;
    }

    public <T> T validate(JsonNode jsonNode, OutputFormat<T> outputFormat) {
        return (T) validate(jsonNode, outputFormat, (ExecutionContextCustomizer) null);
    }

    public <T> T validate(JsonNode jsonNode, OutputFormat<T> outputFormat, ExecutionContextCustomizer executionContextCustomizer) {
        return (T) validate(createExecutionContext(), jsonNode, outputFormat, executionContextCustomizer);
    }

    public <T> T validate(JsonNode jsonNode, OutputFormat<T> outputFormat, final Consumer<ExecutionContext> consumer) {
        return (T) validate(createExecutionContext(), jsonNode, outputFormat, new ExecutionContextCustomizer() { // from class: com.networknt.schema.l
            @Override // com.networknt.schema.ExecutionContextCustomizer
            public final void customize(ExecutionContext executionContext, SchemaContext schemaContext) {
                consumer.accept(executionContext);
            }
        });
    }

    public List<Error> validate(String str, InputFormat inputFormat) {
        return (List) validate(deserialize(str, inputFormat), OutputFormat.DEFAULT);
    }

    public List<Error> validate(String str, InputFormat inputFormat, ExecutionContextCustomizer executionContextCustomizer) {
        return (List) validate(deserialize(str, inputFormat), OutputFormat.DEFAULT, executionContextCustomizer);
    }

    public List<Error> validate(String str, InputFormat inputFormat, Consumer<ExecutionContext> consumer) {
        return (List) validate(deserialize(str, inputFormat), OutputFormat.DEFAULT, consumer);
    }

    public <T> T validate(String str, InputFormat inputFormat, OutputFormat<T> outputFormat) {
        return (T) validate(deserialize(str, inputFormat), outputFormat, (ExecutionContextCustomizer) null);
    }

    public <T> T validate(String str, InputFormat inputFormat, OutputFormat<T> outputFormat, ExecutionContextCustomizer executionContextCustomizer) {
        return (T) validate(createExecutionContext(), deserialize(str, inputFormat), outputFormat, executionContextCustomizer);
    }

    public <T> T validate(String str, InputFormat inputFormat, OutputFormat<T> outputFormat, final Consumer<ExecutionContext> consumer) {
        return (T) validate(createExecutionContext(), deserialize(str, inputFormat), outputFormat, new ExecutionContextCustomizer() { // from class: com.networknt.schema.s
            @Override // com.networknt.schema.ExecutionContextCustomizer
            public final void customize(ExecutionContext executionContext, SchemaContext schemaContext) {
                consumer.accept(executionContext);
            }
        });
    }

    public List<Error> validate(AbsoluteIri absoluteIri, InputFormat inputFormat) {
        return (List) validate(deserialize(absoluteIri, inputFormat), OutputFormat.DEFAULT);
    }

    public List<Error> validate(AbsoluteIri absoluteIri, InputFormat inputFormat, ExecutionContextCustomizer executionContextCustomizer) {
        return (List) validate(deserialize(absoluteIri, inputFormat), OutputFormat.DEFAULT, executionContextCustomizer);
    }

    public List<Error> validate(AbsoluteIri absoluteIri, InputFormat inputFormat, Consumer<ExecutionContext> consumer) {
        return (List) validate(deserialize(absoluteIri, inputFormat), OutputFormat.DEFAULT, consumer);
    }

    public <T> T validate(AbsoluteIri absoluteIri, InputFormat inputFormat, OutputFormat<T> outputFormat) {
        return (T) validate(deserialize(absoluteIri, inputFormat), outputFormat, (ExecutionContextCustomizer) null);
    }

    public <T> T validate(AbsoluteIri absoluteIri, InputFormat inputFormat, OutputFormat<T> outputFormat, ExecutionContextCustomizer executionContextCustomizer) {
        return (T) validate(createExecutionContext(), deserialize(absoluteIri, inputFormat), outputFormat, executionContextCustomizer);
    }

    public <T> T validate(AbsoluteIri absoluteIri, InputFormat inputFormat, OutputFormat<T> outputFormat, final Consumer<ExecutionContext> consumer) {
        return (T) validate(createExecutionContext(), deserialize(absoluteIri, inputFormat), outputFormat, new ExecutionContextCustomizer() { // from class: com.networknt.schema.o
            @Override // com.networknt.schema.ExecutionContextCustomizer
            public final void customize(ExecutionContext executionContext, SchemaContext schemaContext) {
                consumer.accept(executionContext);
            }
        });
    }

    public List<Error> validate(ExecutionContext executionContext, String str, InputFormat inputFormat) {
        return (List) validate(executionContext, deserialize(str, inputFormat), OutputFormat.DEFAULT);
    }

    public List<Error> validate(ExecutionContext executionContext, String str, InputFormat inputFormat, ExecutionContextCustomizer executionContextCustomizer) {
        return (List) validate(executionContext, deserialize(str, inputFormat), OutputFormat.DEFAULT, executionContextCustomizer);
    }

    public List<Error> validate(ExecutionContext executionContext, String str, InputFormat inputFormat, Consumer<ExecutionContext> consumer) {
        return (List) validate(executionContext, deserialize(str, inputFormat), OutputFormat.DEFAULT, consumer);
    }

    public <T> T validate(ExecutionContext executionContext, String str, InputFormat inputFormat, OutputFormat<T> outputFormat) {
        return (T) validate(executionContext, deserialize(str, inputFormat), outputFormat, (ExecutionContextCustomizer) null);
    }

    public <T> T validate(ExecutionContext executionContext, String str, InputFormat inputFormat, OutputFormat<T> outputFormat, ExecutionContextCustomizer executionContextCustomizer) {
        return (T) validate(executionContext, deserialize(str, inputFormat), outputFormat, executionContextCustomizer);
    }

    public <T> T validate(ExecutionContext executionContext, String str, InputFormat inputFormat, OutputFormat<T> outputFormat, final Consumer<ExecutionContext> consumer) {
        return (T) validate(executionContext, deserialize(str, inputFormat), outputFormat, new ExecutionContextCustomizer() { // from class: com.networknt.schema.n
            @Override // com.networknt.schema.ExecutionContextCustomizer
            public final void customize(ExecutionContext executionContext2, SchemaContext schemaContext) {
                consumer.accept(executionContext2);
            }
        });
    }

    public <T> T validate(ExecutionContext executionContext, JsonNode jsonNode, OutputFormat<T> outputFormat) {
        return (T) validate(executionContext, jsonNode, outputFormat, (ExecutionContextCustomizer) null);
    }

    public <T> T validate(ExecutionContext executionContext, JsonNode jsonNode, OutputFormat<T> outputFormat, final Consumer<ExecutionContext> consumer) {
        return (T) validate(executionContext, jsonNode, outputFormat, new ExecutionContextCustomizer() { // from class: com.networknt.schema.m
            @Override // com.networknt.schema.ExecutionContextCustomizer
            public final void customize(ExecutionContext executionContext2, SchemaContext schemaContext) {
                consumer.accept(executionContext2);
            }
        });
    }

    public <T> T validate(ExecutionContext executionContext, JsonNode jsonNode, OutputFormat<T> outputFormat, ExecutionContextCustomizer executionContextCustomizer) {
        outputFormat.customize(executionContext, this.schemaContext);
        if (executionContextCustomizer != null) {
            executionContextCustomizer.customize(executionContext, this.schemaContext);
        }
        try {
            validate(executionContext, jsonNode);
        } catch (FailFastAssertionException e10) {
            executionContext.setErrors(e10.getErrors());
        }
        return outputFormat.format(this, executionContext, this.schemaContext);
    }
}
