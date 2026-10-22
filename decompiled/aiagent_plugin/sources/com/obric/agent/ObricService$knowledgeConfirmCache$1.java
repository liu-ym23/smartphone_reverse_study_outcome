package com.obric.agent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ObricService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricService$knowledgeConfirmCache$1 extends LinkedHashMap<String, Boolean> {
    ObricService$knowledgeConfirmCache$1() {
        super(10, 0.75f, true);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return false;
    L7:
        return containsKey((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(Boolean r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == true) goto L7;
        return false;
    L7:
        return containsValue((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<String, Boolean>> entrySet() {
        return getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Boolean get(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return get((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
    }

    public Boolean get(String r2) {
        return (Boolean) ZeusTransformUtils.preCheckCast(super.get(r2), Boolean.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object get(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return get((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
    }

    public Set<Map.Entry<String, Boolean>> getEntries() {
        return super.entrySet();
    }

    public Set<String> getKeys() {
        return super.keySet();
    }

    public final Boolean getOrDefault(Object r3, Boolean r4) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
        return r4;
    L6:
        return getOrDefault((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4);
    }

    public Boolean getOrDefault(String r1, Boolean r2) {
        return (Boolean) ZeusTransformUtils.preCheckCast(super.getOrDefault(r1, r2), Boolean.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
        return r4;
    L6:
        return getOrDefault((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin"));
    }

    public int getSize() {
        return super.size();
    }

    public Collection<Boolean> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Boolean remove(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return remove((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
    }

    public Boolean remove(String r2) {
        return (Boolean) ZeusTransformUtils.preCheckCast(super.remove(r2), Boolean.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object remove(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return remove((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.HashMap, java.util.Map
    public final boolean remove(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == true) goto L9;
        return false;
    L9:
        return remove((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin"));
    }

    public /* bridge */ boolean remove(String r1, Boolean r2) {
        return super.remove(r1, r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Collection<Boolean> values() {
        return getValues();
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, Boolean> r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        if (size() <= 10) goto L5;
        return true;
    L5:
        return false;
    }
}
