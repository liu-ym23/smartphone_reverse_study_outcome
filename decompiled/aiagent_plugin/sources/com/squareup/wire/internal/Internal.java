package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class Internal {
    public static int countNonNull(Object r2, Object r3) {
        int r0 = 1;
        if (r2 == null) goto L5;
        int r4 = 1;
    L6:
        if (r3 != null) goto L10;
        r0 = 0;
    L10:
        return r4 + r0;
    L5:
        r4 = 0;
        goto L6
    }

    public static int countNonNull(Object r2, Object r3, Object r4) {
        int r0 = 1;
        if (r2 == null) goto L5;
        int r5 = 1;
    L6:
        if (r3 == null) goto L8;
        int r6 = 1;
    L9:
        int r7 = r5 + r6;
        if (r4 != null) goto L14;
        r0 = 0;
    L14:
        return r7 + r0;
    L8:
        r6 = 0;
        goto L9
    L5:
        r5 = 0;
        goto L6
    }

    private Internal() {
    }

    public static <T> List<T> newMutableList() {
        return new MutableOnWriteList(Collections.emptyList());
    }

    public static <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    public static <T> List<T> copyOf(String r2, List<T> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L14;
        if (r4 == Collections.emptyList()) goto L12;
        if (ZeusTransformUtils.instanceOf(r4, ImmutableList.class) == true) goto L12;
        return new ArrayList(r4);
    L12:
        return new MutableOnWriteList(r4);
    L14:
        throw new NullPointerException(r2 + " == null");
    }

    public static <K, V> Map<K, V> copyOf(String r2, Map<K, V> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        return new LinkedHashMap(r4);
    L7:
        throw new NullPointerException(r2 + " == null");
    }

    public static <T> List<T> immutableCopyOf(String r2, List<T> r3) {
        List<T> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L19;
        if (ZeusTransformUtils.instanceOf(r4, MutableOnWriteList.class) == false) goto L8;
        r4 = ((MutableOnWriteList) ZeusTransformUtils.preCheckCast(r4, MutableOnWriteList.class, "com.obric.aiagent.plugin")).mutableList;
    L8:
        if (r4 != Collections.emptyList()) goto L10;
    L17:
        return r4;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, ImmutableList.class) == true) goto L17;
        ImmutableList r0 = new ImmutableList(r4);
        if (r0.contains(null) == true) goto L16;
        return r0;
    L16:
        throw new IllegalArgumentException(r2 + ".contains(null)");
    L19:
        throw new NullPointerException(r2 + " == null");
    }

    public static <K, V> Map<K, V> immutableCopyOf(String r2, Map<K, V> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L19;
        if (r4.isEmpty() == true) goto L7;
        LinkedHashMap r0 = new LinkedHashMap(r4);
        if (r0.containsKey(null) == true) goto L17;
        if (r0.containsValue(null) == true) goto L15;
        return Collections.unmodifiableMap(r0);
    L15:
        throw new IllegalArgumentException(r2 + ".containsValue(null)");
    L17:
        throw new IllegalArgumentException(r2 + ".containsKey(null)");
    L7:
        return Collections.emptyMap();
    L19:
        throw new NullPointerException(r2 + " == null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void redactElements(List<T> r3, ProtoAdapter<T> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.set(r1, r4.redact(r5.get(r1)));
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void redactElements(Map<?, T> r3, ProtoAdapter<T> r4) {
        Iterator r5 = ((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.setValue(r4.redact(r0.getValue()));
        goto L4
    }

    public static boolean equals(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static IllegalStateException missingRequiredFields(Object... r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length;
        String r2 = "";
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L12;
        if (r5[r3] != null) goto L10;
        if (r0.length() <= 0) goto L9;
        r2 = "s";
    L9:
        r0.append("\n  ");
        r0.append(r5[r3 + 1]);
    L10:
        r3 = r3 + 2;
        goto L3
    L12:
        throw new IllegalStateException("Required field" + r2 + " not set:" + r0);
    }

    public static void checkElementsNotNull(List<?> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r4, "list == null");
        int r0 = 0;
        int r1 = r4.size();
    L3:
        if (r0 >= r1) goto L9;
        if (r4.get(r0) == null) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        throw new NullPointerException("Element at index " + r0 + " is null");
    }

    public static void checkElementsNotNull(Map<?, ?> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r5, "map == null");
        Iterator r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r0.getKey(), "map.containsKey(null)");
        if (r0.getValue() != null) goto L4;
        throw new NullPointerException("Value for key " + r0.getKey() + " is null");
    }

    public static int countNonNull(Object r1, Object r2, Object r3, Object r4, Object... r5) {
        int r0 = 0;
        if (r1 == null) goto L5;
        int r6 = 1;
    L6:
        if (r2 == null) goto L8;
        r6 = r6 + 1;
    L8:
        if (r3 == null) goto L10;
        r6 = r6 + 1;
    L10:
        if (r4 == null) goto L12;
        r6 = r6 + 1;
    L12:
        int r7 = r5.length;
    L13:
        if (r0 >= r7) goto L18;
        if (r5[r0] == null) goto L17;
        r6 = r6 + 1;
    L17:
        r0 = r0 + 1;
        goto L13
    L18:
        return r6;
    L5:
        r6 = 0;
        goto L6
    }
}
