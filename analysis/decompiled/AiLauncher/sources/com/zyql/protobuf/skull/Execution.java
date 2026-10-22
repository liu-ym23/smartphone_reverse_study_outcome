package com.zyql.protobuf.skull;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.skull.Item;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class Execution extends GeneratedMessageLite<Execution, Builder> implements ExecutionOrBuilder {
    private static final Execution DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile Parser<Execution> PARSER;
    private Internal.ProtobufList<Item> items_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.zyql.protobuf.skull.Execution$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Execution, Builder> implements ExecutionOrBuilder {
        public Builder addAllItems(Iterable<? extends Item> iterable) {
            copyOnWrite();
            ((Execution) this.instance).addAllItems(iterable);
            return this;
        }

        public Builder addItems(Item item) {
            copyOnWrite();
            ((Execution) this.instance).addItems(item);
            return this;
        }

        public Builder clearItems() {
            copyOnWrite();
            ((Execution) this.instance).clearItems();
            return this;
        }

        @Override // com.zyql.protobuf.skull.ExecutionOrBuilder
        public Item getItems(int i10) {
            return ((Execution) this.instance).getItems(i10);
        }

        @Override // com.zyql.protobuf.skull.ExecutionOrBuilder
        public int getItemsCount() {
            return ((Execution) this.instance).getItemsCount();
        }

        @Override // com.zyql.protobuf.skull.ExecutionOrBuilder
        public List<Item> getItemsList() {
            return Collections.unmodifiableList(((Execution) this.instance).getItemsList());
        }

        public Builder removeItems(int i10) {
            copyOnWrite();
            ((Execution) this.instance).removeItems(i10);
            return this;
        }

        public Builder setItems(int i10, Item item) {
            copyOnWrite();
            ((Execution) this.instance).setItems(i10, item);
            return this;
        }

        private Builder() {
            super(Execution.DEFAULT_INSTANCE);
        }

        public Builder addItems(int i10, Item item) {
            copyOnWrite();
            ((Execution) this.instance).addItems(i10, item);
            return this;
        }

        public Builder setItems(int i10, Item.Builder builder) {
            copyOnWrite();
            ((Execution) this.instance).setItems(i10, builder.build());
            return this;
        }

        public Builder addItems(Item.Builder builder) {
            copyOnWrite();
            ((Execution) this.instance).addItems(builder.build());
            return this;
        }

        public Builder addItems(int i10, Item.Builder builder) {
            copyOnWrite();
            ((Execution) this.instance).addItems(i10, builder.build());
            return this;
        }
    }

    static {
        Execution execution = new Execution();
        DEFAULT_INSTANCE = execution;
        GeneratedMessageLite.registerDefaultInstance(Execution.class, execution);
    }

    private Execution() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllItems(Iterable<? extends Item> iterable) {
        ensureItemsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.items_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItems(Item item) {
        item.getClass();
        ensureItemsIsMutable();
        this.items_.add(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearItems() {
        this.items_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureItemsIsMutable() {
        Internal.ProtobufList<Item> protobufList = this.items_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.items_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static Execution getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Execution parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Execution) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Execution parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Execution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Execution> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeItems(int i10) {
        ensureItemsIsMutable();
        this.items_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItems(int i10, Item item) {
        item.getClass();
        ensureItemsIsMutable();
        this.items_.set(i10, item);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Execution();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", Item.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Execution> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Execution.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.zyql.protobuf.skull.ExecutionOrBuilder
    public Item getItems(int i10) {
        return this.items_.get(i10);
    }

    @Override // com.zyql.protobuf.skull.ExecutionOrBuilder
    public int getItemsCount() {
        return this.items_.size();
    }

    @Override // com.zyql.protobuf.skull.ExecutionOrBuilder
    public List<Item> getItemsList() {
        return this.items_;
    }

    public ItemOrBuilder getItemsOrBuilder(int i10) {
        return this.items_.get(i10);
    }

    public List<? extends ItemOrBuilder> getItemsOrBuilderList() {
        return this.items_;
    }

    public static Builder newBuilder(Execution execution) {
        return DEFAULT_INSTANCE.createBuilder(execution);
    }

    public static Execution parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Execution) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Execution parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Execution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Execution parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Execution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItems(int i10, Item item) {
        item.getClass();
        ensureItemsIsMutable();
        this.items_.add(i10, item);
    }

    public static Execution parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Execution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Execution parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Execution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Execution parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Execution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Execution parseFrom(InputStream inputStream) throws IOException {
        return (Execution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Execution parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Execution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Execution parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Execution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Execution parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Execution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
