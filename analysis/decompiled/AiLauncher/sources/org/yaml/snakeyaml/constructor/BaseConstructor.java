package org.yaml.snakeyaml.constructor;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.composer.Composer;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.CollectionNode;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.util.Tuple;

/* loaded from: classes5.dex */
public abstract class BaseConstructor {
    protected static final Object NOT_INSTANTIATED_OBJECT = new Object();
    protected Composer composer;
    final Map<Node, Object> constructedObjects;
    private boolean explicitPropertyUtils;
    protected LoaderOptions loadingConfig;
    private final ArrayList<Tuple<Map<Object, Object>, Tuple<Object, Object>>> maps2fill;
    private PropertyUtils propertyUtils;
    private final Set<Node> recursiveObjects;
    protected Tag rootTag;
    private final ArrayList<Tuple<Set<Object>, Object>> sets2fill;
    protected final Map<Class<? extends Object>, TypeDescription> typeDefinitions;
    protected final Map<Tag, Class<? extends Object>> typeTags;
    protected final Map<NodeId, Construct> yamlClassConstructors = new EnumMap(NodeId.class);
    protected final Map<Tag, Construct> yamlConstructors = new HashMap();
    protected final Map<String, Construct> yamlMultiConstructors = new HashMap();
    private boolean allowDuplicateKeys = true;
    private boolean warnOnDuplicateKeys = false;
    private boolean wrappedToRootException = false;
    private boolean enumCaseSensitive = false;

