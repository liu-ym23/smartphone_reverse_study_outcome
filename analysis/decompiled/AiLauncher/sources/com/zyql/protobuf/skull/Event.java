package com.zyql.protobuf.skull;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.skull.Item;
import com.zyql.protobuf.skull.MessageDelta;
import com.zyql.protobuf.skull.Task;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class Event extends GeneratedMessageLite<Event, Builder> implements EventOrBuilder {
    private static final Event DEFAULT_INSTANCE;
    public static final int EVENT_ID_FIELD_NUMBER = 1;
    public static final int ITEM_FIELD_NUMBER = 4;
    public static final int MESSAGE_DELTA_FIELD_NUMBER = 5;
    private static volatile Parser<Event> PARSER = null;
    public static final int TASK_FIELD_NUMBER = 3;
    public static final int TASK_ID_FIELD_NUMBER = 101;
    public static final int TYPE_FIELD_NUMBER = 2;
    private Object data_;
    private int dataCase_ = 0;
    private String eventId_ = "";
    private String type_ = "";
    private String taskId_ = "";

    /* renamed from: com.zyql.protobuf.skull.Event$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Event, Builder> implements EventOrBuilder {
        public Builder clearData() {
            copyOnWrite();
            ((Event) this.instance).clearData();
            return this;
        }

        public Builder clearEventId() {
            copyOnWrite();
            ((Event) this.instance).clearEventId();
            return this;
        }

        public Builder clearItem() {
            copyOnWrite();
            ((Event) this.instance).clearItem();
            return this;
        }

        public Builder clearMessageDelta() {
            copyOnWrite();
            ((Event) this.instance).clearMessageDelta();
            return this;
        }

        public Builder clearTask() {
            copyOnWrite();
            ((Event) this.instance).clearTask();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((Event) this.instance).clearTaskId();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((Event) this.instance).clearType();
            return this;
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public DataCase getDataCase() {
            return ((Event) this.instance).getDataCase();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public String getEventId() {
            return ((Event) this.instance).getEventId();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public ByteString getEventIdBytes() {
            return ((Event) this.instance).getEventIdBytes();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public Item getItem() {
            return ((Event) this.instance).getItem();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public MessageDelta getMessageDelta() {
            return ((Event) this.instance).getMessageDelta();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public Task getTask() {
            return ((Event) this.instance).getTask();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public String getTaskId() {
            return ((Event) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public ByteString getTaskIdBytes() {
            return ((Event) this.instance).getTaskIdBytes();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public String getType() {
            return ((Event) this.instance).getType();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public ByteString getTypeBytes() {
            return ((Event) this.instance).getTypeBytes();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public boolean hasItem() {
            return ((Event) this.instance).hasItem();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public boolean hasMessageDelta() {
            return ((Event) this.instance).hasMessageDelta();
        }

        @Override // com.zyql.protobuf.skull.EventOrBuilder
        public boolean hasTask() {
            return ((Event) this.instance).hasTask();
        }

        public Builder mergeItem(Item item) {
            copyOnWrite();
            ((Event) this.instance).mergeItem(item);
            return this;
        }

        public Builder mergeMessageDelta(MessageDelta messageDelta) {
            copyOnWrite();
            ((Event) this.instance).mergeMessageDelta(messageDelta);
            return this;
        }

        public Builder mergeTask(Task task) {
            copyOnWrite();
            ((Event) this.instance).mergeTask(task);
            return this;
        }

        public Builder setEventId(String str) {
            copyOnWrite();
            ((Event) this.instance).setEventId(str);
            return this;
        }

        public Builder setEventIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Event) this.instance).setEventIdBytes(byteString);
            return this;
        }

        public Builder setItem(Item item) {
            copyOnWrite();
            ((Event) this.instance).setItem(item);
            return this;
        }

        public Builder setMessageDelta(MessageDelta messageDelta) {
            copyOnWrite();
            ((Event) this.instance).setMessageDelta(messageDelta);
            return this;
        }

        public Builder setTask(Task task) {
            copyOnWrite();
            ((Event) this.instance).setTask(task);
            return this;
        }

        public Builder setTaskId(String str) {
            copyOnWrite();
            ((Event) this.instance).setTaskId(str);
            return this;
        }

        public Builder setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Event) this.instance).setTaskIdBytes(byteString);
            return this;
        }

        public Builder setType(String str) {
            copyOnWrite();
            ((Event) this.instance).setType(str);
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Event) this.instance).setTypeBytes(byteString);
            return this;
        }

        private Builder() {
            super(Event.DEFAULT_INSTANCE);
        }

        public Builder setItem(Item.Builder builder) {
            copyOnWrite();
            ((Event) this.instance).setItem(builder.build());
            return this;
        }

        public Builder setMessageDelta(MessageDelta.Builder builder) {
            copyOnWrite();
            ((Event) this.instance).setMessageDelta(builder.build());
            return this;
        }

        public Builder setTask(Task.Builder builder) {
            copyOnWrite();
            ((Event) this.instance).setTask(builder.build());
            return this;
        }
    }

    public enum DataCase {
        TASK(3),
        ITEM(4),
        MESSAGE_DELTA(5),
        DATA_NOT_SET(0);

        private final int value;

        DataCase(int i10) {
            this.value = i10;
        }

        public static DataCase forNumber(int i10) {
            if (i10 == 0) {
                return DATA_NOT_SET;
            }
            if (i10 == 3) {
                return TASK;
            }
            if (i10 == 4) {
                return ITEM;
            }
            if (i10 != 5) {
                return null;
            }
            return MESSAGE_DELTA;
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
        Event event = new Event();
        DEFAULT_INSTANCE = event;
        GeneratedMessageLite.registerDefaultInstance(Event.class, event);
    }

    private Event() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.dataCase_ = 0;
        this.data_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEventId() {
        this.eventId_ = getDefaultInstance().getEventId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearItem() {
        if (this.dataCase_ == 4) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessageDelta() {
        if (this.dataCase_ == 5) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTask() {
        if (this.dataCase_ == 3) {
            this.dataCase_ = 0;
            this.data_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTaskId() {
        this.taskId_ = getDefaultInstance().getTaskId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    public static Event getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeItem(Item item) {
        item.getClass();
        if (this.dataCase_ != 4 || this.data_ == Item.getDefaultInstance()) {
            this.data_ = item;
        } else {
            this.data_ = Item.newBuilder((Item) this.data_).mergeFrom((Item.Builder) item).buildPartial();
        }
        this.dataCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMessageDelta(MessageDelta messageDelta) {
        messageDelta.getClass();
        if (this.dataCase_ != 5 || this.data_ == MessageDelta.getDefaultInstance()) {
            this.data_ = messageDelta;
        } else {
            this.data_ = MessageDelta.newBuilder((MessageDelta) this.data_).mergeFrom((MessageDelta.Builder) messageDelta).buildPartial();
        }
        this.dataCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTask(Task task) {
        task.getClass();
        if (this.dataCase_ != 3 || this.data_ == Task.getDefaultInstance()) {
            this.data_ = task;
        } else {
            this.data_ = Task.newBuilder((Task) this.data_).mergeFrom((Task.Builder) task).buildPartial();
        }
        this.dataCase_ = 3;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Event parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Event) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Event parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Event> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventId(String str) {
        str.getClass();
        this.eventId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.eventId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItem(Item item) {
        item.getClass();
        this.data_ = item;
        this.dataCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageDelta(MessageDelta messageDelta) {
        messageDelta.getClass();
        this.data_ = messageDelta;
        this.dataCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTask(Task task) {
        task.getClass();
        this.data_ = task;
        this.dataCase_ = 3;
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
                return new Event();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001e\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003<\u0000\u0004<\u0000\u0005<\u0000eȈ", new Object[]{"data_", "dataCase_", "eventId_", "type_", Task.class, Item.class, MessageDelta.class, "taskId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Event> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Event.class) {
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

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public DataCase getDataCase() {
        return DataCase.forNumber(this.dataCase_);
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public String getEventId() {
        return this.eventId_;
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public ByteString getEventIdBytes() {
        return ByteString.copyFromUtf8(this.eventId_);
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public Item getItem() {
        return this.dataCase_ == 4 ? (Item) this.data_ : Item.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public MessageDelta getMessageDelta() {
        return this.dataCase_ == 5 ? (MessageDelta) this.data_ : MessageDelta.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public Task getTask() {
        return this.dataCase_ == 3 ? (Task) this.data_ : Task.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public String getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public ByteString getTaskIdBytes() {
        return ByteString.copyFromUtf8(this.taskId_);
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public String getType() {
        return this.type_;
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public boolean hasItem() {
        return this.dataCase_ == 4;
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public boolean hasMessageDelta() {
        return this.dataCase_ == 5;
    }

    @Override // com.zyql.protobuf.skull.EventOrBuilder
    public boolean hasTask() {
        return this.dataCase_ == 3;
    }

    public static Builder newBuilder(Event event) {
        return DEFAULT_INSTANCE.createBuilder(event);
    }

    public static Event parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Event) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Event parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Event parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Event parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Event parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Event parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Event parseFrom(InputStream inputStream) throws IOException {
        return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Event parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Event parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Event parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
