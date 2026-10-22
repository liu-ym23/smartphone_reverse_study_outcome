package com.zyql.protobuf.skull;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.skull.AskInput;
import com.zyql.protobuf.skull.Handoff;
import com.zyql.protobuf.skull.Interrupt;
import com.zyql.protobuf.skull.Message;
import com.zyql.protobuf.skull.ToolCall;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class Item extends GeneratedMessageLite<Item, Builder> implements ItemOrBuilder {
    public static final int ASK_INPUT_FIELD_NUMBER = 7;
    private static final Item DEFAULT_INSTANCE;
    public static final int HANDOFF_FIELD_NUMBER = 9;
    public static final int INTERRUPT_FIELD_NUMBER = 8;
    public static final int ITEM_ID_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 5;
    private static volatile Parser<Item> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 3;
    public static final int TASK_ID_FIELD_NUMBER = 2;
    public static final int TOOL_CALL_FIELD_NUMBER = 6;
    public static final int TYPE_FIELD_NUMBER = 4;
    private Object data_;
    private int dataCase_ = 0;
    private String itemId_ = "";
    private String taskId_ = "";
    private String status_ = "";
    private String type_ = "";

    /* renamed from: com.zyql.protobuf.skull.Item$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Item, Builder> implements ItemOrBuilder {
        public Builder clearAskInput() {
            copyOnWrite();
            ((Item) this.instance).clearAskInput();
            return this;
        }

        public Builder clearData() {
            copyOnWrite();
            ((Item) this.instance).clearData();
            return this;
        }

        public Builder clearHandoff() {
            copyOnWrite();
            ((Item) this.instance).clearHandoff();
            return this;
        }

        public Builder clearInterrupt() {
            copyOnWrite();
            ((Item) this.instance).clearInterrupt();
            return this;
        }

        public Builder clearItemId() {
            copyOnWrite();
            ((Item) this.instance).clearItemId();
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((Item) this.instance).clearMessage();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((Item) this.instance).clearStatus();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((Item) this.instance).clearTaskId();
            return this;
        }

        public Builder clearToolCall() {
            copyOnWrite();
            ((Item) this.instance).clearToolCall();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((Item) this.instance).clearType();
            return this;
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public AskInput getAskInput() {
            return ((Item) this.instance).getAskInput();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public DataCase getDataCase() {
            return ((Item) this.instance).getDataCase();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public Handoff getHandoff() {
            return ((Item) this.instance).getHandoff();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public Interrupt getInterrupt() {
            return ((Item) this.instance).getInterrupt();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public String getItemId() {
            return ((Item) this.instance).getItemId();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public ByteString getItemIdBytes() {
            return ((Item) this.instance).getItemIdBytes();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public Message getMessage() {
            return ((Item) this.instance).getMessage();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public String getStatus() {
            return ((Item) this.instance).getStatus();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public ByteString getStatusBytes() {
            return ((Item) this.instance).getStatusBytes();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public String getTaskId() {
            return ((Item) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public ByteString getTaskIdBytes() {
            return ((Item) this.instance).getTaskIdBytes();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public ToolCall getToolCall() {
            return ((Item) this.instance).getToolCall();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public String getType() {
            return ((Item) this.instance).getType();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public ByteString getTypeBytes() {
            return ((Item) this.instance).getTypeBytes();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public boolean hasAskInput() {
            return ((Item) this.instance).hasAskInput();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public boolean hasHandoff() {
            return ((Item) this.instance).hasHandoff();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public boolean hasInterrupt() {
            return ((Item) this.instance).hasInterrupt();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public boolean hasMessage() {
            return ((Item) this.instance).hasMessage();
        }

        @Override // com.zyql.protobuf.skull.ItemOrBuilder
        public boolean hasToolCall() {
            return ((Item) this.instance).hasToolCall();
        }

        public Builder mergeAskInput(AskInput askInput) {
            copyOnWrite();
            ((Item) this.instance).mergeAskInput(askInput);
            return this;
        }

        public Builder mergeHandoff(Handoff handoff) {
            copyOnWrite();
            ((Item) this.instance).mergeHandoff(handoff);
            return this;
        }

        public Builder mergeInterrupt(Interrupt interrupt) {
            copyOnWrite();
            ((Item) this.instance).mergeInterrupt(interrupt);
            return this;
        }

        public Builder mergeMessage(Message message) {
            copyOnWrite();
            ((Item) this.instance).mergeMessage(message);
            return this;
        }

        public Builder mergeToolCall(ToolCall toolCall) {
            copyOnWrite();
            ((Item) this.instance).mergeToolCall(toolCall);
            return this;
        }

        public Builder setAskInput(AskInput askInput) {
            copyOnWrite();
            ((Item) this.instance).setAskInput(askInput);
            return this;
        }

        public Builder setHandoff(Handoff handoff) {
            copyOnWrite();
            ((Item) this.instance).setHandoff(handoff);
            return this;
        }

        public Builder setInterrupt(Interrupt interrupt) {
            copyOnWrite();
            ((Item) this.instance).setInterrupt(interrupt);
            return this;
        }

        public Builder setItemId(String str) {
            copyOnWrite();
            ((Item) this.instance).setItemId(str);
            return this;
        }

        public Builder setItemIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Item) this.instance).setItemIdBytes(byteString);
            return this;
        }

        public Builder setMessage(Message message) {
            copyOnWrite();
            ((Item) this.instance).setMessage(message);
            return this;
        }

        public Builder setStatus(String str) {
            copyOnWrite();
            ((Item) this.instance).setStatus(str);
            return this;
        }

        public Builder setStatusBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Item) this.instance).setStatusBytes(byteString);
            return this;
        }

        public Builder setTaskId(String str) {
            copyOnWrite();
            ((Item) this.instance).setTaskId(str);
            return this;
        }

        public Builder setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Item) this.instance).setTaskIdBytes(byteString);
            return this;
        }

        public Builder setToolCall(ToolCall toolCall) {
            copyOnWrite();
            ((Item) this.instance).setToolCall(toolCall);
            return this;
        }

        public Builder setType(String str) {
            copyOnWrite();
            ((Item) this.instance).setType(str);
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Item) this.instance).setTypeBytes(byteString);
            return this;
        }

        private Builder() {
            super(Item.DEFAULT_INSTANCE);
        }

        public Builder setAskInput(AskInput.Builder builder) {
            copyOnWrite();
            ((Item) this.instance).setAskInput(builder.build());
            return this;
        }

        public Builder setHandoff(Handoff.Builder builder) {
            copyOnWrite();
            ((Item) this.instance).setHandoff(builder.build());
            return this;
        }

        public Builder setInterrupt(Interrupt.Builder builder) {
            copyOnWrite();
            ((Item) this.instance).setInterrupt(builder.build());
            return this;
        }

        public Builder setMessage(Message.Builder builder) {
            copyOnWrite();
            ((Item) this.instance).setMessage(builder.build());
            return this;
        }

        public Builder setToolCall(ToolCall.Builder builder) {
            copyOnWrite();
            ((Item) this.instance).setToolCall(builder.build());
            return this;
        }
    }

    public enum DataCase {
        MESSAGE(5),
        TOOL_CALL(6),
        ASK_INPUT(7),
        INTERRUPT(8),
        HANDOFF(9),
        DATA_NOT_SET(0);

        private final int value;

        DataCase(int i10) {
            this.value = i10;
        }

        public static DataCase forNumber(int i10) {
            if (i10 == 0) {
                return DATA_NOT_SET;
            }
            switch (i10) {
                case 5:
                    return MESSAGE;
                case 6:
                    return TOOL_CALL;
                case 7:
                    return ASK_INPUT;
                case 8:
                    return INTERRUPT;
                case 9:
                    return HANDOFF;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static DataCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        Item item = new Item();
        DEFAULT_INSTANCE = item;
        GeneratedMessageLite.registerDefaultInstance(Item.class, item);
    }

    private Item() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAskInput() {
        if (this.dataCase_ == 7) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.dataCase_ = 0;
        this.data_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHandoff() {
        if (this.dataCase_ == 9) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInterrupt() {
        if (this.dataCase_ == 8) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearItemId() {
        this.itemId_ = getDefaultInstance().getItemId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        if (this.dataCase_ == 5) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = getDefaultInstance().getStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = getDefaultInstance().getTaskId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToolCall() {
        if (this.dataCase_ == 6) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    public static Item getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAskInput(AskInput askInput) {
        askInput.getClass();
        if (this.dataCase_ != 7 || this.data_ == AskInput.getDefaultInstance()) {
            this.data_ = askInput;
        } else {
            this.data_ = AskInput.newBuilder((AskInput) this.data_).mergeFrom((AskInput.Builder) askInput).buildPartial();
        }
        this.dataCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHandoff(Handoff handoff) {
        handoff.getClass();
        if (this.dataCase_ != 9 || this.data_ == Handoff.getDefaultInstance()) {
            this.data_ = handoff;
        } else {
            this.data_ = Handoff.newBuilder((Handoff) this.data_).mergeFrom((Handoff.Builder) handoff).buildPartial();
        }
        this.dataCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInterrupt(Interrupt interrupt) {
        interrupt.getClass();
        if (this.dataCase_ != 8 || this.data_ == Interrupt.getDefaultInstance()) {
            this.data_ = interrupt;
        } else {
            this.data_ = Interrupt.newBuilder((Interrupt) this.data_).mergeFrom((Interrupt.Builder) interrupt).buildPartial();
        }
        this.dataCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMessage(Message message) {
        message.getClass();
        if (this.dataCase_ != 5 || this.data_ == Message.getDefaultInstance()) {
            this.data_ = message;
        } else {
            this.data_ = Message.newBuilder((Message) this.data_).mergeFrom((Message.Builder) message).buildPartial();
        }
        this.dataCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeToolCall(ToolCall toolCall) {
        toolCall.getClass();
        if (this.dataCase_ != 6 || this.data_ == ToolCall.getDefaultInstance()) {
            this.data_ = toolCall;
        } else {
            this.data_ = ToolCall.newBuilder((ToolCall) this.data_).mergeFrom((ToolCall.Builder) toolCall).buildPartial();
        }
        this.dataCase_ = 6;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Item parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Item) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Item parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Item) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Item> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAskInput(AskInput askInput) {
        askInput.getClass();
        this.data_ = askInput;
        this.dataCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHandoff(Handoff handoff) {
        handoff.getClass();
        this.data_ = handoff;
        this.dataCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterrupt(Interrupt interrupt) {
        interrupt.getClass();
        this.data_ = interrupt;
        this.dataCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemId(String str) {
        str.getClass();
        this.itemId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.itemId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(Message message) {
        message.getClass();
        this.data_ = message;
        this.dataCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(String str) {
        str.getClass();
        this.status_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.status_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskId(String str) {
        str.getClass();
        this.taskId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.taskId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolCall(ToolCall toolCall) {
        toolCall.getClass();
        this.data_ = toolCall;
        this.dataCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(String str) {
        str.getClass();
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.type_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Item();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0001\u0000\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000", new Object[]{"data_", "dataCase_", "itemId_", "taskId_", "status_", "type_", Message.class, ToolCall.class, AskInput.class, Interrupt.class, Handoff.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Item> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Item.class) {
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

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public AskInput getAskInput() {
        return this.dataCase_ == 7 ? (AskInput) this.data_ : AskInput.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public DataCase getDataCase() {
        return DataCase.forNumber(this.dataCase_);
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public Handoff getHandoff() {
        return this.dataCase_ == 9 ? (Handoff) this.data_ : Handoff.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public Interrupt getInterrupt() {
        return this.dataCase_ == 8 ? (Interrupt) this.data_ : Interrupt.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public String getItemId() {
        return this.itemId_;
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public ByteString getItemIdBytes() {
        return ByteString.copyFromUtf8(this.itemId_);
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public Message getMessage() {
        return this.dataCase_ == 5 ? (Message) this.data_ : Message.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public String getStatus() {
        return this.status_;
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public ByteString getStatusBytes() {
        return ByteString.copyFromUtf8(this.status_);
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public String getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public ByteString getTaskIdBytes() {
        return ByteString.copyFromUtf8(this.taskId_);
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public ToolCall getToolCall() {
        return this.dataCase_ == 6 ? (ToolCall) this.data_ : ToolCall.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public String getType() {
        return this.type_;
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public boolean hasAskInput() {
        return this.dataCase_ == 7;
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public boolean hasHandoff() {
        return this.dataCase_ == 9;
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public boolean hasInterrupt() {
        return this.dataCase_ == 8;
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public boolean hasMessage() {
        return this.dataCase_ == 5;
    }

    @Override // com.zyql.protobuf.skull.ItemOrBuilder
    public boolean hasToolCall() {
        return this.dataCase_ == 6;
    }

    public static Builder newBuilder(Item item) {
        return DEFAULT_INSTANCE.createBuilder(item);
    }

    public static Item parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Item) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Item parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Item) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Item parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Item) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Item parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Item) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Item parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Item) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Item parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Item) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Item parseFrom(InputStream inputStream) throws IOException {
        return (Item) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Item parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Item) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Item parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Item) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Item parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Item) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
