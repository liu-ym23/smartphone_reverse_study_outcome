package org.yaml.snakeyaml.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes5.dex */
public abstract class MergeUtils {
    private Tuple<List<NodeTuple>, Set<String>> filter(List<NodeTuple> list, Set<String> set) {
        int size = list.size();
        HashSet hashSet = new HashSet(size);
        ArrayList arrayList = new ArrayList(size);
        for (NodeTuple nodeTuple : list) {
            Node keyNode = nodeTuple.getKeyNode();
            if (keyNode instanceof ScalarNode) {
                String value = ((ScalarNode) keyNode).getValue();
                if (!set.contains(value)) {
                    arrayList.add(nodeTuple);
                    hashSet.add(value);
                }
            } else {
                arrayList.add(nodeTuple);
            }
        }
        return new Tuple<>(arrayList, hashSet);
    }

    public abstract MappingNode asMappingNode(Node node);

    public List<NodeTuple> flatten(MappingNode mappingNode) {
        boolean z10;
        List<NodeTuple> value = mappingNode.getValue();
        List<NodeTuple> list = value;
        for (boolean z11 = true; z11; z11 = z10) {
            value = new ArrayList<>(list.size());
            HashSet hashSet = new HashSet(list.size());
            ArrayList arrayList = new ArrayList(2);
            for (NodeTuple nodeTuple : list) {
                Node keyNode = nodeTuple.getKeyNode();
                if (keyNode.getTag().equals(Tag.MERGE)) {
                    arrayList.add(nodeTuple);
                } else {
                    value.add(nodeTuple);
                    if (keyNode instanceof ScalarNode) {
                        hashSet.add(((ScalarNode) keyNode).getValue());
                    }
                }
            }
            Iterator it = arrayList.iterator();
            z10 = false;
            while (it.hasNext()) {
                Node valueNode = ((NodeTuple) it.next()).getValueNode();
                if (valueNode instanceof SequenceNode) {
                    Iterator<Node> it2 = ((SequenceNode) valueNode).getValue().iterator();
                    while (it2.hasNext()) {
                        MappingNode mappingNodeAsMappingNode = asMappingNode(it2.next());
                        z10 = z10 || mappingNodeAsMappingNode.isMerged();
                        Tuple<List<NodeTuple>, Set<String>> tupleFilter = filter(mappingNodeAsMappingNode.getValue(), hashSet);
                        value.addAll(tupleFilter._1());
                        hashSet.addAll(tupleFilter._2());
                    }
                } else {
                    MappingNode mappingNodeAsMappingNode2 = asMappingNode(valueNode);
                    z10 = z10 || mappingNodeAsMappingNode2.isMerged();
                    Tuple<List<NodeTuple>, Set<String>> tupleFilter2 = filter(mappingNodeAsMappingNode2.getValue(), hashSet);
                    value.addAll(tupleFilter2._1());
                    hashSet.addAll(tupleFilter2._2());
                }
            }
            if (z10) {
                list = value;
            }
        }
        return value;
    }
}
