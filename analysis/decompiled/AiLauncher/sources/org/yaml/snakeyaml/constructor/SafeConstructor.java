package org.yaml.snakeyaml.constructor;

import O6.l;
import W4.a;
import io.ktor.sse.ServerSentEventKt;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.internal.Logger;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes5.dex */
public class SafeConstructor extends BaseConstructor {
    private static final Map<String, Boolean> BOOL_VALUES;
    private static final int[][] RADIX_MAX;
    private static final Pattern TIMESTAMP_REGEXP;
    private static final Pattern YMD_REGEXP;
    public static final ConstructUndefined undefinedConstructor = new ConstructUndefined();
    private Logger log;

    /* renamed from: org.yaml.snakeyaml.constructor.SafeConstructor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$yaml$snakeyaml$nodes$NodeId;

        static {
            int[] iArr = new int[NodeId.values().length];
            $SwitchMap$org$yaml$snakeyaml$nodes$NodeId = iArr;
            try {
                iArr[NodeId.mapping.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$nodes$NodeId[NodeId.sequence.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class ConstructUndefined extends AbstractConstruct {
        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            throw new ConstructorException(null, null, "could not determine a constructor for the tag " + node.getTag(), node.getStartMark());
        }
    }

    public class ConstructYamlBinary extends AbstractConstruct {
        public ConstructYamlBinary() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            return Base64.getDecoder().decode(SafeConstructor.this.constructScalar((ScalarNode) node).replaceAll("\\s", ""));
        }
    }

    public class ConstructYamlBool extends AbstractConstruct {
        public ConstructYamlBool() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            return SafeConstructor.BOOL_VALUES.get(SafeConstructor.this.constructScalar((ScalarNode) node).toLowerCase());
        }
    }

    public class ConstructYamlFloat extends AbstractConstruct {
        public ConstructYamlFloat() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            int i10;
            String strReplaceAll = SafeConstructor.this.constructScalar((ScalarNode) node).replaceAll("_", "");
            if (strReplaceAll.isEmpty()) {
                throw new ConstructorException("while constructing a float", node.getStartMark(), "found empty value", node.getStartMark());
            }
            char cCharAt = strReplaceAll.charAt(0);
            if (cCharAt == '-') {
                strReplaceAll = strReplaceAll.substring(1);
                i10 = -1;
            } else {
                if (cCharAt == '+') {
                    strReplaceAll = strReplaceAll.substring(1);
                }
                i10 = 1;
            }
            String lowerCase = strReplaceAll.toLowerCase();
            if (".inf".equals(lowerCase)) {
                return Double.valueOf(i10 == -1 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            if (".nan".equals(lowerCase)) {
                return Double.valueOf(Double.NaN);
            }
            if (strReplaceAll.indexOf(58) == -1) {
                return Double.valueOf(Double.valueOf(strReplaceAll).doubleValue() * i10);
            }
            String[] strArrSplit = strReplaceAll.split(ServerSentEventKt.COLON);
            int length = strArrSplit.length;
            double d10 = 0.0d;
            int i11 = 1;
            for (int i12 = 0; i12 < length; i12++) {
                d10 += Double.parseDouble(strArrSplit[(length - i12) - 1]) * i11;
                i11 *= 60;
            }
            return Double.valueOf(i10 * d10);
        }
    }

    public class ConstructYamlInt extends AbstractConstruct {
        public ConstructYamlInt() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            int i10;
            String strSubstring;
            String strReplace = SafeConstructor.this.constructScalar((ScalarNode) node).replace("_", "");
            if (strReplace.isEmpty()) {
                throw new ConstructorException("while constructing an int", node.getStartMark(), "found empty value", node.getStartMark());
            }
            char cCharAt = strReplace.charAt(0);
            if (cCharAt == '-') {
                strReplace = strReplace.substring(1);
                i10 = -1;
            } else {
                if (cCharAt == '+') {
                    strReplace = strReplace.substring(1);
                }
                i10 = 1;
            }
            if ("0".equals(strReplace)) {
                return 0;
            }
            int i11 = 2;
            if (strReplace.startsWith("0b")) {
                strSubstring = strReplace.substring(2);
            } else if (strReplace.startsWith("0x")) {
                strSubstring = strReplace.substring(2);
                i11 = 16;
            } else {
                if (!strReplace.startsWith("0")) {
                    if (strReplace.indexOf(58) == -1) {
                        return SafeConstructor.this.createNumber(i10, strReplace, 10);
                    }
                    String[] strArrSplit = strReplace.split(ServerSentEventKt.COLON);
                    int length = strArrSplit.length;
                    int i12 = 0;
                    int i13 = 1;
                    for (int i14 = 0; i14 < length; i14++) {
                        i12 = (int) (i12 + (Long.parseLong(strArrSplit[(length - i14) - 1]) * i13));
                        i13 *= 60;
                    }
                    return SafeConstructor.this.createNumber(i10, String.valueOf(i12), 10);
                }
                strSubstring = strReplace.substring(1);
                i11 = 8;
            }
            return SafeConstructor.this.createNumber(i10, strSubstring, i11);
        }
    }

    public class ConstructYamlMap implements Construct {
        public ConstructYamlMap() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            MappingNode mappingNode = (MappingNode) node;
            return node.isTwoStepsConstruction() ? SafeConstructor.this.createDefaultMap(mappingNode.getValue().size()) : SafeConstructor.this.constructMapping(mappingNode);
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            if (node.isTwoStepsConstruction()) {
                SafeConstructor.this.constructMapping2ndStep((MappingNode) node, (Map) obj);
                return;
            }
            throw new YAMLException("Unexpected recursive mapping structure. Node: " + node);
        }
    }

    public class ConstructYamlNull extends AbstractConstruct {
        public ConstructYamlNull() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            if (node == null) {
                return null;
            }
            SafeConstructor.this.constructScalar((ScalarNode) node);
            return null;
        }
    }

    public class ConstructYamlOmap extends AbstractConstruct {
        public ConstructYamlOmap() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!(node instanceof SequenceNode)) {
                throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a sequence, but found " + node.getNodeId(), node.getStartMark());
            }
            for (Node node2 : ((SequenceNode) node).getValue()) {
                if (!(node2 instanceof MappingNode)) {
                    throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a mapping of length 1, but found " + node2.getNodeId(), node2.getStartMark());
                }
                MappingNode mappingNode = (MappingNode) node2;
                if (mappingNode.getValue().size() != 1) {
                    throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a single mapping item, but found " + mappingNode.getValue().size() + " items", mappingNode.getStartMark());
                }
                linkedHashMap.put(SafeConstructor.this.constructObject(mappingNode.getValue().get(0).getKeyNode()), SafeConstructor.this.constructObject(mappingNode.getValue().get(0).getValueNode()));
            }
            return linkedHashMap;
        }
    }

    public class ConstructYamlPairs extends AbstractConstruct {
        public ConstructYamlPairs() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            if (!(node instanceof SequenceNode)) {
                throw new ConstructorException("while constructing pairs", node.getStartMark(), "expected a sequence, but found " + node.getNodeId(), node.getStartMark());
            }
            SequenceNode sequenceNode = (SequenceNode) node;
            ArrayList arrayList = new ArrayList(sequenceNode.getValue().size());
            for (Node node2 : sequenceNode.getValue()) {
                if (!(node2 instanceof MappingNode)) {
                    throw new ConstructorException("while constructingpairs", node.getStartMark(), "expected a mapping of length 1, but found " + node2.getNodeId(), node2.getStartMark());
                }
                MappingNode mappingNode = (MappingNode) node2;
                if (mappingNode.getValue().size() != 1) {
                    throw new ConstructorException("while constructing pairs", node.getStartMark(), "expected a single mapping item, but found " + mappingNode.getValue().size() + " items", mappingNode.getStartMark());
                }
                arrayList.add(new Object[]{SafeConstructor.this.constructObject(mappingNode.getValue().get(0).getKeyNode()), SafeConstructor.this.constructObject(mappingNode.getValue().get(0).getValueNode())});
            }
            return arrayList;
        }
    }

    public class ConstructYamlSeq implements Construct {
        public ConstructYamlSeq() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            SequenceNode sequenceNode = (SequenceNode) node;
            return node.isTwoStepsConstruction() ? SafeConstructor.this.newList(sequenceNode) : SafeConstructor.this.constructSequence(sequenceNode);
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            if (node.isTwoStepsConstruction()) {
                SafeConstructor.this.constructSequenceStep2((SequenceNode) node, (List) obj);
                return;
            }
            throw new YAMLException("Unexpected recursive sequence structure. Node: " + node);
        }
    }

    public class ConstructYamlSet implements Construct {
        public ConstructYamlSet() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            return node.isTwoStepsConstruction() ? SafeConstructor.this.constructedObjects.containsKey(node) ? SafeConstructor.this.constructedObjects.get(node) : SafeConstructor.this.createDefaultSet(((MappingNode) node).getValue().size()) : SafeConstructor.this.constructSet((MappingNode) node);
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            if (node.isTwoStepsConstruction()) {
                SafeConstructor.this.constructSet2ndStep((MappingNode) node, (Set) obj);
                return;
            }
            throw new YAMLException("Unexpected recursive set structure. Node: " + node);
        }
    }

    public class ConstructYamlStr extends AbstractConstruct {
        public ConstructYamlStr() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            return SafeConstructor.this.constructScalar((ScalarNode) node);
        }
    }

    public static class ConstructYamlTimestamp extends AbstractConstruct {
        private Calendar calendar;

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) throws NumberFormatException {
            TimeZone timeZone;
            String str;
            String value = ((ScalarNode) node).getValue();
            Matcher matcher = SafeConstructor.YMD_REGEXP.matcher(value);
            if (matcher.matches()) {
                String strGroup = matcher.group(1);
                String strGroup2 = matcher.group(2);
                String strGroup3 = matcher.group(3);
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                this.calendar = calendar;
                calendar.clear();
                this.calendar.set(1, Integer.parseInt(strGroup));
                this.calendar.set(2, Integer.parseInt(strGroup2) - 1);
                this.calendar.set(5, Integer.parseInt(strGroup3));
                return this.calendar.getTime();
            }
            Matcher matcher2 = SafeConstructor.TIMESTAMP_REGEXP.matcher(value);
            if (!matcher2.matches()) {
                throw new YAMLException("Unexpected timestamp: " + value);
            }
            String strGroup4 = matcher2.group(1);
            String strGroup5 = matcher2.group(2);
            String strGroup6 = matcher2.group(3);
            String strGroup7 = matcher2.group(4);
            String strGroup8 = matcher2.group(5);
            String strGroup9 = matcher2.group(6);
            String strGroup10 = matcher2.group(7);
            if (strGroup10 != null) {
                strGroup9 = strGroup9 + "." + strGroup10;
            }
            double d10 = Double.parseDouble(strGroup9);
            int iRound = (int) Math.round(Math.floor(d10));
            int iRound2 = (int) Math.round((d10 - iRound) * 1000.0d);
            String strGroup11 = matcher2.group(8);
            String strGroup12 = matcher2.group(9);
            if (strGroup11 != null) {
                if (strGroup12 != null) {
                    str = ServerSentEventKt.COLON + strGroup12;
                } else {
                    str = "00";
                }
                timeZone = TimeZone.getTimeZone("GMT" + strGroup11 + str);
            } else {
                timeZone = TimeZone.getTimeZone("UTC");
            }
            Calendar calendar2 = Calendar.getInstance(timeZone);
            this.calendar = calendar2;
            calendar2.set(1, Integer.parseInt(strGroup4));
            this.calendar.set(2, Integer.parseInt(strGroup5) - 1);
            this.calendar.set(5, Integer.parseInt(strGroup6));
            this.calendar.set(11, Integer.parseInt(strGroup7));
            this.calendar.set(12, Integer.parseInt(strGroup8));
            this.calendar.set(13, iRound);
            this.calendar.set(14, iRound2);
            return this.calendar.getTime();
        }

        public Calendar getCalendar() {
            return this.calendar;
        }
    }

    static {
        HashMap map = new HashMap();
        BOOL_VALUES = map;
        Boolean bool = Boolean.TRUE;
        map.put("yes", bool);
        Boolean bool2 = Boolean.FALSE;
        map.put("no", bool2);
        map.put("true", bool);
        map.put("false", bool2);
        map.put(a.ENABLE_ON, bool);
        map.put(a.ENABLE_OFF, bool2);
        RADIX_MAX = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 17, 2);
        int[] iArr = {2, 8, 10, 16};
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = iArr[i10];
            RADIX_MAX[i11] = new int[]{maxLen(Integer.MAX_VALUE, i11), maxLen(Long.MAX_VALUE, i11)};
        }
        TIMESTAMP_REGEXP = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)(?:(?:[Tt]|[ \t]+)([0-9][0-9]?):([0-9][0-9]):([0-9][0-9])(?:\\.([0-9]*))?(?:[ \t]*(?:Z|([-+][0-9][0-9]?)(?::([0-9][0-9])?)?))?)?$");
        YMD_REGEXP = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)$");
    }

    public SafeConstructor(LoaderOptions loaderOptions) {
        super(loaderOptions);
        this.log = Logger.getLogger(getClass().getName());
        this.yamlConstructors.put(Tag.NULL, new ConstructYamlNull());
        this.yamlConstructors.put(Tag.BOOL, new ConstructYamlBool());
        this.yamlConstructors.put(Tag.INT, new ConstructYamlInt());
        this.yamlConstructors.put(Tag.FLOAT, new ConstructYamlFloat());
        this.yamlConstructors.put(Tag.BINARY, new ConstructYamlBinary());
        this.yamlConstructors.put(Tag.TIMESTAMP, new ConstructYamlTimestamp());
        this.yamlConstructors.put(Tag.OMAP, new ConstructYamlOmap());
        this.yamlConstructors.put(Tag.PAIRS, new ConstructYamlPairs());
        this.yamlConstructors.put(Tag.SET, new ConstructYamlSet());
        this.yamlConstructors.put(Tag.STR, new ConstructYamlStr());
        this.yamlConstructors.put(Tag.SEQ, new ConstructYamlSeq());
        this.yamlConstructors.put(Tag.MAP, new ConstructYamlMap());
        Map<Tag, Construct> map = this.yamlConstructors;
        ConstructUndefined constructUndefined = undefinedConstructor;
        map.put(null, constructUndefined);
        this.yamlClassConstructors.put(NodeId.scalar, constructUndefined);
        this.yamlClassConstructors.put(NodeId.sequence, constructUndefined);
        this.yamlClassConstructors.put(NodeId.mapping, constructUndefined);
    }

    public static Number createLongOrBigInteger(String str, int i10) {
        try {
            return Long.valueOf(str, i10);
        } catch (NumberFormatException unused) {
            return new BigInteger(str, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Number createNumber(int i10, String str, int i11) {
        int length = str != null ? str.length() : 0;
        if (i10 < 0) {
            str = l.DATE_SEPARATOR + str;
        }
        int[][] iArr = RADIX_MAX;
        int[] iArr2 = i11 < iArr.length ? iArr[i11] : null;
        if (iArr2 != null && length > iArr2[0]) {
            return length > iArr2[1] ? new BigInteger(str, i11) : createLongOrBigInteger(str, i11);
        }
        try {
            return Integer.valueOf(str, i11);
        } catch (NumberFormatException unused) {
            return createLongOrBigInteger(str, i11);
        }
    }

    private static int maxLen(int i10, int i11) {
        return Integer.toString(i10, i11).length();
    }

    private List<NodeTuple> mergeNode(MappingNode mappingNode, boolean z10, Map<Object, Integer> map, List<NodeTuple> list, boolean z11) {
        Iterator<NodeTuple> it = mappingNode.getValue().iterator();
        while (it.hasNext()) {
            NodeTuple next = it.next();
            Node keyNode = next.getKeyNode();
            Node valueNode = next.getValueNode();
            if (keyNode.getTag().equals(Tag.MERGE)) {
                it.remove();
                int i10 = AnonymousClass1.$SwitchMap$org$yaml$snakeyaml$nodes$NodeId[valueNode.getNodeId().ordinal()];
                if (i10 == 1) {
                    mergeNode((MappingNode) valueNode, false, map, list, z11);
                } else {
                    if (i10 != 2) {
                        throw new ConstructorException("while constructing a mapping", mappingNode.getStartMark(), "expected a mapping or list of mappings for merging, but found " + valueNode.getNodeId(), valueNode.getStartMark());
                    }
                    for (Node node : ((SequenceNode) valueNode).getValue()) {
                        if (!(node instanceof MappingNode)) {
                            throw new ConstructorException("while constructing a mapping", mappingNode.getStartMark(), "expected a mapping for merging, but found " + node.getNodeId(), node.getStartMark());
                        }
                        mergeNode((MappingNode) node, false, map, list, z11);
                    }
                }
            } else {
                if (z11) {
                    if (!(keyNode instanceof ScalarNode)) {
                        throw new YAMLException("Keys must be scalars but found: " + keyNode);
                    }
                    keyNode.setType(String.class);
                    keyNode.setTag(Tag.STR);
                }
                Object objConstructObject = constructObject(keyNode);
                if (!map.containsKey(objConstructObject)) {
                    list.add(next);
                    map.put(objConstructObject, Integer.valueOf(list.size() - 1));
                } else if (z10) {
                    list.set(map.get(objConstructObject).intValue(), next);
                }
            }
        }
        return list;
    }

    @Override // org.yaml.snakeyaml.constructor.BaseConstructor
    public void constructMapping2ndStep(MappingNode mappingNode, Map<Object, Object> map) {
        flattenMapping(mappingNode);
        super.constructMapping2ndStep(mappingNode, map);
    }

    @Override // org.yaml.snakeyaml.constructor.BaseConstructor
    public void constructSet2ndStep(MappingNode mappingNode, Set<Object> set) {
        flattenMapping(mappingNode);
        super.constructSet2ndStep(mappingNode, set);
    }

    public void flattenMapping(MappingNode mappingNode) {
        flattenMapping(mappingNode, false);
    }

    public void processDuplicateKeys(MappingNode mappingNode) {
        processDuplicateKeys(mappingNode, false);
    }

    private static int maxLen(long j10, int i10) {
        return Long.toString(j10, i10).length();
    }

    public void flattenMapping(MappingNode mappingNode, boolean z10) {
        processDuplicateKeys(mappingNode, z10);
        if (mappingNode.isMerged()) {
            mappingNode.setValue(mergeNode(mappingNode, true, new HashMap(), new ArrayList(), z10));
        }
    }

    public void processDuplicateKeys(MappingNode mappingNode, boolean z10) {
        List<NodeTuple> value = mappingNode.getValue();
        HashMap map = new HashMap(value.size());
        TreeSet treeSet = new TreeSet();
        int i10 = 0;
        for (NodeTuple nodeTuple : value) {
            Node keyNode = nodeTuple.getKeyNode();
            if (!keyNode.getTag().equals(Tag.MERGE)) {
                if (z10) {
                    if (!(keyNode instanceof ScalarNode)) {
                        throw new YAMLException("Keys must be scalars but found: " + keyNode);
                    }
                    keyNode.setType(String.class);
                    keyNode.setTag(Tag.STR);
                }
                Object objConstructObject = constructObject(keyNode);
                if (objConstructObject != null && !z10 && keyNode.isTwoStepsConstruction()) {
                    if (!this.loadingConfig.getAllowRecursiveKeys()) {
                        throw new YAMLException("Recursive key for mapping is detected but it is not configured to be allowed.");
                    }
                    try {
                        objConstructObject.hashCode();
                    } catch (Exception e10) {
                        throw new ConstructorException("while constructing a mapping", mappingNode.getStartMark(), "found unacceptable key " + objConstructObject, nodeTuple.getKeyNode().getStartMark(), e10);
                    }
                }
                Integer num = (Integer) map.put(objConstructObject, Integer.valueOf(i10));
                if (num == null) {
                    continue;
                } else {
                    if (!isAllowDuplicateKeys()) {
                        throw new DuplicateKeyException(mappingNode.getStartMark(), objConstructObject, nodeTuple.getKeyNode().getStartMark());
                    }
                    if (isWarnOnDuplicateKeys() && this.log.isLoggable(Logger.Level.WARNING)) {
                        this.log.warn(String.format("duplicate keys found : %s", objConstructObject));
                    }
                    treeSet.add(num);
                }
            }
            i10++;
        }
        Iterator itDescendingIterator = treeSet.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            value.remove(((Integer) itDescendingIterator.next()).intValue());
        }
    }
}
