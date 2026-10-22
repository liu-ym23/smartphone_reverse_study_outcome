package com.zyql.protobuf.skull;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import com.zyql.protobuf.skull.Agent;
import com.zyql.protobuf.skull.Item;
import com.zyql.protobuf.skull.TaskInput;
import com.zyql.protobuf.skull.TaskOutput;
import com.zyql.protobuf.skull.User;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class Task extends GeneratedMessageLite<Task, Builder> implements TaskOrBuilder {
    public static final int AGENT_FIELD_NUMBER = 8;
    public static final int CHILD_TASK_IDS_FIELD_NUMBER = 3;
    private static final Task DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 10;
    public static final int EXECUTION_FIELD_NUMBER = 13;
    public static final int INPUT_FIELD_NUMBER = 11;
    public static final int META_DATA_FIELD_NUMBER = 103;
    public static final int ORIGIN_TASK_ID_FIELD_NUMBER = 4;
    public static final int OUTPUT_FIELD_NUMBER = 12;
    public static final int PARENT_TASK_ID_FIELD_NUMBER = 2;
    private static volatile Parser<Task> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 9;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    public static final int USER_FIELD_NUMBER = 7;
    private Agent agent_;
    private int bitField0_;
    private TaskInput input_;
    private TaskOutput output_;
    private User user_;
    private MapFieldLite<String, String> metaData_ = MapFieldLite.emptyMapField();
    private String taskId_ = "";
    private String parentTaskId_ = "";
    private Internal.ProtobufList<String> childTaskIds_ = GeneratedMessageLite.emptyProtobufList();
    private String originTaskId_ = "";
    private String status_ = "";
    private String error_ = "";
    private Internal.ProtobufList<Item> execution_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.zyql.protobuf.skull.Task$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Task, Builder> implements TaskOrBuilder {
        public Builder addAllChildTaskIds(Iterable<String> iterable) {
            copyOnWrite();
            ((Task) this.instance).addAllChildTaskIds(iterable);
            return this;
        }

        public Builder addAllExecution(Iterable<? extends Item> iterable) {
            copyOnWrite();
            ((Task) this.instance).addAllExecution(iterable);
            return this;
        }

        public Builder addChildTaskIds(String str) {
            copyOnWrite();
            ((Task) this.instance).addChildTaskIds(str);
            return this;
        }

        public Builder addChildTaskIdsBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Task) this.instance).addChildTaskIdsBytes(byteString);
            return this;
        }

        public Builder addExecution(Item item) {
            copyOnWrite();
            ((Task) this.instance).addExecution(item);
            return this;
        }

        public Builder clearAgent() {
            copyOnWrite();
            ((Task) this.instance).clearAgent();
            return this;
        }

        public Builder clearChildTaskIds() {
            copyOnWrite();
            ((Task) this.instance).clearChildTaskIds();
            return this;
        }

        public Builder clearError() {
            copyOnWrite();
            ((Task) this.instance).clearError();
            return this;
        }

        public Builder clearExecution() {
            copyOnWrite();
            ((Task) this.instance).clearExecution();
            return this;
        }

        public Builder clearInput() {
            copyOnWrite();
            ((Task) this.instance).clearInput();
            return this;
        }

        public Builder clearMetaData() {
            copyOnWrite();
            ((Task) this.instance).getMutableMetaDataMap().clear();
            return this;
        }

        public Builder clearOriginTaskId() {
            copyOnWrite();
            ((Task) this.instance).clearOriginTaskId();
            return this;
        }

        public Builder clearOutput() {
            copyOnWrite();
            ((Task) this.instance).clearOutput();
            return this;
        }

        public Builder clearParentTaskId() {
            copyOnWrite();
            ((Task) this.instance).clearParentTaskId();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((Task) this.instance).clearStatus();
            return this;
        }

        public Builder clearTaskId() {
            copyOnWrite();
            ((Task) this.instance).clearTaskId();
            return this;
        }

        public Builder clearUser() {
            copyOnWrite();
            ((Task) this.instance).clearUser();
            return this;
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public boolean containsMetaData(String str) {
            str.getClass();
            return ((Task) this.instance).getMetaDataMap().containsKey(str);
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public Agent getAgent() {
            return ((Task) this.instance).getAgent();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public String getChildTaskIds(int i10) {
            return ((Task) this.instance).getChildTaskIds(i10);
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public ByteString getChildTaskIdsBytes(int i10) {
            return ((Task) this.instance).getChildTaskIdsBytes(i10);
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public int getChildTaskIdsCount() {
            return ((Task) this.instance).getChildTaskIdsCount();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public List<String> getChildTaskIdsList() {
            return Collections.unmodifiableList(((Task) this.instance).getChildTaskIdsList());
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public String getError() {
            return ((Task) this.instance).getError();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public ByteString getErrorBytes() {
            return ((Task) this.instance).getErrorBytes();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public Item getExecution(int i10) {
            return ((Task) this.instance).getExecution(i10);
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public int getExecutionCount() {
            return ((Task) this.instance).getExecutionCount();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public List<Item> getExecutionList() {
            return Collections.unmodifiableList(((Task) this.instance).getExecutionList());
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public TaskInput getInput() {
            return ((Task) this.instance).getInput();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        @Deprecated
        public Map<String, String> getMetaData() {
            return getMetaDataMap();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public int getMetaDataCount() {
            return ((Task) this.instance).getMetaDataMap().size();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public Map<String, String> getMetaDataMap() {
            return Collections.unmodifiableMap(((Task) this.instance).getMetaDataMap());
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public String getMetaDataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> metaDataMap = ((Task) this.instance).getMetaDataMap();
            return metaDataMap.containsKey(str) ? metaDataMap.get(str) : str2;
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public String getMetaDataOrThrow(String str) {
            str.getClass();
            Map<String, String> metaDataMap = ((Task) this.instance).getMetaDataMap();
            if (metaDataMap.containsKey(str)) {
                return metaDataMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public String getOriginTaskId() {
            return ((Task) this.instance).getOriginTaskId();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public ByteString getOriginTaskIdBytes() {
            return ((Task) this.instance).getOriginTaskIdBytes();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public TaskOutput getOutput() {
            return ((Task) this.instance).getOutput();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public String getParentTaskId() {
            return ((Task) this.instance).getParentTaskId();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public ByteString getParentTaskIdBytes() {
            return ((Task) this.instance).getParentTaskIdBytes();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public String getStatus() {
            return ((Task) this.instance).getStatus();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public ByteString getStatusBytes() {
            return ((Task) this.instance).getStatusBytes();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public String getTaskId() {
            return ((Task) this.instance).getTaskId();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public ByteString getTaskIdBytes() {
            return ((Task) this.instance).getTaskIdBytes();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public User getUser() {
            return ((Task) this.instance).getUser();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public boolean hasAgent() {
            return ((Task) this.instance).hasAgent();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public boolean hasInput() {
            return ((Task) this.instance).hasInput();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public boolean hasOutput() {
            return ((Task) this.instance).hasOutput();
        }

        @Override // com.zyql.protobuf.skull.TaskOrBuilder
        public boolean hasUser() {
            return ((Task) this.instance).hasUser();
        }

        public Builder mergeAgent(Agent agent) {
            copyOnWrite();
            ((Task) this.instance).mergeAgent(agent);
            return this;
        }

        public Builder mergeInput(TaskInput taskInput) {
            copyOnWrite();
            ((Task) this.instance).mergeInput(taskInput);
            return this;
        }

        public Builder mergeOutput(TaskOutput taskOutput) {
            copyOnWrite();
            ((Task) this.instance).mergeOutput(taskOutput);
            return this;
        }

        public Builder mergeUser(User user) {
            copyOnWrite();
            ((Task) this.instance).mergeUser(user);
            return this;
        }

        public Builder putAllMetaData(Map<String, String> map) {
            copyOnWrite();
            ((Task) this.instance).getMutableMetaDataMap().putAll(map);
            return this;
        }

        public Builder putMetaData(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((Task) this.instance).getMutableMetaDataMap().put(str, str2);
            return this;
        }

        public Builder removeExecution(int i10) {
            copyOnWrite();
            ((Task) this.instance).removeExecution(i10);
            return this;
        }

        public Builder removeMetaData(String str) {
            str.getClass();
            copyOnWrite();
            ((Task) this.instance).getMutableMetaDataMap().remove(str);
            return this;
        }

        public Builder setAgent(Agent agent) {
            copyOnWrite();
            ((Task) this.instance).setAgent(agent);
            return this;
        }

        public Builder setChildTaskIds(int i10, String str) {
            copyOnWrite();
            ((Task) this.instance).setChildTaskIds(i10, str);
            return this;
        }

        public Builder setError(String str) {
            copyOnWrite();
            ((Task) this.instance).setError(str);
            return this;
        }

        public Builder setErrorBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Task) this.instance).setErrorBytes(byteString);
            return this;
        }

        public Builder setExecution(int i10, Item item) {
            copyOnWrite();
            ((Task) this.instance).setExecution(i10, item);
            return this;
        }

        public Builder setInput(TaskInput taskInput) {
            copyOnWrite();
            ((Task) this.instance).setInput(taskInput);
            return this;
        }

        public Builder setOriginTaskId(String str) {
            copyOnWrite();
            ((Task) this.instance).setOriginTaskId(str);
            return this;
        }

        public Builder setOriginTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Task) this.instance).setOriginTaskIdBytes(byteString);
            return this;
        }

        public Builder setOutput(TaskOutput taskOutput) {
            copyOnWrite();
            ((Task) this.instance).setOutput(taskOutput);
            return this;
        }

        public Builder setParentTaskId(String str) {
            copyOnWrite();
            ((Task) this.instance).setParentTaskId(str);
            return this;
        }

        public Builder setParentTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Task) this.instance).setParentTaskIdBytes(byteString);
            return this;
        }

        public Builder setStatus(String str) {
            copyOnWrite();
            ((Task) this.instance).setStatus(str);
            return this;
        }

        public Builder setStatusBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Task) this.instance).setStatusBytes(byteString);
            return this;
        }

        public Builder setTaskId(String str) {
            copyOnWrite();
            ((Task) this.instance).setTaskId(str);
            return this;
        }

        public Builder setTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
            copyOnWrite();
            ((Task) this.instance).setTaskIdBytes(byteString);
            return this;
        }

        public Builder setUser(User user) {
            copyOnWrite();
            ((Task) this.instance).setUser(user);
            return this;
        }

        private Builder() {
            super(Task.DEFAULT_INSTANCE);
        }

        public Builder addExecution(int i10, Item item) {
            copyOnWrite();
            ((Task) this.instance).addExecution(i10, item);
            return this;
        }

        public Builder setAgent(Agent.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).setAgent(builder.build());
            return this;
        }

        public Builder setExecution(int i10, Item.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).setExecution(i10, builder.build());
            return this;
        }

        public Builder setInput(TaskInput.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).setInput(builder.build());
            return this;
        }

        public Builder setOutput(TaskOutput.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).setOutput(builder.build());
            return this;
        }

        public Builder setUser(User.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).setUser(builder.build());
            return this;
        }

        public Builder addExecution(Item.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).addExecution(builder.build());
            return this;
        }

        public Builder addExecution(int i10, Item.Builder builder) {
            copyOnWrite();
            ((Task) this.instance).addExecution(i10, builder.build());
            return this;
        }
    }

    public static final class From extends GeneratedMessageLite<From, Builder> implements FromOrBuilder {
        public static final int AGENT_FIELD_NUMBER = 6;
        private static final From DEFAULT_INSTANCE;
        private static volatile Parser<From> PARSER = null;
        public static final int USER_FIELD_NUMBER = 5;
        private Agent agent_;
        private int bitField0_;
        private User user_;

        public static final class Builder extends GeneratedMessageLite.Builder<From, Builder> implements FromOrBuilder {
            public Builder clearAgent() {
                copyOnWrite();
                ((From) this.instance).clearAgent();
                return this;
            }

            public Builder clearUser() {
                copyOnWrite();
                ((From) this.instance).clearUser();
                return this;
            }

            @Override // com.zyql.protobuf.skull.Task.FromOrBuilder
            public Agent getAgent() {
                return ((From) this.instance).getAgent();
            }

            @Override // com.zyql.protobuf.skull.Task.FromOrBuilder
            public User getUser() {
                return ((From) this.instance).getUser();
            }

            @Override // com.zyql.protobuf.skull.Task.FromOrBuilder
            public boolean hasAgent() {
                return ((From) this.instance).hasAgent();
            }

            @Override // com.zyql.protobuf.skull.Task.FromOrBuilder
            public boolean hasUser() {
                return ((From) this.instance).hasUser();
            }

            public Builder mergeAgent(Agent agent) {
                copyOnWrite();
                ((From) this.instance).mergeAgent(agent);
                return this;
            }

            public Builder mergeUser(User user) {
                copyOnWrite();
                ((From) this.instance).mergeUser(user);
                return this;
            }

            public Builder setAgent(Agent agent) {
                copyOnWrite();
                ((From) this.instance).setAgent(agent);
                return this;
            }

            public Builder setUser(User user) {
                copyOnWrite();
                ((From) this.instance).setUser(user);
                return this;
            }

            private Builder() {
                super(From.DEFAULT_INSTANCE);
            }

            public Builder setAgent(Agent.Builder builder) {
                copyOnWrite();
                ((From) this.instance).setAgent(builder.build());
                return this;
            }

            public Builder setUser(User.Builder builder) {
                copyOnWrite();
                ((From) this.instance).setUser(builder.build());
                return this;
            }
        }

        static {
            From from = new From();
            DEFAULT_INSTANCE = from;
            GeneratedMessageLite.registerDefaultInstance(From.class, from);
        }

        private From() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAgent() {
            this.agent_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUser() {
            this.user_ = null;
            this.bitField0_ &= -2;
        }

        public static From getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAgent(Agent agent) {
            agent.getClass();
            Agent agent2 = this.agent_;
            if (agent2 == null || agent2 == Agent.getDefaultInstance()) {
                this.agent_ = agent;
            } else {
                this.agent_ = Agent.newBuilder(this.agent_).mergeFrom((Agent.Builder) agent).buildPartial();
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeUser(User user) {
            user.getClass();
            User user2 = this.user_;
            if (user2 == null || user2 == User.getDefaultInstance()) {
                this.user_ = user;
            } else {
                this.user_ = User.newBuilder(this.user_).mergeFrom((User.Builder) user).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static From parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (From) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static From parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (From) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<From> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAgent(Agent agent) {
            agent.getClass();
            this.agent_ = agent;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUser(User user) {
            user.getClass();
            this.user_ = user;
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i10) {
                case 1:
                    return new From();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0005\u0006\u0002\u0000\u0000\u0000\u0005ဉ\u0000\u0006ဉ\u0001", new Object[]{"bitField0_", "user_", "agent_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<From> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (From.class) {
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

        @Override // com.zyql.protobuf.skull.Task.FromOrBuilder
        public Agent getAgent() {
            Agent agent = this.agent_;
            return agent == null ? Agent.getDefaultInstance() : agent;
        }

        @Override // com.zyql.protobuf.skull.Task.FromOrBuilder
        public User getUser() {
            User user = this.user_;
            return user == null ? User.getDefaultInstance() : user;
        }

        @Override // com.zyql.protobuf.skull.Task.FromOrBuilder
        public boolean hasAgent() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.zyql.protobuf.skull.Task.FromOrBuilder
        public boolean hasUser() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(From from) {
            return DEFAULT_INSTANCE.createBuilder(from);
        }

        public static From parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (From) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static From parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (From) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static From parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (From) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static From parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (From) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static From parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (From) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static From parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (From) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static From parseFrom(InputStream inputStream) throws IOException {
            return (From) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static From parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (From) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static From parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (From) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static From parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (From) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface FromOrBuilder extends MessageLiteOrBuilder {
        Agent getAgent();

        User getUser();

        boolean hasAgent();

        boolean hasUser();
    }

    public static final class MetaDataDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private MetaDataDefaultEntryHolder() {
        }
    }

    static {
        Task task = new Task();
        DEFAULT_INSTANCE = task;
        GeneratedMessageLite.registerDefaultInstance(Task.class, task);
    }

    private Task() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllChildTaskIds(Iterable<String> iterable) {
        ensureChildTaskIdsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.childTaskIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllExecution(Iterable<? extends Item> iterable) {
        ensureExecutionIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.execution_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChildTaskIds(String str) {
        str.getClass();
        ensureChildTaskIdsIsMutable();
        this.childTaskIds_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChildTaskIdsBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        ensureChildTaskIdsIsMutable();
        this.childTaskIds_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addExecution(Item item) {
        item.getClass();
        ensureExecutionIsMutable();
        this.execution_.add(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgent() {
        this.agent_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChildTaskIds() {
        this.childTaskIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExecution() {
        this.execution_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInput() {
        this.input_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOriginTaskId() {
        this.originTaskId_ = getDefaultInstance().getOriginTaskId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutput() {
        this.output_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParentTaskId() {
        this.parentTaskId_ = getDefaultInstance().getParentTaskId();
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
    public void clearUser() {
        this.user_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureChildTaskIdsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.childTaskIds_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.childTaskIds_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureExecutionIsMutable() {
        Internal.ProtobufList<Item> protobufList = this.execution_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.execution_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static Task getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableMetaDataMap() {
        return internalGetMutableMetaData();
    }

    private MapFieldLite<String, String> internalGetMetaData() {
        return this.metaData_;
    }

    private MapFieldLite<String, String> internalGetMutableMetaData() {
        if (!this.metaData_.isMutable()) {
            this.metaData_ = this.metaData_.mutableCopy();
        }
        return this.metaData_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAgent(Agent agent) {
        agent.getClass();
        Agent agent2 = this.agent_;
        if (agent2 == null || agent2 == Agent.getDefaultInstance()) {
            this.agent_ = agent;
        } else {
            this.agent_ = Agent.newBuilder(this.agent_).mergeFrom((Agent.Builder) agent).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInput(TaskInput taskInput) {
        taskInput.getClass();
        TaskInput taskInput2 = this.input_;
        if (taskInput2 == null || taskInput2 == TaskInput.getDefaultInstance()) {
            this.input_ = taskInput;
        } else {
            this.input_ = TaskInput.newBuilder(this.input_).mergeFrom((TaskInput.Builder) taskInput).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOutput(TaskOutput taskOutput) {
        taskOutput.getClass();
        TaskOutput taskOutput2 = this.output_;
        if (taskOutput2 == null || taskOutput2 == TaskOutput.getDefaultInstance()) {
            this.output_ = taskOutput;
        } else {
            this.output_ = TaskOutput.newBuilder(this.output_).mergeFrom((TaskOutput.Builder) taskOutput).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUser(User user) {
        user.getClass();
        User user2 = this.user_;
        if (user2 == null || user2 == User.getDefaultInstance()) {
            this.user_ = user;
        } else {
            this.user_ = User.newBuilder(this.user_).mergeFrom((User.Builder) user).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Task parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Task) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Task parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Task> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeExecution(int i10) {
        ensureExecutionIsMutable();
        this.execution_.remove(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgent(Agent agent) {
        agent.getClass();
        this.agent_ = agent;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChildTaskIds(int i10, String str) {
        str.getClass();
        ensureChildTaskIdsIsMutable();
        this.childTaskIds_.set(i10, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.error_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExecution(int i10, Item item) {
        item.getClass();
        ensureExecutionIsMutable();
        this.execution_.set(i10, item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInput(TaskInput taskInput) {
        taskInput.getClass();
        this.input_ = taskInput;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOriginTaskId(String str) {
        str.getClass();
        this.originTaskId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOriginTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.originTaskId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutput(TaskOutput taskOutput) {
        taskOutput.getClass();
        this.output_ = taskOutput;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParentTaskId(String str) {
        str.getClass();
        this.parentTaskId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParentTaskIdBytes(ByteString byteString) throws IllegalArgumentException {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.parentTaskId_ = byteString.toStringUtf8();
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
    public void setUser(User user) {
        user.getClass();
        this.user_ = user;
        this.bitField0_ |= 1;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public boolean containsMetaData(String str) {
        str.getClass();
        return internalGetMetaData().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Task();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0001\u0001g\f\u0001\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003Ț\u0004Ȉ\u0007ဉ\u0000\bဉ\u0001\tȈ\nȈ\u000bဉ\u0002\fဉ\u0003\r\u001bg2", new Object[]{"bitField0_", "taskId_", "parentTaskId_", "childTaskIds_", "originTaskId_", "user_", "agent_", "status_", "error_", "input_", "output_", "execution_", Item.class, "metaData_", MetaDataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Task> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Task.class) {
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

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public Agent getAgent() {
        Agent agent = this.agent_;
        return agent == null ? Agent.getDefaultInstance() : agent;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public String getChildTaskIds(int i10) {
        return this.childTaskIds_.get(i10);
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public ByteString getChildTaskIdsBytes(int i10) {
        return ByteString.copyFromUtf8(this.childTaskIds_.get(i10));
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public int getChildTaskIdsCount() {
        return this.childTaskIds_.size();
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public List<String> getChildTaskIdsList() {
        return this.childTaskIds_;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public String getError() {
        return this.error_;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public ByteString getErrorBytes() {
        return ByteString.copyFromUtf8(this.error_);
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public Item getExecution(int i10) {
        return this.execution_.get(i10);
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public int getExecutionCount() {
        return this.execution_.size();
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public List<Item> getExecutionList() {
        return this.execution_;
    }

    public ItemOrBuilder getExecutionOrBuilder(int i10) {
        return this.execution_.get(i10);
    }

    public List<? extends ItemOrBuilder> getExecutionOrBuilderList() {
        return this.execution_;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public TaskInput getInput() {
        TaskInput taskInput = this.input_;
        return taskInput == null ? TaskInput.getDefaultInstance() : taskInput;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    @Deprecated
    public Map<String, String> getMetaData() {
        return getMetaDataMap();
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public int getMetaDataCount() {
        return internalGetMetaData().size();
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public Map<String, String> getMetaDataMap() {
        return Collections.unmodifiableMap(internalGetMetaData());
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public String getMetaDataOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetaData = internalGetMetaData();
        return mapFieldLiteInternalGetMetaData.containsKey(str) ? mapFieldLiteInternalGetMetaData.get(str) : str2;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public String getMetaDataOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> mapFieldLiteInternalGetMetaData = internalGetMetaData();
        if (mapFieldLiteInternalGetMetaData.containsKey(str)) {
            return mapFieldLiteInternalGetMetaData.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public String getOriginTaskId() {
        return this.originTaskId_;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public ByteString getOriginTaskIdBytes() {
        return ByteString.copyFromUtf8(this.originTaskId_);
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public TaskOutput getOutput() {
        TaskOutput taskOutput = this.output_;
        return taskOutput == null ? TaskOutput.getDefaultInstance() : taskOutput;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public String getParentTaskId() {
        return this.parentTaskId_;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public ByteString getParentTaskIdBytes() {
        return ByteString.copyFromUtf8(this.parentTaskId_);
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public String getStatus() {
        return this.status_;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public ByteString getStatusBytes() {
        return ByteString.copyFromUtf8(this.status_);
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public String getTaskId() {
        return this.taskId_;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public ByteString getTaskIdBytes() {
        return ByteString.copyFromUtf8(this.taskId_);
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public User getUser() {
        User user = this.user_;
        return user == null ? User.getDefaultInstance() : user;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public boolean hasAgent() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public boolean hasInput() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public boolean hasOutput() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.zyql.protobuf.skull.TaskOrBuilder
    public boolean hasUser() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(Task task) {
        return DEFAULT_INSTANCE.createBuilder(task);
    }

    public static Task parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Task) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Task parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Task parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addExecution(int i10, Item item) {
        item.getClass();
        ensureExecutionIsMutable();
        this.execution_.add(i10, item);
    }

    public static Task parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Task parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Task parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Task parseFrom(InputStream inputStream) throws IOException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Task parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Task parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Task parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Task) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
