package com.networknt.schema;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.networknt.schema.Error;
import com.networknt.schema.i18n.MessageFormatter;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.CachingSupplier;
import com.networknt.schema.utils.Strings;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

@JsonIgnoreProperties({"messageSupplier", "schemaNode", "instanceNode", M5.c.CARD_STATE_VALID})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"keyword", "instanceLocation", "message", "evaluationPath", "schemaLocation", "messageKey", "arguments", "details"})
/* loaded from: classes2.dex */
public class Error {
    private final Object[] arguments;
    private final Map<String, Object> details;

    @JsonSerialize(using = ToStringSerializer.class)
    private final NodePath evaluationPath;

    @JsonSerialize(using = ToStringSerializer.class)
    private final NodePath instanceLocation;
    private final JsonNode instanceNode;
    private final String keyword;
    private final String messageKey;
    private final Supplier<String> messageSupplier;

    @JsonSerialize(using = ToStringSerializer.class)
    private final SchemaLocation schemaLocation;
    private final JsonNode schemaNode;

    public static class Builder extends BuilderSupport<Builder> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.networknt.schema.Error.BuilderSupport
        public Builder self() {
            return this;
        }
    }

    public static abstract class BuilderSupport<S> {
        protected Object[] arguments;
        protected Map<String, Object> details;
        protected NodePath evaluationPath;
        protected MessageFormat format;
        protected NodePath instanceLocation;
        protected JsonNode instanceNode;
        protected String keyword;
        protected String message;
        protected MessageFormatter messageFormatter;
        protected String messageKey;
        protected Supplier<String> messageSupplier;
        protected SchemaLocation schemaLocation;
        protected JsonNode schemaNode;

        public static /* synthetic */ String a(BuilderSupport builderSupport) {
            builderSupport.getClass();
            return new MessageFormat(builderSupport.message).format(builderSupport.getMessageArguments());
        }

        public static /* synthetic */ String b(BuilderSupport builderSupport) {
            MessageFormatter messageFormatter = builderSupport.messageFormatter;
            if (messageFormatter == null) {
                final MessageFormat messageFormat = builderSupport.format;
                Objects.requireNonNull(messageFormat);
                messageFormatter = new MessageFormatter() { // from class: com.networknt.schema.d
                    @Override // com.networknt.schema.i18n.MessageFormatter
                    public final String format(Object[] objArr) {
                        return messageFormat.format(objArr);
                    }
                };
            }
            return messageFormatter.format(builderSupport.getMessageArguments());
        }

        public S arguments(Object... objArr) {
            this.arguments = objArr;
            return self();
        }

        public Error build() {
            Supplier bVar;
            String str;
            Supplier cachingSupplier = this.messageSupplier;
            String str2 = this.messageKey;
            if (!Strings.isBlank(this.message)) {
                str2 = this.message;
                if (!str2.contains(Const.STR_MART_JSON_BEGIN)) {
                    String str3 = this.message;
                    Objects.requireNonNull(str3);
                    str = str2;
                    bVar = new b(str3);
                    return new Error(this.keyword, this.evaluationPath, this.schemaLocation, this.instanceLocation, this.arguments, this.details, str, bVar, this.instanceNode, this.schemaNode);
                }
                cachingSupplier = new CachingSupplier(new Supplier() { // from class: com.networknt.schema.a
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Error.BuilderSupport.a(this.f21961a);
                    }
                });
            } else if (cachingSupplier == null) {
                cachingSupplier = new CachingSupplier(new Supplier() { // from class: com.networknt.schema.c
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Error.BuilderSupport.b(this.f21963a);
                    }
                });
            }
            bVar = cachingSupplier;
            str = str2;
            return new Error(this.keyword, this.evaluationPath, this.schemaLocation, this.instanceLocation, this.arguments, this.details, str, bVar, this.instanceNode, this.schemaNode);
        }

        public S details(Map<String, Object> map) {
            this.details = map;
            return self();
        }

        public S evaluationPath(NodePath nodePath) {
            this.evaluationPath = nodePath;
            return self();
        }

        public S format(MessageFormat messageFormat) {
            this.format = messageFormat;
            return self();
        }

        public Object[] getArguments() {
            return this.arguments;
        }

        public Map<String, Object> getDetails() {
            return this.details;
        }

        public NodePath getEvaluationPath() {
            return this.evaluationPath;
        }

        public MessageFormat getFormat() {
            return this.format;
        }

        public NodePath getInstanceLocation() {
            return this.instanceLocation;
        }

        public String getKeyword() {
            return this.keyword;
        }

        public String getMessage() {
            return this.message;
        }

        public Object[] getMessageArguments() {
            return this.arguments;
        }

        public MessageFormatter getMessageFormatter() {
            return this.messageFormatter;
        }

        public String getMessageKey() {
            return this.messageKey;
        }

        public Supplier<String> getMessageSupplier() {
            return this.messageSupplier;
        }

        public SchemaLocation getSchemaLocation() {
            return this.schemaLocation;
        }

        public S index(Integer num) {
            if (this.details == null) {
                this.details = new HashMap();
            }
            this.details.put("index", num);
            return self();
        }

        public S instanceLocation(NodePath nodePath) {
            this.instanceLocation = nodePath;
            return self();
        }

        public S instanceNode(JsonNode jsonNode) {
            this.instanceNode = jsonNode;
            return self();
        }

        public S keyword(String str) {
            this.keyword = str;
            return self();
        }

        public S message(String str) {
            this.message = str;
            return self();
        }

        public S messageFormatter(MessageFormatter messageFormatter) {
            this.messageFormatter = messageFormatter;
            return self();
        }

        public S messageKey(String str) {
            this.messageKey = str;
            return self();
        }

        public S messageSupplier(Supplier<String> supplier) {
            this.messageSupplier = supplier;
            return self();
        }

        public S property(String str) {
            if (this.details == null) {
                this.details = new HashMap();
            }
            this.details.put("property", str);
            return self();
        }

        public S schemaLocation(SchemaLocation schemaLocation) {
            this.schemaLocation = schemaLocation;
            return self();
        }

        public S schemaNode(JsonNode jsonNode) {
            this.schemaNode = jsonNode;
            return self();
        }

        public abstract S self();
    }

    public Error(String str, NodePath nodePath, SchemaLocation schemaLocation, NodePath nodePath2, Object[] objArr, Map<String, Object> map, String str2, Supplier<String> supplier, JsonNode jsonNode, JsonNode jsonNode2) {
        this.keyword = str;
        this.instanceLocation = nodePath2;
        this.schemaLocation = schemaLocation;
        this.evaluationPath = nodePath;
        this.arguments = objArr;
        this.details = map;
        this.messageKey = str2;
        this.messageSupplier = supplier;
        this.instanceNode = jsonNode;
        this.schemaNode = jsonNode2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Error error = (Error) obj;
        String str = this.keyword;
        if (str == null ? error.keyword != null : !str.equals(error.keyword)) {
            return false;
        }
        NodePath nodePath = this.instanceLocation;
        if (nodePath == null ? error.instanceLocation != null : !nodePath.equals(error.instanceLocation)) {
            return false;
        }
        NodePath nodePath2 = this.evaluationPath;
        if (nodePath2 == null ? error.evaluationPath != null : !nodePath2.equals(error.evaluationPath)) {
            return false;
        }
        Map<String, Object> map = this.details;
        if (map == null ? error.details != null : !map.equals(error.details)) {
            return false;
        }
        String str2 = this.messageKey;
        if (str2 == null ? error.messageKey == null : str2.equals(error.messageKey)) {
            return Arrays.equals(this.arguments, error.arguments);
        }
        return false;
    }

    public Object[] getArguments() {
        return this.arguments;
    }

    public Map<String, Object> getDetails() {
        return this.details;
    }

    public NodePath getEvaluationPath() {
        return this.evaluationPath;
    }

    public Integer getIndex() {
        if (this.details == null) {
            return null;
        }
        return (Integer) getDetails().get("index");
    }

    public NodePath getInstanceLocation() {
        return this.instanceLocation;
    }

    public JsonNode getInstanceNode() {
        return this.instanceNode;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getMessage() {
        return this.messageSupplier.get();
    }

    public String getMessageKey() {
        return this.messageKey;
    }

    public String getProperty() {
        if (this.details == null) {
            return null;
        }
        return (String) getDetails().get("property");
    }

    public SchemaLocation getSchemaLocation() {
        return this.schemaLocation;
    }

    public JsonNode getSchemaNode() {
        return this.schemaNode;
    }

    public int hashCode() {
        String str = this.keyword;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        NodePath nodePath = this.instanceLocation;
        int iHashCode2 = (iHashCode + (nodePath != null ? nodePath.hashCode() : 0)) * 31;
        NodePath nodePath2 = this.evaluationPath;
        int iHashCode3 = (iHashCode2 + (nodePath2 != null ? nodePath2.hashCode() : 0)) * 31;
        Map<String, Object> map = this.details;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Object[] objArr = this.arguments;
        int iHashCode5 = (iHashCode4 + (objArr != null ? Arrays.hashCode(objArr) : 0)) * 31;
        String str2 = this.messageKey;
        return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean isValid() {
        return this.messageSupplier != null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        NodePath nodePath = this.instanceLocation;
        if (nodePath != null) {
            sb2.append(nodePath.toString());
        } else {
            SchemaLocation schemaLocation = this.schemaLocation;
            if (schemaLocation != null) {
                sb2.append(schemaLocation.toString());
            }
        }
        sb2.append(": ");
        sb2.append(this.messageSupplier.get());
        return sb2.toString();
    }
}
