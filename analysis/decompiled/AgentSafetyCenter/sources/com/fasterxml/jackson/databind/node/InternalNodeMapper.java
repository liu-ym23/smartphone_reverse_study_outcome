package com.fasterxml.jackson.databind.node;

import ad.o;
import androidx.activity.b;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class InternalNodeMapper {
    private static final JsonMapper JSON_MAPPER;
    private static final ObjectReader NODE_READER;
    private static final ObjectWriter PRETTY_WRITER;
    private static final ObjectWriter STD_WRITER;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class IteratorStack {
        private int _end;
        private Iterator<?>[] _stack;
        private int _top;

        public Iterator<?> popOrNull() {
            int i = this._top;
            if (i == 0) {
                return null;
            }
            Iterator<?>[] itArr = this._stack;
            int i3 = i - 1;
            this._top = i3;
            return itArr[i3];
        }

        public void push(Iterator<?> it) {
            int i = this._top;
            int i3 = this._end;
            Iterator<?>[] itArr = this._stack;
            if (i < i3) {
                this._top = i + 1;
                itArr[i] = it;
                return;
            }
            if (itArr == null) {
                this._end = 10;
                this._stack = new Iterator[10];
            } else {
                int iMin = Math.min(4000, Math.max(20, i3 >> 1)) + i3;
                this._end = iMin;
                this._stack = (Iterator[]) Arrays.copyOf(this._stack, iMin);
            }
            Iterator<?>[] itArr2 = this._stack;
            int i10 = this._top;
            this._top = i10 + 1;
            itArr2[i10] = it;
        }
    }

    static {
        JsonMapper jsonMapper = new JsonMapper();
        JSON_MAPPER = jsonMapper;
        STD_WRITER = jsonMapper.writer();
        PRETTY_WRITER = jsonMapper.writer().withDefaultPrettyPrinter();
        NODE_READER = jsonMapper.readerFor(JsonNode.class);
    }

    private static JsonSerializable _wrapper(BaseJsonNode baseJsonNode) {
        return new WrapperForSerializer(baseJsonNode);
    }

    public static JsonNode bytesToNode(byte[] bArr) {
        return (JsonNode) NODE_READER.readValue(bArr);
    }

    public static String nodeToPrettyString(BaseJsonNode baseJsonNode) {
        try {
            return PRETTY_WRITER.writeValueAsString(_wrapper(baseJsonNode));
        } catch (IOException e10) {
            o.h(e10);
            return null;
        }
    }

    public static String nodeToString(BaseJsonNode baseJsonNode) {
        try {
            return STD_WRITER.writeValueAsString(_wrapper(baseJsonNode));
        } catch (IOException e10) {
            o.h(e10);
            return null;
        }
    }

    public static byte[] valueToBytes(Object obj) {
        return JSON_MAPPER.writeValueAsBytes(obj);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class WrapperForSerializer extends JsonSerializable.Base {
        protected SerializerProvider _context;
        protected final BaseJsonNode _root;

        public WrapperForSerializer(BaseJsonNode baseJsonNode) {
            this._root = baseJsonNode;
        }

        public void _serializeNonRecursive(JsonGenerator jsonGenerator, IteratorStack iteratorStack, Iterator<?> it) {
            JsonNode jsonNode;
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) next;
                        jsonGenerator.writeFieldName((String) entry.getKey());
                        jsonNode = (JsonNode) entry.getValue();
                    } else {
                        jsonNode = (JsonNode) next;
                    }
                    if (jsonNode instanceof ObjectNode) {
                        iteratorStack.push(it);
                        it = jsonNode.properties().iterator();
                        jsonGenerator.writeStartObject(jsonNode, jsonNode.size());
                    } else if (jsonNode instanceof ArrayNode) {
                        iteratorStack.push(it);
                        it = jsonNode.elements();
                        jsonGenerator.writeStartArray(jsonNode, jsonNode.size());
                    } else {
                        boolean z10 = jsonNode instanceof POJONode;
                        SerializerProvider serializerProvider = this._context;
                        if (z10) {
                            try {
                                jsonNode.serialize(jsonGenerator, serializerProvider);
                            } catch (IOException | RuntimeException e10) {
                                jsonGenerator.writeString(b.k("[ERROR: (", e10.getClass().getName(), ") ", e10.getMessage(), "]"));
                            }
                        } else {
                            jsonNode.serialize(jsonGenerator, serializerProvider);
                        }
                    }
                } else {
                    if (jsonGenerator.getOutputContext().inArray()) {
                        jsonGenerator.writeEndArray();
                    } else {
                        jsonGenerator.writeEndObject();
                    }
                    it = iteratorStack.popOrNull();
                    if (it == null) {
                        return;
                    }
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.JsonSerializable
        public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            this._context = serializerProvider;
            _serializeNonRecursive(jsonGenerator, this._root);
        }

        @Override // com.fasterxml.jackson.databind.JsonSerializable
        public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            serialize(jsonGenerator, serializerProvider);
        }

        public void _serializeNonRecursive(JsonGenerator jsonGenerator, JsonNode jsonNode) {
            if (jsonNode instanceof ObjectNode) {
                jsonGenerator.writeStartObject(this, jsonNode.size());
                _serializeNonRecursive(jsonGenerator, new IteratorStack(), jsonNode.properties().iterator());
            } else if (jsonNode instanceof ArrayNode) {
                jsonGenerator.writeStartArray(this, jsonNode.size());
                _serializeNonRecursive(jsonGenerator, new IteratorStack(), jsonNode.elements());
            } else {
                jsonNode.serialize(jsonGenerator, this._context);
            }
        }
    }
}
