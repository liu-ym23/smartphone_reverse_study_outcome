package com.google.protobuf;

import com.bytedance.apm.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class TextFormat {
    private static final String DEBUG_STRING_SILENT_MARKER = " \t ";
    private static final Parser PARSER = null;
    private static final String REDACTED_MARKER = "[REDACTED]";
    private static final Logger logger = null;

    /* JADX INFO: renamed from: com.google.protobuf.TextFormat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r0 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r0;
            r0[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L80:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L58:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L74:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L82:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L62:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L35
        L66:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L36
        L94:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L37
        L54:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L38
        L86:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L39
        L88:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L40
        L68:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L41
        L76:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L42
        L56:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;     // Catch: NoSuchFieldError -> L43
        L64:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L44
        L92:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;     // Catch: NoSuchFieldError -> L45
        L52:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L46
        L84:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;     // Catch: NoSuchFieldError -> L47
        L24:
            int[] r4 = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r4;
            r4[Descriptors.FieldDescriptor.JavaType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L48
        L72:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L49
        L78:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L50
        L90:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.STRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L51
            return;
        }
    }

    public static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(String r1) {
            super(r1);
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int column;
        private final int line;

        public ParseException(String r2) {
            this(-1, -1, r2);
        }

        public ParseException(int r3, int r4, String r5) {
            super(Integer.toString(r3) + ":" + r4 + ": " + r5);
            this.line = r3;
            this.column = r4;
        }

        public int getLine() {
            return this.line;
        }

        public int getColumn() {
            return this.column;
        }
    }

    public static class Parser {
        private static final int BUFFER_SIZE = 4096;
        private final boolean allowUnknownEnumValues;
        private final boolean allowUnknownExtensions;
        private final boolean allowUnknownFields;
        private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
        private final int recursionLimit;
        private final SingularOverwritePolicy singularOverwritePolicy;
        private final TypeRegistry typeRegistry;

        public static class Builder {
            private boolean allowUnknownEnumValues;
            private boolean allowUnknownExtensions;
            private boolean allowUnknownFields;
            private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
            private int recursionLimit;
            private SingularOverwritePolicy singularOverwritePolicy;
            private TypeRegistry typeRegistry;

            public Builder() {
                this.allowUnknownFields = false;
                this.allowUnknownEnumValues = false;
                this.allowUnknownExtensions = false;
                this.singularOverwritePolicy = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
                this.parseInfoTreeBuilder = null;
                this.typeRegistry = TypeRegistry.getEmptyTypeRegistry();
                this.recursionLimit = 100;
            }

            public Builder setTypeRegistry(TypeRegistry r1) {
                this.typeRegistry = r1;
                return this;
            }

            public Builder setAllowUnknownFields(boolean r1) {
                this.allowUnknownFields = r1;
                return this;
            }

            public Builder setAllowUnknownExtensions(boolean r1) {
                this.allowUnknownExtensions = r1;
                return this;
            }

            public Builder setSingularOverwritePolicy(SingularOverwritePolicy r1) {
                this.singularOverwritePolicy = r1;
                return this;
            }

            public Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder r1) {
                this.parseInfoTreeBuilder = r1;
                return this;
            }

            public Builder setRecursionLimit(int r1) {
                this.recursionLimit = r1;
                return this;
            }

            public Parser build() {
                return new Parser(this.typeRegistry, this.allowUnknownFields, this.allowUnknownEnumValues, this.allowUnknownExtensions, this.singularOverwritePolicy, this.parseInfoTreeBuilder, this.recursionLimit, null);
            }
        }

        public static final enum SingularOverwritePolicy extends java.lang.Enum<SingularOverwritePolicy> {
            private static final /* synthetic */ SingularOverwritePolicy[] $VALUES = null;
            public static final SingularOverwritePolicy ALLOW_SINGULAR_OVERWRITES = null;
            public static final SingularOverwritePolicy FORBID_SINGULAR_OVERWRITES = null;

            private static /* synthetic */ SingularOverwritePolicy[] $values() {
                return new SingularOverwritePolicy[]{ALLOW_SINGULAR_OVERWRITES, FORBID_SINGULAR_OVERWRITES};
            }

            private SingularOverwritePolicy(String r1, int r2) {
                super(r1, r2);
            }

            public static SingularOverwritePolicy valueOf(String r2) {
                return (SingularOverwritePolicy) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(SingularOverwritePolicy.class, r2), SingularOverwritePolicy.class, "com.obric.aiagent.plugin");
            }

            public static SingularOverwritePolicy[] values() {
                return (SingularOverwritePolicy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SingularOverwritePolicy[].class, "com.obric.aiagent.plugin");
            }

            static {
                ALLOW_SINGULAR_OVERWRITES = new SingularOverwritePolicy("ALLOW_SINGULAR_OVERWRITES", 0);
                FORBID_SINGULAR_OVERWRITES = new SingularOverwritePolicy("FORBID_SINGULAR_OVERWRITES", 1);
                $VALUES = $values();
            }
        }

        static final class UnknownField {
            final String message;
            final Type type;

            static final enum Type extends java.lang.Enum<Type> {
                private static final /* synthetic */ Type[] $VALUES = null;
                public static final Type EXTENSION = null;
                public static final Type FIELD = null;

                private static /* synthetic */ Type[] $values() {
                    return new Type[]{FIELD, EXTENSION};
                }

                private Type(String r1, int r2) {
                    super(r1, r2);
                }

                public static Type valueOf(String r2) {
                    return (Type) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(Type.class, r2), Type.class, "com.obric.aiagent.plugin");
                }

                public static Type[] values() {
                    return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.aiagent.plugin");
                }

                static {
                    FIELD = new Type("FIELD", 0);
                    EXTENSION = new Type("EXTENSION", 1);
                    $VALUES = $values();
                }
            }

            UnknownField(String r1, Type r2) {
                this.message = r1;
                this.type = r2;
            }
        }

        private void detectSilentMarker(Tokenizer r1, Descriptors.Descriptor r2, String r3) {
        }

        /* synthetic */ Parser(TypeRegistry r1, boolean r2, boolean r3, boolean r4, SingularOverwritePolicy r5, TextFormatParseInfoTree.Builder r6, int r7, AnonymousClass1 r8) {
            this(r1, r2, r3, r4, r5, r6, r7);
        }

        private Parser(TypeRegistry r1, boolean r2, boolean r3, boolean r4, SingularOverwritePolicy r5, TextFormatParseInfoTree.Builder r6, int r7) {
            this.typeRegistry = r1;
            this.allowUnknownFields = r2;
            this.allowUnknownEnumValues = r3;
            this.allowUnknownExtensions = r4;
            this.singularOverwritePolicy = r5;
            this.parseInfoTreeBuilder = r6;
            this.recursionLimit = r7;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public void merge(Readable r3, Message.Builder r4) {
            Readable r5 = (Readable) ZeusTransformUtils.wrapperContextForParams(r3, Readable.class, "com.obric.aiagent.plugin");
            Message.Builder r6 = (Message.Builder) ZeusTransformUtils.wrapperContextForParams(r4, Message.Builder.class, "com.obric.aiagent.plugin");
            merge(r5, ExtensionRegistry.getEmptyRegistry(), r6);
        }

        public void merge(CharSequence r3, Message.Builder r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            Message.Builder r6 = (Message.Builder) ZeusTransformUtils.wrapperContextForParams(r4, Message.Builder.class, "com.obric.aiagent.plugin");
            merge(r5, ExtensionRegistry.getEmptyRegistry(), r6);
        }

        public void merge(Readable r3, ExtensionRegistry r4, Message.Builder r5) {
            Readable r6 = (Readable) ZeusTransformUtils.wrapperContextForParams(r3, Readable.class, "com.obric.aiagent.plugin");
            Message.Builder r7 = (Message.Builder) ZeusTransformUtils.wrapperContextForParams(r5, Message.Builder.class, "com.obric.aiagent.plugin");
            merge(toStringBuilder(r6), r4, r7);
        }

        private static StringBuilder toStringBuilder(Readable r4) {
            Readable r5 = (Readable) ZeusTransformUtils.wrapperContextForParams(r4, Readable.class, "com.obric.aiagent.plugin");
            StringBuilder r0 = new StringBuilder();
            CharBuffer r1 = CharBuffer.allocate(4096);
        L3:
            int r2 = r5.read(r1);
            if (r2 == (-1)) goto L5;
            Java8Compatibility.flip(r1);
            r0.append(r1, 0, r2);
            goto L3
        L5:
            return r0;
        }

        private void checkUnknownFields(List<UnknownField> r8) {
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
            if (r9.isEmpty() == false) goto L5;
            return;
        L5:
            StringBuilder r0 = new StringBuilder("Input contains unknown fields and/or extensions:");
            Iterator r2 = r9.iterator();
        L7:
            if (r2.hasNext() == false) goto L10;
            r0.append('\n').append(((UnknownField) ZeusTransformUtils.preCheckCast(r2.next(), UnknownField.class, "com.obric.aiagent.plugin")).message);
            goto L7
        L10:
            if (this.allowUnknownFields == false) goto L14;
            TextFormat.access$700().warning(r0.toString());
            return;
        L14:
            if (this.allowUnknownExtensions == false) goto L26;
            Iterator r7 = r9.iterator();
            int r4 = 0;
        L17:
            if (r7.hasNext() == false) goto L22;
            if (((UnknownField) ZeusTransformUtils.preCheckCast(r7.next(), UnknownField.class, "com.obric.aiagent.plugin")).type == UnknownField.Type.FIELD) goto L20;
            r4 = r4 + 1;
            goto L17
        L20:
            boolean r10 = false;
        L23:
            if (r10 == false) goto L27;
            TextFormat.access$700().warning(r0.toString());
            return;
        L27:
            String[] r11 = ((UnknownField) ZeusTransformUtils.preCheckCast(r9.get(r4), UnknownField.class, "com.obric.aiagent.plugin")).message.split(":");
            throw new ParseException(Integer.parseInt(r11[0]), Integer.parseInt(r11[1]), r0.toString());
        L22:
            r10 = true;
            goto L23
        L26:
            r4 = 0;
            goto L27
        }

        public void merge(CharSequence r8, ExtensionRegistry r9, Message.Builder r10) {
            CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
            Message.Builder r12 = (Message.Builder) ZeusTransformUtils.wrapperContextForParams(r10, Message.Builder.class, "com.obric.aiagent.plugin");
            Tokenizer r6 = new Tokenizer(r11, null);
            MessageReflection.BuilderAdapter r13 = new MessageReflection.BuilderAdapter(r12);
            ArrayList r14 = new ArrayList();
        L4:
            if (r6.atEnd() == true) goto L6;
            mergeField(r6, r9, r13, r14, this.recursionLimit);
            goto L4
        L6:
            checkUnknownFields(r14);
        }

        private void mergeField(Tokenizer r10, ExtensionRegistry r11, MessageReflection.MergeTarget r12, List<UnknownField> r13, int r14) {
            MessageReflection.MergeTarget r5 = (MessageReflection.MergeTarget) ZeusTransformUtils.wrapperContextForParams(r12, MessageReflection.MergeTarget.class, "com.obric.aiagent.plugin");
            List<UnknownField> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
            mergeField(r10, r11, r5, this.parseInfoTreeBuilder, r7, r14);
        }

        private void mergeField(Tokenizer r19, ExtensionRegistry r20, MessageReflection.MergeTarget r21, TextFormatParseInfoTree.Builder r22, List<UnknownField> r23, int r24) {
            MessageReflection.MergeTarget r3 = (MessageReflection.MergeTarget) ZeusTransformUtils.wrapperContextForParams(r21, MessageReflection.MergeTarget.class, "com.obric.aiagent.plugin");
            List<UnknownField> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
            int r11 = r19.getLine();
            int r12 = r19.getColumn();
            Descriptors.Descriptor r6 = r3.getDescriptorForType();
            if ("google.protobuf.Any".equals(r6.getFullName()) == false) goto L12;
            if (r19.tryConsume("[") == false) goto L12;
            if (r24 < 1) goto L10;
            mergeAnyFieldValue(r19, r20, r3, r22, r7, r6, r24 - 1);
            return;
        L10:
            throw r19.parseException("Message is nested too deep");
        L12:
            if (r19.tryConsume("[") == false) goto L26;
            StringBuilder r1 = new StringBuilder(r19.consumeIdentifier());
        L15:
            if (r19.tryConsume(".") == false) goto L17;
            r1.append('.');
            r1.append(r19.consumeIdentifier());
            goto L15
        L17:
            String r2 = r1.toString();
            ExtensionRegistry.ExtensionInfo r5 = r3.findExtensionByName(r20, r2);
            if (r5 != null) goto L21;
            r7.add(new UnknownField((r19.getPreviousLine() + 1) + ":" + (r19.getPreviousColumn() + 1) + ":\t" + r6.getFullName() + ".[" + r2 + "]", UnknownField.Type.EXTENSION));
            Descriptors.FieldDescriptor r4 = null;
        L23:
            r19.consume("]");
            Descriptors.FieldDescriptor r14 = r4;
        L40:
            if (r14 != null) goto L44;
            detectSilentMarker(r19, r6, r2);
            guessFieldTypeAndSkip(r19, r6, r24);
            return;
        L44:
            if (r14.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L49;
            detectSilentMarker(r19, r6, r14.getFullName());
            r19.tryConsume(":");
            if (r22 == null) goto L48;
            consumeFieldValues(r19, r20, r3, r14, r5, r22.getBuilderForSubMessageField(r14), r7, r24);
        L50:
            if (r22 == null) goto L53;
            r22.setLocation(r14, TextFormatParseLocation.create(r11, r12));
        L53:
            if (r19.tryConsume(";") == true) goto L57;
            r19.tryConsume(",");
            return;
        L57:
            return;
        L48:
            consumeFieldValues(r19, r20, r3, r14, r5, r22, r7, r24);
            goto L50
        L49:
            detectSilentMarker(r19, r6, r14.getFullName());
            r19.consume(":");
            consumeFieldValues(r19, r20, r3, r14, r5, r22, r7, r24);
            goto L50
        L21:
            if (r5.descriptor.getContainingType() != r6) goto L25;
            r4 = r5.descriptor;
            goto L23
        L25:
            throw r19.parseExceptionPreviousToken("Extension \"" + r2 + "\" does not extend message type \"" + r6.getFullName() + "\".");
        L26:
            r2 = r19.consumeIdentifier();
            Descriptors.FieldDescriptor r8 = r6.findFieldByName(r2);
            if (r8 != null) goto L37;
            r8 = r6.findFieldByName(r2.toLowerCase(Locale.US));
            if (r8 != null) goto L31;
        L33:
            if (r8 == null) goto L37;
            if (r8.getMessageType().getName().equals(r2) == true) goto L37;
            r8 = null;
            goto L37
        L31:
            if (r8.isGroupLike() == true) goto L33;
            r8 = null;
        L37:
            if (r8 != null) goto L39;
            r7.add(new UnknownField((r19.getPreviousLine() + 1) + ":" + (r19.getPreviousColumn() + 1) + ":\t" + r6.getFullName() + "." + r2, UnknownField.Type.FIELD));
        L39:
            r14 = r8;
            r5 = null;
            goto L40
        }

        private String consumeFullTypeName(Tokenizer r4) {
            if (r4.tryConsume("[") == false) goto L5;
            String r3 = r4.consumeIdentifier();
        L8:
            if (r4.tryConsume(".") == false) goto L11;
            r3 = r3 + "." + r4.consumeIdentifier();
            goto L8
        L11:
            if (r4.tryConsume("/") == false) goto L16;
            r3 = r3 + "/" + r4.consumeIdentifier();
        L14:
            if (r4.tryConsume(".") == false) goto L16;
            r3 = r3 + "." + r4.consumeIdentifier();
        L16:
            r4.consume("]");
            return r3;
        L5:
            return r4.consumeIdentifier();
        }

        private void consumeFieldValues(Tokenizer r14, ExtensionRegistry r15, MessageReflection.MergeTarget r16, Descriptors.FieldDescriptor r17, ExtensionRegistry.ExtensionInfo r18, TextFormatParseInfoTree.Builder r19, List<UnknownField> r20, int r21) {
            MessageReflection.MergeTarget r10 = (MessageReflection.MergeTarget) ZeusTransformUtils.wrapperContextForParams(r16, MessageReflection.MergeTarget.class, "com.obric.aiagent.plugin");
            List<UnknownField> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
            if (r17.isRepeated() == true) goto L5;
        L12:
            consumeFieldValue(r14, r15, r10, r17, r18, r19, r11, r21);
            return;
        L5:
            if (r14.tryConsume("[") == false) goto L12;
            if (r14.tryConsume("]") == true) goto L15;
        L8:
            consumeFieldValue(r14, r15, r10, r17, r18, r19, r11, r21);
            if (r14.tryConsume("]") == true) goto L16;
            r14.consume(",");
            goto L8
        L16:
            return;
        }

        private void consumeFieldValue(Tokenizer r18, ExtensionRegistry r19, MessageReflection.MergeTarget r20, Descriptors.FieldDescriptor r21, ExtensionRegistry.ExtensionInfo r22, TextFormatParseInfoTree.Builder r23, List<UnknownField> r24, int r25) {
            MessageReflection.MergeTarget r11 = (MessageReflection.MergeTarget) ZeusTransformUtils.wrapperContextForParams(r20, MessageReflection.MergeTarget.class, "com.obric.aiagent.plugin");
            List<UnknownField> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
            if (this.singularOverwritePolicy == SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES) goto L5;
        L17:
            Object r3 = null;
            Message r4 = null;
            if (r21.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L41;
            if (r25 < 1) goto L39;
            if (r18.tryConsume("<") == false) goto L24;
            String r1 = ">";
        L25:
            String r15 = r1;
            if (r22 == null) goto L29;
            r4 = r22.defaultInstance;
        L29:
            MessageReflection.MergeTarget r16 = r11.newMergeTargetForField(r21, r4);
        L31:
            if (r18.tryConsume(r15) == true) goto L37;
            if (r18.atEnd() == true) goto L36;
            mergeField(r18, r19, r16, r23, r12, r25 - 1);
            goto L31
        L36:
            throw r18.parseException("Expected \"" + r15 + "\".");
        L37:
            r3 = r16.finish();
        L76:
            if (r21.isRepeated() == false) goto L78;
            r11.addRepeatedField(r21, r3);
            return;
        L78:
            r11.setField(r21, r3);
            return;
        L24:
            r18.consume("{");
            r1 = "}";
            goto L25
        L39:
            throw r18.parseException("Message is nested too deep");
        L41:
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r21.getType().ordinal()]) {
                case 1: goto L74;
                case 2: goto L74;
                case 3: goto L74;
                case 4: goto L73;
                case 5: goto L73;
                case 6: goto L73;
                case 7: goto L72;
                case 8: goto L71;
                case 9: goto L70;
                case 10: goto L69;
                case 11: goto L69;
                case 12: goto L68;
                case 13: goto L68;
                case 14: goto L67;
                case 15: goto L66;
                case 16: goto L45;
                case 17: goto L44;
                case 18: goto L44;
                default: goto L76;
            };
        L45:
            Descriptors.EnumDescriptor r0 = r21.getEnumType();
            if (r18.lookingAtInteger() == false) goto L58;
            int r2 = r18.consumeInt32();
            if (r0.isClosed() == false) goto L50;
            r3 = r0.findValueByNumber(r2);
        L51:
            if (r3 != null) goto L76;
            String r5 = "Enum type \"" + r0.getFullName() + "\" has no value with number " + r2 + '.';
            if (this.allowUnknownEnumValues == false) goto L57;
            TextFormat.access$700().warning(r5);
            return;
        L57:
            throw r18.parseExceptionPreviousToken("Enum type \"" + r0.getFullName() + "\" has no value with number " + r2 + '.');
        L50:
            r3 = r0.findValueByNumberCreatingIfUnknown(r2);
            goto L51
        L58:
            String r6 = r18.consumeIdentifier();
            r3 = r0.findValueByName(r6);
            if (r3 != null) goto L76;
            String r7 = "Enum type \"" + r0.getFullName() + "\" has no value named \"" + r6 + "\".";
            if (this.allowUnknownEnumValues == false) goto L65;
            TextFormat.access$700().warning(r7);
            return;
        L65:
            throw r18.parseExceptionPreviousToken(r7);
        L66:
            r3 = r18.consumeByteString();
            goto L76
        L67:
            r3 = r18.consumeString();
            goto L76
        L68:
            r3 = Long.valueOf(r18.consumeUInt64());
            goto L76
        L69:
            r3 = Integer.valueOf(r18.consumeUInt32());
            goto L76
        L70:
            r3 = Double.valueOf(r18.consumeDouble());
            goto L76
        L71:
            r3 = Float.valueOf(r18.consumeFloat());
            goto L76
        L72:
            r3 = Boolean.valueOf(r18.consumeBoolean());
            goto L76
        L73:
            r3 = Long.valueOf(r18.consumeInt64());
            goto L76
        L74:
            r3 = Integer.valueOf(r18.consumeInt32());
            goto L76
        L44:
            throw new RuntimeException("Can't get here.");
        L5:
            if (r21.isRepeated() == true) goto L17;
            if (r11.hasField(r21) == true) goto L16;
            if (r21.getContainingOneof() == null) goto L17;
            if (r11.hasOneof(r21.getContainingOneof()) == false) goto L17;
            Descriptors.OneofDescriptor r8 = r21.getContainingOneof();
            throw r18.parseExceptionPreviousToken("Field \"" + r21.getFullName() + "\" is specified along with field \"" + r11.getOneofFieldDescriptor(r8).getFullName() + "\", another member of oneof \"" + r8.getName() + "\".");
        L16:
            throw r18.parseExceptionPreviousToken("Non-repeated field \"" + r21.getFullName() + "\" cannot be overwritten.");
        }

        private void mergeAnyFieldValue(Tokenizer r17, ExtensionRegistry r18, MessageReflection.MergeTarget r19, TextFormatParseInfoTree.Builder r20, List<UnknownField> r21, Descriptors.Descriptor r22, int r23) {
            MessageReflection.MergeTarget r10 = (MessageReflection.MergeTarget) ZeusTransformUtils.wrapperContextForParams(r19, MessageReflection.MergeTarget.class, "com.obric.aiagent.plugin");
            List<UnknownField> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
            StringBuilder r12 = new StringBuilder();
        L3:
            r12.append(r17.consumeIdentifier());
            if (r17.tryConsume("]") == true) goto L5;
            if (r17.tryConsume("/") == true) goto L24;
            if (r17.tryConsume(".") == false) goto L29;
            r12.append(".");
            goto L3
        L29:
            throw r17.parseExceptionPreviousToken("Expected a valid type URL.");
        L24:
            r12.append("/");
            goto L3
        L5:
            detectSilentMarker(r17, r22, r12.toString());
            r17.tryConsume(":");
            if (r17.tryConsume("<") == false) goto L8;
            String r0 = ">";
        L9:
            String r13 = r0;
            String r1 = r12.toString();
            Descriptors.Descriptor r2 = this.typeRegistry.getDescriptorForTypeUrl(r1);     // Catch: InvalidProtocolBufferException -> L20
            if (r2 == null) goto L19;
            DynamicMessage.Builder r14 = DynamicMessage.getDefaultInstance(r2).newBuilderForType();
            MessageReflection.BuilderAdapter r15 = new MessageReflection.BuilderAdapter(r14);
        L14:
            if (r17.tryConsume(r13) == true) goto L16;
            mergeField(r17, r18, r15, r20, r11, r23);
            goto L14
        L16:
            r10.setField(r22.findFieldByName("type_url"), r12.toString());
            r10.setField(r22.findFieldByName("value"), r14.build().toByteString());
            return;
        L19:
            throw r17.parseException("Unable to parse Any of type: " + r1 + ". Please make sure that the TypeRegistry contains the descriptors for the given types.");
        L21:
            throw r17.parseException("Invalid valid type URL. Found: " + r1);
        L8:
            r17.consume("{");
            r0 = "}";
            goto L9
        }

        private void skipField(Tokenizer r2, Descriptors.Descriptor r3, int r4) {
            detectSilentMarker(r2, r3, consumeFullTypeName(r2));
            guessFieldTypeAndSkip(r2, r3, r4);
            if (r2.tryConsume(";") == true) goto L6;
            r2.tryConsume(",");
            return;
        }

        private void skipFieldMessage(Tokenizer r5, Descriptors.Descriptor r6, int r7) {
            if (r5.tryConsume("<") == false) goto L5;
            String r0 = ">";
        L7:
            if (r5.lookingAt(">") == true) goto L11;
            if (r5.lookingAt("}") == true) goto L11;
            skipField(r5, r6, r7);
        L11:
            r5.consume(r0);
            return;
        L5:
            r5.consume("{");
            r0 = "}";
            goto L7
        }

        private void skipFieldValue(Tokenizer r2) {
            if (r2.tryConsumeByteString() == false) goto L5;
            return;
        L5:
            if (r2.tryConsumeIdentifier() == false) goto L7;
            return;
        L7:
            if (r2.tryConsumeInt64() == false) goto L9;
            return;
        L9:
            if (r2.tryConsumeUInt64() == false) goto L11;
            return;
        L11:
            if (r2.tryConsumeDouble() == false) goto L13;
            return;
        L13:
            if (r2.tryConsumeFloat() == false) goto L16;
            return;
        L16:
            throw r2.parseException("Invalid field value: " + Tokenizer.access$900(r2));
        }

        private void guessFieldTypeAndSkip(Tokenizer r3, Descriptors.Descriptor r4, int r5) {
            boolean r0 = r3.tryConsume(":");
            if (r3.lookingAt("[") == false) goto L5;
            skipFieldShortFormedRepeated(r3, r0, r4, r5);
            return;
        L5:
            if (r0 == false) goto L12;
            if (r3.lookingAt("{") == true) goto L12;
            if (r3.lookingAt("<") == true) goto L12;
            skipFieldValue(r3);
            return;
        L12:
            if (r5 < 1) goto L16;
            skipFieldMessage(r3, r4, r5 - 1);
            return;
        L16:
            throw r3.parseException("Message is nested too deep");
        }

        private void skipFieldShortFormedRepeated(Tokenizer r3, boolean r4, Descriptors.Descriptor r5, int r6) {
            if (r3.tryConsume("[") == true) goto L5;
            return;
        L5:
            if (r3.tryConsume("]") == false) goto L8;
            return;
        L8:
            if (r3.lookingAt("{") == true) goto L17;
            if (r3.lookingAt("<") == true) goto L17;
            if (r4 == false) goto L15;
            skipFieldValue(r3);
        L20:
            if (r3.tryConsume("]") == true) goto L21;
            r3.consume(",");
            goto L8
        L21:
            return;
        L15:
            throw r3.parseException("Invalid repeated scalar field: missing \":\" before \"[\".");
        L17:
            if (r6 < 1) goto L24;
            skipFieldMessage(r3, r5, r6 - 1);
            goto L20
        L24:
            throw r3.parseException("Message is nested too deep");
        }
    }

    public static final class Printer {
        private static final Printer DEFAULT_DEBUG_FORMAT = null;
        private static final Printer DEFAULT_TEXT_FORMAT = null;
        private static final ThreadLocal<FieldReporterLevel> sensitiveFieldReportingLevel = null;
        private final boolean enablingSafeDebugFormat;
        private final boolean escapeNonAscii;
        private final ExtensionRegistryLite extensionRegistry;
        private final boolean singleLine;
        private final TypeRegistry typeRegistry;
        private final boolean useShortRepeatedPrimitives;

        static final enum FieldReporterLevel extends java.lang.Enum<FieldReporterLevel> {
            private static final /* synthetic */ FieldReporterLevel[] $VALUES = null;
            public static final FieldReporterLevel ABSTRACT_BUILDER_TO_STRING = null;
            public static final FieldReporterLevel ABSTRACT_MUTABLE_TO_STRING = null;
            public static final FieldReporterLevel ABSTRACT_TO_STRING = null;
            public static final FieldReporterLevel DEBUG_MULTILINE = null;
            public static final FieldReporterLevel DEBUG_SINGLE_LINE = null;
            public static final FieldReporterLevel LEGACY_MULTILINE = null;
            public static final FieldReporterLevel LEGACY_SINGLE_LINE = null;
            public static final FieldReporterLevel PRINT = null;
            public static final FieldReporterLevel PRINTER_PRINT_TO_STRING = null;
            public static final FieldReporterLevel PRINT_UNICODE = null;
            public static final FieldReporterLevel REPORT_ALL = null;
            public static final FieldReporterLevel REPORT_NONE = null;
            public static final FieldReporterLevel SHORT_DEBUG_STRING = null;
            public static final FieldReporterLevel TEXTFORMAT_PRINT_TO_STRING = null;
            public static final FieldReporterLevel TEXT_GENERATOR = null;
            private final int index;

            private static /* synthetic */ FieldReporterLevel[] $values() {
                return new FieldReporterLevel[]{REPORT_ALL, TEXT_GENERATOR, PRINT, PRINTER_PRINT_TO_STRING, TEXTFORMAT_PRINT_TO_STRING, PRINT_UNICODE, SHORT_DEBUG_STRING, LEGACY_MULTILINE, LEGACY_SINGLE_LINE, DEBUG_MULTILINE, DEBUG_SINGLE_LINE, ABSTRACT_TO_STRING, ABSTRACT_BUILDER_TO_STRING, ABSTRACT_MUTABLE_TO_STRING, REPORT_NONE};
            }

            public static FieldReporterLevel valueOf(String r2) {
                return (FieldReporterLevel) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(FieldReporterLevel.class, r2), FieldReporterLevel.class, "com.obric.aiagent.plugin");
            }

            public static FieldReporterLevel[] values() {
                return (FieldReporterLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FieldReporterLevel[].class, "com.obric.aiagent.plugin");
            }

            static {
                REPORT_ALL = new FieldReporterLevel("REPORT_ALL", 0, 0);
                TEXT_GENERATOR = new FieldReporterLevel("TEXT_GENERATOR", 1, 1);
                PRINT = new FieldReporterLevel("PRINT", 2, 2);
                PRINTER_PRINT_TO_STRING = new FieldReporterLevel("PRINTER_PRINT_TO_STRING", 3, 3);
                TEXTFORMAT_PRINT_TO_STRING = new FieldReporterLevel("TEXTFORMAT_PRINT_TO_STRING", 4, 4);
                PRINT_UNICODE = new FieldReporterLevel("PRINT_UNICODE", 5, 5);
                SHORT_DEBUG_STRING = new FieldReporterLevel("SHORT_DEBUG_STRING", 6, 6);
                LEGACY_MULTILINE = new FieldReporterLevel("LEGACY_MULTILINE", 7, 7);
                LEGACY_SINGLE_LINE = new FieldReporterLevel("LEGACY_SINGLE_LINE", 8, 8);
                DEBUG_MULTILINE = new FieldReporterLevel("DEBUG_MULTILINE", 9, 9);
                DEBUG_SINGLE_LINE = new FieldReporterLevel("DEBUG_SINGLE_LINE", 10, 10);
                ABSTRACT_TO_STRING = new FieldReporterLevel("ABSTRACT_TO_STRING", 11, 11);
                ABSTRACT_BUILDER_TO_STRING = new FieldReporterLevel("ABSTRACT_BUILDER_TO_STRING", 12, 12);
                ABSTRACT_MUTABLE_TO_STRING = new FieldReporterLevel("ABSTRACT_MUTABLE_TO_STRING", 13, 13);
                REPORT_NONE = new FieldReporterLevel("REPORT_NONE", 14, 14);
                $VALUES = $values();
            }

            private FieldReporterLevel(String r1, int r2, int r3) {
                super(r1, r2);
                this.index = r3;
            }
        }

        static class MapEntryAdapter implements Comparable<MapEntryAdapter> {
            private Object entry;
            private final Descriptors.FieldDescriptor keyField;
            private Message messageEntry;

            @Override // java.lang.Comparable
            public /* synthetic */ int compareTo(MapEntryAdapter r3) {
                return compareTo2((MapEntryAdapter) ZeusTransformUtils.preCheckCast(r3, MapEntryAdapter.class, "com.obric.aiagent.plugin"));
            }

            MapEntryAdapter(Object r3, Descriptors.FieldDescriptor r4) {
                if (ZeusTransformUtils.instanceOf(r3, Message.class) == false) goto L5;
                this.messageEntry = (Message) ZeusTransformUtils.preCheckCast(r3, Message.class, "com.obric.aiagent.plugin");
            L6:
                this.keyField = r4.getMessageType().findFieldByName("key");
                return;
            L5:
                this.entry = r3;
                goto L6
            }

            Object getKey() {
                Message r0 = this.messageEntry;
                if (r0 == null) goto L8;
                Descriptors.FieldDescriptor r1 = this.keyField;
                if (r1 != null) goto L7;
                return null;
            L7:
                return r0.getField(r1);
            L8:
                return null;
            }

            Object getEntry() {
                Message r0 = this.messageEntry;
                if (r0 == null) goto L6;
                return r0;
            L6:
                return this.entry;
            }

            /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(MapEntryAdapter r5) {
                Object r0 = getKey();
                Object r6 = r5.getKey();
                if (r0 != null) goto L6;
                if (r6 != null) goto L6;
                return 0;
            L6:
                if (r0 != null) goto L10;
                return -1;
            L10:
                if (r6 != null) goto L12;
                return 1;
            L12:
                int r4 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.keyField.getJavaType().ordinal()];
                if (r4 == 1) goto L28;
                if (r4 == 2) goto L26;
                if (r4 == 3) goto L24;
                if (r4 == 4) goto L22;
                return 0;
            L22:
                return ((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin")).compareTo((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin"));
            L24:
                return ((Integer) ZeusTransformUtils.preCheckCast(r0, Integer.class, "com.obric.aiagent.plugin")).compareTo((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin"));
            L26:
                return ((Long) ZeusTransformUtils.preCheckCast(r0, Long.class, "com.obric.aiagent.plugin")).compareTo((Long) ZeusTransformUtils.preCheckCast(r6, Long.class, "com.obric.aiagent.plugin"));
            L28:
                return ((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.aiagent.plugin")).compareTo((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin"));
            }
        }

        static /* synthetic */ void access$000(UnknownFieldSet r0, TextGenerator r1, boolean r2) {
            printUnknownFields(r0, r1, r2);
        }

        static /* synthetic */ Printer access$100() {
            return DEFAULT_TEXT_FORMAT;
        }

        static /* synthetic */ Printer access$200() {
            return DEFAULT_DEBUG_FORMAT;
        }

        static {
            DEFAULT_TEXT_FORMAT = new Printer(true, false, TypeRegistry.getEmptyTypeRegistry(), ExtensionRegistryLite.getEmptyRegistry(), false, false);
            DEFAULT_DEBUG_FORMAT = new Printer(true, false, TypeRegistry.getEmptyTypeRegistry(), ExtensionRegistryLite.getEmptyRegistry(), true, false);
            sensitiveFieldReportingLevel = new AnonymousClass1();
        }

        private Printer(boolean r1, boolean r2, TypeRegistry r3, ExtensionRegistryLite r4, boolean r5, boolean r6) {
            this.escapeNonAscii = r1;
            this.useShortRepeatedPrimitives = r2;
            this.typeRegistry = r3;
            this.extensionRegistry = r4;
            this.enablingSafeDebugFormat = r5;
            this.singleLine = r6;
        }

        public Printer escapingNonAscii(boolean r9) {
            return new Printer(r9, this.useShortRepeatedPrimitives, this.typeRegistry, this.extensionRegistry, this.enablingSafeDebugFormat, this.singleLine);
        }

        public Printer usingTypeRegistry(TypeRegistry r10) {
            if (this.typeRegistry != TypeRegistry.getEmptyTypeRegistry()) goto L7;
            return new Printer(this.escapeNonAscii, this.useShortRepeatedPrimitives, r10, this.extensionRegistry, this.enablingSafeDebugFormat, this.singleLine);
        L7:
            throw new IllegalArgumentException("Only one typeRegistry is allowed.");
        }

        public Printer usingExtensionRegistry(ExtensionRegistryLite r10) {
            if (this.extensionRegistry != ExtensionRegistryLite.getEmptyRegistry()) goto L7;
            return new Printer(this.escapeNonAscii, this.useShortRepeatedPrimitives, this.typeRegistry, r10, this.enablingSafeDebugFormat, this.singleLine);
        L7:
            throw new IllegalArgumentException("Only one extensionRegistry is allowed.");
        }

        Printer enablingSafeDebugFormat(boolean r9) {
            return new Printer(this.escapeNonAscii, this.useShortRepeatedPrimitives, this.typeRegistry, this.extensionRegistry, r9, this.singleLine);
        }

        public Printer usingShortRepeatedPrimitives(boolean r9) {
            return new Printer(this.escapeNonAscii, r9, this.typeRegistry, this.extensionRegistry, this.enablingSafeDebugFormat, this.singleLine);
        }

        public Printer emittingSingleLine(boolean r9) {
            return new Printer(this.escapeNonAscii, this.useShortRepeatedPrimitives, this.typeRegistry, this.extensionRegistry, this.enablingSafeDebugFormat, r9);
        }

        void setSensitiveFieldReportingLevel(FieldReporterLevel r1) {
            sensitiveFieldReportingLevel.set(r1);
        }

        public void print(MessageOrBuilder r3, Appendable r4) {
            print((MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.aiagent.plugin"), (Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.aiagent.plugin"), FieldReporterLevel.PRINT);
        }

        void print(MessageOrBuilder r3, Appendable r4, FieldReporterLevel r5) {
            MessageOrBuilder r6 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.aiagent.plugin");
            print(r6, TextFormat.access$300((Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.aiagent.plugin"), this.singleLine, r6.getDescriptorForType(), r5));
        }

        public void print(UnknownFieldSet r3, Appendable r4) {
            printUnknownFields(r3, TextFormat.access$400((Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.aiagent.plugin"), this.singleLine), this.enablingSafeDebugFormat);
        }

        private void print(MessageOrBuilder r3, TextGenerator r4) {
            MessageOrBuilder r5 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.aiagent.plugin");
            if (r5.getDescriptorForType().getFullName().equals("google.protobuf.Any") == true) goto L5;
        L7:
            printMessage(r5, r4);
            return;
        L5:
            if (printAny(r5, r4) == false) goto L7;
        }

        private void applyUnstablePrefix(Appendable r2) {
            ((Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.aiagent.plugin")).append("");     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        private boolean printAny(MessageOrBuilder r8, TextGenerator r9) {
            MessageOrBuilder r10 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r8, MessageOrBuilder.class, "com.obric.aiagent.plugin");
            Descriptors.Descriptor r0 = r10.getDescriptorForType();
            Descriptors.FieldDescriptor r3 = r0.findFieldByNumber(1);
            Descriptors.FieldDescriptor r1 = r0.findFieldByNumber(2);
            if (r3 != null) goto L5;
        L20:
            return false;
        L5:
            if (r3.getType() != Descriptors.FieldDescriptor.Type.STRING) goto L20;
            if (r1 == null) goto L20;
            if (r1.getType() != Descriptors.FieldDescriptor.Type.BYTES) goto L20;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r10.getField(r3), String.class, "com.obric.aiagent.plugin");
            if (r4.isEmpty() == false) goto L13;
            return false;
        L13:
            Object r11 = r10.getField(r1);
            Descriptors.Descriptor r2 = this.typeRegistry.getDescriptorForTypeUrl(r4);     // Catch: InvalidProtocolBufferException -> L21
            if (r2 != null) goto L17;
            return false;
        L17:
            DynamicMessage.Builder r5 = DynamicMessage.getDefaultInstance(r2).newBuilderForType();     // Catch: InvalidProtocolBufferException -> L21
            r5.mergeFrom((ByteString) ZeusTransformUtils.preCheckCast(r11, ByteString.class, "com.obric.aiagent.plugin"), this.extensionRegistry);     // Catch: InvalidProtocolBufferException -> L21
            r9.print("[");
            r9.print(r4);
            r9.print("] {");
            r9.eol();
            r9.indent();
            print(r5, r9);
            r9.outdent();
            r9.print("}");
            r9.eol();
            return true;
        }

        public String printFieldToString(Descriptors.FieldDescriptor r3, Object r4) {
            StringBuilder r0 = new StringBuilder();     // Catch: IOException -> L7
            if (this.enablingSafeDebugFormat == false) goto L5;
            applyUnstablePrefix(r0);     // Catch: IOException -> L7
        L5:
            printField(r3, r4, r0);     // Catch: IOException -> L7
            return r0.toString();
        L7:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        public void printField(Descriptors.FieldDescriptor r3, Object r4, Appendable r5) {
            printField(r3, r4, TextFormat.access$400((Appendable) ZeusTransformUtils.wrapperContextForParams(r5, Appendable.class, "com.obric.aiagent.plugin"), this.singleLine));
        }

        private void printField(Descriptors.FieldDescriptor r5, Object r6, TextGenerator r7) {
            if (r5.isMapField() == false) goto L13;
            ArrayList r0 = new ArrayList();
            Iterator r8 = ((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin")).iterator();
        L6:
            if (r8.hasNext() == false) goto L8;
            r0.add(new MapEntryAdapter(r8.next(), r5));
            goto L6
        L8:
            Collections.sort(r0);
            Iterator r9 = r0.iterator();
        L10:
            if (r9.hasNext() == false) goto L29;
            printSingleField(r5, ((MapEntryAdapter) ZeusTransformUtils.preCheckCast(r9.next(), MapEntryAdapter.class, "com.obric.aiagent.plugin")).getEntry(), r7);
            goto L10
        L29:
            return;
        L13:
            if (r5.isRepeated() == true) goto L15;
            printSingleField(r5, r6, r7);
            return;
        L15:
            if (this.useShortRepeatedPrimitives == true) goto L17;
        L19:
            Iterator r10 = ((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin")).iterator();
        L21:
            if (r10.hasNext() == false) goto L30;
            printSingleField(r5, r10.next(), r7);
            goto L21
        L30:
            return;
        L17:
            if (r5.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L19;
            printShortRepeatedField(r5, r6, r7);
        }

        public void printFieldValue(Descriptors.FieldDescriptor r3, Object r4, Appendable r5) {
            printFieldValue(r3, r4, TextFormat.access$400((Appendable) ZeusTransformUtils.wrapperContextForParams(r5, Appendable.class, "com.obric.aiagent.plugin"), this.singleLine));
        }

        private void printFieldValue(Descriptors.FieldDescriptor r3, Object r4, TextGenerator r5) {
            if (shouldRedact(r3, r5) == false) goto L9;
            r5.print(TextFormat.REDACTED_MARKER);
            if (r3.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L34;
            r5.eol();
            return;
        L34:
            return;
        L9:
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r3.getType().ordinal()]) {
                case 1: goto L32;
                case 2: goto L32;
                case 3: goto L32;
                case 4: goto L31;
                case 5: goto L31;
                case 6: goto L31;
                case 7: goto L30;
                case 8: goto L29;
                case 9: goto L28;
                case 10: goto L27;
                case 11: goto L27;
                case 12: goto L26;
                case 13: goto L26;
                case 14: goto L21;
                case 15: goto L16;
                case 16: goto L13;
                case 17: goto L11;
                case 18: goto L11;
                default: goto L46;
            };
        L11:
            print((MessageOrBuilder) ZeusTransformUtils.preCheckCast(r4, MessageOrBuilder.class, "com.obric.aiagent.plugin"), r5);
            return;
        L16:
            r5.print("\"");
            if (ZeusTransformUtils.instanceOf(r4, ByteString.class) == false) goto L19;
            r5.print(TextFormat.escapeBytes((ByteString) ZeusTransformUtils.preCheckCast(r4, ByteString.class, "com.obric.aiagent.plugin")));
        L20:
            r5.print("\"");
            return;
        L19:
            r5.print(TextFormat.escapeBytes((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.aiagent.plugin")));
            goto L20
        L21:
            r5.print("\"");
            if (this.escapeNonAscii == false) goto L24;
            String r2 = TextFormatEscaper.escapeText((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
        L25:
            r5.print(r2);
            r5.print("\"");
            return;
        L24:
            r2 = TextFormat.escapeDoubleQuotesAndBackslashes((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")).replace("\n", "\\n");
            goto L25
        L26:
            r5.print(TextFormat.unsignedToString(((Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.aiagent.plugin")).longValue()));
            return;
        L27:
            r5.print(TextFormat.unsignedToString(((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin")).intValue()));
            return;
        L28:
            r5.print(((Double) ZeusTransformUtils.preCheckCast(r4, Double.class, "com.obric.aiagent.plugin")).toString());
            return;
        L29:
            r5.print(((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).toString());
            return;
        L30:
            r5.print(((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).toString());
            return;
        L31:
            r5.print(((Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.aiagent.plugin")).toString());
            return;
        L32:
            r5.print(((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin")).toString());
            return;
        L46:
            return;
        L13:
            if (((Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r4, Descriptors.EnumValueDescriptor.class, "com.obric.aiagent.plugin")).getIndex() != (-1)) goto L15;
            r5.print(Integer.toString(((Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r4, Descriptors.EnumValueDescriptor.class, "com.obric.aiagent.plugin")).getNumber()));
            return;
        L15:
            r5.print(((Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r4, Descriptors.EnumValueDescriptor.class, "com.obric.aiagent.plugin")).getName());
        }

        private boolean shouldRedact(Descriptors.FieldDescriptor r1, TextGenerator r2) {
            if (this.enablingSafeDebugFormat == true) goto L5;
        L7:
            return false;
        L5:
            if (r1.isSensitive() == false) goto L7;
            return true;
        }

        public String printToString(MessageOrBuilder r3) {
            return printToString((MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.aiagent.plugin"), FieldReporterLevel.PRINTER_PRINT_TO_STRING);
        }

        String printToString(MessageOrBuilder r3, FieldReporterLevel r4) {
            MessageOrBuilder r5 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.aiagent.plugin");
            StringBuilder r0 = new StringBuilder();     // Catch: IOException -> L8
            if (this.enablingSafeDebugFormat == false) goto L6;
            applyUnstablePrefix(r0);     // Catch: IOException -> L8
        L6:
            print(r5, r0, r4);     // Catch: IOException -> L8
            return r0.toString();
        L8:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        public String printToString(UnknownFieldSet r3) {
            StringBuilder r0 = new StringBuilder();     // Catch: IOException -> L7
            if (this.enablingSafeDebugFormat == false) goto L5;
            applyUnstablePrefix(r0);     // Catch: IOException -> L7
        L5:
            print(r3, r0);     // Catch: IOException -> L7
            return r0.toString();
        L7:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Deprecated
        public String shortDebugString(MessageOrBuilder r3) {
            MessageOrBuilder r4 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.aiagent.plugin");
            return emittingSingleLine(true).printToString(r4, FieldReporterLevel.SHORT_DEBUG_STRING);
        }

        @Deprecated
        public String shortDebugString(Descriptors.FieldDescriptor r2, Object r3) {
            return emittingSingleLine(true).printFieldToString(r2, r3);
        }

        @Deprecated
        public String shortDebugString(UnknownFieldSet r2) {
            return emittingSingleLine(true).printToString(r2);
        }

        private static void printUnknownFieldValue(int r7, Object r8, TextGenerator r9, boolean r10) {
            int r0 = WireFormat.getTagWireType(r7);
            if (r0 != 0) goto L5;
            if (r10 == false) goto L30;
            String r11 = String.format("UNKNOWN_VARINT %s", new Object[]{TextFormat.REDACTED_MARKER});
        L31:
            r9.print(r11);
            return;
        L30:
            r11 = TextFormat.unsignedToString(((Long) ZeusTransformUtils.preCheckCast(r8, Long.class, "com.obric.aiagent.plugin")).longValue());
            goto L31
        L5:
            if (r0 != 1) goto L7;
            if (r10 == false) goto L26;
            String r12 = String.format("UNKNOWN_FIXED64 %s", new Object[]{TextFormat.REDACTED_MARKER});
        L27:
            r9.print(r12);
            return;
        L26:
            r12 = String.format((Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.aiagent.plugin"), "0x%016x", new Object[]{(Long) ZeusTransformUtils.preCheckCast(r8, Long.class, "com.obric.aiagent.plugin")});
            goto L27
        L7:
            if (r0 != 2) goto L9;
            UnknownFieldSet r13 = UnknownFieldSet.parseFrom((ByteString) ZeusTransformUtils.preCheckCast(r8, ByteString.class, "com.obric.aiagent.plugin"));     // Catch: InvalidProtocolBufferException -> L21
            r9.print("{");     // Catch: InvalidProtocolBufferException -> L21
            r9.eol();     // Catch: InvalidProtocolBufferException -> L21
            r9.indent();     // Catch: InvalidProtocolBufferException -> L21
            printUnknownFields(r13, r9, r10);     // Catch: InvalidProtocolBufferException -> L21
            r9.outdent();     // Catch: InvalidProtocolBufferException -> L21
            r9.print("}");     // Catch: InvalidProtocolBufferException -> L21
            return;
        L21:
            if (r10 == false) goto L23;
            r9.print(String.format("UNKNOWN_STRING %s", new Object[]{TextFormat.REDACTED_MARKER}));
            return;
        L23:
            r9.print("\"");
            r9.print(TextFormat.escapeBytes((ByteString) ZeusTransformUtils.preCheckCast(r8, ByteString.class, "com.obric.aiagent.plugin")));
            r9.print("\"");
            return;
        L9:
            if (r0 != 3) goto L11;
            printUnknownFields((UnknownFieldSet) ZeusTransformUtils.preCheckCast(r8, UnknownFieldSet.class, "com.obric.aiagent.plugin"), r9, r10);
            return;
        L11:
            if (r0 != 5) goto L17;
            if (r10 == false) goto L14;
            String r14 = String.format("UNKNOWN_FIXED32 %s", new Object[]{TextFormat.REDACTED_MARKER});
        L15:
            r9.print(r14);
            return;
        L14:
            r14 = String.format((Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.aiagent.plugin"), "0x%08x", new Object[]{(Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.aiagent.plugin")});
            goto L15
        L17:
            throw new IllegalArgumentException("Bad tag: " + r7);
        }

        private void printMessage(MessageOrBuilder r6, TextGenerator r7) {
            MessageOrBuilder r8 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r6, MessageOrBuilder.class, "com.obric.aiagent.plugin");
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r0 = r8.getAllFields().entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            printField((Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r2.getKey(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin"), r2.getValue(), r7);
            goto L4
        L6:
            printUnknownFields(r8.getUnknownFields(), r7, this.enablingSafeDebugFormat);
        }

        private void printShortRepeatedField(Descriptors.FieldDescriptor r3, Object r4, TextGenerator r5) {
            r5.print(r3.getName());
            r5.print(": ");
            r5.print("[");
            Iterator r6 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).iterator();
            String r0 = "";
        L4:
            if (r6.hasNext() == false) goto L6;
            Object r1 = r6.next();
            r5.print(r0);
            printFieldValue(r3, r1, r5);
            r0 = ", ";
            goto L4
        L6:
            r5.print("]");
            r5.eol();
        }

        private void printSingleField(Descriptors.FieldDescriptor r3, Object r4, TextGenerator r5) {
            if (r3.isExtension() == false) goto L16;
            r5.print("[");
            if (r3.getContainingType().getOptions().getMessageSetWireFormat() == true) goto L7;
        L13:
            r5.print(r3.getFullName());
        L14:
            r5.print("]");
        L20:
            if (r3.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L22;
            r5.print(" {");
            r5.eol();
            r5.indent();
        L23:
            printFieldValue(r3, r4, r5);
            if (r3.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L26;
            r5.outdent();
            r5.print("}");
        L26:
            r5.eol();
            return;
        L22:
            r5.print(": ");
            goto L23
        L7:
            if (r3.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L13;
            if (r3.isOptional() == false) goto L13;
            if (r3.getExtensionScope() != r3.getMessageType()) goto L13;
            r5.print(r3.getMessageType().getFullName());
            goto L14
        L16:
            if (r3.isGroupLike() == false) goto L18;
            r5.print(r3.getMessageType().getName());
            goto L20
        L18:
            r5.print(r3.getName());
            goto L20
        }

        private static void printUnknownFields(UnknownFieldSet r6, TextGenerator r7, boolean r8) {
            if (r6.isEmpty() == false) goto L5;
            return;
        L5:
            Iterator<Map.Entry<Integer, UnknownFieldSet.Field>> r9 = r6.asMap().entrySet().iterator();
        L7:
            if (r9.hasNext() == false) goto L12;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue();
            UnknownFieldSet.Field r3 = (UnknownFieldSet.Field) ZeusTransformUtils.preCheckCast(r0.getValue(), UnknownFieldSet.Field.class, "com.obric.aiagent.plugin");
            printUnknownField(r1, 0, r3.getVarintList(), r7, r8);
            printUnknownField(r1, 5, r3.getFixed32List(), r7, r8);
            printUnknownField(r1, 1, r3.getFixed64List(), r7, r8);
            printUnknownField(r1, 2, r3.getLengthDelimitedList(), r7, r8);
            Iterator<UnknownFieldSet> r2 = r3.getGroupList().iterator();
        L10:
            if (r2.hasNext() == false) goto L7;
            UnknownFieldSet r4 = (UnknownFieldSet) ZeusTransformUtils.preCheckCast(r2.next(), UnknownFieldSet.class, "com.obric.aiagent.plugin");
            r7.print(((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.aiagent.plugin")).toString());
            r7.print(" {");
            r7.eol();
            r7.indent();
            printUnknownFields(r4, r7, r8);
            r7.outdent();
            r7.print("}");
            r7.eol();
            goto L10
        }

        private static void printUnknownField(int r2, int r3, List<?> r4, TextGenerator r5, boolean r6) {
            Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Object r0 = r7.next();
            r5.print(String.valueOf(r2));
            r5.print(": ");
            printUnknownFieldValue(r3, r0, r5, r6);
            r5.eol();
            goto L4
        }
    }

    private static final class TextGenerator {
        private boolean atStartOfLine;
        private final Printer.FieldReporterLevel fieldReporterLevel;
        private final StringBuilder indent;
        private final Appendable output;
        private final Descriptors.Descriptor rootMessageType;
        private final boolean singleLineMode;

        /* synthetic */ TextGenerator(Appendable r2, boolean r3, Descriptors.Descriptor r4, Printer.FieldReporterLevel r5, AnonymousClass1 r6) {
            this((Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.aiagent.plugin"), r3, r4, r5);
        }

        private TextGenerator(Appendable r3, boolean r4, Descriptors.Descriptor r5, Printer.FieldReporterLevel r6) {
            Appendable r7 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.aiagent.plugin");
            this.indent = new StringBuilder();
            this.atStartOfLine = false;
            this.output = r7;
            this.singleLineMode = r4;
            this.rootMessageType = r5;
            this.fieldReporterLevel = r6;
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int r0 = this.indent.length();
            if (r0 == 0) goto L7;
            this.indent.setLength(r0 - 2);
            return;
        L7:
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void print(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            if (this.atStartOfLine == false) goto L9;
            this.atStartOfLine = false;
            Appendable r0 = this.output;
            if (this.singleLineMode == false) goto L7;
            CharSequence r1 = " ";
        L8:
            r0.append(r1);
            goto L9
        L7:
            r1 = this.indent;
        L9:
            this.output.append(r4);
        }

        public void eol() {
            if (this.singleLineMode == true) goto L5;
            this.output.append("\n");
        L5:
            this.atStartOfLine = true;
        }
    }

    private static final class Tokenizer {
        private int column;
        private boolean containsSilentMarkerAfterCurrentToken;
        private boolean containsSilentMarkerAfterPrevToken;
        private String currentToken;
        private int line;
        private int lineInfoTrackingPos;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final CharSequence text;

        private static boolean isAlphaUnder(char r1) {
            if ('a' > r1) goto L7;
            if (r1 > 'z') goto L7;
        L12:
            return true;
        L7:
            if ('A' > r1) goto L11;
            if (r1 <= 'Z') goto L12;
        L11:
            if (r1 == '_') goto L12;
            return false;
        }

        private static boolean isDigitPlusMinus(char r1) {
            if ('0' > r1) goto L7;
            if (r1 > '9') goto L7;
        L12:
            return true;
        L7:
            if (r1 == '+') goto L12;
            if (r1 == '-') goto L12;
            return false;
        }

        private static boolean isWhitespace(char r1) {
            if (r1 != ' ') goto L5;
        L14:
            return true;
        L5:
            if (r1 == '\f') goto L14;
            if (r1 == '\n') goto L14;
            if (r1 == '\r') goto L14;
            if (r1 == '\t') goto L14;
            return false;
        }

        /* synthetic */ Tokenizer(CharSequence r2, AnonymousClass1 r3) {
            this((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin"));
        }

        static /* synthetic */ String access$900(Tokenizer r0) {
            return r0.currentToken;
        }

        private Tokenizer(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.lineInfoTrackingPos = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.containsSilentMarkerAfterCurrentToken = false;
            this.containsSilentMarkerAfterPrevToken = false;
            this.text = r4;
            skipWhitespace();
            nextToken();
        }

        int getPreviousLine() {
            return this.previousLine;
        }

        int getPreviousColumn() {
            return this.previousColumn;
        }

        int getLine() {
            return this.line;
        }

        int getColumn() {
            return this.column;
        }

        boolean getContainsSilentMarkerAfterCurrentToken() {
            return this.containsSilentMarkerAfterCurrentToken;
        }

        boolean getContainsSilentMarkerAfterPrevToken() {
            return this.containsSilentMarkerAfterPrevToken;
        }

        boolean atEnd() {
            if (this.currentToken.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
        L3:
            int r0 = this.lineInfoTrackingPos;
            int r1 = this.pos;
            if (r0 >= r1) goto L11;
            if (this.text.charAt(r0) != '\n') goto L8;
            this.line++;
            this.column = 0;
        L9:
            this.lineInfoTrackingPos++;
            goto L3
        L8:
            this.column++;
            goto L9
        L11:
            if (r1 != this.text.length()) goto L13;
            this.currentToken = "";
            return;
        L13:
            this.currentToken = nextTokenInternal();
            skipWhitespace();
        }

        private String nextTokenInternal() {
            int r0 = this.text.length();
            int r1 = this.pos;
            char r2 = this.text.charAt(r1);
            int r3 = this.pos;
            if (isAlphaUnder(r2) == false) goto L12;
        L4:
            r3 = r3 + 1;
            if (r3 == r0) goto L54;
            char r4 = this.text.charAt(r3);
            if (isAlphaUnder(r4) == true) goto L4;
            if (isDigitPlusMinus(r4) == true) goto L4;
        L54:
            this.pos = r3;
            return this.text.subSequence(r1, r3).toString();
        L12:
            if (isDigitPlusMinus(r2) == true) goto L38;
            if (r2 == '.') goto L38;
            if (r2 == '\"') goto L22;
            if (r2 == '\'') goto L22;
            return nextTokenSingleChar();
        L22:
            r3 = r3 + 1;
            if (r3 == r0) goto L54;
            char r5 = this.text.charAt(r3);
            if (r5 == r2) goto L26;
            if (r5 == '\n') goto L54;
            if (r5 != '\\') goto L22;
            r3 = r3 + 1;
            if (r3 == r0) goto L54;
            if (this.text.charAt(r3) != '\n') goto L22;
        L26:
            r3 = r3 + 1;
        L38:
            if (r2 != '.') goto L47;
            r3 = r3 + 1;
            if (r3 != r0) goto L44;
            return nextTokenSingleChar();
        L44:
            if (isDigitPlusMinus(this.text.charAt(r3)) == true) goto L47;
            return nextTokenSingleChar();
        L47:
            r3 = r3 + 1;
            if (r3 == r0) goto L54;
            char r6 = this.text.charAt(r3);
            if (isDigitPlusMinus(r6) == true) goto L47;
            if (isAlphaUnder(r6) == true) goto L47;
            if (r6 == '.') goto L47;
            goto L54
        }

        private String nextTokenSingleChar() {
            CharSequence r0 = this.text;
            int r1 = this.pos;
            this.pos = r1 + 1;
            char r3 = r0.charAt(r1);
            if (r3 != ',') goto L5;
            return ",";
        L5:
            if (r3 != ':') goto L7;
            return ":";
        L7:
            if (r3 != '<') goto L9;
            return "<";
        L9:
            if (r3 != '>') goto L11;
            return ">";
        L11:
            if (r3 != '[') goto L13;
            return "[";
        L13:
            if (r3 != ']') goto L15;
            return "]";
        L15:
            if (r3 != '{') goto L17;
            return "{";
        L17:
            if (r3 != '}') goto L19;
            return "}";
        L19:
            return String.valueOf(r3);
        }

        private void skipWhitespace() {
            int r0 = this.text.length();
            int r1 = this.pos - 1;
        L3:
            r1 = r1 + 1;
            if (r1 == r0) goto L16;
            char r2 = this.text.charAt(r1);
            if (r2 == '#') goto L7;
            if (isWhitespace(r2) == false) goto L16;
        L7:
            r1 = r1 + 1;
            if (r1 == r0) goto L11;
            if (this.text.charAt(r1) != '\n') goto L7;
        L11:
            if (r1 != r0) goto L3;
        L16:
            this.pos = r1;
        }

        boolean tryConsume(String r2) {
            if (this.currentToken.equals(r2) == false) goto L6;
            nextToken();
            return true;
        L6:
            return false;
        }

        void consume(String r3) {
            if (tryConsume(r3) == false) goto L6;
            return;
        L6:
            throw parseException("Expected \"" + r3 + "\".");
        }

        boolean lookingAtInteger() {
            if (this.currentToken.length() != 0) goto L6;
            return false;
        L6:
            return isDigitPlusMinus(this.currentToken.charAt(0));
        }

        boolean lookingAt(String r1) {
            return this.currentToken.equals(r1);
        }

        String consumeIdentifier() {
            int r0 = 0;
        L4:
            if (r0 >= this.currentToken.length()) goto L17;
            char r1 = this.currentToken.charAt(r0);
            if (isAlphaUnder(r1) == true) goto L16;
            if ('0' > r1) goto L12;
            if (r1 <= '9') goto L16;
        L12:
            if (r1 == '.') goto L16;
            throw parseException("Expected identifier. Found '" + this.currentToken + "'");
        L16:
            r0 = r0 + 1;
            goto L4
        L17:
            String r2 = this.currentToken;
            nextToken();
            return r2;
        }

        boolean tryConsumeIdentifier() {
            consumeIdentifier();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        int consumeInt32() {
            int r0 = TextFormat.parseInt32(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r0;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        int consumeUInt32() {
            int r0 = TextFormat.parseUInt32(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r0;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        long consumeInt64() {
            long r0 = TextFormat.parseInt64(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r0;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        boolean tryConsumeInt64() {
            consumeInt64();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        long consumeUInt64() {
            long r0 = TextFormat.parseUInt64(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r0;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public boolean tryConsumeUInt64() {
            consumeUInt64();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public double consumeDouble() {
            String r0 = this.currentToken.toLowerCase(Locale.ROOT);
            r0.hashCode();
            byte r2 = -1;
            switch(r0.hashCode()) {
                case 104417: goto L22;
                case 108827: goto L18;
                case 1445012: goto L14;
                case 173173288: goto L10;
                case 442101077: goto L6;
                default: goto L25;
            };
        L25:
            switch(r2) {
                case 0: goto L35;
                case 1: goto L33;
                case 2: goto L31;
                case 3: goto L35;
                case 4: goto L31;
                default: goto L37;
            };
        L31:
            nextToken();
            return Double.NEGATIVE_INFINITY;
        L33:
            nextToken();
            return Double.NaN;
        L35:
            nextToken();
            return Double.POSITIVE_INFINITY;
        L37:
            double r1 = Double.parseDouble(this.currentToken);     // Catch: NumberFormatException -> L28
            nextToken();     // Catch: NumberFormatException -> L28
            return r1;
        L28:
            e = move-exception;
            throw floatParseException(e);
        L6:
            if (r0.equals("-infinity") == false) goto L25;
            r2 = 4;
            goto L25
        L10:
            if (r0.equals("infinity") == false) goto L25;
            r2 = 3;
            goto L25
        L14:
            if (r0.equals("-inf") == false) goto L25;
            r2 = 2;
            goto L25
        L18:
            if (r0.equals("nan") == false) goto L25;
            r2 = 1;
            goto L25
        L22:
            if (r0.equals("inf") == false) goto L25;
            r2 = 0;
            goto L25
        }

        public boolean tryConsumeDouble() {
            consumeDouble();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public float consumeFloat() {
            String r0 = this.currentToken.toLowerCase(Locale.ROOT);
            r0.hashCode();
            byte r2 = -1;
            switch(r0.hashCode()) {
                case 104417: goto L42;
                case 108827: goto L38;
                case 1445012: goto L34;
                case 3237029: goto L30;
                case 3373739: goto L26;
                case 44795474: goto L22;
                case 173173288: goto L18;
                case 442101077: goto L14;
                case 820231601: goto L10;
                case 1073404734: goto L6;
                default: goto L45;
            };
        L45:
            switch(r2) {
                case 0: goto L55;
                case 1: goto L53;
                case 2: goto L51;
                case 3: goto L55;
                case 4: goto L53;
                case 5: goto L51;
                case 6: goto L55;
                case 7: goto L51;
                case 8: goto L51;
                case 9: goto L55;
                default: goto L57;
            };
        L51:
            nextToken();
            return Float.NEGATIVE_INFINITY;
        L53:
            nextToken();
            return Float.NaN;
        L55:
            nextToken();
            return Float.POSITIVE_INFINITY;
        L57:
            float r1 = Float.parseFloat(this.currentToken);     // Catch: NumberFormatException -> L48
            nextToken();     // Catch: NumberFormatException -> L48
            return r1;
        L48:
            e = move-exception;
            throw floatParseException(e);
        L6:
            if (r0.equals("infinityf") == false) goto L45;
            r2 = 9;
            goto L45
        L10:
            if (r0.equals("-infinityf") == false) goto L45;
            r2 = 8;
            goto L45
        L14:
            if (r0.equals("-infinity") == false) goto L45;
            r2 = 7;
            goto L45
        L18:
            if (r0.equals("infinity") == false) goto L45;
            r2 = 6;
            goto L45
        L22:
            if (r0.equals("-inff") == false) goto L45;
            r2 = 5;
            goto L45
        L26:
            if (r0.equals("nanf") == false) goto L45;
            r2 = 4;
            goto L45
        L30:
            if (r0.equals("inff") == false) goto L45;
            r2 = 3;
            goto L45
        L34:
            if (r0.equals("-inf") == false) goto L45;
            r2 = 2;
            goto L45
        L38:
            if (r0.equals("nan") == false) goto L45;
            r2 = 1;
            goto L45
        L42:
            if (r0.equals("inf") == false) goto L45;
            r2 = 0;
            goto L45
        }

        public boolean tryConsumeFloat() {
            consumeFloat();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean consumeBoolean() {
            if (this.currentToken.equals("true") == false) goto L5;
        L24:
            nextToken();
            return true;
        L5:
            if (this.currentToken.equals("True") == true) goto L24;
            if (this.currentToken.equals("t") == true) goto L24;
            if (this.currentToken.equals("1") == true) goto L24;
            if (this.currentToken.equals("false") == false) goto L14;
        L22:
            nextToken();
            return false;
        L14:
            if (this.currentToken.equals("False") == true) goto L22;
            if (this.currentToken.equals(f.f4978a) == true) goto L22;
            if (this.currentToken.equals("0") == true) goto L22;
            throw parseException("Expected \"true\" or \"false\". Found \"" + this.currentToken + "\".");
        }

        public String consumeString() {
            return consumeByteString().toStringUtf8();
        }

        ByteString consumeByteString() {
            ArrayList r0 = new ArrayList();
            consumeByteString(r0);
        L4:
            if (this.currentToken.startsWith("'") == true) goto L10;
            if (this.currentToken.startsWith("\"") == true) goto L10;
            return ByteString.copyFrom(r0);
        L10:
            consumeByteString(r0);
            goto L4
        }

        boolean tryConsumeByteString() {
            consumeByteString();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        private void consumeByteString(List<ByteString> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            char r1 = 0;
            if (this.currentToken.length() <= 0) goto L6;
            r1 = this.currentToken.charAt(0);
        L6:
            if (r1 == '\"') goto L13;
            if (r1 == '\'') goto L13;
            throw parseException("Expected string.");
        L13:
            if (this.currentToken.length() < 2) goto L22;
            String r0 = this.currentToken;
            if (r0.charAt(r0.length() - 1) != r1) goto L22;
            String r2 = this.currentToken;     // Catch: InvalidEscapeSequenceException -> L18
            ByteString r3 = TextFormat.unescapeBytes(r2.substring(1, r2.length() - 1));     // Catch: InvalidEscapeSequenceException -> L18
            nextToken();     // Catch: InvalidEscapeSequenceException -> L18
            r6.add(r3);     // Catch: InvalidEscapeSequenceException -> L18
            return;
        L18:
            e = move-exception;
            throw parseException(e.getMessage());
        L22:
            throw parseException("String missing ending quote.");
        }

        ParseException parseException(String r3) {
            return new ParseException(this.line + 1, this.column + 1, r3);
        }

        ParseException parseExceptionPreviousToken(String r3) {
            return new ParseException(this.previousLine + 1, this.previousColumn + 1, r3);
        }

        private ParseException integerParseException(NumberFormatException r3) {
            return parseException("Couldn't parse integer: " + r3.getMessage());
        }

        private ParseException floatParseException(NumberFormatException r3) {
            return parseException("Couldn't parse number: " + r3.getMessage());
        }
    }

    @Deprecated
    public static class UnknownFieldParseException extends ParseException {
        private final String unknownField;

        public UnknownFieldParseException(String r3) {
            this(-1, -1, "", r3);
        }

        public UnknownFieldParseException(int r1, int r2, String r3, String r4) {
            super(r1, r2, r4);
            this.unknownField = r3;
        }

        public String getUnknownField() {
            return this.unknownField;
        }
    }

    private static int digitValue(byte r2) {
        if (48 > r2) goto L9;
        if (r2 > 57) goto L9;
        return r2 - 48;
    L9:
        if (97 <= r2) goto L11;
    L15:
        int r3 = r2 - 65;
    L14:
        return r3 + 10;
    L11:
        if (r2 > 122) goto L15;
        r3 = r2 - 97;
        goto L14
    }

    private static boolean isHex(byte r1) {
        if (48 > r1) goto L7;
        if (r1 > 57) goto L7;
    L14:
        return true;
    L7:
        if (97 > r1) goto L11;
        if (r1 <= 102) goto L14;
    L11:
        if (65 <= r1) goto L13;
    L15:
        return false;
    L13:
        if (r1 > 70) goto L15;
        goto L14
    }

    private static boolean isOctal(byte r1) {
        if (48 <= r1) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 55) goto L7;
        return true;
    }

    static /* synthetic */ TextGenerator access$300(Appendable r2, boolean r3, Descriptors.Descriptor r4, Printer.FieldReporterLevel r5) {
        return setSingleLineOutput((Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    }

    static /* synthetic */ TextGenerator access$400(Appendable r2, boolean r3) {
        return setSingleLineOutput((Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.aiagent.plugin"), r3);
    }

    static /* synthetic */ Logger access$700() {
        return logger;
    }

    private TextFormat() {
    }

    static {
        logger = Logger.getLogger(TextFormat.class.getName());
        PARSER = Parser.newBuilder().build();
    }

    @Deprecated
    public static String shortDebugString(MessageOrBuilder r2) {
        MessageOrBuilder r3 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r2, MessageOrBuilder.class, "com.obric.aiagent.plugin");
        return printer().emittingSingleLine(true).printToString(r3, Printer.FieldReporterLevel.SHORT_DEBUG_STRING);
    }

    public static void printUnknownFieldValue(int r2, Object r3, Appendable r4) {
        printUnknownFieldValue(r2, r3, setSingleLineOutput((Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.aiagent.plugin"), false), false);
    }

    private static void printUnknownFieldValue(int r6, Object r7, TextGenerator r8, boolean r9) {
        int r0 = WireFormat.getTagWireType(r6);
        if (r0 != 0) goto L5;
        r8.print(unsignedToString(((Long) ZeusTransformUtils.preCheckCast(r7, Long.class, "com.obric.aiagent.plugin")).longValue()));
        return;
    L5:
        if (r0 != 1) goto L7;
        r8.print(String.format((Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.aiagent.plugin"), "0x%016x", new Object[]{(Long) ZeusTransformUtils.preCheckCast(r7, Long.class, "com.obric.aiagent.plugin")}));
        return;
    L7:
        if (r0 != 2) goto L9;
        UnknownFieldSet r10 = UnknownFieldSet.parseFrom((ByteString) ZeusTransformUtils.preCheckCast(r7, ByteString.class, "com.obric.aiagent.plugin"));     // Catch: InvalidProtocolBufferException -> L18
        r8.print("{");     // Catch: InvalidProtocolBufferException -> L18
        r8.eol();     // Catch: InvalidProtocolBufferException -> L18
        r8.indent();     // Catch: InvalidProtocolBufferException -> L18
        Printer.access$000(r10, r8, r9);     // Catch: InvalidProtocolBufferException -> L18
        r8.outdent();     // Catch: InvalidProtocolBufferException -> L18
        r8.print("}");     // Catch: InvalidProtocolBufferException -> L18
        return;
    L18:
        r8.print("\"");
        r8.print(escapeBytes((ByteString) ZeusTransformUtils.preCheckCast(r7, ByteString.class, "com.obric.aiagent.plugin")));
        r8.print("\"");
        return;
    L9:
        if (r0 != 3) goto L11;
        Printer.access$000((UnknownFieldSet) ZeusTransformUtils.preCheckCast(r7, UnknownFieldSet.class, "com.obric.aiagent.plugin"), r8, r9);
        return;
    L11:
        if (r0 != 5) goto L14;
        r8.print(String.format((Locale) ZeusTransformUtils.preCheckCast(null, Locale.class, "com.obric.aiagent.plugin"), "0x%08x", new Object[]{(Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.aiagent.plugin")}));
        return;
    L14:
        throw new IllegalArgumentException("Bad tag: " + r6);
    }

    public static Printer printer() {
        return Printer.access$100();
    }

    public static Printer debugFormatPrinter() {
        return Printer.access$200();
    }

    public static String unsignedToString(int r4) {
        if (r4 < 0) goto L6;
        return Integer.toString(r4);
    L6:
        return Long.toString(((long) r4) & 4294967295L);
    }

    public static String unsignedToString(long r2) {
        if (r2 < 0) goto L7;
        return Long.toString(r2);
    L7:
        return BigInteger.valueOf(r2 & Long.MAX_VALUE).setBit(63).toString();
    }

    private static TextGenerator setSingleLineOutput(Appendable r6, boolean r7) {
        Descriptors.Descriptor r3 = null;
        return new TextGenerator((Appendable) ZeusTransformUtils.wrapperContextForParams(r6, Appendable.class, "com.obric.aiagent.plugin"), r7, r3, Printer.FieldReporterLevel.TEXT_GENERATOR, null);
    }

    private static TextGenerator setSingleLineOutput(Appendable r6, boolean r7, Descriptors.Descriptor r8, Printer.FieldReporterLevel r9) {
        return new TextGenerator((Appendable) ZeusTransformUtils.wrapperContextForParams(r6, Appendable.class, "com.obric.aiagent.plugin"), r7, r8, r9, null);
    }

    public static Parser getParser() {
        return PARSER;
    }

    public static void merge(Readable r2, Message.Builder r3) {
        Readable r4 = (Readable) ZeusTransformUtils.wrapperContextForParams(r2, Readable.class, "com.obric.aiagent.plugin");
        Message.Builder r5 = (Message.Builder) ZeusTransformUtils.wrapperContextForParams(r3, Message.Builder.class, "com.obric.aiagent.plugin");
        PARSER.merge(r4, r5);
    }

    public static void merge(CharSequence r2, Message.Builder r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        Message.Builder r5 = (Message.Builder) ZeusTransformUtils.wrapperContextForParams(r3, Message.Builder.class, "com.obric.aiagent.plugin");
        PARSER.merge(r4, r5);
    }

    public static <T extends Message> T parse(CharSequence r2, Class<T> r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        Message.Builder r5 = ((Message) ZeusTransformUtils.preCheckCast(Internal.getDefaultInstance(r3), Message.class, "com.obric.aiagent.plugin")).newBuilderForType();
        merge(r4, r5);
        return (T) r5.build();
    }

    public static void merge(Readable r2, ExtensionRegistry r3, Message.Builder r4) {
        Readable r5 = (Readable) ZeusTransformUtils.wrapperContextForParams(r2, Readable.class, "com.obric.aiagent.plugin");
        Message.Builder r6 = (Message.Builder) ZeusTransformUtils.wrapperContextForParams(r4, Message.Builder.class, "com.obric.aiagent.plugin");
        PARSER.merge(r5, r3, r6);
    }

    public static void merge(CharSequence r2, ExtensionRegistry r3, Message.Builder r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        Message.Builder r6 = (Message.Builder) ZeusTransformUtils.wrapperContextForParams(r4, Message.Builder.class, "com.obric.aiagent.plugin");
        PARSER.merge(r5, r3, r6);
    }

    public static <T extends Message> T parse(CharSequence r2, ExtensionRegistry r3, Class<T> r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        Message.Builder r6 = ((Message) ZeusTransformUtils.preCheckCast(Internal.getDefaultInstance(r4), Message.class, "com.obric.aiagent.plugin")).newBuilderForType();
        merge(r5, r3, r6);
        return (T) r6.build();
    }

    public static String escapeBytes(ByteString r0) {
        return TextFormatEscaper.escapeBytes(r0);
    }

    public static String escapeBytes(byte[] r0) {
        return TextFormatEscaper.escapeBytes(r0);
    }

    public static ByteString unescapeBytes(CharSequence r12) {
        ByteString r13 = ByteString.copyFromUtf8(((CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin")).toString());
        int r0 = r13.size();
        byte[] r1 = new byte[r0];
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r13.size()) goto L124;
        byte r5 = r13.byteAt(r3);
        if (r5 != 92) goto L121;
        r3 = r3 + 1;
        if (r3 >= r13.size()) goto L120;
        byte r6 = r13.byteAt(r3);
        if (isOctal(r6) == false) goto L23;
        int r7 = digitValue(r6);
        int r8 = r3 + 1;
        if (r8 < r13.size()) goto L14;
    L16:
        int r9 = r3 + 1;
        if (r9 < r13.size()) goto L19;
    L21:
        int r10 = r4 + 1;
        r1[r4] = (byte) r7;
    L122:
        r4 = r10;
    L123:
        r3 = r3 + 1;
        goto L4
    L19:
        if (isOctal(r13.byteAt(r9)) == false) goto L21;
        r7 = (r7 * 8) + digitValue(r13.byteAt(r9));
        r3 = r9;
        goto L21
    L14:
        if (isOctal(r13.byteAt(r8)) == false) goto L16;
        r7 = (r7 * 8) + digitValue(r13.byteAt(r8));
        r3 = r8;
        goto L16
    L23:
        if (r6 != 34) goto L25;
        int r11 = r4 + 1;
        r1[r4] = 34;
    L118:
        r4 = r11;
        goto L123
    L25:
        if (r6 != 39) goto L27;
        r11 = r4 + 1;
        r1[r4] = 39;
        goto L118
    L27:
        if (r6 != 63) goto L29;
        r11 = r4 + 1;
        r1[r4] = 63;
        goto L118
    L29:
        if (r6 == 85) goto L86;
        if (r6 != 92) goto L32;
        r11 = r4 + 1;
        r1[r4] = 92;
        goto L118
    L32:
        if (r6 != 102) goto L34;
        r11 = r4 + 1;
        r1[r4] = 12;
        goto L118
    L34:
        if (r6 != 110) goto L36;
        r11 = r4 + 1;
        r1[r4] = 10;
        goto L118
    L36:
        if (r6 != 114) goto L38;
        r11 = r4 + 1;
        r1[r4] = 13;
        goto L118
    L38:
        if (r6 != 120) goto L40;
        r3 = r3 + 1;
        if (r3 >= r13.size()) goto L81;
        if (isHex(r13.byteAt(r3)) == false) goto L81;
        int r14 = digitValue(r13.byteAt(r3));
        int r15 = r3 + 1;
        if (r15 < r13.size()) goto L77;
    L79:
        r10 = r4 + 1;
        r1[r4] = (byte) r14;
        goto L122
    L77:
        if (isHex(r13.byteAt(r15)) == false) goto L79;
        r14 = (r14 * 16) + digitValue(r13.byteAt(r15));
        r3 = r15;
    L81:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
    L40:
        if (r6 != 97) goto L42;
        r11 = r4 + 1;
        r1[r4] = 7;
        goto L118
    L42:
        if (r6 == 98) goto L68;
        switch(r6) {
            case 116: goto L67;
            case 117: goto L47;
            case 118: goto L46;
            default: goto L45;
        };
    L46:
        r11 = r4 + 1;
        r1[r4] = 11;
        goto L118
    L47:
        int r16 = r3 + 1;
        int r17 = r16 + 3;
        if (r17 >= r13.size()) goto L66;
        if (isHex(r13.byteAt(r16)) == false) goto L66;
        int r18 = r16 + 1;
        if (isHex(r13.byteAt(r18)) == false) goto L66;
        int r19 = r16 + 2;
        if (isHex(r13.byteAt(r19)) == false) goto L66;
        if (isHex(r13.byteAt(r17)) == false) goto L66;
        char r20 = (char) ((((digitValue(r13.byteAt(r16)) << 12) | (digitValue(r13.byteAt(r18)) << 8)) | (digitValue(r13.byteAt(r19)) << 4)) | digitValue(r13.byteAt(r17)));
        if (r20 >= 55296) goto L60;
    L64:
        byte[] r21 = Character.toString(r20).getBytes(Internal.UTF_8);
        System.arraycopy(r21, 0, r1, r4, r21.length);
        int r22 = r21.length;
    L110:
        r4 = r4 + r22;
        r3 = r17;
        goto L123
    L60:
        if (r20 > 57343) goto L64;
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' refers to a surrogate");
    L66:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' with too few hex chars");
    L67:
        r11 = r4 + 1;
        r1[r4] = 9;
        goto L118
    L45:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) r6) + '\'');
    L68:
        r11 = r4 + 1;
        r1[r4] = 8;
        goto L118
    L86:
        int r23 = r3 + 1;
        r17 = r23 + 7;
        if (r17 >= r13.size()) goto L114;
        int r24 = 0;
        int r25 = r23;
    L89:
        int r110 = r23 + 8;
        if (r25 >= r110) goto L97;
        byte r111 = r13.byteAt(r25);
        if (isHex(r111) == false) goto L95;
        r24 = (r24 << 4) | digitValue(r111);
        r25 = r25 + 1;
        goto L89
    L95:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
    L97:
        if (Character.isValidCodePoint(r24) == false) goto L112;
        Character.UnicodeBlock r26 = Character.UnicodeBlock.of(r24);
        if (r26 != null) goto L101;
    L109:
        byte[] r27 = new String(new int[]{r24}, 0, 1).getBytes(Internal.UTF_8);
        System.arraycopy(r27, 0, r1, r4, r27.length);
        r22 = r27.length;
        goto L110
    L101:
        if (r26.equals(Character.UnicodeBlock.LOW_SURROGATES) == true) goto L108;
        if (r26.equals(Character.UnicodeBlock.HIGH_SURROGATES) == true) goto L108;
        if (r26.equals(Character.UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES) == false) goto L109;
    L108:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + r13.substring(r23, r110).toStringUtf8() + "' refers to a surrogate code unit");
    L112:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + r13.substring(r23, r110).toStringUtf8() + "' is not a valid code point value");
    L114:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
    L120:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
    L121:
        r10 = r4 + 1;
        r1[r4] = r5;
        goto L122
    L124:
        if (r0 != r4) goto L127;
        return ByteString.wrap(r1);
    L127:
        return ByteString.copyFrom(r1, 0, r4);
    }

    static String escapeText(String r0) {
        return escapeBytes(ByteString.copyFromUtf8(r0));
    }

    public static String escapeDoubleQuotesAndBackslashes(String r0) {
        return TextFormatEscaper.escapeDoubleQuotesAndBackslashes(r0);
    }

    static String unescapeText(String r0) {
        return unescapeBytes(r0).toStringUtf8();
    }

    static int parseInt32(String r2) {
        return (int) parseInteger(r2, true, false);
    }

    static int parseUInt32(String r2) {
        return (int) parseInteger(r2, false, false);
    }

    static long parseInt64(String r2) {
        return parseInteger(r2, true, true);
    }

    static long parseUInt64(String r2) {
        return parseInteger(r2, false, true);
    }

    private static long parseInteger(String r7, boolean r8, boolean r9) {
        int r1 = 0;
        boolean r2 = true;
        if (r7.startsWith("-", 0) == false) goto L8;
        if (r8 == false) goto L7;
        r1 = 1;
    L9:
        int r0 = 10;
        if (r7.startsWith("0x", r1) == false) goto L13;
        r1 = r1 + 2;
        r0 = 16;
    L15:
        String r3 = r7.substring(r1);
        if (r3.length() >= 16) goto L36;
        long r4 = Long.parseLong(r3, r0);
        if (r2 == false) goto L20;
        r4 = -r4;
    L20:
        if (r9 == true) goto L63;
        if (r8 == false) goto L30;
        if (r4 > 2147483647L) goto L28;
        if (r4 < (-2147483648L)) goto L28;
        return r4;
    L28:
        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + r7);
    L30:
        if (r4 >= 4294967296L) goto L35;
        if (r4 < 0) goto L35;
        return r4;
    L35:
        throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + r7);
    L63:
        return r4;
    L36:
        BigInteger r5 = new BigInteger(r3, r0);
        if (r2 == false) goto L39;
        r5 = r5.negate();
    L39:
        if (r9 == true) goto L51;
        if (r8 == false) goto L47;
        if (r5.bitLength() <= 31) goto L60;
        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + r7);
    L60:
        return r5.longValue();
    L47:
        if (r5.bitLength() <= 32) goto L60;
        throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + r7);
    L51:
        if (r8 == false) goto L58;
        if (r5.bitLength() <= 63) goto L60;
        throw new NumberFormatException("Number out of range for 64-bit signed integer: " + r7);
    L58:
        if (r5.bitLength() <= 64) goto L60;
        throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + r7);
    L13:
        if (r7.startsWith("0", r1) == false) goto L15;
        r0 = 8;
        goto L15
    L7:
        throw new NumberFormatException("Number must be positive: " + r7);
    L8:
        r2 = false;
        goto L9
    }
}
