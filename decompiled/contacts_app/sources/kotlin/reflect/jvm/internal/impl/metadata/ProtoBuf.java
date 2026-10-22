package kotlin.reflect.jvm.internal.impl.metadata;

import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;

/* JADX INFO: loaded from: classes4.dex */
public final class ProtoBuf {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Annotation extends GeneratedMessageLite implements AnnotationOrBuilder {
        public static Parser<Annotation> PARSER;
        private static final Annotation defaultInstance = null;
        private List<Argument> argument_;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER;
            private static final Argument defaultInstance = null;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int nameId_;
            private final ByteString unknownFields;
            private Value value_;

            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private int nameId_;
                private Value value_;

                private void maybeForceBuilderInitialization() {
                }

                static /* synthetic */ Builder access$3600() {
                    return create();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                    return mergeFrom(r1, r2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                    return mergeFrom((Argument) r1);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                    return mergeFrom(r1, r2);
                }

                private Builder() {
                    this.value_ = Value.getDefaultInstance();
                    maybeForceBuilderInitialization();
                }

                private static Builder create() {
                    return new Builder();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument r1 = buildPartial();
                    if (r1.isInitialized() == false) goto L6;
                    return r1;
                L6:
                    throw newUninitializedMessageException(r1);
                }

                public Argument buildPartial() {
                    Argument r0 = new Argument(this, null);
                    int r1 = this.bitField0_;
                    int r3 = 1;
                    if ((r1 & 1) == 1) goto L6;
                    r3 = 0;
                L6:
                    Argument.access$3802(r0, this.nameId_);
                    if ((r1 & 2) != 2) goto L9;
                    r3 = r3 | 2;
                L9:
                    Argument.access$3902(r0, this.value_);
                    Argument.access$4002(r0, r3);
                    return r0;
                }

                public Builder mergeFrom(Argument r2) {
                    if (r2 != Argument.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r2.hasNameId() == false) goto L9;
                    setNameId(r2.getNameId());
                L9:
                    if (r2.hasValue() == false) goto L11;
                    mergeValue(r2.getValue());
                L11:
                    setUnknownFields(getUnknownFields().concat(Argument.access$4100(r2)));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasNameId() == true) goto L6;
                    return false;
                L6:
                    if (hasValue() == true) goto L9;
                    return false;
                L9:
                    if (getValue().isInitialized() == true) goto L11;
                    return false;
                L11:
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                    Argument r0 = null;
                    Argument r5 = Argument.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r5 == null) goto L6;
                    mergeFrom(r5);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Argument r6 = (Argument) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r0 = r6;
                L14:
                    if (r0 == null) goto L16;
                    mergeFrom(r0);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }

                public boolean hasNameId() {
                    if ((this.bitField0_ & 1) == 1) goto L7;
                    return false;
                L7:
                    return true;
                }

                public Builder setNameId(int r2) {
                    this.bitField0_ |= 1;
                    this.nameId_ = r2;
                    return this;
                }

                public boolean hasValue() {
                    if ((this.bitField0_ & 2) != 2) goto L5;
                    return true;
                L5:
                    return false;
                }

                public Value getValue() {
                    return this.value_;
                }

