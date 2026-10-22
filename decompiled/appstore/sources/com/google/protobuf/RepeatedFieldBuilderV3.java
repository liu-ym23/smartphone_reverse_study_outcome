package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RepeatedFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private List<SingleFieldBuilderV3<MType, BType, IType>> builders;
    private BuilderExternalList<MType, BType, IType> externalBuilderList;
    private MessageExternalList<MType, BType, IType> externalMessageList;
    private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    private boolean isClean;
    private boolean isMessagesListMutable;
    private List<MType> messages;
    private AbstractMessage.BuilderParent parent;

    public static class BuilderExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements List<BType> {
        RepeatedFieldBuilderV3<MType, BType, IType> builder;

        public BuilderExternalList(RepeatedFieldBuilderV3<MType, BType, IType> r10) {
            this.builder = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public BType get(int r10) {
            return (BType) this.builder.getBuilder(r10);
        }
    }

    public static class MessageExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements List<MType> {
        RepeatedFieldBuilderV3<MType, BType, IType> builder;

        public MessageExternalList(RepeatedFieldBuilderV3<MType, BType, IType> r10) {
            this.builder = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public MType get(int r10) {
            return (MType) this.builder.getMessage(r10);
        }
    }

    public static class MessageOrBuilderExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements List<IType> {
        RepeatedFieldBuilderV3<MType, BType, IType> builder;

        public MessageOrBuilderExternalList(RepeatedFieldBuilderV3<MType, BType, IType> r10) {
            this.builder = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public IType get(int r10) {
            return (IType) this.builder.getMessageOrBuilder(r10);
        }
    }

    public RepeatedFieldBuilderV3(List<MType> r10, boolean r11, AbstractMessage.BuilderParent r12, boolean r13) {
        this.messages = r10;
        this.isMessagesListMutable = r11;
        this.parent = r12;
        this.isClean = r13;
    }

    private void ensureBuilders() {
        if (this.builders != null) goto L8;
        this.builders = new ArrayList(this.messages.size());
        int r10 = 0;
    L6:
        if (r10 >= this.messages.size()) goto L10;
        this.builders.add(null);
        r10 = r10 + 1;
        goto L6
    L10:
        return;
    }

    private void ensureMutableMessageList() {
        if (this.isMessagesListMutable == true) goto L6;
        this.messages = new ArrayList(this.messages);
        this.isMessagesListMutable = true;
        return;
    }

    private void incrementModCounts() {
        MessageExternalList<MType, BType, IType> r10 = this.externalMessageList;
        if (r10 == null) goto L5;
        r10.incrementModCount();
    L5:
        BuilderExternalList<MType, BType, IType> r11 = this.externalBuilderList;
        if (r11 == null) goto L8;
        r11.incrementModCount();
    L8:
        MessageOrBuilderExternalList<MType, BType, IType> r12 = this.externalMessageOrBuilderList;
        if (r12 == null) goto L12;
        r12.incrementModCount();
        return;
    }

    private void onChanged() {
        if (this.isClean == false) goto L8;
        AbstractMessage.BuilderParent r10 = this.parent;
        if (r10 == null) goto L9;
        r10.markDirty();
        this.isClean = false;
        return;
    L9:
        return;
    }

    public RepeatedFieldBuilderV3<MType, BType, IType> addAllMessages(Iterable<? extends MType> r10) {
        Iterator<? extends MType> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        if (r11.next() != null) goto L4;
        throw null;
    L11:
        if ((r10 instanceof Collection) == false) goto L16;
        Collection r12 = (Collection) r10;
        if (r12.size() != 0) goto L15;
        return this;
    L15:
        int r13 = r12.size();
    L17:
        ensureMutableMessageList();
        if (r13 < 0) goto L22;
        List<MType> r14 = this.messages;
        if ((r14 instanceof ArrayList) == false) goto L22;
        ((ArrayList) r14).ensureCapacity(r14.size() + r13);
    L22:
        Iterator<? extends MType> r15 = r10.iterator();
    L24:
        if (r15.hasNext() == false) goto L26;
        addMessage(r15.next());
        goto L24
    L26:
        onChanged();
        incrementModCounts();
        return this;
    L16:
        r13 = -1;
        goto L17
    }

    public BType addBuilder(MType r10) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilderV3<MType, BType, IType> r11 = new SingleFieldBuilderV3(r10, this, this.isClean);
        this.messages.add(null);
        this.builders.add(r11);
        onChanged();
        incrementModCounts();
        return (BType) r11.getBuilder();
    }

    public RepeatedFieldBuilderV3<MType, BType, IType> addMessage(MType r10) {
        if (r10 == null) goto L9;
        ensureMutableMessageList();
        this.messages.add(r10);
        List<SingleFieldBuilderV3<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L7;
        r11.add(null);
    L7:
        onChanged();
        incrementModCounts();
        return this;
    L9:
        throw null;
    }

    public List<MType> build() {
        this.isClean = true;
        boolean r10 = this.isMessagesListMutable;
        if (r10 == true) goto L9;
        if (this.builders != null) goto L9;
        return this.messages;
    L9:
        if (r10 == true) goto L21;
        int r11 = 0;
    L12:
        if (r11 >= this.messages.size()) goto L20;
        MType r12 = this.messages.get(r11);
        SingleFieldBuilderV3<MType, BType, IType> r13 = this.builders.get(r11);
        if (r13 == null) goto L18;
        if (r13.build() != r12) goto L21;
    L18:
        r11 = r11 + 1;
        goto L12
    L20:
        return this.messages;
    L21:
        ensureMutableMessageList();
        int r14 = 0;
    L23:
        if (r14 >= this.messages.size()) goto L25;
        this.messages.set(r14, (MType) getMessage(r14, true));
        r14 = r14 + 1;
        goto L23
    L25:
        List<MType> r15 = Collections.unmodifiableList(this.messages);
        this.messages = r15;
        this.isMessagesListMutable = false;
        return r15;
    }

    public void clear() {
        this.messages = Collections.emptyList();
        this.isMessagesListMutable = false;
        List<SingleFieldBuilderV3<MType, BType, IType>> r10 = this.builders;
        if (r10 == null) goto L11;
        Iterator<SingleFieldBuilderV3<MType, BType, IType>> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        SingleFieldBuilderV3<MType, BType, IType> r12 = r11.next();
        if (r12 == null) goto L6;
        r12.dispose();
        goto L6
    L10:
        this.builders = null;
    L11:
        onChanged();
        incrementModCounts();
    }

    public void dispose() {
        this.parent = null;
    }

    public BType getBuilder(int r10) {
        ensureBuilders();
        SingleFieldBuilderV3<MType, BType, IType> r11 = this.builders.get(r10);
        if (r11 != null) goto L6;
        SingleFieldBuilderV3<MType, BType, IType> r12 = new SingleFieldBuilderV3(this.messages.get(r10), this, this.isClean);
        this.builders.set(r10, r12);
        r11 = r12;
    L6:
        return (BType) r11.getBuilder();
    }

    public List<BType> getBuilderList() {
        if (this.externalBuilderList != null) goto L6;
        this.externalBuilderList = new BuilderExternalList(this);
    L6:
        return this.externalBuilderList;
    }

    public int getCount() {
        return this.messages.size();
    }

    public MType getMessage(int r10) {
        return (MType) getMessage(r10, false);
    }

    public List<MType> getMessageList() {
        if (this.externalMessageList != null) goto L6;
        this.externalMessageList = new MessageExternalList(this);
    L6:
        return this.externalMessageList;
    }

    public IType getMessageOrBuilder(int r10) {
        List<SingleFieldBuilderV3<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L5;
        SingleFieldBuilderV3<MType, BType, IType> r12 = r11.get(r10);
        if (r12 != null) goto L11;
        return this.messages.get(r10);
    L11:
        return (IType) r12.getMessageOrBuilder();
    L5:
        return this.messages.get(r10);
    }

    public List<IType> getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList != null) goto L6;
        this.externalMessageOrBuilderList = new MessageOrBuilderExternalList(this);
    L6:
        return this.externalMessageOrBuilderList;
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    public void markDirty() {
        onChanged();
    }

    public void remove(int r10) {
        ensureMutableMessageList();
        this.messages.remove(r10);
        List<SingleFieldBuilderV3<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L7;
        SingleFieldBuilderV3<MType, BType, IType> r12 = r11.remove(r10);
        if (r12 == null) goto L7;
        r12.dispose();
    L7:
        onChanged();
        incrementModCounts();
    }

    public RepeatedFieldBuilderV3<MType, BType, IType> setMessage(int r10, MType r11) {
        if (r11 == null) goto L11;
        ensureMutableMessageList();
        this.messages.set(r10, r11);
        List<SingleFieldBuilderV3<MType, BType, IType>> r12 = this.builders;
        if (r12 == null) goto L9;
        SingleFieldBuilderV3<MType, BType, IType> r13 = r12.set(r10, null);
        if (r13 == null) goto L9;
        r13.dispose();
    L9:
        onChanged();
        incrementModCounts();
        return this;
    L11:
        throw null;
    }

    private MType getMessage(int r10, boolean r11) {
        List<SingleFieldBuilderV3<MType, BType, IType>> r12 = this.builders;
        if (r12 == null) goto L5;
        SingleFieldBuilderV3<MType, BType, IType> r13 = r12.get(r10);
        if (r13 == null) goto L9;
        if (r11 == false) goto L13;
        return (MType) r13.build();
    L13:
        return (MType) r13.getMessage();
    L9:
        return this.messages.get(r10);
    L5:
        return this.messages.get(r10);
    }

    public RepeatedFieldBuilderV3<MType, BType, IType> addMessage(int r10, MType r11) {
        if (r11 == null) goto L9;
        ensureMutableMessageList();
        this.messages.add(r10, r11);
        List<SingleFieldBuilderV3<MType, BType, IType>> r12 = this.builders;
        if (r12 == null) goto L7;
        r12.add(r10, null);
    L7:
        onChanged();
        incrementModCounts();
        return this;
    L9:
        throw null;
    }

    public BType addBuilder(int r10, MType r11) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilderV3<MType, BType, IType> r12 = new SingleFieldBuilderV3(r11, this, this.isClean);
        this.messages.add(r10, null);
        this.builders.add(r10, r12);
        onChanged();
        incrementModCounts();
        return (BType) r12.getBuilder();
    }
}
