package org.yaml.snakeyaml.representer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes5.dex */
public class Representer extends SafeRepresenter {
    protected Map<Class<? extends Object>, TypeDescription> typeDefinitions;

    public class RepresentJavaBean implements Represent {
        public RepresentJavaBean() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Representer representer = Representer.this;
            return representer.representJavaBean(representer.getProperties(obj.getClass()), obj);
        }
    }

    public Representer(DumperOptions dumperOptions) {
        super(dumperOptions);
        this.typeDefinitions = Collections.EMPTY_MAP;
        this.representers.put(null, new RepresentJavaBean());
    }

    private void resetTag(Class<? extends Object> cls, Node node) {
        if (node.getTag().matches(cls)) {
            if (Enum.class.isAssignableFrom(cls)) {
                node.setTag(Tag.STR);
            } else {
                node.setTag(Tag.MAP);
            }
        }
    }

    @Override // org.yaml.snakeyaml.representer.SafeRepresenter
    public /* bridge */ /* synthetic */ Tag addClassTag(Class cls, Tag tag) {
        return super.addClassTag(cls, tag);
    }

    public TypeDescription addTypeDescription(TypeDescription typeDescription) {
        if (Collections.EMPTY_MAP == this.typeDefinitions) {
            this.typeDefinitions = new HashMap();
        }
        if (typeDescription.getTag() != null) {
            addClassTag(typeDescription.getType(), typeDescription.getTag());
        }
        typeDescription.setPropertyUtils(getPropertyUtils());
        return this.typeDefinitions.put(typeDescription.getType(), typeDescription);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void checkGlobalTag(Property property, Node node, Object obj) {
        Class<?>[] actualTypeArguments;
        if ((obj.getClass().isArray() && obj.getClass().getComponentType().isPrimitive()) || (actualTypeArguments = property.getActualTypeArguments()) == null) {
            return;
        }
        if (node.getNodeId() == NodeId.sequence) {
            Class<?> cls = actualTypeArguments[0];
            SequenceNode sequenceNode = (SequenceNode) node;
            Iterable iterableAsList = Collections.EMPTY_LIST;
            if (obj.getClass().isArray()) {
                iterableAsList = Arrays.asList((Object[]) obj);
            } else if (obj instanceof Iterable) {
                iterableAsList = (Iterable) obj;
            }
            Iterator it = iterableAsList.iterator();
            if (it.hasNext()) {
                for (Node node2 : sequenceNode.getValue()) {
                    Object next = it.next();
                    if (next != null && cls.equals(next.getClass()) && node2.getNodeId() == NodeId.mapping) {
                        node2.setTag(Tag.MAP);
                    }
                }
                return;
            }
            return;
        }
        if (obj instanceof Set) {
            Class<?> cls2 = actualTypeArguments[0];
            Iterator<NodeTuple> it2 = ((MappingNode) node).getValue().iterator();
            for (Object obj2 : (Set) obj) {
                Node keyNode = it2.next().getKeyNode();
                if (cls2.equals(obj2.getClass()) && keyNode.getNodeId() == NodeId.mapping) {
                    keyNode.setTag(Tag.MAP);
                }
            }
            return;
        }
        if (obj instanceof Map) {
            Class<?> cls3 = actualTypeArguments[0];
            Class<?> cls4 = actualTypeArguments[1];
            for (NodeTuple nodeTuple : ((MappingNode) node).getValue()) {
                resetTag(cls3, nodeTuple.getKeyNode());
                resetTag(cls4, nodeTuple.getValueNode());
            }
        }
    }

    public Set<Property> getProperties(Class<? extends Object> cls) {
        return this.typeDefinitions.containsKey(cls) ? this.typeDefinitions.get(cls).getProperties() : getPropertyUtils().getProperties(cls);
    }

    @Override // org.yaml.snakeyaml.representer.SafeRepresenter
    public /* bridge */ /* synthetic */ TimeZone getTimeZone() {
        return super.getTimeZone();
    }

    public MappingNode representJavaBean(Set<Property> set, Object obj) {
        ArrayList arrayList = new ArrayList(set.size());
        Tag tag = this.classTags.get(obj.getClass());
        if (tag == null) {
            tag = new Tag((Class<? extends Object>) obj.getClass());
        }
        MappingNode mappingNode = new MappingNode(tag, arrayList, DumperOptions.FlowStyle.AUTO);
        this.representedObjects.put(obj, mappingNode);
        DumperOptions.FlowStyle flowStyle = DumperOptions.FlowStyle.FLOW;
        for (Property property : set) {
            Object obj2 = property.get(obj);
            NodeTuple nodeTupleRepresentJavaBeanProperty = representJavaBeanProperty(obj, property, obj2, obj2 == null ? null : this.classTags.get(obj2.getClass()));
            if (nodeTupleRepresentJavaBeanProperty != null) {
                if (!((ScalarNode) nodeTupleRepresentJavaBeanProperty.getKeyNode()).isPlain()) {
                    flowStyle = DumperOptions.FlowStyle.BLOCK;
                }
                Node valueNode = nodeTupleRepresentJavaBeanProperty.getValueNode();
                if (!(valueNode instanceof ScalarNode) || !((ScalarNode) valueNode).isPlain()) {
                    flowStyle = DumperOptions.FlowStyle.BLOCK;
                }
                arrayList.add(nodeTupleRepresentJavaBeanProperty);
            }
        }
        DumperOptions.FlowStyle flowStyle2 = this.defaultFlowStyle;
        if (flowStyle2 != DumperOptions.FlowStyle.AUTO) {
            mappingNode.setFlowStyle(flowStyle2);
            return mappingNode;
        }
        mappingNode.setFlowStyle(flowStyle);
        return mappingNode;
    }

    public NodeTuple representJavaBeanProperty(Object obj, Property property, Object obj2, Tag tag) {
        ScalarNode scalarNode = (ScalarNode) representData(property.getName());
        boolean zContainsKey = this.representedObjects.containsKey(obj2);
        Node nodeRepresentData = representData(obj2);
        if (obj2 != null && !zContainsKey) {
            NodeId nodeId = nodeRepresentData.getNodeId();
            if (tag == null) {
                if (nodeId != NodeId.scalar) {
                    if (nodeId == NodeId.mapping && property.getType() == obj2.getClass() && !(obj2 instanceof Map) && !nodeRepresentData.getTag().equals(Tag.SET)) {
                        nodeRepresentData.setTag(Tag.MAP);
                    }
                    checkGlobalTag(property, nodeRepresentData, obj2);
                } else if (property.getType() != Enum.class && (obj2 instanceof Enum)) {
                    nodeRepresentData.setTag(Tag.STR);
                }
            }
        }
        return new NodeTuple(scalarNode, nodeRepresentData);
    }

    @Override // org.yaml.snakeyaml.representer.BaseRepresenter
    public void setPropertyUtils(PropertyUtils propertyUtils) {
        super.setPropertyUtils(propertyUtils);
        Iterator<TypeDescription> it = this.typeDefinitions.values().iterator();
        while (it.hasNext()) {
            it.next().setPropertyUtils(propertyUtils);
        }
    }

    @Override // org.yaml.snakeyaml.representer.SafeRepresenter
    public /* bridge */ /* synthetic */ void setTimeZone(TimeZone timeZone) {
        super.setTimeZone(timeZone);
    }
}
