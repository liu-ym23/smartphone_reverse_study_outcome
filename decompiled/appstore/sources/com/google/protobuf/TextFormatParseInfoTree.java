package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TextFormatParseInfoTree {
    private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
    Map<Descriptors.FieldDescriptor, List<TextFormatParseInfoTree>> subtreesFromField;

    /* JADX INFO: renamed from: com.google.protobuf.TextFormatParseInfoTree$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
        private Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField;

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        public TextFormatParseInfoTree build() {
            return new TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField, null);
        }

        public Builder getBuilderForSubMessageField(Descriptors.FieldDescriptor r10) {
            List<Builder> r11 = this.subtreeBuildersFromField.get(r10);
            if (r11 != null) goto L5;
            r11 = new ArrayList();
            this.subtreeBuildersFromField.put(r10, r11);
        L5:
            Builder r12 = new Builder();
            r11.add(r12);
            return r12;
        }

        public Builder setLocation(Descriptors.FieldDescriptor r10, TextFormatParseLocation r11) {
            List<TextFormatParseLocation> r12 = this.locationsFromField.get(r10);
            if (r12 != null) goto L5;
            r12 = new ArrayList();
            this.locationsFromField.put(r10, r12);
        L5:
            r12.add(r11);
            return this;
        }

        private Builder() {
            this.locationsFromField = new HashMap();
            this.subtreeBuildersFromField = new HashMap();
        }
    }

    public /* synthetic */ TextFormatParseInfoTree(Map r10, Map r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    private static <T> T getFromList(List<T> r10, int r11, Descriptors.FieldDescriptor r12) {
        if (r11 >= r10.size()) goto L9;
        if (r11 < 0) goto L9;
        return r10.get(r11);
    L9:
        if (r12 != null) goto L11;
        String r13 = "<null>";
    L13:
        throw new IllegalArgumentException(String.format("Illegal index field: %s, index %d", new Object[]{r13, Integer.valueOf(r11)}));
    L11:
        r13 = r12.getName();
        goto L13
    }

    public TextFormatParseLocation getLocation(Descriptors.FieldDescriptor r10, int r11) {
        return (TextFormatParseLocation) getFromList(getLocations(r10), r11, r10);
    }

    public List<TextFormatParseLocation> getLocations(Descriptors.FieldDescriptor r10) {
        List<TextFormatParseLocation> r11 = this.locationsFromField.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return Collections.emptyList();
    }

    public TextFormatParseInfoTree getNestedTree(Descriptors.FieldDescriptor r10, int r11) {
        return (TextFormatParseInfoTree) getFromList(getNestedTrees(r10), r11, r10);
    }

    public List<TextFormatParseInfoTree> getNestedTrees(Descriptors.FieldDescriptor r10) {
        List<TextFormatParseInfoTree> r11 = this.subtreesFromField.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return Collections.emptyList();
    }

    private TextFormatParseInfoTree(Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> r10, Map<Descriptors.FieldDescriptor, List<Builder>> r11) {
        HashMap r12 = new HashMap();
        Iterator<Map.Entry<Descriptors.FieldDescriptor, List<TextFormatParseLocation>>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> r14 = r13.next();
        r12.put(r14.getKey(), Collections.unmodifiableList(r14.getValue()));
        goto L4
    L6:
        this.locationsFromField = Collections.unmodifiableMap(r12);
        HashMap r15 = new HashMap();
        Iterator<Map.Entry<Descriptors.FieldDescriptor, List<Builder>>> r16 = r11.entrySet().iterator();
    L8:
        if (r16.hasNext() == false) goto L14;
        Map.Entry<Descriptors.FieldDescriptor, List<Builder>> r17 = r16.next();
        ArrayList r18 = new ArrayList();
        Iterator<Builder> r19 = r17.getValue().iterator();
    L11:
        if (r19.hasNext() == false) goto L13;
        r18.add(r19.next().build());
        goto L11
    L13:
        r15.put(r17.getKey(), Collections.unmodifiableList(r18));
        goto L8
    L14:
        this.subtreesFromField = Collections.unmodifiableMap(r15);
    }
}
