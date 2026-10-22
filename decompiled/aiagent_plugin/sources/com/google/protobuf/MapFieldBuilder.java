package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MapFieldBuilder<KeyT, MessageOrBuilderT extends MessageOrBuilder, MessageT extends MessageOrBuilderT, BuilderT extends MessageOrBuilderT> extends MapFieldReflectionAccessor {
    Map<KeyT, MessageOrBuilderT> builderMap;
    Converter<KeyT, MessageOrBuilderT, MessageT> converter;
    List<Message> messageList;
    Map<KeyT, MessageT> messageMap;

    public interface Converter<KeyT, MessageOrBuilderT extends MessageOrBuilder, MessageT extends MessageOrBuilderT> {
        /* JADX WARN: Incorrect return type in method signature: (TMessageOrBuilderT;)TMessageT; */
        MessageOrBuilder build(MessageOrBuilder r1);

        MapEntry<KeyT, MessageT> defaultEntry();
    }

    public MapFieldBuilder(Converter<KeyT, MessageOrBuilderT, MessageT> r3) {
        Converter<KeyT, MessageOrBuilderT, MessageT> r4 = (Converter) ZeusTransformUtils.wrapperContextForParams(r3, Converter.class, "com.obric.aiagent.plugin");
        this.builderMap = new LinkedHashMap();
        this.messageMap = null;
        this.messageList = null;
        this.converter = r4;
    }

    private List<MapEntry<KeyT, MessageT>> getMapEntryList() {
        ArrayList r0 = new ArrayList(this.messageList.size());
        Class<?> r1 = ((MessageOrBuilder) ZeusTransformUtils.preCheckCast(this.converter.defaultEntry().getValue(), MessageOrBuilder.class, "com.obric.aiagent.plugin")).getClass();
        Iterator<Message> r2 = this.messageList.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Message r4 = (Message) ZeusTransformUtils.preCheckCast(r2.next(), Message.class, "com.obric.aiagent.plugin");
        MapEntry r5 = (MapEntry) ZeusTransformUtils.preCheckCast(r4, MapEntry.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, r5.getValue()) == true) goto L7;
        r0.add(((MapEntry.Builder) ZeusTransformUtils.preCheckCast(this.converter.defaultEntry().toBuilder().mergeFrom(r4), MapEntry.Builder.class, "com.obric.aiagent.plugin")).build());
        goto L4
    L7:
        r0.add(r5);
        goto L4
    L9:
        return r0;
    }

    public Map<KeyT, MessageOrBuilderT> ensureBuilderMap() {
        Map<KeyT, MessageOrBuilderT> r0 = this.builderMap;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.messageMap == null) goto L13;
        this.builderMap = new LinkedHashMap(this.messageMap.size());
        Iterator<Map.Entry<KeyT, MessageT>> r1 = this.messageMap.entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Map<KeyT, MessageOrBuilderT> r4 = this.builderMap;
        Object r5 = r3.getKey();
        r4.put((KeyT) r5, (MessageOrBuilderT) ((MessageOrBuilder) ZeusTransformUtils.preCheckCast(r3.getValue(), MessageOrBuilder.class, "com.obric.aiagent.plugin")));
        goto L9
    L11:
        this.messageMap = null;
        return this.builderMap;
    L13:
        this.builderMap = new LinkedHashMap(this.messageList.size());
        Iterator<MapEntry<KeyT, MessageT>> r2 = getMapEntryList().iterator();
    L15:
        if (r2.hasNext() == false) goto L17;
        MapEntry r6 = (MapEntry) ZeusTransformUtils.preCheckCast(r2.next(), MapEntry.class, "com.obric.aiagent.plugin");
        Map<KeyT, MessageOrBuilderT> r7 = this.builderMap;
        Object r8 = r6.getKey();
        r7.put((KeyT) r8, (MessageOrBuilderT) ((MessageOrBuilder) ZeusTransformUtils.preCheckCast(r6.getValue(), MessageOrBuilder.class, "com.obric.aiagent.plugin")));
        goto L15
    L17:
        this.messageList = null;
        return this.builderMap;
    }

    public List<Message> ensureMessageList() {
        List<Message> r0 = this.messageList;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.builderMap == null) goto L13;
        this.messageList = new ArrayList(this.builderMap.size());
        Iterator<Map.Entry<KeyT, MessageOrBuilderT>> r1 = this.builderMap.entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        this.messageList.add(this.converter.defaultEntry().toBuilder().setKey(r3.getKey()).setValue(this.converter.build((MessageOrBuilder) ZeusTransformUtils.preCheckCast(r3.getValue(), MessageOrBuilder.class, "com.obric.aiagent.plugin"))).build());
        goto L9
    L11:
        this.builderMap = null;
        return this.messageList;
    L13:
        this.messageList = new ArrayList(this.messageMap.size());
        Iterator<Map.Entry<KeyT, MessageT>> r2 = this.messageMap.entrySet().iterator();
    L15:
        if (r2.hasNext() == false) goto L17;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        this.messageList.add(this.converter.defaultEntry().toBuilder().setKey(r4.getKey()).setValue((MessageOrBuilder) ZeusTransformUtils.preCheckCast(r4.getValue(), MessageOrBuilder.class, "com.obric.aiagent.plugin")).build());
        goto L15
    L17:
        this.messageMap = null;
        return this.messageList;
    }

    public Map<KeyT, MessageT> ensureMessageMap() {
        Map<KeyT, MessageT> r0 = populateMutableMap();
        this.messageMap = r0;
        this.builderMap = null;
        this.messageList = null;
        return r0;
    }

    public Map<KeyT, MessageT> getImmutableMap() {
        return new MapField.MutabilityAwareMap(MutabilityOracle.IMMUTABLE, populateMutableMap());
    }

    private Map<KeyT, MessageT> populateMutableMap() {
        Map<KeyT, MessageT> r0 = this.messageMap;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.builderMap == null) goto L12;
        LinkedHashMap r1 = new LinkedHashMap(this.builderMap.size());
        Iterator<Map.Entry<KeyT, MessageOrBuilderT>> r2 = this.builderMap.entrySet().iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r1.put(r3.getKey(), this.converter.build((MessageOrBuilder) ZeusTransformUtils.preCheckCast(r3.getValue(), MessageOrBuilder.class, "com.obric.aiagent.plugin")));
        goto L9
    L11:
        return r1;
    L12:
        LinkedHashMap r4 = new LinkedHashMap(this.messageList.size());
        Iterator<MapEntry<KeyT, MessageT>> r7 = getMapEntryList().iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        MapEntry r5 = (MapEntry) ZeusTransformUtils.preCheckCast(r7.next(), MapEntry.class, "com.obric.aiagent.plugin");
        r4.put(r5.getKey(), (MessageOrBuilder) ZeusTransformUtils.preCheckCast(r5.getValue(), MessageOrBuilder.class, "com.obric.aiagent.plugin"));
        goto L14
    L16:
        return r4;
    }

    public void mergeFrom(MapField<KeyT, MessageT> r1) {
        ensureBuilderMap().putAll(MapFieldLite.copy(r1.getMap()));
    }

    public void clear() {
        this.builderMap = new LinkedHashMap();
        this.messageMap = null;
        this.messageList = null;
    }

    private boolean typedEquals(MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> r1) {
        return MapFieldLite.equals(ensureBuilderMap(), r1.ensureBuilderMap());
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, MapFieldBuilder.class) == true) goto L7;
        return false;
    L7:
        return typedEquals((MapFieldBuilder) ZeusTransformUtils.preCheckCast(r3, MapFieldBuilder.class, "com.obric.aiagent.plugin"));
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(ensureBuilderMap());
    }

    public MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> copy() {
        MapFieldBuilder<KeyT, MessageOrBuilderT, MessageT, BuilderT> r0 = new MapFieldBuilder(this.converter);
        r0.ensureBuilderMap().putAll(ensureBuilderMap());
        return r0;
    }

    public MapField<KeyT, MessageT> build(MapEntry<KeyT, MessageT> r8) {
        MapField<KeyT, MessageT> r9 = MapField.newMapField(r8);
        Map<KeyT, MessageT> r0 = r9.getMutableMap();
        Iterator<Map.Entry<KeyT, MessageOrBuilderT>> r1 = ensureBuilderMap().entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.put(r2.getKey(), this.converter.build((MessageOrBuilder) ZeusTransformUtils.preCheckCast(r2.getValue(), MessageOrBuilder.class, "com.obric.aiagent.plugin")));
        goto L4
    L6:
        r9.makeImmutable();
        return r9;
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    List<Message> getList() {
        return ensureMessageList();
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    List<Message> getMutableList() {
        return ensureMessageList();
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    Message getMapEntryMessageDefaultInstance() {
        return this.converter.defaultEntry();
    }
}
