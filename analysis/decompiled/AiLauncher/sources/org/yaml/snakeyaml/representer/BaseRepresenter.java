package org.yaml.snakeyaml.representer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.AnchorNode;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes5.dex */
public abstract class BaseRepresenter {
    protected Represent nullRepresenter;
    protected Object objectToRepresent;
    private PropertyUtils propertyUtils;
    protected final Map<Class<?>, Represent> representers = new HashMap();
    protected final Map<Class<?>, Represent> multiRepresenters = new LinkedHashMap();
    protected DumperOptions.ScalarStyle defaultScalarStyle = DumperOptions.ScalarStyle.PLAIN;
    protected DumperOptions.FlowStyle defaultFlowStyle = DumperOptions.FlowStyle.AUTO;
    protected final Map<Object, Node> representedObjects = new IdentityHashMap<Object, Node>() { // from class: org.yaml.snakeyaml.representer.BaseRepresenter.1
        private static final long serialVersionUID = -5576159264232131854L;

        @Override // java.util.IdentityHashMap, java.util.AbstractMap, java.util.Map
        public Node put(Object obj, Node node) {
            return (Node) super.put((AnonymousClass1) obj, (Object) new AnchorNode(node));
        }
    };
    private boolean explicitPropertyUtils = false;

    public DumperOptions.FlowStyle getDefaultFlowStyle() {
        return this.defaultFlowStyle;
    }

    public DumperOptions.ScalarStyle getDefaultScalarStyle() {
        DumperOptions.ScalarStyle scalarStyle = this.defaultScalarStyle;
        return scalarStyle == null ? DumperOptions.ScalarStyle.PLAIN : scalarStyle;
    }

    public final PropertyUtils getPropertyUtils() {
        if (this.propertyUtils == null) {
            this.propertyUtils = new PropertyUtils();
        }
        return this.propertyUtils;
    }

    public final boolean isExplicitPropertyUtils() {
        return this.explicitPropertyUtils;
    }

    public Node represent(Object obj) {
        Node nodeRepresentData = representData(obj);
        this.representedObjects.clear();
        this.objectToRepresent = null;
        return nodeRepresentData;
    }

    public final Node representData(Object obj) {
        this.objectToRepresent = obj;
        if (this.representedObjects.containsKey(obj)) {
            return this.representedObjects.get(this.objectToRepresent);
        }
        if (obj == null) {
            return this.nullRepresenter.representData(null);
        }
        Class<?> cls = obj.getClass();
        if (this.representers.containsKey(cls)) {
            return this.representers.get(cls).representData(obj);
        }
        for (Class<?> cls2 : this.multiRepresenters.keySet()) {
            if (cls2 != null && cls2.isInstance(obj)) {
                return this.multiRepresenters.get(cls2).representData(obj);
            }
        }
        return this.multiRepresenters.containsKey(null) ? this.multiRepresenters.get(null).representData(obj) : this.representers.get(null).representData(obj);
    }

    public Node representMapping(Tag tag, Map<?, ?> map, DumperOptions.FlowStyle flowStyle) {
        ArrayList arrayList = new ArrayList(map.size());
        MappingNode mappingNode = new MappingNode(tag, arrayList, flowStyle);
        this.representedObjects.put(this.objectToRepresent, mappingNode);
        DumperOptions.FlowStyle flowStyle2 = DumperOptions.FlowStyle.FLOW;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Node nodeRepresentData = representData(entry.getKey());
            Node nodeRepresentData2 = representData(entry.getValue());
            if (!(nodeRepresentData instanceof ScalarNode) || !((ScalarNode) nodeRepresentData).isPlain()) {
                flowStyle2 = DumperOptions.FlowStyle.BLOCK;
            }
            if (!(nodeRepresentData2 instanceof ScalarNode) || !((ScalarNode) nodeRepresentData2).isPlain()) {
                flowStyle2 = DumperOptions.FlowStyle.BLOCK;
            }
            arrayList.add(new NodeTuple(nodeRepresentData, nodeRepresentData2));
        }
        DumperOptions.FlowStyle flowStyle3 = DumperOptions.FlowStyle.AUTO;
        if (flowStyle == flowStyle3) {
            DumperOptions.FlowStyle flowStyle4 = this.defaultFlowStyle;
            if (flowStyle4 != flowStyle3) {
                mappingNode.setFlowStyle(flowStyle4);
                return mappingNode;
            }
            mappingNode.setFlowStyle(flowStyle2);
        }
        return mappingNode;
    }

    public Node representScalar(Tag tag, String str, DumperOptions.ScalarStyle scalarStyle) {
        return new ScalarNode(tag, str, null, null, scalarStyle);
    }

    public Node representSequence(Tag tag, Iterable<?> iterable, DumperOptions.FlowStyle flowStyle) {
        ArrayList arrayList = new ArrayList(iterable instanceof List ? ((List) iterable).size() : 10);
        SequenceNode sequenceNode = new SequenceNode(tag, arrayList, flowStyle);
        this.representedObjects.put(this.objectToRepresent, sequenceNode);
        DumperOptions.FlowStyle flowStyle2 = DumperOptions.FlowStyle.FLOW;
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            Node nodeRepresentData = representData(it.next());
            if (!(nodeRepresentData instanceof ScalarNode) || !((ScalarNode) nodeRepresentData).isPlain()) {
                flowStyle2 = DumperOptions.FlowStyle.BLOCK;
            }
            arrayList.add(nodeRepresentData);
        }
        DumperOptions.FlowStyle flowStyle3 = DumperOptions.FlowStyle.AUTO;
        if (flowStyle == flowStyle3) {
            DumperOptions.FlowStyle flowStyle4 = this.defaultFlowStyle;
            if (flowStyle4 != flowStyle3) {
                sequenceNode.setFlowStyle(flowStyle4);
                return sequenceNode;
            }
            sequenceNode.setFlowStyle(flowStyle2);
        }
        return sequenceNode;
    }

    public void setDefaultFlowStyle(DumperOptions.FlowStyle flowStyle) {
        this.defaultFlowStyle = flowStyle;
    }

    public void setDefaultScalarStyle(DumperOptions.ScalarStyle scalarStyle) {
        this.defaultScalarStyle = scalarStyle;
    }

    public void setPropertyUtils(PropertyUtils propertyUtils) {
        this.propertyUtils = propertyUtils;
        this.explicitPropertyUtils = true;
    }

    public Node representScalar(Tag tag, String str) {
        return representScalar(tag, str, this.defaultScalarStyle);
    }
}
