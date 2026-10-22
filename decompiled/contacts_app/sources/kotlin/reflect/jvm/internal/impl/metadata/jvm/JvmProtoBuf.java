package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* JADX INFO: loaded from: classes4.dex */
public final class JvmProtoBuf {
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> anonymousObjectOriginName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> classLocalVariable = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> classModuleName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmMethodSignature> constructorSignature = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, Integer> flags = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, Boolean> isRaw = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> jvmClassFlags = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, Integer> lambdaClassOriginName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmMethodSignature> methodSignature = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> packageLocalVariable = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageModuleName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmPropertySignature> propertySignature = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation = null;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class JvmFieldSignature extends GeneratedMessageLite implements JvmFieldSignatureOrBuilder {
        public static Parser<JvmFieldSignature> PARSER;
        private static final JvmFieldSignature defaultInstance = null;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmFieldSignature, Builder> implements JvmFieldSignatureOrBuilder {
            private int bitField0_;
            private int desc_;
            private int name_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$2500() {
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
                return mergeFrom((JvmFieldSignature) r1);
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

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmFieldSignature getDefaultInstanceForType() {
                return JvmFieldSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmFieldSignature build() {
                JvmFieldSignature r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public JvmFieldSignature buildPartial() {
                JvmFieldSignature r0 = new JvmFieldSignature(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                JvmFieldSignature.access$2702(r0, this.name_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                JvmFieldSignature.access$2802(r0, this.desc_);
                JvmFieldSignature.access$2902(r0, r3);
                return r0;
            }

            public Builder mergeFrom(JvmFieldSignature r2) {
                if (r2 != JvmFieldSignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r2.hasName() == false) goto L9;
                setName(r2.getName());
            L9:
                if (r2.hasDesc() == false) goto L11;
                setDesc(r2.getDesc());
            L11:
                setUnknownFields(getUnknownFields().concat(JvmFieldSignature.access$3000(r2)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                JvmFieldSignature r0 = null;
                JvmFieldSignature r5 = JvmFieldSignature.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmFieldSignature r6 = (JvmFieldSignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

            public Builder setDesc(int r2) {
                this.bitField0_ |= 2;
                this.desc_ = r2;
                return this;
            }
        }

        /* synthetic */ JvmFieldSignature(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ JvmFieldSignature(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$2702(JvmFieldSignature r0, int r1) {
            r0.name_ = r1;
            return r1;
        }

        static /* synthetic */ int access$2802(JvmFieldSignature r0, int r1) {
            r0.desc_ = r1;
            return r1;
        }

        static /* synthetic */ int access$2902(JvmFieldSignature r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$3000(JvmFieldSignature r0) {
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

        private JvmFieldSignature(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private JvmFieldSignature(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static JvmFieldSignature getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmFieldSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        private JvmFieldSignature(CodedInputStream r7, ExtensionRegistryLite r8) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L43;
            int r4 = r7.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r4 == 0) goto L16;
            if (r4 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.name_ = r7.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (r4 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.desc_ = r7.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L11:
            if (parseUnknownField(r7, r2, r8, r4) == true) goto L3;
        L16:
            r3 = true;
            goto L3
        L17:
            th = move-exception;
            r2.flush();     // Catch: IOException -> L39 Throwable -> L27
        L27:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L26:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L43:
            r2.flush();     // Catch: IOException -> L40 Throwable -> L34
        L34:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L33:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            JvmFieldSignature r0 = new JvmFieldSignature(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmFieldSignature> getParserForType() {
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

        public boolean hasDesc() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getDesc() {
            return this.desc_;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
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
        public void writeTo(CodedOutputStream r3) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r3.writeInt32(1, this.name_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r3.writeInt32(2, this.desc_);
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
            r2 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L11;
            r2 = r2 + CodedOutputStream.computeInt32Size(2, this.desc_);
        L11:
            int r3 = r2 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public static Builder newBuilder() {
            return Builder.access$2500();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(JvmFieldSignature r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface JvmFieldSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class JvmMethodSignature extends GeneratedMessageLite implements JvmMethodSignatureOrBuilder {
        public static Parser<JvmMethodSignature> PARSER;
        private static final JvmMethodSignature defaultInstance = null;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmMethodSignature, Builder> implements JvmMethodSignatureOrBuilder {
            private int bitField0_;
            private int desc_;
            private int name_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$1800() {
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
                return mergeFrom((JvmMethodSignature) r1);
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

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmMethodSignature getDefaultInstanceForType() {
                return JvmMethodSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmMethodSignature build() {
                JvmMethodSignature r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public JvmMethodSignature buildPartial() {
                JvmMethodSignature r0 = new JvmMethodSignature(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                JvmMethodSignature.access$2002(r0, this.name_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                JvmMethodSignature.access$2102(r0, this.desc_);
                JvmMethodSignature.access$2202(r0, r3);
                return r0;
            }

            public Builder mergeFrom(JvmMethodSignature r2) {
                if (r2 != JvmMethodSignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r2.hasName() == false) goto L9;
                setName(r2.getName());
            L9:
                if (r2.hasDesc() == false) goto L11;
                setDesc(r2.getDesc());
            L11:
                setUnknownFields(getUnknownFields().concat(JvmMethodSignature.access$2300(r2)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                JvmMethodSignature r0 = null;
                JvmMethodSignature r5 = JvmMethodSignature.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmMethodSignature r6 = (JvmMethodSignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

            public Builder setDesc(int r2) {
                this.bitField0_ |= 2;
                this.desc_ = r2;
                return this;
            }
        }

        /* synthetic */ JvmMethodSignature(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ JvmMethodSignature(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int access$2002(JvmMethodSignature r0, int r1) {
            r0.name_ = r1;
            return r1;
        }

        static /* synthetic */ int access$2102(JvmMethodSignature r0, int r1) {
            r0.desc_ = r1;
            return r1;
        }

        static /* synthetic */ int access$2202(JvmMethodSignature r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$2300(JvmMethodSignature r0) {
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

        private JvmMethodSignature(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private JvmMethodSignature(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static JvmMethodSignature getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmMethodSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        private JvmMethodSignature(CodedInputStream r7, ExtensionRegistryLite r8) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L43;
            int r4 = r7.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r4 == 0) goto L16;
            if (r4 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.name_ = r7.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (r4 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.desc_ = r7.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L11:
            if (parseUnknownField(r7, r2, r8, r4) == true) goto L3;
        L16:
            r3 = true;
            goto L3
        L17:
            th = move-exception;
            r2.flush();     // Catch: IOException -> L39 Throwable -> L27
        L27:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L26:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L43:
            r2.flush();     // Catch: IOException -> L40 Throwable -> L34
        L34:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L33:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            JvmMethodSignature r0 = new JvmMethodSignature(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmMethodSignature> getParserForType() {
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

        public boolean hasDesc() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public int getDesc() {
            return this.desc_;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
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
        public void writeTo(CodedOutputStream r3) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r3.writeInt32(1, this.name_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r3.writeInt32(2, this.desc_);
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
            r2 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L11;
            r2 = r2 + CodedOutputStream.computeInt32Size(2, this.desc_);
        L11:
            int r3 = r2 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public static Builder newBuilder() {
            return Builder.access$1800();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(JvmMethodSignature r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface JvmMethodSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class JvmPropertySignature extends GeneratedMessageLite implements JvmPropertySignatureOrBuilder {
        public static Parser<JvmPropertySignature> PARSER;
        private static final JvmPropertySignature defaultInstance = null;
        private int bitField0_;
        private JvmMethodSignature delegateMethod_;
        private JvmFieldSignature field_;
        private JvmMethodSignature getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private JvmMethodSignature setter_;
        private JvmMethodSignature syntheticMethod_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmPropertySignature, Builder> implements JvmPropertySignatureOrBuilder {
            private int bitField0_;
            private JvmMethodSignature delegateMethod_;
            private JvmFieldSignature field_;
            private JvmMethodSignature getter_;
            private JvmMethodSignature setter_;
            private JvmMethodSignature syntheticMethod_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$3200() {
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
                return mergeFrom((JvmPropertySignature) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.field_ = JvmFieldSignature.getDefaultInstance();
                this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
                this.getter_ = JvmMethodSignature.getDefaultInstance();
                this.setter_ = JvmMethodSignature.getDefaultInstance();
                this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
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
            public JvmPropertySignature getDefaultInstanceForType() {
                return JvmPropertySignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmPropertySignature build() {
                JvmPropertySignature r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public JvmPropertySignature buildPartial() {
                JvmPropertySignature r0 = new JvmPropertySignature(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                JvmPropertySignature.access$3402(r0, this.field_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                JvmPropertySignature.access$3502(r0, this.syntheticMethod_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                JvmPropertySignature.access$3602(r0, this.getter_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                JvmPropertySignature.access$3702(r0, this.setter_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                JvmPropertySignature.access$3802(r0, this.delegateMethod_);
                JvmPropertySignature.access$3902(r0, r3);
                return r0;
            }

            public Builder mergeFrom(JvmPropertySignature r2) {
                if (r2 != JvmPropertySignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r2.hasField() == false) goto L9;
                mergeField(r2.getField());
            L9:
                if (r2.hasSyntheticMethod() == false) goto L12;
                mergeSyntheticMethod(r2.getSyntheticMethod());
            L12:
                if (r2.hasGetter() == false) goto L15;
                mergeGetter(r2.getGetter());
            L15:
                if (r2.hasSetter() == false) goto L18;
                mergeSetter(r2.getSetter());
            L18:
                if (r2.hasDelegateMethod() == false) goto L20;
                mergeDelegateMethod(r2.getDelegateMethod());
            L20:
                setUnknownFields(getUnknownFields().concat(JvmPropertySignature.access$4000(r2)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                JvmPropertySignature r0 = null;
                JvmPropertySignature r5 = JvmPropertySignature.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmPropertySignature r6 = (JvmPropertySignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

            public Builder mergeField(JvmFieldSignature r4) {
                if ((this.bitField0_ & 1) == 1) goto L5;
            L7:
                this.field_ = r4;
            L8:
                this.bitField0_ |= 1;
                return this;
            L5:
                if (this.field_ == JvmFieldSignature.getDefaultInstance()) goto L7;
                this.field_ = JvmFieldSignature.newBuilder(this.field_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder mergeSyntheticMethod(JvmMethodSignature r4) {
                if ((this.bitField0_ & 2) == 2) goto L5;
            L7:
                this.syntheticMethod_ = r4;
            L8:
                this.bitField0_ |= 2;
                return this;
            L5:
                if (this.syntheticMethod_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.syntheticMethod_ = JvmMethodSignature.newBuilder(this.syntheticMethod_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder mergeGetter(JvmMethodSignature r4) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.getter_ = r4;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.getter_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.getter_ = JvmMethodSignature.newBuilder(this.getter_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder mergeSetter(JvmMethodSignature r4) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.setter_ = r4;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.setter_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.setter_ = JvmMethodSignature.newBuilder(this.setter_).mergeFrom(r4).buildPartial();
                goto L8
            }

            public Builder mergeDelegateMethod(JvmMethodSignature r4) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.delegateMethod_ = r4;
            L8:
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.delegateMethod_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.delegateMethod_ = JvmMethodSignature.newBuilder(this.delegateMethod_).mergeFrom(r4).buildPartial();
                goto L8
            }
        }

        /* synthetic */ JvmPropertySignature(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ JvmPropertySignature(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ JvmFieldSignature access$3402(JvmPropertySignature r0, JvmFieldSignature r1) {
            r0.field_ = r1;
            return r1;
        }

        static /* synthetic */ JvmMethodSignature access$3502(JvmPropertySignature r0, JvmMethodSignature r1) {
            r0.syntheticMethod_ = r1;
            return r1;
        }

        static /* synthetic */ JvmMethodSignature access$3602(JvmPropertySignature r0, JvmMethodSignature r1) {
            r0.getter_ = r1;
            return r1;
        }

        static /* synthetic */ JvmMethodSignature access$3702(JvmPropertySignature r0, JvmMethodSignature r1) {
            r0.setter_ = r1;
            return r1;
        }

        static /* synthetic */ JvmMethodSignature access$3802(JvmPropertySignature r0, JvmMethodSignature r1) {
            r0.delegateMethod_ = r1;
            return r1;
        }

        static /* synthetic */ int access$3902(JvmPropertySignature r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$4000(JvmPropertySignature r0) {
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

        private JvmPropertySignature(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private JvmPropertySignature(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static JvmPropertySignature getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmPropertySignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        private JvmPropertySignature(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L84;
            int r4 = r8.readTag();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r4 == 0) goto L55;
            JvmMethodSignature.Builder r6 = null;
            JvmFieldSignature.Builder r7 = null;
            JvmMethodSignature.Builder r10 = null;
            JvmMethodSignature.Builder r11 = null;
            JvmMethodSignature.Builder r12 = null;
            if (r4 != 10) goto L9;
            if ((this.bitField0_ & 1) != 1) goto L50;
            r7 = this.field_.toBuilder();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L50:
            JvmFieldSignature r5 = (JvmFieldSignature) r8.readMessage(JvmFieldSignature.PARSER, r9);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.field_ = r5;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r7 == null) goto L53;
            r7.mergeFrom(r5);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.field_ = r7.buildPartial();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L53:
            this.bitField0_ |= 1;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            goto L3
        L9:
            if (r4 != 18) goto L11;
            if ((this.bitField0_ & 2) != 2) goto L43;
            r10 = this.syntheticMethod_.toBuilder();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L43:
            JvmMethodSignature r13 = (JvmMethodSignature) r8.readMessage(JvmMethodSignature.PARSER, r9);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.syntheticMethod_ = r13;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r10 == null) goto L46;
            r10.mergeFrom(r13);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.syntheticMethod_ = r10.buildPartial();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L46:
            this.bitField0_ |= 2;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            goto L3
        L11:
            if (r4 != 26) goto L13;
            if ((this.bitField0_ & 4) != 4) goto L36;
            r11 = this.getter_.toBuilder();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L36:
            JvmMethodSignature r14 = (JvmMethodSignature) r8.readMessage(JvmMethodSignature.PARSER, r9);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.getter_ = r14;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r11 == null) goto L39;
            r11.mergeFrom(r14);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.getter_ = r11.buildPartial();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L39:
            this.bitField0_ |= 4;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            goto L3
        L13:
            if (r4 != 34) goto L15;
            if ((this.bitField0_ & 8) != 8) goto L29;
            r12 = this.setter_.toBuilder();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L29:
            JvmMethodSignature r15 = (JvmMethodSignature) r8.readMessage(JvmMethodSignature.PARSER, r9);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.setter_ = r15;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r12 == null) goto L32;
            r12.mergeFrom(r15);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.setter_ = r12.buildPartial();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L32:
            this.bitField0_ |= 8;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            goto L3
        L15:
            if (r4 != 42) goto L17;
            if ((this.bitField0_ & 16) != 16) goto L22;
            r6 = this.delegateMethod_.toBuilder();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L22:
            JvmMethodSignature r16 = (JvmMethodSignature) r8.readMessage(JvmMethodSignature.PARSER, r9);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.delegateMethod_ = r16;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r6 == null) goto L25;
            r6.mergeFrom(r16);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.delegateMethod_ = r6.buildPartial();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L25:
            this.bitField0_ |= 16;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            goto L3
        L17:
            if (parseUnknownField(r8, r2, r9, r4) == true) goto L3;
        L55:
            r3 = true;
            goto L3
        L56:
            th = move-exception;
            r2.flush();     // Catch: IOException -> L78 Throwable -> L66
        L66:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L65:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L61:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L56
        L58:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L56
        L84:
            r2.flush();     // Catch: IOException -> L79 Throwable -> L73
        L73:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L72:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            JvmPropertySignature r0 = new JvmPropertySignature(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmPropertySignature> getParserForType() {
            return PARSER;
        }

        public boolean hasField() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public JvmFieldSignature getField() {
            return this.field_;
        }

        public boolean hasSyntheticMethod() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public JvmMethodSignature getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        public boolean hasGetter() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public JvmMethodSignature getGetter() {
            return this.getter_;
        }

        public boolean hasSetter() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public JvmMethodSignature getSetter() {
            return this.setter_;
        }

        public boolean hasDelegateMethod() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public JvmMethodSignature getDelegateMethod() {
            return this.delegateMethod_;
        }

        private void initFields() {
            this.field_ = JvmFieldSignature.getDefaultInstance();
            this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
            this.getter_ = JvmMethodSignature.getDefaultInstance();
            this.setter_ = JvmMethodSignature.getDefaultInstance();
            this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
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
            r4.writeMessage(1, this.field_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r4.writeMessage(2, this.syntheticMethod_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r4.writeMessage(3, this.getter_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r4.writeMessage(4, this.setter_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L17;
            r4.writeMessage(5, this.delegateMethod_);
        L17:
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
            r2 = 0 + CodedOutputStream.computeMessageSize(1, this.field_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r2 = r2 + CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
        L12:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r2 = r2 + CodedOutputStream.computeMessageSize(3, this.getter_);
        L15:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r2 = r2 + CodedOutputStream.computeMessageSize(4, this.setter_);
        L18:
            if ((this.bitField0_ & 16) != 16) goto L20;
            r2 = r2 + CodedOutputStream.computeMessageSize(5, this.delegateMethod_);
        L20:
            int r3 = r2 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public static Builder newBuilder() {
            return Builder.access$3200();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(JvmPropertySignature r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface JvmPropertySignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class StringTableTypes extends GeneratedMessageLite implements StringTableTypesOrBuilder {
        public static Parser<StringTableTypes> PARSER;
        private static final StringTableTypes defaultInstance = null;
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Record> record_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<StringTableTypes, Builder> implements StringTableTypesOrBuilder {
            private int bitField0_;
            private List<Integer> localName_;
            private List<Record> record_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$1200() {
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
                return mergeFrom((StringTableTypes) r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return mergeFrom(r1, r2);
            }

            private Builder() {
                this.record_ = Collections.emptyList();
                this.localName_ = Collections.emptyList();
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
            public StringTableTypes getDefaultInstanceForType() {
                return StringTableTypes.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public StringTableTypes build() {
                StringTableTypes r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            public StringTableTypes buildPartial() {
                StringTableTypes r0 = new StringTableTypes(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.record_ = Collections.unmodifiableList(this.record_);
                this.bitField0_ &= -2;
            L5:
                StringTableTypes.access$1402(r0, this.record_);
                if ((this.bitField0_ & 2) != 2) goto L8;
                this.localName_ = Collections.unmodifiableList(this.localName_);
                this.bitField0_ &= -3;
            L8:
                StringTableTypes.access$1502(r0, this.localName_);
                return r0;
            }

            public Builder mergeFrom(StringTableTypes r3) {
                if (r3 != StringTableTypes.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (StringTableTypes.access$1400(r3).isEmpty() == true) goto L12;
                if (this.record_.isEmpty() == false) goto L10;
                this.record_ = StringTableTypes.access$1400(r3);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureRecordIsMutable();
                this.record_.addAll(StringTableTypes.access$1400(r3));
            L12:
                if (StringTableTypes.access$1500(r3).isEmpty() == false) goto L14;
            L17:
                setUnknownFields(getUnknownFields().concat(StringTableTypes.access$1600(r3)));
                return this;
            L14:
                if (this.localName_.isEmpty() == false) goto L16;
                this.localName_ = StringTableTypes.access$1500(r3);
                this.bitField0_ &= -3;
                goto L17
            L16:
                ensureLocalNameIsMutable();
                this.localName_.addAll(StringTableTypes.access$1500(r3));
                goto L17
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                StringTableTypes r0 = null;
                StringTableTypes r5 = StringTableTypes.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                StringTableTypes r6 = (StringTableTypes) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

            private void ensureRecordIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.record_ = new ArrayList(this.record_);
                this.bitField0_ |= 1;
                return;
            }

            private void ensureLocalNameIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.localName_ = new ArrayList(this.localName_);
                this.bitField0_ |= 2;
                return;
            }
        }

        public static final class Record extends GeneratedMessageLite implements RecordOrBuilder {
            public static Parser<Record> PARSER;
            private static final Record defaultInstance = null;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Operation operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final ByteString unknownFields;

            public static final class Builder extends GeneratedMessageLite.Builder<Record, Builder> implements RecordOrBuilder {
                private int bitField0_;
                private Operation operation_;
                private int predefinedIndex_;
                private int range_;
                private List<Integer> replaceChar_;
                private Object string_;
                private List<Integer> substringIndex_;

                private void maybeForceBuilderInitialization() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                static /* synthetic */ Builder access$200() {
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
                    return mergeFrom((Record) r1);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                    return mergeFrom(r1, r2);
                }

                private Builder() {
                    this.range_ = 1;
                    this.string_ = "";
                    this.operation_ = Operation.NONE;
                    this.substringIndex_ = Collections.emptyList();
                    this.replaceChar_ = Collections.emptyList();
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
                public Record getDefaultInstanceForType() {
                    return Record.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Record build() {
                    Record r1 = buildPartial();
                    if (r1.isInitialized() == false) goto L6;
                    return r1;
                L6:
                    throw newUninitializedMessageException(r1);
                }

                public Record buildPartial() {
                    Record r0 = new Record(this, null);
                    int r1 = this.bitField0_;
                    int r3 = 1;
                    if ((r1 & 1) == 1) goto L6;
                    r3 = 0;
                L6:
                    Record.access$402(r0, this.range_);
                    if ((r1 & 2) != 2) goto L9;
                    r3 = r3 | 2;
                L9:
                    Record.access$502(r0, this.predefinedIndex_);
                    if ((r1 & 4) != 4) goto L12;
                    r3 = r3 | 4;
                L12:
                    Record.access$602(r0, this.string_);
                    if ((r1 & 8) != 8) goto L15;
                    r3 = r3 | 8;
                L15:
                    Record.access$702(r0, this.operation_);
                    if ((this.bitField0_ & 16) != 16) goto L18;
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                    this.bitField0_ &= -17;
                L18:
                    Record.access$802(r0, this.substringIndex_);
                    if ((this.bitField0_ & 32) != 32) goto L21;
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                    this.bitField0_ &= -33;
                L21:
                    Record.access$902(r0, this.replaceChar_);
                    Record.access$1002(r0, r3);
                    return r0;
                }

                public Builder mergeFrom(Record r3) {
                    if (r3 != Record.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r3.hasRange() == false) goto L9;
                    setRange(r3.getRange());
                L9:
                    if (r3.hasPredefinedIndex() == false) goto L12;
                    setPredefinedIndex(r3.getPredefinedIndex());
                L12:
                    if (r3.hasString() == false) goto L15;
                    this.bitField0_ |= 4;
                    this.string_ = Record.access$600(r3);
                L15:
                    if (r3.hasOperation() == false) goto L18;
                    setOperation(r3.getOperation());
                L18:
                    if (Record.access$800(r3).isEmpty() == true) goto L24;
                    if (this.substringIndex_.isEmpty() == false) goto L22;
                    this.substringIndex_ = Record.access$800(r3);
                    this.bitField0_ &= -17;
                    goto L24
                L22:
                    ensureSubstringIndexIsMutable();
                    this.substringIndex_.addAll(Record.access$800(r3));
                L24:
                    if (Record.access$900(r3).isEmpty() == false) goto L26;
                L29:
                    setUnknownFields(getUnknownFields().concat(Record.access$1100(r3)));
                    return this;
                L26:
                    if (this.replaceChar_.isEmpty() == false) goto L28;
                    this.replaceChar_ = Record.access$900(r3);
                    this.bitField0_ &= -33;
                    goto L29
                L28:
                    ensureReplaceCharIsMutable();
                    this.replaceChar_.addAll(Record.access$900(r3));
                    goto L29
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                    Record r0 = null;
                    Record r5 = Record.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r5 == null) goto L6;
                    mergeFrom(r5);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Record r6 = (Record) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

                public Builder setRange(int r2) {
                    this.bitField0_ |= 1;
                    this.range_ = r2;
                    return this;
                }

                public Builder setPredefinedIndex(int r2) {
                    this.bitField0_ |= 2;
                    this.predefinedIndex_ = r2;
                    return this;
                }

                public Builder setOperation(Operation r2) {
                    r2.getClass();
                    this.bitField0_ |= 8;
                    this.operation_ = r2;
                    return this;
                }

                private void ensureSubstringIndexIsMutable() {
                    if ((this.bitField0_ & 16) == 16) goto L6;
                    this.substringIndex_ = new ArrayList(this.substringIndex_);
                    this.bitField0_ |= 16;
                    return;
                }

                private void ensureReplaceCharIsMutable() {
                    if ((this.bitField0_ & 32) == 32) goto L6;
                    this.replaceChar_ = new ArrayList(this.replaceChar_);
                    this.bitField0_ |= 32;
                    return;
                }
            }

            public static final enum Operation extends Enum<Operation> implements Internal.EnumLite {
                private static final /* synthetic */ Operation[] $VALUES = null;
                public static final Operation DESC_TO_CLASS_ID = null;
                public static final Operation INTERNAL_TO_CLASS_ID = null;
                public static final Operation NONE = null;
                private static Internal.EnumLiteMap<Operation> internalValueMap;
                private final int value;

                public static Operation valueOf(String r1) {
                    return (Operation) Enum.valueOf(Operation.class, r1);
                }

                public static Operation[] values() {
                    return (Operation[]) $VALUES.clone();
                }

                static {
                    Operation r0 = new Operation("NONE", 0, 0, 0);
                    NONE = r0;
                    Operation r1 = new Operation("INTERNAL_TO_CLASS_ID", 1, 1, 1);
                    INTERNAL_TO_CLASS_ID = r1;
                    Operation r3 = new Operation("DESC_TO_CLASS_ID", 2, 2, 2);
                    DESC_TO_CLASS_ID = r3;
                    $VALUES = new Operation[]{r0, r1, r3};
                    internalValueMap = new AnonymousClass1();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Operation valueOf(int r1) {
                    if (r1 == 0) goto L14;
                    if (r1 == 1) goto L12;
                    if (r1 == 2) goto L10;
                    return null;
                L10:
                    return DESC_TO_CLASS_ID;
                L12:
                    return INTERNAL_TO_CLASS_ID;
                L14:
                    return NONE;
                }

                private Operation(String r1, int r2, int r3, int r4) {
                    super(r1, r2);
                    this.value = r4;
                }
            }

            /* synthetic */ Record(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
                this(r1, r2);
            }

            /* synthetic */ Record(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
                this(r1);
            }

            static /* synthetic */ int access$1002(Record r0, int r1) {
                r0.bitField0_ = r1;
                return r1;
            }

            static /* synthetic */ ByteString access$1100(Record r0) {
                return r0.unknownFields;
            }

            static /* synthetic */ int access$402(Record r0, int r1) {
                r0.range_ = r1;
                return r1;
            }

            static /* synthetic */ int access$502(Record r0, int r1) {
                r0.predefinedIndex_ = r1;
                return r1;
            }

            static /* synthetic */ Object access$600(Record r0) {
                return r0.string_;
            }

            static /* synthetic */ Object access$602(Record r0, Object r1) {
                r0.string_ = r1;
                return r1;
            }

            static /* synthetic */ Operation access$702(Record r0, Operation r1) {
                r0.operation_ = r1;
                return r1;
            }

            static /* synthetic */ List access$800(Record r0) {
                return r0.substringIndex_;
            }

            static /* synthetic */ List access$802(Record r0, List r1) {
                r0.substringIndex_ = r1;
                return r1;
            }

            static /* synthetic */ List access$900(Record r0) {
                return r0.replaceChar_;
            }

            static /* synthetic */ List access$902(Record r0, List r1) {
                r0.replaceChar_ = r1;
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

            private Record(GeneratedMessageLite.Builder r2) {
                super(r2);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r2.getUnknownFields();
            }

            private Record(boolean r1) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static Record getDefaultInstance() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Record getDefaultInstanceForType() {
                return defaultInstance;
            }

            private Record(CodedInputStream r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r0 = ByteString.newOutput();
                CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
                boolean r3 = false;
                int r4 = 0;
            L4:
                if (r3 == true) goto L81;
                int r7 = r12.readTag();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if (r7 == 0) goto L58;
                if (r7 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.range_ = r12.readInt32();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L9:
                if (r7 != 16) goto L11;
                this.bitField0_ |= 2;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.predefinedIndex_ = r12.readInt32();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L11:
                if (r7 != 24) goto L12;
                int r9 = r12.readEnum();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                Operation r10 = Operation.valueOf(r9);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if (r10 == null) goto L53;
                this.bitField0_ |= 8;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.operation_ = r10;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L53:
                r2.writeRawVarint32(r7);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r2.writeRawVarint32(r9);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L12:
                if (r7 != 32) goto L14;
                if ((r4 & 16) == 16) goto L50;
                this.substringIndex_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r4 = r4 | 16;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L50:
                this.substringIndex_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L14:
                if (r7 != 34) goto L16;
                int r8 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if ((r4 & 16) == 16) goto L44;
                if (r12.getBytesUntilLimit() <= 0) goto L44;
                this.substringIndex_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r4 = r4 | 16;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L44:
                if (r12.getBytesUntilLimit() <= 0) goto L46;
                this.substringIndex_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L44
            L46:
                r12.popLimit(r8);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L16:
                if (r7 != 40) goto L18;
                if ((r4 & 32) == 32) goto L37;
                this.replaceChar_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r4 = r4 | 32;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L37:
                this.replaceChar_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L18:
                if (r7 != 42) goto L20;
                int r11 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if ((r4 & 32) == 32) goto L31;
                if (r12.getBytesUntilLimit() <= 0) goto L31;
                this.replaceChar_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r4 = r4 | 32;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L31:
                if (r12.getBytesUntilLimit() <= 0) goto L33;
                this.replaceChar_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L31
            L33:
                r12.popLimit(r11);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L20:
                if (r7 != 50) goto L22;
                ByteString r14 = r12.readBytes();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.bitField0_ |= 4;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.string_ = r14;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L22:
                if (parseUnknownField(r12, r2, r13, r7) == true) goto L4;
            L58:
                r3 = true;
                goto L4
            L59:
                th = move-exception;
                if ((r4 & 16) != 16) goto L71;
                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
            L71:
                if ((r4 & 32) != 32) goto L98;
                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
            L98:
                r2.flush();     // Catch: IOException -> L94 Throwable -> L75
            L75:
                th = move-exception;
                this.unknownFields = r0.toByteString();
                throw th;
            L74:
                this.unknownFields = r0.toByteString();
                makeExtensionsImmutable();
                throw th;
            L64:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L59
            L61:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L59
            L81:
                if ((r4 & 16) != 16) goto L84;
                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
            L84:
                if ((r4 & 32) != 32) goto L96;
                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
            L96:
                r2.flush();     // Catch: IOException -> L93 Throwable -> L88
            L88:
                th = move-exception;
                this.unknownFields = r0.toByteString();
                throw th;
            L87:
                this.unknownFields = r0.toByteString();
                makeExtensionsImmutable();
            }

            static {
                PARSER = new AnonymousClass1();
                Record r0 = new Record(true);
                defaultInstance = r0;
                r0.initFields();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Record> getParserForType() {
                return PARSER;
            }

            public boolean hasRange() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public int getRange() {
                return this.range_;
            }

            public boolean hasPredefinedIndex() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            public boolean hasString() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public String getString() {
                Object r0 = this.string_;
                if ((r0 instanceof String) == true) goto L5;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L9;
                this.string_ = r2;
            L9:
                return r2;
            L5:
                return (String) r0;
            }

            public ByteString getStringBytes() {
                Object r0 = this.string_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.string_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            public boolean hasOperation() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public Operation getOperation() {
                return this.operation_;
            }

            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            private void initFields() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = Operation.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
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
                r4.writeInt32(1, this.range_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r4.writeInt32(2, this.predefinedIndex_);
            L9:
                if ((this.bitField0_ & 8) != 8) goto L12;
                r4.writeEnum(3, this.operation_.getNumber());
            L12:
                if (getSubstringIndexList().size() <= 0) goto L14;
                r4.writeRawVarint32(34);
                r4.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
            L14:
                int r0 = 0;
                int r1 = 0;
            L16:
                if (r1 >= this.substringIndex_.size()) goto L19;
                r4.writeInt32NoTag(this.substringIndex_.get(r1).intValue());
                r1 = r1 + 1;
                goto L16
            L19:
                if (getReplaceCharList().size() <= 0) goto L22;
                r4.writeRawVarint32(42);
                r4.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
            L22:
                if (r0 >= this.replaceChar_.size()) goto L25;
                r4.writeInt32NoTag(this.replaceChar_.get(r0).intValue());
                r0 = r0 + 1;
                goto L22
            L25:
                if ((this.bitField0_ & 4) != 4) goto L27;
                r4.writeBytes(6, getStringBytes());
            L27:
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
                int r1 = CodedOutputStream.computeInt32Size(1, this.range_) + 0;
            L10:
                if ((this.bitField0_ & 2) != 2) goto L13;
                r1 = r1 + CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
            L13:
                if ((this.bitField0_ & 8) != 8) goto L15;
                r1 = r1 + CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
            L15:
                int r3 = 0;
                int r4 = 0;
            L17:
                if (r3 >= this.substringIndex_.size()) goto L19;
                r4 = r4 + CodedOutputStream.computeInt32SizeNoTag(this.substringIndex_.get(r3).intValue());
                r3 = r3 + 1;
                goto L17
            L19:
                int r5 = r1 + r4;
                if (getSubstringIndexList().isEmpty() == true) goto L22;
                r5 = (r5 + 1) + CodedOutputStream.computeInt32SizeNoTag(r4);
            L22:
                this.substringIndexMemoizedSerializedSize = r4;
                int r6 = 0;
            L24:
                if (r2 >= this.replaceChar_.size()) goto L26;
                r6 = r6 + CodedOutputStream.computeInt32SizeNoTag(this.replaceChar_.get(r2).intValue());
                r2 = r2 + 1;
                goto L24
            L26:
                int r7 = r5 + r6;
                if (getReplaceCharList().isEmpty() == true) goto L29;
                r7 = (r7 + 1) + CodedOutputStream.computeInt32SizeNoTag(r6);
            L29:
                this.replaceCharMemoizedSerializedSize = r6;
                if ((this.bitField0_ & 4) != 4) goto L32;
                r7 = r7 + CodedOutputStream.computeBytesSize(6, getStringBytes());
            L32:
                int r8 = r7 + this.unknownFields.size();
                this.memoizedSerializedSize = r8;
                return r8;
            L8:
                r1 = 0;
                goto L10
            }

            public static Builder newBuilder() {
                return Builder.access$200();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(Record r1) {
                return newBuilder().mergeFrom(r1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }
        }

        public interface RecordOrBuilder extends MessageLiteOrBuilder {
        }

        /* synthetic */ StringTableTypes(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }

        /* synthetic */ StringTableTypes(GeneratedMessageLite.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ List access$1400(StringTableTypes r0) {
            return r0.record_;
        }

        static /* synthetic */ List access$1402(StringTableTypes r0, List r1) {
            r0.record_ = r1;
            return r1;
        }

        static /* synthetic */ List access$1500(StringTableTypes r0) {
            return r0.localName_;
        }

        static /* synthetic */ List access$1502(StringTableTypes r0, List r1) {
            r0.localName_ = r1;
            return r1;
        }

        static /* synthetic */ ByteString access$1600(StringTableTypes r0) {
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

        private StringTableTypes(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        private StringTableTypes(boolean r1) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static StringTableTypes getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public StringTableTypes getDefaultInstanceForType() {
            return defaultInstance;
        }

        private StringTableTypes(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
            int r4 = 0;
        L4:
            if (r3 == true) goto L57;
            int r6 = r10.readTag();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            if (r6 == 0) goto L34;
            if (r6 != 10) goto L10;
            if ((r4 & 1) == 1) goto L32;
            this.record_ = new ArrayList();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            r4 = r4 | 1;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
        L32:
            this.record_.add((Record) r10.readMessage(Record.PARSER, r11));     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L4
        L10:
            if (r6 != 40) goto L12;
            if ((r4 & 2) == 2) goto L28;
            this.localName_ = new ArrayList();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            r4 = r4 | 2;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
        L28:
            this.localName_.add(Integer.valueOf(r10.readInt32()));     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L4
        L12:
            if (r6 != 42) goto L14;
            int r7 = r10.pushLimit(r10.readRawVarint32());     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            if ((r4 & 2) == 2) goto L22;
            if (r10.getBytesUntilLimit() <= 0) goto L22;
            this.localName_ = new ArrayList();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            r4 = r4 | 2;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
        L22:
            if (r10.getBytesUntilLimit() <= 0) goto L24;
            this.localName_.add(Integer.valueOf(r10.readInt32()));     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L22
        L24:
            r10.popLimit(r7);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L4
        L14:
            if (parseUnknownField(r10, r2, r11, r6) == true) goto L4;
        L34:
            r3 = true;
            goto L4
        L35:
            th = move-exception;
            if ((r4 & 1) != 1) goto L47;
            this.record_ = Collections.unmodifiableList(this.record_);
        L47:
            if ((r4 & 2) != 2) goto L74;
            this.localName_ = Collections.unmodifiableList(this.localName_);
        L74:
            r2.flush();     // Catch: IOException -> L70 Throwable -> L51
        L51:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L50:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L40:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L35
        L37:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L35
        L57:
            if ((r4 & 1) != 1) goto L60;
            this.record_ = Collections.unmodifiableList(this.record_);
        L60:
            if ((r4 & 2) != 2) goto L72;
            this.localName_ = Collections.unmodifiableList(this.localName_);
        L72:
            r2.flush();     // Catch: IOException -> L69 Throwable -> L64
        L64:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L63:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        static {
            PARSER = new AnonymousClass1();
            StringTableTypes r0 = new StringTableTypes(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<StringTableTypes> getParserForType() {
            return PARSER;
        }

        public List<Record> getRecordList() {
            return this.record_;
        }

        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        private void initFields() {
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
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
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r1 >= this.record_.size()) goto L7;
            r5.writeMessage(1, this.record_.get(r1));
            r1 = r1 + 1;
            goto L4
        L7:
            if (getLocalNameList().size() <= 0) goto L10;
            r5.writeRawVarint32(42);
            r5.writeRawVarint32(this.localNameMemoizedSerializedSize);
        L10:
            if (r0 >= this.localName_.size()) goto L12;
            r5.writeInt32NoTag(this.localName_.get(r0).intValue());
            r0 = r0 + 1;
            goto L10
        L12:
            r5.writeRawBytes(this.unknownFields);
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
            if (r2 >= this.record_.size()) goto L9;
            r3 = r3 + CodedOutputStream.computeMessageSize(1, this.record_.get(r2));
            r2 = r2 + 1;
            goto L7
        L9:
            int r4 = 0;
        L11:
            if (r1 >= this.localName_.size()) goto L13;
            r4 = r4 + CodedOutputStream.computeInt32SizeNoTag(this.localName_.get(r1).intValue());
            r1 = r1 + 1;
            goto L11
        L13:
            int r5 = r3 + r4;
            if (getLocalNameList().isEmpty() == true) goto L16;
            r5 = (r5 + 1) + CodedOutputStream.computeInt32SizeNoTag(r4);
        L16:
            this.localNameMemoizedSerializedSize = r4;
            int r6 = r5 + this.unknownFields.size();
            this.memoizedSerializedSize = r6;
            return r6;
        }

        public static StringTableTypes parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return PARSER.parseDelimitedFrom(r1, r2);
        }

        public static Builder newBuilder() {
            return Builder.access$1200();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(StringTableTypes r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public interface StringTableTypesOrBuilder extends MessageLiteOrBuilder {
    }

    public static void registerAllExtensions(ExtensionRegistryLite r1) {
        r1.add(constructorSignature);
        r1.add(methodSignature);
        r1.add(lambdaClassOriginName);
        r1.add(propertySignature);
        r1.add(flags);
        r1.add(typeAnnotation);
        r1.add(isRaw);
        r1.add(typeParameterAnnotation);
        r1.add(classModuleName);
        r1.add(classLocalVariable);
        r1.add(anonymousObjectOriginName);
        r1.add(jvmClassFlags);
        r1.add(packageModuleName);
        r1.add(packageLocalVariable);
    }

    static {
        constructorSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Constructor.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmMethodSignature.class);
        methodSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmMethodSignature.class);
        lambdaClassOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), 0, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
        propertySignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmPropertySignature.class);
        flags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), 0, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
        typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
        isRaw = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), false, null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
        typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
        classModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
        classLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Property.class);
        anonymousObjectOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 103, WireFormat.FieldType.INT32, Integer.class);
        jvmClassFlags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 104, WireFormat.FieldType.INT32, Integer.class);
        packageModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
        packageLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Property.class);
    }
}
