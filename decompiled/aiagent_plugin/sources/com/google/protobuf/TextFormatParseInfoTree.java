package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TextFormatParseInfoTree {
    private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
    Map<Descriptors.FieldDescriptor, List<TextFormatParseInfoTree>> subtreesFromField;

    /* JADX INFO: renamed from: com.google.protobuf.TextFormatParseInfoTree$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
        private Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.locationsFromField = new HashMap();
            this.subtreeBuildersFromField = new HashMap();
        }

        public Builder setLocation(Descriptors.FieldDescriptor r4, TextFormatParseLocation r5) {
            List<TextFormatParseLocation> r0 = (List) ZeusTransformUtils.preCheckCast(this.locationsFromField.get(r4), List.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            r0 = new ArrayList();
            this.locationsFromField.put(r4, r0);
        L5:
            r0.add(r5);
            return this;
        }

        public Builder getBuilderForSubMessageField(Descriptors.FieldDescriptor r4) {
            List<Builder> r0 = (List) ZeusTransformUtils.preCheckCast(this.subtreeBuildersFromField.get(r4), List.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            r0 = new ArrayList();
            this.subtreeBuildersFromField.put(r4, r0);
        L5:
            Builder r3 = new Builder();
            r0.add(r3);
            return r3;
        }

        public TextFormatParseInfoTree build() {
            return new TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField, null);
        }
    }

    /* synthetic */ TextFormatParseInfoTree(Map r2, Map r3, AnonymousClass1 r4) {
        this((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    private TextFormatParseInfoTree(Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> r7, Map<Descriptors.FieldDescriptor, List<Builder>> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        Iterator r11 = r9.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.put((Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r2.getKey(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin"), Collections.unmodifiableList((List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.aiagent.plugin")));
        goto L4
    L6:
        this.locationsFromField = Collections.unmodifiableMap(r0);
        HashMap r12 = new HashMap();
        Iterator r13 = r10.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L14;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        ArrayList r3 = new ArrayList();
        Iterator r4 = ((List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r3.add(((Builder) ZeusTransformUtils.preCheckCast(r4.next(), Builder.class, "com.obric.aiagent.plugin")).build());
        goto L11
    L13:
        r12.put((Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r1.getKey(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin"), Collections.unmodifiableList(r3));
        goto L8
    L14:
        this.subtreesFromField = Collections.unmodifiableMap(r12);
    }

    public List<TextFormatParseLocation> getLocations(Descriptors.FieldDescriptor r2) {
        List<TextFormatParseLocation> r1 = (List) ZeusTransformUtils.preCheckCast(this.locationsFromField.get(r2), List.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return Collections.emptyList();
    }

    public TextFormatParseLocation getLocation(Descriptors.FieldDescriptor r1, int r2) {
        return (TextFormatParseLocation) ZeusTransformUtils.preCheckCast(getFromList(getLocations(r1), r2, r1), TextFormatParseLocation.class, "com.obric.aiagent.plugin");
    }

    public List<TextFormatParseInfoTree> getNestedTrees(Descriptors.FieldDescriptor r2) {
        List<TextFormatParseInfoTree> r1 = (List) ZeusTransformUtils.preCheckCast(this.subtreesFromField.get(r2), List.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return Collections.emptyList();
    }

    public TextFormatParseInfoTree getNestedTree(Descriptors.FieldDescriptor r1, int r2) {
        return (TextFormatParseInfoTree) ZeusTransformUtils.preCheckCast(getFromList(getNestedTrees(r1), r2, r1), TextFormatParseInfoTree.class, "com.obric.aiagent.plugin");
    }

    public static Builder builder() {
        return new Builder(null);
    }

    private static <T> T getFromList(List<T> r2, int r3, Descriptors.FieldDescriptor r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r3 >= r5.size()) goto L8;
        if (r3 < 0) goto L8;
        return (T) r5.get(r3);
    L8:
        Object[] r0 = new Object[2];
        if (r4 != null) goto L11;
        String r6 = "<null>";
    L12:
        r0[0] = r6;
        r0[1] = Integer.valueOf(r3);
        throw new IllegalArgumentException(String.format("Illegal index field: %s, index %d", r0));
    L11:
        r6 = r4.getName();
        goto L12
    }
}
