package com.uxsense.core.pattern;

import B9.H;
import B9.h0;
import C9.AbstractC0200b;
import C9.C0199a;
import D7.q;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.model.ViewTrigger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0004H\u0086\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0004J'\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0019\"\u00020\u0004¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0019\"\u00020\u0004¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u001d\u001a\u00020\u0004J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010 \u001a\u00020!J\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010#\u001a\u00020\nJ+\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0019\"\u00020\n¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0004J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u001b\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003HÆ\u0003JQ\u0010-\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00032\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u00063"}, d2 = {"Lcom/uxsense/core/pattern/PatternMatchResult;", "", "nodes", "", "", "Lcom/uxsense/core/base/parse/KViewNode;", "valueSources", "Lcom/uxsense/core/pattern/ValueSource;", "triggers", "", "Lcom/uxsense/core/model/ViewTrigger;", AppAgent.CONSTRUCT, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getNodes", "()Ljava/util/Map;", "getValueSources", "getTriggers", "get", HintConstants.AUTOFILL_HINT_NAME, "getValue", "getOrThrow", "contains", "", "getAll", "names", "", "([Ljava/lang/String;)Ljava/util/List;", "getAllNonNull", "getByClassName", "className", "getClickableNodes", "getByNamePattern", "regex", "Lkotlin/text/Regex;", "getByTrigger", "trigger", "getByAnyTrigger", "([Lcom/uxsense/core/model/ViewTrigger;)Ljava/util/Map;", "getNodesWithTriggers", "getTriggersForNode", "toJson", "debugString", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PatternMatchResult {
    private final Map<String, KViewNode> nodes;
    private final Map<String, List<ViewTrigger>> triggers;
    private final Map<String, ValueSource> valueSources;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ValueSource.values().length];
            try {
                iArr[ValueSource.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ValueSource.DESCRIPTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ValueSource.TEXT_OR_DESC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ValueSource.DESC_OR_TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PatternMatchResult(Map<String, KViewNode> nodes, Map<String, ? extends ValueSource> valueSources, Map<String, ? extends List<? extends ViewTrigger>> triggers) {
        k.f(nodes, "nodes");
        k.f(valueSources, "valueSources");
        k.f(triggers, "triggers");
        this.nodes = nodes;
        this.valueSources = valueSources;
        this.triggers = triggers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PatternMatchResult copy$default(PatternMatchResult patternMatchResult, Map map, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            map = patternMatchResult.nodes;
        }
        if ((i & 2) != 0) {
            map2 = patternMatchResult.valueSources;
        }
        if ((i & 4) != 0) {
            map3 = patternMatchResult.triggers;
        }
        return patternMatchResult.copy(map, map2, map3);
    }

    public final Map<String, KViewNode> component1() {
        return this.nodes;
    }

    public final Map<String, ValueSource> component2() {
        return this.valueSources;
    }

    public final Map<String, List<ViewTrigger>> component3() {
        return this.triggers;
    }

    public final boolean contains(String name) {
        k.f(name, "name");
        return this.nodes.containsKey(name);
    }

    public final PatternMatchResult copy(Map<String, KViewNode> nodes, Map<String, ? extends ValueSource> valueSources, Map<String, ? extends List<? extends ViewTrigger>> triggers) {
        k.f(nodes, "nodes");
        k.f(valueSources, "valueSources");
        k.f(triggers, "triggers");
        return new PatternMatchResult(nodes, valueSources, triggers);
    }

    public final String debugString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MatchResult with " + this.nodes.size() + " nodes:");
        sb.append('\n');
        for (Map.Entry<String, KViewNode> entry : this.nodes.entrySet()) {
            String key = entry.getKey();
            KViewNode value = entry.getValue();
            StringBuilder sbV = B7.a.v("  [", key, "] ");
            sbV.append(value.getClassName());
            sb.append(sbV.toString());
            sb.append('\n');
            String text = value.getText();
            if (text != null) {
                sb.append("    text: ".concat(text));
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatternMatchResult)) {
            return false;
        }
        PatternMatchResult patternMatchResult = (PatternMatchResult) other;
        return k.b(this.nodes, patternMatchResult.nodes) && k.b(this.valueSources, patternMatchResult.valueSources) && k.b(this.triggers, patternMatchResult.triggers);
    }

    public final KViewNode get(String name) {
        k.f(name, "name");
        return this.nodes.get(name);
    }

    public final List<KViewNode> getAll(String... names) {
        k.f(names, "names");
        ArrayList arrayList = new ArrayList(names.length);
        for (String str : names) {
            arrayList.add(this.nodes.get(str));
        }
        return arrayList;
    }

    public final List<KViewNode> getAllNonNull(String... names) {
        k.f(names, "names");
        ArrayList arrayList = new ArrayList();
        for (String str : names) {
            KViewNode kViewNode = this.nodes.get(str);
            if (kViewNode != null) {
                arrayList.add(kViewNode);
            }
        }
        return arrayList;
    }

    public final Map<String, KViewNode> getByAnyTrigger(ViewTrigger... triggers) {
        k.f(triggers, "triggers");
        Map<String, KViewNode> map = this.nodes;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, KViewNode> entry : map.entrySet()) {
            List<ViewTrigger> list = this.triggers.get(entry.getKey());
            if (list != null) {
                List<ViewTrigger> list2 = list;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it = list2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (q.N((ViewTrigger) it.next(), triggers)) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                            break;
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public final List<KViewNode> getByClassName(String className) {
        k.f(className, "className");
        Collection<KViewNode> collectionValues = this.nodes.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (k.b(((KViewNode) obj).getClassName(), className)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final Map<String, KViewNode> getByNamePattern(Regex regex) {
        k.f(regex, "regex");
        Map<String, KViewNode> map = this.nodes;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, KViewNode> entry : map.entrySet()) {
            if (regex.d(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public final Map<String, KViewNode> getByTrigger(ViewTrigger trigger) {
        k.f(trigger, "trigger");
        Map<String, KViewNode> map = this.nodes;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, KViewNode> entry : map.entrySet()) {
            List<ViewTrigger> list = this.triggers.get(entry.getKey());
            if (list != null && list.contains(trigger)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public final List<KViewNode> getClickableNodes() {
        Collection<KViewNode> collectionValues = this.nodes.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((KViewNode) obj).getClickable()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final Map<String, KViewNode> getNodes() {
        return this.nodes;
    }

    public final Map<String, KViewNode> getNodesWithTriggers() {
        Map<String, KViewNode> map = this.nodes;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, KViewNode> entry : map.entrySet()) {
            if (this.triggers.get(entry.getKey()) != null && (!r3.isEmpty())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public final KViewNode getOrThrow(String name) {
        k.f(name, "name");
        KViewNode kViewNode = this.nodes.get(name);
        if (kViewNode != null) {
            return kViewNode;
        }
        throw new NoSuchElementException(B7.a.m("Node with name '", name, "' not found in match result"));
    }

    public final Map<String, List<ViewTrigger>> getTriggers() {
        return this.triggers;
    }

    public final List<ViewTrigger> getTriggersForNode(String name) {
        k.f(name, "name");
        List<ViewTrigger> list = this.triggers.get(name);
        return list == null ? EmptyList.f4893a : list;
    }

    public final String getValue(String name) {
        String str;
        k.f(name, "name");
        KViewNode kViewNode = this.nodes.get(name);
        if (kViewNode == null) {
            return null;
        }
        ValueSource valueSource = this.valueSources.get(name);
        if (valueSource == null) {
            valueSource = ValueSource.TEXT;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[valueSource.ordinal()];
        if (i == 1) {
            return kViewNode.getText();
        }
        if (i == 2) {
            return kViewNode.getDescription();
        }
        if (i == 3) {
            String text = kViewNode.getText();
            if (text != null) {
                str = text.length() > 0 ? text : null;
                if (str != null) {
                    return str;
                }
            }
            return kViewNode.getDescription();
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        String description = kViewNode.getDescription();
        if (description != null) {
            str = description.length() > 0 ? description : null;
            if (str != null) {
                return str;
            }
        }
        return kViewNode.getText();
    }

    public final Map<String, ValueSource> getValueSources() {
        return this.valueSources;
    }

    public int hashCode() {
        return this.triggers.hashCode() + androidx.appfunctions.metadata.a.f(this.valueSources, this.nodes.hashCode() * 31, 31);
    }

    public final String toJson() {
        C0199a c0199a = AbstractC0200b.d;
        Map<String, KViewNode> map = this.nodes;
        c0199a.getClass();
        return c0199a.b(new H(h0.f242a, KViewNode.INSTANCE.serializer()), map);
    }

    public String toString() {
        return "PatternMatchResult(nodes=" + this.nodes + ", valueSources=" + this.valueSources + ", triggers=" + this.triggers + ')';
    }

    public /* synthetic */ PatternMatchResult(Map map, Map map2, Map map3, int i, e eVar) {
        this(map, (i & 2) != 0 ? kotlin.collections.a.M() : map2, (i & 4) != 0 ? kotlin.collections.a.M() : map3);
    }
}
