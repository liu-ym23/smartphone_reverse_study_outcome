package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private List<SingleFieldBuilder<MType, BType, IType>> builders;
    private BuilderExternalList<MType, BType, IType> externalBuilderList;
    private MessageExternalList<MType, BType, IType> externalMessageList;
    private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    private boolean isClean;
    private Internal.ProtobufList<MType> messages;
    private AbstractMessage.BuilderParent parent;

    private static class BuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements List<BType>, RandomAccess {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        BuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> r1) {
            this.builder = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public BType get(int r1) {
            return (BType) this.builder.getBuilder(r1);
        }

        void incrementModCount() {
            this.modCount++;
        }
    }

    private static class MessageExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements List<MType>, RandomAccess {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        MessageExternalList(RepeatedFieldBuilder<MType, BType, IType> r1) {
            this.builder = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public MType get(int r1) {
            return (MType) this.builder.getMessage(r1);
        }

        void incrementModCount() {
            this.modCount++;
        }
    }

    private static class MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements List<IType>, RandomAccess {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        MessageOrBuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> r1) {
            this.builder = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public IType get(int r1) {
            return (IType) this.builder.getMessageOrBuilder(r1);
        }

        void incrementModCount() {
            this.modCount++;
        }
    }

    private static <MsgT extends GeneratedMessage> Internal.ProtobufList<MsgT> passthroughOrCopyToProtobufList(List<MsgT> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Internal.ProtobufList.class) == true) goto L5;
        ProtobufArrayList r0 = ProtobufArrayList.emptyList().mutableCopyWithCapacity(r3.size());
        r0.addAll(r3);
        return r0;
    L5:
        return (Internal.ProtobufList) ZeusTransformUtils.preCheckCast(r3, Internal.ProtobufList.class, "com.obric.aiagent.plugin");
    }

    public RepeatedFieldBuilder(List<MType> r2, boolean r3, AbstractMessage.BuilderParent r4, boolean r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        AbstractMessage.BuilderParent r7 = (AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r4, AbstractMessage.BuilderParent.class, "com.obric.aiagent.plugin");
        this.messages = passthroughOrCopyToProtobufList(r6);
        this.parent = r7;
        this.isClean = r5;
    }

    public void dispose() {
        this.parent = null;
    }

    private void ensureMutableMessageList() {
        if (this.messages.isModifiable() == true) goto L6;
        Internal.ProtobufList<MType> r0 = this.messages;
        this.messages = r0.mutableCopyWithCapacity(r0.size());
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

    public int getCount() {
        return this.messages.size();
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    public MType getMessage(int r2) {
        return (MType) getMessage(r2, false);
    }

    private MType getMessage(int r4, boolean r5) {
        List<SingleFieldBuilder<MType, BType, IType>> r0 = this.builders;
        if (r0 == null) goto L5;
        SingleFieldBuilder r1 = (SingleFieldBuilder) ZeusTransformUtils.preCheckCast(r0.get(r4), SingleFieldBuilder.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        if (r5 == false) goto L13;
        return (MType) r1.build();
    L13:
        return (MType) r1.getMessage();
    L9:
        return (MType) ZeusTransformUtils.preCheckCast(this.messages.get(r4), GeneratedMessage.class, "com.obric.aiagent.plugin");
    L5:
        return (MType) ZeusTransformUtils.preCheckCast(this.messages.get(r4), GeneratedMessage.class, "com.obric.aiagent.plugin");
    }

    public BType getBuilder(int r4) {
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> r0 = (SingleFieldBuilder) ZeusTransformUtils.preCheckCast(this.builders.get(r4), SingleFieldBuilder.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        SingleFieldBuilder<MType, BType, IType> r1 = new SingleFieldBuilder((GeneratedMessage) ZeusTransformUtils.preCheckCast(this.messages.get(r4), GeneratedMessage.class, "com.obric.aiagent.plugin"), this, this.isClean);
        this.builders.set(r4, r1);
        r0 = r1;
    L6:
        return (BType) r0.getBuilder();
    }

    public IType getMessageOrBuilder(int r4) {
        List<SingleFieldBuilder<MType, BType, IType>> r0 = this.builders;
        if (r0 == null) goto L5;
        SingleFieldBuilder r1 = (SingleFieldBuilder) ZeusTransformUtils.preCheckCast(r0.get(r4), SingleFieldBuilder.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L11;
        return (IType) ZeusTransformUtils.preCheckCast(this.messages.get(r4), MessageOrBuilder.class, "com.obric.aiagent.plugin");
    L11:
        return (IType) r1.getMessageOrBuilder();
    L5:
        return (IType) ZeusTransformUtils.preCheckCast(this.messages.get(r4), MessageOrBuilder.class, "com.obric.aiagent.plugin");
    }

    public RepeatedFieldBuilder<MType, BType, IType> setMessage(int r2, MType r3) {
        Internal.checkNotNull(r3);
        ensureMutableMessageList();
        this.messages.set(r2, r3);
        List<SingleFieldBuilder<MType, BType, IType>> r4 = this.builders;
        if (r4 == null) goto L7;
        SingleFieldBuilder r5 = (SingleFieldBuilder) ZeusTransformUtils.preCheckCast(r4.set(r2, null), SingleFieldBuilder.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L7;
        r5.dispose();
    L7:
        onChanged();
        incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder<MType, BType, IType> addMessage(MType r2) {
        Internal.checkNotNull(r2);
        ensureMutableMessageList();
        this.messages.add(r2);
        List<SingleFieldBuilder<MType, BType, IType>> r3 = this.builders;
        if (r3 == null) goto L5;
        r3.add(null);
    L5:
        onChanged();
        incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder<MType, BType, IType> addMessage(int r2, MType r3) {
        Internal.checkNotNull(r3);
        ensureMutableMessageList();
        this.messages.add(r2, r3);
        List<SingleFieldBuilder<MType, BType, IType>> r4 = this.builders;
        if (r4 == null) goto L5;
        r4.add(r2, null);
    L5:
        onChanged();
        incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder<MType, BType, IType> addAllMessages(Iterable<? extends MType> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.aiagent.plugin");
        Iterator r0 = r6.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Internal.checkNotNull((GeneratedMessage) ZeusTransformUtils.preCheckCast(r0.next(), GeneratedMessage.class, "com.obric.aiagent.plugin"));
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
        addMessage((GeneratedMessage) ZeusTransformUtils.preCheckCast(r7.next(), GeneratedMessage.class, "com.obric.aiagent.plugin"));
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

    public BType addBuilder(MType r3) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> r0 = new SingleFieldBuilder(r3, this, this.isClean);
        this.messages.add(null);
        this.builders.add(r0);
        onChanged();
        incrementModCounts();
        return (BType) r0.getBuilder();
    }

    public BType addBuilder(int r3, MType r4) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> r0 = new SingleFieldBuilder(r4, this, this.isClean);
        this.messages.add(r3, null);
        this.builders.add(r3, r0);
        onChanged();
        incrementModCounts();
        return (BType) r0.getBuilder();
    }

    public void remove(int r3) {
        ensureMutableMessageList();
        this.messages.remove(r3);
        List<SingleFieldBuilder<MType, BType, IType>> r0 = this.builders;
        if (r0 == null) goto L7;
        SingleFieldBuilder r4 = (SingleFieldBuilder) ZeusTransformUtils.preCheckCast(r0.remove(r3), SingleFieldBuilder.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        r4.dispose();
    L7:
        onChanged();
        incrementModCounts();
    }

    public void clear() {
        this.messages = ProtobufArrayList.emptyList();
        List<SingleFieldBuilder<MType, BType, IType>> r0 = this.builders;
        if (r0 == null) goto L11;
        Iterator<SingleFieldBuilder<MType, BType, IType>> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        SingleFieldBuilder r2 = (SingleFieldBuilder) ZeusTransformUtils.preCheckCast(r1.next(), SingleFieldBuilder.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.dispose();
        goto L6
    L10:
        this.builders = null;
    L11:
        onChanged();
        incrementModCounts();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public List<MType> build() {
        this.isClean = true;
        if (this.messages.isModifiable() == false) goto L5;
    L8:
        int r2 = 0;
        if (this.messages.isModifiable() == true) goto L23;
        int r1 = 0;
    L12:
        if (r1 >= this.messages.size()) goto L19;
        Message r3 = (Message) ZeusTransformUtils.preCheckCast(this.messages.get(r1), Message.class, "com.obric.aiagent.plugin");
        SingleFieldBuilder r4 = (SingleFieldBuilder) ZeusTransformUtils.preCheckCast(this.builders.get(r1), SingleFieldBuilder.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L18;
        if (r4.build() == r3) goto L18;
        boolean r5 = false;
    L20:
        if (r5 == false) goto L23;
        return this.messages;
    L18:
        r1 = r1 + 1;
        goto L12
    L19:
        r5 = true;
    L23:
        ensureMutableMessageList();
    L25:
        if (r2 >= this.messages.size()) goto L27;
        this.messages.set(r2, getMessage(r2, true));
        r2 = r2 + 1;
        goto L25
    L27:
        this.messages.makeImmutable();
        return this.messages;
    L5:
        if (this.builders != null) goto L8;
        return this.messages;
    }

    public List<MType> getMessageList() {
        if (this.externalMessageList != null) goto L6;
        this.externalMessageList = new MessageExternalList(this);
    L6:
        return this.externalMessageList;
    }

    public List<BType> getBuilderList() {
        if (this.externalBuilderList != null) goto L6;
        this.externalBuilderList = new BuilderExternalList(this);
    L6:
        return this.externalBuilderList;
    }

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