                public Builder mergeValue(Value r4) {
                    if ((this.bitField0_ & 2) == 2) goto L5;
                L7:
                    this.value_ = r4;
                L8:
                    this.bitField0_ |= 2;
                    return this;
                L5:
                    if (this.value_ == Value.getDefaultInstance()) goto L7;
                    this.value_ = Value.newBuilder(this.value_).mergeFrom(r4).buildPartial();
                    goto L8
                }
            }

            public static final class Value extends GeneratedMessageLite implements ValueOrBuilder {
                public static Parser<Value> PARSER;
                private static final Value defaultInstance = null;
                private Annotation annotation_;
                private int arrayDimensionCount_;
                private List<Value> arrayElement_;
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                private int stringValue_;
                private Type type_;
                private final ByteString unknownFields;

                public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
                    private Annotation annotation_;
                    private int arrayDimensionCount_;
                    private List<Value> arrayElement_;
                    private int bitField0_;
                    private int classId_;
                    private double doubleValue_;
                    private int enumValueId_;
                    private int flags_;
                    private float floatValue_;
                    private long intValue_;
                    private int stringValue_;
                    private Type type_;

                    private void maybeForceBuilderInitialization() {
                    }

                    static /* synthetic */ Builder access$2100() {
                        return create();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public /* bridge */ /* synthetic */ MessageLite build() {
                        return build();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                        return clone();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    /* JADX INFO: renamed from: clone */
                    public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                        return clone();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                        return clone();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                        return getDefaultInstanceForType();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                        return getDefaultInstanceForType();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                        return mergeFrom(r1, r2);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                    public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                        return mergeFrom((Value) r1);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                        return mergeFrom(r1, r2);
                    }

                    private Builder() {
                        this.type_ = Type.BYTE;
                        this.annotation_ = Annotation.getDefaultInstance();
                        this.arrayElement_ = Collections.emptyList();
                        maybeForceBuilderInitialization();
                    }

                    private static Builder create() {
                        return new Builder();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    public Builder clone() {
                        return create().mergeFrom(buildPartial());
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public Value build() {
                        Value r1 = buildPartial();
                        if (r1.isInitialized() == false) goto L6;
                        return r1;
                    L6:
                        throw newUninitializedMessageException(r1);
                    }

                    public Value buildPartial() {
                        Value r0 = new Value(this, null);
                        int r1 = this.bitField0_;
                        int r3 = 1;
                        if ((r1 & 1) == 1) goto L6;
                        r3 = 0;
                    L6:
                        Value.access$2302(r0, this.type_);
                        if ((r1 & 2) != 2) goto L9;
                        r3 = r3 | 2;
                    L9:
                        Value.access$2402(r0, this.intValue_);
                        if ((r1 & 4) != 4) goto L12;
                        r3 = r3 | 4;
                    L12:
                        Value.access$2502(r0, this.floatValue_);
                        if ((r1 & 8) != 8) goto L15;
                        r3 = r3 | 8;
                    L15:
                        Value.access$2602(r0, this.doubleValue_);
                        if ((r1 & 16) != 16) goto L18;
                        r3 = r3 | 16;
                    L18:
                        Value.access$2702(r0, this.stringValue_);
                        if ((r1 & 32) != 32) goto L21;
                        r3 = r3 | 32;
                    L21:
                        Value.access$2802(r0, this.classId_);
                        if ((r1 & 64) != 64) goto L24;
                        r3 = r3 | 64;
                    L24:
                        Value.access$2902(r0, this.enumValueId_);
                        if ((r1 & 128) != 128) goto L27;
                        r3 = r3 | 128;
                    L27:
                        Value.access$3002(r0, this.annotation_);
                        if ((this.bitField0_ & 256) != 256) goto L30;
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                        this.bitField0_ &= -257;
                    L30:
                        Value.access$3102(r0, this.arrayElement_);
                        if ((r1 & 512) != 512) goto L33;
                        r3 = r3 | 256;
                    L33:
                        Value.access$3202(r0, this.arrayDimensionCount_);
                        if ((r1 & 1024) != 1024) goto L36;
                        r3 = r3 | 512;
                    L36:
                        Value.access$3302(r0, this.flags_);
                        Value.access$3402(r0, r3);
                        return r0;
                    }

                    public Builder mergeFrom(Value r3) {
                        if (r3 != Value.getDefaultInstance()) goto L6;
                        return this;
                    L6:
                        if (r3.hasType() == false) goto L9;
                        setType(r3.getType());
                    L9:
                        if (r3.hasIntValue() == false) goto L12;
                        setIntValue(r3.getIntValue());
                    L12:
                        if (r3.hasFloatValue() == false) goto L15;
                        setFloatValue(r3.getFloatValue());
                    L15:
                        if (r3.hasDoubleValue() == false) goto L18;
                        setDoubleValue(r3.getDoubleValue());
                    L18:
                        if (r3.hasStringValue() == false) goto L21;
                        setStringValue(r3.getStringValue());
                    L21:
                        if (r3.hasClassId() == false) goto L24;
                        setClassId(r3.getClassId());
                    L24:
                        if (r3.hasEnumValueId() == false) goto L27;
                        setEnumValueId(r3.getEnumValueId());
                    L27:
                        if (r3.hasAnnotation() == false) goto L30;
                        mergeAnnotation(r3.getAnnotation());
                    L30:
                        if (Value.access$3100(r3).isEmpty() == true) goto L36;
                        if (this.arrayElement_.isEmpty() == false) goto L34;
                        this.arrayElement_ = Value.access$3100(r3);
                        this.bitField0_ &= -257;
                        goto L36
                    L34:
                        ensureArrayElementIsMutable();
                        this.arrayElement_.addAll(Value.access$3100(r3));
                    L36:
                        if (r3.hasArrayDimensionCount() == false) goto L39;
                        setArrayDimensionCount(r3.getArrayDimensionCount());
                    L39:
                        if (r3.hasFlags() == false) goto L41;
                        setFlags(r3.getFlags());
                    L41:
                        setUnknownFields(getUnknownFields().concat(Value.access$3500(r3)));
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public final boolean isInitialized() {
                        if (hasAnnotation() == true) goto L5;
                    L7:
                        int r0 = 0;
                    L9:
                        if (r0 >= getArrayElementCount()) goto L14;
                        if (getArrayElement(r0).isInitialized() == false) goto L12;
                        r0 = r0 + 1;
                        goto L9
                    L12:
                        return false;
                    L14:
                        return true;
                    L5:
                        if (getAnnotation().isInitialized() == true) goto L7;
                        return false;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                        Value r0 = null;
                        Value r5 = Value.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                        if (r5 == null) goto L6;
                        mergeFrom(r5);
                    L6:
                        return this;
                    L9:
                        e = move-exception;
                        Value r6 = (Value) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                        throw e;     // Catch: Throwable -> L12
                    L12:
                        th = th;
                        r0 = r6;
                    L14:
                        if (r0 == null) goto L16;
                        mergeFrom(r0);
                    L16:
                        throw th;
                    L7:
                        th = th;
                        goto L14
                    }

                    public Builder setType(Type r2) {
                        r2.getClass();
                        this.bitField0_ |= 1;
                        this.type_ = r2;
                        return this;
                    }

                    public Builder setIntValue(long r2) {
                        this.bitField0_ |= 2;
                        this.intValue_ = r2;
                        return this;
                    }

                    public Builder setFloatValue(float r2) {
                        this.bitField0_ |= 4;
                        this.floatValue_ = r2;
                        return this;
                    }

                    public Builder setDoubleValue(double r2) {
                        this.bitField0_ |= 8;
                        this.doubleValue_ = r2;
                        return this;
                    }

                    public Builder setStringValue(int r2) {
                        this.bitField0_ |= 16;
                        this.stringValue_ = r2;
                        return this;
                    }

                    public Builder setClassId(int r2) {
                        this.bitField0_ |= 32;
                        this.classId_ = r2;
                        return this;
                    }

                    public Builder setEnumValueId(int r2) {
                        this.bitField0_ |= 64;
                        this.enumValueId_ = r2;
                        return this;
                    }

                    public boolean hasAnnotation() {
                        if ((this.bitField0_ & 128) != 128) goto L5;
                        return true;
                    L5:
                        return false;
                    }

                    public Annotation getAnnotation() {
                        return this.annotation_;
                    }

                    public Builder mergeAnnotation(Annotation r4) {
                        if ((this.bitField0_ & 128) == 128) goto L5;
                    L7:
                        this.annotation_ = r4;
                    L8:
                        this.bitField0_ |= 128;
                        return this;
                    L5:
                        if (this.annotation_ == Annotation.getDefaultInstance()) goto L7;
                        this.annotation_ = Annotation.newBuilder(this.annotation_).mergeFrom(r4).buildPartial();
                        goto L8
                    }

                    private void ensureArrayElementIsMutable() {
                        if ((this.bitField0_ & 256) == 256) goto L6;
                        this.arrayElement_ = new ArrayList(this.arrayElement_);
                        this.bitField0_ |= 256;
                        return;
                    }

                    public int getArrayElementCount() {
                        return this.arrayElement_.size();
                    }

                    public Value getArrayElement(int r1) {
                        return this.arrayElement_.get(r1);
                    }

                    public Builder setArrayDimensionCount(int r2) {
                        this.bitField0_ |= 512;
                        this.arrayDimensionCount_ = r2;
                        return this;
                    }

                    public Builder setFlags(int r2) {
                        this.bitField0_ |= 1024;
                        this.flags_ = r2;
                        return this;
                    }
                }

                public static final enum Type extends Enum<Type> implements Internal.EnumLite {
                    private static final /* synthetic */ Type[] $VALUES = null;
                    public static final Type ANNOTATION = null;
                    public static final Type ARRAY = null;
                    public static final Type BOOLEAN = null;
                    public static final Type BYTE = null;
                    public static final Type CHAR = null;
                    public static final Type CLASS = null;
                    public static final Type DOUBLE = null;
                    public static final Type ENUM = null;
                    public static final Type FLOAT = null;
                    public static final Type INT = null;
                    public static final Type LONG = null;
                    public static final Type SHORT = null;
                    public static final Type STRING = null;
                    private static Internal.EnumLiteMap<Type> internalValueMap;
                    private final int value;

                    public static Type valueOf(String r1) {
                        return (Type) Enum.valueOf(Type.class, r1);
                    }

                    public static Type[] values() {
                        return (Type[]) $VALUES.clone();
                    }

                    static {
                        Type r0 = new Type("BYTE", 0, 0, 0);
                        BYTE = r0;
                        Type r1 = new Type("CHAR", 1, 1, 1);
                        CHAR = r1;
                        Type r3 = new Type("SHORT", 2, 2, 2);
                        SHORT = r3;
                        Type r5 = new Type("INT", 3, 3, 3);
                        INT = r5;
                        Type r7 = new Type("LONG", 4, 4, 4);
                        LONG = r7;
                        Type r9 = new Type("FLOAT", 5, 5, 5);
                        FLOAT = r9;
                        Type r11 = new Type("DOUBLE", 6, 6, 6);
                        DOUBLE = r11;
                        Type r13 = new Type("BOOLEAN", 7, 7, 7);
                        BOOLEAN = r13;
                        Type r15 = new Type("STRING", 8, 8, 8);
                        STRING = r15;
                        Type r14 = new Type("CLASS", 9, 9, 9);
                        CLASS = r14;
                        Type r12 = new Type("ENUM", 10, 10, 10);
                        ENUM = r12;
                        Type r10 = new Type("ANNOTATION", 11, 11, 11);
                        ANNOTATION = r10;
                        Type r8 = new Type("ARRAY", 12, 12, 12);
                        ARRAY = r8;
                        $VALUES = new Type[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
                        internalValueMap = new AnonymousClass1();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    public static Type valueOf(int r0) {
                        switch(r0) {
                            case 0: goto L30;
                            case 1: goto L28;
                            case 2: goto L26;
                            case 3: goto L24;
                            case 4: goto L22;
                            case 5: goto L20;
                            case 6: goto L18;
                            case 7: goto L16;
                            case 8: goto L14;
                            case 9: goto L12;
                            case 10: goto L10;
                            case 11: goto L8;
                            case 12: goto L6;
                            default: goto L3;
                        };
                    L3:
                        return null;
                    L6:
                        return ARRAY;
                    L8:
                        return ANNOTATION;
                    L10:
                        return ENUM;
                    L12:
                        return CLASS;
                    L14:
                        return STRING;
                    L16:
                        return BOOLEAN;
                    L18:
                        return DOUBLE;
                    L20:
                        return FLOAT;
                    L22:
                        return LONG;
                    L24:
                        return INT;
                    L26:
                        return SHORT;
                    L28:
                        return CHAR;
                    L30:
                        return BYTE;
                    }

                    private Type(String r1, int r2, int r3, int r4) {
                        super(r1, r2);
                        this.value = r4;
                    }
                }

                /* synthetic */ Value(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
                    this(r1, r2);
                }

                /* synthetic */ Value(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
                    this(r1);
                }

                static /* synthetic */ Type access$2302(Value r0, Type r1) {
                    r0.type_ = r1;
                    return r1;
                }

                static /* synthetic */ long access$2402(Value r0, long r1) {
                    r0.intValue_ = r1;
                    return r1;
                }

                static /* synthetic */ float access$2502(Value r0, float r1) {
                    r0.floatValue_ = r1;
                    return r1;
                }

                static /* synthetic */ double access$2602(Value r0, double r1) {
                    r0.doubleValue_ = r1;
                    return r1;
                }

                static /* synthetic */ int access$2702(Value r0, int r1) {
                    r0.stringValue_ = r1;
                    return r1;
                }

                static /* synthetic */ int access$2802(Value r0, int r1) {
                    r0.classId_ = r1;
                    return r1;
                }

                static /* synthetic */ int access$2902(Value r0, int r1) {
                    r0.enumValueId_ = r1;
                    return r1;
                }

                static /* synthetic */ Annotation access$3002(Value r0, Annotation r1) {
                    r0.annotation_ = r1;
                    return r1;
                }

                static /* synthetic */ List access$3100(Value r0) {
                    return r0.arrayElement_;
                }

                static /* synthetic */ List access$3102(Value r0, List r1) {
                    r0.arrayElement_ = r1;
                    return r1;
                }

                static /* synthetic */ int access$3202(Value r0, int r1) {
                    r0.arrayDimensionCount_ = r1;
                    return r1;
                }

                static /* synthetic */ int access$3302(Value r0, int r1) {
                    r0.flags_ = r1;
                    return r1;
                }

                static /* synthetic */ int access$3402(Value r0, int r1) {
                    r0.bitField0_ = r1;
                    return r1;
                }

                static /* synthetic */ ByteString access$3500(Value r0) {
                    return r0.unknownFields;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                    return newBuilderForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                    return toBuilder();
                }

                private Value(GeneratedMessageLite.Builder r2) {
                    super(r2);
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = r2.getUnknownFields();
                }

                private Value(boolean r1) {
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = ByteString.EMPTY;
                }

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Value getDefaultInstanceForType() {
                    return defaultInstance;
                }

                private Value(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    initFields();
                    ByteString.Output r0 = ByteString.newOutput();
                    CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
                    boolean r3 = false;
                    int r4 = 0;
                L4:
                    if (r3 == true) goto L55;
                    int r6 = r10.readTag();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    switch(r6) {
                        case 0: goto L33;
                        case 8: goto L28;
                        case 16: goto L27;
                        case 29: goto L26;
                        case 33: goto L25;
                        case 40: goto L24;
                        case 48: goto L23;
                        case 56: goto L22;
                        case 66: goto L15;
                        case 74: goto L11;
                        case 80: goto L9;
                        case 88: goto L8;
                        default: goto L34;
                    };     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                L8:
                    this.bitField0_ |= 256;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.arrayDimensionCount_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L9:
                    this.bitField0_ |= 512;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.flags_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L11:
                    if ((r4 & 256) == 256) goto L13;
                    this.arrayElement_ = new ArrayList();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    r4 = r4 | 256;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                L13:
                    this.arrayElement_.add((Value) r10.readMessage(PARSER, r11));     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L15:
                    if ((this.bitField0_ & 128) != 128) goto L17;
                    Builder r7 = this.annotation_.toBuilder();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                L18:
                    Annotation r8 = (Annotation) r10.readMessage(Annotation.PARSER, r11);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.annotation_ = r8;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    if (r7 == null) goto L21;
                    r7.mergeFrom(r8);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.annotation_ = r7.buildPartial();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                L21:
                    this.bitField0_ |= 128;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L17:
                    r7 = null;
                    goto L18
                L22:
                    this.bitField0_ |= 64;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.enumValueId_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L23:
                    this.bitField0_ |= 32;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.classId_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L24:
                    this.bitField0_ |= 16;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.stringValue_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L25:
                    this.bitField0_ |= 8;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.doubleValue_ = r10.readDouble();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L26:
                    this.bitField0_ |= 4;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.floatValue_ = r10.readFloat();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L27:
                    this.bitField0_ |= 2;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.intValue_ = r10.readSInt64();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L28:
                    int r9 = r10.readEnum();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    Type r12 = Type.valueOf(r9);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    if (r12 == null) goto L30;
                    this.bitField0_ |= 1;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.type_ = r12;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L30:
                    r2.writeRawVarint32(r6);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    r2.writeRawVarint32(r9);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                L33:
                    r3 = true;
                    goto L4
                L34:
                    if (parseUnknownField(r10, r2, r11, r6) == true) goto L4;
                L36:
                    th = move-exception;
                    if ((r4 & 256) != 256) goto L68;
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                L68:
                    r2.flush();     // Catch: IOException -> L65 Throwable -> L49
                L49:
                    th = move-exception;
                    this.unknownFields = r0.toByteString();
                    throw th;
                L48:
                    this.unknownFields = r0.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                L41:
                    e = move-exception;
                    throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L36
                L38:
                    e = move-exception;
                    throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L36
                L55:
                    if ((r4 & 256) != 256) goto L70;
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                L70:
                    r2.flush();     // Catch: IOException -> L64 Throwable -> L59
                L59:
                    th = move-exception;
                    this.unknownFields = r0.toByteString();
                    throw th;
                L58:
                    this.unknownFields = r0.toByteString();
                    makeExtensionsImmutable();
                }

                static {
                    PARSER = new AnonymousClass1();
                    Value r0 = new Value(true);
                    defaultInstance = r0;
                    r0.initFields();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Parser<Value> getParserForType() {
                    return PARSER;
                }

                public boolean hasType() {
                    if ((this.bitField0_ & 1) == 1) goto L7;
                    return false;
                L7:
                    return true;
                }

                public Type getType() {
                    return this.type_;
                }

                public boolean hasIntValue() {
                    if ((this.bitField0_ & 2) != 2) goto L5;
                    return true;
                L5:
                    return false;
                }

                public long getIntValue() {
                    return this.intValue_;
                }

                public boolean hasFloatValue() {
                    if ((this.bitField0_ & 4) != 4) goto L5;
                    return true;
                L5:
                    return false;
                }

                public float getFloatValue() {
                    return this.floatValue_;
                }

                public boolean hasDoubleValue() {
                    if ((this.bitField0_ & 8) != 8) goto L5;
                    return true;
                L5:
                    return false;
                }

                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                public boolean hasStringValue() {
                    if ((this.bitField0_ & 16) != 16) goto L5;
                    return true;
                L5:
                    return false;
                }

                public int getStringValue() {
                    return this.stringValue_;
                }

                public boolean hasClassId() {
                    if ((this.bitField0_ & 32) != 32) goto L5;
                    return true;
                L5:
                    return false;
                }

                public int getClassId() {
                    return this.classId_;
                }

                public boolean hasEnumValueId() {
                    if ((this.bitField0_ & 64) != 64) goto L5;
                    return true;
                L5:
                    return false;
                }

                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                public boolean hasAnnotation() {
                    if ((this.bitField0_ & 128) != 128) goto L5;
                    return true;
                L5:
                    return false;
                }

                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                public List<Value> getArrayElementList() {
                    return this.arrayElement_;
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                public Value getArrayElement(int r1) {
                    return this.arrayElement_.get(r1);
                }

                public boolean hasArrayDimensionCount() {
                    if ((this.bitField0_ & 256) != 256) goto L5;
                    return true;
                L5:
                    return false;
                }

                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                public boolean hasFlags() {
                    if ((this.bitField0_ & 512) != 512) goto L5;
                    return true;
                L5:
                    return false;
                }

                public int getFlags() {
                    return this.flags_;
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = 0.0d;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    byte r0 = this.memoizedIsInitialized;
                    if (r0 != 1) goto L6;
                    return true;
                L6:
                    if (r0 != 0) goto L9;
                    return false;
                L9:
                    if (hasAnnotation() == true) goto L11;
                L14:
                    int r1 = 0;
                L16:
                    if (r1 >= getArrayElementCount()) goto L22;
                    if (getArrayElement(r1).isInitialized() == false) goto L19;
                    r1 = r1 + 1;
                    goto L16
                L19:
                    this.memoizedIsInitialized = 0;
                    return false;
                L22:
                    this.memoizedIsInitialized = 1;
                    return true;
                L11:
                    if (getAnnotation().isInitialized() == true) goto L14;
                    this.memoizedIsInitialized = 0;
                    return false;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public void writeTo(CodedOutputStream r6) throws IOException {
                    getSerializedSize();
                    if ((this.bitField0_ & 1) != 1) goto L6;
                    r6.writeEnum(1, this.type_.getNumber());
                L6:
                    if ((this.bitField0_ & 2) != 2) goto L9;
                    r6.writeSInt64(2, this.intValue_);
                L9:
                    if ((this.bitField0_ & 4) != 4) goto L12;
                    r6.writeFloat(3, this.floatValue_);
                L12:
                    if ((this.bitField0_ & 8) != 8) goto L15;
                    r6.writeDouble(4, this.doubleValue_);
                L15:
                    if ((this.bitField0_ & 16) != 16) goto L18;
                    r6.writeInt32(5, this.stringValue_);
                L18:
                    if ((this.bitField0_ & 32) != 32) goto L21;
                    r6.writeInt32(6, this.classId_);
                L21:
                    if ((this.bitField0_ & 64) != 64) goto L24;
                    r6.writeInt32(7, this.enumValueId_);
                L24:
                    if ((this.bitField0_ & 128) != 128) goto L26;
                    r6.writeMessage(8, this.annotation_);
                L26:
                    int r0 = 0;
                L28:
                    if (r0 >= this.arrayElement_.size()) goto L31;
                    r6.writeMessage(9, this.arrayElement_.get(r0));
                    r0 = r0 + 1;
                    goto L28
                L31:
                    if ((this.bitField0_ & 512) != 512) goto L34;
                    r6.writeInt32(10, this.flags_);
                L34:
                    if ((this.bitField0_ & 256) != 256) goto L36;
                    r6.writeInt32(11, this.arrayDimensionCount_);
                L36:
                    r6.writeRawBytes(this.unknownFields);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public int getSerializedSize() {
                    int r0 = this.memoizedSerializedSize;
                    if (r0 == (-1)) goto L5;
                    return r0;
                L5:
                    int r2 = 0;
                    if ((this.bitField0_ & 1) != 1) goto L8;
                    int r1 = CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0;
                L10:
                    if ((this.bitField0_ & 2) != 2) goto L13;
                    r1 = r1 + CodedOutputStream.computeSInt64Size(2, this.intValue_);
                L13:
                    if ((this.bitField0_ & 4) != 4) goto L16;
                    r1 = r1 + CodedOutputStream.computeFloatSize(3, this.floatValue_);
                L16:
                    if ((this.bitField0_ & 8) != 8) goto L19;
                    r1 = r1 + CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                L19:
                    if ((this.bitField0_ & 16) != 16) goto L22;
                    r1 = r1 + CodedOutputStream.computeInt32Size(5, this.stringValue_);
                L22:
                    if ((this.bitField0_ & 32) != 32) goto L25;
                    r1 = r1 + CodedOutputStream.computeInt32Size(6, this.classId_);
                L25:
                    if ((this.bitField0_ & 64) != 64) goto L28;
                    r1 = r1 + CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                L28:
                    if ((this.bitField0_ & 128) != 128) goto L31;
                    r1 = r1 + CodedOutputStream.computeMessageSize(8, this.annotation_);
                L31:
                    if (r2 >= this.arrayElement_.size()) goto L34;
                    r1 = r1 + CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(r2));
                    r2 = r2 + 1;
                    goto L31
                L34:
                    if ((this.bitField0_ & 512) != 512) goto L37;
                    r1 = r1 + CodedOutputStream.computeInt32Size(10, this.flags_);
                L37:
                    if ((this.bitField0_ & 256) != 256) goto L39;
                    r1 = r1 + CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                L39:
                    int r3 = r1 + this.unknownFields.size();
                    this.memoizedSerializedSize = r3;
                    return r3;
                L8:
                    r1 = 0;
                    goto L10
                }

                public static Builder newBuilder() {
                    return Builder.access$2100();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Builder newBuilderForType() {
                    return newBuilder();
                }

                public static Builder newBuilder(Value r1) {
                    return newBuilder().mergeFrom(r1);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Builder toBuilder() {
                    return newBuilder(this);
                }
            }

            public interface ValueOrBuilder extends MessageLiteOrBuilder {
            }

            /* synthetic */ Argument(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
                this(r1, r2);
            }

            /* synthetic */ Argument(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
                this(r1);
            }

            static /* synthetic */ int access$3802(Argument r0, int r1) {
                r0.nameId_ = r1;
                return r1;
            }

            static /* synthetic */ Value access$3902(Argument r0, Value r1) {
                r0.value_ = r1;
                return r1;
            }

            static /* synthetic */ int access$4002(Argument r0, int r1) {
                r0.bitField0_ = r1;
                return r1;
            }

            static /* synthetic */ ByteString access$4100(Argument r0) {
                return r0.unknownFields;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            private Argument(GeneratedMessageLite.Builder r2) {
                super(r2);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r2.getUnknownFields();
            }

            private Argument(boolean r1) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            private Argument(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r0 = ByteString.newOutput();
                CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
                boolean r3 = false;
            L3:
                if (r3 == true) goto L52;
                int r4 = r8.readTag();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                if (r4 == 0) goto L23;
                if (r4 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                this.nameId_ = r8.readInt32();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                goto L3
            L9:
                if (r4 != 18) goto L11;
                if ((this.bitField0_ & 2) != 2) goto L16;
                Value.Builder r5 = this.value_.toBuilder();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
            L17:
                Value r6 = (Value) r8.readMessage(Value.PARSER, r9);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                this.value_ = r6;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                if (r5 == null) goto L20;
                r5.mergeFrom(r6);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                this.value_ = r5.buildPartial();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
            L20:
                this.bitField0_ |= 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                goto L3
            L16:
                r5 = null;
                goto L17
            L11:
                if (parseUnknownField(r8, r2, r9, r4) == true) goto L3;
            L23:
                r3 = true;
                goto L3
            L24:
                th = move-exception;
                r2.flush();     // Catch: IOException -> L46 Throwable -> L34
            L34:
                th = move-exception;
                this.unknownFields = r0.toByteString();
                throw th;
            L33:
                this.unknownFields = r0.toByteString();
                makeExtensionsImmutable();
                throw th;
            L26:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L24
            L29:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L24
            L52:
                r2.flush();     // Catch: IOException -> L47 Throwable -> L41
            L41:
                th = move-exception;
                this.unknownFields = r0.toByteString();
                throw th;
            L40:
                this.unknownFields = r0.toByteString();
                makeExtensionsImmutable();
            }

            static {
                PARSER = new AnonymousClass1();
                Argument r0 = new Argument(true);
                defaultInstance = r0;
                r0.initFields();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public boolean hasNameId() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public int getNameId() {
                return this.nameId_;
            }

            public boolean hasValue() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public Value getValue() {
                return this.value_;
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r0 = this.memoizedIsInitialized;
                if (r0 != 1) goto L6;
                return true;
            L6:
                if (r0 != 0) goto L9;
                return false;
            L9:
                if (hasNameId() == true) goto L13;
                this.memoizedIsInitialized = 0;
                return false;
            L13:
                if (hasValue() == true) goto L17;
                this.memoizedIsInitialized = 0;
                return false;
            L17:
                if (getValue().isInitialized() == true) goto L20;
                this.memoizedIsInitialized = 0;
                return false;
            L20:
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r3) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r3.writeInt32(1, this.nameId_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L8;
                r3.writeMessage(2, this.value_);
            L8:
                r3.writeRawBytes(this.unknownFields);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int r0 = this.memoizedSerializedSize;
                if (r0 == (-1)) goto L5;
                return r0;
            L5:
                int r2 = 0;
                if ((this.bitField0_ & 1) != 1) goto L9;
                r2 = 0 + CodedOutputStream.computeInt32Size(1, this.nameId_);
            L9:
                if ((this.bitField0_ & 2) != 2) goto L11;
                r2 = r2 + CodedOutputStream.computeMessageSize(2, this.value_);
            L11:
                int r3 = r2 + this.unknownFields.size();
                this.memoizedSerializedSize = r3;
                return r3;
            }

            public static Builder newBuilder() {
                return Builder.access$3600();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(Argument r1) {
                return newBuilder().mergeFrom(r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }
        }

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
            private List<Argument> argument_;
            private int bitField0_;
            private int id_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$4200() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((Annotation) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.argument_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Annotation build() {
                Annotation r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public Annotation buildPartial() {
                Annotation r0 = new Annotation(this, null);
                int r2 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r2 = 0;
            L6:
                Annotation.access$4402(r0, this.id_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -3;
            L9:
                Annotation.access$4502(r0, this.argument_);
                Annotation.access$4602(r0, r2);
                return r0;
            }

            public Builder mergeFrom(Annotation r3) {
                if (r3 != Annotation.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasId() == false) goto L9;
                setId(r3.getId());
            L9:
                if (Annotation.access$4500(r3).isEmpty() == false) goto L11;
            L14:
                setUnknownFields(getUnknownFields().concat(Annotation.access$4700(r3)));
                return this;
            L11:
                if (this.argument_.isEmpty() == false) goto L13;
                this.argument_ = Annotation.access$4500(r3);
                this.bitField0_ &= -3;
                goto L14
            L13:
                ensureArgumentIsMutable();
                this.argument_.addAll(Annotation.access$4500(r3));
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasId() == true) goto L5;
                return false;
            L5:
                int r0 = 0;
            L7:
                if (r0 >= getArgumentCount()) goto L12;
                if (getArgument(r0).isInitialized() == false) goto L10;
                r0 = r0 + 1;
                goto L7
            L10:
                return false;
            L12:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                Annotation r0 = null;
                Annotation r5 = Annotation.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                Annotation r6 = (Annotation) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public boolean hasId() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public Builder setId(int r2) {
                this.bitField0_ |= 1;
                this.id_ = r2;
                return this;
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.argument_ = new ArrayList(this.argument_);
                this.bitField0_ |= 2;
                return;
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public Argument getArgument(int r1) {
                return this.argument_.get(r1);
            }
        }

        /* synthetic */ Annotation(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ Annotation(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$4402(Annotation r0, int r1) {
            r0.id_ = r1;
            return r1;
        }

        static /* synthetic */ List access$4500(Annotation r0) {
            return r0.argument_;
        }

        static /* synthetic */ List access$4502(Annotation r0, List r1) {
            r0.argument_ = r1;
            return r1;
        }

        static /* synthetic */ int access$4602(Annotation r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$4700(Annotation r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private Annotation(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private Annotation(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Annotation getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Annotation(CodedInputStream r9, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            int r4 = 0;
        L4:
            if (r3 == true) goto L40;
            int r6 = r9.readTag();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            if (r6 == 0) goto L20;
            if (r6 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            this.id_ = r9.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            goto L4
        L10:
            if (r6 != 18) goto L12;
            if ((r4 & 2) == 2) goto L17;
            this.argument_ = new ArrayList();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            r4 = r4 | 2;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
        L17:
            this.argument_.add((Argument) r9.readMessage(Argument.PARSER, r10));     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            goto L4
        L12:
            if (parseUnknownField(r9, r2, r10, r6) == true) goto L4;
        L20:
            r3 = true;
            goto L4
        L21:
            th = move-exception;
            if ((r4 & 2) != 2) goto L52;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L52:
            r2.flush();     // Catch: IOException -> L50 Throwable -> L34
        L34:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L33:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L26:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L21
        L23:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L21
        L40:
            if ((r4 & 2) != 2) goto L55;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L55:
            r2.flush();     // Catch: IOException -> L49 Throwable -> L44
        L44:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L43:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            Annotation r0 = new Annotation(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Annotation> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getId() {
            return this.id_;
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public Argument getArgument(int r1) {
            return this.argument_.get(r1);
        }

        private void initFields() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (hasId() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            int r1 = 0;
        L14:
            if (r1 >= getArgumentCount()) goto L20;
            if (getArgument(r1).isInitialized() == false) goto L17;
            r1 = r1 + 1;
            goto L14
        L17:
            this.memoizedIsInitialized = 0;
            return false;
        L20:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r4) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r4.writeInt32(1, this.id_);
        L5:
            int r0 = 0;
        L7:
            if (r0 >= this.argument_.size()) goto L9;
            r4.writeMessage(2, this.argument_.get(r0));
            r0 = r0 + 1;
            goto L7
        L9:
            r4.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
        L10:
            if (r2 >= this.argument_.size()) goto L12;
            r1 = r1 + CodedOutputStream.computeMessageSize(2, this.argument_.get(r2));
            r2 = r2 + 1;
            goto L10
        L12:
            int r3 = r1 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        L8:
            r1 = 0;
            goto L10
        }

        public static Builder newBuilder() {
            return Builder.access$4200();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Annotation r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Class extends GeneratedMessageLite.ExtendableMessage<Class> implements ClassOrBuilder {
        public static Parser<Class> PARSER;
        private static final Class defaultInstance = null;
        private int bitField0_;
        private int companionObjectName_;
        private List<Constructor> constructor_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private List<EnumEntry> enumEntry_;
        private int flags_;
        private int fqName_;
        private List<Function> function_;
        private int inlineClassUnderlyingPropertyName_;
        private int inlineClassUnderlyingTypeId_;
        private Type inlineClassUnderlyingType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingName_;
        private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingTypeId_;
        private List<Type> multiFieldValueClassUnderlyingType_;
        private int nestedClassNameMemoizedSerializedSize;
        private List<Integer> nestedClassName_;
        private List<Property> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        private List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        private List<Integer> supertypeId_;
        private List<Type> supertype_;
        private List<TypeAlias> typeAlias_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private VersionRequirementTable versionRequirementTable_;
        private List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Class, Builder> implements ClassOrBuilder {
            private int bitField0_;
            private int companionObjectName_;
            private List<Constructor> constructor_;
            private List<Integer> contextReceiverTypeId_;
            private List<Type> contextReceiverType_;
            private List<EnumEntry> enumEntry_;
            private int flags_;
            private int fqName_;
            private List<Function> function_;
            private int inlineClassUnderlyingPropertyName_;
            private int inlineClassUnderlyingTypeId_;
            private Type inlineClassUnderlyingType_;
            private List<Integer> multiFieldValueClassUnderlyingName_;
            private List<Integer> multiFieldValueClassUnderlyingTypeId_;
            private List<Type> multiFieldValueClassUnderlyingType_;
            private List<Integer> nestedClassName_;
            private List<Property> property_;
            private List<Integer> sealedSubclassFqName_;
            private List<Integer> supertypeId_;
            private List<Type> supertype_;
            private List<TypeAlias> typeAlias_;
            private List<TypeParameter> typeParameter_;
            private TypeTable typeTable_;
            private VersionRequirementTable versionRequirementTable_;
            private List<Integer> versionRequirement_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$8700() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((Class) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.flags_ = 6;
                this.typeParameter_ = Collections.emptyList();
                this.supertype_ = Collections.emptyList();
                this.supertypeId_ = Collections.emptyList();
                this.nestedClassName_ = Collections.emptyList();
                this.contextReceiverType_ = Collections.emptyList();
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.constructor_ = Collections.emptyList();
                this.function_ = Collections.emptyList();
                this.property_ = Collections.emptyList();
                this.typeAlias_ = Collections.emptyList();
                this.enumEntry_ = Collections.emptyList();
                this.sealedSubclassFqName_ = Collections.emptyList();
                this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
                this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
                this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
                this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.versionRequirement_ = Collections.emptyList();
                this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Class build() {
                Class r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public Class buildPartial() {
                Class r0 = new Class(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                Class.access$8902(r0, this.flags_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                Class.access$9002(r0, this.fqName_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                Class.access$9102(r0, this.companionObjectName_);
                if ((this.bitField0_ & 8) != 8) goto L15;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -9;
            L15:
                Class.access$9202(r0, this.typeParameter_);
                if ((this.bitField0_ & 16) != 16) goto L18;
                this.supertype_ = Collections.unmodifiableList(this.supertype_);
                this.bitField0_ &= -17;
            L18:
                Class.access$9302(r0, this.supertype_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                this.bitField0_ &= -33;
            L21:
                Class.access$9402(r0, this.supertypeId_);
                if ((this.bitField0_ & 64) != 64) goto L24;
                this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                this.bitField0_ &= -65;
            L24:
                Class.access$9502(r0, this.nestedClassName_);
                if ((this.bitField0_ & 128) != 128) goto L27;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -129;
            L27:
                Class.access$9602(r0, this.contextReceiverType_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -257;
            L30:
                Class.access$9702(r0, this.contextReceiverTypeId_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.constructor_ = Collections.unmodifiableList(this.constructor_);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            L33:
                Class.access$9802(r0, this.constructor_);
                if ((this.bitField0_ & 1024) != 1024) goto L36;
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -1025;
            L36:
                Class.access$9902(r0, this.function_);
                if ((this.bitField0_ & 2048) != 2048) goto L39;
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -2049;
            L39:
                Class.access$10002(r0, this.property_);
                if ((this.bitField0_ & 4096) != 4096) goto L42;
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -4097;
            L42:
                Class.access$10102(r0, this.typeAlias_);
                if ((this.bitField0_ & 8192) != 8192) goto L45;
                this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                this.bitField0_ &= -8193;
            L45:
                Class.access$10202(r0, this.enumEntry_);
                if ((this.bitField0_ & 16384) != 16384) goto L48;
                this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                this.bitField0_ &= -16385;
            L48:
                Class.access$10302(r0, this.sealedSubclassFqName_);
                if ((r1 & 32768) != 32768) goto L51;
                r3 = r3 | 8;
            L51:
                Class.access$10402(r0, this.inlineClassUnderlyingPropertyName_);
                if ((r1 & 65536) != 65536) goto L54;
                r3 = r3 | 16;
            L54:
                Class.access$10502(r0, this.inlineClassUnderlyingType_);
                if ((r1 & 131072) != 131072) goto L57;
                r3 = r3 | 32;
            L57:
                Class.access$10602(r0, this.inlineClassUnderlyingTypeId_);
                if ((this.bitField0_ & 262144) != 262144) goto L60;
                this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                this.bitField0_ &= -262145;
            L60:
                Class.access$10702(r0, this.multiFieldValueClassUnderlyingName_);
                if ((this.bitField0_ & 524288) != 524288) goto L63;
                this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                this.bitField0_ &= -524289;
            L63:
                Class.access$10802(r0, this.multiFieldValueClassUnderlyingType_);
                if ((this.bitField0_ & 1048576) != 1048576) goto L66;
                this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                this.bitField0_ &= -1048577;
            L66:
                Class.access$10902(r0, this.multiFieldValueClassUnderlyingTypeId_);
                if ((r1 & 2097152) != 2097152) goto L69;
                r3 = r3 | 64;
            L69:
                Class.access$11002(r0, this.typeTable_);
                if ((this.bitField0_ & 4194304) != 4194304) goto L72;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -4194305;
            L72:
                Class.access$11102(r0, this.versionRequirement_);
                if ((r1 & 8388608) != 8388608) goto L75;
                r3 = r3 | 128;
            L75:
                Class.access$11202(r0, this.versionRequirementTable_);
                Class.access$11302(r0, r3);
                return r0;
            }

            public Builder mergeFrom(Class r3) {
                if (r3 != Class.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasFlags() == false) goto L9;
                setFlags(r3.getFlags());
            L9:
                if (r3.hasFqName() == false) goto L12;
                setFqName(r3.getFqName());
            L12:
                if (r3.hasCompanionObjectName() == false) goto L15;
                setCompanionObjectName(r3.getCompanionObjectName());
            L15:
                if (Class.access$9200(r3).isEmpty() == true) goto L21;
                if (this.typeParameter_.isEmpty() == false) goto L19;
                this.typeParameter_ = Class.access$9200(r3);
                this.bitField0_ &= -9;
                goto L21
            L19:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Class.access$9200(r3));
            L21:
                if (Class.access$9300(r3).isEmpty() == true) goto L27;
                if (this.supertype_.isEmpty() == false) goto L25;
                this.supertype_ = Class.access$9300(r3);
                this.bitField0_ &= -17;
                goto L27
            L25:
                ensureSupertypeIsMutable();
                this.supertype_.addAll(Class.access$9300(r3));
            L27:
                if (Class.access$9400(r3).isEmpty() == true) goto L33;
                if (this.supertypeId_.isEmpty() == false) goto L31;
                this.supertypeId_ = Class.access$9400(r3);
                this.bitField0_ &= -33;
                goto L33
            L31:
                ensureSupertypeIdIsMutable();
                this.supertypeId_.addAll(Class.access$9400(r3));
            L33:
                if (Class.access$9500(r3).isEmpty() == true) goto L39;
                if (this.nestedClassName_.isEmpty() == false) goto L37;
                this.nestedClassName_ = Class.access$9500(r3);
                this.bitField0_ &= -65;
                goto L39
            L37:
                ensureNestedClassNameIsMutable();
                this.nestedClassName_.addAll(Class.access$9500(r3));
            L39:
                if (Class.access$9600(r3).isEmpty() == true) goto L45;
                if (this.contextReceiverType_.isEmpty() == false) goto L43;
                this.contextReceiverType_ = Class.access$9600(r3);
                this.bitField0_ &= -129;
                goto L45
            L43:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Class.access$9600(r3));
            L45:
                if (Class.access$9700(r3).isEmpty() == true) goto L51;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L49;
                this.contextReceiverTypeId_ = Class.access$9700(r3);
                this.bitField0_ &= -257;
                goto L51
            L49:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Class.access$9700(r3));
            L51:
                if (Class.access$9800(r3).isEmpty() == true) goto L57;
                if (this.constructor_.isEmpty() == false) goto L55;
                this.constructor_ = Class.access$9800(r3);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
                goto L57
            L55:
                ensureConstructorIsMutable();
                this.constructor_.addAll(Class.access$9800(r3));
            L57:
                if (Class.access$9900(r3).isEmpty() == true) goto L63;
                if (this.function_.isEmpty() == false) goto L61;
                this.function_ = Class.access$9900(r3);
                this.bitField0_ &= -1025;
                goto L63
            L61:
                ensureFunctionIsMutable();
                this.function_.addAll(Class.access$9900(r3));
            L63:
                if (Class.access$10000(r3).isEmpty() == true) goto L69;
                if (this.property_.isEmpty() == false) goto L67;
                this.property_ = Class.access$10000(r3);
                this.bitField0_ &= -2049;
                goto L69
            L67:
                ensurePropertyIsMutable();
                this.property_.addAll(Class.access$10000(r3));
            L69:
                if (Class.access$10100(r3).isEmpty() == true) goto L75;
                if (this.typeAlias_.isEmpty() == false) goto L73;
                this.typeAlias_ = Class.access$10100(r3);
                this.bitField0_ &= -4097;
                goto L75
            L73:
                ensureTypeAliasIsMutable();
                this.typeAlias_.addAll(Class.access$10100(r3));
            L75:
                if (Class.access$10200(r3).isEmpty() == true) goto L81;
                if (this.enumEntry_.isEmpty() == false) goto L79;
                this.enumEntry_ = Class.access$10200(r3);
                this.bitField0_ &= -8193;
                goto L81
            L79:
                ensureEnumEntryIsMutable();
                this.enumEntry_.addAll(Class.access$10200(r3));
            L81:
                if (Class.access$10300(r3).isEmpty() == true) goto L87;
                if (this.sealedSubclassFqName_.isEmpty() == false) goto L85;
                this.sealedSubclassFqName_ = Class.access$10300(r3);
                this.bitField0_ &= -16385;
                goto L87
            L85:
                ensureSealedSubclassFqNameIsMutable();
                this.sealedSubclassFqName_.addAll(Class.access$10300(r3));
            L87:
                if (r3.hasInlineClassUnderlyingPropertyName() == false) goto L90;
                setInlineClassUnderlyingPropertyName(r3.getInlineClassUnderlyingPropertyName());
            L90:
                if (r3.hasInlineClassUnderlyingType() == false) goto L93;
                mergeInlineClassUnderlyingType(r3.getInlineClassUnderlyingType());
            L93:
                if (r3.hasInlineClassUnderlyingTypeId() == false) goto L96;
                setInlineClassUnderlyingTypeId(r3.getInlineClassUnderlyingTypeId());
            L96:
                if (Class.access$10700(r3).isEmpty() == true) goto L102;
                if (this.multiFieldValueClassUnderlyingName_.isEmpty() == false) goto L100;
                this.multiFieldValueClassUnderlyingName_ = Class.access$10700(r3);
                this.bitField0_ &= -262145;
                goto L102
            L100:
                ensureMultiFieldValueClassUnderlyingNameIsMutable();
                this.multiFieldValueClassUnderlyingName_.addAll(Class.access$10700(r3));
            L102:
                if (Class.access$10800(r3).isEmpty() == true) goto L108;
                if (this.multiFieldValueClassUnderlyingType_.isEmpty() == false) goto L106;
                this.multiFieldValueClassUnderlyingType_ = Class.access$10800(r3);
                this.bitField0_ &= -524289;
                goto L108
            L106:
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                this.multiFieldValueClassUnderlyingType_.addAll(Class.access$10800(r3));
            L108:
                if (Class.access$10900(r3).isEmpty() == true) goto L114;
                if (this.multiFieldValueClassUnderlyingTypeId_.isEmpty() == false) goto L112;
                this.multiFieldValueClassUnderlyingTypeId_ = Class.access$10900(r3);
                this.bitField0_ &= -1048577;
                goto L114
            L112:
                ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                this.multiFieldValueClassUnderlyingTypeId_.addAll(Class.access$10900(r3));
            L114:
                if (r3.hasTypeTable() == false) goto L117;
                mergeTypeTable(r3.getTypeTable());
            L117:
                if (Class.access$11100(r3).isEmpty() == true) goto L123;
                if (this.versionRequirement_.isEmpty() == false) goto L121;
                this.versionRequirement_ = Class.access$11100(r3);
                this.bitField0_ &= -4194305;
                goto L123
            L121:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Class.access$11100(r3));
            L123:
                if (r3.hasVersionRequirementTable() == false) goto L125;
                mergeVersionRequirementTable(r3.getVersionRequirementTable());
            L125:
                mergeExtensionFields(r3);
                setUnknownFields(getUnknownFields().concat(Class.access$11400(r3)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasFqName() == true) goto L5;
                return false;
            L5:
                int r0 = 0;
            L7:
                if (r0 >= getTypeParameterCount()) goto L12;
                if (getTypeParameter(r0).isInitialized() == false) goto L10;
                r0 = r0 + 1;
                goto L7
            L10:
                return false;
            L12:
                int r1 = 0;
            L14:
                if (r1 >= getSupertypeCount()) goto L19;
                if (getSupertype(r1).isInitialized() == false) goto L17;
                r1 = r1 + 1;
                goto L14
            L17:
                return false;
            L19:
                int r2 = 0;
            L21:
                if (r2 >= getContextReceiverTypeCount()) goto L26;
                if (getContextReceiverType(r2).isInitialized() == false) goto L24;
                r2 = r2 + 1;
                goto L21
            L24:
                return false;
            L26:
                int r3 = 0;
            L28:
                if (r3 >= getConstructorCount()) goto L33;
                if (getConstructor(r3).isInitialized() == false) goto L31;
                r3 = r3 + 1;
                goto L28
            L31:
                return false;
            L33:
                int r4 = 0;
            L35:
                if (r4 >= getFunctionCount()) goto L40;
                if (getFunction(r4).isInitialized() == false) goto L38;
                r4 = r4 + 1;
                goto L35
            L38:
                return false;
            L40:
                int r5 = 0;
            L42:
                if (r5 >= getPropertyCount()) goto L47;
                if (getProperty(r5).isInitialized() == false) goto L45;
                r5 = r5 + 1;
                goto L42
            L45:
                return false;
            L47:
                int r6 = 0;
            L49:
                if (r6 >= getTypeAliasCount()) goto L54;
                if (getTypeAlias(r6).isInitialized() == false) goto L52;
                r6 = r6 + 1;
                goto L49
            L52:
                return false;
            L54:
                int r7 = 0;
            L56:
                if (r7 >= getEnumEntryCount()) goto L62;
                if (getEnumEntry(r7).isInitialized() == false) goto L59;
                r7 = r7 + 1;
                goto L56
            L59:
                return false;
            L62:
                if (hasInlineClassUnderlyingType() == true) goto L64;
            L66:
                int r8 = 0;
            L68:
                if (r8 >= getMultiFieldValueClassUnderlyingTypeCount()) goto L74;
                if (getMultiFieldValueClassUnderlyingType(r8).isInitialized() == false) goto L71;
                r8 = r8 + 1;
                goto L68
            L71:
                return false;
            L74:
                if (hasTypeTable() == false) goto L79;
                if (getTypeTable().isInitialized() == true) goto L79;
                return false;
            L79:
                if (extensionsAreInitialized() == true) goto L81;
                return false;
            L81:
                return true;
            L64:
                if (getInlineClassUnderlyingType().isInitialized() == true) goto L66;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                Class r0 = null;
                Class r5 = Class.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                Class r6 = (Class) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public Builder setFlags(int r2) {
                this.bitField0_ |= 1;
                this.flags_ = r2;
                return this;
            }

            public boolean hasFqName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public Builder setFqName(int r2) {
                this.bitField0_ |= 2;
                this.fqName_ = r2;
                return this;
            }

            public Builder setCompanionObjectName(int r2) {
                this.bitField0_ |= 4;
                this.companionObjectName_ = r2;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 8) == 8) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 8;
                return;
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int r1) {
                return this.typeParameter_.get(r1);
            }

            private void ensureSupertypeIsMutable() {
                if ((this.bitField0_ & 16) == 16) goto L6;
                this.supertype_ = new ArrayList(this.supertype_);
                this.bitField0_ |= 16;
                return;
            }

            public int getSupertypeCount() {
                return this.supertype_.size();
            }

            public Type getSupertype(int r1) {
                return this.supertype_.get(r1);
            }

            private void ensureSupertypeIdIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.supertypeId_ = new ArrayList(this.supertypeId_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureNestedClassNameIsMutable() {
                if ((this.bitField0_ & 64) == 64) goto L6;
                this.nestedClassName_ = new ArrayList(this.nestedClassName_);
                this.bitField0_ |= 64;
                return;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 128) == 128) goto L6;
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 128;
                return;
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Type getContextReceiverType(int r1) {
                return this.contextReceiverType_.get(r1);
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 256;
                return;
            }

            private void ensureConstructorIsMutable() {
                if ((this.bitField0_ & 512) == 512) goto L6;
                this.constructor_ = new ArrayList(this.constructor_);
                this.bitField0_ |= 512;
                return;
            }

            public int getConstructorCount() {
                return this.constructor_.size();
            }

            public Constructor getConstructor(int r1) {
                return this.constructor_.get(r1);
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1024) == 1024) goto L6;
                this.function_ = new ArrayList(this.function_);
                this.bitField0_ |= 1024;
                return;
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Function getFunction(int r1) {
                return this.function_.get(r1);
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2048) == 2048) goto L6;
                this.property_ = new ArrayList(this.property_);
                this.bitField0_ |= 2048;
                return;
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public Property getProperty(int r1) {
                return this.property_.get(r1);
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4096) == 4096) goto L6;
                this.typeAlias_ = new ArrayList(this.typeAlias_);
                this.bitField0_ |= 4096;
                return;
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeAlias getTypeAlias(int r1) {
                return this.typeAlias_.get(r1);
            }

            private void ensureEnumEntryIsMutable() {
                if ((this.bitField0_ & 8192) == 8192) goto L6;
                this.enumEntry_ = new ArrayList(this.enumEntry_);
                this.bitField0_ |= 8192;
                return;
            }

            public int getEnumEntryCount() {
                return this.enumEntry_.size();
            }

            public EnumEntry getEnumEntry(int r1) {
                return this.enumEntry_.get(r1);
            }

            private void ensureSealedSubclassFqNameIsMutable() {
                if ((this.bitField0_ & 16384) == 16384) goto L6;
                this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
                this.bitField0_ |= 16384;
                return;
            }

            public Builder setInlineClassUnderlyingPropertyName(int r3) {
                this.bitField0_ |= 32768;
                this.inlineClassUnderlyingPropertyName_ = r3;
                return this;
            }

            public boolean hasInlineClassUnderlyingType() {
                if ((this.bitField0_ & 65536) != 65536) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getInlineClassUnderlyingType() {
                return this.inlineClassUnderlyingType_;
            }

            public Builder mergeInlineClassUnderlyingType(Type r4) {
                if ((this.bitField0_ & 65536) == 65536) goto L5;
            L7:
                this.inlineClassUnderlyingType_ = r4;
            L8:
                this.bitField0_ |= 65536;
                return this;
            L5:
                if (this.inlineClassUnderlyingType_ == Type.getDefaultInstance()) goto L7;
                this.inlineClassUnderlyingType_ = Type.newBuilder(this.inlineClassUnderlyingType_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setInlineClassUnderlyingTypeId(int r3) {
                this.bitField0_ |= 131072;
                this.inlineClassUnderlyingTypeId_ = r3;
                return this;
            }

            private void ensureMultiFieldValueClassUnderlyingNameIsMutable() {
                if ((this.bitField0_ & 262144) == 262144) goto L6;
                this.multiFieldValueClassUnderlyingName_ = new ArrayList(this.multiFieldValueClassUnderlyingName_);
                this.bitField0_ |= 262144;
                return;
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIsMutable() {
                if ((this.bitField0_ & 524288) == 524288) goto L6;
                this.multiFieldValueClassUnderlyingType_ = new ArrayList(this.multiFieldValueClassUnderlyingType_);
                this.bitField0_ |= 524288;
                return;
            }

            public int getMultiFieldValueClassUnderlyingTypeCount() {
                return this.multiFieldValueClassUnderlyingType_.size();
            }

            public Type getMultiFieldValueClassUnderlyingType(int r1) {
                return this.multiFieldValueClassUnderlyingType_.get(r1);
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIdIsMutable() {
                if ((this.bitField0_ & 1048576) == 1048576) goto L6;
                this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList(this.multiFieldValueClassUnderlyingTypeId_);
                this.bitField0_ |= 1048576;
                return;
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 2097152) != 2097152) goto L5;
                return true;
            L5:
                return false;
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder mergeTypeTable(TypeTable r4) {
                if ((this.bitField0_ & 2097152) == 2097152) goto L5;
            L7:
                this.typeTable_ = r4;
            L8:
                this.bitField0_ |= 2097152;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(r4).buildPartial();
                goto L8
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4194304) == 4194304) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4194304;
                return;
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable r4) {
                if ((this.bitField0_ & 8388608) == 8388608) goto L5;
            L7:
                this.versionRequirementTable_ = r4;
            L8:
                this.bitField0_ |= 8388608;
                return this;
            L5:
                if (this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) goto L7;
                this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(r4).buildPartial();
                goto L8
            }
        }

        public static final enum Kind extends Enum<Kind> implements Internal.EnumLite {
            private static final /* synthetic */ Kind[] $VALUES = null;
            public static final Kind ANNOTATION_CLASS = null;
            public static final Kind CLASS = null;
            public static final Kind COMPANION_OBJECT = null;
            public static final Kind ENUM_CLASS = null;
            public static final Kind ENUM_ENTRY = null;
            public static final Kind INTERFACE = null;
            public static final Kind OBJECT = null;
            private static Internal.EnumLiteMap<Kind> internalValueMap;
            private final int value;

            public static Kind valueOf(String r1) {
                return (Kind) Enum.valueOf(Kind.class, r1);
            }

            public static Kind[] values() {
                return (Kind[]) $VALUES.clone();
            }

            static {
                Kind r0 = new Kind("CLASS", 0, 0, 0);
                CLASS = r0;
                Kind r1 = new Kind("INTERFACE", 1, 1, 1);
                INTERFACE = r1;
                Kind r3 = new Kind("ENUM_CLASS", 2, 2, 2);
                ENUM_CLASS = r3;
                Kind r5 = new Kind("ENUM_ENTRY", 3, 3, 3);
                ENUM_ENTRY = r5;
                Kind r7 = new Kind("ANNOTATION_CLASS", 4, 4, 4);
                ANNOTATION_CLASS = r7;
                Kind r9 = new Kind("OBJECT", 5, 5, 5);
                OBJECT = r9;
                Kind r11 = new Kind("COMPANION_OBJECT", 6, 6, 6);
                COMPANION_OBJECT = r11;
                $VALUES = new Kind[]{r0, r1, r3, r5, r7, r9, r11};
                internalValueMap = new AnonymousClass1();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int r0) {
                switch(r0) {
                    case 0: goto L18;
                    case 1: goto L16;
                    case 2: goto L14;
                    case 3: goto L12;
                    case 4: goto L10;
                    case 5: goto L8;
                    case 6: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return COMPANION_OBJECT;
            L8:
                return OBJECT;
            L10:
                return ANNOTATION_CLASS;
            L12:
                return ENUM_ENTRY;
            L14:
                return ENUM_CLASS;
            L16:
                return INTERFACE;
            L18:
                return CLASS;
            }

            private Kind(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.value = r4;
            }
        }

        /* synthetic */ Class(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ Class(GeneratedMessageLite.ExtendableBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ List access$10000(Class r0) {
            return r0.property_;
        }

        static /* synthetic */ List access$10002(Class r0, List r1) {
            r0.property_ = r1;
            return r1;
        }

        static /* synthetic */ List access$10100(Class r0) {
            return r0.typeAlias_;
        }

        static /* synthetic */ List access$10102(Class r0, List r1) {
            r0.typeAlias_ = r1;
            return r1;
        }

        static /* synthetic */ List access$10200(Class r0) {
            return r0.enumEntry_;
        }

        static /* synthetic */ List access$10202(Class r0, List r1) {
            r0.enumEntry_ = r1;
            return r1;
        }

        static /* synthetic */ List access$10300(Class r0) {
            return r0.sealedSubclassFqName_;
        }

        static /* synthetic */ List access$10302(Class r0, List r1) {
            r0.sealedSubclassFqName_ = r1;
            return r1;
        }

        static /* synthetic */ int access$10402(Class r0, int r1) {
            r0.inlineClassUnderlyingPropertyName_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$10502(Class r0, Type r1) {
            r0.inlineClassUnderlyingType_ = r1;
            return r1;
        }

        static /* synthetic */ int access$10602(Class r0, int r1) {
            r0.inlineClassUnderlyingTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ List access$10700(Class r0) {
            return r0.multiFieldValueClassUnderlyingName_;
        }

        static /* synthetic */ List access$10702(Class r0, List r1) {
            r0.multiFieldValueClassUnderlyingName_ = r1;
            return r1;
        }

        static /* synthetic */ List access$10800(Class r0) {
            return r0.multiFieldValueClassUnderlyingType_;
        }

        static /* synthetic */ List access$10802(Class r0, List r1) {
            r0.multiFieldValueClassUnderlyingType_ = r1;
            return r1;
        }

        static /* synthetic */ List access$10900(Class r0) {
            return r0.multiFieldValueClassUnderlyingTypeId_;
        }

        static /* synthetic */ List access$10902(Class r0, List r1) {
            r0.multiFieldValueClassUnderlyingTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ TypeTable access$11002(Class r0, TypeTable r1) {
            r0.typeTable_ = r1;
            return r1;
        }

        static /* synthetic */ List access$11100(Class r0) {
            return r0.versionRequirement_;
        }

        static /* synthetic */ List access$11102(Class r0, List r1) {
            r0.versionRequirement_ = r1;
            return r1;
        }

        static /* synthetic */ VersionRequirementTable access$11202(Class r0, VersionRequirementTable r1) {
            r0.versionRequirementTable_ = r1;
            return r1;
        }

        static /* synthetic */ int access$11302(Class r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$11400(Class r0) {
            return r0.unknownFields;
        }

        static /* synthetic */ int access$8902(Class r0, int r1) {
            r0.flags_ = r1;
            return r1;
        }

        static /* synthetic */ int access$9002(Class r0, int r1) {
            r0.fqName_ = r1;
            return r1;
        }

        static /* synthetic */ int access$9102(Class r0, int r1) {
            r0.companionObjectName_ = r1;
            return r1;
        }

        static /* synthetic */ List access$9200(Class r0) {
            return r0.typeParameter_;
        }

        static /* synthetic */ List access$9202(Class r0, List r1) {
            r0.typeParameter_ = r1;
            return r1;
        }

        static /* synthetic */ List access$9300(Class r0) {
            return r0.supertype_;
        }

        static /* synthetic */ List access$9302(Class r0, List r1) {
            r0.supertype_ = r1;
            return r1;
        }

        static /* synthetic */ List access$9400(Class r0) {
            return r0.supertypeId_;
        }

        static /* synthetic */ List access$9402(Class r0, List r1) {
            r0.supertypeId_ = r1;
            return r1;
        }

        static /* synthetic */ List access$9500(Class r0) {
            return r0.nestedClassName_;
        }

        static /* synthetic */ List access$9502(Class r0, List r1) {
            r0.nestedClassName_ = r1;
            return r1;
        }

        static /* synthetic */ List access$9600(Class r0) {
            return r0.contextReceiverType_;
        }

        static /* synthetic */ List access$9602(Class r0, List r1) {
            r0.contextReceiverType_ = r1;
            return r1;
        }

        static /* synthetic */ List access$9700(Class r0) {
            return r0.contextReceiverTypeId_;
        }

        static /* synthetic */ List access$9702(Class r0, List r1) {
            r0.contextReceiverTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ List access$9800(Class r0) {
            return r0.constructor_;
        }

        static /* synthetic */ List access$9802(Class r0, List r1) {
            r0.constructor_ = r1;
            return r1;
        }

        static /* synthetic */ List access$9900(Class r0) {
            return r0.function_;
        }

        static /* synthetic */ List access$9902(Class r0, List r1) {
            r0.function_ = r1;
            return r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private Class(GeneratedMessageLite.ExtendableBuilder<Class, ?> r2) {
            super(r2);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private Class(boolean r1) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Class getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Class(CodedInputStream r18, ExtensionRegistryLite r19) throws InvalidProtocolBufferException {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r4 = ByteString.newOutput();
            CodedOutputStream r6 = CodedOutputStream.newInstance(r4, 1);
            boolean r7 = false;
            int r8 = 0;
        L4:
            if (r7 == true) goto L233;
            int r15 = r18.readTag();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            Cloneable r16 = null;
            switch(r15) {
                case 0: goto L163;
                case 8: goto L161;
                case 16: goto L157;
                case 18: goto L147;
                case 24: goto L146;
                case 32: goto L145;
                case 42: goto L142;
                case 50: goto L138;
                case 56: goto L134;
                case 58: goto L124;
                case 66: goto L121;
                case 74: goto L117;
                case 82: goto L113;
                case 90: goto L109;
                case 106: goto L105;
                case 128: goto L101;
                case 130: goto L91;
                case 136: goto L90;
                case 146: goto L84;
                case 152: goto L82;
                case 162: goto L79;
                case 168: goto L75;
                case 170: goto L65;
                case 176: goto L62;
                case 178: goto L52;
                case 186: goto L49;
                case 192: goto L45;
                case 194: goto L35;
                case 242: goto L29;
                case 248: goto L25;
                case 250: goto L15;
                case 258: goto L9;
                default: goto L7;
            };     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L7:
            boolean r12 = true;
            if (parseUnknownField(r18, r6, r19, r15) == true) goto L4;
        L164:
            r7 = r12;
            goto L4
        L15:
            int r13 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r8 & 4194304) == 4194304) goto L21;
            if (r18.getBytesUntilLimit() <= 0) goto L21;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 4194304;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L21:
            if (r18.getBytesUntilLimit() <= 0) goto L23;
            this.versionRequirement_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L21
        L23:
            r18.popLimit(r13);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L160:
            r12 = true;
            goto L4
        L35:
            int r11 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r8 & 1048576) == 1048576) goto L41;
            if (r18.getBytesUntilLimit() <= 0) goto L41;
            this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 1048576;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L41:
            if (r18.getBytesUntilLimit() <= 0) goto L43;
            this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L41
        L43:
            r18.popLimit(r11);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L52:
            int r14 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r8 & 262144) == 262144) goto L58;
            if (r18.getBytesUntilLimit() <= 0) goto L58;
            this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 262144;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L58:
            if (r18.getBytesUntilLimit() <= 0) goto L60;
            this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L58
        L60:
            r18.popLimit(r14);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L65:
            int r17 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r8 & 256) == 256) goto L71;
            if (r18.getBytesUntilLimit() <= 0) goto L71;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 256;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L71:
            if (r18.getBytesUntilLimit() <= 0) goto L73;
            this.contextReceiverTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L71
        L73:
            r18.popLimit(r17);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L82:
            this.bitField0_ |= 32;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.inlineClassUnderlyingTypeId_ = r18.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L90:
            this.bitField0_ |= 8;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.inlineClassUnderlyingPropertyName_ = r18.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L91:
            int r110 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r8 & 16384) == 16384) goto L97;
            if (r18.getBytesUntilLimit() <= 0) goto L97;
            this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 16384;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L97:
            if (r18.getBytesUntilLimit() <= 0) goto L99;
            this.sealedSubclassFqName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L97
        L99:
            r18.popLimit(r110);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L124:
            int r111 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r8 & 64) == 64) goto L130;
            if (r18.getBytesUntilLimit() <= 0) goto L130;
            this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 64;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L130:
            if (r18.getBytesUntilLimit() <= 0) goto L132;
            this.nestedClassName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L130
        L132:
            r18.popLimit(r111);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L145:
            this.bitField0_ |= 4;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.companionObjectName_ = r18.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L146:
            this.bitField0_ |= 2;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.fqName_ = r18.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L147:
            int r112 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r8 & 32) == 32) goto L153;
            if (r18.getBytesUntilLimit() <= 0) goto L153;
            this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 32;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L153:
            if (r18.getBytesUntilLimit() <= 0) goto L155;
            this.supertypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L153
        L155:
            r18.popLimit(r112);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L161:
            r12 = true;
            this.bitField0_ |= 1;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.flags_ = r18.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L163:
            r12 = true;
            goto L164
        L9:
            if ((this.bitField0_ & 128) != 128) goto L11;
            r16 = this.versionRequirementTable_.toBuilder();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L11:
            VersionRequirementTable.Builder r113 = r16;
            VersionRequirementTable r114 = (VersionRequirementTable) r18.readMessage(VersionRequirementTable.PARSER, r19);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.versionRequirementTable_ = r114;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if (r113 == 0) goto L14;
            r113.mergeFrom(r114);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.versionRequirementTable_ = r113.buildPartial();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L14:
            this.bitField0_ |= 128;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L25:
            if ((r8 & 4194304) == 4194304) goto L27;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 4194304;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L27:
            this.versionRequirement_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L29:
            if ((this.bitField0_ & 64) != 64) goto L31;
            r16 = this.typeTable_.toBuilder();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L31:
            TypeTable.Builder r115 = r16;
            TypeTable r116 = (TypeTable) r18.readMessage(TypeTable.PARSER, r19);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.typeTable_ = r116;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if (r115 == 0) goto L34;
            r115.mergeFrom(r116);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.typeTable_ = r115.buildPartial();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L34:
            this.bitField0_ |= 64;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L45:
            if ((r8 & 1048576) == 1048576) goto L47;
            this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 1048576;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L47:
            this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L49:
            if ((r8 & 524288) == 524288) goto L51;
            this.multiFieldValueClassUnderlyingType_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 524288;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L51:
            this.multiFieldValueClassUnderlyingType_.add((Type) r18.readMessage(Type.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L62:
            if ((r8 & 262144) == 262144) goto L64;
            this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 262144;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L64:
            this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L75:
            if ((r8 & 256) == 256) goto L77;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 256;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L77:
            this.contextReceiverTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L79:
            if ((r8 & 128) == 128) goto L81;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 128;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L81:
            this.contextReceiverType_.add((Type) r18.readMessage(Type.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L84:
            if ((this.bitField0_ & 16) != 16) goto L86;
            r16 = this.inlineClassUnderlyingType_.toBuilder();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L86:
            Type.Builder r117 = r16;
            Type r118 = (Type) r18.readMessage(Type.PARSER, r19);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.inlineClassUnderlyingType_ = r118;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if (r117 == 0) goto L89;
            r117.mergeFrom(r118);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.inlineClassUnderlyingType_ = r117.buildPartial();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L89:
            this.bitField0_ |= 16;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L101:
            if ((r8 & 16384) == 16384) goto L103;
            this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 16384;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L103:
            this.sealedSubclassFqName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L105:
            if ((r8 & 8192) == 8192) goto L107;
            this.enumEntry_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 8192;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L107:
            this.enumEntry_.add((EnumEntry) r18.readMessage(EnumEntry.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L109:
            if ((r8 & 4096) == 4096) goto L111;
            this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 4096;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L111:
            this.typeAlias_.add((TypeAlias) r18.readMessage(TypeAlias.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L113:
            if ((r8 & 2048) == 2048) goto L115;
            this.property_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 2048;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L115:
            this.property_.add((Property) r18.readMessage(Property.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L117:
            if ((r8 & 1024) == 1024) goto L119;
            this.function_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 1024;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L119:
            this.function_.add((Function) r18.readMessage(Function.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L121:
            if ((r8 & 512) == 512) goto L123;
            this.constructor_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 512;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L123:
            this.constructor_.add((Constructor) r18.readMessage(Constructor.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L134:
            if ((r8 & 64) == 64) goto L136;
            this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 64;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L136:
            this.nestedClassName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L138:
            if ((r8 & 16) == 16) goto L140;
            this.supertype_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 16;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L140:
            this.supertype_.add((Type) r18.readMessage(Type.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L142:
            if ((r8 & 8) == 8) goto L144;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 8;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L144:
            this.typeParameter_.add((TypeParameter) r18.readMessage(TypeParameter.PARSER, r19));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L157:
            if ((r8 & 32) == 32) goto L159;
            this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r8 = r8 | 32;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L159:
            this.supertypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L160
        L168:
            th = move-exception;
            if ((r8 & 32) != 32) goto L181;
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        L181:
            if ((r8 & 8) != 8) goto L184;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L184:
            if ((r8 & 16) != 16) goto L187;
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        L187:
            if ((r8 & 64) != 64) goto L190;
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        L190:
            if ((r8 & 512) != 512) goto L193;
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        L193:
            if ((r8 & 1024) != 1024) goto L196;
            this.function_ = Collections.unmodifiableList(this.function_);
        L196:
            if ((r8 & 2048) != 2048) goto L199;
            this.property_ = Collections.unmodifiableList(this.property_);
        L199:
            if ((r8 & 4096) != 4096) goto L202;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L202:
            if ((r8 & 8192) != 8192) goto L205;
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        L205:
            if ((r8 & 16384) != 16384) goto L208;
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        L208:
            if ((r8 & 128) != 128) goto L211;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L211:
            if ((r8 & 256) != 256) goto L214;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L214:
            if ((r8 & 262144) != 262144) goto L217;
            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
        L217:
            if ((r8 & 524288) != 524288) goto L220;
            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
        L220:
            if ((r8 & 1048576) != 1048576) goto L223;
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
        L223:
            if ((r8 & 4194304) != 4194304) goto L291;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L291:
            r6.flush();     // Catch: IOException -> L288 Throwable -> L227
        L227:
            th = move-exception;
            this.unknownFields = r4.toByteString();
            throw th;
        L226:
            this.unknownFields = r4.toByteString();
            makeExtensionsImmutable();
            throw th;
        L174:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L168
        L170:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L168
        L233:
            if ((r8 & 32) != 32) goto L236;
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        L236:
            if ((r8 & 8) != 8) goto L239;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L239:
            if ((r8 & 16) != 16) goto L242;
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        L242:
            if ((r8 & 64) != 64) goto L245;
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        L245:
            if ((r8 & 512) != 512) goto L248;
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        L248:
            if ((r8 & 1024) != 1024) goto L251;
            this.function_ = Collections.unmodifiableList(this.function_);
        L251:
            if ((r8 & 2048) != 2048) goto L254;
            this.property_ = Collections.unmodifiableList(this.property_);
        L254:
            if ((r8 & 4096) != 4096) goto L257;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L257:
            if ((r8 & 8192) != 8192) goto L260;
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        L260:
            if ((r8 & 16384) != 16384) goto L263;
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        L263:
            if ((r8 & 128) != 128) goto L266;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L266:
            if ((r8 & 256) != 256) goto L269;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L269:
            if ((r8 & 262144) != 262144) goto L272;
            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
        L272:
            if ((r8 & 524288) != 524288) goto L275;
            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
        L275:
            if ((r8 & 1048576) != 1048576) goto L278;
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
        L278:
            if ((r8 & 4194304) != 4194304) goto L293;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L293:
            r6.flush();     // Catch: IOException -> L287 Throwable -> L282
        L282:
            th = move-exception;
            this.unknownFields = r4.toByteString();
            throw th;
        L281:
            this.unknownFields = r4.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            Class r0 = new Class(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Class> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasFqName() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getFqName() {
            return this.fqName_;
        }

        public boolean hasCompanionObjectName() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int r1) {
            return this.typeParameter_.get(r1);
        }

        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public Type getSupertype(int r1) {
            return this.supertype_.get(r1);
        }

        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public Type getContextReceiverType(int r1) {
            return this.contextReceiverType_.get(r1);
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public Constructor getConstructor(int r1) {
            return this.constructor_.get(r1);
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public Function getFunction(int r1) {
            return this.function_.get(r1);
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public Property getProperty(int r1) {
            return this.property_.get(r1);
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public TypeAlias getTypeAlias(int r1) {
            return this.typeAlias_.get(r1);
        }

        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public EnumEntry getEnumEntry(int r1) {
            return this.enumEntry_.get(r1);
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        public boolean hasInlineClassUnderlyingPropertyName() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        public boolean hasInlineClassUnderlyingType() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        public boolean hasInlineClassUnderlyingTypeId() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
            return this.multiFieldValueClassUnderlyingName_;
        }

        public int getMultiFieldValueClassUnderlyingNameCount() {
            return this.multiFieldValueClassUnderlyingName_.size();
        }

        public List<Type> getMultiFieldValueClassUnderlyingTypeList() {
            return this.multiFieldValueClassUnderlyingType_;
        }

        public int getMultiFieldValueClassUnderlyingTypeCount() {
            return this.multiFieldValueClassUnderlyingType_.size();
        }

        public Type getMultiFieldValueClassUnderlyingType(int r1) {
            return this.multiFieldValueClassUnderlyingType_.get(r1);
        }

        public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
            return this.multiFieldValueClassUnderlyingTypeId_;
        }

        public int getMultiFieldValueClassUnderlyingTypeIdCount() {
            return this.multiFieldValueClassUnderlyingTypeId_.size();
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasVersionRequirementTable() {
            if ((this.bitField0_ & 128) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (hasFqName() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            int r1 = 0;
        L14:
            if (r1 >= getTypeParameterCount()) goto L20;
            if (getTypeParameter(r1).isInitialized() == false) goto L17;
            r1 = r1 + 1;
            goto L14
        L17:
            this.memoizedIsInitialized = 0;
            return false;
        L20:
            int r2 = 0;
        L22:
            if (r2 >= getSupertypeCount()) goto L28;
            if (getSupertype(r2).isInitialized() == false) goto L25;
            r2 = r2 + 1;
            goto L22
        L25:
            this.memoizedIsInitialized = 0;
            return false;
        L28:
            int r3 = 0;
        L30:
            if (r3 >= getContextReceiverTypeCount()) goto L36;
            if (getContextReceiverType(r3).isInitialized() == false) goto L33;
            r3 = r3 + 1;
            goto L30
        L33:
            this.memoizedIsInitialized = 0;
            return false;
        L36:
            int r4 = 0;
        L38:
            if (r4 >= getConstructorCount()) goto L44;
            if (getConstructor(r4).isInitialized() == false) goto L41;
            r4 = r4 + 1;
            goto L38
        L41:
            this.memoizedIsInitialized = 0;
            return false;
        L44:
            int r5 = 0;
        L46:
            if (r5 >= getFunctionCount()) goto L52;
            if (getFunction(r5).isInitialized() == false) goto L49;
            r5 = r5 + 1;
            goto L46
        L49:
            this.memoizedIsInitialized = 0;
            return false;
        L52:
            int r6 = 0;
        L54:
            if (r6 >= getPropertyCount()) goto L60;
            if (getProperty(r6).isInitialized() == false) goto L57;
            r6 = r6 + 1;
            goto L54
        L57:
            this.memoizedIsInitialized = 0;
            return false;
        L60:
            int r7 = 0;
        L62:
            if (r7 >= getTypeAliasCount()) goto L68;
            if (getTypeAlias(r7).isInitialized() == false) goto L65;
            r7 = r7 + 1;
            goto L62
        L65:
            this.memoizedIsInitialized = 0;
            return false;
        L68:
            int r8 = 0;
        L70:
            if (r8 >= getEnumEntryCount()) goto L77;
            if (getEnumEntry(r8).isInitialized() == false) goto L73;
            r8 = r8 + 1;
            goto L70
        L73:
            this.memoizedIsInitialized = 0;
            return false;
        L77:
            if (hasInlineClassUnderlyingType() == true) goto L79;
        L82:
            int r9 = 0;
        L84:
            if (r9 >= getMultiFieldValueClassUnderlyingTypeCount()) goto L91;
            if (getMultiFieldValueClassUnderlyingType(r9).isInitialized() == false) goto L87;
            r9 = r9 + 1;
            goto L84
        L87:
            this.memoizedIsInitialized = 0;
            return false;
        L91:
            if (hasTypeTable() == false) goto L97;
            if (getTypeTable().isInitialized() == true) goto L97;
            this.memoizedIsInitialized = 0;
            return false;
        L97:
            if (extensionsAreInitialized() == true) goto L100;
            this.memoizedIsInitialized = 0;
            return false;
        L100:
            this.memoizedIsInitialized = 1;
            return true;
        L79:
            if (getInlineClassUnderlyingType().isInitialized() == true) goto L82;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r8.writeInt32(1, this.flags_);
        L6:
            if (getSupertypeIdList().size() <= 0) goto L8;
            r8.writeRawVarint32(18);
            r8.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
        L8:
            int r1 = 0;
            int r3 = 0;
        L10:
            if (r3 >= this.supertypeId_.size()) goto L13;
            r8.writeInt32NoTag(this.supertypeId_.get(r3).intValue());
            r3 = r3 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 2) != 2) goto L16;
            r8.writeInt32(3, this.fqName_);
        L16:
            if ((this.bitField0_ & 4) != 4) goto L18;
            r8.writeInt32(4, this.companionObjectName_);
        L18:
            int r4 = 0;
        L20:
            if (r4 >= this.typeParameter_.size()) goto L22;
            r8.writeMessage(5, this.typeParameter_.get(r4));
            r4 = r4 + 1;
            goto L20
        L22:
            int r5 = 0;
        L24:
            if (r5 >= this.supertype_.size()) goto L27;
            r8.writeMessage(6, this.supertype_.get(r5));
            r5 = r5 + 1;
            goto L24
        L27:
            if (getNestedClassNameList().size() <= 0) goto L29;
            r8.writeRawVarint32(58);
            r8.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
        L29:
            int r6 = 0;
        L31:
            if (r6 >= this.nestedClassName_.size()) goto L33;
            r8.writeInt32NoTag(this.nestedClassName_.get(r6).intValue());
            r6 = r6 + 1;
            goto L31
        L33:
            int r7 = 0;
        L35:
            if (r7 >= this.constructor_.size()) goto L37;
            r8.writeMessage(8, this.constructor_.get(r7));
            r7 = r7 + 1;
            goto L35
        L37:
            int r9 = 0;
        L39:
            if (r9 >= this.function_.size()) goto L41;
            r8.writeMessage(9, this.function_.get(r9));
            r9 = r9 + 1;
            goto L39
        L41:
            int r10 = 0;
        L43:
            if (r10 >= this.property_.size()) goto L45;
            r8.writeMessage(10, this.property_.get(r10));
            r10 = r10 + 1;
            goto L43
        L45:
            int r11 = 0;
        L47:
            if (r11 >= this.typeAlias_.size()) goto L49;
            r8.writeMessage(11, this.typeAlias_.get(r11));
            r11 = r11 + 1;
            goto L47
        L49:
            int r12 = 0;
        L51:
            if (r12 >= this.enumEntry_.size()) goto L54;
            r8.writeMessage(13, this.enumEntry_.get(r12));
            r12 = r12 + 1;
            goto L51
        L54:
            if (getSealedSubclassFqNameList().size() <= 0) goto L56;
            r8.writeRawVarint32(130);
            r8.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
        L56:
            int r13 = 0;
        L58:
            if (r13 >= this.sealedSubclassFqName_.size()) goto L61;
            r8.writeInt32NoTag(this.sealedSubclassFqName_.get(r13).intValue());
            r13 = r13 + 1;
            goto L58
        L61:
            if ((this.bitField0_ & 8) != 8) goto L64;
            r8.writeInt32(17, this.inlineClassUnderlyingPropertyName_);
        L64:
            if ((this.bitField0_ & 16) != 16) goto L67;
            r8.writeMessage(18, this.inlineClassUnderlyingType_);
        L67:
            if ((this.bitField0_ & 32) != 32) goto L69;
            r8.writeInt32(19, this.inlineClassUnderlyingTypeId_);
        L69:
            int r2 = 0;
        L71:
            if (r2 >= this.contextReceiverType_.size()) goto L74;
            r8.writeMessage(20, this.contextReceiverType_.get(r2));
            r2 = r2 + 1;
            goto L71
        L74:
            if (getContextReceiverTypeIdList().size() <= 0) goto L76;
            r8.writeRawVarint32(170);
            r8.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L76:
            int r14 = 0;
        L78:
            if (r14 >= this.contextReceiverTypeId_.size()) goto L81;
            r8.writeInt32NoTag(this.contextReceiverTypeId_.get(r14).intValue());
            r14 = r14 + 1;
            goto L78
        L81:
            if (getMultiFieldValueClassUnderlyingNameList().size() <= 0) goto L83;
            r8.writeRawVarint32(178);
            r8.writeRawVarint32(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
        L83:
            int r15 = 0;
        L85:
            if (r15 >= this.multiFieldValueClassUnderlyingName_.size()) goto L87;
            r8.writeInt32NoTag(this.multiFieldValueClassUnderlyingName_.get(r15).intValue());
            r15 = r15 + 1;
            goto L85
        L87:
            int r16 = 0;
        L89:
            if (r16 >= this.multiFieldValueClassUnderlyingType_.size()) goto L92;
            r8.writeMessage(23, this.multiFieldValueClassUnderlyingType_.get(r16));
            r16 = r16 + 1;
            goto L89
        L92:
            if (getMultiFieldValueClassUnderlyingTypeIdList().size() <= 0) goto L94;
            r8.writeRawVarint32(194);
            r8.writeRawVarint32(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
        L94:
            int r17 = 0;
        L96:
            if (r17 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
            r8.writeInt32NoTag(this.multiFieldValueClassUnderlyingTypeId_.get(r17).intValue());
            r17 = r17 + 1;
            goto L96
        L99:
            if ((this.bitField0_ & 64) != 64) goto L102;
            r8.writeMessage(30, this.typeTable_);
        L102:
            if (r1 >= this.versionRequirement_.size()) goto L105;
            r8.writeInt32(31, this.versionRequirement_.get(r1).intValue());
            r1 = r1 + 1;
            goto L102
        L105:
            if ((this.bitField0_ & 128) != 128) goto L107;
            r8.writeMessage(32, this.versionRequirementTable_);
        L107:
            r0.writeUntil(19000, r8);
            r8.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L9:
            int r3 = 0;
            int r4 = 0;
        L11:
            if (r3 >= this.supertypeId_.size()) goto L13;
            r4 = r4 + CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(r3).intValue());
            r3 = r3 + 1;
            goto L11
        L13:
            int r5 = r1 + r4;
            if (getSupertypeIdList().isEmpty() == true) goto L16;
            r5 = (r5 + 1) + CodedOutputStream.computeInt32SizeNoTag(r4);
        L16:
            this.supertypeIdMemoizedSerializedSize = r4;
            if ((this.bitField0_ & 2) != 2) goto L20;
            r5 = r5 + CodedOutputStream.computeInt32Size(3, this.fqName_);
        L20:
            if ((this.bitField0_ & 4) != 4) goto L22;
            r5 = r5 + CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
        L22:
            int r6 = 0;
        L24:
            if (r6 >= this.typeParameter_.size()) goto L26;
            r5 = r5 + CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(r6));
            r6 = r6 + 1;
            goto L24
        L26:
            int r7 = 0;
        L28:
            if (r7 >= this.supertype_.size()) goto L30;
            r5 = r5 + CodedOutputStream.computeMessageSize(6, this.supertype_.get(r7));
            r7 = r7 + 1;
            goto L28
        L30:
            int r8 = 0;
            int r9 = 0;
        L32:
            if (r8 >= this.nestedClassName_.size()) goto L34;
            r9 = r9 + CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(r8).intValue());
            r8 = r8 + 1;
            goto L32
        L34:
            int r10 = r5 + r9;
            if (getNestedClassNameList().isEmpty() == true) goto L37;
            r10 = (r10 + 1) + CodedOutputStream.computeInt32SizeNoTag(r9);
        L37:
            this.nestedClassNameMemoizedSerializedSize = r9;
            int r11 = 0;
        L39:
            if (r11 >= this.constructor_.size()) goto L41;
            r10 = r10 + CodedOutputStream.computeMessageSize(8, this.constructor_.get(r11));
            r11 = r11 + 1;
            goto L39
        L41:
            int r12 = 0;
        L43:
            if (r12 >= this.function_.size()) goto L45;
            r10 = r10 + CodedOutputStream.computeMessageSize(9, this.function_.get(r12));
            r12 = r12 + 1;
            goto L43
        L45:
            int r13 = 0;
        L47:
            if (r13 >= this.property_.size()) goto L49;
            r10 = r10 + CodedOutputStream.computeMessageSize(10, this.property_.get(r13));
            r13 = r13 + 1;
            goto L47
        L49:
            int r14 = 0;
        L51:
            if (r14 >= this.typeAlias_.size()) goto L53;
            r10 = r10 + CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(r14));
            r14 = r14 + 1;
            goto L51
        L53:
            int r15 = 0;
        L55:
            if (r15 >= this.enumEntry_.size()) goto L57;
            r10 = r10 + CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(r15));
            r15 = r15 + 1;
            goto L55
        L57:
            int r16 = 0;
            int r17 = 0;
        L59:
            if (r16 >= this.sealedSubclassFqName_.size()) goto L61;
            r17 = r17 + CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(r16).intValue());
            r16 = r16 + 1;
            goto L59
        L61:
            int r18 = r10 + r17;
            if (getSealedSubclassFqNameList().isEmpty() == true) goto L64;
            r18 = (r18 + 2) + CodedOutputStream.computeInt32SizeNoTag(r17);
        L64:
            this.sealedSubclassFqNameMemoizedSerializedSize = r17;
            if ((this.bitField0_ & 8) != 8) goto L68;
            r18 = r18 + CodedOutputStream.computeInt32Size(17, this.inlineClassUnderlyingPropertyName_);
        L68:
            if ((this.bitField0_ & 16) != 16) goto L71;
            r18 = r18 + CodedOutputStream.computeMessageSize(18, this.inlineClassUnderlyingType_);
        L71:
            if ((this.bitField0_ & 32) != 32) goto L73;
            r18 = r18 + CodedOutputStream.computeInt32Size(19, this.inlineClassUnderlyingTypeId_);
        L73:
            int r19 = 0;
        L75:
            if (r19 >= this.contextReceiverType_.size()) goto L77;
            r18 = r18 + CodedOutputStream.computeMessageSize(20, this.contextReceiverType_.get(r19));
            r19 = r19 + 1;
            goto L75
        L77:
            int r20 = 0;
            int r21 = 0;
        L79:
            if (r20 >= this.contextReceiverTypeId_.size()) goto L81;
            r21 = r21 + CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(r20).intValue());
            r20 = r20 + 1;
            goto L79
        L81:
            int r22 = r18 + r21;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L84;
            r22 = (r22 + 2) + CodedOutputStream.computeInt32SizeNoTag(r21);
        L84:
            this.contextReceiverTypeIdMemoizedSerializedSize = r21;
            int r23 = 0;
            int r24 = 0;
        L86:
            if (r23 >= this.multiFieldValueClassUnderlyingName_.size()) goto L88;
            r24 = r24 + CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingName_.get(r23).intValue());
            r23 = r23 + 1;
            goto L86
        L88:
            int r25 = r22 + r24;
            if (getMultiFieldValueClassUnderlyingNameList().isEmpty() == true) goto L91;
            r25 = (r25 + 2) + CodedOutputStream.computeInt32SizeNoTag(r24);
        L91:
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = r24;
            int r26 = 0;
        L93:
            if (r26 >= this.multiFieldValueClassUnderlyingType_.size()) goto L95;
            r25 = r25 + CodedOutputStream.computeMessageSize(23, this.multiFieldValueClassUnderlyingType_.get(r26));
            r26 = r26 + 1;
            goto L93
        L95:
            int r27 = 0;
            int r28 = 0;
        L97:
            if (r27 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
            r28 = r28 + CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingTypeId_.get(r27).intValue());
            r27 = r27 + 1;
            goto L97
        L99:
            int r29 = r25 + r28;
            if (getMultiFieldValueClassUnderlyingTypeIdList().isEmpty() == true) goto L102;
            r29 = (r29 + 2) + CodedOutputStream.computeInt32SizeNoTag(r28);
        L102:
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = r28;
            if ((this.bitField0_ & 64) != 64) goto L105;
            r29 = r29 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L105:
            int r30 = 0;
        L107:
            if (r2 >= this.versionRequirement_.size()) goto L109;
            r30 = r30 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r2).intValue());
            r2 = r2 + 1;
            goto L107
        L109:
            int r31 = (r29 + r30) + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 128) != 128) goto L112;
            r31 = r31 + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        L112:
            int r32 = (r31 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r32;
            return r32;
        L8:
            r1 = 0;
            goto L9
        }

        public static Class parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return PARSER.parseFrom(r1, r2);
        }

        public static Builder newBuilder() {
            return Builder.access$8700();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Class r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface ClassOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Constructor extends GeneratedMessageLite.ExtendableMessage<Constructor> implements ConstructorOrBuilder {
        public static Parser<Constructor> PARSER;
        private static final Constructor defaultInstance = null;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Constructor, Builder> implements ConstructorOrBuilder {
            private int bitField0_;
            private int flags_;
            private List<ValueParameter> valueParameter_;
            private List<Integer> versionRequirement_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$13300() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((Constructor) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.flags_ = 6;
                this.valueParameter_ = Collections.emptyList();
                this.versionRequirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Constructor build() {
                Constructor r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public Constructor buildPartial() {
                Constructor r0 = new Constructor(this, null);
                int r2 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r2 = 0;
            L6:
                Constructor.access$13502(r0, this.flags_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -3;
            L9:
                Constructor.access$13602(r0, this.valueParameter_);
                if ((this.bitField0_ & 4) != 4) goto L12;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -5;
            L12:
                Constructor.access$13702(r0, this.versionRequirement_);
                Constructor.access$13802(r0, r2);
                return r0;
            }

            public Builder mergeFrom(Constructor r3) {
                if (r3 != Constructor.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasFlags() == false) goto L9;
                setFlags(r3.getFlags());
            L9:
                if (Constructor.access$13600(r3).isEmpty() == true) goto L15;
                if (this.valueParameter_.isEmpty() == false) goto L13;
                this.valueParameter_ = Constructor.access$13600(r3);
                this.bitField0_ &= -3;
                goto L15
            L13:
                ensureValueParameterIsMutable();
                this.valueParameter_.addAll(Constructor.access$13600(r3));
            L15:
                if (Constructor.access$13700(r3).isEmpty() == false) goto L17;
            L20:
                mergeExtensionFields(r3);
                setUnknownFields(getUnknownFields().concat(Constructor.access$13900(r3)));
                return this;
            L17:
                if (this.versionRequirement_.isEmpty() == false) goto L19;
                this.versionRequirement_ = Constructor.access$13700(r3);
                this.bitField0_ &= -5;
                goto L20
            L19:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Constructor.access$13700(r3));
                goto L20
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r1 = 0;
            L4:
                if (r1 >= getValueParameterCount()) goto L10;
                if (getValueParameter(r1).isInitialized() == false) goto L7;
                r1 = r1 + 1;
                goto L4
            L7:
                return false;
            L10:
                if (extensionsAreInitialized() == true) goto L12;
                return false;
            L12:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                Constructor r0 = null;
                Constructor r5 = Constructor.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                Constructor r6 = (Constructor) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public Builder setFlags(int r2) {
                this.bitField0_ |= 1;
                this.flags_ = r2;
                return this;
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.valueParameter_ = new ArrayList(this.valueParameter_);
                this.bitField0_ |= 2;
                return;
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            public ValueParameter getValueParameter(int r1) {
                return this.valueParameter_.get(r1);
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4;
                return;
            }
        }

        /* synthetic */ Constructor(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ Constructor(GeneratedMessageLite.ExtendableBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$13502(Constructor r0, int r1) {
            r0.flags_ = r1;
            return r1;
        }

        static /* synthetic */ List access$13600(Constructor r0) {
            return r0.valueParameter_;
        }

        static /* synthetic */ List access$13602(Constructor r0, List r1) {
            r0.valueParameter_ = r1;
            return r1;
        }

        static /* synthetic */ List access$13700(Constructor r0) {
            return r0.versionRequirement_;
        }

        static /* synthetic */ List access$13702(Constructor r0, List r1) {
            r0.versionRequirement_ = r1;
            return r1;
        }

        static /* synthetic */ int access$13802(Constructor r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$13900(Constructor r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private Constructor(GeneratedMessageLite.ExtendableBuilder<Constructor, ?> r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private Constructor(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Constructor getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Constructor(CodedInputStream r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            int r4 = 0;
        L4:
            if (r3 == true) goto L60;
            int r7 = r11.readTag();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            if (r7 == 0) goto L37;
            if (r7 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            this.flags_ = r11.readInt32();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            goto L4
        L10:
            if (r7 != 18) goto L12;
            if ((r4 & 2) == 2) goto L34;
            this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            r4 = r4 | 2;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        L34:
            this.valueParameter_.add((ValueParameter) r11.readMessage(ValueParameter.PARSER, r12));     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            goto L4
        L12:
            if (r7 != 248) goto L14;
            if ((r4 & 4) == 4) goto L30;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            r4 = r4 | 4;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        L30:
            this.versionRequirement_.add(Integer.valueOf(r11.readInt32()));     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            goto L4
        L14:
            if (r7 != 250) goto L16;
            int r8 = r11.pushLimit(r11.readRawVarint32());     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            if ((r4 & 4) == 4) goto L24;
            if (r11.getBytesUntilLimit() <= 0) goto L24;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            r4 = r4 | 4;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        L24:
            if (r11.getBytesUntilLimit() <= 0) goto L26;
            this.versionRequirement_.add(Integer.valueOf(r11.readInt32()));     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            goto L24
        L26:
            r11.popLimit(r8);     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            goto L4
        L16:
            if (parseUnknownField(r11, r2, r12, r7) == true) goto L4;
        L37:
            r3 = true;
            goto L4
        L38:
            th = move-exception;
            if ((r4 & 2) != 2) goto L50;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L50:
            if ((r4 & 4) != 4) goto L78;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L78:
            r2.flush();     // Catch: IOException -> L73 Throwable -> L54
        L54:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L53:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L43:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L38
        L40:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L38
        L60:
            if ((r4 & 2) != 2) goto L63;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L63:
            if ((r4 & 4) != 4) goto L76;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L76:
            r2.flush();     // Catch: IOException -> L72 Throwable -> L67
        L67:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L66:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            Constructor r0 = new Constructor(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Constructor> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getFlags() {
            return this.flags_;
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public ValueParameter getValueParameter(int r1) {
            return this.valueParameter_.get(r1);
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L8;
            return false;
        L8:
            int r1 = 0;
        L10:
            if (r1 >= getValueParameterCount()) goto L17;
            if (getValueParameter(r1).isInitialized() == false) goto L13;
            r1 = r1 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (extensionsAreInitialized() == true) goto L20;
            this.memoizedIsInitialized = 0;
            return false;
        L20:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r6) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r6.writeInt32(1, this.flags_);
        L5:
            int r1 = 0;
            int r2 = 0;
        L7:
            if (r2 >= this.valueParameter_.size()) goto L10;
            r6.writeMessage(2, this.valueParameter_.get(r2));
            r2 = r2 + 1;
        L10:
            if (r1 >= this.versionRequirement_.size()) goto L12;
            r6.writeInt32(31, this.versionRequirement_.get(r1).intValue());
            r1 = r1 + 1;
            goto L10
        L12:
            r0.writeUntil(19000, r6);
            r6.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L9:
            int r3 = 0;
        L11:
            if (r3 >= this.valueParameter_.size()) goto L13;
            r1 = r1 + CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(r3));
            r3 = r3 + 1;
            goto L11
        L13:
            int r4 = 0;
        L15:
            if (r2 >= this.versionRequirement_.size()) goto L17;
            r4 = r4 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r2).intValue());
            r2 = r2 + 1;
            goto L15
        L17:
            int r5 = (((r1 + r4) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r5;
            return r5;
        L8:
            r1 = 0;
            goto L9
        }

        public static Builder newBuilder() {
            return Builder.access$13300();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Constructor r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface ConstructorOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Contract extends GeneratedMessageLite implements ContractOrBuilder {
        public static Parser<Contract> PARSER;
        private static final Contract defaultInstance = null;
        private List<Effect> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<Contract, Builder> implements ContractOrBuilder {
            private int bitField0_;
            private List<Effect> effect_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$23500() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((Contract) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.effect_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Contract build() {
                Contract r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public Contract buildPartial() {
                Contract r0 = new Contract(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.effect_ = Collections.unmodifiableList(this.effect_);
                this.bitField0_ &= -2;
            L5:
                Contract.access$23702(r0, this.effect_);
                return r0;
            }

            public Builder mergeFrom(Contract r3) {
                if (r3 != Contract.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Contract.access$23700(r3).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(Contract.access$23800(r3)));
                return this;
            L8:
                if (this.effect_.isEmpty() == false) goto L10;
                this.effect_ = Contract.access$23700(r3);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureEffectIsMutable();
                this.effect_.addAll(Contract.access$23700(r3));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r1 = 0;
            L4:
                if (r1 >= getEffectCount()) goto L9;
                if (getEffect(r1).isInitialized() == false) goto L7;
                r1 = r1 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                Contract r0 = null;
                Contract r5 = Contract.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                Contract r6 = (Contract) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            private void ensureEffectIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.effect_ = new ArrayList(this.effect_);
                this.bitField0_ |= 1;
                return;
            }

            public int getEffectCount() {
                return this.effect_.size();
            }

            public Effect getEffect(int r1) {
                return this.effect_.get(r1);
            }
        }

        /* synthetic */ Contract(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ Contract(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ List access$23700(Contract r0) {
            return r0.effect_;
        }

        static /* synthetic */ List access$23702(Contract r0, List r1) {
            r0.effect_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$23800(Contract r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private Contract(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private Contract(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Contract getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Contract getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Contract(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            boolean r4 = false;
        L3:
            if (r3 == true) goto L36;
            int r5 = r8.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r5 == 0) goto L16;
            if (r5 != 10) goto L9;
            if ((r4 & true) == true) goto L14;
            this.effect_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.effect_.add((Effect) r8.readMessage(Effect.PARSER, r9));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r8, r2, r9, r5) == true) goto L3;
        L16:
            r3 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r4 & true) != true) goto L48;
            this.effect_ = Collections.unmodifiableList(this.effect_);
        L48:
            r2.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L29:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r4 & true) != true) goto L51;
            this.effect_ = Collections.unmodifiableList(this.effect_);
        L51:
            r2.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L39:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            Contract r0 = new Contract(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Contract> getParserForType() {
            return PARSER;
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        public Effect getEffect(int r1) {
            return this.effect_.get(r1);
        }

        private void initFields() {
            this.effect_ = Collections.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L8;
            return false;
        L8:
            int r1 = 0;
        L10:
            if (r1 >= getEffectCount()) goto L16;
            if (getEffect(r1).isInitialized() == false) goto L13;
            r1 = r1 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r4) throws IOException {
            getSerializedSize();
            int r0 = 0;
        L4:
            if (r0 >= this.effect_.size()) goto L6;
            r4.writeMessage(1, this.effect_.get(r0));
            r0 = r0 + 1;
            goto L4
        L6:
            r4.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            int r2 = 0;
        L7:
            if (r1 >= this.effect_.size()) goto L9;
            r2 = r2 + CodedOutputStream.computeMessageSize(1, this.effect_.get(r1));
            r1 = r1 + 1;
            goto L7
        L9:
            int r3 = r2 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public static Builder newBuilder() {
            return Builder.access$23500();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Contract r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface ContractOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Effect extends GeneratedMessageLite implements EffectOrBuilder {
        public static Parser<Effect> PARSER;
        private static final Effect defaultInstance = null;
        private int bitField0_;
        private Expression conclusionOfConditionalEffect_;
        private List<Expression> effectConstructorArgument_;
        private EffectType effectType_;
        private InvocationKind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<Effect, Builder> implements EffectOrBuilder {
            private int bitField0_;
            private Expression conclusionOfConditionalEffect_;
            private List<Expression> effectConstructorArgument_;
            private EffectType effectType_;
            private InvocationKind kind_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$24000() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((Effect) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.effectType_ = EffectType.RETURNS_CONSTANT;
                this.effectConstructorArgument_ = Collections.emptyList();
                this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
                this.kind_ = InvocationKind.AT_MOST_ONCE;
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Effect build() {
                Effect r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public Effect buildPartial() {
                Effect r0 = new Effect(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                Effect.access$24202(r0, this.effectType_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                this.bitField0_ &= -3;
            L9:
                Effect.access$24302(r0, this.effectConstructorArgument_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 2;
            L12:
                Effect.access$24402(r0, this.conclusionOfConditionalEffect_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 4;
            L15:
                Effect.access$24502(r0, this.kind_);
                Effect.access$24602(r0, r3);
                return r0;
            }

            public Builder mergeFrom(Effect r3) {
                if (r3 != Effect.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasEffectType() == false) goto L9;
                setEffectType(r3.getEffectType());
            L9:
                if (Effect.access$24300(r3).isEmpty() == true) goto L15;
                if (this.effectConstructorArgument_.isEmpty() == false) goto L13;
                this.effectConstructorArgument_ = Effect.access$24300(r3);
                this.bitField0_ &= -3;
                goto L15
            L13:
                ensureEffectConstructorArgumentIsMutable();
                this.effectConstructorArgument_.addAll(Effect.access$24300(r3));
            L15:
                if (r3.hasConclusionOfConditionalEffect() == false) goto L18;
                mergeConclusionOfConditionalEffect(r3.getConclusionOfConditionalEffect());
            L18:
                if (r3.hasKind() == false) goto L20;
                setKind(r3.getKind());
            L20:
                setUnknownFields(getUnknownFields().concat(Effect.access$24700(r3)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r1 = 0;
            L4:
                if (r1 >= getEffectConstructorArgumentCount()) goto L10;
                if (getEffectConstructorArgument(r1).isInitialized() == false) goto L7;
                r1 = r1 + 1;
                goto L4
            L7:
                return false;
            L10:
                if (hasConclusionOfConditionalEffect() == true) goto L12;
                return true;
            L12:
                if (getConclusionOfConditionalEffect().isInitialized() == true) goto L18;
                return false;
            L18:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                Effect r0 = null;
                Effect r5 = Effect.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                Effect r6 = (Effect) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public Builder setEffectType(EffectType r2) {
                r2.getClass();
                this.bitField0_ |= 1;
                this.effectType_ = r2;
                return this;
            }

            private void ensureEffectConstructorArgumentIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
                this.bitField0_ |= 2;
                return;
            }

            public int getEffectConstructorArgumentCount() {
                return this.effectConstructorArgument_.size();
            }

            public Expression getEffectConstructorArgument(int r1) {
                return this.effectConstructorArgument_.get(r1);
            }

            public boolean hasConclusionOfConditionalEffect() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public Expression getConclusionOfConditionalEffect() {
                return this.conclusionOfConditionalEffect_;
            }

            public Builder mergeConclusionOfConditionalEffect(Expression r4) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.conclusionOfConditionalEffect_ = r4;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.conclusionOfConditionalEffect_ == Expression.getDefaultInstance()) goto L7;
                this.conclusionOfConditionalEffect_ = Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setKind(InvocationKind r2) {
                r2.getClass();
                this.bitField0_ |= 8;
                this.kind_ = r2;
                return this;
            }
        }

        public static final enum EffectType extends Enum<EffectType> implements Internal.EnumLite {
            private static final /* synthetic */ EffectType[] $VALUES = null;
            public static final EffectType CALLS = null;
            public static final EffectType RETURNS_CONSTANT = null;
            public static final EffectType RETURNS_NOT_NULL = null;
            private static Internal.EnumLiteMap<EffectType> internalValueMap;
            private final int value;

            public static EffectType valueOf(String r1) {
                return (EffectType) Enum.valueOf(EffectType.class, r1);
            }

            public static EffectType[] values() {
                return (EffectType[]) $VALUES.clone();
            }

            static {
                EffectType r0 = new EffectType("RETURNS_CONSTANT", 0, 0, 0);
                RETURNS_CONSTANT = r0;
                EffectType r1 = new EffectType("CALLS", 1, 1, 1);
                CALLS = r1;
                EffectType r3 = new EffectType("RETURNS_NOT_NULL", 2, 2, 2);
                RETURNS_NOT_NULL = r3;
                $VALUES = new EffectType[]{r0, r1, r3};
                internalValueMap = new AnonymousClass1();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static EffectType valueOf(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return RETURNS_NOT_NULL;
            L12:
                return CALLS;
            L14:
                return RETURNS_CONSTANT;
            }

            private EffectType(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.value = r4;
            }
        }

        public static final enum InvocationKind extends Enum<InvocationKind> implements Internal.EnumLite {
            private static final /* synthetic */ InvocationKind[] $VALUES = null;
            public static final InvocationKind AT_LEAST_ONCE = null;
            public static final InvocationKind AT_MOST_ONCE = null;
            public static final InvocationKind EXACTLY_ONCE = null;
            private static Internal.EnumLiteMap<InvocationKind> internalValueMap;
            private final int value;

            public static InvocationKind valueOf(String r1) {
                return (InvocationKind) Enum.valueOf(InvocationKind.class, r1);
            }

            public static InvocationKind[] values() {
                return (InvocationKind[]) $VALUES.clone();
            }

            static {
                InvocationKind r0 = new InvocationKind("AT_MOST_ONCE", 0, 0, 0);
                AT_MOST_ONCE = r0;
                InvocationKind r1 = new InvocationKind("EXACTLY_ONCE", 1, 1, 1);
                EXACTLY_ONCE = r1;
                InvocationKind r3 = new InvocationKind("AT_LEAST_ONCE", 2, 2, 2);
                AT_LEAST_ONCE = r3;
                $VALUES = new InvocationKind[]{r0, r1, r3};
                internalValueMap = new AnonymousClass1();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static InvocationKind valueOf(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return AT_LEAST_ONCE;
            L12:
                return EXACTLY_ONCE;
            L14:
                return AT_MOST_ONCE;
            }

            private InvocationKind(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.value = r4;
            }
        }

        /* synthetic */ Effect(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ Effect(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ EffectType access$24202(Effect r0, EffectType r1) {
            r0.effectType_ = r1;
            return r1;
        }

        static /* synthetic */ List access$24300(Effect r0) {
            return r0.effectConstructorArgument_;
        }

        static /* synthetic */ List access$24302(Effect r0, List r1) {
            r0.effectConstructorArgument_ = r1;
            return r1;
        }

        static /* synthetic */ Expression access$24402(Effect r0, Expression r1) {
            r0.conclusionOfConditionalEffect_ = r1;
            return r1;
        }

        static /* synthetic */ InvocationKind access$24502(Effect r0, InvocationKind r1) {
            r0.kind_ = r1;
            return r1;
        }

        static /* synthetic */ int access$24602(Effect r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$24700(Effect r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private Effect(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private Effect(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Effect getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Effect getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Effect(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            int r4 = 0;
        L4:
            if (r3 == true) goto L59;
            int r6 = r10.readTag();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r6 == 0) goto L39;
            if (r6 != 8) goto L10;
            int r7 = r10.readEnum();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            EffectType r8 = EffectType.valueOf(r7);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r8 == null) goto L36;
            this.bitField0_ |= 1;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.effectType_ = r8;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L36:
            r2.writeRawVarint32(r6);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            r2.writeRawVarint32(r7);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L10:
            if (r6 != 18) goto L12;
            if ((r4 & 2) == 2) goto L33;
            this.effectConstructorArgument_ = new ArrayList();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            r4 = r4 | 2;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
        L33:
            this.effectConstructorArgument_.add((Expression) r10.readMessage(Expression.PARSER, r11));     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L12:
            if (r6 != 26) goto L14;
            if ((this.bitField0_ & 2) != 2) goto L25;
            Expression.Builder r9 = this.conclusionOfConditionalEffect_.toBuilder();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
        L26:
            Expression r12 = (Expression) r10.readMessage(Expression.PARSER, r11);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.conclusionOfConditionalEffect_ = r12;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r9 == null) goto L29;
            r9.mergeFrom(r12);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.conclusionOfConditionalEffect_ = r9.buildPartial();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
        L29:
            this.bitField0_ |= 2;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L25:
            r9 = null;
            goto L26
        L14:
            if (r6 != 32) goto L16;
            int r13 = r10.readEnum();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            InvocationKind r14 = InvocationKind.valueOf(r13);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r14 == null) goto L20;
            this.bitField0_ |= 4;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.kind_ = r14;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L20:
            r2.writeRawVarint32(r6);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            r2.writeRawVarint32(r13);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L16:
            if (parseUnknownField(r10, r2, r11, r6) == true) goto L4;
        L39:
            r3 = true;
            goto L4
        L40:
            th = move-exception;
            if ((r4 & 2) != 2) goto L74;
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
        L74:
            r2.flush();     // Catch: IOException -> L69 Throwable -> L53
        L53:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L52:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L45:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L40
        L42:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L40
        L59:
            if ((r4 & 2) != 2) goto L72;
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
        L72:
            r2.flush();     // Catch: IOException -> L68 Throwable -> L63
        L63:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L62:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            Effect r0 = new Effect(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Effect> getParserForType() {
            return PARSER;
        }

        public boolean hasEffectType() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public EffectType getEffectType() {
            return this.effectType_;
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        public Expression getEffectConstructorArgument(int r1) {
            return this.effectConstructorArgument_.get(r1);
        }

        public boolean hasConclusionOfConditionalEffect() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        public boolean hasKind() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public InvocationKind getKind() {
            return this.kind_;
        }

        private void initFields() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L8;
            return false;
        L8:
            int r1 = 0;
        L10:
            if (r1 >= getEffectConstructorArgumentCount()) goto L17;
            if (getEffectConstructorArgument(r1).isInitialized() == false) goto L13;
            r1 = r1 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (hasConclusionOfConditionalEffect() == true) goto L19;
        L22:
            this.memoizedIsInitialized = 1;
            return true;
        L19:
            if (getConclusionOfConditionalEffect().isInitialized() == true) goto L22;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r4) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r4.writeEnum(1, this.effectType_.getNumber());
        L5:
            int r0 = 0;
        L7:
            if (r0 >= this.effectConstructorArgument_.size()) goto L10;
            r4.writeMessage(2, this.effectConstructorArgument_.get(r0));
            r0 = r0 + 1;
            goto L7
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r4.writeMessage(3, this.conclusionOfConditionalEffect_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r4.writeEnum(4, this.kind_.getNumber());
        L15:
            r4.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) + 0;
        L10:
            if (r2 >= this.effectConstructorArgument_.size()) goto L13;
            r1 = r1 + CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(r2));
            r2 = r2 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 2) != 2) goto L16;
            r1 = r1 + CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
        L16:
            if ((this.bitField0_ & 4) != 4) goto L18;
            r1 = r1 + CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
        L18:
            int r3 = r1 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        L8:
            r1 = 0;
            goto L10
        }

        public static Builder newBuilder() {
            return Builder.access$24000();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Effect r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface EffectOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class EnumEntry extends GeneratedMessageLite.ExtendableMessage<EnumEntry> implements EnumEntryOrBuilder {
        public static Parser<EnumEntry> PARSER;
        private static final EnumEntry defaultInstance = null;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumEntry, Builder> implements EnumEntryOrBuilder {
            private int bitField0_;
            private int name_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$20400() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((EnumEntry) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public EnumEntry build() {
                EnumEntry r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public EnumEntry buildPartial() {
                EnumEntry r0 = new EnumEntry(this, null);
                int r2 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r2 = 0;
            L6:
                EnumEntry.access$20602(r0, this.name_);
                EnumEntry.access$20702(r0, r2);
                return r0;
            }

            public Builder mergeFrom(EnumEntry r2) {
                if (r2 != EnumEntry.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r2.hasName() == false) goto L8;
                setName(r2.getName());
            L8:
                mergeExtensionFields(r2);
                setUnknownFields(getUnknownFields().concat(EnumEntry.access$20800(r2)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (extensionsAreInitialized() == true) goto L6;
                return false;
            L6:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                EnumEntry r0 = null;
                EnumEntry r5 = EnumEntry.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                EnumEntry r6 = (EnumEntry) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public Builder setName(int r2) {
                this.bitField0_ |= 1;
                this.name_ = r2;
                return this;
            }
        }

        /* synthetic */ EnumEntry(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ EnumEntry(GeneratedMessageLite.ExtendableBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$20602(EnumEntry r0, int r1) {
            r0.name_ = r1;
            return r1;
        }

        static /* synthetic */ int access$20702(EnumEntry r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$20800(EnumEntry r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private EnumEntry(GeneratedMessageLite.ExtendableBuilder<EnumEntry, ?> r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private EnumEntry(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public EnumEntry getDefaultInstanceForType() {
            return defaultInstance;
        }

        private EnumEntry(CodedInputStream r7, ExtensionRegistryLite r8) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L40;
            int r4 = r7.readTag();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
            if (r4 == 0) goto L13;
            if (r4 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
            this.name_ = r7.readInt32();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
            goto L3
        L9:
            if (parseUnknownField(r7, r2, r8, r4) == true) goto L3;
        L13:
            r3 = true;
            goto L3
        L14:
            th = move-exception;
            r2.flush();     // Catch: IOException -> L36 Throwable -> L24
        L24:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L23:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L19:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L14
        L16:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L14
        L40:
            r2.flush();     // Catch: IOException -> L37 Throwable -> L31
        L31:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L30:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            EnumEntry r0 = new EnumEntry(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<EnumEntry> getParserForType() {
            return PARSER;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getName() {
            return this.name_;
        }

        private void initFields() {
            this.name_ = 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (extensionsAreInitialized() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r4) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r4.writeInt32(1, this.name_);
        L5:
            r0.writeUntil(200, r4);
            r4.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            r2 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
        L8:
            int r3 = (r2 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public static Builder newBuilder() {
            return Builder.access$20400();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumEntry r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface EnumEntryOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Expression extends GeneratedMessageLite implements ExpressionOrBuilder {
        public static Parser<Expression> PARSER;
        private static final Expression defaultInstance = null;
        private List<Expression> andArgument_;
        private int bitField0_;
        private ConstantValue constantValue_;
        private int flags_;
        private int isInstanceTypeId_;
        private Type isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Expression> orArgument_;
        private final ByteString unknownFields;
        private int valueParameterReference_;

        public static final class Builder extends GeneratedMessageLite.Builder<Expression, Builder> implements ExpressionOrBuilder {
            private List<Expression> andArgument_;
            private int bitField0_;
            private ConstantValue constantValue_;
            private int flags_;
            private int isInstanceTypeId_;
            private Type isInstanceType_;
            private List<Expression> orArgument_;
            private int valueParameterReference_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$24900() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((Expression) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.constantValue_ = ConstantValue.TRUE;
                this.isInstanceType_ = Type.getDefaultInstance();
                this.andArgument_ = Collections.emptyList();
                this.orArgument_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Expression build() {
                Expression r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public Expression buildPartial() {
                Expression r0 = new Expression(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                Expression.access$25102(r0, this.flags_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                Expression.access$25202(r0, this.valueParameterReference_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                Expression.access$25302(r0, this.constantValue_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                Expression.access$25402(r0, this.isInstanceType_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                Expression.access$25502(r0, this.isInstanceTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                this.bitField0_ &= -33;
            L21:
                Expression.access$25602(r0, this.andArgument_);
                if ((this.bitField0_ & 64) != 64) goto L24;
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                this.bitField0_ &= -65;
            L24:
                Expression.access$25702(r0, this.orArgument_);
                Expression.access$25802(r0, r3);
                return r0;
            }

            public Builder mergeFrom(Expression r3) {
                if (r3 != Expression.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasFlags() == false) goto L9;
                setFlags(r3.getFlags());
            L9:
                if (r3.hasValueParameterReference() == false) goto L12;
                setValueParameterReference(r3.getValueParameterReference());
            L12:
                if (r3.hasConstantValue() == false) goto L15;
                setConstantValue(r3.getConstantValue());
            L15:
                if (r3.hasIsInstanceType() == false) goto L18;
                mergeIsInstanceType(r3.getIsInstanceType());
            L18:
                if (r3.hasIsInstanceTypeId() == false) goto L21;
                setIsInstanceTypeId(r3.getIsInstanceTypeId());
            L21:
                if (Expression.access$25600(r3).isEmpty() == true) goto L27;
                if (this.andArgument_.isEmpty() == false) goto L25;
                this.andArgument_ = Expression.access$25600(r3);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureAndArgumentIsMutable();
                this.andArgument_.addAll(Expression.access$25600(r3));
            L27:
                if (Expression.access$25700(r3).isEmpty() == false) goto L29;
            L32:
                setUnknownFields(getUnknownFields().concat(Expression.access$25900(r3)));
                return this;
            L29:
                if (this.orArgument_.isEmpty() == false) goto L31;
                this.orArgument_ = Expression.access$25700(r3);
                this.bitField0_ &= -65;
                goto L32
            L31:
                ensureOrArgumentIsMutable();
                this.orArgument_.addAll(Expression.access$25700(r3));
                goto L32
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasIsInstanceType() == true) goto L5;
            L7:
                int r0 = 0;
            L9:
                if (r0 >= getAndArgumentCount()) goto L14;
                if (getAndArgument(r0).isInitialized() == false) goto L12;
                r0 = r0 + 1;
                goto L9
            L12:
                return false;
            L14:
                int r1 = 0;
            L16:
                if (r1 >= getOrArgumentCount()) goto L21;
                if (getOrArgument(r1).isInitialized() == false) goto L19;
                r1 = r1 + 1;
                goto L16
            L19:
                return false;
            L21:
                return true;
            L5:
                if (getIsInstanceType().isInitialized() == true) goto L7;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                Expression r0 = null;
                Expression r5 = Expression.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                Expression r6 = (Expression) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public Builder setFlags(int r2) {
                this.bitField0_ |= 1;
                this.flags_ = r2;
                return this;
            }

            public Builder setValueParameterReference(int r2) {
                this.bitField0_ |= 2;
                this.valueParameterReference_ = r2;
                return this;
            }

            public Builder setConstantValue(ConstantValue r2) {
                r2.getClass();
                this.bitField0_ |= 4;
                this.constantValue_ = r2;
                return this;
            }

            public boolean hasIsInstanceType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getIsInstanceType() {
                return this.isInstanceType_;
            }

            public Builder mergeIsInstanceType(Type r4) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.isInstanceType_ = r4;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.isInstanceType_ == Type.getDefaultInstance()) goto L7;
                this.isInstanceType_ = Type.newBuilder(this.isInstanceType_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setIsInstanceTypeId(int r2) {
                this.bitField0_ |= 16;
                this.isInstanceTypeId_ = r2;
                return this;
            }

            private void ensureAndArgumentIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.andArgument_ = new ArrayList(this.andArgument_);
                this.bitField0_ |= 32;
                return;
            }

            public int getAndArgumentCount() {
                return this.andArgument_.size();
            }

            public Expression getAndArgument(int r1) {
                return this.andArgument_.get(r1);
            }

            private void ensureOrArgumentIsMutable() {
                if ((this.bitField0_ & 64) == 64) goto L6;
                this.orArgument_ = new ArrayList(this.orArgument_);
                this.bitField0_ |= 64;
                return;
            }

            public int getOrArgumentCount() {
                return this.orArgument_.size();
            }

            public Expression getOrArgument(int r1) {
                return this.orArgument_.get(r1);
            }
        }

        public static final enum ConstantValue extends Enum<ConstantValue> implements Internal.EnumLite {
            private static final /* synthetic */ ConstantValue[] $VALUES = null;
            public static final ConstantValue FALSE = null;
            public static final ConstantValue NULL = null;
            public static final ConstantValue TRUE = null;
            private static Internal.EnumLiteMap<ConstantValue> internalValueMap;
            private final int value;

            public static ConstantValue valueOf(String r1) {
                return (ConstantValue) Enum.valueOf(ConstantValue.class, r1);
            }

            public static ConstantValue[] values() {
                return (ConstantValue[]) $VALUES.clone();
            }

            static {
                ConstantValue r0 = new ConstantValue("TRUE", 0, 0, 0);
                TRUE = r0;
                ConstantValue r1 = new ConstantValue("FALSE", 1, 1, 1);
                FALSE = r1;
                ConstantValue r3 = new ConstantValue("NULL", 2, 2, 2);
                NULL = r3;
                $VALUES = new ConstantValue[]{r0, r1, r3};
                internalValueMap = new AnonymousClass1();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static ConstantValue valueOf(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return NULL;
            L12:
                return FALSE;
            L14:
                return TRUE;
            }

            private ConstantValue(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.value = r4;
            }
        }

        /* synthetic */ Expression(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ Expression(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$25102(Expression r0, int r1) {
            r0.flags_ = r1;
            return r1;
        }

        static /* synthetic */ int access$25202(Expression r0, int r1) {
            r0.valueParameterReference_ = r1;
            return r1;
        }

        static /* synthetic */ ConstantValue access$25302(Expression r0, ConstantValue r1) {
            r0.constantValue_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$25402(Expression r0, Type r1) {
            r0.isInstanceType_ = r1;
            return r1;
        }

        static /* synthetic */ int access$25502(Expression r0, int r1) {
            r0.isInstanceTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ List access$25600(Expression r0) {
            return r0.andArgument_;
        }

        static /* synthetic */ List access$25602(Expression r0, List r1) {
            r0.andArgument_ = r1;
            return r1;
        }

        static /* synthetic */ List access$25700(Expression r0) {
            return r0.orArgument_;
        }

        static /* synthetic */ List access$25702(Expression r0, List r1) {
            r0.orArgument_ = r1;
            return r1;
        }

        static /* synthetic */ int access$25802(Expression r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$25900(Expression r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private Expression(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private Expression(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Expression getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Expression getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Expression(CodedInputStream r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            int r4 = 0;
        L4:
            if (r3 == true) goto L71;
            int r7 = r12.readTag();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r7 == 0) goto L48;
            if (r7 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.flags_ = r12.readInt32();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L10:
            if (r7 != 16) goto L12;
            this.bitField0_ |= 2;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.valueParameterReference_ = r12.readInt32();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L12:
            if (r7 != 24) goto L14;
            int r8 = r12.readEnum();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            ConstantValue r9 = ConstantValue.valueOf(r8);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r9 == null) goto L43;
            this.bitField0_ |= 4;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.constantValue_ = r9;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L43:
            r2.writeRawVarint32(r7);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r2.writeRawVarint32(r8);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L14:
            if (r7 != 34) goto L16;
            if ((this.bitField0_ & 8) != 8) goto L36;
            Type.Builder r10 = this.isInstanceType_.toBuilder();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L37:
            Type r11 = (Type) r12.readMessage(Type.PARSER, r13);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.isInstanceType_ = r11;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r10 == null) goto L40;
            r10.mergeFrom(r11);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.isInstanceType_ = r10.buildPartial();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L40:
            this.bitField0_ |= 8;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L36:
            r10 = null;
            goto L37
        L16:
            if (r7 != 40) goto L18;
            this.bitField0_ |= 16;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.isInstanceTypeId_ = r12.readInt32();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L18:
            if (r7 != 50) goto L20;
            if ((r4 & 32) == 32) goto L31;
            this.andArgument_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r4 = r4 | 32;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L31:
            this.andArgument_.add((Expression) r12.readMessage(PARSER, r13));     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L20:
            if (r7 != 58) goto L22;
            if ((r4 & 64) == 64) goto L27;
            this.orArgument_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r4 = r4 | 64;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L27:
            this.orArgument_.add((Expression) r12.readMessage(PARSER, r13));     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L22:
            if (parseUnknownField(r12, r2, r13, r7) == true) goto L4;
        L48:
            r3 = true;
            goto L4
        L49:
            th = move-exception;
            if ((r4 & 32) != 32) goto L61;
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        L61:
            if ((r4 & 64) != 64) goto L86;
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
        L86:
            r2.flush();     // Catch: IOException -> L84 Throwable -> L65
        L65:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L64:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L54:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L51:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L71:
            if ((r4 & 32) != 32) goto L74;
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        L74:
            if ((r4 & 64) != 64) goto L89;
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
        L89:
            r2.flush();     // Catch: IOException -> L83 Throwable -> L78
        L78:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L77:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            Expression r0 = new Expression(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Expression> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasValueParameterReference() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        public boolean hasConstantValue() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        public boolean hasIsInstanceType() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        public boolean hasIsInstanceTypeId() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public Expression getAndArgument(int r1) {
            return this.andArgument_.get(r1);
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        public Expression getOrArgument(int r1) {
            return this.orArgument_.get(r1);
        }

        private void initFields() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (hasIsInstanceType() == true) goto L11;
        L14:
            int r1 = 0;
        L16:
            if (r1 >= getAndArgumentCount()) goto L22;
            if (getAndArgument(r1).isInitialized() == false) goto L19;
            r1 = r1 + 1;
            goto L16
        L19:
            this.memoizedIsInitialized = 0;
            return false;
        L22:
            int r2 = 0;
        L24:
            if (r2 >= getOrArgumentCount()) goto L30;
            if (getOrArgument(r2).isInitialized() == false) goto L27;
            r2 = r2 + 1;
            goto L24
        L27:
            this.memoizedIsInitialized = 0;
            return false;
        L30:
            this.memoizedIsInitialized = 1;
            return true;
        L11:
            if (getIsInstanceType().isInitialized() == true) goto L14;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r5.writeInt32(2, this.valueParameterReference_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r5.writeEnum(3, this.constantValue_.getNumber());
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r5.writeMessage(4, this.isInstanceType_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L17;
            r5.writeInt32(5, this.isInstanceTypeId_);
        L17:
            int r0 = 0;
            int r1 = 0;
        L19:
            if (r1 >= this.andArgument_.size()) goto L22;
            r5.writeMessage(6, this.andArgument_.get(r1));
            r1 = r1 + 1;
        L22:
            if (r0 >= this.orArgument_.size()) goto L24;
            r5.writeMessage(7, this.orArgument_.get(r0));
            r0 = r0 + 1;
            goto L22
        L24:
            r5.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r1 = r1 + CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r1 = r1 + CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r1 = r1 + CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L21;
            r1 = r1 + CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
        L21:
            int r3 = 0;
        L23:
            if (r3 >= this.andArgument_.size()) goto L26;
            r1 = r1 + CodedOutputStream.computeMessageSize(6, this.andArgument_.get(r3));
            r3 = r3 + 1;
        L26:
            if (r2 >= this.orArgument_.size()) goto L28;
            r1 = r1 + CodedOutputStream.computeMessageSize(7, this.orArgument_.get(r2));
            r2 = r2 + 1;
            goto L26
        L28:
            int r4 = r1 + this.unknownFields.size();
            this.memoizedSerializedSize = r4;
            return r4;
        L8:
            r1 = 0;
            goto L10
        }

        public static Builder newBuilder() {
            return Builder.access$24900();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Expression r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface ExpressionOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Function extends GeneratedMessageLite.ExtendableMessage<Function> implements FunctionOrBuilder {
        public static Parser<Function> PARSER;
        private static final Function defaultInstance = null;
        private int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private Contract contract_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Function, Builder> implements FunctionOrBuilder {
            private int bitField0_;
            private List<Integer> contextReceiverTypeId_;
            private List<Type> contextReceiverType_;
            private Contract contract_;
            private int flags_;
            private int name_;
            private int oldFlags_;
            private int receiverTypeId_;
            private Type receiverType_;
            private int returnTypeId_;
            private Type returnType_;
            private List<TypeParameter> typeParameter_;
            private TypeTable typeTable_;
            private List<ValueParameter> valueParameter_;
            private List<Integer> versionRequirement_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$14100() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((Function) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.flags_ = 6;
                this.oldFlags_ = 6;
                this.returnType_ = Type.getDefaultInstance();
                this.typeParameter_ = Collections.emptyList();
                this.receiverType_ = Type.getDefaultInstance();
                this.contextReceiverType_ = Collections.emptyList();
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.valueParameter_ = Collections.emptyList();
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.versionRequirement_ = Collections.emptyList();
                this.contract_ = Contract.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Function build() {
                Function r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public Function buildPartial() {
                Function r0 = new Function(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                Function.access$14302(r0, this.flags_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                Function.access$14402(r0, this.oldFlags_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                Function.access$14502(r0, this.name_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                Function.access$14602(r0, this.returnType_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                Function.access$14702(r0, this.returnTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            L21:
                Function.access$14802(r0, this.typeParameter_);
                if ((r1 & 64) != 64) goto L24;
                r3 = r3 | 32;
            L24:
                Function.access$14902(r0, this.receiverType_);
                if ((r1 & 128) != 128) goto L27;
                r3 = r3 | 64;
            L27:
                Function.access$15002(r0, this.receiverTypeId_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            L30:
                Function.access$15102(r0, this.contextReceiverType_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            L33:
                Function.access$15202(r0, this.contextReceiverTypeId_);
                if ((this.bitField0_ & 1024) != 1024) goto L36;
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -1025;
            L36:
                Function.access$15302(r0, this.valueParameter_);
                if ((r1 & 2048) != 2048) goto L39;
                r3 = r3 | 128;
            L39:
                Function.access$15402(r0, this.typeTable_);
                if ((this.bitField0_ & 4096) != 4096) goto L42;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -4097;
            L42:
                Function.access$15502(r0, this.versionRequirement_);
                if ((r1 & 8192) != 8192) goto L45;
                r3 = r3 | 256;
            L45:
                Function.access$15602(r0, this.contract_);
                Function.access$15702(r0, r3);
                return r0;
            }

            public Builder mergeFrom(Function r3) {
                if (r3 != Function.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasFlags() == false) goto L9;
                setFlags(r3.getFlags());
            L9:
                if (r3.hasOldFlags() == false) goto L12;
                setOldFlags(r3.getOldFlags());
            L12:
                if (r3.hasName() == false) goto L15;
                setName(r3.getName());
            L15:
                if (r3.hasReturnType() == false) goto L18;
                mergeReturnType(r3.getReturnType());
            L18:
                if (r3.hasReturnTypeId() == false) goto L21;
                setReturnTypeId(r3.getReturnTypeId());
            L21:
                if (Function.access$14800(r3).isEmpty() == true) goto L27;
                if (this.typeParameter_.isEmpty() == false) goto L25;
                this.typeParameter_ = Function.access$14800(r3);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Function.access$14800(r3));
            L27:
                if (r3.hasReceiverType() == false) goto L30;
                mergeReceiverType(r3.getReceiverType());
            L30:
                if (r3.hasReceiverTypeId() == false) goto L33;
                setReceiverTypeId(r3.getReceiverTypeId());
            L33:
                if (Function.access$15100(r3).isEmpty() == true) goto L39;
                if (this.contextReceiverType_.isEmpty() == false) goto L37;
                this.contextReceiverType_ = Function.access$15100(r3);
                this.bitField0_ &= -257;
                goto L39
            L37:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Function.access$15100(r3));
            L39:
                if (Function.access$15200(r3).isEmpty() == true) goto L45;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L43;
                this.contextReceiverTypeId_ = Function.access$15200(r3);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
                goto L45
            L43:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Function.access$15200(r3));
            L45:
                if (Function.access$15300(r3).isEmpty() == true) goto L51;
                if (this.valueParameter_.isEmpty() == false) goto L49;
                this.valueParameter_ = Function.access$15300(r3);
                this.bitField0_ &= -1025;
                goto L51
            L49:
                ensureValueParameterIsMutable();
                this.valueParameter_.addAll(Function.access$15300(r3));
            L51:
                if (r3.hasTypeTable() == false) goto L54;
                mergeTypeTable(r3.getTypeTable());
            L54:
                if (Function.access$15500(r3).isEmpty() == true) goto L60;
                if (this.versionRequirement_.isEmpty() == false) goto L58;
                this.versionRequirement_ = Function.access$15500(r3);
                this.bitField0_ &= -4097;
                goto L60
            L58:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Function.access$15500(r3));
            L60:
                if (r3.hasContract() == false) goto L62;
                mergeContract(r3.getContract());
            L62:
                mergeExtensionFields(r3);
                setUnknownFields(getUnknownFields().concat(Function.access$15800(r3)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L6;
                return false;
            L6:
                if (hasReturnType() == true) goto L8;
            L10:
                int r0 = 0;
            L12:
                if (r0 >= getTypeParameterCount()) goto L18;
                if (getTypeParameter(r0).isInitialized() == false) goto L15;
                r0 = r0 + 1;
                goto L12
            L15:
                return false;
            L18:
                if (hasReceiverType() == true) goto L20;
            L22:
                int r1 = 0;
            L24:
                if (r1 >= getContextReceiverTypeCount()) goto L29;
                if (getContextReceiverType(r1).isInitialized() == false) goto L27;
                r1 = r1 + 1;
                goto L24
            L27:
                return false;
            L29:
                int r2 = 0;
            L31:
                if (r2 >= getValueParameterCount()) goto L37;
                if (getValueParameter(r2).isInitialized() == false) goto L34;
                r2 = r2 + 1;
                goto L31
            L34:
                return false;
            L37:
                if (hasTypeTable() == false) goto L42;
                if (getTypeTable().isInitialized() == true) goto L42;
                return false;
            L42:
                if (hasContract() == false) goto L47;
                if (getContract().isInitialized() == true) goto L47;
                return false;
            L47:
                if (extensionsAreInitialized() == true) goto L49;
                return false;
            L49:
                return true;
            L20:
                if (getReceiverType().isInitialized() == true) goto L22;
                return false;
            L8:
                if (getReturnType().isInitialized() == true) goto L10;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                Function r0 = null;
                Function r5 = Function.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                Function r6 = (Function) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public Builder setFlags(int r2) {
                this.bitField0_ |= 1;
                this.flags_ = r2;
                return this;
            }

            public Builder setOldFlags(int r2) {
                this.bitField0_ |= 2;
                this.oldFlags_ = r2;
                return this;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public Builder setName(int r2) {
                this.bitField0_ |= 4;
                this.name_ = r2;
                return this;
            }

            public boolean hasReturnType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public Builder mergeReturnType(Type r4) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.returnType_ = r4;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.returnType_ == Type.getDefaultInstance()) goto L7;
                this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setReturnTypeId(int r2) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = r2;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 32;
                return;
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int r1) {
                return this.typeParameter_.get(r1);
            }

            public boolean hasReceiverType() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Builder mergeReceiverType(Type r4) {
                if ((this.bitField0_ & 64) == 64) goto L5;
            L7:
                this.receiverType_ = r4;
            L8:
                this.bitField0_ |= 64;
                return this;
            L5:
                if (this.receiverType_ == Type.getDefaultInstance()) goto L7;
                this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setReceiverTypeId(int r2) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = r2;
                return this;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 256;
                return;
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Type getContextReceiverType(int r1) {
                return this.contextReceiverType_.get(r1);
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) == 512) goto L6;
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 512;
                return;
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 1024) == 1024) goto L6;
                this.valueParameter_ = new ArrayList(this.valueParameter_);
                this.bitField0_ |= 1024;
                return;
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            public ValueParameter getValueParameter(int r1) {
                return this.valueParameter_.get(r1);
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 2048) != 2048) goto L5;
                return true;
            L5:
                return false;
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder mergeTypeTable(TypeTable r4) {
                if ((this.bitField0_ & 2048) == 2048) goto L5;
            L7:
                this.typeTable_ = r4;
            L8:
                this.bitField0_ |= 2048;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(r4).buildPartial();
                goto L8
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4096) == 4096) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4096;
                return;
            }

            public boolean hasContract() {
                if ((this.bitField0_ & 8192) != 8192) goto L5;
                return true;
            L5:
                return false;
            }

            public Contract getContract() {
                return this.contract_;
            }

            public Builder mergeContract(Contract r4) {
                if ((this.bitField0_ & 8192) == 8192) goto L5;
            L7:
                this.contract_ = r4;
            L8:
                this.bitField0_ |= 8192;
                return this;
            L5:
                if (this.contract_ == Contract.getDefaultInstance()) goto L7;
                this.contract_ = Contract.newBuilder(this.contract_).mergeFrom(r4).buildPartial();
                goto L8
            }
        }

        /* synthetic */ Function(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ Function(GeneratedMessageLite.ExtendableBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$14302(Function r0, int r1) {
            r0.flags_ = r1;
            return r1;
        }

        static /* synthetic */ int access$14402(Function r0, int r1) {
            r0.oldFlags_ = r1;
            return r1;
        }

        static /* synthetic */ int access$14502(Function r0, int r1) {
            r0.name_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$14602(Function r0, Type r1) {
            r0.returnType_ = r1;
            return r1;
        }

        static /* synthetic */ int access$14702(Function r0, int r1) {
            r0.returnTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ List access$14800(Function r0) {
            return r0.typeParameter_;
        }

        static /* synthetic */ List access$14802(Function r0, List r1) {
            r0.typeParameter_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$14902(Function r0, Type r1) {
            r0.receiverType_ = r1;
            return r1;
        }

        static /* synthetic */ int access$15002(Function r0, int r1) {
            r0.receiverTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ List access$15100(Function r0) {
            return r0.contextReceiverType_;
        }

        static /* synthetic */ List access$15102(Function r0, List r1) {
            r0.contextReceiverType_ = r1;
            return r1;
        }

        static /* synthetic */ List access$15200(Function r0) {
            return r0.contextReceiverTypeId_;
        }

        static /* synthetic */ List access$15202(Function r0, List r1) {
            r0.contextReceiverTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ List access$15300(Function r0) {
            return r0.valueParameter_;
        }

        static /* synthetic */ List access$15302(Function r0, List r1) {
            r0.valueParameter_ = r1;
            return r1;
        }

        static /* synthetic */ TypeTable access$15402(Function r0, TypeTable r1) {
            r0.typeTable_ = r1;
            return r1;
        }

        static /* synthetic */ List access$15500(Function r0) {
            return r0.versionRequirement_;
        }

        static /* synthetic */ List access$15502(Function r0, List r1) {
            r0.versionRequirement_ = r1;
            return r1;
        }

        static /* synthetic */ Contract access$15602(Function r0, Contract r1) {
            r0.contract_ = r1;
            return r1;
        }

        static /* synthetic */ int access$15702(Function r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$15800(Function r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private Function(GeneratedMessageLite.ExtendableBuilder<Function, ?> r2) {
            super(r2);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private Function(boolean r1) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Function getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Function(CodedInputStream r14, ExtensionRegistryLite r15) throws InvalidProtocolBufferException {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            int r4 = 0;
        L4:
            if (r3 == true) goto L114;
            int r10 = r14.readTag();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            Type.Builder r11 = null;
            Contract.Builder r12 = null;
            TypeTable.Builder r13 = null;
            Type.Builder r16 = null;
            switch(r10) {
                case 0: goto L80;
                case 8: goto L78;
                case 16: goto L77;
                case 26: goto L71;
                case 34: goto L66;
                case 42: goto L60;
                case 50: goto L55;
                case 56: goto L54;
                case 64: goto L53;
                case 72: goto L52;
                case 82: goto L48;
                case 88: goto L44;
                case 90: goto L35;
                case 242: goto L29;
                case 248: goto L24;
                case 250: goto L15;
                case 258: goto L9;
                default: goto L81;
            };     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L9:
            if ((this.bitField0_ & 256) != 256) goto L11;
            r12 = this.contract_.toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L11:
            Contract r17 = (Contract) r14.readMessage(Contract.PARSER, r15);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.contract_ = r17;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            if (r12 == null) goto L14;
            r12.mergeFrom(r17);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.contract_ = r12.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L14:
            this.bitField0_ |= 256;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L15:
            int r18 = r14.pushLimit(r14.readRawVarint32());     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            int r19 = (r4 == true ? 1 : 0) & 4096;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = r4;
            if (r19 == 4096) goto L21;
            r4 = r4;
            if (r14.getBytesUntilLimit() <= 0) goto L21;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = (r4 == true ? 1 : 0) | 4096;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L21:
            if (r14.getBytesUntilLimit() <= 0) goto L23;
            this.versionRequirement_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L21
        L23:
            r14.popLimit(r18);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L24:
            int r110 = (r4 == true ? 1 : 0) & 4096;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = r4;
            if (r110 == 4096) goto L27;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = (r4 == true ? 1 : 0) | 4096;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L27:
            this.versionRequirement_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L29:
            if ((this.bitField0_ & 128) != 128) goto L31;
            r13 = this.typeTable_.toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L31:
            TypeTable r111 = (TypeTable) r14.readMessage(TypeTable.PARSER, r15);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.typeTable_ = r111;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            if (r13 == null) goto L34;
            r13.mergeFrom(r111);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.typeTable_ = r13.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L34:
            this.bitField0_ |= 128;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L35:
            int r112 = r14.pushLimit(r14.readRawVarint32());     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            int r113 = (r4 == true ? 1 : 0) & 512;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = r4;
            if (r113 == 512) goto L41;
            r4 = r4;
            if (r14.getBytesUntilLimit() <= 0) goto L41;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = (r4 == true ? 1 : 0) | 512;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L41:
            if (r14.getBytesUntilLimit() <= 0) goto L43;
            this.contextReceiverTypeId_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L41
        L43:
            r14.popLimit(r112);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L44:
            int r114 = (r4 == true ? 1 : 0) & 512;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = r4;
            if (r114 == 512) goto L47;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = (r4 == true ? 1 : 0) | 512;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L47:
            this.contextReceiverTypeId_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L48:
            int r115 = (r4 == true ? 1 : 0) & 256;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = r4;
            if (r115 == 256) goto L51;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = (r4 == true ? 1 : 0) | 256;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L51:
            this.contextReceiverType_.add((Type) r14.readMessage(Type.PARSER, r15));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L52:
            this.bitField0_ |= 1;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.flags_ = r14.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L53:
            this.bitField0_ |= 64;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.receiverTypeId_ = r14.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L54:
            this.bitField0_ |= 16;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.returnTypeId_ = r14.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L55:
            int r116 = (r4 == true ? 1 : 0) & 1024;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = r4;
            if (r116 == 1024) goto L58;
            this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = (r4 == true ? 1 : 0) | 1024;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L58:
            this.valueParameter_.add((ValueParameter) r14.readMessage(ValueParameter.PARSER, r15));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L60:
            if ((this.bitField0_ & 32) != 32) goto L62;
            r16 = this.receiverType_.toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L62:
            Type r117 = (Type) r14.readMessage(Type.PARSER, r15);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.receiverType_ = r117;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            if (r16 == null) goto L65;
            r16.mergeFrom(r117);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.receiverType_ = r16.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L65:
            this.bitField0_ |= 32;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L66:
            int r118 = (r4 == true ? 1 : 0) & 32;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = r4;
            if (r118 == 32) goto L69;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r4 = (r4 == true ? 1 : 0) | 32;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L69:
            this.typeParameter_.add((TypeParameter) r14.readMessage(TypeParameter.PARSER, r15));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L71:
            if ((this.bitField0_ & 8) != 8) goto L73;
            r11 = this.returnType_.toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L73:
            Type r119 = (Type) r14.readMessage(Type.PARSER, r15);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.returnType_ = r119;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            if (r11 == null) goto L76;
            r11.mergeFrom(r119);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.returnType_ = r11.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L76:
            this.bitField0_ |= 8;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L77:
            this.bitField0_ |= 4;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.name_ = r14.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L78:
            this.bitField0_ |= 2;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.oldFlags_ = r14.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L80:
            r3 = true;
            goto L4
        L81:
            if (parseUnknownField(r14, r2, r15, r10) == true) goto L4;
        L83:
            th = move-exception;
            if (((r4 == true ? 1 : 0) & 32) != 32) goto L95;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L95:
            if (((r4 == true ? 1 : 0) & 1024) != 1024) goto L98;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L98:
            if (((r4 == true ? 1 : 0) & 256) != 256) goto L101;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L101:
            if (((r4 == true ? 1 : 0) & 512) != 512) goto L104;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L104:
            if (((r4 == true ? 1 : 0) & 4096) != 4096) goto L139;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L139:
            r2.flush();     // Catch: IOException -> L136 Throwable -> L108
        L108:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L107:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L85:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L83
        L88:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L83
        L114:
            if (((r4 == true ? 1 : 0) & 32) != 32) goto L117;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L117:
            if (((r4 == true ? 1 : 0) & 1024) != 1024) goto L120;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L120:
            if (((r4 == true ? 1 : 0) & 256) != 256) goto L123;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L123:
            if (((r4 == true ? 1 : 0) & 512) != 512) goto L126;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L126:
            if (((r4 == true ? 1 : 0) & 4096) != 4096) goto L141;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L141:
            r2.flush();     // Catch: IOException -> L135 Throwable -> L130
        L130:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L129:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            Function r0 = new Function(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Function> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasOldFlags() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasReturnType() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public boolean hasReturnTypeId() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int r1) {
            return this.typeParameter_.get(r1);
        }

        public boolean hasReceiverType() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public boolean hasReceiverTypeId() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public Type getContextReceiverType(int r1) {
            return this.contextReceiverType_.get(r1);
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public ValueParameter getValueParameter(int r1) {
            return this.valueParameter_.get(r1);
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 128) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasContract() {
            if ((this.bitField0_ & 256) != 256) goto L5;
            return true;
        L5:
            return false;
        }

        public Contract getContract() {
            return this.contract_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = Contract.getDefaultInstance();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasReturnType() == true) goto L15;
        L18:
            int r1 = 0;
        L20:
            if (r1 >= getTypeParameterCount()) goto L27;
            if (getTypeParameter(r1).isInitialized() == false) goto L23;
            r1 = r1 + 1;
            goto L20
        L23:
            this.memoizedIsInitialized = 0;
            return false;
        L27:
            if (hasReceiverType() == true) goto L29;
        L32:
            int r2 = 0;
        L34:
            if (r2 >= getContextReceiverTypeCount()) goto L40;
            if (getContextReceiverType(r2).isInitialized() == false) goto L37;
            r2 = r2 + 1;
            goto L34
        L37:
            this.memoizedIsInitialized = 0;
            return false;
        L40:
            int r3 = 0;
        L42:
            if (r3 >= getValueParameterCount()) goto L49;
            if (getValueParameter(r3).isInitialized() == false) goto L45;
            r3 = r3 + 1;
            goto L42
        L45:
            this.memoizedIsInitialized = 0;
            return false;
        L49:
            if (hasTypeTable() == false) goto L55;
            if (getTypeTable().isInitialized() == true) goto L55;
            this.memoizedIsInitialized = 0;
            return false;
        L55:
            if (hasContract() == false) goto L61;
            if (getContract().isInitialized() == true) goto L61;
            this.memoizedIsInitialized = 0;
            return false;
        L61:
            if (extensionsAreInitialized() == true) goto L64;
            this.memoizedIsInitialized = 0;
            return false;
        L64:
            this.memoizedIsInitialized = 1;
            return true;
        L29:
            if (getReceiverType().isInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        L15:
            if (getReturnType().isInitialized() == true) goto L18;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r9) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
            if ((this.bitField0_ & 2) != 2) goto L6;
            r9.writeInt32(1, this.oldFlags_);
        L6:
            if ((this.bitField0_ & 4) != 4) goto L9;
            r9.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 8) != 8) goto L11;
            r9.writeMessage(3, this.returnType_);
        L11:
            int r1 = 0;
            int r5 = 0;
        L13:
            if (r5 >= this.typeParameter_.size()) goto L16;
            r9.writeMessage(4, this.typeParameter_.get(r5));
            r5 = r5 + 1;
            goto L13
        L16:
            if ((this.bitField0_ & 32) != 32) goto L18;
            r9.writeMessage(5, this.receiverType_);
        L18:
            int r4 = 0;
        L20:
            if (r4 >= this.valueParameter_.size()) goto L23;
            r9.writeMessage(6, this.valueParameter_.get(r4));
            r4 = r4 + 1;
            goto L20
        L23:
            if ((this.bitField0_ & 16) != 16) goto L26;
            r9.writeInt32(7, this.returnTypeId_);
        L26:
            if ((this.bitField0_ & 64) != 64) goto L29;
            r9.writeInt32(8, this.receiverTypeId_);
        L29:
            if ((this.bitField0_ & 1) != 1) goto L31;
            r9.writeInt32(9, this.flags_);
        L31:
            int r2 = 0;
        L33:
            if (r2 >= this.contextReceiverType_.size()) goto L36;
            r9.writeMessage(10, this.contextReceiverType_.get(r2));
            r2 = r2 + 1;
            goto L33
        L36:
            if (getContextReceiverTypeIdList().size() <= 0) goto L38;
            r9.writeRawVarint32(90);
            r9.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L38:
            int r3 = 0;
        L40:
            if (r3 >= this.contextReceiverTypeId_.size()) goto L43;
            r9.writeInt32NoTag(this.contextReceiverTypeId_.get(r3).intValue());
            r3 = r3 + 1;
            goto L40
        L43:
            if ((this.bitField0_ & 128) != 128) goto L46;
            r9.writeMessage(30, this.typeTable_);
        L46:
            if (r1 >= this.versionRequirement_.size()) goto L49;
            r9.writeInt32(31, this.versionRequirement_.get(r1).intValue());
            r1 = r1 + 1;
            goto L46
        L49:
            if ((this.bitField0_ & 256) != 256) goto L51;
            r9.writeMessage(32, this.contract_);
        L51:
            r0.writeUntil(19000, r9);
            r9.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 2) != 2) goto L8;
            int r1 = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
        L10:
            if ((this.bitField0_ & 4) != 4) goto L13;
            r1 = r1 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r1 = r1 + CodedOutputStream.computeMessageSize(3, this.returnType_);
        L15:
            int r4 = 0;
        L17:
            if (r4 >= this.typeParameter_.size()) goto L20;
            r1 = r1 + CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(r4));
            r4 = r4 + 1;
            goto L17
        L20:
            if ((this.bitField0_ & 32) != 32) goto L22;
            r1 = r1 + CodedOutputStream.computeMessageSize(5, this.receiverType_);
        L22:
            int r5 = 0;
        L24:
            if (r5 >= this.valueParameter_.size()) goto L27;
            r1 = r1 + CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(r5));
            r5 = r5 + 1;
            goto L24
        L27:
            if ((this.bitField0_ & 16) != 16) goto L30;
            r1 = r1 + CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
        L30:
            if ((this.bitField0_ & 64) != 64) goto L33;
            r1 = r1 + CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
        L33:
            if ((this.bitField0_ & 1) != 1) goto L35;
            r1 = r1 + CodedOutputStream.computeInt32Size(9, this.flags_);
        L35:
            int r3 = 0;
        L37:
            if (r3 >= this.contextReceiverType_.size()) goto L39;
            r1 = r1 + CodedOutputStream.computeMessageSize(10, this.contextReceiverType_.get(r3));
            r3 = r3 + 1;
            goto L37
        L39:
            int r6 = 0;
            int r7 = 0;
        L41:
            if (r6 >= this.contextReceiverTypeId_.size()) goto L43;
            r7 = r7 + CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(r6).intValue());
            r6 = r6 + 1;
            goto L41
        L43:
            int r8 = r1 + r7;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L46;
            r8 = (r8 + 1) + CodedOutputStream.computeInt32SizeNoTag(r7);
        L46:
            this.contextReceiverTypeIdMemoizedSerializedSize = r7;
            if ((this.bitField0_ & 128) != 128) goto L49;
            r8 = r8 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L49:
            int r9 = 0;
        L51:
            if (r2 >= this.versionRequirement_.size()) goto L53;
            r9 = r9 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r2).intValue());
            r2 = r2 + 1;
            goto L51
        L53:
            int r10 = (r8 + r9) + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 256) != 256) goto L56;
            r10 = r10 + CodedOutputStream.computeMessageSize(32, this.contract_);
        L56:
            int r11 = (r10 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r11;
            return r11;
        L8:
            r1 = 0;
            goto L10
        }

        public static Function parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return PARSER.parseFrom(r1, r2);
        }

        public static Builder newBuilder() {
            return Builder.access$14100();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Function r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface FunctionOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final enum MemberKind extends Enum<MemberKind> implements Internal.EnumLite {
        private static final /* synthetic */ MemberKind[] $VALUES = null;
        public static final MemberKind DECLARATION = null;
        public static final MemberKind DELEGATION = null;
        public static final MemberKind FAKE_OVERRIDE = null;
        public static final MemberKind SYNTHESIZED = null;
        private static Internal.EnumLiteMap<MemberKind> internalValueMap;
        private final int value;

        public static MemberKind valueOf(String r1) {
            return (MemberKind) Enum.valueOf(MemberKind.class, r1);
        }

        public static MemberKind[] values() {
            return (MemberKind[]) $VALUES.clone();
        }

        static {
            MemberKind r0 = new MemberKind("DECLARATION", 0, 0, 0);
            DECLARATION = r0;
            MemberKind r1 = new MemberKind("FAKE_OVERRIDE", 1, 1, 1);
            FAKE_OVERRIDE = r1;
            MemberKind r3 = new MemberKind("DELEGATION", 2, 2, 2);
            DELEGATION = r3;
            MemberKind r5 = new MemberKind("SYNTHESIZED", 3, 3, 3);
            SYNTHESIZED = r5;
            $VALUES = new MemberKind[]{r0, r1, r3, r5};
            internalValueMap = new AnonymousClass1();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return SYNTHESIZED;
        L14:
            return DELEGATION;
        L16:
            return FAKE_OVERRIDE;
        L18:
            return DECLARATION;
        }

        private MemberKind(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.value = r4;
        }
    }

    public static final enum Modality extends Enum<Modality> implements Internal.EnumLite {
        private static final /* synthetic */ Modality[] $VALUES = null;
        public static final Modality ABSTRACT = null;
        public static final Modality FINAL = null;
        public static final Modality OPEN = null;
        public static final Modality SEALED = null;
        private static Internal.EnumLiteMap<Modality> internalValueMap;
        private final int value;

        public static Modality valueOf(String r1) {
            return (Modality) Enum.valueOf(Modality.class, r1);
        }

        public static Modality[] values() {
            return (Modality[]) $VALUES.clone();
        }

        static {
            Modality r0 = new Modality("FINAL", 0, 0, 0);
            FINAL = r0;
            Modality r1 = new Modality("OPEN", 1, 1, 1);
            OPEN = r1;
            Modality r3 = new Modality("ABSTRACT", 2, 2, 2);
            ABSTRACT = r3;
            Modality r5 = new Modality("SEALED", 3, 3, 3);
            SEALED = r5;
            $VALUES = new Modality[]{r0, r1, r3, r5};
            internalValueMap = new AnonymousClass1();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return SEALED;
        L14:
            return ABSTRACT;
        L16:
            return OPEN;
        L18:
            return FINAL;
        }

        private Modality(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.value = r4;
        }
    }

    public static final class Package extends GeneratedMessageLite.ExtendableMessage<Package> implements PackageOrBuilder {
        public static Parser<Package> PARSER;
        private static final Package defaultInstance = null;
        private int bitField0_;
        private List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Property> property_;
        private List<TypeAlias> typeAlias_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private VersionRequirementTable versionRequirementTable_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Package, Builder> implements PackageOrBuilder {
            private int bitField0_;
            private List<Function> function_;
            private List<Property> property_;
            private List<TypeAlias> typeAlias_;
            private TypeTable typeTable_;
            private VersionRequirementTable versionRequirementTable_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$11600() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((Package) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.function_ = Collections.emptyList();
                this.property_ = Collections.emptyList();
                this.typeAlias_ = Collections.emptyList();
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Package build() {
                Package r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public Package buildPartial() {
                Package r0 = new Package(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) != 1) goto L5;
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -2;
            L5:
                Package.access$11802(r0, this.function_);
                if ((this.bitField0_ & 2) != 2) goto L8;
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -3;
            L8:
                Package.access$11902(r0, this.property_);
                if ((this.bitField0_ & 4) != 4) goto L11;
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -5;
            L11:
                Package.access$12002(r0, this.typeAlias_);
                if ((r1 & 8) == 8) goto L15;
                r3 = 0;
            L15:
                Package.access$12102(r0, this.typeTable_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 2;
            L18:
                Package.access$12202(r0, this.versionRequirementTable_);
                Package.access$12302(r0, r3);
                return r0;
            }

            public Builder mergeFrom(Package r3) {
                if (r3 != Package.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Package.access$11800(r3).isEmpty() == true) goto L12;
                if (this.function_.isEmpty() == false) goto L10;
                this.function_ = Package.access$11800(r3);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureFunctionIsMutable();
                this.function_.addAll(Package.access$11800(r3));
            L12:
                if (Package.access$11900(r3).isEmpty() == true) goto L18;
                if (this.property_.isEmpty() == false) goto L16;
                this.property_ = Package.access$11900(r3);
                this.bitField0_ &= -3;
                goto L18
            L16:
                ensurePropertyIsMutable();
                this.property_.addAll(Package.access$11900(r3));
            L18:
                if (Package.access$12000(r3).isEmpty() == true) goto L24;
                if (this.typeAlias_.isEmpty() == false) goto L22;
                this.typeAlias_ = Package.access$12000(r3);
                this.bitField0_ &= -5;
                goto L24
            L22:
                ensureTypeAliasIsMutable();
                this.typeAlias_.addAll(Package.access$12000(r3));
            L24:
                if (r3.hasTypeTable() == false) goto L27;
                mergeTypeTable(r3.getTypeTable());
            L27:
                if (r3.hasVersionRequirementTable() == false) goto L29;
                mergeVersionRequirementTable(r3.getVersionRequirementTable());
            L29:
                mergeExtensionFields(r3);
                setUnknownFields(getUnknownFields().concat(Package.access$12400(r3)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r1 = 0;
            L4:
                if (r1 >= getFunctionCount()) goto L9;
                if (getFunction(r1).isInitialized() == false) goto L7;
                r1 = r1 + 1;
                goto L4
            L7:
                return false;
            L9:
                int r2 = 0;
            L11:
                if (r2 >= getPropertyCount()) goto L16;
                if (getProperty(r2).isInitialized() == false) goto L14;
                r2 = r2 + 1;
                goto L11
            L14:
                return false;
            L16:
                int r3 = 0;
            L18:
                if (r3 >= getTypeAliasCount()) goto L24;
                if (getTypeAlias(r3).isInitialized() == false) goto L21;
                r3 = r3 + 1;
                goto L18
            L21:
                return false;
            L24:
                if (hasTypeTable() == false) goto L29;
                if (getTypeTable().isInitialized() == true) goto L29;
                return false;
            L29:
                if (extensionsAreInitialized() == true) goto L31;
                return false;
            L31:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                Package r0 = null;
                Package r5 = Package.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                Package r6 = (Package) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.function_ = new ArrayList(this.function_);
                this.bitField0_ |= 1;
                return;
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Function getFunction(int r1) {
                return this.function_.get(r1);
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.property_ = new ArrayList(this.property_);
                this.bitField0_ |= 2;
                return;
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public Property getProperty(int r1) {
                return this.property_.get(r1);
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.typeAlias_ = new ArrayList(this.typeAlias_);
                this.bitField0_ |= 4;
                return;
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeAlias getTypeAlias(int r1) {
                return this.typeAlias_.get(r1);
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder mergeTypeTable(TypeTable r4) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.typeTable_ = r4;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable r4) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.versionRequirementTable_ = r4;
            L8:
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) goto L7;
                this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(r4).buildPartial();
                goto L8
            }
        }

        /* synthetic */ Package(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ Package(GeneratedMessageLite.ExtendableBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ List access$11800(Package r0) {
            return r0.function_;
        }

        static /* synthetic */ List access$11802(Package r0, List r1) {
            r0.function_ = r1;
            return r1;
        }

        static /* synthetic */ List access$11900(Package r0) {
            return r0.property_;
        }

        static /* synthetic */ List access$11902(Package r0, List r1) {
            r0.property_ = r1;
            return r1;
        }

        static /* synthetic */ List access$12000(Package r0) {
            return r0.typeAlias_;
        }

        static /* synthetic */ List access$12002(Package r0, List r1) {
            r0.typeAlias_ = r1;
            return r1;
        }

        static /* synthetic */ TypeTable access$12102(Package r0, TypeTable r1) {
            r0.typeTable_ = r1;
            return r1;
        }

        static /* synthetic */ VersionRequirementTable access$12202(Package r0, VersionRequirementTable r1) {
            r0.versionRequirementTable_ = r1;
            return r1;
        }

        static /* synthetic */ int access$12302(Package r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$12400(Package r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private Package(GeneratedMessageLite.ExtendableBuilder<Package, ?> r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private Package(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Package getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Package(CodedInputStream r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            int r4 = 0;
        L4:
            if (r3 == true) goto L73;
            int r7 = r11.readTag();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if (r7 == 0) goto L47;
            if (r7 != 26) goto L10;
            int r8 = (r4 == true ? 1 : 0) & 1;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r4 = r4;
            if (r8 == 1) goto L45;
            this.function_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r4 = (r4 == true ? 1 : 0) | 1;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L45:
            this.function_.add((Function) r11.readMessage(Function.PARSER, r12));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L10:
            if (r7 != 34) goto L12;
            int r9 = (r4 == true ? 1 : 0) & 2;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r4 = r4;
            if (r9 == 2) goto L41;
            this.property_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r4 = (r4 == true ? 1 : 0) | 2;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L41:
            this.property_.add((Property) r11.readMessage(Property.PARSER, r12));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L12:
            if (r7 != 42) goto L13;
            int r10 = (r4 == true ? 1 : 0) & 4;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r4 = r4;
            if (r10 == 4) goto L37;
            this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r4 = (r4 == true ? 1 : 0) | 4;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L37:
            this.typeAlias_.add((TypeAlias) r11.readMessage(TypeAlias.PARSER, r12));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L13:
            VersionRequirementTable.Builder r13 = null;
            TypeTable.Builder r14 = null;
            if (r7 != 242) goto L16;
            if ((this.bitField0_ & 1) != 1) goto L30;
            r14 = this.typeTable_.toBuilder();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L30:
            TypeTable r15 = (TypeTable) r11.readMessage(TypeTable.PARSER, r12);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.typeTable_ = r15;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if (r14 == null) goto L33;
            r14.mergeFrom(r15);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.typeTable_ = r14.buildPartial();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L33:
            this.bitField0_ |= 1;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L16:
            if (r7 != 258) goto L18;
            if ((this.bitField0_ & 2) != 2) goto L23;
            r13 = this.versionRequirementTable_.toBuilder();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L23:
            VersionRequirementTable r16 = (VersionRequirementTable) r11.readMessage(VersionRequirementTable.PARSER, r12);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.versionRequirementTable_ = r16;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if (r13 == null) goto L26;
            r13.mergeFrom(r16);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.versionRequirementTable_ = r13.buildPartial();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L26:
            this.bitField0_ |= 2;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L18:
            if (parseUnknownField(r11, r2, r12, r7) == true) goto L4;
        L47:
            r3 = true;
            goto L4
        L48:
            th = move-exception;
            if (((r4 == true ? 1 : 0) & 1) != 1) goto L60;
            this.function_ = Collections.unmodifiableList(this.function_);
        L60:
            if (((r4 == true ? 1 : 0) & 2) != 2) goto L63;
            this.property_ = Collections.unmodifiableList(this.property_);
        L63:
            if (((r4 == true ? 1 : 0) & 4) != 4) goto L92;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L92:
            r2.flush();     // Catch: IOException -> L89 Throwable -> L67
        L67:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L66:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L53:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L48
        L50:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L48
        L73:
            if (((r4 == true ? 1 : 0) & 1) != 1) goto L76;
            this.function_ = Collections.unmodifiableList(this.function_);
        L76:
            if (((r4 == true ? 1 : 0) & 2) != 2) goto L79;
            this.property_ = Collections.unmodifiableList(this.property_);
        L79:
            if (((r4 == true ? 1 : 0) & 4) != 4) goto L94;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L94:
            r2.flush();     // Catch: IOException -> L88 Throwable -> L83
        L83:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L82:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            Package r0 = new Package(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Package> getParserForType() {
            return PARSER;
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public Function getFunction(int r1) {
            return this.function_.get(r1);
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public Property getProperty(int r1) {
            return this.property_.get(r1);
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public TypeAlias getTypeAlias(int r1) {
            return this.typeAlias_.get(r1);
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public boolean hasVersionRequirementTable() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        private void initFields() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L8;
            return false;
        L8:
            int r1 = 0;
        L10:
            if (r1 >= getFunctionCount()) goto L16;
            if (getFunction(r1).isInitialized() == false) goto L13;
            r1 = r1 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            int r2 = 0;
        L18:
            if (r2 >= getPropertyCount()) goto L24;
            if (getProperty(r2).isInitialized() == false) goto L21;
            r2 = r2 + 1;
            goto L18
        L21:
            this.memoizedIsInitialized = 0;
            return false;
        L24:
            int r3 = 0;
        L26:
            if (r3 >= getTypeAliasCount()) goto L33;
            if (getTypeAlias(r3).isInitialized() == false) goto L29;
            r3 = r3 + 1;
            goto L26
        L29:
            this.memoizedIsInitialized = 0;
            return false;
        L33:
            if (hasTypeTable() == false) goto L39;
            if (getTypeTable().isInitialized() == true) goto L39;
            this.memoizedIsInitialized = 0;
            return false;
        L39:
            if (extensionsAreInitialized() == true) goto L42;
            this.memoizedIsInitialized = 0;
            return false;
        L42:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r6) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r2 >= this.function_.size()) goto L6;
            r6.writeMessage(3, this.function_.get(r2));
            r2 = r2 + 1;
            goto L4
        L6:
            int r3 = 0;
        L8:
            if (r3 >= this.property_.size()) goto L11;
            r6.writeMessage(4, this.property_.get(r3));
            r3 = r3 + 1;
        L11:
            if (r1 >= this.typeAlias_.size()) goto L14;
            r6.writeMessage(5, this.typeAlias_.get(r1));
            r1 = r1 + 1;
            goto L11
        L14:
            if ((this.bitField0_ & 1) != 1) goto L17;
            r6.writeMessage(30, this.typeTable_);
        L17:
            if ((this.bitField0_ & 2) != 2) goto L19;
            r6.writeMessage(32, this.versionRequirementTable_);
        L19:
            r0.writeUntil(200, r6);
            r6.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            int r2 = 0;
            int r3 = 0;
        L7:
            if (r2 >= this.function_.size()) goto L9;
            r3 = r3 + CodedOutputStream.computeMessageSize(3, this.function_.get(r2));
            r2 = r2 + 1;
            goto L7
        L9:
            int r4 = 0;
        L11:
            if (r4 >= this.property_.size()) goto L14;
            r3 = r3 + CodedOutputStream.computeMessageSize(4, this.property_.get(r4));
            r4 = r4 + 1;
        L14:
            if (r1 >= this.typeAlias_.size()) goto L17;
            r3 = r3 + CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(r1));
            r1 = r1 + 1;
            goto L14
        L17:
            if ((this.bitField0_ & 1) != 1) goto L20;
            r3 = r3 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L20:
            if ((this.bitField0_ & 2) != 2) goto L22;
            r3 = r3 + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        L22:
            int r5 = (r3 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r5;
            return r5;
        }

        public static Package parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return PARSER.parseFrom(r1, r2);
        }

        public static Builder newBuilder() {
            return Builder.access$11600();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Package r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class PackageFragment extends GeneratedMessageLite.ExtendableMessage<PackageFragment> implements PackageFragmentOrBuilder {
        public static Parser<PackageFragment> PARSER;
        private static final PackageFragment defaultInstance = null;
        private int bitField0_;
        private List<Class> class__;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Package package_;
        private QualifiedNameTable qualifiedNames_;
        private StringTable strings_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<PackageFragment, Builder> implements PackageFragmentOrBuilder {
            private int bitField0_;
            private List<Class> class__;
            private Package package_;
            private QualifiedNameTable qualifiedNames_;
            private StringTable strings_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$22600() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((PackageFragment) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.strings_ = StringTable.getDefaultInstance();
                this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
                this.package_ = Package.getDefaultInstance();
                this.class__ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public PackageFragment build() {
                PackageFragment r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public PackageFragment buildPartial() {
                PackageFragment r0 = new PackageFragment(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                PackageFragment.access$22802(r0, this.strings_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                PackageFragment.access$22902(r0, this.qualifiedNames_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                PackageFragment.access$23002(r0, this.package_);
                if ((this.bitField0_ & 8) != 8) goto L15;
                this.class__ = Collections.unmodifiableList(this.class__);
                this.bitField0_ &= -9;
            L15:
                PackageFragment.access$23102(r0, this.class__);
                PackageFragment.access$23202(r0, r3);
                return r0;
            }

            public Builder mergeFrom(PackageFragment r3) {
                if (r3 != PackageFragment.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasStrings() == false) goto L9;
                mergeStrings(r3.getStrings());
            L9:
                if (r3.hasQualifiedNames() == false) goto L12;
                mergeQualifiedNames(r3.getQualifiedNames());
            L12:
                if (r3.hasPackage() == false) goto L15;
                mergePackage(r3.getPackage());
            L15:
                if (PackageFragment.access$23100(r3).isEmpty() == false) goto L17;
            L20:
                mergeExtensionFields(r3);
                setUnknownFields(getUnknownFields().concat(PackageFragment.access$23300(r3)));
                return this;
            L17:
                if (this.class__.isEmpty() == false) goto L19;
                this.class__ = PackageFragment.access$23100(r3);
                this.bitField0_ &= -9;
                goto L20
            L19:
                ensureClass_IsMutable();
                this.class__.addAll(PackageFragment.access$23100(r3));
                goto L20
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasQualifiedNames() == false) goto L8;
                if (getQualifiedNames().isInitialized() == true) goto L8;
                return false;
            L8:
                if (hasPackage() == true) goto L10;
            L12:
                int r0 = 0;
            L14:
                if (r0 >= getClass_Count()) goto L20;
                if (getClass_(r0).isInitialized() == false) goto L17;
                r0 = r0 + 1;
                goto L14
            L17:
                return false;
            L20:
                if (extensionsAreInitialized() == true) goto L22;
                return false;
            L22:
                return true;
            L10:
                if (getPackage().isInitialized() == true) goto L12;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                PackageFragment r0 = null;
                PackageFragment r5 = PackageFragment.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                PackageFragment r6 = (PackageFragment) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public Builder mergeStrings(StringTable r4) {
                if ((this.bitField0_ & 1) == 1) goto L5;
            L7:
                this.strings_ = r4;
            L8:
                this.bitField0_ |= 1;
                return this;
            L5:
                if (this.strings_ == StringTable.getDefaultInstance()) goto L7;
                this.strings_ = StringTable.newBuilder(this.strings_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public boolean hasQualifiedNames() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public QualifiedNameTable getQualifiedNames() {
                return this.qualifiedNames_;
            }

            public Builder mergeQualifiedNames(QualifiedNameTable r4) {
                if ((this.bitField0_ & 2) == 2) goto L5;
            L7:
                this.qualifiedNames_ = r4;
            L8:
                this.bitField0_ |= 2;
                return this;
            L5:
                if (this.qualifiedNames_ == QualifiedNameTable.getDefaultInstance()) goto L7;
                this.qualifiedNames_ = QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public boolean hasPackage() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public Package getPackage() {
                return this.package_;
            }

            public Builder mergePackage(Package r4) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.package_ = r4;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.package_ == Package.getDefaultInstance()) goto L7;
                this.package_ = Package.newBuilder(this.package_).mergeFrom(r4).buildPartial();
                goto L8
            }

            private void ensureClass_IsMutable() {
                if ((this.bitField0_ & 8) == 8) goto L6;
                this.class__ = new ArrayList(this.class__);
                this.bitField0_ |= 8;
                return;
            }

            public int getClass_Count() {
                return this.class__.size();
            }

            public Class getClass_(int r1) {
                return this.class__.get(r1);
            }
        }

        /* synthetic */ PackageFragment(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ PackageFragment(GeneratedMessageLite.ExtendableBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ StringTable access$22802(PackageFragment r0, StringTable r1) {
            r0.strings_ = r1;
            return r1;
        }

        static /* synthetic */ QualifiedNameTable access$22902(PackageFragment r0, QualifiedNameTable r1) {
            r0.qualifiedNames_ = r1;
            return r1;
        }

        static /* synthetic */ Package access$23002(PackageFragment r0, Package r1) {
            r0.package_ = r1;
            return r1;
        }

        static /* synthetic */ List access$23100(PackageFragment r0) {
            return r0.class__;
        }

        static /* synthetic */ List access$23102(PackageFragment r0, List r1) {
            r0.class__ = r1;
            return r1;
        }

        static /* synthetic */ int access$23202(PackageFragment r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$23300(PackageFragment r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private PackageFragment(GeneratedMessageLite.ExtendableBuilder<PackageFragment, ?> r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private PackageFragment(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static PackageFragment getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public PackageFragment getDefaultInstanceForType() {
            return defaultInstance;
        }

        private PackageFragment(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            int r4 = 0;
        L4:
            if (r3 == true) goto L64;
            int r6 = r10.readTag();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            if (r6 == 0) goto L44;
            Package.Builder r8 = null;
            StringTable.Builder r9 = null;
            QualifiedNameTable.Builder r12 = null;
            if (r6 != 10) goto L10;
            if ((this.bitField0_ & 1) != 1) goto L39;
            r9 = this.strings_.toBuilder();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L39:
            StringTable r7 = (StringTable) r10.readMessage(StringTable.PARSER, r11);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.strings_ = r7;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            if (r9 == null) goto L42;
            r9.mergeFrom(r7);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.strings_ = r9.buildPartial();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L42:
            this.bitField0_ |= 1;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            goto L4
        L10:
            if (r6 != 18) goto L12;
            if ((this.bitField0_ & 2) != 2) goto L32;
            r12 = this.qualifiedNames_.toBuilder();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L32:
            QualifiedNameTable r13 = (QualifiedNameTable) r10.readMessage(QualifiedNameTable.PARSER, r11);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.qualifiedNames_ = r13;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            if (r12 == null) goto L35;
            r12.mergeFrom(r13);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.qualifiedNames_ = r12.buildPartial();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L35:
            this.bitField0_ |= 2;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            goto L4
        L12:
            if (r6 != 26) goto L14;
            if ((this.bitField0_ & 4) != 4) goto L25;
            r8 = this.package_.toBuilder();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L25:
            Package r14 = (Package) r10.readMessage(Package.PARSER, r11);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.package_ = r14;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            if (r8 == null) goto L28;
            r8.mergeFrom(r14);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.package_ = r8.buildPartial();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L28:
            this.bitField0_ |= 4;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            goto L4
        L14:
            if (r6 != 34) goto L16;
            int r15 = (r4 == true ? 1 : 0) & 8;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            r4 = r4;
            if (r15 == 8) goto L21;
            this.class__ = new ArrayList();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            r4 = (r4 == true ? 1 : 0) | 8;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L21:
            this.class__.add((Class) r10.readMessage(Class.PARSER, r11));     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            goto L4
        L16:
            if (parseUnknownField(r10, r2, r11, r6) == true) goto L4;
        L44:
            r3 = true;
            goto L4
        L45:
            th = move-exception;
            if (((r4 == true ? 1 : 0) & 8) != 8) goto L79;
            this.class__ = Collections.unmodifiableList(this.class__);
        L79:
            r2.flush();     // Catch: IOException -> L74 Throwable -> L58
        L58:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L57:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L47:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L45
        L50:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L45
        L64:
            if (((r4 == true ? 1 : 0) & 8) != 8) goto L77;
            this.class__ = Collections.unmodifiableList(this.class__);
        L77:
            r2.flush();     // Catch: IOException -> L73 Throwable -> L68
        L68:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L67:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            PackageFragment r0 = new PackageFragment(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<PackageFragment> getParserForType() {
            return PARSER;
        }

        public boolean hasStrings() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public StringTable getStrings() {
            return this.strings_;
        }

        public boolean hasQualifiedNames() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        public boolean hasPackage() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public Package getPackage() {
            return this.package_;
        }

        public List<Class> getClass_List() {
            return this.class__;
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public Class getClass_(int r1) {
            return this.class__.get(r1);
        }

        private void initFields() {
            this.strings_ = StringTable.getDefaultInstance();
            this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            this.package_ = Package.getDefaultInstance();
            this.class__ = Collections.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (hasQualifiedNames() == false) goto L15;
            if (getQualifiedNames().isInitialized() == true) goto L15;
            this.memoizedIsInitialized = 0;
            return false;
        L15:
            if (hasPackage() == true) goto L17;
        L20:
            int r1 = 0;
        L22:
            if (r1 >= getClass_Count()) goto L29;
            if (getClass_(r1).isInitialized() == false) goto L25;
            r1 = r1 + 1;
            goto L22
        L25:
            this.memoizedIsInitialized = 0;
            return false;
        L29:
            if (extensionsAreInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        L32:
            this.memoizedIsInitialized = 1;
            return true;
        L17:
            if (getPackage().isInitialized() == true) goto L20;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.writeMessage(1, this.strings_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r5.writeMessage(2, this.qualifiedNames_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L11;
            r5.writeMessage(3, this.package_);
        L11:
            int r1 = 0;
        L13:
            if (r1 >= this.class__.size()) goto L15;
            r5.writeMessage(4, this.class__.get(r1));
            r1 = r1 + 1;
            goto L13
        L15:
            r0.writeUntil(200, r5);
            r5.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = CodedOutputStream.computeMessageSize(1, this.strings_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r1 = r1 + CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r1 = r1 + CodedOutputStream.computeMessageSize(3, this.package_);
        L16:
            if (r2 >= this.class__.size()) goto L18;
            r1 = r1 + CodedOutputStream.computeMessageSize(4, this.class__.get(r2));
            r2 = r2 + 1;
            goto L16
        L18:
            int r3 = (r1 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        L8:
            r1 = 0;
            goto L10
        }

        public static PackageFragment parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return PARSER.parseFrom(r1, r2);
        }

        public static Builder newBuilder() {
            return Builder.access$22600();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(PackageFragment r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface PackageFragmentOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface PackageOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Property extends GeneratedMessageLite.ExtendableMessage<Property> implements PropertyOrBuilder {
        public static Parser<Property> PARSER;
        private static final Property defaultInstance = null;
        private int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private int flags_;
        private int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private int setterFlags_;
        private ValueParameter setterValueParameter_;
        private List<TypeParameter> typeParameter_;
        private final ByteString unknownFields;
        private List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Property, Builder> implements PropertyOrBuilder {
            private int bitField0_;
            private List<Integer> contextReceiverTypeId_;
            private List<Type> contextReceiverType_;
            private int flags_;
            private int getterFlags_;
            private int name_;
            private int oldFlags_;
            private int receiverTypeId_;
            private Type receiverType_;
            private int returnTypeId_;
            private Type returnType_;
            private int setterFlags_;
            private ValueParameter setterValueParameter_;
            private List<TypeParameter> typeParameter_;
            private List<Integer> versionRequirement_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$16000() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((Property) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.flags_ = 518;
                this.oldFlags_ = 2054;
                this.returnType_ = Type.getDefaultInstance();
                this.typeParameter_ = Collections.emptyList();
                this.receiverType_ = Type.getDefaultInstance();
                this.contextReceiverType_ = Collections.emptyList();
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.setterValueParameter_ = ValueParameter.getDefaultInstance();
                this.versionRequirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Property build() {
                Property r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public Property buildPartial() {
                Property r0 = new Property(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                Property.access$16202(r0, this.flags_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                Property.access$16302(r0, this.oldFlags_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                Property.access$16402(r0, this.name_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                Property.access$16502(r0, this.returnType_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                Property.access$16602(r0, this.returnTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            L21:
                Property.access$16702(r0, this.typeParameter_);
                if ((r1 & 64) != 64) goto L24;
                r3 = r3 | 32;
            L24:
                Property.access$16802(r0, this.receiverType_);
                if ((r1 & 128) != 128) goto L27;
                r3 = r3 | 64;
            L27:
                Property.access$16902(r0, this.receiverTypeId_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            L30:
                Property.access$17002(r0, this.contextReceiverType_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            L33:
                Property.access$17102(r0, this.contextReceiverTypeId_);
                if ((r1 & 1024) != 1024) goto L36;
                r3 = r3 | 128;
            L36:
                Property.access$17202(r0, this.setterValueParameter_);
                if ((r1 & 2048) != 2048) goto L39;
                r3 = r3 | 256;
            L39:
                Property.access$17302(r0, this.getterFlags_);
                if ((r1 & 4096) != 4096) goto L42;
                r3 = r3 | 512;
            L42:
                Property.access$17402(r0, this.setterFlags_);
                if ((this.bitField0_ & 8192) != 8192) goto L45;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -8193;
            L45:
                Property.access$17502(r0, this.versionRequirement_);
                Property.access$17602(r0, r3);
                return r0;
            }

            public Builder mergeFrom(Property r3) {
                if (r3 != Property.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasFlags() == false) goto L9;
                setFlags(r3.getFlags());
            L9:
                if (r3.hasOldFlags() == false) goto L12;
                setOldFlags(r3.getOldFlags());
            L12:
                if (r3.hasName() == false) goto L15;
                setName(r3.getName());
            L15:
                if (r3.hasReturnType() == false) goto L18;
                mergeReturnType(r3.getReturnType());
            L18:
                if (r3.hasReturnTypeId() == false) goto L21;
                setReturnTypeId(r3.getReturnTypeId());
            L21:
                if (Property.access$16700(r3).isEmpty() == true) goto L27;
                if (this.typeParameter_.isEmpty() == false) goto L25;
                this.typeParameter_ = Property.access$16700(r3);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Property.access$16700(r3));
            L27:
                if (r3.hasReceiverType() == false) goto L30;
                mergeReceiverType(r3.getReceiverType());
            L30:
                if (r3.hasReceiverTypeId() == false) goto L33;
                setReceiverTypeId(r3.getReceiverTypeId());
            L33:
                if (Property.access$17000(r3).isEmpty() == true) goto L39;
                if (this.contextReceiverType_.isEmpty() == false) goto L37;
                this.contextReceiverType_ = Property.access$17000(r3);
                this.bitField0_ &= -257;
                goto L39
            L37:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Property.access$17000(r3));
            L39:
                if (Property.access$17100(r3).isEmpty() == true) goto L45;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L43;
                this.contextReceiverTypeId_ = Property.access$17100(r3);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
                goto L45
            L43:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Property.access$17100(r3));
            L45:
                if (r3.hasSetterValueParameter() == false) goto L48;
                mergeSetterValueParameter(r3.getSetterValueParameter());
            L48:
                if (r3.hasGetterFlags() == false) goto L51;
                setGetterFlags(r3.getGetterFlags());
            L51:
                if (r3.hasSetterFlags() == false) goto L54;
                setSetterFlags(r3.getSetterFlags());
            L54:
                if (Property.access$17500(r3).isEmpty() == false) goto L56;
            L59:
                mergeExtensionFields(r3);
                setUnknownFields(getUnknownFields().concat(Property.access$17700(r3)));
                return this;
            L56:
                if (this.versionRequirement_.isEmpty() == false) goto L58;
                this.versionRequirement_ = Property.access$17500(r3);
                this.bitField0_ &= -8193;
                goto L59
            L58:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Property.access$17500(r3));
                goto L59
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L6;
                return false;
            L6:
                if (hasReturnType() == true) goto L8;
            L10:
                int r0 = 0;
            L12:
                if (r0 >= getTypeParameterCount()) goto L18;
                if (getTypeParameter(r0).isInitialized() == false) goto L15;
                r0 = r0 + 1;
                goto L12
            L15:
                return false;
            L18:
                if (hasReceiverType() == true) goto L20;
            L22:
                int r1 = 0;
            L24:
                if (r1 >= getContextReceiverTypeCount()) goto L30;
                if (getContextReceiverType(r1).isInitialized() == false) goto L27;
                r1 = r1 + 1;
                goto L24
            L27:
                return false;
            L30:
                if (hasSetterValueParameter() == false) goto L35;
                if (getSetterValueParameter().isInitialized() == true) goto L35;
                return false;
            L35:
                if (extensionsAreInitialized() == true) goto L37;
                return false;
            L37:
                return true;
            L20:
                if (getReceiverType().isInitialized() == true) goto L22;
                return false;
            L8:
                if (getReturnType().isInitialized() == true) goto L10;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                Property r0 = null;
                Property r5 = Property.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                Property r6 = (Property) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public Builder setFlags(int r2) {
                this.bitField0_ |= 1;
                this.flags_ = r2;
                return this;
            }

            public Builder setOldFlags(int r2) {
                this.bitField0_ |= 2;
                this.oldFlags_ = r2;
                return this;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public Builder setName(int r2) {
                this.bitField0_ |= 4;
                this.name_ = r2;
                return this;
            }

            public boolean hasReturnType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public Builder mergeReturnType(Type r4) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.returnType_ = r4;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.returnType_ == Type.getDefaultInstance()) goto L7;
                this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setReturnTypeId(int r2) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = r2;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 32;
                return;
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int r1) {
                return this.typeParameter_.get(r1);
            }

            public boolean hasReceiverType() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Builder mergeReceiverType(Type r4) {
                if ((this.bitField0_ & 64) == 64) goto L5;
            L7:
                this.receiverType_ = r4;
            L8:
                this.bitField0_ |= 64;
                return this;
            L5:
                if (this.receiverType_ == Type.getDefaultInstance()) goto L7;
                this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setReceiverTypeId(int r2) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = r2;
                return this;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 256;
                return;
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Type getContextReceiverType(int r1) {
                return this.contextReceiverType_.get(r1);
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) == 512) goto L6;
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 512;
                return;
            }

            public boolean hasSetterValueParameter() {
                if ((this.bitField0_ & 1024) != 1024) goto L5;
                return true;
            L5:
                return false;
            }

            public ValueParameter getSetterValueParameter() {
                return this.setterValueParameter_;
            }

            public Builder mergeSetterValueParameter(ValueParameter r4) {
                if ((this.bitField0_ & 1024) == 1024) goto L5;
            L7:
                this.setterValueParameter_ = r4;
            L8:
                this.bitField0_ |= 1024;
                return this;
            L5:
                if (this.setterValueParameter_ == ValueParameter.getDefaultInstance()) goto L7;
                this.setterValueParameter_ = ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setGetterFlags(int r2) {
                this.bitField0_ |= 2048;
                this.getterFlags_ = r2;
                return this;
            }

            public Builder setSetterFlags(int r2) {
                this.bitField0_ |= 4096;
                this.setterFlags_ = r2;
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 8192) == 8192) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 8192;
                return;
            }
        }

        /* synthetic */ Property(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ Property(GeneratedMessageLite.ExtendableBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$16202(Property r0, int r1) {
            r0.flags_ = r1;
            return r1;
        }

        static /* synthetic */ int access$16302(Property r0, int r1) {
            r0.oldFlags_ = r1;
            return r1;
        }

        static /* synthetic */ int access$16402(Property r0, int r1) {
            r0.name_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$16502(Property r0, Type r1) {
            r0.returnType_ = r1;
            return r1;
        }

        static /* synthetic */ int access$16602(Property r0, int r1) {
            r0.returnTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ List access$16700(Property r0) {
            return r0.typeParameter_;
        }

        static /* synthetic */ List access$16702(Property r0, List r1) {
            r0.typeParameter_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$16802(Property r0, Type r1) {
            r0.receiverType_ = r1;
            return r1;
        }

        static /* synthetic */ int access$16902(Property r0, int r1) {
            r0.receiverTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ List access$17000(Property r0) {
            return r0.contextReceiverType_;
        }

        static /* synthetic */ List access$17002(Property r0, List r1) {
            r0.contextReceiverType_ = r1;
            return r1;
        }

        static /* synthetic */ List access$17100(Property r0) {
            return r0.contextReceiverTypeId_;
        }

        static /* synthetic */ List access$17102(Property r0, List r1) {
            r0.contextReceiverTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ ValueParameter access$17202(Property r0, ValueParameter r1) {
            r0.setterValueParameter_ = r1;
            return r1;
        }

        static /* synthetic */ int access$17302(Property r0, int r1) {
            r0.getterFlags_ = r1;
            return r1;
        }

        static /* synthetic */ int access$17402(Property r0, int r1) {
            r0.setterFlags_ = r1;
            return r1;
        }

        static /* synthetic */ List access$17500(Property r0) {
            return r0.versionRequirement_;
        }

        static /* synthetic */ List access$17502(Property r0, List r1) {
            r0.versionRequirement_ = r1;
            return r1;
        }

        static /* synthetic */ int access$17602(Property r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$17700(Property r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private Property(GeneratedMessageLite.ExtendableBuilder<Property, ?> r2) {
            super(r2);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private Property(boolean r1) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Property getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Property(CodedInputStream r13, ExtensionRegistryLite r14) throws InvalidProtocolBufferException {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            int r4 = 0;
        L4:
            if (r3 == true) goto L102;
            int r9 = r13.readTag();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            Type.Builder r10 = null;
            ValueParameter.Builder r11 = null;
            Type.Builder r12 = null;
            switch(r9) {
                case 0: goto L71;
                case 8: goto L69;
                case 16: goto L68;
                case 26: goto L62;
                case 34: goto L57;
                case 42: goto L51;
                case 50: goto L44;
                case 56: goto L42;
                case 64: goto L41;
                case 72: goto L40;
                case 80: goto L39;
                case 88: goto L38;
                case 98: goto L34;
                case 104: goto L30;
                case 106: goto L21;
                case 248: goto L17;
                case 250: goto L8;
                default: goto L72;
            };     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L8:
            int r15 = r13.pushLimit(r13.readRawVarint32());     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            int r16 = (r4 == true ? 1 : 0) & 8192;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = r4;
            if (r16 == 8192) goto L14;
            r4 = r4;
            if (r13.getBytesUntilLimit() <= 0) goto L14;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = (r4 == true ? 1 : 0) | 8192;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L14:
            if (r13.getBytesUntilLimit() <= 0) goto L16;
            this.versionRequirement_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L14
        L16:
            r13.popLimit(r15);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L17:
            int r17 = (r4 == true ? 1 : 0) & 8192;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = r4;
            if (r17 == 8192) goto L20;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = (r4 == true ? 1 : 0) | 8192;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L20:
            this.versionRequirement_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L21:
            int r18 = r13.pushLimit(r13.readRawVarint32());     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            int r19 = (r4 == true ? 1 : 0) & 512;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = r4;
            if (r19 == 512) goto L27;
            r4 = r4;
            if (r13.getBytesUntilLimit() <= 0) goto L27;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = (r4 == true ? 1 : 0) | 512;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L27:
            if (r13.getBytesUntilLimit() <= 0) goto L29;
            this.contextReceiverTypeId_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L27
        L29:
            r13.popLimit(r18);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L30:
            int r20 = (r4 == true ? 1 : 0) & 512;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = r4;
            if (r20 == 512) goto L33;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = (r4 == true ? 1 : 0) | 512;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L33:
            this.contextReceiverTypeId_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L34:
            int r21 = (r4 == true ? 1 : 0) & 256;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = r4;
            if (r21 == 256) goto L37;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = (r4 == true ? 1 : 0) | 256;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L37:
            this.contextReceiverType_.add((Type) r13.readMessage(Type.PARSER, r14));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L38:
            this.bitField0_ |= 1;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.flags_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L39:
            this.bitField0_ |= 64;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.receiverTypeId_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L40:
            this.bitField0_ |= 16;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.returnTypeId_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L41:
            this.bitField0_ |= 512;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.setterFlags_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L42:
            this.bitField0_ |= 256;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.getterFlags_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L44:
            if ((this.bitField0_ & 128) != 128) goto L46;
            r11 = this.setterValueParameter_.toBuilder();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L46:
            ValueParameter r22 = (ValueParameter) r13.readMessage(ValueParameter.PARSER, r14);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.setterValueParameter_ = r22;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            if (r11 == null) goto L49;
            r11.mergeFrom(r22);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.setterValueParameter_ = r11.buildPartial();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L49:
            this.bitField0_ |= 128;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L51:
            if ((this.bitField0_ & 32) != 32) goto L53;
            r12 = this.receiverType_.toBuilder();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L53:
            Type r23 = (Type) r13.readMessage(Type.PARSER, r14);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.receiverType_ = r23;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            if (r12 == null) goto L56;
            r12.mergeFrom(r23);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.receiverType_ = r12.buildPartial();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L56:
            this.bitField0_ |= 32;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L57:
            int r24 = (r4 == true ? 1 : 0) & 32;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = r4;
            if (r24 == 32) goto L60;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r4 = (r4 == true ? 1 : 0) | 32;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L60:
            this.typeParameter_.add((TypeParameter) r13.readMessage(TypeParameter.PARSER, r14));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L62:
            if ((this.bitField0_ & 8) != 8) goto L64;
            r10 = this.returnType_.toBuilder();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L64:
            Type r25 = (Type) r13.readMessage(Type.PARSER, r14);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.returnType_ = r25;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            if (r10 == null) goto L67;
            r10.mergeFrom(r25);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.returnType_ = r10.buildPartial();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L67:
            this.bitField0_ |= 8;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L68:
            this.bitField0_ |= 4;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.name_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L69:
            this.bitField0_ |= 2;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.oldFlags_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L71:
            r3 = true;
            goto L4
        L72:
            if (parseUnknownField(r13, r2, r14, r9) == true) goto L4;
        L74:
            th = move-exception;
            if (((r4 == true ? 1 : 0) & 32) != 32) goto L86;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L86:
            if (((r4 == true ? 1 : 0) & 256) != 256) goto L89;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L89:
            if (((r4 == true ? 1 : 0) & 512) != 512) goto L92;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L92:
            if (((r4 == true ? 1 : 0) & 8192) != 8192) goto L124;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L124:
            r2.flush();     // Catch: IOException -> L121 Throwable -> L96
        L96:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L95:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L79:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L74
        L76:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L74
        L102:
            if (((r4 == true ? 1 : 0) & 32) != 32) goto L105;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L105:
            if (((r4 == true ? 1 : 0) & 256) != 256) goto L108;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L108:
            if (((r4 == true ? 1 : 0) & 512) != 512) goto L111;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L111:
            if (((r4 == true ? 1 : 0) & 8192) != 8192) goto L126;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L126:
            r2.flush();     // Catch: IOException -> L120 Throwable -> L115
        L115:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L114:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            Property r0 = new Property(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Property> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasOldFlags() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasReturnType() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public boolean hasReturnTypeId() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int r1) {
            return this.typeParameter_.get(r1);
        }

        public boolean hasReceiverType() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public boolean hasReceiverTypeId() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public Type getContextReceiverType(int r1) {
            return this.contextReceiverType_.get(r1);
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public boolean hasSetterValueParameter() {
            if ((this.bitField0_ & 128) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public boolean hasGetterFlags() {
            if ((this.bitField0_ & 256) != 256) goto L5;
            return true;
        L5:
            return false;
        }

        public int getGetterFlags() {
            return this.getterFlags_;
        }

        public boolean hasSetterFlags() {
            if ((this.bitField0_ & 512) != 512) goto L5;
            return true;
        L5:
            return false;
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        private void initFields() {
            this.flags_ = 518;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasReturnType() == true) goto L15;
        L18:
            int r1 = 0;
        L20:
            if (r1 >= getTypeParameterCount()) goto L27;
            if (getTypeParameter(r1).isInitialized() == false) goto L23;
            r1 = r1 + 1;
            goto L20
        L23:
            this.memoizedIsInitialized = 0;
            return false;
        L27:
            if (hasReceiverType() == true) goto L29;
        L32:
            int r2 = 0;
        L34:
            if (r2 >= getContextReceiverTypeCount()) goto L41;
            if (getContextReceiverType(r2).isInitialized() == false) goto L37;
            r2 = r2 + 1;
            goto L34
        L37:
            this.memoizedIsInitialized = 0;
            return false;
        L41:
            if (hasSetterValueParameter() == false) goto L47;
            if (getSetterValueParameter().isInitialized() == true) goto L47;
            this.memoizedIsInitialized = 0;
            return false;
        L47:
            if (extensionsAreInitialized() == true) goto L50;
            this.memoizedIsInitialized = 0;
            return false;
        L50:
            this.memoizedIsInitialized = 1;
            return true;
        L29:
            if (getReceiverType().isInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        L15:
            if (getReturnType().isInitialized() == true) goto L18;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
            if ((this.bitField0_ & 2) != 2) goto L6;
            r8.writeInt32(1, this.oldFlags_);
        L6:
            if ((this.bitField0_ & 4) != 4) goto L9;
            r8.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 8) != 8) goto L11;
            r8.writeMessage(3, this.returnType_);
        L11:
            int r1 = 0;
            int r5 = 0;
        L13:
            if (r5 >= this.typeParameter_.size()) goto L16;
            r8.writeMessage(4, this.typeParameter_.get(r5));
            r5 = r5 + 1;
            goto L13
        L16:
            if ((this.bitField0_ & 32) != 32) goto L19;
            r8.writeMessage(5, this.receiverType_);
        L19:
            if ((this.bitField0_ & 128) != 128) goto L22;
            r8.writeMessage(6, this.setterValueParameter_);
        L22:
            if ((this.bitField0_ & 256) != 256) goto L25;
            r8.writeInt32(7, this.getterFlags_);
        L25:
            if ((this.bitField0_ & 512) != 512) goto L28;
            r8.writeInt32(8, this.setterFlags_);
        L28:
            if ((this.bitField0_ & 16) != 16) goto L31;
            r8.writeInt32(9, this.returnTypeId_);
        L31:
            if ((this.bitField0_ & 64) != 64) goto L34;
            r8.writeInt32(10, this.receiverTypeId_);
        L34:
            if ((this.bitField0_ & 1) != 1) goto L36;
            r8.writeInt32(11, this.flags_);
        L36:
            int r2 = 0;
        L38:
            if (r2 >= this.contextReceiverType_.size()) goto L41;
            r8.writeMessage(12, this.contextReceiverType_.get(r2));
            r2 = r2 + 1;
            goto L38
        L41:
            if (getContextReceiverTypeIdList().size() <= 0) goto L43;
            r8.writeRawVarint32(106);
            r8.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L43:
            int r3 = 0;
        L45:
            if (r3 >= this.contextReceiverTypeId_.size()) goto L48;
            r8.writeInt32NoTag(this.contextReceiverTypeId_.get(r3).intValue());
            r3 = r3 + 1;
        L48:
            if (r1 >= this.versionRequirement_.size()) goto L50;
            r8.writeInt32(31, this.versionRequirement_.get(r1).intValue());
            r1 = r1 + 1;
            goto L48
        L50:
            r0.writeUntil(19000, r8);
            r8.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 2) != 2) goto L8;
            int r1 = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
        L10:
            if ((this.bitField0_ & 4) != 4) goto L13;
            r1 = r1 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r1 = r1 + CodedOutputStream.computeMessageSize(3, this.returnType_);
        L15:
            int r4 = 0;
        L17:
            if (r4 >= this.typeParameter_.size()) goto L20;
            r1 = r1 + CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(r4));
            r4 = r4 + 1;
            goto L17
        L20:
            if ((this.bitField0_ & 32) != 32) goto L23;
            r1 = r1 + CodedOutputStream.computeMessageSize(5, this.receiverType_);
        L23:
            if ((this.bitField0_ & 128) != 128) goto L26;
            r1 = r1 + CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
        L26:
            if ((this.bitField0_ & 256) != 256) goto L29;
            r1 = r1 + CodedOutputStream.computeInt32Size(7, this.getterFlags_);
        L29:
            if ((this.bitField0_ & 512) != 512) goto L32;
            r1 = r1 + CodedOutputStream.computeInt32Size(8, this.setterFlags_);
        L32:
            if ((this.bitField0_ & 16) != 16) goto L35;
            r1 = r1 + CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
        L35:
            if ((this.bitField0_ & 64) != 64) goto L38;
            r1 = r1 + CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
        L38:
            if ((this.bitField0_ & 1) != 1) goto L40;
            r1 = r1 + CodedOutputStream.computeInt32Size(11, this.flags_);
        L40:
            int r3 = 0;
        L42:
            if (r3 >= this.contextReceiverType_.size()) goto L44;
            r1 = r1 + CodedOutputStream.computeMessageSize(12, this.contextReceiverType_.get(r3));
            r3 = r3 + 1;
            goto L42
        L44:
            int r5 = 0;
            int r6 = 0;
        L46:
            if (r5 >= this.contextReceiverTypeId_.size()) goto L48;
            r6 = r6 + CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(r5).intValue());
            r5 = r5 + 1;
            goto L46
        L48:
            int r7 = r1 + r6;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L51;
            r7 = (r7 + 1) + CodedOutputStream.computeInt32SizeNoTag(r6);
        L51:
            this.contextReceiverTypeIdMemoizedSerializedSize = r6;
            int r8 = 0;
        L53:
            if (r2 >= this.versionRequirement_.size()) goto L55;
            r8 = r8 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r2).intValue());
            r2 = r2 + 1;
            goto L53
        L55:
            int r9 = (((r7 + r8) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r9;
            return r9;
        L8:
            r1 = 0;
            goto L10
        }

        public static Builder newBuilder() {
            return Builder.access$16000();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Property r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface PropertyOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class QualifiedNameTable extends GeneratedMessageLite implements QualifiedNameTableOrBuilder {
        public static Parser<QualifiedNameTable> PARSER;
        private static final QualifiedNameTable defaultInstance = null;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<QualifiedName> qualifiedName_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<QualifiedNameTable, Builder> implements QualifiedNameTableOrBuilder {
            private int bitField0_;
            private List<QualifiedName> qualifiedName_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$1400() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((QualifiedNameTable) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.qualifiedName_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public QualifiedNameTable build() {
                QualifiedNameTable r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public QualifiedNameTable buildPartial() {
                QualifiedNameTable r0 = new QualifiedNameTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                this.bitField0_ &= -2;
            L5:
                QualifiedNameTable.access$1602(r0, this.qualifiedName_);
                return r0;
            }

            public Builder mergeFrom(QualifiedNameTable r3) {
                if (r3 != QualifiedNameTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (QualifiedNameTable.access$1600(r3).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(QualifiedNameTable.access$1700(r3)));
                return this;
            L8:
                if (this.qualifiedName_.isEmpty() == false) goto L10;
                this.qualifiedName_ = QualifiedNameTable.access$1600(r3);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureQualifiedNameIsMutable();
                this.qualifiedName_.addAll(QualifiedNameTable.access$1600(r3));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r1 = 0;
            L4:
                if (r1 >= getQualifiedNameCount()) goto L9;
                if (getQualifiedName(r1).isInitialized() == false) goto L7;
                r1 = r1 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                QualifiedNameTable r0 = null;
                QualifiedNameTable r5 = QualifiedNameTable.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                QualifiedNameTable r6 = (QualifiedNameTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            private void ensureQualifiedNameIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.qualifiedName_ = new ArrayList(this.qualifiedName_);
                this.bitField0_ |= 1;
                return;
            }

            public int getQualifiedNameCount() {
                return this.qualifiedName_.size();
            }

            public QualifiedName getQualifiedName(int r1) {
                return this.qualifiedName_.get(r1);
            }
        }

        public static final class QualifiedName extends GeneratedMessageLite implements QualifiedNameOrBuilder {
            public static Parser<QualifiedName> PARSER;
            private static final QualifiedName defaultInstance = null;
            private int bitField0_;
            private Kind kind_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int parentQualifiedName_;
            private int shortName_;
            private final ByteString unknownFields;

            public static final class Builder extends GeneratedMessageLite.Builder<QualifiedName, Builder> implements QualifiedNameOrBuilder {
                private int bitField0_;
                private Kind kind_;
                private int parentQualifiedName_;
                private int shortName_;

                private void maybeForceBuilderInitialization() {
                }

                static /* synthetic */ Builder access$700() {
                    return create();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                    return mergeFrom(r1, r2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                    return mergeFrom((QualifiedName) r1);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                    return mergeFrom(r1, r2);
                }

                private Builder() {
                    this.parentQualifiedName_ = -1;
                    this.kind_ = Kind.PACKAGE;
                    maybeForceBuilderInitialization();
                }

                private static Builder create() {
                    return new Builder();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public QualifiedName build() {
                    QualifiedName r1 = buildPartial();
                    if (r1.isInitialized() == false) goto L6;
                    return r1;
                L6:
                    throw newUninitializedMessageException(r1);
                }

                public QualifiedName buildPartial() {
                    QualifiedName r0 = new QualifiedName(this, null);
                    int r1 = this.bitField0_;
                    int r3 = 1;
                    if ((r1 & 1) == 1) goto L6;
                    r3 = 0;
                L6:
                    QualifiedName.access$902(r0, this.parentQualifiedName_);
                    if ((r1 & 2) != 2) goto L9;
                    r3 = r3 | 2;
                L9:
                    QualifiedName.access$1002(r0, this.shortName_);
                    if ((r1 & 4) != 4) goto L12;
                    r3 = r3 | 4;
                L12:
                    QualifiedName.access$1102(r0, this.kind_);
                    QualifiedName.access$1202(r0, r3);
                    return r0;
                }

                public Builder mergeFrom(QualifiedName r2) {
                    if (r2 != QualifiedName.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r2.hasParentQualifiedName() == false) goto L9;
                    setParentQualifiedName(r2.getParentQualifiedName());
                L9:
                    if (r2.hasShortName() == false) goto L12;
                    setShortName(r2.getShortName());
                L12:
                    if (r2.hasKind() == false) goto L14;
                    setKind(r2.getKind());
                L14:
                    setUnknownFields(getUnknownFields().concat(QualifiedName.access$1300(r2)));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasShortName() == true) goto L6;
                    return false;
                L6:
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                    QualifiedName r0 = null;
                    QualifiedName r5 = QualifiedName.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r5 == null) goto L6;
                    mergeFrom(r5);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    QualifiedName r6 = (QualifiedName) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r0 = r6;
                L14:
                    if (r0 == null) goto L16;
                    mergeFrom(r0);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }

                public Builder setParentQualifiedName(int r2) {
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = r2;
                    return this;
                }

                public boolean hasShortName() {
                    if ((this.bitField0_ & 2) != 2) goto L5;
                    return true;
                L5:
                    return false;
                }

                public Builder setShortName(int r2) {
                    this.bitField0_ |= 2;
                    this.shortName_ = r2;
                    return this;
                }

                public Builder setKind(Kind r2) {
                    r2.getClass();
                    this.bitField0_ |= 4;
                    this.kind_ = r2;
                    return this;
                }
            }

            public static final enum Kind extends Enum<Kind> implements Internal.EnumLite {
                private static final /* synthetic */ Kind[] $VALUES = null;
                public static final Kind CLASS = null;
                public static final Kind LOCAL = null;
                public static final Kind PACKAGE = null;
                private static Internal.EnumLiteMap<Kind> internalValueMap;
                private final int value;

                public static Kind valueOf(String r1) {
                    return (Kind) Enum.valueOf(Kind.class, r1);
                }

                public static Kind[] values() {
                    return (Kind[]) $VALUES.clone();
                }

                static {
                    Kind r0 = new Kind("CLASS", 0, 0, 0);
                    CLASS = r0;
                    Kind r1 = new Kind("PACKAGE", 1, 1, 1);
                    PACKAGE = r1;
                    Kind r3 = new Kind("LOCAL", 2, 2, 2);
                    LOCAL = r3;
                    $VALUES = new Kind[]{r0, r1, r3};
                    internalValueMap = new AnonymousClass1();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int r1) {
                    if (r1 == 0) goto L14;
                    if (r1 == 1) goto L12;
                    if (r1 == 2) goto L10;
                    return null;
                L10:
                    return LOCAL;
                L12:
                    return PACKAGE;
                L14:
                    return CLASS;
                }

                private Kind(String r1, int r2, int r3, int r4) {
                    super(r1, r2);
                    this.value = r4;
                }
            }

            /* synthetic */ QualifiedName(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
                this(r1, r2);
            }

            /* synthetic */ QualifiedName(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
                this(r1);
            }

            static /* synthetic */ int access$1002(QualifiedName r0, int r1) {
                r0.shortName_ = r1;
                return r1;
            }

            static /* synthetic */ Kind access$1102(QualifiedName r0, Kind r1) {
                r0.kind_ = r1;
                return r1;
            }

            static /* synthetic */ int access$1202(QualifiedName r0, int r1) {
                r0.bitField0_ = r1;
                return r1;
            }

            static /* synthetic */ ByteString access$1300(QualifiedName r0) {
                return r0.unknownFields;
            }

            static /* synthetic */ int access$902(QualifiedName r0, int r1) {
                r0.parentQualifiedName_ = r1;
                return r1;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            private QualifiedName(GeneratedMessageLite.Builder r2) {
                super(r2);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r2.getUnknownFields();
            }

            private QualifiedName(boolean r1) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public QualifiedName getDefaultInstanceForType() {
                return defaultInstance;
            }

            private QualifiedName(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r0 = ByteString.newOutput();
                CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
                boolean r3 = false;
            L3:
                if (r3 == true) goto L49;
                int r4 = r8.readTag();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                if (r4 == 0) goto L22;
                if (r4 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.parentQualifiedName_ = r8.readInt32();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L9:
                if (r4 != 16) goto L11;
                this.bitField0_ |= 2;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.shortName_ = r8.readInt32();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L11:
                if (r4 != 24) goto L13;
                int r5 = r8.readEnum();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                Kind r6 = Kind.valueOf(r5);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                if (r6 == null) goto L17;
                this.bitField0_ |= 4;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.kind_ = r6;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L17:
                r2.writeRawVarint32(r4);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                r2.writeRawVarint32(r5);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L13:
                if (parseUnknownField(r8, r2, r9, r4) == true) goto L3;
            L22:
                r3 = true;
                goto L3
            L23:
                th = move-exception;
                r2.flush();     // Catch: IOException -> L45 Throwable -> L33
            L33:
                th = move-exception;
                this.unknownFields = r0.toByteString();
                throw th;
            L32:
                this.unknownFields = r0.toByteString();
                makeExtensionsImmutable();
                throw th;
            L28:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L23
            L25:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L23
            L49:
                r2.flush();     // Catch: IOException -> L46 Throwable -> L40
            L40:
                th = move-exception;
                this.unknownFields = r0.toByteString();
                throw th;
            L39:
                this.unknownFields = r0.toByteString();
                makeExtensionsImmutable();
            }

            static {
                PARSER = new AnonymousClass1();
                QualifiedName r0 = new QualifiedName(true);
                defaultInstance = r0;
                r0.initFields();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<QualifiedName> getParserForType() {
                return PARSER;
            }

            public boolean hasParentQualifiedName() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            public boolean hasShortName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public int getShortName() {
                return this.shortName_;
            }

            public boolean hasKind() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public Kind getKind() {
                return this.kind_;
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r0 = this.memoizedIsInitialized;
                if (r0 != 1) goto L6;
                return true;
            L6:
                if (r0 != 0) goto L9;
                return false;
            L9:
                if (hasShortName() == true) goto L12;
                this.memoizedIsInitialized = 0;
                return false;
            L12:
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r3) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r3.writeInt32(1, this.parentQualifiedName_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r3.writeInt32(2, this.shortName_);
            L9:
                if ((this.bitField0_ & 4) != 4) goto L11;
                r3.writeEnum(3, this.kind_.getNumber());
            L11:
                r3.writeRawBytes(this.unknownFields);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int r0 = this.memoizedSerializedSize;
                if (r0 == (-1)) goto L5;
                return r0;
            L5:
                int r2 = 0;
                if ((this.bitField0_ & 1) != 1) goto L9;
                r2 = 0 + CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_);
            L9:
                if ((this.bitField0_ & 2) != 2) goto L12;
                r2 = r2 + CodedOutputStream.computeInt32Size(2, this.shortName_);
            L12:
                if ((this.bitField0_ & 4) != 4) goto L14;
                r2 = r2 + CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
            L14:
                int r3 = r2 + this.unknownFields.size();
                this.memoizedSerializedSize = r3;
                return r3;
            }

            public static Builder newBuilder() {
                return Builder.access$700();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(QualifiedName r1) {
                return newBuilder().mergeFrom(r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }
        }

        public interface QualifiedNameOrBuilder extends MessageLiteOrBuilder {
        }

        /* synthetic */ QualifiedNameTable(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ QualifiedNameTable(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ List access$1600(QualifiedNameTable r0) {
            return r0.qualifiedName_;
        }

        static /* synthetic */ List access$1602(QualifiedNameTable r0, List r1) {
            r0.qualifiedName_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$1700(QualifiedNameTable r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private QualifiedNameTable(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private QualifiedNameTable(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public QualifiedNameTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        private QualifiedNameTable(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            boolean r4 = false;
        L3:
            if (r3 == true) goto L36;
            int r5 = r8.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r5 == 0) goto L16;
            if (r5 != 10) goto L9;
            if ((r4 & true) == true) goto L14;
            this.qualifiedName_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.qualifiedName_.add((QualifiedName) r8.readMessage(QualifiedName.PARSER, r9));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r8, r2, r9, r5) == true) goto L3;
        L16:
            r3 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r4 & true) != true) goto L48;
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
        L48:
            r2.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L29:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r4 & true) != true) goto L51;
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
        L51:
            r2.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L39:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            QualifiedNameTable r0 = new QualifiedNameTable(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        public QualifiedName getQualifiedName(int r1) {
            return this.qualifiedName_.get(r1);
        }

        private void initFields() {
            this.qualifiedName_ = Collections.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L8;
            return false;
        L8:
            int r1 = 0;
        L10:
            if (r1 >= getQualifiedNameCount()) goto L16;
            if (getQualifiedName(r1).isInitialized() == false) goto L13;
            r1 = r1 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r4) throws IOException {
            getSerializedSize();
            int r0 = 0;
        L4:
            if (r0 >= this.qualifiedName_.size()) goto L6;
            r4.writeMessage(1, this.qualifiedName_.get(r0));
            r0 = r0 + 1;
            goto L4
        L6:
            r4.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            int r2 = 0;
        L7:
            if (r1 >= this.qualifiedName_.size()) goto L9;
            r2 = r2 + CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(r1));
            r1 = r1 + 1;
            goto L7
        L9:
            int r3 = r2 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public static Builder newBuilder() {
            return Builder.access$1400();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(QualifiedNameTable r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface QualifiedNameTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class StringTable extends GeneratedMessageLite implements StringTableOrBuilder {
        public static Parser<StringTable> PARSER;
        private static final StringTable defaultInstance = null;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private LazyStringList string_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<StringTable, Builder> implements StringTableOrBuilder {
            private int bitField0_;
            private LazyStringList string_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$100() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((StringTable) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.string_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public StringTable build() {
                StringTable r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public StringTable buildPartial() {
                StringTable r0 = new StringTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.string_ = this.string_.getUnmodifiableView();
                this.bitField0_ &= -2;
            L5:
                StringTable.access$302(r0, this.string_);
                return r0;
            }

            public Builder mergeFrom(StringTable r3) {
                if (r3 != StringTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (StringTable.access$300(r3).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(StringTable.access$400(r3)));
                return this;
            L8:
                if (this.string_.isEmpty() == false) goto L10;
                this.string_ = StringTable.access$300(r3);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureStringIsMutable();
                this.string_.addAll(StringTable.access$300(r3));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                StringTable r0 = null;
                StringTable r5 = StringTable.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                StringTable r6 = (StringTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            private void ensureStringIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.string_ = new LazyStringArrayList(this.string_);
                this.bitField0_ |= 1;
                return;
            }
        }

        /* synthetic */ StringTable(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ StringTable(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ LazyStringList access$300(StringTable r0) {
            return r0.string_;
        }

        static /* synthetic */ LazyStringList access$302(StringTable r0, LazyStringList r1) {
            r0.string_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$400(StringTable r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private StringTable(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private StringTable(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public StringTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        private StringTable(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            boolean r4 = false;
        L3:
            if (r3 == true) goto L36;
            int r5 = r8.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r5 == 0) goto L16;
            if (r5 != 10) goto L9;
            ByteString r6 = r8.readBytes();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if ((r4 & true) == true) goto L14;
            this.string_ = new LazyStringArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.string_.add(r6);     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r8, r2, r9, r5) == true) goto L3;
        L16:
            r3 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r4 & true) != true) goto L51;
            this.string_ = this.string_.getUnmodifiableView();
        L51:
            r2.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L29:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r4 & true) != true) goto L49;
            this.string_ = this.string_.getUnmodifiableView();
        L49:
            r2.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L39:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            StringTable r0 = new StringTable(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<StringTable> getParserForType() {
            return PARSER;
        }

        public ProtocolStringList getStringList() {
            return this.string_;
        }

        public String getString(int r1) {
            return (String) this.string_.get(r1);
        }

        private void initFields() {
            this.string_ = LazyStringArrayList.EMPTY;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r4) throws IOException {
            getSerializedSize();
            int r0 = 0;
        L4:
            if (r0 >= this.string_.size()) goto L6;
            r4.writeBytes(1, this.string_.getByteString(r0));
            r0 = r0 + 1;
            goto L4
        L6:
            r4.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            int r2 = 0;
        L7:
            if (r1 >= this.string_.size()) goto L9;
            r2 = r2 + CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(r1));
            r1 = r1 + 1;
            goto L7
        L9:
            int r3 = ((0 + r2) + (getStringList().size() * 1)) + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public static Builder newBuilder() {
            return Builder.access$100();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(StringTable r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface StringTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Type extends GeneratedMessageLite.ExtendableMessage<Type> implements TypeOrBuilder {
        public static Parser<Type> PARSER;
        private static final Type defaultInstance = null;
        private int abbreviatedTypeId_;
        private Type abbreviatedType_;
        private List<Argument> argument_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private Type flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean nullable_;
        private int outerTypeId_;
        private Type outerType_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;
        private final ByteString unknownFields;

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER;
            private static final Argument defaultInstance = null;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Projection projection_;
            private int typeId_;
            private Type type_;
            private final ByteString unknownFields;

            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private Projection projection_;
                private int typeId_;
                private Type type_;

                private void maybeForceBuilderInitialization() {
                }

                static /* synthetic */ Builder access$5000() {
                    return create();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                    return mergeFrom(r1, r2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                    return mergeFrom((Argument) r1);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                    return mergeFrom(r1, r2);
                }

                private Builder() {
                    this.projection_ = Projection.INV;
                    this.type_ = Type.getDefaultInstance();
                    maybeForceBuilderInitialization();
                }

                private static Builder create() {
                    return new Builder();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument r1 = buildPartial();
                    if (r1.isInitialized() == false) goto L6;
                    return r1;
                L6:
                    throw newUninitializedMessageException(r1);
                }

                public Argument buildPartial() {
                    Argument r0 = new Argument(this, null);
                    int r1 = this.bitField0_;
                    int r3 = 1;
                    if ((r1 & 1) == 1) goto L6;
                    r3 = 0;
                L6:
                    Argument.access$5202(r0, this.projection_);
                    if ((r1 & 2) != 2) goto L9;
                    r3 = r3 | 2;
                L9:
                    Argument.access$5302(r0, this.type_);
                    if ((r1 & 4) != 4) goto L12;
                    r3 = r3 | 4;
                L12:
                    Argument.access$5402(r0, this.typeId_);
                    Argument.access$5502(r0, r3);
                    return r0;
                }

                public Builder mergeFrom(Argument r2) {
                    if (r2 != Argument.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r2.hasProjection() == false) goto L9;
                    setProjection(r2.getProjection());
                L9:
                    if (r2.hasType() == false) goto L12;
                    mergeType(r2.getType());
                L12:
                    if (r2.hasTypeId() == false) goto L14;
                    setTypeId(r2.getTypeId());
                L14:
                    setUnknownFields(getUnknownFields().concat(Argument.access$5600(r2)));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasType() == true) goto L5;
                    return true;
                L5:
                    if (getType().isInitialized() == true) goto L10;
                    return false;
                L10:
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                    Argument r0 = null;
                    Argument r5 = Argument.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r5 == null) goto L6;
                    mergeFrom(r5);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Argument r6 = (Argument) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r0 = r6;
                L14:
                    if (r0 == null) goto L16;
                    mergeFrom(r0);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }

                public Builder setProjection(Projection r2) {
                    r2.getClass();
                    this.bitField0_ |= 1;
                    this.projection_ = r2;
                    return this;
                }

                public boolean hasType() {
                    if ((this.bitField0_ & 2) != 2) goto L5;
                    return true;
                L5:
                    return false;
                }

                public Type getType() {
                    return this.type_;
                }

                public Builder mergeType(Type r4) {
                    if ((this.bitField0_ & 2) == 2) goto L5;
                L7:
                    this.type_ = r4;
                L8:
                    this.bitField0_ |= 2;
                    return this;
                L5:
                    if (this.type_ == Type.getDefaultInstance()) goto L7;
                    this.type_ = Type.newBuilder(this.type_).mergeFrom(r4).buildPartial();
                    goto L8
                }

                public Builder setTypeId(int r2) {
                    this.bitField0_ |= 4;
                    this.typeId_ = r2;
                    return this;
                }
            }

            public static final enum Projection extends Enum<Projection> implements Internal.EnumLite {
                private static final /* synthetic */ Projection[] $VALUES = null;
                public static final Projection IN = null;
                public static final Projection INV = null;
                public static final Projection OUT = null;
                public static final Projection STAR = null;
                private static Internal.EnumLiteMap<Projection> internalValueMap;
                private final int value;

                public static Projection valueOf(String r1) {
                    return (Projection) Enum.valueOf(Projection.class, r1);
                }

                public static Projection[] values() {
                    return (Projection[]) $VALUES.clone();
                }

                static {
                    Projection r0 = new Projection("IN", 0, 0, 0);
                    IN = r0;
                    Projection r1 = new Projection("OUT", 1, 1, 1);
                    OUT = r1;
                    Projection r3 = new Projection("INV", 2, 2, 2);
                    INV = r3;
                    Projection r5 = new Projection("STAR", 3, 3, 3);
                    STAR = r5;
                    $VALUES = new Projection[]{r0, r1, r3, r5};
                    internalValueMap = new AnonymousClass1();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Projection valueOf(int r1) {
                    if (r1 == 0) goto L18;
                    if (r1 == 1) goto L16;
                    if (r1 == 2) goto L14;
                    if (r1 == 3) goto L12;
                    return null;
                L12:
                    return STAR;
                L14:
                    return INV;
                L16:
                    return OUT;
                L18:
                    return IN;
                }

                private Projection(String r1, int r2, int r3, int r4) {
                    super(r1, r2);
                    this.value = r4;
                }
            }

            /* synthetic */ Argument(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
                this(r1, r2);
            }

            /* synthetic */ Argument(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
                this(r1);
            }

            static /* synthetic */ Projection access$5202(Argument r0, Projection r1) {
                r0.projection_ = r1;
                return r1;
            }

            static /* synthetic */ Type access$5302(Argument r0, Type r1) {
                r0.type_ = r1;
                return r1;
            }

            static /* synthetic */ int access$5402(Argument r0, int r1) {
                r0.typeId_ = r1;
                return r1;
            }

            static /* synthetic */ int access$5502(Argument r0, int r1) {
                r0.bitField0_ = r1;
                return r1;
            }

            static /* synthetic */ ByteString access$5600(Argument r0) {
                return r0.unknownFields;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            private Argument(GeneratedMessageLite.Builder r2) {
                super(r2);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r2.getUnknownFields();
            }

            private Argument(boolean r1) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            private Argument(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r0 = ByteString.newOutput();
                CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
                boolean r3 = false;
            L3:
                if (r3 == true) goto L58;
                int r4 = r8.readTag();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                if (r4 == 0) goto L29;
                if (r4 != 8) goto L9;
                int r5 = r8.readEnum();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                Projection r6 = Projection.valueOf(r5);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                if (r6 == null) goto L26;
                this.bitField0_ |= 1;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                this.projection_ = r6;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                goto L3
            L26:
                r2.writeRawVarint32(r4);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                r2.writeRawVarint32(r5);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                goto L3
            L9:
                if (r4 != 18) goto L11;
                if ((this.bitField0_ & 2) != 2) goto L19;
                Builder r7 = this.type_.toBuilder();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            L20:
                Type r10 = (Type) r8.readMessage(Type.PARSER, r9);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                this.type_ = r10;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                if (r7 == null) goto L23;
                r7.mergeFrom(r10);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                this.type_ = r7.buildPartial();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            L23:
                this.bitField0_ |= 2;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                goto L3
            L19:
                r7 = null;
                goto L20
            L11:
                if (r4 != 24) goto L13;
                this.bitField0_ |= 4;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                this.typeId_ = r8.readInt32();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                goto L3
            L13:
                if (parseUnknownField(r8, r2, r9, r4) == true) goto L3;
            L29:
                r3 = true;
                goto L3
            L30:
                th = move-exception;
                r2.flush();     // Catch: IOException -> L52 Throwable -> L40
            L40:
                th = move-exception;
                this.unknownFields = r0.toByteString();
                throw th;
            L39:
                this.unknownFields = r0.toByteString();
                makeExtensionsImmutable();
                throw th;
            L32:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L30
            L35:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L30
            L58:
                r2.flush();     // Catch: IOException -> L53 Throwable -> L47
            L47:
                th = move-exception;
                this.unknownFields = r0.toByteString();
                throw th;
            L46:
                this.unknownFields = r0.toByteString();
                makeExtensionsImmutable();
            }

            static {
                PARSER = new AnonymousClass1();
                Argument r0 = new Argument(true);
                defaultInstance = r0;
                r0.initFields();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public boolean hasProjection() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public Projection getProjection() {
                return this.projection_;
            }

            public boolean hasType() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getType() {
                return this.type_;
            }

            public boolean hasTypeId() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public int getTypeId() {
                return this.typeId_;
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r0 = this.memoizedIsInitialized;
                if (r0 != 1) goto L6;
                return true;
            L6:
                if (r0 != 0) goto L9;
                return false;
            L9:
                if (hasType() == true) goto L11;
            L14:
                this.memoizedIsInitialized = 1;
                return true;
            L11:
                if (getType().isInitialized() == true) goto L14;
                this.memoizedIsInitialized = 0;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r3) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r3.writeEnum(1, this.projection_.getNumber());
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r3.writeMessage(2, this.type_);
            L9:
                if ((this.bitField0_ & 4) != 4) goto L11;
                r3.writeInt32(3, this.typeId_);
            L11:
                r3.writeRawBytes(this.unknownFields);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int r0 = this.memoizedSerializedSize;
                if (r0 == (-1)) goto L5;
                return r0;
            L5:
                int r2 = 0;
                if ((this.bitField0_ & 1) != 1) goto L9;
                r2 = 0 + CodedOutputStream.computeEnumSize(1, this.projection_.getNumber());
            L9:
                if ((this.bitField0_ & 2) != 2) goto L12;
                r2 = r2 + CodedOutputStream.computeMessageSize(2, this.type_);
            L12:
                if ((this.bitField0_ & 4) != 4) goto L14;
                r2 = r2 + CodedOutputStream.computeInt32Size(3, this.typeId_);
            L14:
                int r3 = r2 + this.unknownFields.size();
                this.memoizedSerializedSize = r3;
                return r3;
            }

            public static Builder newBuilder() {
                return Builder.access$5000();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(Argument r1) {
                return newBuilder().mergeFrom(r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }
        }

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Type, Builder> implements TypeOrBuilder {
            private int abbreviatedTypeId_;
            private Type abbreviatedType_;
            private List<Argument> argument_;
            private int bitField0_;
            private int className_;
            private int flags_;
            private int flexibleTypeCapabilitiesId_;
            private int flexibleUpperBoundId_;
            private Type flexibleUpperBound_;
            private boolean nullable_;
            private int outerTypeId_;
            private Type outerType_;
            private int typeAliasName_;
            private int typeParameterName_;
            private int typeParameter_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$5700() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((Type) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.argument_ = Collections.emptyList();
                this.flexibleUpperBound_ = Type.getDefaultInstance();
                this.outerType_ = Type.getDefaultInstance();
                this.abbreviatedType_ = Type.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Type build() {
                Type r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public Type buildPartial() {
                Type r0 = new Type(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) != 1) goto L5;
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -2;
            L5:
                Type.access$5902(r0, this.argument_);
                if ((r1 & 2) == 2) goto L9;
                r3 = 0;
            L9:
                Type.access$6002(r0, this.nullable_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 2;
            L12:
                Type.access$6102(r0, this.flexibleTypeCapabilitiesId_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 4;
            L15:
                Type.access$6202(r0, this.flexibleUpperBound_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 8;
            L18:
                Type.access$6302(r0, this.flexibleUpperBoundId_);
                if ((r1 & 32) != 32) goto L21;
                r3 = r3 | 16;
            L21:
                Type.access$6402(r0, this.className_);
                if ((r1 & 64) != 64) goto L24;
                r3 = r3 | 32;
            L24:
                Type.access$6502(r0, this.typeParameter_);
                if ((r1 & 128) != 128) goto L27;
                r3 = r3 | 64;
            L27:
                Type.access$6602(r0, this.typeParameterName_);
                if ((r1 & 256) != 256) goto L30;
                r3 = r3 | 128;
            L30:
                Type.access$6702(r0, this.typeAliasName_);
                if ((r1 & 512) != 512) goto L33;
                r3 = r3 | 256;
            L33:
                Type.access$6802(r0, this.outerType_);
                if ((r1 & 1024) != 1024) goto L36;
                r3 = r3 | 512;
            L36:
                Type.access$6902(r0, this.outerTypeId_);
                if ((r1 & 2048) != 2048) goto L39;
                r3 = r3 | 1024;
            L39:
                Type.access$7002(r0, this.abbreviatedType_);
                if ((r1 & 4096) != 4096) goto L42;
                r3 = r3 | 2048;
            L42:
                Type.access$7102(r0, this.abbreviatedTypeId_);
                if ((r1 & 8192) != 8192) goto L45;
                r3 = r3 | 4096;
            L45:
                Type.access$7202(r0, this.flags_);
                Type.access$7302(r0, r3);
                return r0;
            }

            public Builder mergeFrom(Type r3) {
                if (r3 != Type.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Type.access$5900(r3).isEmpty() == true) goto L12;
                if (this.argument_.isEmpty() == false) goto L10;
                this.argument_ = Type.access$5900(r3);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureArgumentIsMutable();
                this.argument_.addAll(Type.access$5900(r3));
            L12:
                if (r3.hasNullable() == false) goto L15;
                setNullable(r3.getNullable());
            L15:
                if (r3.hasFlexibleTypeCapabilitiesId() == false) goto L18;
                setFlexibleTypeCapabilitiesId(r3.getFlexibleTypeCapabilitiesId());
            L18:
                if (r3.hasFlexibleUpperBound() == false) goto L21;
                mergeFlexibleUpperBound(r3.getFlexibleUpperBound());
            L21:
                if (r3.hasFlexibleUpperBoundId() == false) goto L24;
                setFlexibleUpperBoundId(r3.getFlexibleUpperBoundId());
            L24:
                if (r3.hasClassName() == false) goto L27;
                setClassName(r3.getClassName());
            L27:
                if (r3.hasTypeParameter() == false) goto L30;
                setTypeParameter(r3.getTypeParameter());
            L30:
                if (r3.hasTypeParameterName() == false) goto L33;
                setTypeParameterName(r3.getTypeParameterName());
            L33:
                if (r3.hasTypeAliasName() == false) goto L36;
                setTypeAliasName(r3.getTypeAliasName());
            L36:
                if (r3.hasOuterType() == false) goto L39;
                mergeOuterType(r3.getOuterType());
            L39:
                if (r3.hasOuterTypeId() == false) goto L42;
                setOuterTypeId(r3.getOuterTypeId());
            L42:
                if (r3.hasAbbreviatedType() == false) goto L45;
                mergeAbbreviatedType(r3.getAbbreviatedType());
            L45:
                if (r3.hasAbbreviatedTypeId() == false) goto L48;
                setAbbreviatedTypeId(r3.getAbbreviatedTypeId());
            L48:
                if (r3.hasFlags() == false) goto L50;
                setFlags(r3.getFlags());
            L50:
                mergeExtensionFields(r3);
                setUnknownFields(getUnknownFields().concat(Type.access$7400(r3)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r1 = 0;
            L4:
                if (r1 >= getArgumentCount()) goto L10;
                if (getArgument(r1).isInitialized() == false) goto L7;
                r1 = r1 + 1;
                goto L4
            L7:
                return false;
            L10:
                if (hasFlexibleUpperBound() == false) goto L15;
                if (getFlexibleUpperBound().isInitialized() == true) goto L15;
                return false;
            L15:
                if (hasOuterType() == false) goto L20;
                if (getOuterType().isInitialized() == true) goto L20;
                return false;
            L20:
                if (hasAbbreviatedType() == false) goto L25;
                if (getAbbreviatedType().isInitialized() == true) goto L25;
                return false;
            L25:
                if (extensionsAreInitialized() == true) goto L27;
                return false;
            L27:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                Type r0 = null;
                Type r5 = Type.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                Type r6 = (Type) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.argument_ = new ArrayList(this.argument_);
                this.bitField0_ |= 1;
                return;
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public Argument getArgument(int r1) {
                return this.argument_.get(r1);
            }

            public Builder setNullable(boolean r2) {
                this.bitField0_ |= 2;
                this.nullable_ = r2;
                return this;
            }

            public Builder setFlexibleTypeCapabilitiesId(int r2) {
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = r2;
                return this;
            }

            public boolean hasFlexibleUpperBound() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getFlexibleUpperBound() {
                return this.flexibleUpperBound_;
            }

            public Builder mergeFlexibleUpperBound(Type r4) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.flexibleUpperBound_ = r4;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.flexibleUpperBound_ == Type.getDefaultInstance()) goto L7;
                this.flexibleUpperBound_ = Type.newBuilder(this.flexibleUpperBound_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setFlexibleUpperBoundId(int r2) {
                this.bitField0_ |= 16;
                this.flexibleUpperBoundId_ = r2;
                return this;
            }

            public Builder setClassName(int r2) {
                this.bitField0_ |= 32;
                this.className_ = r2;
                return this;
            }

            public Builder setTypeParameter(int r2) {
                this.bitField0_ |= 64;
                this.typeParameter_ = r2;
                return this;
            }

            public Builder setTypeParameterName(int r2) {
                this.bitField0_ |= 128;
                this.typeParameterName_ = r2;
                return this;
            }

            public Builder setTypeAliasName(int r2) {
                this.bitField0_ |= 256;
                this.typeAliasName_ = r2;
                return this;
            }

            public boolean hasOuterType() {
                if ((this.bitField0_ & 512) != 512) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getOuterType() {
                return this.outerType_;
            }

            public Builder mergeOuterType(Type r4) {
                if ((this.bitField0_ & 512) == 512) goto L5;
            L7:
                this.outerType_ = r4;
            L8:
                this.bitField0_ |= 512;
                return this;
            L5:
                if (this.outerType_ == Type.getDefaultInstance()) goto L7;
                this.outerType_ = Type.newBuilder(this.outerType_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setOuterTypeId(int r2) {
                this.bitField0_ |= 1024;
                this.outerTypeId_ = r2;
                return this;
            }

            public boolean hasAbbreviatedType() {
                if ((this.bitField0_ & 2048) != 2048) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getAbbreviatedType() {
                return this.abbreviatedType_;
            }

            public Builder mergeAbbreviatedType(Type r4) {
                if ((this.bitField0_ & 2048) == 2048) goto L5;
            L7:
                this.abbreviatedType_ = r4;
            L8:
                this.bitField0_ |= 2048;
                return this;
            L5:
                if (this.abbreviatedType_ == Type.getDefaultInstance()) goto L7;
                this.abbreviatedType_ = Type.newBuilder(this.abbreviatedType_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setAbbreviatedTypeId(int r2) {
                this.bitField0_ |= 4096;
                this.abbreviatedTypeId_ = r2;
                return this;
            }

            public Builder setFlags(int r2) {
                this.bitField0_ |= 8192;
                this.flags_ = r2;
                return this;
            }
        }

        /* synthetic */ Type(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ Type(GeneratedMessageLite.ExtendableBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ List access$5900(Type r0) {
            return r0.argument_;
        }

        static /* synthetic */ List access$5902(Type r0, List r1) {
            r0.argument_ = r1;
            return r1;
        }

        static /* synthetic */ boolean access$6002(Type r0, boolean r1) {
            r0.nullable_ = r1;
            return r1;
        }

        static /* synthetic */ int access$6102(Type r0, int r1) {
            r0.flexibleTypeCapabilitiesId_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$6202(Type r0, Type r1) {
            r0.flexibleUpperBound_ = r1;
            return r1;
        }

        static /* synthetic */ int access$6302(Type r0, int r1) {
            r0.flexibleUpperBoundId_ = r1;
            return r1;
        }

        static /* synthetic */ int access$6402(Type r0, int r1) {
            r0.className_ = r1;
            return r1;
        }

        static /* synthetic */ int access$6502(Type r0, int r1) {
            r0.typeParameter_ = r1;
            return r1;
        }

        static /* synthetic */ int access$6602(Type r0, int r1) {
            r0.typeParameterName_ = r1;
            return r1;
        }

        static /* synthetic */ int access$6702(Type r0, int r1) {
            r0.typeAliasName_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$6802(Type r0, Type r1) {
            r0.outerType_ = r1;
            return r1;
        }

        static /* synthetic */ int access$6902(Type r0, int r1) {
            r0.outerTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$7002(Type r0, Type r1) {
            r0.abbreviatedType_ = r1;
            return r1;
        }

        static /* synthetic */ int access$7102(Type r0, int r1) {
            r0.abbreviatedTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ int access$7202(Type r0, int r1) {
            r0.flags_ = r1;
            return r1;
        }

        static /* synthetic */ int access$7302(Type r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$7400(Type r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private Type(GeneratedMessageLite.ExtendableBuilder<Type, ?> r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private Type(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Type getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Type(CodedInputStream r9, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            boolean r4 = false;
        L3:
            if (r3 == true) goto L65;
            int r5 = r9.readTag();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            Builder r6 = null;
            switch(r5) {
                case 0: goto L43;
                case 8: goto L41;
                case 18: goto L38;
                case 24: goto L36;
                case 32: goto L35;
                case 42: goto L29;
                case 48: goto L27;
                case 56: goto L26;
                case 64: goto L25;
                case 72: goto L24;
                case 82: goto L18;
                case 88: goto L16;
                case 96: goto L15;
                case 106: goto L9;
                case 112: goto L7;
                default: goto L44;
            };     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L7:
            this.bitField0_ |= 2048;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.abbreviatedTypeId_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L9:
            if ((this.bitField0_ & 1024) != 1024) goto L11;
            r6 = this.abbreviatedType_.toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L11:
            Type r7 = (Type) r9.readMessage(PARSER, r10);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.abbreviatedType_ = r7;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            if (r6 == null) goto L14;
            r6.mergeFrom(r7);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.abbreviatedType_ = r6.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L14:
            this.bitField0_ |= 1024;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L15:
            this.bitField0_ |= 128;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.typeAliasName_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L16:
            this.bitField0_ |= 512;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.outerTypeId_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L18:
            if ((this.bitField0_ & 256) != 256) goto L20;
            r6 = this.outerType_.toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L20:
            Type r8 = (Type) r9.readMessage(PARSER, r10);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.outerType_ = r8;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            if (r6 == null) goto L23;
            r6.mergeFrom(r8);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.outerType_ = r6.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L23:
            this.bitField0_ |= 256;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L24:
            this.bitField0_ |= 64;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.typeParameterName_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L25:
            this.bitField0_ |= 8;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.flexibleUpperBoundId_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L26:
            this.bitField0_ |= 32;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.typeParameter_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L27:
            this.bitField0_ |= 16;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.className_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L29:
            if ((this.bitField0_ & 4) != 4) goto L31;
            r6 = this.flexibleUpperBound_.toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L31:
            Type r11 = (Type) r9.readMessage(PARSER, r10);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.flexibleUpperBound_ = r11;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            if (r6 == null) goto L34;
            r6.mergeFrom(r11);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.flexibleUpperBound_ = r6.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L34:
            this.bitField0_ |= 4;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L35:
            this.bitField0_ |= 2;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.flexibleTypeCapabilitiesId_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L36:
            this.bitField0_ |= 1;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.nullable_ = r9.readBool();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L38:
            if ((r4 & true) == true) goto L40;
            this.argument_ = new ArrayList();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            r4 = r4 | true;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L40:
            this.argument_.add((Argument) r9.readMessage(Argument.PARSER, r10));     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L41:
            this.bitField0_ |= 4096;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.flags_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L43:
            r3 = true;
            goto L3
        L44:
            if (parseUnknownField(r9, r2, r10, r5) == true) goto L3;
        L46:
            th = move-exception;
            if ((r4 & true) != true) goto L78;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L78:
            r2.flush();     // Catch: IOException -> L75 Throwable -> L59
        L59:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L58:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L51:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L46
        L48:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L46
        L65:
            if ((r4 & true) != true) goto L80;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L80:
            r2.flush();     // Catch: IOException -> L74 Throwable -> L69
        L69:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L68:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            Type r0 = new Type(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Type> getParserForType() {
            return PARSER;
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public Argument getArgument(int r1) {
            return this.argument_.get(r1);
        }

        public boolean hasNullable() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean getNullable() {
            return this.nullable_;
        }

        public boolean hasFlexibleTypeCapabilitiesId() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public boolean hasFlexibleUpperBound() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public boolean hasFlexibleUpperBoundId() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        public boolean hasClassName() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public int getClassName() {
            return this.className_;
        }

        public boolean hasTypeParameter() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public int getTypeParameter() {
            return this.typeParameter_;
        }

        public boolean hasTypeParameterName() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        public boolean hasTypeAliasName() {
            if ((this.bitField0_ & 128) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        public boolean hasOuterType() {
            if ((this.bitField0_ & 256) != 256) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getOuterType() {
            return this.outerType_;
        }

        public boolean hasOuterTypeId() {
            if ((this.bitField0_ & 512) != 512) goto L5;
            return true;
        L5:
            return false;
        }

        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        public boolean hasAbbreviatedType() {
            if ((this.bitField0_ & 1024) != 1024) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public boolean hasAbbreviatedTypeId() {
            if ((this.bitField0_ & 2048) != 2048) goto L5;
            return true;
        L5:
            return false;
        }

        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 4096) != 4096) goto L5;
            return true;
        L5:
            return false;
        }

        public int getFlags() {
            return this.flags_;
        }

        private void initFields() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L8;
            return false;
        L8:
            int r1 = 0;
        L10:
            if (r1 >= getArgumentCount()) goto L17;
            if (getArgument(r1).isInitialized() == false) goto L13;
            r1 = r1 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (hasFlexibleUpperBound() == false) goto L23;
            if (getFlexibleUpperBound().isInitialized() == true) goto L23;
            this.memoizedIsInitialized = 0;
            return false;
        L23:
            if (hasOuterType() == false) goto L29;
            if (getOuterType().isInitialized() == true) goto L29;
            this.memoizedIsInitialized = 0;
            return false;
        L29:
            if (hasAbbreviatedType() == false) goto L35;
            if (getAbbreviatedType().isInitialized() == true) goto L35;
            this.memoizedIsInitialized = 0;
            return false;
        L35:
            if (extensionsAreInitialized() == true) goto L38;
            this.memoizedIsInitialized = 0;
            return false;
        L38:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r6) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
            if ((this.bitField0_ & 4096) != 4096) goto L5;
            r6.writeInt32(1, this.flags_);
        L5:
            int r1 = 0;
        L7:
            if (r1 >= this.argument_.size()) goto L10;
            r6.writeMessage(2, this.argument_.get(r1));
            r1 = r1 + 1;
            goto L7
        L10:
            if ((this.bitField0_ & 1) != 1) goto L13;
            r6.writeBool(3, this.nullable_);
        L13:
            if ((this.bitField0_ & 2) != 2) goto L16;
            r6.writeInt32(4, this.flexibleTypeCapabilitiesId_);
        L16:
            if ((this.bitField0_ & 4) != 4) goto L19;
            r6.writeMessage(5, this.flexibleUpperBound_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r6.writeInt32(6, this.className_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L25;
            r6.writeInt32(7, this.typeParameter_);
        L25:
            if ((this.bitField0_ & 8) != 8) goto L28;
            r6.writeInt32(8, this.flexibleUpperBoundId_);
        L28:
            if ((this.bitField0_ & 64) != 64) goto L31;
            r6.writeInt32(9, this.typeParameterName_);
        L31:
            if ((this.bitField0_ & 256) != 256) goto L34;
            r6.writeMessage(10, this.outerType_);
        L34:
            if ((this.bitField0_ & 512) != 512) goto L37;
            r6.writeInt32(11, this.outerTypeId_);
        L37:
            if ((this.bitField0_ & 128) != 128) goto L40;
            r6.writeInt32(12, this.typeAliasName_);
        L40:
            if ((this.bitField0_ & 1024) != 1024) goto L43;
            r6.writeMessage(13, this.abbreviatedType_);
        L43:
            if ((this.bitField0_ & 2048) != 2048) goto L45;
            r6.writeInt32(14, this.abbreviatedTypeId_);
        L45:
            r0.writeUntil(200, r6);
            r6.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 4096) != 4096) goto L8;
            int r1 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L10:
            if (r2 >= this.argument_.size()) goto L13;
            r1 = r1 + CodedOutputStream.computeMessageSize(2, this.argument_.get(r2));
            r2 = r2 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 1) != 1) goto L16;
            r1 = r1 + CodedOutputStream.computeBoolSize(3, this.nullable_);
        L16:
            if ((this.bitField0_ & 2) != 2) goto L19;
            r1 = r1 + CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
        L19:
            if ((this.bitField0_ & 4) != 4) goto L22;
            r1 = r1 + CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
        L22:
            if ((this.bitField0_ & 16) != 16) goto L25;
            r1 = r1 + CodedOutputStream.computeInt32Size(6, this.className_);
        L25:
            if ((this.bitField0_ & 32) != 32) goto L28;
            r1 = r1 + CodedOutputStream.computeInt32Size(7, this.typeParameter_);
        L28:
            if ((this.bitField0_ & 8) != 8) goto L31;
            r1 = r1 + CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
        L31:
            if ((this.bitField0_ & 64) != 64) goto L34;
            r1 = r1 + CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
        L34:
            if ((this.bitField0_ & 256) != 256) goto L37;
            r1 = r1 + CodedOutputStream.computeMessageSize(10, this.outerType_);
        L37:
            if ((this.bitField0_ & 512) != 512) goto L40;
            r1 = r1 + CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
        L40:
            if ((this.bitField0_ & 128) != 128) goto L43;
            r1 = r1 + CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
        L43:
            if ((this.bitField0_ & 1024) != 1024) goto L46;
            r1 = r1 + CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
        L46:
            if ((this.bitField0_ & 2048) != 2048) goto L48;
            r1 = r1 + CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
        L48:
            int r3 = (r1 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        L8:
            r1 = 0;
            goto L10
        }

        public static Builder newBuilder() {
            return Builder.access$5700();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Type r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class TypeAlias extends GeneratedMessageLite.ExtendableMessage<TypeAlias> implements TypeAliasOrBuilder {
        public static Parser<TypeAlias> PARSER;
        private static final TypeAlias defaultInstance = null;
        private List<Annotation> annotation_;
        private int bitField0_;
        private int expandedTypeId_;
        private Type expandedType_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List<TypeParameter> typeParameter_;
        private int underlyingTypeId_;
        private Type underlyingType_;
        private final ByteString unknownFields;
        private List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeAlias, Builder> implements TypeAliasOrBuilder {
            private List<Annotation> annotation_;
            private int bitField0_;
            private int expandedTypeId_;
            private Type expandedType_;
            private int flags_;
            private int name_;
            private List<TypeParameter> typeParameter_;
            private int underlyingTypeId_;
            private Type underlyingType_;
            private List<Integer> versionRequirement_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$19000() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((TypeAlias) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.flags_ = 6;
                this.typeParameter_ = Collections.emptyList();
                this.underlyingType_ = Type.getDefaultInstance();
                this.expandedType_ = Type.getDefaultInstance();
                this.annotation_ = Collections.emptyList();
                this.versionRequirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeAlias build() {
                TypeAlias r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public TypeAlias buildPartial() {
                TypeAlias r0 = new TypeAlias(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                TypeAlias.access$19202(r0, this.flags_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                TypeAlias.access$19302(r0, this.name_);
                if ((this.bitField0_ & 4) != 4) goto L12;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -5;
            L12:
                TypeAlias.access$19402(r0, this.typeParameter_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 4;
            L15:
                TypeAlias.access$19502(r0, this.underlyingType_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 8;
            L18:
                TypeAlias.access$19602(r0, this.underlyingTypeId_);
                if ((r1 & 32) != 32) goto L21;
                r3 = r3 | 16;
            L21:
                TypeAlias.access$19702(r0, this.expandedType_);
                if ((r1 & 64) != 64) goto L24;
                r3 = r3 | 32;
            L24:
                TypeAlias.access$19802(r0, this.expandedTypeId_);
                if ((this.bitField0_ & 128) != 128) goto L27;
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ &= -129;
            L27:
                TypeAlias.access$19902(r0, this.annotation_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -257;
            L30:
                TypeAlias.access$20002(r0, this.versionRequirement_);
                TypeAlias.access$20102(r0, r3);
                return r0;
            }

            public Builder mergeFrom(TypeAlias r3) {
                if (r3 != TypeAlias.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasFlags() == false) goto L9;
                setFlags(r3.getFlags());
            L9:
                if (r3.hasName() == false) goto L12;
                setName(r3.getName());
            L12:
                if (TypeAlias.access$19400(r3).isEmpty() == true) goto L18;
                if (this.typeParameter_.isEmpty() == false) goto L16;
                this.typeParameter_ = TypeAlias.access$19400(r3);
                this.bitField0_ &= -5;
                goto L18
            L16:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(TypeAlias.access$19400(r3));
            L18:
                if (r3.hasUnderlyingType() == false) goto L21;
                mergeUnderlyingType(r3.getUnderlyingType());
            L21:
                if (r3.hasUnderlyingTypeId() == false) goto L24;
                setUnderlyingTypeId(r3.getUnderlyingTypeId());
            L24:
                if (r3.hasExpandedType() == false) goto L27;
                mergeExpandedType(r3.getExpandedType());
            L27:
                if (r3.hasExpandedTypeId() == false) goto L30;
                setExpandedTypeId(r3.getExpandedTypeId());
            L30:
                if (TypeAlias.access$19900(r3).isEmpty() == true) goto L36;
                if (this.annotation_.isEmpty() == false) goto L34;
                this.annotation_ = TypeAlias.access$19900(r3);
                this.bitField0_ &= -129;
                goto L36
            L34:
                ensureAnnotationIsMutable();
                this.annotation_.addAll(TypeAlias.access$19900(r3));
            L36:
                if (TypeAlias.access$20000(r3).isEmpty() == false) goto L38;
            L41:
                mergeExtensionFields(r3);
                setUnknownFields(getUnknownFields().concat(TypeAlias.access$20200(r3)));
                return this;
            L38:
                if (this.versionRequirement_.isEmpty() == false) goto L40;
                this.versionRequirement_ = TypeAlias.access$20000(r3);
                this.bitField0_ &= -257;
                goto L41
            L40:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(TypeAlias.access$20000(r3));
                goto L41
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L5;
                return false;
            L5:
                int r0 = 0;
            L7:
                if (r0 >= getTypeParameterCount()) goto L13;
                if (getTypeParameter(r0).isInitialized() == false) goto L10;
                r0 = r0 + 1;
                goto L7
            L10:
                return false;
            L13:
                if (hasUnderlyingType() == false) goto L18;
                if (getUnderlyingType().isInitialized() == true) goto L18;
                return false;
            L18:
                if (hasExpandedType() == true) goto L20;
            L22:
                int r1 = 0;
            L24:
                if (r1 >= getAnnotationCount()) goto L30;
                if (getAnnotation(r1).isInitialized() == false) goto L27;
                r1 = r1 + 1;
                goto L24
            L27:
                return false;
            L30:
                if (extensionsAreInitialized() == true) goto L32;
                return false;
            L32:
                return true;
            L20:
                if (getExpandedType().isInitialized() == true) goto L22;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                TypeAlias r0 = null;
                TypeAlias r5 = TypeAlias.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeAlias r6 = (TypeAlias) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public Builder setFlags(int r2) {
                this.bitField0_ |= 1;
                this.flags_ = r2;
                return this;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public Builder setName(int r2) {
                this.bitField0_ |= 2;
                this.name_ = r2;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 4;
                return;
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int r1) {
                return this.typeParameter_.get(r1);
            }

            public boolean hasUnderlyingType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getUnderlyingType() {
                return this.underlyingType_;
            }

            public Builder mergeUnderlyingType(Type r4) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.underlyingType_ = r4;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.underlyingType_ == Type.getDefaultInstance()) goto L7;
                this.underlyingType_ = Type.newBuilder(this.underlyingType_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setUnderlyingTypeId(int r2) {
                this.bitField0_ |= 16;
                this.underlyingTypeId_ = r2;
                return this;
            }

            public boolean hasExpandedType() {
                if ((this.bitField0_ & 32) != 32) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getExpandedType() {
                return this.expandedType_;
            }

            public Builder mergeExpandedType(Type r4) {
                if ((this.bitField0_ & 32) == 32) goto L5;
            L7:
                this.expandedType_ = r4;
            L8:
                this.bitField0_ |= 32;
                return this;
            L5:
                if (this.expandedType_ == Type.getDefaultInstance()) goto L7;
                this.expandedType_ = Type.newBuilder(this.expandedType_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setExpandedTypeId(int r2) {
                this.bitField0_ |= 64;
                this.expandedTypeId_ = r2;
                return this;
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 128) == 128) goto L6;
                this.annotation_ = new ArrayList(this.annotation_);
                this.bitField0_ |= 128;
                return;
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public Annotation getAnnotation(int r1) {
                return this.annotation_.get(r1);
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 256;
                return;
            }
        }

        /* synthetic */ TypeAlias(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ TypeAlias(GeneratedMessageLite.ExtendableBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$19202(TypeAlias r0, int r1) {
            r0.flags_ = r1;
            return r1;
        }

        static /* synthetic */ int access$19302(TypeAlias r0, int r1) {
            r0.name_ = r1;
            return r1;
        }

        static /* synthetic */ List access$19400(TypeAlias r0) {
            return r0.typeParameter_;
        }

        static /* synthetic */ List access$19402(TypeAlias r0, List r1) {
            r0.typeParameter_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$19502(TypeAlias r0, Type r1) {
            r0.underlyingType_ = r1;
            return r1;
        }

        static /* synthetic */ int access$19602(TypeAlias r0, int r1) {
            r0.underlyingTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$19702(TypeAlias r0, Type r1) {
            r0.expandedType_ = r1;
            return r1;
        }

        static /* synthetic */ int access$19802(TypeAlias r0, int r1) {
            r0.expandedTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ List access$19900(TypeAlias r0) {
            return r0.annotation_;
        }

        static /* synthetic */ List access$19902(TypeAlias r0, List r1) {
            r0.annotation_ = r1;
            return r1;
        }

        static /* synthetic */ List access$20000(TypeAlias r0) {
            return r0.versionRequirement_;
        }

        static /* synthetic */ List access$20002(TypeAlias r0, List r1) {
            r0.versionRequirement_ = r1;
            return r1;
        }

        static /* synthetic */ int access$20102(TypeAlias r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$20200(TypeAlias r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private TypeAlias(GeneratedMessageLite.ExtendableBuilder<TypeAlias, ?> r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private TypeAlias(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeAlias getDefaultInstanceForType() {
            return defaultInstance;
        }

        private TypeAlias(CodedInputStream r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            int r4 = 0;
        L4:
            if (r3 == true) goto L76;
            int r8 = r12.readTag();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            Type.Builder r9 = null;
            switch(r8) {
                case 0: goto L48;
                case 8: goto L46;
                case 16: goto L45;
                case 26: goto L42;
                case 34: goto L35;
                case 40: goto L33;
                case 50: goto L27;
                case 56: goto L25;
                case 66: goto L22;
                case 248: goto L18;
                case 250: goto L8;
                default: goto L49;
            };     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L8:
            int r10 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            if ((r4 & 256) == 256) goto L14;
            if (r12.getBytesUntilLimit() <= 0) goto L14;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            r4 = r4 | 256;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L14:
            if (r12.getBytesUntilLimit() <= 0) goto L16;
            this.versionRequirement_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L14
        L16:
            r12.popLimit(r10);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L18:
            if ((r4 & 256) == 256) goto L20;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            r4 = r4 | 256;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L20:
            this.versionRequirement_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L22:
            if ((r4 & 128) == 128) goto L24;
            this.annotation_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            r4 = r4 | 128;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L24:
            this.annotation_.add((Annotation) r12.readMessage(Annotation.PARSER, r13));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L25:
            this.bitField0_ |= 32;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.expandedTypeId_ = r12.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L27:
            if ((this.bitField0_ & 16) != 16) goto L29;
            r9 = this.expandedType_.toBuilder();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L29:
            Type r11 = (Type) r12.readMessage(Type.PARSER, r13);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.expandedType_ = r11;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            if (r9 == null) goto L32;
            r9.mergeFrom(r11);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.expandedType_ = r9.buildPartial();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L32:
            this.bitField0_ |= 16;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L33:
            this.bitField0_ |= 8;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.underlyingTypeId_ = r12.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L35:
            if ((this.bitField0_ & 4) != 4) goto L37;
            r9 = this.underlyingType_.toBuilder();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L37:
            Type r14 = (Type) r12.readMessage(Type.PARSER, r13);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.underlyingType_ = r14;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            if (r9 == null) goto L40;
            r9.mergeFrom(r14);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.underlyingType_ = r9.buildPartial();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L40:
            this.bitField0_ |= 4;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L42:
            if ((r4 & 4) == 4) goto L44;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            r4 = r4 | 4;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L44:
            this.typeParameter_.add((TypeParameter) r12.readMessage(TypeParameter.PARSER, r13));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L45:
            this.bitField0_ |= 2;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.name_ = r12.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L46:
            this.bitField0_ |= 1;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.flags_ = r12.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L48:
            r3 = true;
            goto L4
        L49:
            if (parseUnknownField(r12, r2, r13, r8) == true) goto L4;
        L51:
            th = move-exception;
            if ((r4 & 4) != 4) goto L63;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L63:
            if ((r4 & 128) != 128) goto L66;
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        L66:
            if ((r4 & 256) != 256) goto L95;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L95:
            r2.flush();     // Catch: IOException -> L92 Throwable -> L70
        L70:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L69:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L53:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L51
        L56:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L51
        L76:
            if ((r4 & 4) != 4) goto L79;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L79:
            if ((r4 & 128) != 128) goto L82;
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        L82:
            if ((r4 & 256) != 256) goto L97;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L97:
            r2.flush();     // Catch: IOException -> L91 Throwable -> L86
        L86:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L85:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            TypeAlias r0 = new TypeAlias(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeAlias> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getName() {
            return this.name_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int r1) {
            return this.typeParameter_.get(r1);
        }

        public boolean hasUnderlyingType() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        public boolean hasUnderlyingTypeId() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        public boolean hasExpandedType() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getExpandedType() {
            return this.expandedType_;
        }

        public boolean hasExpandedTypeId() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public Annotation getAnnotation(int r1) {
            return this.annotation_.get(r1);
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            int r1 = 0;
        L14:
            if (r1 >= getTypeParameterCount()) goto L21;
            if (getTypeParameter(r1).isInitialized() == false) goto L17;
            r1 = r1 + 1;
            goto L14
        L17:
            this.memoizedIsInitialized = 0;
            return false;
        L21:
            if (hasUnderlyingType() == false) goto L27;
            if (getUnderlyingType().isInitialized() == true) goto L27;
            this.memoizedIsInitialized = 0;
            return false;
        L27:
            if (hasExpandedType() == true) goto L29;
        L32:
            int r2 = 0;
        L34:
            if (r2 >= getAnnotationCount()) goto L41;
            if (getAnnotation(r2).isInitialized() == false) goto L37;
            r2 = r2 + 1;
            goto L34
        L37:
            this.memoizedIsInitialized = 0;
            return false;
        L41:
            if (extensionsAreInitialized() == true) goto L44;
            this.memoizedIsInitialized = 0;
            return false;
        L44:
            this.memoizedIsInitialized = 1;
            return true;
        L29:
            if (getExpandedType().isInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r6) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r6.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r6.writeInt32(2, this.name_);
        L8:
            int r1 = 0;
            int r2 = 0;
        L10:
            if (r2 >= this.typeParameter_.size()) goto L13;
            r6.writeMessage(3, this.typeParameter_.get(r2));
            r2 = r2 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r6.writeMessage(4, this.underlyingType_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r6.writeInt32(5, this.underlyingTypeId_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r6.writeMessage(6, this.expandedType_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L24;
            r6.writeInt32(7, this.expandedTypeId_);
        L24:
            int r3 = 0;
        L26:
            if (r3 >= this.annotation_.size()) goto L29;
            r6.writeMessage(8, this.annotation_.get(r3));
            r3 = r3 + 1;
        L29:
            if (r1 >= this.versionRequirement_.size()) goto L31;
            r6.writeInt32(31, this.versionRequirement_.get(r1).intValue());
            r1 = r1 + 1;
            goto L29
        L31:
            r0.writeUntil(200, r6);
            r6.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r1 = r1 + CodedOutputStream.computeInt32Size(2, this.name_);
        L12:
            int r3 = 0;
        L14:
            if (r3 >= this.typeParameter_.size()) goto L17;
            r1 = r1 + CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(r3));
            r3 = r3 + 1;
            goto L14
        L17:
            if ((this.bitField0_ & 4) != 4) goto L20;
            r1 = r1 + CodedOutputStream.computeMessageSize(4, this.underlyingType_);
        L20:
            if ((this.bitField0_ & 8) != 8) goto L23;
            r1 = r1 + CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
        L23:
            if ((this.bitField0_ & 16) != 16) goto L26;
            r1 = r1 + CodedOutputStream.computeMessageSize(6, this.expandedType_);
        L26:
            if ((this.bitField0_ & 32) != 32) goto L28;
            r1 = r1 + CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
        L28:
            int r4 = 0;
        L30:
            if (r4 >= this.annotation_.size()) goto L32;
            r1 = r1 + CodedOutputStream.computeMessageSize(8, this.annotation_.get(r4));
            r4 = r4 + 1;
            goto L30
        L32:
            int r5 = 0;
        L34:
            if (r2 >= this.versionRequirement_.size()) goto L36;
            r5 = r5 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r2).intValue());
            r2 = r2 + 1;
            goto L34
        L36:
            int r6 = (((r1 + r5) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r6;
            return r6;
        L8:
            r1 = 0;
            goto L10
        }

        public static TypeAlias parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return PARSER.parseDelimitedFrom(r1, r2);
        }

        public static Builder newBuilder() {
            return Builder.access$19000();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TypeAlias r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface TypeAliasOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface TypeOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class TypeParameter extends GeneratedMessageLite.ExtendableMessage<TypeParameter> implements TypeParameterOrBuilder {
        public static Parser<TypeParameter> PARSER;
        private static final TypeParameter defaultInstance = null;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private boolean reified_;
        private final ByteString unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        private List<Integer> upperBoundId_;
        private List<Type> upperBound_;
        private Variance variance_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeParameter, Builder> implements TypeParameterOrBuilder {
            private int bitField0_;
            private int id_;
            private int name_;
            private boolean reified_;
            private List<Integer> upperBoundId_;
            private List<Type> upperBound_;
            private Variance variance_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$7600() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((TypeParameter) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.variance_ = Variance.INV;
                this.upperBound_ = Collections.emptyList();
                this.upperBoundId_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeParameter build() {
                TypeParameter r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public TypeParameter buildPartial() {
                TypeParameter r0 = new TypeParameter(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                TypeParameter.access$7802(r0, this.id_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                TypeParameter.access$7902(r0, this.name_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                TypeParameter.access$8002(r0, this.reified_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                TypeParameter.access$8102(r0, this.variance_);
                if ((this.bitField0_ & 16) != 16) goto L18;
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                this.bitField0_ &= -17;
            L18:
                TypeParameter.access$8202(r0, this.upperBound_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                this.bitField0_ &= -33;
            L21:
                TypeParameter.access$8302(r0, this.upperBoundId_);
                TypeParameter.access$8402(r0, r3);
                return r0;
            }

            public Builder mergeFrom(TypeParameter r3) {
                if (r3 != TypeParameter.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasId() == false) goto L9;
                setId(r3.getId());
            L9:
                if (r3.hasName() == false) goto L12;
                setName(r3.getName());
            L12:
                if (r3.hasReified() == false) goto L15;
                setReified(r3.getReified());
            L15:
                if (r3.hasVariance() == false) goto L18;
                setVariance(r3.getVariance());
            L18:
                if (TypeParameter.access$8200(r3).isEmpty() == true) goto L24;
                if (this.upperBound_.isEmpty() == false) goto L22;
                this.upperBound_ = TypeParameter.access$8200(r3);
                this.bitField0_ &= -17;
                goto L24
            L22:
                ensureUpperBoundIsMutable();
                this.upperBound_.addAll(TypeParameter.access$8200(r3));
            L24:
                if (TypeParameter.access$8300(r3).isEmpty() == false) goto L26;
            L29:
                mergeExtensionFields(r3);
                setUnknownFields(getUnknownFields().concat(TypeParameter.access$8500(r3)));
                return this;
            L26:
                if (this.upperBoundId_.isEmpty() == false) goto L28;
                this.upperBoundId_ = TypeParameter.access$8300(r3);
                this.bitField0_ &= -33;
                goto L29
            L28:
                ensureUpperBoundIdIsMutable();
                this.upperBoundId_.addAll(TypeParameter.access$8300(r3));
                goto L29
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasId() == true) goto L6;
                return false;
            L6:
                if (hasName() == true) goto L8;
                return false;
            L8:
                int r0 = 0;
            L10:
                if (r0 >= getUpperBoundCount()) goto L16;
                if (getUpperBound(r0).isInitialized() == false) goto L13;
                r0 = r0 + 1;
                goto L10
            L13:
                return false;
            L16:
                if (extensionsAreInitialized() == true) goto L18;
                return false;
            L18:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                TypeParameter r0 = null;
                TypeParameter r5 = TypeParameter.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeParameter r6 = (TypeParameter) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public boolean hasId() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public Builder setId(int r2) {
                this.bitField0_ |= 1;
                this.id_ = r2;
                return this;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public Builder setName(int r2) {
                this.bitField0_ |= 2;
                this.name_ = r2;
                return this;
            }

            public Builder setReified(boolean r2) {
                this.bitField0_ |= 4;
                this.reified_ = r2;
                return this;
            }

            public Builder setVariance(Variance r2) {
                r2.getClass();
                this.bitField0_ |= 8;
                this.variance_ = r2;
                return this;
            }

            private void ensureUpperBoundIsMutable() {
                if ((this.bitField0_ & 16) == 16) goto L6;
                this.upperBound_ = new ArrayList(this.upperBound_);
                this.bitField0_ |= 16;
                return;
            }

            public int getUpperBoundCount() {
                return this.upperBound_.size();
            }

            public Type getUpperBound(int r1) {
                return this.upperBound_.get(r1);
            }

            private void ensureUpperBoundIdIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.upperBoundId_ = new ArrayList(this.upperBoundId_);
                this.bitField0_ |= 32;
                return;
            }
        }

        public static final enum Variance extends Enum<Variance> implements Internal.EnumLite {
            private static final /* synthetic */ Variance[] $VALUES = null;
            public static final Variance IN = null;
            public static final Variance INV = null;
            public static final Variance OUT = null;
            private static Internal.EnumLiteMap<Variance> internalValueMap;
            private final int value;

            public static Variance valueOf(String r1) {
                return (Variance) Enum.valueOf(Variance.class, r1);
            }

            public static Variance[] values() {
                return (Variance[]) $VALUES.clone();
            }

            static {
                Variance r0 = new Variance("IN", 0, 0, 0);
                IN = r0;
                Variance r1 = new Variance("OUT", 1, 1, 1);
                OUT = r1;
                Variance r3 = new Variance("INV", 2, 2, 2);
                INV = r3;
                $VALUES = new Variance[]{r0, r1, r3};
                internalValueMap = new AnonymousClass1();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return INV;
            L12:
                return OUT;
            L14:
                return IN;
            }

            private Variance(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.value = r4;
            }
        }

        /* synthetic */ TypeParameter(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ TypeParameter(GeneratedMessageLite.ExtendableBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$7802(TypeParameter r0, int r1) {
            r0.id_ = r1;
            return r1;
        }

        static /* synthetic */ int access$7902(TypeParameter r0, int r1) {
            r0.name_ = r1;
            return r1;
        }

        static /* synthetic */ boolean access$8002(TypeParameter r0, boolean r1) {
            r0.reified_ = r1;
            return r1;
        }

        static /* synthetic */ Variance access$8102(TypeParameter r0, Variance r1) {
            r0.variance_ = r1;
            return r1;
        }

        static /* synthetic */ List access$8200(TypeParameter r0) {
            return r0.upperBound_;
        }

        static /* synthetic */ List access$8202(TypeParameter r0, List r1) {
            r0.upperBound_ = r1;
            return r1;
        }

        static /* synthetic */ List access$8300(TypeParameter r0) {
            return r0.upperBoundId_;
        }

        static /* synthetic */ List access$8302(TypeParameter r0, List r1) {
            r0.upperBoundId_ = r1;
            return r1;
        }

        static /* synthetic */ int access$8402(TypeParameter r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$8500(TypeParameter r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private TypeParameter(GeneratedMessageLite.ExtendableBuilder<TypeParameter, ?> r2) {
            super(r2);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private TypeParameter(boolean r1) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        private TypeParameter(CodedInputStream r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            int r4 = 0;
        L4:
            if (r3 == true) goto L70;
            int r7 = r12.readTag();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if (r7 == 0) goto L47;
            if (r7 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.id_ = r12.readInt32();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L9:
            if (r7 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.name_ = r12.readInt32();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L11:
            if (r7 != 24) goto L12;
            this.bitField0_ |= 4;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.reified_ = r12.readBool();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L12:
            if (r7 != 32) goto L14;
            int r9 = r12.readEnum();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            Variance r10 = Variance.valueOf(r9);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if (r10 == null) goto L41;
            this.bitField0_ |= 8;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.variance_ = r10;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L41:
            r2.writeRawVarint32(r7);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r2.writeRawVarint32(r9);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L14:
            if (r7 != 42) goto L16;
            if ((r4 & 16) == 16) goto L38;
            this.upperBound_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r4 = r4 | 16;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L38:
            this.upperBound_.add((Type) r12.readMessage(Type.PARSER, r13));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L16:
            if (r7 != 48) goto L18;
            if ((r4 & 32) == 32) goto L34;
            this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r4 = r4 | 32;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L34:
            this.upperBoundId_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L18:
            if (r7 != 50) goto L20;
            int r8 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if ((r4 & 32) == 32) goto L28;
            if (r12.getBytesUntilLimit() <= 0) goto L28;
            this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r4 = r4 | 32;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L28:
            if (r12.getBytesUntilLimit() <= 0) goto L30;
            this.upperBoundId_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L28
        L30:
            r12.popLimit(r8);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L20:
            if (parseUnknownField(r12, r2, r13, r7) == true) goto L4;
        L47:
            r3 = true;
            goto L4
        L48:
            th = move-exception;
            if ((r4 & 16) != 16) goto L60;
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        L60:
            if ((r4 & 32) != 32) goto L86;
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
        L86:
            r2.flush();     // Catch: IOException -> L83 Throwable -> L64
        L64:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L63:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L50:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L48
        L53:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L48
        L70:
            if ((r4 & 16) != 16) goto L73;
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        L73:
            if ((r4 & 32) != 32) goto L88;
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
        L88:
            r2.flush();     // Catch: IOException -> L82 Throwable -> L77
        L77:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L76:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            TypeParameter r0 = new TypeParameter(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeParameter> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasReified() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getReified() {
            return this.reified_;
        }

        public boolean hasVariance() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public Variance getVariance() {
            return this.variance_;
        }

        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public Type getUpperBound(int r1) {
            return this.upperBound_.get(r1);
        }

        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (hasId() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasName() == true) goto L16;
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            int r1 = 0;
        L18:
            if (r1 >= getUpperBoundCount()) goto L25;
            if (getUpperBound(r1).isInitialized() == false) goto L21;
            r1 = r1 + 1;
            goto L18
        L21:
            this.memoizedIsInitialized = 0;
            return false;
        L25:
            if (extensionsAreInitialized() == true) goto L28;
            this.memoizedIsInitialized = 0;
            return false;
        L28:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r6) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r6.writeInt32(1, this.id_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r6.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r6.writeBool(3, this.reified_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L14;
            r6.writeEnum(4, this.variance_.getNumber());
        L14:
            int r1 = 0;
            int r2 = 0;
        L16:
            if (r2 >= this.upperBound_.size()) goto L19;
            r6.writeMessage(5, this.upperBound_.get(r2));
            r2 = r2 + 1;
            goto L16
        L19:
            if (getUpperBoundIdList().size() <= 0) goto L22;
            r6.writeRawVarint32(50);
            r6.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
        L22:
            if (r1 >= this.upperBoundId_.size()) goto L24;
            r6.writeInt32NoTag(this.upperBoundId_.get(r1).intValue());
            r1 = r1 + 1;
            goto L22
        L24:
            r0.writeUntil(1000, r6);
            r6.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r1 = r1 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r1 = r1 + CodedOutputStream.computeBoolSize(3, this.reified_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r1 = r1 + CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
        L18:
            int r3 = 0;
        L20:
            if (r3 >= this.upperBound_.size()) goto L22;
            r1 = r1 + CodedOutputStream.computeMessageSize(5, this.upperBound_.get(r3));
            r3 = r3 + 1;
            goto L20
        L22:
            int r4 = 0;
        L24:
            if (r2 >= this.upperBoundId_.size()) goto L26;
            r4 = r4 + CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(r2).intValue());
            r2 = r2 + 1;
            goto L24
        L26:
            int r5 = r1 + r4;
            if (getUpperBoundIdList().isEmpty() == true) goto L29;
            r5 = (r5 + 1) + CodedOutputStream.computeInt32SizeNoTag(r4);
        L29:
            this.upperBoundIdMemoizedSerializedSize = r4;
            int r6 = (r5 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r6;
            return r6;
        L8:
            r1 = 0;
            goto L10
        }

        public static Builder newBuilder() {
            return Builder.access$7600();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TypeParameter r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface TypeParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class TypeTable extends GeneratedMessageLite implements TypeTableOrBuilder {
        public static Parser<TypeTable> PARSER;
        private static final TypeTable defaultInstance = null;
        private int bitField0_;
        private int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Type> type_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<TypeTable, Builder> implements TypeTableOrBuilder {
            private int bitField0_;
            private int firstNullable_;
            private List<Type> type_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$12600() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((TypeTable) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.type_ = Collections.emptyList();
                this.firstNullable_ = -1;
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeTable build() {
                TypeTable r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public TypeTable buildPartial() {
                TypeTable r0 = new TypeTable(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) != 1) goto L5;
                this.type_ = Collections.unmodifiableList(this.type_);
                this.bitField0_ &= -2;
            L5:
                TypeTable.access$12802(r0, this.type_);
                if ((r1 & 2) == 2) goto L9;
                r3 = 0;
            L9:
                TypeTable.access$12902(r0, this.firstNullable_);
                TypeTable.access$13002(r0, r3);
                return r0;
            }

            public Builder mergeFrom(TypeTable r3) {
                if (r3 != TypeTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (TypeTable.access$12800(r3).isEmpty() == true) goto L12;
                if (this.type_.isEmpty() == false) goto L10;
                this.type_ = TypeTable.access$12800(r3);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureTypeIsMutable();
                this.type_.addAll(TypeTable.access$12800(r3));
            L12:
                if (r3.hasFirstNullable() == false) goto L14;
                setFirstNullable(r3.getFirstNullable());
            L14:
                setUnknownFields(getUnknownFields().concat(TypeTable.access$13100(r3)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r1 = 0;
            L4:
                if (r1 >= getTypeCount()) goto L9;
                if (getType(r1).isInitialized() == false) goto L7;
                r1 = r1 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                TypeTable r0 = null;
                TypeTable r5 = TypeTable.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeTable r6 = (TypeTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            private void ensureTypeIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.type_ = new ArrayList(this.type_);
                this.bitField0_ |= 1;
                return;
            }

            public int getTypeCount() {
                return this.type_.size();
            }

            public Type getType(int r1) {
                return this.type_.get(r1);
            }

            public Builder setFirstNullable(int r2) {
                this.bitField0_ |= 2;
                this.firstNullable_ = r2;
                return this;
            }
        }

        /* synthetic */ TypeTable(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ TypeTable(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ List access$12800(TypeTable r0) {
            return r0.type_;
        }

        static /* synthetic */ List access$12802(TypeTable r0, List r1) {
            r0.type_ = r1;
            return r1;
        }

        static /* synthetic */ int access$12902(TypeTable r0, int r1) {
            r0.firstNullable_ = r1;
            return r1;
        }

        static /* synthetic */ int access$13002(TypeTable r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$13100(TypeTable r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private TypeTable(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private TypeTable(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        private TypeTable(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            boolean r4 = false;
        L3:
            if (r3 == true) goto L39;
            int r5 = r8.readTag();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            if (r5 == 0) goto L19;
            if (r5 != 10) goto L9;
            if ((r4 & true) == true) goto L17;
            this.type_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            r4 = r4 | true;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
        L17:
            this.type_.add((Type) r8.readMessage(Type.PARSER, r9));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            goto L3
        L9:
            if (r5 != 16) goto L11;
            this.bitField0_ |= 1;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            this.firstNullable_ = r8.readInt32();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            goto L3
        L11:
            if (parseUnknownField(r8, r2, r9, r5) == true) goto L3;
        L19:
            r3 = true;
            goto L3
        L20:
            th = move-exception;
            if ((r4 & true) != true) goto L51;
            this.type_ = Collections.unmodifiableList(this.type_);
        L51:
            r2.flush();     // Catch: IOException -> L49 Throwable -> L33
        L33:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L32:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L25:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L20
        L22:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L20
        L39:
            if ((r4 & true) != true) goto L54;
            this.type_ = Collections.unmodifiableList(this.type_);
        L54:
            r2.flush();     // Catch: IOException -> L48 Throwable -> L43
        L43:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L42:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            TypeTable r0 = new TypeTable(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeTable> getParserForType() {
            return PARSER;
        }

        public List<Type> getTypeList() {
            return this.type_;
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        public Type getType(int r1) {
            return this.type_.get(r1);
        }

        public boolean hasFirstNullable() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getFirstNullable() {
            return this.firstNullable_;
        }

        private void initFields() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L8;
            return false;
        L8:
            int r1 = 0;
        L10:
            if (r1 >= getTypeCount()) goto L16;
            if (getType(r1).isInitialized() == false) goto L13;
            r1 = r1 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r4) throws IOException {
            getSerializedSize();
            int r0 = 0;
        L4:
            if (r0 >= this.type_.size()) goto L7;
            r4.writeMessage(1, this.type_.get(r0));
            r0 = r0 + 1;
            goto L4
        L7:
            if ((this.bitField0_ & 1) != 1) goto L9;
            r4.writeInt32(2, this.firstNullable_);
        L9:
            r4.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            int r2 = 0;
        L7:
            if (r1 >= this.type_.size()) goto L10;
            r2 = r2 + CodedOutputStream.computeMessageSize(1, this.type_.get(r1));
            r1 = r1 + 1;
            goto L7
        L10:
            if ((this.bitField0_ & 1) != 1) goto L12;
            r2 = r2 + CodedOutputStream.computeInt32Size(2, this.firstNullable_);
        L12:
            int r3 = r2 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public static Builder newBuilder() {
            return Builder.access$12600();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TypeTable r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface TypeTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class ValueParameter extends GeneratedMessageLite.ExtendableMessage<ValueParameter> implements ValueParameterOrBuilder {
        public static Parser<ValueParameter> PARSER;
        private static final ValueParameter defaultInstance = null;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int typeId_;
        private Type type_;
        private final ByteString unknownFields;
        private int varargElementTypeId_;
        private Type varargElementType_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ValueParameter, Builder> implements ValueParameterOrBuilder {
            private int bitField0_;
            private int flags_;
            private int name_;
            private int typeId_;
            private Type type_;
            private int varargElementTypeId_;
            private Type varargElementType_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$17900() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((ValueParameter) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.type_ = Type.getDefaultInstance();
                this.varargElementType_ = Type.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public ValueParameter build() {
                ValueParameter r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public ValueParameter buildPartial() {
                ValueParameter r0 = new ValueParameter(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                ValueParameter.access$18102(r0, this.flags_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                ValueParameter.access$18202(r0, this.name_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                ValueParameter.access$18302(r0, this.type_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                ValueParameter.access$18402(r0, this.typeId_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                ValueParameter.access$18502(r0, this.varargElementType_);
                if ((r1 & 32) != 32) goto L21;
                r3 = r3 | 32;
            L21:
                ValueParameter.access$18602(r0, this.varargElementTypeId_);
                ValueParameter.access$18702(r0, r3);
                return r0;
            }

            public Builder mergeFrom(ValueParameter r2) {
                if (r2 != ValueParameter.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r2.hasFlags() == false) goto L9;
                setFlags(r2.getFlags());
            L9:
                if (r2.hasName() == false) goto L12;
                setName(r2.getName());
            L12:
                if (r2.hasType() == false) goto L15;
                mergeType(r2.getType());
            L15:
                if (r2.hasTypeId() == false) goto L18;
                setTypeId(r2.getTypeId());
            L18:
                if (r2.hasVarargElementType() == false) goto L21;
                mergeVarargElementType(r2.getVarargElementType());
            L21:
                if (r2.hasVarargElementTypeId() == false) goto L23;
                setVarargElementTypeId(r2.getVarargElementTypeId());
            L23:
                mergeExtensionFields(r2);
                setUnknownFields(getUnknownFields().concat(ValueParameter.access$18800(r2)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L6;
                return false;
            L6:
                if (hasType() == false) goto L11;
                if (getType().isInitialized() == true) goto L11;
                return false;
            L11:
                if (hasVarargElementType() == false) goto L16;
                if (getVarargElementType().isInitialized() == true) goto L16;
                return false;
            L16:
                if (extensionsAreInitialized() == true) goto L18;
                return false;
            L18:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                ValueParameter r0 = null;
                ValueParameter r5 = ValueParameter.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                ValueParameter r6 = (ValueParameter) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public Builder setFlags(int r2) {
                this.bitField0_ |= 1;
                this.flags_ = r2;
                return this;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public Builder setName(int r2) {
                this.bitField0_ |= 2;
                this.name_ = r2;
                return this;
            }

            public boolean hasType() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getType() {
                return this.type_;
            }

            public Builder mergeType(Type r4) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.type_ = r4;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.type_ == Type.getDefaultInstance()) goto L7;
                this.type_ = Type.newBuilder(this.type_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setTypeId(int r2) {
                this.bitField0_ |= 8;
                this.typeId_ = r2;
                return this;
            }

            public boolean hasVarargElementType() {
                if ((this.bitField0_ & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            public Type getVarargElementType() {
                return this.varargElementType_;
            }

            public Builder mergeVarargElementType(Type r4) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.varargElementType_ = r4;
            L8:
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.varargElementType_ == Type.getDefaultInstance()) goto L7;
                this.varargElementType_ = Type.newBuilder(this.varargElementType_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder setVarargElementTypeId(int r2) {
                this.bitField0_ |= 32;
                this.varargElementTypeId_ = r2;
                return this;
            }
        }

        /* synthetic */ ValueParameter(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ ValueParameter(GeneratedMessageLite.ExtendableBuilder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$18102(ValueParameter r0, int r1) {
            r0.flags_ = r1;
            return r1;
        }

        static /* synthetic */ int access$18202(ValueParameter r0, int r1) {
            r0.name_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$18302(ValueParameter r0, Type r1) {
            r0.type_ = r1;
            return r1;
        }

        static /* synthetic */ int access$18402(ValueParameter r0, int r1) {
            r0.typeId_ = r1;
            return r1;
        }

        static /* synthetic */ Type access$18502(ValueParameter r0, Type r1) {
            r0.varargElementType_ = r1;
            return r1;
        }

        static /* synthetic */ int access$18602(ValueParameter r0, int r1) {
            r0.varargElementTypeId_ = r1;
            return r1;
        }

        static /* synthetic */ int access$18702(ValueParameter r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$18800(ValueParameter r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private ValueParameter(GeneratedMessageLite.ExtendableBuilder<ValueParameter, ?> r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private ValueParameter(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public ValueParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        private ValueParameter(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L69;
            int r4 = r10.readTag();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if (r4 == 0) goto L40;
            if (r4 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.flags_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L9:
            if (r4 != 16) goto L10;
            this.bitField0_ |= 2;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.name_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L10:
            Type.Builder r8 = null;
            if (r4 != 26) goto L13;
            if ((this.bitField0_ & 4) != 4) goto L33;
            r8 = this.type_.toBuilder();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L33:
            Type r5 = (Type) r10.readMessage(Type.PARSER, r11);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.type_ = r5;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if (r8 == null) goto L36;
            r8.mergeFrom(r5);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.type_ = r8.buildPartial();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L36:
            this.bitField0_ |= 4;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L13:
            if (r4 != 34) goto L15;
            if ((this.bitField0_ & 16) != 16) goto L26;
            r8 = this.varargElementType_.toBuilder();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L26:
            Type r6 = (Type) r10.readMessage(Type.PARSER, r11);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.varargElementType_ = r6;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if (r8 == null) goto L29;
            r8.mergeFrom(r6);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.varargElementType_ = r8.buildPartial();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L29:
            this.bitField0_ |= 16;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L15:
            if (r4 != 40) goto L17;
            this.bitField0_ |= 8;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.typeId_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L17:
            if (r4 != 48) goto L19;
            this.bitField0_ |= 32;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.varargElementTypeId_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L19:
            if (parseUnknownField(r10, r2, r11, r4) == true) goto L3;
        L40:
            r3 = true;
            goto L3
        L41:
            th = move-exception;
            r2.flush();     // Catch: IOException -> L63 Throwable -> L51
        L51:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L50:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L43:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L41
        L46:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L41
        L69:
            r2.flush();     // Catch: IOException -> L64 Throwable -> L58
        L58:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L57:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            ValueParameter r0 = new ValueParameter(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<ValueParameter> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasType() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getType() {
            return this.type_;
        }

        public boolean hasTypeId() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean hasVarargElementType() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        public boolean hasVarargElementTypeId() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        private void initFields() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasType() == false) goto L19;
            if (getType().isInitialized() == true) goto L19;
            this.memoizedIsInitialized = 0;
            return false;
        L19:
            if (hasVarargElementType() == false) goto L25;
            if (getVarargElementType().isInitialized() == true) goto L25;
            this.memoizedIsInitialized = 0;
            return false;
        L25:
            if (extensionsAreInitialized() == true) goto L28;
            this.memoizedIsInitialized = 0;
            return false;
        L28:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r5.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r5.writeMessage(3, this.type_);
        L12:
            if ((this.bitField0_ & 16) != 16) goto L15;
            r5.writeMessage(4, this.varargElementType_);
        L15:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r5.writeInt32(5, this.typeId_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L20;
            r5.writeInt32(6, this.varargElementTypeId_);
        L20:
            r0.writeUntil(200, r5);
            r5.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L9;
            r2 = 0 + CodedOutputStream.computeInt32Size(1, this.flags_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r2 = r2 + CodedOutputStream.computeInt32Size(2, this.name_);
        L12:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r2 = r2 + CodedOutputStream.computeMessageSize(3, this.type_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            r2 = r2 + CodedOutputStream.computeMessageSize(4, this.varargElementType_);
        L18:
            if ((this.bitField0_ & 8) != 8) goto L21;
            r2 = r2 + CodedOutputStream.computeInt32Size(5, this.typeId_);
        L21:
            if ((this.bitField0_ & 32) != 32) goto L23;
            r2 = r2 + CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
        L23:
            int r3 = (r2 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public static Builder newBuilder() {
            return Builder.access$17900();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ValueParameter r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface ValueParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class VersionRequirement extends GeneratedMessageLite implements VersionRequirementOrBuilder {
        public static Parser<VersionRequirement> PARSER;
        private static final VersionRequirement defaultInstance = null;
        private int bitField0_;
        private int errorCode_;
        private Level level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int message_;
        private final ByteString unknownFields;
        private int versionFull_;
        private VersionKind versionKind_;
        private int version_;

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirement, Builder> implements VersionRequirementOrBuilder {
            private int bitField0_;
            private int errorCode_;
            private Level level_;
            private int message_;
            private int versionFull_;
            private VersionKind versionKind_;
            private int version_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$21000() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((VersionRequirement) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.level_ = Level.ERROR;
                this.versionKind_ = VersionKind.LANGUAGE_VERSION;
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public VersionRequirement build() {
                VersionRequirement r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public VersionRequirement buildPartial() {
                VersionRequirement r0 = new VersionRequirement(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                VersionRequirement.access$21202(r0, this.version_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                VersionRequirement.access$21302(r0, this.versionFull_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                VersionRequirement.access$21402(r0, this.level_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                VersionRequirement.access$21502(r0, this.errorCode_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                VersionRequirement.access$21602(r0, this.message_);
                if ((r1 & 32) != 32) goto L21;
                r3 = r3 | 32;
            L21:
                VersionRequirement.access$21702(r0, this.versionKind_);
                VersionRequirement.access$21802(r0, r3);
                return r0;
            }

            public Builder mergeFrom(VersionRequirement r2) {
                if (r2 != VersionRequirement.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r2.hasVersion() == false) goto L9;
                setVersion(r2.getVersion());
            L9:
                if (r2.hasVersionFull() == false) goto L12;
                setVersionFull(r2.getVersionFull());
            L12:
                if (r2.hasLevel() == false) goto L15;
                setLevel(r2.getLevel());
            L15:
                if (r2.hasErrorCode() == false) goto L18;
                setErrorCode(r2.getErrorCode());
            L18:
                if (r2.hasMessage() == false) goto L21;
                setMessage(r2.getMessage());
            L21:
                if (r2.hasVersionKind() == false) goto L23;
                setVersionKind(r2.getVersionKind());
            L23:
                setUnknownFields(getUnknownFields().concat(VersionRequirement.access$21900(r2)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                VersionRequirement r0 = null;
                VersionRequirement r5 = VersionRequirement.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                VersionRequirement r6 = (VersionRequirement) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public Builder setVersion(int r2) {
                this.bitField0_ |= 1;
                this.version_ = r2;
                return this;
            }

            public Builder setVersionFull(int r2) {
                this.bitField0_ |= 2;
                this.versionFull_ = r2;
                return this;
            }

            public Builder setLevel(Level r2) {
                r2.getClass();
                this.bitField0_ |= 4;
                this.level_ = r2;
                return this;
            }

            public Builder setErrorCode(int r2) {
                this.bitField0_ |= 8;
                this.errorCode_ = r2;
                return this;
            }

            public Builder setMessage(int r2) {
                this.bitField0_ |= 16;
                this.message_ = r2;
                return this;
            }

            public Builder setVersionKind(VersionKind r2) {
                r2.getClass();
                this.bitField0_ |= 32;
                this.versionKind_ = r2;
                return this;
            }
        }

        public static final enum Level extends Enum<Level> implements Internal.EnumLite {
            private static final /* synthetic */ Level[] $VALUES = null;
            public static final Level ERROR = null;
            public static final Level HIDDEN = null;
            public static final Level WARNING = null;
            private static Internal.EnumLiteMap<Level> internalValueMap;
            private final int value;

            public static Level valueOf(String r1) {
                return (Level) Enum.valueOf(Level.class, r1);
            }

            public static Level[] values() {
                return (Level[]) $VALUES.clone();
            }

            static {
                Level r0 = new Level("WARNING", 0, 0, 0);
                WARNING = r0;
                Level r1 = new Level("ERROR", 1, 1, 1);
                ERROR = r1;
                Level r3 = new Level("HIDDEN", 2, 2, 2);
                HIDDEN = r3;
                $VALUES = new Level[]{r0, r1, r3};
                internalValueMap = new AnonymousClass1();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return HIDDEN;
            L12:
                return ERROR;
            L14:
                return WARNING;
            }

            private Level(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.value = r4;
            }
        }

        public static final enum VersionKind extends Enum<VersionKind> implements Internal.EnumLite {
            private static final /* synthetic */ VersionKind[] $VALUES = null;
            public static final VersionKind API_VERSION = null;
            public static final VersionKind COMPILER_VERSION = null;
            public static final VersionKind LANGUAGE_VERSION = null;
            private static Internal.EnumLiteMap<VersionKind> internalValueMap;
            private final int value;

            public static VersionKind valueOf(String r1) {
                return (VersionKind) Enum.valueOf(VersionKind.class, r1);
            }

            public static VersionKind[] values() {
                return (VersionKind[]) $VALUES.clone();
            }

            static {
                VersionKind r0 = new VersionKind("LANGUAGE_VERSION", 0, 0, 0);
                LANGUAGE_VERSION = r0;
                VersionKind r1 = new VersionKind("COMPILER_VERSION", 1, 1, 1);
                COMPILER_VERSION = r1;
                VersionKind r3 = new VersionKind("API_VERSION", 2, 2, 2);
                API_VERSION = r3;
                $VALUES = new VersionKind[]{r0, r1, r3};
                internalValueMap = new AnonymousClass1();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static VersionKind valueOf(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return API_VERSION;
            L12:
                return COMPILER_VERSION;
            L14:
                return LANGUAGE_VERSION;
            }

            private VersionKind(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.value = r4;
            }
        }

        /* synthetic */ VersionRequirement(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ VersionRequirement(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$21202(VersionRequirement r0, int r1) {
            r0.version_ = r1;
            return r1;
        }

        static /* synthetic */ int access$21302(VersionRequirement r0, int r1) {
            r0.versionFull_ = r1;
            return r1;
        }

        static /* synthetic */ Level access$21402(VersionRequirement r0, Level r1) {
            r0.level_ = r1;
            return r1;
        }

        static /* synthetic */ int access$21502(VersionRequirement r0, int r1) {
            r0.errorCode_ = r1;
            return r1;
        }

        static /* synthetic */ int access$21602(VersionRequirement r0, int r1) {
            r0.message_ = r1;
            return r1;
        }

        static /* synthetic */ VersionKind access$21702(VersionRequirement r0, VersionKind r1) {
            r0.versionKind_ = r1;
            return r1;
        }

        static /* synthetic */ int access$21802(VersionRequirement r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$21900(VersionRequirement r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private VersionRequirement(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private VersionRequirement(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static VersionRequirement getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirement getDefaultInstanceForType() {
            return defaultInstance;
        }

        private VersionRequirement(CodedInputStream r9, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L63;
            int r4 = r9.readTag();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            if (r4 == 0) goto L34;
            if (r4 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.version_ = r9.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L9:
            if (r4 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.versionFull_ = r9.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L11:
            if (r4 != 24) goto L13;
            int r5 = r9.readEnum();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            Level r6 = Level.valueOf(r5);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            if (r6 == null) goto L29;
            this.bitField0_ |= 4;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.level_ = r6;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L29:
            r2.writeRawVarint32(r4);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            r2.writeRawVarint32(r5);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L13:
            if (r4 != 32) goto L15;
            this.bitField0_ |= 8;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.errorCode_ = r9.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L15:
            if (r4 != 40) goto L17;
            this.bitField0_ |= 16;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.message_ = r9.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L17:
            if (r4 != 48) goto L19;
            int r7 = r9.readEnum();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            VersionKind r8 = VersionKind.valueOf(r7);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            if (r8 == null) goto L23;
            this.bitField0_ |= 32;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.versionKind_ = r8;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L23:
            r2.writeRawVarint32(r4);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            r2.writeRawVarint32(r7);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L19:
            if (parseUnknownField(r9, r2, r10, r4) == true) goto L3;
        L34:
            r3 = true;
            goto L3
        L35:
            th = move-exception;
            r2.flush();     // Catch: IOException -> L57 Throwable -> L45
        L45:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L44:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L40:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L35
        L37:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L35
        L63:
            r2.flush();     // Catch: IOException -> L58 Throwable -> L52
        L52:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L51:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            VersionRequirement r0 = new VersionRequirement(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<VersionRequirement> getParserForType() {
            return PARSER;
        }

        public boolean hasVersion() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public int getVersion() {
            return this.version_;
        }

        public boolean hasVersionFull() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getVersionFull() {
            return this.versionFull_;
        }

        public boolean hasLevel() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public Level getLevel() {
            return this.level_;
        }

        public boolean hasErrorCode() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public boolean hasMessage() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public int getMessage() {
            return this.message_;
        }

        public boolean hasVersionKind() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public VersionKind getVersionKind() {
            return this.versionKind_;
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r4) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r4.writeInt32(1, this.version_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r4.writeInt32(2, this.versionFull_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r4.writeEnum(3, this.level_.getNumber());
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r4.writeInt32(4, this.errorCode_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            r4.writeInt32(5, this.message_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L20;
            r4.writeEnum(6, this.versionKind_.getNumber());
        L20:
            r4.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L9;
            r2 = 0 + CodedOutputStream.computeInt32Size(1, this.version_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r2 = r2 + CodedOutputStream.computeInt32Size(2, this.versionFull_);
        L12:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r2 = r2 + CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
        L15:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r2 = r2 + CodedOutputStream.computeInt32Size(4, this.errorCode_);
        L18:
            if ((this.bitField0_ & 16) != 16) goto L21;
            r2 = r2 + CodedOutputStream.computeInt32Size(5, this.message_);
        L21:
            if ((this.bitField0_ & 32) != 32) goto L23;
            r2 = r2 + CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
        L23:
            int r3 = r2 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public static Builder newBuilder() {
            return Builder.access$21000();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(VersionRequirement r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface VersionRequirementOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class VersionRequirementTable extends GeneratedMessageLite implements VersionRequirementTableOrBuilder {
        public static Parser<VersionRequirementTable> PARSER;
        private static final VersionRequirementTable defaultInstance = null;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<VersionRequirement> requirement_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirementTable, Builder> implements VersionRequirementTableOrBuilder {
            private int bitField0_;
            private List<VersionRequirement> requirement_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$22100() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2081clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                return mergeFrom((VersionRequirementTable) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.requirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public VersionRequirementTable build() {
                VersionRequirementTable r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public VersionRequirementTable buildPartial() {
                VersionRequirementTable r0 = new VersionRequirementTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
                this.bitField0_ &= -2;
            L5:
                VersionRequirementTable.access$22302(r0, this.requirement_);
                return r0;
            }

            public Builder mergeFrom(VersionRequirementTable r3) {
                if (r3 != VersionRequirementTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (VersionRequirementTable.access$22300(r3).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(VersionRequirementTable.access$22400(r3)));
                return this;
            L8:
                if (this.requirement_.isEmpty() == false) goto L10;
                this.requirement_ = VersionRequirementTable.access$22300(r3);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureRequirementIsMutable();
                this.requirement_.addAll(VersionRequirementTable.access$22300(r3));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                VersionRequirementTable r0 = null;
                VersionRequirementTable r5 = VersionRequirementTable.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                VersionRequirementTable r6 = (VersionRequirementTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                mergeFrom(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            private void ensureRequirementIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.requirement_ = new ArrayList(this.requirement_);
                this.bitField0_ |= 1;
                return;
            }
        }

        /* synthetic */ VersionRequirementTable(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ VersionRequirementTable(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ List access$22300(VersionRequirementTable r0) {
            return r0.requirement_;
        }

        static /* synthetic */ List access$22302(VersionRequirementTable r0, List r1) {
            r0.requirement_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$22400(VersionRequirementTable r0) {
            return r0.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private VersionRequirementTable(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private VersionRequirementTable(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static VersionRequirementTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirementTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        private VersionRequirementTable(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            boolean r4 = false;
        L3:
            if (r3 == true) goto L36;
            int r5 = r8.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r5 == 0) goto L16;
            if (r5 != 10) goto L9;
            if ((r4 & true) == true) goto L14;
            this.requirement_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.requirement_.add((VersionRequirement) r8.readMessage(VersionRequirement.PARSER, r9));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r8, r2, r9, r5) == true) goto L3;
        L16:
            r3 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r4 & true) != true) goto L48;
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
        L48:
            r2.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L29:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r4 & true) != true) goto L51;
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
        L51:
            r2.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L39:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            VersionRequirementTable r0 = new VersionRequirementTable(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        public List<VersionRequirement> getRequirementList() {
            return this.requirement_;
        }

        public int getRequirementCount() {
            return this.requirement_.size();
        }

        private void initFields() {
            this.requirement_ = Collections.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r4) throws IOException {
            getSerializedSize();
            int r0 = 0;
        L4:
            if (r0 >= this.requirement_.size()) goto L6;
            r4.writeMessage(1, this.requirement_.get(r0));
            r0 = r0 + 1;
            goto L4
        L6:
            r4.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            int r2 = 0;
        L7:
            if (r1 >= this.requirement_.size()) goto L9;
            r2 = r2 + CodedOutputStream.computeMessageSize(1, this.requirement_.get(r1));
            r1 = r1 + 1;
            goto L7
        L9:
            int r3 = r2 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public static Builder newBuilder() {
            return Builder.access$22100();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(VersionRequirementTable r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface VersionRequirementTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final enum Visibility extends Enum<Visibility> implements Internal.EnumLite {
        private static final /* synthetic */ Visibility[] $VALUES = null;
        public static final Visibility INTERNAL = null;
        public static final Visibility LOCAL = null;
        public static final Visibility PRIVATE = null;
        public static final Visibility PRIVATE_TO_THIS = null;
        public static final Visibility PROTECTED = null;
        public static final Visibility PUBLIC = null;
        private static Internal.EnumLiteMap<Visibility> internalValueMap;
        private final int value;

        public static Visibility valueOf(String r1) {
            return (Visibility) Enum.valueOf(Visibility.class, r1);
        }

        public static Visibility[] values() {
            return (Visibility[]) $VALUES.clone();
        }

        static {
            Visibility r0 = new Visibility("INTERNAL", 0, 0, 0);
            INTERNAL = r0;
            Visibility r1 = new Visibility("PRIVATE", 1, 1, 1);
            PRIVATE = r1;
            Visibility r3 = new Visibility("PROTECTED", 2, 2, 2);
            PROTECTED = r3;
            Visibility r5 = new Visibility("PUBLIC", 3, 3, 3);
            PUBLIC = r5;
            Visibility r7 = new Visibility("PRIVATE_TO_THIS", 4, 4, 4);
            PRIVATE_TO_THIS = r7;
            Visibility r9 = new Visibility("LOCAL", 5, 5, 5);
            LOCAL = r9;
            $VALUES = new Visibility[]{r0, r1, r3, r5, r7, r9};
            internalValueMap = new AnonymousClass1();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return LOCAL;
        L18:
            return PRIVATE_TO_THIS;
        L20:
            return PUBLIC;
        L22:
            return PROTECTED;
        L24:
            return PRIVATE;
        L26:
            return INTERNAL;
        }

        private Visibility(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.value = r4;
        }
    }
}
