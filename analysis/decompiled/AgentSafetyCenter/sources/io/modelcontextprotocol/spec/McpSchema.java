package io.modelcontextprotocol.spec;

import b8.g0;
import b8.u0;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.util.Assert;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class McpSchema {
    public static final String JSONRPC_VERSION = "2.0";

    @Deprecated
    public static final String LATEST_PROTOCOL_VERSION = "2025-06-18";
    public static final String METHOD_COMPLETION_COMPLETE = "completion/complete";
    public static final String METHOD_ELICITATION_CREATE = "elicitation/create";
    public static final String METHOD_INITIALIZE = "initialize";
    public static final String METHOD_LOGGING_SET_LEVEL = "logging/setLevel";
    public static final String METHOD_NOTIFICATION_INITIALIZED = "notifications/initialized";
    public static final String METHOD_NOTIFICATION_MESSAGE = "notifications/message";
    public static final String METHOD_NOTIFICATION_PROGRESS = "notifications/progress";
    public static final String METHOD_NOTIFICATION_PROMPTS_LIST_CHANGED = "notifications/prompts/list_changed";
    public static final String METHOD_NOTIFICATION_RESOURCES_LIST_CHANGED = "notifications/resources/list_changed";
    public static final String METHOD_NOTIFICATION_RESOURCES_UPDATED = "notifications/resources/updated";
    public static final String METHOD_NOTIFICATION_ROOTS_LIST_CHANGED = "notifications/roots/list_changed";
    public static final String METHOD_NOTIFICATION_TOOLS_LIST_CHANGED = "notifications/tools/list_changed";
    public static final String METHOD_PING = "ping";
    public static final String METHOD_PROMPT_GET = "prompts/get";
    public static final String METHOD_PROMPT_LIST = "prompts/list";
    public static final String METHOD_RESOURCES_LIST = "resources/list";
    public static final String METHOD_RESOURCES_READ = "resources/read";
    public static final String METHOD_RESOURCES_SUBSCRIBE = "resources/subscribe";
    public static final String METHOD_RESOURCES_TEMPLATES_LIST = "resources/templates/list";
    public static final String METHOD_RESOURCES_UNSUBSCRIBE = "resources/unsubscribe";
    public static final String METHOD_ROOTS_LIST = "roots/list";
    public static final String METHOD_SAMPLING_CREATE_MESSAGE = "sampling/createMessage";
    public static final String METHOD_TOOLS_CALL = "tools/call";
    public static final String METHOD_TOOLS_LIST = "tools/list";
    private static final rd.b logger = rd.d.b(McpSchema.class);
    public static final String FIRST_PAGE = null;
    private static final TypeRef<HashMap<String, Object>> MAP_TYPE_REF = new TypeRef<HashMap<String, Object>>() { // from class: io.modelcontextprotocol.spec.McpSchema.1
    };

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface Annotated {
        Annotations annotations();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ClientCapabilities extends androidx.activity.b {

        @JsonProperty("elicitation")
        private final Elicitation elicitation;

        @JsonProperty("experimental")
        private final Map<String, Object> experimental;

        @JsonProperty("roots")
        private final RootCapabilities roots;

        @JsonProperty("sampling")
        private final Sampling sampling;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private Elicitation elicitation;
            private Map<String, Object> experimental;
            private RootCapabilities roots;
            private Sampling sampling;

            public ClientCapabilities build() {
                return new ClientCapabilities(this.experimental, this.roots, this.sampling, this.elicitation);
            }

            public Builder elicitation() {
                this.elicitation = new Elicitation();
                return this;
            }

            public Builder experimental(Map<String, Object> map) {
                this.experimental = map;
                return this;
            }

            public Builder roots(Boolean bool) {
                this.roots = new RootCapabilities(bool);
                return this;
            }

            public Builder sampling() {
                this.sampling = new Sampling();
                return this;
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        public static final class Elicitation extends androidx.activity.b {
            public final boolean equals(Object obj) {
                return obj instanceof Elicitation;
            }

            public final int hashCode() {
                return 0;
            }

            public final String toString() {
                Object[] objArr = new Object[0];
                String[] strArrSplit = "".length() == 0 ? new String[0] : "".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, Elicitation.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        public static final class RootCapabilities extends androidx.activity.b {

            @JsonProperty("listChanged")
            private final Boolean listChanged;

            public RootCapabilities(@JsonProperty("listChanged") Boolean bool) {
                this.listChanged = bool;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof RootCapabilities) && Objects.equals(this.listChanged, ((RootCapabilities) obj).listChanged);
            }

            public final int hashCode() {
                return Objects.hashCode(this.listChanged);
            }

            @JsonProperty("listChanged")
            public Boolean listChanged() {
                return this.listChanged;
            }

            public final String toString() {
                Object[] objArr = {this.listChanged};
                String[] strArrSplit = "listChanged".length() == 0 ? new String[0] : "listChanged".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, RootCapabilities.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        public static final class Sampling extends androidx.activity.b {
            public final boolean equals(Object obj) {
                return obj instanceof Sampling;
            }

            public final int hashCode() {
                return 0;
            }

            public final String toString() {
                Object[] objArr = new Object[0];
                String[] strArrSplit = "".length() == 0 ? new String[0] : "".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, Sampling.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }
        }

        public ClientCapabilities(@JsonProperty("experimental") Map<String, Object> map, @JsonProperty("roots") RootCapabilities rootCapabilities, @JsonProperty("sampling") Sampling sampling, @JsonProperty("elicitation") Elicitation elicitation) {
            this.experimental = map;
            this.roots = rootCapabilities;
            this.sampling = sampling;
            this.elicitation = elicitation;
        }

        public static Builder builder() {
            return new Builder();
        }

        @JsonProperty("elicitation")
        public Elicitation elicitation() {
            return this.elicitation;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ClientCapabilities)) {
                return false;
            }
            ClientCapabilities clientCapabilities = (ClientCapabilities) obj;
            return Objects.equals(this.experimental, clientCapabilities.experimental) && Objects.equals(this.roots, clientCapabilities.roots) && Objects.equals(this.sampling, clientCapabilities.sampling) && Objects.equals(this.elicitation, clientCapabilities.elicitation);
        }

        @JsonProperty("experimental")
        public Map<String, Object> experimental() {
            return this.experimental;
        }

        public final int hashCode() {
            Map<String, Object> map = this.experimental;
            RootCapabilities rootCapabilities = this.roots;
            Sampling sampling = this.sampling;
            Elicitation elicitation = this.elicitation;
            return Objects.hashCode(elicitation) + ((Objects.hashCode(sampling) + ((Objects.hashCode(rootCapabilities) + (Objects.hashCode(map) * 31)) * 31)) * 31);
        }

        @JsonProperty("roots")
        public RootCapabilities roots() {
            return this.roots;
        }

        @JsonProperty("sampling")
        public Sampling sampling() {
            return this.sampling;
        }

        public final String toString() {
            Object[] objArr = {this.experimental, this.roots, this.sampling, this.elicitation};
            String[] strArrSplit = "experimental;roots;sampling;elicitation".length() == 0 ? new String[0] : "experimental;roots;sampling;elicitation".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ClientCapabilities.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface CompleteReference {
        String identifier();

        String type();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonSubTypes({@JsonSubTypes.Type(name = "text", value = TextContent.class), @JsonSubTypes.Type(name = "image", value = ImageContent.class), @JsonSubTypes.Type(name = "audio", value = AudioContent.class), @JsonSubTypes.Type(name = "resource", value = EmbeddedResource.class), @JsonSubTypes.Type(name = "resource_link", value = ResourceLink.class)})
    @JsonTypeInfo(include = JsonTypeInfo.As.PROPERTY, property = "type", use = JsonTypeInfo.Id.NAME)
    public interface Content extends Meta {
        default String type() {
            if (this instanceof TextContent) {
                return "text";
            }
            if (this instanceof ImageContent) {
                return "image";
            }
            if (this instanceof AudioContent) {
                return "audio";
            }
            if (this instanceof EmbeddedResource) {
                return "resource";
            }
            if (this instanceof ResourceLink) {
                return "resource_link";
            }
            g5.f.s("Unknown content type: ".concat(String.valueOf(this)));
            return null;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ErrorCodes {
        public static final int INTERNAL_ERROR = -32603;
        public static final int INVALID_PARAMS = -32602;
        public static final int INVALID_REQUEST = -32600;
        public static final int METHOD_NOT_FOUND = -32601;
        public static final int PARSE_ERROR = -32700;
        public static final int RESOURCE_NOT_FOUND = -32002;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface Identifier {
        String name();

        String title();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface JSONRPCMessage {
        String jsonrpc();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class JSONRPCNotification extends androidx.activity.b implements JSONRPCMessage {

        @JsonProperty("jsonrpc")
        private final String jsonrpc;

        @JsonProperty("method")
        private final String method;

        @JsonProperty("params")
        private final Object params;

        public JSONRPCNotification(@JsonProperty("jsonrpc") String str, @JsonProperty("method") String str2, @JsonProperty("params") Object obj) {
            this.jsonrpc = str;
            this.method = str2;
            this.params = obj;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof JSONRPCNotification)) {
                return false;
            }
            JSONRPCNotification jSONRPCNotification = (JSONRPCNotification) obj;
            return Objects.equals(this.jsonrpc, jSONRPCNotification.jsonrpc) && Objects.equals(this.method, jSONRPCNotification.method) && Objects.equals(this.params, jSONRPCNotification.params);
        }

        public final int hashCode() {
            String str = this.jsonrpc;
            String str2 = this.method;
            Object obj = this.params;
            return Objects.hashCode(obj) + androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.JSONRPCMessage
        @JsonProperty("jsonrpc")
        public String jsonrpc() {
            return this.jsonrpc;
        }

        @JsonProperty("method")
        public String method() {
            return this.method;
        }

        @JsonProperty("params")
        public Object params() {
            return this.params;
        }

        public final String toString() {
            Object[] objArr = {this.jsonrpc, this.method, this.params};
            String[] strArrSplit = "jsonrpc;method;params".length() == 0 ? new String[0] : "jsonrpc;method;params".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, JSONRPCNotification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class JSONRPCRequest extends androidx.activity.b implements JSONRPCMessage {

        /* renamed from: id, reason: collision with root package name */
        @JsonProperty("id")
        private final Object f6341id;

        @JsonProperty("jsonrpc")
        private final String jsonrpc;

        @JsonProperty("method")
        private final String method;

        @JsonProperty("params")
        private final Object params;

        public JSONRPCRequest(@JsonProperty("jsonrpc") String str, @JsonProperty("method") String str2, @JsonProperty("id") Object obj, @JsonProperty("params") Object obj2) {
            Assert.notNull(obj, "MCP requests MUST include an ID - null IDs are not allowed");
            Assert.isTrue((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long), "MCP requests MUST have an ID that is either a string or integer");
            this.jsonrpc = str;
            this.method = str2;
            this.f6341id = obj;
            this.params = obj2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof JSONRPCRequest)) {
                return false;
            }
            JSONRPCRequest jSONRPCRequest = (JSONRPCRequest) obj;
            return Objects.equals(this.jsonrpc, jSONRPCRequest.jsonrpc) && Objects.equals(this.method, jSONRPCRequest.method) && Objects.equals(this.f6341id, jSONRPCRequest.f6341id) && Objects.equals(this.params, jSONRPCRequest.params);
        }

        public final int hashCode() {
            String str = this.jsonrpc;
            String str2 = this.method;
            Object obj = this.f6341id;
            Object obj2 = this.params;
            return Objects.hashCode(obj2) + ((Objects.hashCode(obj) + androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2)) * 31);
        }

        @JsonProperty("id")
        public Object id() {
            return this.f6341id;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.JSONRPCMessage
        @JsonProperty("jsonrpc")
        public String jsonrpc() {
            return this.jsonrpc;
        }

        @JsonProperty("method")
        public String method() {
            return this.method;
        }

        @JsonProperty("params")
        public Object params() {
            return this.params;
        }

        public final String toString() {
            Object[] objArr = {this.jsonrpc, this.method, this.f6341id, this.params};
            String[] strArrSplit = "jsonrpc;method;id;params".length() == 0 ? new String[0] : "jsonrpc;method;id;params".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, JSONRPCRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class JSONRPCResponse extends androidx.activity.b implements JSONRPCMessage {

        @JsonProperty("error")
        private final JSONRPCError error;

        /* renamed from: id, reason: collision with root package name */
        @JsonProperty("id")
        private final Object f6342id;

        @JsonProperty("jsonrpc")
        private final String jsonrpc;

        @JsonProperty("result")
        private final Object result;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        public static final class JSONRPCError extends androidx.activity.b {

            @JsonProperty("code")
            private final Integer code;

            @JsonProperty("data")
            private final Object data;

            @JsonProperty("message")
            private final String message;

            public JSONRPCError(@JsonProperty("code") Integer num, @JsonProperty("message") String str, @JsonProperty("data") Object obj) {
                this.code = num;
                this.message = str;
                this.data = obj;
            }

            @JsonProperty("code")
            public Integer code() {
                return this.code;
            }

            @JsonProperty("data")
            public Object data() {
                return this.data;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof JSONRPCError)) {
                    return false;
                }
                JSONRPCError jSONRPCError = (JSONRPCError) obj;
                return Objects.equals(this.code, jSONRPCError.code) && Objects.equals(this.message, jSONRPCError.message) && Objects.equals(this.data, jSONRPCError.data);
            }

            public final int hashCode() {
                Integer num = this.code;
                String str = this.message;
                Object obj = this.data;
                return Objects.hashCode(obj) + androidx.activity.b.w(Objects.hashCode(num) * 31, 31, str);
            }

            @JsonProperty("message")
            public String message() {
                return this.message;
            }

            public final String toString() {
                Object[] objArr = {this.code, this.message, this.data};
                String[] strArrSplit = "code;message;data".length() == 0 ? new String[0] : "code;message;data".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, JSONRPCError.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }
        }

        public JSONRPCResponse(@JsonProperty("jsonrpc") String str, @JsonProperty("id") Object obj, @JsonProperty("result") Object obj2, @JsonProperty("error") JSONRPCError jSONRPCError) {
            this.jsonrpc = str;
            this.f6342id = obj;
            this.result = obj2;
            this.error = jSONRPCError;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof JSONRPCResponse)) {
                return false;
            }
            JSONRPCResponse jSONRPCResponse = (JSONRPCResponse) obj;
            return Objects.equals(this.jsonrpc, jSONRPCResponse.jsonrpc) && Objects.equals(this.f6342id, jSONRPCResponse.f6342id) && Objects.equals(this.result, jSONRPCResponse.result) && Objects.equals(this.error, jSONRPCResponse.error);
        }

        @JsonProperty("error")
        public JSONRPCError error() {
            return this.error;
        }

        public final int hashCode() {
            String str = this.jsonrpc;
            Object obj = this.f6342id;
            Object obj2 = this.result;
            JSONRPCError jSONRPCError = this.error;
            return Objects.hashCode(jSONRPCError) + ((Objects.hashCode(obj2) + ((Objects.hashCode(obj) + (Objects.hashCode(str) * 31)) * 31)) * 31);
        }

        @JsonProperty("id")
        public Object id() {
            return this.f6342id;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.JSONRPCMessage
        @JsonProperty("jsonrpc")
        public String jsonrpc() {
            return this.jsonrpc;
        }

        @JsonProperty("result")
        public Object result() {
            return this.result;
        }

        public final String toString() {
            Object[] objArr = {this.jsonrpc, this.f6342id, this.result, this.error};
            String[] strArrSplit = "jsonrpc;id;result;error".length() == 0 ? new String[0] : "jsonrpc;id;result;error".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, JSONRPCResponse.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class JsonSchema extends androidx.activity.b {

        @JsonProperty("additionalProperties")
        private final Boolean additionalProperties;

        @JsonProperty("definitions")
        private final Map<String, Object> definitions;

        @JsonProperty("$defs")
        private final Map<String, Object> defs;

        @JsonProperty("properties")
        private final Map<String, Object> properties;

        @JsonProperty("required")
        private final List<String> required;

        @JsonProperty("type")
        private final String type;

        public JsonSchema(@JsonProperty("type") String str, @JsonProperty("properties") Map<String, Object> map, @JsonProperty("required") List<String> list, @JsonProperty("additionalProperties") Boolean bool, @JsonProperty("$defs") Map<String, Object> map2, @JsonProperty("definitions") Map<String, Object> map3) {
            this.type = str;
            this.properties = map;
            this.required = list;
            this.additionalProperties = bool;
            this.defs = map2;
            this.definitions = map3;
        }

        @JsonProperty("additionalProperties")
        public Boolean additionalProperties() {
            return this.additionalProperties;
        }

        @JsonProperty("definitions")
        public Map<String, Object> definitions() {
            return this.definitions;
        }

        @JsonProperty("$defs")
        public Map<String, Object> defs() {
            return this.defs;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof JsonSchema)) {
                return false;
            }
            JsonSchema jsonSchema = (JsonSchema) obj;
            return Objects.equals(this.type, jsonSchema.type) && Objects.equals(this.properties, jsonSchema.properties) && Objects.equals(this.required, jsonSchema.required) && Objects.equals(this.additionalProperties, jsonSchema.additionalProperties) && Objects.equals(this.defs, jsonSchema.defs) && Objects.equals(this.definitions, jsonSchema.definitions);
        }

        public final int hashCode() {
            String str = this.type;
            Map<String, Object> map = this.properties;
            List<String> list = this.required;
            Boolean bool = this.additionalProperties;
            Map<String, Object> map2 = this.defs;
            Map<String, Object> map3 = this.definitions;
            return Objects.hashCode(map3) + androidx.activity.b.f(map2, (Objects.hashCode(bool) + androidx.activity.b.x(list, androidx.activity.b.f(map, Objects.hashCode(str) * 31, 31), 31)) * 31, 31);
        }

        @JsonProperty("properties")
        public Map<String, Object> properties() {
            return this.properties;
        }

        @JsonProperty("required")
        public List<String> required() {
            return this.required;
        }

        public final String toString() {
            Object[] objArr = {this.type, this.properties, this.required, this.additionalProperties, this.defs, this.definitions};
            String[] strArrSplit = "type;properties;required;additionalProperties;defs;definitions".length() == 0 ? new String[0] : "type;properties;required;additionalProperties;defs;definitions".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, JsonSchema.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @JsonProperty("type")
        public String type() {
            return this.type;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum LoggingLevel {
        DEBUG(0),
        INFO(1),
        NOTICE(2),
        WARNING(3),
        ERROR(4),
        CRITICAL(5),
        ALERT(6),
        EMERGENCY(7);

        private final int level;

        LoggingLevel(int i) {
            this.level = i;
        }

        public int level() {
            return this.level;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface Meta {
        Map<String, Object> meta();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ModelHint extends androidx.activity.b {

        @JsonProperty("name")
        private final String name;

        public ModelHint(@JsonProperty("name") String str) {
            this.name = str;
        }

        public static ModelHint of(String str) {
            return new ModelHint(str);
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ModelHint) && Objects.equals(this.name, ((ModelHint) obj).name);
        }

        public final int hashCode() {
            return Objects.hashCode(this.name);
        }

        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        public final String toString() {
            Object[] objArr = {this.name};
            String[] strArrSplit = "name".length() == 0 ? new String[0] : "name".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ModelHint.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ModelPreferences extends androidx.activity.b {

        @JsonProperty("costPriority")
        private final Double costPriority;

        @JsonProperty("hints")
        private final List<ModelHint> hints;

        @JsonProperty("intelligencePriority")
        private final Double intelligencePriority;

        @JsonProperty("speedPriority")
        private final Double speedPriority;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private Double costPriority;
            private List<ModelHint> hints;
            private Double intelligencePriority;
            private Double speedPriority;

            public Builder addHint(String str) {
                if (this.hints == null) {
                    this.hints = new ArrayList();
                }
                this.hints.add(new ModelHint(str));
                return this;
            }

            public ModelPreferences build() {
                return new ModelPreferences(this.hints, this.costPriority, this.speedPriority, this.intelligencePriority);
            }

            public Builder costPriority(Double d7) {
                this.costPriority = d7;
                return this;
            }

            public Builder hints(List<ModelHint> list) {
                this.hints = list;
                return this;
            }

            public Builder intelligencePriority(Double d7) {
                this.intelligencePriority = d7;
                return this;
            }

            public Builder speedPriority(Double d7) {
                this.speedPriority = d7;
                return this;
            }
        }

        public ModelPreferences(@JsonProperty("hints") List<ModelHint> list, @JsonProperty("costPriority") Double d7, @JsonProperty("speedPriority") Double d10, @JsonProperty("intelligencePriority") Double d11) {
            this.hints = list;
            this.costPriority = d7;
            this.speedPriority = d10;
            this.intelligencePriority = d11;
        }

        public static Builder builder() {
            return new Builder();
        }

        @JsonProperty("costPriority")
        public Double costPriority() {
            return this.costPriority;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ModelPreferences)) {
                return false;
            }
            ModelPreferences modelPreferences = (ModelPreferences) obj;
            return Objects.equals(this.hints, modelPreferences.hints) && Objects.equals(this.costPriority, modelPreferences.costPriority) && Objects.equals(this.speedPriority, modelPreferences.speedPriority) && Objects.equals(this.intelligencePriority, modelPreferences.intelligencePriority);
        }

        public final int hashCode() {
            List<ModelHint> list = this.hints;
            Double d7 = this.costPriority;
            Double d10 = this.speedPriority;
            Double d11 = this.intelligencePriority;
            return Objects.hashCode(d11) + ((Objects.hashCode(d10) + ((Objects.hashCode(d7) + (Objects.hashCode(list) * 31)) * 31)) * 31);
        }

        @JsonProperty("hints")
        public List<ModelHint> hints() {
            return this.hints;
        }

        @JsonProperty("intelligencePriority")
        public Double intelligencePriority() {
            return this.intelligencePriority;
        }

        @JsonProperty("speedPriority")
        public Double speedPriority() {
            return this.speedPriority;
        }

        public final String toString() {
            Object[] objArr = {this.hints, this.costPriority, this.speedPriority, this.intelligencePriority};
            String[] strArrSplit = "hints;costPriority;speedPriority;intelligencePriority".length() == 0 ? new String[0] : "hints;costPriority;speedPriority;intelligencePriority".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ModelPreferences.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface Notification extends Meta {
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class PaginatedResult extends androidx.activity.b {

        @JsonProperty("nextCursor")
        private final String nextCursor;

        public PaginatedResult(@JsonProperty("nextCursor") String str) {
            this.nextCursor = str;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof PaginatedResult) && Objects.equals(this.nextCursor, ((PaginatedResult) obj).nextCursor);
        }

        public final int hashCode() {
            return Objects.hashCode(this.nextCursor);
        }

        @JsonProperty("nextCursor")
        public String nextCursor() {
            return this.nextCursor;
        }

        public final String toString() {
            Object[] objArr = {this.nextCursor};
            String[] strArrSplit = "nextCursor".length() == 0 ? new String[0] : "nextCursor".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, PaginatedResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class PromptMessage extends androidx.activity.b {

        @JsonProperty("content")
        private final Content content;

        @JsonProperty("role")
        private final Role role;

        public PromptMessage(@JsonProperty("role") Role role, @JsonProperty("content") Content content) {
            this.role = role;
            this.content = content;
        }

        @JsonProperty("content")
        public Content content() {
            return this.content;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof PromptMessage)) {
                return false;
            }
            PromptMessage promptMessage = (PromptMessage) obj;
            return Objects.equals(this.role, promptMessage.role) && Objects.equals(this.content, promptMessage.content);
        }

        public final int hashCode() {
            Role role = this.role;
            Content content = this.content;
            return Objects.hashCode(content) + (Objects.hashCode(role) * 31);
        }

        @JsonProperty("role")
        public Role role() {
            return this.role;
        }

        public final String toString() {
            Object[] objArr = {this.role, this.content};
            String[] strArrSplit = "role;content".length() == 0 ? new String[0] : "role;content".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, PromptMessage.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface Request extends Meta {
        default Object progressToken() {
            if (meta() == null || !meta().containsKey("progressToken")) {
                return null;
            }
            return meta().get("progressToken");
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface ResourceContent extends Identifier, Annotated, Meta {
        String description();

        String mimeType();

        Long size();

        String uri();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonSubTypes({@JsonSubTypes.Type(TextResourceContents.class), @JsonSubTypes.Type(BlobResourceContents.class)})
    @JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
    public interface ResourceContents extends Meta {
        String mimeType();

        String uri();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ResourceLink extends androidx.activity.b implements Content, ResourceContent {

        @JsonProperty("annotations")
        private final Annotations annotations;

        @JsonProperty("description")
        private final String description;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("mimeType")
        private final String mimeType;

        @JsonProperty("name")
        private final String name;

        @JsonProperty("size")
        private final Long size;

        @JsonProperty("title")
        private final String title;

        @JsonProperty("uri")
        private final String uri;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private Annotations annotations;
            private String description;
            private Map<String, Object> meta;
            private String mimeType;
            private String name;
            private Long size;
            private String title;
            private String uri;

            public Builder annotations(Annotations annotations) {
                this.annotations = annotations;
                return this;
            }

            public ResourceLink build() {
                Assert.hasText(this.uri, "uri must not be empty");
                Assert.hasText(this.name, "name must not be empty");
                return new ResourceLink(this.name, this.title, this.uri, this.description, this.mimeType, this.size, this.annotations, this.meta);
            }

            public Builder description(String str) {
                this.description = str;
                return this;
            }

            public Builder meta(Map<String, Object> map) {
                this.meta = map;
                return this;
            }

            public Builder mimeType(String str) {
                this.mimeType = str;
                return this;
            }

            public Builder name(String str) {
                this.name = str;
                return this;
            }

            public Builder size(Long l2) {
                this.size = l2;
                return this;
            }

            public Builder title(String str) {
                this.title = str;
                return this;
            }

            public Builder uri(String str) {
                this.uri = str;
                return this;
            }
        }

        public ResourceLink(@JsonProperty("name") String str, @JsonProperty("title") String str2, @JsonProperty("uri") String str3, @JsonProperty("description") String str4, @JsonProperty("mimeType") String str5, @JsonProperty("size") Long l2, @JsonProperty("annotations") Annotations annotations, @JsonProperty("_meta") Map<String, Object> map) {
            this.name = str;
            this.title = str2;
            this.uri = str3;
            this.description = str4;
            this.mimeType = str5;
            this.size = l2;
            this.annotations = annotations;
            this.meta = map;
        }

        public static Builder builder() {
            return new Builder();
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Annotated
        @JsonProperty("annotations")
        public Annotations annotations() {
            return this.annotations;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContent
        @JsonProperty("description")
        public String description() {
            return this.description;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ResourceLink)) {
                return false;
            }
            ResourceLink resourceLink = (ResourceLink) obj;
            return Objects.equals(this.name, resourceLink.name) && Objects.equals(this.title, resourceLink.title) && Objects.equals(this.uri, resourceLink.uri) && Objects.equals(this.description, resourceLink.description) && Objects.equals(this.mimeType, resourceLink.mimeType) && Objects.equals(this.size, resourceLink.size) && Objects.equals(this.annotations, resourceLink.annotations) && Objects.equals(this.meta, resourceLink.meta);
        }

        public final int hashCode() {
            String str = this.name;
            String str2 = this.title;
            String str3 = this.uri;
            String str4 = this.description;
            String str5 = this.mimeType;
            Long l2 = this.size;
            Annotations annotations = this.annotations;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + ((Objects.hashCode(annotations) + ((Objects.hashCode(l2) + androidx.activity.b.w(androidx.activity.b.w(androidx.activity.b.w(androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2), 31, str3), 31, str4), 31, str5)) * 31)) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContent
        @JsonProperty("mimeType")
        public String mimeType() {
            return this.mimeType;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContent
        @JsonProperty("size")
        public Long size() {
            return this.size;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("title")
        public String title() {
            return this.title;
        }

        public final String toString() {
            Object[] objArr = {this.name, this.title, this.uri, this.description, this.mimeType, this.size, this.annotations, this.meta};
            String[] strArrSplit = "name;title;uri;description;mimeType;size;annotations;meta".length() == 0 ? new String[0] : "name;title;uri;description;mimeType;size;annotations;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ResourceLink.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContent
        @JsonProperty("uri")
        public String uri() {
            return this.uri;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface Result extends Meta {
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum Role {
        USER,
        ASSISTANT
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class SamplingMessage extends androidx.activity.b {

        @JsonProperty("content")
        private final Content content;

        @JsonProperty("role")
        private final Role role;

        public SamplingMessage(@JsonProperty("role") Role role, @JsonProperty("content") Content content) {
            this.role = role;
            this.content = content;
        }

        @JsonProperty("content")
        public Content content() {
            return this.content;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SamplingMessage)) {
                return false;
            }
            SamplingMessage samplingMessage = (SamplingMessage) obj;
            return Objects.equals(this.role, samplingMessage.role) && Objects.equals(this.content, samplingMessage.content);
        }

        public final int hashCode() {
            Role role = this.role;
            Content content = this.content;
            return Objects.hashCode(content) + (Objects.hashCode(role) * 31);
        }

        @JsonProperty("role")
        public Role role() {
            return this.role;
        }

        public final String toString() {
            Object[] objArr = {this.role, this.content};
            String[] strArrSplit = "role;content".length() == 0 ? new String[0] : "role;content".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, SamplingMessage.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ServerCapabilities extends androidx.activity.b {

        @JsonProperty("completions")
        private final CompletionCapabilities completions;

        @JsonProperty("experimental")
        private final Map<String, Object> experimental;

        @JsonProperty("logging")
        private final LoggingCapabilities logging;

        @JsonProperty("prompts")
        private final PromptCapabilities prompts;

        @JsonProperty("resources")
        private final ResourceCapabilities resources;

        @JsonProperty("tools")
        private final ToolCapabilities tools;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private CompletionCapabilities completions;
            private Map<String, Object> experimental;
            private LoggingCapabilities logging;
            private PromptCapabilities prompts;
            private ResourceCapabilities resources;
            private ToolCapabilities tools;

            public ServerCapabilities build() {
                return new ServerCapabilities(this.completions, this.experimental, this.logging, this.prompts, this.resources, this.tools);
            }

            public Builder completions() {
                this.completions = new CompletionCapabilities();
                return this;
            }

            public Builder experimental(Map<String, Object> map) {
                this.experimental = map;
                return this;
            }

            public Builder logging() {
                this.logging = new LoggingCapabilities();
                return this;
            }

            public Builder prompts(Boolean bool) {
                this.prompts = new PromptCapabilities(bool);
                return this;
            }

            public Builder resources(Boolean bool, Boolean bool2) {
                this.resources = new ResourceCapabilities(bool, bool2);
                return this;
            }

            public Builder tools(Boolean bool) {
                this.tools = new ToolCapabilities(bool);
                return this;
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        public static final class CompletionCapabilities extends androidx.activity.b {
            public final boolean equals(Object obj) {
                return obj instanceof CompletionCapabilities;
            }

            public final int hashCode() {
                return 0;
            }

            public final String toString() {
                Object[] objArr = new Object[0];
                String[] strArrSplit = "".length() == 0 ? new String[0] : "".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, CompletionCapabilities.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        public static final class LoggingCapabilities extends androidx.activity.b {
            public final boolean equals(Object obj) {
                return obj instanceof LoggingCapabilities;
            }

            public final int hashCode() {
                return 0;
            }

            public final String toString() {
                Object[] objArr = new Object[0];
                String[] strArrSplit = "".length() == 0 ? new String[0] : "".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, LoggingCapabilities.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        public static final class PromptCapabilities extends androidx.activity.b {

            @JsonProperty("listChanged")
            private final Boolean listChanged;

            public PromptCapabilities(@JsonProperty("listChanged") Boolean bool) {
                this.listChanged = bool;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof PromptCapabilities) && Objects.equals(this.listChanged, ((PromptCapabilities) obj).listChanged);
            }

            public final int hashCode() {
                return Objects.hashCode(this.listChanged);
            }

            @JsonProperty("listChanged")
            public Boolean listChanged() {
                return this.listChanged;
            }

            public final String toString() {
                Object[] objArr = {this.listChanged};
                String[] strArrSplit = "listChanged".length() == 0 ? new String[0] : "listChanged".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, PromptCapabilities.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        public static final class ResourceCapabilities extends androidx.activity.b {

            @JsonProperty("listChanged")
            private final Boolean listChanged;

            @JsonProperty("subscribe")
            private final Boolean subscribe;

            public ResourceCapabilities(@JsonProperty("subscribe") Boolean bool, @JsonProperty("listChanged") Boolean bool2) {
                this.subscribe = bool;
                this.listChanged = bool2;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof ResourceCapabilities)) {
                    return false;
                }
                ResourceCapabilities resourceCapabilities = (ResourceCapabilities) obj;
                return Objects.equals(this.subscribe, resourceCapabilities.subscribe) && Objects.equals(this.listChanged, resourceCapabilities.listChanged);
            }

            public final int hashCode() {
                Boolean bool = this.subscribe;
                Boolean bool2 = this.listChanged;
                return Objects.hashCode(bool2) + (Objects.hashCode(bool) * 31);
            }

            @JsonProperty("listChanged")
            public Boolean listChanged() {
                return this.listChanged;
            }

            @JsonProperty("subscribe")
            public Boolean subscribe() {
                return this.subscribe;
            }

            public final String toString() {
                Object[] objArr = {this.subscribe, this.listChanged};
                String[] strArrSplit = "subscribe;listChanged".length() == 0 ? new String[0] : "subscribe;listChanged".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, ResourceCapabilities.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        public static final class ToolCapabilities extends androidx.activity.b {

            @JsonProperty("listChanged")
            private final Boolean listChanged;

            public ToolCapabilities(@JsonProperty("listChanged") Boolean bool) {
                this.listChanged = bool;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof ToolCapabilities) && Objects.equals(this.listChanged, ((ToolCapabilities) obj).listChanged);
            }

            public final int hashCode() {
                return Objects.hashCode(this.listChanged);
            }

            @JsonProperty("listChanged")
            public Boolean listChanged() {
                return this.listChanged;
            }

            public final String toString() {
                Object[] objArr = {this.listChanged};
                String[] strArrSplit = "listChanged".length() == 0 ? new String[0] : "listChanged".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, ToolCapabilities.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }
        }

        public ServerCapabilities(@JsonProperty("completions") CompletionCapabilities completionCapabilities, @JsonProperty("experimental") Map<String, Object> map, @JsonProperty("logging") LoggingCapabilities loggingCapabilities, @JsonProperty("prompts") PromptCapabilities promptCapabilities, @JsonProperty("resources") ResourceCapabilities resourceCapabilities, @JsonProperty("tools") ToolCapabilities toolCapabilities) {
            this.completions = completionCapabilities;
            this.experimental = map;
            this.logging = loggingCapabilities;
            this.prompts = promptCapabilities;
            this.resources = resourceCapabilities;
            this.tools = toolCapabilities;
        }

        public static Builder builder() {
            return new Builder();
        }

        @JsonProperty("completions")
        public CompletionCapabilities completions() {
            return this.completions;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ServerCapabilities)) {
                return false;
            }
            ServerCapabilities serverCapabilities = (ServerCapabilities) obj;
            return Objects.equals(this.completions, serverCapabilities.completions) && Objects.equals(this.experimental, serverCapabilities.experimental) && Objects.equals(this.logging, serverCapabilities.logging) && Objects.equals(this.prompts, serverCapabilities.prompts) && Objects.equals(this.resources, serverCapabilities.resources) && Objects.equals(this.tools, serverCapabilities.tools);
        }

        @JsonProperty("experimental")
        public Map<String, Object> experimental() {
            return this.experimental;
        }

        public final int hashCode() {
            CompletionCapabilities completionCapabilities = this.completions;
            Map<String, Object> map = this.experimental;
            LoggingCapabilities loggingCapabilities = this.logging;
            PromptCapabilities promptCapabilities = this.prompts;
            ResourceCapabilities resourceCapabilities = this.resources;
            ToolCapabilities toolCapabilities = this.tools;
            return Objects.hashCode(toolCapabilities) + ((Objects.hashCode(resourceCapabilities) + ((Objects.hashCode(promptCapabilities) + ((Objects.hashCode(loggingCapabilities) + androidx.activity.b.f(map, Objects.hashCode(completionCapabilities) * 31, 31)) * 31)) * 31)) * 31);
        }

        @JsonProperty("logging")
        public LoggingCapabilities logging() {
            return this.logging;
        }

        public Builder mutate() {
            Builder builder = new Builder();
            builder.completions = this.completions;
            builder.experimental = this.experimental;
            builder.logging = this.logging;
            builder.prompts = this.prompts;
            builder.resources = this.resources;
            builder.tools = this.tools;
            return builder;
        }

        @JsonProperty("prompts")
        public PromptCapabilities prompts() {
            return this.prompts;
        }

        @JsonProperty("resources")
        public ResourceCapabilities resources() {
            return this.resources;
        }

        public final String toString() {
            Object[] objArr = {this.completions, this.experimental, this.logging, this.prompts, this.resources, this.tools};
            String[] strArrSplit = "completions;experimental;logging;prompts;resources;tools".length() == 0 ? new String[0] : "completions;experimental;logging;prompts;resources;tools".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ServerCapabilities.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @JsonProperty("tools")
        public ToolCapabilities tools() {
            return this.tools;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class SetLevelRequest extends androidx.activity.b {

        @JsonProperty("level")
        private final LoggingLevel level;

        public SetLevelRequest(@JsonProperty("level") LoggingLevel loggingLevel) {
            this.level = loggingLevel;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof SetLevelRequest) && Objects.equals(this.level, ((SetLevelRequest) obj).level);
        }

        public final int hashCode() {
            return Objects.hashCode(this.level);
        }

        @JsonProperty("level")
        public LoggingLevel level() {
            return this.level;
        }

        public final String toString() {
            Object[] objArr = {this.level};
            String[] strArrSplit = "level".length() == 0 ? new String[0] : "level".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, SetLevelRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ToolAnnotations extends androidx.activity.b {

        @JsonProperty("destructiveHint")
        private final Boolean destructiveHint;

        @JsonProperty("idempotentHint")
        private final Boolean idempotentHint;

        @JsonProperty("openWorldHint")
        private final Boolean openWorldHint;

        @JsonProperty("readOnlyHint")
        private final Boolean readOnlyHint;

        @JsonProperty("returnDirect")
        private final Boolean returnDirect;

        @JsonProperty("title")
        private final String title;

        public ToolAnnotations(@JsonProperty("title") String str, @JsonProperty("readOnlyHint") Boolean bool, @JsonProperty("destructiveHint") Boolean bool2, @JsonProperty("idempotentHint") Boolean bool3, @JsonProperty("openWorldHint") Boolean bool4, @JsonProperty("returnDirect") Boolean bool5) {
            this.title = str;
            this.readOnlyHint = bool;
            this.destructiveHint = bool2;
            this.idempotentHint = bool3;
            this.openWorldHint = bool4;
            this.returnDirect = bool5;
        }

        @JsonProperty("destructiveHint")
        public Boolean destructiveHint() {
            return this.destructiveHint;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ToolAnnotations)) {
                return false;
            }
            ToolAnnotations toolAnnotations = (ToolAnnotations) obj;
            return Objects.equals(this.title, toolAnnotations.title) && Objects.equals(this.readOnlyHint, toolAnnotations.readOnlyHint) && Objects.equals(this.destructiveHint, toolAnnotations.destructiveHint) && Objects.equals(this.idempotentHint, toolAnnotations.idempotentHint) && Objects.equals(this.openWorldHint, toolAnnotations.openWorldHint) && Objects.equals(this.returnDirect, toolAnnotations.returnDirect);
        }

        public final int hashCode() {
            String str = this.title;
            Boolean bool = this.readOnlyHint;
            Boolean bool2 = this.destructiveHint;
            Boolean bool3 = this.idempotentHint;
            Boolean bool4 = this.openWorldHint;
            Boolean bool5 = this.returnDirect;
            return Objects.hashCode(bool5) + ((Objects.hashCode(bool4) + ((Objects.hashCode(bool3) + ((Objects.hashCode(bool2) + ((Objects.hashCode(bool) + (Objects.hashCode(str) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        @JsonProperty("idempotentHint")
        public Boolean idempotentHint() {
            return this.idempotentHint;
        }

        @JsonProperty("openWorldHint")
        public Boolean openWorldHint() {
            return this.openWorldHint;
        }

        @JsonProperty("readOnlyHint")
        public Boolean readOnlyHint() {
            return this.readOnlyHint;
        }

        @JsonProperty("returnDirect")
        public Boolean returnDirect() {
            return this.returnDirect;
        }

        @JsonProperty("title")
        public String title() {
            return this.title;
        }

        public final String toString() {
            Object[] objArr = {this.title, this.readOnlyHint, this.destructiveHint, this.idempotentHint, this.openWorldHint, this.returnDirect};
            String[] strArrSplit = "title;readOnlyHint;destructiveHint;idempotentHint;openWorldHint;returnDirect".length() == 0 ? new String[0] : "title;readOnlyHint;destructiveHint;idempotentHint;openWorldHint;returnDirect".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ToolAnnotations.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    private McpSchema() {
    }

    public static JSONRPCMessage deserializeJsonRpcMessage(McpJsonMapper mcpJsonMapper, String str) {
        logger.h(str, "Received JSON message: {}");
        HashMap map = (HashMap) mcpJsonMapper.readValue(str, MAP_TYPE_REF);
        if (map.containsKey("method") && map.containsKey("id")) {
            return (JSONRPCMessage) mcpJsonMapper.convertValue(map, JSONRPCRequest.class);
        }
        if (map.containsKey("method") && !map.containsKey("id")) {
            return (JSONRPCMessage) mcpJsonMapper.convertValue(map, JSONRPCNotification.class);
        }
        if (map.containsKey("result") || map.containsKey("error")) {
            return (JSONRPCMessage) mcpJsonMapper.convertValue(map, JSONRPCResponse.class);
        }
        g5.f.s(w2.c.b("Cannot deserialize JSONRPCMessage: ", str));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JsonSchema parseSchema(McpJsonMapper mcpJsonMapper, String str) {
        try {
            return (JsonSchema) mcpJsonMapper.readValue(str, JsonSchema.class);
        } catch (IOException e10) {
            throw new IllegalArgumentException(w2.c.b("Invalid schema: ", str), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> schemaToMap(McpJsonMapper mcpJsonMapper, String str) {
        try {
            return (Map) mcpJsonMapper.readValue(str, MAP_TYPE_REF);
        } catch (IOException e10) {
            throw new IllegalArgumentException(w2.c.b("Invalid schema: ", str), e10);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class CallToolRequest extends androidx.activity.b implements Request {

        @JsonProperty("arguments")
        private final Map<String, Object> arguments;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("name")
        private final String name;

        public CallToolRequest(@JsonProperty("name") String str, @JsonProperty("arguments") Map<String, Object> map, @JsonProperty("_meta") Map<String, Object> map2) {
            this.name = str;
            this.arguments = map;
            this.meta = map2;
        }

        public static Builder builder() {
            return new Builder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Map<String, Object> parseJsonArguments(McpJsonMapper mcpJsonMapper, String str) {
            try {
                return (Map) mcpJsonMapper.readValue(str, McpSchema.MAP_TYPE_REF);
            } catch (IOException e10) {
                throw new IllegalArgumentException(w2.c.b("Invalid arguments: ", str), e10);
            }
        }

        @JsonProperty("arguments")
        public Map<String, Object> arguments() {
            return this.arguments;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof CallToolRequest)) {
                return false;
            }
            CallToolRequest callToolRequest = (CallToolRequest) obj;
            return Objects.equals(this.name, callToolRequest.name) && Objects.equals(this.arguments, callToolRequest.arguments) && Objects.equals(this.meta, callToolRequest.meta);
        }

        public final int hashCode() {
            String str = this.name;
            Map<String, Object> map = this.arguments;
            Map<String, Object> map2 = this.meta;
            return Objects.hashCode(map2) + androidx.activity.b.f(map, Objects.hashCode(str) * 31, 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        public final String toString() {
            Object[] objArr = {this.name, this.arguments, this.meta};
            String[] strArrSplit = "name;arguments;meta".length() == 0 ? new String[0] : "name;arguments;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, CallToolRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private Map<String, Object> arguments;
            private Map<String, Object> meta;
            private String name;

            public Builder arguments(McpJsonMapper mcpJsonMapper, String str) {
                this.arguments = CallToolRequest.parseJsonArguments(mcpJsonMapper, str);
                return this;
            }

            public CallToolRequest build() {
                Assert.hasText(this.name, "name must not be empty");
                return new CallToolRequest(this.name, this.arguments, this.meta);
            }

            public Builder meta(Map<String, Object> map) {
                this.meta = map;
                return this;
            }

            public Builder name(String str) {
                this.name = str;
                return this;
            }

            public Builder progressToken(Object obj) {
                if (this.meta == null) {
                    this.meta = new HashMap();
                }
                this.meta.put("progressToken", obj);
                return this;
            }

            public Builder arguments(Map<String, Object> map) {
                this.arguments = map;
                return this;
            }
        }

        public CallToolRequest(McpJsonMapper mcpJsonMapper, String str, String str2) {
            this(str, parseJsonArguments(mcpJsonMapper, str2), (Map<String, Object>) null);
        }

        public CallToolRequest(String str, Map<String, Object> map) {
            this(str, map, (Map<String, Object>) null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class Tool extends androidx.activity.b {

        @JsonProperty("annotations")
        private final ToolAnnotations annotations;

        @JsonProperty("description")
        private final String description;

        @JsonProperty("inputSchema")
        private final JsonSchema inputSchema;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("name")
        private final String name;

        @JsonProperty("outputSchema")
        private final Map<String, Object> outputSchema;

        @JsonProperty("title")
        private final String title;

        public Tool(@JsonProperty("name") String str, @JsonProperty("title") String str2, @JsonProperty("description") String str3, @JsonProperty("inputSchema") JsonSchema jsonSchema, @JsonProperty("outputSchema") Map<String, Object> map, @JsonProperty("annotations") ToolAnnotations toolAnnotations, @JsonProperty("_meta") Map<String, Object> map2) {
            this.name = str;
            this.title = str2;
            this.description = str3;
            this.inputSchema = jsonSchema;
            this.outputSchema = map;
            this.annotations = toolAnnotations;
            this.meta = map2;
        }

        public static Builder builder() {
            return new Builder();
        }

        @JsonProperty("annotations")
        public ToolAnnotations annotations() {
            return this.annotations;
        }

        @JsonProperty("description")
        public String description() {
            return this.description;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Tool)) {
                return false;
            }
            Tool tool = (Tool) obj;
            return Objects.equals(this.name, tool.name) && Objects.equals(this.title, tool.title) && Objects.equals(this.description, tool.description) && Objects.equals(this.inputSchema, tool.inputSchema) && Objects.equals(this.outputSchema, tool.outputSchema) && Objects.equals(this.annotations, tool.annotations) && Objects.equals(this.meta, tool.meta);
        }

        public final int hashCode() {
            String str = this.name;
            String str2 = this.title;
            String str3 = this.description;
            JsonSchema jsonSchema = this.inputSchema;
            Map<String, Object> map = this.outputSchema;
            ToolAnnotations toolAnnotations = this.annotations;
            Map<String, Object> map2 = this.meta;
            return Objects.hashCode(map2) + ((Objects.hashCode(toolAnnotations) + androidx.activity.b.f(map, (Objects.hashCode(jsonSchema) + androidx.activity.b.w(androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2), 31, str3)) * 31, 31)) * 31);
        }

        @JsonProperty("inputSchema")
        public JsonSchema inputSchema() {
            return this.inputSchema;
        }

        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        @JsonProperty("outputSchema")
        public Map<String, Object> outputSchema() {
            return this.outputSchema;
        }

        @JsonProperty("title")
        public String title() {
            return this.title;
        }

        public final String toString() {
            Object[] objArr = {this.name, this.title, this.description, this.inputSchema, this.outputSchema, this.annotations, this.meta};
            String[] strArrSplit = "name;title;description;inputSchema;outputSchema;annotations;meta".length() == 0 ? new String[0] : "name;title;description;inputSchema;outputSchema;annotations;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, Tool.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private ToolAnnotations annotations;
            private String description;
            private JsonSchema inputSchema;
            private Map<String, Object> meta;
            private String name;
            private Map<String, Object> outputSchema;
            private String title;

            public Builder annotations(ToolAnnotations toolAnnotations) {
                this.annotations = toolAnnotations;
                return this;
            }

            public Tool build() {
                Assert.hasText(this.name, "name must not be empty");
                return new Tool(this.name, this.title, this.description, this.inputSchema, this.outputSchema, this.annotations, this.meta);
            }

            public Builder description(String str) {
                this.description = str;
                return this;
            }

            public Builder inputSchema(McpJsonMapper mcpJsonMapper, String str) {
                this.inputSchema = McpSchema.parseSchema(mcpJsonMapper, str);
                return this;
            }

            public Builder meta(Map<String, Object> map) {
                this.meta = map;
                return this;
            }

            public Builder name(String str) {
                this.name = str;
                return this;
            }

            public Builder outputSchema(McpJsonMapper mcpJsonMapper, String str) {
                this.outputSchema = McpSchema.schemaToMap(mcpJsonMapper, str);
                return this;
            }

            public Builder title(String str) {
                this.title = str;
                return this;
            }

            public Builder inputSchema(JsonSchema jsonSchema) {
                this.inputSchema = jsonSchema;
                return this;
            }

            public Builder outputSchema(Map<String, Object> map) {
                this.outputSchema = map;
                return this;
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class CompleteResult extends androidx.activity.b implements Result {

        @JsonProperty("completion")
        private final CompleteCompletion completion;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        @JsonInclude(JsonInclude.Include.ALWAYS)
        public static final class CompleteCompletion extends androidx.activity.b {

            @JsonProperty("hasMore")
            private final Boolean hasMore;

            @JsonProperty("total")
            private final Integer total;

            @JsonProperty("values")
            private final List<String> values;

            public CompleteCompletion(@JsonProperty("values") List<String> list, @JsonProperty("total") Integer num, @JsonProperty("hasMore") Boolean bool) {
                this.values = list;
                this.total = num;
                this.hasMore = bool;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof CompleteCompletion)) {
                    return false;
                }
                CompleteCompletion completeCompletion = (CompleteCompletion) obj;
                return Objects.equals(this.values, completeCompletion.values) && Objects.equals(this.total, completeCompletion.total) && Objects.equals(this.hasMore, completeCompletion.hasMore);
            }

            @JsonProperty("hasMore")
            public Boolean hasMore() {
                return this.hasMore;
            }

            public final int hashCode() {
                List<String> list = this.values;
                Integer num = this.total;
                Boolean bool = this.hasMore;
                return Objects.hashCode(bool) + ((Objects.hashCode(num) + (Objects.hashCode(list) * 31)) * 31);
            }

            public final String toString() {
                Object[] objArr = {this.values, this.total, this.hasMore};
                String[] strArrSplit = "values;total;hasMore".length() == 0 ? new String[0] : "values;total;hasMore".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, CompleteCompletion.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }

            @JsonProperty("total")
            public Integer total() {
                return this.total;
            }

            @JsonProperty("values")
            public List<String> values() {
                return this.values;
            }
        }

        public CompleteResult(@JsonProperty("completion") CompleteCompletion completeCompletion, @JsonProperty("_meta") Map<String, Object> map) {
            this.completion = completeCompletion;
            this.meta = map;
        }

        @JsonProperty("completion")
        public CompleteCompletion completion() {
            return this.completion;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof CompleteResult)) {
                return false;
            }
            CompleteResult completeResult = (CompleteResult) obj;
            return Objects.equals(this.completion, completeResult.completion) && Objects.equals(this.meta, completeResult.meta);
        }

        public final int hashCode() {
            CompleteCompletion completeCompletion = this.completion;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + (Objects.hashCode(completeCompletion) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        public final String toString() {
            Object[] objArr = {this.completion, this.meta};
            String[] strArrSplit = "completion;meta".length() == 0 ? new String[0] : "completion;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, CompleteResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public CompleteResult(CompleteCompletion completeCompletion) {
            this(completeCompletion, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class PaginatedRequest extends androidx.activity.b implements Request {

        @JsonProperty("cursor")
        private final String cursor;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        public PaginatedRequest(@JsonProperty("cursor") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.cursor = str;
            this.meta = map;
        }

        @JsonProperty("cursor")
        public String cursor() {
            return this.cursor;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof PaginatedRequest)) {
                return false;
            }
            PaginatedRequest paginatedRequest = (PaginatedRequest) obj;
            return Objects.equals(this.cursor, paginatedRequest.cursor) && Objects.equals(this.meta, paginatedRequest.meta);
        }

        public final int hashCode() {
            String str = this.cursor;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + (Objects.hashCode(str) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        public final String toString() {
            Object[] objArr = {this.cursor, this.meta};
            String[] strArrSplit = "cursor;meta".length() == 0 ? new String[0] : "cursor;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, PaginatedRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public PaginatedRequest(String str) {
            this(str, null);
        }

        public PaginatedRequest() {
            this(null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ReadResourceRequest extends androidx.activity.b implements Request {

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("uri")
        private final String uri;

        public ReadResourceRequest(@JsonProperty("uri") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.uri = str;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ReadResourceRequest)) {
                return false;
            }
            ReadResourceRequest readResourceRequest = (ReadResourceRequest) obj;
            return Objects.equals(this.uri, readResourceRequest.uri) && Objects.equals(this.meta, readResourceRequest.meta);
        }

        public final int hashCode() {
            String str = this.uri;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + (Objects.hashCode(str) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        public final String toString() {
            Object[] objArr = {this.uri, this.meta};
            String[] strArrSplit = "uri;meta".length() == 0 ? new String[0] : "uri;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ReadResourceRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @JsonProperty("uri")
        public String uri() {
            return this.uri;
        }

        public ReadResourceRequest(String str) {
            this(str, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ReadResourceResult extends androidx.activity.b implements Result {

        @JsonProperty("contents")
        private final List<ResourceContents> contents;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        public ReadResourceResult(@JsonProperty("contents") List<ResourceContents> list, @JsonProperty("_meta") Map<String, Object> map) {
            this.contents = list;
            this.meta = map;
        }

        @JsonProperty("contents")
        public List<ResourceContents> contents() {
            return this.contents;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ReadResourceResult)) {
                return false;
            }
            ReadResourceResult readResourceResult = (ReadResourceResult) obj;
            return Objects.equals(this.contents, readResourceResult.contents) && Objects.equals(this.meta, readResourceResult.meta);
        }

        public final int hashCode() {
            List<ResourceContents> list = this.contents;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + (Objects.hashCode(list) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        public final String toString() {
            Object[] objArr = {this.contents, this.meta};
            String[] strArrSplit = "contents;meta".length() == 0 ? new String[0] : "contents;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ReadResourceResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public ReadResourceResult(List<ResourceContents> list) {
            this(list, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ResourceReference extends androidx.activity.b implements CompleteReference {
        public static final String TYPE = "ref/resource";

        @JsonProperty("type")
        private final String type;

        @JsonProperty("uri")
        private final String uri;

        public ResourceReference(@JsonProperty("type") String str, @JsonProperty("uri") String str2) {
            this.type = str;
            this.uri = str2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ResourceReference)) {
                return false;
            }
            ResourceReference resourceReference = (ResourceReference) obj;
            return Objects.equals(this.type, resourceReference.type) && Objects.equals(this.uri, resourceReference.uri);
        }

        public final int hashCode() {
            String str = this.type;
            String str2 = this.uri;
            return Objects.hashCode(str2) + (Objects.hashCode(str) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.CompleteReference
        public String identifier() {
            return uri();
        }

        public final String toString() {
            Object[] objArr = {this.type, this.uri};
            String[] strArrSplit = "type;uri".length() == 0 ? new String[0] : "type;uri".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ResourceReference.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.CompleteReference
        @JsonProperty("type")
        public String type() {
            return this.type;
        }

        @JsonProperty("uri")
        public String uri() {
            return this.uri;
        }

        public ResourceReference(String str) {
            this(TYPE, str);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ResourcesUpdatedNotification extends androidx.activity.b implements Notification {

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("uri")
        private final String uri;

        public ResourcesUpdatedNotification(@JsonProperty("uri") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.uri = str;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ResourcesUpdatedNotification)) {
                return false;
            }
            ResourcesUpdatedNotification resourcesUpdatedNotification = (ResourcesUpdatedNotification) obj;
            return Objects.equals(this.uri, resourcesUpdatedNotification.uri) && Objects.equals(this.meta, resourcesUpdatedNotification.meta);
        }

        public final int hashCode() {
            String str = this.uri;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + (Objects.hashCode(str) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        public final String toString() {
            Object[] objArr = {this.uri, this.meta};
            String[] strArrSplit = "uri;meta".length() == 0 ? new String[0] : "uri;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ResourcesUpdatedNotification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @JsonProperty("uri")
        public String uri() {
            return this.uri;
        }

        public ResourcesUpdatedNotification(String str) {
            this(str, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class SubscribeRequest extends androidx.activity.b implements Request {

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("uri")
        private final String uri;

        public SubscribeRequest(@JsonProperty("uri") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.uri = str;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SubscribeRequest)) {
                return false;
            }
            SubscribeRequest subscribeRequest = (SubscribeRequest) obj;
            return Objects.equals(this.uri, subscribeRequest.uri) && Objects.equals(this.meta, subscribeRequest.meta);
        }

        public final int hashCode() {
            String str = this.uri;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + (Objects.hashCode(str) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        public final String toString() {
            Object[] objArr = {this.uri, this.meta};
            String[] strArrSplit = "uri;meta".length() == 0 ? new String[0] : "uri;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, SubscribeRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @JsonProperty("uri")
        public String uri() {
            return this.uri;
        }

        public SubscribeRequest(String str) {
            this(str, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class UnsubscribeRequest extends androidx.activity.b implements Request {

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("uri")
        private final String uri;

        public UnsubscribeRequest(@JsonProperty("uri") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.uri = str;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof UnsubscribeRequest)) {
                return false;
            }
            UnsubscribeRequest unsubscribeRequest = (UnsubscribeRequest) obj;
            return Objects.equals(this.uri, unsubscribeRequest.uri) && Objects.equals(this.meta, unsubscribeRequest.meta);
        }

        public final int hashCode() {
            String str = this.uri;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + (Objects.hashCode(str) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        public final String toString() {
            Object[] objArr = {this.uri, this.meta};
            String[] strArrSplit = "uri;meta".length() == 0 ? new String[0] : "uri;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, UnsubscribeRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @JsonProperty("uri")
        public String uri() {
            return this.uri;
        }

        public UnsubscribeRequest(String str) {
            this(str, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class Annotations extends androidx.activity.b {

        @JsonProperty("audience")
        private final List<Role> audience;

        @JsonProperty("lastModified")
        private final String lastModified;

        @JsonProperty("priority")
        private final Double priority;

        public Annotations(@JsonProperty("audience") List<Role> list, @JsonProperty("priority") Double d7, @JsonProperty("lastModified") String str) {
            this.audience = list;
            this.priority = d7;
            this.lastModified = str;
        }

        @JsonProperty("audience")
        public List<Role> audience() {
            return this.audience;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Annotations)) {
                return false;
            }
            Annotations annotations = (Annotations) obj;
            return Objects.equals(this.audience, annotations.audience) && Objects.equals(this.priority, annotations.priority) && Objects.equals(this.lastModified, annotations.lastModified);
        }

        public final int hashCode() {
            List<Role> list = this.audience;
            Double d7 = this.priority;
            String str = this.lastModified;
            return Objects.hashCode(str) + ((Objects.hashCode(d7) + (Objects.hashCode(list) * 31)) * 31);
        }

        @JsonProperty("lastModified")
        public String lastModified() {
            return this.lastModified;
        }

        @JsonProperty("priority")
        public Double priority() {
            return this.priority;
        }

        public final String toString() {
            Object[] objArr = {this.audience, this.priority, this.lastModified};
            String[] strArrSplit = "audience;priority;lastModified".length() == 0 ? new String[0] : "audience;priority;lastModified".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, Annotations.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public Annotations(List<Role> list, Double d7) {
            this(list, d7, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ElicitRequest extends androidx.activity.b implements Request {

        @JsonProperty("message")
        private final String message;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("requestedSchema")
        private final Map<String, Object> requestedSchema;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private String message;
            private Map<String, Object> meta;
            private Map<String, Object> requestedSchema;

            public ElicitRequest build() {
                return new ElicitRequest(this.message, this.requestedSchema, this.meta);
            }

            public Builder message(String str) {
                this.message = str;
                return this;
            }

            public Builder meta(Map<String, Object> map) {
                this.meta = map;
                return this;
            }

            public Builder progressToken(Object obj) {
                if (this.meta == null) {
                    this.meta = new HashMap();
                }
                this.meta.put("progressToken", obj);
                return this;
            }

            public Builder requestedSchema(Map<String, Object> map) {
                this.requestedSchema = map;
                return this;
            }
        }

        public ElicitRequest(@JsonProperty("message") String str, @JsonProperty("requestedSchema") Map<String, Object> map, @JsonProperty("_meta") Map<String, Object> map2) {
            this.message = str;
            this.requestedSchema = map;
            this.meta = map2;
        }

        public static Builder builder() {
            return new Builder();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ElicitRequest)) {
                return false;
            }
            ElicitRequest elicitRequest = (ElicitRequest) obj;
            return Objects.equals(this.message, elicitRequest.message) && Objects.equals(this.requestedSchema, elicitRequest.requestedSchema) && Objects.equals(this.meta, elicitRequest.meta);
        }

        public final int hashCode() {
            String str = this.message;
            Map<String, Object> map = this.requestedSchema;
            Map<String, Object> map2 = this.meta;
            return Objects.hashCode(map2) + androidx.activity.b.f(map, Objects.hashCode(str) * 31, 31);
        }

        @JsonProperty("message")
        public String message() {
            return this.message;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("requestedSchema")
        public Map<String, Object> requestedSchema() {
            return this.requestedSchema;
        }

        public final String toString() {
            Object[] objArr = {this.message, this.requestedSchema, this.meta};
            String[] strArrSplit = "message;requestedSchema;meta".length() == 0 ? new String[0] : "message;requestedSchema;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ElicitRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public ElicitRequest(String str, Map<String, Object> map) {
            this(str, map, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ElicitResult extends androidx.activity.b implements Result {

        @JsonProperty("action")
        private final Action action;

        @JsonProperty("content")
        private final Map<String, Object> content;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public enum Action {
            ACCEPT,
            DECLINE,
            CANCEL
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private Action action;
            private Map<String, Object> content;
            private Map<String, Object> meta;

            public ElicitResult build() {
                return new ElicitResult(this.action, this.content, this.meta);
            }

            public Builder content(Map<String, Object> map) {
                this.content = map;
                return this;
            }

            public Builder message(Action action) {
                this.action = action;
                return this;
            }

            public Builder meta(Map<String, Object> map) {
                this.meta = map;
                return this;
            }
        }

        public ElicitResult(@JsonProperty("action") Action action, @JsonProperty("content") Map<String, Object> map, @JsonProperty("_meta") Map<String, Object> map2) {
            this.action = action;
            this.content = map;
            this.meta = map2;
        }

        public static Builder builder() {
            return new Builder();
        }

        @JsonProperty("action")
        public Action action() {
            return this.action;
        }

        @JsonProperty("content")
        public Map<String, Object> content() {
            return this.content;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ElicitResult)) {
                return false;
            }
            ElicitResult elicitResult = (ElicitResult) obj;
            return Objects.equals(this.action, elicitResult.action) && Objects.equals(this.content, elicitResult.content) && Objects.equals(this.meta, elicitResult.meta);
        }

        public final int hashCode() {
            Action action = this.action;
            Map<String, Object> map = this.content;
            Map<String, Object> map2 = this.meta;
            return Objects.hashCode(map2) + androidx.activity.b.f(map, Objects.hashCode(action) * 31, 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        public final String toString() {
            Object[] objArr = {this.action, this.content, this.meta};
            String[] strArrSplit = "action;content;meta".length() == 0 ? new String[0] : "action;content;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ElicitResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public ElicitResult(Action action, Map<String, Object> map) {
            this(action, map, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class GetPromptRequest extends androidx.activity.b implements Request {

        @JsonProperty("arguments")
        private final Map<String, Object> arguments;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("name")
        private final String name;

        public GetPromptRequest(@JsonProperty("name") String str, @JsonProperty("arguments") Map<String, Object> map, @JsonProperty("_meta") Map<String, Object> map2) {
            this.name = str;
            this.arguments = map;
            this.meta = map2;
        }

        @JsonProperty("arguments")
        public Map<String, Object> arguments() {
            return this.arguments;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof GetPromptRequest)) {
                return false;
            }
            GetPromptRequest getPromptRequest = (GetPromptRequest) obj;
            return Objects.equals(this.name, getPromptRequest.name) && Objects.equals(this.arguments, getPromptRequest.arguments) && Objects.equals(this.meta, getPromptRequest.meta);
        }

        public final int hashCode() {
            String str = this.name;
            Map<String, Object> map = this.arguments;
            Map<String, Object> map2 = this.meta;
            return Objects.hashCode(map2) + androidx.activity.b.f(map, Objects.hashCode(str) * 31, 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        public final String toString() {
            Object[] objArr = {this.name, this.arguments, this.meta};
            String[] strArrSplit = "name;arguments;meta".length() == 0 ? new String[0] : "name;arguments;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, GetPromptRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public GetPromptRequest(String str, Map<String, Object> map) {
            this(str, map, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class GetPromptResult extends androidx.activity.b implements Result {

        @JsonProperty("description")
        private final String description;

        @JsonProperty("messages")
        private final List<PromptMessage> messages;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        public GetPromptResult(@JsonProperty("description") String str, @JsonProperty("messages") List<PromptMessage> list, @JsonProperty("_meta") Map<String, Object> map) {
            this.description = str;
            this.messages = list;
            this.meta = map;
        }

        @JsonProperty("description")
        public String description() {
            return this.description;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof GetPromptResult)) {
                return false;
            }
            GetPromptResult getPromptResult = (GetPromptResult) obj;
            return Objects.equals(this.description, getPromptResult.description) && Objects.equals(this.messages, getPromptResult.messages) && Objects.equals(this.meta, getPromptResult.meta);
        }

        public final int hashCode() {
            String str = this.description;
            List<PromptMessage> list = this.messages;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.x(list, Objects.hashCode(str) * 31, 31);
        }

        @JsonProperty("messages")
        public List<PromptMessage> messages() {
            return this.messages;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        public final String toString() {
            Object[] objArr = {this.description, this.messages, this.meta};
            String[] strArrSplit = "description;messages;meta".length() == 0 ? new String[0] : "description;messages;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, GetPromptResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public GetPromptResult(String str, List<PromptMessage> list) {
            this(str, list, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class Implementation extends androidx.activity.b implements Identifier {

        @JsonProperty("name")
        private final String name;

        @JsonProperty("title")
        private final String title;

        @JsonProperty("version")
        private final String version;

        public Implementation(@JsonProperty("name") String str, @JsonProperty("title") String str2, @JsonProperty("version") String str3) {
            this.name = str;
            this.title = str2;
            this.version = str3;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Implementation)) {
                return false;
            }
            Implementation implementation = (Implementation) obj;
            return Objects.equals(this.name, implementation.name) && Objects.equals(this.title, implementation.title) && Objects.equals(this.version, implementation.version);
        }

        public final int hashCode() {
            String str = this.name;
            String str2 = this.title;
            String str3 = this.version;
            return Objects.hashCode(str3) + androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("title")
        public String title() {
            return this.title;
        }

        public final String toString() {
            Object[] objArr = {this.name, this.title, this.version};
            String[] strArrSplit = "name;title;version".length() == 0 ? new String[0] : "name;title;version".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, Implementation.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @JsonProperty("version")
        public String version() {
            return this.version;
        }

        public Implementation(String str, String str2) {
            this(str, null, str2);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ListPromptsResult extends androidx.activity.b implements Result {

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("nextCursor")
        private final String nextCursor;

        @JsonProperty("prompts")
        private final List<Prompt> prompts;

        public ListPromptsResult(@JsonProperty("prompts") List<Prompt> list, @JsonProperty("nextCursor") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.prompts = list;
            this.nextCursor = str;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ListPromptsResult)) {
                return false;
            }
            ListPromptsResult listPromptsResult = (ListPromptsResult) obj;
            return Objects.equals(this.prompts, listPromptsResult.prompts) && Objects.equals(this.nextCursor, listPromptsResult.nextCursor) && Objects.equals(this.meta, listPromptsResult.meta);
        }

        public final int hashCode() {
            List<Prompt> list = this.prompts;
            String str = this.nextCursor;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(Objects.hashCode(list) * 31, 31, str);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("nextCursor")
        public String nextCursor() {
            return this.nextCursor;
        }

        @JsonProperty("prompts")
        public List<Prompt> prompts() {
            return this.prompts;
        }

        public final String toString() {
            Object[] objArr = {this.prompts, this.nextCursor, this.meta};
            String[] strArrSplit = "prompts;nextCursor;meta".length() == 0 ? new String[0] : "prompts;nextCursor;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ListPromptsResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public ListPromptsResult(List<Prompt> list, String str) {
            this(list, str, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ListResourceTemplatesResult extends androidx.activity.b implements Result {

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("nextCursor")
        private final String nextCursor;

        @JsonProperty("resourceTemplates")
        private final List<ResourceTemplate> resourceTemplates;

        public ListResourceTemplatesResult(@JsonProperty("resourceTemplates") List<ResourceTemplate> list, @JsonProperty("nextCursor") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.resourceTemplates = list;
            this.nextCursor = str;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ListResourceTemplatesResult)) {
                return false;
            }
            ListResourceTemplatesResult listResourceTemplatesResult = (ListResourceTemplatesResult) obj;
            return Objects.equals(this.resourceTemplates, listResourceTemplatesResult.resourceTemplates) && Objects.equals(this.nextCursor, listResourceTemplatesResult.nextCursor) && Objects.equals(this.meta, listResourceTemplatesResult.meta);
        }

        public final int hashCode() {
            List<ResourceTemplate> list = this.resourceTemplates;
            String str = this.nextCursor;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(Objects.hashCode(list) * 31, 31, str);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("nextCursor")
        public String nextCursor() {
            return this.nextCursor;
        }

        @JsonProperty("resourceTemplates")
        public List<ResourceTemplate> resourceTemplates() {
            return this.resourceTemplates;
        }

        public final String toString() {
            Object[] objArr = {this.resourceTemplates, this.nextCursor, this.meta};
            String[] strArrSplit = "resourceTemplates;nextCursor;meta".length() == 0 ? new String[0] : "resourceTemplates;nextCursor;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ListResourceTemplatesResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public ListResourceTemplatesResult(List<ResourceTemplate> list, String str) {
            this(list, str, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ListResourcesResult extends androidx.activity.b implements Result {

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("nextCursor")
        private final String nextCursor;

        @JsonProperty("resources")
        private final List<Resource> resources;

        public ListResourcesResult(@JsonProperty("resources") List<Resource> list, @JsonProperty("nextCursor") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.resources = list;
            this.nextCursor = str;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ListResourcesResult)) {
                return false;
            }
            ListResourcesResult listResourcesResult = (ListResourcesResult) obj;
            return Objects.equals(this.resources, listResourcesResult.resources) && Objects.equals(this.nextCursor, listResourcesResult.nextCursor) && Objects.equals(this.meta, listResourcesResult.meta);
        }

        public final int hashCode() {
            List<Resource> list = this.resources;
            String str = this.nextCursor;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(Objects.hashCode(list) * 31, 31, str);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("nextCursor")
        public String nextCursor() {
            return this.nextCursor;
        }

        @JsonProperty("resources")
        public List<Resource> resources() {
            return this.resources;
        }

        public final String toString() {
            Object[] objArr = {this.resources, this.nextCursor, this.meta};
            String[] strArrSplit = "resources;nextCursor;meta".length() == 0 ? new String[0] : "resources;nextCursor;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ListResourcesResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public ListResourcesResult(List<Resource> list, String str) {
            this(list, str, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ListRootsResult extends androidx.activity.b implements Result {

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("nextCursor")
        private final String nextCursor;

        @JsonProperty("roots")
        private final List<Root> roots;

        public ListRootsResult(@JsonProperty("roots") List<Root> list, @JsonProperty("nextCursor") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.roots = list;
            this.nextCursor = str;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ListRootsResult)) {
                return false;
            }
            ListRootsResult listRootsResult = (ListRootsResult) obj;
            return Objects.equals(this.roots, listRootsResult.roots) && Objects.equals(this.nextCursor, listRootsResult.nextCursor) && Objects.equals(this.meta, listRootsResult.meta);
        }

        public final int hashCode() {
            List<Root> list = this.roots;
            String str = this.nextCursor;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(Objects.hashCode(list) * 31, 31, str);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("nextCursor")
        public String nextCursor() {
            return this.nextCursor;
        }

        @JsonProperty("roots")
        public List<Root> roots() {
            return this.roots;
        }

        public final String toString() {
            Object[] objArr = {this.roots, this.nextCursor, this.meta};
            String[] strArrSplit = "roots;nextCursor;meta".length() == 0 ? new String[0] : "roots;nextCursor;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ListRootsResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public ListRootsResult(List<Root> list) {
            this(list, null);
        }

        public ListRootsResult(List<Root> list, String str) {
            this(list, str, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ListToolsResult extends androidx.activity.b implements Result {

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("nextCursor")
        private final String nextCursor;

        @JsonProperty("tools")
        private final List<Tool> tools;

        public ListToolsResult(@JsonProperty("tools") List<Tool> list, @JsonProperty("nextCursor") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.tools = list;
            this.nextCursor = str;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ListToolsResult)) {
                return false;
            }
            ListToolsResult listToolsResult = (ListToolsResult) obj;
            return Objects.equals(this.tools, listToolsResult.tools) && Objects.equals(this.nextCursor, listToolsResult.nextCursor) && Objects.equals(this.meta, listToolsResult.meta);
        }

        public final int hashCode() {
            List<Tool> list = this.tools;
            String str = this.nextCursor;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(Objects.hashCode(list) * 31, 31, str);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("nextCursor")
        public String nextCursor() {
            return this.nextCursor;
        }

        public final String toString() {
            Object[] objArr = {this.tools, this.nextCursor, this.meta};
            String[] strArrSplit = "tools;nextCursor;meta".length() == 0 ? new String[0] : "tools;nextCursor;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ListToolsResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @JsonProperty("tools")
        public List<Tool> tools() {
            return this.tools;
        }

        public ListToolsResult(List<Tool> list, String str) {
            this(list, str, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class PromptReference extends androidx.activity.b implements CompleteReference, Identifier {
        public static final String TYPE = "ref/prompt";

        @JsonProperty("name")
        private final String name;

        @JsonProperty("title")
        private final String title;

        @JsonProperty("type")
        private final String type;

        public PromptReference(@JsonProperty("type") String str, @JsonProperty("name") String str2, @JsonProperty("title") String str3) {
            this.type = str;
            this.name = str2;
            this.title = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PromptReference.class == obj.getClass()) {
                PromptReference promptReference = (PromptReference) obj;
                if (Objects.equals(identifier(), promptReference.identifier()) && Objects.equals(type(), promptReference.type())) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(identifier(), type());
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.CompleteReference
        public String identifier() {
            return name();
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("title")
        public String title() {
            return this.title;
        }

        public final String toString() {
            Object[] objArr = {this.type, this.name, this.title};
            String[] strArrSplit = "type;name;title".length() == 0 ? new String[0] : "type;name;title".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, PromptReference.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.CompleteReference
        @JsonProperty("type")
        public String type() {
            return this.type;
        }

        public PromptReference(String str, String str2) {
            this(str, str2, null);
        }

        public PromptReference(String str) {
            this(TYPE, str, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class Root extends androidx.activity.b {

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("name")
        private final String name;

        @JsonProperty("uri")
        private final String uri;

        public Root(@JsonProperty("uri") String str, @JsonProperty("name") String str2, @JsonProperty("_meta") Map<String, Object> map) {
            this.uri = str;
            this.name = str2;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Root)) {
                return false;
            }
            Root root = (Root) obj;
            return Objects.equals(this.uri, root.uri) && Objects.equals(this.name, root.name) && Objects.equals(this.meta, root.meta);
        }

        public final int hashCode() {
            String str = this.uri;
            String str2 = this.name;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2);
        }

        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        public final String toString() {
            Object[] objArr = {this.uri, this.name, this.meta};
            String[] strArrSplit = "uri;name;meta".length() == 0 ? new String[0] : "uri;name;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, Root.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @JsonProperty("uri")
        public String uri() {
            return this.uri;
        }

        public Root(String str, String str2) {
            this(str, str2, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class AudioContent extends androidx.activity.b implements Annotated, Content {

        @JsonProperty("annotations")
        private final Annotations annotations;

        @JsonProperty("data")
        private final String data;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("mimeType")
        private final String mimeType;

        public AudioContent(@JsonProperty("annotations") Annotations annotations, @JsonProperty("data") String str, @JsonProperty("mimeType") String str2, @JsonProperty("_meta") Map<String, Object> map) {
            this.annotations = annotations;
            this.data = str;
            this.mimeType = str2;
            this.meta = map;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Annotated
        @JsonProperty("annotations")
        public Annotations annotations() {
            return this.annotations;
        }

        @JsonProperty("data")
        public String data() {
            return this.data;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AudioContent)) {
                return false;
            }
            AudioContent audioContent = (AudioContent) obj;
            return Objects.equals(this.annotations, audioContent.annotations) && Objects.equals(this.data, audioContent.data) && Objects.equals(this.mimeType, audioContent.mimeType) && Objects.equals(this.meta, audioContent.meta);
        }

        public final int hashCode() {
            Annotations annotations = this.annotations;
            String str = this.data;
            String str2 = this.mimeType;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(androidx.activity.b.w(Objects.hashCode(annotations) * 31, 31, str), 31, str2);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("mimeType")
        public String mimeType() {
            return this.mimeType;
        }

        public final String toString() {
            Object[] objArr = {this.annotations, this.data, this.mimeType, this.meta};
            String[] strArrSplit = "annotations;data;mimeType;meta".length() == 0 ? new String[0] : "annotations;data;mimeType;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, AudioContent.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public AudioContent(Annotations annotations, String str, String str2) {
            this(annotations, str, str2, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class BlobResourceContents extends androidx.activity.b implements ResourceContents {

        @JsonProperty("blob")
        private final String blob;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("mimeType")
        private final String mimeType;

        @JsonProperty("uri")
        private final String uri;

        public BlobResourceContents(@JsonProperty("uri") String str, @JsonProperty("mimeType") String str2, @JsonProperty("blob") String str3, @JsonProperty("_meta") Map<String, Object> map) {
            this.uri = str;
            this.mimeType = str2;
            this.blob = str3;
            this.meta = map;
        }

        @JsonProperty("blob")
        public String blob() {
            return this.blob;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof BlobResourceContents)) {
                return false;
            }
            BlobResourceContents blobResourceContents = (BlobResourceContents) obj;
            return Objects.equals(this.uri, blobResourceContents.uri) && Objects.equals(this.mimeType, blobResourceContents.mimeType) && Objects.equals(this.blob, blobResourceContents.blob) && Objects.equals(this.meta, blobResourceContents.meta);
        }

        public final int hashCode() {
            String str = this.uri;
            String str2 = this.mimeType;
            String str3 = this.blob;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2), 31, str3);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContents
        @JsonProperty("mimeType")
        public String mimeType() {
            return this.mimeType;
        }

        public final String toString() {
            Object[] objArr = {this.uri, this.mimeType, this.blob, this.meta};
            String[] strArrSplit = "uri;mimeType;blob;meta".length() == 0 ? new String[0] : "uri;mimeType;blob;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, BlobResourceContents.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContents
        @JsonProperty("uri")
        public String uri() {
            return this.uri;
        }

        public BlobResourceContents(String str, String str2, String str3) {
            this(str, str2, str3, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class CompleteRequest extends androidx.activity.b implements Request {

        @JsonProperty("argument")
        private final CompleteArgument argument;

        @JsonProperty("context")
        private final CompleteContext context;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("ref")
        private final CompleteReference ref;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static final class CompleteArgument extends androidx.activity.b {

            @JsonProperty("name")
            private final String name;

            @JsonProperty("value")
            private final String value;

            public CompleteArgument(@JsonProperty("name") String str, @JsonProperty("value") String str2) {
                this.name = str;
                this.value = str2;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof CompleteArgument)) {
                    return false;
                }
                CompleteArgument completeArgument = (CompleteArgument) obj;
                return Objects.equals(this.name, completeArgument.name) && Objects.equals(this.value, completeArgument.value);
            }

            public final int hashCode() {
                String str = this.name;
                String str2 = this.value;
                return Objects.hashCode(str2) + (Objects.hashCode(str) * 31);
            }

            @JsonProperty("name")
            public String name() {
                return this.name;
            }

            public final String toString() {
                Object[] objArr = {this.name, this.value};
                String[] strArrSplit = "name;value".length() == 0 ? new String[0] : "name;value".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, CompleteArgument.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }

            @JsonProperty("value")
            public String value() {
                return this.value;
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static final class CompleteContext extends androidx.activity.b {

            @JsonProperty("arguments")
            private final Map<String, String> arguments;

            public CompleteContext(@JsonProperty("arguments") Map<String, String> map) {
                this.arguments = map;
            }

            @JsonProperty("arguments")
            public Map<String, String> arguments() {
                return this.arguments;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof CompleteContext) && Objects.equals(this.arguments, ((CompleteContext) obj).arguments);
            }

            public final int hashCode() {
                return Objects.hashCode(this.arguments);
            }

            public final String toString() {
                Object[] objArr = {this.arguments};
                String[] strArrSplit = "arguments".length() == 0 ? new String[0] : "arguments".split(";");
                StringBuilder sb2 = new StringBuilder();
                androidx.activity.b.t(sb2, CompleteContext.class, "[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb2.append(strArrSplit[i]);
                    sb2.append("=");
                    sb2.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }
        }

        public CompleteRequest(@JsonProperty("ref") CompleteReference completeReference, @JsonProperty("argument") CompleteArgument completeArgument, @JsonProperty("_meta") Map<String, Object> map, @JsonProperty("context") CompleteContext completeContext) {
            this.ref = completeReference;
            this.argument = completeArgument;
            this.meta = map;
            this.context = completeContext;
        }

        @JsonProperty("argument")
        public CompleteArgument argument() {
            return this.argument;
        }

        @JsonProperty("context")
        public CompleteContext context() {
            return this.context;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof CompleteRequest)) {
                return false;
            }
            CompleteRequest completeRequest = (CompleteRequest) obj;
            return Objects.equals(this.ref, completeRequest.ref) && Objects.equals(this.argument, completeRequest.argument) && Objects.equals(this.meta, completeRequest.meta) && Objects.equals(this.context, completeRequest.context);
        }

        public final int hashCode() {
            CompleteReference completeReference = this.ref;
            CompleteArgument completeArgument = this.argument;
            Map<String, Object> map = this.meta;
            CompleteContext completeContext = this.context;
            return Objects.hashCode(completeContext) + androidx.activity.b.f(map, (Objects.hashCode(completeArgument) + (Objects.hashCode(completeReference) * 31)) * 31, 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("ref")
        public CompleteReference ref() {
            return this.ref;
        }

        public final String toString() {
            Object[] objArr = {this.ref, this.argument, this.meta, this.context};
            String[] strArrSplit = "ref;argument;meta;context".length() == 0 ? new String[0] : "ref;argument;meta;context".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, CompleteRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public CompleteRequest(CompleteReference completeReference, CompleteArgument completeArgument, Map<String, Object> map) {
            this(completeReference, completeArgument, map, null);
        }

        public CompleteRequest(CompleteReference completeReference, CompleteArgument completeArgument, CompleteContext completeContext) {
            this(completeReference, completeArgument, null, completeContext);
        }

        public CompleteRequest(CompleteReference completeReference, CompleteArgument completeArgument) {
            this(completeReference, completeArgument, null, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class InitializeRequest extends androidx.activity.b implements Request {

        @JsonProperty("capabilities")
        private final ClientCapabilities capabilities;

        @JsonProperty("clientInfo")
        private final Implementation clientInfo;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("protocolVersion")
        private final String protocolVersion;

        public InitializeRequest(@JsonProperty("protocolVersion") String str, @JsonProperty("capabilities") ClientCapabilities clientCapabilities, @JsonProperty("clientInfo") Implementation implementation, @JsonProperty("_meta") Map<String, Object> map) {
            this.protocolVersion = str;
            this.capabilities = clientCapabilities;
            this.clientInfo = implementation;
            this.meta = map;
        }

        @JsonProperty("capabilities")
        public ClientCapabilities capabilities() {
            return this.capabilities;
        }

        @JsonProperty("clientInfo")
        public Implementation clientInfo() {
            return this.clientInfo;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof InitializeRequest)) {
                return false;
            }
            InitializeRequest initializeRequest = (InitializeRequest) obj;
            return Objects.equals(this.protocolVersion, initializeRequest.protocolVersion) && Objects.equals(this.capabilities, initializeRequest.capabilities) && Objects.equals(this.clientInfo, initializeRequest.clientInfo) && Objects.equals(this.meta, initializeRequest.meta);
        }

        public final int hashCode() {
            String str = this.protocolVersion;
            ClientCapabilities clientCapabilities = this.capabilities;
            Implementation implementation = this.clientInfo;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + ((Objects.hashCode(implementation) + ((Objects.hashCode(clientCapabilities) + (Objects.hashCode(str) * 31)) * 31)) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("protocolVersion")
        public String protocolVersion() {
            return this.protocolVersion;
        }

        public final String toString() {
            Object[] objArr = {this.protocolVersion, this.capabilities, this.clientInfo, this.meta};
            String[] strArrSplit = "protocolVersion;capabilities;clientInfo;meta".length() == 0 ? new String[0] : "protocolVersion;capabilities;clientInfo;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, InitializeRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public InitializeRequest(String str, ClientCapabilities clientCapabilities, Implementation implementation) {
            this(str, clientCapabilities, implementation, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class LoggingMessageNotification extends androidx.activity.b implements Notification {

        @JsonProperty("data")
        private final String data;

        @JsonProperty("level")
        private final LoggingLevel level;

        @JsonProperty("logger")
        private final String logger;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private String data;
            private LoggingLevel level = LoggingLevel.INFO;
            private String logger = "server";
            private Map<String, Object> meta;

            public LoggingMessageNotification build() {
                return new LoggingMessageNotification(this.level, this.logger, this.data, this.meta);
            }

            public Builder data(String str) {
                this.data = str;
                return this;
            }

            public Builder level(LoggingLevel loggingLevel) {
                this.level = loggingLevel;
                return this;
            }

            public Builder logger(String str) {
                this.logger = str;
                return this;
            }

            public Builder meta(Map<String, Object> map) {
                this.meta = map;
                return this;
            }
        }

        public LoggingMessageNotification(@JsonProperty("level") LoggingLevel loggingLevel, @JsonProperty("logger") String str, @JsonProperty("data") String str2, @JsonProperty("_meta") Map<String, Object> map) {
            this.level = loggingLevel;
            this.logger = str;
            this.data = str2;
            this.meta = map;
        }

        public static Builder builder() {
            return new Builder();
        }

        @JsonProperty("data")
        public String data() {
            return this.data;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof LoggingMessageNotification)) {
                return false;
            }
            LoggingMessageNotification loggingMessageNotification = (LoggingMessageNotification) obj;
            return Objects.equals(this.level, loggingMessageNotification.level) && Objects.equals(this.logger, loggingMessageNotification.logger) && Objects.equals(this.data, loggingMessageNotification.data) && Objects.equals(this.meta, loggingMessageNotification.meta);
        }

        public final int hashCode() {
            LoggingLevel loggingLevel = this.level;
            String str = this.logger;
            String str2 = this.data;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(androidx.activity.b.w(Objects.hashCode(loggingLevel) * 31, 31, str), 31, str2);
        }

        @JsonProperty("level")
        public LoggingLevel level() {
            return this.level;
        }

        @JsonProperty("logger")
        public String logger() {
            return this.logger;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        public final String toString() {
            Object[] objArr = {this.level, this.logger, this.data, this.meta};
            String[] strArrSplit = "level;logger;data;meta".length() == 0 ? new String[0] : "level;logger;data;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, LoggingMessageNotification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public LoggingMessageNotification(LoggingLevel loggingLevel, String str, String str2) {
            this(loggingLevel, str, str2, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class PromptArgument extends androidx.activity.b implements Identifier {

        @JsonProperty("description")
        private final String description;

        @JsonProperty("name")
        private final String name;

        @JsonProperty("required")
        private final Boolean required;

        @JsonProperty("title")
        private final String title;

        public PromptArgument(@JsonProperty("name") String str, @JsonProperty("title") String str2, @JsonProperty("description") String str3, @JsonProperty("required") Boolean bool) {
            this.name = str;
            this.title = str2;
            this.description = str3;
            this.required = bool;
        }

        @JsonProperty("description")
        public String description() {
            return this.description;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof PromptArgument)) {
                return false;
            }
            PromptArgument promptArgument = (PromptArgument) obj;
            return Objects.equals(this.name, promptArgument.name) && Objects.equals(this.title, promptArgument.title) && Objects.equals(this.description, promptArgument.description) && Objects.equals(this.required, promptArgument.required);
        }

        public final int hashCode() {
            String str = this.name;
            String str2 = this.title;
            String str3 = this.description;
            Boolean bool = this.required;
            return Objects.hashCode(bool) + androidx.activity.b.w(androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2), 31, str3);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        @JsonProperty("required")
        public Boolean required() {
            return this.required;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("title")
        public String title() {
            return this.title;
        }

        public final String toString() {
            Object[] objArr = {this.name, this.title, this.description, this.required};
            String[] strArrSplit = "name;title;description;required".length() == 0 ? new String[0] : "name;title;description;required".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, PromptArgument.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public PromptArgument(String str, String str2, Boolean bool) {
            this(str, null, str2, bool);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class TextResourceContents extends androidx.activity.b implements ResourceContents {

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("mimeType")
        private final String mimeType;

        @JsonProperty("text")
        private final String text;

        @JsonProperty("uri")
        private final String uri;

        public TextResourceContents(@JsonProperty("uri") String str, @JsonProperty("mimeType") String str2, @JsonProperty("text") String str3, @JsonProperty("_meta") Map<String, Object> map) {
            this.uri = str;
            this.mimeType = str2;
            this.text = str3;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof TextResourceContents)) {
                return false;
            }
            TextResourceContents textResourceContents = (TextResourceContents) obj;
            return Objects.equals(this.uri, textResourceContents.uri) && Objects.equals(this.mimeType, textResourceContents.mimeType) && Objects.equals(this.text, textResourceContents.text) && Objects.equals(this.meta, textResourceContents.meta);
        }

        public final int hashCode() {
            String str = this.uri;
            String str2 = this.mimeType;
            String str3 = this.text;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2), 31, str3);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContents
        @JsonProperty("mimeType")
        public String mimeType() {
            return this.mimeType;
        }

        @JsonProperty("text")
        public String text() {
            return this.text;
        }

        public final String toString() {
            Object[] objArr = {this.uri, this.mimeType, this.text, this.meta};
            String[] strArrSplit = "uri;mimeType;text;meta".length() == 0 ? new String[0] : "uri;mimeType;text;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, TextResourceContents.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContents
        @JsonProperty("uri")
        public String uri() {
            return this.uri;
        }

        public TextResourceContents(String str, String str2, String str3) {
            this(str, str2, str3, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class CallToolResult extends androidx.activity.b implements Result {

        @JsonProperty("content")
        private final List<Content> content;

        @JsonProperty("isError")
        private final Boolean isError;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("structuredContent")
        private final Object structuredContent;

        public CallToolResult(String str, Boolean bool) {
            this(List.of(new TextContent(str)), bool, null);
        }

        public static Builder builder() {
            return new Builder();
        }

        @JsonProperty("content")
        public List<Content> content() {
            return this.content;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof CallToolResult)) {
                return false;
            }
            CallToolResult callToolResult = (CallToolResult) obj;
            return Objects.equals(this.content, callToolResult.content) && Objects.equals(this.isError, callToolResult.isError) && Objects.equals(this.structuredContent, callToolResult.structuredContent) && Objects.equals(this.meta, callToolResult.meta);
        }

        public final int hashCode() {
            List<Content> list = this.content;
            Boolean bool = this.isError;
            Object obj = this.structuredContent;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + ((Objects.hashCode(obj) + ((Objects.hashCode(bool) + (Objects.hashCode(list) * 31)) * 31)) * 31);
        }

        @JsonProperty("isError")
        public Boolean isError() {
            return this.isError;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("structuredContent")
        public Object structuredContent() {
            return this.structuredContent;
        }

        public final String toString() {
            Object[] objArr = {this.content, this.isError, this.structuredContent, this.meta};
            String[] strArrSplit = "content;isError;structuredContent;meta".length() == 0 ? new String[0] : "content;isError;structuredContent;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, CallToolResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @Deprecated
        public CallToolResult(List<Content> list, Boolean bool) {
            this(list, bool, null, null);
        }

        @Deprecated
        public CallToolResult(List<Content> list, Boolean bool, Map<String, Object> map) {
            this(list, bool, map, null);
        }

        public CallToolResult(@JsonProperty("content") List<Content> list, @JsonProperty("isError") Boolean bool, @JsonProperty("structuredContent") Object obj, @JsonProperty("_meta") Map<String, Object> map) {
            this.content = list;
            this.isError = bool;
            this.structuredContent = obj;
            this.meta = map;
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private List<Content> content = new ArrayList();
            private Boolean isError = Boolean.FALSE;
            private Map<String, Object> meta;
            private Object structuredContent;

            public Builder addContent(Content content) {
                Assert.notNull(content, "contentItem must not be null");
                if (this.content == null) {
                    this.content = new ArrayList();
                }
                this.content.add(content);
                return this;
            }

            public Builder addTextContent(String str) {
                Assert.notNull(str, "text must not be null");
                return addContent(new TextContent(str));
            }

            public CallToolResult build() {
                return new CallToolResult(this.content, this.isError, this.structuredContent, this.meta);
            }

            public Builder content(List<Content> list) {
                Assert.notNull(list, "content must not be null");
                this.content = list;
                return this;
            }

            public Builder isError(Boolean bool) {
                Assert.notNull(bool, "isError must not be null");
                this.isError = bool;
                return this;
            }

            public Builder meta(Map<String, Object> map) {
                this.meta = map;
                return this;
            }

            public Builder structuredContent(McpJsonMapper mcpJsonMapper, String str) {
                Assert.hasText(str, "structuredContent must not be empty");
                try {
                    this.structuredContent = mcpJsonMapper.readValue(str, McpSchema.MAP_TYPE_REF);
                    return this;
                } catch (IOException e10) {
                    throw new IllegalArgumentException(w2.c.b("Invalid structured content: ", str), e10);
                }
            }

            public Builder textContent(List<String> list) {
                Assert.notNull(list, "textContent must not be null");
                Stream<R> map = list.stream().map(new a8.b(22));
                List<Content> list2 = this.content;
                Objects.requireNonNull(list2);
                g0 g0Var = new g0(6);
                g0Var.f1963f = list2;
                VarHandle.storeStoreFence();
                map.forEach(g0Var);
                return this;
            }

            public Builder structuredContent(Object obj) {
                Assert.notNull(obj, "structuredContent must not be null");
                this.structuredContent = obj;
                return this;
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class CreateMessageResult extends androidx.activity.b implements Result {

        @JsonProperty("content")
        private final Content content;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("model")
        private final String model;

        @JsonProperty("role")
        private final Role role;

        @JsonProperty("stopReason")
        private final StopReason stopReason;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private Content content;
            private Map<String, Object> meta;
            private String model;
            private Role role = Role.ASSISTANT;
            private StopReason stopReason = StopReason.END_TURN;

            public CreateMessageResult build() {
                return new CreateMessageResult(this.role, this.content, this.model, this.stopReason, this.meta);
            }

            public Builder content(Content content) {
                this.content = content;
                return this;
            }

            public Builder message(String str) {
                this.content = new TextContent(str);
                return this;
            }

            public Builder meta(Map<String, Object> map) {
                this.meta = map;
                return this;
            }

            public Builder model(String str) {
                this.model = str;
                return this;
            }

            public Builder role(Role role) {
                this.role = role;
                return this;
            }

            public Builder stopReason(StopReason stopReason) {
                this.stopReason = stopReason;
                return this;
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public enum StopReason {
            END_TURN("endTurn"),
            STOP_SEQUENCE("stopSequence"),
            MAX_TOKENS("maxTokens"),
            UNKNOWN("unknown");

            private final String value;

            StopReason(String str) {
                this.value = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ boolean lambda$of$0(String str, StopReason stopReason) {
                return stopReason.value.equals(str);
            }

            @JsonCreator
            private static StopReason of(String str) {
                Stream stream = Arrays.stream(values());
                u0 u0Var = new u0(2);
                u0Var.f2028f = str;
                VarHandle.storeStoreFence();
                return (StopReason) stream.filter(u0Var).findFirst().orElse(UNKNOWN);
            }
        }

        public CreateMessageResult(@JsonProperty("role") Role role, @JsonProperty("content") Content content, @JsonProperty("model") String str, @JsonProperty("stopReason") StopReason stopReason, @JsonProperty("_meta") Map<String, Object> map) {
            this.role = role;
            this.content = content;
            this.model = str;
            this.stopReason = stopReason;
            this.meta = map;
        }

        public static Builder builder() {
            return new Builder();
        }

        @JsonProperty("content")
        public Content content() {
            return this.content;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof CreateMessageResult)) {
                return false;
            }
            CreateMessageResult createMessageResult = (CreateMessageResult) obj;
            return Objects.equals(this.role, createMessageResult.role) && Objects.equals(this.content, createMessageResult.content) && Objects.equals(this.model, createMessageResult.model) && Objects.equals(this.stopReason, createMessageResult.stopReason) && Objects.equals(this.meta, createMessageResult.meta);
        }

        public final int hashCode() {
            Role role = this.role;
            Content content = this.content;
            String str = this.model;
            StopReason stopReason = this.stopReason;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + ((Objects.hashCode(stopReason) + androidx.activity.b.w((Objects.hashCode(content) + (Objects.hashCode(role) * 31)) * 31, 31, str)) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("model")
        public String model() {
            return this.model;
        }

        @JsonProperty("role")
        public Role role() {
            return this.role;
        }

        @JsonProperty("stopReason")
        public StopReason stopReason() {
            return this.stopReason;
        }

        public final String toString() {
            Object[] objArr = {this.role, this.content, this.model, this.stopReason, this.meta};
            String[] strArrSplit = "role;content;model;stopReason;meta".length() == 0 ? new String[0] : "role;content;model;stopReason;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, CreateMessageResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public CreateMessageResult(Role role, Content content, String str, StopReason stopReason) {
            this(role, content, str, stopReason, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class InitializeResult extends androidx.activity.b implements Result {

        @JsonProperty("capabilities")
        private final ServerCapabilities capabilities;

        @JsonProperty("instructions")
        private final String instructions;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("protocolVersion")
        private final String protocolVersion;

        @JsonProperty("serverInfo")
        private final Implementation serverInfo;

        public InitializeResult(@JsonProperty("protocolVersion") String str, @JsonProperty("capabilities") ServerCapabilities serverCapabilities, @JsonProperty("serverInfo") Implementation implementation, @JsonProperty("instructions") String str2, @JsonProperty("_meta") Map<String, Object> map) {
            this.protocolVersion = str;
            this.capabilities = serverCapabilities;
            this.serverInfo = implementation;
            this.instructions = str2;
            this.meta = map;
        }

        @JsonProperty("capabilities")
        public ServerCapabilities capabilities() {
            return this.capabilities;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof InitializeResult)) {
                return false;
            }
            InitializeResult initializeResult = (InitializeResult) obj;
            return Objects.equals(this.protocolVersion, initializeResult.protocolVersion) && Objects.equals(this.capabilities, initializeResult.capabilities) && Objects.equals(this.serverInfo, initializeResult.serverInfo) && Objects.equals(this.instructions, initializeResult.instructions) && Objects.equals(this.meta, initializeResult.meta);
        }

        public final int hashCode() {
            String str = this.protocolVersion;
            ServerCapabilities serverCapabilities = this.capabilities;
            Implementation implementation = this.serverInfo;
            String str2 = this.instructions;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w((Objects.hashCode(implementation) + ((Objects.hashCode(serverCapabilities) + (Objects.hashCode(str) * 31)) * 31)) * 31, 31, str2);
        }

        @JsonProperty("instructions")
        public String instructions() {
            return this.instructions;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("protocolVersion")
        public String protocolVersion() {
            return this.protocolVersion;
        }

        @JsonProperty("serverInfo")
        public Implementation serverInfo() {
            return this.serverInfo;
        }

        public final String toString() {
            Object[] objArr = {this.protocolVersion, this.capabilities, this.serverInfo, this.instructions, this.meta};
            String[] strArrSplit = "protocolVersion;capabilities;serverInfo;instructions;meta".length() == 0 ? new String[0] : "protocolVersion;capabilities;serverInfo;instructions;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, InitializeResult.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public InitializeResult(String str, ServerCapabilities serverCapabilities, Implementation implementation, String str2) {
            this(str, serverCapabilities, implementation, str2, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ProgressNotification extends androidx.activity.b implements Notification {

        @JsonProperty("message")
        private final String message;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("progress")
        private final Double progress;

        @JsonProperty("progressToken")
        private final Object progressToken;

        @JsonProperty("total")
        private final Double total;

        public ProgressNotification(@JsonProperty("progressToken") Object obj, @JsonProperty("progress") Double d7, @JsonProperty("total") Double d10, @JsonProperty("message") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.progressToken = obj;
            this.progress = d7;
            this.total = d10;
            this.message = str;
            this.meta = map;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ProgressNotification)) {
                return false;
            }
            ProgressNotification progressNotification = (ProgressNotification) obj;
            return Objects.equals(this.progressToken, progressNotification.progressToken) && Objects.equals(this.progress, progressNotification.progress) && Objects.equals(this.total, progressNotification.total) && Objects.equals(this.message, progressNotification.message) && Objects.equals(this.meta, progressNotification.meta);
        }

        public final int hashCode() {
            Object obj = this.progressToken;
            Double d7 = this.progress;
            Double d10 = this.total;
            String str = this.message;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w((Objects.hashCode(d10) + ((Objects.hashCode(d7) + (Objects.hashCode(obj) * 31)) * 31)) * 31, 31, str);
        }

        @JsonProperty("message")
        public String message() {
            return this.message;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("progress")
        public Double progress() {
            return this.progress;
        }

        @JsonProperty("progressToken")
        public Object progressToken() {
            return this.progressToken;
        }

        public final String toString() {
            Object[] objArr = {this.progressToken, this.progress, this.total, this.message, this.meta};
            String[] strArrSplit = "progressToken;progress;total;message;meta".length() == 0 ? new String[0] : "progressToken;progress;total;message;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ProgressNotification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @JsonProperty("total")
        public Double total() {
            return this.total;
        }

        public ProgressNotification(Object obj, double d7, Double d10, String str) {
            this(obj, Double.valueOf(d7), d10, str, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class EmbeddedResource extends androidx.activity.b implements Annotated, Content {

        @JsonProperty("annotations")
        private final Annotations annotations;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("resource")
        private final ResourceContents resource;

        @Deprecated
        public EmbeddedResource(List<Role> list, Double d7, ResourceContents resourceContents) {
            this((list == null && d7 == null) ? null : new Annotations(list, d7), resourceContents, (Map<String, Object>) null);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Annotated
        @JsonProperty("annotations")
        public Annotations annotations() {
            return this.annotations;
        }

        @Deprecated
        public List<Role> audience() {
            Annotations annotations = this.annotations;
            if (annotations == null) {
                return null;
            }
            return annotations.audience();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof EmbeddedResource)) {
                return false;
            }
            EmbeddedResource embeddedResource = (EmbeddedResource) obj;
            return Objects.equals(this.annotations, embeddedResource.annotations) && Objects.equals(this.resource, embeddedResource.resource) && Objects.equals(this.meta, embeddedResource.meta);
        }

        public final int hashCode() {
            Annotations annotations = this.annotations;
            ResourceContents resourceContents = this.resource;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + ((Objects.hashCode(resourceContents) + (Objects.hashCode(annotations) * 31)) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @Deprecated
        public Double priority() {
            Annotations annotations = this.annotations;
            if (annotations == null) {
                return null;
            }
            return annotations.priority();
        }

        @JsonProperty("resource")
        public ResourceContents resource() {
            return this.resource;
        }

        public final String toString() {
            Object[] objArr = {this.annotations, this.resource, this.meta};
            String[] strArrSplit = "annotations;resource;meta".length() == 0 ? new String[0] : "annotations;resource;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, EmbeddedResource.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public EmbeddedResource(Annotations annotations, ResourceContents resourceContents) {
            this(annotations, resourceContents, (Map<String, Object>) null);
        }

        public EmbeddedResource(@JsonProperty("annotations") Annotations annotations, @JsonProperty("resource") ResourceContents resourceContents, @JsonProperty("_meta") Map<String, Object> map) {
            this.annotations = annotations;
            this.resource = resourceContents;
            this.meta = map;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ImageContent extends androidx.activity.b implements Annotated, Content {

        @JsonProperty("annotations")
        private final Annotations annotations;

        @JsonProperty("data")
        private final String data;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("mimeType")
        private final String mimeType;

        @Deprecated
        public ImageContent(List<Role> list, Double d7, String str, String str2) {
            this((list == null && d7 == null) ? null : new Annotations(list, d7), str, str2, (Map<String, Object>) null);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Annotated
        @JsonProperty("annotations")
        public Annotations annotations() {
            return this.annotations;
        }

        @Deprecated
        public List<Role> audience() {
            Annotations annotations = this.annotations;
            if (annotations == null) {
                return null;
            }
            return annotations.audience();
        }

        @JsonProperty("data")
        public String data() {
            return this.data;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ImageContent)) {
                return false;
            }
            ImageContent imageContent = (ImageContent) obj;
            return Objects.equals(this.annotations, imageContent.annotations) && Objects.equals(this.data, imageContent.data) && Objects.equals(this.mimeType, imageContent.mimeType) && Objects.equals(this.meta, imageContent.meta);
        }

        public final int hashCode() {
            Annotations annotations = this.annotations;
            String str = this.data;
            String str2 = this.mimeType;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(androidx.activity.b.w(Objects.hashCode(annotations) * 31, 31, str), 31, str2);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("mimeType")
        public String mimeType() {
            return this.mimeType;
        }

        @Deprecated
        public Double priority() {
            Annotations annotations = this.annotations;
            if (annotations == null) {
                return null;
            }
            return annotations.priority();
        }

        public final String toString() {
            Object[] objArr = {this.annotations, this.data, this.mimeType, this.meta};
            String[] strArrSplit = "annotations;data;mimeType;meta".length() == 0 ? new String[0] : "annotations;data;mimeType;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ImageContent.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public ImageContent(Annotations annotations, String str, String str2) {
            this(annotations, str, str2, (Map<String, Object>) null);
        }

        public ImageContent(@JsonProperty("annotations") Annotations annotations, @JsonProperty("data") String str, @JsonProperty("mimeType") String str2, @JsonProperty("_meta") Map<String, Object> map) {
            this.annotations = annotations;
            this.data = str;
            this.mimeType = str2;
            this.meta = map;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class TextContent extends androidx.activity.b implements Annotated, Content {

        @JsonProperty("annotations")
        private final Annotations annotations;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("text")
        private final String text;

        @Deprecated
        public TextContent(List<Role> list, Double d7, String str) {
            this((list == null && d7 == null) ? null : new Annotations(list, d7), str, (Map<String, Object>) null);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Annotated
        @JsonProperty("annotations")
        public Annotations annotations() {
            return this.annotations;
        }

        @Deprecated
        public List<Role> audience() {
            Annotations annotations = this.annotations;
            if (annotations == null) {
                return null;
            }
            return annotations.audience();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof TextContent)) {
                return false;
            }
            TextContent textContent = (TextContent) obj;
            return Objects.equals(this.annotations, textContent.annotations) && Objects.equals(this.text, textContent.text) && Objects.equals(this.meta, textContent.meta);
        }

        public final int hashCode() {
            Annotations annotations = this.annotations;
            String str = this.text;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.w(Objects.hashCode(annotations) * 31, 31, str);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @Deprecated
        public Double priority() {
            Annotations annotations = this.annotations;
            if (annotations == null) {
                return null;
            }
            return annotations.priority();
        }

        @JsonProperty("text")
        public String text() {
            return this.text;
        }

        public final String toString() {
            Object[] objArr = {this.annotations, this.text, this.meta};
            String[] strArrSplit = "annotations;text;meta".length() == 0 ? new String[0] : "annotations;text;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, TextContent.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public TextContent(Annotations annotations, String str) {
            this(annotations, str, (Map<String, Object>) null);
        }

        public TextContent(String str) {
            this((Annotations) null, str, (Map<String, Object>) null);
        }

        public TextContent(@JsonProperty("annotations") Annotations annotations, @JsonProperty("text") String str, @JsonProperty("_meta") Map<String, Object> map) {
            this.annotations = annotations;
            this.text = str;
            this.meta = map;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class ResourceTemplate extends androidx.activity.b implements Annotated, Identifier, Meta {

        @JsonProperty("annotations")
        private final Annotations annotations;

        @JsonProperty("description")
        private final String description;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("mimeType")
        private final String mimeType;

        @JsonProperty("name")
        private final String name;

        @JsonProperty("title")
        private final String title;

        @JsonProperty("uriTemplate")
        private final String uriTemplate;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private Annotations annotations;
            private String description;
            private Map<String, Object> meta;
            private String mimeType;
            private String name;
            private String title;
            private String uriTemplate;

            public Builder annotations(Annotations annotations) {
                this.annotations = annotations;
                return this;
            }

            public ResourceTemplate build() {
                Assert.hasText(this.uriTemplate, "uri must not be empty");
                Assert.hasText(this.name, "name must not be empty");
                return new ResourceTemplate(this.uriTemplate, this.name, this.title, this.description, this.mimeType, this.annotations, this.meta);
            }

            public Builder description(String str) {
                this.description = str;
                return this;
            }

            public Builder meta(Map<String, Object> map) {
                this.meta = map;
                return this;
            }

            public Builder mimeType(String str) {
                this.mimeType = str;
                return this;
            }

            public Builder name(String str) {
                this.name = str;
                return this;
            }

            public Builder title(String str) {
                this.title = str;
                return this;
            }

            public Builder uriTemplate(String str) {
                this.uriTemplate = str;
                return this;
            }
        }

        public ResourceTemplate(@JsonProperty("uriTemplate") String str, @JsonProperty("name") String str2, @JsonProperty("title") String str3, @JsonProperty("description") String str4, @JsonProperty("mimeType") String str5, @JsonProperty("annotations") Annotations annotations, @JsonProperty("_meta") Map<String, Object> map) {
            this.uriTemplate = str;
            this.name = str2;
            this.title = str3;
            this.description = str4;
            this.mimeType = str5;
            this.annotations = annotations;
            this.meta = map;
        }

        public static Builder builder() {
            return new Builder();
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Annotated
        @JsonProperty("annotations")
        public Annotations annotations() {
            return this.annotations;
        }

        @JsonProperty("description")
        public String description() {
            return this.description;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ResourceTemplate)) {
                return false;
            }
            ResourceTemplate resourceTemplate = (ResourceTemplate) obj;
            return Objects.equals(this.uriTemplate, resourceTemplate.uriTemplate) && Objects.equals(this.name, resourceTemplate.name) && Objects.equals(this.title, resourceTemplate.title) && Objects.equals(this.description, resourceTemplate.description) && Objects.equals(this.mimeType, resourceTemplate.mimeType) && Objects.equals(this.annotations, resourceTemplate.annotations) && Objects.equals(this.meta, resourceTemplate.meta);
        }

        public final int hashCode() {
            String str = this.uriTemplate;
            String str2 = this.name;
            String str3 = this.title;
            String str4 = this.description;
            String str5 = this.mimeType;
            Annotations annotations = this.annotations;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + ((Objects.hashCode(annotations) + androidx.activity.b.w(androidx.activity.b.w(androidx.activity.b.w(androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2), 31, str3), 31, str4), 31, str5)) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("mimeType")
        public String mimeType() {
            return this.mimeType;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("title")
        public String title() {
            return this.title;
        }

        public final String toString() {
            Object[] objArr = {this.uriTemplate, this.name, this.title, this.description, this.mimeType, this.annotations, this.meta};
            String[] strArrSplit = "uriTemplate;name;title;description;mimeType;annotations;meta".length() == 0 ? new String[0] : "uriTemplate;name;title;description;mimeType;annotations;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, ResourceTemplate.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @JsonProperty("uriTemplate")
        public String uriTemplate() {
            return this.uriTemplate;
        }

        public ResourceTemplate(String str, String str2, String str3, String str4, String str5, Annotations annotations) {
            this(str, str2, str3, str4, str5, annotations, null);
        }

        public ResourceTemplate(String str, String str2, String str3, String str4, Annotations annotations) {
            this(str, str2, null, str3, str4, annotations);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class Prompt extends androidx.activity.b implements Identifier {

        @JsonProperty("arguments")
        private final List<PromptArgument> arguments;

        @JsonProperty("description")
        private final String description;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("name")
        private final String name;

        @JsonProperty("title")
        private final String title;

        public Prompt(String str, String str2, String str3, List<PromptArgument> list) {
            this(str, str2, str3, list == null ? new ArrayList<>() : list, null);
        }

        @JsonProperty("arguments")
        public List<PromptArgument> arguments() {
            return this.arguments;
        }

        @JsonProperty("description")
        public String description() {
            return this.description;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Prompt)) {
                return false;
            }
            Prompt prompt = (Prompt) obj;
            return Objects.equals(this.name, prompt.name) && Objects.equals(this.title, prompt.title) && Objects.equals(this.description, prompt.description) && Objects.equals(this.arguments, prompt.arguments) && Objects.equals(this.meta, prompt.meta);
        }

        public final int hashCode() {
            String str = this.name;
            String str2 = this.title;
            String str3 = this.description;
            List<PromptArgument> list = this.arguments;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + androidx.activity.b.x(list, androidx.activity.b.w(androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2), 31, str3), 31);
        }

        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("title")
        public String title() {
            return this.title;
        }

        public final String toString() {
            Object[] objArr = {this.name, this.title, this.description, this.arguments, this.meta};
            String[] strArrSplit = "name;title;description;arguments;meta".length() == 0 ? new String[0] : "name;title;description;arguments;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, Prompt.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public Prompt(String str, String str2, List<PromptArgument> list) {
            this(str, null, str2, list == null ? new ArrayList<>() : list);
        }

        public Prompt(@JsonProperty("name") String str, @JsonProperty("title") String str2, @JsonProperty("description") String str3, @JsonProperty("arguments") List<PromptArgument> list, @JsonProperty("_meta") Map<String, Object> map) {
            this.name = str;
            this.title = str2;
            this.description = str3;
            this.arguments = list;
            this.meta = map;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class Resource extends androidx.activity.b implements ResourceContent {

        @JsonProperty("annotations")
        private final Annotations annotations;

        @JsonProperty("description")
        private final String description;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("mimeType")
        private final String mimeType;

        @JsonProperty("name")
        private final String name;

        @JsonProperty("size")
        private final Long size;

        @JsonProperty("title")
        private final String title;

        @JsonProperty("uri")
        private final String uri;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private Annotations annotations;
            private String description;
            private Map<String, Object> meta;
            private String mimeType;
            private String name;
            private Long size;
            private String title;
            private String uri;

            public Builder annotations(Annotations annotations) {
                this.annotations = annotations;
                return this;
            }

            public Resource build() {
                Assert.hasText(this.uri, "uri must not be empty");
                Assert.hasText(this.name, "name must not be empty");
                return new Resource(this.uri, this.name, this.title, this.description, this.mimeType, this.size, this.annotations, this.meta);
            }

            public Builder description(String str) {
                this.description = str;
                return this;
            }

            public Builder meta(Map<String, Object> map) {
                this.meta = map;
                return this;
            }

            public Builder mimeType(String str) {
                this.mimeType = str;
                return this;
            }

            public Builder name(String str) {
                this.name = str;
                return this;
            }

            public Builder size(Long l2) {
                this.size = l2;
                return this;
            }

            public Builder title(String str) {
                this.title = str;
                return this;
            }

            public Builder uri(String str) {
                this.uri = str;
                return this;
            }
        }

        public Resource(@JsonProperty("uri") String str, @JsonProperty("name") String str2, @JsonProperty("title") String str3, @JsonProperty("description") String str4, @JsonProperty("mimeType") String str5, @JsonProperty("size") Long l2, @JsonProperty("annotations") Annotations annotations, @JsonProperty("_meta") Map<String, Object> map) {
            this.uri = str;
            this.name = str2;
            this.title = str3;
            this.description = str4;
            this.mimeType = str5;
            this.size = l2;
            this.annotations = annotations;
            this.meta = map;
        }

        public static Builder builder() {
            return new Builder();
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Annotated
        @JsonProperty("annotations")
        public Annotations annotations() {
            return this.annotations;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContent
        @JsonProperty("description")
        public String description() {
            return this.description;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Resource)) {
                return false;
            }
            Resource resource = (Resource) obj;
            return Objects.equals(this.uri, resource.uri) && Objects.equals(this.name, resource.name) && Objects.equals(this.title, resource.title) && Objects.equals(this.description, resource.description) && Objects.equals(this.mimeType, resource.mimeType) && Objects.equals(this.size, resource.size) && Objects.equals(this.annotations, resource.annotations) && Objects.equals(this.meta, resource.meta);
        }

        public final int hashCode() {
            String str = this.uri;
            String str2 = this.name;
            String str3 = this.title;
            String str4 = this.description;
            String str5 = this.mimeType;
            Long l2 = this.size;
            Annotations annotations = this.annotations;
            Map<String, Object> map = this.meta;
            return Objects.hashCode(map) + ((Objects.hashCode(annotations) + ((Objects.hashCode(l2) + androidx.activity.b.w(androidx.activity.b.w(androidx.activity.b.w(androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2), 31, str3), 31, str4), 31, str5)) * 31)) * 31);
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContent
        @JsonProperty("mimeType")
        public String mimeType() {
            return this.mimeType;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("name")
        public String name() {
            return this.name;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContent
        @JsonProperty("size")
        public Long size() {
            return this.size;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Identifier
        @JsonProperty("title")
        public String title() {
            return this.title;
        }

        public final String toString() {
            Object[] objArr = {this.uri, this.name, this.title, this.description, this.mimeType, this.size, this.annotations, this.meta};
            String[] strArrSplit = "uri;name;title;description;mimeType;size;annotations;meta".length() == 0 ? new String[0] : "uri;name;title;description;mimeType;size;annotations;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, Resource.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.ResourceContent
        @JsonProperty("uri")
        public String uri() {
            return this.uri;
        }

        @Deprecated
        public Resource(String str, String str2, String str3, String str4, String str5, Long l2, Annotations annotations) {
            this(str, str2, str3, str4, str5, l2, annotations, null);
        }

        @Deprecated
        public Resource(String str, String str2, String str3, String str4, Long l2, Annotations annotations) {
            this(str, str2, null, str3, str4, l2, annotations, null);
        }

        @Deprecated
        public Resource(String str, String str2, String str3, String str4, Annotations annotations) {
            this(str, str2, null, str3, str4, null, annotations, null);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public static final class CreateMessageRequest extends androidx.activity.b implements Request {

        @JsonProperty("includeContext")
        private final ContextInclusionStrategy includeContext;

        @JsonProperty("maxTokens")
        private final Integer maxTokens;

        @JsonProperty("messages")
        private final List<SamplingMessage> messages;

        @JsonProperty("_meta")
        private final Map<String, Object> meta;

        @JsonProperty("metadata")
        private final Map<String, Object> metadata;

        @JsonProperty("modelPreferences")
        private final ModelPreferences modelPreferences;

        @JsonProperty("stopSequences")
        private final List<String> stopSequences;

        @JsonProperty("systemPrompt")
        private final String systemPrompt;

        @JsonProperty("temperature")
        private final Double temperature;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private ContextInclusionStrategy includeContext;
            private Integer maxTokens;
            private List<SamplingMessage> messages;
            private Map<String, Object> meta;
            private Map<String, Object> metadata;
            private ModelPreferences modelPreferences;
            private List<String> stopSequences;
            private String systemPrompt;
            private Double temperature;

            public CreateMessageRequest build() {
                return new CreateMessageRequest(this.messages, this.modelPreferences, this.systemPrompt, this.includeContext, this.temperature, this.maxTokens, this.stopSequences, this.metadata, this.meta);
            }

            public Builder includeContext(ContextInclusionStrategy contextInclusionStrategy) {
                this.includeContext = contextInclusionStrategy;
                return this;
            }

            public Builder maxTokens(int i) {
                this.maxTokens = Integer.valueOf(i);
                return this;
            }

            public Builder messages(List<SamplingMessage> list) {
                this.messages = list;
                return this;
            }

            public Builder meta(Map<String, Object> map) {
                this.meta = map;
                return this;
            }

            public Builder metadata(Map<String, Object> map) {
                this.metadata = map;
                return this;
            }

            public Builder modelPreferences(ModelPreferences modelPreferences) {
                this.modelPreferences = modelPreferences;
                return this;
            }

            public Builder progressToken(Object obj) {
                if (this.meta == null) {
                    this.meta = new HashMap();
                }
                this.meta.put("progressToken", obj);
                return this;
            }

            public Builder stopSequences(List<String> list) {
                this.stopSequences = list;
                return this;
            }

            public Builder systemPrompt(String str) {
                this.systemPrompt = str;
                return this;
            }

            public Builder temperature(Double d7) {
                this.temperature = d7;
                return this;
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public enum ContextInclusionStrategy {
            NONE,
            THIS_SERVER,
            ALL_SERVERS
        }

        public CreateMessageRequest(@JsonProperty("messages") List<SamplingMessage> list, @JsonProperty("modelPreferences") ModelPreferences modelPreferences, @JsonProperty("systemPrompt") String str, @JsonProperty("includeContext") ContextInclusionStrategy contextInclusionStrategy, @JsonProperty("temperature") Double d7, @JsonProperty("maxTokens") Integer num, @JsonProperty("stopSequences") List<String> list2, @JsonProperty("metadata") Map<String, Object> map, @JsonProperty("_meta") Map<String, Object> map2) {
            this.messages = list;
            this.modelPreferences = modelPreferences;
            this.systemPrompt = str;
            this.includeContext = contextInclusionStrategy;
            this.temperature = d7;
            this.maxTokens = num;
            this.stopSequences = list2;
            this.metadata = map;
            this.meta = map2;
        }

        public static Builder builder() {
            return new Builder();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof CreateMessageRequest)) {
                return false;
            }
            CreateMessageRequest createMessageRequest = (CreateMessageRequest) obj;
            return Objects.equals(this.messages, createMessageRequest.messages) && Objects.equals(this.modelPreferences, createMessageRequest.modelPreferences) && Objects.equals(this.systemPrompt, createMessageRequest.systemPrompt) && Objects.equals(this.includeContext, createMessageRequest.includeContext) && Objects.equals(this.temperature, createMessageRequest.temperature) && Objects.equals(this.maxTokens, createMessageRequest.maxTokens) && Objects.equals(this.stopSequences, createMessageRequest.stopSequences) && Objects.equals(this.metadata, createMessageRequest.metadata) && Objects.equals(this.meta, createMessageRequest.meta);
        }

        public final int hashCode() {
            List<SamplingMessage> list = this.messages;
            ModelPreferences modelPreferences = this.modelPreferences;
            String str = this.systemPrompt;
            ContextInclusionStrategy contextInclusionStrategy = this.includeContext;
            Double d7 = this.temperature;
            Integer num = this.maxTokens;
            List<String> list2 = this.stopSequences;
            Map<String, Object> map = this.metadata;
            Map<String, Object> map2 = this.meta;
            return Objects.hashCode(map2) + androidx.activity.b.f(map, androidx.activity.b.x(list2, (Objects.hashCode(num) + ((Objects.hashCode(d7) + ((Objects.hashCode(contextInclusionStrategy) + androidx.activity.b.w((Objects.hashCode(modelPreferences) + (Objects.hashCode(list) * 31)) * 31, 31, str)) * 31)) * 31)) * 31, 31), 31);
        }

        @JsonProperty("includeContext")
        public ContextInclusionStrategy includeContext() {
            return this.includeContext;
        }

        @JsonProperty("maxTokens")
        public Integer maxTokens() {
            return this.maxTokens;
        }

        @JsonProperty("messages")
        public List<SamplingMessage> messages() {
            return this.messages;
        }

        @Override // io.modelcontextprotocol.spec.McpSchema.Meta
        @JsonProperty("_meta")
        public Map<String, Object> meta() {
            return this.meta;
        }

        @JsonProperty("metadata")
        public Map<String, Object> metadata() {
            return this.metadata;
        }

        @JsonProperty("modelPreferences")
        public ModelPreferences modelPreferences() {
            return this.modelPreferences;
        }

        @JsonProperty("stopSequences")
        public List<String> stopSequences() {
            return this.stopSequences;
        }

        @JsonProperty("systemPrompt")
        public String systemPrompt() {
            return this.systemPrompt;
        }

        @JsonProperty("temperature")
        public Double temperature() {
            return this.temperature;
        }

        public final String toString() {
            Object[] objArr = {this.messages, this.modelPreferences, this.systemPrompt, this.includeContext, this.temperature, this.maxTokens, this.stopSequences, this.metadata, this.meta};
            String[] strArrSplit = "messages;modelPreferences;systemPrompt;includeContext;temperature;maxTokens;stopSequences;metadata;meta".length() == 0 ? new String[0] : "messages;modelPreferences;systemPrompt;includeContext;temperature;maxTokens;stopSequences;metadata;meta".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, CreateMessageRequest.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public CreateMessageRequest(List<SamplingMessage> list, ModelPreferences modelPreferences, String str, ContextInclusionStrategy contextInclusionStrategy, Double d7, Integer num, List<String> list2, Map<String, Object> map) {
            this(list, modelPreferences, str, contextInclusionStrategy, d7, num, list2, map, null);
        }
    }
}
