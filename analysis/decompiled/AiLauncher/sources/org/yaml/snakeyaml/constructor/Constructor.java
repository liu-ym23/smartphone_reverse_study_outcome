package org.yaml.snakeyaml.constructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.util.EnumUtils;

/* loaded from: classes5.dex */
public class Constructor extends SafeConstructor {

    public class ConstructMapping implements Construct {
        public ConstructMapping() {
        }

        private Object newInstance(TypeDescription typeDescription, String str, Node node) {
            Object objNewInstance = typeDescription.newInstance(str, node);
            if (objNewInstance == null) {
                return Constructor.this.constructObject(node);
            }
            Constructor.this.constructedObjects.put(node, objNewInstance);
            return Constructor.this.constructObjectNoCheck(node);
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            MappingNode mappingNode = (MappingNode) node;
            if (Map.class.isAssignableFrom(node.getType())) {
                return node.isTwoStepsConstruction() ? Constructor.this.newMap(mappingNode) : Constructor.this.constructMapping(mappingNode);
            }
            if (Collection.class.isAssignableFrom(node.getType())) {
                return node.isTwoStepsConstruction() ? Constructor.this.newSet(mappingNode) : Constructor.this.constructSet(mappingNode);
            }
            Object objNewInstance = Constructor.this.newInstance(mappingNode);
            if (objNewInstance != BaseConstructor.NOT_INSTANTIATED_OBJECT) {
                return node.isTwoStepsConstruction() ? objNewInstance : constructJavaBean2ndStep(mappingNode, objNewInstance);
            }
            throw new ConstructorException(null, null, "Can't create an instance for " + mappingNode.getTag(), node.getStartMark());
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            if (Map.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructMapping2ndStep((MappingNode) node, (Map) obj);
            } else if (Set.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructSet2ndStep((MappingNode) node, (Set) obj);
            } else {
                constructJavaBean2ndStep((MappingNode) node, obj);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object constructJavaBean2ndStep(MappingNode mappingNode, Object obj) {
            Class<?>[] actualTypeArguments;
            Constructor.this.flattenMapping(mappingNode, true);
            Class<? extends Object> type = mappingNode.getType();
            for (NodeTuple nodeTuple : mappingNode.getValue()) {
                Node valueNode = nodeTuple.getValueNode();
                String str = (String) Constructor.this.constructObject(nodeTuple.getKeyNode());
                try {
                    TypeDescription typeDescription = Constructor.this.typeDefinitions.get(type);
                    Property property = typeDescription == null ? getProperty(type, str) : typeDescription.getProperty(str);
                    if (!property.isWritable()) {
                        throw new YAMLException("No writable property '" + str + "' on class: " + type.getName());
                    }
                    valueNode.setType(property.getType());
                    if ((typeDescription == null || !typeDescription.setupPropertyType(str, valueNode)) && valueNode.getNodeId() != NodeId.scalar && (actualTypeArguments = property.getActualTypeArguments()) != null && actualTypeArguments.length > 0) {
                        if (valueNode.getNodeId() == NodeId.sequence) {
                            ((SequenceNode) valueNode).setListType(actualTypeArguments[0]);
                        } else if (Map.class.isAssignableFrom(valueNode.getType())) {
                            MappingNode mappingNode2 = (MappingNode) valueNode;
                            mappingNode2.setTypes(actualTypeArguments[0], actualTypeArguments[1]);
                            mappingNode2.setUseClassConstructor(Boolean.TRUE);
                        } else if (Collection.class.isAssignableFrom(valueNode.getType())) {
                            MappingNode mappingNode3 = (MappingNode) valueNode;
                            mappingNode3.setOnlyKeyType(actualTypeArguments[0]);
                            mappingNode3.setUseClassConstructor(Boolean.TRUE);
                        }
                    }
                    Object objNewInstance = typeDescription != null ? newInstance(typeDescription, str, valueNode) : Constructor.this.constructObject(valueNode);
                    if ((property.getType() == Float.TYPE || property.getType() == Float.class) && (objNewInstance instanceof Double)) {
                        objNewInstance = Float.valueOf(((Double) objNewInstance).floatValue());
                    }
                    if (property.getType() == String.class && Tag.BINARY.equals(valueNode.getTag()) && (objNewInstance instanceof byte[])) {
                        objNewInstance = new String((byte[]) objNewInstance);
                    }
                    if (typeDescription == null || !typeDescription.setProperty(obj, str, objNewInstance)) {
                        property.set(obj, objNewInstance);
                    }
                } catch (DuplicateKeyException e10) {
                    throw e10;
                } catch (Exception e11) {
                    throw new ConstructorException("Cannot create property=" + str + " for JavaBean=" + obj, mappingNode.getStartMark(), e11.getMessage(), valueNode.getStartMark(), e11);
                }
            }
            return obj;
        }

        public Property getProperty(Class<? extends Object> cls, String str) {
            return Constructor.this.getPropertyUtils().getProperty(cls, str);
        }
    }

    public class ConstructScalar extends AbstractConstruct {
        public ConstructScalar() {
        }

        private Object constructStandardJavaInstance(Class cls, ScalarNode scalarNode) throws NumberFormatException {
            if (cls == String.class) {
                return Constructor.this.yamlConstructors.get(Tag.STR).construct(scalarNode);
            }
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return Constructor.this.yamlConstructors.get(Tag.BOOL).construct(scalarNode);
            }
            if (cls == Character.class || cls == Character.TYPE) {
                String str = (String) Constructor.this.yamlConstructors.get(Tag.STR).construct(scalarNode);
                if (str.isEmpty()) {
                    return null;
                }
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                throw new YAMLException("Invalid node Character: '" + str + "'; length: " + str.length());
            }
            boolean zIsAssignableFrom = Date.class.isAssignableFrom(cls);
            Class cls2 = Long.TYPE;
            if (zIsAssignableFrom) {
                Date date = (Date) Constructor.this.yamlConstructors.get(Tag.TIMESTAMP).construct(scalarNode);
                if (cls == Date.class) {
                    return date;
                }
                try {
                    return cls.getConstructor(cls2).newInstance(Long.valueOf(date.getTime()));
                } catch (RuntimeException e10) {
                    throw e10;
                } catch (Exception unused) {
                    throw new YAMLException("Cannot construct: '" + cls + "'");
                }
            }
            Class cls3 = Float.TYPE;
            if (cls == Float.class || cls == Double.class || cls == cls3 || cls == Double.TYPE || cls == BigDecimal.class) {
                if (cls == BigDecimal.class) {
                    return new BigDecimal(scalarNode.getValue());
                }
                Object objConstruct = Constructor.this.yamlConstructors.get(Tag.FLOAT).construct(scalarNode);
                return (cls == Float.class || cls == cls3) ? Float.valueOf(((Double) objConstruct).floatValue()) : objConstruct;
            }
            Class cls4 = Integer.TYPE;
            Class cls5 = Short.TYPE;
            Class cls6 = Byte.TYPE;
            if (cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == BigInteger.class || cls == cls6 || cls == cls5 || cls == cls4 || cls == cls2) {
                Object objConstruct2 = Constructor.this.yamlConstructors.get(Tag.INT).construct(scalarNode);
                return (cls == Byte.class || cls == cls6) ? Byte.valueOf(Integer.valueOf(objConstruct2.toString()).byteValue()) : (cls == Short.class || cls == cls5) ? Short.valueOf(Integer.valueOf(objConstruct2.toString()).shortValue()) : (cls == Integer.class || cls == cls4) ? Integer.valueOf(Integer.parseInt(objConstruct2.toString())) : (cls == Long.class || cls == cls2) ? Long.valueOf(objConstruct2.toString()) : new BigInteger(objConstruct2.toString());
            }
            if (Enum.class.isAssignableFrom(cls)) {
                String value = scalarNode.getValue();
                try {
                    return Constructor.this.loadingConfig.isEnumCaseSensitive() ? Enum.valueOf(cls, value) : EnumUtils.findEnumInsensitiveCase(cls, value);
                } catch (Exception unused2) {
                    throw new YAMLException("Unable to find enum value '" + value + "' for enum class: " + cls.getName());
                }
            }
            if (Calendar.class.isAssignableFrom(cls)) {
                SafeConstructor.ConstructYamlTimestamp constructYamlTimestamp = new SafeConstructor.ConstructYamlTimestamp();
                constructYamlTimestamp.construct(scalarNode);
                return constructYamlTimestamp.getCalendar();
            }
            if (Number.class.isAssignableFrom(cls)) {
                return new SafeConstructor.ConstructYamlFloat().construct(scalarNode);
            }
            if (UUID.class == cls) {
                return UUID.fromString(scalarNode.getValue());
            }
            if (Constructor.this.yamlConstructors.containsKey(scalarNode.getTag())) {
                return Constructor.this.yamlConstructors.get(scalarNode.getTag()).construct(scalarNode);
            }
            throw new YAMLException("Unsupported class: " + cls);
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) throws NoSuchMethodException, SecurityException, NumberFormatException {
            Object objConstructScalar;
            ScalarNode scalarNode = (ScalarNode) node;
            Class<? extends Object> type = scalarNode.getType();
            Object objNewInstance = Constructor.this.newInstance(type, scalarNode, false);
            if (objNewInstance != BaseConstructor.NOT_INSTANTIATED_OBJECT) {
                return objNewInstance;
            }
            if (type.isPrimitive() || type == String.class || Number.class.isAssignableFrom(type) || type == Boolean.class || Date.class.isAssignableFrom(type) || type == Character.class || type == BigInteger.class || type == BigDecimal.class || Enum.class.isAssignableFrom(type) || Tag.BINARY.equals(scalarNode.getTag()) || Calendar.class.isAssignableFrom(type) || type == UUID.class) {
                return constructStandardJavaInstance(type, scalarNode);
            }
            java.lang.reflect.Constructor<?> declaredConstructor = null;
            int i10 = 0;
            for (java.lang.reflect.Constructor<?> constructor : type.getDeclaredConstructors()) {
                if (constructor.getParameterTypes().length == 1) {
                    i10++;
                    declaredConstructor = constructor;
                }
            }
            if (declaredConstructor == null) {
                throw new YAMLException("No single argument constructor found for " + type);
            }
            if (i10 == 1) {
                objConstructScalar = constructStandardJavaInstance(declaredConstructor.getParameterTypes()[0], scalarNode);
            } else {
                objConstructScalar = Constructor.this.constructScalar(scalarNode);
                try {
                    declaredConstructor = type.getDeclaredConstructor(String.class);
                } catch (Exception e10) {
                    throw new YAMLException("Can't construct a java object for scalar " + scalarNode.getTag() + "; No String constructor found. Exception=" + e10.getMessage(), e10);
                }
            }
            try {
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(objConstructScalar);
            } catch (Exception e11) {
                throw new ConstructorException(null, null, "Can't construct a java object for scalar " + scalarNode.getTag() + "; exception=" + e11.getMessage(), scalarNode.getStartMark(), e11);
            }
        }
    }

