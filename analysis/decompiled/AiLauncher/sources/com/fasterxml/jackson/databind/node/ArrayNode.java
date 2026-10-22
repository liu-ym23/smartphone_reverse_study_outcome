package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* loaded from: classes2.dex */
public class ArrayNode extends ContainerNode<ArrayNode> implements Serializable {
    private static final long serialVersionUID = 1;
    private final List<JsonNode> _children;

    public ArrayNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
        this._children = new ArrayList();
    }

    public ArrayNode _add(JsonNode jsonNode) {
        this._children.add(jsonNode);
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNode _at(JsonPointer jsonPointer) {
        return get(jsonPointer.getMatchingIndex());
    }

    public boolean _childrenEqual(ArrayNode arrayNode) {
        return this._children.equals(arrayNode._children);
    }

    public ArrayNode _insert(int i10, JsonNode jsonNode) {
        if (i10 < 0) {
            this._children.add(0, jsonNode);
            return this;
        }
        if (i10 >= this._children.size()) {
            this._children.add(jsonNode);
            return this;
        }
        this._children.add(i10, jsonNode);
        return this;
    }

    public ArrayNode _set(int i10, JsonNode jsonNode) {
        if (i10 >= 0 && i10 < this._children.size()) {
            this._children.set(i10, jsonNode);
            return this;
        }
        throw new IndexOutOfBoundsException("Illegal index " + i10 + ", array size " + size());
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public ArrayNode _withArray(JsonPointer jsonPointer, JsonPointer jsonPointer2, JsonNode.OverwriteMode overwriteMode, boolean z10) {
        ArrayNode arrayNode;
        JsonPointer jsonPointer3;
        boolean z11;
        if (jsonPointer2.matches()) {
            return this;
        }
        JsonNode jsonNode_at = _at(jsonPointer2);
        if (jsonNode_at == null || !(jsonNode_at instanceof BaseJsonNode)) {
            arrayNode = this;
            jsonPointer3 = jsonPointer2;
            z11 = z10;
        } else {
            ArrayNode arrayNode_withArray = ((BaseJsonNode) jsonNode_at)._withArray(jsonPointer, jsonPointer2.tail(), overwriteMode, z10);
            if (arrayNode_withArray != null) {
                return arrayNode_withArray;
            }
            arrayNode = this;
            jsonPointer3 = jsonPointer2;
            z11 = z10;
            arrayNode._withXxxVerifyReplace(jsonPointer, jsonPointer3, overwriteMode, z11, jsonNode_at);
        }
        return arrayNode._withArrayAddTailElement(jsonPointer3, z11);
    }

    public ArrayNode _withArrayAddTailElement(JsonPointer jsonPointer, boolean z10) {
        int matchingIndex = jsonPointer.getMatchingIndex();
        if (matchingIndex < 0) {
            return null;
        }
        JsonPointer jsonPointerTail = jsonPointer.tail();
        if (jsonPointerTail.matches()) {
            ArrayNode arrayNode = arrayNode();
            _withXxxSetArrayElement(matchingIndex, arrayNode);
            return arrayNode;
        }
        if (z10 && jsonPointerTail.mayMatchElement()) {
            ArrayNode arrayNode2 = arrayNode();
            _withXxxSetArrayElement(matchingIndex, arrayNode2);
            return arrayNode2._withArrayAddTailElement(jsonPointerTail, z10);
        }
        ObjectNode objectNode = objectNode();
        _withXxxSetArrayElement(matchingIndex, objectNode);
        return objectNode._withArrayAddTailProperty(jsonPointerTail, z10);
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.node.BaseJsonNode
    public ObjectNode _withObject(JsonPointer jsonPointer, JsonPointer jsonPointer2, JsonNode.OverwriteMode overwriteMode, boolean z10) {
        ArrayNode arrayNode;
        JsonPointer jsonPointer3;
        boolean z11;
        if (jsonPointer2.matches()) {
            return null;
        }
        JsonNode jsonNode_at = _at(jsonPointer2);
        if (jsonNode_at == null || !(jsonNode_at instanceof BaseJsonNode)) {
            arrayNode = this;
            jsonPointer3 = jsonPointer2;
            z11 = z10;
        } else {
            ObjectNode objectNode_withObject = ((BaseJsonNode) jsonNode_at)._withObject(jsonPointer, jsonPointer2.tail(), overwriteMode, z10);
            if (objectNode_withObject != null) {
                return objectNode_withObject;
            }
            arrayNode = this;
            jsonPointer3 = jsonPointer2;
            z11 = z10;
            arrayNode._withXxxVerifyReplace(jsonPointer, jsonPointer3, overwriteMode, z11, jsonNode_at);
        }
        return arrayNode._withObjectAddTailElement(jsonPointer3, z11);
    }

    public ObjectNode _withObjectAddTailElement(JsonPointer jsonPointer, boolean z10) {
        int matchingIndex = jsonPointer.getMatchingIndex();
        if (matchingIndex < 0) {
            return null;
        }
        JsonPointer jsonPointerTail = jsonPointer.tail();
        if (jsonPointerTail.matches()) {
            ObjectNode objectNode = objectNode();
            _withXxxSetArrayElement(matchingIndex, objectNode);
            return objectNode;
        }
        if (z10 && jsonPointerTail.mayMatchElement()) {
            ArrayNode arrayNode = arrayNode();
            _withXxxSetArrayElement(matchingIndex, arrayNode);
            return arrayNode._withObjectAddTailElement(jsonPointerTail, z10);
        }
        ObjectNode objectNode2 = objectNode();
        _withXxxSetArrayElement(matchingIndex, objectNode2);
        return objectNode2._withObjectAddTailProperty(jsonPointerTail, z10);
    }

    public void _withXxxSetArrayElement(int i10, JsonNode jsonNode) {
        if (i10 >= size()) {
            int maxElementIndexForInsert = this._nodeFactory.getMaxElementIndexForInsert();
            if (i10 > maxElementIndexForInsert) {
                _reportWrongNodeOperation("Too big Array index (%d; max %d) to use for insert with `JsonPointer`", Integer.valueOf(i10), Integer.valueOf(maxElementIndexForInsert));
            }
            while (i10 >= size()) {
                addNull();
            }
        }
        set(i10, jsonNode);
    }

    public ArrayNode add(JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        _add(jsonNode);
        return this;
    }

    public ArrayNode addAll(ArrayNode arrayNode) {
        this._children.addAll(arrayNode._children);
        return this;
    }

    public ArrayNode addArray() {
        ArrayNode arrayNode = arrayNode();
        _add(arrayNode);
        return arrayNode;
    }

    public ArrayNode addNull() {
        return _add(nullNode());
    }

    public ObjectNode addObject() {
        ObjectNode objectNode = objectNode();
        _add(objectNode);
        return objectNode;
    }

    public ArrayNode addPOJO(Object obj) {
        return _add(obj == null ? nullNode() : pojoNode(obj));
    }

    public ArrayNode addRawValue(RawValue rawValue) {
        return _add(rawValue == null ? nullNode() : rawValueNode(rawValue));
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonToken asToken() {
        return JsonToken.START_ARRAY;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public Iterator<JsonNode> elements() {
        return this._children.listIterator();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Comparator<JsonNode> comparator, JsonNode jsonNode) {
        if (!(jsonNode instanceof ArrayNode)) {
            return false;
        }
        ArrayNode arrayNode = (ArrayNode) jsonNode;
        int size = this._children.size();
        if (arrayNode.size() != size) {
            return false;
        }
        List<JsonNode> list = this._children;
        List<JsonNode> list2 = arrayNode._children;
        for (int i10 = 0; i10 < size; i10++) {
            if (!list.get(i10).equals(comparator, list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<JsonNode> findParents(String str, List<JsonNode> list) {
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            list = it.next().findParents(str, list);
        }
        return list;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNode findValue(String str) {
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            JsonNode jsonNodeFindValue = it.next().findValue(str);
            if (jsonNodeFindValue != null) {
                return jsonNodeFindValue;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<JsonNode> findValues(String str, List<JsonNode> list) {
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            list = it.next().findValues(str, list);
        }
        return list;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<String> findValuesAsText(String str, List<String> list) {
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            list = it.next().findValuesAsText(str, list);
        }
        return list;
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonNode get(String str) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNodeType getNodeType() {
        return JsonNodeType.ARRAY;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public int hashCode() {
        return this._children.hashCode();
    }

    public ArrayNode insert(int i10, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        _insert(i10, jsonNode);
        return this;
    }

    public ArrayNode insertArray(int i10) {
        ArrayNode arrayNode = arrayNode();
        _insert(i10, arrayNode);
        return arrayNode;
    }

    public ArrayNode insertNull(int i10) {
        return _insert(i10, nullNode());
    }

    public ObjectNode insertObject(int i10) {
        ObjectNode objectNode = objectNode();
        _insert(i10, objectNode);
        return objectNode;
    }

    public ArrayNode insertPOJO(int i10, Object obj) {
        return _insert(i10, obj == null ? nullNode() : pojoNode(obj));
    }

    public ArrayNode insertRawValue(int i10, RawValue rawValue) {
        return _insert(i10, rawValue == null ? nullNode() : rawValueNode(rawValue));
    }

    @Override // com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public boolean isArray() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializable.Base
    public boolean isEmpty(SerializerProvider serializerProvider) {
        return this._children.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public Optional<JsonNode> optional(int i10) {
        return Optional.ofNullable(get(i10));
    }

    public JsonNode remove(int i10) {
        if (i10 < 0 || i10 >= this._children.size()) {
            return null;
        }
        return this._children.remove(i10);
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode
    public /* bridge */ /* synthetic */ ContainerNode removeIf(Predicate predicate) {
        return removeIf((Predicate<? super JsonNode>) predicate);
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.JsonNode
    public JsonNode required(int i10) {
        return (i10 < 0 || i10 >= this._children.size()) ? (JsonNode) _reportRequiredViolation("No value at index #%d [0, %d) of `ArrayNode`", Integer.valueOf(i10), Integer.valueOf(this._children.size())) : this._children.get(i10);
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.JsonSerializable
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<JsonNode> list = this._children;
        int size = list.size();
        jsonGenerator.writeStartArray(this, size);
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).serialize(jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.JsonSerializable
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdWriteTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(this, JsonToken.START_ARRAY));
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            ((BaseJsonNode) it.next()).serialize(jsonGenerator, serializerProvider);
        }
        typeSerializer.writeTypeSuffix(jsonGenerator, writableTypeIdWriteTypePrefix);
    }

    public JsonNode set(int i10, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        if (i10 >= 0 && i10 < this._children.size()) {
            return this._children.set(i10, jsonNode);
        }
        throw new IndexOutOfBoundsException("Illegal index " + i10 + ", array size " + size());
    }

    public ArrayNode setNull(int i10) {
        return _set(i10, nullNode());
    }

    public ArrayNode setPOJO(int i10, Object obj) {
        return _set(i10, obj == null ? nullNode() : pojoNode(obj));
    }

    public ArrayNode setRawValue(int i10, RawValue rawValue) {
        return _set(i10, rawValue == null ? nullNode() : rawValueNode(rawValue));
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public int size() {
        return this._children.size();
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode
    public Stream<JsonNode> valueStream() {
        return this._children.stream();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public Iterator<JsonNode> values() {
        return this._children.listIterator();
    }

    public ArrayNode addAll(Collection<? extends JsonNode> collection) {
        Iterator<? extends JsonNode> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ArrayNode deepCopy() {
        ArrayNode arrayNode = arrayNode(this._children.size());
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            arrayNode._children.add(it.next().deepCopy());
        }
        return arrayNode;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ObjectNode findParent(String str) {
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            JsonNode jsonNodeFindParent = it.next().findParent(str);
            if (jsonNodeFindParent != null) {
                return (ObjectNode) jsonNodeFindParent;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean isEmpty() {
        return this._children.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode
    public ArrayNode removeAll() {
        this._children.clear();
        return this;
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode
    public ArrayNode removeIf(Predicate<? super JsonNode> predicate) {
        this._children.removeIf(predicate);
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    @Deprecated
    public ObjectNode with(String str) {
        JsonPointer jsonPointer_jsonPointerIfValid = _jsonPointerIfValid(str);
        return jsonPointer_jsonPointerIfValid != null ? withObject(jsonPointer_jsonPointerIfValid) : (ObjectNode) super.with(str);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ArrayNode withArray(String str) {
        JsonPointer jsonPointer_jsonPointerIfValid = _jsonPointerIfValid(str);
        return jsonPointer_jsonPointerIfValid != null ? withArray(jsonPointer_jsonPointerIfValid) : (ArrayNode) super.withArray(str);
    }

    public ArrayNode(JsonNodeFactory jsonNodeFactory, int i10) {
        super(jsonNodeFactory);
        this._children = new ArrayList(i10);
    }

    public ArrayNode add(short s10) {
        return _add(numberNode(s10));
    }

    public ArrayNode insert(int i10, short s10) {
        return _insert(i10, numberNode(s10));
    }

    @Override // com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonNode path(String str) {
        return MissingNode.getInstance();
    }

    public ArrayNode add(Short sh) {
        return _add(sh == null ? nullNode() : numberNode(sh.shortValue()));
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonNode get(int i10) {
        if (i10 < 0 || i10 >= this._children.size()) {
            return null;
        }
        return this._children.get(i10);
    }

    public ArrayNode insert(int i10, Short sh) {
        return _insert(i10, sh == null ? nullNode() : numberNode(sh.shortValue()));
    }

    @Override // com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.core.TreeNode
    public JsonNode path(int i10) {
        if (i10 >= 0 && i10 < this._children.size()) {
            return this._children.get(i10);
        }
        return MissingNode.getInstance();
    }

    public ArrayNode(JsonNodeFactory jsonNodeFactory, List<JsonNode> list) {
        super(jsonNodeFactory);
        Objects.requireNonNull(list, "Must not pass `null` for 'children' argument");
        this._children = list;
    }

    public ArrayNode add(int i10) {
        return _add(numberNode(i10));
    }

    public ArrayNode insert(int i10, int i11) {
        return _insert(i10, numberNode(i11));
    }

    public ArrayNode set(int i10, short s10) {
        return _set(i10, numberNode(s10));
    }

    public ArrayNode add(Integer num) {
        return _add(num == null ? nullNode() : numberNode(num.intValue()));
    }

    public ArrayNode insert(int i10, Integer num) {
        return _insert(i10, num == null ? nullNode() : numberNode(num.intValue()));
    }

    public ArrayNode set(int i10, Short sh) {
        return _set(i10, sh == null ? nullNode() : numberNode(sh.shortValue()));
    }

    public ArrayNode add(long j10) {
        return _add(numberNode(j10));
    }

    public ArrayNode insert(int i10, long j10) {
        return _insert(i10, numberNode(j10));
    }

    public ArrayNode set(int i10, int i11) {
        return _set(i10, numberNode(i11));
    }

    public ArrayNode add(Long l10) {
        return _add(l10 == null ? nullNode() : numberNode(l10.longValue()));
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ArrayNode)) {
            return this._children.equals(((ArrayNode) obj)._children);
        }
        return false;
    }

    public ArrayNode insert(int i10, Long l10) {
        return _insert(i10, l10 == null ? nullNode() : numberNode(l10.longValue()));
    }

    public ArrayNode set(int i10, Integer num) {
        return _set(i10, num == null ? nullNode() : numberNode(num.intValue()));
    }

    public ArrayNode add(float f10) {
        return _add(numberNode(f10));
    }

    public ArrayNode insert(int i10, float f10) {
        return _insert(i10, numberNode(f10));
    }

    public ArrayNode set(int i10, long j10) {
        return _set(i10, numberNode(j10));
    }

    public ArrayNode add(Float f10) {
        return _add(f10 == null ? nullNode() : numberNode(f10.floatValue()));
    }

    public ArrayNode insert(int i10, Float f10) {
        return _insert(i10, f10 == null ? nullNode() : numberNode(f10.floatValue()));
    }

    public ArrayNode set(int i10, Long l10) {
        return _set(i10, l10 == null ? nullNode() : numberNode(l10.longValue()));
    }

    public ArrayNode add(double d10) {
        return _add(numberNode(d10));
    }

    public ArrayNode insert(int i10, double d10) {
        return _insert(i10, numberNode(d10));
    }

    public ArrayNode set(int i10, float f10) {
        return _set(i10, numberNode(f10));
    }

    public ArrayNode add(Double d10) {
        return _add(d10 == null ? nullNode() : numberNode(d10.doubleValue()));
    }

    public ArrayNode insert(int i10, Double d10) {
        return _insert(i10, d10 == null ? nullNode() : numberNode(d10.doubleValue()));
    }

    public ArrayNode set(int i10, Float f10) {
        return _set(i10, f10 == null ? nullNode() : numberNode(f10.floatValue()));
    }

    public ArrayNode add(BigDecimal bigDecimal) {
        return _add(bigDecimal == null ? nullNode() : numberNode(bigDecimal));
    }

    public ArrayNode insert(int i10, BigDecimal bigDecimal) {
        return _insert(i10, bigDecimal == null ? nullNode() : numberNode(bigDecimal));
    }

    public ArrayNode set(int i10, double d10) {
        return _set(i10, numberNode(d10));
    }

    public ArrayNode add(BigInteger bigInteger) {
        return _add(bigInteger == null ? nullNode() : numberNode(bigInteger));
    }

    public ArrayNode insert(int i10, BigInteger bigInteger) {
        return _insert(i10, bigInteger == null ? nullNode() : numberNode(bigInteger));
    }

    public ArrayNode set(int i10, Double d10) {
        return _set(i10, d10 == null ? nullNode() : numberNode(d10.doubleValue()));
    }

    public ArrayNode add(String str) {
        return _add(str == null ? nullNode() : textNode(str));
    }

    public ArrayNode insert(int i10, String str) {
        return _insert(i10, str == null ? nullNode() : textNode(str));
    }

    public ArrayNode set(int i10, BigDecimal bigDecimal) {
        return _set(i10, bigDecimal == null ? nullNode() : numberNode(bigDecimal));
    }

    public ArrayNode add(boolean z10) {
        return _add(booleanNode(z10));
    }

    public ArrayNode insert(int i10, boolean z10) {
        return _insert(i10, booleanNode(z10));
    }

    public ArrayNode set(int i10, BigInteger bigInteger) {
        return _set(i10, bigInteger == null ? nullNode() : numberNode(bigInteger));
    }

    public ArrayNode add(Boolean bool) {
        return _add(bool == null ? nullNode() : booleanNode(bool.booleanValue()));
    }

    public ArrayNode insert(int i10, Boolean bool) {
        if (bool == null) {
            return insertNull(i10);
        }
        return _insert(i10, booleanNode(bool.booleanValue()));
    }

    public ArrayNode set(int i10, String str) {
        return _set(i10, str == null ? nullNode() : textNode(str));
    }

    public ArrayNode add(byte[] bArr) {
        return _add(bArr == null ? nullNode() : binaryNode(bArr));
    }

    public ArrayNode set(int i10, boolean z10) {
        return _set(i10, booleanNode(z10));
    }

    public ArrayNode insert(int i10, byte[] bArr) {
        if (bArr == null) {
            return insertNull(i10);
        }
        return _insert(i10, binaryNode(bArr));
    }

    public ArrayNode set(int i10, Boolean bool) {
        return _set(i10, bool == null ? nullNode() : booleanNode(bool.booleanValue()));
    }

    public ArrayNode set(int i10, byte[] bArr) {
        return _set(i10, bArr == null ? nullNode() : binaryNode(bArr));
    }
}
