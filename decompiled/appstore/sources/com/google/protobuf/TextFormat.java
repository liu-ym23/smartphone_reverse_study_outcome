package com.google.protobuf;

import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class TextFormat {
    private static final Printer DEFAULT_PRINTER = null;
    private static final Parser PARSER = null;
    private static final Printer SINGLE_LINE_PRINTER = null;
    private static final Printer UNICODE_PRINTER = null;
    private static final Logger logger = null;

    /* JADX INFO: renamed from: com.google.protobuf.TextFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r10 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r10;
            r10[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    public static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        public InvalidEscapeSequenceException(String r10) {
            super(r10);
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int column;
        private final int line;

        public ParseException(String r10) {
            this(-1, -1, r10);
        }

        public int getColumn() {
            return this.column;
        }

        public int getLine() {
            return this.line;
        }

        public ParseException(int r10, int r11, String r12) {
            super(Integer.toString(r10) + ":" + r11 + ": " + r12);
            this.line = r10;
            this.column = r11;
        }
    }

    public static class Parser {
        private static final int BUFFER_SIZE = 4096;
        private final boolean allowUnknownFields;
        private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
        private final SingularOverwritePolicy singularOverwritePolicy;

        public static class Builder {
            private boolean allowUnknownFields;
            private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
            private SingularOverwritePolicy singularOverwritePolicy;

            public Builder() {
                this.allowUnknownFields = false;
                this.singularOverwritePolicy = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
                this.parseInfoTreeBuilder = null;
            }

            public Parser build() {
                return new Parser(this.allowUnknownFields, this.singularOverwritePolicy, this.parseInfoTreeBuilder, null);
            }

            public Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder r10) {
                this.parseInfoTreeBuilder = r10;
                return this;
            }

            public Builder setSingularOverwritePolicy(SingularOverwritePolicy r10) {
                this.singularOverwritePolicy = r10;
                return this;
            }
        }

        public static final enum SingularOverwritePolicy extends java.lang.Enum<SingularOverwritePolicy> {
            private static final /* synthetic */ SingularOverwritePolicy[] $VALUES = null;
            public static final SingularOverwritePolicy ALLOW_SINGULAR_OVERWRITES = null;
            public static final SingularOverwritePolicy FORBID_SINGULAR_OVERWRITES = null;

            static {
                SingularOverwritePolicy r10 = new SingularOverwritePolicy("ALLOW_SINGULAR_OVERWRITES", 0);
                ALLOW_SINGULAR_OVERWRITES = r10;
                SingularOverwritePolicy r11 = new SingularOverwritePolicy("FORBID_SINGULAR_OVERWRITES", 1);
                FORBID_SINGULAR_OVERWRITES = r11;
                $VALUES = new SingularOverwritePolicy[]{r10, r11};
            }

            private SingularOverwritePolicy(String r10, int r11) {
                super(r10, r11);
            }

            public static SingularOverwritePolicy valueOf(String r10) {
                return (SingularOverwritePolicy) java.lang.Enum.valueOf(SingularOverwritePolicy.class, r10);
            }

            public static SingularOverwritePolicy[] values() {
                return (SingularOverwritePolicy[]) $VALUES.clone();
            }
        }

        public /* synthetic */ Parser(boolean r10, SingularOverwritePolicy r11, TextFormatParseInfoTree.Builder r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        private void checkUnknownFields(List<String> r10) throws ParseException {
            if (r10.isEmpty() == false) goto L5;
            return;
        L5:
            StringBuilder r11 = new StringBuilder("Input contains unknown fields and/or extensions:");
            Iterator<String> r12 = r10.iterator();
        L7:
            if (r12.hasNext() == false) goto L10;
            String r13 = r12.next();
            r11.append('\n');
            r11.append(r13);
            goto L7
        L10:
            if (this.allowUnknownFields == false) goto L13;
            TextFormat.access$1000().warning(r11.toString());
            return;
        L13:
            String[] r14 = r10.get(0).split(":");
            throw new ParseException(Integer.valueOf(r14[0]).intValue(), Integer.valueOf(r14[1]).intValue(), r11.toString());
        }

        private void consumeFieldValue(Tokenizer r14, ExtensionRegistry r15, MessageReflection.MergeTarget r16, Descriptors.FieldDescriptor r17, ExtensionRegistry.ExtensionInfo r18, TextFormatParseInfoTree.Builder r19, List<String> r20) throws ParseException {
            Object r10 = null;
            Message r11 = null;
            if (r17.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L22;
            if (r14.tryConsume("<") == false) goto L8;
            String r12 = ">";
        L7:
            String r13 = r12;
            if (r18 == null) goto L12;
            r11 = r18.defaultInstance;
        L12:
            MessageReflection.MergeTarget r110 = r16.newMergeTargetForField(r17, r11);
        L14:
            if (r14.tryConsume(r13) == true) goto L20;
            if (r14.atEnd() == true) goto L19;
            mergeField(r14, r15, r110, r19, r20);
            goto L14
        L19:
            throw r14.parseException("Expected \"" + r13 + "\".");
        L20:
            r10 = r110.finish();
        L48:
            if (r17.isRepeated() == false) goto L50;
            r16.addRepeatedField(r17, r10);
            return;
        L50:
            SingularOverwritePolicy r21 = this.singularOverwritePolicy;
            SingularOverwritePolicy r22 = SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES;
            if (r21 != r22) goto L58;
            if (r16.hasField(r17) == false) goto L58;
            throw r14.parseExceptionPreviousToken("Non-repeated field \"" + r17.getFullName() + "\" cannot be overwritten.");
        L58:
            if (this.singularOverwritePolicy == r22) goto L60;
        L66:
            r16.setField(r17, r10);
            return;
        L60:
            if (r17.getContainingOneof() == null) goto L66;
            if (r16.hasOneof(r17.getContainingOneof()) == false) goto L66;
            Descriptors.OneofDescriptor r23 = r17.getContainingOneof();
            throw r14.parseExceptionPreviousToken("Field \"" + r17.getFullName() + "\" is specified along with field \"" + r16.getOneofFieldDescriptor(r23).getFullName() + "\", another member of oneof \"" + r23.getName() + "\".");
        L8:
            r14.consume("{");
            r12 = "}";
            goto L7
        L22:
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r17.getType().ordinal()]) {
                case 1: goto L46;
                case 2: goto L46;
                case 3: goto L46;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L44;
                case 8: goto L43;
                case 9: goto L42;
                case 10: goto L41;
                case 11: goto L41;
                case 12: goto L40;
                case 13: goto L40;
                case 14: goto L39;
                case 15: goto L38;
                case 16: goto L26;
                case 17: goto L25;
                case 18: goto L25;
                default: goto L48;
            };
        L26:
            Descriptors.EnumDescriptor r24 = r17.getEnumType();
            if (r14.lookingAtInteger() == false) goto L33;
            int r25 = r14.consumeInt32();
            r10 = r24.findValueByNumber(r25);
            if (r10 != null) goto L48;
            throw r14.parseExceptionPreviousToken("Enum type \"" + r24.getFullName() + "\" has no value with number " + r25 + '.');
        L33:
            String r26 = r14.consumeIdentifier();
            r10 = r24.findValueByName(r26);
            if (r10 != null) goto L48;
            throw r14.parseExceptionPreviousToken("Enum type \"" + r24.getFullName() + "\" has no value named \"" + r26 + "\".");
        L38:
            r10 = r14.consumeByteString();
            goto L48
        L39:
            r10 = r14.consumeString();
            goto L48
        L40:
            r10 = Long.valueOf(r14.consumeUInt64());
            goto L48
        L41:
            r10 = Integer.valueOf(r14.consumeUInt32());
            goto L48
        L42:
            r10 = Double.valueOf(r14.consumeDouble());
            goto L48
        L43:
            r10 = Float.valueOf(r14.consumeFloat());
            goto L48
        L44:
            r10 = Boolean.valueOf(r14.consumeBoolean());
            goto L48
        L45:
            r10 = Long.valueOf(r14.consumeInt64());
            goto L48
        L46:
            r10 = Integer.valueOf(r14.consumeInt32());
            goto L48
        L25:
            throw new RuntimeException("Can't get here.");
        }

        private void consumeFieldValues(Tokenizer r10, ExtensionRegistry r11, MessageReflection.MergeTarget r12, Descriptors.FieldDescriptor r13, ExtensionRegistry.ExtensionInfo r14, TextFormatParseInfoTree.Builder r15, List<String> r16) throws ParseException {
            if (r13.isRepeated() == true) goto L5;
        L10:
            consumeFieldValue(r10, r11, r12, r13, r14, r15, r16);
            return;
        L5:
            if (r10.tryConsume("[") == false) goto L10;
        L6:
            consumeFieldValue(r10, r11, r12, r13, r14, r15, r16);
            if (r10.tryConsume("]") == true) goto L13;
            r10.consume(",");
            goto L6
        }

        private void mergeField(Tokenizer r10, ExtensionRegistry r11, MessageReflection.MergeTarget r12, List<String> r13) throws ParseException {
            mergeField(r10, r11, r12, this.parseInfoTreeBuilder, r13);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        private void skipField(Tokenizer r10) throws ParseException {
            if (r10.tryConsume("[") == false) goto L7;
        L4:
            r10.consumeIdentifier();
            if (r10.tryConsume(LibrarianImpl.Constants.DOT) == true) goto L4;
            r10.consume("]");
        L9:
            if (r10.tryConsume(":") == true) goto L11;
        L15:
            skipFieldMessage(r10);
        L17:
            if (r10.tryConsume(";") == true) goto L22;
            r10.tryConsume(",");
            return;
        L22:
            return;
        L11:
            if (r10.lookingAt("<") == true) goto L15;
            if (r10.lookingAt("{") == true) goto L15;
            skipFieldValue(r10);
            goto L17
        L7:
            r10.consumeIdentifier();
            goto L9
        }

        private void skipFieldMessage(Tokenizer r10) throws ParseException {
            if (r10.tryConsume("<") == false) goto L5;
            String r11 = ">";
        L7:
            if (r10.lookingAt(">") == true) goto L11;
            if (r10.lookingAt("}") == true) goto L11;
            skipField(r10);
        L11:
            r10.consume(r11);
            return;
        L5:
            r10.consume("{");
            r11 = "}";
            goto L7
        }

        private void skipFieldValue(Tokenizer r10) throws ParseException {
            if (r10.tryConsumeString() == false) goto L9;
        L5:
            if (r10.tryConsumeString() == true) goto L5;
            return;
        L9:
            if (r10.tryConsumeIdentifier() == false) goto L11;
            return;
        L11:
            if (r10.tryConsumeInt64() == false) goto L13;
            return;
        L13:
            if (r10.tryConsumeUInt64() == false) goto L15;
            return;
        L15:
            if (r10.tryConsumeDouble() == false) goto L17;
            return;
        L17:
            if (r10.tryConsumeFloat() == false) goto L20;
            return;
        L20:
            throw r10.parseException("Invalid field value: " + Tokenizer.access$1200(r10));
        }

        private static StringBuilder toStringBuilder(Readable r10) throws IOException {
            StringBuilder r11 = new StringBuilder();
            CharBuffer r12 = CharBuffer.allocate(4096);
        L3:
            int r13 = r10.read(r12);
            if (r13 == (-1)) goto L5;
            r12.flip();
            r11.append(r12, 0, r13);
            goto L3
        L5:
            return r11;
        }

        public void merge(Readable r10, Message.Builder r11) throws IOException {
            merge(r10, ExtensionRegistry.getEmptyRegistry(), r11);
        }

        private Parser(boolean r10, SingularOverwritePolicy r11, TextFormatParseInfoTree.Builder r12) {
            this.allowUnknownFields = r10;
            this.singularOverwritePolicy = r11;
            this.parseInfoTreeBuilder = r12;
        }

        private void mergeField(Tokenizer r17, ExtensionRegistry r18, MessageReflection.MergeTarget r19, TextFormatParseInfoTree.Builder r20, List<String> r21) throws ParseException {
            int r10 = r17.getLine();
            int r11 = r17.getColumn();
            Descriptors.Descriptor r12 = r19.getDescriptorForType();
            ExtensionRegistry.ExtensionInfo r13 = null;
            Descriptors.FieldDescriptor r14 = null;
            r13 = null;
            if (r17.tryConsume("[") == false) goto L17;
            StringBuilder r15 = new StringBuilder(r17.consumeIdentifier());
        L6:
            if (r17.tryConsume(LibrarianImpl.Constants.DOT) == false) goto L8;
            r15.append('.');
            r15.append(r17.consumeIdentifier());
            goto L6
        L8:
            ExtensionRegistry.ExtensionInfo r16 = r19.findExtensionByName(r18, r15.toString());
            if (r16 != null) goto L12;
            r21.add((r17.getPreviousLine() + 1) + ":" + (r17.getPreviousColumn() + 1) + ":\t" + r12.getFullName() + ".[" + r15 + "]");
        L14:
            r17.consume("]");
            Descriptors.FieldDescriptor r110 = r14;
            r13 = r16;
        L32:
            if (r110 != null) goto L43;
            if (r17.tryConsume(":") == true) goto L36;
        L40:
            skipFieldMessage(r17);
            return;
        L36:
            if (r17.lookingAt("{") == true) goto L40;
            if (r17.lookingAt("<") == true) goto L40;
            skipFieldValue(r17);
            return;
        L43:
            if (r110.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L48;
            r17.tryConsume(":");
            if (r20 == null) goto L47;
            consumeFieldValues(r17, r18, r19, r110, r13, r20.getBuilderForSubMessageField(r110), r21);
        L49:
            if (r20 == null) goto L52;
            r20.setLocation(r110, TextFormatParseLocation.create(r10, r11));
        L52:
            if (r17.tryConsume(";") == true) goto L57;
            r17.tryConsume(",");
            return;
        L57:
            return;
        L47:
            consumeFieldValues(r17, r18, r19, r110, r13, r20, r21);
            goto L49
        L48:
            r17.consume(":");
            consumeFieldValues(r17, r18, r19, r110, r13, r20, r21);
            goto L49
        L12:
            if (r16.descriptor.getContainingType() != r12) goto L16;
            r14 = r16.descriptor;
            goto L14
        L16:
            throw r17.parseExceptionPreviousToken("Extension \"" + r15 + "\" does not extend message type \"" + r12.getFullName() + "\".");
        L17:
            String r22 = r17.consumeIdentifier();
            r110 = r12.findFieldByName(r22);
            if (r110 != null) goto L24;
            r110 = r12.findFieldByName(r22.toLowerCase(Locale.US));
            if (r110 == null) goto L24;
            if (r110.getType() == Descriptors.FieldDescriptor.Type.GROUP) goto L24;
            r110 = null;
        L24:
            if (r110 != null) goto L26;
        L30:
            if (r110 != null) goto L32;
            r21.add((r17.getPreviousLine() + 1) + ":" + (r17.getPreviousColumn() + 1) + ":\t" + r12.getFullName() + LibrarianImpl.Constants.DOT + r22);
            goto L32
        L26:
            if (r110.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L30;
            if (r110.getMessageType().getName().equals(r22) == true) goto L30;
            r110 = null;
            goto L30
        }

        public void merge(CharSequence r10, Message.Builder r11) throws ParseException {
            merge(r10, ExtensionRegistry.getEmptyRegistry(), r11);
        }

        public void merge(Readable r10, ExtensionRegistry r11, Message.Builder r12) throws IOException {
            merge(toStringBuilder(r10), r11, r12);
        }

        public void merge(CharSequence r10, ExtensionRegistry r11, Message.Builder r12) throws ParseException {
            Tokenizer r13 = new Tokenizer(r10, null);
            MessageReflection.BuilderAdapter r14 = new MessageReflection.BuilderAdapter(r12);
            ArrayList r15 = new ArrayList();
        L4:
            if (r13.atEnd() == true) goto L6;
            mergeField(r13, r11, r14, r15);
            goto L4
        L6:
            checkUnknownFields(r15);
        }
    }

    public static final class Printer {
        boolean escapeNonAscii;
        boolean singleLineMode;

        public /* synthetic */ Printer(AnonymousClass1 r10) {
            this();
        }

        public static /* synthetic */ Printer access$100(Printer r10, boolean r11) {
            return r10.setSingleLineMode(r11);
        }

        public static /* synthetic */ Printer access$200(Printer r10, boolean r11) {
            return r10.setEscapeNonAscii(r11);
        }

        public static /* synthetic */ void access$400(Printer r10, MessageOrBuilder r11, TextGenerator r12) throws IOException {
            r10.print(r11, r12);
        }

        public static /* synthetic */ void access$500(Printer r10, UnknownFieldSet r11, TextGenerator r12) throws IOException {
            r10.printUnknownFields(r11, r12);
        }

        public static /* synthetic */ void access$600(Printer r10, Descriptors.FieldDescriptor r11, Object r12, TextGenerator r13) throws IOException {
            r10.printField(r11, r12, r13);
        }

        public static /* synthetic */ void access$700(Printer r10, Descriptors.FieldDescriptor r11, Object r12, TextGenerator r13) throws IOException {
            r10.printFieldValue(r11, r12, r13);
        }

        private void print(MessageOrBuilder r10, TextGenerator r11) throws IOException {
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r12 = r10.getAllFields().entrySet().iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            Map.Entry<Descriptors.FieldDescriptor, Object> r13 = r12.next();
            printField(r13.getKey(), r13.getValue(), r11);
            goto L4
        L6:
            printUnknownFields(r10.getUnknownFields(), r11);
        }

        private void printField(Descriptors.FieldDescriptor r10, Object r11, TextGenerator r12) throws IOException {
            if (r10.isRepeated() == false) goto L8;
            Iterator r13 = ((List) r11).iterator();
        L6:
            if (r13.hasNext() == false) goto L11;
            printSingleField(r10, r13.next(), r12);
            goto L6
        L11:
            return;
        L8:
            printSingleField(r10, r11, r12);
        }

        private void printFieldValue(Descriptors.FieldDescriptor r10, Object r11, TextGenerator r12) throws IOException {
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r10.getType().ordinal()]) {
                case 1: goto L23;
                case 2: goto L23;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L22;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L17;
                case 14: goto L12;
                case 15: goto L7;
                case 16: goto L6;
                case 17: goto L5;
                case 18: goto L5;
                default: goto L35;
            };
        L5:
            print((Message) r11, r12);
            return;
        L6:
            r12.print(((Descriptors.EnumValueDescriptor) r11).getName());
            return;
        L7:
            r12.print("\"");
            if ((r11 instanceof ByteString) == false) goto L10;
            r12.print(TextFormat.escapeBytes((ByteString) r11));
        L11:
            r12.print("\"");
            return;
        L10:
            r12.print(TextFormat.escapeBytes((byte[]) r11));
            goto L11
        L12:
            r12.print("\"");
            if (this.escapeNonAscii == false) goto L15;
            String r13 = TextFormatEscaper.escapeText((String) r11);
        L16:
            r12.print(r13);
            r12.print("\"");
            return;
        L15:
            r13 = TextFormat.escapeDoubleQuotesAndBackslashes((String) r11).replace("\n", "\\n");
            goto L16
        L17:
            r12.print(TextFormat.unsignedToString(((Long) r11).longValue()));
            return;
        L18:
            r12.print(TextFormat.unsignedToString(((Integer) r11).intValue()));
            return;
        L19:
            r12.print(((Double) r11).toString());
            return;
        L20:
            r12.print(((Float) r11).toString());
            return;
        L21:
            r12.print(((Boolean) r11).toString());
            return;
        L22:
            r12.print(((Long) r11).toString());
            return;
        L23:
            r12.print(((Integer) r11).toString());
            return;
        }

        private void printSingleField(Descriptors.FieldDescriptor r10, Object r11, TextGenerator r12) throws IOException {
            if (r10.isExtension() == false) goto L16;
            r12.print("[");
            if (r10.getContainingType().getOptions().getMessageSetWireFormat() == true) goto L7;
        L13:
            r12.print(r10.getFullName());
        L14:
            r12.print("]");
        L19:
            Descriptors.FieldDescriptor.JavaType r13 = r10.getJavaType();
            Descriptors.FieldDescriptor.JavaType r14 = Descriptors.FieldDescriptor.JavaType.MESSAGE;
            if (r13 == r14) goto L22;
            r12.print(": ");
        L26:
            printFieldValue(r10, r11, r12);
            if (r10.getJavaType() != r14) goto L33;
            if (this.singleLineMode == false) goto L31;
            r12.print("} ");
            return;
        L31:
            r12.outdent();
            r12.print("}\n");
            return;
        L33:
            if (this.singleLineMode == false) goto L35;
            r12.print(" ");
            return;
        L35:
            r12.print("\n");
            return;
        L22:
            if (this.singleLineMode == false) goto L24;
            r12.print(" { ");
            goto L26
        L24:
            r12.print(" {\n");
            r12.indent();
            goto L26
        L7:
            if (r10.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L13;
            if (r10.isOptional() == false) goto L13;
            if (r10.getExtensionScope() != r10.getMessageType()) goto L13;
            r12.print(r10.getMessageType().getFullName());
            goto L14
        L16:
            if (r10.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L18;
            r12.print(r10.getMessageType().getName());
            goto L19
        L18:
            r12.print(r10.getName());
            goto L19
        }

        private void printUnknownField(int r10, int r11, List<?> r12, TextGenerator r13) throws IOException {
            Iterator<?> r14 = r12.iterator();
        L4:
            if (r14.hasNext() == false) goto L10;
            Object r15 = r14.next();
            r13.print(String.valueOf(r10));
            r13.print(": ");
            TextFormat.access$800(r11, r15, r13);
            if (this.singleLineMode == false) goto L8;
            String r16 = " ";
        L9:
            r13.print(r16);
            goto L4
        L8:
            r16 = "\n";
            goto L9
        }

        private void printUnknownFields(UnknownFieldSet r10, TextGenerator r11) throws IOException {
            Iterator<Map.Entry<Integer, UnknownFieldSet.Field>> r12 = r10.asMap().entrySet().iterator();
        L4:
            if (r12.hasNext() == false) goto L16;
            Map.Entry<Integer, UnknownFieldSet.Field> r13 = r12.next();
            int r14 = r13.getKey().intValue();
            UnknownFieldSet.Field r15 = r13.getValue();
            printUnknownField(r14, 0, r15.getVarintList(), r11);
            printUnknownField(r14, 5, r15.getFixed32List(), r11);
            printUnknownField(r14, 1, r15.getFixed64List(), r11);
            printUnknownField(r14, 2, r15.getLengthDelimitedList(), r11);
            Iterator<UnknownFieldSet> r16 = r15.getGroupList().iterator();
        L7:
            if (r16.hasNext() == false) goto L4;
            UnknownFieldSet r17 = r16.next();
            r11.print(r13.getKey().toString());
            if (this.singleLineMode == false) goto L11;
            r11.print(" { ");
        L12:
            printUnknownFields(r17, r11);
            if (this.singleLineMode == true) goto L14;
            r11.outdent();
            r11.print("}\n");
            goto L7
        L14:
            r11.print("} ");
            goto L7
        L11:
            r11.print(" {\n");
            r11.indent();
            goto L12
        }

        private Printer setEscapeNonAscii(boolean r10) {
            this.escapeNonAscii = r10;
            return this;
        }

        private Printer setSingleLineMode(boolean r10) {
            this.singleLineMode = r10;
            return this;
        }

        private Printer() {
            this.singleLineMode = false;
            this.escapeNonAscii = true;
        }
    }

    public static final class TextGenerator {
        private boolean atStartOfLine;
        private final StringBuilder indent;
        private final Appendable output;

        public /* synthetic */ TextGenerator(Appendable r10, AnonymousClass1 r11) {
            this(r10);
        }

        private void write(CharSequence r10) throws IOException {
            if (r10.length() != 0) goto L6;
            return;
        L6:
            if (this.atStartOfLine == false) goto L8;
            this.atStartOfLine = false;
            this.output.append(this.indent);
        L8:
            this.output.append(r10);
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int r10 = this.indent.length();
            if (r10 == 0) goto L7;
            this.indent.delete(r10 - 2, r10);
            return;
        L7:
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void print(CharSequence r10) throws IOException {
            int r11 = r10.length();
            int r12 = 0;
            int r13 = 0;
        L3:
            if (r12 >= r11) goto L8;
            if (r10.charAt(r12) != '\n') goto L7;
            int r14 = r12 + 1;
            write(r10.subSequence(r13, r14));
            this.atStartOfLine = true;
            r13 = r14;
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            write(r10.subSequence(r13, r11));
        }

        private TextGenerator(Appendable r10) {
            this.indent = new StringBuilder();
            this.atStartOfLine = true;
            this.output = r10;
        }
    }

    public static final class Tokenizer {
        private static final Pattern DOUBLE_INFINITY = null;
        private static final Pattern FLOAT_INFINITY = null;
        private static final Pattern FLOAT_NAN = null;
        private static final Pattern TOKEN = null;
        private static final Pattern WHITESPACE = null;
        private int column;
        private String currentToken;
        private int line;
        private final Matcher matcher;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final CharSequence text;

        static {
            WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
            TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
            DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
            FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
            FLOAT_NAN = Pattern.compile("nanf?", 2);
        }

        public /* synthetic */ Tokenizer(CharSequence r10, AnonymousClass1 r11) {
            this(r10);
        }

        public static /* synthetic */ String access$1200(Tokenizer r10) {
            return r10.currentToken;
        }

        private ParseException floatParseException(NumberFormatException r10) {
            return parseException("Couldn't parse number: " + r10.getMessage());
        }

        private ParseException integerParseException(NumberFormatException r10) {
            return parseException("Couldn't parse integer: " + r10.getMessage());
        }

        private void skipWhitespace() {
            this.matcher.usePattern(WHITESPACE);
            if (this.matcher.lookingAt() == false) goto L6;
            Matcher r10 = this.matcher;
            r10.region(r10.end(), this.matcher.regionEnd());
            return;
        }

        public boolean atEnd() {
            if (this.currentToken.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void consume(String r10) throws ParseException {
            if (tryConsume(r10) == false) goto L6;
            return;
        L6:
            throw parseException("Expected \"" + r10 + "\".");
        }

        public boolean consumeBoolean() throws ParseException {
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
            if (this.currentToken.equals("f") == true) goto L22;
            if (this.currentToken.equals(AdReportParam.ClickPosType.SKIP) == true) goto L22;
            throw parseException("Expected \"true\" or \"false\".");
        }

        public ByteString consumeByteString() throws ParseException {
            ArrayList r10 = new ArrayList();
            consumeByteString(r10);
        L4:
            if (this.currentToken.startsWith("'") == true) goto L10;
            if (this.currentToken.startsWith("\"") == true) goto L10;
            return ByteString.copyFrom(r10);
        L10:
            consumeByteString(r10);
            goto L4
        }

        public double consumeDouble() throws ParseException {
            if (DOUBLE_INFINITY.matcher(this.currentToken).matches() == false) goto L10;
            boolean r10 = this.currentToken.startsWith("-");
            nextToken();
            if (r10 == false) goto L7;
            return Double.NEGATIVE_INFINITY;
        L7:
            return Double.POSITIVE_INFINITY;
        L10:
            if (this.currentToken.equalsIgnoreCase("nan") == false) goto L18;
            nextToken();
            return Double.NaN;
        L18:
            double r11 = Double.parseDouble(this.currentToken);     // Catch: NumberFormatException -> L15
            nextToken();     // Catch: NumberFormatException -> L15
            return r11;
        L15:
            e = move-exception;
            throw floatParseException(e);
        }

        public float consumeFloat() throws ParseException {
            if (FLOAT_INFINITY.matcher(this.currentToken).matches() == false) goto L10;
            boolean r10 = this.currentToken.startsWith("-");
            nextToken();
            if (r10 == false) goto L7;
            return Float.NEGATIVE_INFINITY;
        L7:
            return Float.POSITIVE_INFINITY;
        L10:
            if (FLOAT_NAN.matcher(this.currentToken).matches() == false) goto L18;
            nextToken();
            return Float.NaN;
        L18:
            float r11 = Float.parseFloat(this.currentToken);     // Catch: NumberFormatException -> L15
            nextToken();     // Catch: NumberFormatException -> L15
            return r11;
        L15:
            e = move-exception;
            throw floatParseException(e);
        }

        public String consumeIdentifier() throws ParseException {
            int r10 = 0;
        L4:
            if (r10 >= this.currentToken.length()) goto L25;
            char r11 = this.currentToken.charAt(r10);
            if ('a' > r11) goto L10;
            if (r11 > 'z') goto L10;
        L24:
            r10 = r10 + 1;
        L10:
            if ('A' > r11) goto L14;
            if (r11 <= 'Z') goto L24;
        L14:
            if ('0' > r11) goto L18;
            if (r11 <= '9') goto L24;
        L18:
            if (r11 == '_') goto L24;
            if (r11 == '.') goto L24;
            throw parseException("Expected identifier. Found '" + this.currentToken + "'");
        L25:
            String r12 = this.currentToken;
            nextToken();
            return r12;
        }

        public int consumeInt32() throws ParseException {
            int r10 = TextFormat.parseInt32(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r10;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public long consumeInt64() throws ParseException {
            long r10 = TextFormat.parseInt64(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r10;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public String consumeString() throws ParseException {
            return consumeByteString().toStringUtf8();
        }

        public int consumeUInt32() throws ParseException {
            int r10 = TextFormat.parseUInt32(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r10;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public long consumeUInt64() throws ParseException {
            long r10 = TextFormat.parseUInt64(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r10;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public int getColumn() {
            return this.column;
        }

        public int getLine() {
            return this.line;
        }

        public int getPreviousColumn() {
            return this.previousColumn;
        }

        public int getPreviousLine() {
            return this.previousLine;
        }

        public boolean lookingAt(String r10) {
            return this.currentToken.equals(r10);
        }

        public boolean lookingAtInteger() {
            if (this.currentToken.length() != 0) goto L5;
            return false;
        L5:
            char r10 = this.currentToken.charAt(0);
            if ('0' > r10) goto L10;
            if (r10 > '9') goto L10;
        L13:
            return true;
        L10:
            if (r10 == '-') goto L13;
            if (r10 == '+') goto L13;
            return false;
        }

        public void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
        L4:
            if (this.pos >= this.matcher.regionStart()) goto L11;
            if (this.text.charAt(this.pos) != '\n') goto L8;
            this.line++;
            this.column = 0;
        L9:
            this.pos++;
            goto L4
        L8:
            this.column++;
            goto L9
        L11:
            if (this.matcher.regionStart() != this.matcher.regionEnd()) goto L13;
            this.currentToken = "";
            return;
        L13:
            this.matcher.usePattern(TOKEN);
            if (this.matcher.lookingAt() == false) goto L16;
            this.currentToken = this.matcher.group();
            Matcher r10 = this.matcher;
            r10.region(r10.end(), this.matcher.regionEnd());
        L17:
            skipWhitespace();
            return;
        L16:
            this.currentToken = String.valueOf(this.text.charAt(this.pos));
            Matcher r11 = this.matcher;
            r11.region(this.pos + 1, r11.regionEnd());
            goto L17
        }

        public ParseException parseException(String r10) {
            return new ParseException(this.line + 1, this.column + 1, r10);
        }

        public ParseException parseExceptionPreviousToken(String r10) {
            return new ParseException(this.previousLine + 1, this.previousColumn + 1, r10);
        }

        public boolean tryConsume(String r10) {
            if (this.currentToken.equals(r10) == false) goto L6;
            nextToken();
            return true;
        L6:
            return false;
        }

        public boolean tryConsumeDouble() {
            consumeDouble();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeFloat() {
            consumeFloat();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeIdentifier() {
            consumeIdentifier();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeInt64() {
            consumeInt64();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeString() {
            consumeString();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeUInt64() {
            consumeUInt64();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public UnknownFieldParseException unknownFieldParseExceptionPreviousToken(String r10, String r11) {
            return new UnknownFieldParseException(this.previousLine + 1, this.previousColumn + 1, r10, r11);
        }

        private Tokenizer(CharSequence r10) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.text = r10;
            this.matcher = WHITESPACE.matcher(r10);
            skipWhitespace();
            nextToken();
        }

        private void consumeByteString(List<ByteString> r10) throws ParseException {
            char r11 = 0;
            if (this.currentToken.length() <= 0) goto L6;
            r11 = this.currentToken.charAt(0);
        L6:
            if (r11 == '\"') goto L13;
            if (r11 == '\'') goto L13;
            throw parseException("Expected string.");
        L13:
            if (this.currentToken.length() < 2) goto L22;
            String r12 = this.currentToken;
            if (r12.charAt(r12.length() - 1) != r11) goto L22;
            String r13 = this.currentToken;     // Catch: InvalidEscapeSequenceException -> L18
            ByteString r14 = TextFormat.unescapeBytes(r13.substring(1, r13.length() - 1));     // Catch: InvalidEscapeSequenceException -> L18
            nextToken();     // Catch: InvalidEscapeSequenceException -> L18
            r10.add(r14);     // Catch: InvalidEscapeSequenceException -> L18
            return;
        L18:
            e = move-exception;
            throw parseException(e.getMessage());
        L22:
            throw parseException("String missing ending quote.");
        }
    }

    public static class UnknownFieldParseException extends ParseException {
        private final String unknownField;

        public UnknownFieldParseException(String r10) {
            this(-1, -1, "", r10);
        }

        public String getUnknownField() {
            return this.unknownField;
        }

        public UnknownFieldParseException(int r10, int r11, String r12, String r13) {
            super(r10, r11, r13);
            this.unknownField = r12;
        }
    }

    static {
        logger = Logger.getLogger(TextFormat.class.getName());
        AnonymousClass1 r10 = null;
        DEFAULT_PRINTER = new Printer(r10);
        SINGLE_LINE_PRINTER = Printer.access$100(new Printer(r10), true);
        UNICODE_PRINTER = Printer.access$200(new Printer(r10), false);
        PARSER = Parser.newBuilder().build();
    }

    private TextFormat() {
    }

    public static /* synthetic */ Logger access$1000() {
        return logger;
    }

    public static /* synthetic */ void access$800(int r10, Object r11, TextGenerator r12) throws IOException {
        printUnknownFieldValue(r10, r11, r12);
    }

    private static int digitValue(byte r10) {
        if (48 > r10) goto L9;
        if (r10 > 57) goto L9;
        return r10 - 48;
    L9:
        if (97 > r10) goto L15;
        if (r10 > 122) goto L15;
        return r10 - 87;
    L15:
        return r10 - 55;
    }

    public static String escapeBytes(ByteString r10) {
        return TextFormatEscaper.escapeBytes(r10);
    }

    public static String escapeDoubleQuotesAndBackslashes(String r10) {
        return TextFormatEscaper.escapeDoubleQuotesAndBackslashes(r10);
    }

    public static String escapeText(String r10) {
        return escapeBytes(ByteString.copyFromUtf8(r10));
    }

    public static Parser getParser() {
        return PARSER;
    }

    private static boolean isHex(byte r10) {
        if (48 > r10) goto L7;
        if (r10 > 57) goto L7;
    L14:
        return true;
    L7:
        if (97 > r10) goto L11;
        if (r10 <= 102) goto L14;
    L11:
        if (65 <= r10) goto L13;
    L15:
        return false;
    L13:
        if (r10 > 70) goto L15;
        goto L14
    }

    private static boolean isOctal(byte r10) {
        if (48 <= r10) goto L5;
    L7:
        return false;
    L5:
        if (r10 > 55) goto L7;
        return true;
    }

    public static void merge(Readable r10, Message.Builder r11) throws IOException {
        PARSER.merge(r10, r11);
    }

    public static int parseInt32(String r10) throws NumberFormatException {
        return (int) parseInteger(r10, true, false);
    }

    public static long parseInt64(String r10) throws NumberFormatException {
        return parseInteger(r10, true, true);
    }

    private static long parseInteger(String r10, boolean r11, boolean r12) throws NumberFormatException {
        int r13 = 0;
        if (r10.startsWith("-", 0) == false) goto L6;
        if (r11 == false) goto L8;
        r13 = 1;
        goto L6
    L8:
        throw new NumberFormatException("Number must be positive: " + r10);
    L6:
        int r14 = r13;
        if (r10.startsWith("0x", r13) == false) goto L13;
        r13 = r13 + 2;
        int r15 = 16;
    L16:
        String r16 = r10.substring(r13);
        if (r16.length() >= 16) goto L37;
        long r17 = Long.parseLong(r16, r15);
        if (r14 == 0) goto L21;
        r17 = -r17;
    L21:
        if (r12 == true) goto L64;
        if (r11 == false) goto L31;
        if (r17 > 2147483647L) goto L29;
        if (r17 < (-2147483648L)) goto L29;
        return r17;
    L29:
        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + r10);
    L31:
        if (r17 >= 4294967296L) goto L36;
        if (r17 < 0) goto L36;
        return r17;
    L36:
        throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + r10);
    L64:
        return r17;
    L37:
        BigInteger r18 = new BigInteger(r16, r15);
        if (r14 == 0) goto L40;
        r18 = r18.negate();
    L40:
        if (r12 == true) goto L52;
        if (r11 == false) goto L48;
        if (r18.bitLength() <= 31) goto L61;
        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + r10);
    L61:
        return r18.longValue();
    L48:
        if (r18.bitLength() <= 32) goto L61;
        throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + r10);
    L52:
        if (r11 == false) goto L59;
        if (r18.bitLength() <= 63) goto L61;
        throw new NumberFormatException("Number out of range for 64-bit signed integer: " + r10);
    L59:
        if (r18.bitLength() <= 64) goto L61;
        throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + r10);
    L13:
        if (r10.startsWith(AdReportParam.ClickPosType.SKIP, r13) == false) goto L15;
        r15 = 8;
        goto L16
    L15:
        r15 = 10;
        goto L16
    }

    public static int parseUInt32(String r10) throws NumberFormatException {
        return (int) parseInteger(r10, false, false);
    }

    public static long parseUInt64(String r10) throws NumberFormatException {
        return parseInteger(r10, false, true);
    }

    public static void print(MessageOrBuilder r10, Appendable r11) throws IOException {
        Printer.access$400(DEFAULT_PRINTER, r10, new TextGenerator(r11, null));
    }

    public static void printField(Descriptors.FieldDescriptor r10, Object r11, Appendable r12) throws IOException {
        Printer.access$600(DEFAULT_PRINTER, r10, r11, new TextGenerator(r12, null));
    }

    public static String printFieldToString(Descriptors.FieldDescriptor r10, Object r11) {
        StringBuilder r12 = new StringBuilder();     // Catch: IOException -> L4
        printField(r10, r11, r12);     // Catch: IOException -> L4
        return r12.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static void printFieldValue(Descriptors.FieldDescriptor r10, Object r11, Appendable r12) throws IOException {
        Printer.access$700(DEFAULT_PRINTER, r10, r11, new TextGenerator(r12, null));
    }

    public static String printToString(MessageOrBuilder r10) {
        StringBuilder r11 = new StringBuilder();     // Catch: IOException -> L4
        print(r10, r11);     // Catch: IOException -> L4
        return r11.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String printToUnicodeString(MessageOrBuilder r10) {
        StringBuilder r11 = new StringBuilder();     // Catch: IOException -> L4
        Printer.access$400(UNICODE_PRINTER, r10, new TextGenerator(r11, null));     // Catch: IOException -> L4
        return r11.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static void printUnicode(MessageOrBuilder r10, Appendable r11) throws IOException {
        Printer.access$400(UNICODE_PRINTER, r10, new TextGenerator(r11, null));
    }

    public static void printUnknownFieldValue(int r10, Object r11, Appendable r12) throws IOException {
        printUnknownFieldValue(r10, r11, new TextGenerator(r12, null));
    }

    public static String shortDebugString(MessageOrBuilder r10) {
        StringBuilder r11 = new StringBuilder();     // Catch: IOException -> L4
        Printer.access$400(SINGLE_LINE_PRINTER, r10, new TextGenerator(r11, null));     // Catch: IOException -> L4
        return r11.toString().trim();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static ByteString unescapeBytes(CharSequence r10) throws InvalidEscapeSequenceException {
        ByteString r11 = ByteString.copyFromUtf8(r10.toString());
        int r12 = r11.size();
        byte[] r13 = new byte[r12];
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r11.size()) goto L73;
        byte r16 = r11.byteAt(r14);
        if (r16 != 92) goto L71;
        int r17 = r14 + 1;
        if (r17 >= r11.size()) goto L70;
        byte r18 = r11.byteAt(r17);
        if (isOctal(r18) == false) goto L24;
        int r19 = digitValue(r18);
        int r20 = r14 + 2;
        if (r20 < r11.size()) goto L14;
    L16:
        r14 = r17 + 1;
        if (r14 < r11.size()) goto L19;
    L21:
        r14 = r17;
    L22:
        r13[r15] = (byte) r19;
        r15 = r15 + 1;
    L72:
        r14 = r14 + 1;
        goto L4
    L19:
        if (isOctal(r11.byteAt(r14)) == false) goto L21;
        r19 = (r19 * 8) + digitValue(r11.byteAt(r14));
        goto L22
    L14:
        if (isOctal(r11.byteAt(r20)) == false) goto L16;
        r19 = (r19 * 8) + digitValue(r11.byteAt(r20));
        r17 = r20;
        goto L16
    L24:
        if (r18 != 34) goto L26;
        int r21 = r15 + 1;
        r13[r15] = 34;
    L68:
        r15 = r21;
        r14 = r17;
        goto L72
    L26:
        if (r18 == 39) goto L66;
        if (r18 != 92) goto L29;
        r21 = r15 + 1;
        r13[r15] = 92;
        goto L68
    L29:
        if (r18 != 102) goto L31;
        r21 = r15 + 1;
        r13[r15] = Ascii.FF;
        goto L68
    L31:
        if (r18 != 110) goto L33;
        r21 = r15 + 1;
        r13[r15] = 10;
        goto L68
    L33:
        if (r18 != 114) goto L35;
        r21 = r15 + 1;
        r13[r15] = Ascii.CR;
        goto L68
    L35:
        if (r18 != 116) goto L37;
        r21 = r15 + 1;
        r13[r15] = 9;
        goto L68
    L37:
        if (r18 != 118) goto L39;
        r21 = r15 + 1;
        r13[r15] = Ascii.VT;
        goto L68
    L39:
        if (r18 != 120) goto L41;
        r17 = r14 + 2;
        if (r17 >= r11.size()) goto L59;
        if (isHex(r11.byteAt(r17)) == false) goto L59;
        int r22 = digitValue(r11.byteAt(r17));
        int r23 = r14 + 3;
        if (r23 < r11.size()) goto L55;
    L57:
        r21 = r15 + 1;
        r13[r15] = (byte) r22;
        goto L68
    L55:
        if (isHex(r11.byteAt(r23)) == false) goto L57;
        r22 = (r22 * 16) + digitValue(r11.byteAt(r23));
        r17 = r23;
    L59:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
    L41:
        if (r18 != 97) goto L43;
        r21 = r15 + 1;
        r13[r15] = 7;
        goto L68
    L43:
        if (r18 != 98) goto L46;
        r21 = r15 + 1;
        r13[r15] = 8;
        goto L68
    L46:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) r18) + '\'');
    L66:
        r21 = r15 + 1;
        r13[r15] = 39;
        goto L68
    L70:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
    L71:
        r13[r15] = r16;
        r15 = r15 + 1;
        goto L72
    L73:
        if (r12 != r15) goto L76;
        return ByteString.wrap(r13);
    L76:
        return ByteString.copyFrom(r13, 0, r15);
    }

    public static String unescapeText(String r10) throws InvalidEscapeSequenceException {
        return unescapeBytes(r10).toStringUtf8();
    }

    public static String unsignedToString(int r10) {
        if (r10 < 0) goto L6;
        return Integer.toString(r10);
    L6:
        return Long.toString(((long) r10) & 4294967295L);
    }

    public static String escapeBytes(byte[] r10) {
        return TextFormatEscaper.escapeBytes(r10);
    }

    public static void merge(CharSequence r10, Message.Builder r11) throws ParseException {
        PARSER.merge(r10, r11);
    }

    public static void print(UnknownFieldSet r10, Appendable r11) throws IOException {
        Printer.access$500(DEFAULT_PRINTER, r10, new TextGenerator(r11, null));
    }

    public static void printUnicode(UnknownFieldSet r10, Appendable r11) throws IOException {
        Printer.access$500(UNICODE_PRINTER, r10, new TextGenerator(r11, null));
    }

    private static void printUnknownFieldValue(int r10, Object r11, TextGenerator r12) throws IOException {
        int r13 = WireFormat.getTagWireType(r10);
        if (r13 != 0) goto L5;
        r12.print(unsignedToString(((Long) r11).longValue()));
        return;
    L5:
        if (r13 != 1) goto L7;
        r12.print(String.format(null, "0x%016x", new Object[]{(Long) r11}));
        return;
    L7:
        if (r13 != 2) goto L9;
        r12.print("\"");
        r12.print(escapeBytes((ByteString) r11));
        r12.print("\"");
        return;
    L9:
        if (r13 != 3) goto L11;
        Printer.access$500(DEFAULT_PRINTER, (UnknownFieldSet) r11, r12);
        return;
    L11:
        if (r13 != 5) goto L14;
        r12.print(String.format(null, "0x%08x", new Object[]{(Integer) r11}));
        return;
    L14:
        throw new IllegalArgumentException("Bad tag: " + r10);
    }

    public static void merge(Readable r10, ExtensionRegistry r11, Message.Builder r12) throws IOException {
        PARSER.merge(r10, r11, r12);
    }

    public static String unsignedToString(long r10) {
        if (r10 < 0) goto L7;
        return Long.toString(r10);
    L7:
        return BigInteger.valueOf(r10 & Long.MAX_VALUE).setBit(63).toString();
    }

    public static void merge(CharSequence r10, ExtensionRegistry r11, Message.Builder r12) throws ParseException {
        PARSER.merge(r10, r11, r12);
    }

    public static String printToString(UnknownFieldSet r10) {
        StringBuilder r11 = new StringBuilder();     // Catch: IOException -> L4
        print(r10, r11);     // Catch: IOException -> L4
        return r11.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String printToUnicodeString(UnknownFieldSet r10) {
        StringBuilder r11 = new StringBuilder();     // Catch: IOException -> L4
        Printer.access$500(UNICODE_PRINTER, r10, new TextGenerator(r11, null));     // Catch: IOException -> L4
        return r11.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String shortDebugString(Descriptors.FieldDescriptor r10, Object r11) {
        StringBuilder r12 = new StringBuilder();     // Catch: IOException -> L4
        Printer.access$600(SINGLE_LINE_PRINTER, r10, r11, new TextGenerator(r12, null));     // Catch: IOException -> L4
        return r12.toString().trim();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String shortDebugString(UnknownFieldSet r10) {
        StringBuilder r11 = new StringBuilder();     // Catch: IOException -> L4
        Printer.access$500(SINGLE_LINE_PRINTER, r10, new TextGenerator(r11, null));     // Catch: IOException -> L4
        return r11.toString().trim();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }
}
