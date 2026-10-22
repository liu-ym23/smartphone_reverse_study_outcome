package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.zyql.protobuf.agent.DirSkillLoader;
import com.zyql.protobuf.agent.InlineSkill;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class Skill extends GeneratedMessageLite<Skill, Builder> implements SkillOrBuilder {
    private static final Skill DEFAULT_INSTANCE;
    public static final int DIR_SKILL_LOADER_FIELD_NUMBER = 2;
    public static final int INLINE_SKILL_FIELD_NUMBER = 1;
    private static volatile Parser<Skill> PARSER;
    private int skillCase_ = 0;
    private Object skill_;

    /* renamed from: com.zyql.protobuf.agent.Skill$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Skill, Builder> implements SkillOrBuilder {
        public Builder clearDirSkillLoader() {
            copyOnWrite();
            ((Skill) this.instance).clearDirSkillLoader();
            return this;
        }

        public Builder clearInlineSkill() {
            copyOnWrite();
            ((Skill) this.instance).clearInlineSkill();
            return this;
        }

        public Builder clearSkill() {
            copyOnWrite();
            ((Skill) this.instance).clearSkill();
            return this;
        }

        @Override // com.zyql.protobuf.agent.SkillOrBuilder
        public DirSkillLoader getDirSkillLoader() {
            return ((Skill) this.instance).getDirSkillLoader();
        }

        @Override // com.zyql.protobuf.agent.SkillOrBuilder
        public InlineSkill getInlineSkill() {
            return ((Skill) this.instance).getInlineSkill();
        }

        @Override // com.zyql.protobuf.agent.SkillOrBuilder
        public SkillCase getSkillCase() {
            return ((Skill) this.instance).getSkillCase();
        }

        @Override // com.zyql.protobuf.agent.SkillOrBuilder
        public boolean hasDirSkillLoader() {
            return ((Skill) this.instance).hasDirSkillLoader();
        }

        @Override // com.zyql.protobuf.agent.SkillOrBuilder
        public boolean hasInlineSkill() {
            return ((Skill) this.instance).hasInlineSkill();
        }

        public Builder mergeDirSkillLoader(DirSkillLoader dirSkillLoader) {
            copyOnWrite();
            ((Skill) this.instance).mergeDirSkillLoader(dirSkillLoader);
            return this;
        }

        public Builder mergeInlineSkill(InlineSkill inlineSkill) {
            copyOnWrite();
            ((Skill) this.instance).mergeInlineSkill(inlineSkill);
            return this;
        }

        public Builder setDirSkillLoader(DirSkillLoader dirSkillLoader) {
            copyOnWrite();
            ((Skill) this.instance).setDirSkillLoader(dirSkillLoader);
            return this;
        }

        public Builder setInlineSkill(InlineSkill inlineSkill) {
            copyOnWrite();
            ((Skill) this.instance).setInlineSkill(inlineSkill);
            return this;
        }

        private Builder() {
            super(Skill.DEFAULT_INSTANCE);
        }

        public Builder setDirSkillLoader(DirSkillLoader.Builder builder) {
            copyOnWrite();
            ((Skill) this.instance).setDirSkillLoader(builder.build());
            return this;
        }

        public Builder setInlineSkill(InlineSkill.Builder builder) {
            copyOnWrite();
            ((Skill) this.instance).setInlineSkill(builder.build());
            return this;
        }
    }

    public enum SkillCase {
        INLINE_SKILL(1),
        DIR_SKILL_LOADER(2),
        SKILL_NOT_SET(0);

        private final int value;

        SkillCase(int i10) {
            this.value = i10;
        }

        public static SkillCase forNumber(int i10) {
            if (i10 == 0) {
                return SKILL_NOT_SET;
            }
            if (i10 == 1) {
                return INLINE_SKILL;
            }
            if (i10 != 2) {
                return null;
            }
            return DIR_SKILL_LOADER;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static SkillCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        Skill skill = new Skill();
        DEFAULT_INSTANCE = skill;
        GeneratedMessageLite.registerDefaultInstance(Skill.class, skill);
    }

    private Skill() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDirSkillLoader() {
        if (this.skillCase_ == 2) {
            this.skillCase_ = 0;
            this.skill_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInlineSkill() {
        if (this.skillCase_ == 1) {
            this.skillCase_ = 0;
            this.skill_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSkill() {
        this.skillCase_ = 0;
        this.skill_ = null;
    }

    public static Skill getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDirSkillLoader(DirSkillLoader dirSkillLoader) {
        dirSkillLoader.getClass();
        if (this.skillCase_ != 2 || this.skill_ == DirSkillLoader.getDefaultInstance()) {
            this.skill_ = dirSkillLoader;
        } else {
            this.skill_ = DirSkillLoader.newBuilder((DirSkillLoader) this.skill_).mergeFrom((DirSkillLoader.Builder) dirSkillLoader).buildPartial();
        }
        this.skillCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInlineSkill(InlineSkill inlineSkill) {
        inlineSkill.getClass();
        if (this.skillCase_ != 1 || this.skill_ == InlineSkill.getDefaultInstance()) {
            this.skill_ = inlineSkill;
        } else {
            this.skill_ = InlineSkill.newBuilder((InlineSkill) this.skill_).mergeFrom((InlineSkill.Builder) inlineSkill).buildPartial();
        }
        this.skillCase_ = 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Skill parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Skill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Skill parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Skill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Skill> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDirSkillLoader(DirSkillLoader dirSkillLoader) {
        dirSkillLoader.getClass();
        this.skill_ = dirSkillLoader;
        this.skillCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInlineSkill(InlineSkill inlineSkill) {
        inlineSkill.getClass();
        this.skill_ = inlineSkill;
        this.skillCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        switch (i10) {
            case 1:
                return new Skill();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"skill_", "skillCase_", InlineSkill.class, DirSkillLoader.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Skill> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Skill.class) {
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

    @Override // com.zyql.protobuf.agent.SkillOrBuilder
    public DirSkillLoader getDirSkillLoader() {
        return this.skillCase_ == 2 ? (DirSkillLoader) this.skill_ : DirSkillLoader.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.SkillOrBuilder
    public InlineSkill getInlineSkill() {
        return this.skillCase_ == 1 ? (InlineSkill) this.skill_ : InlineSkill.getDefaultInstance();
    }

    @Override // com.zyql.protobuf.agent.SkillOrBuilder
    public SkillCase getSkillCase() {
        return SkillCase.forNumber(this.skillCase_);
    }

    @Override // com.zyql.protobuf.agent.SkillOrBuilder
    public boolean hasDirSkillLoader() {
        return this.skillCase_ == 2;
    }

    @Override // com.zyql.protobuf.agent.SkillOrBuilder
    public boolean hasInlineSkill() {
        return this.skillCase_ == 1;
    }

    public static Builder newBuilder(Skill skill) {
        return DEFAULT_INSTANCE.createBuilder(skill);
    }

    public static Skill parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Skill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Skill parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Skill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Skill parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Skill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Skill parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Skill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Skill parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Skill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Skill parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Skill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Skill parseFrom(InputStream inputStream) throws IOException {
        return (Skill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Skill parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Skill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Skill parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Skill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Skill parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Skill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