    public class ConstructSequence implements Construct {
        public ConstructSequence() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Class<? extends Object> wrapIfPrimitive(Class<?> cls) {
            if (!cls.isPrimitive()) {
                return cls;
            }
            if (cls == Integer.TYPE) {
                return Integer.class;
            }
            if (cls == Float.TYPE) {
                return Float.class;
            }
            if (cls == Double.TYPE) {
                return Double.class;
            }
            if (cls == Boolean.TYPE) {
                return Boolean.class;
            }
            if (cls == Long.TYPE) {
                return Long.class;
            }
            if (cls == Character.TYPE) {
                return Character.class;
            }
            if (cls == Short.TYPE) {
                return Short.class;
            }
            if (cls == Byte.TYPE) {
                return Byte.class;
            }
            throw new YAMLException("Unexpected primitive " + cls);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) throws SecurityException {
            SequenceNode sequenceNode = (SequenceNode) node;
            if (Set.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    throw new YAMLException("Set cannot be recursive.");
                }
                return Constructor.this.constructSet(sequenceNode);
            }
            if (Collection.class.isAssignableFrom(node.getType())) {
                return node.isTwoStepsConstruction() ? Constructor.this.newList(sequenceNode) : Constructor.this.constructSequence(sequenceNode);
            }
            if (node.getType().isArray()) {
                return node.isTwoStepsConstruction() ? Constructor.this.createArray(node.getType(), sequenceNode.getValue().size()) : Constructor.this.constructArray(sequenceNode);
            }
            ArrayList<java.lang.reflect.Constructor> arrayList = new ArrayList(sequenceNode.getValue().size());
            int i10 = 0;
            for (java.lang.reflect.Constructor<?> constructor : node.getType().getDeclaredConstructors()) {
                if (sequenceNode.getValue().size() == constructor.getParameterTypes().length) {
                    arrayList.add(constructor);
                }
            }
            if (!arrayList.isEmpty()) {
                if (arrayList.size() == 1) {
                    Object[] objArr = new Object[sequenceNode.getValue().size()];
                    java.lang.reflect.Constructor constructor2 = (java.lang.reflect.Constructor) arrayList.get(0);
                    for (Node node2 : sequenceNode.getValue()) {
                        node2.setType(constructor2.getParameterTypes()[i10]);
                        objArr[i10] = Constructor.this.constructObject(node2);
                        i10++;
                    }
                    try {
                        constructor2.setAccessible(true);
                        return constructor2.newInstance(objArr);
                    } catch (Exception e10) {
                        throw new YAMLException(e10);
                    }
                }
                List<? extends Object> listConstructSequence = Constructor.this.constructSequence(sequenceNode);
                Class<?>[] clsArr = new Class[listConstructSequence.size()];
                Iterator<? extends Object> it = listConstructSequence.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    clsArr[i11] = it.next().getClass();
                    i11++;
                }
                for (java.lang.reflect.Constructor constructor3 : arrayList) {
                    Class<?>[] parameterTypes = constructor3.getParameterTypes();
                    for (int i12 = 0; i12 < parameterTypes.length; i12++) {
                        if (!wrapIfPrimitive(parameterTypes[i12]).isAssignableFrom(clsArr[i12])) {
                            break;
                        }
                    }
                    try {
                        constructor3.setAccessible(true);
                        return constructor3.newInstance(listConstructSequence.toArray());
                    } catch (Exception e11) {
                        throw new YAMLException(e11);
                    }
                }
            }
            throw new YAMLException("No suitable constructor with " + sequenceNode.getValue().size() + " arguments found for " + node.getType());
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
            SequenceNode sequenceNode = (SequenceNode) node;
            if (List.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructSequenceStep2(sequenceNode, (List) obj);
            } else {
                if (!node.getType().isArray()) {
                    throw new YAMLException("Immutable objects cannot be recursive.");
                }
                Constructor.this.constructArrayStep2(sequenceNode, obj);
            }
        }
    }

    public class ConstructYamlObject implements Construct {
        public ConstructYamlObject() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Construct getConstructor(Node node) {
            node.setType(Constructor.this.getClassForNode(node));
            return Constructor.this.yamlClassConstructors.get(node.getNodeId());
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            try {
                return getConstructor(node).construct(node);
            } catch (ConstructorException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new ConstructorException(null, null, "Can't construct a java object for " + node.getTag() + "; exception=" + e11.getMessage(), node.getStartMark(), e11);
            }
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            try {
                getConstructor(node).construct2ndStep(node, obj);
            } catch (Exception e10) {
                throw new ConstructorException(null, null, "Can't construct a second step for a java object for " + node.getTag() + "; exception=" + e10.getMessage(), node.getStartMark(), e10);
            }
        }
    }

    public Constructor(LoaderOptions loaderOptions) {
        this((Class<? extends Object>) Object.class, loaderOptions);
    }

    private static String check(String str) {
        if (str == null) {
            throw new NullPointerException("Root type must be provided.");
        }
        if (str.trim().isEmpty()) {
            throw new YAMLException("Root type must be provided.");
        }
        return str;
    }

    private static Class<? extends Object> checkRoot(Class<? extends Object> cls) {
        if (cls != null) {
            return cls;
        }
        throw new NullPointerException("Root class must be provided.");
    }

    public Class<?> getClassForName(String str) throws ClassNotFoundException {
        try {
            return Class.forName(str, true, Thread.currentThread().getContextClassLoader());
        } catch (ClassNotFoundException unused) {
            return Class.forName(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Class<?> getClassForNode(Node node) {
        Class<? extends Object> cls = this.typeTags.get(node.getTag());
        if (cls != null) {
            return cls;
        }
        String className = node.getTag().getClassName();
        try {
            Class<?> classForName = getClassForName(className);
            this.typeTags.put(node.getTag(), classForName);
            return classForName;
        } catch (ClassNotFoundException unused) {
            throw new YAMLException("Class not found: " + className);
        }
    }

    public Constructor(Class<? extends Object> cls, LoaderOptions loaderOptions) {
        this(new TypeDescription(checkRoot(cls)), null, loaderOptions);
    }

    public Constructor(TypeDescription typeDescription, LoaderOptions loaderOptions) {
        this(typeDescription, null, loaderOptions);
    }

    public Constructor(TypeDescription typeDescription, Collection<TypeDescription> collection, LoaderOptions loaderOptions) {
        super(loaderOptions);
        if (typeDescription != null) {
            this.yamlConstructors.put(null, new ConstructYamlObject());
            if (!Object.class.equals(typeDescription.getType())) {
                this.rootTag = new Tag(typeDescription.getType());
            }
            this.yamlClassConstructors.put(NodeId.scalar, new ConstructScalar());
            this.yamlClassConstructors.put(NodeId.mapping, new ConstructMapping());
            this.yamlClassConstructors.put(NodeId.sequence, new ConstructSequence());
            addTypeDescription(typeDescription);
            if (collection != null) {
                Iterator<TypeDescription> it = collection.iterator();
                while (it.hasNext()) {
                    addTypeDescription(it.next());
                }
                return;
            }
            return;
        }
        throw new NullPointerException("Root type must be provided.");
    }

    public Constructor(String str, LoaderOptions loaderOptions) throws ClassNotFoundException {
        this((Class<? extends Object>) Class.forName(check(str)), loaderOptions);
    }
}