    public BaseConstructor(LoaderOptions loaderOptions) {
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided.");
        }
        this.constructedObjects = new HashMap();
        this.recursiveObjects = new HashSet();
        this.maps2fill = new ArrayList<>();
        this.sets2fill = new ArrayList<>();
        HashMap map = new HashMap();
        this.typeDefinitions = map;
        this.typeTags = new HashMap();
        this.rootTag = null;
        this.explicitPropertyUtils = false;
        map.put(SortedMap.class, new TypeDescription(SortedMap.class, Tag.OMAP, TreeMap.class));
        map.put(SortedSet.class, new TypeDescription(SortedSet.class, Tag.SET, TreeSet.class));
        this.loadingConfig = loaderOptions;
    }

    private void fillRecursive() {
        if (!this.maps2fill.isEmpty()) {
            Iterator<Tuple<Map<Object, Object>, Tuple<Object, Object>>> it = this.maps2fill.iterator();
            while (it.hasNext()) {
                Tuple<Map<Object, Object>, Tuple<Object, Object>> next = it.next();
                Tuple<Object, Object> tuple_2 = next._2();
                next._1().put(tuple_2._1(), tuple_2._2());
            }
            this.maps2fill.clear();
        }
        if (this.sets2fill.isEmpty()) {
            return;
        }
        Iterator<Tuple<Set<Object>, Object>> it2 = this.sets2fill.iterator();
        while (it2.hasNext()) {
            Tuple<Set<Object>, Object> next2 = it2.next();
            next2._1().add(next2._2());
        }
        this.sets2fill.clear();
    }

    public TypeDescription addTypeDescription(TypeDescription typeDescription) {
        if (typeDescription == null) {
            throw new NullPointerException("TypeDescription is required.");
        }
        this.typeTags.put(typeDescription.getTag(), typeDescription.getType());
        typeDescription.setPropertyUtils(getPropertyUtils());
        return this.typeDefinitions.put(typeDescription.getType(), typeDescription);
    }

    public boolean checkData() {
        return this.composer.checkNode();
    }

    public Object constructArray(SequenceNode sequenceNode) {
        return constructArrayStep2(sequenceNode, createArray(sequenceNode.getType(), sequenceNode.getValue().size()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object constructArrayStep2(SequenceNode sequenceNode, Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Class<?> componentType = sequenceNode.getType().getComponentType();
        int i10 = 0;
        for (Node node : sequenceNode.getValue()) {
            if (node.getType() == Object.class) {
                node.setType(componentType);
            }
            Object objConstructObject = constructObject(node);
            if (!componentType.isPrimitive()) {
                Array.set(obj, i10, objConstructObject);
            } else {
                if (objConstructObject == null) {
                    throw new NullPointerException("Unable to construct element value for " + node);
                }
                if (Byte.TYPE.equals(componentType)) {
                    Array.setByte(obj, i10, ((Number) objConstructObject).byteValue());
                } else if (Short.TYPE.equals(componentType)) {
                    Array.setShort(obj, i10, ((Number) objConstructObject).shortValue());
                } else if (Integer.TYPE.equals(componentType)) {
                    Array.setInt(obj, i10, ((Number) objConstructObject).intValue());
                } else if (Long.TYPE.equals(componentType)) {
                    Array.setLong(obj, i10, ((Number) objConstructObject).longValue());
                } else if (Float.TYPE.equals(componentType)) {
                    Array.setFloat(obj, i10, ((Number) objConstructObject).floatValue());
                } else if (Double.TYPE.equals(componentType)) {
                    Array.setDouble(obj, i10, ((Number) objConstructObject).doubleValue());
                } else if (Character.TYPE.equals(componentType)) {
                    Array.setChar(obj, i10, ((Character) objConstructObject).charValue());
                } else {
                    if (!Boolean.TYPE.equals(componentType)) {
                        throw new YAMLException("unexpected primitive type");
                    }
                    Array.setBoolean(obj, i10, ((Boolean) objConstructObject).booleanValue());
                }
            }
            i10++;
        }
        return obj;
    }

    public final Object constructDocument(Node node) {
        try {
            try {
                Object objConstructObject = constructObject(node);
                fillRecursive();
                return objConstructObject;
            } catch (RuntimeException e10) {
                if (!this.wrappedToRootException || (e10 instanceof YAMLException)) {
                    throw e10;
                }
                throw new YAMLException(e10);
            }
        } finally {
            this.constructedObjects.clear();
            this.recursiveObjects.clear();
        }
    }

    public Map<Object, Object> constructMapping(MappingNode mappingNode) {
        Map<Object, Object> mapNewMap = newMap(mappingNode);
        constructMapping2ndStep(mappingNode, mapNewMap);
        return mapNewMap;
    }

    public void constructMapping2ndStep(MappingNode mappingNode, Map<Object, Object> map) {
        for (NodeTuple nodeTuple : mappingNode.getValue()) {
            Node keyNode = nodeTuple.getKeyNode();
            Node valueNode = nodeTuple.getValueNode();
            Object objConstructObject = constructObject(keyNode);
            if (objConstructObject != null) {
                try {
                    objConstructObject.hashCode();
                } catch (Exception e10) {
                    throw new ConstructorException("while constructing a mapping", mappingNode.getStartMark(), "found unacceptable key " + objConstructObject, nodeTuple.getKeyNode().getStartMark(), e10);
                }
            }
            Object objConstructObject2 = constructObject(valueNode);
            if (!keyNode.isTwoStepsConstruction()) {
                map.put(objConstructObject, objConstructObject2);
            } else {
                if (!this.loadingConfig.getAllowRecursiveKeys()) {
                    throw new YAMLException("Recursive key for mapping is detected but it is not configured to be allowed.");
                }
                postponeMapFilling(map, objConstructObject, objConstructObject2);
            }
        }
    }

    public Object constructObject(Node node) {
        return this.constructedObjects.containsKey(node) ? this.constructedObjects.get(node) : constructObjectNoCheck(node);
    }

    public Object constructObjectNoCheck(Node node) {
        if (this.recursiveObjects.contains(node)) {
            throw new ConstructorException(null, null, "found unconstructable recursive node", node.getStartMark());
        }
        this.recursiveObjects.add(node);
        Construct constructor = getConstructor(node);
        Object objFinalizeConstruction = finalizeConstruction(node, this.constructedObjects.containsKey(node) ? this.constructedObjects.get(node) : constructor.construct(node));
        this.constructedObjects.put(node, objFinalizeConstruction);
        this.recursiveObjects.remove(node);
        if (node.isTwoStepsConstruction()) {
            constructor.construct2ndStep(node, objFinalizeConstruction);
        }
        return objFinalizeConstruction;
    }

    public String constructScalar(ScalarNode scalarNode) {
        return scalarNode.getValue();
    }

    public List<? extends Object> constructSequence(SequenceNode sequenceNode) {
        List<? extends Object> listNewList = newList(sequenceNode);
        constructSequenceStep2(sequenceNode, listNewList);
        return listNewList;
    }

    public void constructSequenceStep2(SequenceNode sequenceNode, Collection<Object> collection) {
        Iterator<Node> it = sequenceNode.getValue().iterator();
        while (it.hasNext()) {
            collection.add(constructObject(it.next()));
        }
    }

    public Set<? extends Object> constructSet(SequenceNode sequenceNode) {
        Set<? extends Object> setNewSet = newSet(sequenceNode);
        constructSequenceStep2(sequenceNode, setNewSet);
        return setNewSet;
    }

    public void constructSet2ndStep(MappingNode mappingNode, Set<Object> set) {
        for (NodeTuple nodeTuple : mappingNode.getValue()) {
            Node keyNode = nodeTuple.getKeyNode();
            Object objConstructObject = constructObject(keyNode);
            if (objConstructObject != null) {
                try {
                    objConstructObject.hashCode();
                } catch (Exception e10) {
                    throw new ConstructorException("while constructing a Set", mappingNode.getStartMark(), "found unacceptable key " + objConstructObject, nodeTuple.getKeyNode().getStartMark(), e10);
                }
            }
            if (keyNode.isTwoStepsConstruction()) {
                postponeSetFilling(set, objConstructObject);
            } else {
                set.add(objConstructObject);
            }
        }
    }

    public Object createArray(Class<?> cls, int i10) {
        return Array.newInstance(cls.getComponentType(), i10);
    }

    public List<Object> createDefaultList(int i10) {
        return new ArrayList(i10);
    }

    public Map<Object, Object> createDefaultMap(int i10) {
        return new LinkedHashMap(i10);
    }

    public Set<Object> createDefaultSet(int i10) {
        return new LinkedHashSet(i10);
    }

    public Object finalizeConstruction(Node node, Object obj) {
        Class<? extends Object> type = node.getType();
        return this.typeDefinitions.containsKey(type) ? this.typeDefinitions.get(type).finalizeConstruction(obj) : obj;
    }

    public Construct getConstructor(Node node) {
        if (node.useClassConstructor()) {
            return this.yamlClassConstructors.get(node.getNodeId());
        }
        Tag tag = node.getTag();
        Construct construct = this.yamlConstructors.get(tag);
        if (construct != null) {
            return construct;
        }
        for (String str : this.yamlMultiConstructors.keySet()) {
            if (tag.startsWith(str)) {
                return this.yamlMultiConstructors.get(str);
            }
        }
        return this.yamlConstructors.get(null);
    }

    public Object getData() throws NoSuchElementException {
        if (!this.composer.checkNode()) {
            throw new NoSuchElementException("No document is available.");
        }
        Node node = this.composer.getNode();
        Tag tag = this.rootTag;
        if (tag != null) {
            node.setTag(tag);
        }
        return constructDocument(node);
    }

    public LoaderOptions getLoadingConfig() {
        return this.loadingConfig;
    }

    public final PropertyUtils getPropertyUtils() {
        if (this.propertyUtils == null) {
            this.propertyUtils = new PropertyUtils();
        }
        return this.propertyUtils;
    }

    public Object getSingleData(Class<?> cls) {
        Node singleNode = this.composer.getSingleNode();
        if (singleNode == null || Tag.NULL.equals(singleNode.getTag())) {
            return this.yamlConstructors.get(Tag.NULL).construct(singleNode);
        }
        if (Object.class != cls) {
            singleNode.setTag(new Tag((Class<? extends Object>) cls));
        } else {
            Tag tag = this.rootTag;
            if (tag != null) {
                singleNode.setTag(tag);
            }
        }
        return constructDocument(singleNode);
    }

    public boolean isAllowDuplicateKeys() {
        return this.allowDuplicateKeys;
    }

    public boolean isEnumCaseSensitive() {
        return this.enumCaseSensitive;
    }

    public final boolean isExplicitPropertyUtils() {
        return this.explicitPropertyUtils;
    }

    public boolean isWarnOnDuplicateKeys() {
        return this.warnOnDuplicateKeys;
    }

    public boolean isWrappedToRootException() {
        return this.wrappedToRootException;
    }

    public Object newInstance(Node node) {
        return newInstance(Object.class, node);
    }

    public List<Object> newList(SequenceNode sequenceNode) {
        Object objNewInstance = newInstance(List.class, sequenceNode);
        return objNewInstance != NOT_INSTANTIATED_OBJECT ? (List) objNewInstance : createDefaultList(sequenceNode.getValue().size());
    }

    public Map<Object, Object> newMap(MappingNode mappingNode) {
        Object objNewInstance = newInstance(Map.class, mappingNode);
        return objNewInstance != NOT_INSTANTIATED_OBJECT ? (Map) objNewInstance : createDefaultMap(mappingNode.getValue().size());
    }

    public Set<Object> newSet(CollectionNode<?> collectionNode) {
        Object objNewInstance = newInstance(Set.class, collectionNode);
        return objNewInstance != NOT_INSTANTIATED_OBJECT ? (Set) objNewInstance : createDefaultSet(collectionNode.getValue().size());
    }

    public void postponeMapFilling(Map<Object, Object> map, Object obj, Object obj2) {
        this.maps2fill.add(0, new Tuple<>(map, new Tuple(obj, obj2)));
    }

    public void postponeSetFilling(Set<Object> set, Object obj) {
        this.sets2fill.add(0, new Tuple<>(set, obj));
    }

    public void setAllowDuplicateKeys(boolean z10) {
        this.allowDuplicateKeys = z10;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public void setEnumCaseSensitive(boolean z10) {
        this.enumCaseSensitive = z10;
    }

    public void setPropertyUtils(PropertyUtils propertyUtils) {
        this.propertyUtils = propertyUtils;
        this.explicitPropertyUtils = true;
        Iterator<TypeDescription> it = this.typeDefinitions.values().iterator();
        while (it.hasNext()) {
            it.next().setPropertyUtils(propertyUtils);
        }
    }

    public void setWarnOnDuplicateKeys(boolean z10) {
        this.warnOnDuplicateKeys = z10;
    }

    public void setWrappedToRootException(boolean z10) {
        this.wrappedToRootException = z10;
    }

    public final Object newInstance(Class<?> cls, Node node) {
        return newInstance(cls, node, true);
    }

    public Set<Object> constructSet(MappingNode mappingNode) {
        Set<Object> setNewSet = newSet(mappingNode);
        constructSet2ndStep(mappingNode, setNewSet);
        return setNewSet;
    }

    public Object newInstance(Class<?> cls, Node node, boolean z10) throws NoSuchMethodException, SecurityException {
        Object objNewInstance;
        try {
            Class<? extends Object> type = node.getType();
            if (this.typeDefinitions.containsKey(type) && (objNewInstance = this.typeDefinitions.get(type).newInstance(node)) != null) {
                return objNewInstance;
            }
            if (z10 && cls.isAssignableFrom(type) && !Modifier.isAbstract(type.getModifiers())) {
                java.lang.reflect.Constructor<? extends Object> declaredConstructor = type.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null);
            }
            return NOT_INSTANTIATED_OBJECT;
        } catch (Exception e10) {
            throw new YAMLException(e10);
        }
    }
}
