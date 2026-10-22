package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class RepeatedFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private List<SingleFieldBuilderV3<MType, BType, IType>> builders;
    private BuilderExternalList<MType, BType, IType> externalBuilderList;
    private MessageExternalList<MType, BType, IType> externalMessageList;
    private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    private boolean isClean;
    private boolean isMessagesListMutable;
    private List<MType> messages;
    private AbstractMessage.BuilderParent parent;

    private static class BuilderExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements List<BType>, RandomAccess {
        RepeatedFieldBuilderV3<MType, BType, IType> builder;

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Deprecated
        BuilderExternalList(RepeatedFieldBuilderV3<MType, BType, IType> r1) {
            this.builder = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public BType get(int r1) {
            return (BType) this.builder.getBuilder(r1);
        }

        @Deprecated
        void incrementModCount() {
            this.modCount++;
        }
    }

    private static class MessageExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements List<MType>, RandomAccess {
        RepeatedFieldBuilderV3<MType, BType, IType> builder;

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Deprecated
        MessageExternalList(RepeatedFieldBuilderV3<MType, BType, IType> r1) {
            this.builder = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public MType get(int r1) {
            return (MType) this.builder.getMessage(r1);
        }

        @Deprecated
        void incrementModCount() {
            this.modCount++;
        }
    }

    private static class MessageOrBuilderExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements List<IType>, RandomAccess {
        RepeatedFieldBuilderV3<MType, BType, IType> builder;

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        MessageOrBuilderExternalList(RepeatedFieldBuilderV3<MType, BType, IType> r1) {
            this.builder = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public IType get(int r1) {
            return (IType) this.builder.getMessageOrBuilder(r1);
        }

        @Deprecated
        void incrementModCount() {
            this.modCount++;
        }
    }

    @Deprecated
    public RepeatedFieldBuilderV3(List<MType> r3, boolean r4, AbstractMessage.BuilderParent r5, boolean r6) {
        List<MType> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        AbstractMessage.BuilderParent r8 = (AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r5, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin");
        this.messages = r7;
        this.isMessagesListMutable = r4;
        this.parent = r8;
        this.isClean = r6;
    }

    @Deprecated
    public void dispose() {
        this.parent = null;
    }

    private void ensureMutableMessageList() {
        if (this.isMessagesListMutable == true) goto L6;
        this.messages = new ArrayList(this.messages);
        this.isMessagesListMutable = true;
        return;
    }

    private void ensureBuilders() {
        if (this.builders != null) goto L8;
        this.builders = new ArrayList(this.messages.size());
        int r0 = 0;
    L6:
        if (r0 >= this.messages.size()) goto L10;
        this.builders.add(null);
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    @Deprecated
    public int getCount() {
        return this.messages.size();
    }

    @Deprecated
    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    @Deprecated
    public MType getMessage(int r2) {
        return (MType) getMessage(r2, false);
    }

    private MType getMessage(int r4, boolean r5) {
        List<SingleFieldBuilderV3<MType, BType, IType>> r0 = this.builders;
        if (r0 == null) goto L5;
        SingleFieldBuilderV3 r1 = (SingleFieldBuilderV3) ZeusTransformUtils.preCheckCast(r0.get(r4), SingleFieldBuilderV3.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        if (r5 == false) goto L13;
        return (MType) r1.build();
    L13:
        return (MType) r1.getMessage();
    L9:
        return (MType) ZeusTransformUtils.preCheckCast(this.messages.get(r4), AbstractMessage.class, "com.obric.aiagent.plugin");
    L5:
        return (MType) ZeusTransformUtils.preCheckCast(this.messages.get(r4), AbstractMessage.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public BType getBuilder(int r4) {
        ensureBuilders();
        SingleFieldBuilderV3<MType, BType, IType> r0 = (SingleFieldBuilderV3) ZeusTransformUtils.preCheckCast(this.builders.get(r4), SingleFieldBuilderV3.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        SingleFieldBuilderV3<MType, BType, IType> r1 = new SingleFieldBuilderV3((AbstractMessage) ZeusTransformUtils.preCheckCast(this.messages.get(r4), AbstractMessage.class, "com.obric.aiagent.plugin"), this, this.isClean);
        this.builders.set(r4, r1);
        r0 = r1;
    L6:
        return (BType) r0.getBuilder();
    }

    @Deprecated
    public IType getMessageOrBuilder(int r4) {
        List<SingleFieldBuilderV3<MType, BType, IType>> r0 = this.builders;
        if (r0 == null) goto L5;
        SingleFieldBuilderV3 r1 = (SingleFieldBuilderV3) ZeusTransformUtils.preCheckCast(r0.get(r4), SingleFieldBuilderV3.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L11;
        return (IType) ZeusTransformUtils.preCheckCast(this.messages.get(r4), MessageOrBuilder.class, "com.obric.aiagent.plugin");
    L11:
        return (IType) r1.getMessageOrBuilder();
    L5:
        return (IType) ZeusTransformUtils.preCheckCast(this.messages.get(r4), MessageOrBuilder.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public RepeatedFieldBuilderV3<MType, BType, IType> setMessage(int r2, MType r3) {
        Internal.checkNotNull(r3);
        ensureMutableMessageList();
        this.messages.set(r2, r3);
        List<SingleFieldBuilderV3<MType, BType, IType>> r4 = this.builders;
        if (r4 == null) goto L7;
        SingleFieldBuilderV3 r5 = (SingleFieldBuilderV3) ZeusTransformUtils.preCheckCast(r4.set(r2, null), SingleFieldBuilderV3.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L7;
        r5.dispose();
    L7:
        onChanged();
        incrementModCounts();
        return this;
    }

    @Deprecated
    public RepeatedFieldBuilderV3<MType, BType, IType> addMessage(MType r2) {
        Internal.checkNotNull(r2);
        ensureMutableMessageList();
        this.messages.add(r2);
        List<SingleFieldBuilderV3<MType, BType, IType>> r3 = this.builders;
        if (r3 == null) goto L5;
        r3.add(null);
    L5:
        onChanged();
        incrementModCounts();
        return this;
    }

    @Deprecated
    public RepeatedFieldBuilderV3<MType, BType, IType> addMessage(int r2, MType r3) {
        Internal.checkNotNull(r3);
        ensureMutableMessageList();
        this.messages.add(r2, r3);
        List<SingleFieldBuilderV3<MType, BType, IType>> r4 = this.builders;
        if (r4 == null) goto L5;
        r4.add(r2, null);
    L5:
        onChanged();
        incrementModCounts();
        return this;
    }

    @Deprecated
    public RepeatedFieldBuilderV3<MType, BType, IType> addAllMessages(Iterable<? extends MType> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.aiagent.plugin");
        Iterator r0 = r6.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Internal.checkNotNull((AbstractMessage) ZeusTransformUtils.preCheckCast(r0.next(), AbstractMessage.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        int r1 = -1;
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == false) goto L12;
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin");
        if (r2.isEmpty() == false) goto L11;
        return this;
    L11:
        r1 = r2.size();
    L12:
        ensureMutableMessageList();
        if (r1 >= 0) goto L15;
    L17:
        Iterator r7 = r6.iterator();
    L19:
        if (r7.hasNext() == false) goto L21;
        addMessage((AbstractMessage) ZeusTransformUtils.preCheckCast(r7.next(), AbstractMessage.class, "com.obric.aiagent.plugin"));
        goto L19
    L21:
        onChanged();
        incrementModCounts();
        return this;
    L15:
        if (ZeusTransformUtils.instanceOf(this.messages, ArrayList.class) == false) goto L17;
        ((ArrayList) ZeusTransformUtils.preCheckCast(this.messages, ArrayList.class, "com.obric.aiagent.plugin")).ensureCapacity(this.messages.size() + r1);
        goto L17
    }

    @Deprecated
    public BType addBuilder(MType r3) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilderV3<MType, BType, IType> r0 = new SingleFieldBuilderV3(r3, this, this.isClean);
        this.messages.add(null);
        this.builders.add(r0);
        onChanged();
        incrementModCounts();
        return (BType) r0.getBuilder();
    }

    @Deprecated
    public BType addBuilder(int r3, MType r4) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilderV3<MType, BType, IType> r0 = new SingleFieldBuilderV3(r4, this, this.isClean);
        this.messages.add(r3, null);
        this.builders.add(r3, r0);
        onChanged();
        incrementModCounts();
        return (BType) r0.getBuilder();
    }

    @Deprecated
    public void remove(int r3) {
        ensureMutableMessageList();
        this.messages.remove(r3);
        List<SingleFieldBuilderV3<MType, BType, IType>> r0 = this.builders;
        if (r0 == null) goto L7;
        SingleFieldBuilderV3 r4 = (SingleFieldBuilderV3) ZeusTransformUtils.preCheckCast(r0.remove(r3), SingleFieldBuilderV3.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        r4.dispose();
    L7:
        onChanged();
        incrementModCounts();
    }

    @Deprecated
    public void clear() {
        this.messages = Collections.emptyList();
        this.isMessagesListMutable = false;
        List<SingleFieldBuilderV3<MType, BType, IType>> r0 = this.builders;
        if (r0 == null) goto L11;
        Iterator<SingleFieldBuilderV3<MType, BType, IType>> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        SingleFieldBuilderV3 r2 = (SingleFieldBuilderV3) ZeusTransformUtils.preCheckCast(r1.next(), SingleFieldBuilderV3.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.dispose();
        goto L6
    L10:
        this.builders = null;
    L11:
        onChanged();
        incrementModCounts();
    }

    @Deprecated
    public List<MType> build() {
        this.isClean = true;
        boolean r1 = this.isMessagesListMutable;
        if (r1 == true) goto L9;
        if (this.builders != null) goto L9;
        return this.messages;
    L9:
        if (r1 == true) goto L23;
        int r2 = 0;
    L12:
        if (r2 >= this.messages.size()) goto L19;
        Message r3 = (Message) ZeusTransformUtils.preCheckCast(this.messages.get(r2), Message.class, "com.obric.aiagent.plugin");
        SingleFieldBuilderV3 r4 = (SingleFieldBuilderV3) ZeusTransformUtils.preCheckCast(this.builders.get(r2), SingleFieldBuilderV3.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L18;
        if (r4.build() == r3) goto L18;
        boolean r5 = false;
    L20:
        if (r5 == false) goto L23;
        return this.messages;
    L18:
        r2 = r2 + 1;
        goto L12
    L19:
        r5 = true;
    L23:
        ensureMutableMessageList();
        int r6 = 0;
    L25:
        if (r6 >= this.messages.size()) goto L27;
        this.messages.set(r6, (MType) getMessage(r6, true));
        r6 = r6 + 1;
        goto L25
    L27:
        List<MType> r0 = Collections.unmodifiableList(this.messages);
        this.messages = r0;
        this.isMessagesListMutable = false;
        return r0;
    }

    @Deprecated
    public List<MType> getMessageList() {
        if (this.externalMessageList != null) goto L6;
        this.externalMessageList = new MessageExternalList(this);
    L6:
        return this.externalMessageList;
    }

    @Deprecated
    public List<BType> getBuilderList() {
        if (this.externalBuilderList != null) goto L6;
        this.externalBuilderList = new BuilderExternalList(this);
    L6:
        return this.externalBuilderList;
    }

    @Deprecated
    public List<IType> getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList != null) goto L6;
        this.externalMessageOrBuilderList = new MessageOrBuilderExternalList(this);
    L6:
        return this.externalMessageOrBuilderList;
    }

    private void onChanged() {
        if (this.isClean == false) goto L8;
        AbstractMessage.BuilderParent r0 = this.parent;
        if (r0 == null) goto L9;
        r0.markDirty();
        this.isClean = false;
        return;
    L9:
        return;
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    @Deprecated
    public void markDirty() {
        onChanged();
    }

    private void incrementModCounts() {
        MessageExternalList<MType, BType, IType> r0 = this.externalMessageList;
        if (r0 == null) goto L5;
        r0.incrementModCount();
    L5:
        BuilderExternalList<MType, BType, IType> r1 = this.externalBuilderList;
        if (r1 == null) goto L8;
        r1.incrementModCount();
    L8:
        MessageOrBuilderExternalList<MType, BType, IType> r2 = this.externalMessageOrBuilderList;
        if (r2 == null) goto L12;
        r2.incrementModCount();
        return;
    }
}
